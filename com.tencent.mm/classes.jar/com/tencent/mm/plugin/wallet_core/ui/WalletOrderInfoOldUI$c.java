package com.tencent.mm.plugin.wallet_core.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

final class WalletOrderInfoOldUI$c
  extends BaseAdapter
{
  protected List<Orders.Promotions> ujV;
  
  public WalletOrderInfoOldUI$c(List<Orders.Promotions> paramList)
  {
    AppMethodBeat.i(47493);
    this.ujV = null;
    this.ujV = new ArrayList();
    Object localObject;
    int j = localObject.size();
    int i = 0;
    while (i < j)
    {
      paramList = (Orders.Promotions)localObject.get(i);
      if ((paramList != null) && ((!bo.isNullOrNil(paramList.ppq)) || (paramList.ukk == 2) || (paramList.ukk == 1))) {
        this.ujV.add(localObject.get(i));
      }
      i += 1;
    }
    AppMethodBeat.o(47493);
  }
  
  public final Orders.Promotions IH(int paramInt)
  {
    AppMethodBeat.i(47495);
    Orders.Promotions localPromotions = (Orders.Promotions)this.ujV.get(paramInt);
    AppMethodBeat.o(47495);
    return localPromotions;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(47494);
    if (this.ujV != null)
    {
      int i = this.ujV.size();
      AppMethodBeat.o(47494);
      return i;
    }
    AppMethodBeat.o(47494);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(47496);
    Orders.Promotions localPromotions = IH(paramInt);
    Object localObject;
    if ((bo.isNullOrNil(localPromotions.ppq)) && (localPromotions.ubC > 0L))
    {
      localObject = this.urV.nh(localPromotions.ubC);
      h localh = h.qsU;
      String str = WalletOrderInfoOldUI.b(this.urV);
      paramInt = localPromotions.ukk;
      paramViewGroup = (ViewGroup)localObject;
      if ("-1".equals(localObject)) {
        paramViewGroup = Integer.valueOf(5);
      }
      localh.e(13471, new Object[] { str, Integer.valueOf(1), Integer.valueOf(paramInt), paramViewGroup, Long.valueOf(localPromotions.ubC), Long.valueOf(localPromotions.uiN) });
    }
    if (paramView == null)
    {
      paramViewGroup = new WalletOrderInfoOldUI.c.a(this);
      paramViewGroup.type = localPromotions.type;
      if (localPromotions.type == Orders.ujL) {
        if (localPromotions.uki == 1)
        {
          paramView = View.inflate(this.urV, 2130971221, null);
          paramViewGroup.kAK = ((CdnImageView)paramView.findViewById(2131829282));
          paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131829284));
          paramViewGroup.uso = ((TextView)paramView.findViewById(2131829286));
          paramViewGroup.gve = ((TextView)paramView.findViewById(2131829285));
          if (!TextUtils.isEmpty(localPromotions.url)) {
            this.urV.urO.put(localPromotions.url, paramViewGroup.uso);
          }
          paramView.setTag(paramViewGroup);
          paramViewGroup.uki = localPromotions.uki;
        }
      }
    }
    label293:
    label1586:
    for (;;)
    {
      if (localPromotions != null)
      {
        localObject = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(this.urV).get(localPromotions.ubC);
        ab.i("MicroMsg.WalletOrderInfoOldUI", "try get result ".concat(String.valueOf(localObject)));
        if (localObject == null) {
          break label1306;
        }
        paramViewGroup.kAK.setUrl(((WalletOrderInfoOldUI.b)localObject).cDz);
        paramViewGroup.gve.setText(((WalletOrderInfoOldUI.b)localObject).cyA);
        paramViewGroup.uso.setText(((WalletOrderInfoOldUI.b)localObject).urC);
        if (bo.isNullOrNil(localPromotions.ppq)) {
          break label1356;
        }
        paramViewGroup.uso.setVisibility(8);
        if (paramViewGroup.usp != null)
        {
          paramViewGroup.usp.setVisibility(0);
          if (!this.urV.uqP.contains(localPromotions.ppq)) {
            break label1345;
          }
          paramViewGroup.usp.setChecked(true);
        }
        label450:
        if ((paramViewGroup.titleTv == null) || (localObject == null) || (bo.isNullOrNil(((WalletOrderInfoOldUI.b)localObject).title))) {
          break label1383;
        }
        paramViewGroup.titleTv.setText(((WalletOrderInfoOldUI.b)localObject).title);
        label485:
        if ((!bo.isNullOrNil(this.urV.unA)) && (paramViewGroup.uso != null))
        {
          paramViewGroup.uso.setClickable(this.urV.coa);
          paramViewGroup.uso.setEnabled(this.urV.coa);
          paramViewGroup.uso.setOnClickListener(null);
          if (this.urV.cob) {
            paramViewGroup.uso.setVisibility(8);
          }
        }
        long l = localPromotions.ubC;
        localObject = this.urV.nh(l);
        if (!((String)localObject).equals("0")) {
          break label1435;
        }
        paramViewGroup.uso.setBackgroundColor(this.urV.getResources().getColor(2131690605));
        paramViewGroup.uso.setTextColor(this.urV.getResources().getColor(2131690701));
      }
      for (;;)
      {
        if (paramViewGroup.uso != null)
        {
          paramInt = BackwardSupportUtil.b.b(this.urV.getContext(), 15.0F);
          i = BackwardSupportUtil.b.b(this.urV.getContext(), 5.0F);
          paramViewGroup.uso.setPadding(paramInt, i, paramInt, i);
        }
        AppMethodBeat.o(47496);
        return paramView;
        paramView = View.inflate(this.urV, 2130971222, null);
        paramViewGroup.kAK = ((CdnImageView)paramView.findViewById(2131829282));
        paramViewGroup.uso = ((TextView)paramView.findViewById(2131829286));
        paramViewGroup.gve = ((TextView)paramView.findViewById(2131829285));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131829284));
        if (!TextUtils.isEmpty(localPromotions.url)) {
          this.urV.urO.put(localPromotions.url, paramViewGroup.uso);
        }
        paramView.setTag(paramViewGroup);
        break;
        paramView = View.inflate(this.urV, 2130971223, null);
        paramViewGroup.kAK = ((CdnImageView)paramView.findViewById(2131829282));
        paramViewGroup.uso = ((TextView)paramView.findViewById(2131829286));
        paramViewGroup.gve = ((TextView)paramView.findViewById(2131829285));
        paramViewGroup.usp = ((CheckBox)paramView.findViewById(2131829071));
        if (!TextUtils.isEmpty(localPromotions.url)) {
          this.urV.urO.put(localPromotions.url, paramViewGroup.uso);
        }
        paramView.setTag(paramViewGroup);
        break label293;
        paramViewGroup = (WalletOrderInfoOldUI.c.a)paramView.getTag();
        int i = 0;
        paramInt = i;
        if (localPromotions.type == paramViewGroup.type) {
          if (localPromotions.type == Orders.ujL)
          {
            paramInt = i;
            if (localPromotions.uki != paramViewGroup.uki) {}
          }
          else
          {
            paramInt = 1;
          }
        }
        if (paramInt != 0) {
          break label1586;
        }
        paramViewGroup = new WalletOrderInfoOldUI.c.a(this);
        paramViewGroup.type = localPromotions.type;
        if (localPromotions.type == Orders.ujL)
        {
          if (localPromotions.uki == 1)
          {
            paramView = View.inflate(this.urV, 2130971221, null);
            paramViewGroup.kAK = ((CdnImageView)paramView.findViewById(2131829282));
            paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131829284));
            paramViewGroup.uso = ((TextView)paramView.findViewById(2131829286));
            paramViewGroup.gve = ((TextView)paramView.findViewById(2131829285));
            if (!TextUtils.isEmpty(localPromotions.url)) {
              this.urV.urO.put(localPromotions.url, paramViewGroup.uso);
            }
            paramView.setTag(paramViewGroup);
          }
          for (;;)
          {
            paramViewGroup.uki = localPromotions.uki;
            break;
            paramView = View.inflate(this.urV, 2130971222, null);
            paramViewGroup.kAK = ((CdnImageView)paramView.findViewById(2131829282));
            paramViewGroup.uso = ((TextView)paramView.findViewById(2131829286));
            paramViewGroup.gve = ((TextView)paramView.findViewById(2131829285));
            paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131829284));
            if (!TextUtils.isEmpty(localPromotions.url)) {
              this.urV.urO.put(localPromotions.url, paramViewGroup.uso);
            }
            paramView.setTag(paramViewGroup);
          }
        }
        paramView = View.inflate(this.urV, 2130971223, null);
        paramViewGroup.kAK = ((CdnImageView)paramView.findViewById(2131829282));
        paramViewGroup.uso = ((TextView)paramView.findViewById(2131829286));
        paramViewGroup.gve = ((TextView)paramView.findViewById(2131829285));
        paramViewGroup.usp = ((CheckBox)paramView.findViewById(2131829071));
        if (!TextUtils.isEmpty(localPromotions.url)) {
          this.urV.urO.put(localPromotions.url, paramViewGroup.uso);
        }
        paramView.setTag(paramViewGroup);
        break label293;
        paramViewGroup.kAK.setUrl(localPromotions.pvi);
        paramViewGroup.gve.setText(localPromotions.name);
        paramViewGroup.uso.setText(localPromotions.uiO);
        break label387;
        label1345:
        paramViewGroup.usp.setChecked(false);
        break label450;
        label1356:
        paramViewGroup.uso.setVisibility(0);
        if (paramViewGroup.usp == null) {
          break label450;
        }
        paramViewGroup.usp.setVisibility(8);
        break label450;
        label1383:
        if ((paramViewGroup.titleTv != null) && (!bo.isNullOrNil(localPromotions.title)))
        {
          paramViewGroup.titleTv.setText(localPromotions.title);
          break label485;
        }
        if (paramViewGroup.titleTv == null) {
          break label485;
        }
        paramViewGroup.titleTv.setVisibility(8);
        break label485;
        if ((((String)localObject).equals("-1")) || (((String)localObject).equals("3")))
        {
          paramViewGroup.uso.setBackgroundDrawable(this.urV.getResources().getDrawable(2130838054));
          paramViewGroup.uso.setTextColor(this.urV.getResources().getColor(2131690701));
        }
        else if ((((String)localObject).equals("4")) || (((String)localObject).equals("2")) || (((String)localObject).equals("1")))
        {
          paramViewGroup.uso.setBackgroundColor(this.urV.getResources().getColor(2131690605));
          paramViewGroup.uso.setTextColor(this.urV.getResources().getColor(2131690168));
        }
        else
        {
          ab.e("MicroMsg.WalletOrderInfoOldUI", "PromotionsAdapter unknow award state");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.c
 * JD-Core Version:    0.7.0.1
 */