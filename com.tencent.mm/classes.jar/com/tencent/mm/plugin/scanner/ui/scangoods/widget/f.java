package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;
import kotlin.j.c;
import kotlin.j.c.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/RandomScanDotsAnimationController;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController;", "context", "Landroid/content/Context;", "scanDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "animationCallback", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "animationHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "scanPointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "generateRandomPoints", "startAnimation", "", "stopAnimation", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  public static final f.a PdM;
  private final MTimerHandler.CallBack PdN;
  private final MTimerHandler PdO;
  private aj PdP;
  
  static
  {
    AppMethodBeat.i(52260);
    PdM = new f.a((byte)0);
    AppMethodBeat.o(52260);
  }
  
  public f(Context paramContext, d paramd)
  {
    super(paramContext, paramd);
    AppMethodBeat.i(52259);
    this.PdN = new f..ExternalSyntheticLambda0(this);
    this.PdO = new MTimerHandler(Looper.getMainLooper(), this.PdN, true);
    this.PdP = new aj();
    paramContext = this.PdP;
    int i = 0;
    paramd = new ScanPoint[10];
    while (i < 10)
    {
      paramd[i] = new ScanPoint();
      i += 1;
    }
    paramContext.points = paramd;
    AppMethodBeat.o(52259);
  }
  
  private static final boolean a(f paramf)
  {
    AppMethodBeat.i(314633);
    s.u(paramf, "this$0");
    paramf.PdP.pointCount = c.aixl.qq(3, 7);
    double d1 = paramf.getViewWidth() * 0.1D;
    double d2 = paramf.getViewHeight() * 0.2D;
    double d3 = paramf.getViewWidth();
    double d4 = paramf.getViewHeight() * 0.8D;
    Log.d("MicroMsg.RandomScanDotsAnimationController", "alvinluo randomCenter centerCount: %d, startY: %s, endY: %s", new Object[] { Integer.valueOf(paramf.PdP.pointCount), Double.valueOf(d2), Double.valueOf(d4) });
    ScanPoint[] arrayOfScanPoint = paramf.PdP.points;
    s.checkNotNull(arrayOfScanPoint);
    Object localObject = paramf.PdP.points;
    int k;
    if (localObject == null)
    {
      i = 0;
      k = Math.min(i, paramf.PdP.pointCount);
      if (k <= 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localObject = (ScanPoint)k.m(arrayOfScanPoint, i);
      if (localObject != null)
      {
        ((ScanPoint)localObject).setXFactor((float)(c.aixl.y(0.0D, 1.0D) * (d3 * 0.9D - d1) + d1));
        ((ScanPoint)localObject).setYFactor((float)(c.aixl.y(0.0D, 1.0D) * (d4 - d2) + d2));
        Log.d("MicroMsg.RandomScanDotsAnimationController", "alvinluo randomCenter i: %d, %f, %f", new Object[] { Integer.valueOf(i), Float.valueOf(((ScanPoint)localObject).getX()), Float.valueOf(((ScanPoint)localObject).getY()) });
      }
      if (j >= k)
      {
        paramf.b(paramf.PdP);
        AppMethodBeat.o(314633);
        return true;
        i = localObject.length;
        break;
      }
    }
  }
  
  public final void startAnimation()
  {
    AppMethodBeat.i(52257);
    this.PdO.startTimer(0L, 350L);
    AppMethodBeat.o(52257);
  }
  
  public final void stopAnimation()
  {
    AppMethodBeat.i(52258);
    this.PdO.stopTimer();
    super.stopAnimation();
    AppMethodBeat.o(52258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.f
 * JD-Core Version:    0.7.0.1
 */