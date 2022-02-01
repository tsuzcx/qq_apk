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
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.i;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends BaseAdapter
{
  private static final String VjG;
  private static final String VjH;
  private static final String VjI;
  private static final String VjJ;
  private static final String VjK;
  private static final String VjL;
  private ArrayList<Bankcard> VjM;
  private int VjN;
  com.tencent.mm.plugin.wallet_core.utils.b VjO;
  List<String> VjP;
  private final Context mContext;
  private int mCount;
  
  static
  {
    AppMethodBeat.i(315561);
    VjG = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png";
    VjH = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png";
    VjI = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png";
    VjJ = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png";
    VjK = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png";
    VjL = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png";
    AppMethodBeat.o(315561);
  }
  
  public a(Context paramContext, ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(69069);
    this.mCount = 0;
    this.mContext = paramContext;
    this.VjM = paramArrayList;
    this.VjN = 0;
    this.VjO = new com.tencent.mm.plugin.wallet_core.utils.b();
    this.VjO.d(this.mContext, this.VjM);
    ifE();
    AppMethodBeat.o(69069);
  }
  
  private Bankcard arR(int paramInt)
  {
    AppMethodBeat.i(69072);
    if ((paramInt >= 0) && (paramInt < this.mCount))
    {
      Bankcard localBankcard = (Bankcard)this.VjM.get(paramInt);
      AppMethodBeat.o(69072);
      return localBankcard;
    }
    AppMethodBeat.o(69072);
    return null;
  }
  
  private void ifE()
  {
    AppMethodBeat.i(69071);
    h.baF();
    this.VjP = Util.stringsToList(((String)h.baE().ban().get(at.a.acTm, "")).split(","));
    AppMethodBeat.o(69071);
  }
  
  public final void bK(ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(69070);
    this.VjM = paramArrayList;
    if (paramArrayList != null) {}
    for (this.mCount = paramArrayList.size();; this.mCount = 0)
    {
      if (this.mCount > 0) {
        this.VjO.d(this.mContext, this.VjM);
      }
      ifE();
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
    Bankcard localBankcard = arR(paramInt);
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
    if ((localBankcard.ihU()) && ("CITIC_CREDIT".equals(localBankcard.field_bankcardType)))
    {
      AppMethodBeat.o(69073);
      return 5;
    }
    if (localBankcard.ihZ())
    {
      AppMethodBeat.o(69073);
      return 6;
    }
    if ((localBankcard.ihY()) && (!z.bBi()))
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
    Bankcard localBankcard = arR(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(69074);
      return paramView;
    }
    int i = getItemViewType(paramInt);
    boolean bool;
    if ((this.VjP == null) || (this.VjP.isEmpty()) || (localBankcard == null)) {
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
        paramViewGroup = this.VjP.iterator();
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
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, a.g.wallet_bankcard, this.VjO, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, a.g.wallet_bankcard_international, this.VjO, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramInt = a.g.wallet_bankcard_wxcredit_err;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, paramInt, null);
      paramView = new a();
      paramView.VjY = ((ImageView)((View)localObject).findViewById(a.f.bank_logo));
      paramView.VjU = ((TextView)((View)localObject).findViewById(a.f.bank_name));
      paramView.VjZ = ((TextView)((View)localObject).findViewById(a.f.bankcard_expired));
      paramView.Vkc = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask1));
      paramView.Vkd = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask2));
      paramView.Vke = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask3));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      switch (localBankcard.field_wxcreditState)
      {
      case 2: 
      default: 
        paramViewGroup.VjZ.setVisibility(8);
      }
    }
    for (;;)
    {
      paramViewGroup.VjU.setText(localBankcard.field_bankName);
      this.VjO.a(this.mContext, localBankcard, paramViewGroup.VjY);
      AppMethodBeat.o(69074);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      paramViewGroup.VjZ.setBackgroundResource(a.e.wallet_bankcard_verify);
      paramViewGroup.VjZ.setVisibility(0);
      continue;
      paramViewGroup.VjZ.setBackgroundResource(a.e.wallet_bankcard_fail);
      paramViewGroup.VjZ.setVisibility(0);
    }
    paramInt = a.g.wallet_bankcard_wait_2_open;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, paramInt, null);
      paramView = new a();
      paramView.VjY = ((ImageView)((View)localObject).findViewById(a.f.bank_logo));
      paramView.VjU = ((TextView)((View)localObject).findViewById(a.f.bank_name));
      paramView.Vkb = ((TextView)((View)localObject).findViewById(a.f.new_msg_tip));
      paramView.Vkc = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask1));
      paramView.Vkd = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask2));
      paramView.Vke = ((ImageView)((View)localObject).findViewById(a.f.bankcard_id_mask3));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.VjU.setText(this.mContext.getString(a.i.wallet_index_ui_open_wxcredit, new Object[] { localBankcard.field_bankName }));
      if (!b.d(localBankcard)) {
        break label714;
      }
      paramViewGroup.Vkb.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(69074);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      label714:
      paramViewGroup.Vkb.setVisibility(8);
    }
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, a.g.wallet_bankcard_white, this.VjO, bool);
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
      paramViewGroup.VjY = ((ImageView)paramView.findViewById(a.f.bank_logo));
      paramViewGroup.VjU = ((TextView)paramView.findViewById(a.f.bank_name));
      paramViewGroup.VjV = ((TextView)paramView.findViewById(a.f.bankcard_type));
      paramViewGroup.VjZ = ((TextView)paramView.findViewById(a.f.bankcard_expired));
      paramViewGroup.Vkf = ((WalletTextView)paramView.findViewById(a.f.wallet_bankcard_honeypay_quota_tv));
      paramViewGroup.VjX = ((ImageView)paramView.findViewById(a.f.bankcard_mask));
      paramViewGroup.Vkg = ((TextView)paramView.findViewById(a.f.wallet_bankcard_honeypay_remain_quota_desc_tv));
      paramViewGroup.VjW = ((ViewGroup)paramView.findViewById(a.f.wallet_bankcard_rl));
      paramView.setTag(paramViewGroup);
      paramViewGroup.VjY.setImageDrawable(com.tencent.mm.svg.a.a.i(this.mContext.getResources(), a.h.honey_pay_bank_logo));
      if (((paramViewGroup.VjY instanceof CdnImageView)) && (!Util.isNullOrNil(localBankcard.VDG)))
      {
        ((CdnImageView)paramViewGroup.VjY).setUseSdcardCache(true);
        ((CdnImageView)paramViewGroup.VjY).setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.ikk());
        ((CdnImageView)paramViewGroup.VjY).iz(localBankcard.VDG, a.h.honey_pay_bank_logo);
      }
      localObject = i.jo(i.getDisplayName(localBankcard.VDC), 10);
      paramViewGroup.VjU.setText(p.b(this.mContext, (CharSequence)localObject, paramViewGroup.VjU.getTextSize()));
      paramViewGroup.VjV.setText(localBankcard.VDF);
      if (localBankcard.VDD != 0) {
        break label1205;
      }
      localObject = i.b(localBankcard.VDB, "100", 2, RoundingMode.HALF_UP).toString();
      paramViewGroup.Vkf.setPrefix(ai.jOX());
      paramViewGroup.Vkf.setText((CharSequence)localObject);
      paramViewGroup.Vkf.setTextSize(1, 30.0F);
      paramViewGroup.Vkf.setVisibility(0);
      paramViewGroup.Vkg.setVisibility(0);
    }
    for (;;)
    {
      if (aw.isDarkMode())
      {
        paramViewGroup.VjW.setBackgroundResource(a.e.wallet_bankcard_honeypay_bg_dm);
        paramViewGroup.VjX.setImageResource(a.h.honey_pay_input_logo_dm);
      }
      paramView.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(315559);
          int[] arrayOfInt = new int[2];
          paramViewGroup.VjU.getLocationInWindow(arrayOfInt);
          int i = arrayOfInt[0];
          paramViewGroup.Vkf.getLocationInWindow(arrayOfInt);
          int j = arrayOfInt[0];
          paramViewGroup.VjU.setMaxWidth(j - i - com.tencent.mm.cd.a.fromDPToPix(paramView.getContext(), 16));
          AppMethodBeat.o(315559);
        }
      }, 50L);
      AppMethodBeat.o(69074);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label1205:
      paramViewGroup.Vkf.setVisibility(4);
      paramViewGroup.Vkg.setVisibility(4);
    }
  }
  
  public int getViewTypeCount()
  {
    return 7;
  }
  
  final class a
  {
    public TextView VjT = null;
    public TextView VjU = null;
    public TextView VjV = null;
    public ViewGroup VjW = null;
    public ImageView VjX = null;
    public ImageView VjY = null;
    public TextView VjZ = null;
    public TextView Vka = null;
    public TextView Vkb = null;
    public ImageView Vkc = null;
    public ImageView Vkd = null;
    public ImageView Vke = null;
    public WalletTextView Vkf = null;
    public TextView Vkg = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.a
 * JD-Core Version:    0.7.0.1
 */