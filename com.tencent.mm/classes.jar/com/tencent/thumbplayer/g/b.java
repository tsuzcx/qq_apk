package com.tencent.thumbplayer.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.a.a;
import com.tencent.thumbplayer.b.f;
import com.tencent.thumbplayer.b.i.b;
import com.tencent.thumbplayer.b.i.c;
import com.tencent.thumbplayer.b.i.d;
import com.tencent.thumbplayer.b.k;
import com.tencent.thumbplayer.b.n;
import com.tencent.thumbplayer.b.p;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class b
  implements ITPPlayListener
{
  d.k Myp;
  private d.i Myq;
  private d.e Myr;
  long Mys;
  private String Myt;
  private Object Myu;
  private Object Myv;
  private Object Myw;
  private b Myx;
  private a Myy;
  private com.tencent.thumbplayer.utils.e Myz;
  private Looper mLooper;
  
  b(Looper paramLooper, b paramb)
  {
    AppMethodBeat.i(194756);
    this.mLooper = paramLooper;
    this.Myy = new a(paramLooper);
    this.Myx = paramb;
    this.Myz = new com.tencent.thumbplayer.utils.e();
    this.Myp = new d.k();
    this.Myq = new d.i();
    this.Myr = new d.e();
    AppMethodBeat.o(194756);
  }
  
  private void J(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(194785);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      zO(paramBoolean);
      AppMethodBeat.o(194785);
      return;
      this.Myp.width = this.Myx.gbO();
      continue;
      this.Myp.height = this.Myx.gbP();
      continue;
      this.Myq.Mzd = this.Myx.gbQ();
      continue;
      this.Mys = this.Myx.aic(paramInt2);
      continue;
      this.Myt = this.Myx.aid(paramInt2);
      continue;
      this.Myr.MyX = this.Myx.gbR();
    }
  }
  
  private void a(Message paramMessage, boolean paramBoolean)
  {
    AppMethodBeat.i(194784);
    if ((paramMessage.what != 83) && (paramMessage.what != 73) && (paramMessage.what != 74)) {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerInternal.java]", "internalMessage " + aif(paramMessage.what));
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(194784);
      return;
      this.Myx.c((f)paramMessage.obj);
      AppMethodBeat.o(194784);
      return;
      this.Myx.l((Surface)paramMessage.obj);
      AppMethodBeat.o(194784);
      return;
      this.Myx.a((d.b)paramMessage.obj);
      AppMethodBeat.o(194784);
      return;
      this.Myx.b((p)paramMessage.obj);
      AppMethodBeat.o(194784);
      return;
      this.Myx.b(((d.j)paramMessage.obj).Mze, ((d.j)paramMessage.obj).Mzf);
      AppMethodBeat.o(194784);
      return;
      paramMessage = (d.f)paramMessage.obj;
      if (paramMessage != null)
      {
        this.Myx.a(paramMessage.url, paramMessage.mimeType, paramMessage.name, paramMessage.MyY);
        AppMethodBeat.o(194784);
        return;
        paramMessage = (d.a)paramMessage.obj;
        if (paramMessage != null)
        {
          this.Myx.a(paramMessage.url, paramMessage.name, paramMessage.MyN);
          AppMethodBeat.o(194784);
          return;
          this.Myx.aW(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(194784);
          return;
          this.Myx.aX(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(194784);
          return;
          this.Myx.gbG();
          AppMethodBeat.o(194784);
          return;
          this.Myx.gbH();
          AppMethodBeat.o(194784);
          return;
          this.Myx.gbI();
          AppMethodBeat.o(194784);
          return;
          this.Myx.gbJ();
          zO(paramBoolean);
          AppMethodBeat.o(194784);
          return;
          this.Myx.gbK();
          zO(paramBoolean);
          AppMethodBeat.o(194784);
          return;
          this.Myx.gbL();
          zO(paramBoolean);
          this.Myy.removeCallbacksAndMessages(null);
          AppMethodBeat.o(194784);
          return;
          this.Myx.lb(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(194784);
          return;
          this.Myx.zM(((Boolean)paramMessage.obj).booleanValue());
          AppMethodBeat.o(194784);
          return;
          this.Myx.ci(((Float)paramMessage.obj).floatValue());
          AppMethodBeat.o(194784);
          return;
          this.Myx.cj(((Float)paramMessage.obj).floatValue());
          AppMethodBeat.o(194784);
          return;
          paramMessage = (d.c)paramMessage.obj;
          if (paramMessage != null)
          {
            this.Myx.d(paramMessage.Mtp, paramMessage.MyR, paramMessage.MyS);
            AppMethodBeat.o(194784);
            return;
            this.Myx.zN(((Boolean)paramMessage.obj).booleanValue());
            AppMethodBeat.o(194784);
            return;
            paramMessage = (d.h)paramMessage.obj;
            if (paramMessage != null)
            {
              if (!TextUtils.isEmpty(paramMessage.url))
              {
                this.Myx.a(paramMessage.url, paramMessage.Mzb, paramMessage.Mzc, paramMessage.mode);
                AppMethodBeat.o(194784);
                return;
              }
              this.Myx.a(paramMessage.MyQ, paramMessage.Mzb, paramMessage.Mzc, paramMessage.mode);
              AppMethodBeat.o(194784);
              return;
              this.Myx.aY(paramMessage.arg1, paramMessage.arg2);
              AppMethodBeat.o(194784);
              return;
              J(paramMessage.what, paramMessage.arg1, paramBoolean);
              AppMethodBeat.o(194784);
              return;
              this.Myx.gbS();
              AppMethodBeat.o(194784);
              return;
              this.Myx.T(paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
              AppMethodBeat.o(194784);
              return;
              this.Myx.bbq((String)paramMessage.obj);
              AppMethodBeat.o(194784);
              return;
              paramMessage = (i.b)paramMessage.obj;
              this.Myx.bm(paramMessage.url, paramMessage.MvV, paramMessage.MvU);
              AppMethodBeat.o(194784);
              return;
              this.Myx.aie(paramMessage.arg1);
              AppMethodBeat.o(194784);
              return;
              paramMessage = (i.d)paramMessage.obj;
              this.Myx.mY(paramMessage.Mwa, paramMessage.Mwb);
              AppMethodBeat.o(194784);
              return;
              this.Myx.cf((Map)paramMessage.obj);
              AppMethodBeat.o(194784);
              return;
              paramMessage = (d.d)paramMessage.obj;
              this.Myu = this.Myx.a(paramMessage.bcd, paramMessage.MyT, paramMessage.MyV);
              zO(paramBoolean);
              AppMethodBeat.o(194784);
              return;
              ((Long)paramMessage.obj).longValue();
              this.Myv = null;
              zO(paramBoolean);
              AppMethodBeat.o(194784);
              return;
              paramMessage = (i.c)paramMessage.obj;
              this.Myx.b((int)paramMessage.MvX, paramMessage.MvY, paramMessage.MvZ, paramMessage.Fdf);
              AppMethodBeat.o(194784);
              return;
              paramMessage = paramMessage.obj;
              this.Myw = null;
              zO(paramBoolean);
              AppMethodBeat.o(194784);
              return;
              this.Myx.gbE();
              AppMethodBeat.o(194784);
              return;
              this.Myx.gbF();
            }
          }
        }
      }
    }
  }
  
  private static String aif(int paramInt)
  {
    AppMethodBeat.i(194781);
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
      AppMethodBeat.o(194781);
      return str;
    case 1: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> set player params";
    case 4: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> set surface";
    case 5: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> set data source";
    case 6: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> set subtitle source";
    case 7: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> add audio source";
    case 8: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> add select track";
    case 36: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> deselect track";
    case 10: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> prepare async";
    case 11: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> start";
    case 12: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> pause";
    case 13: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> stop";
    case 14: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> reset";
    case 15: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> release";
    case 16: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> seek to";
    case 17: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> set output mute";
    case 18: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> set audio gain ratio";
    case 19: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> set speed ratio";
    case 35: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> set loopback";
    case 21: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> get video width";
    case 22: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> get video height";
    case 23: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> get track info";
    case 27: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> get property long";
    case 28: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> get property string";
    case 29: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> set video info";
    case 30: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> capture video";
    case 31: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> switch def";
    case 32: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> select program";
    case 33: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> get program";
    case 20: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> set loopback with param";
    case 73: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> cdn info update";
    case 41: 
      AppMethodBeat.o(194781);
      return "[tpPlayer] -> pauseDownload";
    }
    AppMethodBeat.o(194781);
    return "[tpPlayer] -> resumeDownload";
  }
  
  private boolean gbY()
  {
    AppMethodBeat.i(194775);
    if (Looper.myLooper() == this.mLooper)
    {
      AppMethodBeat.o(194775);
      return true;
    }
    AppMethodBeat.o(194775);
    return false;
  }
  
  private void gbZ()
  {
    AppMethodBeat.i(194776);
    if (!gbY()) {
      this.Myz.readLock().unlock();
    }
    AppMethodBeat.o(194776);
  }
  
  private void gca()
  {
    AppMethodBeat.i(194777);
    if (!gbY()) {
      this.Myz.readLock().lock();
    }
    AppMethodBeat.o(194777);
  }
  
  private void gce()
  {
    AppMethodBeat.i(194783);
    this.Myz.gck();
    AppMethodBeat.o(194783);
  }
  
  private void zO(boolean paramBoolean)
  {
    AppMethodBeat.i(194780);
    if (paramBoolean) {
      this.Myz.writeLock().lock();
    }
    if (paramBoolean) {
      this.Myz.Mzq.signalAll();
    }
    if (paramBoolean) {
      this.Myz.writeLock().unlock();
    }
    AppMethodBeat.o(194780);
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(194774);
    gca();
    if (this.Myy == null)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerInternal.java]", aif(paramInt1) + " , send failed , handler null");
      gbZ();
      AppMethodBeat.o(194774);
      return;
    }
    if ((paramBoolean1) && (paramObject == null))
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerInternal.java]", aif(paramInt1) + ", send failed , params null");
      gbZ();
      AppMethodBeat.o(194774);
      return;
    }
    if (paramBoolean2) {
      this.Myy.removeMessages(paramInt1);
    }
    Message localMessage = this.Myy.obtainMessage();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    if (gbY()) {
      a(localMessage, false);
    }
    for (;;)
    {
      gbZ();
      AppMethodBeat.o(194774);
      return;
      this.Myy.sendMessageDelayed(localMessage, 0L);
    }
  }
  
  final void gcb()
  {
    AppMethodBeat.i(194778);
    if (!gbY()) {
      this.Myz.writeLock().lock();
    }
    AppMethodBeat.o(194778);
  }
  
  final void gcc()
  {
    AppMethodBeat.i(194779);
    if (!gbY()) {
      this.Myz.writeLock().unlock();
    }
    AppMethodBeat.o(194779);
  }
  
  final void gcd()
  {
    AppMethodBeat.i(194782);
    if (gbY())
    {
      AppMethodBeat.o(194782);
      return;
    }
    gce();
    AppMethodBeat.o(194782);
  }
  
  public final long getAdvRemainTime()
  {
    AppMethodBeat.i(194771);
    try
    {
      long l = this.Myx.gbV();
      AppMethodBeat.o(194771);
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(194771);
    }
    return 0L;
  }
  
  public final String getContentType(long paramLong, String paramString)
  {
    return null;
  }
  
  public final int getCurrentPlayClipNo()
  {
    AppMethodBeat.i(194770);
    try
    {
      int i = this.Myx.gbU();
      AppMethodBeat.o(194770);
      return i;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(194770);
    }
    return 0;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(194769);
    long l = getCurrentPositionMs();
    AppMethodBeat.o(194769);
    return l;
  }
  
  final long getCurrentPositionMs()
  {
    AppMethodBeat.i(194758);
    try
    {
      long l = this.Myx.gbN();
      AppMethodBeat.o(194758);
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(194758);
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
    AppMethodBeat.i(194757);
    try
    {
      long l = this.Myx.gbM();
      AppMethodBeat.o(194757);
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(194757);
    }
    return 0L;
  }
  
  public final Object getPlayInfo(long paramLong)
  {
    AppMethodBeat.i(194772);
    gcb();
    a(82, 0, 0, Long.valueOf(paramLong), false, false);
    gcd();
    gcc();
    Object localObject = this.Myv;
    AppMethodBeat.o(194772);
    return localObject;
  }
  
  public final Object getPlayInfo(String paramString)
  {
    AppMethodBeat.i(194773);
    gcb();
    a(84, 0, 0, paramString, false, false);
    gcd();
    gcc();
    paramString = this.Myw;
    AppMethodBeat.o(194773);
    return paramString;
  }
  
  public final long getPlayerBufferLength()
  {
    AppMethodBeat.i(194768);
    try
    {
      long l = this.Myx.gbT();
      AppMethodBeat.o(194768);
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(194768);
    }
    return 0L;
  }
  
  public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    AppMethodBeat.i(194765);
    a(76, 0, 0, paramMap, false, false);
    AppMethodBeat.o(194765);
  }
  
  public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(194764);
    i.b localb = new i.b();
    localb.url = paramString1;
    localb.MvV = paramString2;
    localb.MvU = paramString3;
    localb.MvW = paramString4;
    a(73, 0, 0, localb, false, false);
    AppMethodBeat.o(194764);
  }
  
  public final void onDownloadCdnUrlUpdate(String paramString)
  {
    AppMethodBeat.i(194763);
    a(72, 0, 0, paramString, false, false);
    AppMethodBeat.o(194763);
  }
  
  public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(194761);
    a(71, paramInt1, paramInt2, paramString, false, false);
    AppMethodBeat.o(194761);
  }
  
  public final void onDownloadFinish()
  {
    AppMethodBeat.i(194760);
    a(70, 0, 0, null, false, false);
    AppMethodBeat.o(194760);
  }
  
  public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194759);
    i.c localc = new i.c();
    localc.MvX = paramInt1;
    localc.MvY = paramInt2;
    localc.MvZ = paramLong1;
    localc.Fdf = paramLong2;
    a(83, 0, 0, localc, false, false);
    AppMethodBeat.o(194759);
  }
  
  public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194767);
    i.d locald = new i.d();
    locald.Mwb = paramString2;
    locald.Mwa = paramString1;
    a(75, 0, 0, locald, false, false);
    AppMethodBeat.o(194767);
  }
  
  public final void onDownloadStatusUpdate(int paramInt)
  {
    AppMethodBeat.i(194766);
    a(74, paramInt, 0, null, false, false);
    AppMethodBeat.o(194766);
  }
  
  public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(194762);
    gcb();
    d.d locald = new d.d();
    locald.bcd = paramInt;
    locald.MyT = paramObject1;
    locald.MyU = paramObject2;
    locald.MyV = paramObject3;
    locald.MyW = paramObject4;
    a(77, 0, 0, locald, false, false);
    gcd();
    gcc();
    paramObject1 = this.Myu;
    AppMethodBeat.o(194762);
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
      AppMethodBeat.i(194755);
      b.a(b.this, paramMessage);
      AppMethodBeat.o(194755);
    }
  }
  
  public static abstract interface b
  {
    public abstract void T(int paramInt1, int paramInt2, String paramString);
    
    public abstract Object a(int paramInt, Object paramObject1, Object paramObject2);
    
    public abstract void a(a parama, long paramLong, p paramp, int paramInt);
    
    public abstract void a(d.b paramb);
    
    public abstract void a(String paramString, long paramLong, p paramp, int paramInt);
    
    public abstract void a(String paramString1, String paramString2, com.tencent.thumbplayer.b.b.b paramb);
    
    public abstract void a(String paramString1, String paramString2, String paramString3, com.tencent.thumbplayer.b.b.b paramb);
    
    public abstract void aW(int paramInt, long paramLong);
    
    public abstract void aX(int paramInt, long paramLong);
    
    public abstract void aY(int paramInt, long paramLong);
    
    public abstract long aic(int paramInt);
    
    public abstract String aid(int paramInt);
    
    public abstract void aie(int paramInt);
    
    public abstract void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
    
    public abstract void b(com.tencent.thumbplayer.b.e parame, com.tencent.thumbplayer.b.d paramd);
    
    public abstract void b(p paramp);
    
    public abstract void bbq(String paramString);
    
    public abstract void bm(String paramString1, String paramString2, String paramString3);
    
    public abstract void c(f paramf);
    
    public abstract void cf(Map<String, String> paramMap);
    
    public abstract void ci(float paramFloat);
    
    public abstract void cj(float paramFloat);
    
    public abstract void d(boolean paramBoolean, long paramLong1, long paramLong2);
    
    public abstract void gbE();
    
    public abstract void gbF();
    
    public abstract void gbG();
    
    public abstract void gbH();
    
    public abstract void gbI();
    
    public abstract void gbJ();
    
    public abstract void gbK();
    
    public abstract void gbL();
    
    public abstract long gbM();
    
    public abstract long gbN();
    
    public abstract int gbO();
    
    public abstract int gbP();
    
    public abstract n[] gbQ();
    
    public abstract k[] gbR();
    
    public abstract void gbS();
    
    public abstract long gbT();
    
    public abstract int gbU();
    
    public abstract long gbV();
    
    public abstract void l(Surface paramSurface);
    
    public abstract void lb(int paramInt1, int paramInt2);
    
    public abstract void mY(String paramString1, String paramString2);
    
    public abstract void zM(boolean paramBoolean);
    
    public abstract void zN(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.g.b
 * JD-Core Version:    0.7.0.1
 */