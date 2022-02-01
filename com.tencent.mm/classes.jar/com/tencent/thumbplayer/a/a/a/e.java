package com.tencent.thumbplayer.a.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes.Builder;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnTimedTextListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.MediaPlayer.TrackInfo;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.a;
import com.tencent.thumbplayer.a.a.c.b;
import com.tencent.thumbplayer.a.a.c.c;
import com.tencent.thumbplayer.a.a.c.d;
import com.tencent.thumbplayer.a.a.c.e;
import com.tencent.thumbplayer.a.a.c.f;
import com.tencent.thumbplayer.a.a.c.g;
import com.tencent.thumbplayer.a.a.c.i;
import com.tencent.thumbplayer.a.a.c.j;
import com.tencent.thumbplayer.a.a.c.k;
import com.tencent.thumbplayer.a.a.c.l;
import com.tencent.thumbplayer.a.a.c.m;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamBoolean;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamString;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPAudioTrackInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.utils.j;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class e
  implements com.tencent.thumbplayer.a.a.b
{
  com.tencent.thumbplayer.f.a RVN;
  private c.f RVZ;
  private Object RVt;
  boolean RWP;
  long RWQ;
  long RWR;
  private FileDescriptor RWS;
  private float RWT;
  private float RWU;
  int RWV;
  long RWW;
  private long RWX;
  int RWY;
  int RWZ;
  c.c RWa;
  c.e RWb;
  c.d RWc;
  c.g RWd;
  c.m RWe;
  c.i RWf;
  long RXA;
  private f RXB;
  @TargetApi(16)
  private MediaPlayer.OnTimedTextListener RXC;
  private boolean RXa;
  private d RXb;
  private com.tencent.thumbplayer.b.c RXc;
  private Future<?> RXd;
  private final Object RXe;
  private long RXf;
  private a RXg;
  private final Object RXh;
  int RXi;
  int RXj;
  final Object RXk;
  Future<?> RXl;
  boolean RXm;
  volatile e RXn;
  volatile e RXo;
  private boolean RXp;
  long RXq;
  long RXr;
  volatile boolean RXs;
  int RXt;
  int RXu;
  private int RXv;
  private int RXw;
  private List<b> RXx;
  private List<b> RXy;
  private a RXz;
  boolean gPs;
  private Map<String, String> jEZ;
  volatile MediaPlayer mBq;
  private Context mContext;
  private boolean mMute;
  private String mUrl;
  int mVideoHeight;
  int mVideoWidth;
  
  public e(Context paramContext, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(188863);
    this.RWP = false;
    this.RWQ = 0L;
    this.RWR = 0L;
    this.mMute = false;
    this.RWT = 1.0F;
    this.RWU = 1.0F;
    this.RWV = 0;
    this.RWW = -1L;
    this.gPs = false;
    this.RWX = -1L;
    this.RWY = -1;
    this.RWZ = -1;
    this.RXa = true;
    this.RXd = null;
    this.RXe = new Object();
    this.RXf = 25000L;
    this.RXh = new Object();
    this.RXi = 3;
    this.RXj = 30;
    this.RXk = new Object();
    this.RXl = null;
    this.RXm = false;
    this.RXp = false;
    this.RXq = 0L;
    this.RXr = -1L;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.RXs = false;
    this.RXt = 0;
    this.RXu = -1;
    this.RXv = 0;
    this.RXw = -1;
    this.RXx = new ArrayList();
    this.RXy = new ArrayList();
    this.RXA = 0L;
    this.RXB = null;
    this.RXC = new MediaPlayer.OnTimedTextListener()
    {
      public final void onTimedText(MediaPlayer paramAnonymousMediaPlayer, TimedText paramAnonymousTimedText)
      {
        AppMethodBeat.i(188851);
        TPSubtitleData localTPSubtitleData;
        if (e.this.RWf != null)
        {
          localTPSubtitleData = new TPSubtitleData();
          if (paramAnonymousTimedText == null) {
            break label79;
          }
        }
        label79:
        for (paramAnonymousMediaPlayer = paramAnonymousTimedText.getText();; paramAnonymousMediaPlayer = "")
        {
          localTPSubtitleData.subtitleData = paramAnonymousMediaPlayer;
          localTPSubtitleData.trackIndex = e.this.RXu;
          localTPSubtitleData.startPositionMs = e.this.getCurrentPositionMs();
          e.this.RWf.a(localTPSubtitleData);
          AppMethodBeat.o(188851);
          return;
        }
      }
    };
    this.RVN = new com.tencent.thumbplayer.f.a(paramb, "TPSystemMediaPlayer");
    this.mContext = paramContext;
    this.RXb = new d((byte)0);
    paramContext = new b((byte)0);
    paramContext.RXH = new TPTrackInfo();
    paramContext.RXH.isSelected = true;
    paramContext.RXH.name = "audio_1";
    this.RXx.add(paramContext);
    paramContext = new b();
    if (Build.VERSION.SDK_INT <= 19) {
      a(paramContext);
    }
    paramContext.setOnPreparedListener(this.RXb);
    paramContext.setOnCompletionListener(this.RXb);
    paramContext.setOnErrorListener(this.RXb);
    paramContext.setOnInfoListener(this.RXb);
    paramContext.setOnBufferingUpdateListener(this.RXb);
    paramContext.setOnSeekCompleteListener(this.RXb);
    paramContext.setOnVideoSizeChangedListener(this.RXb);
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.setOnTimedTextListener(this.RXC);
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramContext.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
    }
    for (;;)
    {
      this.mBq = paramContext;
      this.RXn = e.RXJ;
      this.RXo = e.RXJ;
      this.RXz = new c();
      this.RXz.a(new a.a()
      {
        public final void a(a.c paramAnonymousc)
        {
          AppMethodBeat.i(188846);
          TPSubtitleData localTPSubtitleData = new TPSubtitleData();
          localTPSubtitleData.subtitleData = paramAnonymousc.text;
          paramAnonymousc = e.this.RWf;
          if (paramAnonymousc != null) {
            paramAnonymousc.a(localTPSubtitleData);
          }
          AppMethodBeat.o(188846);
        }
      });
      this.RXz.a(new a.b()
      {
        public final long getCurrentPosition()
        {
          AppMethodBeat.i(188847);
          if ((e.this.RXn != e.e.RXO) && (e.this.RXn != e.e.RXN))
          {
            AppMethodBeat.o(188847);
            return -1L;
          }
          long l = e.this.getCurrentPositionMs();
          AppMethodBeat.o(188847);
          return l;
        }
      });
      AppMethodBeat.o(188863);
      return;
      paramContext.setAudioStreamType(3);
    }
  }
  
  private void a(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(188862);
    try
    {
      Field localField = MediaPlayer.class.getDeclaredField("mEventHandler");
      localField.setAccessible(true);
      paramMediaPlayer = (Handler)localField.get(paramMediaPlayer);
      localField = Handler.class.getDeclaredField("mCallback");
      localField.setAccessible(true);
      if ((Handler.Callback)localField.get(paramMediaPlayer) == null) {
        localField.set(paramMediaPlayer, new e.c(paramMediaPlayer));
      }
      AppMethodBeat.o(188862);
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      this.RVN.error("mediaPlayerExceptionHook, " + Log.getStackTraceString(paramMediaPlayer));
      AppMethodBeat.o(188862);
    }
  }
  
  private void a(f paramf)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        AppMethodBeat.i(188880);
        localObject1 = paramf.url;
        paramf.position = getCurrentPositionMs();
        paramf.RXY = this.RXn;
        paramf.RXW = this.RXw;
        paramf.RXX = this.RXu;
        this.RVN.info("playerResetStart, pos:" + paramf.position + ", state:" + paramf.RXY);
        this.RXp = true;
        hmX();
        hmZ();
        hna();
        hmU();
        localObject2 = new b();
        if (Build.VERSION.SDK_INT <= 19) {
          a((MediaPlayer)localObject2);
        }
        ((MediaPlayer)localObject2).setOnPreparedListener(this.RXb);
        ((MediaPlayer)localObject2).setOnCompletionListener(this.RXb);
        ((MediaPlayer)localObject2).setOnErrorListener(this.RXb);
        ((MediaPlayer)localObject2).setOnInfoListener(this.RXb);
        ((MediaPlayer)localObject2).setOnBufferingUpdateListener(this.RXb);
        ((MediaPlayer)localObject2).setOnSeekCompleteListener(this.RXb);
        ((MediaPlayer)localObject2).setOnVideoSizeChangedListener(this.RXb);
        if (Build.VERSION.SDK_INT >= 16) {
          ((MediaPlayer)localObject2).setOnTimedTextListener(this.RXC);
        }
        if (Build.VERSION.SDK_INT >= 26)
        {
          ((MediaPlayer)localObject2).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
          if (this.mMute)
          {
            this.mBq.setVolume(0.0F, 0.0F);
            if (this.RWU != 1.0D) {
              setPlaySpeedRatio(this.RWU);
            }
            if (this.RWP) {
              this.mBq.setLooping(this.RWP);
            }
            this.mBq = ((MediaPlayer)localObject2);
            this.RXo = e.RXJ;
            if (this.RWS == null) {
              break label536;
            }
            this.mBq.setDataSource(this.RWS);
            this.RXo = e.RXK;
            if (this.RVt != null) {
              break label710;
            }
            this.mBq.setDisplay(null);
            localObject1 = this.RXB;
            if ((localObject1 != null) && (((f)localObject1).RXU != paramf.RXU))
            {
              localObject2 = this.RWb;
              if (((f)localObject1).RXU != 1) {
                break label764;
              }
              i = 3;
              if (localObject2 != null) {
                ((c.e)localObject2).a(i, ((f)localObject1).RVK, 0L, null);
              }
              paramf.RXY = ((f)localObject1).RXY;
              paramf.position = ((f)localObject1).position;
            }
            this.RXB = paramf;
            if ((paramf.RXY == e.RXL) || (paramf.RXY == e.RXM) || (paramf.RXY == e.RXN) || (paramf.RXY == e.RXO))
            {
              this.mBq.prepareAsync();
              this.RXn = e.RXL;
              this.RXo = e.RXL;
              hmW();
            }
            AppMethodBeat.o(188880);
          }
        }
        else
        {
          ((MediaPlayer)localObject2).setAudioStreamType(3);
          continue;
        }
        if (this.RWT == 1.0F) {
          continue;
        }
      }
      finally {}
      this.mBq.setVolume(this.RWT, this.RWT);
      continue;
      label536:
      int i = paramf.RXV;
      if (i > 0)
      {
        localObject2 = (b)this.RXx.get(i);
        c.e locale = this.RWb;
        if (locale != null)
        {
          TPPlayerMsg.TPAudioTrackInfo localTPAudioTrackInfo = new TPPlayerMsg.TPAudioTrackInfo();
          localTPAudioTrackInfo.audioTrackUrl = ((b)localObject2).url;
          localTPAudioTrackInfo.keyId = ((b)localObject2).keyId;
          this.RVN.info("handleDataSource, audioTrack url:" + localTPAudioTrackInfo.audioTrackUrl + ", keyId:" + localTPAudioTrackInfo.keyId);
          locale.a(1011, 0L, 0L, localTPAudioTrackInfo);
        }
      }
      if ((this.jEZ != null) && (!this.jEZ.isEmpty()))
      {
        localObject1 = Uri.parse((String)localObject1);
        this.mBq.setDataSource(this.mContext, (Uri)localObject1, this.jEZ);
      }
      else
      {
        this.mBq.setDataSource((String)localObject1);
        continue;
        label710:
        if ((this.RVt instanceof SurfaceHolder))
        {
          this.mBq.setDisplay((SurfaceHolder)this.RVt);
        }
        else if ((this.RVt instanceof Surface))
        {
          this.mBq.setSurface((Surface)this.RVt);
          continue;
          label764:
          i = 4;
        }
      }
    }
  }
  
  static int aqV(int paramInt)
  {
    long l2 = 2147483647L;
    long l1;
    if (paramInt < 0)
    {
      l1 = 10000000L - paramInt;
      if (l1 < 2147483647L) {
        break label38;
      }
      l1 = l2;
    }
    label38:
    for (;;)
    {
      return (int)l1;
      l1 = paramInt + 10000000L;
      break;
    }
  }
  
  private void hmT()
  {
    AppMethodBeat.i(188878);
    e locale = this.RXo;
    if ((locale == e.RXM) || (locale == e.RXN) || (locale == e.RXO)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.RXo = e.RXP;
        this.RVN.info("MediaPlayer stop.");
        this.mBq.stop();
      }
      AppMethodBeat.o(188878);
      return;
    }
  }
  
  private void hmW()
  {
    AppMethodBeat.i(188907);
    this.RVN.info("startCheckPrepareTimeoutTimer");
    synchronized (this.RXe)
    {
      if (this.RXd == null) {
        this.RXd = j.getScheduledExecutorServiceInstance().schedule(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(188848);
            if (e.this.RXn == e.e.RXL)
            {
              e.this.RVN.error("startCheckPrepareTimeoutTimer, post error");
              e.this.RXn = e.e.RXR;
              e.this.hmU();
              e.this.hmX();
              c.d locald = e.this.RWc;
              if (locald != null) {
                locald.a(2001, e.aqV(-110), 0L, 0L);
              }
            }
            AppMethodBeat.o(188848);
          }
        }, this.RXf, TimeUnit.MILLISECONDS);
      }
      AppMethodBeat.o(188907);
      return;
    }
  }
  
  private void hmY()
  {
    AppMethodBeat.i(188909);
    synchronized (this.RXh)
    {
      if (!hnb())
      {
        this.RVN.info("startCheckBufferingTimer, forbidden check buffer by position");
        AppMethodBeat.o(188909);
        return;
      }
      if (this.RXg == null)
      {
        this.RXg = new a((byte)0);
        final a locala = this.RXg;
        this.RXg.RXF = false;
        this.RXg.RXG = j.getScheduledExecutorServiceInstance().schedule(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(188849);
            if (!locala.RXF)
            {
              Object localObject1 = e.this;
              long l1 = ((e)localObject1).getCurrentPositionMs();
              long l2 = ((e)localObject1).RXr;
              ((e)localObject1).RXr = l1;
              if (((e)localObject1).RXn != e.e.RXN) {
                if ((((e)localObject1).RXn == e.e.RXO) && (((e)localObject1).RXs))
                {
                  ((e)localObject1).RVN.info("checkBuffingEvent, pause state and send end buffering");
                  ((e)localObject1).RXs = false;
                  ((e)localObject1).RXt = 0;
                  localObject1 = ((e)localObject1).RWb;
                  if (localObject1 != null) {
                    ((c.e)localObject1).a(201, 0L, 0L, null);
                  }
                }
              }
              for (;;)
              {
                try
                {
                  Thread.sleep(400L);
                }
                catch (InterruptedException localInterruptedException) {}
                break;
                if (localInterruptedException.RWP) {
                  if ((localInterruptedException.RWR > 0L) && (l1 >= localInterruptedException.RWR) && (!localInterruptedException.RXm))
                  {
                    localInterruptedException.RVN.info("checkBuffingEvent, loopback skip end, curPosition:" + l1 + ", mLoopStartPositionMs:" + localInterruptedException.RWQ);
                    localInterruptedException.mBq.seekTo((int)localInterruptedException.RWQ);
                  }
                }
                c.e locale;
                while ((((e)localObject2).RWW <= 0L) || (l1 < ((e)localObject2).getDurationMs() - ((e)localObject2).RWW))
                {
                  if (l1 != l2) {
                    localInterruptedException.RXA += 1L;
                  }
                  if ((l1 != l2) || (l1 <= 0L)) {
                    break label528;
                  }
                  int i = localInterruptedException.RXt + 1;
                  localInterruptedException.RXt = i;
                  if ((i >= localInterruptedException.RXi) && (!localInterruptedException.RXs))
                  {
                    localInterruptedException.RXs = true;
                    localInterruptedException.RVN.info("checkBuffingEvent, position no change,send start buffering");
                    locale = localInterruptedException.RWb;
                    if (locale != null) {
                      locale.a(200, l1, localInterruptedException.RXq, Long.valueOf(localInterruptedException.RXA));
                    }
                  }
                  if (localInterruptedException.RXt < localInterruptedException.RXj) {
                    break;
                  }
                  localInterruptedException.RVN.error("checkBuffingEvent post error");
                  localInterruptedException.RXn = e.e.RXR;
                  localInterruptedException.hmU();
                  localInterruptedException.RXs = false;
                  localInterruptedException.hmZ();
                  localObject2 = localInterruptedException.RWc;
                  if (localObject2 == null) {
                    break;
                  }
                  ((c.d)localObject2).a(2001, e.aqV(-110), 0L, 0L);
                  break;
                }
                ((e)localObject2).RVN.info("checkBuffingEvent, skip end, mBaseDuration: " + ((e)localObject2).RXq + ", curPosition:" + l1 + ", mSkipEndMilsec:" + ((e)localObject2).RWW);
                ((e)localObject2).RXn = e.e.RXQ;
                ((e)localObject2).hmU();
                ((e)localObject2).hmZ();
                Object localObject2 = ((e)localObject2).RWa;
                if (localObject2 != null)
                {
                  ((c.c)localObject2).onCompletion();
                  continue;
                  label528:
                  if (((e)localObject2).RXs)
                  {
                    ((e)localObject2).RVN.info("checkBuffingEvent, position change, send end buffering");
                    locale = ((e)localObject2).RWb;
                    if (locale != null) {
                      locale.a(201, l1, ((e)localObject2).RXq, Long.valueOf(((e)localObject2).RXA));
                    }
                  }
                  ((e)localObject2).RXs = false;
                  ((e)localObject2).RXt = 0;
                }
              }
            }
            AppMethodBeat.o(188849);
          }
        }, 0L, TimeUnit.MILLISECONDS);
      }
      AppMethodBeat.o(188909);
      return;
    }
  }
  
  public final void L(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(188893);
    this.RVN.info("switchDefinition, defUrl: ".concat(String.valueOf(paramString)));
    if (TextUtils.isEmpty(paramString))
    {
      this.RVN.info("switchDefinition, defUrl is null");
      AppMethodBeat.o(188893);
      return;
    }
    this.mUrl = paramString;
    f localf = new f((byte)0);
    localf.RVK = paramLong;
    localf.RXV = this.RXv;
    localf.RXU = 1;
    localf.url = paramString;
    try
    {
      a(localf);
      AppMethodBeat.o(188893);
      return;
    }
    catch (Exception paramString)
    {
      paramString = new IllegalStateException("playerResetStart");
      AppMethodBeat.o(188893);
      throw paramString;
    }
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(188868);
    parama = new IllegalStateException("system Mediaplayer cannot support audio frame out");
    AppMethodBeat.o(188868);
    throw parama;
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(188870);
    paramb = new IllegalStateException("system Mediaplayer cannot support audio postprocess frame out");
    AppMethodBeat.o(188870);
    throw paramb;
  }
  
  public final void a(c.c paramc)
  {
    this.RWa = paramc;
  }
  
  public final void a(c.d paramd)
  {
    this.RWc = paramd;
  }
  
  public final void a(c.e parame)
  {
    this.RWb = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.RVZ = paramf;
  }
  
  public final void a(c.g paramg)
  {
    this.RWd = paramg;
  }
  
  public final void a(c.i parami)
  {
    this.RWf = parami;
  }
  
  public final void a(c.j paramj)
  {
    AppMethodBeat.i(188866);
    paramj = new IllegalStateException("system Mediaplayer cannot support subtitle frame out");
    AppMethodBeat.o(188866);
    throw paramj;
  }
  
  public final void a(c.k paramk)
  {
    AppMethodBeat.i(188867);
    paramk = new IllegalStateException("system Mediaplayer cannot support video frame out");
    AppMethodBeat.o(188867);
    throw paramk;
  }
  
  public final void a(c.l paraml)
  {
    AppMethodBeat.i(188869);
    paraml = new IllegalStateException("system Mediaplayer cannot support video postprocess frame out");
    AppMethodBeat.o(188869);
    throw paraml;
  }
  
  public final void a(c.m paramm)
  {
    this.RWe = paramm;
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong) {}
  
  public final void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(188876);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      this.RVN.error("addSubtitleSource, illegal argument.");
      AppMethodBeat.o(188876);
      return;
    }
    paramString2 = new TPTrackInfo();
    paramString2.name = paramString3;
    paramString2.isExclusive = true;
    paramString2.isInternal = false;
    paramString2.isSelected = false;
    paramString2.trackType = 3;
    b localb = new b((byte)0);
    localb.RXH = paramString2;
    localb.url = paramString1;
    this.RVN.info("addSubtitleSource, name:" + paramString2.name + ", url:" + paramString3);
    this.RXy.add(localb);
    AppMethodBeat.o(188876);
  }
  
  public final void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(188906);
    if (this.RXc != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = paramTPCaptureParams.width;
      localTPImageGeneratorParams.height = paramTPCaptureParams.height;
      localTPImageGeneratorParams.format = paramTPCaptureParams.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = paramTPCaptureParams.requestedTimeMsToleranceBefore;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = paramTPCaptureParams.requestedTimeMsToleranceAfter;
      this.RXc.a(getCurrentPositionMs(), localTPImageGeneratorParams, paramTPCaptureCallBack);
      AppMethodBeat.o(188906);
      return;
    }
    paramTPCaptureCallBack.onCaptureVideoFailed(1000013);
    AppMethodBeat.o(188906);
  }
  
  @TargetApi(16)
  public final void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188883);
    if (Build.VERSION.SDK_INT < 16)
    {
      this.RVN.error("deselectTrack, android mediaplayer not support ");
      AppMethodBeat.o(188883);
      return;
    }
    this.mBq.deselectTrack(paramInt);
    AppMethodBeat.o(188883);
  }
  
  public final void g(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    AppMethodBeat.i(188877);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      this.RVN.error("addAudioTrackSource, illegal argument.");
      AppMethodBeat.o(188877);
      return;
    }
    TPTrackInfo localTPTrackInfo = new TPTrackInfo();
    localTPTrackInfo.name = paramString2;
    localTPTrackInfo.isExclusive = true;
    localTPTrackInfo.isInternal = false;
    localTPTrackInfo.isSelected = false;
    localTPTrackInfo.trackType = 2;
    b localb = new b((byte)0);
    localb.RXH = localTPTrackInfo;
    localb.url = paramString1;
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramList = (TPOptionalParam)paramString1.next();
      if (paramList.getKey() == 6) {
        localb.keyId = paramList.getParamString().value;
      }
    }
    this.RVN.info("addAudioTrackSource, name:" + localTPTrackInfo.name + ", url:" + paramString2);
    this.RXx.add(localb);
    AppMethodBeat.o(188877);
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(188901);
    if (this.gPs)
    {
      AppMethodBeat.o(188901);
      return 0L;
    }
    if ((this.RXp) || (this.RXn == e.RXR))
    {
      if (this.RXr == -1L)
      {
        l = this.RWV;
        AppMethodBeat.o(188901);
        return l;
      }
      l = this.RXr;
      AppMethodBeat.o(188901);
      return l;
    }
    if ((this.RXn == e.RXJ) || (this.RXn == e.RXK) || (this.RXn == e.RXL) || (this.RXn == e.RXP) || (this.RXn == e.RXM))
    {
      l = this.RWV;
      AppMethodBeat.o(188901);
      return l;
    }
    long l = this.mBq.getCurrentPosition();
    AppMethodBeat.o(188901);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(188900);
    if (this.gPs)
    {
      AppMethodBeat.o(188900);
      return 0L;
    }
    long l;
    if (this.RXp)
    {
      l = this.RXq;
      AppMethodBeat.o(188900);
      return l;
    }
    if ((this.RXn != e.RXM) && (this.RXn != e.RXN) && (this.RXn != e.RXO))
    {
      AppMethodBeat.o(188900);
      return -1L;
    }
    if (this.RXq <= 0L) {
      this.RXq = this.mBq.getDuration();
    }
    if (this.RWX > 0L)
    {
      if (this.RXq > 0L) {
        break label141;
      }
      this.RXq = this.RWX;
    }
    for (;;)
    {
      l = this.RXq;
      AppMethodBeat.o(188900);
      return l;
      label141:
      if (Math.abs(this.RWX - this.RXq) * 100L / this.RWX > 1L) {
        this.RXq = this.RWX;
      }
    }
  }
  
  public final long getPlayableDurationMs()
  {
    return 0L;
  }
  
  public final TPProgramInfo[] getProgramInfo()
  {
    return new TPProgramInfo[0];
  }
  
  public final long getPropertyLong(int paramInt)
  {
    return -1L;
  }
  
  public final String getPropertyString(int paramInt)
  {
    return null;
  }
  
  @TargetApi(16)
  public final TPTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(188904);
    if (((this.RXn == e.RXM) || (this.RXn == e.RXN) || (this.RXn == e.RXO)) && (com.tencent.thumbplayer.utils.b.SDK_INT > 16)) {}
    Object localObject;
    for (;;)
    {
      try
      {
        MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.mBq.getTrackInfo();
        if ((arrayOfTrackInfo != null) || (!this.RXx.isEmpty()) || (!this.RXy.isEmpty())) {
          break;
        }
        AppMethodBeat.o(188904);
        return new TPTrackInfo[0];
      }
      catch (Exception localException)
      {
        this.RVN.error("getTrackInfo, android getTrackInfo crash");
      }
      localObject = null;
    }
    int j = this.RXx.size();
    int k = this.RXy.size();
    if (localObject == null) {}
    TPTrackInfo[] arrayOfTPTrackInfo;
    for (int i = 0;; i = localObject.length)
    {
      arrayOfTPTrackInfo = new TPTrackInfo[i + (k + j)];
      localIterator = this.RXx.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        arrayOfTPTrackInfo[i] = ((b)localIterator.next()).RXH;
        i += 1;
      }
    }
    Iterator localIterator = this.RXy.iterator();
    while (localIterator.hasNext())
    {
      arrayOfTPTrackInfo[i] = ((b)localIterator.next()).RXH;
      i += 1;
    }
    if ((localObject == null) || (localObject.length <= 0))
    {
      AppMethodBeat.o(188904);
      return arrayOfTPTrackInfo;
    }
    int m = localObject.length;
    k = 0;
    j = i;
    if (k < m)
    {
      localIterator = localObject[k];
      TPTrackInfo localTPTrackInfo = new TPTrackInfo();
      localTPTrackInfo.name = localIterator.getLanguage();
      i = localIterator.getTrackType();
      if (2 == i) {
        i = 2;
      }
      for (;;)
      {
        localTPTrackInfo.trackType = i;
        arrayOfTPTrackInfo[j] = localTPTrackInfo;
        k += 1;
        j += 1;
        break;
        if (1 == i) {
          i = 1;
        } else if (4 == i) {
          i = 3;
        } else {
          i = 0;
        }
      }
    }
    AppMethodBeat.o(188904);
    return arrayOfTPTrackInfo;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(188903);
    this.RVN.info("getVideoHeight, height:" + this.mVideoHeight);
    int i = this.mVideoHeight;
    AppMethodBeat.o(188903);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(188902);
    this.RVN.info("getVideoWidth, width:" + this.mVideoWidth);
    int i = this.mVideoWidth;
    AppMethodBeat.o(188902);
    return i;
  }
  
  final void hmU()
  {
    AppMethodBeat.i(188879);
    this.mBq.setOnPreparedListener(null);
    this.mBq.setOnCompletionListener(null);
    this.mBq.setOnErrorListener(null);
    this.mBq.setOnInfoListener(null);
    this.mBq.setOnBufferingUpdateListener(null);
    this.mBq.setOnSeekCompleteListener(null);
    this.mBq.setOnVideoSizeChangedListener(null);
    hmT();
    if (this.RXo != e.RXS) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.RXo = e.RXS;
        this.RVN.info("MediaPlayer release.");
        this.mBq.release();
      }
      AppMethodBeat.o(188879);
      return;
    }
  }
  
  final void hmV()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(188881);
        Object localObject1 = this.RXB;
        this.RVN.info("playerResetEnd, actionInfo:" + localObject1 + ", mSuspend:" + this.RXp);
        if ((localObject1 == null) || (!this.RXp)) {
          break label464;
        }
        c.e locale = this.RWb;
        int i;
        if (((f)localObject1).RXU == 1)
        {
          i = 3;
          if (locale != null) {
            locale.a(i, 1000L, 0L, Long.valueOf(((f)localObject1).RVK));
          }
          if (Build.VERSION.SDK_INT >= 16)
          {
            if (((f)localObject1).RXW > 0) {
              this.mBq.selectTrack(((f)localObject1).RXW);
            }
            if (((f)localObject1).RXX > 0) {
              this.mBq.selectTrack(((f)localObject1).RXX);
            }
          }
          if ((((f)localObject1).position > 0L) && (!this.RXm)) {
            this.RVN.info("playerResetEnd, onPrepared(), and seek to:" + ((f)localObject1).position);
          }
        }
        try
        {
          this.mBq.seekTo((int)((f)localObject1).position);
          this.RVN.info("playerResetEnd, restore state:" + ((f)localObject1).RXY);
          if ((((f)localObject1).RXY == e.RXJ) || (((f)localObject1).RXY == e.RXK) || (((f)localObject1).RXY == e.RXL))
          {
            this.RXn = e.RXM;
            localObject1 = this.RVZ;
            if (localObject1 != null) {
              ((c.f)localObject1).tf();
            }
            this.RXp = false;
            this.RXB = null;
            AppMethodBeat.o(188881);
            return;
            i = 4;
          }
        }
        catch (Exception localException2)
        {
          this.RVN.r(localException2);
          continue;
        }
        if (localObject2.RXY == e.RXM) {
          break label337;
        }
      }
      finally {}
      if (localObject2.RXY == e.RXO)
      {
        label337:
        this.RXn = localObject2.RXY;
        continue;
      }
      if (localObject2.RXY == e.RXN)
      {
        this.RVN.info("playerResetEnd,  MediaPlayer.start().");
        this.mBq.start();
        this.RXn = localObject2.RXY;
        this.RXo = e.RXN;
        hmY();
        continue;
      }
      this.RVN.error("illegal state, state:" + localObject2.RXY);
      this.RXn = e.RXR;
      hmU();
      Object localObject3 = this.RWc;
      if (localObject3 == null) {
        continue;
      }
      ((c.d)localObject3).a(2000, aqV(-10004), 0L, 0L);
      continue;
      label464:
      if ((this.RWV > 0) && (!this.RXm)) {
        this.RVN.info("onPrepared(), and seekto:" + this.RWV);
      }
      try
      {
        this.mBq.seekTo(this.RWV);
        this.RXn = e.RXM;
        localObject3 = this.RVZ;
        if (localObject3 != null) {
          ((c.f)localObject3).tf();
        }
        AppMethodBeat.o(188881);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          this.RVN.r(localException1);
        }
      }
    }
  }
  
  /* Error */
  final void hmX()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 926
    //   5: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 169	com/tencent/thumbplayer/a/a/a/e:RXe	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 167	com/tencent/thumbplayer/a/a/a/e:RXd	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 167	com/tencent/thumbplayer/a/a/a/e:RXd	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 932 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 167	com/tencent/thumbplayer/a/a/a/e:RXd	Ljava/util/concurrent/Future;
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc_w 926
    //   43: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: ldc_w 926
    //   55: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_2
    //   59: athrow
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	e
    //   60	4	1	localObject2	Object
    //   49	10	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	38	49	finally
    //   38	40	49	finally
    //   50	52	49	finally
    //   2	15	60	finally
    //   40	46	60	finally
    //   52	60	60	finally
  }
  
  /* Error */
  final void hmZ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 933
    //   5: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 175	com/tencent/thumbplayer/a/a/a/e:RXh	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 611	com/tencent/thumbplayer/a/a/a/e:RXg	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   19: ifnull +48 -> 67
    //   22: aload_0
    //   23: getfield 611	com/tencent/thumbplayer/a/a/a/e:RXg	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   26: iconst_1
    //   27: putfield 615	com/tencent/thumbplayer/a/a/a/e$a:RXF	Z
    //   30: aload_0
    //   31: getfield 611	com/tencent/thumbplayer/a/a/a/e:RXg	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   34: getfield 621	com/tencent/thumbplayer/a/a/a/e$a:RXG	Ljava/util/concurrent/Future;
    //   37: ifnull +17 -> 54
    //   40: aload_0
    //   41: getfield 611	com/tencent/thumbplayer/a/a/a/e:RXg	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   44: getfield 621	com/tencent/thumbplayer/a/a/a/e$a:RXG	Ljava/util/concurrent/Future;
    //   47: iconst_1
    //   48: invokeinterface 932 2 0
    //   53: pop
    //   54: aload_0
    //   55: getfield 611	com/tencent/thumbplayer/a/a/a/e:RXg	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   58: aconst_null
    //   59: putfield 621	com/tencent/thumbplayer/a/a/a/e$a:RXG	Ljava/util/concurrent/Future;
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 611	com/tencent/thumbplayer/a/a/a/e:RXg	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   67: aload_1
    //   68: monitorexit
    //   69: ldc_w 933
    //   72: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_2
    //   79: aload_1
    //   80: monitorexit
    //   81: ldc_w 933
    //   84: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_2
    //   88: athrow
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	e
    //   89	4	1	localObject2	Object
    //   78	10	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	54	78	finally
    //   54	67	78	finally
    //   67	69	78	finally
    //   79	81	78	finally
    //   2	15	89	finally
    //   69	75	89	finally
    //   81	89	89	finally
  }
  
  /* Error */
  final void hna()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 934
    //   5: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 181	com/tencent/thumbplayer/a/a/a/e:RXk	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 183	com/tencent/thumbplayer/a/a/a/e:RXl	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 183	com/tencent/thumbplayer/a/a/a/e:RXl	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 932 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 183	com/tencent/thumbplayer/a/a/a/e:RXl	Ljava/util/concurrent/Future;
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc_w 934
    //   43: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: ldc_w 934
    //   55: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_2
    //   59: athrow
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	e
    //   60	4	1	localObject2	Object
    //   49	10	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	38	49	finally
    //   38	40	49	finally
    //   50	52	49	finally
    //   2	15	60	finally
    //   40	46	60	finally
    //   52	60	60	finally
  }
  
  final boolean hnb()
  {
    if (this.gPs) {
      return false;
    }
    return this.RXa;
  }
  
  /* Error */
  public final void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 936
    //   5: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 230	com/tencent/thumbplayer/a/a/a/e:RVN	Lcom/tencent/thumbplayer/f/a;
    //   12: ldc_w 938
    //   15: invokevirtual 447	com/tencent/thumbplayer/f/a:info	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 187	com/tencent/thumbplayer/a/a/a/e:RXp	Z
    //   22: ifeq +39 -> 61
    //   25: aload_0
    //   26: getfield 216	com/tencent/thumbplayer/a/a/a/e:RXB	Lcom/tencent/thumbplayer/a/a/a/e$f;
    //   29: ifnull +13 -> 42
    //   32: aload_0
    //   33: getfield 216	com/tencent/thumbplayer/a/a/a/e:RXB	Lcom/tencent/thumbplayer/a/a/a/e$f;
    //   36: getstatic 510	com/tencent/thumbplayer/a/a/a/e$e:RXO	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   39: putfield 428	com/tencent/thumbplayer/a/a/a/e$f:RXY	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   42: aload_0
    //   43: getfield 230	com/tencent/thumbplayer/a/a/a/e:RVN	Lcom/tencent/thumbplayer/f/a;
    //   46: ldc_w 940
    //   49: invokevirtual 943	com/tencent/thumbplayer/f/a:warn	(Ljava/lang/String;)V
    //   52: ldc_w 936
    //   55: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: aload_0
    //   62: getfield 326	com/tencent/thumbplayer/a/a/a/e:mBq	Landroid/media/MediaPlayer;
    //   65: invokevirtual 945	android/media/MediaPlayer:pause	()V
    //   68: aload_0
    //   69: getstatic 510	com/tencent/thumbplayer/a/a/a/e$e:RXO	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   72: putfield 331	com/tencent/thumbplayer/a/a/a/e:RXn	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   75: aload_0
    //   76: getstatic 510	com/tencent/thumbplayer/a/a/a/e$e:RXO	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   79: putfield 333	com/tencent/thumbplayer/a/a/a/e:RXo	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   82: ldc_w 936
    //   85: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: goto -30 -> 58
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	e
    //   91	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	42	91	finally
    //   42	58	91	finally
    //   61	88	91	finally
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(188884);
    this.RVN.info("prepare ");
    this.RXn = e.RXL;
    this.RXo = e.RXL;
    this.mBq.prepare();
    AppMethodBeat.o(188884);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(188885);
    this.RVN.info("prepareAsync ");
    this.RXn = e.RXL;
    this.RXo = e.RXL;
    this.mBq.prepareAsync();
    hmW();
    AppMethodBeat.o(188885);
  }
  
  public final void release()
  {
    try
    {
      AppMethodBeat.i(188890);
      this.RVN.info("release ");
      this.RXz.release();
      hmX();
      hmZ();
      hna();
      this.RXn = e.RXS;
      hmU();
      this.RVZ = null;
      this.RWa = null;
      this.RWb = null;
      this.RWc = null;
      this.RWd = null;
      this.RWe = null;
      this.RWf = null;
      this.RVt = null;
      this.RVN.info("release over.");
      AppMethodBeat.o(188890);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(188889);
      this.RVN.info("reset ");
      this.RXn = e.RXJ;
      this.RXz.reset();
      hmT();
      hmX();
      hmZ();
      hna();
      this.RVN.info("reset over.");
      AppMethodBeat.o(188889);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(188891);
    this.RVN.info("seekTo, position: ".concat(String.valueOf(paramInt)));
    if (this.RXm)
    {
      this.RVN.info("current media is not seekable, ignore");
      AppMethodBeat.o(188891);
      return;
    }
    if (this.RXp)
    {
      if (this.RXB != null) {
        this.RXB.position = paramInt;
      }
      AppMethodBeat.o(188891);
      return;
    }
    this.mBq.seekTo(paramInt);
    AppMethodBeat.o(188891);
  }
  
  @TargetApi(26)
  public final void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(188892);
    this.RVN.info("seekTo, position: " + paramInt1 + ", mode: " + paramInt2);
    if (this.RXm)
    {
      this.RVN.info("current media is not seekable, ignore");
      AppMethodBeat.o(188892);
      return;
    }
    if (this.RXp)
    {
      if (this.RXB != null) {
        this.RXB.position = paramInt1;
      }
      AppMethodBeat.o(188892);
      return;
    }
    MediaPlayer localMediaPlayer = this.mBq;
    if (Build.VERSION.SDK_INT < 26)
    {
      this.RVN.info("os ver is too low, current sdk int:" + Build.VERSION.SDK_INT + ", is less than 26, use seekTo(int positionMs) instead");
      localMediaPlayer.seekTo(paramInt1);
      AppMethodBeat.o(188892);
      return;
    }
    if (paramInt2 == 1) {}
    for (;;)
    {
      long l = paramInt1;
      try
      {
        localMediaPlayer.seekTo(l, i);
        AppMethodBeat.o(188892);
        return;
      }
      catch (Exception localException2)
      {
        this.RVN.r(localException2);
        try
        {
          localMediaPlayer.seekTo(paramInt1);
          AppMethodBeat.o(188892);
          return;
        }
        catch (Exception localException1)
        {
          this.RVN.r(localException1);
          AppMethodBeat.o(188892);
        }
      }
      if (paramInt2 == 2) {
        i = 1;
      } else if (paramInt2 == 3) {
        i = 2;
      }
    }
  }
  
  public final void selectProgram(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188905);
    this.RVN.error("selectProgram, android mediaplayer not support");
    AppMethodBeat.o(188905);
  }
  
  public final void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188882);
    this.RVN.info("selectTrack, trackID:" + paramInt + ", opaque:" + paramLong);
    int i = this.RXx.size();
    int j = this.RXy.size();
    c.e locale = this.RWb;
    if ((paramInt >= 0) && (paramInt < i)) {
      try
      {
        f localf = new f((byte)0);
        localf.RVK = paramLong;
        localf.RXV = paramInt;
        localf.RXU = 2;
        localf.url = this.mUrl;
        a(localf);
        ((b)this.RXx.get(this.RXv)).RXH.isSelected = false;
        ((b)this.RXx.get(paramInt)).RXH.isSelected = true;
        this.RXv = paramInt;
        AppMethodBeat.o(188882);
        return;
      }
      catch (Exception localException1)
      {
        this.RVN.r(localException1);
        if (locale != null) {
          locale.a(4, aqV(-10000), 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(188882);
        return;
      }
    }
    if ((paramInt >= i) && (paramInt < i + j)) {
      try
      {
        this.RXz.reset();
        b localb = (b)this.RXy.get(paramInt - i);
        this.RXz.setDataSource(localb.url);
        this.RXz.prepare();
        AppMethodBeat.o(188882);
        return;
      }
      catch (Exception localException2)
      {
        this.RVN.r(localException2);
        if (locale != null) {
          locale.a(4, aqV(-10000), 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(188882);
        return;
      }
    }
    paramInt -= i + j;
    if (Build.VERSION.SDK_INT < 16)
    {
      this.RVN.error("selectTrack, android mediaplayer not support ");
      if (locale != null) {
        locale.a(4, aqV(-10001), 0L, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(188882);
      return;
    }
    if ((this.RXn != e.RXM) && (this.RXn != e.RXN) && (this.RXn != e.RXO))
    {
      this.RVN.error("selectTrack, illegal state:" + this.RXn);
      AppMethodBeat.o(188882);
      return;
    }
    Object localObject = null;
    try
    {
      MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.mBq.getTrackInfo();
      localObject = arrayOfTrackInfo;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        this.RVN.error("getTrackInfo, android getTrackInfo crash");
      }
      localObject = localObject[paramInt];
      if (localObject.getTrackType() != 2) {
        break label587;
      }
      this.RXw = paramInt;
      for (;;)
      {
        this.mBq.selectTrack(paramInt);
        if (locale != null) {
          locale.a(4, 1000L, 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(188882);
        return;
        if (localObject.getTrackType() != 4) {
          break;
        }
        this.RXu = paramInt;
      }
      if (locale == null) {
        break label629;
      }
      locale.a(4, aqV(-10003), 0L, Long.valueOf(paramLong));
      AppMethodBeat.o(188882);
    }
    if ((localObject == null) || (localObject.length <= paramInt))
    {
      if (locale != null) {
        locale.a(4, aqV(-10002), 0L, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(188882);
      return;
    }
    label587:
    label629:
    return;
  }
  
  public final void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(188895);
    this.RVN.info("setAudioGainRatio, : ".concat(String.valueOf(paramFloat)));
    this.RWT = paramFloat;
    try
    {
      if (this.mBq != null) {
        this.mBq.setVolume(this.RWT, this.RWT);
      }
      AppMethodBeat.o(188895);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.RVN.info("setAudioGainRatio ex : " + localIllegalStateException.toString());
      AppMethodBeat.o(188895);
    }
  }
  
  public final void setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(188896);
    this.RVN.info("setAudioNormalizeVolumeParams not supported.");
    AppMethodBeat.o(188896);
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(188874);
    if (paramParcelFileDescriptor == null)
    {
      this.RVN.info("setDataSource pfd is null ");
      paramParcelFileDescriptor = new IllegalArgumentException("pfd is null");
      AppMethodBeat.o(188874);
      throw paramParcelFileDescriptor;
    }
    this.RVN.info("setDataSource pfd， pfd: " + paramParcelFileDescriptor.toString());
    this.RWS = paramParcelFileDescriptor.getFileDescriptor();
    this.mBq.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
    this.RXc = new com.tencent.thumbplayer.b.c(paramParcelFileDescriptor.getFileDescriptor());
    this.RXn = e.RXK;
    this.RXo = e.RXK;
    AppMethodBeat.o(188874);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(188875);
    paramITPMediaAsset = new IllegalArgumentException("setDataSource by asset, android mediaplayer not support");
    AppMethodBeat.o(188875);
    throw paramITPMediaAsset;
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(188873);
    this.RVN.info("setDataSource httpHeader, url: ".concat(String.valueOf(paramString)));
    this.mUrl = paramString;
    this.jEZ = paramMap;
    paramMap = Uri.parse(this.mUrl);
    this.mBq.setDataSource(this.mContext, paramMap, this.jEZ);
    this.RXc = new com.tencent.thumbplayer.b.c(paramString);
    this.RXn = e.RXK;
    this.RXo = e.RXK;
    AppMethodBeat.o(188873);
  }
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(188898);
    this.RVN.info("setLoopback, : ".concat(String.valueOf(paramBoolean)));
    this.RWP = paramBoolean;
    this.mBq.setLooping(paramBoolean);
    AppMethodBeat.o(188898);
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188899);
    this.RVN.info("setLoopback, : " + paramBoolean + ", loopStart: " + paramLong1 + ", loopEnd: " + paramLong2);
    if ((paramLong1 < 0L) || (paramLong1 > this.RXq) || (paramLong2 > this.RXq))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("position error, must more than 0 and less than duration");
      AppMethodBeat.o(188899);
      throw localIllegalArgumentException;
    }
    this.RWP = paramBoolean;
    this.RWQ = paramLong1;
    this.RWR = paramLong2;
    this.mBq.setLooping(paramBoolean);
    AppMethodBeat.o(188899);
  }
  
  public final void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(188894);
    this.RVN.info("setOutputMute, : ".concat(String.valueOf(paramBoolean)));
    this.mMute = paramBoolean;
    if (paramBoolean) {}
    try
    {
      this.mBq.setVolume(0.0F, 0.0F);
      this.RVN.info("setOutputMute, true");
      AppMethodBeat.o(188894);
      return;
    }
    catch (Exception localException)
    {
      this.RVN.info("setOutputMute, Exception: " + localException.toString());
      AppMethodBeat.o(188894);
    }
    this.mBq.setVolume(this.RWT, this.RWT);
    this.RVN.info("setOutputMute, false, mAudioGain: " + this.RWT);
    AppMethodBeat.o(188894);
    return;
  }
  
  @TargetApi(23)
  public final void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(188897);
    this.RVN.info("setPlaySpeedRatio, : ".concat(String.valueOf(paramFloat)));
    if (Build.VERSION.SDK_INT < 23)
    {
      this.RVN.info("os version is too low: " + Build.VERSION.SDK_INT);
      AppMethodBeat.o(188897);
      return;
    }
    this.RWU = paramFloat;
    this.RVN.info("setPlaySpeedRatio play speed:".concat(String.valueOf(paramFloat)));
    try
    {
      PlaybackParams localPlaybackParams = this.mBq.getPlaybackParams();
      if (localPlaybackParams.getSpeed() != paramFloat)
      {
        localPlaybackParams.setSpeed(paramFloat);
        this.mBq.setPlaybackParams(localPlaybackParams);
      }
      AppMethodBeat.o(188897);
      return;
    }
    catch (Exception localException)
    {
      this.RVN.r(localException);
      AppMethodBeat.o(188897);
    }
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(188865);
    switch (paramTPOptionalParam.getKey())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(188865);
      return;
      this.RWV = ((int)paramTPOptionalParam.getParamLong().value);
      this.RVN.info("setPlayerOptionalParam, start position:" + this.RWV);
      AppMethodBeat.o(188865);
      return;
      this.RWW = paramTPOptionalParam.getParamLong().value;
      this.RVN.info("setPlayerOptionalParam, skip end position:" + this.RWW);
      AppMethodBeat.o(188865);
      return;
      this.RWX = paramTPOptionalParam.getParamLong().value;
      AppMethodBeat.o(188865);
      return;
      this.RWZ = ((int)paramTPOptionalParam.getParamLong().value);
      this.RVN.info("setPlayerOptionalParam, video width:" + this.RWZ);
      AppMethodBeat.o(188865);
      return;
      this.RWY = ((int)paramTPOptionalParam.getParamLong().value);
      this.RVN.info("setPlayerOptionalParam, video height:" + this.RWY);
      AppMethodBeat.o(188865);
      return;
      this.gPs = paramTPOptionalParam.getParamBoolean().value;
      this.RXm = true;
      this.RVN.info("setPlayerOptionalParam, is live:" + this.gPs);
      AppMethodBeat.o(188865);
      return;
      this.RXa = paramTPOptionalParam.getParamBoolean().value;
      AppMethodBeat.o(188865);
      return;
      this.RXf = paramTPOptionalParam.getParamLong().value;
      this.RVN.info("setPlayerOptionalParam, prepare timeout:" + this.RXf + "(ms)");
      AppMethodBeat.o(188865);
      return;
      this.RXj = ((int)((paramTPOptionalParam.getParamLong().value + 400L) / 400L));
      this.RVN.info("setPlayerOptionalParam, buffer timeout:" + paramTPOptionalParam.getParamLong().value + "(ms)");
      AppMethodBeat.o(188865);
      return;
      this.RXi = ((int)(paramTPOptionalParam.getParamLong().value / 400L));
      this.RVN.info("setPlayerOptionalParam, on buffer timeout:" + paramTPOptionalParam.getParamLong().value + "(ms)");
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(188871);
    this.RVN.info("setSurface, surface: ".concat(String.valueOf(paramSurface)));
    this.RVt = paramSurface;
    this.mBq.setSurface(paramSurface);
    this.RVN.info("setSurface over, surface: ".concat(String.valueOf(paramSurface)));
    AppMethodBeat.o(188871);
  }
  
  public final void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(188872);
    this.RVN.info("setSurfaceHolder, sh: ".concat(String.valueOf(paramSurfaceHolder)));
    this.RVt = paramSurfaceHolder;
    this.mBq.setDisplay(paramSurfaceHolder);
    this.RVN.info("setSurfaceHolder over, sh: ".concat(String.valueOf(paramSurfaceHolder)));
    AppMethodBeat.o(188872);
  }
  
  public final void start()
  {
    AppMethodBeat.i(188886);
    this.RVN.info("start ");
    if (this.RXp)
    {
      if (this.RXB != null) {
        this.RXB.RXY = e.RXN;
      }
      this.RVN.warn("system player is busy.");
      AppMethodBeat.o(188886);
      return;
    }
    if ((this.RXn != e.RXM) && (this.RXn != e.RXO))
    {
      this.RVN.warn("start(), illegal state, state:" + this.RXn);
      AppMethodBeat.o(188886);
      return;
    }
    this.mBq.start();
    this.RXn = e.RXN;
    this.RXo = e.RXN;
    if (this.RWU != 1.0D) {
      setPlaySpeedRatio(this.RWU);
    }
    hmY();
    AppMethodBeat.o(188886);
  }
  
  public final void stop()
  {
    try
    {
      AppMethodBeat.i(188888);
      this.RVN.info("stop ");
      hmX();
      hmZ();
      hna();
      this.RXn = e.RXP;
      hmT();
      this.RXv = 0;
      this.RXB = null;
      this.RXu = -1;
      this.RXw = -1;
      this.RXz.stop();
      this.RXA = 0L;
      this.RVN.info("stop over.");
      AppMethodBeat.o(188888);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void updateLoggerContext(com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(188864);
    this.RVN.a(new com.tencent.thumbplayer.f.b(paramb, "TPSystemMediaPlayer"));
    AppMethodBeat.o(188864);
  }
  
  static final class a
  {
    boolean RXF;
    Future<?> RXG;
  }
  
  static final class b
  {
    public TPTrackInfo RXH;
    public String keyId = "";
    public String url = "";
  }
  
  final class d
    implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener
  {
    private d() {}
    
    private int aqW(int paramInt)
    {
      if (e.this.RWZ > 0) {
        paramInt = e.this.RWZ;
      }
      return paramInt;
    }
    
    private int aqX(int paramInt)
    {
      if (e.this.RWY > 0) {
        paramInt = e.this.RWY;
      }
      return paramInt;
    }
    
    public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt) {}
    
    public final void onCompletion(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(188854);
      if (e.this.gPs)
      {
        e.this.RVN.warn("onCompletion, unknown err.");
        AppMethodBeat.o(188854);
        return;
      }
      e.this.RVN.info("onCompletion.");
      e.this.RXn = e.e.RXQ;
      e.this.hmU();
      e.this.hmZ();
      paramMediaPlayer = e.this.RWa;
      if (paramMediaPlayer != null) {
        paramMediaPlayer.onCompletion();
      }
      AppMethodBeat.o(188854);
    }
    
    public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      int j = 2000;
      AppMethodBeat.i(188855);
      if ((e.this.RXn == e.e.RXQ) || (e.this.RXn == e.e.RXP) || (e.this.RXn == e.e.RXS) || (e.this.RXn == e.e.RXJ) || (e.this.RXn == e.e.RXR))
      {
        e.this.RVN.info("onError, illegal state:" + e.this.RXn + ", what:" + paramInt1 + ", extra:" + paramInt2);
        AppMethodBeat.o(188855);
        return true;
      }
      e.this.RVN.info("onError, what: " + paramInt1 + ", extra: " + paramInt2);
      e.this.hmX();
      e.this.hmZ();
      e.this.RXn = e.e.RXR;
      int i = j;
      switch (paramInt2)
      {
      default: 
        i = j;
        switch (paramInt1)
        {
        default: 
          i = j;
        }
        break;
      }
      for (;;)
      {
        e.this.hmU();
        paramMediaPlayer = e.this.RWc;
        if (paramMediaPlayer != null) {
          paramMediaPlayer.a(i, e.aqV(paramInt1), paramInt2, 0L);
        }
        AppMethodBeat.o(188855);
        return true;
        i = 2001;
        continue;
        i = 2001;
      }
    }
    
    public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(188856);
      e.this.RVN.info("mediaplayer, onInfo. what:" + paramInt1 + ", extra:" + paramInt2);
      paramInt2 = -1;
      e locale;
      switch (paramInt1)
      {
      default: 
        paramInt1 = -1;
        if (paramInt1 != -1)
        {
          if ((200 != paramInt1) && (201 != paramInt1)) {
            break label395;
          }
          if (!e.this.hnb())
          {
            if (200 != paramInt1) {
              break label377;
            }
            e.this.RXs = true;
            locale = e.this;
          }
        }
        break;
      }
      for (;;)
      {
        synchronized (locale.RXk)
        {
          if (locale.RXl == null) {
            locale.RXl = j.getScheduledExecutorServiceInstance().schedule(new e.5(locale), locale.RXj * 400, TimeUnit.MILLISECONDS);
          }
          if (e.this.RWb != null) {
            e.this.RWb.a(paramInt1, 0L, 0L, null);
          }
          if (paramInt1 == 106)
          {
            paramInt1 = aqW(paramMediaPlayer.getVideoWidth());
            paramInt2 = aqX(paramMediaPlayer.getVideoHeight());
            if (((paramInt2 != e.this.mVideoHeight) || (paramInt1 != e.this.mVideoWidth)) && (paramInt2 > 0) && (paramInt1 > 0))
            {
              e.this.mVideoHeight = paramInt2;
              e.this.mVideoWidth = paramInt1;
              if (e.this.RWe != null) {
                e.this.RWe.aI(e.this.mVideoWidth, e.this.mVideoHeight);
              }
            }
          }
          AppMethodBeat.o(188856);
          return true;
          paramInt1 = 200;
          break;
          paramInt1 = 201;
          break;
          paramInt1 = 106;
          break;
          e.this.RXm = true;
          paramInt1 = paramInt2;
        }
        label377:
        e.this.RXs = false;
        e.this.hna();
        continue;
        label395:
        if (e.this.RWb != null) {
          e.this.RWb.a(106, 0L, 0L, null);
        }
      }
    }
    
    public final void onPrepared(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(188853);
      if (e.this.RXn != e.e.RXL)
      {
        e.this.RVN.info("onPrepared() is called in a wrong situation, mState = " + e.this.RXn);
        AppMethodBeat.o(188853);
        return;
      }
      e.this.RXo = e.e.RXM;
      long l = e.this.mBq.getDuration();
      if (l <= 0L) {
        e.this.RXm = true;
      }
      e.this.RVN.info("onPrepared() , mStartPositionMs=" + e.this.RWV + ", duration:" + l + ", mIsLive:" + e.this.gPs);
      e.this.hmX();
      e.this.hmV();
      AppMethodBeat.o(188853);
    }
    
    public final void onSeekComplete(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(188857);
      if (e.this.mBq == null)
      {
        AppMethodBeat.o(188857);
        return;
      }
      e.this.RVN.info("onSeekComplete().");
      if ((e.e.RXM != e.this.RXn) && (e.this.RWd != null)) {
        e.this.RWd.cJH();
      }
      AppMethodBeat.o(188857);
    }
    
    public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(188858);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        e.this.RVN.error("onVideoSizeChanged() size error, width:" + paramInt1 + " height:" + paramInt2);
        AppMethodBeat.o(188858);
        return;
      }
      paramInt1 = aqW(paramInt1);
      paramInt2 = aqX(paramInt2);
      try
      {
        if (((paramInt1 != e.this.mVideoWidth) || (paramInt2 != e.this.mVideoHeight)) && (paramInt2 > 0) && (paramInt1 > 0)) {
          e.this.RWe.aI(paramInt1, paramInt2);
        }
      }
      catch (Exception paramMediaPlayer)
      {
        for (;;)
        {
          e.this.RVN.warn(paramMediaPlayer.toString());
        }
      }
      e.this.mVideoWidth = paramInt1;
      e.this.mVideoHeight = paramInt2;
      e.this.RVN.info("onVideoSizeChanged(), width:" + paramInt1 + " height:" + paramInt2);
      AppMethodBeat.o(188858);
    }
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(188861);
      RXJ = new e("IDLE", 0);
      RXK = new e("INITIALIZED", 1);
      RXL = new e("PREPARING", 2);
      RXM = new e("PREPARED", 3);
      RXN = new e("STARTED", 4);
      RXO = new e("PAUSED", 5);
      RXP = new e("STOPPED", 6);
      RXQ = new e("COMPLETE", 7);
      RXR = new e("ERROR", 8);
      RXS = new e("RELEASE", 9);
      RXT = new e[] { RXJ, RXK, RXL, RXM, RXN, RXO, RXP, RXQ, RXR, RXS };
      AppMethodBeat.o(188861);
    }
    
    private e() {}
  }
  
  static final class f
  {
    long RVK;
    int RXU;
    int RXV;
    int RXW;
    int RXX;
    e.e RXY;
    long position;
    String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */