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
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public final class WalletOrderInfoOldUI$a
  extends BaseAdapter
{
  public WalletOrderInfoOldUI$a(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  private Orders.Commodity AV(int paramInt)
  {
    return (Orders.Commodity)this.qEN.qDV.get(paramInt);
  }
  
  public final int getCount()
  {
    if (this.qEN.qDV != null) {
      return this.qEN.qDV.size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Orders.Commodity localCommodity;
    label414:
    Object localObject1;
    Object localObject2;
    label452:
    Orders.DiscountInfo localDiscountInfo;
    TextView localTextView;
    if (paramView == null)
    {
      paramView = View.inflate(this.qEN, a.g.wallet_order_info_item, null);
      paramViewGroup = new WalletOrderInfoOldUI.a.a(this);
      paramViewGroup.qEQ = ((TextView)paramView.findViewById(a.f.wallet_order_info_bankcard_title));
      paramViewGroup.eXP = ((TextView)paramView.findViewById(a.f.wallet_order_info_desc));
      paramViewGroup.qET = ((TextView)paramView.findViewById(a.f.wallet_order_info_spid));
      paramViewGroup.qER = ((TextView)paramView.findViewById(a.f.wallet_order_info_total_fee));
      paramViewGroup.qES = ((TextView)paramView.findViewById(a.f.wallet_order_info_org_total_fee));
      paramViewGroup.qES.getPaint().setFlags(16);
      paramViewGroup.qEU = ((TextView)paramView.findViewById(a.f.wallet_order_info_trans_id));
      paramViewGroup.qEV = ((TextView)paramView.findViewById(a.f.wallet_order_info_cre_time));
      paramViewGroup.qEW = ((TextView)paramView.findViewById(a.f.wallet_order_info_bankcard));
      paramViewGroup.qEY = ((MaxListView)paramView.findViewById(a.f.wallet_order_info_promotions));
      paramViewGroup.qEZ = paramView.findViewById(a.f.wallet_order_info_discount_ll);
      paramViewGroup.qEX = paramView.findViewById(a.f.wallet_order_info_septator_3);
      paramViewGroup.qFb = ((TextView)paramView.findViewById(a.f.wallet_order_original_feeinfo_desc));
      paramViewGroup.qFa = ((TextView)paramView.findViewById(a.f.wallet_order_original_feeinfo_title));
      paramViewGroup.qFc = ((TextView)paramView.findViewById(a.f.wallet_order_rate_info_desc));
      paramViewGroup.qFd = ((TextView)paramView.findViewById(a.f.wallet_order_rate_info_title));
      paramViewGroup.qFf = ((ViewGroup)paramView.findViewById(a.f.wallet_order_info_tiny_app_info));
      paramViewGroup.qAV = ((CdnImageView)paramView.findViewById(a.f.tinyapp_logo_iv));
      paramViewGroup.qAW = ((TextView)paramView.findViewById(a.f.tinyapp_desc));
      paramViewGroup.qAX = ((TextView)paramView.findViewById(a.f.tinyapp_name));
      paramViewGroup.qFe = paramView.findViewById(a.f.wallet_order_info_septator_4);
      paramView.setTag(paramViewGroup);
      localCommodity = AV(paramInt);
      if ((localCommodity == null) || (paramViewGroup == null)) {
        break label1214;
      }
      WalletOrderInfoOldUI.a(this.qEN, localCommodity.bMY);
      paramViewGroup.qER.setText(e.d(localCommodity.iHP, localCommodity.mOZ));
      if ((localCommodity.qxe < 0.0D) || (localCommodity.iHP >= localCommodity.qxe)) {
        break label658;
      }
      paramViewGroup.qES.setText(e.d(localCommodity.qxe, localCommodity.mOZ));
      paramViewGroup.qES.setVisibility(0);
      localObject1 = (LinearLayout)paramViewGroup.qEZ;
      localObject2 = localCommodity.qxh;
      ((LinearLayout)localObject1).removeAllViews();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label683;
      }
      paramInt = 0;
      if (paramInt >= ((List)localObject2).size()) {
        break label683;
      }
      localDiscountInfo = (Orders.DiscountInfo)((List)localObject2).get(paramInt);
      localTextView = new TextView(this.qEN.mController.uMN);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = this.qEN.mController.uMN.getResources().getDimensionPixelOffset(a.d.BasicPaddingSize);
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setTextAppearance(this.qEN.mController.uMN, a.j.MMWalletOrdersInfo);
      if (localDiscountInfo.qxz <= 0.0D) {
        break label670;
      }
      localTextView.setText(localDiscountInfo.nxN + e.d(localDiscountInfo.qxz / 100.0D, this.qEN.qmc.mOZ));
    }
    for (;;)
    {
      ((LinearLayout)localObject1).addView(localTextView);
      localTextView.setTextColor(this.qEN.getResources().getColor(a.c.wallet_favor_list_text_color));
      paramInt += 1;
      break label452;
      paramViewGroup = (WalletOrderInfoOldUI.a.a)paramView.getTag();
      break;
      label658:
      paramViewGroup.qES.setVisibility(8);
      break label414;
      label670:
      localTextView.setText(localDiscountInfo.nxN);
    }
    label683:
    if (((LinearLayout)localObject1).getChildCount() > 0)
    {
      ((LinearLayout)localObject1).setVisibility(0);
      localObject2 = paramViewGroup.qEQ;
      localObject1 = this.qEN;
      if (!q.Gw()) {
        break label1226;
      }
      localObject1 = ((Context)localObject1).getString(a.i.wallet_order_info_pay_method_payu);
      label725:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.qET.setText(localCommodity.mOO);
      paramViewGroup.eXP.setText(localCommodity.desc);
      paramViewGroup.eXP.setTag(localCommodity.desc);
      paramViewGroup.eXP.setOnLongClickListener(WalletOrderInfoOldUI.a(this.qEN));
      paramViewGroup.eXP.setBackgroundResource(a.e.wallet_order_info_trans_id_text_bg);
      paramViewGroup.qEU.setText(localCommodity.bMY);
      paramViewGroup.qEU.setTag(localCommodity.bMY);
      paramViewGroup.qEU.setOnLongClickListener(WalletOrderInfoOldUI.a(this.qEN));
      paramViewGroup.qEU.setBackgroundResource(a.e.wallet_order_info_trans_id_text_bg);
      paramViewGroup.qEV.setText(e.hP(localCommodity.mOV));
      paramViewGroup.qEW.setText(localCommodity.mOX);
      localObject1 = localCommodity.qxi;
      if (paramViewGroup.qFc != null)
      {
        if (bk.bl((String)localObject1)) {
          break label1239;
        }
        paramViewGroup.qFc.setText((CharSequence)localObject1);
        paramViewGroup.qFc.setVisibility(0);
        paramViewGroup.qFd.setVisibility(0);
      }
      localObject1 = localCommodity.qxk;
      if (paramViewGroup.qFb != null)
      {
        if (bk.bl((String)localObject1)) {
          break label1260;
        }
        paramViewGroup.qFb.setText((CharSequence)localObject1);
        paramViewGroup.qFb.setVisibility(0);
        paramViewGroup.qFa.setVisibility(0);
      }
      label961:
      if (localCommodity.qxn.size() <= 0) {
        break label1281;
      }
      localObject1 = (Orders.Promotions)localCommodity.qxn.get(0);
      h.nFQ.f(13033, new Object[] { Integer.valueOf(1), ((Orders.Promotions)localObject1).mPa, ((Orders.Promotions)localObject1).url, ((Orders.Promotions)localObject1).name, WalletOrderInfoOldUI.b(this.qEN) });
      this.qEN.qEH = new WalletOrderInfoOldUI.c(this.qEN, localCommodity.qxn);
      paramViewGroup.qEY.setAdapter(this.qEN.qEH);
      paramViewGroup.qEY.setOnItemClickListener(new WalletOrderInfoOldUI.a.1(this));
      this.qEN.qEH.notifyDataSetChanged();
      paramViewGroup.qEY.setVisibility(0);
      paramViewGroup.qEX.setVisibility(0);
    }
    for (;;)
    {
      label914:
      if ((localCommodity.qxl == null) || (bk.bl(localCommodity.qxl.qhq))) {
        break label1311;
      }
      paramViewGroup.qAV.setUrl(localCommodity.qxl.qws);
      paramViewGroup.qAW.setText(localCommodity.qxl.qwt);
      paramViewGroup.qAX.setText(localCommodity.qxl.qwr);
      paramViewGroup.qFf.setOnClickListener(new WalletOrderInfoOldUI.a.2(this, localCommodity));
      paramViewGroup.qFe.setVisibility(0);
      label1214:
      return paramView;
      ((LinearLayout)localObject1).setVisibility(8);
      break;
      label1226:
      localObject1 = ((Context)localObject1).getString(a.i.wallet_order_info_pay_method);
      break label725;
      label1239:
      paramViewGroup.qFd.setVisibility(8);
      paramViewGroup.qFc.setVisibility(8);
      break label914;
      label1260:
      paramViewGroup.qFa.setVisibility(8);
      paramViewGroup.qFb.setVisibility(8);
      break label961;
      label1281:
      paramViewGroup.qEY.setVisibility(8);
      paramViewGroup.qFf.setVisibility(8);
      paramViewGroup.qEX.setVisibility(8);
    }
    label1311:
    paramViewGroup.qFf.setVisibility(8);
    paramViewGroup.qFe.setVisibility(8);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.a
 * JD-Core Version:    0.7.0.1
 */