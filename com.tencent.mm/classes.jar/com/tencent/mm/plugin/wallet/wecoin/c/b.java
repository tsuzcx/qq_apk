package com.tencent.mm.plugin.wallet.wecoin.c;

import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable;", "T", "Ljava/lang/Runnable;", "liveData", "Landroidx/lifecycle/MutableLiveData;", "data", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "Ljava/lang/Object;", "run", "", "Companion", "plugin-wxpay_release"})
final class b<T>
  implements Runnable
{
  public static final a OHx;
  private final r<T> EiN;
  private final T bnW;
  
  static
  {
    AppMethodBeat.i(277474);
    OHx = new a((byte)0);
    AppMethodBeat.o(277474);
  }
  
  private b(r<T> paramr, T paramT)
  {
    this.EiN = paramr;
    this.bnW = paramT;
  }
  
  public final void run()
  {
    AppMethodBeat.i(277471);
    this.EiN.setValue(this.bnW);
    AppMethodBeat.o(277471);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable;", "T", "liveData", "Landroidx/lifecycle/MutableLiveData;", "data", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable;", "plugin-wxpay_release"})
  public static final class a
  {
    public static <T> b<T> c(r<T> paramr, T paramT)
    {
      AppMethodBeat.i(186705);
      p.k(paramr, "liveData");
      paramr = new b(paramr, paramT, (byte)0);
      AppMethodBeat.o(186705);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.c.b
 * JD-Core Version:    0.7.0.1
 */