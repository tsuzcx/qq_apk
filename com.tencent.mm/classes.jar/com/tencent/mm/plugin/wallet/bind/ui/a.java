package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.ai;
import com.tencent.mm.wallet_core.c.ah;
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
  private int mCount;
  private ArrayList<Bankcard> zME;
  private int zMF;
  com.tencent.mm.plugin.wallet_core.utils.a zMG;
  List<String> zMH;
  
  public a(Context paramContext, ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(69069);
    this.mCount = 0;
    this.mContext = paramContext;
    this.zME = paramArrayList;
    this.zMF = 0;
    this.zMG = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.zMG.b(this.mContext, this.zME);
    dZJ();
    AppMethodBeat.o(69069);
  }
  
  private Bankcard Rk(int paramInt)
  {
    AppMethodBeat.i(69072);
    if ((paramInt >= 0) && (paramInt < this.mCount))
    {
      Bankcard localBankcard = (Bankcard)this.zME.get(paramInt);
      AppMethodBeat.o(69072);
      return localBankcard;
    }
    AppMethodBeat.o(69072);
    return null;
  }
  
  private void dZJ()
  {
    AppMethodBeat.i(69071);
    g.afC();
    this.zMH = bt.S(((String)g.afB().afk().get(ae.a.Fqv, "")).split(","));
    AppMethodBeat.o(69071);
  }
  
  public final void au(ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(69070);
    this.zME = paramArrayList;
    if (paramArrayList != null) {}
    for (this.mCount = paramArrayList.size();; this.mCount = 0)
    {
      if (this.mCount > 0) {
        this.zMG.b(this.mContext, this.zME);
      }
      dZJ();
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
    Bankcard localBankcard = Rk(paramInt);
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
    if ((localBankcard.ebu()) && ("CITIC_CREDIT".equals(localBankcard.field_bankcardType)))
    {
      AppMethodBeat.o(69073);
      return 5;
    }
    if (localBankcard.ebz())
    {
      AppMethodBeat.o(69073);
      return 6;
    }
    if ((localBankcard.eby()) && (!u.aqV()))
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
    Bankcard localBankcard = Rk(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(69074);
      return paramView;
    }
    int i = getItemViewType(paramInt);
    boolean bool;
    if ((this.zMH == null) || (this.zMH.isEmpty()) || (localBankcard == null)) {
      bool = false;
    }
    for (;;)
    {
      ad.v("MicroMsg.BankcardListAdapter", "getView, pos: %d, bottom_wording: %s, showNew: %s", new Object[] { Integer.valueOf(paramInt), localBankcard.field_card_bottom_wording, Boolean.valueOf(bool) });
      switch (i)
      {
      default: 
        AppMethodBeat.o(69074);
        return paramView;
        paramViewGroup = this.zMH.iterator();
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
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131495911, this.zMG, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131495918, this.zMG, bool);
    AppMethodBeat.o(69074);
    return paramView;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, 2131495925, null);
      paramView = new a();
      paramView.zMN = ((ImageView)((View)localObject).findViewById(2131297121));
      paramView.zMJ = ((TextView)((View)localObject).findViewById(2131297130));
      paramView.zMO = ((TextView)((View)localObject).findViewById(2131297158));
      paramView.zMR = ((ImageView)((View)localObject).findViewById(2131297160));
      paramView.zMS = ((ImageView)((View)localObject).findViewById(2131297161));
      paramView.zMT = ((ImageView)((View)localObject).findViewById(2131297162));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      switch (localBankcard.field_wxcreditState)
      {
      case 2: 
      default: 
        paramViewGroup.zMO.setVisibility(8);
      }
    }
    for (;;)
    {
      paramViewGroup.zMJ.setText(localBankcard.field_bankName);
      this.zMG.a(this.mContext, localBankcard, paramViewGroup.zMN);
      AppMethodBeat.o(69074);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      paramViewGroup.zMO.setBackgroundResource(2131234633);
      paramViewGroup.zMO.setVisibility(0);
      continue;
      paramViewGroup.zMO.setBackgroundResource(2131234621);
      paramViewGroup.zMO.setVisibility(0);
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, 2131495922, null);
      paramView = new a();
      paramView.zMN = ((ImageView)((View)localObject).findViewById(2131297121));
      paramView.zMJ = ((TextView)((View)localObject).findViewById(2131297130));
      paramView.zMQ = ((TextView)((View)localObject).findViewById(2131302791));
      paramView.zMR = ((ImageView)((View)localObject).findViewById(2131297160));
      paramView.zMS = ((ImageView)((View)localObject).findViewById(2131297161));
      paramView.zMT = ((ImageView)((View)localObject).findViewById(2131297162));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.zMJ.setText(this.mContext.getString(2131765310, new Object[] { localBankcard.field_bankName }));
      if (!b.b(localBankcard)) {
        break label702;
      }
      paramViewGroup.zMQ.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(69074);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      label702:
      paramViewGroup.zMQ.setVisibility(8);
    }
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131495923, this.zMG, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramView = View.inflate(this.mContext, 2131495912, null);
    AppMethodBeat.o(69074);
    return paramView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = View.inflate(this.mContext, 2131495916, null);
      paramViewGroup = new a();
      paramViewGroup.zMN = ((ImageView)paramView.findViewById(2131297121));
      paramViewGroup.zMJ = ((TextView)paramView.findViewById(2131297130));
      paramViewGroup.zMK = ((TextView)paramView.findViewById(2131297177));
      paramViewGroup.zMO = ((TextView)paramView.findViewById(2131297158));
      paramViewGroup.zMU = ((WalletTextView)paramView.findViewById(2131306685));
      paramViewGroup.zMM = ((ImageView)paramView.findViewById(2131297168));
      paramViewGroup.zMV = ((TextView)paramView.findViewById(2131306686));
      paramViewGroup.zML = ((ViewGroup)paramView.findViewById(2131306688));
      paramView.setTag(paramViewGroup);
      paramViewGroup.zMN.setImageDrawable(com.tencent.mm.svg.a.a.g(this.mContext.getResources(), 2131690298));
      if (((paramViewGroup.zMN instanceof CdnImageView)) && (!bt.isNullOrNil(localBankcard.Acn)))
      {
        ((CdnImageView)paramViewGroup.zMN).setUseSdcardCache(true);
        ((CdnImageView)paramViewGroup.zMN).setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.edz());
        ((CdnImageView)paramViewGroup.zMN).fz(localBankcard.Acn, 2131690298);
      }
      localObject = com.tencent.mm.wallet_core.ui.e.gn(com.tencent.mm.wallet_core.ui.e.sh(localBankcard.Acj), 10);
      paramViewGroup.zMJ.setText(k.b(this.mContext, (CharSequence)localObject, paramViewGroup.zMJ.getTextSize()));
      paramViewGroup.zMK.setText(localBankcard.Acm);
      if (localBankcard.Ack != 0) {
        break label1159;
      }
      localObject = com.tencent.mm.wallet_core.ui.e.a(localBankcard.Aci, "100", 2, RoundingMode.HALF_UP).toString();
      paramViewGroup.zMU.setPrefix(ah.fkg());
      paramViewGroup.zMU.setText((CharSequence)localObject);
      paramViewGroup.zMU.setVisibility(0);
      paramViewGroup.zMV.setVisibility(0);
    }
    for (;;)
    {
      if (ai.Eq())
      {
        paramViewGroup.zML.setBackgroundResource(2131234626);
        paramViewGroup.zMM.setImageResource(2131690312);
      }
      AppMethodBeat.o(69074);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label1159:
      paramViewGroup.zMU.setVisibility(4);
      paramViewGroup.zMV.setVisibility(4);
    }
  }
  
  public int getViewTypeCount()
  {
    return 7;
  }
  
  final class a
  {
    public TextView zMI = null;
    public TextView zMJ = null;
    public TextView zMK = null;
    public ViewGroup zML = null;
    public ImageView zMM = null;
    public ImageView zMN = null;
    public TextView zMO = null;
    public TextView zMP = null;
    public TextView zMQ = null;
    public ImageView zMR = null;
    public ImageView zMS = null;
    public ImageView zMT = null;
    public WalletTextView zMU = null;
    public TextView zMV = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.a
 * JD-Core Version:    0.7.0.1
 */