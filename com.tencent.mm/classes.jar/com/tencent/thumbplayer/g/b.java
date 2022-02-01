package com.tencent.thumbplayer.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.a.a;
import com.tencent.thumbplayer.b.d;
import com.tencent.thumbplayer.b.e;
import com.tencent.thumbplayer.b.i.b;
import com.tencent.thumbplayer.b.i.c;
import com.tencent.thumbplayer.b.i.d;
import com.tencent.thumbplayer.b.k;
import com.tencent.thumbplayer.b.n;
import com.tencent.thumbplayer.b.p;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.utils.h;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class b
  implements ITPPlayListener
{
  d.k Kif;
  private d.i Kig;
  private d.e Kih;
  private long Kii;
  private String Kij;
  private Object Kik;
  private Object Kil;
  private Object Kim;
  private b Kin;
  private a Kio;
  private h Kip;
  private Looper mLooper;
  
  b(Looper paramLooper, b paramb)
  {
    AppMethodBeat.i(188055);
    this.mLooper = paramLooper;
    this.Kio = new a(paramLooper);
    this.Kin = paramb;
    this.Kip = new h();
    this.Kif = new d.k();
    this.Kig = new d.i();
    this.Kih = new d.e();
    AppMethodBeat.o(188055);
  }
  
  private void I(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(188085);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      yN(paramBoolean);
      AppMethodBeat.o(188085);
      return;
      this.Kif.width = this.Kin.fFZ();
      continue;
      this.Kif.height = this.Kin.fGa();
      continue;
      this.Kig.KiT = this.Kin.fGb();
      continue;
      this.Kii = this.Kin.aeT(paramInt2);
      continue;
      this.Kij = this.Kin.aeU(paramInt2);
      continue;
      this.Kih.KiN = this.Kin.fGc();
    }
  }
  
  private void a(Message paramMessage, boolean paramBoolean)
  {
    AppMethodBeat.i(188084);
    if ((paramMessage.what != 83) && (paramMessage.what != 73) && (paramMessage.what != 74)) {
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerInternal.java]", "internalMessage " + aeW(paramMessage.what));
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(188084);
      return;
      this.Kin.c((com.tencent.thumbplayer.b.f)paramMessage.obj);
      AppMethodBeat.o(188084);
      return;
      this.Kin.l((Surface)paramMessage.obj);
      AppMethodBeat.o(188084);
      return;
      this.Kin.a((d.b)paramMessage.obj);
      AppMethodBeat.o(188084);
      return;
      this.Kin.b((p)paramMessage.obj);
      AppMethodBeat.o(188084);
      return;
      this.Kin.b(((d.j)paramMessage.obj).KiU, ((d.j)paramMessage.obj).KiV);
      AppMethodBeat.o(188084);
      return;
      paramMessage = (d.f)paramMessage.obj;
      if (paramMessage != null)
      {
        this.Kin.a(paramMessage.url, paramMessage.mimeType, paramMessage.name, paramMessage.KiO);
        AppMethodBeat.o(188084);
        return;
        paramMessage = (d.a)paramMessage.obj;
        if (paramMessage != null)
        {
          this.Kin.a(paramMessage.url, paramMessage.name, paramMessage.KiD);
          AppMethodBeat.o(188084);
          return;
          this.Kin.aL(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(188084);
          return;
          this.Kin.aM(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(188084);
          return;
          this.Kin.fFQ();
          AppMethodBeat.o(188084);
          return;
          this.Kin.fFR();
          AppMethodBeat.o(188084);
          return;
          this.Kin.fFS();
          AppMethodBeat.o(188084);
          return;
          this.Kin.fFT();
          yN(paramBoolean);
          AppMethodBeat.o(188084);
          return;
          this.Kin.fFU();
          yN(paramBoolean);
          AppMethodBeat.o(188084);
          return;
          this.Kin.fFV();
          yN(paramBoolean);
          this.Kio.removeCallbacksAndMessages(null);
          AppMethodBeat.o(188084);
          return;
          this.Kin.kF(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(188084);
          return;
          this.Kin.yL(((Boolean)paramMessage.obj).booleanValue());
          AppMethodBeat.o(188084);
          return;
          this.Kin.cf(((Float)paramMessage.obj).floatValue());
          AppMethodBeat.o(188084);
          return;
          this.Kin.cg(((Float)paramMessage.obj).floatValue());
          AppMethodBeat.o(188084);
          return;
          paramMessage = (d.c)paramMessage.obj;
          if (paramMessage != null)
          {
            this.Kin.d(paramMessage.Kcy, paramMessage.KiH, paramMessage.KiI);
            AppMethodBeat.o(188084);
            return;
            this.Kin.yM(((Boolean)paramMessage.obj).booleanValue());
            AppMethodBeat.o(188084);
            return;
            paramMessage = (d.h)paramMessage.obj;
            if (paramMessage != null)
            {
              if (!TextUtils.isEmpty(paramMessage.url))
              {
                this.Kin.a(paramMessage.url, paramMessage.KiR, paramMessage.KiS, paramMessage.mode);
                AppMethodBeat.o(188084);
                return;
              }
              this.Kin.a(paramMessage.KiG, paramMessage.KiR, paramMessage.KiS, paramMessage.mode);
              AppMethodBeat.o(188084);
              return;
              this.Kin.aN(paramMessage.arg1, paramMessage.arg2);
              AppMethodBeat.o(188084);
              return;
              I(paramMessage.what, paramMessage.arg1, paramBoolean);
              AppMethodBeat.o(188084);
              return;
              this.Kin.fGd();
              AppMethodBeat.o(188084);
              return;
              this.Kin.R(paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
              AppMethodBeat.o(188084);
              return;
              this.Kin.aTN((String)paramMessage.obj);
              AppMethodBeat.o(188084);
              return;
              paramMessage = (i.b)paramMessage.obj;
              this.Kin.bc(paramMessage.url, paramMessage.Kfe, paramMessage.Kfd);
              AppMethodBeat.o(188084);
              return;
              this.Kin.aeV(paramMessage.arg1);
              AppMethodBeat.o(188084);
              return;
              paramMessage = (i.d)paramMessage.obj;
              this.Kin.mu(paramMessage.Kfk, paramMessage.Kfl);
              AppMethodBeat.o(188084);
              return;
              this.Kin.bU((Map)paramMessage.obj);
              AppMethodBeat.o(188084);
              return;
              paramMessage = (d.d)paramMessage.obj;
              this.Kik = this.Kin.a(paramMessage.aRI, paramMessage.KiJ, paramMessage.KiL);
              yN(paramBoolean);
              AppMethodBeat.o(188084);
              return;
              ((Long)paramMessage.obj).longValue();
              this.Kil = null;
              yN(paramBoolean);
              AppMethodBeat.o(188084);
              return;
              paramMessage = (i.c)paramMessage.obj;
              this.Kin.b((int)paramMessage.Kfg, paramMessage.Kfh, paramMessage.Kfi, paramMessage.Kfj);
              AppMethodBeat.o(188084);
              return;
              paramMessage = paramMessage.obj;
              this.Kim = null;
              yN(paramBoolean);
            }
          }
        }
      }
    }
  }
  
  private static String aeW(int paramInt)
  {
    AppMethodBeat.i(188081);
    switch (paramInt)
    {
    case 2: 
    case 3: 
    case 9: 
    case 24: 
    case 25: 
    case 26: 
    case 34: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 70: 
    case 71: 
    case 72: 
    default: 
      String str = "[tpPlayer] -> ".concat(String.valueOf(paramInt));
      AppMethodBeat.o(188081);
      return str;
    case 1: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> set player params";
    case 4: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> set surface";
    case 5: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> set data source";
    case 6: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> set subtitle source";
    case 7: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> add audio source";
    case 8: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> add select track";
    case 36: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> deselect track";
    case 10: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> prepare async";
    case 11: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> start";
    case 12: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> pause";
    case 13: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> stop";
    case 14: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> reset";
    case 15: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> release";
    case 16: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> seek to";
    case 17: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> set output mute";
    case 18: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> set audio gain ratio";
    case 19: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> set speed ratio";
    case 35: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> set loopback";
    case 21: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> get video width";
    case 22: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> get video height";
    case 23: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> get track info";
    case 27: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> get property long";
    case 28: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> get property string";
    case 29: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> set video info";
    case 30: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> capture video";
    case 31: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> switch def";
    case 32: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> select program";
    case 33: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> get program";
    case 20: 
      AppMethodBeat.o(188081);
      return "[tpPlayer] -> set loopback with param";
    }
    AppMethodBeat.o(188081);
    return "[tpPlayer] -> cdn info update";
  }
  
  private boolean fGj()
  {
    AppMethodBeat.i(188075);
    if (Looper.myLooper() == this.mLooper)
    {
      AppMethodBeat.o(188075);
      return true;
    }
    AppMethodBeat.o(188075);
    return false;
  }
  
  private void fGk()
  {
    AppMethodBeat.i(188076);
    if (!fGj()) {
      this.Kip.readLock().unlock();
    }
    AppMethodBeat.o(188076);
  }
  
  private void fGl()
  {
    AppMethodBeat.i(188077);
    if (!fGj()) {
      this.Kip.readLock().lock();
    }
    AppMethodBeat.o(188077);
  }
  
  private void fGp()
  {
    AppMethodBeat.i(188083);
    this.Kip.fGz();
    AppMethodBeat.o(188083);
  }
  
  private void yN(boolean paramBoolean)
  {
    AppMethodBeat.i(188080);
    if (paramBoolean) {
      this.Kip.writeLock().lock();
    }
    if (paramBoolean) {
      this.Kip.Kmx.signalAll();
    }
    if (paramBoolean) {
      this.Kip.writeLock().unlock();
    }
    AppMethodBeat.o(188080);
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(188074);
    fGl();
    if (this.Kio == null)
    {
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerInternal.java]", aeW(paramInt1) + " , send failed , handler null");
      fGk();
      AppMethodBeat.o(188074);
      return;
    }
    if ((paramBoolean1) && (paramObject == null))
    {
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerInternal.java]", aeW(paramInt1) + ", send failed , params null");
      fGk();
      AppMethodBeat.o(188074);
      return;
    }
    if (paramBoolean2) {
      this.Kio.removeMessages(paramInt1);
    }
    Message localMessage = this.Kio.obtainMessage();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    if (fGj()) {
      a(localMessage, false);
    }
    for (;;)
    {
      fGk();
      AppMethodBeat.o(188074);
      return;
      this.Kio.sendMessageDelayed(localMessage, 0L);
    }
  }
  
  final void fGm()
  {
    AppMethodBeat.i(188078);
    if (!fGj()) {
      this.Kip.writeLock().lock();
    }
    AppMethodBeat.o(188078);
  }
  
  final void fGn()
  {
    AppMethodBeat.i(188079);
    if (!fGj()) {
      this.Kip.writeLock().unlock();
    }
    AppMethodBeat.o(188079);
  }
  
  final void fGo()
  {
    AppMethodBeat.i(188082);
    if (fGj())
    {
      AppMethodBeat.o(188082);
      return;
    }
    fGp();
    AppMethodBeat.o(188082);
  }
  
  public final long getAdvRemainTime()
  {
    AppMethodBeat.i(188071);
    try
    {
      long l = this.Kin.fGg();
      AppMethodBeat.o(188071);
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(188071);
    }
    return 0L;
  }
  
  public final String getContentType(long paramLong, String paramString)
  {
    return null;
  }
  
  public final int getCurrentPlayClipNo()
  {
    AppMethodBeat.i(188070);
    try
    {
      int i = this.Kin.fGf();
      AppMethodBeat.o(188070);
      return i;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(188070);
    }
    return 0;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(188069);
    long l = getCurrentPositionMs();
    AppMethodBeat.o(188069);
    return l;
  }
  
  final long getCurrentPositionMs()
  {
    AppMethodBeat.i(188057);
    try
    {
      long l = this.Kin.fFX();
      AppMethodBeat.o(188057);
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(188057);
    }
    return 0L;
  }
  
  public final String getDataFilePath(long paramLong, String paramString)
  {
    return null;
  }
  
  public final long getDataTotalSize(long paramLong, String paramString)
  {
    return 0L;
  }
  
  final long getDurationMs()
  {
    AppMethodBeat.i(188056);
    try
    {
      long l = this.Kin.fFW();
      AppMethodBeat.o(188056);
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(188056);
    }
    return 0L;
  }
  
  public final Object getPlayInfo(long paramLong)
  {
    AppMethodBeat.i(188072);
    fGm();
    a(82, 0, 0, Long.valueOf(paramLong), false, false);
    fGo();
    fGn();
    Object localObject = this.Kil;
    AppMethodBeat.o(188072);
    return localObject;
  }
  
  public final Object getPlayInfo(String paramString)
  {
    AppMethodBeat.i(188073);
    fGm();
    a(84, 0, 0, paramString, false, false);
    fGo();
    fGn();
    paramString = this.Kim;
    AppMethodBeat.o(188073);
    return paramString;
  }
  
  public final long getPlayerBufferLength()
  {
    AppMethodBeat.i(188068);
    try
    {
      long l = this.Kin.fGe();
      AppMethodBeat.o(188068);
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(188068);
    }
    return 0L;
  }
  
  public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    AppMethodBeat.i(188065);
    a(76, 0, 0, paramMap, false, false);
    AppMethodBeat.o(188065);
  }
  
  public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(188064);
    i.b localb = new i.b();
    localb.url = paramString1;
    localb.Kfe = paramString2;
    localb.Kfd = paramString3;
    localb.Kff = paramString4;
    a(73, 0, 0, localb, false, false);
    AppMethodBeat.o(188064);
  }
  
  public final void onDownloadCdnUrlUpdate(String paramString)
  {
    AppMethodBeat.i(188063);
    a(72, 0, 0, paramString, false, false);
    AppMethodBeat.o(188063);
  }
  
  public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(188061);
    a(71, paramInt1, paramInt2, paramString, false, false);
    AppMethodBeat.o(188061);
  }
  
  public final void onDownloadFinish()
  {
    AppMethodBeat.i(188060);
    a(70, 0, 0, null, false, false);
    AppMethodBeat.o(188060);
  }
  
  public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188059);
    i.c localc = new i.c();
    localc.Kfg = paramInt1;
    localc.Kfh = paramInt2;
    localc.Kfi = paramLong1;
    localc.Kfj = paramLong2;
    a(83, 0, 0, localc, false, false);
    AppMethodBeat.o(188059);
  }
  
  public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188067);
    i.d locald = new i.d();
    locald.Kfl = paramString2;
    locald.Kfk = paramString1;
    a(75, 0, 0, locald, false, false);
    AppMethodBeat.o(188067);
  }
  
  public final void onDownloadStatusUpdate(int paramInt)
  {
    AppMethodBeat.i(188066);
    a(74, paramInt, 0, null, false, false);
    AppMethodBeat.o(188066);
  }
  
  public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(188062);
    fGm();
    d.d locald = new d.d();
    locald.aRI = paramInt;
    locald.KiJ = paramObject1;
    locald.KiK = paramObject2;
    locald.KiL = paramObject3;
    locald.KiM = paramObject4;
    a(77, 0, 0, locald, false, false);
    fGo();
    fGn();
    paramObject1 = this.Kik;
    AppMethodBeat.o(188062);
    return paramObject1;
  }
  
  public final int onReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    return 0;
  }
  
  public final int onStartReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    return 0;
  }
  
  public final int onStopReadData(long paramLong, String paramString)
  {
    return 0;
  }
  
  final class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(188054);
      b.a(b.this, paramMessage);
      AppMethodBeat.o(188054);
    }
  }
  
  public static abstract interface b
  {
    public abstract void R(int paramInt1, int paramInt2, String paramString);
    
    public abstract Object a(int paramInt, Object paramObject1, Object paramObject2);
    
    public abstract void a(a parama, long paramLong, p paramp, int paramInt);
    
    public abstract void a(d.b paramb);
    
    public abstract void a(String paramString, long paramLong, p paramp, int paramInt);
    
    public abstract void a(String paramString1, String paramString2, com.tencent.thumbplayer.b.b.b paramb);
    
    public abstract void a(String paramString1, String paramString2, String paramString3, com.tencent.thumbplayer.b.b.b paramb);
    
    public abstract void aL(int paramInt, long paramLong);
    
    public abstract void aM(int paramInt, long paramLong);
    
    public abstract void aN(int paramInt, long paramLong);
    
    public abstract void aTN(String paramString);
    
    public abstract long aeT(int paramInt);
    
    public abstract String aeU(int paramInt);
    
    public abstract void aeV(int paramInt);
    
    public abstract void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
    
    public abstract void b(e parame, d paramd);
    
    public abstract void b(p paramp);
    
    public abstract void bU(Map<String, String> paramMap);
    
    public abstract void bc(String paramString1, String paramString2, String paramString3);
    
    public abstract void c(com.tencent.thumbplayer.b.f paramf);
    
    public abstract void cf(float paramFloat);
    
    public abstract void cg(float paramFloat);
    
    public abstract void d(boolean paramBoolean, long paramLong1, long paramLong2);
    
    public abstract void fFQ();
    
    public abstract void fFR();
    
    public abstract void fFS();
    
    public abstract void fFT();
    
    public abstract void fFU();
    
    public abstract void fFV();
    
    public abstract long fFW();
    
    public abstract long fFX();
    
    public abstract int fFZ();
    
    public abstract int fGa();
    
    public abstract n[] fGb();
    
    public abstract k[] fGc();
    
    public abstract void fGd();
    
    public abstract long fGe();
    
    public abstract int fGf();
    
    public abstract long fGg();
    
    public abstract void kF(int paramInt1, int paramInt2);
    
    public abstract void l(Surface paramSurface);
    
    public abstract void mu(String paramString1, String paramString2);
    
    public abstract void yL(boolean paramBoolean);
    
    public abstract void yM(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.g.b
 * JD-Core Version:    0.7.0.1
 */