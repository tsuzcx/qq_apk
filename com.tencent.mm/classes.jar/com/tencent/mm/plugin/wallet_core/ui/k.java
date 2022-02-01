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
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class k
  extends BaseAdapter
{
  protected ArrayList<Bankcard> CQh;
  private com.tencent.mm.plugin.wallet_core.utils.a CWV;
  private int Dao;
  private int DwK;
  public String DwL;
  public boolean DwM;
  private boolean DwN;
  private Context mContext;
  private Orders yvS;
  
  public k(Context paramContext, ArrayList<Bankcard> paramArrayList, int paramInt, Orders paramOrders)
  {
    AppMethodBeat.i(70876);
    this.yvS = null;
    this.DwK = -1;
    this.DwL = "";
    this.DwM = true;
    this.DwN = false;
    this.mContext = paramContext;
    this.CQh = paramArrayList;
    this.Dao = paramInt;
    this.yvS = paramOrders;
    this.CWV = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.CWV.b(this.mContext, this.CQh);
    if ((paramOrders != null) && (paramOrders.DpX == 1)) {
      this.DwN = true;
    }
    AppMethodBeat.o(70876);
  }
  
  private LinkedList<String> g(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70881);
    LinkedList localLinkedList = new LinkedList();
    if ((this.yvS != null) && (this.yvS.DpQ != null) && (this.yvS.DpQ.CYQ != null))
    {
      Iterator localIterator = this.yvS.DpQ.CYQ.CYl.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.wRt.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.CYw.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).ynr);
          }
          AppMethodBeat.o(70881);
          return localLinkedList;
        }
      }
    }
    AppMethodBeat.o(70881);
    return localLinkedList;
  }
  
  public Bankcard VS(int paramInt)
  {
    AppMethodBeat.i(70878);
    Bankcard localBankcard;
    if (this.DwN)
    {
      localBankcard = (Bankcard)this.CQh.get(paramInt);
      AppMethodBeat.o(70878);
      return localBankcard;
    }
    int j = getCount();
    int i;
    if (this.yvS != null)
    {
      i = j;
      if (this.yvS.DpK.equals("CFT")) {}
    }
    else
    {
      i = j - 1;
    }
    if (paramInt < i)
    {
      localBankcard = (Bankcard)this.CQh.get(paramInt);
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
    for (this.CQh = new ArrayList();; this.CQh = paramArrayList)
    {
      this.DwM = paramBoolean;
      if (this.CQh.size() > 0) {
        this.CWV.b(this.mContext, this.CQh);
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
    if (this.DwN)
    {
      if (this.CQh == null)
      {
        AppMethodBeat.o(70877);
        return 0;
      }
      i = this.CQh.size();
      AppMethodBeat.o(70877);
      return i;
    }
    if ((this.yvS != null) && (this.yvS.DpK.equals("CFT"))) {}
    for (;;)
    {
      if (this.CQh != null)
      {
        int j = this.CQh.size();
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
      paramViewGroup.xif = ((TextView)paramView.findViewById(2131305546));
      paramViewGroup.DwQ = ((CheckedTextView)paramView.findViewById(2131298214));
      paramViewGroup.DwR = ((CdnImageView)paramView.findViewById(2131297121));
      paramViewGroup.DwP = ((FavourLayout)paramView.findViewById(2131299869));
      paramViewGroup.xif.setText("");
      paramView.setTag(paramViewGroup);
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      paramViewGroup.xif.setTextColor(ak.getResources().getColor(2131100490));
      paramViewGroup.DwP.setVisibility(8);
      localObject1 = VS(paramInt);
      if (localObject1 != null) {
        break label343;
      }
      paramViewGroup.DwQ.setVisibility(4);
      paramViewGroup.xif.setVisibility(8);
      paramViewGroup.titleTv.setText(2131765660);
      paramViewGroup.DwR.setVisibility(8);
      localObject1 = new LinkedList();
      if ((this.yvS == null) || (this.yvS.DpQ == null) || (this.yvS.DpQ.CYQ == null)) {
        break label340;
      }
      localObject2 = this.yvS.DpQ.CYQ.CYm;
      if (localObject2 == null) {
        break label340;
      }
      localObject2 = ((n)localObject2).CZc.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(((o)((Iterator)localObject2).next()).ynr);
      }
      paramViewGroup = (a)paramView.getTag();
    }
    if ((this.DwM) && (((LinkedList)localObject1).size() > 0))
    {
      paramViewGroup.DwP.setVisibility(0);
      paramViewGroup.xif.setVisibility(8);
      paramViewGroup.DwP.setWording((LinkedList)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(70880);
      return paramView;
      label340:
      break;
      label343:
      paramViewGroup.DwR.setVisibility(0);
      paramViewGroup.DwQ.setVisibility(0);
      paramViewGroup.xif.setVisibility(0);
      paramViewGroup.xif.setText("");
      if (((Bankcard)localObject1).eIC())
      {
        paramViewGroup.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, ((Bankcard)localObject1).field_desc, paramViewGroup.titleTv.getTextSize()));
        label410:
        if (!((Bankcard)localObject1).eIy()) {
          break label902;
        }
        localObject2 = t.eJf().CRg;
        if (bu.isNullOrNil(((Bankcard)localObject2).Dmk)) {
          break label837;
        }
        paramViewGroup.titleTv.setText(((Bankcard)localObject2).Dmk);
        label449:
        paramViewGroup.xif.setVisibility(0);
        switch (((Bankcard)localObject1).a(this.Dao, this.yvS))
        {
        default: 
          if (!bu.isNullOrNil(((Bankcard)localObject1).field_tips))
          {
            paramViewGroup.xif.setText(((Bankcard)localObject1).field_tips);
            label539:
            localObject2 = paramViewGroup.xif.getText().toString();
            paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100711));
            if (!this.DwL.equalsIgnoreCase(((Bankcard)localObject1).field_bindSerial)) {
              break label1119;
            }
            paramViewGroup.DwQ.setChecked(true);
            paramViewGroup.DwQ.setEnabled(true);
            label604:
            paramViewGroup.DwR.setTag(2131306720, null);
            paramViewGroup.DwR.setTag(null);
            paramViewGroup.DwR.setImageDrawable(null);
            paramViewGroup.xif.setOnClickListener(null);
            if (!((Bankcard)localObject1).eIy()) {
              break label1184;
            }
            com.tencent.mm.plugin.wallet_core.utils.a.k(paramViewGroup.DwR);
          }
          break;
        }
      }
      for (;;)
      {
        if ((bu.isNullOrNil(((Bankcard)localObject1).field_forbid_title)) || (bu.isNullOrNil(((Bankcard)localObject1).field_forbid_url))) {
          break label1299;
        }
        localObject2 = (String)localObject2 + "  ";
        SpannableString localSpannableString = new SpannableString((String)localObject2 + ((Bankcard)localObject1).field_forbid_title);
        paramViewGroup.xif.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70875);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletChangeBankcardAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            if ((paramAnonymousView.getTag() instanceof String))
            {
              localObject = new Intent();
              paramAnonymousView = (String)paramAnonymousView.getTag();
              ae.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", new Object[] { paramAnonymousView });
              ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject).putExtra("geta8key_username", v.aAC());
              ((Intent)localObject).putExtra("pay_channel", 1);
              f.b(k.a(k.this), (Intent)localObject, WalletChangeBankcardUI.Dal);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletChangeBankcardAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70875);
          }
        });
        paramInt = ((String)localObject2).length();
        int i = ((String)localObject2).length();
        int j = ((Bankcard)localObject1).field_forbid_title.length();
        localSpannableString.setSpan(new ForegroundColorSpan(ak.getResources().getColor(2131101107)), paramInt, i + j, 34);
        paramViewGroup.xif.setText(localSpannableString);
        paramViewGroup.xif.setTag(((Bankcard)localObject1).field_forbid_url);
        break;
        paramViewGroup.titleTv.setText(((Bankcard)localObject1).field_desc);
        break label410;
        label837:
        if (((Bankcard)localObject2).Dmj >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(ah.fWh(), new Object[] { f.D(((Bankcard)localObject2).Dmj) }));
          break label449;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(2131765303));
        break label449;
        label902:
        if (!((Bankcard)localObject1).eIz()) {
          break label449;
        }
        if (!bu.isNullOrNil(((Bankcard)localObject1).Dmk))
        {
          paramViewGroup.titleTv.setText(((Bankcard)localObject1).Dmk);
          break label449;
        }
        if (((Bankcard)localObject1).Dmj >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(2131765386, new Object[] { f.D(((Bankcard)localObject1).Dmj) }));
          break label449;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(2131765303));
        break label449;
        paramViewGroup.xif.setText(((Bankcard)localObject1).field_forbidWord);
        break label539;
        paramViewGroup.xif.setText(2131765666);
        break label539;
        paramViewGroup.xif.setText(2131765677);
        break label539;
        paramViewGroup.xif.setText(2131765672);
        break label539;
        paramViewGroup.xif.setText(2131765668);
        break label539;
        paramViewGroup.xif.setText(2131765664);
        break label539;
        paramViewGroup.xif.setText(2131765670);
        break label539;
        paramViewGroup.xif.setText(2131765675);
        break label539;
        paramViewGroup.xif.setVisibility(8);
        break label539;
        label1119:
        if (isEnabled(paramInt))
        {
          paramViewGroup.DwQ.setChecked(false);
          paramViewGroup.DwQ.setEnabled(true);
          break label604;
        }
        paramViewGroup.DwQ.setEnabled(false);
        paramViewGroup.DwQ.setChecked(false);
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100490));
        break label604;
        label1184:
        if (((Bankcard)localObject1).eIz())
        {
          this.CWV.a((Bankcard)localObject1, paramViewGroup.DwR);
        }
        else if (((Bankcard)localObject1).eIC())
        {
          paramViewGroup.DwR.setImageDrawable(com.tencent.mm.svg.a.a.g(ak.getResources(), 2131690298));
          if (!bu.isNullOrNil(((Bankcard)localObject1).DmC))
          {
            paramViewGroup.DwR.setUseSdcardCache(true);
            paramViewGroup.DwR.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.eKI());
            paramViewGroup.DwR.gk(((Bankcard)localObject1).DmC, 2131690298);
          }
        }
        else
        {
          this.CWV.a(this.mContext, (Bankcard)localObject1, paramViewGroup.DwR);
        }
      }
      label1299:
      if ((this.DwM) && (bu.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) && (bu.isNullOrNil((String)localObject2)))
      {
        localObject1 = g((Bankcard)localObject1);
        if (((LinkedList)localObject1).size() > 0)
        {
          paramViewGroup.DwP.setVisibility(0);
          paramViewGroup.xif.setVisibility(8);
          paramViewGroup.DwP.setWording((LinkedList)localObject1);
        }
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(70879);
    Bankcard localBankcard = VS(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(70879);
      return true;
    }
    if (localBankcard.a(this.Dao, this.yvS) != 0)
    {
      AppMethodBeat.o(70879);
      return false;
    }
    AppMethodBeat.o(70879);
    return true;
  }
  
  final class a
  {
    public FavourLayout DwP;
    public CheckedTextView DwQ;
    public CdnImageView DwR;
    public TextView titleTv;
    public TextView xif;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.k
 * JD-Core Version:    0.7.0.1
 */