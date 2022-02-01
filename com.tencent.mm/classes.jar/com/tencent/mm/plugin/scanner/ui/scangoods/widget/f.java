package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/RandomScanDotsAnimationController;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController;", "context", "Landroid/content/Context;", "scanDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "animationTimer", "Ljava/util/Timer;", "scanPointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "generateRandomPoints", "startAnimation", "", "stopAnimation", "Companion", "plugin-scan_release"})
public final class f
  extends a
{
  public static final f.a CPv;
  private Timer CPt;
  private ae CPu;
  
  static
  {
    AppMethodBeat.i(52260);
    CPv = new f.a((byte)0);
    AppMethodBeat.o(52260);
  }
  
  public f(Context paramContext, d paramd)
  {
    super(paramContext, paramd);
    AppMethodBeat.i(52259);
    this.CPu = new ae();
    paramContext = this.CPu;
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
    this.CPt = new Timer();
    Timer localTimer = this.CPt;
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
    Timer localTimer = this.CPt;
    if (localTimer != null) {
      localTimer.cancel();
    }
    super.stopAnimation();
    AppMethodBeat.o(52258);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/RandomScanDotsAnimationController$startAnimation$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
  public static final class b
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(52256);
      MMHandlerThread.postToMainThread((Runnable)new a(this));
      AppMethodBeat.o(52256);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(52255);
        this.CPx.CPw.b(f.a(this.CPx.CPw));
        AppMethodBeat.o(52255);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.f
 * JD-Core Version:    0.7.0.1
 */