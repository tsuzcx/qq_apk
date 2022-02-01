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
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.f;
import com.tencent.thumbplayer.a.a.c.h;
import com.tencent.thumbplayer.a.a.c.i;
import com.tencent.thumbplayer.a.a.c.j;
import com.tencent.thumbplayer.b.e;
import com.tencent.thumbplayer.b.f.a;
import com.tencent.thumbplayer.b.f.b;
import com.tencent.thumbplayer.b.f.e;
import com.tencent.thumbplayer.b.i.a;
import com.tencent.thumbplayer.b.k;
import com.tencent.thumbplayer.b.m;
import com.tencent.thumbplayer.b.n;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class c
  implements com.tencent.thumbplayer.a.a.b
{
  private com.tencent.thumbplayer.a.a.c.e LWK;
  com.tencent.thumbplayer.a.a.c.b LWL;
  com.tencent.thumbplayer.a.a.c.d LWM;
  com.tencent.thumbplayer.a.a.c.c LWN;
  c.f LWO;
  c.j LWP;
  c.h LWQ;
  Object LXA;
  Future<?> LXB;
  boolean LXC;
  boolean LXD;
  d LXE;
  boolean LXF;
  private long LXG;
  long LXH;
  long LXI;
  boolean LXJ;
  int LXK;
  int LXL;
  private int LXM;
  private int LXN;
  private List<b> LXO;
  private e LXP;
  @TargetApi(16)
  private MediaPlayer.OnTimedTextListener LXQ;
  boolean LXf;
  long LXg;
  long LXh;
  private FileDescriptor LXi;
  private float LXj;
  private float LXk;
  int LXl;
  long LXm;
  private long LXn;
  private int LXo;
  private int LXp;
  private boolean LXq;
  private c LXr;
  private c.a LXs;
  private com.tencent.thumbplayer.c.b LXt;
  private Future<?> LXu;
  private Object LXv;
  private long LXw;
  private Future<?> LXx;
  private final Object LXy;
  int LXz;
  private Map<String, String> iFC;
  MediaPlayer lqh;
  private Context mContext;
  private String mUrl;
  int mVideoHeight;
  int mVideoWidth;
  private boolean uac;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(191730);
    this.mContext = null;
    this.LXf = false;
    this.LXg = 0L;
    this.LXh = 0L;
    this.LXj = 1.0F;
    this.LXk = 1.0F;
    this.LXl = 0;
    this.LXm = -1L;
    this.uac = false;
    this.LXn = -1L;
    this.LXo = -1;
    this.LXp = -1;
    this.LXq = true;
    this.LXu = null;
    this.LXv = new Object();
    this.LXw = 25000L;
    this.LXx = null;
    this.LXy = new Object();
    this.LXz = 30;
    this.LXA = new Object();
    this.LXB = null;
    this.LXC = false;
    this.LXD = false;
    this.LXG = 0L;
    this.LXH = 0L;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.LXI = 0L;
    this.LXJ = false;
    this.LXK = 0;
    this.LXL = -1;
    this.LXM = 0;
    this.LXN = -1;
    this.LXO = new ArrayList();
    this.LXP = null;
    this.LXQ = new MediaPlayer.OnTimedTextListener()
    {
      public final void onTimedText(MediaPlayer paramAnonymousMediaPlayer, TimedText paramAnonymousTimedText)
      {
        AppMethodBeat.i(191717);
        m localm;
        if (c.this.LWQ != null)
        {
          localm = new m();
          if (paramAnonymousTimedText == null) {
            break label79;
          }
        }
        label79:
        for (paramAnonymousMediaPlayer = paramAnonymousTimedText.getText();; paramAnonymousMediaPlayer = "")
        {
          localm.LZk = paramAnonymousMediaPlayer;
          localm.LZl = c.this.LXL;
          localm.LWv = c.this.getCurrentPositionMs();
          c.this.LWQ.a(localm);
          AppMethodBeat.o(191717);
          return;
        }
      }
    };
    this.mContext = paramContext;
    this.LXr = new c((byte)0);
    paramContext = new b((byte)0);
    paramContext.LXS = new n();
    paramContext.LXS.isSelected = true;
    paramContext.LXS.name = "audio_1";
    this.LXO.add(paramContext);
    this.lqh = new a();
    this.lqh.setOnPreparedListener(this.LXr);
    this.lqh.setOnCompletionListener(this.LXr);
    this.lqh.setOnErrorListener(this.LXr);
    this.lqh.setOnInfoListener(this.LXr);
    this.lqh.setOnBufferingUpdateListener(this.LXr);
    this.lqh.setOnSeekCompleteListener(this.LXr);
    this.lqh.setOnVideoSizeChangedListener(this.LXr);
    if (Build.VERSION.SDK_INT >= 16) {
      this.lqh.setOnTimedTextListener(this.LXQ);
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.lqh.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
      paramContext = Looper.myLooper();
      if (paramContext == null) {
        break label478;
      }
      this.LXs = new c.a(paramContext, this);
    }
    for (;;)
    {
      this.LXE = d.LXU;
      AppMethodBeat.o(191730);
      return;
      this.lqh.setAudioStreamType(3);
      break;
      label478:
      paramContext = Looper.getMainLooper();
      if (paramContext != null) {
        this.LXs = new c.a(paramContext, this);
      } else {
        this.LXs = null;
      }
    }
  }
  
  private void a(e parame)
  {
    for (;;)
    {
      Object localObject1;
      float f1;
      float f2;
      try
      {
        AppMethodBeat.i(191740);
        localObject1 = parame.url;
        parame.position = getCurrentPositionMs();
        parame.LYj = this.LXE;
        parame.LYh = this.LXN;
        parame.LYi = this.LXL;
        f1 = this.LXj;
        f2 = this.LXk;
        boolean bool = this.LXf;
        this.lqh.reset();
        Object localObject2;
        if (this.LXi != null)
        {
          this.lqh.setDataSource(this.LXi);
          break label422;
          this.lqh.setVolume(this.LXj, this.LXj);
          break label437;
          cj(f2);
          if (bool) {
            this.lqh.setLooping(bool);
          }
          localObject1 = this.LXP;
          if ((localObject1 != null) && (((e)localObject1).LYf != parame.LYf))
          {
            localObject2 = this.LWM;
            if (((e)localObject1).LYf != 1) {
              break label416;
            }
            i = 3;
            if (localObject2 != null) {
              ((com.tencent.thumbplayer.a.a.c.d)localObject2).a(i, ((e)localObject1).LWx, 0L, null);
            }
            parame.LYj = ((e)localObject1).LYj;
            parame.position = ((e)localObject1).position;
          }
          this.LXP = parame;
          if ((parame.LYj == d.LXW) || (parame.LYj == d.LXX) || (parame.LYj == d.LXY) || (parame.LYj == d.LXZ))
          {
            this.lqh.prepareAsync();
            fWo();
          }
          AppMethodBeat.o(191740);
          return;
        }
        i = parame.LYg;
        if (i > 0)
        {
          localObject2 = (b)this.LXO.get(i);
          com.tencent.thumbplayer.a.a.c.d locald = this.LWM;
          if (locald != null)
          {
            i.a locala = new i.a();
            locala.LYY = ((b)localObject2).url;
            locala.LXT = ((b)localObject2).LXT;
            locald.a(1011, 0L, 0L, locala);
          }
        }
        if ((this.iFC != null) && (!this.iFC.isEmpty()))
        {
          localObject1 = Uri.parse((String)localObject1);
          this.lqh.setDataSource(this.mContext, (Uri)localObject1, this.iFC);
        }
      }
      finally {}
      this.lqh.setDataSource((String)localObject1);
      break label422;
      label416:
      int i = 4;
      continue;
      label422:
      if ((f1 <= 1.0F) && (f1 >= 1.0F)) {
        label437:
        if (f2 <= 1.0F) {
          if (f2 >= 1.0F) {}
        }
      }
    }
  }
  
  static int aha(int paramInt)
  {
    if (paramInt < 0) {
      return 10000000 - paramInt;
    }
    return 10000000 + paramInt;
  }
  
  private void fWo()
  {
    AppMethodBeat.i(191767);
    synchronized (this.LXy)
    {
      if (!fWr())
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "startCheckBufferingTimer, forbidden check buffer by position");
        AppMethodBeat.o(191767);
        return;
      }
      if (this.LXx == null) {
        this.LXx = com.tencent.thumbplayer.utils.f.getScheduledExecutorServiceInstance().scheduleAtFixedRate(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(191715);
            c localc = c.this;
            long l1 = localc.getCurrentPositionMs();
            long l2 = localc.LXH;
            localc.LXH = l1;
            if (localc.LXE != c.d.LXY)
            {
              if ((localc.LXE == c.d.LXZ) && (localc.LXJ))
              {
                com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, pause state and send end buffering");
                localc.LXJ = false;
                localc.LXK = 0;
                if (localc.LWM != null) {
                  localc.LWM.a(201, 0L, 0L, null);
                }
              }
              AppMethodBeat.o(191715);
              return;
            }
            if (localc.LXf) {
              if ((localc.LXh > 0L) && (l1 >= localc.LXh) && (!localc.LXD))
              {
                com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, skip end, curPosition:" + l1 + ", mSkipEndPositionMs:" + localc.LXm);
                localc.lqh.seekTo((int)localc.LXg);
              }
            }
            for (;;)
            {
              if ((l1 == l2) && (l1 > 0L))
              {
                int i = localc.LXK + 1;
                localc.LXK = i;
                if ((i >= 3) && (!localc.LXJ))
                {
                  localc.LXJ = true;
                  com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, position no change,send start buffering");
                  if (localc.LWM != null) {
                    localc.LWM.a(200, 0L, 0L, null);
                  }
                }
                if (localc.LXK < localc.LXz) {
                  break label499;
                }
                com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent post error");
                localc.lqh.stop();
                localc.LXE = c.d.LYc;
                localc.LXJ = false;
                localc.fWp();
                if (localc.LWN == null) {
                  break label499;
                }
                localc.LWN.a(2001, c.aha(-110), 0L, 0L);
                AppMethodBeat.o(191715);
                return;
                if ((localc.LXm > 0L) && (l1 >= localc.getDurationMs() - localc.LXm)) {
                  try
                  {
                    localc.lqh.pause();
                    localc.lqh.stop();
                    localc.LXE = c.d.LYb;
                    localc.fWp();
                    if (localc.LWL != null) {
                      localc.LWL.onCompletion();
                    }
                    AppMethodBeat.o(191715);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException);
                    }
                  }
                }
              }
            }
            if (localc.LXJ)
            {
              com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, position change, send end buffering");
              if (localc.LWM != null) {
                localc.LWM.a(201, 0L, 0L, null);
              }
            }
            localc.LXJ = false;
            localc.LXK = 0;
            localc.LXC = true;
            label499:
            AppMethodBeat.o(191715);
          }
        }, 0L, 400L, TimeUnit.MILLISECONDS);
      }
      AppMethodBeat.o(191767);
      return;
    }
  }
  
  public final void M(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(191753);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "switchDefinition, defUrl: ".concat(String.valueOf(paramString)));
    if (this.lqh == null)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "switchDefinition, player is null");
      AppMethodBeat.o(191753);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "switchDefinition, defUrl is null");
      AppMethodBeat.o(191753);
      return;
    }
    this.mUrl = paramString;
    e locale = new e((byte)0);
    locale.LWx = paramLong;
    locale.LYg = this.LXM;
    locale.LYf = 1;
    locale.url = paramString;
    try
    {
      a(locale);
      AppMethodBeat.o(191753);
      return;
    }
    catch (Exception paramString)
    {
      paramString = new IllegalStateException("playerResetStart");
      AppMethodBeat.o(191753);
      throw paramString;
    }
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(191732);
    parama = new IllegalStateException("system Mediaplayer cannot support audio frame out");
    AppMethodBeat.o(191732);
    throw parama;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    this.LWL = paramb;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.c paramc)
  {
    this.LWN = paramc;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    this.LWM = paramd;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.e parame)
  {
    this.LWK = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.LWO = paramf;
  }
  
  public final void a(c.h paramh)
  {
    this.LWQ = paramh;
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(191731);
    parami = new IllegalStateException("system Mediaplayer cannot support video frame out");
    AppMethodBeat.o(191731);
    throw parami;
  }
  
  public final void a(c.j paramj)
  {
    this.LWP = paramj;
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(191737);
    parama = new IllegalArgumentException("setDataSource by asset, android mediaplayer not support");
    AppMethodBeat.o(191737);
    throw parama;
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama, int paramInt, long paramLong) {}
  
  public final void a(e parame, com.tencent.thumbplayer.b.d paramd)
  {
    AppMethodBeat.i(191765);
    if (this.LXt != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = parame.width;
      localTPImageGeneratorParams.height = parame.height;
      localTPImageGeneratorParams.format = parame.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = parame.requestedTimeMsToleranceBefore;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = parame.requestedTimeMsToleranceAfter;
      this.LXt.a(getCurrentPositionMs(), localTPImageGeneratorParams, paramd);
    }
    AppMethodBeat.o(191765);
  }
  
  public final void aQ(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191742);
    int i = this.LXO.size();
    com.tencent.thumbplayer.a.a.c.d locald = this.LWM;
    if ((paramInt >= 0) && (paramInt < i)) {
      try
      {
        e locale = new e((byte)0);
        locale.LWx = paramLong;
        locale.LYg = paramInt;
        locale.LYf = 2;
        locale.url = this.mUrl;
        a(locale);
        ((b)this.LXO.get(this.LXM)).LXS.isSelected = false;
        ((b)this.LXO.get(paramInt)).LXS.isSelected = true;
        this.LXM = paramInt;
        AppMethodBeat.o(191742);
        return;
      }
      catch (Exception localException1)
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException1);
        if (locald != null) {
          locald.a(4, aha(-10000), 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(191742);
        return;
      }
    }
    paramInt -= i;
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "selectTrack, android mediaplayer not support ");
      if (locald != null) {
        locald.a(4, aha(-10001), 0L, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(191742);
      return;
    }
    if ((this.LXE != d.LXX) && (this.LXE != d.LXY) && (this.LXE != d.LXZ))
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "selectTrack, illegal state:" + this.LXE);
      AppMethodBeat.o(191742);
      return;
    }
    Object localObject = null;
    try
    {
      MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.lqh.getTrackInfo();
      localObject = arrayOfTrackInfo;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "getTrackInfo, android getTrackInfo crash");
      }
      localObject = localObject[paramInt];
      if (localObject.getTrackType() != 2) {
        break label420;
      }
      this.LXN = paramInt;
      for (;;)
      {
        this.lqh.selectTrack(paramInt);
        if (locald != null) {
          locald.a(4, 1000L, 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(191742);
        return;
        label420:
        if (localObject.getTrackType() != 4) {
          break;
        }
        this.LXL = paramInt;
      }
      if (locald == null) {
        break label462;
      }
      locald.a(4, aha(-10003), 0L, Long.valueOf(paramLong));
      label462:
      AppMethodBeat.o(191742);
    }
    if ((localObject == null) || (localObject.length <= paramInt))
    {
      if (locald != null) {
        locald.a(4, aha(-10002), 0L, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(191742);
      return;
    }
  }
  
  @TargetApi(16)
  public final void aR(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191743);
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "deselectTrack, android mediaplayer not support ");
      AppMethodBeat.o(191743);
      return;
    }
    this.lqh.deselectTrack(paramInt);
    AppMethodBeat.o(191743);
  }
  
  public final void aS(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191764);
    com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "selectProgram, android mediaplayer not support");
    AppMethodBeat.o(191764);
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      AppMethodBeat.i(191736);
      if (paramParcelFileDescriptor == null)
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource pfd is null ");
        paramParcelFileDescriptor = new IllegalArgumentException("pfd is null");
        AppMethodBeat.o(191736);
        throw paramParcelFileDescriptor;
      }
    }
    finally {}
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource pfd， pfd: " + paramParcelFileDescriptor.toString());
    this.LXi = paramParcelFileDescriptor.getFileDescriptor();
    this.lqh.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
    this.LXt = new com.tencent.thumbplayer.c.b(paramParcelFileDescriptor.getFileDescriptor());
    this.LXE = d.LXV;
    AppMethodBeat.o(191736);
  }
  
  public final void b(com.tencent.thumbplayer.b.f paramf)
  {
    switch (paramf.key)
    {
    default: 
      return;
    case 100: 
      this.LXl = ((int)paramf.LYO.value);
      return;
    case 500: 
      this.LXm = paramf.LYO.value;
      return;
    case 1: 
      this.LXn = paramf.LYO.value;
      return;
    case 2: 
      this.LXp = ((int)paramf.LYO.value);
      return;
    case 3: 
      this.LXo = ((int)paramf.LYO.value);
      return;
    case 4: 
      this.uac = paramf.LYN.value;
      return;
    case 5: 
      this.LXq = paramf.LYN.value;
      return;
    case 207: 
      this.LXw = paramf.LYO.value;
      return;
    }
    this.LXz = ((int)((paramf.LYO.value + 400L) / 400L));
  }
  
  @TargetApi(16)
  public final void bk(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(191738);
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addSubtitleSource android mediaplayer not support ");
      AppMethodBeat.o(191738);
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      String str = "";
      if (paramString2.equals("text/x-subrip"))
      {
        paramString3 = "application/x-subrip";
        if (Build.VERSION.SDK_INT >= 28) {
          paramString3 = "application/x-subrip";
        }
      }
      while (TextUtils.isEmpty(paramString3))
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addTimedTextSource, mimeType no support.");
        AppMethodBeat.o(191738);
        return;
        paramString3 = str;
        if (paramString2.equals("text/vtt"))
        {
          paramString3 = str;
          if (Build.VERSION.SDK_INT >= 28) {
            paramString3 = "application/x-subrip";
          }
        }
      }
      try
      {
        this.lqh.addTimedTextSource(this.mContext, Uri.parse(paramString1), paramString3);
        AppMethodBeat.o(191738);
        return;
      }
      catch (Exception paramString1)
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", paramString1, "addTimedTextSource error");
        AppMethodBeat.o(191738);
        return;
      }
    }
    com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addTimedTextSource, mimeType no support.");
    AppMethodBeat.o(191738);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191758);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setLoopback, : " + paramBoolean + ", loopStart: " + paramLong1 + ", loopEnd: " + paramLong2);
    Object localObject;
    if (this.LXE == d.LYc)
    {
      localObject = new IllegalStateException("state error, current state is error state");
      AppMethodBeat.o(191758);
      throw ((Throwable)localObject);
    }
    if ((paramLong1 < 0L) || (paramLong1 > this.LXG) || (paramLong2 > this.LXG))
    {
      localObject = new IllegalArgumentException("position error, must more than 0 and less than duration");
      AppMethodBeat.o(191758);
      throw ((Throwable)localObject);
    }
    this.LXf = paramBoolean;
    this.LXg = paramLong1;
    this.LXh = paramLong2;
    this.lqh.setLooping(paramBoolean);
    AppMethodBeat.o(191758);
  }
  
  public final void ci(float paramFloat)
  {
    AppMethodBeat.i(191755);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setAudioGainRatio, : ".concat(String.valueOf(paramFloat)));
    this.LXj = paramFloat;
    try
    {
      if (this.lqh != null) {
        this.lqh.setVolume(this.LXj, this.LXj);
      }
      AppMethodBeat.o(191755);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setAudioGainRatio ex : " + localIllegalStateException.toString());
      AppMethodBeat.o(191755);
    }
  }
  
  @TargetApi(23)
  public final void cj(float paramFloat)
  {
    AppMethodBeat.i(191756);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setPlaySpeedRatio, : ".concat(String.valueOf(paramFloat)));
    if (Build.VERSION.SDK_INT < 23)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "os version is too low: " + Build.VERSION.SDK_INT);
      AppMethodBeat.o(191756);
      return;
    }
    this.LXk = paramFloat;
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setPlaySpeedRatio play speed:".concat(String.valueOf(paramFloat)));
    try
    {
      PlaybackParams localPlaybackParams = this.lqh.getPlaybackParams();
      if (localPlaybackParams.getSpeed() != paramFloat)
      {
        localPlaybackParams.setSpeed(paramFloat);
        this.lqh.setPlaybackParams(localPlaybackParams);
      }
      AppMethodBeat.o(191756);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException);
      AppMethodBeat.o(191756);
    }
  }
  
  @TargetApi(16)
  public final n[] fWg()
  {
    AppMethodBeat.i(191763);
    if ((this.LXE == d.LXX) || (this.LXE == d.LXY) || (this.LXE == d.LXZ)) {}
    Object localObject;
    for (;;)
    {
      try
      {
        MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.lqh.getTrackInfo();
        if ((arrayOfTrackInfo != null) || (!this.LXO.isEmpty())) {
          break;
        }
        AppMethodBeat.o(191763);
        return new n[0];
      }
      catch (Exception localException)
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "getTrackInfo, android getTrackInfo crash");
      }
      localObject = null;
    }
    int j = this.LXO.size();
    if (localObject == null) {}
    n[] arrayOfn;
    Iterator localIterator;
    for (int i = 0;; i = localObject.length)
    {
      arrayOfn = new n[i + j];
      localIterator = this.LXO.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        arrayOfn[i] = ((b)localIterator.next()).LXS;
        i += 1;
      }
    }
    if (localObject == null)
    {
      AppMethodBeat.o(191763);
      return arrayOfn;
    }
    int m = localObject.length;
    int k = 0;
    j = i;
    if (k < m)
    {
      localIterator = localObject[k];
      n localn = new n();
      localn.name = localIterator.getLanguage();
      i = localIterator.getTrackType();
      if (2 == i) {
        i = 2;
      }
      for (;;)
      {
        localn.trackType = i;
        arrayOfn[j] = localn;
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
    AppMethodBeat.o(191763);
    return arrayOfn;
  }
  
  public final k[] fWh()
  {
    return new k[0];
  }
  
  final void fWm()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(191741);
        Object localObject1 = this.LXP;
        if (localObject1 == null) {
          break label334;
        }
        com.tencent.thumbplayer.a.a.c.d locald = this.LWM;
        int i;
        if (((e)localObject1).LYf == 1)
        {
          i = 3;
          if (locald != null) {
            locald.a(i, 1000L, 0L, Long.valueOf(((e)localObject1).LWx));
          }
          if (Build.VERSION.SDK_INT >= 16)
          {
            if (((e)localObject1).LYh > 0) {
              this.lqh.selectTrack(((e)localObject1).LYh);
            }
            if (((e)localObject1).LYi > 0) {
              this.lqh.selectTrack(((e)localObject1).LYi);
            }
          }
          if ((((e)localObject1).position > 0L) && (!this.LXD)) {
            com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared(), and seekto:" + this.LXl);
          }
        }
        try
        {
          this.lqh.seekTo((int)((e)localObject1).position);
          if ((((e)localObject1).LYj == d.LXU) || (((e)localObject1).LYj == d.LXV) || (((e)localObject1).LYj == d.LXW))
          {
            localObject1 = this.LWK;
            if (localObject1 != null) {
              ((com.tencent.thumbplayer.a.a.c.e)localObject1).ta();
            }
            this.LXE = d.LXX;
            this.LXP = null;
            AppMethodBeat.o(191741);
            return;
            i = 4;
          }
        }
        catch (Exception localException2)
        {
          com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException2);
          continue;
        }
        if (localObject2.LYj == d.LXX) {
          break label259;
        }
      }
      finally {}
      if (localObject2.LYj == d.LXZ)
      {
        label259:
        this.LXE = localObject2.LYj;
        continue;
      }
      if (localObject2.LYj == d.LXY)
      {
        this.lqh.start();
        this.LXE = localObject2.LYj;
        continue;
      }
      this.LXE = d.LYc;
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "illegal state, state:" + localObject2.LYj);
      continue;
      label334:
      if ((this.LXl > 0) && (!this.LXD)) {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared(), and seekto:" + this.LXl);
      }
      try
      {
        this.lqh.seekTo(this.LXl);
        com.tencent.thumbplayer.a.a.c.e locale = this.LWK;
        if (locale != null) {
          locale.ta();
        }
        AppMethodBeat.o(191741);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException1);
        }
      }
    }
  }
  
  /* Error */
  final void fWn()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 819
    //   5: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 157	com/tencent/thumbplayer/a/a/a/c:LXv	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 155	com/tencent/thumbplayer/a/a/a/c:LXu	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 155	com/tencent/thumbplayer/a/a/a/c:LXu	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 825 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 155	com/tencent/thumbplayer/a/a/a/c:LXu	Ljava/util/concurrent/Future;
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc_w 819
    //   43: invokestatic 317	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: ldc_w 819
    //   55: invokestatic 317	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_2
    //   59: athrow
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	c
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
  final void fWp()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 827
    //   5: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 165	com/tencent/thumbplayer/a/a/a/c:LXy	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 163	com/tencent/thumbplayer/a/a/a/c:LXx	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 163	com/tencent/thumbplayer/a/a/a/c:LXx	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 825 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 163	com/tencent/thumbplayer/a/a/a/c:LXx	Ljava/util/concurrent/Future;
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc_w 827
    //   43: invokestatic 317	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: ldc_w 827
    //   55: invokestatic 317	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_2
    //   59: athrow
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	c
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
  final void fWq()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 829
    //   5: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 169	com/tencent/thumbplayer/a/a/a/c:LXA	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 171	com/tencent/thumbplayer/a/a/a/c:LXB	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 171	com/tencent/thumbplayer/a/a/a/c:LXB	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 825 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 171	com/tencent/thumbplayer/a/a/a/c:LXB	Ljava/util/concurrent/Future;
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc_w 829
    //   43: invokestatic 317	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: ldc_w 829
    //   55: invokestatic 317	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_2
    //   59: athrow
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	c
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
  
  final boolean fWr()
  {
    AppMethodBeat.i(191770);
    if (this.uac)
    {
      AppMethodBeat.o(191770);
      return false;
    }
    if (getDurationMs() <= 0L)
    {
      AppMethodBeat.o(191770);
      return false;
    }
    boolean bool = this.LXq;
    AppMethodBeat.o(191770);
    return bool;
  }
  
  public final void g(String paramString1, String paramString2, List<com.tencent.thumbplayer.b.f> paramList)
  {
    AppMethodBeat.i(191739);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addAudioTrackSource, illegal argument.");
    }
    n localn = new n();
    localn.name = paramString2;
    localn.isExclusive = true;
    localn.isInternal = false;
    localn.isSelected = false;
    paramString2 = new b((byte)0);
    paramString2.LXS = localn;
    paramString2.url = paramString1;
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramList = (com.tencent.thumbplayer.b.f)paramString1.next();
      if (paramList.key == 6) {
        paramString2.LXT = paramList.LYP.value;
      }
    }
    this.LXO.add(paramString2);
    AppMethodBeat.o(191739);
  }
  
  public final long getBufferedDurationMs()
  {
    return this.LXI;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(191760);
    if ((this.lqh == null) || (this.LXE == d.LXU) || (this.LXE == d.LXV) || (this.LXE == d.LXW) || (this.LXE == d.LYa) || (this.LXE == d.LXX))
    {
      l = this.LXl;
      AppMethodBeat.o(191760);
      return l;
    }
    long l = this.lqh.getCurrentPosition();
    AppMethodBeat.o(191760);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(191759);
    if ((this.LXE != d.LXX) && (this.LXE != d.LXY) && (this.LXE != d.LXZ))
    {
      AppMethodBeat.o(191759);
      return -1L;
    }
    if (this.LXG <= 0L) {
      this.LXG = this.lqh.getDuration();
    }
    if (this.LXn > 0L) {
      if (this.LXG > 0L) {
        break label106;
      }
    }
    for (this.LXG = this.LXn;; this.LXG = this.LXn) {
      label106:
      do
      {
        long l = this.LXG;
        AppMethodBeat.o(191759);
        return l;
      } while ((this.LXG <= 0L) || (Math.abs(this.LXn - this.LXG) * 100L / this.LXn <= 1L));
    }
  }
  
  public final long getPropertyLong(int paramInt)
  {
    return -1L;
  }
  
  public final String getPropertyString(int paramInt)
  {
    return null;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(191762);
    if (this.mVideoHeight <= 0) {
      this.mVideoHeight = this.lqh.getVideoHeight();
    }
    if ((this.mVideoHeight <= 0) && (this.LXo > 0) && ((this.LXE == d.LXX) || (this.LXE == d.LXY) || (this.LXE == d.LXZ))) {
      this.mVideoHeight = this.LXo;
    }
    int i = this.mVideoHeight;
    AppMethodBeat.o(191762);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(191761);
    if (this.mVideoWidth <= 0) {
      this.mVideoWidth = this.lqh.getVideoWidth();
    }
    if (((this.LXE == d.LXX) || (this.LXE == d.LXY) || (this.LXE == d.LXZ)) && (this.mVideoWidth <= 0) && (this.LXp > 0)) {
      this.mVideoWidth = this.LXp;
    }
    int i = this.mVideoWidth;
    AppMethodBeat.o(191761);
    return i;
  }
  
  @TargetApi(26)
  public final void kS(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(191752);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "seekTo, position: " + paramInt1 + ", mode: " + paramInt2);
    if (this.LXD)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "current media is not seekable, ignore");
      AppMethodBeat.o(191752);
      return;
    }
    if (Build.VERSION.SDK_INT < 26)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "os ver is too low, current sdk int:" + Build.VERSION.SDK_INT + ", is less than 26, use seekTo(int positionMs) instead");
      this.lqh.seekTo(paramInt1);
      AppMethodBeat.o(191752);
      return;
    }
    if (paramInt2 == 1) {}
    for (;;)
    {
      try
      {
        this.lqh.seekTo(paramInt1, i);
        AppMethodBeat.o(191752);
        return;
      }
      catch (Exception localException1)
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException1);
        try
        {
          this.lqh.seekTo(paramInt1);
          AppMethodBeat.o(191752);
          return;
        }
        catch (Exception localException2)
        {
          com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException2);
          AppMethodBeat.o(191752);
        }
      }
      if (paramInt2 == 2) {
        i = 1;
      } else if (paramInt2 == 3) {
        i = 2;
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(191747);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "pause ");
    this.lqh.pause();
    this.LXE = d.LXZ;
    AppMethodBeat.o(191747);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(191744);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "prepare ");
    this.LXE = d.LXW;
    this.lqh.prepare();
    AppMethodBeat.o(191744);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(191745);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "prepareAsync ");
    this.LXE = d.LXW;
    this.lqh.prepareAsync();
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "startCheckPrepareTimeoutTimer");
    synchronized (this.LXv)
    {
      if (this.LXu == null) {
        this.LXu = com.tencent.thumbplayer.utils.f.getScheduledExecutorServiceInstance().schedule(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(191714);
            if (c.this.LXE == c.d.LXW) {
              com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "startCheckPrepareTimeoutTimer, post error");
            }
            try
            {
              c.this.lqh.stop();
              c.this.LXE = c.d.LYc;
              c.this.fWn();
              if (c.this.LWN != null) {
                c.this.LWN.a(2001, c.aha(-110), 0L, 0L);
              }
              AppMethodBeat.o(191714);
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException);
              }
            }
          }
        }, this.LXw, TimeUnit.MILLISECONDS);
      }
      AppMethodBeat.o(191745);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(191750);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "release ");
    this.LXC = false;
    fWn();
    fWp();
    fWq();
    this.lqh.reset();
    this.lqh.release();
    this.LWK = null;
    this.LWL = null;
    this.LWM = null;
    this.LWN = null;
    this.LWO = null;
    this.LWP = null;
    this.LWQ = null;
    this.LXs = null;
    this.LXE = d.LYd;
    AppMethodBeat.o(191750);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(191749);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "reset ");
    this.LXC = false;
    this.lqh.reset();
    fWn();
    fWp();
    fWq();
    this.LXE = d.LXU;
    AppMethodBeat.o(191749);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(191751);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "seekTo, position: ".concat(String.valueOf(paramInt)));
    if (this.LXD)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "current media is not seekable, ignore");
      AppMethodBeat.o(191751);
      return;
    }
    this.lqh.seekTo(paramInt);
    AppMethodBeat.o(191751);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(191734);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource， url: ".concat(String.valueOf(paramString)));
    this.mUrl = paramString;
    this.lqh.setDataSource(paramString);
    this.LXt = new com.tencent.thumbplayer.c.b(paramString);
    this.LXE = d.LXV;
    AppMethodBeat.o(191734);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(191735);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource httpHeader， url: ".concat(String.valueOf(paramString)));
    this.mUrl = paramString;
    this.iFC = paramMap;
    paramMap = Uri.parse(this.mUrl);
    this.lqh.setDataSource(this.mContext, paramMap, this.iFC);
    this.LXt = new com.tencent.thumbplayer.c.b(paramString);
    this.LXE = d.LXV;
    AppMethodBeat.o(191735);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(191733);
    this.lqh.setSurface(paramSurface);
    AppMethodBeat.o(191733);
  }
  
  public final void start()
  {
    AppMethodBeat.i(191746);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "start ");
    this.LXC = false;
    this.lqh.start();
    this.LXE = d.LXY;
    if (this.LXk != 1.0D) {
      cj(this.LXk);
    }
    fWo();
    if ((this.LXl == 0) && (!this.LXD)) {
      this.LXs.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(191713);
          if ((!c.this.LXC) && (c.this.LXE != c.d.LXZ))
          {
            c.this.LXF = true;
            try
            {
              com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "position not change, so auto seek");
              c.this.lqh.seekTo(c.this.LXl + 500);
              AppMethodBeat.o(191713);
              return;
            }
            catch (Exception localException)
            {
              com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException);
            }
          }
          AppMethodBeat.o(191713);
        }
      }, 2000L);
    }
    AppMethodBeat.o(191746);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(191748);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "stop ");
    fWn();
    fWp();
    fWq();
    this.lqh.stop();
    this.LXE = d.LYa;
    this.LXM = 0;
    this.LXL = -1;
    this.LXN = -1;
    AppMethodBeat.o(191748);
  }
  
  public final void zv(boolean paramBoolean)
  {
    AppMethodBeat.i(191757);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setLoopback, : ".concat(String.valueOf(paramBoolean)));
    this.LXf = paramBoolean;
    this.lqh.setLooping(paramBoolean);
    AppMethodBeat.o(191757);
  }
  
  public final void zw(boolean paramBoolean)
  {
    AppMethodBeat.i(191754);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, : ".concat(String.valueOf(paramBoolean)));
    if (this.lqh == null)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, player is null");
      AppMethodBeat.o(191754);
      return;
    }
    if (paramBoolean) {
      try
      {
        this.lqh.setVolume(0.0F, 0.0F);
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, true");
        AppMethodBeat.o(191754);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, Exception: " + localException.toString());
        AppMethodBeat.o(191754);
        return;
      }
    }
    this.lqh.setVolume(this.LXj, this.LXj);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, false, mAudioGain: " + this.LXj);
    AppMethodBeat.o(191754);
  }
  
  static final class b
  {
    public n LXS;
    public String LXT = "";
    public String url = "";
  }
  
  final class c
    implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener
  {
    private c() {}
    
    public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
    {
      AppMethodBeat.i(191726);
      long l2 = ((float)(c.this.getDurationMs() * paramInt) / 100.0F) - c.this.getCurrentPositionMs();
      paramMediaPlayer = c.this;
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = c.this.LXI;
      }
      paramMediaPlayer.LXI = l1;
      AppMethodBeat.o(191726);
    }
    
    public final void onCompletion(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(191721);
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onCompletion, : ");
      c.this.LXE = c.d.LYb;
      c.this.fWp();
      if (c.this.LWL != null) {
        c.this.LWL.onCompletion();
      }
      AppMethodBeat.o(191721);
    }
    
    public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      int j = 2000;
      AppMethodBeat.i(191722);
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onError, : " + paramInt1 + ", extra: " + paramInt2);
      c.this.fWn();
      c.this.fWp();
      c.this.LXE = c.d.LYc;
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
        if (c.this.LWN != null) {
          c.this.LWN.a(i, c.aha(paramInt1), paramInt2, 0L);
        }
        AppMethodBeat.o(191722);
        return true;
        i = 2001;
        continue;
        i = 2001;
      }
    }
    
    public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(191723);
      paramInt2 = -1;
      c localc;
      switch (paramInt1)
      {
      default: 
        paramInt1 = -1;
        if (paramInt1 != -1)
        {
          if ((200 != paramInt1) && (201 != paramInt1)) {
            break label332;
          }
          if (!c.this.fWr())
          {
            if (200 != paramInt1) {
              break label322;
            }
            localc = c.this;
          }
        }
        break;
      }
      for (;;)
      {
        synchronized (localc.LXA)
        {
          if (localc.LXB == null) {
            localc.LXB = com.tencent.thumbplayer.utils.f.getScheduledExecutorServiceInstance().schedule(new c.4(localc), 1200L, TimeUnit.MILLISECONDS);
          }
          if (c.this.LWM != null) {
            c.this.LWM.a(paramInt1, 0L, 0L, null);
          }
          if (paramInt1 == 106)
          {
            paramInt1 = paramMediaPlayer.getVideoWidth();
            paramInt2 = paramMediaPlayer.getVideoHeight();
            if (((paramInt2 != c.this.mVideoHeight) || (paramInt1 != c.this.mVideoWidth)) && (paramInt2 > 0) && (paramInt1 > 0))
            {
              c.this.mVideoHeight = paramInt2;
              c.this.mVideoWidth = paramInt1;
              if (c.this.LWP != null) {
                c.this.LWP.aD(c.this.mVideoWidth, c.this.mVideoHeight);
              }
            }
          }
          AppMethodBeat.o(191723);
          return true;
          paramInt1 = 200;
          break;
          paramInt1 = 201;
          break;
          paramInt1 = 106;
          break;
          c.this.LXD = true;
          paramInt1 = paramInt2;
        }
        label322:
        c.this.fWq();
        continue;
        label332:
        if (c.this.LWM != null) {
          c.this.LWM.a(106, 0L, 0L, null);
        }
      }
    }
    
    public final void onPrepared(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(191720);
      if (c.this.LXE != c.d.LXW)
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared() is called in a wrong situation, mState = " + c.this.LXE);
        AppMethodBeat.o(191720);
        return;
      }
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared() , mStartPositionMs=" + c.this.LXl);
      c.this.fWn();
      c.this.fWm();
      AppMethodBeat.o(191720);
    }
    
    public final void onSeekComplete(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(191724);
      if (c.this.lqh == null)
      {
        AppMethodBeat.o(191724);
        return;
      }
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onSeekComplete().");
      if ((c.d.LXZ == c.this.LXE) && (paramMediaPlayer != null)) {}
      try
      {
        paramMediaPlayer.pause();
        if ((!c.this.LXF) && (c.d.LXX != c.this.LXE) && (c.this.LWO != null)) {
          c.this.LWO.ckp();
        }
        c.this.LXF = false;
        AppMethodBeat.o(191724);
        return;
      }
      catch (Exception paramMediaPlayer)
      {
        for (;;)
        {
          com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", paramMediaPlayer);
        }
      }
    }
    
    public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(191725);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "onVideoSizeChanged() size error, width:" + paramInt1 + " height:" + paramInt2);
        AppMethodBeat.o(191725);
        return;
      }
      try
      {
        if ((paramInt1 != c.this.mVideoWidth) || (paramInt2 != c.this.mVideoHeight)) {
          c.this.LWP.aD(paramInt1, paramInt2);
        }
      }
      catch (Exception paramMediaPlayer)
      {
        for (;;)
        {
          com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPSystemMediaPlayer.java]", paramMediaPlayer.toString());
        }
      }
      c.this.mVideoWidth = paramInt1;
      c.this.mVideoHeight = paramInt2;
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onVideoSizeChanged(), width:" + paramInt1 + " height:" + paramInt2);
      AppMethodBeat.o(191725);
    }
  }
  
  static enum d
  {
    static
    {
      AppMethodBeat.i(191729);
      LXU = new d("IDLE", 0);
      LXV = new d("INITIALIZED", 1);
      LXW = new d("PREPARING", 2);
      LXX = new d("PREPARED", 3);
      LXY = new d("STARTED", 4);
      LXZ = new d("PAUSED", 5);
      LYa = new d("STOPPED", 6);
      LYb = new d("COMPLETE", 7);
      LYc = new d("ERROR", 8);
      LYd = new d("RELEASE", 9);
      LYe = new d[] { LXU, LXV, LXW, LXX, LXY, LXZ, LYa, LYb, LYc, LYd };
      AppMethodBeat.o(191729);
    }
    
    private d() {}
  }
  
  static final class e
  {
    long LWx;
    int LYf;
    int LYg;
    int LYh;
    int LYi;
    c.d LYj;
    long position;
    String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */