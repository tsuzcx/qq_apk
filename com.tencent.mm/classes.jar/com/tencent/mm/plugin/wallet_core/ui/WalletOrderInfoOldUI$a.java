package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public final class WalletOrderInfoOldUI$a
  extends BaseAdapter
{
  public WalletOrderInfoOldUI$a(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  private Orders.Commodity IG(int paramInt)
  {
    AppMethodBeat.i(47488);
    Orders.Commodity localCommodity = (Orders.Commodity)this.urV.uqQ.get(paramInt);
    AppMethodBeat.o(47488);
    return localCommodity;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(47487);
    if (this.urV.uqQ != null)
    {
      int i = this.urV.uqQ.size();
      AppMethodBeat.o(47487);
      return i;
    }
    AppMethodBeat.o(47487);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(47489);
    Orders.Commodity localCommodity;
    label398:
    Object localObject1;
    Object localObject2;
    label436:
    Orders.DiscountInfo localDiscountInfo;
    TextView localTextView;
    if (paramView == null)
    {
      paramView = View.inflate(this.urV, 2130971220, null);
      paramViewGroup = new WalletOrderInfoOldUI.a.a(this);
      paramViewGroup.urY = ((TextView)paramView.findViewById(2131829272));
      paramViewGroup.gpM = ((TextView)paramView.findViewById(2131829265));
      paramViewGroup.usb = ((TextView)paramView.findViewById(2131829258));
      paramViewGroup.urZ = ((TextView)paramView.findViewById(2131829260));
      paramViewGroup.usa = ((TextView)paramView.findViewById(2131829261));
      paramViewGroup.usa.getPaint().setFlags(16);
      paramViewGroup.usc = ((TextView)paramView.findViewById(2131829275));
      paramViewGroup.usd = ((TextView)paramView.findViewById(2131829271));
      paramViewGroup.use = ((TextView)paramView.findViewById(2131829273));
      paramViewGroup.usg = ((MaxListView)paramView.findViewById(2131829277));
      paramViewGroup.ush = paramView.findViewById(2131829262);
      paramViewGroup.usf = paramView.findViewById(2131829276);
      paramViewGroup.usj = ((TextView)paramView.findViewById(2131829267));
      paramViewGroup.usi = ((TextView)paramView.findViewById(2131829266));
      paramViewGroup.usk = ((TextView)paramView.findViewById(2131829269));
      paramViewGroup.usl = ((TextView)paramView.findViewById(2131829268));
      paramViewGroup.usn = ((ViewGroup)paramView.findViewById(2131829279));
      paramViewGroup.unG = ((CdnImageView)paramView.findViewById(2131827333));
      paramViewGroup.unH = ((TextView)paramView.findViewById(2131829281));
      paramViewGroup.unI = ((TextView)paramView.findViewById(2131829280));
      paramViewGroup.usm = paramView.findViewById(2131829278);
      paramView.setTag(paramViewGroup);
      localCommodity = IG(paramInt);
      if ((localCommodity == null) || (paramViewGroup == null)) {
        break label1187;
      }
      WalletOrderInfoOldUI.a(this.urV, localCommodity.cnJ);
      paramViewGroup.urZ.setText(e.e(localCommodity.kNS, localCommodity.ppp));
      if ((localCommodity.ujM < 0.0D) || (localCommodity.kNS >= localCommodity.ujM)) {
        break label631;
      }
      paramViewGroup.usa.setText(e.e(localCommodity.ujM, localCommodity.ppp));
      paramViewGroup.usa.setVisibility(0);
      localObject1 = (LinearLayout)paramViewGroup.ush;
      localObject2 = localCommodity.ujP;
      ((LinearLayout)localObject1).removeAllViews();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label656;
      }
      paramInt = 0;
      if (paramInt >= ((List)localObject2).size()) {
        break label656;
      }
      localDiscountInfo = (Orders.DiscountInfo)((List)localObject2).get(paramInt);
      localTextView = new TextView(this.urV.getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = this.urV.getContext().getResources().getDimensionPixelOffset(2131427496);
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setTextAppearance(this.urV.getContext(), 2131493474);
      if (localDiscountInfo.ukh <= 0.0D) {
        break label643;
      }
      localTextView.setText(localDiscountInfo.qiO + e.e(localDiscountInfo.ukh / 100.0D, this.urV.tVr.ppp));
    }
    for (;;)
    {
      ((LinearLayout)localObject1).addView(localTextView);
      localTextView.setTextColor(this.urV.getResources().getColor(2131690640));
      paramInt += 1;
      break label436;
      paramViewGroup = (WalletOrderInfoOldUI.a.a)paramView.getTag();
      break;
      label631:
      paramViewGroup.usa.setVisibility(8);
      break label398;
      label643:
      localTextView.setText(localDiscountInfo.qiO);
    }
    label656:
    if (((LinearLayout)localObject1).getChildCount() > 0)
    {
      ((LinearLayout)localObject1).setVisibility(0);
      localObject2 = paramViewGroup.urY;
      localObject1 = this.urV;
      if (!r.ZB()) {
        break label1204;
      }
      localObject1 = ((Context)localObject1).getString(2131305350);
      label698:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.usb.setText(localCommodity.ppe);
      paramViewGroup.gpM.setText(localCommodity.desc);
      paramViewGroup.gpM.setTag(localCommodity.desc);
      paramViewGroup.gpM.setOnLongClickListener(WalletOrderInfoOldUI.a(this.urV));
      paramViewGroup.gpM.setBackgroundResource(2130840867);
      paramViewGroup.usc.setText(localCommodity.cnJ);
      paramViewGroup.usc.setTag(localCommodity.cnJ);
      paramViewGroup.usc.setOnLongClickListener(WalletOrderInfoOldUI.a(this.urV));
      paramViewGroup.usc.setBackgroundResource(2130840867);
      paramViewGroup.usd.setText(e.kB(localCommodity.ppl));
      paramViewGroup.use.setText(localCommodity.ppn);
      localObject1 = localCommodity.ujQ;
      if (paramViewGroup.usk != null)
      {
        if (bo.isNullOrNil((String)localObject1)) {
          break label1217;
        }
        paramViewGroup.usk.setText((CharSequence)localObject1);
        paramViewGroup.usk.setVisibility(0);
        paramViewGroup.usl.setVisibility(0);
      }
      label887:
      localObject1 = localCommodity.ujS;
      if (paramViewGroup.usj != null)
      {
        if (bo.isNullOrNil((String)localObject1)) {
          break label1238;
        }
        paramViewGroup.usj.setText((CharSequence)localObject1);
        paramViewGroup.usj.setVisibility(0);
        paramViewGroup.usi.setVisibility(0);
      }
      label934:
      if (localCommodity.ujV.size() <= 0) {
        break label1259;
      }
      localObject1 = (Orders.Promotions)localCommodity.ujV.get(0);
      h.qsU.e(13033, new Object[] { Integer.valueOf(1), ((Orders.Promotions)localObject1).ppq, ((Orders.Promotions)localObject1).url, ((Orders.Promotions)localObject1).name, WalletOrderInfoOldUI.b(this.urV) });
      this.urV.urP = new WalletOrderInfoOldUI.c(this.urV, localCommodity.ujV);
      paramViewGroup.usg.setAdapter(this.urV.urP);
      paramViewGroup.usg.setOnItemClickListener(new WalletOrderInfoOldUI.a.1(this));
      this.urV.urP.notifyDataSetChanged();
      paramViewGroup.usg.setVisibility(0);
      paramViewGroup.usf.setVisibility(0);
      label1095:
      if ((localCommodity.ujT == null) || (bo.isNullOrNil(localCommodity.ujT.ugl))) {
        break label1289;
      }
      paramViewGroup.unG.setUrl(localCommodity.ujT.uiQ);
      paramViewGroup.unH.setText(localCommodity.ujT.uiR);
      paramViewGroup.unI.setText(localCommodity.ujT.uaK);
      paramViewGroup.usn.setOnClickListener(new WalletOrderInfoOldUI.a.2(this, localCommodity));
      paramViewGroup.usm.setVisibility(0);
    }
    for (;;)
    {
      label1187:
      AppMethodBeat.o(47489);
      return paramView;
      ((LinearLayout)localObject1).setVisibility(8);
      break;
      label1204:
      localObject1 = ((Context)localObject1).getString(2131305349);
      break label698;
      label1217:
      paramViewGroup.usl.setVisibility(8);
      paramViewGroup.usk.setVisibility(8);
      break label887;
      label1238:
      paramViewGroup.usi.setVisibility(8);
      paramViewGroup.usj.setVisibility(8);
      break label934;
      label1259:
      paramViewGroup.usg.setVisibility(8);
      paramViewGroup.usn.setVisibility(8);
      paramViewGroup.usf.setVisibility(8);
      break label1095;
      label1289:
      paramViewGroup.usn.setVisibility(8);
      paramViewGroup.usm.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.a
 * JD-Core Version:    0.7.0.1
 */