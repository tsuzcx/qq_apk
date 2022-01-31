package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class i
  extends BaseAdapter
{
  private Context mContext;
  private Orders qrf;
  protected ArrayList<Bankcard> tNG;
  private com.tencent.mm.plugin.wallet_core.utils.a tSy;
  private int tVN;
  public boolean upA;
  private boolean upB;
  private int upy;
  public String upz;
  
  public i(Context paramContext, ArrayList<Bankcard> paramArrayList, int paramInt, Orders paramOrders)
  {
    AppMethodBeat.i(47313);
    this.qrf = null;
    this.upy = -1;
    this.upz = "";
    this.upA = true;
    this.upB = false;
    this.mContext = paramContext;
    this.tNG = paramArrayList;
    this.tVN = paramInt;
    this.qrf = paramOrders;
    this.tSy = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.tSy.b(this.mContext, this.tNG);
    if ((paramOrders != null) && (paramOrders.ujt == 1)) {
      this.upB = true;
    }
    AppMethodBeat.o(47313);
  }
  
  private LinkedList<String> g(Bankcard paramBankcard)
  {
    AppMethodBeat.i(47318);
    LinkedList localLinkedList = new LinkedList();
    if ((this.qrf != null) && (this.qrf.ujm != null) && (this.qrf.ujm.tUq != null))
    {
      Iterator localIterator = this.qrf.ujm.tUq.tTL.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.por.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.tTW.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).qiO);
          }
          AppMethodBeat.o(47318);
          return localLinkedList;
        }
      }
    }
    AppMethodBeat.o(47318);
    return localLinkedList;
  }
  
  public Bankcard Il(int paramInt)
  {
    AppMethodBeat.i(47315);
    Bankcard localBankcard;
    if (this.upB)
    {
      localBankcard = (Bankcard)this.tNG.get(paramInt);
      AppMethodBeat.o(47315);
      return localBankcard;
    }
    int j = getCount();
    int i;
    if (this.qrf != null)
    {
      i = j;
      if (this.qrf.ujh.equals("CFT")) {}
    }
    else
    {
      i = j - 1;
    }
    if (paramInt < i)
    {
      localBankcard = (Bankcard)this.tNG.get(paramInt);
      AppMethodBeat.o(47315);
      return localBankcard;
    }
    AppMethodBeat.o(47315);
    return null;
  }
  
  public final void g(ArrayList<Bankcard> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(47319);
    if (paramArrayList == null) {}
    for (this.tNG = new ArrayList();; this.tNG = paramArrayList)
    {
      this.upA = paramBoolean;
      if (this.tNG.size() > 0) {
        this.tSy.b(this.mContext, this.tNG);
      }
      notifyDataSetChanged();
      AppMethodBeat.o(47319);
      return;
    }
  }
  
  public int getCount()
  {
    int i = 0;
    AppMethodBeat.i(47314);
    if (this.upB)
    {
      if (this.tNG == null)
      {
        AppMethodBeat.o(47314);
        return 0;
      }
      i = this.tNG.size();
      AppMethodBeat.o(47314);
      return i;
    }
    if ((this.qrf != null) && (this.qrf.ujh.equals("CFT"))) {}
    for (;;)
    {
      if (this.tNG != null)
      {
        int j = this.tNG.size();
        AppMethodBeat.o(47314);
        return i + j;
      }
      AppMethodBeat.o(47314);
      return i;
      i = 1;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(47317);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2130971160, null);
      paramViewGroup = new i.a(this);
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131820680));
      paramViewGroup.pAD = ((TextView)paramView.findViewById(2131821890));
      paramViewGroup.upE = ((CheckedTextView)paramView.findViewById(2131826235));
      paramViewGroup.upF = ((CdnImageView)paramView.findViewById(2131828979));
      paramViewGroup.upD = ((FavourLayout)paramView.findViewById(2131829080));
      paramViewGroup.pAD.setText("");
      paramView.setTag(paramViewGroup);
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      paramViewGroup.pAD.setTextColor(ah.getResources().getColor(2131690168));
      paramViewGroup.upD.setVisibility(8);
      localObject1 = Il(paramInt);
      if (localObject1 != null) {
        break label342;
      }
      paramViewGroup.upE.setVisibility(4);
      paramViewGroup.pAD.setVisibility(8);
      paramViewGroup.titleTv.setText(2131305446);
      paramViewGroup.upF.setVisibility(8);
      localObject1 = new LinkedList();
      if ((this.qrf == null) || (this.qrf.ujm == null) || (this.qrf.ujm.tUq == null)) {
        break label339;
      }
      localObject2 = this.qrf.ujm.tUq.tTM;
      if (localObject2 == null) {
        break label339;
      }
      localObject2 = ((n)localObject2).tUD.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(((o)((Iterator)localObject2).next()).qiO);
      }
      paramViewGroup = (i.a)paramView.getTag();
    }
    if ((this.upA) && (((LinkedList)localObject1).size() > 0))
    {
      paramViewGroup.upD.setVisibility(0);
      paramViewGroup.pAD.setVisibility(8);
      paramViewGroup.upD.setWording((LinkedList)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(47317);
      return paramView;
      label339:
      break;
      label342:
      paramViewGroup.upF.setVisibility(0);
      paramViewGroup.upE.setVisibility(0);
      paramViewGroup.pAD.setVisibility(0);
      paramViewGroup.pAD.setText("");
      if (((Bankcard)localObject1).cTj())
      {
        paramViewGroup.titleTv.setText(j.b(this.mContext, ((Bankcard)localObject1).field_desc, paramViewGroup.titleTv.getTextSize()));
        label409:
        if (!((Bankcard)localObject1).cTf()) {
          break label902;
        }
        localObject2 = t.cTN().tOD;
        if (bo.isNullOrNil(((Bankcard)localObject2).ufN)) {
          break label837;
        }
        paramViewGroup.titleTv.setText(((Bankcard)localObject2).ufN);
        label448:
        paramViewGroup.pAD.setVisibility(0);
        switch (((Bankcard)localObject1).a(this.tVN, this.qrf))
        {
        default: 
          if (!bo.isNullOrNil(((Bankcard)localObject1).field_tips))
          {
            paramViewGroup.pAD.setText(((Bankcard)localObject1).field_tips);
            label539:
            localObject2 = paramViewGroup.pAD.getText().toString();
            paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131690322));
            if (!this.upz.equalsIgnoreCase(((Bankcard)localObject1).field_bindSerial)) {
              break label1119;
            }
            paramViewGroup.upE.setChecked(true);
            paramViewGroup.upE.setEnabled(true);
            label604:
            paramViewGroup.upF.setTag(2131820690, null);
            paramViewGroup.upF.setTag(null);
            paramViewGroup.upF.setImageDrawable(null);
            paramViewGroup.pAD.setOnClickListener(null);
            if (!((Bankcard)localObject1).cTf()) {
              break label1184;
            }
            com.tencent.mm.plugin.wallet_core.utils.a.k(paramViewGroup.upF);
          }
          break;
        }
      }
      for (;;)
      {
        if ((bo.isNullOrNil(((Bankcard)localObject1).field_forbid_title)) || (bo.isNullOrNil(((Bankcard)localObject1).field_forbid_url))) {
          break label1299;
        }
        localObject2 = (String)localObject2 + "  ";
        SpannableString localSpannableString = new SpannableString((String)localObject2 + ((Bankcard)localObject1).field_forbid_title);
        paramViewGroup.pAD.setOnClickListener(new i.1(this));
        paramInt = ((String)localObject2).length();
        int i = ((String)localObject2).length();
        int j = ((Bankcard)localObject1).field_forbid_title.length();
        localSpannableString.setSpan(new ForegroundColorSpan(ah.getResources().getColor(2131690641)), paramInt, i + j, 34);
        paramViewGroup.pAD.setText(localSpannableString);
        paramViewGroup.pAD.setTag(((Bankcard)localObject1).field_forbid_url);
        break;
        paramViewGroup.titleTv.setText(((Bankcard)localObject1).field_desc);
        break label409;
        label837:
        if (((Bankcard)localObject2).ufM >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(ae.dSD(), new Object[] { e.F(((Bankcard)localObject2).ufM) }));
          break label448;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(2131305111));
        break label448;
        label902:
        if (!((Bankcard)localObject1).cTg()) {
          break label448;
        }
        if (!bo.isNullOrNil(((Bankcard)localObject1).ufN))
        {
          paramViewGroup.titleTv.setText(((Bankcard)localObject1).ufN);
          break label448;
        }
        if (((Bankcard)localObject1).ufM >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(2131305186, new Object[] { e.F(((Bankcard)localObject1).ufM) }));
          break label448;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(2131305111));
        break label448;
        paramViewGroup.pAD.setText(((Bankcard)localObject1).field_forbidWord);
        break label539;
        paramViewGroup.pAD.setText(2131305452);
        break label539;
        paramViewGroup.pAD.setText(2131305463);
        break label539;
        paramViewGroup.pAD.setText(2131305458);
        break label539;
        paramViewGroup.pAD.setText(2131305454);
        break label539;
        paramViewGroup.pAD.setText(2131305450);
        break label539;
        paramViewGroup.pAD.setText(2131305456);
        break label539;
        paramViewGroup.pAD.setText(2131305461);
        break label539;
        paramViewGroup.pAD.setVisibility(8);
        break label539;
        label1119:
        if (isEnabled(paramInt))
        {
          paramViewGroup.upE.setChecked(false);
          paramViewGroup.upE.setEnabled(true);
          break label604;
        }
        paramViewGroup.upE.setEnabled(false);
        paramViewGroup.upE.setChecked(false);
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131690168));
        break label604;
        label1184:
        if (((Bankcard)localObject1).cTg())
        {
          this.tSy.a((Bankcard)localObject1, paramViewGroup.upF);
        }
        else if (((Bankcard)localObject1).cTj())
        {
          paramViewGroup.upF.setImageDrawable(com.tencent.mm.svg.a.a.g(ah.getResources(), 2131231407));
          if (!bo.isNullOrNil(((Bankcard)localObject1).uge))
          {
            paramViewGroup.upF.setUseSdcardCache(true);
            paramViewGroup.upF.setImgSavedPath(b.cVf());
            paramViewGroup.upF.eq(((Bankcard)localObject1).uge, 2131231407);
          }
        }
        else
        {
          this.tSy.a(this.mContext, (Bankcard)localObject1, paramViewGroup.upF);
        }
      }
      label1299:
      if ((this.upA) && (bo.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) && (bo.isNullOrNil((String)localObject2)))
      {
        localObject1 = g((Bankcard)localObject1);
        if (((LinkedList)localObject1).size() > 0)
        {
          paramViewGroup.upD.setVisibility(0);
          paramViewGroup.pAD.setVisibility(8);
          paramViewGroup.upD.setWording((LinkedList)localObject1);
        }
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(47316);
    Bankcard localBankcard = Il(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(47316);
      return true;
    }
    if (localBankcard.a(this.tVN, this.qrf) != 0)
    {
      AppMethodBeat.o(47316);
      return false;
    }
    AppMethodBeat.o(47316);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.i
 * JD-Core Version:    0.7.0.1
 */