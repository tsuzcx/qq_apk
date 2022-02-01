package com.tencent.thumbplayer.a.a.a;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
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
import com.tencent.thumbplayer.api.TPCommonEnum.TPSurfaceType;
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
  boolean IBH;
  com.tencent.thumbplayer.f.a ahDA;
  private c.f ahDM;
  c.c ahDN;
  c.e ahDO;
  c.d ahDP;
  c.g ahDQ;
  c.m ahDR;
  c.i ahDS;
  private Object ahDg;
  boolean ahEB;
  long ahEC;
  long ahED;
  private FileDescriptor ahEE;
  private AssetFileDescriptor ahEF;
  private float ahEG;
  private float ahEH;
  int ahEI;
  long ahEJ;
  private long ahEK;
  int ahEL;
  int ahEM;
  private boolean ahEN;
  private d ahEO;
  private com.tencent.thumbplayer.b.c ahEP;
  private Future<?> ahEQ;
  private final Object ahER;
  private long ahES;
  private a ahET;
  private final Object ahEU;
  int ahEV;
  int ahEW;
  final Object ahEX;
  Future<?> ahEY;
  boolean ahEZ;
  volatile e ahFa;
  volatile e ahFb;
  private boolean ahFc;
  long ahFd;
  long ahFe;
  volatile boolean ahFf;
  int ahFg;
  int ahFh;
  private int ahFi;
  private int ahFj;
  private List<b> ahFk;
  private List<b> ahFl;
  private a ahFm;
  long ahFn;
  private f ahFo;
  private MediaPlayer.OnTimedTextListener ahFp;
  private Context mContext;
  private boolean mMute;
  private String mUrl;
  int mVideoHeight;
  int mVideoWidth;
  private Map<String, String> ppb;
  volatile MediaPlayer sFf;
  
  public e(Context paramContext, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(228696);
    this.ahEB = false;
    this.ahEC = 0L;
    this.ahED = 0L;
    this.mMute = false;
    this.ahEG = 1.0F;
    this.ahEH = 1.0F;
    this.ahEI = 0;
    this.ahEJ = -1L;
    this.IBH = false;
    this.ahEK = -1L;
    this.ahEL = -1;
    this.ahEM = -1;
    this.ahEN = true;
    this.ahEQ = null;
    this.ahER = new Object();
    this.ahES = 25000L;
    this.ahEU = new Object();
    this.ahEV = 3;
    this.ahEW = 30;
    this.ahEX = new Object();
    this.ahEY = null;
    this.ahEZ = false;
    this.ahFc = false;
    this.ahFd = 0L;
    this.ahFe = -1L;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.ahFf = false;
    this.ahFg = 0;
    this.ahFh = -1;
    this.ahFi = 0;
    this.ahFj = -1;
    this.ahFk = new ArrayList();
    this.ahFl = new ArrayList();
    this.ahFn = 0L;
    this.ahFo = null;
    this.ahFp = new MediaPlayer.OnTimedTextListener()
    {
      public final void onTimedText(MediaPlayer paramAnonymousMediaPlayer, TimedText paramAnonymousTimedText)
      {
        AppMethodBeat.i(228582);
        TPSubtitleData localTPSubtitleData;
        if (e.this.ahDS != null)
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
          localTPSubtitleData.trackIndex = e.this.ahFh;
          localTPSubtitleData.startPositionMs = e.this.getCurrentPositionMs();
          e.this.ahDS.a(localTPSubtitleData);
          AppMethodBeat.o(228582);
          return;
        }
      }
    };
    this.ahDA = new com.tencent.thumbplayer.f.a(paramb, "TPSystemMediaPlayer");
    this.mContext = paramContext;
    this.ahEO = new d((byte)0);
    paramContext = new b((byte)0);
    paramContext.ahFu = new TPTrackInfo();
    paramContext.ahFu.isSelected = true;
    paramContext.ahFu.name = "audio_1";
    this.ahFk.add(paramContext);
    paramContext = new b();
    if (Build.VERSION.SDK_INT <= 19) {
      a(paramContext);
    }
    paramContext.setOnPreparedListener(this.ahEO);
    paramContext.setOnCompletionListener(this.ahEO);
    paramContext.setOnErrorListener(this.ahEO);
    paramContext.setOnInfoListener(this.ahEO);
    paramContext.setOnBufferingUpdateListener(this.ahEO);
    paramContext.setOnSeekCompleteListener(this.ahEO);
    paramContext.setOnVideoSizeChangedListener(this.ahEO);
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.setOnTimedTextListener(this.ahFp);
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramContext.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
    }
    for (;;)
    {
      this.sFf = paramContext;
      this.ahFa = e.ahFw;
      this.ahFb = e.ahFw;
      this.ahFm = new c();
      this.ahFm.a(new a.a()
      {
        public final void a(a.c paramAnonymousc)
        {
          AppMethodBeat.i(228609);
          TPSubtitleData localTPSubtitleData = new TPSubtitleData();
          localTPSubtitleData.subtitleData = paramAnonymousc.text;
          paramAnonymousc = e.this.ahDS;
          if (paramAnonymousc != null) {
            paramAnonymousc.a(localTPSubtitleData);
          }
          AppMethodBeat.o(228609);
        }
      });
      this.ahFm.a(new a.b()
      {
        public final long getCurrentPosition()
        {
          AppMethodBeat.i(228606);
          if ((e.this.ahFa != e.e.ahFB) && (e.this.ahFa != e.e.ahFA))
          {
            AppMethodBeat.o(228606);
            return -1L;
          }
          long l = e.this.getCurrentPositionMs();
          AppMethodBeat.o(228606);
          return l;
        }
      });
      AppMethodBeat.o(228696);
      return;
      paramContext.setAudioStreamType(3);
    }
  }
  
  private void a(AssetFileDescriptor paramAssetFileDescriptor)
  {
    AppMethodBeat.i(228705);
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.sFf.setDataSource(paramAssetFileDescriptor);
      AppMethodBeat.o(228705);
      return;
    }
    this.sFf.setDataSource(paramAssetFileDescriptor.getFileDescriptor(), paramAssetFileDescriptor.getStartOffset(), paramAssetFileDescriptor.getLength());
    AppMethodBeat.o(228705);
  }
  
  private void a(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(228676);
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
      AppMethodBeat.o(228676);
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      this.ahDA.error("mediaPlayerExceptionHook, " + Log.getStackTraceString(paramMediaPlayer));
      AppMethodBeat.o(228676);
    }
  }
  
  private void a(f paramf)
  {
    label782:
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      int i;
      try
      {
        AppMethodBeat.i(228728);
        localObject1 = paramf.url;
        paramf.position = getCurrentPositionMs();
        paramf.ahFL = this.ahFa;
        paramf.ahFJ = this.ahFj;
        paramf.ahFK = this.ahFh;
        this.ahDA.bGe("playerResetStart, pos:" + paramf.position + ", state:" + paramf.ahFL);
        this.ahFc = true;
        jZT();
        jZV();
        jZW();
        jZQ();
        localObject2 = new b();
        if (Build.VERSION.SDK_INT <= 19) {
          a((MediaPlayer)localObject2);
        }
        ((MediaPlayer)localObject2).setOnPreparedListener(this.ahEO);
        ((MediaPlayer)localObject2).setOnCompletionListener(this.ahEO);
        ((MediaPlayer)localObject2).setOnErrorListener(this.ahEO);
        ((MediaPlayer)localObject2).setOnInfoListener(this.ahEO);
        ((MediaPlayer)localObject2).setOnBufferingUpdateListener(this.ahEO);
        ((MediaPlayer)localObject2).setOnSeekCompleteListener(this.ahEO);
        ((MediaPlayer)localObject2).setOnVideoSizeChangedListener(this.ahEO);
        if (Build.VERSION.SDK_INT >= 16) {
          ((MediaPlayer)localObject2).setOnTimedTextListener(this.ahFp);
        }
        if (Build.VERSION.SDK_INT >= 26)
        {
          ((MediaPlayer)localObject2).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
          if (this.mMute)
          {
            this.sFf.setVolume(0.0F, 0.0F);
            if (this.ahEH != 1.0D) {
              setPlaySpeedRatio(this.ahEH);
            }
            if (this.ahEB) {
              this.sFf.setLooping(this.ahEB);
            }
            this.sFf = ((MediaPlayer)localObject2);
            this.ahFb = e.ahFw;
            if (this.ahEE == null) {
              break label536;
            }
            this.sFf.setDataSource(this.ahEE);
            this.ahFb = e.ahFx;
            if (this.ahDg != null) {
              break label728;
            }
            this.sFf.setDisplay(null);
            localObject1 = this.ahFo;
            if ((localObject1 != null) && (((f)localObject1).ahFH != paramf.ahFH))
            {
              localObject2 = this.ahDO;
              if (((f)localObject1).ahFH != 1) {
                break label782;
              }
              i = 3;
              if (localObject2 != null) {
                ((c.e)localObject2).a(i, ((f)localObject1).ahDx, 0L, null);
              }
              paramf.ahFL = ((f)localObject1).ahFL;
              paramf.position = ((f)localObject1).position;
            }
            this.ahFo = paramf;
            if ((paramf.ahFL == e.ahFy) || (paramf.ahFL == e.ahFz) || (paramf.ahFL == e.ahFA) || (paramf.ahFL == e.ahFB))
            {
              this.sFf.prepareAsync();
              this.ahFa = e.ahFy;
              this.ahFb = e.ahFy;
              jZS();
            }
            AppMethodBeat.o(228728);
          }
        }
        else
        {
          ((MediaPlayer)localObject2).setAudioStreamType(3);
          continue;
        }
        if (this.ahEG == 1.0F) {
          continue;
        }
      }
      finally {}
      this.sFf.setVolume(this.ahEG, this.ahEG);
      continue;
      label536:
      if (this.ahEF != null)
      {
        a(this.ahEF);
      }
      else
      {
        i = paramf.ahFI;
        if (i > 0)
        {
          localObject2 = (b)this.ahFk.get(i);
          c.e locale = this.ahDO;
          if (locale != null)
          {
            TPPlayerMsg.TPAudioTrackInfo localTPAudioTrackInfo = new TPPlayerMsg.TPAudioTrackInfo();
            localTPAudioTrackInfo.audioTrackUrl = ((b)localObject2).url;
            localTPAudioTrackInfo.keyId = ((b)localObject2).keyId;
            this.ahDA.bGe("handleDataSource, audioTrack url:" + localTPAudioTrackInfo.audioTrackUrl + ", keyId:" + localTPAudioTrackInfo.keyId);
            locale.a(1011, 0L, 0L, localTPAudioTrackInfo);
          }
        }
        if ((this.ppb != null) && (!this.ppb.isEmpty()))
        {
          localObject1 = Uri.parse((String)localObject1);
          this.sFf.setDataSource(this.mContext, (Uri)localObject1, this.ppb);
        }
        else
        {
          this.sFf.setDataSource((String)localObject1);
          continue;
          label728:
          if ((this.ahDg instanceof SurfaceHolder))
          {
            this.sFf.setDisplay((SurfaceHolder)this.ahDg);
          }
          else if ((this.ahDg instanceof Surface))
          {
            this.sFf.setSurface((Surface)this.ahDg);
            continue;
            i = 4;
          }
        }
      }
    }
  }
  
  static int aHu(int paramInt)
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
  
  private void jZP()
  {
    AppMethodBeat.i(228711);
    e locale = this.ahFb;
    if ((locale == e.ahFz) || (locale == e.ahFA) || (locale == e.ahFB)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.ahFb = e.ahFC;
        this.ahDA.bGe("MediaPlayer stop.");
        this.sFf.stop();
      }
      AppMethodBeat.o(228711);
      return;
    }
  }
  
  private void jZS()
  {
    AppMethodBeat.i(228736);
    this.ahDA.bGe("startCheckPrepareTimeoutTimer");
    synchronized (this.ahER)
    {
      if (this.ahEQ == null) {
        this.ahEQ = j.getScheduledExecutorServiceInstance().schedule(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(228605);
            if (e.this.ahFa == e.e.ahFy)
            {
              e.this.ahDA.error("startCheckPrepareTimeoutTimer, post error");
              e.this.ahFa = e.e.ahFE;
              e.this.jZQ();
              e.this.jZT();
              c.d locald = e.this.ahDP;
              if (locald != null) {
                locald.a(2001, e.aHu(-110), 0L, 0L);
              }
            }
            AppMethodBeat.o(228605);
          }
        }, this.ahES, TimeUnit.MILLISECONDS);
      }
      AppMethodBeat.o(228736);
      return;
    }
  }
  
  private void jZU()
  {
    AppMethodBeat.i(228753);
    synchronized (this.ahEU)
    {
      if (!jZX())
      {
        this.ahDA.bGe("startCheckBufferingTimer, forbidden check buffer by position");
        AppMethodBeat.o(228753);
        return;
      }
      if (this.ahET == null)
      {
        this.ahET = new a((byte)0);
        final a locala = this.ahET;
        this.ahET.ahFs = false;
        this.ahET.ahFt = j.getScheduledExecutorServiceInstance().schedule(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(228589);
            if (!locala.ahFs)
            {
              Object localObject1 = e.this;
              long l1 = ((e)localObject1).getCurrentPositionMs();
              long l2 = ((e)localObject1).ahFe;
              ((e)localObject1).ahFe = l1;
              if (((e)localObject1).ahFa != e.e.ahFA) {
                if ((((e)localObject1).ahFa == e.e.ahFB) && (((e)localObject1).ahFf))
                {
                  ((e)localObject1).ahDA.bGe("checkBuffingEvent, pause state and send end buffering");
                  ((e)localObject1).ahFf = false;
                  ((e)localObject1).ahFg = 0;
                  localObject1 = ((e)localObject1).ahDO;
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
                if (localInterruptedException.ahEB) {
                  if ((localInterruptedException.ahED > 0L) && (l1 >= localInterruptedException.ahED) && (!localInterruptedException.ahEZ))
                  {
                    localInterruptedException.ahDA.bGe("checkBuffingEvent, loopback skip end, curPosition:" + l1 + ", mLoopStartPositionMs:" + localInterruptedException.ahEC);
                    localInterruptedException.sFf.seekTo((int)localInterruptedException.ahEC);
                  }
                }
                c.e locale;
                while ((((e)localObject2).ahEJ <= 0L) || (l1 < ((e)localObject2).getDurationMs() - ((e)localObject2).ahEJ))
                {
                  if (l1 != l2) {
                    localInterruptedException.ahFn += 1L;
                  }
                  if ((l1 != l2) || (l1 <= 0L)) {
                    break label528;
                  }
                  int i = localInterruptedException.ahFg + 1;
                  localInterruptedException.ahFg = i;
                  if ((i >= localInterruptedException.ahEV) && (!localInterruptedException.ahFf))
                  {
                    localInterruptedException.ahFf = true;
                    localInterruptedException.ahDA.bGe("checkBuffingEvent, position no change,send start buffering");
                    locale = localInterruptedException.ahDO;
                    if (locale != null) {
                      locale.a(200, l1, localInterruptedException.ahFd, Long.valueOf(localInterruptedException.ahFn));
                    }
                  }
                  if (localInterruptedException.ahFg < localInterruptedException.ahEW) {
                    break;
                  }
                  localInterruptedException.ahDA.error("checkBuffingEvent post error");
                  localInterruptedException.ahFa = e.e.ahFE;
                  localInterruptedException.jZQ();
                  localInterruptedException.ahFf = false;
                  localInterruptedException.jZV();
                  localObject2 = localInterruptedException.ahDP;
                  if (localObject2 == null) {
                    break;
                  }
                  ((c.d)localObject2).a(2001, e.aHu(-110), 0L, 0L);
                  break;
                }
                ((e)localObject2).ahDA.bGe("checkBuffingEvent, skip end, mBaseDuration: " + ((e)localObject2).ahFd + ", curPosition:" + l1 + ", mSkipEndMilsec:" + ((e)localObject2).ahEJ);
                ((e)localObject2).ahFa = e.e.ahFD;
                ((e)localObject2).jZQ();
                ((e)localObject2).jZV();
                Object localObject2 = ((e)localObject2).ahDN;
                if (localObject2 != null)
                {
                  ((c.c)localObject2).onCompletion();
                  continue;
                  label528:
                  if (((e)localObject2).ahFf)
                  {
                    ((e)localObject2).ahDA.bGe("checkBuffingEvent, position change, send end buffering");
                    locale = ((e)localObject2).ahDO;
                    if (locale != null) {
                      locale.a(201, l1, ((e)localObject2).ahFd, Long.valueOf(((e)localObject2).ahFn));
                    }
                  }
                  ((e)localObject2).ahFf = false;
                  ((e)localObject2).ahFg = 0;
                }
              }
            }
            AppMethodBeat.o(228589);
          }
        }, 0L, TimeUnit.MILLISECONDS);
      }
      AppMethodBeat.o(228753);
      return;
    }
  }
  
  public final void N(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(229013);
    this.ahDA.bGe("switchDefinition, defUrl: ".concat(String.valueOf(paramString)));
    if (TextUtils.isEmpty(paramString))
    {
      this.ahDA.bGe("switchDefinition, defUrl is null");
      AppMethodBeat.o(229013);
      return;
    }
    this.mUrl = paramString;
    f localf = new f((byte)0);
    localf.ahDx = paramLong;
    localf.ahFI = this.ahFi;
    localf.ahFH = 1;
    localf.url = paramString;
    try
    {
      a(localf);
      AppMethodBeat.o(229013);
      return;
    }
    catch (Exception paramString)
    {
      paramString = new IllegalStateException("playerResetStart");
      AppMethodBeat.o(229013);
      throw paramString;
    }
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(228836);
    parama = new IllegalStateException("system Mediaplayer cannot support audio frame out");
    AppMethodBeat.o(228836);
    throw parama;
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(228853);
    paramb = new IllegalStateException("system Mediaplayer cannot support audio postprocess frame out");
    AppMethodBeat.o(228853);
    throw paramb;
  }
  
  public final void a(c.c paramc)
  {
    this.ahDN = paramc;
  }
  
  public final void a(c.d paramd)
  {
    this.ahDP = paramd;
  }
  
  public final void a(c.e parame)
  {
    this.ahDO = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.ahDM = paramf;
  }
  
  public final void a(c.g paramg)
  {
    this.ahDQ = paramg;
  }
  
  public final void a(c.i parami)
  {
    this.ahDS = parami;
  }
  
  public final void a(c.j paramj)
  {
    AppMethodBeat.i(228817);
    paramj = new IllegalStateException("system Mediaplayer cannot support subtitle frame out");
    AppMethodBeat.o(228817);
    throw paramj;
  }
  
  public final void a(c.k paramk)
  {
    AppMethodBeat.i(228826);
    paramk = new IllegalStateException("system Mediaplayer cannot support video frame out");
    AppMethodBeat.o(228826);
    throw paramk;
  }
  
  public final void a(c.l paraml)
  {
    AppMethodBeat.i(228846);
    paraml = new IllegalStateException("system Mediaplayer cannot support video postprocess frame out");
    AppMethodBeat.o(228846);
    throw paraml;
  }
  
  public final void a(c.m paramm)
  {
    this.ahDR = paramm;
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong) {}
  
  public final void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(228924);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      this.ahDA.error("addSubtitleSource, illegal argument.");
      AppMethodBeat.o(228924);
      return;
    }
    paramString2 = new TPTrackInfo();
    paramString2.name = paramString3;
    paramString2.isExclusive = true;
    paramString2.isInternal = false;
    paramString2.isSelected = false;
    paramString2.trackType = 3;
    b localb = new b((byte)0);
    localb.ahFu = paramString2;
    localb.url = paramString1;
    this.ahDA.bGe("addSubtitleSource, name:" + paramString2.name + ", url:" + paramString3);
    this.ahFl.add(localb);
    AppMethodBeat.o(228924);
  }
  
  public final void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(229142);
    if (this.ahEP != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = paramTPCaptureParams.width;
      localTPImageGeneratorParams.height = paramTPCaptureParams.height;
      localTPImageGeneratorParams.format = paramTPCaptureParams.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = paramTPCaptureParams.requestedTimeMsToleranceBefore;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = paramTPCaptureParams.requestedTimeMsToleranceAfter;
      this.ahEP.a(getCurrentPositionMs(), localTPImageGeneratorParams, paramTPCaptureCallBack);
      AppMethodBeat.o(229142);
      return;
    }
    paramTPCaptureCallBack.onCaptureVideoFailed(1000013);
    AppMethodBeat.o(229142);
  }
  
  public final void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228975);
    if (Build.VERSION.SDK_INT < 16)
    {
      this.ahDA.error("deselectTrack, android mediaplayer not support ");
      AppMethodBeat.o(228975);
      return;
    }
    this.sFf.deselectTrack(paramInt);
    AppMethodBeat.o(228975);
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(229084);
    if (this.IBH)
    {
      AppMethodBeat.o(229084);
      return 0L;
    }
    if ((this.ahFc) || (this.ahFa == e.ahFE))
    {
      if (this.ahFe == -1L)
      {
        l = this.ahEI;
        AppMethodBeat.o(229084);
        return l;
      }
      l = this.ahFe;
      AppMethodBeat.o(229084);
      return l;
    }
    if ((this.ahFa == e.ahFw) || (this.ahFa == e.ahFx) || (this.ahFa == e.ahFy) || (this.ahFa == e.ahFC) || (this.ahFa == e.ahFz))
    {
      l = this.ahEI;
      AppMethodBeat.o(229084);
      return l;
    }
    long l = this.sFf.getCurrentPosition();
    AppMethodBeat.o(229084);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(229071);
    if (this.IBH)
    {
      AppMethodBeat.o(229071);
      return 0L;
    }
    long l;
    if (this.ahFc)
    {
      l = this.ahFd;
      AppMethodBeat.o(229071);
      return l;
    }
    if ((this.ahFa != e.ahFz) && (this.ahFa != e.ahFA) && (this.ahFa != e.ahFB))
    {
      AppMethodBeat.o(229071);
      return -1L;
    }
    if (this.ahFd <= 0L) {
      this.ahFd = this.sFf.getDuration();
    }
    if (this.ahEK > 0L)
    {
      if (this.ahFd > 0L) {
        break label141;
      }
      this.ahFd = this.ahEK;
    }
    for (;;)
    {
      l = this.ahFd;
      AppMethodBeat.o(229071);
      return l;
      label141:
      if (Math.abs(this.ahEK - this.ahFd) * 100L / this.ahEK > 1L) {
        this.ahFd = this.ahEK;
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
  
  public final TPTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(229121);
    if (((this.ahFa == e.ahFz) || (this.ahFa == e.ahFA) || (this.ahFa == e.ahFB)) && (com.tencent.thumbplayer.utils.b.SDK_INT > 16)) {}
    Object localObject;
    for (;;)
    {
      try
      {
        MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.sFf.getTrackInfo();
        if ((arrayOfTrackInfo != null) || (!this.ahFk.isEmpty()) || (!this.ahFl.isEmpty())) {
          break;
        }
        AppMethodBeat.o(229121);
        return new TPTrackInfo[0];
      }
      catch (Exception localException)
      {
        this.ahDA.error("getTrackInfo, android getTrackInfo crash");
      }
      localObject = null;
    }
    int j = this.ahFk.size();
    int k = this.ahFl.size();
    if (localObject == null) {}
    TPTrackInfo[] arrayOfTPTrackInfo;
    for (int i = 0;; i = localObject.length)
    {
      arrayOfTPTrackInfo = new TPTrackInfo[i + (k + j)];
      localIterator = this.ahFk.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        arrayOfTPTrackInfo[i] = ((b)localIterator.next()).ahFu;
        i += 1;
      }
    }
    Iterator localIterator = this.ahFl.iterator();
    while (localIterator.hasNext())
    {
      arrayOfTPTrackInfo[i] = ((b)localIterator.next()).ahFu;
      i += 1;
    }
    if ((localObject == null) || (localObject.length <= 0))
    {
      AppMethodBeat.o(229121);
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
    AppMethodBeat.o(229121);
    return arrayOfTPTrackInfo;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(229107);
    this.ahDA.bGe("getVideoHeight, height:" + this.mVideoHeight);
    int i = this.mVideoHeight;
    AppMethodBeat.o(229107);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(229098);
    this.ahDA.bGe("getVideoWidth, width:" + this.mVideoWidth);
    int i = this.mVideoWidth;
    AppMethodBeat.o(229098);
    return i;
  }
  
  public final void j(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    AppMethodBeat.i(228934);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      this.ahDA.error("addAudioTrackSource, illegal argument.");
      AppMethodBeat.o(228934);
      return;
    }
    TPTrackInfo localTPTrackInfo = new TPTrackInfo();
    localTPTrackInfo.name = paramString2;
    localTPTrackInfo.isExclusive = true;
    localTPTrackInfo.isInternal = false;
    localTPTrackInfo.isSelected = false;
    localTPTrackInfo.trackType = 2;
    b localb = new b((byte)0);
    localb.ahFu = localTPTrackInfo;
    localb.url = paramString1;
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramList = (TPOptionalParam)paramString1.next();
      if (paramList.getKey() == 6) {
        localb.keyId = paramList.getParamString().value;
      }
    }
    this.ahDA.bGe("addAudioTrackSource, name:" + localTPTrackInfo.name + ", url:" + paramString2);
    this.ahFk.add(localb);
    AppMethodBeat.o(228934);
  }
  
  final void jZQ()
  {
    AppMethodBeat.i(228941);
    this.sFf.setOnPreparedListener(null);
    this.sFf.setOnCompletionListener(null);
    this.sFf.setOnErrorListener(null);
    this.sFf.setOnInfoListener(null);
    this.sFf.setOnBufferingUpdateListener(null);
    this.sFf.setOnSeekCompleteListener(null);
    this.sFf.setOnVideoSizeChangedListener(null);
    jZP();
    if (this.ahFb != e.ahFF) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.ahFb = e.ahFF;
        this.ahDA.bGe("MediaPlayer release.");
        this.sFf.release();
      }
      AppMethodBeat.o(228941);
      return;
    }
  }
  
  final void jZR()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(228955);
        Object localObject1 = this.ahFo;
        this.ahDA.bGe("playerResetEnd, actionInfo:" + localObject1 + ", mSuspend:" + this.ahFc);
        if ((localObject1 == null) || (!this.ahFc)) {
          break label464;
        }
        c.e locale = this.ahDO;
        int i;
        if (((f)localObject1).ahFH == 1)
        {
          i = 3;
          if (locale != null) {
            locale.a(i, 1000L, 0L, Long.valueOf(((f)localObject1).ahDx));
          }
          if (Build.VERSION.SDK_INT >= 16)
          {
            if (((f)localObject1).ahFJ > 0) {
              this.sFf.selectTrack(((f)localObject1).ahFJ);
            }
            if (((f)localObject1).ahFK > 0) {
              this.sFf.selectTrack(((f)localObject1).ahFK);
            }
          }
          if ((((f)localObject1).position > 0L) && (!this.ahEZ)) {
            this.ahDA.bGe("playerResetEnd, onPrepared(), and seek to:" + ((f)localObject1).position);
          }
        }
        try
        {
          this.sFf.seekTo((int)((f)localObject1).position);
          this.ahDA.bGe("playerResetEnd, restore state:" + ((f)localObject1).ahFL);
          if ((((f)localObject1).ahFL == e.ahFw) || (((f)localObject1).ahFL == e.ahFx) || (((f)localObject1).ahFL == e.ahFy))
          {
            this.ahFa = e.ahFz;
            localObject1 = this.ahDM;
            if (localObject1 != null) {
              ((c.f)localObject1).Qz();
            }
            this.ahFc = false;
            this.ahFo = null;
            AppMethodBeat.o(228955);
            return;
            i = 4;
          }
        }
        catch (Exception localException2)
        {
          this.ahDA.p(localException2);
          continue;
        }
        if (localObject2.ahFL == e.ahFz) {
          break label337;
        }
      }
      finally {}
      if (localObject2.ahFL == e.ahFB)
      {
        label337:
        this.ahFa = localObject2.ahFL;
        continue;
      }
      if (localObject2.ahFL == e.ahFA)
      {
        this.ahDA.bGe("playerResetEnd,  MediaPlayer.start().");
        this.sFf.start();
        this.ahFa = localObject2.ahFL;
        this.ahFb = e.ahFA;
        jZU();
        continue;
      }
      this.ahDA.error("illegal state, state:" + localObject2.ahFL);
      this.ahFa = e.ahFE;
      jZQ();
      Object localObject3 = this.ahDP;
      if (localObject3 == null) {
        continue;
      }
      ((c.d)localObject3).a(2000, aHu(-10004), 0L, 0L);
      continue;
      label464:
      if ((this.ahEI > 0) && (!this.ahEZ)) {
        this.ahDA.bGe("onPrepared(), and seekto:" + this.ahEI);
      }
      try
      {
        this.sFf.seekTo(this.ahEI);
        this.ahFa = e.ahFz;
        localObject3 = this.ahDM;
        if (localObject3 != null) {
          ((c.f)localObject3).Qz();
        }
        AppMethodBeat.o(228955);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          this.ahDA.p(localException1);
        }
      }
    }
  }
  
  /* Error */
  final void jZT()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 948
    //   5: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 168	com/tencent/thumbplayer/a/a/a/e:ahER	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 166	com/tencent/thumbplayer/a/a/a/e:ahEQ	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 166	com/tencent/thumbplayer/a/a/a/e:ahEQ	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 954 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 166	com/tencent/thumbplayer/a/a/a/e:ahEQ	Ljava/util/concurrent/Future;
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc_w 948
    //   43: invokestatic 350	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: ldc_w 948
    //   55: invokestatic 350	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2	15	60	finally
    //   40	46	60	finally
    //   50	60	60	finally
  }
  
  /* Error */
  final void jZV()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 955
    //   5: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 174	com/tencent/thumbplayer/a/a/a/e:ahEU	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 633	com/tencent/thumbplayer/a/a/a/e:ahET	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   19: ifnull +48 -> 67
    //   22: aload_0
    //   23: getfield 633	com/tencent/thumbplayer/a/a/a/e:ahET	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   26: iconst_1
    //   27: putfield 637	com/tencent/thumbplayer/a/a/a/e$a:ahFs	Z
    //   30: aload_0
    //   31: getfield 633	com/tencent/thumbplayer/a/a/a/e:ahET	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   34: getfield 643	com/tencent/thumbplayer/a/a/a/e$a:ahFt	Ljava/util/concurrent/Future;
    //   37: ifnull +17 -> 54
    //   40: aload_0
    //   41: getfield 633	com/tencent/thumbplayer/a/a/a/e:ahET	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   44: getfield 643	com/tencent/thumbplayer/a/a/a/e$a:ahFt	Ljava/util/concurrent/Future;
    //   47: iconst_1
    //   48: invokeinterface 954 2 0
    //   53: pop
    //   54: aload_0
    //   55: getfield 633	com/tencent/thumbplayer/a/a/a/e:ahET	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   58: aconst_null
    //   59: putfield 643	com/tencent/thumbplayer/a/a/a/e$a:ahFt	Ljava/util/concurrent/Future;
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 633	com/tencent/thumbplayer/a/a/a/e:ahET	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   67: aload_1
    //   68: monitorexit
    //   69: ldc_w 955
    //   72: invokestatic 350	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_2
    //   79: aload_1
    //   80: monitorexit
    //   81: ldc_w 955
    //   84: invokestatic 350	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2	15	89	finally
    //   69	75	89	finally
    //   79	89	89	finally
  }
  
  /* Error */
  final void jZW()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 956
    //   5: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 180	com/tencent/thumbplayer/a/a/a/e:ahEX	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 182	com/tencent/thumbplayer/a/a/a/e:ahEY	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 182	com/tencent/thumbplayer/a/a/a/e:ahEY	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 954 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 182	com/tencent/thumbplayer/a/a/a/e:ahEY	Ljava/util/concurrent/Future;
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc_w 956
    //   43: invokestatic 350	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: ldc_w 956
    //   55: invokestatic 350	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2	15	60	finally
    //   40	46	60	finally
    //   50	60	60	finally
  }
  
  final boolean jZX()
  {
    if (this.IBH) {
      return false;
    }
    return this.ahEN;
  }
  
  /* Error */
  public final void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 958
    //   5: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 229	com/tencent/thumbplayer/a/a/a/e:ahDA	Lcom/tencent/thumbplayer/f/a;
    //   12: ldc_w 960
    //   15: invokevirtual 466	com/tencent/thumbplayer/f/a:bGe	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 186	com/tencent/thumbplayer/a/a/a/e:ahFc	Z
    //   22: ifeq +39 -> 61
    //   25: aload_0
    //   26: getfield 215	com/tencent/thumbplayer/a/a/a/e:ahFo	Lcom/tencent/thumbplayer/a/a/a/e$f;
    //   29: ifnull +13 -> 42
    //   32: aload_0
    //   33: getfield 215	com/tencent/thumbplayer/a/a/a/e:ahFo	Lcom/tencent/thumbplayer/a/a/a/e$f;
    //   36: getstatic 528	com/tencent/thumbplayer/a/a/a/e$e:ahFB	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   39: putfield 447	com/tencent/thumbplayer/a/a/a/e$f:ahFL	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   42: aload_0
    //   43: getfield 229	com/tencent/thumbplayer/a/a/a/e:ahDA	Lcom/tencent/thumbplayer/f/a;
    //   46: ldc_w 962
    //   49: invokevirtual 965	com/tencent/thumbplayer/f/a:bGf	(Ljava/lang/String;)V
    //   52: ldc_w 958
    //   55: invokestatic 350	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: aload_0
    //   62: getfield 325	com/tencent/thumbplayer/a/a/a/e:sFf	Landroid/media/MediaPlayer;
    //   65: invokevirtual 967	android/media/MediaPlayer:pause	()V
    //   68: aload_0
    //   69: getstatic 528	com/tencent/thumbplayer/a/a/a/e$e:ahFB	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   72: putfield 330	com/tencent/thumbplayer/a/a/a/e:ahFa	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   75: aload_0
    //   76: getstatic 528	com/tencent/thumbplayer/a/a/a/e$e:ahFB	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   79: putfield 332	com/tencent/thumbplayer/a/a/a/e:ahFb	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   82: ldc_w 958
    //   85: invokestatic 350	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(228980);
    this.ahDA.bGe("prepare ");
    this.ahFa = e.ahFy;
    this.ahFb = e.ahFy;
    this.sFf.prepare();
    AppMethodBeat.o(228980);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(228985);
    this.ahDA.bGe("prepareAsync ");
    this.ahFa = e.ahFy;
    this.ahFb = e.ahFy;
    this.sFf.prepareAsync();
    jZS();
    AppMethodBeat.o(228985);
  }
  
  public final void release()
  {
    try
    {
      AppMethodBeat.i(229005);
      this.ahDA.bGe("release ");
      this.ahFm.release();
      jZT();
      jZV();
      jZW();
      this.ahFa = e.ahFF;
      jZQ();
      this.ahDM = null;
      this.ahDN = null;
      this.ahDO = null;
      this.ahDP = null;
      this.ahDQ = null;
      this.ahDR = null;
      this.ahDS = null;
      this.ahDg = null;
      this.ahDA.bGe("release over.");
      AppMethodBeat.o(229005);
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
      AppMethodBeat.i(229003);
      this.ahDA.bGe("reset ");
      this.ahFa = e.ahFw;
      this.ahFm.reset();
      jZP();
      jZT();
      jZV();
      jZW();
      this.ahDA.bGe("reset over.");
      AppMethodBeat.o(229003);
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
    AppMethodBeat.i(229007);
    this.ahDA.bGe("seekTo, position: ".concat(String.valueOf(paramInt)));
    if (this.ahEZ)
    {
      this.ahDA.bGe("current media is not seekable, ignore");
      AppMethodBeat.o(229007);
      return;
    }
    if (this.ahFc)
    {
      if (this.ahFo != null) {
        this.ahFo.position = paramInt;
      }
      AppMethodBeat.o(229007);
      return;
    }
    this.sFf.seekTo(paramInt);
    AppMethodBeat.o(229007);
  }
  
  public final void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(229011);
    this.ahDA.bGe("seekTo, position: " + paramInt1 + ", mode: " + paramInt2);
    if (this.ahEZ)
    {
      this.ahDA.bGe("current media is not seekable, ignore");
      AppMethodBeat.o(229011);
      return;
    }
    if (this.ahFc)
    {
      if (this.ahFo != null) {
        this.ahFo.position = paramInt1;
      }
      AppMethodBeat.o(229011);
      return;
    }
    MediaPlayer localMediaPlayer = this.sFf;
    if (Build.VERSION.SDK_INT < 26)
    {
      this.ahDA.bGe("os ver is too low, current sdk int:" + Build.VERSION.SDK_INT + ", is less than 26, use seekTo(int positionMs) instead");
      localMediaPlayer.seekTo(paramInt1);
      AppMethodBeat.o(229011);
      return;
    }
    if (paramInt2 == 1) {}
    for (;;)
    {
      long l = paramInt1;
      try
      {
        localMediaPlayer.seekTo(l, i);
        AppMethodBeat.o(229011);
        return;
      }
      catch (Exception localException2)
      {
        this.ahDA.p(localException2);
        try
        {
          localMediaPlayer.seekTo(paramInt1);
          AppMethodBeat.o(229011);
          return;
        }
        catch (Exception localException1)
        {
          this.ahDA.p(localException1);
          AppMethodBeat.o(229011);
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
    AppMethodBeat.i(229128);
    this.ahDA.error("selectProgram, android mediaplayer not support");
    AppMethodBeat.o(229128);
  }
  
  public final void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228969);
    this.ahDA.bGe("selectTrack, trackID:" + paramInt + ", opaque:" + paramLong);
    int i = this.ahFk.size();
    int j = this.ahFl.size();
    c.e locale = this.ahDO;
    if ((paramInt >= 0) && (paramInt < i)) {
      try
      {
        f localf = new f((byte)0);
        localf.ahDx = paramLong;
        localf.ahFI = paramInt;
        localf.ahFH = 2;
        localf.url = this.mUrl;
        a(localf);
        ((b)this.ahFk.get(this.ahFi)).ahFu.isSelected = false;
        ((b)this.ahFk.get(paramInt)).ahFu.isSelected = true;
        this.ahFi = paramInt;
        AppMethodBeat.o(228969);
        return;
      }
      catch (Exception localException1)
      {
        this.ahDA.p(localException1);
        if (locale != null) {
          locale.a(4, aHu(-10000), 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(228969);
        return;
      }
    }
    if ((paramInt >= i) && (paramInt < i + j)) {
      try
      {
        this.ahFm.reset();
        b localb = (b)this.ahFl.get(paramInt - i);
        this.ahFm.setDataSource(localb.url);
        this.ahFm.prepare();
        AppMethodBeat.o(228969);
        return;
      }
      catch (Exception localException2)
      {
        this.ahDA.p(localException2);
        if (locale != null) {
          locale.a(4, aHu(-10000), 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(228969);
        return;
      }
    }
    paramInt -= i + j;
    if (Build.VERSION.SDK_INT < 16)
    {
      this.ahDA.error("selectTrack, android mediaplayer not support ");
      if (locale != null) {
        locale.a(4, aHu(-10001), 0L, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(228969);
      return;
    }
    if ((this.ahFa != e.ahFz) && (this.ahFa != e.ahFA) && (this.ahFa != e.ahFB))
    {
      this.ahDA.error("selectTrack, illegal state:" + this.ahFa);
      AppMethodBeat.o(228969);
      return;
    }
    Object localObject = null;
    try
    {
      MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.sFf.getTrackInfo();
      localObject = arrayOfTrackInfo;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        this.ahDA.error("getTrackInfo, android getTrackInfo crash");
      }
      localObject = localObject[paramInt];
      if (localObject.getTrackType() != 2) {
        break label587;
      }
      this.ahFj = paramInt;
      for (;;)
      {
        this.sFf.selectTrack(paramInt);
        if (locale != null) {
          locale.a(4, 1000L, 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(228969);
        return;
        if (localObject.getTrackType() != 4) {
          break;
        }
        this.ahFh = paramInt;
      }
      if (locale == null) {
        break label629;
      }
      locale.a(4, aHu(-10003), 0L, Long.valueOf(paramLong));
      AppMethodBeat.o(228969);
    }
    if ((localObject == null) || (localObject.length <= paramInt))
    {
      if (locale != null) {
        locale.a(4, aHu(-10002), 0L, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(228969);
      return;
    }
    label587:
    label629:
    return;
  }
  
  public final void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(229024);
    this.ahDA.bGe("setAudioGainRatio, : ".concat(String.valueOf(paramFloat)));
    this.ahEG = paramFloat;
    try
    {
      if (this.sFf != null) {
        this.sFf.setVolume(this.ahEG, this.ahEG);
      }
      AppMethodBeat.o(229024);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.ahDA.bGe("setAudioGainRatio ex : " + localIllegalStateException.toString());
      AppMethodBeat.o(229024);
    }
  }
  
  public final void setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(229028);
    this.ahDA.bGe("setAudioNormalizeVolumeParams not supported.");
    AppMethodBeat.o(229028);
  }
  
  public final void setDataSource(AssetFileDescriptor paramAssetFileDescriptor)
  {
    AppMethodBeat.i(228908);
    if (paramAssetFileDescriptor == null)
    {
      this.ahDA.bGe("setDataSource afd is null ");
      paramAssetFileDescriptor = new IllegalArgumentException("afd is null");
      AppMethodBeat.o(228908);
      throw paramAssetFileDescriptor;
    }
    this.ahDA.bGe("setDataSource afd， afd: " + paramAssetFileDescriptor.toString());
    this.ahEF = paramAssetFileDescriptor;
    a(paramAssetFileDescriptor);
    this.ahEP = new com.tencent.thumbplayer.b.c(paramAssetFileDescriptor.getFileDescriptor());
    this.ahFa = e.ahFx;
    this.ahFb = e.ahFx;
    AppMethodBeat.o(228908);
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(228899);
    if (paramParcelFileDescriptor == null)
    {
      this.ahDA.bGe("setDataSource pfd is null ");
      paramParcelFileDescriptor = new IllegalArgumentException("pfd is null");
      AppMethodBeat.o(228899);
      throw paramParcelFileDescriptor;
    }
    this.ahDA.bGe("setDataSource pfd， pfd: " + paramParcelFileDescriptor.toString());
    this.ahEE = paramParcelFileDescriptor.getFileDescriptor();
    this.sFf.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
    this.ahEP = new com.tencent.thumbplayer.b.c(paramParcelFileDescriptor.getFileDescriptor());
    this.ahFa = e.ahFx;
    this.ahFb = e.ahFx;
    AppMethodBeat.o(228899);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(228915);
    paramITPMediaAsset = new IllegalArgumentException("setDataSource by asset, android mediaplayer not support");
    AppMethodBeat.o(228915);
    throw paramITPMediaAsset;
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(228891);
    this.ahDA.bGe("setDataSource httpHeader, url: ".concat(String.valueOf(paramString)));
    this.mUrl = paramString;
    this.ppb = paramMap;
    paramMap = Uri.parse(this.mUrl);
    this.sFf.setDataSource(this.mContext, paramMap, this.ppb);
    this.ahEP = new com.tencent.thumbplayer.b.c(paramString);
    this.ahFa = e.ahFx;
    this.ahFb = e.ahFx;
    AppMethodBeat.o(228891);
  }
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(229039);
    this.ahDA.bGe("setLoopback, : ".concat(String.valueOf(paramBoolean)));
    this.ahEB = paramBoolean;
    this.sFf.setLooping(paramBoolean);
    AppMethodBeat.o(229039);
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(229050);
    this.ahDA.bGe("setLoopback, : " + paramBoolean + ", loopStart: " + paramLong1 + ", loopEnd: " + paramLong2);
    if ((paramLong1 < 0L) || (paramLong1 > this.ahFd) || (paramLong2 > this.ahFd))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("position error, must more than 0 and less than duration");
      AppMethodBeat.o(229050);
      throw localIllegalArgumentException;
    }
    this.ahEB = paramBoolean;
    this.ahEC = paramLong1;
    this.ahED = paramLong2;
    this.sFf.setLooping(paramBoolean);
    AppMethodBeat.o(229050);
  }
  
  public final void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(229019);
    this.ahDA.bGe("setOutputMute, : ".concat(String.valueOf(paramBoolean)));
    this.mMute = paramBoolean;
    if (paramBoolean) {}
    try
    {
      this.sFf.setVolume(0.0F, 0.0F);
      this.ahDA.bGe("setOutputMute, true");
      AppMethodBeat.o(229019);
      return;
    }
    catch (Exception localException)
    {
      this.ahDA.bGe("setOutputMute, Exception: " + localException.toString());
      AppMethodBeat.o(229019);
    }
    this.sFf.setVolume(this.ahEG, this.ahEG);
    this.ahDA.bGe("setOutputMute, false, mAudioGain: " + this.ahEG);
    AppMethodBeat.o(229019);
    return;
  }
  
  public final void setPlaySharpenSwitch() {}
  
  public final void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(229033);
    this.ahDA.bGe("setPlaySpeedRatio, : ".concat(String.valueOf(paramFloat)));
    if (Build.VERSION.SDK_INT < 23)
    {
      this.ahDA.bGe("os version is too low: " + Build.VERSION.SDK_INT);
      AppMethodBeat.o(229033);
      return;
    }
    this.ahEH = paramFloat;
    this.ahDA.bGe("setPlaySpeedRatio play speed:".concat(String.valueOf(paramFloat)));
    try
    {
      PlaybackParams localPlaybackParams = this.sFf.getPlaybackParams();
      if (localPlaybackParams.getSpeed() != paramFloat)
      {
        localPlaybackParams.setSpeed(paramFloat);
        this.sFf.setPlaybackParams(localPlaybackParams);
      }
      AppMethodBeat.o(229033);
      return;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(229033);
    }
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(228767);
    switch (paramTPOptionalParam.getKey())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(228767);
      return;
      this.ahEI = ((int)paramTPOptionalParam.getParamLong().value);
      this.ahDA.bGe("setPlayerOptionalParam, start position:" + this.ahEI);
      AppMethodBeat.o(228767);
      return;
      this.ahEJ = paramTPOptionalParam.getParamLong().value;
      this.ahDA.bGe("setPlayerOptionalParam, skip end position:" + this.ahEJ);
      AppMethodBeat.o(228767);
      return;
      this.ahEK = paramTPOptionalParam.getParamLong().value;
      AppMethodBeat.o(228767);
      return;
      this.ahEM = ((int)paramTPOptionalParam.getParamLong().value);
      this.ahDA.bGe("setPlayerOptionalParam, video width:" + this.ahEM);
      AppMethodBeat.o(228767);
      return;
      this.ahEL = ((int)paramTPOptionalParam.getParamLong().value);
      this.ahDA.bGe("setPlayerOptionalParam, video height:" + this.ahEL);
      AppMethodBeat.o(228767);
      return;
      this.IBH = paramTPOptionalParam.getParamBoolean().value;
      this.ahEZ = true;
      this.ahDA.bGe("setPlayerOptionalParam, is live:" + this.IBH);
      AppMethodBeat.o(228767);
      return;
      this.ahEN = paramTPOptionalParam.getParamBoolean().value;
      AppMethodBeat.o(228767);
      return;
      this.ahES = paramTPOptionalParam.getParamLong().value;
      this.ahDA.bGe("setPlayerOptionalParam, prepare timeout:" + this.ahES + "(ms)");
      AppMethodBeat.o(228767);
      return;
      this.ahEW = ((int)((paramTPOptionalParam.getParamLong().value + 400L) / 400L));
      this.ahDA.bGe("setPlayerOptionalParam, buffer timeout:" + paramTPOptionalParam.getParamLong().value + "(ms)");
      AppMethodBeat.o(228767);
      return;
      this.ahEV = ((int)(paramTPOptionalParam.getParamLong().value / 400L));
      this.ahDA.bGe("setPlayerOptionalParam, on buffer timeout:" + paramTPOptionalParam.getParamLong().value + "(ms)");
    }
  }
  
  public final void setSurface(Surface paramSurface, @TPCommonEnum.TPSurfaceType int paramInt)
  {
    AppMethodBeat.i(228871);
    this.ahDA.bGe("setSurface, surface: ".concat(String.valueOf(paramSurface)));
    this.ahDg = paramSurface;
    this.sFf.setSurface(paramSurface);
    this.ahDA.bGe("setSurface over, surface: ".concat(String.valueOf(paramSurface)));
    AppMethodBeat.o(228871);
  }
  
  public final void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(228882);
    this.ahDA.bGe("setSurfaceHolder, sh: ".concat(String.valueOf(paramSurfaceHolder)));
    this.ahDg = paramSurfaceHolder;
    this.sFf.setDisplay(paramSurfaceHolder);
    this.ahDA.bGe("setSurfaceHolder over, sh: ".concat(String.valueOf(paramSurfaceHolder)));
    AppMethodBeat.o(228882);
  }
  
  public final void start()
  {
    AppMethodBeat.i(228991);
    this.ahDA.bGe("start ");
    if (this.ahFc)
    {
      if (this.ahFo != null) {
        this.ahFo.ahFL = e.ahFA;
      }
      this.ahDA.bGf("system player is busy.");
      AppMethodBeat.o(228991);
      return;
    }
    if ((this.ahFa != e.ahFz) && (this.ahFa != e.ahFB))
    {
      this.ahDA.bGf("start(), illegal state, state:" + this.ahFa);
      AppMethodBeat.o(228991);
      return;
    }
    this.sFf.start();
    this.ahFa = e.ahFA;
    this.ahFb = e.ahFA;
    if (this.ahEH != 1.0D) {
      setPlaySpeedRatio(this.ahEH);
    }
    jZU();
    AppMethodBeat.o(228991);
  }
  
  public final void stop()
  {
    try
    {
      AppMethodBeat.i(229000);
      this.ahDA.bGe("stop ");
      jZT();
      jZV();
      jZW();
      this.ahFa = e.ahFC;
      jZP();
      this.ahFi = 0;
      this.ahFo = null;
      this.ahFh = -1;
      this.ahFj = -1;
      this.ahFm.stop();
      this.ahFn = 0L;
      this.ahDA.bGe("stop over.");
      AppMethodBeat.o(229000);
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
    AppMethodBeat.i(228758);
    this.ahDA.a(new com.tencent.thumbplayer.f.b(paramb, "TPSystemMediaPlayer"));
    AppMethodBeat.o(228758);
  }
  
  static final class a
  {
    boolean ahFs;
    Future<?> ahFt;
  }
  
  static final class b
  {
    public TPTrackInfo ahFu;
    public String keyId = "";
    public String url = "";
  }
  
  final class d
    implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener
  {
    private d() {}
    
    private int aHv(int paramInt)
    {
      if (e.this.ahEM > 0) {
        paramInt = e.this.ahEM;
      }
      return paramInt;
    }
    
    private int aHw(int paramInt)
    {
      if (e.this.ahEL > 0) {
        paramInt = e.this.ahEL;
      }
      return paramInt;
    }
    
    public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt) {}
    
    public final void onCompletion(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(228658);
      if (e.this.IBH)
      {
        e.this.ahDA.bGf("onCompletion, unknown err.");
        AppMethodBeat.o(228658);
        return;
      }
      e.this.ahDA.bGe("onCompletion.");
      e.this.ahFa = e.e.ahFD;
      e.this.jZQ();
      e.this.jZV();
      paramMediaPlayer = e.this.ahDN;
      if (paramMediaPlayer != null) {
        paramMediaPlayer.onCompletion();
      }
      AppMethodBeat.o(228658);
    }
    
    public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      int j = 2000;
      AppMethodBeat.i(228670);
      if ((e.this.ahFa == e.e.ahFD) || (e.this.ahFa == e.e.ahFC) || (e.this.ahFa == e.e.ahFF) || (e.this.ahFa == e.e.ahFw) || (e.this.ahFa == e.e.ahFE))
      {
        e.this.ahDA.bGe("onError, illegal state:" + e.this.ahFa + ", what:" + paramInt1 + ", extra:" + paramInt2);
        AppMethodBeat.o(228670);
        return true;
      }
      e.this.ahDA.bGe("onError, what: " + paramInt1 + ", extra: " + paramInt2);
      e.this.jZT();
      e.this.jZV();
      e.this.ahFa = e.e.ahFE;
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
        e.this.jZQ();
        paramMediaPlayer = e.this.ahDP;
        if (paramMediaPlayer != null) {
          paramMediaPlayer.a(i, e.aHu(paramInt1), paramInt2, 0L);
        }
        AppMethodBeat.o(228670);
        return true;
        i = 2001;
        continue;
        i = 2001;
      }
    }
    
    public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(228683);
      e.this.ahDA.bGe("mediaplayer, onInfo. what:" + paramInt1 + ", extra:" + paramInt2);
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
          if (!e.this.jZX())
          {
            if (200 != paramInt1) {
              break label377;
            }
            e.this.ahFf = true;
            locale = e.this;
          }
        }
        break;
      }
      for (;;)
      {
        synchronized (locale.ahEX)
        {
          if (locale.ahEY == null) {
            locale.ahEY = j.getScheduledExecutorServiceInstance().schedule(new e.5(locale), locale.ahEW * 400, TimeUnit.MILLISECONDS);
          }
          if (e.this.ahDO != null) {
            e.this.ahDO.a(paramInt1, 0L, 0L, null);
          }
          if (paramInt1 == 106)
          {
            paramInt1 = aHv(paramMediaPlayer.getVideoWidth());
            paramInt2 = aHw(paramMediaPlayer.getVideoHeight());
            if (((paramInt2 != e.this.mVideoHeight) || (paramInt1 != e.this.mVideoWidth)) && (paramInt2 > 0) && (paramInt1 > 0))
            {
              e.this.mVideoHeight = paramInt2;
              e.this.mVideoWidth = paramInt1;
              if (e.this.ahDR != null) {
                e.this.ahDR.bN(e.this.mVideoWidth, e.this.mVideoHeight);
              }
            }
          }
          AppMethodBeat.o(228683);
          return true;
          paramInt1 = 200;
          break;
          paramInt1 = 201;
          break;
          paramInt1 = 106;
          break;
          e.this.ahEZ = true;
          paramInt1 = paramInt2;
        }
        label377:
        e.this.ahFf = false;
        e.this.jZW();
        continue;
        label395:
        if (e.this.ahDO != null) {
          e.this.ahDO.a(106, 0L, 0L, null);
        }
      }
    }
    
    public final void onPrepared(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(228651);
      if (e.this.ahFa != e.e.ahFy)
      {
        e.this.ahDA.bGe("onPrepared() is called in a wrong situation, mState = " + e.this.ahFa);
        AppMethodBeat.o(228651);
        return;
      }
      e.this.ahFb = e.e.ahFz;
      long l = e.this.sFf.getDuration();
      if (l <= 0L) {
        e.this.ahEZ = true;
      }
      e.this.ahDA.bGe("onPrepared() , mStartPositionMs=" + e.this.ahEI + ", duration:" + l + ", mIsLive:" + e.this.IBH);
      e.this.jZT();
      e.this.jZR();
      AppMethodBeat.o(228651);
    }
    
    public final void onSeekComplete(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(228692);
      if (e.this.sFf == null)
      {
        AppMethodBeat.o(228692);
        return;
      }
      e.this.ahDA.bGe("onSeekComplete().");
      if ((e.e.ahFz != e.this.ahFa) && (e.this.ahDQ != null)) {
        e.this.ahDQ.dEH();
      }
      AppMethodBeat.o(228692);
    }
    
    public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(228704);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        e.this.ahDA.error("onVideoSizeChanged() size error, width:" + paramInt1 + " height:" + paramInt2);
        AppMethodBeat.o(228704);
        return;
      }
      paramInt1 = aHv(paramInt1);
      paramInt2 = aHw(paramInt2);
      try
      {
        if (((paramInt1 != e.this.mVideoWidth) || (paramInt2 != e.this.mVideoHeight)) && (paramInt2 > 0) && (paramInt1 > 0)) {
          e.this.ahDR.bN(paramInt1, paramInt2);
        }
      }
      catch (Exception paramMediaPlayer)
      {
        for (;;)
        {
          e.this.ahDA.bGf(paramMediaPlayer.toString());
        }
      }
      e.this.mVideoWidth = paramInt1;
      e.this.mVideoHeight = paramInt2;
      e.this.ahDA.bGe("onVideoSizeChanged(), width:" + paramInt1 + " height:" + paramInt2);
      AppMethodBeat.o(228704);
    }
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(228640);
      ahFw = new e("IDLE", 0);
      ahFx = new e("INITIALIZED", 1);
      ahFy = new e("PREPARING", 2);
      ahFz = new e("PREPARED", 3);
      ahFA = new e("STARTED", 4);
      ahFB = new e("PAUSED", 5);
      ahFC = new e("STOPPED", 6);
      ahFD = new e("COMPLETE", 7);
      ahFE = new e("ERROR", 8);
      ahFF = new e("RELEASE", 9);
      ahFG = new e[] { ahFw, ahFx, ahFy, ahFz, ahFA, ahFB, ahFC, ahFD, ahFE, ahFF };
      AppMethodBeat.o(228640);
    }
    
    private e() {}
  }
  
  static final class f
  {
    long ahDx;
    int ahFH;
    int ahFI;
    int ahFJ;
    int ahFK;
    e.e ahFL;
    long position;
    String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */