package com.tencent.mm.plugin.scanner.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.d.a.a;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanAnimationDotsView;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.k;
import kotlin.g.b.s;

final class ScanUIRectView$5
  implements a.a
{
  ScanUIRectView$5(ScanUIRectView paramScanUIRectView)
  {
    AppMethodBeat.i(161021);
    AppMethodBeat.o(161021);
  }
  
  public final void a(final long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(314534);
    Log.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", new Object[] { Long.valueOf(paramLong) });
    if (paramBundle.getBoolean("result_is_best_img", false)) {
      this.Pcg.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(314485);
          if ((paramLong == ScanUIRectView.l(ScanUIRectView.5.this.Pcg)) && (ScanUIRectView.l(ScanUIRectView.5.this.Pcg) != 0L) && (ScanUIRectView.m(ScanUIRectView.5.this.Pcg) != null)) {
            ScanUIRectView.m(ScanUIRectView.5.this.Pcg).e(ScanUIRectView.l(ScanUIRectView.5.this.Pcg), this.mIa);
          }
          AppMethodBeat.o(314485);
        }
      });
    }
    AppMethodBeat.o(314534);
  }
  
  public final void a(final aj paramaj)
  {
    AppMethodBeat.i(314543);
    this.Pcg.post(new Runnable()
    {
      public final void run()
      {
        Object localObject3 = null;
        AppMethodBeat.i(314486);
        ScanGoodsMaskView localScanGoodsMaskView;
        aj localaj;
        ScanPoint[] arrayOfScanPoint;
        int k;
        if ((paramaj != null) && ((ScanUIRectView.x(ScanUIRectView.5.this.Pcg) instanceof ScanGoodsMaskView)))
        {
          localScanGoodsMaskView = (ScanGoodsMaskView)ScanUIRectView.x(ScanUIRectView.5.this.Pcg);
          localaj = paramaj;
          s.u(localaj, "pointsResult");
          if (localScanGoodsMaskView.Pkf)
          {
            Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
            AppMethodBeat.o(314486);
            return;
          }
          arrayOfScanPoint = localaj.points;
          if (arrayOfScanPoint != null)
          {
            Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", new Object[] { Integer.valueOf(localaj.pointCount) });
            k = localaj.pointCount;
            if (k <= 0) {}
          }
        }
        int j;
        for (int i = 0;; i = j)
        {
          j = i + 1;
          Object localObject2 = (ScanPoint)k.m(arrayOfScanPoint, i);
          Object localObject1;
          Float localFloat;
          if (localObject2 == null)
          {
            localObject1 = null;
            if (localObject2 != null) {
              break label243;
            }
            localFloat = null;
            label157:
            if (localObject2 != null) {
              break label256;
            }
            localObject2 = null;
            label165:
            Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", new Object[] { localObject1, localFloat, localObject2 });
            if (j < k) {
              continue;
            }
            localObject1 = localScanGoodsMaskView.Pef;
            if (localObject1 != null) {
              break label269;
            }
            s.bIx("animationDotsView");
            localObject1 = localObject3;
          }
          label256:
          label269:
          for (;;)
          {
            ((ScanAnimationDotsView)localObject1).b(localaj);
            AppMethodBeat.o(314486);
            return;
            localObject1 = Integer.valueOf(((ScanPoint)localObject2).getId());
            break;
            label243:
            localFloat = Float.valueOf(((ScanPoint)localObject2).getX());
            break label157;
            localObject2 = Float.valueOf(((ScanPoint)localObject2).getY());
            break label165;
          }
        }
      }
    });
    AppMethodBeat.o(314543);
  }
  
  public final void tS(final long paramLong)
  {
    AppMethodBeat.i(314538);
    Log.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(0L) });
    this.Pcg.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(314482);
        if ((ScanUIRectView.l(ScanUIRectView.5.this.Pcg) == paramLong) && (ScanUIRectView.l(ScanUIRectView.5.this.Pcg) != 0L)) {
          ScanUIRectView.5.this.Pcg.ua(this.JEx);
        }
        AppMethodBeat.o(314482);
      }
    });
    AppMethodBeat.o(314538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanUIRectView.5
 * JD-Core Version:    0.7.0.1
 */