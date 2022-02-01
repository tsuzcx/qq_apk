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
  long ZAa;
  long ZAb;
  volatile boolean ZAc;
  int ZAd;
  int ZAe;
  private int ZAf;
  private int ZAg;
  private List<b> ZAh;
  private List<b> ZAi;
  private a ZAj;
  long ZAk;
  private f ZAl;
  @TargetApi(16)
  private MediaPlayer.OnTimedTextListener ZAm;
  private c.f ZyJ;
  c.c ZyK;
  c.e ZyL;
  c.d ZyM;
  c.g ZyN;
  c.m ZyO;
  c.i ZyP;
  private Object Zyd;
  com.tencent.thumbplayer.f.a Zyx;
  long ZzA;
  long ZzB;
  private FileDescriptor ZzC;
  private float ZzD;
  private float ZzE;
  int ZzF;
  long ZzG;
  private long ZzH;
  int ZzI;
  int ZzJ;
  private boolean ZzK;
  private d ZzL;
  private com.tencent.thumbplayer.b.c ZzM;
  private Future<?> ZzN;
  private final Object ZzO;
  private long ZzP;
  private a ZzQ;
  private final Object ZzR;
  int ZzS;
  int ZzT;
  final Object ZzU;
  Future<?> ZzV;
  boolean ZzW;
  volatile e ZzX;
  volatile e ZzY;
  private boolean ZzZ;
  boolean Zzz;
  boolean jzL;
  private Context mContext;
  private boolean mMute;
  private String mUrl;
  int mVideoHeight;
  int mVideoWidth;
  private Map<String, String> mvC;
  volatile MediaPlayer pzX;
  
  public e(Context paramContext, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(219235);
    this.Zzz = false;
    this.ZzA = 0L;
    this.ZzB = 0L;
    this.mMute = false;
    this.ZzD = 1.0F;
    this.ZzE = 1.0F;
    this.ZzF = 0;
    this.ZzG = -1L;
    this.jzL = false;
    this.ZzH = -1L;
    this.ZzI = -1;
    this.ZzJ = -1;
    this.ZzK = true;
    this.ZzN = null;
    this.ZzO = new Object();
    this.ZzP = 25000L;
    this.ZzR = new Object();
    this.ZzS = 3;
    this.ZzT = 30;
    this.ZzU = new Object();
    this.ZzV = null;
    this.ZzW = false;
    this.ZzZ = false;
    this.ZAa = 0L;
    this.ZAb = -1L;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.ZAc = false;
    this.ZAd = 0;
    this.ZAe = -1;
    this.ZAf = 0;
    this.ZAg = -1;
    this.ZAh = new ArrayList();
    this.ZAi = new ArrayList();
    this.ZAk = 0L;
    this.ZAl = null;
    this.ZAm = new MediaPlayer.OnTimedTextListener()
    {
      public final void onTimedText(MediaPlayer paramAnonymousMediaPlayer, TimedText paramAnonymousTimedText)
      {
        AppMethodBeat.i(219153);
        TPSubtitleData localTPSubtitleData;
        if (e.this.ZyP != null)
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
          localTPSubtitleData.trackIndex = e.this.ZAe;
          localTPSubtitleData.startPositionMs = e.this.getCurrentPositionMs();
          e.this.ZyP.a(localTPSubtitleData);
          AppMethodBeat.o(219153);
          return;
        }
      }
    };
    this.Zyx = new com.tencent.thumbplayer.f.a(paramb, "TPSystemMediaPlayer");
    this.mContext = paramContext;
    this.ZzL = new d((byte)0);
    paramContext = new b((byte)0);
    paramContext.ZAr = new TPTrackInfo();
    paramContext.ZAr.isSelected = true;
    paramContext.ZAr.name = "audio_1";
    this.ZAh.add(paramContext);
    paramContext = new b();
    if (Build.VERSION.SDK_INT <= 19) {
      a(paramContext);
    }
    paramContext.setOnPreparedListener(this.ZzL);
    paramContext.setOnCompletionListener(this.ZzL);
    paramContext.setOnErrorListener(this.ZzL);
    paramContext.setOnInfoListener(this.ZzL);
    paramContext.setOnBufferingUpdateListener(this.ZzL);
    paramContext.setOnSeekCompleteListener(this.ZzL);
    paramContext.setOnVideoSizeChangedListener(this.ZzL);
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.setOnTimedTextListener(this.ZAm);
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramContext.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
    }
    for (;;)
    {
      this.pzX = paramContext;
      this.ZzX = e.ZAt;
      this.ZzY = e.ZAt;
      this.ZAj = new c();
      this.ZAj.a(new a.a()
      {
        public final void a(a.c paramAnonymousc)
        {
          AppMethodBeat.i(219129);
          TPSubtitleData localTPSubtitleData = new TPSubtitleData();
          localTPSubtitleData.subtitleData = paramAnonymousc.text;
          paramAnonymousc = e.this.ZyP;
          if (paramAnonymousc != null) {
            paramAnonymousc.a(localTPSubtitleData);
          }
          AppMethodBeat.o(219129);
        }
      });
      this.ZAj.a(new a.b()
      {
        public final long getCurrentPosition()
        {
          AppMethodBeat.i(219131);
          if ((e.this.ZzX != e.e.ZAy) && (e.this.ZzX != e.e.ZAx))
          {
            AppMethodBeat.o(219131);
            return -1L;
          }
          long l = e.this.getCurrentPositionMs();
          AppMethodBeat.o(219131);
          return l;
        }
      });
      AppMethodBeat.o(219235);
      return;
      paramContext.setAudioStreamType(3);
    }
  }
  
  private void a(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(219229);
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
      AppMethodBeat.o(219229);
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      this.Zyx.error("mediaPlayerExceptionHook, " + Log.getStackTraceString(paramMediaPlayer));
      AppMethodBeat.o(219229);
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
        AppMethodBeat.i(219283);
        localObject1 = paramf.url;
        paramf.position = getCurrentPositionMs();
        paramf.ZAI = this.ZzX;
        paramf.ZAG = this.ZAg;
        paramf.ZAH = this.ZAe;
        this.Zyx.bDy("playerResetStart, pos:" + paramf.position + ", state:" + paramf.ZAI);
        this.ZzZ = true;
        iqy();
        iqA();
        iqB();
        iqv();
        localObject2 = new b();
        if (Build.VERSION.SDK_INT <= 19) {
          a((MediaPlayer)localObject2);
        }
        ((MediaPlayer)localObject2).setOnPreparedListener(this.ZzL);
        ((MediaPlayer)localObject2).setOnCompletionListener(this.ZzL);
        ((MediaPlayer)localObject2).setOnErrorListener(this.ZzL);
        ((MediaPlayer)localObject2).setOnInfoListener(this.ZzL);
        ((MediaPlayer)localObject2).setOnBufferingUpdateListener(this.ZzL);
        ((MediaPlayer)localObject2).setOnSeekCompleteListener(this.ZzL);
        ((MediaPlayer)localObject2).setOnVideoSizeChangedListener(this.ZzL);
        if (Build.VERSION.SDK_INT >= 16) {
          ((MediaPlayer)localObject2).setOnTimedTextListener(this.ZAm);
        }
        if (Build.VERSION.SDK_INT >= 26)
        {
          ((MediaPlayer)localObject2).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
          if (this.mMute)
          {
            this.pzX.setVolume(0.0F, 0.0F);
            if (this.ZzE != 1.0D) {
              setPlaySpeedRatio(this.ZzE);
            }
            if (this.Zzz) {
              this.pzX.setLooping(this.Zzz);
            }
            this.pzX = ((MediaPlayer)localObject2);
            this.ZzY = e.ZAt;
            if (this.ZzC == null) {
              break label536;
            }
            this.pzX.setDataSource(this.ZzC);
            this.ZzY = e.ZAu;
            if (this.Zyd != null) {
              break label710;
            }
            this.pzX.setDisplay(null);
            localObject1 = this.ZAl;
            if ((localObject1 != null) && (((f)localObject1).ZAE != paramf.ZAE))
            {
              localObject2 = this.ZyL;
              if (((f)localObject1).ZAE != 1) {
                break label764;
              }
              i = 3;
              if (localObject2 != null) {
                ((c.e)localObject2).a(i, ((f)localObject1).Zyu, 0L, null);
              }
              paramf.ZAI = ((f)localObject1).ZAI;
              paramf.position = ((f)localObject1).position;
            }
            this.ZAl = paramf;
            if ((paramf.ZAI == e.ZAv) || (paramf.ZAI == e.ZAw) || (paramf.ZAI == e.ZAx) || (paramf.ZAI == e.ZAy))
            {
              this.pzX.prepareAsync();
              this.ZzX = e.ZAv;
              this.ZzY = e.ZAv;
              iqx();
            }
            AppMethodBeat.o(219283);
          }
        }
        else
        {
          ((MediaPlayer)localObject2).setAudioStreamType(3);
          continue;
        }
        if (this.ZzD == 1.0F) {
          continue;
        }
      }
      finally {}
      this.pzX.setVolume(this.ZzD, this.ZzD);
      continue;
      label536:
      int i = paramf.ZAF;
      if (i > 0)
      {
        localObject2 = (b)this.ZAh.get(i);
        c.e locale = this.ZyL;
        if (locale != null)
        {
          TPPlayerMsg.TPAudioTrackInfo localTPAudioTrackInfo = new TPPlayerMsg.TPAudioTrackInfo();
          localTPAudioTrackInfo.audioTrackUrl = ((b)localObject2).url;
          localTPAudioTrackInfo.keyId = ((b)localObject2).keyId;
          this.Zyx.bDy("handleDataSource, audioTrack url:" + localTPAudioTrackInfo.audioTrackUrl + ", keyId:" + localTPAudioTrackInfo.keyId);
          locale.a(1011, 0L, 0L, localTPAudioTrackInfo);
        }
      }
      if ((this.mvC != null) && (!this.mvC.isEmpty()))
      {
        localObject1 = Uri.parse((String)localObject1);
        this.pzX.setDataSource(this.mContext, (Uri)localObject1, this.mvC);
      }
      else
      {
        this.pzX.setDataSource((String)localObject1);
        continue;
        label710:
        if ((this.Zyd instanceof SurfaceHolder))
        {
          this.pzX.setDisplay((SurfaceHolder)this.Zyd);
        }
        else if ((this.Zyd instanceof Surface))
        {
          this.pzX.setSurface((Surface)this.Zyd);
          continue;
          label764:
          i = 4;
        }
      }
    }
  }
  
  static int aAI(int paramInt)
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
  
  private void iqu()
  {
    AppMethodBeat.i(219273);
    e locale = this.ZzY;
    if ((locale == e.ZAw) || (locale == e.ZAx) || (locale == e.ZAy)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.ZzY = e.ZAz;
        this.Zyx.bDy("MediaPlayer stop.");
        this.pzX.stop();
      }
      AppMethodBeat.o(219273);
      return;
    }
  }
  
  private void iqx()
  {
    AppMethodBeat.i(219360);
    this.Zyx.bDy("startCheckPrepareTimeoutTimer");
    synchronized (this.ZzO)
    {
      if (this.ZzN == null) {
        this.ZzN = j.getScheduledExecutorServiceInstance().schedule(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219133);
            if (e.this.ZzX == e.e.ZAv)
            {
              e.this.Zyx.error("startCheckPrepareTimeoutTimer, post error");
              e.this.ZzX = e.e.ZAB;
              e.this.iqv();
              e.this.iqy();
              c.d locald = e.this.ZyM;
              if (locald != null) {
                locald.a(2001, e.aAI(-110), 0L, 0L);
              }
            }
            AppMethodBeat.o(219133);
          }
        }, this.ZzP, TimeUnit.MILLISECONDS);
      }
      AppMethodBeat.o(219360);
      return;
    }
  }
  
  private void iqz()
  {
    AppMethodBeat.i(219367);
    synchronized (this.ZzR)
    {
      if (!iqC())
      {
        this.Zyx.bDy("startCheckBufferingTimer, forbidden check buffer by position");
        AppMethodBeat.o(219367);
        return;
      }
      if (this.ZzQ == null)
      {
        this.ZzQ = new a((byte)0);
        final a locala = this.ZzQ;
        this.ZzQ.ZAp = false;
        this.ZzQ.ZAq = j.getScheduledExecutorServiceInstance().schedule(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219143);
            if (!locala.ZAp)
            {
              Object localObject1 = e.this;
              long l1 = ((e)localObject1).getCurrentPositionMs();
              long l2 = ((e)localObject1).ZAb;
              ((e)localObject1).ZAb = l1;
              if (((e)localObject1).ZzX != e.e.ZAx) {
                if ((((e)localObject1).ZzX == e.e.ZAy) && (((e)localObject1).ZAc))
                {
                  ((e)localObject1).Zyx.bDy("checkBuffingEvent, pause state and send end buffering");
                  ((e)localObject1).ZAc = false;
                  ((e)localObject1).ZAd = 0;
                  localObject1 = ((e)localObject1).ZyL;
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
                if (localInterruptedException.Zzz) {
                  if ((localInterruptedException.ZzB > 0L) && (l1 >= localInterruptedException.ZzB) && (!localInterruptedException.ZzW))
                  {
                    localInterruptedException.Zyx.bDy("checkBuffingEvent, loopback skip end, curPosition:" + l1 + ", mLoopStartPositionMs:" + localInterruptedException.ZzA);
                    localInterruptedException.pzX.seekTo((int)localInterruptedException.ZzA);
                  }
                }
                c.e locale;
                while ((((e)localObject2).ZzG <= 0L) || (l1 < ((e)localObject2).getDurationMs() - ((e)localObject2).ZzG))
                {
                  if (l1 != l2) {
                    localInterruptedException.ZAk += 1L;
                  }
                  if ((l1 != l2) || (l1 <= 0L)) {
                    break label528;
                  }
                  int i = localInterruptedException.ZAd + 1;
                  localInterruptedException.ZAd = i;
                  if ((i >= localInterruptedException.ZzS) && (!localInterruptedException.ZAc))
                  {
                    localInterruptedException.ZAc = true;
                    localInterruptedException.Zyx.bDy("checkBuffingEvent, position no change,send start buffering");
                    locale = localInterruptedException.ZyL;
                    if (locale != null) {
                      locale.a(200, l1, localInterruptedException.ZAa, Long.valueOf(localInterruptedException.ZAk));
                    }
                  }
                  if (localInterruptedException.ZAd < localInterruptedException.ZzT) {
                    break;
                  }
                  localInterruptedException.Zyx.error("checkBuffingEvent post error");
                  localInterruptedException.ZzX = e.e.ZAB;
                  localInterruptedException.iqv();
                  localInterruptedException.ZAc = false;
                  localInterruptedException.iqA();
                  localObject2 = localInterruptedException.ZyM;
                  if (localObject2 == null) {
                    break;
                  }
                  ((c.d)localObject2).a(2001, e.aAI(-110), 0L, 0L);
                  break;
                }
                ((e)localObject2).Zyx.bDy("checkBuffingEvent, skip end, mBaseDuration: " + ((e)localObject2).ZAa + ", curPosition:" + l1 + ", mSkipEndMilsec:" + ((e)localObject2).ZzG);
                ((e)localObject2).ZzX = e.e.ZAA;
                ((e)localObject2).iqv();
                ((e)localObject2).iqA();
                Object localObject2 = ((e)localObject2).ZyK;
                if (localObject2 != null)
                {
                  ((c.c)localObject2).onCompletion();
                  continue;
                  label528:
                  if (((e)localObject2).ZAc)
                  {
                    ((e)localObject2).Zyx.bDy("checkBuffingEvent, position change, send end buffering");
                    locale = ((e)localObject2).ZyL;
                    if (locale != null) {
                      locale.a(201, l1, ((e)localObject2).ZAa, Long.valueOf(((e)localObject2).ZAk));
                    }
                  }
                  ((e)localObject2).ZAc = false;
                  ((e)localObject2).ZAd = 0;
                }
              }
            }
            AppMethodBeat.o(219143);
          }
        }, 0L, TimeUnit.MILLISECONDS);
      }
      AppMethodBeat.o(219367);
      return;
    }
  }
  
  public final void L(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(219325);
    this.Zyx.bDy("switchDefinition, defUrl: ".concat(String.valueOf(paramString)));
    if (TextUtils.isEmpty(paramString))
    {
      this.Zyx.bDy("switchDefinition, defUrl is null");
      AppMethodBeat.o(219325);
      return;
    }
    this.mUrl = paramString;
    f localf = new f((byte)0);
    localf.Zyu = paramLong;
    localf.ZAF = this.ZAf;
    localf.ZAE = 1;
    localf.url = paramString;
    try
    {
      a(localf);
      AppMethodBeat.o(219325);
      return;
    }
    catch (Exception paramString)
    {
      paramString = new IllegalStateException("playerResetStart");
      AppMethodBeat.o(219325);
      throw paramString;
    }
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(219251);
    parama = new IllegalStateException("system Mediaplayer cannot support audio frame out");
    AppMethodBeat.o(219251);
    throw parama;
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(219254);
    paramb = new IllegalStateException("system Mediaplayer cannot support audio postprocess frame out");
    AppMethodBeat.o(219254);
    throw paramb;
  }
  
  public final void a(c.c paramc)
  {
    this.ZyK = paramc;
  }
  
  public final void a(c.d paramd)
  {
    this.ZyM = paramd;
  }
  
  public final void a(c.e parame)
  {
    this.ZyL = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.ZyJ = paramf;
  }
  
  public final void a(c.g paramg)
  {
    this.ZyN = paramg;
  }
  
  public final void a(c.i parami)
  {
    this.ZyP = parami;
  }
  
  public final void a(c.j paramj)
  {
    AppMethodBeat.i(219245);
    paramj = new IllegalStateException("system Mediaplayer cannot support subtitle frame out");
    AppMethodBeat.o(219245);
    throw paramj;
  }
  
  public final void a(c.k paramk)
  {
    AppMethodBeat.i(219248);
    paramk = new IllegalStateException("system Mediaplayer cannot support video frame out");
    AppMethodBeat.o(219248);
    throw paramk;
  }
  
  public final void a(c.l paraml)
  {
    AppMethodBeat.i(219253);
    paraml = new IllegalStateException("system Mediaplayer cannot support video postprocess frame out");
    AppMethodBeat.o(219253);
    throw paraml;
  }
  
  public final void a(c.m paramm)
  {
    this.ZyO = paramm;
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong) {}
  
  public final void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(219268);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      this.Zyx.error("addSubtitleSource, illegal argument.");
      AppMethodBeat.o(219268);
      return;
    }
    paramString2 = new TPTrackInfo();
    paramString2.name = paramString3;
    paramString2.isExclusive = true;
    paramString2.isInternal = false;
    paramString2.isSelected = false;
    paramString2.trackType = 3;
    b localb = new b((byte)0);
    localb.ZAr = paramString2;
    localb.url = paramString1;
    this.Zyx.bDy("addSubtitleSource, name:" + paramString2.name + ", url:" + paramString3);
    this.ZAi.add(localb);
    AppMethodBeat.o(219268);
  }
  
  public final void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(219357);
    if (this.ZzM != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = paramTPCaptureParams.width;
      localTPImageGeneratorParams.height = paramTPCaptureParams.height;
      localTPImageGeneratorParams.format = paramTPCaptureParams.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = paramTPCaptureParams.requestedTimeMsToleranceBefore;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = paramTPCaptureParams.requestedTimeMsToleranceAfter;
      this.ZzM.a(getCurrentPositionMs(), localTPImageGeneratorParams, paramTPCaptureCallBack);
      AppMethodBeat.o(219357);
      return;
    }
    paramTPCaptureCallBack.onCaptureVideoFailed(1000013);
    AppMethodBeat.o(219357);
  }
  
  @TargetApi(16)
  public final void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(219302);
    if (Build.VERSION.SDK_INT < 16)
    {
      this.Zyx.error("deselectTrack, android mediaplayer not support ");
      AppMethodBeat.o(219302);
      return;
    }
    this.pzX.deselectTrack(paramInt);
    AppMethodBeat.o(219302);
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(219342);
    if (this.jzL)
    {
      AppMethodBeat.o(219342);
      return 0L;
    }
    if ((this.ZzZ) || (this.ZzX == e.ZAB))
    {
      if (this.ZAb == -1L)
      {
        l = this.ZzF;
        AppMethodBeat.o(219342);
        return l;
      }
      l = this.ZAb;
      AppMethodBeat.o(219342);
      return l;
    }
    if ((this.ZzX == e.ZAt) || (this.ZzX == e.ZAu) || (this.ZzX == e.ZAv) || (this.ZzX == e.ZAz) || (this.ZzX == e.ZAw))
    {
      l = this.ZzF;
      AppMethodBeat.o(219342);
      return l;
    }
    long l = this.pzX.getCurrentPosition();
    AppMethodBeat.o(219342);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(219341);
    if (this.jzL)
    {
      AppMethodBeat.o(219341);
      return 0L;
    }
    long l;
    if (this.ZzZ)
    {
      l = this.ZAa;
      AppMethodBeat.o(219341);
      return l;
    }
    if ((this.ZzX != e.ZAw) && (this.ZzX != e.ZAx) && (this.ZzX != e.ZAy))
    {
      AppMethodBeat.o(219341);
      return -1L;
    }
    if (this.ZAa <= 0L) {
      this.ZAa = this.pzX.getDuration();
    }
    if (this.ZzH > 0L)
    {
      if (this.ZAa > 0L) {
        break label141;
      }
      this.ZAa = this.ZzH;
    }
    for (;;)
    {
      l = this.ZAa;
      AppMethodBeat.o(219341);
      return l;
      label141:
      if (Math.abs(this.ZzH - this.ZAa) * 100L / this.ZzH > 1L) {
        this.ZAa = this.ZzH;
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
    AppMethodBeat.i(219354);
    if (((this.ZzX == e.ZAw) || (this.ZzX == e.ZAx) || (this.ZzX == e.ZAy)) && (com.tencent.thumbplayer.utils.b.SDK_INT > 16)) {}
    Object localObject;
    for (;;)
    {
      try
      {
        MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.pzX.getTrackInfo();
        if ((arrayOfTrackInfo != null) || (!this.ZAh.isEmpty()) || (!this.ZAi.isEmpty())) {
          break;
        }
        AppMethodBeat.o(219354);
        return new TPTrackInfo[0];
      }
      catch (Exception localException)
      {
        this.Zyx.error("getTrackInfo, android getTrackInfo crash");
      }
      localObject = null;
    }
    int j = this.ZAh.size();
    int k = this.ZAi.size();
    if (localObject == null) {}
    TPTrackInfo[] arrayOfTPTrackInfo;
    for (int i = 0;; i = localObject.length)
    {
      arrayOfTPTrackInfo = new TPTrackInfo[i + (k + j)];
      localIterator = this.ZAh.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        arrayOfTPTrackInfo[i] = ((b)localIterator.next()).ZAr;
        i += 1;
      }
    }
    Iterator localIterator = this.ZAi.iterator();
    while (localIterator.hasNext())
    {
      arrayOfTPTrackInfo[i] = ((b)localIterator.next()).ZAr;
      i += 1;
    }
    if ((localObject == null) || (localObject.length <= 0))
    {
      AppMethodBeat.o(219354);
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
    AppMethodBeat.o(219354);
    return arrayOfTPTrackInfo;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(219346);
    this.Zyx.bDy("getVideoHeight, height:" + this.mVideoHeight);
    int i = this.mVideoHeight;
    AppMethodBeat.o(219346);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(219344);
    this.Zyx.bDy("getVideoWidth, width:" + this.mVideoWidth);
    int i = this.mVideoWidth;
    AppMethodBeat.o(219344);
    return i;
  }
  
  public final void h(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    AppMethodBeat.i(219271);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      this.Zyx.error("addAudioTrackSource, illegal argument.");
      AppMethodBeat.o(219271);
      return;
    }
    TPTrackInfo localTPTrackInfo = new TPTrackInfo();
    localTPTrackInfo.name = paramString2;
    localTPTrackInfo.isExclusive = true;
    localTPTrackInfo.isInternal = false;
    localTPTrackInfo.isSelected = false;
    localTPTrackInfo.trackType = 2;
    b localb = new b((byte)0);
    localb.ZAr = localTPTrackInfo;
    localb.url = paramString1;
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramList = (TPOptionalParam)paramString1.next();
      if (paramList.getKey() == 6) {
        localb.keyId = paramList.getParamString().value;
      }
    }
    this.Zyx.bDy("addAudioTrackSource, name:" + localTPTrackInfo.name + ", url:" + paramString2);
    this.ZAh.add(localb);
    AppMethodBeat.o(219271);
  }
  
  /* Error */
  final void iqA()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 862
    //   5: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 175	com/tencent/thumbplayer/a/a/a/e:ZzR	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 611	com/tencent/thumbplayer/a/a/a/e:ZzQ	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   19: ifnull +48 -> 67
    //   22: aload_0
    //   23: getfield 611	com/tencent/thumbplayer/a/a/a/e:ZzQ	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   26: iconst_1
    //   27: putfield 615	com/tencent/thumbplayer/a/a/a/e$a:ZAp	Z
    //   30: aload_0
    //   31: getfield 611	com/tencent/thumbplayer/a/a/a/e:ZzQ	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   34: getfield 621	com/tencent/thumbplayer/a/a/a/e$a:ZAq	Ljava/util/concurrent/Future;
    //   37: ifnull +17 -> 54
    //   40: aload_0
    //   41: getfield 611	com/tencent/thumbplayer/a/a/a/e:ZzQ	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   44: getfield 621	com/tencent/thumbplayer/a/a/a/e$a:ZAq	Ljava/util/concurrent/Future;
    //   47: iconst_1
    //   48: invokeinterface 868 2 0
    //   53: pop
    //   54: aload_0
    //   55: getfield 611	com/tencent/thumbplayer/a/a/a/e:ZzQ	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   58: aconst_null
    //   59: putfield 621	com/tencent/thumbplayer/a/a/a/e$a:ZAq	Ljava/util/concurrent/Future;
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 611	com/tencent/thumbplayer/a/a/a/e:ZzQ	Lcom/tencent/thumbplayer/a/a/a/e$a;
    //   67: aload_1
    //   68: monitorexit
    //   69: ldc_w 862
    //   72: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_2
    //   79: aload_1
    //   80: monitorexit
    //   81: ldc_w 862
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
    //   2	15	89	finally
    //   69	75	89	finally
    //   79	89	89	finally
  }
  
  /* Error */
  final void iqB()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 869
    //   5: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 181	com/tencent/thumbplayer/a/a/a/e:ZzU	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 183	com/tencent/thumbplayer/a/a/a/e:ZzV	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 183	com/tencent/thumbplayer/a/a/a/e:ZzV	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 868 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 183	com/tencent/thumbplayer/a/a/a/e:ZzV	Ljava/util/concurrent/Future;
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc_w 869
    //   43: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: ldc_w 869
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
    //   2	15	60	finally
    //   40	46	60	finally
    //   50	60	60	finally
  }
  
  final boolean iqC()
  {
    if (this.jzL) {
      return false;
    }
    return this.ZzK;
  }
  
  final void iqv()
  {
    AppMethodBeat.i(219274);
    this.pzX.setOnPreparedListener(null);
    this.pzX.setOnCompletionListener(null);
    this.pzX.setOnErrorListener(null);
    this.pzX.setOnInfoListener(null);
    this.pzX.setOnBufferingUpdateListener(null);
    this.pzX.setOnSeekCompleteListener(null);
    this.pzX.setOnVideoSizeChangedListener(null);
    iqu();
    if (this.ZzY != e.ZAC) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.ZzY = e.ZAC;
        this.Zyx.bDy("MediaPlayer release.");
        this.pzX.release();
      }
      AppMethodBeat.o(219274);
      return;
    }
  }
  
  final void iqw()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(219287);
        Object localObject1 = this.ZAl;
        this.Zyx.bDy("playerResetEnd, actionInfo:" + localObject1 + ", mSuspend:" + this.ZzZ);
        if ((localObject1 == null) || (!this.ZzZ)) {
          break label464;
        }
        c.e locale = this.ZyL;
        int i;
        if (((f)localObject1).ZAE == 1)
        {
          i = 3;
          if (locale != null) {
            locale.a(i, 1000L, 0L, Long.valueOf(((f)localObject1).Zyu));
          }
          if (Build.VERSION.SDK_INT >= 16)
          {
            if (((f)localObject1).ZAG > 0) {
              this.pzX.selectTrack(((f)localObject1).ZAG);
            }
            if (((f)localObject1).ZAH > 0) {
              this.pzX.selectTrack(((f)localObject1).ZAH);
            }
          }
          if ((((f)localObject1).position > 0L) && (!this.ZzW)) {
            this.Zyx.bDy("playerResetEnd, onPrepared(), and seek to:" + ((f)localObject1).position);
          }
        }
        try
        {
          this.pzX.seekTo((int)((f)localObject1).position);
          this.Zyx.bDy("playerResetEnd, restore state:" + ((f)localObject1).ZAI);
          if ((((f)localObject1).ZAI == e.ZAt) || (((f)localObject1).ZAI == e.ZAu) || (((f)localObject1).ZAI == e.ZAv))
          {
            this.ZzX = e.ZAw;
            localObject1 = this.ZyJ;
            if (localObject1 != null) {
              ((c.f)localObject1).qX();
            }
            this.ZzZ = false;
            this.ZAl = null;
            AppMethodBeat.o(219287);
            return;
            i = 4;
          }
        }
        catch (Exception localException2)
        {
          this.Zyx.n(localException2);
          continue;
        }
        if (localObject2.ZAI == e.ZAw) {
          break label337;
        }
      }
      finally {}
      if (localObject2.ZAI == e.ZAy)
      {
        label337:
        this.ZzX = localObject2.ZAI;
        continue;
      }
      if (localObject2.ZAI == e.ZAx)
      {
        this.Zyx.bDy("playerResetEnd,  MediaPlayer.start().");
        this.pzX.start();
        this.ZzX = localObject2.ZAI;
        this.ZzY = e.ZAx;
        iqz();
        continue;
      }
      this.Zyx.error("illegal state, state:" + localObject2.ZAI);
      this.ZzX = e.ZAB;
      iqv();
      Object localObject3 = this.ZyM;
      if (localObject3 == null) {
        continue;
      }
      ((c.d)localObject3).a(2000, aAI(-10004), 0L, 0L);
      continue;
      label464:
      if ((this.ZzF > 0) && (!this.ZzW)) {
        this.Zyx.bDy("onPrepared(), and seekto:" + this.ZzF);
      }
      try
      {
        this.pzX.seekTo(this.ZzF);
        this.ZzX = e.ZAw;
        localObject3 = this.ZyJ;
        if (localObject3 != null) {
          ((c.f)localObject3).qX();
        }
        AppMethodBeat.o(219287);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          this.Zyx.n(localException1);
        }
      }
    }
  }
  
  /* Error */
  final void iqy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 934
    //   5: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 169	com/tencent/thumbplayer/a/a/a/e:ZzO	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 167	com/tencent/thumbplayer/a/a/a/e:ZzN	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 167	com/tencent/thumbplayer/a/a/a/e:ZzN	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 868 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 167	com/tencent/thumbplayer/a/a/a/e:ZzN	Ljava/util/concurrent/Future;
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
    //   2	15	60	finally
    //   40	46	60	finally
    //   50	60	60	finally
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
    //   9: getfield 230	com/tencent/thumbplayer/a/a/a/e:Zyx	Lcom/tencent/thumbplayer/f/a;
    //   12: ldc_w 938
    //   15: invokevirtual 447	com/tencent/thumbplayer/f/a:bDy	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 187	com/tencent/thumbplayer/a/a/a/e:ZzZ	Z
    //   22: ifeq +39 -> 61
    //   25: aload_0
    //   26: getfield 216	com/tencent/thumbplayer/a/a/a/e:ZAl	Lcom/tencent/thumbplayer/a/a/a/e$f;
    //   29: ifnull +13 -> 42
    //   32: aload_0
    //   33: getfield 216	com/tencent/thumbplayer/a/a/a/e:ZAl	Lcom/tencent/thumbplayer/a/a/a/e$f;
    //   36: getstatic 510	com/tencent/thumbplayer/a/a/a/e$e:ZAy	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   39: putfield 428	com/tencent/thumbplayer/a/a/a/e$f:ZAI	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   42: aload_0
    //   43: getfield 230	com/tencent/thumbplayer/a/a/a/e:Zyx	Lcom/tencent/thumbplayer/f/a;
    //   46: ldc_w 940
    //   49: invokevirtual 943	com/tencent/thumbplayer/f/a:bDz	(Ljava/lang/String;)V
    //   52: ldc_w 936
    //   55: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: aload_0
    //   62: getfield 326	com/tencent/thumbplayer/a/a/a/e:pzX	Landroid/media/MediaPlayer;
    //   65: invokevirtual 945	android/media/MediaPlayer:pause	()V
    //   68: aload_0
    //   69: getstatic 510	com/tencent/thumbplayer/a/a/a/e$e:ZAy	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   72: putfield 331	com/tencent/thumbplayer/a/a/a/e:ZzX	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   75: aload_0
    //   76: getstatic 510	com/tencent/thumbplayer/a/a/a/e$e:ZAy	Lcom/tencent/thumbplayer/a/a/a/e$e;
    //   79: putfield 333	com/tencent/thumbplayer/a/a/a/e:ZzY	Lcom/tencent/thumbplayer/a/a/a/e$e;
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
    AppMethodBeat.i(219304);
    this.Zyx.bDy("prepare ");
    this.ZzX = e.ZAv;
    this.ZzY = e.ZAv;
    this.pzX.prepare();
    AppMethodBeat.o(219304);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(219305);
    this.Zyx.bDy("prepareAsync ");
    this.ZzX = e.ZAv;
    this.ZzY = e.ZAv;
    this.pzX.prepareAsync();
    iqx();
    AppMethodBeat.o(219305);
  }
  
  public final void release()
  {
    try
    {
      AppMethodBeat.i(219317);
      this.Zyx.bDy("release ");
      this.ZAj.release();
      iqy();
      iqA();
      iqB();
      this.ZzX = e.ZAC;
      iqv();
      this.ZyJ = null;
      this.ZyK = null;
      this.ZyL = null;
      this.ZyM = null;
      this.ZyN = null;
      this.ZyO = null;
      this.ZyP = null;
      this.Zyd = null;
      this.Zyx.bDy("release over.");
      AppMethodBeat.o(219317);
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
      AppMethodBeat.i(219312);
      this.Zyx.bDy("reset ");
      this.ZzX = e.ZAt;
      this.ZAj.reset();
      iqu();
      iqy();
      iqA();
      iqB();
      this.Zyx.bDy("reset over.");
      AppMethodBeat.o(219312);
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
    AppMethodBeat.i(219319);
    this.Zyx.bDy("seekTo, position: ".concat(String.valueOf(paramInt)));
    if (this.ZzW)
    {
      this.Zyx.bDy("current media is not seekable, ignore");
      AppMethodBeat.o(219319);
      return;
    }
    if (this.ZzZ)
    {
      if (this.ZAl != null) {
        this.ZAl.position = paramInt;
      }
      AppMethodBeat.o(219319);
      return;
    }
    this.pzX.seekTo(paramInt);
    AppMethodBeat.o(219319);
  }
  
  @TargetApi(26)
  public final void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(219321);
    this.Zyx.bDy("seekTo, position: " + paramInt1 + ", mode: " + paramInt2);
    if (this.ZzW)
    {
      this.Zyx.bDy("current media is not seekable, ignore");
      AppMethodBeat.o(219321);
      return;
    }
    if (this.ZzZ)
    {
      if (this.ZAl != null) {
        this.ZAl.position = paramInt1;
      }
      AppMethodBeat.o(219321);
      return;
    }
    MediaPlayer localMediaPlayer = this.pzX;
    if (Build.VERSION.SDK_INT < 26)
    {
      this.Zyx.bDy("os ver is too low, current sdk int:" + Build.VERSION.SDK_INT + ", is less than 26, use seekTo(int positionMs) instead");
      localMediaPlayer.seekTo(paramInt1);
      AppMethodBeat.o(219321);
      return;
    }
    if (paramInt2 == 1) {}
    for (;;)
    {
      long l = paramInt1;
      try
      {
        localMediaPlayer.seekTo(l, i);
        AppMethodBeat.o(219321);
        return;
      }
      catch (Exception localException2)
      {
        this.Zyx.n(localException2);
        try
        {
          localMediaPlayer.seekTo(paramInt1);
          AppMethodBeat.o(219321);
          return;
        }
        catch (Exception localException1)
        {
          this.Zyx.n(localException1);
          AppMethodBeat.o(219321);
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
    AppMethodBeat.i(219355);
    this.Zyx.error("selectProgram, android mediaplayer not support");
    AppMethodBeat.o(219355);
  }
  
  public final void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(219301);
    this.Zyx.bDy("selectTrack, trackID:" + paramInt + ", opaque:" + paramLong);
    int i = this.ZAh.size();
    int j = this.ZAi.size();
    c.e locale = this.ZyL;
    if ((paramInt >= 0) && (paramInt < i)) {
      try
      {
        f localf = new f((byte)0);
        localf.Zyu = paramLong;
        localf.ZAF = paramInt;
        localf.ZAE = 2;
        localf.url = this.mUrl;
        a(localf);
        ((b)this.ZAh.get(this.ZAf)).ZAr.isSelected = false;
        ((b)this.ZAh.get(paramInt)).ZAr.isSelected = true;
        this.ZAf = paramInt;
        AppMethodBeat.o(219301);
        return;
      }
      catch (Exception localException1)
      {
        this.Zyx.n(localException1);
        if (locale != null) {
          locale.a(4, aAI(-10000), 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(219301);
        return;
      }
    }
    if ((paramInt >= i) && (paramInt < i + j)) {
      try
      {
        this.ZAj.reset();
        b localb = (b)this.ZAi.get(paramInt - i);
        this.ZAj.setDataSource(localb.url);
        this.ZAj.prepare();
        AppMethodBeat.o(219301);
        return;
      }
      catch (Exception localException2)
      {
        this.Zyx.n(localException2);
        if (locale != null) {
          locale.a(4, aAI(-10000), 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(219301);
        return;
      }
    }
    paramInt -= i + j;
    if (Build.VERSION.SDK_INT < 16)
    {
      this.Zyx.error("selectTrack, android mediaplayer not support ");
      if (locale != null) {
        locale.a(4, aAI(-10001), 0L, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(219301);
      return;
    }
    if ((this.ZzX != e.ZAw) && (this.ZzX != e.ZAx) && (this.ZzX != e.ZAy))
    {
      this.Zyx.error("selectTrack, illegal state:" + this.ZzX);
      AppMethodBeat.o(219301);
      return;
    }
    Object localObject = null;
    try
    {
      MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.pzX.getTrackInfo();
      localObject = arrayOfTrackInfo;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        this.Zyx.error("getTrackInfo, android getTrackInfo crash");
      }
      localObject = localObject[paramInt];
      if (localObject.getTrackType() != 2) {
        break label587;
      }
      this.ZAg = paramInt;
      for (;;)
      {
        this.pzX.selectTrack(paramInt);
        if (locale != null) {
          locale.a(4, 1000L, 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(219301);
        return;
        if (localObject.getTrackType() != 4) {
          break;
        }
        this.ZAe = paramInt;
      }
      if (locale == null) {
        break label629;
      }
      locale.a(4, aAI(-10003), 0L, Long.valueOf(paramLong));
      AppMethodBeat.o(219301);
    }
    if ((localObject == null) || (localObject.length <= paramInt))
    {
      if (locale != null) {
        locale.a(4, aAI(-10002), 0L, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(219301);
      return;
    }
    label587:
    label629:
    return;
  }
  
  public final void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(219329);
    this.Zyx.bDy("setAudioGainRatio, : ".concat(String.valueOf(paramFloat)));
    this.ZzD = paramFloat;
    try
    {
      if (this.pzX != null) {
        this.pzX.setVolume(this.ZzD, this.ZzD);
      }
      AppMethodBeat.o(219329);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.Zyx.bDy("setAudioGainRatio ex : " + localIllegalStateException.toString());
      AppMethodBeat.o(219329);
    }
  }
  
  public final void setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(219331);
    this.Zyx.bDy("setAudioNormalizeVolumeParams not supported.");
    AppMethodBeat.o(219331);
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(219260);
    if (paramParcelFileDescriptor == null)
    {
      this.Zyx.bDy("setDataSource pfd is null ");
      paramParcelFileDescriptor = new IllegalArgumentException("pfd is null");
      AppMethodBeat.o(219260);
      throw paramParcelFileDescriptor;
    }
    this.Zyx.bDy("setDataSource pfd， pfd: " + paramParcelFileDescriptor.toString());
    this.ZzC = paramParcelFileDescriptor.getFileDescriptor();
    this.pzX.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
    this.ZzM = new com.tencent.thumbplayer.b.c(paramParcelFileDescriptor.getFileDescriptor());
    this.ZzX = e.ZAu;
    this.ZzY = e.ZAu;
    AppMethodBeat.o(219260);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(219261);
    paramITPMediaAsset = new IllegalArgumentException("setDataSource by asset, android mediaplayer not support");
    AppMethodBeat.o(219261);
    throw paramITPMediaAsset;
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(219258);
    this.Zyx.bDy("setDataSource httpHeader, url: ".concat(String.valueOf(paramString)));
    this.mUrl = paramString;
    this.mvC = paramMap;
    paramMap = Uri.parse(this.mUrl);
    this.pzX.setDataSource(this.mContext, paramMap, this.mvC);
    this.ZzM = new com.tencent.thumbplayer.b.c(paramString);
    this.ZzX = e.ZAu;
    this.ZzY = e.ZAu;
    AppMethodBeat.o(219258);
  }
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(219334);
    this.Zyx.bDy("setLoopback, : ".concat(String.valueOf(paramBoolean)));
    this.Zzz = paramBoolean;
    this.pzX.setLooping(paramBoolean);
    AppMethodBeat.o(219334);
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(219336);
    this.Zyx.bDy("setLoopback, : " + paramBoolean + ", loopStart: " + paramLong1 + ", loopEnd: " + paramLong2);
    if ((paramLong1 < 0L) || (paramLong1 > this.ZAa) || (paramLong2 > this.ZAa))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("position error, must more than 0 and less than duration");
      AppMethodBeat.o(219336);
      throw localIllegalArgumentException;
    }
    this.Zzz = paramBoolean;
    this.ZzA = paramLong1;
    this.ZzB = paramLong2;
    this.pzX.setLooping(paramBoolean);
    AppMethodBeat.o(219336);
  }
  
  public final void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(219328);
    this.Zyx.bDy("setOutputMute, : ".concat(String.valueOf(paramBoolean)));
    this.mMute = paramBoolean;
    if (paramBoolean) {}
    try
    {
      this.pzX.setVolume(0.0F, 0.0F);
      this.Zyx.bDy("setOutputMute, true");
      AppMethodBeat.o(219328);
      return;
    }
    catch (Exception localException)
    {
      this.Zyx.bDy("setOutputMute, Exception: " + localException.toString());
      AppMethodBeat.o(219328);
    }
    this.pzX.setVolume(this.ZzD, this.ZzD);
    this.Zyx.bDy("setOutputMute, false, mAudioGain: " + this.ZzD);
    AppMethodBeat.o(219328);
    return;
  }
  
  @TargetApi(23)
  public final void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(219333);
    this.Zyx.bDy("setPlaySpeedRatio, : ".concat(String.valueOf(paramFloat)));
    if (Build.VERSION.SDK_INT < 23)
    {
      this.Zyx.bDy("os version is too low: " + Build.VERSION.SDK_INT);
      AppMethodBeat.o(219333);
      return;
    }
    this.ZzE = paramFloat;
    this.Zyx.bDy("setPlaySpeedRatio play speed:".concat(String.valueOf(paramFloat)));
    try
    {
      PlaybackParams localPlaybackParams = this.pzX.getPlaybackParams();
      if (localPlaybackParams.getSpeed() != paramFloat)
      {
        localPlaybackParams.setSpeed(paramFloat);
        this.pzX.setPlaybackParams(localPlaybackParams);
      }
      AppMethodBeat.o(219333);
      return;
    }
    catch (Exception localException)
    {
      this.Zyx.n(localException);
      AppMethodBeat.o(219333);
    }
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(219242);
    switch (paramTPOptionalParam.getKey())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(219242);
      return;
      this.ZzF = ((int)paramTPOptionalParam.getParamLong().value);
      this.Zyx.bDy("setPlayerOptionalParam, start position:" + this.ZzF);
      AppMethodBeat.o(219242);
      return;
      this.ZzG = paramTPOptionalParam.getParamLong().value;
      this.Zyx.bDy("setPlayerOptionalParam, skip end position:" + this.ZzG);
      AppMethodBeat.o(219242);
      return;
      this.ZzH = paramTPOptionalParam.getParamLong().value;
      AppMethodBeat.o(219242);
      return;
      this.ZzJ = ((int)paramTPOptionalParam.getParamLong().value);
      this.Zyx.bDy("setPlayerOptionalParam, video width:" + this.ZzJ);
      AppMethodBeat.o(219242);
      return;
      this.ZzI = ((int)paramTPOptionalParam.getParamLong().value);
      this.Zyx.bDy("setPlayerOptionalParam, video height:" + this.ZzI);
      AppMethodBeat.o(219242);
      return;
      this.jzL = paramTPOptionalParam.getParamBoolean().value;
      this.ZzW = true;
      this.Zyx.bDy("setPlayerOptionalParam, is live:" + this.jzL);
      AppMethodBeat.o(219242);
      return;
      this.ZzK = paramTPOptionalParam.getParamBoolean().value;
      AppMethodBeat.o(219242);
      return;
      this.ZzP = paramTPOptionalParam.getParamLong().value;
      this.Zyx.bDy("setPlayerOptionalParam, prepare timeout:" + this.ZzP + "(ms)");
      AppMethodBeat.o(219242);
      return;
      this.ZzT = ((int)((paramTPOptionalParam.getParamLong().value + 400L) / 400L));
      this.Zyx.bDy("setPlayerOptionalParam, buffer timeout:" + paramTPOptionalParam.getParamLong().value + "(ms)");
      AppMethodBeat.o(219242);
      return;
      this.ZzS = ((int)(paramTPOptionalParam.getParamLong().value / 400L));
      this.Zyx.bDy("setPlayerOptionalParam, on buffer timeout:" + paramTPOptionalParam.getParamLong().value + "(ms)");
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(219255);
    this.Zyx.bDy("setSurface, surface: ".concat(String.valueOf(paramSurface)));
    this.Zyd = paramSurface;
    this.pzX.setSurface(paramSurface);
    this.Zyx.bDy("setSurface over, surface: ".concat(String.valueOf(paramSurface)));
    AppMethodBeat.o(219255);
  }
  
  public final void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(219257);
    this.Zyx.bDy("setSurfaceHolder, sh: ".concat(String.valueOf(paramSurfaceHolder)));
    this.Zyd = paramSurfaceHolder;
    this.pzX.setDisplay(paramSurfaceHolder);
    this.Zyx.bDy("setSurfaceHolder over, sh: ".concat(String.valueOf(paramSurfaceHolder)));
    AppMethodBeat.o(219257);
  }
  
  public final void start()
  {
    AppMethodBeat.i(219307);
    this.Zyx.bDy("start ");
    if (this.ZzZ)
    {
      if (this.ZAl != null) {
        this.ZAl.ZAI = e.ZAx;
      }
      this.Zyx.bDz("system player is busy.");
      AppMethodBeat.o(219307);
      return;
    }
    if ((this.ZzX != e.ZAw) && (this.ZzX != e.ZAy))
    {
      this.Zyx.bDz("start(), illegal state, state:" + this.ZzX);
      AppMethodBeat.o(219307);
      return;
    }
    this.pzX.start();
    this.ZzX = e.ZAx;
    this.ZzY = e.ZAx;
    if (this.ZzE != 1.0D) {
      setPlaySpeedRatio(this.ZzE);
    }
    iqz();
    AppMethodBeat.o(219307);
  }
  
  public final void stop()
  {
    try
    {
      AppMethodBeat.i(219309);
      this.Zyx.bDy("stop ");
      iqy();
      iqA();
      iqB();
      this.ZzX = e.ZAz;
      iqu();
      this.ZAf = 0;
      this.ZAl = null;
      this.ZAe = -1;
      this.ZAg = -1;
      this.ZAj.stop();
      this.ZAk = 0L;
      this.Zyx.bDy("stop over.");
      AppMethodBeat.o(219309);
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
    AppMethodBeat.i(219236);
    this.Zyx.a(new com.tencent.thumbplayer.f.b(paramb, "TPSystemMediaPlayer"));
    AppMethodBeat.o(219236);
  }
  
  static final class a
  {
    boolean ZAp;
    Future<?> ZAq;
  }
  
  static final class b
  {
    public TPTrackInfo ZAr;
    public String keyId = "";
    public String url = "";
  }
  
  final class d
    implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener
  {
    private d() {}
    
    private int aAJ(int paramInt)
    {
      if (e.this.ZzJ > 0) {
        paramInt = e.this.ZzJ;
      }
      return paramInt;
    }
    
    private int aAK(int paramInt)
    {
      if (e.this.ZzI > 0) {
        paramInt = e.this.ZzI;
      }
      return paramInt;
    }
    
    public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt) {}
    
    public final void onCompletion(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(219171);
      if (e.this.jzL)
      {
        e.this.Zyx.bDz("onCompletion, unknown err.");
        AppMethodBeat.o(219171);
        return;
      }
      e.this.Zyx.bDy("onCompletion.");
      e.this.ZzX = e.e.ZAA;
      e.this.iqv();
      e.this.iqA();
      paramMediaPlayer = e.this.ZyK;
      if (paramMediaPlayer != null) {
        paramMediaPlayer.onCompletion();
      }
      AppMethodBeat.o(219171);
    }
    
    public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      int j = 2000;
      AppMethodBeat.i(219183);
      if ((e.this.ZzX == e.e.ZAA) || (e.this.ZzX == e.e.ZAz) || (e.this.ZzX == e.e.ZAC) || (e.this.ZzX == e.e.ZAt) || (e.this.ZzX == e.e.ZAB))
      {
        e.this.Zyx.bDy("onError, illegal state:" + e.this.ZzX + ", what:" + paramInt1 + ", extra:" + paramInt2);
        AppMethodBeat.o(219183);
        return true;
      }
      e.this.Zyx.bDy("onError, what: " + paramInt1 + ", extra: " + paramInt2);
      e.this.iqy();
      e.this.iqA();
      e.this.ZzX = e.e.ZAB;
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
        e.this.iqv();
        paramMediaPlayer = e.this.ZyM;
        if (paramMediaPlayer != null) {
          paramMediaPlayer.a(i, e.aAI(paramInt1), paramInt2, 0L);
        }
        AppMethodBeat.o(219183);
        return true;
        i = 2001;
        continue;
        i = 2001;
      }
    }
    
    public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(219198);
      e.this.Zyx.bDy("mediaplayer, onInfo. what:" + paramInt1 + ", extra:" + paramInt2);
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
          if (!e.this.iqC())
          {
            if (200 != paramInt1) {
              break label377;
            }
            e.this.ZAc = true;
            locale = e.this;
          }
        }
        break;
      }
      for (;;)
      {
        synchronized (locale.ZzU)
        {
          if (locale.ZzV == null) {
            locale.ZzV = j.getScheduledExecutorServiceInstance().schedule(new e.5(locale), locale.ZzT * 400, TimeUnit.MILLISECONDS);
          }
          if (e.this.ZyL != null) {
            e.this.ZyL.a(paramInt1, 0L, 0L, null);
          }
          if (paramInt1 == 106)
          {
            paramInt1 = aAJ(paramMediaPlayer.getVideoWidth());
            paramInt2 = aAK(paramMediaPlayer.getVideoHeight());
            if (((paramInt2 != e.this.mVideoHeight) || (paramInt1 != e.this.mVideoWidth)) && (paramInt2 > 0) && (paramInt1 > 0))
            {
              e.this.mVideoHeight = paramInt2;
              e.this.mVideoWidth = paramInt1;
              if (e.this.ZyO != null) {
                e.this.ZyO.ba(e.this.mVideoWidth, e.this.mVideoHeight);
              }
            }
          }
          AppMethodBeat.o(219198);
          return true;
          paramInt1 = 200;
          break;
          paramInt1 = 201;
          break;
          paramInt1 = 106;
          break;
          e.this.ZzW = true;
          paramInt1 = paramInt2;
        }
        label377:
        e.this.ZAc = false;
        e.this.iqB();
        continue;
        label395:
        if (e.this.ZyL != null) {
          e.this.ZyL.a(106, 0L, 0L, null);
        }
      }
    }
    
    public final void onPrepared(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(219166);
      if (e.this.ZzX != e.e.ZAv)
      {
        e.this.Zyx.bDy("onPrepared() is called in a wrong situation, mState = " + e.this.ZzX);
        AppMethodBeat.o(219166);
        return;
      }
      e.this.ZzY = e.e.ZAw;
      long l = e.this.pzX.getDuration();
      if (l <= 0L) {
        e.this.ZzW = true;
      }
      e.this.Zyx.bDy("onPrepared() , mStartPositionMs=" + e.this.ZzF + ", duration:" + l + ", mIsLive:" + e.this.jzL);
      e.this.iqy();
      e.this.iqw();
      AppMethodBeat.o(219166);
    }
    
    public final void onSeekComplete(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(219200);
      if (e.this.pzX == null)
      {
        AppMethodBeat.o(219200);
        return;
      }
      e.this.Zyx.bDy("onSeekComplete().");
      if ((e.e.ZAw != e.this.ZzX) && (e.this.ZyN != null)) {
        e.this.ZyN.cYp();
      }
      AppMethodBeat.o(219200);
    }
    
    public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(219206);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        e.this.Zyx.error("onVideoSizeChanged() size error, width:" + paramInt1 + " height:" + paramInt2);
        AppMethodBeat.o(219206);
        return;
      }
      paramInt1 = aAJ(paramInt1);
      paramInt2 = aAK(paramInt2);
      try
      {
        if (((paramInt1 != e.this.mVideoWidth) || (paramInt2 != e.this.mVideoHeight)) && (paramInt2 > 0) && (paramInt1 > 0)) {
          e.this.ZyO.ba(paramInt1, paramInt2);
        }
      }
      catch (Exception paramMediaPlayer)
      {
        for (;;)
        {
          e.this.Zyx.bDz(paramMediaPlayer.toString());
        }
      }
      e.this.mVideoWidth = paramInt1;
      e.this.mVideoHeight = paramInt2;
      e.this.Zyx.bDy("onVideoSizeChanged(), width:" + paramInt1 + " height:" + paramInt2);
      AppMethodBeat.o(219206);
    }
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(219218);
      ZAt = new e("IDLE", 0);
      ZAu = new e("INITIALIZED", 1);
      ZAv = new e("PREPARING", 2);
      ZAw = new e("PREPARED", 3);
      ZAx = new e("STARTED", 4);
      ZAy = new e("PAUSED", 5);
      ZAz = new e("STOPPED", 6);
      ZAA = new e("COMPLETE", 7);
      ZAB = new e("ERROR", 8);
      ZAC = new e("RELEASE", 9);
      ZAD = new e[] { ZAt, ZAu, ZAv, ZAw, ZAx, ZAy, ZAz, ZAA, ZAB, ZAC };
      AppMethodBeat.o(219218);
    }
    
    private e() {}
  }
  
  static final class f
  {
    int ZAE;
    int ZAF;
    int ZAG;
    int ZAH;
    e.e ZAI;
    long Zyu;
    long position;
    String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */