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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.aj;
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
  private ArrayList<Bankcard> BeY;
  private int BeZ;
  com.tencent.mm.plugin.wallet_core.utils.a Bfa;
  List<String> Bfb;
  private final Context mContext;
  private int mCount;
  
  public a(Context paramContext, ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(69069);
    this.mCount = 0;
    this.mContext = paramContext;
    this.BeY = paramArrayList;
    this.BeZ = 0;
    this.Bfa = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.Bfa.b(this.mContext, this.BeY);
    epf();
    AppMethodBeat.o(69069);
  }
  
  private Bankcard Tt(int paramInt)
  {
    AppMethodBeat.i(69072);
    if ((paramInt >= 0) && (paramInt < this.mCount))
    {
      Bankcard localBankcard = (Bankcard)this.BeY.get(paramInt);
      AppMethodBeat.o(69072);
      return localBankcard;
    }
    AppMethodBeat.o(69072);
    return null;
  }
  
  private void epf()
  {
    AppMethodBeat.i(69071);
    g.agS();
    this.Bfb = bs.S(((String)g.agR().agA().get(ah.a.GOl, "")).split(","));
    AppMethodBeat.o(69071);
  }
  
  public final void aG(ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(69070);
    this.BeY = paramArrayList;
    if (paramArrayList != null) {}
    for (this.mCount = paramArrayList.size();; this.mCount = 0)
    {
      if (this.mCount > 0) {
        this.Bfa.b(this.mContext, this.BeY);
      }
      epf();
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
    Bankcard localBankcard = Tt(paramInt);
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
    if ((localBankcard.eqQ()) && ("CITIC_CREDIT".equals(localBankcard.field_bankcardType)))
    {
      AppMethodBeat.o(69073);
      return 5;
    }
    if (localBankcard.eqV())
    {
      AppMethodBeat.o(69073);
      return 6;
    }
    if ((localBankcard.eqU()) && (!u.axL()))
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
    Bankcard localBankcard = Tt(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(69074);
      return paramView;
    }
    int i = getItemViewType(paramInt);
    boolean bool;
    if ((this.Bfb == null) || (this.Bfb.isEmpty()) || (localBankcard == null)) {
      bool = false;
    }
    for (;;)
    {
      ac.v("MicroMsg.BankcardListAdapter", "getView, pos: %d, bottom_wording: %s, showNew: %s", new Object[] { Integer.valueOf(paramInt), localBankcard.field_card_bottom_wording, Boolean.valueOf(bool) });
      switch (i)
      {
      default: 
        AppMethodBeat.o(69074);
        return paramView;
        paramViewGroup = this.Bfb.iterator();
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
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131495911, this.Bfa, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131495918, this.Bfa, bool);
    AppMethodBeat.o(69074);
    return paramView;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, 2131495925, null);
      paramView = new a();
      paramView.Bfh = ((ImageView)((View)localObject).findViewById(2131297121));
      paramView.Bfd = ((TextView)((View)localObject).findViewById(2131297130));
      paramView.Bfi = ((TextView)((View)localObject).findViewById(2131297158));
      paramView.Bfl = ((ImageView)((View)localObject).findViewById(2131297160));
      paramView.Bfm = ((ImageView)((View)localObject).findViewById(2131297161));
      paramView.Bfn = ((ImageView)((View)localObject).findViewById(2131297162));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      switch (localBankcard.field_wxcreditState)
      {
      case 2: 
      default: 
        paramViewGroup.Bfi.setVisibility(8);
      }
    }
    for (;;)
    {
      paramViewGroup.Bfd.setText(localBankcard.field_bankName);
      this.Bfa.a(this.mContext, localBankcard, paramViewGroup.Bfh);
      AppMethodBeat.o(69074);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      paramViewGroup.Bfi.setBackgroundResource(2131234633);
      paramViewGroup.Bfi.setVisibility(0);
      continue;
      paramViewGroup.Bfi.setBackgroundResource(2131234621);
      paramViewGroup.Bfi.setVisibility(0);
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, 2131495922, null);
      paramView = new a();
      paramView.Bfh = ((ImageView)((View)localObject).findViewById(2131297121));
      paramView.Bfd = ((TextView)((View)localObject).findViewById(2131297130));
      paramView.Bfk = ((TextView)((View)localObject).findViewById(2131302791));
      paramView.Bfl = ((ImageView)((View)localObject).findViewById(2131297160));
      paramView.Bfm = ((ImageView)((View)localObject).findViewById(2131297161));
      paramView.Bfn = ((ImageView)((View)localObject).findViewById(2131297162));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.Bfd.setText(this.mContext.getString(2131765310, new Object[] { localBankcard.field_bankName }));
      if (!b.b(localBankcard)) {
        break label702;
      }
      paramViewGroup.Bfk.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(69074);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      label702:
      paramViewGroup.Bfk.setVisibility(8);
    }
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131495923, this.Bfa, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramView = View.inflate(this.mContext, 2131495912, null);
    AppMethodBeat.o(69074);
    return paramView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = View.inflate(this.mContext, 2131495916, null);
      paramViewGroup = new a();
      paramViewGroup.Bfh = ((ImageView)paramView.findViewById(2131297121));
      paramViewGroup.Bfd = ((TextView)paramView.findViewById(2131297130));
      paramViewGroup.Bfe = ((TextView)paramView.findViewById(2131297177));
      paramViewGroup.Bfi = ((TextView)paramView.findViewById(2131297158));
      paramViewGroup.Bfo = ((WalletTextView)paramView.findViewById(2131306685));
      paramViewGroup.Bfg = ((ImageView)paramView.findViewById(2131297168));
      paramViewGroup.Bfp = ((TextView)paramView.findViewById(2131306686));
      paramViewGroup.Bff = ((ViewGroup)paramView.findViewById(2131306688));
      paramView.setTag(paramViewGroup);
      paramViewGroup.Bfh.setImageDrawable(com.tencent.mm.svg.a.a.g(this.mContext.getResources(), 2131690298));
      if (((paramViewGroup.Bfh instanceof CdnImageView)) && (!bs.isNullOrNil(localBankcard.BuH)))
      {
        ((CdnImageView)paramViewGroup.Bfh).setUseSdcardCache(true);
        ((CdnImageView)paramViewGroup.Bfh).setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.esU());
        ((CdnImageView)paramViewGroup.Bfh).fE(localBankcard.BuH, 2131690298);
      }
      localObject = com.tencent.mm.wallet_core.ui.e.gr(com.tencent.mm.wallet_core.ui.e.wk(localBankcard.BuD), 10);
      paramViewGroup.Bfd.setText(k.b(this.mContext, (CharSequence)localObject, paramViewGroup.Bfd.getTextSize()));
      paramViewGroup.Bfe.setText(localBankcard.BuG);
      if (localBankcard.BuE != 0) {
        break label1159;
      }
      localObject = com.tencent.mm.wallet_core.ui.e.a(localBankcard.BuC, "100", 2, RoundingMode.HALF_UP).toString();
      paramViewGroup.Bfo.setPrefix(ah.fAw());
      paramViewGroup.Bfo.setText((CharSequence)localObject);
      paramViewGroup.Bfo.setVisibility(0);
      paramViewGroup.Bfp.setVisibility(0);
    }
    for (;;)
    {
      if (aj.DT())
      {
        paramViewGroup.Bff.setBackgroundResource(2131234626);
        paramViewGroup.Bfg.setImageResource(2131690312);
      }
      AppMethodBeat.o(69074);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label1159:
      paramViewGroup.Bfo.setVisibility(4);
      paramViewGroup.Bfp.setVisibility(4);
    }
  }
  
  public int getViewTypeCount()
  {
    return 7;
  }
  
  final class a
  {
    public TextView Bfc = null;
    public TextView Bfd = null;
    public TextView Bfe = null;
    public ViewGroup Bff = null;
    public ImageView Bfg = null;
    public ImageView Bfh = null;
    public TextView Bfi = null;
    public TextView Bfj = null;
    public TextView Bfk = null;
    public ImageView Bfl = null;
    public ImageView Bfm = null;
    public ImageView Bfn = null;
    public WalletTextView Bfo = null;
    public TextView Bfp = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.a
 * JD-Core Version:    0.7.0.1
 */