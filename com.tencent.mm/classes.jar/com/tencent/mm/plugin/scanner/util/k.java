package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.view.c;
import com.tencent.mm.plugin.scanner.view.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanShowLoadingTimerTask;", "Ljava/util/TimerTask;", "loadingViewModel", "Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel;", "loadingStatusChangedListener", "Lcom/tencent/mm/plugin/scanner/util/ScanShowLoadingTimerTask$LoadingStatusChangedListener;", "onCancelListener", "Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel$OnCancelListener;", "(Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel;Lcom/tencent/mm/plugin/scanner/util/ScanShowLoadingTimerTask$LoadingStatusChangedListener;Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel$OnCancelListener;)V", "cancelListener", "isCancelled", "", "cancel", "run", "", "Companion", "LoadingStatusChangedListener", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends TimerTask
{
  public static final k.a Pjf;
  private c OVx;
  private c.a Pjg;
  private b Pjh;
  private boolean isCancelled;
  
  static
  {
    AppMethodBeat.i(52494);
    Pjf = new k.a((byte)0);
    AppMethodBeat.o(52494);
  }
  
  public k(c paramc, b paramb, c.a parama)
  {
    this.OVx = paramc;
    this.Pjh = paramb;
    this.Pjg = parama;
  }
  
  private static final void a(k paramk)
  {
    AppMethodBeat.i(314105);
    s.u(paramk, "this$0");
    Log.v("MicroMsg.ScanShowLoadingTimerTask", "alvinluo initLoadingTimer showLoading isCancelled: %b", new Object[] { Boolean.valueOf(paramk.isCancelled) });
    if (!paramk.isCancelled)
    {
      c localc = paramk.OVx;
      if (localc != null) {
        localc.a(true, true, paramk.Pjg);
      }
      paramk = paramk.Pjh;
      if (paramk != null) {
        paramk.onShow();
      }
    }
    AppMethodBeat.o(314105);
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(52492);
    boolean bool = super.cancel();
    this.isCancelled = true;
    AppMethodBeat.o(52492);
    return bool;
  }
  
  public final void run()
  {
    AppMethodBeat.i(52493);
    MMHandlerThread.postToMainThread(new k..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(52493);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanShowLoadingTimerTask$LoadingStatusChangedListener;", "", "onDismiss", "", "onShow", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.k
 * JD-Core Version:    0.7.0.1
 */