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
  private com.tencent.thumbplayer.a.a.c.e MtF;
  com.tencent.thumbplayer.a.a.c.b MtG;
  com.tencent.thumbplayer.a.a.c.d MtH;
  com.tencent.thumbplayer.a.a.c.c MtI;
  c.f MtJ;
  c.j MtK;
  c.h MtL;
  boolean MuA;
  private long MuB;
  long MuC;
  long MuD;
  boolean MuE;
  int MuF;
  int MuG;
  private int MuH;
  private int MuI;
  private List<b> MuJ;
  private e MuK;
  @TargetApi(16)
  private MediaPlayer.OnTimedTextListener MuL;
  boolean Mua;
  long Mub;
  long Muc;
  private FileDescriptor Mud;
  private float Mue;
  private float Muf;
  int Mug;
  long Muh;
  private long Mui;
  private int Muj;
  private int Muk;
  private boolean Mul;
  private c Mum;
  private c.a Mun;
  private com.tencent.thumbplayer.c.b Muo;
  private Future<?> Mup;
  private Object Muq;
  private long Mur;
  private Future<?> Mus;
  private final Object Mut;
  int Muu;
  Object Muv;
  Future<?> Muw;
  boolean Mux;
  boolean Muy;
  d Muz;
  private Map<String, String> iIv;
  MediaPlayer luF;
  private Context mContext;
  private String mUrl;
  int mVideoHeight;
  int mVideoWidth;
  private boolean ule;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(194408);
    this.mContext = null;
    this.Mua = false;
    this.Mub = 0L;
    this.Muc = 0L;
    this.Mue = 1.0F;
    this.Muf = 1.0F;
    this.Mug = 0;
    this.Muh = -1L;
    this.ule = false;
    this.Mui = -1L;
    this.Muj = -1;
    this.Muk = -1;
    this.Mul = true;
    this.Mup = null;
    this.Muq = new Object();
    this.Mur = 25000L;
    this.Mus = null;
    this.Mut = new Object();
    this.Muu = 30;
    this.Muv = new Object();
    this.Muw = null;
    this.Mux = false;
    this.Muy = false;
    this.MuB = 0L;
    this.MuC = 0L;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.MuD = 0L;
    this.MuE = false;
    this.MuF = 0;
    this.MuG = -1;
    this.MuH = 0;
    this.MuI = -1;
    this.MuJ = new ArrayList();
    this.MuK = null;
    this.MuL = new MediaPlayer.OnTimedTextListener()
    {
      public final void onTimedText(MediaPlayer paramAnonymousMediaPlayer, TimedText paramAnonymousTimedText)
      {
        AppMethodBeat.i(194395);
        m localm;
        if (c.this.MtL != null)
        {
          localm = new m();
          if (paramAnonymousTimedText == null) {
            break label79;
          }
        }
        label79:
        for (paramAnonymousMediaPlayer = paramAnonymousTimedText.getText();; paramAnonymousMediaPlayer = "")
        {
          localm.Mwf = paramAnonymousMediaPlayer;
          localm.Mwg = c.this.MuG;
          localm.Mtq = c.this.getCurrentPositionMs();
          c.this.MtL.a(localm);
          AppMethodBeat.o(194395);
          return;
        }
      }
    };
    this.mContext = paramContext;
    this.Mum = new c((byte)0);
    paramContext = new b((byte)0);
    paramContext.MuN = new n();
    paramContext.MuN.isSelected = true;
    paramContext.MuN.name = "audio_1";
    this.MuJ.add(paramContext);
    this.luF = new a();
    this.luF.setOnPreparedListener(this.Mum);
    this.luF.setOnCompletionListener(this.Mum);
    this.luF.setOnErrorListener(this.Mum);
    this.luF.setOnInfoListener(this.Mum);
    this.luF.setOnBufferingUpdateListener(this.Mum);
    this.luF.setOnSeekCompleteListener(this.Mum);
    this.luF.setOnVideoSizeChangedListener(this.Mum);
    if (Build.VERSION.SDK_INT >= 16) {
      this.luF.setOnTimedTextListener(this.MuL);
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.luF.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
      paramContext = Looper.myLooper();
      if (paramContext == null) {
        break label478;
      }
      this.Mun = new c.a(paramContext, this);
    }
    for (;;)
    {
      this.Muz = d.MuP;
      AppMethodBeat.o(194408);
      return;
      this.luF.setAudioStreamType(3);
      break;
      label478:
      paramContext = Looper.getMainLooper();
      if (paramContext != null) {
        this.Mun = new c.a(paramContext, this);
      } else {
        this.Mun = null;
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
        AppMethodBeat.i(194418);
        localObject1 = parame.url;
        parame.position = getCurrentPositionMs();
        parame.Mve = this.Muz;
        parame.Mvc = this.MuI;
        parame.Mvd = this.MuG;
        f1 = this.Mue;
        f2 = this.Muf;
        boolean bool = this.Mua;
        this.luF.reset();
        Object localObject2;
        if (this.Mud != null)
        {
          this.luF.setDataSource(this.Mud);
          break label422;
          this.luF.setVolume(this.Mue, this.Mue);
          break label437;
          ch(f2);
          if (bool) {
            this.luF.setLooping(bool);
          }
          localObject1 = this.MuK;
          if ((localObject1 != null) && (((e)localObject1).Mva != parame.Mva))
          {
            localObject2 = this.MtH;
            if (((e)localObject1).Mva != 1) {
              break label416;
            }
            i = 3;
            if (localObject2 != null) {
              ((com.tencent.thumbplayer.a.a.c.d)localObject2).a(i, ((e)localObject1).Mts, 0L, null);
            }
            parame.Mve = ((e)localObject1).Mve;
            parame.position = ((e)localObject1).position;
          }
          this.MuK = parame;
          if ((parame.Mve == d.MuR) || (parame.Mve == d.MuS) || (parame.Mve == d.MuT) || (parame.Mve == d.MuU))
          {
            this.luF.prepareAsync();
            gaN();
          }
          AppMethodBeat.o(194418);
          return;
        }
        i = parame.Mvb;
        if (i > 0)
        {
          localObject2 = (b)this.MuJ.get(i);
          com.tencent.thumbplayer.a.a.c.d locald = this.MtH;
          if (locald != null)
          {
            i.a locala = new i.a();
            locala.MvT = ((b)localObject2).url;
            locala.MuO = ((b)localObject2).MuO;
            locald.a(1011, 0L, 0L, locala);
          }
        }
        if ((this.iIv != null) && (!this.iIv.isEmpty()))
        {
          localObject1 = Uri.parse((String)localObject1);
          this.luF.setDataSource(this.mContext, (Uri)localObject1, this.iIv);
        }
      }
      finally {}
      this.luF.setDataSource((String)localObject1);
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
  
  static int ahJ(int paramInt)
  {
    if (paramInt < 0) {
      return 10000000 - paramInt;
    }
    return 10000000 + paramInt;
  }
  
  private void gaN()
  {
    AppMethodBeat.i(194445);
    synchronized (this.Mut)
    {
      if (!gaQ())
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "startCheckBufferingTimer, forbidden check buffer by position");
        AppMethodBeat.o(194445);
        return;
      }
      if (this.Mus == null) {
        this.Mus = com.tencent.thumbplayer.utils.f.getScheduledExecutorServiceInstance().scheduleAtFixedRate(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194393);
            c localc = c.this;
            long l1 = localc.getCurrentPositionMs();
            long l2 = localc.MuC;
            localc.MuC = l1;
            if (localc.Muz != c.d.MuT)
            {
              if ((localc.Muz == c.d.MuU) && (localc.MuE))
              {
                com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, pause state and send end buffering");
                localc.MuE = false;
                localc.MuF = 0;
                if (localc.MtH != null) {
                  localc.MtH.a(201, 0L, 0L, null);
                }
              }
              AppMethodBeat.o(194393);
              return;
            }
            if (localc.Mua) {
              if ((localc.Muc > 0L) && (l1 >= localc.Muc) && (!localc.Muy))
              {
                com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, skip end, curPosition:" + l1 + ", mSkipEndPositionMs:" + localc.Muh);
                localc.luF.seekTo((int)localc.Mub);
              }
            }
            for (;;)
            {
              if ((l1 == l2) && (l1 > 0L))
              {
                int i = localc.MuF + 1;
                localc.MuF = i;
                if ((i >= 3) && (!localc.MuE))
                {
                  localc.MuE = true;
                  com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, position no change,send start buffering");
                  if (localc.MtH != null) {
                    localc.MtH.a(200, 0L, 0L, null);
                  }
                }
                if (localc.MuF < localc.Muu) {
                  break label499;
                }
                com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent post error");
                localc.luF.stop();
                localc.Muz = c.d.MuX;
                localc.MuE = false;
                localc.gaO();
                if (localc.MtI == null) {
                  break label499;
                }
                localc.MtI.a(2001, c.ahJ(-110), 0L, 0L);
                AppMethodBeat.o(194393);
                return;
                if ((localc.Muh > 0L) && (l1 >= localc.getDurationMs() - localc.Muh)) {
                  try
                  {
                    localc.luF.pause();
                    localc.luF.stop();
                    localc.Muz = c.d.MuW;
                    localc.gaO();
                    if (localc.MtG != null) {
                      localc.MtG.onCompletion();
                    }
                    AppMethodBeat.o(194393);
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
            if (localc.MuE)
            {
              com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "checkBuffingEvent, position change, send end buffering");
              if (localc.MtH != null) {
                localc.MtH.a(201, 0L, 0L, null);
              }
            }
            localc.MuE = false;
            localc.MuF = 0;
            localc.Mux = true;
            label499:
            AppMethodBeat.o(194393);
          }
        }, 0L, 400L, TimeUnit.MILLISECONDS);
      }
      AppMethodBeat.o(194445);
      return;
    }
  }
  
  public final void L(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(194431);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "switchDefinition, defUrl: ".concat(String.valueOf(paramString)));
    if (this.luF == null)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "switchDefinition, player is null");
      AppMethodBeat.o(194431);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "switchDefinition, defUrl is null");
      AppMethodBeat.o(194431);
      return;
    }
    this.mUrl = paramString;
    e locale = new e((byte)0);
    locale.Mts = paramLong;
    locale.Mvb = this.MuH;
    locale.Mva = 1;
    locale.url = paramString;
    try
    {
      a(locale);
      AppMethodBeat.o(194431);
      return;
    }
    catch (Exception paramString)
    {
      paramString = new IllegalStateException("playerResetStart");
      AppMethodBeat.o(194431);
      throw paramString;
    }
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(194410);
    parama = new IllegalStateException("system Mediaplayer cannot support audio frame out");
    AppMethodBeat.o(194410);
    throw parama;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    this.MtG = paramb;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.c paramc)
  {
    this.MtI = paramc;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    this.MtH = paramd;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.e parame)
  {
    this.MtF = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.MtJ = paramf;
  }
  
  public final void a(c.h paramh)
  {
    this.MtL = paramh;
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(194409);
    parami = new IllegalStateException("system Mediaplayer cannot support video frame out");
    AppMethodBeat.o(194409);
    throw parami;
  }
  
  public final void a(c.j paramj)
  {
    this.MtK = paramj;
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(194415);
    parama = new IllegalArgumentException("setDataSource by asset, android mediaplayer not support");
    AppMethodBeat.o(194415);
    throw parama;
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama, int paramInt, long paramLong) {}
  
  public final void a(e parame, com.tencent.thumbplayer.b.d paramd)
  {
    AppMethodBeat.i(194443);
    if (this.Muo != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = parame.width;
      localTPImageGeneratorParams.height = parame.height;
      localTPImageGeneratorParams.format = parame.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = parame.requestedTimeMsToleranceBefore;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = parame.requestedTimeMsToleranceAfter;
      this.Muo.a(getCurrentPositionMs(), localTPImageGeneratorParams, paramd);
    }
    AppMethodBeat.o(194443);
  }
  
  public final void aR(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194420);
    int i = this.MuJ.size();
    com.tencent.thumbplayer.a.a.c.d locald = this.MtH;
    if ((paramInt >= 0) && (paramInt < i)) {
      try
      {
        e locale = new e((byte)0);
        locale.Mts = paramLong;
        locale.Mvb = paramInt;
        locale.Mva = 2;
        locale.url = this.mUrl;
        a(locale);
        ((b)this.MuJ.get(this.MuH)).MuN.isSelected = false;
        ((b)this.MuJ.get(paramInt)).MuN.isSelected = true;
        this.MuH = paramInt;
        AppMethodBeat.o(194420);
        return;
      }
      catch (Exception localException1)
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException1);
        if (locald != null) {
          locald.a(4, ahJ(-10000), 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(194420);
        return;
      }
    }
    paramInt -= i;
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "selectTrack, android mediaplayer not support ");
      if (locald != null) {
        locald.a(4, ahJ(-10001), 0L, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(194420);
      return;
    }
    if ((this.Muz != d.MuS) && (this.Muz != d.MuT) && (this.Muz != d.MuU))
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "selectTrack, illegal state:" + this.Muz);
      AppMethodBeat.o(194420);
      return;
    }
    Object localObject = null;
    try
    {
      MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.luF.getTrackInfo();
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
      this.MuI = paramInt;
      for (;;)
      {
        this.luF.selectTrack(paramInt);
        if (locald != null) {
          locald.a(4, 1000L, 0L, Long.valueOf(paramLong));
        }
        AppMethodBeat.o(194420);
        return;
        label420:
        if (localObject.getTrackType() != 4) {
          break;
        }
        this.MuG = paramInt;
      }
      if (locald == null) {
        break label462;
      }
      locald.a(4, ahJ(-10003), 0L, Long.valueOf(paramLong));
      label462:
      AppMethodBeat.o(194420);
    }
    if ((localObject == null) || (localObject.length <= paramInt))
    {
      if (locald != null) {
        locald.a(4, ahJ(-10002), 0L, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(194420);
      return;
    }
  }
  
  @TargetApi(16)
  public final void aS(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194421);
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "deselectTrack, android mediaplayer not support ");
      AppMethodBeat.o(194421);
      return;
    }
    this.luF.deselectTrack(paramInt);
    AppMethodBeat.o(194421);
  }
  
  public final void aT(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194442);
    com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "selectProgram, android mediaplayer not support");
    AppMethodBeat.o(194442);
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      AppMethodBeat.i(194414);
      if (paramParcelFileDescriptor == null)
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource pfd is null ");
        paramParcelFileDescriptor = new IllegalArgumentException("pfd is null");
        AppMethodBeat.o(194414);
        throw paramParcelFileDescriptor;
      }
    }
    finally {}
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource pfd， pfd: " + paramParcelFileDescriptor.toString());
    this.Mud = paramParcelFileDescriptor.getFileDescriptor();
    this.luF.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
    this.Muo = new com.tencent.thumbplayer.c.b(paramParcelFileDescriptor.getFileDescriptor());
    this.Muz = d.MuQ;
    AppMethodBeat.o(194414);
  }
  
  public final void b(com.tencent.thumbplayer.b.f paramf)
  {
    switch (paramf.key)
    {
    default: 
      return;
    case 100: 
      this.Mug = ((int)paramf.MvJ.value);
      return;
    case 500: 
      this.Muh = paramf.MvJ.value;
      return;
    case 1: 
      this.Mui = paramf.MvJ.value;
      return;
    case 2: 
      this.Muk = ((int)paramf.MvJ.value);
      return;
    case 3: 
      this.Muj = ((int)paramf.MvJ.value);
      return;
    case 4: 
      this.ule = paramf.MvI.value;
      return;
    case 5: 
      this.Mul = paramf.MvI.value;
      return;
    case 207: 
      this.Mur = paramf.MvJ.value;
      return;
    }
    this.Muu = ((int)((paramf.MvJ.value + 400L) / 400L));
  }
  
  @TargetApi(16)
  public final void bl(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194416);
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addSubtitleSource android mediaplayer not support ");
      AppMethodBeat.o(194416);
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
        AppMethodBeat.o(194416);
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
        this.luF.addTimedTextSource(this.mContext, Uri.parse(paramString1), paramString3);
        AppMethodBeat.o(194416);
        return;
      }
      catch (Exception paramString1)
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", paramString1, "addTimedTextSource error");
        AppMethodBeat.o(194416);
        return;
      }
    }
    com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addTimedTextSource, mimeType no support.");
    AppMethodBeat.o(194416);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194436);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setLoopback, : " + paramBoolean + ", loopStart: " + paramLong1 + ", loopEnd: " + paramLong2);
    Object localObject;
    if (this.Muz == d.MuX)
    {
      localObject = new IllegalStateException("state error, current state is error state");
      AppMethodBeat.o(194436);
      throw ((Throwable)localObject);
    }
    if ((paramLong1 < 0L) || (paramLong1 > this.MuB) || (paramLong2 > this.MuB))
    {
      localObject = new IllegalArgumentException("position error, must more than 0 and less than duration");
      AppMethodBeat.o(194436);
      throw ((Throwable)localObject);
    }
    this.Mua = paramBoolean;
    this.Mub = paramLong1;
    this.Muc = paramLong2;
    this.luF.setLooping(paramBoolean);
    AppMethodBeat.o(194436);
  }
  
  public final void cg(float paramFloat)
  {
    AppMethodBeat.i(194433);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setAudioGainRatio, : ".concat(String.valueOf(paramFloat)));
    this.Mue = paramFloat;
    try
    {
      if (this.luF != null) {
        this.luF.setVolume(this.Mue, this.Mue);
      }
      AppMethodBeat.o(194433);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setAudioGainRatio ex : " + localIllegalStateException.toString());
      AppMethodBeat.o(194433);
    }
  }
  
  @TargetApi(23)
  public final void ch(float paramFloat)
  {
    AppMethodBeat.i(194434);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setPlaySpeedRatio, : ".concat(String.valueOf(paramFloat)));
    if (Build.VERSION.SDK_INT < 23)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "os version is too low: " + Build.VERSION.SDK_INT);
      AppMethodBeat.o(194434);
      return;
    }
    this.Muf = paramFloat;
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setPlaySpeedRatio play speed:".concat(String.valueOf(paramFloat)));
    try
    {
      PlaybackParams localPlaybackParams = this.luF.getPlaybackParams();
      if (localPlaybackParams.getSpeed() != paramFloat)
      {
        localPlaybackParams.setSpeed(paramFloat);
        this.luF.setPlaybackParams(localPlaybackParams);
      }
      AppMethodBeat.o(194434);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException);
      AppMethodBeat.o(194434);
    }
  }
  
  public final void g(String paramString1, String paramString2, List<com.tencent.thumbplayer.b.f> paramList)
  {
    AppMethodBeat.i(194417);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "addAudioTrackSource, illegal argument.");
    }
    n localn = new n();
    localn.name = paramString2;
    localn.isExclusive = true;
    localn.isInternal = false;
    localn.isSelected = false;
    paramString2 = new b((byte)0);
    paramString2.MuN = localn;
    paramString2.url = paramString1;
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramList = (com.tencent.thumbplayer.b.f)paramString1.next();
      if (paramList.key == 6) {
        paramString2.MuO = paramList.MvK.value;
      }
    }
    this.MuJ.add(paramString2);
    AppMethodBeat.o(194417);
  }
  
  @TargetApi(16)
  public final n[] gaF()
  {
    AppMethodBeat.i(194441);
    if ((this.Muz == d.MuS) || (this.Muz == d.MuT) || (this.Muz == d.MuU)) {}
    Object localObject;
    for (;;)
    {
      try
      {
        MediaPlayer.TrackInfo[] arrayOfTrackInfo = this.luF.getTrackInfo();
        if ((arrayOfTrackInfo != null) || (!this.MuJ.isEmpty())) {
          break;
        }
        AppMethodBeat.o(194441);
        return new n[0];
      }
      catch (Exception localException)
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "getTrackInfo, android getTrackInfo crash");
      }
      localObject = null;
    }
    int j = this.MuJ.size();
    if (localObject == null) {}
    n[] arrayOfn;
    Iterator localIterator;
    for (int i = 0;; i = localObject.length)
    {
      arrayOfn = new n[i + j];
      localIterator = this.MuJ.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        arrayOfn[i] = ((b)localIterator.next()).MuN;
        i += 1;
      }
    }
    if (localObject == null)
    {
      AppMethodBeat.o(194441);
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
    AppMethodBeat.o(194441);
    return arrayOfn;
  }
  
  public final k[] gaG()
  {
    return new k[0];
  }
  
  final void gaL()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(194419);
        Object localObject1 = this.MuK;
        if (localObject1 == null) {
          break label334;
        }
        com.tencent.thumbplayer.a.a.c.d locald = this.MtH;
        int i;
        if (((e)localObject1).Mva == 1)
        {
          i = 3;
          if (locald != null) {
            locald.a(i, 1000L, 0L, Long.valueOf(((e)localObject1).Mts));
          }
          if (Build.VERSION.SDK_INT >= 16)
          {
            if (((e)localObject1).Mvc > 0) {
              this.luF.selectTrack(((e)localObject1).Mvc);
            }
            if (((e)localObject1).Mvd > 0) {
              this.luF.selectTrack(((e)localObject1).Mvd);
            }
          }
          if ((((e)localObject1).position > 0L) && (!this.Muy)) {
            com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared(), and seekto:" + this.Mug);
          }
        }
        try
        {
          this.luF.seekTo((int)((e)localObject1).position);
          if ((((e)localObject1).Mve == d.MuP) || (((e)localObject1).Mve == d.MuQ) || (((e)localObject1).Mve == d.MuR))
          {
            localObject1 = this.MtF;
            if (localObject1 != null) {
              ((com.tencent.thumbplayer.a.a.c.e)localObject1).ta();
            }
            this.Muz = d.MuS;
            this.MuK = null;
            AppMethodBeat.o(194419);
            return;
            i = 4;
          }
        }
        catch (Exception localException2)
        {
          com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException2);
          continue;
        }
        if (localObject2.Mve == d.MuS) {
          break label259;
        }
      }
      finally {}
      if (localObject2.Mve == d.MuU)
      {
        label259:
        this.Muz = localObject2.Mve;
        continue;
      }
      if (localObject2.Mve == d.MuT)
      {
        this.luF.start();
        this.Muz = localObject2.Mve;
        continue;
      }
      this.Muz = d.MuX;
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "illegal state, state:" + localObject2.Mve);
      continue;
      label334:
      if ((this.Mug > 0) && (!this.Muy)) {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared(), and seekto:" + this.Mug);
      }
      try
      {
        this.luF.seekTo(this.Mug);
        com.tencent.thumbplayer.a.a.c.e locale = this.MtF;
        if (locale != null) {
          locale.ta();
        }
        AppMethodBeat.o(194419);
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
  final void gaM()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 840
    //   5: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 157	com/tencent/thumbplayer/a/a/a/c:Muq	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 155	com/tencent/thumbplayer/a/a/a/c:Mup	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 155	com/tencent/thumbplayer/a/a/a/c:Mup	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 846 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 155	com/tencent/thumbplayer/a/a/a/c:Mup	Ljava/util/concurrent/Future;
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc_w 840
    //   43: invokestatic 317	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: ldc_w 840
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
  final void gaO()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 848
    //   5: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 165	com/tencent/thumbplayer/a/a/a/c:Mut	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 163	com/tencent/thumbplayer/a/a/a/c:Mus	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 163	com/tencent/thumbplayer/a/a/a/c:Mus	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 846 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 163	com/tencent/thumbplayer/a/a/a/c:Mus	Ljava/util/concurrent/Future;
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc_w 848
    //   43: invokestatic 317	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: ldc_w 848
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
  final void gaP()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 850
    //   5: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 169	com/tencent/thumbplayer/a/a/a/c:Muv	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 171	com/tencent/thumbplayer/a/a/a/c:Muw	Ljava/util/concurrent/Future;
    //   19: ifnull +19 -> 38
    //   22: aload_0
    //   23: getfield 171	com/tencent/thumbplayer/a/a/a/c:Muw	Ljava/util/concurrent/Future;
    //   26: iconst_1
    //   27: invokeinterface 846 2 0
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 171	com/tencent/thumbplayer/a/a/a/c:Muw	Ljava/util/concurrent/Future;
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc_w 850
    //   43: invokestatic 317	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: ldc_w 850
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
  
  final boolean gaQ()
  {
    AppMethodBeat.i(194448);
    if (this.ule)
    {
      AppMethodBeat.o(194448);
      return false;
    }
    if (getDurationMs() <= 0L)
    {
      AppMethodBeat.o(194448);
      return false;
    }
    boolean bool = this.Mul;
    AppMethodBeat.o(194448);
    return bool;
  }
  
  public final long getBufferedDurationMs()
  {
    return this.MuD;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(194438);
    if ((this.luF == null) || (this.Muz == d.MuP) || (this.Muz == d.MuQ) || (this.Muz == d.MuR) || (this.Muz == d.MuV) || (this.Muz == d.MuS))
    {
      l = this.Mug;
      AppMethodBeat.o(194438);
      return l;
    }
    long l = this.luF.getCurrentPosition();
    AppMethodBeat.o(194438);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(194437);
    if ((this.Muz != d.MuS) && (this.Muz != d.MuT) && (this.Muz != d.MuU))
    {
      AppMethodBeat.o(194437);
      return -1L;
    }
    if (this.MuB <= 0L) {
      this.MuB = this.luF.getDuration();
    }
    if (this.Mui > 0L) {
      if (this.MuB > 0L) {
        break label106;
      }
    }
    for (this.MuB = this.Mui;; this.MuB = this.Mui) {
      label106:
      do
      {
        long l = this.MuB;
        AppMethodBeat.o(194437);
        return l;
      } while ((this.MuB <= 0L) || (Math.abs(this.Mui - this.MuB) * 100L / this.Mui <= 1L));
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
    AppMethodBeat.i(194440);
    if (this.mVideoHeight <= 0) {
      this.mVideoHeight = this.luF.getVideoHeight();
    }
    if ((this.mVideoHeight <= 0) && (this.Muj > 0) && ((this.Muz == d.MuS) || (this.Muz == d.MuT) || (this.Muz == d.MuU))) {
      this.mVideoHeight = this.Muj;
    }
    int i = this.mVideoHeight;
    AppMethodBeat.o(194440);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(194439);
    if (this.mVideoWidth <= 0) {
      this.mVideoWidth = this.luF.getVideoWidth();
    }
    if (((this.Muz == d.MuS) || (this.Muz == d.MuT) || (this.Muz == d.MuU)) && (this.mVideoWidth <= 0) && (this.Muk > 0)) {
      this.mVideoWidth = this.Muk;
    }
    int i = this.mVideoWidth;
    AppMethodBeat.o(194439);
    return i;
  }
  
  @TargetApi(26)
  public final void kZ(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(194430);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "seekTo, position: " + paramInt1 + ", mode: " + paramInt2);
    if (this.Muy)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "current media is not seekable, ignore");
      AppMethodBeat.o(194430);
      return;
    }
    if (Build.VERSION.SDK_INT < 26)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "os ver is too low, current sdk int:" + Build.VERSION.SDK_INT + ", is less than 26, use seekTo(int positionMs) instead");
      this.luF.seekTo(paramInt1);
      AppMethodBeat.o(194430);
      return;
    }
    if (paramInt2 == 1) {}
    for (;;)
    {
      try
      {
        this.luF.seekTo(paramInt1, i);
        AppMethodBeat.o(194430);
        return;
      }
      catch (Exception localException1)
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException1);
        try
        {
          this.luF.seekTo(paramInt1);
          AppMethodBeat.o(194430);
          return;
        }
        catch (Exception localException2)
        {
          com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException2);
          AppMethodBeat.o(194430);
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
    AppMethodBeat.i(194425);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "pause ");
    this.luF.pause();
    this.Muz = d.MuU;
    AppMethodBeat.o(194425);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(194422);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "prepare ");
    this.Muz = d.MuR;
    this.luF.prepare();
    AppMethodBeat.o(194422);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(194423);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "prepareAsync ");
    this.Muz = d.MuR;
    this.luF.prepareAsync();
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "startCheckPrepareTimeoutTimer");
    synchronized (this.Muq)
    {
      if (this.Mup == null) {
        this.Mup = com.tencent.thumbplayer.utils.f.getScheduledExecutorServiceInstance().schedule(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194392);
            if (c.this.Muz == c.d.MuR) {
              com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "startCheckPrepareTimeoutTimer, post error");
            }
            try
            {
              c.this.luF.stop();
              c.this.Muz = c.d.MuX;
              c.this.gaM();
              if (c.this.MtI != null) {
                c.this.MtI.a(2001, c.ahJ(-110), 0L, 0L);
              }
              AppMethodBeat.o(194392);
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
        }, this.Mur, TimeUnit.MILLISECONDS);
      }
      AppMethodBeat.o(194423);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(194428);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "release ");
    this.Mux = false;
    gaM();
    gaO();
    gaP();
    this.luF.reset();
    this.luF.release();
    this.MtF = null;
    this.MtG = null;
    this.MtH = null;
    this.MtI = null;
    this.MtJ = null;
    this.MtK = null;
    this.MtL = null;
    this.Mun = null;
    this.Muz = d.MuY;
    AppMethodBeat.o(194428);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(194427);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "reset ");
    this.Mux = false;
    this.luF.reset();
    gaM();
    gaO();
    gaP();
    this.Muz = d.MuP;
    AppMethodBeat.o(194427);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(194429);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "seekTo, position: ".concat(String.valueOf(paramInt)));
    if (this.Muy)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "current media is not seekable, ignore");
      AppMethodBeat.o(194429);
      return;
    }
    this.luF.seekTo(paramInt);
    AppMethodBeat.o(194429);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(194412);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource， url: ".concat(String.valueOf(paramString)));
    this.mUrl = paramString;
    this.luF.setDataSource(paramString);
    this.Muo = new com.tencent.thumbplayer.c.b(paramString);
    this.Muz = d.MuQ;
    AppMethodBeat.o(194412);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(194413);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setDataSource httpHeader， url: ".concat(String.valueOf(paramString)));
    this.mUrl = paramString;
    this.iIv = paramMap;
    paramMap = Uri.parse(this.mUrl);
    this.luF.setDataSource(this.mContext, paramMap, this.iIv);
    this.Muo = new com.tencent.thumbplayer.c.b(paramString);
    this.Muz = d.MuQ;
    AppMethodBeat.o(194413);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(194411);
    this.luF.setSurface(paramSurface);
    AppMethodBeat.o(194411);
  }
  
  public final void start()
  {
    AppMethodBeat.i(194424);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "start ");
    this.Mux = false;
    this.luF.start();
    this.Muz = d.MuT;
    if (this.Muf != 1.0D) {
      ch(this.Muf);
    }
    gaN();
    if ((this.Mug == 0) && (!this.Muy)) {
      this.Mun.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194391);
          if ((!c.this.Mux) && (c.this.Muz != c.d.MuU))
          {
            c.this.MuA = true;
            try
            {
              com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "position not change, so auto seek");
              c.this.luF.seekTo(c.this.Mug + 500);
              AppMethodBeat.o(194391);
              return;
            }
            catch (Exception localException)
            {
              com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", localException);
            }
          }
          AppMethodBeat.o(194391);
        }
      }, 2000L);
    }
    AppMethodBeat.o(194424);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(194426);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "stop ");
    gaM();
    gaO();
    gaP();
    this.luF.stop();
    this.Muz = d.MuV;
    this.MuH = 0;
    this.MuG = -1;
    this.MuI = -1;
    AppMethodBeat.o(194426);
  }
  
  public final void zJ(boolean paramBoolean)
  {
    AppMethodBeat.i(194435);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setLoopback, : ".concat(String.valueOf(paramBoolean)));
    this.Mua = paramBoolean;
    this.luF.setLooping(paramBoolean);
    AppMethodBeat.o(194435);
  }
  
  public final void zK(boolean paramBoolean)
  {
    AppMethodBeat.i(194432);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, : ".concat(String.valueOf(paramBoolean)));
    if (this.luF == null)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, player is null");
      AppMethodBeat.o(194432);
      return;
    }
    if (paramBoolean) {
      try
      {
        this.luF.setVolume(0.0F, 0.0F);
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, true");
        AppMethodBeat.o(194432);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, Exception: " + localException.toString());
        AppMethodBeat.o(194432);
        return;
      }
    }
    this.luF.setVolume(this.Mue, this.Mue);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "setOutputMute, false, mAudioGain: " + this.Mue);
    AppMethodBeat.o(194432);
  }
  
  static final class b
  {
    public n MuN;
    public String MuO = "";
    public String url = "";
  }
  
  final class c
    implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener
  {
    private c() {}
    
    public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
    {
      AppMethodBeat.i(194404);
      long l2 = ((float)(c.this.getDurationMs() * paramInt) / 100.0F) - c.this.getCurrentPositionMs();
      paramMediaPlayer = c.this;
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = c.this.MuD;
      }
      paramMediaPlayer.MuD = l1;
      AppMethodBeat.o(194404);
    }
    
    public final void onCompletion(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(194399);
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onCompletion, : ");
      c.this.Muz = c.d.MuW;
      c.this.gaO();
      if (c.this.MtG != null) {
        c.this.MtG.onCompletion();
      }
      AppMethodBeat.o(194399);
    }
    
    public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      int j = 2000;
      AppMethodBeat.i(194400);
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onError, : " + paramInt1 + ", extra: " + paramInt2);
      c.this.gaM();
      c.this.gaO();
      c.this.Muz = c.d.MuX;
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
        if (c.this.MtI != null) {
          c.this.MtI.a(i, c.ahJ(paramInt1), paramInt2, 0L);
        }
        AppMethodBeat.o(194400);
        return true;
        i = 2001;
        continue;
        i = 2001;
      }
    }
    
    public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(194401);
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
          if (!c.this.gaQ())
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
        synchronized (localc.Muv)
        {
          if (localc.Muw == null) {
            localc.Muw = com.tencent.thumbplayer.utils.f.getScheduledExecutorServiceInstance().schedule(new c.4(localc), 1200L, TimeUnit.MILLISECONDS);
          }
          if (c.this.MtH != null) {
            c.this.MtH.a(paramInt1, 0L, 0L, null);
          }
          if (paramInt1 == 106)
          {
            paramInt1 = paramMediaPlayer.getVideoWidth();
            paramInt2 = paramMediaPlayer.getVideoHeight();
            if (((paramInt2 != c.this.mVideoHeight) || (paramInt1 != c.this.mVideoWidth)) && (paramInt2 > 0) && (paramInt1 > 0))
            {
              c.this.mVideoHeight = paramInt2;
              c.this.mVideoWidth = paramInt1;
              if (c.this.MtK != null) {
                c.this.MtK.aC(c.this.mVideoWidth, c.this.mVideoHeight);
              }
            }
          }
          AppMethodBeat.o(194401);
          return true;
          paramInt1 = 200;
          break;
          paramInt1 = 201;
          break;
          paramInt1 = 106;
          break;
          c.this.Muy = true;
          paramInt1 = paramInt2;
        }
        label322:
        c.this.gaP();
        continue;
        label332:
        if (c.this.MtH != null) {
          c.this.MtH.a(106, 0L, 0L, null);
        }
      }
    }
    
    public final void onPrepared(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(194398);
      if (c.this.Muz != c.d.MuR)
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared() is called in a wrong situation, mState = " + c.this.Muz);
        AppMethodBeat.o(194398);
        return;
      }
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared() , mStartPositionMs=" + c.this.Mug);
      c.this.gaM();
      c.this.gaL();
      AppMethodBeat.o(194398);
    }
    
    public final void onSeekComplete(MediaPlayer paramMediaPlayer)
    {
      AppMethodBeat.i(194402);
      if (c.this.luF == null)
      {
        AppMethodBeat.o(194402);
        return;
      }
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onSeekComplete().");
      if ((c.d.MuU == c.this.Muz) && (paramMediaPlayer != null)) {}
      try
      {
        paramMediaPlayer.pause();
        if ((!c.this.MuA) && (c.d.MuS != c.this.Muz) && (c.this.MtJ != null)) {
          c.this.MtJ.clF();
        }
        c.this.MuA = false;
        AppMethodBeat.o(194402);
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
      AppMethodBeat.i(194403);
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "onVideoSizeChanged() size error, width:" + paramInt1 + " height:" + paramInt2);
        AppMethodBeat.o(194403);
        return;
      }
      try
      {
        if ((paramInt1 != c.this.mVideoWidth) || (paramInt2 != c.this.mVideoHeight)) {
          c.this.MtK.aC(paramInt1, paramInt2);
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
      AppMethodBeat.o(194403);
    }
  }
  
  static enum d
  {
    static
    {
      AppMethodBeat.i(194407);
      MuP = new d("IDLE", 0);
      MuQ = new d("INITIALIZED", 1);
      MuR = new d("PREPARING", 2);
      MuS = new d("PREPARED", 3);
      MuT = new d("STARTED", 4);
      MuU = new d("PAUSED", 5);
      MuV = new d("STOPPED", 6);
      MuW = new d("COMPLETE", 7);
      MuX = new d("ERROR", 8);
      MuY = new d("RELEASE", 9);
      MuZ = new d[] { MuP, MuQ, MuR, MuS, MuT, MuU, MuV, MuW, MuX, MuY };
      AppMethodBeat.o(194407);
    }
    
    private d() {}
  }
  
  static final class e
  {
    long Mts;
    int Mva;
    int Mvb;
    int Mvc;
    int Mvd;
    c.d Mve;
    long position;
    String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */