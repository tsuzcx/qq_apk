package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.ae;
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
  private ArrayList<Bankcard> tSw;
  private int tSx;
  com.tencent.mm.plugin.wallet_core.utils.a tSy;
  List<String> tSz;
  
  public a(Context paramContext, ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(45732);
    this.mCount = 0;
    this.mContext = paramContext;
    this.tSw = paramArrayList;
    this.tSx = 0;
    this.tSy = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.tSy.b(this.mContext, this.tSw);
    cRw();
    AppMethodBeat.o(45732);
  }
  
  private Bankcard Il(int paramInt)
  {
    AppMethodBeat.i(45735);
    if ((paramInt >= 0) && (paramInt < this.mCount))
    {
      Bankcard localBankcard = (Bankcard)this.tSw.get(paramInt);
      AppMethodBeat.o(45735);
      return localBankcard;
    }
    AppMethodBeat.o(45735);
    return null;
  }
  
  private void cRw()
  {
    AppMethodBeat.i(45734);
    g.RM();
    this.tSz = bo.P(((String)g.RL().Ru().get(ac.a.yHC, "")).split(","));
    AppMethodBeat.o(45734);
  }
  
  public final void W(ArrayList<Bankcard> paramArrayList)
  {
    AppMethodBeat.i(45733);
    this.tSw = paramArrayList;
    if (paramArrayList != null) {}
    for (this.mCount = paramArrayList.size();; this.mCount = 0)
    {
      if (this.mCount > 0) {
        this.tSy.b(this.mContext, this.tSw);
      }
      cRw();
      AppMethodBeat.o(45733);
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
    AppMethodBeat.i(45736);
    Bankcard localBankcard = Il(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(45736);
      return 4;
    }
    if (localBankcard.field_bankcardState == 9)
    {
      if (localBankcard.field_wxcreditState == 0)
      {
        AppMethodBeat.o(45736);
        return 2;
      }
      AppMethodBeat.o(45736);
      return 3;
    }
    if ((localBankcard.cTe()) && ("CITIC_CREDIT".equals(localBankcard.field_bankcardType)))
    {
      AppMethodBeat.o(45736);
      return 5;
    }
    if (localBankcard.cTj())
    {
      AppMethodBeat.o(45736);
      return 6;
    }
    if ((localBankcard.cTi()) && (!r.ZB()))
    {
      AppMethodBeat.o(45736);
      return 0;
    }
    AppMethodBeat.o(45736);
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(45737);
    Bankcard localBankcard = Il(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(45737);
      return paramView;
    }
    int i = getItemViewType(paramInt);
    boolean bool;
    if ((this.tSz == null) || (this.tSz.isEmpty()) || (localBankcard == null)) {
      bool = false;
    }
    for (;;)
    {
      ab.v("MicroMsg.BankcardListAdapter", "getView, pos: %d, bottom_wording: %s, showNew: %s", new Object[] { Integer.valueOf(paramInt), localBankcard.field_card_bottom_wording, Boolean.valueOf(bool) });
      switch (i)
      {
      default: 
        AppMethodBeat.o(45737);
        return paramView;
        paramViewGroup = this.tSz.iterator();
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
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2130971137, this.tSy, bool);
    AppMethodBeat.o(45737);
    return paramView;
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2130971144, this.tSy, bool);
    AppMethodBeat.o(45737);
    return paramView;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, 2130971151, null);
      paramView = new a.a(this);
      paramView.tSF = ((ImageView)((View)localObject).findViewById(2131828979));
      paramView.tSB = ((TextView)((View)localObject).findViewById(2131828980));
      paramView.tSG = ((TextView)((View)localObject).findViewById(2131828987));
      paramView.tSJ = ((ImageView)((View)localObject).findViewById(2131828982));
      paramView.tSK = ((ImageView)((View)localObject).findViewById(2131828983));
      paramView.tSL = ((ImageView)((View)localObject).findViewById(2131828984));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      switch (localBankcard.field_wxcreditState)
      {
      case 2: 
      default: 
        paramViewGroup.tSG.setVisibility(8);
      }
    }
    for (;;)
    {
      paramViewGroup.tSB.setText(localBankcard.field_bankName);
      this.tSy.a(this.mContext, localBankcard, paramViewGroup.tSF);
      AppMethodBeat.o(45737);
      return localObject;
      paramViewGroup = (a.a)paramView.getTag();
      localObject = paramView;
      break;
      paramViewGroup.tSG.setBackgroundResource(2130840812);
      paramViewGroup.tSG.setVisibility(0);
      continue;
      paramViewGroup.tSG.setBackgroundResource(2130840802);
      paramViewGroup.tSG.setVisibility(0);
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject = View.inflate(this.mContext, 2130971148, null);
      paramView = new a.a(this);
      paramView.tSF = ((ImageView)((View)localObject).findViewById(2131828979));
      paramView.tSB = ((TextView)((View)localObject).findViewById(2131828980));
      paramView.tSI = ((TextView)((View)localObject).findViewById(2131829030));
      paramView.tSJ = ((ImageView)((View)localObject).findViewById(2131828982));
      paramView.tSK = ((ImageView)((View)localObject).findViewById(2131828983));
      paramView.tSL = ((ImageView)((View)localObject).findViewById(2131828984));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.tSB.setText(this.mContext.getString(2131305118, new Object[] { localBankcard.field_bankName }));
      if (!b.b(localBankcard)) {
        break label702;
      }
      paramViewGroup.tSI.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(45737);
      return localObject;
      paramViewGroup = (a.a)paramView.getTag();
      localObject = paramView;
      break;
      label702:
      paramViewGroup.tSI.setVisibility(8);
    }
    paramView = com.tencent.mm.plugin.wallet_core.ui.view.b.a(this.mContext, paramView, localBankcard, 2130971149, this.tSy, bool);
    AppMethodBeat.o(45737);
    return paramView;
    paramView = View.inflate(this.mContext, 2130971138, null);
    AppMethodBeat.o(45737);
    return paramView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = View.inflate(this.mContext, 2130971142, null);
      paramViewGroup = new a.a(this);
      paramViewGroup.tSF = ((ImageView)paramView.findViewById(2131828979));
      paramViewGroup.tSB = ((TextView)paramView.findViewById(2131828980));
      paramViewGroup.tSC = ((TextView)paramView.findViewById(2131828981));
      paramViewGroup.tSG = ((TextView)paramView.findViewById(2131828987));
      paramViewGroup.tSM = ((WalletTextView)paramView.findViewById(2131829011));
      paramViewGroup.tSE = ((ImageView)paramView.findViewById(2131828978));
      paramViewGroup.tSN = ((TextView)paramView.findViewById(2131829012));
      paramView.setTag(paramViewGroup);
      paramViewGroup.tSF.setImageDrawable(com.tencent.mm.svg.a.a.g(this.mContext.getResources(), 2131231407));
      if (((paramViewGroup.tSF instanceof CdnImageView)) && (!bo.isNullOrNil(localBankcard.uge)))
      {
        ((CdnImageView)paramViewGroup.tSF).setUseSdcardCache(true);
        ((CdnImageView)paramViewGroup.tSF).setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.cVf());
        ((CdnImageView)paramViewGroup.tSF).eq(localBankcard.uge, 2131231407);
      }
      localObject = com.tencent.mm.wallet_core.ui.e.eZ(com.tencent.mm.wallet_core.ui.e.nE(localBankcard.uga), 10);
      paramViewGroup.tSB.setText(j.b(this.mContext, (CharSequence)localObject, paramViewGroup.tSB.getTextSize()));
      paramViewGroup.tSC.setText(localBankcard.ugd);
      if (localBankcard.ugb != 0) {
        break label1119;
      }
      localObject = com.tencent.mm.wallet_core.ui.e.a(localBankcard.ufZ, "100", 2, RoundingMode.HALF_UP).toString();
      paramViewGroup.tSM.setPrefix(ae.dSz());
      paramViewGroup.tSM.setText((CharSequence)localObject);
      paramViewGroup.tSM.setVisibility(0);
      paramViewGroup.tSN.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(45737);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label1119:
      paramViewGroup.tSM.setVisibility(4);
      paramViewGroup.tSN.setVisibility(4);
    }
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