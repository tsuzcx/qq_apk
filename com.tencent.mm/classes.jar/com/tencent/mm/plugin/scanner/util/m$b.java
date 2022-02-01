package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
final class m$b
  extends q
  implements a<Object>
{
  m$b(z.f paramf, Bitmap paramBitmap, b paramb)
  {
    super(0);
  }
  
  public final Object invoke()
  {
    Object localObject2 = null;
    AppMethodBeat.i(194798);
    try
    {
      long l = System.currentTimeMillis();
      this.hLk.SYG = BitmapUtil.fastBlurBitmap(this.cKG, 0.1F, 10, true, 200L);
      Log.i("MicroMsg.ScanViewUtils", "alvinluo blurBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      Object localObject1 = (Bitmap)this.hLk.SYG;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((Bitmap)localObject1).getWidth());
        Bitmap localBitmap = (Bitmap)this.hLk.SYG;
        if (localBitmap != null) {
          localObject2 = Integer.valueOf(localBitmap.getHeight());
        }
        Log.d("MicroMsg.ScanViewUtils", "alvinluo blurBitmap width: %s, height: %s", new Object[] { localObject1, localObject2 });
        localObject1 = Thread.currentThread();
        localObject2 = Looper.getMainLooper();
        p.g(localObject2, "Looper.getMainLooper()");
        if (!p.j(localObject1, ((Looper)localObject2).getThread())) {
          break label205;
        }
        localObject1 = this.gWe.invoke((Bitmap)this.hLk.SYG);
        AppMethodBeat.o(194798);
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ScanViewUtils", (Throwable)localException, "blurBitmap exception", new Object[0]);
        continue;
        locald = null;
      }
      label205:
      d locald = h.RTc.aV((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194797);
          this.CUw.gWe.invoke((Bitmap)this.CUw.hLk.SYG);
          AppMethodBeat.o(194797);
        }
      });
      AppMethodBeat.o(194798);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.m.b
 * JD-Core Version:    0.7.0.1
 */