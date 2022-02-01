package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/RandomScanDotsAnimationController;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController;", "context", "Landroid/content/Context;", "scanDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "animationCallback", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "animationHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "scanPointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "generateRandomPoints", "startAnimation", "", "stopAnimation", "Companion", "plugin-scan_release"})
public final class f
  extends a
{
  public static final f.a IUY;
  private final MTimerHandler.CallBack IUV;
  private final MTimerHandler IUW;
  private ac IUX;
  
  static
  {
    AppMethodBeat.i(52260);
    IUY = new f.a((byte)0);
    AppMethodBeat.o(52260);
  }
  
  public f(Context paramContext, d paramd)
  {
    super(paramContext, paramd);
    AppMethodBeat.i(52259);
    this.IUV = ((MTimerHandler.CallBack)new b(this));
    this.IUW = new MTimerHandler(Looper.getMainLooper(), this.IUV, true);
    this.IUX = new ac();
    paramContext = this.IUX;
    paramd = new ScanPoint[10];
    int i = 0;
    while (i < 10)
    {
      paramd[i] = new ScanPoint();
      i += 1;
    }
    paramContext.points = paramd;
    AppMethodBeat.o(52259);
  }
  
  public final void startAnimation()
  {
    AppMethodBeat.i(52257);
    this.IUW.startTimer(0L, 350L);
    AppMethodBeat.o(52257);
  }
  
  public final void stopAnimation()
  {
    AppMethodBeat.i(52258);
    this.IUW.stopTimer();
    super.stopAnimation();
    AppMethodBeat.o(52258);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements MTimerHandler.CallBack
  {
    b(f paramf) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(217749);
      this.IUZ.b(f.a(this.IUZ));
      AppMethodBeat.o(217749);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.f
 * JD-Core Version:    0.7.0.1
 */