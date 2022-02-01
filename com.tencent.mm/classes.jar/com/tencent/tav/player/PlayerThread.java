package com.tencent.tav.player;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import androidx.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.Utils;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.core.CGMathFunctions;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.report.PreviewReportSession;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

public class PlayerThread
  implements Handler.Callback
{
  static final int ACTION_FINISH = -1;
  static final int ACTION_GET_TAV_EXTRA_INFO = 25;
  static final int ACTION_PAUSE = 3;
  static final int ACTION_PLAY = 2;
  static final int ACTION_PREPARE = 1;
  static final int ACTION_QUIT = 850;
  static final int ACTION_READ_SAMPLE = 12;
  static final int ACTION_READ_SNAP_SHOOT_BITMAP = 24;
  static final int ACTION_REFRESH_SURFACE = 26;
  static final int ACTION_RELEASE = 6;
  static final int ACTION_SEEK = 5;
  static final int ACTION_SEEK_PRE_SAMPLE = 9;
  static final int ACTION_SET_VOLUME = 7;
  static final int ACTION_STOP = 4;
  static final int ACTION_UPDATE_ALLPROPERTIES = 20;
  static final int ACTION_UPDATE_AUDIOCLIP_PROPERTIES = 22;
  static final int ACTION_UPDATE_AUDIOVOLUME_PROPERTIES = 23;
  static final int ACTION_UPDATE_COMPOSITION = 11;
  static final int ACTION_UPDATE_PROPERTIES = 10;
  static final int ACTION_UPDATE_SIZE = 21;
  static final int STATUS_FINISH = 3;
  static final int STATUS_INIT_CODEC = 2;
  static final int STATUS_NONE = 1;
  public static final String TAG = "PlayerThreadMain";
  private static final long UNIT_TIME = 1000L;
  public static h<String> map;
  private AudioCompositionDecoderTrack aDecoderTrack;
  private long decoderConsumerTimeUs;
  private Filter filter;
  private CMTime frameDuration;
  private CGRect glViewportRect;
  private volatile long lastSyncMessageId;
  private VideoComposition.RenderLayoutMode layoutMode;
  private PlayerThreadAudio mAudioThread;
  private Surface mDisplayTarget;
  private volatile boolean mEnableScheduleNext;
  private boolean mLooper;
  private Handler mMainHandler;
  private boolean mPause;
  private Handler mPlayHandler;
  private CMTimeRange mPlayRange;
  private Player mPlayer;
  private PlayerItem mPlayerItem;
  private CMTime mPosition;
  private long mStartTime;
  private int mStatus;
  private HandlerThread mThread;
  private OnGetTavExtraListener onGetTavExtraListener;
  private OnReadSnapShootListener onReadSnapShootListener;
  private float rate;
  private RenderContext renderContext;
  private RenderContextParams renderContextParams;
  private CGSize renderSize;
  private PreviewReportSession reportSession;
  private long startTimeUsMark;
  private CGSize surfaceSize;
  private IDecoderTrack vDecoderTrack;
  
  static
  {
    AppMethodBeat.i(216322);
    h localh = new h((byte)0);
    map = localh;
    localh.put(1, "初始化");
    map.put(2, "播放");
    map.put(3, "暂停");
    map.put(4, "停止");
    map.put(5, "拖动");
    map.put(12, "读取下一帧");
    map.put(6, "结束线程");
    map.put(26, "刷新渲染");
    AppMethodBeat.o(216322);
  }
  
  PlayerThread(IDecoderTrack paramIDecoderTrack, AudioCompositionDecoderTrack paramAudioCompositionDecoderTrack, CGSize paramCGSize, Surface paramSurface, Handler paramHandler, Player paramPlayer)
  {
    AppMethodBeat.i(215954);
    this.lastSyncMessageId = 0L;
    this.decoderConsumerTimeUs = 0L;
    this.mPosition = CMTime.CMTimeZero;
    this.frameDuration = new CMTime(1L, 30);
    this.mStatus = 1;
    this.rate = 1.0F;
    this.mEnableScheduleNext = false;
    this.startTimeUsMark = getCurrentUsTime();
    this.vDecoderTrack = paramIDecoderTrack;
    this.aDecoderTrack = paramAudioCompositionDecoderTrack;
    this.mDisplayTarget = paramSurface;
    this.mMainHandler = paramHandler;
    this.renderSize = paramCGSize;
    if (paramIDecoderTrack != null) {
      this.frameDuration = paramIDecoderTrack.getFrameDuration();
    }
    this.mPlayer = paramPlayer;
    this.mPlayerItem = paramPlayer.getCurrentItem();
    initThread();
    AppMethodBeat.o(215954);
  }
  
  private void applyViewport()
  {
    AppMethodBeat.i(216158);
    if (this.renderContext == null)
    {
      AppMethodBeat.o(216158);
      return;
    }
    if ((this.glViewportRect == null) || (this.glViewportRect.origin == null) || (this.glViewportRect.size == null))
    {
      AppMethodBeat.o(216158);
      return;
    }
    this.renderContext.updateViewport(this.glViewportRect);
    AppMethodBeat.o(216158);
  }
  
  private String catLog(int paramInt)
  {
    AppMethodBeat.i(216305);
    String str = (String)map.d(paramInt, null);
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(216305);
      return String.valueOf(paramInt);
    }
    AppMethodBeat.o(216305);
    return str;
  }
  
  private void checkCopyPixelBuffer(CMTime paramCMTime)
  {
    AppMethodBeat.i(216167);
    if (this.onReadSnapShootListener != null)
    {
      Object localObject = ByteBuffer.allocateDirect(this.renderContext.width() * this.renderContext.height() * 4);
      ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
      ((ByteBuffer)localObject).rewind();
      GLES20.glReadPixels(0, 0, this.renderContext.width(), this.renderContext.height(), 6408, 5121, (Buffer)localObject);
      Bitmap localBitmap = Bitmap.createBitmap(this.renderContext.width(), this.renderContext.height(), Bitmap.Config.ARGB_4444);
      ((ByteBuffer)localObject).rewind();
      localBitmap.copyPixelsFromBuffer((Buffer)localObject);
      localObject = Utils.flipYBitmap(localBitmap);
      this.onReadSnapShootListener.onSuccess((Bitmap)localObject, paramCMTime);
      this.onReadSnapShootListener = null;
    }
    AppMethodBeat.o(216167);
  }
  
  private long getCurrentUsTime()
  {
    AppMethodBeat.i(216131);
    long l = System.nanoTime() / 1000L;
    AppMethodBeat.o(216131);
    return l;
  }
  
  private CMTime getLastSeekPosAndRemoveOther()
  {
    AppMethodBeat.i(216049);
    Object localObject2 = CMTime.CMTimeInvalid;
    Object localObject1;
    Object localObject3;
    ArrayList localArrayList;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject1 = this.mPlayHandler.getLooper().getQueue();
      localObject3 = MessageQueue.class.getDeclaredField("mMessages");
      ((Field)localObject3).setAccessible(true);
      localObject1 = (Message)((Field)localObject3).get(localObject1);
      localArrayList = new ArrayList();
      label62:
      if (localObject1 == null) {
        break label177;
      }
      if ((((Message)localObject1).what != 5) || (!(((Message)localObject1).obj instanceof PlayerMessage))) {
        break label164;
      }
      localObject3 = (CMTime)((PlayerMessage)((Message)localObject1).obj).bizMsg1;
      localArrayList.add(localObject1);
    }
    label164:
    do
    {
      localObject2 = Message.class.getDeclaredField("next");
      ((Field)localObject2).setAccessible(true);
      localObject1 = (Message)((Field)localObject2).get(localObject1);
      localObject2 = localObject3;
      break label62;
      localObject1 = Handler.class.getDeclaredField("mQueue");
      ((Field)localObject1).setAccessible(true);
      localObject1 = (MessageQueue)((Field)localObject1).get(this.mPlayHandler);
      break;
      localObject3 = localObject2;
    } while (((Message)localObject1).getTarget() != this.mPlayHandler);
    label177:
    if (localObject2 != CMTime.CMTimeInvalid)
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Message)((Iterator)localObject1).next();
        this.mPlayHandler.removeMessages(((Message)localObject3).what, ((Message)localObject3).obj);
      }
    }
    AppMethodBeat.o(216049);
    return localObject2;
  }
  
  private long getWaitTime(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(216213);
    long l1 = this.frameDuration.getTimeUs();
    long l2 = paramCMTime.getTimeUs();
    if ((paramBoolean1) || (paramBoolean2))
    {
      Logger.d("PlayerThreadMain", "getWaitTime - 0 " + paramBoolean1 + "  |  " + paramBoolean2);
      AppMethodBeat.o(216213);
      return 0L;
    }
    long l3 = ((float)l1 / Math.abs(this.rate));
    long l4 = l3 - this.decoderConsumerTimeUs;
    Logger.v("PlayerThreadMain", "getWaitTime--position-->" + l2 + " rate = " + this.rate + "--decoderConsumerTimeUs-->" + this.decoderConsumerTimeUs + "--frameDurationMs-->" + l1 + "--realTime-->" + l3 + "--nextFrameTime-->" + (l2 + l3) + "--sleepTime-->" + l4 + "  mStartTime = " + this.mStartTime);
    AppMethodBeat.o(216213);
    return l4;
  }
  
  private void initDecoderTrack(Object paramObject)
  {
    AppMethodBeat.i(215969);
    if ((this.renderContext == null) && (this.mDisplayTarget != null)) {
      if ((this.renderContextParams == null) || (!(this.renderContextParams.getParam("share_context") instanceof EGLContext))) {
        break label452;
      }
    }
    label443:
    label452:
    Object localObject2;
    for (Object localObject1 = (EGLContext)this.renderContextParams.getParam("share_context");; localObject2 = null)
    {
      if (localObject1 != null)
      {
        this.renderContext = new RenderContext((int)this.surfaceSize.width, (int)this.surfaceSize.height, this.mDisplayTarget, (EGLContext)localObject1);
        this.renderContext.setParams(this.renderContextParams);
        localObject1 = this.mPlayerItem.getVideoComposition();
        if (localObject1 != null)
        {
          this.renderSize = ((VideoComposition)localObject1).getRenderSize();
          this.layoutMode = ((VideoComposition)localObject1).getRenderLayoutMode();
        }
        if ((this.renderContext != null) && (this.renderSize != null))
        {
          this.renderContext.setHeight((int)this.renderSize.height);
          this.renderContext.setWidth((int)this.renderSize.width);
        }
        initViewport();
        updateProgressPreNextAction(this.mPosition);
        if (this.vDecoderTrack == null) {
          break label443;
        }
      }
      for (;;)
      {
        try
        {
          this.vDecoderTrack.setFrameRate((int)(this.frameDuration.timeScale / this.frameDuration.getValue()));
          this.vDecoderTrack.start(this.renderContext);
          if (!this.mLooper)
          {
            if (this.mPosition == CMTime.CMTimeInvalid) {
              this.mPosition = this.vDecoderTrack.getDuration();
            }
            this.vDecoderTrack.seekTo(this.mPosition, false, true);
            readSample(-1);
          }
          onCompositionUpdate(paramObject, true);
          Logger.v("PlayerThreadMain", "prepare: init codec-->" + Thread.currentThread().getName() + "--vDecoderTrack-->" + this.vDecoderTrack);
          if (this.aDecoderTrack != null)
          {
            this.aDecoderTrack.start();
            this.aDecoderTrack.seekTo(this.mPosition, false, false);
          }
          updateStatus(2);
          synAudioComposition();
          notifyProgressChange();
          AppMethodBeat.o(215969);
          return;
        }
        catch (Exception localException)
        {
          Logger.v("PlayerThreadMain", "init composition cause exception: ".concat(String.valueOf(localException)));
          this.vDecoderTrack.release();
          this.vDecoderTrack = null;
        }
        this.renderContext = new RenderContext((int)this.surfaceSize.width, (int)this.surfaceSize.height, this.mDisplayTarget);
        break;
        onCompositionUpdate(paramObject, false);
      }
    }
  }
  
  private void initThread()
  {
    AppMethodBeat.i(215958);
    this.mThread = new HandlerThread("PlayerVideoThread");
    this.mThread.start();
    this.mPlayHandler = new Handler(this.mThread.getLooper(), this);
    this.mAudioThread = new PlayerThreadAudio(this.aDecoderTrack, this.mMainHandler, getPlayHandler());
    AppMethodBeat.o(215958);
  }
  
  private void initViewport()
  {
    AppMethodBeat.i(215974);
    CGSize localCGSize;
    if (this.renderSize != null)
    {
      localCGSize = this.renderSize;
      if (this.layoutMode != null) {
        break label71;
      }
      this.glViewportRect = CGMathFunctions.initGLViewportDefault(this.surfaceSize, localCGSize);
    }
    for (;;)
    {
      applyViewport();
      this.mMainHandler.obtainMessage(3, this.glViewportRect).sendToTarget();
      AppMethodBeat.o(215974);
      return;
      localCGSize = this.surfaceSize;
      break;
      label71:
      initViewportByLayoutMode(localCGSize);
    }
  }
  
  private void initViewportByLayoutMode(CGSize paramCGSize)
  {
    AppMethodBeat.i(215979);
    switch (2.$SwitchMap$com$tencent$tav$core$composition$VideoComposition$RenderLayoutMode[this.layoutMode.ordinal()])
    {
    default: 
      this.glViewportRect = CGMathFunctions.initGLViewportDefault(this.surfaceSize, paramCGSize);
      AppMethodBeat.o(215979);
      return;
    case 1: 
      this.glViewportRect = CGMathFunctions.initGLViewportFit(this.surfaceSize, paramCGSize);
      AppMethodBeat.o(215979);
      return;
    }
    this.glViewportRect = CGMathFunctions.initGLViewportFill(this.surfaceSize, paramCGSize);
    AppMethodBeat.o(215979);
  }
  
  private void isNeedEnsureLooper(int paramInt)
  {
    if (paramInt == 2) {
      this.mLooper = true;
    }
  }
  
  private boolean needNotifyProgressChange()
  {
    AppMethodBeat.i(216036);
    try
    {
      if (Build.VERSION.SDK_INT >= 23) {}
      for (Object localObject = this.mPlayHandler.getLooper().getQueue();; localObject = (MessageQueue)((Field)localObject).get(this.mPlayHandler))
      {
        Field localField = MessageQueue.class.getDeclaredField("mMessages");
        localField.setAccessible(true);
        localObject = (Message)localField.get(localObject);
        if (localObject != null)
        {
          if ((((Message)localObject).what == 3) || (((Message)localObject).what == 4) || (((Message)localObject).what == 1) || (((Message)localObject).what == 850)) {
            break;
          }
          int i = ((Message)localObject).what;
          if (i == 6) {
            break;
          }
        }
        AppMethodBeat.o(216036);
        return true;
        localObject = Handler.class.getDeclaredField("mQueue");
        ((Field)localObject).setAccessible(true);
      }
      return false;
    }
    catch (Exception localException)
    {
      Logger.e("PlayerThreadMain", "needNotifyProgressChange", localException);
      AppMethodBeat.o(216036);
    }
  }
  
  private void notifyProgressChange()
  {
    AppMethodBeat.i(216242);
    if (needNotifyProgressChange()) {
      this.mMainHandler.obtainMessage(2, this.mPosition).sendToTarget();
    }
    AppMethodBeat.o(216242);
  }
  
  private void notifyStatus(IPlayer.PlayerStatus paramPlayerStatus, String paramString)
  {
    AppMethodBeat.i(216233);
    this.mMainHandler.obtainMessage(1, new PlayerStatusMsg(paramPlayerStatus, paramString)).sendToTarget();
    AppMethodBeat.o(216233);
  }
  
  private void onCompositionUpdate(Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(215988);
    if ((paramObject instanceof OnCompositionUpdateListener)) {
      ((OnCompositionUpdateListener)paramObject).onUpdated(this.mPlayer, paramBoolean);
    }
    AppMethodBeat.o(215988);
  }
  
  private void pause()
  {
    AppMethodBeat.i(216077);
    this.mLooper = false;
    this.mPause = true;
    enableScheduleNext(false);
    removePendingMessage(new int[] { 12 });
    notifyStatus(IPlayer.PlayerStatus.PAUSED, "");
    AppMethodBeat.o(216077);
  }
  
  private void play()
  {
    AppMethodBeat.i(216087);
    if (this.mStatus == 1)
    {
      if ((this.vDecoderTrack != null) || (this.aDecoderTrack != null))
      {
        sendMessage(1, "not can play");
        sendMessage(2, "not can play");
      }
      AppMethodBeat.o(216087);
      return;
    }
    if (this.mStatus == 3) {
      if (this.vDecoderTrack != null)
      {
        if (!this.mPosition.smallThan(this.vDecoderTrack.getDuration())) {
          break label183;
        }
        this.vDecoderTrack.seekTo(this.mPosition, false, true);
      }
    }
    for (;;)
    {
      updateStatus(2);
      removePendingMessage(new int[] { 12 });
      this.mLooper = true;
      enableScheduleNext(true);
      sendMessage(12, Integer.valueOf(2), "play");
      notifyStatus(IPlayer.PlayerStatus.PLAYING, "");
      Logger.v("PlayerThreadMain", "playm() called start play-->" + this.mStatus);
      AppMethodBeat.o(216087);
      return;
      label183:
      this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
    }
  }
  
  private void playerFinish()
  {
    AppMethodBeat.i(216195);
    Logger.d("PlayerThreadMain", "playFinish");
    if (this.vDecoderTrack != null) {}
    for (CMTime localCMTime = this.vDecoderTrack.getDuration();; localCMTime = this.mPlayer.duration())
    {
      updateProgressPreNextAction(localCMTime);
      notifyProgressChange();
      updateStatus(3);
      syncAudioOtherMsg(-1, null);
      if (this.vDecoderTrack != null) {
        this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
      }
      this.mStartTime = 0L;
      this.mLooper = false;
      notifyStatus(IPlayer.PlayerStatus.FINISHED, "");
      AppMethodBeat.o(216195);
      return;
    }
  }
  
  private void prepare(Object paramObject)
  {
    AppMethodBeat.i(216250);
    if (this.mStatus == 1)
    {
      initDecoderTrack(paramObject);
      enableScheduleNext(true);
      AppMethodBeat.o(216250);
      return;
    }
    sendMessage(4, Boolean.FALSE, "prepare");
    sendMessage(1, paramObject, "prepare");
    AppMethodBeat.o(216250);
  }
  
  private void readSample(int paramInt)
  {
    AppMethodBeat.i(216105);
    int i;
    if (this.mAudioThread.lastSyncMessgeId == this.lastSyncMessageId)
    {
      i = 1;
      if (i == 0) {
        break label53;
      }
    }
    label53:
    for (CMTime localCMTime = this.mAudioThread.getCurrentPlayingState();; localCMTime = CMTime.CMTimeInvalid)
    {
      readSample(paramInt, localCMTime);
      AppMethodBeat.o(216105);
      return;
      i = 0;
      break;
    }
  }
  
  private void readSample(int paramInt, CMTime paramCMTime)
  {
    AppMethodBeat.i(216125);
    if (this.vDecoderTrack == null)
    {
      syncAudioProgress();
      AppMethodBeat.o(216125);
      return;
    }
    if (this.reportSession == null) {
      this.reportSession = new PreviewReportSession();
    }
    long l1 = getCurrentUsTime() - this.startTimeUsMark;
    try
    {
      l2 = this.frameDuration.divide(this.rate).getTimeUs();
      if (l2 - l1 > 0L) {
        Thread.sleep((l2 - l1) / 1000L);
      }
    }
    finally
    {
      long l2;
      CMSampleState localCMSampleState;
      for (;;)
      {
        Logger.e("PlayerThreadMain", "readSample", localThrowable);
      }
      localObject = localCMSampleState;
      try
      {
        this.renderContext.makeCurrent();
        localObject = localCMSampleState;
        l1 = System.nanoTime();
        localObject = localCMSampleState;
        paramCMTime = readSampleBuffer(paramInt, paramCMTime, localCMTime);
        localObject = localCMSampleState;
        l2 = System.nanoTime();
        if (paramInt != 5)
        {
          localObject = localCMSampleState;
          if (!this.mEnableScheduleNext)
          {
            localObject = localCMSampleState;
            Logger.i("PlayerThreadMain", "disable schedule next, ignore this render");
            AppMethodBeat.o(216125);
            return;
          }
        }
        localObject = localCMSampleState;
        long l3 = System.nanoTime();
        localObject = localCMSampleState;
        renderSampleBuffer(paramCMTime);
        localObject = localCMSampleState;
        this.reportSession.tickPreview(l2 - l1, System.nanoTime() - l3);
        localObject = localCMSampleState;
        paramCMTime = paramCMTime.getState();
        localObject = paramCMTime;
        this.vDecoderTrack.asyncReadNextSample(paramCMTime.getTime().add(new CMTime(1L, paramCMTime.getTime().timeScale)));
        localObject = paramCMTime;
        this.decoderConsumerTimeUs = (getCurrentUsTime() - this.startTimeUsMark);
        localObject = paramCMTime;
      }
      catch (Exception paramCMTime)
      {
        do
        {
          Logger.e("PlayerThreadMain", "readSample", paramCMTime);
        } while (!(paramCMTime instanceof IllegalStateException));
        notifyStatus(IPlayer.PlayerStatus.ERROR, "解码异常");
        AppMethodBeat.o(216125);
        return;
      }
      Logger.v("PlayerThreadMain", "readSample() called with: messageId = [" + paramInt + "]--currentSampleState-->" + localObject + "--looper-->" + this.mLooper + " consumer = " + (System.currentTimeMillis() - this.startTimeUsMark));
      if (!((CMSampleState)localObject).stateMatchingTo(new long[] { -1L, -3L })) {
        break label534;
      }
      Logger.v("PlayerThreadMain", "readSample() called with: finish");
      playerFinish();
      AppMethodBeat.o(216125);
      return;
      if (5 != paramInt) {
        break label701;
      }
    }
    this.startTimeUsMark = getCurrentUsTime();
    isNeedEnsureLooper(paramInt);
    localCMSampleState = new CMSampleState();
    CMTime localCMTime = this.vDecoderTrack.getCurrentSampleTime();
    Logger.v("PlayerThreadMain", "readSample[" + paramInt + "] lastPosition = " + localCMTime + " syncPlayingTime = " + paramCMTime);
    if (paramInt == 2) {
      syncAudioOtherMsg(2, localCMTime);
    }
    if ((paramInt != 5) && (!this.mEnableScheduleNext))
    {
      Logger.i("PlayerThreadMain", "disable schedule next, ignore this readSample");
      AppMethodBeat.o(216125);
      return;
    }
    Object localObject;
    label534:
    boolean bool1 = true;
    if (((CMSampleState)localObject).getStateCode() >= 0L)
    {
      this.mPosition = ((CMSampleState)localObject).getTime();
      paramCMTime = (CMTime)localObject;
      if (!bool1)
      {
        paramCMTime = (CMTime)localObject;
        if (!this.mPlayHandler.hasMessages(5)) {
          notifyProgressChange();
        }
      }
    }
    for (paramCMTime = (CMTime)localObject;; paramCMTime = new CMSampleState(localCMTime))
    {
      if (this.mLooper)
      {
        boolean bool2 = this.mPause;
        this.decoderConsumerTimeUs = (getCurrentUsTime() - this.startTimeUsMark + 5000L);
        scheduleNextWork(getWaitTime(paramCMTime.getTime(), bool1, bool2));
        this.mPause = false;
      }
      Logger.v("PlayerThreadMain", "readSample end [" + paramInt + "]--looper-->" + this.mLooper + " consumer = " + (getCurrentUsTime() - this.startTimeUsMark));
      AppMethodBeat.o(216125);
      return;
      label701:
      bool1 = false;
      break;
      if (((CMSampleState)localObject).stateMatchingTo(new long[] { -100L })) {
        this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
      }
    }
  }
  
  private CMSampleBuffer readSampleBuffer(int paramInt, CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(216140);
    if (paramInt == 5)
    {
      paramCMTime1 = this.vDecoderTrack.seekTo(paramCMTime1, true, true);
      AppMethodBeat.o(216140);
      return paramCMTime1;
    }
    CMTime localCMTime = this.frameDuration.multi(this.rate);
    if (paramCMTime2.smallThan(paramCMTime1.sub(localCMTime.multi(3.0F))))
    {
      Logger.v("PlayerThreadMain", "readSampleBuffer: sampleTime = // " + paramCMTime2.add(this.frameDuration));
      paramCMTime1 = this.vDecoderTrack.readSample(paramCMTime1.divide(localCMTime).multi(localCMTime));
      AppMethodBeat.o(216140);
      return paramCMTime1;
    }
    if ((paramCMTime2.bigThan(paramCMTime1.add(localCMTime))) && (paramCMTime1.bigThan(CMTime.CMTimeZero)) && (this.mAudioThread.isFinished()))
    {
      syncAudioOtherMsg(2, paramCMTime2);
      Logger.v("PlayerThreadMain", "readSampleBuffer: sampleTime = /// " + paramCMTime2.add(localCMTime));
      paramCMTime1 = this.vDecoderTrack.readSample(localCMTime);
      AppMethodBeat.o(216140);
      return paramCMTime1;
    }
    Logger.v("PlayerThreadMain", "readSampleBuffer: sampleTime = " + paramCMTime2.add(localCMTime));
    paramCMTime1 = this.vDecoderTrack.readSample(paramCMTime2.add(localCMTime));
    AppMethodBeat.o(216140);
    return paramCMTime1;
  }
  
  private void refreshSurface(Callback paramCallback)
  {
    AppMethodBeat.i(216027);
    if (this.mStatus == 1)
    {
      AppMethodBeat.o(216027);
      return;
    }
    if (this.vDecoderTrack != null)
    {
      removePendingMessage(new int[] { 12, 26 });
      renderSampleBuffer(this.vDecoderTrack.readSample(this.vDecoderTrack.getCurrentSampleTime()));
    }
    if (paramCallback != null) {
      paramCallback.call();
    }
    AppMethodBeat.o(216027);
  }
  
  private void release(Message paramMessage)
  {
    AppMethodBeat.i(216014);
    Logger.d("PlayerThreadMain", "release player - ".concat(String.valueOf(this)));
    this.renderContext.makeCurrent();
    if ((paramMessage.obj instanceof PlayerMessage))
    {
      Object localObject = ((PlayerMessage)paramMessage.obj).bizMsg1;
      if ((localObject instanceof Runnable)) {
        ((Runnable)localObject).run();
      }
    }
    removePendingMessage(new int[0]);
    releaseAudioThread(paramMessage.what, paramMessage.obj);
    updateStatus(1);
    if (this.reportSession != null)
    {
      this.reportSession.flush();
      this.reportSession = null;
    }
    AppMethodBeat.o(216014);
  }
  
  private void releaseAudioThread(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(216277);
    if (paramInt == 6)
    {
      this.lastSyncMessageId = System.currentTimeMillis();
      Logger.d("PlayerThreadMain", "releaseAudioThread SyncMessageId = " + this.lastSyncMessageId + "  action = " + paramInt + "  obj =  " + paramObject);
      this.mAudioThread.sendMessage(paramInt, paramObject, "syncAudioStatus", this.lastSyncMessageId);
    }
    AppMethodBeat.o(216277);
  }
  
  private void releaseComposition()
  {
    AppMethodBeat.i(216298);
    if (this.vDecoderTrack == null)
    {
      AppMethodBeat.o(216298);
      return;
    }
    if (this.mPlayerItem.getCustomVideoCompositor() != null) {
      this.mPlayerItem.getCustomVideoCompositor().release();
    }
    this.vDecoderTrack.release();
    this.aDecoderTrack.release();
    AppMethodBeat.o(216298);
  }
  
  private void removePendingMessage(int... arg1)
  {
    AppMethodBeat.i(216097);
    StringBuilder localStringBuilder = new StringBuilder("handleMessage() called with: removeInt = [");
    Object localObject1;
    if (???.length == 0) {
      localObject1 = "null";
    }
    for (;;)
    {
      Logger.v("PlayerThreadMain", localObject1 + "]");
      if (???.length == 0) {
        synchronized (this.mPlayHandler)
        {
          if (!this.mPlayHandler.hasMessages(850))
          {
            this.mPlayHandler.removeCallbacksAndMessages(null);
            AppMethodBeat.o(216097);
            return;
            localObject1 = Integer.valueOf(???[0]);
          }
          else
          {
            this.mPlayHandler.removeCallbacksAndMessages(null);
            this.mPlayHandler.sendEmptyMessage(850);
          }
        }
      }
    }
    int j = ???.length;
    int i = 0;
    while (i < j)
    {
      int k = ???[i];
      this.mPlayHandler.removeMessages(k);
      i += 1;
    }
    AppMethodBeat.o(216097);
  }
  
  private void renderSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(216149);
    Logger.v("PlayerThreadMain", "renderSampleBuffer() called with: sampleBuffer = [" + paramCMSampleBuffer + "]");
    if (paramCMSampleBuffer.getTextureInfo() != null)
    {
      if (this.filter == null)
      {
        this.filter = new Filter();
        this.filter.setRendererWidth(this.renderContext.width());
        this.filter.setRendererHeight(this.renderContext.height());
      }
      this.renderContext.makeCurrent();
      TextureInfo localTextureInfo = paramCMSampleBuffer.getTextureInfo();
      if (this.onGetTavExtraListener != null)
      {
        this.onGetTavExtraListener.getTextureInfo(localTextureInfo);
        AppMethodBeat.o(216149);
        return;
      }
      applyViewport();
      this.filter.setBgColor(this.mPlayer.getBgColor());
      this.filter.applyFilter(localTextureInfo, null, localTextureInfo.getTextureMatrix());
      checkCopyPixelBuffer(paramCMSampleBuffer.getTime());
      this.renderContext.setPresentationTime(paramCMSampleBuffer.getTime().getTimeUs());
      this.renderContext.swapBuffers();
    }
    AppMethodBeat.o(216149);
  }
  
  private void scheduleNextWork(long paramLong)
  {
    AppMethodBeat.i(216224);
    if (!this.mEnableScheduleNext)
    {
      Logger.i("PlayerThreadMain", "disable scheduleNextWork ignore");
      AppMethodBeat.o(216224);
      return;
    }
    paramLong /= 1000L;
    if (paramLong > 0L)
    {
      Logger.v("scheduleNextWork", "waitTime".concat(String.valueOf(paramLong)));
      sendMessageDelay(12, paramLong, "schedule next");
      AppMethodBeat.o(216224);
      return;
    }
    sendMessage(12, "schedule next");
    AppMethodBeat.o(216224);
  }
  
  private void seek(CMTime paramCMTime)
  {
    AppMethodBeat.i(216020);
    if (this.mStatus == 1)
    {
      AppMethodBeat.o(216020);
      return;
    }
    Object localObject = CMTime.CMTimeInvalid;
    try
    {
      CMTime localCMTime = getLastSeekPosAndRemoveOther();
      localObject = localCMTime;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("PlayerThreadMain", "getLastSeekPosAndRemoveOther", localException);
      }
      syncAudioOtherMsg(5, localObject);
      AppMethodBeat.o(216020);
      return;
    }
    if (((CMTime)localObject).getValue() > -1L) {}
    for (;;)
    {
      if (this.vDecoderTrack != null)
      {
        removePendingMessage(new int[] { 12 });
        this.mPosition = ((CMTime)localObject);
        notifyProgressChange();
        syncAudioOtherMsg(3, localObject);
        syncAudioOtherMsg(5, localObject);
        readSample(5, (CMTime)localObject);
        this.mPlayHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(215899);
            if (PlayerThread.this.mLooper) {
              PlayerThread.access$100(PlayerThread.this, 2, null);
            }
            AppMethodBeat.o(215899);
          }
        }, 10L);
        AppMethodBeat.o(216020);
        return;
      }
      localObject = paramCMTime;
    }
  }
  
  private void seekPreSample()
  {
    AppMethodBeat.i(216181);
    CMTime localCMTime = this.vDecoderTrack.getCurrentSampleTime();
    if (localCMTime != CMTime.CMTimeInvalid) {
      seek(localCMTime);
    }
    AppMethodBeat.o(216181);
  }
  
  private void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(216060);
    releaseComposition();
    if (this.filter != null)
    {
      this.filter.release();
      this.filter = null;
    }
    this.mStartTime = 0L;
    enableScheduleNext(false);
    updateStatus(1);
    if (paramBoolean)
    {
      notifyStatus(IPlayer.PlayerStatus.STOPPED, "");
      removePendingMessage(new int[0]);
      this.mLooper = false;
    }
    AppMethodBeat.o(216060);
  }
  
  private void synAudioComposition()
  {
    AppMethodBeat.i(216287);
    if (this.aDecoderTrack != null)
    {
      this.lastSyncMessageId = System.currentTimeMillis();
      Logger.d("PlayerThreadMain", "synAudioComposition SyncMessageId = " + this.lastSyncMessageId);
      this.mAudioThread.sendMessage(1, null, "syncAudioStatus composition", this.lastSyncMessageId);
    }
    AppMethodBeat.o(216287);
  }
  
  private void syncAudioOtherMsg(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(216270);
    if ((paramInt == 3) || (paramInt == 2) || (paramInt == 4) || (paramInt == 6) || (paramInt == 7) || (paramInt == -1) || (paramInt == 5))
    {
      this.lastSyncMessageId = System.currentTimeMillis();
      Logger.d("PlayerThreadMain", "syncAudioOtherMsg SyncMessageId = " + this.lastSyncMessageId + "  action = " + paramInt + "  obj = " + paramObject);
      this.mAudioThread.sendMessage(paramInt, paramObject, "syncAudioStatus", this.lastSyncMessageId);
    }
    AppMethodBeat.o(216270);
  }
  
  private void syncAudioProgress()
  {
    AppMethodBeat.i(216177);
    if (this.aDecoderTrack != null)
    {
      if (!this.mPosition.equalsTo(this.aDecoderTrack.getCurrentSampleTime()))
      {
        this.mPosition = this.aDecoderTrack.getCurrentSampleTime();
        notifyProgressChange();
      }
      if (this.mAudioThread.isFinished())
      {
        Logger.v("PlayerThreadMain", "processFrame() called with: finish");
        playerFinish();
        AppMethodBeat.o(216177);
        return;
      }
      if (this.mLooper)
      {
        scheduleNextWork(30L);
        this.mPause = false;
      }
    }
    AppMethodBeat.o(216177);
  }
  
  private void udpateAudioVolumeProperties() {}
  
  private void updateAllProperties() {}
  
  private void updateAudioClipsProperties()
  {
    AppMethodBeat.i(216002);
    if (this.aDecoderTrack != null) {
      this.aDecoderTrack.release();
    }
    this.aDecoderTrack = this.mPlayerItem.initAudioCompositionDecoderTrack();
    this.aDecoderTrack.start();
    this.mAudioThread.update(this.aDecoderTrack);
    if (this.mLooper) {
      syncAudioOtherMsg(2, this.mPosition);
    }
    AppMethodBeat.o(216002);
  }
  
  private void updateComposition(Object paramObject)
  {
    AppMethodBeat.i(216072);
    if ((paramObject instanceof PlayerItem))
    {
      paramObject = (PlayerItem)paramObject;
      this.vDecoderTrack = paramObject.getRealDecoderTrack();
      this.aDecoderTrack = paramObject.getAudioCompositionDecoderTrack();
      this.mPlayerItem = paramObject;
    }
    if (this.vDecoderTrack != null) {
      this.frameDuration = this.vDecoderTrack.getFrameDuration();
    }
    this.mAudioThread.update(this.aDecoderTrack);
    AppMethodBeat.o(216072);
  }
  
  private void updateProgressPreNextAction(CMTime paramCMTime)
  {
    this.mPosition = paramCMTime;
  }
  
  private void updateProperties() {}
  
  private void updateStatus(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  void bindSurface(IDecoderTrack paramIDecoderTrack, PlayerLayer paramPlayerLayer)
  {
    AppMethodBeat.i(216357);
    this.mDisplayTarget = paramPlayerLayer.surface;
    this.vDecoderTrack = paramIDecoderTrack;
    this.surfaceSize = new CGSize(paramPlayerLayer.surfaceWidth, paramPlayerLayer.surfaceHeight);
    sendMessage(1, "bind surface");
    AppMethodBeat.o(216357);
  }
  
  public void cancelAllPendingSeeks()
  {
    AppMethodBeat.i(216442);
    removePendingMessage(new int[] { 5 });
    AppMethodBeat.o(216442);
  }
  
  void enableScheduleNext(boolean paramBoolean)
  {
    this.mEnableScheduleNext = paramBoolean;
  }
  
  public CGRect getGlViewportRect()
  {
    return this.glViewportRect;
  }
  
  Handler getPlayHandler()
  {
    return this.mPlayHandler;
  }
  
  public CMTime getPosition()
  {
    return this.mPosition;
  }
  
  RenderContextParams getRenderContextParams()
  {
    return this.renderContextParams;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject3 = null;
    AppMethodBeat.i(216406);
    Object localObject2;
    Callback localCallback;
    StringBuilder localStringBuilder;
    if (paramMessage.obj == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label745;
      }
      localObject2 = ((PlayerMessage)localObject1).bizMsg1;
      localCallback = ((PlayerMessage)localObject1).callback;
      if (paramMessage.what != 2) {
        syncAudioOtherMsg(paramMessage.what, paramMessage.obj);
      }
      localStringBuilder = new StringBuilder("handleMessage() called with: msg = [").append(catLog(paramMessage.what)).append("]--obj-->").append(localObject2).append("--from-->");
      if (localObject1 != null) {
        break label149;
      }
    }
    label149:
    for (Object localObject1 = localObject3;; localObject1 = ((PlayerMessage)localObject1).form)
    {
      Logger.v("PlayerThreadMain", (String)localObject1);
      if (this.mThread != null) {
        break label159;
      }
      AppMethodBeat.o(216406);
      return false;
      localObject1 = (PlayerMessage)paramMessage.obj;
      break;
    }
    for (;;)
    {
      try
      {
        label159:
        switch (paramMessage.what)
        {
        case 1: 
          label316:
          if (localCallback != null) {
            localCallback.call();
          }
          AppMethodBeat.o(216406);
          return true;
        }
      }
      catch (Exception paramMessage)
      {
        Logger.v("PlayerThreadMain", "player error:" + Log.getStackTraceString(paramMessage));
        AppMethodBeat.o(216406);
        return false;
      }
      prepare(localObject2);
      continue;
      play();
      continue;
      pause();
    }
    for (;;)
    {
      label393:
      stop(bool);
      break label316;
      label745:
      do
      {
        bool = ((Boolean)localObject2).booleanValue();
        break label393;
        seek((CMTime)localObject2);
        break label316;
        if ((this.mPlayRange != null) && (!this.mPosition.add(this.frameDuration).smallThan(this.mPlayRange.getEnd())))
        {
          seek(this.mPlayRange.getStart());
          break label316;
        }
        if (!this.mEnableScheduleNext) {
          break label316;
        }
        if (localObject2 == null) {}
        for (int i = 0;; i = ((Integer)localObject2).intValue())
        {
          readSample(i);
          break;
        }
        seekPreSample();
        break label316;
        updateProperties();
        break label316;
        updateAllProperties();
        break label316;
        updateAudioClipsProperties();
        break label316;
        udpateAudioVolumeProperties();
        break label316;
        paramMessage = (UpdateCompositionMessage)localObject2;
        stop(true);
        releaseComposition();
        if (paramMessage == null) {
          break label316;
        }
        updateComposition(paramMessage.playerItem);
        prepare(paramMessage.updateListener);
        break label316;
        if (!(localObject2 instanceof CGSize)) {
          break label316;
        }
        this.surfaceSize = ((CGSize)localObject2);
        initViewport();
        break label316;
        if (!(localObject2 instanceof OnReadSnapShootListener)) {
          break label316;
        }
        this.onReadSnapShootListener = ((OnReadSnapShootListener)localObject2);
        break label316;
        if (!(localObject2 instanceof OnGetTavExtraListener)) {
          break label316;
        }
        this.onGetTavExtraListener = ((OnGetTavExtraListener)localObject2);
        break label316;
        release(paramMessage);
        break label316;
        refreshSurface((Callback)localObject2);
        break label316;
        Logger.i("PlayerThreadMain", "quit: PlayerThreadMain ".concat(String.valueOf(this)));
        removePendingMessage(new int[0]);
        this.mThread.quit();
        this.mThread = null;
        this.vDecoderTrack.release();
        this.aDecoderTrack.release();
        this.renderContext.release();
        this.renderContext = null;
        this.vDecoderTrack = null;
        this.aDecoderTrack = null;
        this.mPlayHandler.removeCallbacksAndMessages(null);
        break label316;
        localCallback = null;
        localObject2 = null;
        break;
        break label316;
      } while (localObject2 != null);
      boolean bool = false;
    }
  }
  
  public boolean hasMessage(int paramInt)
  {
    AppMethodBeat.i(216432);
    if ((this.mPlayHandler != null) && (this.mThread != null))
    {
      boolean bool = this.mPlayHandler.hasMessages(paramInt);
      AppMethodBeat.o(216432);
      return bool;
    }
    AppMethodBeat.o(216432);
    return false;
  }
  
  void removePendingUpdateCompositionMessage()
  {
    AppMethodBeat.i(216421);
    removePendingMessage(new int[] { 11 });
    AppMethodBeat.o(216421);
  }
  
  void removeReadSampleMessage()
  {
    AppMethodBeat.i(216413);
    if (this.mStatus == 1)
    {
      AppMethodBeat.o(216413);
      return;
    }
    if (this.vDecoderTrack != null) {
      removePendingMessage(new int[] { 12, 26 });
    }
    AppMethodBeat.o(216413);
  }
  
  public void sendMessage(int paramInt, Object paramObject, String paramString)
  {
    AppMethodBeat.i(216370);
    Logger.v("PlayerThreadMain", "sendMessage() called with: what = [" + catLog(paramInt) + "], obj = [" + paramObject + "], from = [" + paramString + "]");
    if ((this.mPlayHandler != null) && (this.mThread != null)) {
      this.mPlayHandler.obtainMessage(paramInt, new PlayerMessage(paramObject, paramString, System.currentTimeMillis())).sendToTarget();
    }
    AppMethodBeat.o(216370);
  }
  
  public void sendMessage(int paramInt, Object paramObject, String paramString, Callback paramCallback)
  {
    AppMethodBeat.i(216364);
    Logger.d("PlayerThreadMain", "sendMessage() called with: what = [" + catLog(paramInt) + "], obj = [" + paramObject + "], from = [" + paramString + "]");
    if ((this.mPlayHandler != null) && (this.mThread != null)) {
      this.mPlayHandler.obtainMessage(paramInt, new PlayerMessage(paramObject, paramString, System.currentTimeMillis(), paramCallback)).sendToTarget();
    }
    AppMethodBeat.o(216364);
  }
  
  public void sendMessage(int paramInt, String paramString)
  {
    AppMethodBeat.i(216377);
    Logger.v("PlayerThreadMain", "sendMessage() called with: what = [" + catLog(paramInt) + "], from = [" + paramString + "]");
    if ((this.mPlayHandler != null) && (this.mThread != null)) {
      this.mPlayHandler.obtainMessage(paramInt, new PlayerMessage(null, paramString, System.currentTimeMillis())).sendToTarget();
    }
    AppMethodBeat.o(216377);
  }
  
  public void sendMessageDelay(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(216381);
    Logger.v("PlayerThreadMain", "sendMessageDelay() called with: what = [" + catLog(paramInt) + "], delay = [" + paramLong + "], from = [" + paramString + "]");
    if (this.mPlayHandler != null)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt;
      localMessage.obj = new PlayerMessage(null, paramString, System.currentTimeMillis());
      this.mPlayHandler.sendMessageDelayed(localMessage, paramLong);
    }
    AppMethodBeat.o(216381);
  }
  
  void setFrameDuration(CMTime paramCMTime)
  {
    this.frameDuration = paramCMTime;
  }
  
  public void setPlayRange(CMTimeRange paramCMTimeRange)
  {
    this.mPlayRange = paramCMTimeRange;
  }
  
  public void setRate(float paramFloat)
  {
    AppMethodBeat.i(216332);
    this.rate = paramFloat;
    this.mAudioThread.setRate(paramFloat);
    AppMethodBeat.o(216332);
  }
  
  void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    AppMethodBeat.i(216344);
    this.renderContextParams = paramRenderContextParams;
    if (this.renderContext != null) {
      this.renderContext.setParams(paramRenderContextParams);
    }
    AppMethodBeat.o(216344);
  }
  
  public void updatePositionRightAway(CMTime paramCMTime)
  {
    this.mPosition = paramCMTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.player.PlayerThread
 * JD-Core Version:    0.7.0.1
 */