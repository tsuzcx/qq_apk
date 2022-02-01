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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class k
  extends BaseAdapter
{
  protected ArrayList<Bankcard> AYt;
  private int BEO;
  public String BEP;
  public boolean BEQ;
  private boolean BER;
  private com.tencent.mm.plugin.wallet_core.utils.a Bfa;
  private int Biu;
  private Context mContext;
  private Orders wSu;
  
  public k(Context paramContext, ArrayList<Bankcard> paramArrayList, int paramInt, Orders paramOrders)
  {
    AppMethodBeat.i(70876);
    this.wSu = null;
    this.BEO = -1;
    this.BEP = "";
    this.BEQ = true;
    this.BER = false;
    this.mContext = paramContext;
    this.AYt = paramArrayList;
    this.Biu = paramInt;
    this.wSu = paramOrders;
    this.Bfa = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.Bfa.b(this.mContext, this.AYt);
    if ((paramOrders != null) && (paramOrders.BxZ == 1)) {
      this.BER = true;
    }
    AppMethodBeat.o(70876);
  }
  
  private LinkedList<String> g(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70881);
    LinkedList localLinkedList = new LinkedList();
    if ((this.wSu != null) && (this.wSu.BxS != null) && (this.wSu.BxS.BgW != null))
    {
      Iterator localIterator = this.wSu.BxS.BgW.Bgr.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.vwo.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.BgC.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).wJS);
          }
          AppMethodBeat.o(70881);
          return localLinkedList;
        }
      }
    }
    AppMethodBeat.o(70881);
    return localLinkedList;
  }
  
  public Bankcard Tt(int paramInt)
  {
    AppMethodBeat.i(70878);
    Bankcard localBankcard;
    if (this.BER)
    {
      localBankcard = (Bankcard)this.AYt.get(paramInt);
      AppMethodBeat.o(70878);
      return localBankcard;
    }
    int j = getCount();
    int i;
    if (this.wSu != null)
    {
      i = j;
      if (this.wSu.BxM.equals("CFT")) {}
    }
    else
    {
      i = j - 1;
    }
    if (paramInt < i)
    {
      localBankcard = (Bankcard)this.AYt.get(paramInt);
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
    for (this.AYt = new ArrayList();; this.AYt = paramArrayList)
    {
      this.BEQ = paramBoolean;
      if (this.AYt.size() > 0) {
        this.Bfa.b(this.mContext, this.AYt);
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
    if (this.BER)
    {
      if (this.AYt == null)
      {
        AppMethodBeat.o(70877);
        return 0;
      }
      i = this.AYt.size();
      AppMethodBeat.o(70877);
      return i;
    }
    if ((this.wSu != null) && (this.wSu.BxM.equals("CFT"))) {}
    for (;;)
    {
      if (this.AYt != null)
      {
        int j = this.AYt.size();
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
      paramViewGroup.vLf = ((TextView)paramView.findViewById(2131305546));
      paramViewGroup.BEU = ((CheckedTextView)paramView.findViewById(2131298214));
      paramViewGroup.BEV = ((CdnImageView)paramView.findViewById(2131297121));
      paramViewGroup.BET = ((FavourLayout)paramView.findViewById(2131299869));
      paramViewGroup.vLf.setText("");
      paramView.setTag(paramViewGroup);
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      paramViewGroup.vLf.setTextColor(ai.getResources().getColor(2131100490));
      paramViewGroup.BET.setVisibility(8);
      localObject1 = Tt(paramInt);
      if (localObject1 != null) {
        break label343;
      }
      paramViewGroup.BEU.setVisibility(4);
      paramViewGroup.vLf.setVisibility(8);
      paramViewGroup.titleTv.setText(2131765660);
      paramViewGroup.BEV.setVisibility(8);
      localObject1 = new LinkedList();
      if ((this.wSu == null) || (this.wSu.BxS == null) || (this.wSu.BxS.BgW == null)) {
        break label340;
      }
      localObject2 = this.wSu.BxS.BgW.Bgs;
      if (localObject2 == null) {
        break label340;
      }
      localObject2 = ((n)localObject2).Bhi.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(((o)((Iterator)localObject2).next()).wJS);
      }
      paramViewGroup = (a)paramView.getTag();
    }
    if ((this.BEQ) && (((LinkedList)localObject1).size() > 0))
    {
      paramViewGroup.BET.setVisibility(0);
      paramViewGroup.vLf.setVisibility(8);
      paramViewGroup.BET.setWording((LinkedList)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(70880);
      return paramView;
      label340:
      break;
      label343:
      paramViewGroup.BEV.setVisibility(0);
      paramViewGroup.BEU.setVisibility(0);
      paramViewGroup.vLf.setVisibility(0);
      paramViewGroup.vLf.setText("");
      if (((Bankcard)localObject1).eqV())
      {
        paramViewGroup.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, ((Bankcard)localObject1).field_desc, paramViewGroup.titleTv.getTextSize()));
        label410:
        if (!((Bankcard)localObject1).eqR()) {
          break label902;
        }
        localObject2 = s.ery().AZp;
        if (bs.isNullOrNil(((Bankcard)localObject2).Bup)) {
          break label837;
        }
        paramViewGroup.titleTv.setText(((Bankcard)localObject2).Bup);
        label449:
        paramViewGroup.vLf.setVisibility(0);
        switch (((Bankcard)localObject1).a(this.Biu, this.wSu))
        {
        default: 
          if (!bs.isNullOrNil(((Bankcard)localObject1).field_tips))
          {
            paramViewGroup.vLf.setText(((Bankcard)localObject1).field_tips);
            label539:
            localObject2 = paramViewGroup.vLf.getText().toString();
            paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100711));
            if (!this.BEP.equalsIgnoreCase(((Bankcard)localObject1).field_bindSerial)) {
              break label1119;
            }
            paramViewGroup.BEU.setChecked(true);
            paramViewGroup.BEU.setEnabled(true);
            label604:
            paramViewGroup.BEV.setTag(2131306720, null);
            paramViewGroup.BEV.setTag(null);
            paramViewGroup.BEV.setImageDrawable(null);
            paramViewGroup.vLf.setOnClickListener(null);
            if (!((Bankcard)localObject1).eqR()) {
              break label1184;
            }
            com.tencent.mm.plugin.wallet_core.utils.a.k(paramViewGroup.BEV);
          }
          break;
        }
      }
      for (;;)
      {
        if ((bs.isNullOrNil(((Bankcard)localObject1).field_forbid_title)) || (bs.isNullOrNil(((Bankcard)localObject1).field_forbid_url))) {
          break label1299;
        }
        localObject2 = (String)localObject2 + "  ";
        SpannableString localSpannableString = new SpannableString((String)localObject2 + ((Bankcard)localObject1).field_forbid_title);
        paramViewGroup.vLf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70875);
            if ((paramAnonymousView.getTag() instanceof String))
            {
              Intent localIntent = new Intent();
              paramAnonymousView = (String)paramAnonymousView.getTag();
              ac.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", new Object[] { paramAnonymousView });
              localIntent.putExtra("rawUrl", paramAnonymousView);
              localIntent.putExtra("geta8key_username", u.axw());
              localIntent.putExtra("pay_channel", 1);
              e.b(k.a(k.this), localIntent, WalletChangeBankcardUI.Bir);
            }
            AppMethodBeat.o(70875);
          }
        });
        paramInt = ((String)localObject2).length();
        int i = ((String)localObject2).length();
        int j = ((Bankcard)localObject1).field_forbid_title.length();
        localSpannableString.setSpan(new ForegroundColorSpan(ai.getResources().getColor(2131101107)), paramInt, i + j, 34);
        paramViewGroup.vLf.setText(localSpannableString);
        paramViewGroup.vLf.setTag(((Bankcard)localObject1).field_forbid_url);
        break;
        paramViewGroup.titleTv.setText(((Bankcard)localObject1).field_desc);
        break label410;
        label837:
        if (((Bankcard)localObject2).Buo >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(ah.fAB(), new Object[] { e.D(((Bankcard)localObject2).Buo) }));
          break label449;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(2131765303));
        break label449;
        label902:
        if (!((Bankcard)localObject1).eqS()) {
          break label449;
        }
        if (!bs.isNullOrNil(((Bankcard)localObject1).Bup))
        {
          paramViewGroup.titleTv.setText(((Bankcard)localObject1).Bup);
          break label449;
        }
        if (((Bankcard)localObject1).Buo >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(2131765386, new Object[] { e.D(((Bankcard)localObject1).Buo) }));
          break label449;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(2131765303));
        break label449;
        paramViewGroup.vLf.setText(((Bankcard)localObject1).field_forbidWord);
        break label539;
        paramViewGroup.vLf.setText(2131765666);
        break label539;
        paramViewGroup.vLf.setText(2131765677);
        break label539;
        paramViewGroup.vLf.setText(2131765672);
        break label539;
        paramViewGroup.vLf.setText(2131765668);
        break label539;
        paramViewGroup.vLf.setText(2131765664);
        break label539;
        paramViewGroup.vLf.setText(2131765670);
        break label539;
        paramViewGroup.vLf.setText(2131765675);
        break label539;
        paramViewGroup.vLf.setVisibility(8);
        break label539;
        label1119:
        if (isEnabled(paramInt))
        {
          paramViewGroup.BEU.setChecked(false);
          paramViewGroup.BEU.setEnabled(true);
          break label604;
        }
        paramViewGroup.BEU.setEnabled(false);
        paramViewGroup.BEU.setChecked(false);
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100490));
        break label604;
        label1184:
        if (((Bankcard)localObject1).eqS())
        {
          this.Bfa.a((Bankcard)localObject1, paramViewGroup.BEV);
        }
        else if (((Bankcard)localObject1).eqV())
        {
          paramViewGroup.BEV.setImageDrawable(com.tencent.mm.svg.a.a.g(ai.getResources(), 2131690298));
          if (!bs.isNullOrNil(((Bankcard)localObject1).BuH))
          {
            paramViewGroup.BEV.setUseSdcardCache(true);
            paramViewGroup.BEV.setImgSavedPath(b.esU());
            paramViewGroup.BEV.fE(((Bankcard)localObject1).BuH, 2131690298);
          }
        }
        else
        {
          this.Bfa.a(this.mContext, (Bankcard)localObject1, paramViewGroup.BEV);
        }
      }
      label1299:
      if ((this.BEQ) && (bs.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) && (bs.isNullOrNil((String)localObject2)))
      {
        localObject1 = g((Bankcard)localObject1);
        if (((LinkedList)localObject1).size() > 0)
        {
          paramViewGroup.BET.setVisibility(0);
          paramViewGroup.vLf.setVisibility(8);
          paramViewGroup.BET.setWording((LinkedList)localObject1);
        }
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(70879);
    Bankcard localBankcard = Tt(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(70879);
      return true;
    }
    if (localBankcard.a(this.Biu, this.wSu) != 0)
    {
      AppMethodBeat.o(70879);
      return false;
    }
    AppMethodBeat.o(70879);
    return true;
  }
  
  final class a
  {
    public FavourLayout BET;
    public CheckedTextView BEU;
    public CdnImageView BEV;
    public TextView titleTv;
    public TextView vLf;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.k
 * JD-Core Version:    0.7.0.1
 */