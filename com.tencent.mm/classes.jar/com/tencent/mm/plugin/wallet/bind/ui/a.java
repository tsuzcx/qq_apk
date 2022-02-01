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
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.al;
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
  private ArrayList<Bankcard> CWT;
  private int CWU;
  com.tencent.mm.plugin.wallet_core.utils.a CWV;
  List<String> CWW;
  private final Context mContext;
  private int mCount;
  
  public a(Context paramContext, ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(69069);
    this.mCount = 0;
    this.mContext = paramContext;
    this.CWT = paramArrayList;
    this.CWU = 0;
    this.CWV = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.CWV.b(this.mContext, this.CWT);
    eGM();
    AppMethodBeat.o(69069);
  }
  
  private Bankcard VS(int paramInt)
  {
    AppMethodBeat.i(69072);
    if ((paramInt >= 0) && (paramInt < this.mCount))
    {
      Bankcard localBankcard = (Bankcard)this.CWT.get(paramInt);
      AppMethodBeat.o(69072);
      return localBankcard;
    }
    AppMethodBeat.o(69072);
    return null;
  }
  
  private void eGM()
  {
    AppMethodBeat.i(69071);
    g.ajS();
    this.CWW = bu.U(((String)g.ajR().ajA().get(am.a.IVf, "")).split(","));
    AppMethodBeat.o(69071);
  }
  
  public final void aD(ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(69070);
    this.CWT = paramArrayList;
    if (paramArrayList != null) {}
    for (this.mCount = paramArrayList.size();; this.mCount = 0)
    {
      if (this.mCount > 0) {
        this.CWV.b(this.mContext, this.CWT);
      }
      eGM();
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
    Bankcard localBankcard = VS(paramInt);
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
    if ((localBankcard.eIx()) && ("CITIC_CREDIT".equals(localBankcard.field_bankcardType)))
    {
      AppMethodBeat.o(69073);
      return 5;
    }
    if (localBankcard.eIC())
    {
      AppMethodBeat.o(69073);
      return 6;
    }
    if ((localBankcard.eIB()) && (!v.aAR()))
    {
      AppMethodBeat.o(69073);
      return 0;
    }
    AppMethodBeat.o(69073);
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(69074);
    Bankcard localBankcard = VS(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(69074);
      return paramView;
    }
    int i = getItemViewType(paramInt);
    boolean bool;
    if ((this.CWW == null) || (this.CWW.isEmpty()) || (localBankcard == null)) {
      bool = false;
    }
    for (;;)
    {
      ae.v("MicroMsg.BankcardListAdapter", "getView, pos: %d, bottom_wording: %s, showNew: %s", new Object[] { Integer.valueOf(paramInt), localBankcard.field_card_bottom_wording, Boolean.valueOf(bool) });
      switch (i)
      {
      default: 
        AppMethodBeat.o(69074);
        return paramView;
        paramViewGroup = this.CWW.iterator();
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
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131495911, this.CWV, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131495918, this.CWV, bool);
    AppMethodBeat.o(69074);
    return paramView;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, 2131495925, null);
      paramView = new a();
      paramView.CXc = ((ImageView)((View)localObject).findViewById(2131297121));
      paramView.CWY = ((TextView)((View)localObject).findViewById(2131297130));
      paramView.CXd = ((TextView)((View)localObject).findViewById(2131297158));
      paramView.CXg = ((ImageView)((View)localObject).findViewById(2131297160));
      paramView.CXh = ((ImageView)((View)localObject).findViewById(2131297161));
      paramView.CXi = ((ImageView)((View)localObject).findViewById(2131297162));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      switch (localBankcard.field_wxcreditState)
      {
      case 2: 
      default: 
        paramViewGroup.CXd.setVisibility(8);
      }
    }
    for (;;)
    {
      paramViewGroup.CWY.setText(localBankcard.field_bankName);
      this.CWV.a(this.mContext, localBankcard, paramViewGroup.CXc);
      AppMethodBeat.o(69074);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      paramViewGroup.CXd.setBackgroundResource(2131234633);
      paramViewGroup.CXd.setVisibility(0);
      continue;
      paramViewGroup.CXd.setBackgroundResource(2131234621);
      paramViewGroup.CXd.setVisibility(0);
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, 2131495922, null);
      paramView = new a();
      paramView.CXc = ((ImageView)((View)localObject).findViewById(2131297121));
      paramView.CWY = ((TextView)((View)localObject).findViewById(2131297130));
      paramView.CXf = ((TextView)((View)localObject).findViewById(2131302791));
      paramView.CXg = ((ImageView)((View)localObject).findViewById(2131297160));
      paramView.CXh = ((ImageView)((View)localObject).findViewById(2131297161));
      paramView.CXi = ((ImageView)((View)localObject).findViewById(2131297162));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.CWY.setText(this.mContext.getString(2131765310, new Object[] { localBankcard.field_bankName }));
      if (!b.b(localBankcard)) {
        break label702;
      }
      paramViewGroup.CXf.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(69074);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      label702:
      paramViewGroup.CXf.setVisibility(8);
    }
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131495923, this.CWV, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramView = View.inflate(this.mContext, 2131495912, null);
    AppMethodBeat.o(69074);
    return paramView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = View.inflate(this.mContext, 2131495916, null);
      paramViewGroup = new a();
      paramViewGroup.CXc = ((ImageView)paramView.findViewById(2131297121));
      paramViewGroup.CWY = ((TextView)paramView.findViewById(2131297130));
      paramViewGroup.CWZ = ((TextView)paramView.findViewById(2131297177));
      paramViewGroup.CXd = ((TextView)paramView.findViewById(2131297158));
      paramViewGroup.CXj = ((WalletTextView)paramView.findViewById(2131306685));
      paramViewGroup.CXb = ((ImageView)paramView.findViewById(2131297168));
      paramViewGroup.CXk = ((TextView)paramView.findViewById(2131306686));
      paramViewGroup.CXa = ((ViewGroup)paramView.findViewById(2131306688));
      paramView.setTag(paramViewGroup);
      paramViewGroup.CXc.setImageDrawable(com.tencent.mm.svg.a.a.g(this.mContext.getResources(), 2131690298));
      if (((paramViewGroup.CXc instanceof CdnImageView)) && (!bu.isNullOrNil(localBankcard.DmC)))
      {
        ((CdnImageView)paramViewGroup.CXc).setUseSdcardCache(true);
        ((CdnImageView)paramViewGroup.CXc).setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.eKI());
        ((CdnImageView)paramViewGroup.CXc).gk(localBankcard.DmC, 2131690298);
      }
      localObject = f.gX(f.zP(localBankcard.Dmy), 10);
      paramViewGroup.CWY.setText(k.b(this.mContext, (CharSequence)localObject, paramViewGroup.CWY.getTextSize()));
      paramViewGroup.CWZ.setText(localBankcard.DmB);
      if (localBankcard.Dmz != 0) {
        break label1159;
      }
      localObject = f.b(localBankcard.Dmx, "100", 2, RoundingMode.HALF_UP).toString();
      paramViewGroup.CXj.setPrefix(ah.fWc());
      paramViewGroup.CXj.setText((CharSequence)localObject);
      paramViewGroup.CXj.setVisibility(0);
      paramViewGroup.CXk.setVisibility(0);
    }
    for (;;)
    {
      if (al.isDarkMode())
      {
        paramViewGroup.CXa.setBackgroundResource(2131234626);
        paramViewGroup.CXb.setImageResource(2131690312);
      }
      AppMethodBeat.o(69074);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label1159:
      paramViewGroup.CXj.setVisibility(4);
      paramViewGroup.CXk.setVisibility(4);
    }
  }
  
  public int getViewTypeCount()
  {
    return 7;
  }
  
  final class a
  {
    public TextView CWX = null;
    public TextView CWY = null;
    public TextView CWZ = null;
    public ViewGroup CXa = null;
    public ImageView CXb = null;
    public ImageView CXc = null;
    public TextView CXd = null;
    public TextView CXe = null;
    public TextView CXf = null;
    public ImageView CXg = null;
    public ImageView CXh = null;
    public ImageView CXi = null;
    public WalletTextView CXj = null;
    public TextView CXk = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.a
 * JD-Core Version:    0.7.0.1
 */