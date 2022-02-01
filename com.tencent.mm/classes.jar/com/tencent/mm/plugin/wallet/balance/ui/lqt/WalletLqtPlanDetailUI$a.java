package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dbu;
import java.util.List;

final class WalletLqtPlanDetailUI$a
  extends BaseAdapter
{
  private WalletLqtPlanDetailUI$a(WalletLqtPlanDetailUI paramWalletLqtPlanDetailUI) {}
  
  private dbu aeq(int paramInt)
  {
    AppMethodBeat.i(68911);
    dbu localdbu = (dbu)WalletLqtPlanDetailUI.c(this.HzM).get(paramInt);
    AppMethodBeat.o(68911);
    return localdbu;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(68910);
    int i = WalletLqtPlanDetailUI.c(this.HzM).size();
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
      localView = LayoutInflater.from(this.HzM.getContext()).inflate(2131495338, paramViewGroup, false);
      localView.setTag(new WalletLqtPlanDetailUI.b(this.HzM, localView));
    }
    paramView = aeq(paramInt);
    paramViewGroup = (WalletLqtPlanDetailUI.b)localView.getTag();
    paramViewGroup.HzT.setText(paramView.BrH);
    if (paramView.state == 2)
    {
      paramViewGroup.HzU.setText(paramViewGroup.HzM.getString(2131767934, new Object[] { WalletLqtPlanDetailUI.aUO(new StringBuilder().append(paramView.eht).toString()) }));
      paramViewGroup.HzU.setTextColor(paramViewGroup.HzM.getResources().getColor(2131100904));
    }
    for (;;)
    {
      AppMethodBeat.o(68912);
      return localView;
      paramViewGroup.HzU.setText(paramView.dQx);
      paramViewGroup.HzU.setTextColor(paramViewGroup.HzM.getResources().getColor(2131101332));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI.a
 * JD-Core Version:    0.7.0.1
 */