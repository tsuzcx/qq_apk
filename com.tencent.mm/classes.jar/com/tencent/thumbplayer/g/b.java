package com.tencent.thumbplayer.g;

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
  private Object MbA;
  private Object MbB;
  private b MbC;
  private b.a MbD;
  private com.tencent.thumbplayer.utils.e MbE;
  d.k Mbu;
  private d.i Mbv;
  private d.e Mbw;
  long Mbx;
  private String Mby;
  private Object Mbz;
  private Looper mLooper;
  
  b(Looper paramLooper, b paramb)
  {
    AppMethodBeat.i(192078);
    this.mLooper = paramLooper;
    this.MbD = new b.a(this, paramLooper);
    this.MbC = paramb;
    this.MbE = new com.tencent.thumbplayer.utils.e();
    this.Mbu = new d.k();
    this.Mbv = new d.i();
    this.Mbw = new d.e();
    AppMethodBeat.o(192078);
  }
  
  private void J(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(192107);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      zA(paramBoolean);
      AppMethodBeat.o(192107);
      return;
      this.Mbu.width = this.MbC.fXp();
      continue;
      this.Mbu.height = this.MbC.fXq();
      continue;
      this.Mbv.Mci = this.MbC.fXr();
      continue;
      this.Mbx = this.MbC.aht(paramInt2);
      continue;
      this.Mby = this.MbC.ahu(paramInt2);
      continue;
      this.Mbw.Mcc = this.MbC.fXs();
    }
  }
  
  private void a(Message paramMessage, boolean paramBoolean)
  {
    AppMethodBeat.i(192106);
    if ((paramMessage.what != 83) && (paramMessage.what != 73) && (paramMessage.what != 74)) {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerInternal.java]", "internalMessage " + ahw(paramMessage.what));
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(192106);
      return;
      this.MbC.c((f)paramMessage.obj);
      AppMethodBeat.o(192106);
      return;
      this.MbC.l((Surface)paramMessage.obj);
      AppMethodBeat.o(192106);
      return;
      this.MbC.a((d.b)paramMessage.obj);
      AppMethodBeat.o(192106);
      return;
      this.MbC.b((p)paramMessage.obj);
      AppMethodBeat.o(192106);
      return;
      this.MbC.b(((d.j)paramMessage.obj).Mcj, ((d.j)paramMessage.obj).Mck);
      AppMethodBeat.o(192106);
      return;
      paramMessage = (d.f)paramMessage.obj;
      if (paramMessage != null)
      {
        this.MbC.a(paramMessage.url, paramMessage.mimeType, paramMessage.name, paramMessage.Mcd);
        AppMethodBeat.o(192106);
        return;
        paramMessage = (d.a)paramMessage.obj;
        if (paramMessage != null)
        {
          this.MbC.a(paramMessage.url, paramMessage.name, paramMessage.MbS);
          AppMethodBeat.o(192106);
          return;
          this.MbC.aV(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(192106);
          return;
          this.MbC.aW(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(192106);
          return;
          this.MbC.fXh();
          AppMethodBeat.o(192106);
          return;
          this.MbC.fXi();
          AppMethodBeat.o(192106);
          return;
          this.MbC.fXj();
          AppMethodBeat.o(192106);
          return;
          this.MbC.fXk();
          zA(paramBoolean);
          AppMethodBeat.o(192106);
          return;
          this.MbC.fXl();
          zA(paramBoolean);
          AppMethodBeat.o(192106);
          return;
          this.MbC.fXm();
          zA(paramBoolean);
          this.MbD.removeCallbacksAndMessages(null);
          AppMethodBeat.o(192106);
          return;
          this.MbC.kU(paramMessage.arg1, paramMessage.arg2);
          AppMethodBeat.o(192106);
          return;
          this.MbC.zy(((Boolean)paramMessage.obj).booleanValue());
          AppMethodBeat.o(192106);
          return;
          this.MbC.ck(((Float)paramMessage.obj).floatValue());
          AppMethodBeat.o(192106);
          return;
          this.MbC.cl(((Float)paramMessage.obj).floatValue());
          AppMethodBeat.o(192106);
          return;
          paramMessage = (d.c)paramMessage.obj;
          if (paramMessage != null)
          {
            this.MbC.d(paramMessage.LWu, paramMessage.MbW, paramMessage.MbX);
            AppMethodBeat.o(192106);
            return;
            this.MbC.zz(((Boolean)paramMessage.obj).booleanValue());
            AppMethodBeat.o(192106);
            return;
            paramMessage = (d.h)paramMessage.obj;
            if (paramMessage != null)
            {
              if (!TextUtils.isEmpty(paramMessage.url))
              {
                this.MbC.a(paramMessage.url, paramMessage.Mcg, paramMessage.Mch, paramMessage.mode);
                AppMethodBeat.o(192106);
                return;
              }
              this.MbC.a(paramMessage.MbV, paramMessage.Mcg, paramMessage.Mch, paramMessage.mode);
              AppMethodBeat.o(192106);
              return;
              this.MbC.aX(paramMessage.arg1, paramMessage.arg2);
              AppMethodBeat.o(192106);
              return;
              J(paramMessage.what, paramMessage.arg1, paramBoolean);
              AppMethodBeat.o(192106);
              return;
              this.MbC.fXt();
              AppMethodBeat.o(192106);
              return;
              this.MbC.T(paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
              AppMethodBeat.o(192106);
              return;
              this.MbC.aZN((String)paramMessage.obj);
              AppMethodBeat.o(192106);
              return;
              paramMessage = (i.b)paramMessage.obj;
              this.MbC.bl(paramMessage.url, paramMessage.LZa, paramMessage.LYZ);
              AppMethodBeat.o(192106);
              return;
              this.MbC.ahv(paramMessage.arg1);
              AppMethodBeat.o(192106);
              return;
              paramMessage = (i.d)paramMessage.obj;
              this.MbC.mS(paramMessage.LZf, paramMessage.LZg);
              AppMethodBeat.o(192106);
              return;
              this.MbC.ca((Map)paramMessage.obj);
              AppMethodBeat.o(192106);
              return;
              paramMessage = (d.d)paramMessage.obj;
              this.Mbz = this.MbC.a(paramMessage.bcd, paramMessage.MbY, paramMessage.Mca);
              zA(paramBoolean);
              AppMethodBeat.o(192106);
              return;
              ((Long)paramMessage.obj).longValue();
              this.MbA = null;
              zA(paramBoolean);
              AppMethodBeat.o(192106);
              return;
              paramMessage = (i.c)paramMessage.obj;
              this.MbC.b((int)paramMessage.LZc, paramMessage.LZd, paramMessage.LZe, paramMessage.EKH);
              AppMethodBeat.o(192106);
              return;
              paramMessage = paramMessage.obj;
              this.MbB = null;
              zA(paramBoolean);
              AppMethodBeat.o(192106);
              return;
              this.MbC.fXf();
              AppMethodBeat.o(192106);
              return;
              this.MbC.fXg();
            }
          }
        }
      }
    }
  }
  
  private static String ahw(int paramInt)
  {
    AppMethodBeat.i(192103);
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
      AppMethodBeat.o(192103);
      return str;
    case 1: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> set player params";
    case 4: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> set surface";
    case 5: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> set data source";
    case 6: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> set subtitle source";
    case 7: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> add audio source";
    case 8: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> add select track";
    case 36: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> deselect track";
    case 10: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> prepare async";
    case 11: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> start";
    case 12: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> pause";
    case 13: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> stop";
    case 14: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> reset";
    case 15: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> release";
    case 16: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> seek to";
    case 17: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> set output mute";
    case 18: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> set audio gain ratio";
    case 19: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> set speed ratio";
    case 35: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> set loopback";
    case 21: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> get video width";
    case 22: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> get video height";
    case 23: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> get track info";
    case 27: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> get property long";
    case 28: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> get property string";
    case 29: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> set video info";
    case 30: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> capture video";
    case 31: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> switch def";
    case 32: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> select program";
    case 33: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> get program";
    case 20: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> set loopback with param";
    case 73: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> cdn info update";
    case 41: 
      AppMethodBeat.o(192103);
      return "[tpPlayer] -> pauseDownload";
    }
    AppMethodBeat.o(192103);
    return "[tpPlayer] -> resumeDownload";
  }
  
  private void fXA()
  {
    AppMethodBeat.i(192098);
    if (!fXz()) {
      this.MbE.readLock().unlock();
    }
    AppMethodBeat.o(192098);
  }
  
  private void fXB()
  {
    AppMethodBeat.i(192099);
    if (!fXz()) {
      this.MbE.readLock().lock();
    }
    AppMethodBeat.o(192099);
  }
  
  private void fXF()
  {
    AppMethodBeat.i(192105);
    this.MbE.fXL();
    AppMethodBeat.o(192105);
  }
  
  private boolean fXz()
  {
    AppMethodBeat.i(192097);
    if (Looper.myLooper() == this.mLooper)
    {
      AppMethodBeat.o(192097);
      return true;
    }
    AppMethodBeat.o(192097);
    return false;
  }
  
  private void zA(boolean paramBoolean)
  {
    AppMethodBeat.i(192102);
    if (paramBoolean) {
      this.MbE.writeLock().lock();
    }
    if (paramBoolean) {
      this.MbE.Mcv.signalAll();
    }
    if (paramBoolean) {
      this.MbE.writeLock().unlock();
    }
    AppMethodBeat.o(192102);
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192096);
    fXB();
    if (this.MbD == null)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerInternal.java]", ahw(paramInt1) + " , send failed , handler null");
      fXA();
      AppMethodBeat.o(192096);
      return;
    }
    if ((paramBoolean1) && (paramObject == null))
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerInternal.java]", ahw(paramInt1) + ", send failed , params null");
      fXA();
      AppMethodBeat.o(192096);
      return;
    }
    if (paramBoolean2) {
      this.MbD.removeMessages(paramInt1);
    }
    Message localMessage = this.MbD.obtainMessage();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    if (fXz()) {
      a(localMessage, false);
    }
    for (;;)
    {
      fXA();
      AppMethodBeat.o(192096);
      return;
      this.MbD.sendMessageDelayed(localMessage, 0L);
    }
  }
  
  final void fXC()
  {
    AppMethodBeat.i(192100);
    if (!fXz()) {
      this.MbE.writeLock().lock();
    }
    AppMethodBeat.o(192100);
  }
  
  final void fXD()
  {
    AppMethodBeat.i(192101);
    if (!fXz()) {
      this.MbE.writeLock().unlock();
    }
    AppMethodBeat.o(192101);
  }
  
  final void fXE()
  {
    AppMethodBeat.i(192104);
    if (fXz())
    {
      AppMethodBeat.o(192104);
      return;
    }
    fXF();
    AppMethodBeat.o(192104);
  }
  
  public final long getAdvRemainTime()
  {
    AppMethodBeat.i(192093);
    try
    {
      long l = this.MbC.fXw();
      AppMethodBeat.o(192093);
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(192093);
    }
    return 0L;
  }
  
  public final String getContentType(long paramLong, String paramString)
  {
    return null;
  }
  
  public final int getCurrentPlayClipNo()
  {
    AppMethodBeat.i(192092);
    try
    {
      int i = this.MbC.fXv();
      AppMethodBeat.o(192092);
      return i;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(192092);
    }
    return 0;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(192091);
    long l = getCurrentPositionMs();
    AppMethodBeat.o(192091);
    return l;
  }
  
  final long getCurrentPositionMs()
  {
    AppMethodBeat.i(192080);
    try
    {
      long l = this.MbC.fXo();
      AppMethodBeat.o(192080);
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(192080);
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
    AppMethodBeat.i(192079);
    try
    {
      long l = this.MbC.fXn();
      AppMethodBeat.o(192079);
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(192079);
    }
    return 0L;
  }
  
  public final Object getPlayInfo(long paramLong)
  {
    AppMethodBeat.i(192094);
    fXC();
    a(82, 0, 0, Long.valueOf(paramLong), false, false);
    fXE();
    fXD();
    Object localObject = this.MbA;
    AppMethodBeat.o(192094);
    return localObject;
  }
  
  public final Object getPlayInfo(String paramString)
  {
    AppMethodBeat.i(192095);
    fXC();
    a(84, 0, 0, paramString, false, false);
    fXE();
    fXD();
    paramString = this.MbB;
    AppMethodBeat.o(192095);
    return paramString;
  }
  
  public final long getPlayerBufferLength()
  {
    AppMethodBeat.i(192090);
    try
    {
      long l = this.MbC.fXu();
      AppMethodBeat.o(192090);
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
      AppMethodBeat.o(192090);
    }
    return 0L;
  }
  
  public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    AppMethodBeat.i(192087);
    a(76, 0, 0, paramMap, false, false);
    AppMethodBeat.o(192087);
  }
  
  public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(192086);
    i.b localb = new i.b();
    localb.url = paramString1;
    localb.LZa = paramString2;
    localb.LYZ = paramString3;
    localb.LZb = paramString4;
    a(73, 0, 0, localb, false, false);
    AppMethodBeat.o(192086);
  }
  
  public final void onDownloadCdnUrlUpdate(String paramString)
  {
    AppMethodBeat.i(192085);
    a(72, 0, 0, paramString, false, false);
    AppMethodBeat.o(192085);
  }
  
  public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(192083);
    a(71, paramInt1, paramInt2, paramString, false, false);
    AppMethodBeat.o(192083);
  }
  
  public final void onDownloadFinish()
  {
    AppMethodBeat.i(192082);
    a(70, 0, 0, null, false, false);
    AppMethodBeat.o(192082);
  }
  
  public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(192081);
    i.c localc = new i.c();
    localc.LZc = paramInt1;
    localc.LZd = paramInt2;
    localc.LZe = paramLong1;
    localc.EKH = paramLong2;
    a(83, 0, 0, localc, false, false);
    AppMethodBeat.o(192081);
  }
  
  public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192089);
    i.d locald = new i.d();
    locald.LZg = paramString2;
    locald.LZf = paramString1;
    a(75, 0, 0, locald, false, false);
    AppMethodBeat.o(192089);
  }
  
  public final void onDownloadStatusUpdate(int paramInt)
  {
    AppMethodBeat.i(192088);
    a(74, paramInt, 0, null, false, false);
    AppMethodBeat.o(192088);
  }
  
  public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(192084);
    fXC();
    d.d locald = new d.d();
    locald.bcd = paramInt;
    locald.MbY = paramObject1;
    locald.MbZ = paramObject2;
    locald.Mca = paramObject3;
    locald.Mcb = paramObject4;
    a(77, 0, 0, locald, false, false);
    fXE();
    fXD();
    paramObject1 = this.Mbz;
    AppMethodBeat.o(192084);
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
  
  public static abstract interface b
  {
    public abstract void T(int paramInt1, int paramInt2, String paramString);
    
    public abstract Object a(int paramInt, Object paramObject1, Object paramObject2);
    
    public abstract void a(a parama, long paramLong, p paramp, int paramInt);
    
    public abstract void a(d.b paramb);
    
    public abstract void a(String paramString, long paramLong, p paramp, int paramInt);
    
    public abstract void a(String paramString1, String paramString2, com.tencent.thumbplayer.b.b.b paramb);
    
    public abstract void a(String paramString1, String paramString2, String paramString3, com.tencent.thumbplayer.b.b.b paramb);
    
    public abstract void aV(int paramInt, long paramLong);
    
    public abstract void aW(int paramInt, long paramLong);
    
    public abstract void aX(int paramInt, long paramLong);
    
    public abstract void aZN(String paramString);
    
    public abstract long aht(int paramInt);
    
    public abstract String ahu(int paramInt);
    
    public abstract void ahv(int paramInt);
    
    public abstract void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
    
    public abstract void b(com.tencent.thumbplayer.b.e parame, com.tencent.thumbplayer.b.d paramd);
    
    public abstract void b(p paramp);
    
    public abstract void bl(String paramString1, String paramString2, String paramString3);
    
    public abstract void c(f paramf);
    
    public abstract void ca(Map<String, String> paramMap);
    
    public abstract void ck(float paramFloat);
    
    public abstract void cl(float paramFloat);
    
    public abstract void d(boolean paramBoolean, long paramLong1, long paramLong2);
    
    public abstract void fXf();
    
    public abstract void fXg();
    
    public abstract void fXh();
    
    public abstract void fXi();
    
    public abstract void fXj();
    
    public abstract void fXk();
    
    public abstract void fXl();
    
    public abstract void fXm();
    
    public abstract long fXn();
    
    public abstract long fXo();
    
    public abstract int fXp();
    
    public abstract int fXq();
    
    public abstract n[] fXr();
    
    public abstract k[] fXs();
    
    public abstract void fXt();
    
    public abstract long fXu();
    
    public abstract int fXv();
    
    public abstract long fXw();
    
    public abstract void kU(int paramInt1, int paramInt2);
    
    public abstract void l(Surface paramSurface);
    
    public abstract void mS(String paramString1, String paramString2);
    
    public abstract void zy(boolean paramBoolean);
    
    public abstract void zz(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.g.b
 * JD-Core Version:    0.7.0.1
 */