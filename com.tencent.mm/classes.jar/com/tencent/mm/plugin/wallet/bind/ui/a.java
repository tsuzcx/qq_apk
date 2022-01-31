package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends BaseAdapter
{
  private final Context mContext;
  private int mCount = 0;
  private ArrayList<Bankcard> qjw;
  private int qjx;
  com.tencent.mm.plugin.wallet_core.e.a qjy;
  List<String> qjz;
  
  public a(Context paramContext, ArrayList<Bankcard> paramArrayList)
  {
    this.mContext = paramContext;
    this.qjw = paramArrayList;
    this.qjx = 0;
    this.qjy = new com.tencent.mm.plugin.wallet_core.e.a();
    this.qjy.b(this.mContext, this.qjw);
    bTA();
  }
  
  private Bankcard AH(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mCount)) {
      return (Bankcard)this.qjw.get(paramInt);
    }
    return null;
  }
  
  private void bTA()
  {
    g.DQ();
    this.qjz = bk.G(((String)g.DP().Dz().get(ac.a.uxt, "")).split(","));
  }
  
  public final void R(ArrayList<Bankcard> paramArrayList)
  {
    this.qjw = paramArrayList;
    if (paramArrayList != null) {}
    for (this.mCount = paramArrayList.size();; this.mCount = 0)
    {
      if (this.mCount > 0) {
        this.qjy.b(this.mContext, this.qjw);
      }
      bTA();
      return;
    }
  }
  
  public int getCount()
  {
    return this.mCount;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Bankcard localBankcard = AH(paramInt);
    if (localBankcard == null) {
      return 4;
    }
    if (localBankcard.field_bankcardState == 9)
    {
      if (localBankcard.field_wxcreditState == 0) {
        return 2;
      }
      return 3;
    }
    if ((localBankcard.bUP()) && ("CITIC_CREDIT".equals(localBankcard.field_bankcardType))) {
      return 5;
    }
    if (localBankcard.bUU()) {
      return 6;
    }
    if ((localBankcard.bUT()) && (!q.Gw())) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Bankcard localBankcard = AH(paramInt);
    if (localBankcard == null) {
      return paramView;
    }
    int i = getItemViewType(paramInt);
    boolean bool;
    if ((this.qjz == null) || (this.qjz.isEmpty()) || (localBankcard == null)) {
      bool = false;
    }
    for (;;)
    {
      y.v("MicroMsg.BankcardListAdapter", "getView, pos: %d, bottom_wording: %s, showNew: %s", new Object[] { Integer.valueOf(paramInt), localBankcard.field_card_bottom_wording, Boolean.valueOf(bool) });
      switch (i)
      {
      default: 
        return paramView;
      case 0: 
        return com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, a.g.wallet_bankcard, this.qjy, bool, i);
        paramViewGroup = this.qjz.iterator();
        for (;;)
        {
          if (paramViewGroup.hasNext()) {
            if (((String)paramViewGroup.next()).equals(localBankcard.field_bindSerial))
            {
              bool = true;
              break;
            }
          }
        }
        bool = false;
      }
    }
    return com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, a.g.wallet_bankcard_international, this.qjy, bool, i);
    paramInt = a.g.wallet_bankcard_wxcredit_err;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, paramInt, null);
      paramView = new a.a(this);
      paramView.qjF = ((ImageView)((View)localObject).findViewById(a.f.bank_logo));
      paramView.qjB = ((TextView)((View)localObject).findViewById(a.f.bank_name));
      paramView.qjG = ((TextView)((View)localObject).findViewById(a.f.bankcard_expired));
      paramView.qjJ = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask1));
      paramView.qjK = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask2));
      paramView.qjL = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask3));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      switch (localBankcard.field_wxcreditState)
      {
      case 2: 
      default: 
        paramViewGroup.qjG.setVisibility(8);
      }
    }
    for (;;)
    {
      paramViewGroup.qjB.setText(localBankcard.field_bankName);
      this.qjy.a(this.mContext, localBankcard, paramViewGroup.qjF);
      return localObject;
      paramViewGroup = (a.a)paramView.getTag();
      localObject = paramView;
      break;
      paramViewGroup.qjG.setBackgroundResource(a.e.wallet_bankcard_verify);
      paramViewGroup.qjG.setVisibility(0);
      continue;
      paramViewGroup.qjG.setBackgroundResource(a.e.wallet_bankcard_fail);
      paramViewGroup.qjG.setVisibility(0);
    }
    paramInt = a.g.wallet_bankcard_wait_2_open;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, paramInt, null);
      paramView = new a.a(this);
      paramView.qjF = ((ImageView)((View)localObject).findViewById(a.f.bank_logo));
      paramView.qjB = ((TextView)((View)localObject).findViewById(a.f.bank_name));
      paramView.qjI = ((TextView)((View)localObject).findViewById(a.f.new_msg_tip));
      paramView.qjJ = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask1));
      paramView.qjK = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask2));
      paramView.qjL = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask3));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.qjB.setText(this.mContext.getString(a.i.wallet_index_ui_open_wxcredit, new Object[] { localBankcard.field_bankName }));
      if (!b.a(localBankcard)) {
        break;
      }
      paramViewGroup.qjI.setVisibility(0);
      return localObject;
      paramViewGroup = (a.a)paramView.getTag();
      localObject = paramView;
    }
    paramViewGroup.qjI.setVisibility(8);
    return localObject;
    return com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, a.g.wallet_bankcard_white, this.qjy, bool, i);
    return View.inflate(this.mContext, a.g.wallet_bankcard_add, null);
    paramInt = a.g.wallet_bankcard_honey_pay;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = View.inflate(this.mContext, paramInt, null);
      paramViewGroup = new a.a(this);
      paramViewGroup.qjF = ((ImageView)paramView.findViewById(a.f.bank_logo));
      paramViewGroup.qjB = ((TextView)paramView.findViewById(a.f.bank_name));
      paramViewGroup.qjC = ((TextView)paramView.findViewById(a.f.bankcard_type));
      paramViewGroup.qjG = ((TextView)paramView.findViewById(a.f.bankcard_expired));
      paramViewGroup.qjM = ((WalletTextView)paramView.findViewById(a.f.wallet_bankcard_honeypay_quota_tv));
      paramViewGroup.qjE = ((ImageView)paramView.findViewById(a.f.bankcard_mask));
      paramViewGroup.qjN = ((TextView)paramView.findViewById(a.f.wallet_bankcard_honeypay_remain_quota_desc_tv));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.qjF.setImageDrawable(com.tencent.mm.svg.a.a.e(this.mContext.getResources(), a.h.honey_pay_bank_logo));
      if (((paramViewGroup.qjF instanceof CdnImageView)) && (!bk.bl(localBankcard.qtP)))
      {
        ((CdnImageView)paramViewGroup.qjF).setUseSdcardCache(true);
        ((CdnImageView)paramViewGroup.qjF).setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.bWn());
        ((CdnImageView)paramViewGroup.qjF).dl(localBankcard.qtP, a.h.honey_pay_bank_logo);
      }
      localObject = com.tencent.mm.wallet_core.ui.e.dP(com.tencent.mm.wallet_core.ui.e.gV(localBankcard.qtL), 10);
      paramViewGroup.qjB.setText(j.a(this.mContext, (CharSequence)localObject, paramViewGroup.qjB.getTextSize()));
      paramViewGroup.qjC.setText(localBankcard.qtO);
      if (localBankcard.qtM != 0) {
        break;
      }
      localObject = com.tencent.mm.wallet_core.ui.e.b(localBankcard.qtK, "100", RoundingMode.HALF_UP).toString();
      paramViewGroup.qjM.setPrefix(ab.cML());
      paramViewGroup.qjM.setText((CharSequence)localObject);
      paramViewGroup.qjM.setVisibility(0);
      paramViewGroup.qjN.setVisibility(0);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
    }
    paramViewGroup.qjM.setVisibility(4);
    paramViewGroup.qjN.setVisibility(4);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.a
 * JD-Core Version:    0.7.0.1
 */