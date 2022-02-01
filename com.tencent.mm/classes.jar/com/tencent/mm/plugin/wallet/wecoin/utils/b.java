package com.tencent.mm.plugin.wallet.wecoin.utils;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable;", "T", "Ljava/lang/Runnable;", "liveData", "Landroidx/lifecycle/MutableLiveData;", "data", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "Ljava/lang/Object;", "run", "", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
final class b<T>
  implements Runnable
{
  public static final a Vxh;
  private final x<T> MnI;
  private final T cpt;
  
  static
  {
    AppMethodBeat.i(315716);
    Vxh = new a((byte)0);
    AppMethodBeat.o(315716);
  }
  
  private b(x<T> paramx, T paramT)
  {
    this.MnI = paramx;
    this.cpt = paramT;
  }
  
  public final void run()
  {
    AppMethodBeat.i(315723);
    this.MnI.setValue(this.cpt);
    AppMethodBeat.o(315723);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable;", "T", "liveData", "Landroidx/lifecycle/MutableLiveData;", "data", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable;", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <T> b<T> d(x<T> paramx, T paramT)
    {
      AppMethodBeat.i(315722);
      s.u(paramx, "liveData");
      paramx = new b(paramx, paramT, (byte)0);
      AppMethodBeat.o(315722);
      return paramx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.utils.b
 * JD-Core Version:    0.7.0.1
 */