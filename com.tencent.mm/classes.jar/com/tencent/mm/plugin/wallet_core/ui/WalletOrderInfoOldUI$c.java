package com.tencent.mm.plugin.wallet_core.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

final class WalletOrderInfoOldUI$c
  extends BaseAdapter
{
  protected List<Orders.Promotions> qxn = null;
  
  public WalletOrderInfoOldUI$c(List<Orders.Promotions> paramList)
  {
    Object localObject;
    int j = localObject.size();
    int i = 0;
    while (i < j)
    {
      paramList = (Orders.Promotions)localObject.get(i);
      if ((paramList != null) && ((!bk.bl(paramList.mPa)) || (paramList.qxB == 2) || (paramList.qxB == 1))) {
        this.qxn.add(localObject.get(i));
      }
      i += 1;
    }
  }
  
  public final Orders.Promotions AW(int paramInt)
  {
    return (Orders.Promotions)this.qxn.get(paramInt);
  }
  
  public final int getCount()
  {
    if (this.qxn != null) {
      return this.qxn.size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Orders.Promotions localPromotions = AW(paramInt);
    Object localObject;
    if ((bk.bl(localPromotions.mPa)) && (localPromotions.qqG > 0L))
    {
      localObject = this.qEN.gL(localPromotions.qqG);
      h localh = h.nFQ;
      String str = WalletOrderInfoOldUI.b(this.qEN);
      paramInt = localPromotions.qxB;
      paramViewGroup = (ViewGroup)localObject;
      if ("-1".equals(localObject)) {
        paramViewGroup = Integer.valueOf(5);
      }
      localh.f(13471, new Object[] { str, Integer.valueOf(1), Integer.valueOf(paramInt), paramViewGroup, Long.valueOf(localPromotions.qqG), Long.valueOf(localPromotions.qwo) });
    }
    if (paramView == null)
    {
      paramViewGroup = new WalletOrderInfoOldUI.c.a(this);
      paramViewGroup.type = localPromotions.type;
      if (localPromotions.type == Orders.qxd) {
        if (localPromotions.qxA == 1)
        {
          paramView = View.inflate(this.qEN, a.g.wallet_order_info_promotions_activity_festival_item, null);
          paramViewGroup.qFg = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
          paramViewGroup.eXr = ((TextView)paramView.findViewById(a.f.wallet_order_info_title));
          paramViewGroup.qFh = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
          paramViewGroup.fdt = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            this.qEN.qEG.put(localPromotions.url, paramViewGroup.qFh);
          }
          paramView.setTag(paramViewGroup);
          paramViewGroup.qxA = localPromotions.qxA;
        }
      }
    }
    label293:
    label457:
    label1613:
    for (;;)
    {
      if (localPromotions != null)
      {
        localObject = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(this.qEN).get(localPromotions.qqG);
        y.i("MicroMsg.WalletOrderInfoOldUI", "try get result " + localObject);
        if (localObject == null) {
          break label1333;
        }
        paramViewGroup.qFg.setUrl(((WalletOrderInfoOldUI.b)localObject).bVO);
        paramViewGroup.fdt.setText(((WalletOrderInfoOldUI.b)localObject).bQZ);
        paramViewGroup.qFh.setText(((WalletOrderInfoOldUI.b)localObject).qEu);
        if (bk.bl(localPromotions.mPa)) {
          break label1383;
        }
        paramViewGroup.qFh.setVisibility(8);
        if (paramViewGroup.qFi != null)
        {
          paramViewGroup.qFi.setVisibility(0);
          if (!this.qEN.qDU.contains(localPromotions.mPa)) {
            break label1372;
          }
          paramViewGroup.qFi.setChecked(true);
        }
        if ((paramViewGroup.eXr == null) || (localObject == null) || (bk.bl(((WalletOrderInfoOldUI.b)localObject).title))) {
          break label1410;
        }
        paramViewGroup.eXr.setText(((WalletOrderInfoOldUI.b)localObject).title);
        label492:
        if ((!bk.bl(this.qEN.qAP)) && (paramViewGroup.qFh != null))
        {
          paramViewGroup.qFh.setClickable(this.qEN.bGL);
          paramViewGroup.qFh.setEnabled(this.qEN.bGL);
          paramViewGroup.qFh.setOnClickListener(null);
          if (this.qEN.bGM) {
            paramViewGroup.qFh.setVisibility(8);
          }
        }
        long l = localPromotions.qqG;
        localObject = this.qEN.gL(l);
        if (!((String)localObject).equals("0")) {
          break label1462;
        }
        paramViewGroup.qFh.setBackgroundColor(this.qEN.getResources().getColor(a.c.transparent));
        paramViewGroup.qFh.setTextColor(this.qEN.getResources().getColor(a.c.wechat_green));
      }
      for (;;)
      {
        if (paramViewGroup.qFh != null)
        {
          paramInt = BackwardSupportUtil.b.b(this.qEN.mController.uMN, 15.0F);
          i = BackwardSupportUtil.b.b(this.qEN.mController.uMN, 5.0F);
          paramViewGroup.qFh.setPadding(paramInt, i, paramInt, i);
        }
        return paramView;
        paramView = View.inflate(this.qEN, a.g.wallet_order_info_promotions_activity_item, null);
        paramViewGroup.qFg = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
        paramViewGroup.qFh = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
        paramViewGroup.fdt = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
        paramViewGroup.eXr = ((TextView)paramView.findViewById(a.f.wallet_order_info_title));
        if (!TextUtils.isEmpty(localPromotions.url)) {
          this.qEN.qEG.put(localPromotions.url, paramViewGroup.qFh);
        }
        paramView.setTag(paramViewGroup);
        break;
        paramView = View.inflate(this.qEN, a.g.wallet_order_info_promotions_item, null);
        paramViewGroup.qFg = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
        paramViewGroup.qFh = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
        paramViewGroup.fdt = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
        paramViewGroup.qFi = ((CheckBox)paramView.findViewById(a.f.agree_wx_cb));
        if (!TextUtils.isEmpty(localPromotions.url)) {
          this.qEN.qEG.put(localPromotions.url, paramViewGroup.qFh);
        }
        paramView.setTag(paramViewGroup);
        break label293;
        paramViewGroup = (WalletOrderInfoOldUI.c.a)paramView.getTag();
        int i = 0;
        paramInt = i;
        if (localPromotions.type == paramViewGroup.type) {
          if (localPromotions.type == Orders.qxd)
          {
            paramInt = i;
            if (localPromotions.qxA != paramViewGroup.qxA) {}
          }
          else
          {
            paramInt = 1;
          }
        }
        if (paramInt != 0) {
          break label1613;
        }
        paramViewGroup = new WalletOrderInfoOldUI.c.a(this);
        paramViewGroup.type = localPromotions.type;
        if (localPromotions.type == Orders.qxd)
        {
          if (localPromotions.qxA == 1)
          {
            paramView = View.inflate(this.qEN, a.g.wallet_order_info_promotions_activity_festival_item, null);
            paramViewGroup.qFg = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
            paramViewGroup.eXr = ((TextView)paramView.findViewById(a.f.wallet_order_info_title));
            paramViewGroup.qFh = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
            paramViewGroup.fdt = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
            if (!TextUtils.isEmpty(localPromotions.url)) {
              this.qEN.qEG.put(localPromotions.url, paramViewGroup.qFh);
            }
            paramView.setTag(paramViewGroup);
          }
          for (;;)
          {
            paramViewGroup.qxA = localPromotions.qxA;
            break;
            paramView = View.inflate(this.qEN, a.g.wallet_order_info_promotions_activity_item, null);
            paramViewGroup.qFg = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
            paramViewGroup.qFh = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
            paramViewGroup.fdt = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
            paramViewGroup.eXr = ((TextView)paramView.findViewById(a.f.wallet_order_info_title));
            if (!TextUtils.isEmpty(localPromotions.url)) {
              this.qEN.qEG.put(localPromotions.url, paramViewGroup.qFh);
            }
            paramView.setTag(paramViewGroup);
          }
        }
        paramView = View.inflate(this.qEN, a.g.wallet_order_info_promotions_item, null);
        paramViewGroup.qFg = ((CdnImageView)paramView.findViewById(a.f.wallet_order_info_logo));
        paramViewGroup.qFh = ((TextView)paramView.findViewById(a.f.wallet_order_info_btn));
        paramViewGroup.fdt = ((TextView)paramView.findViewById(a.f.wallet_order_info_name));
        paramViewGroup.qFi = ((CheckBox)paramView.findViewById(a.f.agree_wx_cb));
        if (!TextUtils.isEmpty(localPromotions.url)) {
          this.qEN.qEG.put(localPromotions.url, paramViewGroup.qFh);
        }
        paramView.setTag(paramViewGroup);
        break label293;
        paramViewGroup.qFg.setUrl(localPromotions.mTc);
        paramViewGroup.fdt.setText(localPromotions.name);
        paramViewGroup.qFh.setText(localPromotions.qwp);
        break label394;
        label1372:
        paramViewGroup.qFi.setChecked(false);
        break label457;
        label1383:
        paramViewGroup.qFh.setVisibility(0);
        if (paramViewGroup.qFi == null) {
          break label457;
        }
        paramViewGroup.qFi.setVisibility(8);
        break label457;
        if ((paramViewGroup.eXr != null) && (!bk.bl(localPromotions.title)))
        {
          paramViewGroup.eXr.setText(localPromotions.title);
          break label492;
        }
        if (paramViewGroup.eXr == null) {
          break label492;
        }
        paramViewGroup.eXr.setVisibility(8);
        break label492;
        if ((((String)localObject).equals("-1")) || (((String)localObject).equals("3")))
        {
          paramViewGroup.qFh.setBackgroundDrawable(this.qEN.getResources().getDrawable(a.e.btn_style_hollow_green));
          paramViewGroup.qFh.setTextColor(this.qEN.getResources().getColor(a.c.wechat_green));
        }
        else if ((((String)localObject).equals("4")) || (((String)localObject).equals("2")) || (((String)localObject).equals("1")))
        {
          paramViewGroup.qFh.setBackgroundColor(this.qEN.getResources().getColor(a.c.transparent));
          paramViewGroup.qFh.setTextColor(this.qEN.getResources().getColor(a.c.hint_text_color));
        }
        else
        {
          y.e("MicroMsg.WalletOrderInfoOldUI", "PromotionsAdapter unknow award state");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.c
 * JD-Core Version:    0.7.0.1
 */