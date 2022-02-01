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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.al;
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
  private ArrayList<Bankcard> CFn;
  private int CFo;
  com.tencent.mm.plugin.wallet_core.utils.a CFp;
  List<String> CFq;
  private final Context mContext;
  private int mCount;
  
  public a(Context paramContext, ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(69069);
    this.mCount = 0;
    this.mContext = paramContext;
    this.CFn = paramArrayList;
    this.CFo = 0;
    this.CFp = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.CFp.b(this.mContext, this.CFn);
    eDf();
    AppMethodBeat.o(69069);
  }
  
  private Bankcard Vl(int paramInt)
  {
    AppMethodBeat.i(69072);
    if ((paramInt >= 0) && (paramInt < this.mCount))
    {
      Bankcard localBankcard = (Bankcard)this.CFn.get(paramInt);
      AppMethodBeat.o(69072);
      return localBankcard;
    }
    AppMethodBeat.o(69072);
    return null;
  }
  
  private void eDf()
  {
    AppMethodBeat.i(69071);
    g.ajD();
    this.CFq = bt.U(((String)g.ajC().ajl().get(al.a.IAG, "")).split(","));
    AppMethodBeat.o(69071);
  }
  
  public final void aC(ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(69070);
    this.CFn = paramArrayList;
    if (paramArrayList != null) {}
    for (this.mCount = paramArrayList.size();; this.mCount = 0)
    {
      if (this.mCount > 0) {
        this.CFp.b(this.mContext, this.CFn);
      }
      eDf();
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
    Bankcard localBankcard = Vl(paramInt);
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
    if ((localBankcard.eEQ()) && ("CITIC_CREDIT".equals(localBankcard.field_bankcardType)))
    {
      AppMethodBeat.o(69073);
      return 5;
    }
    if (localBankcard.eEV())
    {
      AppMethodBeat.o(69073);
      return 6;
    }
    if ((localBankcard.eEU()) && (!u.aAB()))
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
    Bankcard localBankcard = Vl(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(69074);
      return paramView;
    }
    int i = getItemViewType(paramInt);
    boolean bool;
    if ((this.CFq == null) || (this.CFq.isEmpty()) || (localBankcard == null)) {
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
        paramViewGroup = this.CFq.iterator();
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
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131495911, this.CFp, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131495918, this.CFp, bool);
    AppMethodBeat.o(69074);
    return paramView;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, 2131495925, null);
      paramView = new a();
      paramView.CFw = ((ImageView)((View)localObject).findViewById(2131297121));
      paramView.CFs = ((TextView)((View)localObject).findViewById(2131297130));
      paramView.CFx = ((TextView)((View)localObject).findViewById(2131297158));
      paramView.CFA = ((ImageView)((View)localObject).findViewById(2131297160));
      paramView.CFB = ((ImageView)((View)localObject).findViewById(2131297161));
      paramView.CFC = ((ImageView)((View)localObject).findViewById(2131297162));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      switch (localBankcard.field_wxcreditState)
      {
      case 2: 
      default: 
        paramViewGroup.CFx.setVisibility(8);
      }
    }
    for (;;)
    {
      paramViewGroup.CFs.setText(localBankcard.field_bankName);
      this.CFp.a(this.mContext, localBankcard, paramViewGroup.CFw);
      AppMethodBeat.o(69074);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      paramViewGroup.CFx.setBackgroundResource(2131234633);
      paramViewGroup.CFx.setVisibility(0);
      continue;
      paramViewGroup.CFx.setBackgroundResource(2131234621);
      paramViewGroup.CFx.setVisibility(0);
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, 2131495922, null);
      paramView = new a();
      paramView.CFw = ((ImageView)((View)localObject).findViewById(2131297121));
      paramView.CFs = ((TextView)((View)localObject).findViewById(2131297130));
      paramView.CFz = ((TextView)((View)localObject).findViewById(2131302791));
      paramView.CFA = ((ImageView)((View)localObject).findViewById(2131297160));
      paramView.CFB = ((ImageView)((View)localObject).findViewById(2131297161));
      paramView.CFC = ((ImageView)((View)localObject).findViewById(2131297162));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.CFs.setText(this.mContext.getString(2131765310, new Object[] { localBankcard.field_bankName }));
      if (!b.b(localBankcard)) {
        break label702;
      }
      paramViewGroup.CFz.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(69074);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      label702:
      paramViewGroup.CFz.setVisibility(8);
    }
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2131495923, this.CFp, bool);
    AppMethodBeat.o(69074);
    return paramView;
    paramView = View.inflate(this.mContext, 2131495912, null);
    AppMethodBeat.o(69074);
    return paramView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = View.inflate(this.mContext, 2131495916, null);
      paramViewGroup = new a();
      paramViewGroup.CFw = ((ImageView)paramView.findViewById(2131297121));
      paramViewGroup.CFs = ((TextView)paramView.findViewById(2131297130));
      paramViewGroup.CFt = ((TextView)paramView.findViewById(2131297177));
      paramViewGroup.CFx = ((TextView)paramView.findViewById(2131297158));
      paramViewGroup.CFD = ((WalletTextView)paramView.findViewById(2131306685));
      paramViewGroup.CFv = ((ImageView)paramView.findViewById(2131297168));
      paramViewGroup.CFE = ((TextView)paramView.findViewById(2131306686));
      paramViewGroup.CFu = ((ViewGroup)paramView.findViewById(2131306688));
      paramView.setTag(paramViewGroup);
      paramViewGroup.CFw.setImageDrawable(com.tencent.mm.svg.a.a.g(this.mContext.getResources(), 2131690298));
      if (((paramViewGroup.CFw instanceof CdnImageView)) && (!bt.isNullOrNil(localBankcard.CUW)))
      {
        ((CdnImageView)paramViewGroup.CFw).setUseSdcardCache(true);
        ((CdnImageView)paramViewGroup.CFw).setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.eHa());
        ((CdnImageView)paramViewGroup.CFw).gb(localBankcard.CUW, 2131690298);
      }
      localObject = com.tencent.mm.wallet_core.ui.e.gO(com.tencent.mm.wallet_core.ui.e.zf(localBankcard.CUS), 10);
      paramViewGroup.CFs.setText(k.b(this.mContext, (CharSequence)localObject, paramViewGroup.CFs.getTextSize()));
      paramViewGroup.CFt.setText(localBankcard.CUV);
      if (localBankcard.CUT != 0) {
        break label1159;
      }
      localObject = com.tencent.mm.wallet_core.ui.e.b(localBankcard.CUR, "100", 2, RoundingMode.HALF_UP).toString();
      paramViewGroup.CFD.setPrefix(ah.fRG());
      paramViewGroup.CFD.setText((CharSequence)localObject);
      paramViewGroup.CFD.setVisibility(0);
      paramViewGroup.CFE.setVisibility(0);
    }
    for (;;)
    {
      if (al.isDarkMode())
      {
        paramViewGroup.CFu.setBackgroundResource(2131234626);
        paramViewGroup.CFv.setImageResource(2131690312);
      }
      AppMethodBeat.o(69074);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label1159:
      paramViewGroup.CFD.setVisibility(4);
      paramViewGroup.CFE.setVisibility(4);
    }
  }
  
  public int getViewTypeCount()
  {
    return 7;
  }
  
  final class a
  {
    public ImageView CFA = null;
    public ImageView CFB = null;
    public ImageView CFC = null;
    public WalletTextView CFD = null;
    public TextView CFE = null;
    public TextView CFr = null;
    public TextView CFs = null;
    public TextView CFt = null;
    public ViewGroup CFu = null;
    public ImageView CFv = null;
    public ImageView CFw = null;
    public TextView CFx = null;
    public TextView CFy = null;
    public TextView CFz = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.a
 * JD-Core Version:    0.7.0.1
 */