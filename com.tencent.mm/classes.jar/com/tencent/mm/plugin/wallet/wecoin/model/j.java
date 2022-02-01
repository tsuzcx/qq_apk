package com.tencent.mm.plugin.wallet.wecoin.model;

import androidx.lifecycle.af;
import androidx.lifecycle.ah.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinIncomeDetailViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "businessID", "", "(I)V", "getBusinessID", "()I", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements ah.b
{
  private final int VtP;
  
  public j(int paramInt)
  {
    this.VtP = paramInt;
  }
  
  public final <T extends af> T create(Class<T> paramClass)
  {
    AppMethodBeat.i(315785);
    s.u(paramClass, "modelClass");
    paramClass = (af)new i(this.VtP);
    AppMethodBeat.o(315785);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.j
 * JD-Core Version:    0.7.0.1
 */