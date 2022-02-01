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
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
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
  private com.tencent.mm.plugin.wallet_core.utils.a CFp;
  private int CII;
  protected ArrayList<Bankcard> CyC;
  private int Dfg;
  public String Dfh;
  public boolean Dfi;
  private boolean Dfj;
  private Context mContext;
  private Orders ygb;
  
  public k(Context paramContext, ArrayList<Bankcard> paramArrayList, int paramInt, Orders paramOrders)
  {
    AppMethodBeat.i(70876);
    this.ygb = null;
    this.Dfg = -1;
    this.Dfh = "";
    this.Dfi = true;
    this.Dfj = false;
    this.mContext = paramContext;
    this.CyC = paramArrayList;
    this.CII = paramInt;
    this.ygb = paramOrders;
    this.CFp = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.CFp.b(this.mContext, this.CyC);
    if ((paramOrders != null) && (paramOrders.CYs == 1)) {
      this.Dfj = true;
    }
    AppMethodBeat.o(70876);
  }
  
  private LinkedList<String> g(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70881);
    LinkedList localLinkedList = new LinkedList();
    if ((this.ygb != null) && (this.ygb.CYl != null) && (this.ygb.CYl.CHk != null))
    {
      Iterator localIterator = this.ygb.CYl.CHk.CGF.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.wBI.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.CGQ.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).xXz);
          }
          AppMethodBeat.o(70881);
          return localLinkedList;
        }
      }
    }
    AppMethodBeat.o(70881);
    return localLinkedList;
  }
  
  public Bankcard Vl(int paramInt)
  {
    AppMethodBeat.i(70878);
    Bankcard localBankcard;
    if (this.Dfj)
    {
      localBankcard = (Bankcard)this.CyC.get(paramInt);
      AppMethodBeat.o(70878);
      return localBankcard;
    }
    int j = getCount();
    int i;
    if (this.ygb != null)
    {
      i = j;
      if (this.ygb.CYf.equals("CFT")) {}
    }
    else
    {
      i = j - 1;
    }
    if (paramInt < i)
    {
      localBankcard = (Bankcard)this.CyC.get(paramInt);
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
    for (this.CyC = new ArrayList();; this.CyC = paramArrayList)
    {
      this.Dfi = paramBoolean;
      if (this.CyC.size() > 0) {
        this.CFp.b(this.mContext, this.CyC);
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
    if (this.Dfj)
    {
      if (this.CyC == null)
      {
        AppMethodBeat.o(70877);
        return 0;
      }
      i = this.CyC.size();
      AppMethodBeat.o(70877);
      return i;
    }
    if ((this.ygb != null) && (this.ygb.CYf.equals("CFT"))) {}
    for (;;)
    {
      if (this.CyC != null)
      {
        int j = this.CyC.size();
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
      paramViewGroup.wSo = ((TextView)paramView.findViewById(2131305546));
      paramViewGroup.Dfm = ((CheckedTextView)paramView.findViewById(2131298214));
      paramViewGroup.Dfn = ((CdnImageView)paramView.findViewById(2131297121));
      paramViewGroup.Dfl = ((FavourLayout)paramView.findViewById(2131299869));
      paramViewGroup.wSo.setText("");
      paramView.setTag(paramViewGroup);
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      paramViewGroup.wSo.setTextColor(aj.getResources().getColor(2131100490));
      paramViewGroup.Dfl.setVisibility(8);
      localObject1 = Vl(paramInt);
      if (localObject1 != null) {
        break label343;
      }
      paramViewGroup.Dfm.setVisibility(4);
      paramViewGroup.wSo.setVisibility(8);
      paramViewGroup.titleTv.setText(2131765660);
      paramViewGroup.Dfn.setVisibility(8);
      localObject1 = new LinkedList();
      if ((this.ygb == null) || (this.ygb.CYl == null) || (this.ygb.CYl.CHk == null)) {
        break label340;
      }
      localObject2 = this.ygb.CYl.CHk.CGG;
      if (localObject2 == null) {
        break label340;
      }
      localObject2 = ((n)localObject2).CHw.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(((o)((Iterator)localObject2).next()).xXz);
      }
      paramViewGroup = (a)paramView.getTag();
    }
    if ((this.Dfi) && (((LinkedList)localObject1).size() > 0))
    {
      paramViewGroup.Dfl.setVisibility(0);
      paramViewGroup.wSo.setVisibility(8);
      paramViewGroup.Dfl.setWording((LinkedList)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(70880);
      return paramView;
      label340:
      break;
      label343:
      paramViewGroup.Dfn.setVisibility(0);
      paramViewGroup.Dfm.setVisibility(0);
      paramViewGroup.wSo.setVisibility(0);
      paramViewGroup.wSo.setText("");
      if (((Bankcard)localObject1).eEV())
      {
        paramViewGroup.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, ((Bankcard)localObject1).field_desc, paramViewGroup.titleTv.getTextSize()));
        label410:
        if (!((Bankcard)localObject1).eER()) {
          break label902;
        }
        localObject2 = t.eFy().CzB;
        if (bt.isNullOrNil(((Bankcard)localObject2).CUE)) {
          break label837;
        }
        paramViewGroup.titleTv.setText(((Bankcard)localObject2).CUE);
        label449:
        paramViewGroup.wSo.setVisibility(0);
        switch (((Bankcard)localObject1).a(this.CII, this.ygb))
        {
        default: 
          if (!bt.isNullOrNil(((Bankcard)localObject1).field_tips))
          {
            paramViewGroup.wSo.setText(((Bankcard)localObject1).field_tips);
            label539:
            localObject2 = paramViewGroup.wSo.getText().toString();
            paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100711));
            if (!this.Dfh.equalsIgnoreCase(((Bankcard)localObject1).field_bindSerial)) {
              break label1119;
            }
            paramViewGroup.Dfm.setChecked(true);
            paramViewGroup.Dfm.setEnabled(true);
            label604:
            paramViewGroup.Dfn.setTag(2131306720, null);
            paramViewGroup.Dfn.setTag(null);
            paramViewGroup.Dfn.setImageDrawable(null);
            paramViewGroup.wSo.setOnClickListener(null);
            if (!((Bankcard)localObject1).eER()) {
              break label1184;
            }
            com.tencent.mm.plugin.wallet_core.utils.a.k(paramViewGroup.Dfn);
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
        paramViewGroup.wSo.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70875);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletChangeBankcardAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            if ((paramAnonymousView.getTag() instanceof String))
            {
              localObject = new Intent();
              paramAnonymousView = (String)paramAnonymousView.getTag();
              ad.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", new Object[] { paramAnonymousView });
              ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject).putExtra("geta8key_username", u.aAm());
              ((Intent)localObject).putExtra("pay_channel", 1);
              e.b(k.a(k.this), (Intent)localObject, WalletChangeBankcardUI.CIF);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletChangeBankcardAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70875);
          }
        });
        paramInt = ((String)localObject2).length();
        int i = ((String)localObject2).length();
        int j = ((Bankcard)localObject1).field_forbid_title.length();
        localSpannableString.setSpan(new ForegroundColorSpan(aj.getResources().getColor(2131101107)), paramInt, i + j, 34);
        paramViewGroup.wSo.setText(localSpannableString);
        paramViewGroup.wSo.setTag(((Bankcard)localObject1).field_forbid_url);
        break;
        paramViewGroup.titleTv.setText(((Bankcard)localObject1).field_desc);
        break label410;
        label837:
        if (((Bankcard)localObject2).CUD >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(ah.fRL(), new Object[] { e.D(((Bankcard)localObject2).CUD) }));
          break label449;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(2131765303));
        break label449;
        label902:
        if (!((Bankcard)localObject1).eES()) {
          break label449;
        }
        if (!bt.isNullOrNil(((Bankcard)localObject1).CUE))
        {
          paramViewGroup.titleTv.setText(((Bankcard)localObject1).CUE);
          break label449;
        }
        if (((Bankcard)localObject1).CUD >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(2131765386, new Object[] { e.D(((Bankcard)localObject1).CUD) }));
          break label449;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(2131765303));
        break label449;
        paramViewGroup.wSo.setText(((Bankcard)localObject1).field_forbidWord);
        break label539;
        paramViewGroup.wSo.setText(2131765666);
        break label539;
        paramViewGroup.wSo.setText(2131765677);
        break label539;
        paramViewGroup.wSo.setText(2131765672);
        break label539;
        paramViewGroup.wSo.setText(2131765668);
        break label539;
        paramViewGroup.wSo.setText(2131765664);
        break label539;
        paramViewGroup.wSo.setText(2131765670);
        break label539;
        paramViewGroup.wSo.setText(2131765675);
        break label539;
        paramViewGroup.wSo.setVisibility(8);
        break label539;
        label1119:
        if (isEnabled(paramInt))
        {
          paramViewGroup.Dfm.setChecked(false);
          paramViewGroup.Dfm.setEnabled(true);
          break label604;
        }
        paramViewGroup.Dfm.setEnabled(false);
        paramViewGroup.Dfm.setChecked(false);
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100490));
        break label604;
        label1184:
        if (((Bankcard)localObject1).eES())
        {
          this.CFp.a((Bankcard)localObject1, paramViewGroup.Dfn);
        }
        else if (((Bankcard)localObject1).eEV())
        {
          paramViewGroup.Dfn.setImageDrawable(com.tencent.mm.svg.a.a.g(aj.getResources(), 2131690298));
          if (!bt.isNullOrNil(((Bankcard)localObject1).CUW))
          {
            paramViewGroup.Dfn.setUseSdcardCache(true);
            paramViewGroup.Dfn.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.eHa());
            paramViewGroup.Dfn.gb(((Bankcard)localObject1).CUW, 2131690298);
          }
        }
        else
        {
          this.CFp.a(this.mContext, (Bankcard)localObject1, paramViewGroup.Dfn);
        }
      }
      label1299:
      if ((this.Dfi) && (bt.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) && (bt.isNullOrNil((String)localObject2)))
      {
        localObject1 = g((Bankcard)localObject1);
        if (((LinkedList)localObject1).size() > 0)
        {
          paramViewGroup.Dfl.setVisibility(0);
          paramViewGroup.wSo.setVisibility(8);
          paramViewGroup.Dfl.setWording((LinkedList)localObject1);
        }
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(70879);
    Bankcard localBankcard = Vl(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(70879);
      return true;
    }
    if (localBankcard.a(this.CII, this.ygb) != 0)
    {
      AppMethodBeat.o(70879);
      return false;
    }
    AppMethodBeat.o(70879);
    return true;
  }
  
  final class a
  {
    public FavourLayout Dfl;
    public CheckedTextView Dfm;
    public CdnImageView Dfn;
    public TextView titleTv;
    public TextView wSo;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.k
 * JD-Core Version:    0.7.0.1
 */