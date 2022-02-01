package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.view.c;
import com.tencent.mm.plugin.scanner.view.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.TimerTask;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/util/ScanShowLoadingTimerTask;", "Ljava/util/TimerTask;", "loadingViewModel", "Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel;", "loadingStatusChangedListener", "Lcom/tencent/mm/plugin/scanner/util/ScanShowLoadingTimerTask$LoadingStatusChangedListener;", "onCancelListener", "Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel$OnCancelListener;", "(Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel;Lcom/tencent/mm/plugin/scanner/util/ScanShowLoadingTimerTask$LoadingStatusChangedListener;Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel$OnCancelListener;)V", "cancelListener", "isCancelled", "", "cancel", "run", "", "Companion", "LoadingStatusChangedListener", "plugin-scan_release"})
public final class i
  extends TimerTask
{
  public static final i.a CTV;
  private c CIV;
  private c.a CTT;
  private b CTU;
  private boolean isCancelled;
  
  static
  {
    AppMethodBeat.i(52494);
    CTV = new i.a((byte)0);
    AppMethodBeat.o(52494);
  }
  
  public i(c paramc, b paramb, c.a parama)
  {
    this.CIV = paramc;
    this.CTU = paramb;
    this.CTT = parama;
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
    MMHandlerThread.postToMainThread((Runnable)new c(this));
    AppMethodBeat.o(52493);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/util/ScanShowLoadingTimerTask$LoadingStatusChangedListener;", "", "onDismiss", "", "onShow", "plugin-scan_release"})
  public static abstract interface b
  {
    public abstract void onShow();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(52491);
      Log.v("MicroMsg.ScanShowLoadingTimerTask", "alvinluo initLoadingTimer showLoading isCancelled: %b", new Object[] { Boolean.valueOf(i.a(this.CTW)) });
      if (!i.a(this.CTW))
      {
        Object localObject = i.b(this.CTW);
        if (localObject != null) {
          ((c)localObject).a(true, true, i.c(this.CTW));
        }
        localObject = i.d(this.CTW);
        if (localObject != null)
        {
          ((i.b)localObject).onShow();
          AppMethodBeat.o(52491);
          return;
        }
      }
      AppMethodBeat.o(52491);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.i
 * JD-Core Version:    0.7.0.1
 */