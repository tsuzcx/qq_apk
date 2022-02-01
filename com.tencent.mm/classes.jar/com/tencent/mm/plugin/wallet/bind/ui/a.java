package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends BaseAdapter
{
  private static final String HCA;
  private static final String HCB;
  private static final String HCC;
  private static final String HCD;
  private static final String HCE;
  private static final String HCz;
  private ArrayList<Bankcard> HCF;
  private int HCG;
  com.tencent.mm.plugin.wallet_core.utils.a HCH;
  List<String> HCI;
  private final Context mContext;
  private int mCount;
  
  static
  {
    AppMethodBeat.i(214049);
    HCz = "http://" + WeChatHosts.domainString(2131761736) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png";
    HCA = "http://" + WeChatHosts.domainString(2131761736) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png";
    HCB = "http://" + WeChatHosts.domainString(2131761736) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png";
    HCC = "http://" + WeChatHosts.domainString(2131761736) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png";
    HCD = "http://" + WeChatHosts.domainString(2131761736) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png";
    HCE = "http://" + WeChatHosts.domainString(2131761736) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png";
    AppMethodBeat.o(214049);
  }
  
  public a(Context paramContext, ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(69069);
    this.mCount = 0;
    this.mContext = paramContext;
    this.HCF = paramArrayList;
    this.HCG = 0;
    this.HCH = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.HCH.b(this.mContext, this.HCF);
    fNW();
    AppMethodBeat.o(69069);
  }
  
  private Bankcard aeu(int paramInt)
  {
    AppMethodBeat.i(69072);
    if ((paramInt >= 0) && (paramInt < this.mCount))
    {
      Bankcard localBankcard = (Bankcard)this.HCF.get(paramInt);
      AppMethodBeat.o(69072);
      return localBankcard;
    }
    AppMethodBeat.o(69072);
    return null;
  }
  
  private void fNW()
  {
    AppMethodBeat.i(69071);
    g.aAi();
    this.HCI = Util.stringsToList(((String)g.aAh().azQ().get(ar.a.Odx, "")).split(","));
    AppMethodBeat.o(69071);
  }
  
  public final void aV(ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(69070);
    this.HCF = paramArrayList;
    if (paramArrayList != null) {}
    for (this.mCount = paramArrayList.size();; this.mCount = 0)
    {
      if (this.mCount > 0) {
        this.HCH.b(this.mContext, this.HCF);
      }
      fNW();
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
    Bankcard localBankcard = aeu(paramInt);
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
    if ((localBankcard.fQa()) && ("CITIC_CREDIT".equals(localBankcard.field_bankcardType)))
    {
      AppMethodBeat.o(69073);
      return 5;
    }
    if (localBankcard.fQf())
    {
      AppMethodBeat.o(69073);
      return 6;
    }
    if ((localBankcard.fQe()) && (!z.aUo()))
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
    Bankcard localBankcard = aeu(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(69074);
      return paramView;
    }
    int i = getItemViewType(paramInt);
    boolean bool;
    if ((this.HCI == null) || (this.HCI.isEmpty()) || (localBankcard == null)) {
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
        paramViewGroup = this.HCI.iterator();
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
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131496891, this.HCH, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131496898, this.HCH, bool);
    AppMethodBeat.o(69074);
    return paramView;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, 2131496905, null);
      paramView = new a();
      paramView.HCR = ((ImageView)((View)localObject).findViewById(2131297265));
      paramView.HCN = ((TextView)((View)localObject).findViewById(2131297274));
      paramView.HCS = ((TextView)((View)localObject).findViewById(2131297302));
      paramView.HCV = ((ImageView)((View)localObject).findViewById(2131297304));
      paramView.HCW = ((ImageView)((View)localObject).findViewById(2131297305));
      paramView.HCX = ((ImageView)((View)localObject).findViewById(2131297306));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      switch (localBankcard.field_wxcreditState)
      {
      case 2: 
      default: 
        paramViewGroup.HCS.setVisibility(8);
      }
    }
    for (;;)
    {
      paramViewGroup.HCN.setText(localBankcard.field_bankName);
      this.HCH.a(this.mContext, localBankcard, paramViewGroup.HCR);
      AppMethodBeat.o(69074);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      paramViewGroup.HCS.setBackgroundResource(2131235595);
      paramViewGroup.HCS.setVisibility(0);
      continue;
      paramViewGroup.HCS.setBackgroundResource(2131235583);
      paramViewGroup.HCS.setVisibility(0);
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, 2131496902, null);
      paramView = new a();
      paramView.HCR = ((ImageView)((View)localObject).findViewById(2131297265));
      paramView.HCN = ((TextView)((View)localObject).findViewById(2131297274));
      paramView.HCU = ((TextView)((View)localObject).findViewById(2131305360));
      paramView.HCV = ((ImageView)((View)localObject).findViewById(2131297304));
      paramView.HCW = ((ImageView)((View)localObject).findViewById(2131297305));
      paramView.HCX = ((ImageView)((View)localObject).findViewById(2131297306));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.HCN.setText(this.mContext.getString(2131767753, new Object[] { localBankcard.field_bankName }));
      if (!b.c(localBankcard)) {
        break label712;
      }
      paramViewGroup.HCU.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(69074);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      label712:
      paramViewGroup.HCU.setVisibility(8);
    }
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131496903, this.HCH, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramView = View.inflate(this.mContext, 2131496892, null);
    AppMethodBeat.o(69074);
    return paramView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = View.inflate(this.mContext, 2131496896, null);
      paramViewGroup = new a();
      paramViewGroup.HCR = ((ImageView)paramView.findViewById(2131297265));
      paramViewGroup.HCN = ((TextView)paramView.findViewById(2131297274));
      paramViewGroup.HCO = ((TextView)paramView.findViewById(2131297321));
      paramViewGroup.HCS = ((TextView)paramView.findViewById(2131297302));
      paramViewGroup.HCY = ((WalletTextView)paramView.findViewById(2131310145));
      paramViewGroup.HCQ = ((ImageView)paramView.findViewById(2131297312));
      paramViewGroup.HCZ = ((TextView)paramView.findViewById(2131310146));
      paramViewGroup.HCP = ((ViewGroup)paramView.findViewById(2131310148));
      paramView.setTag(paramViewGroup);
      paramViewGroup.HCR.setImageDrawable(com.tencent.mm.svg.a.a.h(this.mContext.getResources(), 2131690395));
      if (((paramViewGroup.HCR instanceof CdnImageView)) && (!Util.isNullOrNil(localBankcard.HVU)))
      {
        ((CdnImageView)paramViewGroup.HCR).setUseSdcardCache(true);
        ((CdnImageView)paramViewGroup.HCR).setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.fSn());
        ((CdnImageView)paramViewGroup.HCR).gI(localBankcard.HVU, 2131690395);
      }
      localObject = f.hs(f.getDisplayName(localBankcard.HVQ), 10);
      paramViewGroup.HCN.setText(l.b(this.mContext, (CharSequence)localObject, paramViewGroup.HCN.getTextSize()));
      paramViewGroup.HCO.setText(localBankcard.HVT);
      if (localBankcard.HVR != 0) {
        break label1190;
      }
      localObject = f.b(localBankcard.HVP, "100", 2, RoundingMode.HALF_UP).toString();
      paramViewGroup.HCY.setPrefix(ah.hhz());
      paramViewGroup.HCY.setText((CharSequence)localObject);
      paramViewGroup.HCY.setVisibility(0);
      paramViewGroup.HCZ.setVisibility(0);
    }
    for (;;)
    {
      if (com.tencent.mm.ui.ao.isDarkMode())
      {
        paramViewGroup.HCP.setBackgroundResource(2131235588);
        paramViewGroup.HCQ.setImageResource(2131690409);
      }
      paramView.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214048);
          int[] arrayOfInt = new int[2];
          paramViewGroup.HCN.getLocationInWindow(arrayOfInt);
          int i = arrayOfInt[0];
          paramViewGroup.HCY.getLocationInWindow(arrayOfInt);
          int j = arrayOfInt[0];
          paramViewGroup.HCN.setMaxWidth(j - i - com.tencent.mm.cb.a.fromDPToPix(paramView.getContext(), 16));
          AppMethodBeat.o(214048);
        }
      }, 50L);
      AppMethodBeat.o(69074);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label1190:
      paramViewGroup.HCY.setVisibility(4);
      paramViewGroup.HCZ.setVisibility(4);
    }
  }
  
  public int getViewTypeCount()
  {
    return 7;
  }
  
  final class a
  {
    public TextView HCM = null;
    public TextView HCN = null;
    public TextView HCO = null;
    public ViewGroup HCP = null;
    public ImageView HCQ = null;
    public ImageView HCR = null;
    public TextView HCS = null;
    public TextView HCT = null;
    public TextView HCU = null;
    public ImageView HCV = null;
    public ImageView HCW = null;
    public ImageView HCX = null;
    public WalletTextView HCY = null;
    public TextView HCZ = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.a
 * JD-Core Version:    0.7.0.1
 */