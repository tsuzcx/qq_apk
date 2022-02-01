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
import com.tencent.thumbplayer.b.d;
import com.tencent.thumbplayer.b.e;
import com.tencent.thumbplayer.b.f.a;
import com.tencent.thumbplayer.b.f.b;
import com.tencent.thumbplayer.b.f.e;
import com.tencent.thumbplayer.b.i.a;
import com.tencent.thumbplayer.b.k;
import com.tencent.thumbplayer.b.m;
import com.tencent.thumbplayer.b.n;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.utils.i;
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
  private com.tencent.thumbplayer.a.a.c.e KcO;
  com.tencent.thumbplayer.a.a.c.b KcP;
  com.tencent.thumbplayer.a.a.c.d KcQ;
  com.tencent.thumbplayer.a.a.c.c KcR;
  c.f KcS;
  c.j KcT;
  c.h KcU;
  private long KdA;
  private Future<?> KdB;
  private final Object KdC;
  int KdD;
  Object KdE;
  Future<?> KdF;
  boolean KdG;
  boolean KdH;
  d KdI;
  boolean KdJ;
  private long KdK;
  long KdL;
  long KdM;
  boolean KdN;
  int KdO;
  int KdP;
  private int KdQ;
  private int KdR;
  private List<b> KdS;
  private e KdT;
  @TargetApi(16)
  private MediaPlayer.OnTimedTextListener KdU;
  boolean Kdj;
  long Kdk;
  long Kdl;
  private FileDescriptor Kdm;
  private float Kdn;
  private float Kdo;
  int Kdp;
  long Kdq;
  private long Kdr;
  private int Kds;
  private int Kdt;
  private boolean Kdu;
  private c Kdv;
  private c.a Kdw;
  private com.tencent.thumbplayer.c.b Kdx;
  private Future<?> Kdy;
  private Object Kdz;
  private Map<String, String> iml;
  MediaPlayer kTD;
  private Context mContext;
  private String mUrl;
  int mVideoHeight;
  int mVideoWidth;
  private boolean tcm;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(187709);
    this.mContext = null;
    this.Kdj = false;
    this.Kdk = 0L;
    this.Kdl = 0L;
    this.Kdn = 1.0F;
    this.Kdo = 1.0F;
    this.Kdp = 0;
    this.Kdq = -1L;
    this.tcm = false;
    this.Kdr = -1L;
    this.Kds = -1;
    this.Kdt = -1;
    this.Kdu = true;
    this.Kdy = null;
    this.Kdz = new Object();
    this.KdA = 25000L;
    this.KdB = null;
    this.KdC = new Object();
    this.KdD = 30;
    this.KdE = new Object();
    this.KdF = null;
    this.KdG = false;
    this.KdH = false;
    this.KdK = 0L;
    this.KdL = 0L;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.KdM = 0L;
    this.KdN = false;
    this.KdO = 0;
    this.KdP = -1;
    this.KdQ = 0;
    this.KdR = -1;
    this.KdS = new ArrayList();
    this.KdT = null;
    this.KdU = new MediaPlayer.OnTimedTextListener()
    {
      public final void onTimedText(MediaPlayer paramAnonymousMediaPlayer, TimedText paramAnonymousTimedText)
      {
        AppMethodBeat.i(187696);
        m localm;
        if (c.this.KcU != null)
        {
          localm = new m();
          if (paramAnonymousTimedText == null) {
            break label79;
          }
        }
        label79:
        for (paramAnonymousMediaPlayer = paramAnonymousTimedText.getText();; paramAnonymousMediaPlayer = "")
        {
          localm.Kfp = paramAnonymousMediaPlayer;
          localm.Kfq = c.this.KdP;
          localm.Kcz = c.this.getCurrentPositionMs();
          c.this.KcU.a(localm);
          AppMethodBeat.o(187696);
          return;
        }
      }
    };
    this.mContext = paramContext;
    this.Kdv = new c((byte)0);
    paramContext = new b((byte)0);
    paramContext.KdW = new n();
    paramContext.KdW.isSelected = true;
    paramContext.KdW.name = "audio_1";
    this.KdS.add(paramContext);
    this.kTD = new a();
    this.kTD.setOnPreparedListener(this.Kdv);
    this.kTD.setOnCompletionListener(this.Kdv);
    this.kTD.setOnErrorListener(this.Kdv);
    this.kTD.setOnInfoListener(this.Kdv);
    this.kTD.setOnBufferingUpdateListener(this.Kdv);
    this.kTD.setOnSeekCompleteListener(this.Kdv);
    this.kTD.setOnVideoSizeChangedListener(this.Kdv);
    if (Build.VERSION.SDK_INT >= 16) {
      this.kTD.setOnTimedTextListener(this.KdU);
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.kTD.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
      paramContext = Looper.myLooper();
      if (paramContext == null) {
        break label478;
      }
      this.Kdw = new c.a(paramContext, this);
    }
    for (;;)
    {
      this.KdI = d.KdY;
      AppMethodBeat.o(187709);
      return;
      this.kTD.setAudioStreamType(3);
      break;
      label478:
      paramContext = Looper.getMainLooper();
      if (paramContext != null) {
        this.Kdw = new c.a(paramContext, this);
      } else {
        this.Kdw = null;
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
        AppMethodBeat.i(187719);
        localObject1 = parame.url;
        parame.position = getCurrentPositionMs();
        parame.Ken = this.KdI;
        parame.Kel = this.KdR;
        parame.Kem = this.KdP;
        f1 = this.Kdn;
        f2 = this.Kdo;
        boolean bool = this.Kdj;
        this.kTD.reset();
        Object localObject2;
        if (this.Kdm != null)
        {
          this.kTD.setDataSource(this.Kdm);
          break label422;
          this.kTD.setVolume(this.Kdn, this.Kdn);
          break label437;
          ce(f2);
          if (bool) {
            this.kTD.setLooping(bool);
          }
          localObject1 = this.KdT;
          if ((localObject1 != null) && (((e)localObject1).Kej != parame.Kej))
          {
            localObject2 = this.KcQ;
            if (((e)localObject1).Kej != 1) {
              break label416;
            }
            i = 3;
            if (localObject2 != null) {
              ((com.tencent.thumbplayer.a.a.c.d)localObject2).a(i, ((e)localObject1).KcB, 0L, null);
            }
            parame.Ken = ((e)localObject1).Ken;
            parame.position = ((e)localObject1).position;
          }
          this.KdT = parame;
          if ((parame.Ken == d.Kea) || (parame.Ken == d.Keb) || (parame.Ken == d.Kec) || (parame.Ken == d.Ked))
          {
            this.kTD.prepareAsync();
            fEW();
          }
          AppMethodBeat.o(187719);
          return;
        }
        i = parame.Kek;
        if (i > 0)
        {
          localObject2 = (b)this.KdS.get(i);
          com.tencent.thumbplayer.a.a.c.d locald = this.KcQ;
          if (locald != null)
          {
            i.a locala = new i.a();
            locala.Kfc = ((b)localObject2).url;
            locala.KdX = ((b)localObject2).KdX;
            locald.a(1011, 0L, 0L, locala);
          }
        }
        if ((this.iml != null) && (!this.iml.isEmpty()))
        {
          localObject1 = Uri.parse((String)localObject1);
          this.kTD.setDataSource(this.mContext, (Uri)localObject1, this.iml);
        }
      }
      finally {}
      this.kTD.setDataSource((String)localObject1);
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
  
  static int aeA(int paramInt)
  {
    if (paramInt < 0) {
      return 10000000 - paramInt;
    }
    return 10000000 + paramInt;
  }
  
  private void fEW()
  {
    AppMethodBeat.i(187746);
    synchronized (this.KdC)
    {
      if (!fEZ())
      {
        com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "startCheckBufferingTimer, forbidden check buffer by position");
        AppMethodBeat.o(187746);
        return;
      }
      if (this.KdB == null) {
        this.KdB = i.getScheduledExecutorServiceInstance().scheduleAtFixedRate(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187694);
            c localc = c.this;
            long l1 = localc.getCurrentPositionMs();
            long l2 = localc.KdL;
            localc.KdL = l1;
            if (localc.KdI != c.d.Kec)
            {
              if ((localc.KdI == c.d.Ked) && (localc.KdN))
              {
                com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, pause state and send end buffering");
                localc.KdN = false;
                localc.KdO = 0;
                if (localc.KcQ != null) {
                  localc.KcQ.a(201, 0L, 0L, null);
                }
              }
              AppMethodBeat.o(187694);
              return;
            }
            if (localc.Kdj) {
              if ((localc.Kdl > 0L) && (l1 >= localc.Kdl) && (!localc.KdH))
              {
                com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, skip end, curPosition:" + l1 + ", mSkipEndPositionMs:" + localc.Kdq);
                localc.kTD.seekTo((int)localc.Kdk);
              }
            }
            for (;;)
            {
              if ((l1 == l2) && (l1 > 0L))
              {
                int i = localc.KdO + 1;
                localc.KdO = i;
                if ((i >= 3) && (!localc.KdN))
                {
                  localc.KdN = true;
                  com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, position no change,send start buffering");
                  if (localc.KcQ != null) {
                    localc.KcQ.a(200, 0L, 0L, null);
                  }
                }
                if (localc.KdO < localc.KdD) {
                  break label499;
                }
                com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent post error");
                localc.kTD.stop();
                localc.KdI = c.d.Keg;
                localc.KdN = false;
                localc.fEX();
                if (localc.KcR == null) {
                  break label499;
                }
                localc.KcR.a(2001, c.aeA(-110), 0L, 0L);
                AppMethodBeat.o(187694);
                return;
                if ((localc.Kdq > 0L) && (l1 >= localc.getDurationMs() - localc.Kdq)) {
                  try
                  {
                    localc.kTD.pause();
                    localc.kTD.stop();
                    localc.KdI = c.d.Kef;
                    localc.fEX();
                    if (localc.KcP != null) {
                      localc.KcP.onCompletion();
                    }
                    AppMethodBeat.o(187694);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException);
                    }
                  }
                }
              }
            }
            if (localc.KdN)
            {
              com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, position change, send end buffering");
              if (localc.KcQ != null) {
                localc.KcQ.a(201, 0L, 0L, null);
              }
            }
            localc.KdN = false;
            localc.KdO = 0;
            localc.KdG = true;
            label499:
            AppMethodBeat.o(187694);
          }
        }, 0L, 400L, TimeUnit.MILLISECONDS);
      }
      AppMethodBeat.o(187746);
      return;
    }
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(187711);
    parama = new IllegalStateException("system Mediaplayer cannot support audio frame out");
    AppMethodBeat.o(187711);
    throw parama;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    this.KcP = paramb;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.c paramc)
  {
    this.KcR = paramc;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    this.KcQ = paramd;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.e parame)
  {
    this.KcO = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.KcS = paramf;
  }
  
  public final void a(c.h paramh)
  {
    this.KcU = paramh;
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(187710);
    parami = new IllegalStateException("system Mediaplayer cannot support video frame out");
    AppMethodBeat.o(187710);
    throw parami;
  }
  
  public final void a(c.j paramj)
  {
    this.KcT = paramj;
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(187716);
    parama = new IllegalArgumentException("setDataSource by asset, android mediaplayer not support");
    AppMethodBeat.o(187716);
    throw parama;
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama, int paramInt, long paramLong) {}
  
  public final void a(e parame, d paramd)
  {
    AppMethodBeat.i(187744);
    if (this.Kdx != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = parame.width;
      localTPImageGeneratorParams.height = parame.height;
      localTPImageGeneratorParams.format = parame.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = parame.requestedTimeMsToleranceBefore;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = parame.requestedTimeMsToleranceAfter;
      this.Kdx.a(getCurrentPositionMs(), localTPImageGeneratorParams, paramd);
    }
    AppMethodBeat.o(187744);
  }
  
  public final void aG(int paramInt, long paramLong)
  {
    AppMethodBeat.i(187721);
    int i = this.KdS.size();
    com.tencent.thumbplayer.a.a.c.d locald = this.KcQ;
    if ((paramInt >= 0) && (paramInt < i)) {
      try
      {
        e locale = new e((byte)0);
        locale.KcB = paramLong;
        locale.Kek = paramInt;
        locale.Kej = 2;
        locale.url = this.mUrl;
        a(locale);
        ((b)this.KdS.get(this.KdQ)).KdW.isSelected = false;
        ((b)this.KdS.get(paramInt)).KdW.isSelected = true;
        this.KdQ = paramInt;
        AppMethodBeat.o(187721);
        return;
      }
      catch (Exception localException1)
      {
        com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException1);
        if (locald != null) {
          locald.a(4, aeA(-10000), 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(187721);
        return;
      }
    }
    paramInt -= i;
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "selectTrack, android mediaplayer not support ");
      if (locald != null) {
        locald.a(4, aeA(-10001), 0L, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(187721);
      return;
    }
    if ((this.KdI != d.Keb) && (this.KdI != d.Kec) && (this.KdI != d.Ked))
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "selectTrack, illegal state:" + this.KdI);
      AppMethodBeat.o(187721);
      return;
    }
    Object localObject = null;
    try
    {
      MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.kTD.getTrackInfo();
      localObject = arrayOfTrackInfo;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "getTrackInfo, android getTrackInfo crash");
      }
      localObject = localObject[paramInt];
      if (localObject.getTrackType() != 2) {
        break label420;
      }
      this.KdR = paramInt;
      for (;;)
      {
        this.kTD.selectTrack(paramInt);
        if (locald != null) {
          locald.a(4, 1000L, 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(187721);
        return;
        label420:
        if (localObject.getTrackType() != 4) {
          break;
        }
        this.KdP = paramInt;
      }
      if (locald == null) {
        break label462;
      }
      locald.a(4, aeA(-10003), 0L, Long.valueOf(paramLong));
      label462:
      AppMethodBeat.o(187721);
    }
    if ((localObject == null) || (localObject.length <= paramInt))
    {
      if (locald != null) {
        locald.a(4, aeA(-10002), 0L, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(187721);
      return;
    }
  }
  
  @TargetApi(16)
  public final void aH(int paramInt, long paramLong)
  {
    AppMethodBeat.i(187722);
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "deselectTrack, android mediaplayer not support ");
      AppMethodBeat.o(187722);
      return;
    }
    this.kTD.deselectTrack(paramInt);
    AppMethodBeat.o(187722);
  }
  
  public final void aI(int paramInt, long paramLong)
  {
    AppMethodBeat.i(187743);
    com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "selectProgram, android mediaplayer not support");
    AppMethodBeat.o(187743);
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      AppMethodBeat.i(187715);
      if (paramParcelFileDescriptor == null)
      {
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource pfd is null ");
        paramParcelFileDescriptor = new IllegalArgumentException("pfd is null");
        AppMethodBeat.o(187715);
        throw paramParcelFileDescriptor;
      }
    }
    finally {}
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource pfd， pfd: " + paramParcelFileDescriptor.toString());
    this.Kdm = paramParcelFileDescriptor.getFileDescriptor();
    this.kTD.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
    this.Kdx = new com.tencent.thumbplayer.c.b(paramParcelFileDescriptor.getFileDescriptor());
    this.KdI = d.KdZ;
    AppMethodBeat.o(187715);
  }
  
  public final void b(com.tencent.thumbplayer.b.f paramf)
  {
    switch (paramf.key)
    {
    default: 
      return;
    case 100: 
      this.Kdp = ((int)paramf.KeS.value);
      return;
    case 500: 
      this.Kdq = paramf.KeS.value;
      return;
    case 1: 
      this.Kdr = paramf.KeS.value;
      return;
    case 2: 
      this.Kdt = ((int)paramf.KeS.value);
      return;
    case 3: 
      this.Kds = ((int)paramf.KeS.value);
      return;
    case 4: 
      this.tcm = paramf.KeR.value;
      return;
    case 5: 
      this.Kdu = paramf.KeR.value;
      return;
    case 207: 
      this.KdA = paramf.KeS.value;
      return;
    }
    this.KdD = ((int)((paramf.KeS.value + 400L) / 400L));
  }
  
  @TargetApi(16)
  public final void bb(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(187717);
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addSubtitleSource android mediaplayer not support ");
      AppMethodBeat.o(187717);
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
        com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addTimedTextSource, mimeType no support.");
        AppMethodBeat.o(187717);
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
        this.kTD.addTimedTextSource(this.mContext, Uri.parse(paramString1), paramString3);
        AppMethodBeat.o(187717);
        return;
      }
      catch (Exception paramString1)
      {
        com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", paramString1, "addTimedTextSource error");
        AppMethodBeat.o(187717);
        return;
      }
    }
    com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addTimedTextSource, mimeType no support.");
    AppMethodBeat.o(187717);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(187737);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setLoopback, : " + paramBoolean + ", loopStart: " + paramLong1 + ", loopEnd: " + paramLong2);
    Object localObject;
    if (this.KdI == d.Keg)
    {
      localObject = new IllegalStateException("state error, current state is error state");
      AppMethodBeat.o(187737);
      throw ((Throwable)localObject);
    }
    if ((paramLong1 < 0L) || (paramLong1 > this.KdK) || (paramLong2 > this.KdK))
    {
      localObject = new IllegalArgumentException("position error, must more than 0 and less than duration");
      AppMethodBeat.o(187737);
      throw ((Throwable)localObject);
    }
    this.Kdj = paramBoolean;
    this.Kdk = paramLong1;
    this.Kdl = paramLong2;
    this.kTD.setLooping(paramBoolean);
    AppMethodBeat.o(187737);
  }
  
  public final void cd(float paramFloat)
  {
    AppMethodBeat.i(187734);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setAudioGainRatio, : ".concat(String.valueOf(paramFloat)));
    this.Kdn = paramFloat;
    try
    {
      if (this.kTD != null) {
        this.kTD.setVolume(this.Kdn, this.Kdn);
      }
      AppMethodBeat.o(187734);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setAudioGainRatio ex : " + localIllegalStateException.toString());
      AppMethodBeat.o(187734);
    }
  }
  
  @TargetApi(23)
  public final void ce(float paramFloat)
  {
    AppMethodBeat.i(187735);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setPlaySpeedRatio, : ".concat(String.valueOf(paramFloat)));
    if (Build.VERSION.SDK_INT < 23)
    {
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "os version is too low: " + Build.VERSION.SDK_INT);
      AppMethodBeat.o(187735);
      return;
    }
    this.Kdo = paramFloat;
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setPlaySpeedRatio play speed:".concat(String.valueOf(paramFloat)));
    try
    {
      PlaybackParams localPlaybackParams = this.kTD.getPlaybackParams();
      if (localPlaybackParams.getSpeed() != paramFloat)
      {
        localPlaybackParams.setSpeed(paramFloat);
        this.kTD.setPlaybackParams(localPlaybackParams);
      }
      AppMethodBeat.o(187735);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException);
      AppMethodBeat.o(187735);
    }
  }
  
  @TargetApi(16)
  public final n[] fEO()
  {
    AppMethodBeat.i(187742);
    if ((this.KdI == d.Keb) || (this.KdI == d.Kec) || (this.KdI == d.Ked)) {}
    Object localObject;
    for (;;)
    {
      try
      {
        MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.kTD.getTrackInfo();
        if ((arrayOfTrackInfo != null) || (!this.KdS.isEmpty())) {
          break;
        }
        AppMethodBeat.o(187742);
        return new n[0];
      }
      catch (Exception localException)
      {
        com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "getTrackInfo, android getTrackInfo crash");
      }
      localObject = null;
    }
    int j = this.KdS.size();
    if (localObject == null) {}
    n[] arrayOfn;
    Iterator localIterator;
    for (int i = 0;; i = localObject.length)
    {
      arrayOfn = new n[i + j];
      localIterator = this.KdS.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        arrayOfn[i] = ((b)localIterator.next()).KdW;
        i += 1;
      }
    }
    if (localObject == null)
    {
      AppMethodBeat.o(187742);
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
    AppMethodBeat.o(187742);
    return arrayOfn;
  }
  
  public final k[] fEP()
  {
    return new k[0];
  }
  
  final void fEU()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(187720);
        Object localObject1 = this.KdT;
        if (localObject1 == null) {
          break label334;
        }
        com.tencent.thumbplayer.a.a.c.d locald = this.KcQ;
        int i;
        if (((e)localObject1).Kej == 1)
        {
          i = 3;
          if (locald != null) {
            locald.a(i, 1000L, 0L, Long.valueOf(((e)localObject1).KcB));
          }
          if (Build.VERSION.SDK_INT >= 16)
          {
            if (((e)localObject1).Kel > 0) {
              this.kTD.selectTrack(((e)localObject1).Kel);
            }
            if (((e)localObject1).Kem > 0) {
              this.kTD.selectTrack(((e)localObject1).Kem);
            }
          }
          if ((((e)localObject1).position > 0L) && (!this.KdH)) {
            com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared(), and seekto:" + this.Kdp);
          }
        }
        try
        {
          this.kTD.seekTo((int)((e)localObject1).position);
          if ((((e)localObject1).Ken == d.KdY) || (((e)localObject1).Ken == d.KdZ) || (((e)localObject1).Ken == d.Kea))
          {
            localObject1 = this.KcO;
            if (localObject1 != null) {
              ((com.tencent.thumbplayer.a.a.c.e)localObject1).rB();
            }
            this.KdI = d.Keb;
            this.KdT = null;
            AppMethodBeat.o(187720);
            return;
            i = 4;
          }
        }
        catch (Exception localException2)
        {
          com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException2);
          continue;
        }
        if (localObject2.Ken == d.Keb) {
          break label259;
        }
      }
      finally {}
      if (localObject2.Ken == d.Ked)
      {
        label259:
        this.KdI = localObject2.Ken;
        continue;
      }
      if (localObject2.Ken == d.Kec)
      {
        this.kTD.start();
        this.KdI = localObject2.Ken;
        continue;
      }
      this.KdI = d.Keg;
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "illegal state, state:" + localObject2.Ken);
      continue;
      label334:
      if ((this.Kdp > 0) && (!this.KdH)) {
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared(), and seekto:" + this.Kdp);
      }
      try
      {
        this.kTD.seekTo(this.Kdp);
        com.tencent.thumbplayer.a.a.c.e locale = this.KcO;
        if (locale != null) {
          locale.rB();
        }
        AppMethodBeat.o(187720);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException1);
        }
      }
    }
  }
  
  /* Error */
  final void fEV()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 805
    //   5: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 157	com/tencent/thumbplayer/a/a/a/c:Kdz	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 155	com/tencent/thumbplayer/a/a/a/c:Kdy	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 155	com/tencent/thumbplayer/a/a/a/c:Kdy	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 811 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 155	com/tencent/thumbplayer/a/a/a/c:Kdy	Ljava/util/concurrent/Future;
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc_w 805
    //   43: invokestatic 317	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: ldc_w 805
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
  final void fEX()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 813
    //   5: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 165	com/tencent/thumbplayer/a/a/a/c:KdC	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 163	com/tencent/thumbplayer/a/a/a/c:KdB	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 163	com/tencent/thumbplayer/a/a/a/c:KdB	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 811 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 163	com/tencent/thumbplayer/a/a/a/c:KdB	Ljava/util/concurrent/Future;
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc_w 813
    //   43: invokestatic 317	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: ldc_w 813
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
  final void fEY()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 815
    //   5: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 169	com/tencent/thumbplayer/a/a/a/c:KdE	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 171	com/tencent/thumbplayer/a/a/a/c:KdF	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 171	com/tencent/thumbplayer/a/a/a/c:KdF	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 811 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 171	com/tencent/thumbplayer/a/a/a/c:KdF	Ljava/util/concurrent/Future;
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc_w 815
    //   43: invokestatic 317	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: ldc_w 815
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
  
  final boolean fEZ()
  {
    AppMethodBeat.i(187749);
    if (this.tcm)
    {
      AppMethodBeat.o(187749);
      return false;
    }
    if (getDurationMs() <= 0L)
    {
      AppMethodBeat.o(187749);
      return false;
    }
    boolean bool = this.Kdu;
    AppMethodBeat.o(187749);
    return bool;
  }
  
  public final void g(String paramString1, String paramString2, List<com.tencent.thumbplayer.b.f> paramList)
  {
    AppMethodBeat.i(187718);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addAudioTrackSource, illegal argument.");
    }
    n localn = new n();
    localn.name = paramString2;
    localn.isExclusive = true;
    localn.isInternal = false;
    localn.isSelected = false;
    paramString2 = new b((byte)0);
    paramString2.KdW = localn;
    paramString2.url = paramString1;
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramList = (com.tencent.thumbplayer.b.f)paramString1.next();
      if (paramList.key == 6) {
        paramString2.KdX = paramList.KeT.value;
      }
    }
    this.KdS.add(paramString2);
    AppMethodBeat.o(187718);
  }
  
  public final long getBufferedDurationMs()
  {
    return this.KdM;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(187739);
    if ((this.kTD == null) || (this.KdI == d.KdY) || (this.KdI == d.KdZ) || (this.KdI == d.Kea) || (this.KdI == d.Kee) || (this.KdI == d.Keb))
    {
      l = this.Kdp;
      AppMethodBeat.o(187739);
      return l;
    }
    long l = this.kTD.getCurrentPosition();
    AppMethodBeat.o(187739);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(187738);
    if ((this.KdI != d.Keb) && (this.KdI != d.Kec) && (this.KdI != d.Ked))
    {
      AppMethodBeat.o(187738);
      return -1L;
    }
    if (this.KdK <= 0L) {
      this.KdK = this.kTD.getDuration();
    }
    if (this.Kdr > 0L) {
      if (this.KdK > 0L) {
        break label106;
      }
    }
    for (this.KdK = this.Kdr;; this.KdK = this.Kdr) {
      label106:
      do
      {
        long l = this.KdK;
        AppMethodBeat.o(187738);
        return l;
      } while ((this.KdK <= 0L) || (Math.abs(this.Kdr - this.KdK) * 100L / this.Kdr <= 1L));
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
    AppMethodBeat.i(187741);
    if (this.mVideoHeight <= 0) {
      this.mVideoHeight = this.kTD.getVideoHeight();
    }
    if ((this.mVideoHeight <= 0) && (this.Kds > 0) && ((this.KdI == d.Keb) || (this.KdI == d.Kec) || (this.KdI == d.Ked))) {
      this.mVideoHeight = this.Kds;
    }
    int i = this.mVideoHeight;
    AppMethodBeat.o(187741);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(187740);
    if (this.mVideoWidth <= 0) {
      this.mVideoWidth = this.kTD.getVideoWidth();
    }
    if (((this.KdI == d.Keb) || (this.KdI == d.Kec) || (this.KdI == d.Ked)) && (this.mVideoWidth <= 0) && (this.Kdt > 0)) {
      this.mVideoWidth = this.Kdt;
    }
    int i = this.mVideoWidth;
    AppMethodBeat.o(187740);
    return i;
  }
  
  @TargetApi(26)
  public final void kD(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(187731);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "seekTo, position: " + paramInt1 + ", mode: " + paramInt2);
    if (this.KdH)
    {
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "current media is not seekable, ignore");
      AppMethodBeat.o(187731);
      return;
    }
    if (Build.VERSION.SDK_INT < 26)
    {
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "os ver is too low, current sdk int:" + Build.VERSION.SDK_INT + ", is less than 26, use seekTo(int positionMs) instead");
      this.kTD.seekTo(paramInt1);
      AppMethodBeat.o(187731);
      return;
    }
    if (paramInt2 == 1) {}
    for (;;)
    {
      try
      {
        this.kTD.seekTo(paramInt1, i);
        AppMethodBeat.o(187731);
        return;
      }
      catch (Exception localException1)
      {
        com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException1);
        try
        {
          this.kTD.seekTo(paramInt1);
          AppMethodBeat.o(187731);
          return;
        }
        catch (Exception localException2)
        {
          com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException2);
          AppMethodBeat.o(187731);
        }
      }
      if (paramInt2 == 2) {
        i = 1;
      } else if (paramInt2 == 3) {
        i = 2;
      }
    }
  }
  
  public final void p(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(187732);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "switchDefinition, defUrl: ".concat(String.valueOf(paramString)));
    if (this.kTD == null)
    {
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "switchDefinition, player is null");
      AppMethodBeat.o(187732);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "switchDefinition, defUrl is null");
      AppMethodBeat.o(187732);
      return;
    }
    this.mUrl = paramString;
    e locale = new e((byte)0);
    locale.KcB = paramLong;
    locale.Kek = this.KdQ;
    locale.Kej = 1;
    locale.url = paramString;
    try
    {
      a(locale);
      AppMethodBeat.o(187732);
      return;
    }
    catch (Exception paramString)
    {
      paramString = new IllegalStateException("playerResetStart");
      AppMethodBeat.o(187732);
      throw paramString;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(187726);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "pause ");
    this.kTD.pause();
    this.KdI = d.Ked;
    AppMethodBeat.o(187726);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(187723);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "prepare ");
    this.KdI = d.Kea;
    this.kTD.prepare();
    AppMethodBeat.o(187723);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(187724);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "prepareAsync ");
    this.KdI = d.Kea;
    this.kTD.prepareAsync();
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "startCheckPrepareTimeoutTimer");
    synchronized (this.Kdz)
    {
      if (this.Kdy == null) {
        this.Kdy = i.getScheduledExecutorServiceInstance().schedule(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187693);
            if (c.this.KdI == c.d.Kea) {
              com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "startCheckPrepareTimeoutTimer, post error");
            }
            try
            {
              c.this.kTD.stop();
              c.this.KdI = c.d.Keg;
              c.this.fEV();
              if (c.this.KcR != null) {
                c.this.KcR.a(2001, c.aeA(-110), 0L, 0L);
              }
              AppMethodBeat.o(187693);
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException);
              }
            }
          }
        }, this.KdA, TimeUnit.MILLISECONDS);
      }
      AppMethodBeat.o(187724);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(187729);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "release ");
    this.KdG = false;
    fEV();
    fEX();
    fEY();
    this.kTD.reset();
    this.kTD.release();
    this.KcO = null;
    this.KcP = null;
    this.KcQ = null;
    this.KcR = null;
    this.KcS = null;
    this.KcT = null;
    this.KcU = null;
    this.Kdw = null;
    this.KdI = d.Keh;
    AppMethodBeat.o(187729);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(187728);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "reset ");
    this.KdG = false;
    this.kTD.reset();
    fEV();
    fEX();
    fEY();
    this.KdI = d.KdY;
    AppMethodBeat.o(187728);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(187730);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "seekTo, position: ".concat(String.valueOf(paramInt)));
    if (this.KdH)
    {
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "current media is not seekable, ignore");
      AppMethodBeat.o(187730);
      return;
    }
    this.kTD.seekTo(paramInt);
    AppMethodBeat.o(187730);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(187713);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource， url: ".concat(String.valueOf(paramString)));
    this.mUrl = paramString;
    this.kTD.setDataSource(paramString);
    this.Kdx = new com.tencent.thumbplayer.c.b(paramString);
    this.KdI = d.KdZ;
    AppMethodBeat.o(187713);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(187714);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource httpHeader， url: ".concat(String.valueOf(paramString)));
    this.mUrl = paramString;
    this.iml = paramMap;
    paramMap = Uri.parse(this.mUrl);
    this.kTD.setDataSource(this.mContext, paramMap, this.iml);
    this.Kdx = new com.tencent.thumbplayer.c.b(paramString);
    this.KdI = d.KdZ;
    AppMethodBeat.o(187714);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(187712);
    this.kTD.setSurface(paramSurface);
    AppMethodBeat.o(187712);
  }
  
  public final void start()
  {
    AppMethodBeat.i(187725);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "start ");
    this.KdG = false;
    this.kTD.start();
    this.KdI = d.Kec;
    if (this.Kdo != 1.0D) {
      ce(this.Kdo);
    }
    fEW();
    if ((this.Kdp == 0) && (!this.KdH)) {
      this.Kdw.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187692);
          if ((!c.this.KdG) && (c.this.KdI != c.d.Ked))
          {
            c.this.KdJ = true;
            try
            {
              com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "position not change, so auto seek");
              c.this.kTD.seekTo(c.this.Kdp + 500);
              AppMethodBeat.o(187692);
              return;
            }
            catch (Exception localException)
            {
              com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException);
            }
          }
          AppMethodBeat.o(187692);
        }
      }, 2000L);
    }
    AppMethodBeat.o(187725);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(187727);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "stop ");
    fEV();
    fEX();
    fEY();
    this.kTD.stop();
    this.KdI = d.Kee;
    this.KdQ = 0;
    this.KdP = -1;
    this.KdR = -1;
    AppMethodBeat.o(187727);
  }
  
  public final void yI(boolean paramBoolean)
  {
    AppMethodBeat.i(187736);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setLoopback, : ".concat(String.valueOf(paramBoolean)));
    this.Kdj = paramBoolean;
    this.kTD.setLooping(paramBoolean);
    AppMethodBeat.o(187736);
  }
  
  public final void yJ(boolean paramBoolean)
  {
    AppMethodBeat.i(187733);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, : ".concat(String.valueOf(paramBoolean)));
    if (this.kTD == null)
    {
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, player is null");
      AppMethodBeat.o(187733);
      return;
    }
    if (paramBoolean) {
      try
      {
        this.kTD.setVolume(0.0F, 0.0F);
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, true");
        AppMethodBeat.o(187733);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, Exception: " + localException.toString());
        AppMethodBeat.o(187733);
        return;
      }
    }
    this.kTD.setVolume(this.Kdn, this.Kdn);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, false, mAudioGain: " + this.Kdn);
    AppMethodBeat.o(187733);
  }
  
  static final class b
  {
    public n KdW;
    public String KdX = "";
    public String url = "";
  }
  
  final class c
    implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener
  {
    private c() {}
    
    public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
    {
      AppMethodBeat.i(187705);
      long l2 = ((float)(c.this.getDurationMs() * paramInt) / 100.0F) - c.this.getCurrentPositionMs();
      paramMediaPlayer = c.this;
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = c.this.KdM;
      }
      paramMediaPlayer.KdM = l1;
      AppMethodBeat.o(187705);
    }
    
    public final void onCompletion(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(187700);
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onCompletion, : ");
      c.this.KdI = c.d.Kef;
      c.this.fEX();
      if (c.this.KcP != null) {
        c.this.KcP.onCompletion();
      }
      AppMethodBeat.o(187700);
    }
    
    public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      int j = 2000;
      AppMethodBeat.i(187701);
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onError, : " + paramInt1 + ", extra: " + paramInt2);
      c.this.fEV();
      c.this.fEX();
      c.this.KdI = c.d.Keg;
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
        if (c.this.KcR != null) {
          c.this.KcR.a(i, c.aeA(paramInt1), paramInt2, 0L);
        }
        AppMethodBeat.o(187701);
        return true;
        i = 2001;
        continue;
        i = 2001;
      }
    }
    
    public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(187702);
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
          if (!c.this.fEZ())
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
        synchronized (localc.KdE)
        {
          if (localc.KdF == null) {
            localc.KdF = i.getScheduledExecutorServiceInstance().schedule(new c.4(localc), 1200L, TimeUnit.MILLISECONDS);
          }
          if (c.this.KcQ != null) {
            c.this.KcQ.a(paramInt1, 0L, 0L, null);
          }
          if (paramInt1 == 106)
          {
            paramInt1 = paramMediaPlayer.getVideoWidth();
            paramInt2 = paramMediaPlayer.getVideoHeight();
            if (((paramInt2 != c.this.mVideoHeight) || (paramInt1 != c.this.mVideoWidth)) && (paramInt2 > 0) && (paramInt1 > 0))
            {
              c.this.mVideoHeight = paramInt2;
              c.this.mVideoWidth = paramInt1;
              if (c.this.KcT != null) {
                c.this.KcT.ay(c.this.mVideoWidth, c.this.mVideoHeight);
              }
            }
          }
          AppMethodBeat.o(187702);
          return true;
          paramInt1 = 200;
          break;
          paramInt1 = 201;
          break;
          paramInt1 = 106;
          break;
          c.this.KdH = true;
          paramInt1 = paramInt2;
        }
        label322:
        c.this.fEY();
        continue;
        label332:
        if (c.this.KcQ != null) {
          c.this.KcQ.a(106, 0L, 0L, null);
        }
      }
    }
    
    public final void onPrepared(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(187699);
      if (c.this.KdI != c.d.Kea)
      {
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared() is called in a wrong situation, mState = " + c.this.KdI);
        AppMethodBeat.o(187699);
        return;
      }
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared() , mStartPositionMs=" + c.this.Kdp);
      c.this.fEV();
      c.this.fEU();
      AppMethodBeat.o(187699);
    }
    
    public final void onSeekComplete(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(187703);
      if (c.this.kTD == null)
      {
        AppMethodBeat.o(187703);
        return;
      }
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onSeekComplete().");
      if ((c.d.Ked == c.this.KdI) && (paramMediaPlayer != null)) {}
      try
      {
        paramMediaPlayer.pause();
        if ((!c.this.KdJ) && (c.d.Keb != c.this.KdI) && (c.this.KcS != null)) {
          c.this.KcS.cfM();
        }
        c.this.KdJ = false;
        AppMethodBeat.o(187703);
        return;
      }
      catch (Exception paramMediaPlayer)
      {
        for (;;)
        {
          com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", paramMediaPlayer);
        }
      }
    }
    
    public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(187704);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "onVideoSizeChanged() size error, width:" + paramInt1 + " height:" + paramInt2);
        AppMethodBeat.o(187704);
        return;
      }
      try
      {
        if ((paramInt1 != c.this.mVideoWidth) || (paramInt2 != c.this.mVideoHeight)) {
          c.this.KcT.ay(paramInt1, paramInt2);
        }
      }
      catch (Exception paramMediaPlayer)
      {
        for (;;)
        {
          com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPSystemMediaPlayer.java]", paramMediaPlayer.toString());
        }
      }
      c.this.mVideoWidth = paramInt1;
      c.this.mVideoHeight = paramInt2;
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onVideoSizeChanged(), width:" + paramInt1 + " height:" + paramInt2);
      AppMethodBeat.o(187704);
    }
  }
  
  static enum d
  {
    static
    {
      AppMethodBeat.i(187708);
      KdY = new d("IDLE", 0);
      KdZ = new d("INITIALIZED", 1);
      Kea = new d("PREPARING", 2);
      Keb = new d("PREPARED", 3);
      Kec = new d("STARTED", 4);
      Ked = new d("PAUSED", 5);
      Kee = new d("STOPPED", 6);
      Kef = new d("COMPLETE", 7);
      Keg = new d("ERROR", 8);
      Keh = new d("RELEASE", 9);
      Kei = new d[] { KdY, KdZ, Kea, Keb, Kec, Ked, Kee, Kef, Keg, Keh };
      AppMethodBeat.o(187708);
    }
    
    private d() {}
  }
  
  static final class e
  {
    long KcB;
    int Kej;
    int Kek;
    int Kel;
    int Kem;
    c.d Ken;
    long position;
    String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */