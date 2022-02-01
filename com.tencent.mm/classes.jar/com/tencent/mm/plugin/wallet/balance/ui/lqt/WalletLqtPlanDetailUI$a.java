package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cas;
import java.util.List;

final class WalletLqtPlanDetailUI$a
  extends BaseAdapter
{
  private WalletLqtPlanDetailUI$a(WalletLqtPlanDetailUI paramWalletLqtPlanDetailUI) {}
  
  private cas Rh(int paramInt)
  {
    AppMethodBeat.i(68911);
    cas localcas = (cas)WalletLqtPlanDetailUI.c(this.zKw).get(paramInt);
    AppMethodBeat.o(68911);
    return localcas;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(68910);
    int i = WalletLqtPlanDetailUI.c(this.zKw).size();
    AppMethodBeat.o(68910);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(68912);
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.zKw.getContext()).inflate(2131494617, paramViewGroup, false);
      localView.setTag(new WalletLqtPlanDetailUI.b(this.zKw, localView));
    }
    paramView = Rh(paramInt);
    paramViewGroup = (WalletLqtPlanDetailUI.b)localView.getTag();
    paramViewGroup.zKD.setText(paramView.wdN);
    if (paramView.state == 2)
    {
      paramViewGroup.zKE.setText(paramViewGroup.zKw.getString(2131765485, new Object[] { WalletLqtPlanDetailUI.atx(new StringBuilder().append(paramView.dEb).toString()) }));
      paramViewGroup.zKE.setTextColor(paramViewGroup.zKw.getResources().getColor(2131100711));
    }
    for (;;)
    {
      AppMethodBeat.o(68912);
      return localView;
      paramViewGroup.zKE.setText(paramView.doh);
      paramViewGroup.zKE.setTextColor(paramViewGroup.zKw.getResources().getColor(2131101089));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI.a
 * JD-Core Version:    0.7.0.1
 */