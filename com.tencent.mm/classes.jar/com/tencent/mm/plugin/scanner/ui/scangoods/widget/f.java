package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.sdk.platformtools.ar;
import d.l;
import java.util.Timer;
import java.util.TimerTask;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/RandomScanDotsAnimationController;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController;", "context", "Landroid/content/Context;", "scanDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "animationTimer", "Ljava/util/Timer;", "scanPointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "generateRandomPoints", "startAnimation", "", "stopAnimation", "Companion", "plugin-scan_release"})
public final class f
  extends a
{
  public static final f.a yLC;
  private Timer yLA;
  private ac yLB;
  
  static
  {
    AppMethodBeat.i(52260);
    yLC = new f.a((byte)0);
    AppMethodBeat.o(52260);
  }
  
  public f(Context paramContext, d paramd)
  {
    super(paramContext, paramd);
    AppMethodBeat.i(52259);
    this.yLB = new ac();
    paramContext = this.yLB;
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
    this.yLA = new Timer();
    Timer localTimer = this.yLA;
    if (localTimer != null)
    {
      localTimer.scheduleAtFixedRate((TimerTask)new b(this), 0L, 350L);
      AppMethodBeat.o(52257);
      return;
    }
    AppMethodBeat.o(52257);
  }
  
  public final void stopAnimation()
  {
    AppMethodBeat.i(52258);
    Timer localTimer = this.yLA;
    if (localTimer != null) {
      localTimer.cancel();
    }
    super.stopAnimation();
    AppMethodBeat.o(52258);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/RandomScanDotsAnimationController$startAnimation$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
  public static final class b
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(52256);
      ar.f((Runnable)new a(this));
      AppMethodBeat.o(52256);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(52255);
        this.yLE.yLD.b(f.a(this.yLE.yLD));
        AppMethodBeat.o(52255);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.f
 * JD-Core Version:    0.7.0.1
 */