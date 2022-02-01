package com.tencent.mm.plugin.scanner.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.c.a.a;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.ab;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanAnimationDotsView;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.e;
import d.g.b.p;

final class ScanUIRectView$3
  implements a.a
{
  ScanUIRectView$3(ScanUIRectView paramScanUIRectView) {}
  
  public final void a(final long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(161016);
    ad.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", new Object[] { Long.valueOf(paramLong) });
    if (paramBundle.getBoolean("result_is_best_img", false)) {
      this.ytY.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(161013);
          if ((paramLong == ScanUIRectView.l(ScanUIRectView.3.this.ytY)) && (ScanUIRectView.l(ScanUIRectView.3.this.ytY) != 0L) && (ScanUIRectView.m(ScanUIRectView.3.this.ytY) != null)) {
            ScanUIRectView.m(ScanUIRectView.3.this.ytY).e(ScanUIRectView.l(ScanUIRectView.3.this.ytY), this.val$result);
          }
          AppMethodBeat.o(161013);
        }
      });
    }
    AppMethodBeat.o(161016);
  }
  
  public final void a(final ab paramab)
  {
    AppMethodBeat.i(161018);
    this.ytY.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(161015);
        if ((paramab != null) && ((ScanUIRectView.r(ScanUIRectView.3.this.ytY) instanceof ScanGoodsMaskView)))
        {
          ScanGoodsMaskView localScanGoodsMaskView = (ScanGoodsMaskView)ScanUIRectView.r(ScanUIRectView.3.this.ytY);
          ab localab = paramab;
          p.h(localab, "pointsResult");
          if (localScanGoodsMaskView.yAD)
          {
            ad.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
            AppMethodBeat.o(161015);
            return;
          }
          ScanPoint[] arrayOfScanPoint = localab.points;
          if (arrayOfScanPoint != null)
          {
            ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", new Object[] { Integer.valueOf(localab.pointCount) });
            int j = localab.pointCount;
            int i = 0;
            if (i < j)
            {
              Object localObject2 = (ScanPoint)e.f(arrayOfScanPoint, i);
              label149:
              Float localFloat;
              if (localObject2 != null)
              {
                localObject1 = Integer.valueOf(((ScanPoint)localObject2).getId());
                if (localObject2 == null) {
                  break label216;
                }
                localFloat = Float.valueOf(((ScanPoint)localObject2).getX());
                label164:
                if (localObject2 == null) {
                  break label222;
                }
              }
              label216:
              label222:
              for (localObject2 = Float.valueOf(((ScanPoint)localObject2).getY());; localObject2 = null)
              {
                ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", new Object[] { localObject1, localFloat, localObject2 });
                i += 1;
                break;
                localObject1 = null;
                break label149;
                localFloat = null;
                break label164;
              }
            }
            Object localObject1 = localScanGoodsMaskView.yvW;
            if (localObject1 == null) {
              p.bcb("animationDotsView");
            }
            ((ScanAnimationDotsView)localObject1).b(localab);
          }
        }
        AppMethodBeat.o(161015);
      }
    });
    AppMethodBeat.o(161018);
  }
  
  public final void yW(final long paramLong)
  {
    AppMethodBeat.i(161017);
    ad.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(0L) });
    this.ytY.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(161014);
        if ((ScanUIRectView.l(ScanUIRectView.3.this.ytY) == paramLong) && (ScanUIRectView.l(ScanUIRectView.3.this.ytY) != 0L)) {
          ScanUIRectView.3.this.ytY.zb(this.uIT);
        }
        AppMethodBeat.o(161014);
      }
    });
    AppMethodBeat.o(161017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanUIRectView.3
 * JD-Core Version:    0.7.0.1
 */