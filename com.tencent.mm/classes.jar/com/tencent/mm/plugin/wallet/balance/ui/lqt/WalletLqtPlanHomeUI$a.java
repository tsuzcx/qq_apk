package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

final class WalletLqtPlanHomeUI$a
  extends BaseAdapter
{
  private WalletLqtPlanHomeUI$a(WalletLqtPlanHomeUI paramWalletLqtPlanHomeUI) {}
  
  private bmo Ik(int paramInt)
  {
    AppMethodBeat.i(45616);
    bmo localbmo = (bmo)WalletLqtPlanHomeUI.c(this.tQV).get(paramInt);
    AppMethodBeat.o(45616);
    return localbmo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(45615);
    int i = WalletLqtPlanHomeUI.c(this.tQV).size();
    AppMethodBeat.o(45615);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(45617);
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.tQV.getContext()).inflate(2130970007, paramViewGroup, false);
      localView.setTag(new WalletLqtPlanHomeUI.b(this.tQV, localView));
    }
    paramView = Ik(paramInt);
    paramViewGroup = (WalletLqtPlanHomeUI.b)localView.getTag();
    paramViewGroup.tRc.setPrefix(ae.dSz());
    BigDecimal localBigDecimal = e.a(paramView.cNd, "100", 2, RoundingMode.HALF_UP);
    if (localBigDecimal.intValue() == localBigDecimal.doubleValue())
    {
      paramViewGroup.tRc.setText(localBigDecimal.intValue());
      paramViewGroup.tRe.setText(paramViewGroup.tQV.getString(2131305256, new Object[] { paramView.eel, paramView.nLq, paramView.ppo }));
      if ((paramView.xAW == null) || (bo.isNullOrNil(paramView.xAW.xVz))) {
        break label407;
      }
      paramViewGroup.tRf.setText(paramView.xAW.xVz);
      if (bo.isNullOrNil(paramView.xAW.color)) {
        break label384;
      }
      paramViewGroup.tRf.setTextColor(Color.parseColor(paramView.xAW.color));
      label260:
      paramViewGroup.tRf.setVisibility(0);
      label268:
      if (paramView.xAX != null)
      {
        paramViewGroup.tRg.setText(paramView.xAX.title);
        paramViewGroup.tRi.setOnClickListener(new WalletLqtPlanHomeUI.b.1(paramViewGroup, paramView));
      }
      if (paramView.state == 1) {
        break label419;
      }
      paramViewGroup.tRh.setVisibility(0);
      paramViewGroup.tRe.setTextColor(Color.parseColor("#d1d1d1"));
      paramViewGroup.tRc.setTextColor(Color.parseColor("#d1d1d1"));
    }
    for (;;)
    {
      paramViewGroup.tRd.setOnClickListener(new WalletLqtPlanHomeUI.b.2(paramViewGroup, paramView));
      AppMethodBeat.o(45617);
      return localView;
      paramViewGroup.tRc.setText(localBigDecimal.toString());
      break;
      label384:
      paramViewGroup.tRf.setTextColor(paramViewGroup.tQV.getResources().getColor(2131690318));
      break label260;
      label407:
      paramViewGroup.tRf.setVisibility(8);
      break label268;
      label419:
      paramViewGroup.tRh.setVisibility(8);
      paramViewGroup.tRe.setTextColor(paramViewGroup.tQV.getResources().getColor(2131689763));
      paramViewGroup.tRc.setTextColor(paramViewGroup.tQV.getResources().getColor(2131689763));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.a
 * JD-Core Version:    0.7.0.1
 */