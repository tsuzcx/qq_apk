package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
final class p$b
  extends u
  implements a<Object>
{
  p$b(ah.f<Bitmap> paramf, Bitmap paramBitmap, b<? super Bitmap, ah> paramb)
  {
    super(0);
  }
  
  private static final void a(b paramb, ah.f paramf)
  {
    AppMethodBeat.i(314076);
    s.u(paramb, "$callback");
    s.u(paramf, "$blurBitmap");
    paramb.invoke(paramf.aqH);
    AppMethodBeat.o(314076);
  }
  
  public final Object invoke()
  {
    Integer localInteger = null;
    AppMethodBeat.i(314090);
    try
    {
      long l = System.currentTimeMillis();
      this.PjI.aqH = BitmapUtil.fastBlurBitmap(this.eGL, 0.1F, 10, true, 200L);
      Log.i("MicroMsg.ScanViewUtils", "alvinluo blurBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      Object localObject1 = (Bitmap)this.PjI.aqH;
      if (localObject1 == null)
      {
        localObject1 = null;
        localBitmap = (Bitmap)this.PjI.aqH;
        if (localBitmap != null) {
          break label183;
        }
        Log.d("MicroMsg.ScanViewUtils", "alvinluo blurBitmap width: %s, height: %s", new Object[] { localObject1, localInteger });
        if (!s.p(Thread.currentThread(), Looper.getMainLooper().getThread())) {
          break label196;
        }
        this.$callback.invoke(this.PjI.aqH);
        localObject1 = ah.aiuX;
        AppMethodBeat.o(314090);
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Bitmap localBitmap;
        Log.printErrStackTrace("MicroMsg.ScanViewUtils", (Throwable)localException, "blurBitmap exception", new Object[0]);
        continue;
        localObject2 = Integer.valueOf(localException.getWidth());
        continue;
        label183:
        localInteger = Integer.valueOf(localBitmap.getHeight());
      }
      label196:
      Object localObject2 = h.ahAA.bk(new p.b..ExternalSyntheticLambda0(this.$callback, this.PjI));
      AppMethodBeat.o(314090);
      return localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.p.b
 * JD-Core Version:    0.7.0.1
 */