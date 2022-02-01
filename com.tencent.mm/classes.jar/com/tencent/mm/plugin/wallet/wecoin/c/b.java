package com.tencent.mm.plugin.wallet.wecoin.c;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable;", "T", "Ljava/lang/Runnable;", "liveData", "Landroid/arch/lifecycle/MutableLiveData;", "data", "(Landroid/arch/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "Ljava/lang/Object;", "run", "", "Companion", "plugin-wxpay_release"})
final class b<T>
  implements Runnable
{
  public static final a HPp;
  private final MutableLiveData<T> CAn;
  private final T data;
  
  static
  {
    AppMethodBeat.i(212918);
    HPp = new a((byte)0);
    AppMethodBeat.o(212918);
  }
  
  private b(MutableLiveData<T> paramMutableLiveData, T paramT)
  {
    this.CAn = paramMutableLiveData;
    this.data = paramT;
  }
  
  public final void run()
  {
    AppMethodBeat.i(212917);
    this.CAn.setValue(this.data);
    AppMethodBeat.o(212917);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable;", "T", "liveData", "Landroid/arch/lifecycle/MutableLiveData;", "data", "(Landroid/arch/lifecycle/MutableLiveData;Ljava/lang/Object;)Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable;", "plugin-wxpay_release"})
  public static final class a
  {
    public static <T> b<T> c(MutableLiveData<T> paramMutableLiveData, T paramT)
    {
      AppMethodBeat.i(212916);
      p.h(paramMutableLiveData, "liveData");
      paramMutableLiveData = new b(paramMutableLiveData, paramT, (byte)0);
      AppMethodBeat.o(212916);
      return paramMutableLiveData;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.c.b
 * JD-Core Version:    0.7.0.1
 */