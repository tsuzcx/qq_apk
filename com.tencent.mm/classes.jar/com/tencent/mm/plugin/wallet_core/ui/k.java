package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class k
  extends BaseAdapter
{
  private int Amt;
  public String Amu;
  public boolean Amv;
  private boolean Amw;
  private Context mContext;
  private Orders vIq;
  protected ArrayList<Bankcard> zGg;
  private com.tencent.mm.plugin.wallet_core.utils.a zMG;
  private int zQa;
  
  public k(Context paramContext, ArrayList<Bankcard> paramArrayList, int paramInt, Orders paramOrders)
  {
    AppMethodBeat.i(70876);
    this.vIq = null;
    this.Amt = -1;
    this.Amu = "";
    this.Amv = true;
    this.Amw = false;
    this.mContext = paramContext;
    this.zGg = paramArrayList;
    this.zQa = paramInt;
    this.vIq = paramOrders;
    this.zMG = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.zMG.b(this.mContext, this.zGg);
    if ((paramOrders != null) && (paramOrders.AfF == 1)) {
      this.Amw = true;
    }
    AppMethodBeat.o(70876);
  }
  
  private LinkedList<String> g(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70881);
    LinkedList localLinkedList = new LinkedList();
    if ((this.vIq != null) && (this.vIq.Afy != null) && (this.vIq.Afy.zOC != null))
    {
      Iterator localIterator = this.vIq.Afy.zOC.zNX.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.uns.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.zOi.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).vzN);
          }
          AppMethodBeat.o(70881);
          return localLinkedList;
        }
      }
    }
    AppMethodBeat.o(70881);
    return localLinkedList;
  }
  
  public Bankcard Rk(int paramInt)
  {
    AppMethodBeat.i(70878);
    Bankcard localBankcard;
    if (this.Amw)
    {
      localBankcard = (Bankcard)this.zGg.get(paramInt);
      AppMethodBeat.o(70878);
      return localBankcard;
    }
    int j = getCount();
    int i;
    if (this.vIq != null)
    {
      i = j;
      if (this.vIq.Afs.equals("CFT")) {}
    }
    else
    {
      i = j - 1;
    }
    if (paramInt < i)
    {
      localBankcard = (Bankcard)this.zGg.get(paramInt);
      AppMethodBeat.o(70878);
      return localBankcard;
    }
    AppMethodBeat.o(70878);
    return null;
  }
  
  public final void f(ArrayList<Bankcard> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(70882);
    if (paramArrayList == null) {}
    for (this.zGg = new ArrayList();; this.zGg = paramArrayList)
    {
      this.Amv = paramBoolean;
      if (this.zGg.size() > 0) {
        this.zMG.b(this.mContext, this.zGg);
      }
      notifyDataSetChanged();
      AppMethodBeat.o(70882);
      return;
    }
  }
  
  public int getCount()
  {
    int i = 0;
    AppMethodBeat.i(70877);
    if (this.Amw)
    {
      if (this.zGg == null)
      {
        AppMethodBeat.o(70877);
        return 0;
      }
      i = this.zGg.size();
      AppMethodBeat.o(70877);
      return i;
    }
    if ((this.vIq != null) && (this.vIq.Afs.equals("CFT"))) {}
    for (;;)
    {
      if (this.zGg != null)
      {
        int j = this.zGg.size();
        AppMethodBeat.o(70877);
        return i + j;
      }
      AppMethodBeat.o(70877);
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
    AppMethodBeat.i(70880);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2131495934, null);
      paramViewGroup = new a();
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131305902));
      paramViewGroup.uCm = ((TextView)paramView.findViewById(2131305546));
      paramViewGroup.Amz = ((CheckedTextView)paramView.findViewById(2131298214));
      paramViewGroup.AmA = ((CdnImageView)paramView.findViewById(2131297121));
      paramViewGroup.Amy = ((FavourLayout)paramView.findViewById(2131299869));
      paramViewGroup.uCm.setText("");
      paramView.setTag(paramViewGroup);
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      paramViewGroup.uCm.setTextColor(aj.getResources().getColor(2131100490));
      paramViewGroup.Amy.setVisibility(8);
      localObject1 = Rk(paramInt);
      if (localObject1 != null) {
        break label343;
      }
      paramViewGroup.Amz.setVisibility(4);
      paramViewGroup.uCm.setVisibility(8);
      paramViewGroup.titleTv.setText(2131765660);
      paramViewGroup.AmA.setVisibility(8);
      localObject1 = new LinkedList();
      if ((this.vIq == null) || (this.vIq.Afy == null) || (this.vIq.Afy.zOC == null)) {
        break label340;
      }
      localObject2 = this.vIq.Afy.zOC.zNY;
      if (localObject2 == null) {
        break label340;
      }
      localObject2 = ((n)localObject2).zOO.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(((o)((Iterator)localObject2).next()).vzN);
      }
      paramViewGroup = (a)paramView.getTag();
    }
    if ((this.Amv) && (((LinkedList)localObject1).size() > 0))
    {
      paramViewGroup.Amy.setVisibility(0);
      paramViewGroup.uCm.setVisibility(8);
      paramViewGroup.Amy.setWording((LinkedList)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(70880);
      return paramView;
      label340:
      break;
      label343:
      paramViewGroup.AmA.setVisibility(0);
      paramViewGroup.Amz.setVisibility(0);
      paramViewGroup.uCm.setVisibility(0);
      paramViewGroup.uCm.setText("");
      if (((Bankcard)localObject1).ebz())
      {
        paramViewGroup.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, ((Bankcard)localObject1).field_desc, paramViewGroup.titleTv.getTextSize()));
        label410:
        if (!((Bankcard)localObject1).ebv()) {
          break label902;
        }
        localObject2 = s.ecc().zHd;
        if (bt.isNullOrNil(((Bankcard)localObject2).AbV)) {
          break label837;
        }
        paramViewGroup.titleTv.setText(((Bankcard)localObject2).AbV);
        label449:
        paramViewGroup.uCm.setVisibility(0);
        switch (((Bankcard)localObject1).a(this.zQa, this.vIq))
        {
        default: 
          if (!bt.isNullOrNil(((Bankcard)localObject1).field_tips))
          {
            paramViewGroup.uCm.setText(((Bankcard)localObject1).field_tips);
            label539:
            localObject2 = paramViewGroup.uCm.getText().toString();
            paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100711));
            if (!this.Amu.equalsIgnoreCase(((Bankcard)localObject1).field_bindSerial)) {
              break label1119;
            }
            paramViewGroup.Amz.setChecked(true);
            paramViewGroup.Amz.setEnabled(true);
            label604:
            paramViewGroup.AmA.setTag(2131306720, null);
            paramViewGroup.AmA.setTag(null);
            paramViewGroup.AmA.setImageDrawable(null);
            paramViewGroup.uCm.setOnClickListener(null);
            if (!((Bankcard)localObject1).ebv()) {
              break label1184;
            }
            com.tencent.mm.plugin.wallet_core.utils.a.j(paramViewGroup.AmA);
          }
          break;
        }
      }
      for (;;)
      {
        if ((bt.isNullOrNil(((Bankcard)localObject1).field_forbid_title)) || (bt.isNullOrNil(((Bankcard)localObject1).field_forbid_url))) {
          break label1299;
        }
        localObject2 = (String)localObject2 + "  ";
        SpannableString localSpannableString = new SpannableString((String)localObject2 + ((Bankcard)localObject1).field_forbid_title);
        paramViewGroup.uCm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70875);
            if ((paramAnonymousView.getTag() instanceof String))
            {
              Intent localIntent = new Intent();
              paramAnonymousView = (String)paramAnonymousView.getTag();
              ad.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", new Object[] { paramAnonymousView });
              localIntent.putExtra("rawUrl", paramAnonymousView);
              localIntent.putExtra("geta8key_username", u.aqG());
              localIntent.putExtra("pay_channel", 1);
              e.b(k.a(k.this), localIntent, WalletChangeBankcardUI.zPX);
            }
            AppMethodBeat.o(70875);
          }
        });
        paramInt = ((String)localObject2).length();
        int i = ((String)localObject2).length();
        int j = ((Bankcard)localObject1).field_forbid_title.length();
        localSpannableString.setSpan(new ForegroundColorSpan(aj.getResources().getColor(2131101107)), paramInt, i + j, 34);
        paramViewGroup.uCm.setText(localSpannableString);
        paramViewGroup.uCm.setTag(((Bankcard)localObject1).field_forbid_url);
        break;
        paramViewGroup.titleTv.setText(((Bankcard)localObject1).field_desc);
        break label410;
        label837:
        if (((Bankcard)localObject2).AbU >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(ah.fkl(), new Object[] { e.E(((Bankcard)localObject2).AbU) }));
          break label449;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(2131765303));
        break label449;
        label902:
        if (!((Bankcard)localObject1).ebw()) {
          break label449;
        }
        if (!bt.isNullOrNil(((Bankcard)localObject1).AbV))
        {
          paramViewGroup.titleTv.setText(((Bankcard)localObject1).AbV);
          break label449;
        }
        if (((Bankcard)localObject1).AbU >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(2131765386, new Object[] { e.E(((Bankcard)localObject1).AbU) }));
          break label449;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(2131765303));
        break label449;
        paramViewGroup.uCm.setText(((Bankcard)localObject1).field_forbidWord);
        break label539;
        paramViewGroup.uCm.setText(2131765666);
        break label539;
        paramViewGroup.uCm.setText(2131765677);
        break label539;
        paramViewGroup.uCm.setText(2131765672);
        break label539;
        paramViewGroup.uCm.setText(2131765668);
        break label539;
        paramViewGroup.uCm.setText(2131765664);
        break label539;
        paramViewGroup.uCm.setText(2131765670);
        break label539;
        paramViewGroup.uCm.setText(2131765675);
        break label539;
        paramViewGroup.uCm.setVisibility(8);
        break label539;
        label1119:
        if (isEnabled(paramInt))
        {
          paramViewGroup.Amz.setChecked(false);
          paramViewGroup.Amz.setEnabled(true);
          break label604;
        }
        paramViewGroup.Amz.setEnabled(false);
        paramViewGroup.Amz.setChecked(false);
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100490));
        break label604;
        label1184:
        if (((Bankcard)localObject1).ebw())
        {
          this.zMG.a((Bankcard)localObject1, paramViewGroup.AmA);
        }
        else if (((Bankcard)localObject1).ebz())
        {
          paramViewGroup.AmA.setImageDrawable(com.tencent.mm.svg.a.a.g(aj.getResources(), 2131690298));
          if (!bt.isNullOrNil(((Bankcard)localObject1).Acn))
          {
            paramViewGroup.AmA.setUseSdcardCache(true);
            paramViewGroup.AmA.setImgSavedPath(b.edz());
            paramViewGroup.AmA.fz(((Bankcard)localObject1).Acn, 2131690298);
          }
        }
        else
        {
          this.zMG.a(this.mContext, (Bankcard)localObject1, paramViewGroup.AmA);
        }
      }
      label1299:
      if ((this.Amv) && (bt.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) && (bt.isNullOrNil((String)localObject2)))
      {
        localObject1 = g((Bankcard)localObject1);
        if (((LinkedList)localObject1).size() > 0)
        {
          paramViewGroup.Amy.setVisibility(0);
          paramViewGroup.uCm.setVisibility(8);
          paramViewGroup.Amy.setWording((LinkedList)localObject1);
        }
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(70879);
    Bankcard localBankcard = Rk(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(70879);
      return true;
    }
    if (localBankcard.a(this.zQa, this.vIq) != 0)
    {
      AppMethodBeat.o(70879);
      return false;
    }
    AppMethodBeat.o(70879);
    return true;
  }
  
  final class a
  {
    public CdnImageView AmA;
    public FavourLayout Amy;
    public CheckedTextView Amz;
    public TextView titleTv;
    public TextView uCm;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.k
 * JD-Core Version:    0.7.0.1
 */