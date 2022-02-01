package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.g;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends BaseAdapter
{
  private static final String Ous;
  private static final String Out;
  private static final String Ouu;
  private static final String Ouv;
  private static final String Ouw;
  private static final String Oux;
  com.tencent.mm.plugin.wallet_core.utils.a OuA;
  List<String> OuB;
  private ArrayList<Bankcard> Ouy;
  private int Ouz;
  private final Context mContext;
  private int mCount;
  
  static
  {
    AppMethodBeat.i(223497);
    Ous = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png";
    Out = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png";
    Ouu = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png";
    Ouv = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png";
    Ouw = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png";
    Oux = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png";
    AppMethodBeat.o(223497);
  }
  
  public a(Context paramContext, ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(69069);
    this.mCount = 0;
    this.mContext = paramContext;
    this.Ouy = paramArrayList;
    this.Ouz = 0;
    this.OuA = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.OuA.b(this.mContext, this.Ouy);
    gGB();
    AppMethodBeat.o(69069);
  }
  
  private Bankcard amh(int paramInt)
  {
    AppMethodBeat.i(69072);
    if ((paramInt >= 0) && (paramInt < this.mCount))
    {
      Bankcard localBankcard = (Bankcard)this.Ouy.get(paramInt);
      AppMethodBeat.o(69072);
      return localBankcard;
    }
    AppMethodBeat.o(69072);
    return null;
  }
  
  private void gGB()
  {
    AppMethodBeat.i(69071);
    h.aHH();
    this.OuB = Util.stringsToList(((String)h.aHG().aHp().get(ar.a.VrI, "")).split(","));
    AppMethodBeat.o(69071);
  }
  
  public final void bj(ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(69070);
    this.Ouy = paramArrayList;
    if (paramArrayList != null) {}
    for (this.mCount = paramArrayList.size();; this.mCount = 0)
    {
      if (this.mCount > 0) {
        this.OuA.b(this.mContext, this.Ouy);
      }
      gGB();
      AppMethodBeat.o(69070);
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
    AppMethodBeat.i(69073);
    Bankcard localBankcard = amh(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(69073);
      return 4;
    }
    if (localBankcard.field_bankcardState == 9)
    {
      if (localBankcard.field_wxcreditState == 0)
      {
        AppMethodBeat.o(69073);
        return 2;
      }
      AppMethodBeat.o(69073);
      return 3;
    }
    if ((localBankcard.gIG()) && ("CITIC_CREDIT".equals(localBankcard.field_bankcardType)))
    {
      AppMethodBeat.o(69073);
      return 5;
    }
    if (localBankcard.gIL())
    {
      AppMethodBeat.o(69073);
      return 6;
    }
    if ((localBankcard.gIK()) && (!z.bdq()))
    {
      AppMethodBeat.o(69073);
      return 0;
    }
    AppMethodBeat.o(69073);
    return 1;
  }
  
  public View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(69074);
    Bankcard localBankcard = amh(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(69074);
      return paramView;
    }
    int i = getItemViewType(paramInt);
    boolean bool;
    if ((this.OuB == null) || (this.OuB.isEmpty()) || (localBankcard == null)) {
      bool = false;
    }
    for (;;)
    {
      Log.v("MicroMsg.BankcardListAdapter", "getView, pos: %d, bottom_wording: %s, showNew: %s", new Object[] { Integer.valueOf(paramInt), localBankcard.field_card_bottom_wording, Boolean.valueOf(bool) });
      switch (i)
      {
      default: 
        AppMethodBeat.o(69074);
        return paramView;
        paramViewGroup = this.OuB.iterator();
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
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, a.g.wallet_bankcard, this.OuA, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, a.g.wallet_bankcard_international, this.OuA, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramInt = a.g.wallet_bankcard_wxcredit_err;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, paramInt, null);
      paramView = new a();
      paramView.OuK = ((ImageView)((View)localObject).findViewById(a.f.bank_logo));
      paramView.OuG = ((TextView)((View)localObject).findViewById(a.f.bank_name));
      paramView.OuL = ((TextView)((View)localObject).findViewById(a.f.bankcard_expired));
      paramView.OuO = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask1));
      paramView.OuP = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask2));
      paramView.OuQ = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask3));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      switch (localBankcard.field_wxcreditState)
      {
      case 2: 
      default: 
        paramViewGroup.OuL.setVisibility(8);
      }
    }
    for (;;)
    {
      paramViewGroup.OuG.setText(localBankcard.field_bankName);
      this.OuA.a(this.mContext, localBankcard, paramViewGroup.OuK);
      AppMethodBeat.o(69074);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      paramViewGroup.OuL.setBackgroundResource(a.e.wallet_bankcard_verify);
      paramViewGroup.OuL.setVisibility(0);
      continue;
      paramViewGroup.OuL.setBackgroundResource(a.e.wallet_bankcard_fail);
      paramViewGroup.OuL.setVisibility(0);
    }
    paramInt = a.g.wallet_bankcard_wait_2_open;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, paramInt, null);
      paramView = new a();
      paramView.OuK = ((ImageView)((View)localObject).findViewById(a.f.bank_logo));
      paramView.OuG = ((TextView)((View)localObject).findViewById(a.f.bank_name));
      paramView.OuN = ((TextView)((View)localObject).findViewById(a.f.new_msg_tip));
      paramView.OuO = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask1));
      paramView.OuP = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask2));
      paramView.OuQ = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask3));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.OuG.setText(this.mContext.getString(a.i.wallet_index_ui_open_wxcredit, new Object[] { localBankcard.field_bankName }));
      if (!b.c(localBankcard)) {
        break label714;
      }
      paramViewGroup.OuN.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(69074);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      label714:
      paramViewGroup.OuN.setVisibility(8);
    }
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, a.g.wallet_bankcard_white, this.OuA, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramView = View.inflate(this.mContext, a.g.wallet_bankcard_add, null);
    AppMethodBeat.o(69074);
    return paramView;
    paramInt = a.g.wallet_bankcard_honey_pay;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = View.inflate(this.mContext, paramInt, null);
      paramViewGroup = new a();
      paramViewGroup.OuK = ((ImageView)paramView.findViewById(a.f.bank_logo));
      paramViewGroup.OuG = ((TextView)paramView.findViewById(a.f.bank_name));
      paramViewGroup.OuH = ((TextView)paramView.findViewById(a.f.bankcard_type));
      paramViewGroup.OuL = ((TextView)paramView.findViewById(a.f.bankcard_expired));
      paramViewGroup.OuR = ((WalletTextView)paramView.findViewById(a.f.wallet_bankcard_honeypay_quota_tv));
      paramViewGroup.OuJ = ((ImageView)paramView.findViewById(a.f.bankcard_mask));
      paramViewGroup.OuS = ((TextView)paramView.findViewById(a.f.wallet_bankcard_honeypay_remain_quota_desc_tv));
      paramViewGroup.OuI = ((ViewGroup)paramView.findViewById(a.f.wallet_bankcard_rl));
      paramView.setTag(paramViewGroup);
      paramViewGroup.OuK.setImageDrawable(com.tencent.mm.svg.a.a.h(this.mContext.getResources(), a.h.honey_pay_bank_logo));
      if (((paramViewGroup.OuK instanceof CdnImageView)) && (!Util.isNullOrNil(localBankcard.ONV)))
      {
        ((CdnImageView)paramViewGroup.OuK).setUseSdcardCache(true);
        ((CdnImageView)paramViewGroup.OuK).setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.gKS());
        ((CdnImageView)paramViewGroup.OuK).hr(localBankcard.ONV, a.h.honey_pay_bank_logo);
      }
      localObject = g.ic(g.PJ(localBankcard.ONR), 10);
      paramViewGroup.OuG.setText(l.b(this.mContext, (CharSequence)localObject, paramViewGroup.OuG.getTextSize()));
      paramViewGroup.OuH.setText(localBankcard.ONU);
      if (localBankcard.ONS != 0) {
        break label1194;
      }
      localObject = g.b(localBankcard.ONQ, "100", 2, RoundingMode.HALF_UP).toString();
      paramViewGroup.OuR.setPrefix(ah.ijb());
      paramViewGroup.OuR.setText((CharSequence)localObject);
      paramViewGroup.OuR.setVisibility(0);
      paramViewGroup.OuS.setVisibility(0);
    }
    for (;;)
    {
      if (ar.isDarkMode())
      {
        paramViewGroup.OuI.setBackgroundResource(a.e.wallet_bankcard_honeypay_bg_dm);
        paramViewGroup.OuJ.setImageResource(a.h.honey_pay_input_logo_dm);
      }
      paramView.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(234263);
          int[] arrayOfInt = new int[2];
          paramViewGroup.OuG.getLocationInWindow(arrayOfInt);
          int i = arrayOfInt[0];
          paramViewGroup.OuR.getLocationInWindow(arrayOfInt);
          int j = arrayOfInt[0];
          paramViewGroup.OuG.setMaxWidth(j - i - com.tencent.mm.ci.a.fromDPToPix(paramView.getContext(), 16));
          AppMethodBeat.o(234263);
        }
      }, 50L);
      AppMethodBeat.o(69074);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label1194:
      paramViewGroup.OuR.setVisibility(4);
      paramViewGroup.OuS.setVisibility(4);
    }
  }
  
  public int getViewTypeCount()
  {
    return 7;
  }
  
  final class a
  {
    public TextView OuF = null;
    public TextView OuG = null;
    public TextView OuH = null;
    public ViewGroup OuI = null;
    public ImageView OuJ = null;
    public ImageView OuK = null;
    public TextView OuL = null;
    public TextView OuM = null;
    public TextView OuN = null;
    public ImageView OuO = null;
    public ImageView OuP = null;
    public ImageView OuQ = null;
    public WalletTextView OuR = null;
    public TextView OuS = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.a
 * JD-Core Version:    0.7.0.1
 */