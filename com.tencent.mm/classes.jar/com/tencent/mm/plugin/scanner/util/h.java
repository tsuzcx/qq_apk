package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.view.b;
import com.tencent.mm.plugin.scanner.view.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import d.l;
import java.util.TimerTask;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/util/ScanShowLoadingTimerTask;", "Ljava/util/TimerTask;", "loadingViewModel", "Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel;", "loadingStatusChangedListener", "Lcom/tencent/mm/plugin/scanner/util/ScanShowLoadingTimerTask$LoadingStatusChangedListener;", "onCancelListener", "Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel$OnCancelListener;", "(Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel;Lcom/tencent/mm/plugin/scanner/util/ScanShowLoadingTimerTask$LoadingStatusChangedListener;Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel$OnCancelListener;)V", "cancelListener", "isCancelled", "", "cancel", "run", "", "Companion", "LoadingStatusChangedListener", "plugin-scan_release"})
public final class h
  extends TimerTask
{
  public static final h.a yPU;
  private boolean isCancelled;
  private b yFd;
  private b.a yPS;
  private b yPT;
  
  static
  {
    AppMethodBeat.i(52494);
    yPU = new h.a((byte)0);
    AppMethodBeat.o(52494);
  }
  
  public h(b paramb, b paramb1, b.a parama)
  {
    this.yFd = paramb;
    this.yPT = paramb1;
    this.yPS = parama;
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
    ar.f((Runnable)new c(this));
    AppMethodBeat.o(52493);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/util/ScanShowLoadingTimerTask$LoadingStatusChangedListener;", "", "onDismiss", "", "onShow", "plugin-scan_release"})
  public static abstract interface b
  {
    public abstract void onShow();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(52491);
      ae.v("MicroMsg.ScanShowLoadingTimerTask", "alvinluo initLoadingTimer showLoading isCancelled: %b", new Object[] { Boolean.valueOf(h.a(this.yPV)) });
      if (!h.a(this.yPV))
      {
        Object localObject = h.b(this.yPV);
        if (localObject != null) {
          ((b)localObject).a(true, true, h.c(this.yPV));
        }
        localObject = h.d(this.yPV);
        if (localObject != null)
        {
          ((h.b)localObject).onShow();
          AppMethodBeat.o(52491);
          return;
        }
      }
      AppMethodBeat.o(52491);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.h
 * JD-Core Version:    0.7.0.1
 */