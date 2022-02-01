package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class l
  extends BaseAdapter
{
  private Orders Ivh;
  private int OYk;
  public String OYl;
  public boolean OYm;
  private boolean OYn;
  protected ArrayList<Bankcard> OmN;
  private com.tencent.mm.plugin.wallet_core.utils.a OuA;
  private int OxV;
  private Context mContext;
  
  public l(Context paramContext, ArrayList<Bankcard> paramArrayList, int paramInt, Orders paramOrders)
  {
    AppMethodBeat.i(70876);
    this.Ivh = null;
    this.OYk = -1;
    this.OYl = "";
    this.OYm = true;
    this.OYn = false;
    this.mContext = paramContext;
    this.OmN = paramArrayList;
    this.OxV = paramInt;
    this.Ivh = paramOrders;
    this.OuA = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.OuA.b(this.mContext, this.OmN);
    if ((paramOrders != null) && (paramOrders.ORl == 1)) {
      this.OYn = true;
    }
    AppMethodBeat.o(70876);
  }
  
  private LinkedList<String> i(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70881);
    LinkedList localLinkedList = new LinkedList();
    if ((this.Ivh != null) && (this.Ivh.ORe != null) && (this.Ivh.ORe.Owx != null))
    {
      Iterator localIterator = this.Ivh.ORe.Owx.OvS.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.GGC.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.Owd.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).Ila);
          }
          AppMethodBeat.o(70881);
          return localLinkedList;
        }
      }
    }
    AppMethodBeat.o(70881);
    return localLinkedList;
  }
  
  public Bankcard amh(int paramInt)
  {
    AppMethodBeat.i(70878);
    Bankcard localBankcard;
    if (this.OYn)
    {
      localBankcard = (Bankcard)this.OmN.get(paramInt);
      AppMethodBeat.o(70878);
      return localBankcard;
    }
    int j = getCount();
    int i;
    if (this.Ivh != null)
    {
      i = j;
      if (this.Ivh.OQY.equals("CFT")) {}
    }
    else
    {
      i = j - 1;
    }
    if (paramInt < i)
    {
      localBankcard = (Bankcard)this.OmN.get(paramInt);
      AppMethodBeat.o(70878);
      return localBankcard;
    }
    AppMethodBeat.o(70878);
    return null;
  }
  
  public int getCount()
  {
    int i = 0;
    AppMethodBeat.i(70877);
    if (this.OYn)
    {
      if (this.OmN == null)
      {
        AppMethodBeat.o(70877);
        return 0;
      }
      i = this.OmN.size();
      AppMethodBeat.o(70877);
      return i;
    }
    if ((this.Ivh != null) && (this.Ivh.OQY.equals("CFT"))) {}
    for (;;)
    {
      if (this.OmN != null)
      {
        int j = this.OmN.size();
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
    Object localObject1;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, a.g.wallet_change_bankcard_item, null);
      paramViewGroup = new a();
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(a.f.title));
      paramViewGroup.GZI = ((TextView)paramView.findViewById(a.f.summary));
      paramViewGroup.OYq = ((CdnImageView)paramView.findViewById(a.f.bank_logo));
      paramViewGroup.OYp = ((FavourLayout)paramView.findViewById(a.f.favour_tip));
      paramViewGroup.mND = paramView.findViewById(a.f.wcpay_listview_divider);
      paramViewGroup.CbM = ((ImageView)paramView.findViewById(a.f.bankcard_selected));
      paramViewGroup.OYr = ((ImageView)paramView.findViewById(a.f.new_card_logo));
      paramViewGroup.GZI.setText("");
      paramView.setTag(paramViewGroup);
      if (paramInt != getCount() - 1) {
        break label386;
      }
      localObject1 = paramViewGroup.mND.getLayoutParams();
      if ((localObject1 instanceof LinearLayout.LayoutParams))
      {
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 16);
        paramViewGroup.mND.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    Object localObject2;
    for (;;)
    {
      paramViewGroup.GZI.setTextColor(MMApplicationContext.getResources().getColor(a.c.hint_text_color));
      paramViewGroup.OYp.setVisibility(8);
      localObject1 = amh(paramInt);
      if (localObject1 != null) {
        break label492;
      }
      paramViewGroup.GZI.setVisibility(8);
      paramViewGroup.titleTv.setText(a.i.wallet_pay_bankcard_add);
      paramViewGroup.OYq.setVisibility(8);
      paramViewGroup.OYr.setVisibility(0);
      localObject1 = new LinkedList();
      if ((this.Ivh == null) || (this.Ivh.ORe == null) || (this.Ivh.ORe.Owx == null)) {
        break label489;
      }
      localObject2 = this.Ivh.ORe.Owx.OvT;
      if (localObject2 == null) {
        break label489;
      }
      localObject2 = ((n)localObject2).OwJ.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(((o)((Iterator)localObject2).next()).Ila);
      }
      paramViewGroup = (a)paramView.getTag();
      break;
      label386:
      localObject1 = paramViewGroup.mND.getLayoutParams();
      if ((localObject1 instanceof LinearLayout.LayoutParams))
      {
        ((LinearLayout.LayoutParams)localObject1).leftMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 40);
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        paramViewGroup.mND.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    if ((this.OYm) && (((LinkedList)localObject1).size() > 0))
    {
      paramViewGroup.OYp.setVisibility(0);
      paramViewGroup.GZI.setVisibility(8);
      paramViewGroup.OYp.setWording((LinkedList)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(70880);
      return paramView;
      label489:
      break;
      label492:
      paramViewGroup.OYq.setVisibility(0);
      paramViewGroup.OYr.setVisibility(8);
      paramViewGroup.GZI.setVisibility(0);
      paramViewGroup.GZI.setText("");
      if (((Bankcard)localObject1).gIL())
      {
        paramViewGroup.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, ((Bankcard)localObject1).field_desc, paramViewGroup.titleTv.getTextSize()));
        label560:
        if (!((Bankcard)localObject1).gIH()) {
          break label1081;
        }
        localObject2 = u.gJo().OnP;
        if (Util.isNullOrNil(((Bankcard)localObject2).ONE)) {
          break label1016;
        }
        paramViewGroup.titleTv.setText(((Bankcard)localObject2).ONE);
        label599:
        paramViewGroup.GZI.setVisibility(0);
        switch (((Bankcard)localObject1).a(this.OxV, this.Ivh))
        {
        default: 
          if (!Util.isNullOrNil(((Bankcard)localObject1).field_tips))
          {
            paramViewGroup.GZI.setText(((Bankcard)localObject1).field_tips);
            label691:
            localObject2 = paramViewGroup.GZI.getText().toString();
            paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(a.c.normal_text_color));
            if (!isEnabled(paramInt)) {
              paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(a.c.hint_text_color));
            }
            if ((this.OYl == null) || (!this.OYl.equalsIgnoreCase(((Bankcard)localObject1).field_bindSerial))) {
              break label1298;
            }
            paramViewGroup.CbM.setVisibility(0);
            label783:
            paramViewGroup.OYq.setTag(a.f.wallet_core_bankcard_logo_helper_tag, null);
            paramViewGroup.OYq.setTag(null);
            paramViewGroup.OYq.setImageDrawable(null);
            paramViewGroup.GZI.setOnClickListener(null);
            if (!((Bankcard)localObject1).gIH()) {
              break label1310;
            }
            com.tencent.mm.plugin.wallet_core.utils.a.n(paramViewGroup.OYq);
          }
          break;
        }
      }
      for (;;)
      {
        if ((Util.isNullOrNil(((Bankcard)localObject1).field_forbid_title)) || (Util.isNullOrNil(((Bankcard)localObject1).field_forbid_url))) {
          break label1425;
        }
        localObject2 = (String)localObject2 + "  ";
        SpannableString localSpannableString = new SpannableString((String)localObject2 + ((Bankcard)localObject1).field_forbid_title);
        paramViewGroup.GZI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70875);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletChangeBankcardAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            if ((paramAnonymousView.getTag() instanceof String))
            {
              localObject = new Intent();
              paramAnonymousView = (String)paramAnonymousView.getTag();
              Log.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", new Object[] { paramAnonymousView });
              ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject).putExtra("geta8key_username", z.bcZ());
              ((Intent)localObject).putExtra("pay_channel", 1);
              g.c(l.a(l.this), (Intent)localObject, WalletChangeBankcardUI.OxS);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletChangeBankcardAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70875);
          }
        });
        paramInt = ((String)localObject2).length();
        int i = ((String)localObject2).length();
        int j = ((Bankcard)localObject1).field_forbid_title.length();
        localSpannableString.setSpan(new ForegroundColorSpan(MMApplicationContext.getResources().getColor(a.c.wallet_forbid_card_link_color)), paramInt, i + j, 34);
        paramViewGroup.GZI.setText(localSpannableString);
        paramViewGroup.GZI.setTag(((Bankcard)localObject1).field_forbid_url);
        break;
        paramViewGroup.titleTv.setText(((Bankcard)localObject1).field_desc);
        break label560;
        label1016:
        if (((Bankcard)localObject2).OND >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(ah.ijg(), new Object[] { g.F(((Bankcard)localObject2).OND) }));
          break label599;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(a.i.wallet_index_ui_default_balance));
        break label599;
        label1081:
        if (!((Bankcard)localObject1).gII()) {
          break label599;
        }
        if (!Util.isNullOrNil(((Bankcard)localObject1).ONE))
        {
          paramViewGroup.titleTv.setText(((Bankcard)localObject1).ONE);
          break label599;
        }
        if (((Bankcard)localObject1).OND >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(a.i.wallet_lqt_change_bankcard_balance_left, new Object[] { g.F(((Bankcard)localObject1).OND) }));
          break label599;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(a.i.wallet_index_ui_default_balance));
        break label599;
        paramViewGroup.GZI.setText(((Bankcard)localObject1).field_forbidWord);
        break label691;
        paramViewGroup.GZI.setText(a.i.wallet_pay_bankcard_expired);
        break label691;
        paramViewGroup.GZI.setText(a.i.wallet_pay_bankcard_quota);
        break label691;
        paramViewGroup.GZI.setText(a.i.wallet_pay_bankcard_maintenance);
        break label691;
        paramViewGroup.GZI.setText(a.i.wallet_pay_bankcard_insufficient_balance);
        break label691;
        paramViewGroup.GZI.setText(a.i.wallet_pay_bankcard_domestic);
        break label691;
        paramViewGroup.GZI.setText(a.i.wallet_pay_bankcard_international);
        break label691;
        paramViewGroup.GZI.setText(a.i.wallet_pay_bankcard_not_support_bankcard);
        break label691;
        paramViewGroup.GZI.setVisibility(8);
        break label691;
        label1298:
        paramViewGroup.CbM.setVisibility(8);
        break label783;
        label1310:
        if (((Bankcard)localObject1).gII())
        {
          this.OuA.a((Bankcard)localObject1, paramViewGroup.OYq);
        }
        else if (((Bankcard)localObject1).gIL())
        {
          paramViewGroup.OYq.setImageDrawable(com.tencent.mm.svg.a.a.h(MMApplicationContext.getResources(), a.h.honey_pay_bank_logo));
          if (!Util.isNullOrNil(((Bankcard)localObject1).ONV))
          {
            paramViewGroup.OYq.setUseSdcardCache(true);
            paramViewGroup.OYq.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.gKS());
            paramViewGroup.OYq.hr(((Bankcard)localObject1).ONV, a.h.honey_pay_bank_logo);
          }
        }
        else
        {
          this.OuA.a(this.mContext, (Bankcard)localObject1, paramViewGroup.OYq);
        }
      }
      label1425:
      if ((this.OYm) && (Util.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) && (Util.isNullOrNil((String)localObject2)))
      {
        localObject1 = i((Bankcard)localObject1);
        if (((LinkedList)localObject1).size() > 0)
        {
          paramViewGroup.OYp.setVisibility(0);
          paramViewGroup.GZI.setVisibility(8);
          paramViewGroup.OYp.setWording((LinkedList)localObject1);
        }
      }
    }
  }
  
  public final void i(ArrayList<Bankcard> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(70882);
    if (paramArrayList == null) {}
    for (this.OmN = new ArrayList();; this.OmN = paramArrayList)
    {
      this.OYm = paramBoolean;
      if (this.OmN.size() > 0) {
        this.OuA.b(this.mContext, this.OmN);
      }
      notifyDataSetChanged();
      AppMethodBeat.o(70882);
      return;
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(70879);
    Bankcard localBankcard = amh(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(70879);
      return true;
    }
    if (localBankcard.a(this.OxV, this.Ivh) != 0)
    {
      AppMethodBeat.o(70879);
      return false;
    }
    AppMethodBeat.o(70879);
    return true;
  }
  
  final class a
  {
    public ImageView CbM;
    public TextView GZI;
    public FavourLayout OYp;
    public CdnImageView OYq;
    public ImageView OYr;
    public View mND;
    public TextView titleTv;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.l
 * JD-Core Version:    0.7.0.1
 */