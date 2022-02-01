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
import com.tencent.mm.plugin.wallet.model.c;
import com.tencent.mm.plugin.wallet.model.d;
import com.tencent.mm.plugin.wallet.model.h;
import com.tencent.mm.plugin.wallet.model.l;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class m
  extends BaseAdapter
{
  private Orders OsJ;
  public boolean VOA;
  private boolean VOB;
  private int VOy;
  public String VOz;
  protected ArrayList<Bankcard> Vbt;
  private com.tencent.mm.plugin.wallet_core.utils.b VjO;
  private int Vng;
  private Context mContext;
  
  public m(Context paramContext, ArrayList<Bankcard> paramArrayList, int paramInt, Orders paramOrders)
  {
    AppMethodBeat.i(70876);
    this.OsJ = null;
    this.VOy = -1;
    this.VOz = "";
    this.VOA = true;
    this.VOB = false;
    this.mContext = paramContext;
    this.Vbt = paramArrayList;
    this.Vng = paramInt;
    this.OsJ = paramOrders;
    this.VjO = new com.tencent.mm.plugin.wallet_core.utils.b();
    this.VjO.d(this.mContext, this.Vbt);
    if ((paramOrders != null) && (paramOrders.VHf == 1)) {
      this.VOB = true;
    }
    AppMethodBeat.o(70876);
  }
  
  private Bankcard arR(int paramInt)
  {
    AppMethodBeat.i(70878);
    Bankcard localBankcard;
    if (this.VOB)
    {
      localBankcard = (Bankcard)this.Vbt.get(paramInt);
      AppMethodBeat.o(70878);
      return localBankcard;
    }
    int j = getCount();
    int i;
    if (this.OsJ != null)
    {
      i = j;
      if (this.OsJ.VGS.equals("CFT")) {}
    }
    else
    {
      i = j - 1;
    }
    if (paramInt < i)
    {
      localBankcard = (Bankcard)this.Vbt.get(paramInt);
      AppMethodBeat.o(70878);
      return localBankcard;
    }
    AppMethodBeat.o(70878);
    return null;
  }
  
  private LinkedList<String> j(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70881);
    LinkedList localLinkedList = new LinkedList();
    if ((this.OsJ != null) && (this.OsJ.VGY != null) && (this.OsJ.VGY.VlI != null))
    {
      Iterator localIterator = this.OsJ.VGY.VlI.Vld.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.MDt.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.Vlo.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).OhO);
          }
          AppMethodBeat.o(70881);
          return localLinkedList;
        }
      }
    }
    AppMethodBeat.o(70881);
    return localLinkedList;
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(70877);
    if (this.VOB)
    {
      if (this.Vbt == null)
      {
        AppMethodBeat.o(70877);
        return 0;
      }
      i = this.Vbt.size();
      AppMethodBeat.o(70877);
      return i;
    }
    if ((this.OsJ != null) && (this.OsJ.VGS.equals("CFT"))) {}
    for (;;)
    {
      if (this.Vbt != null)
      {
        int j = this.Vbt.size();
        AppMethodBeat.o(70877);
        return i + j;
      }
      AppMethodBeat.o(70877);
      return i;
      i = 1;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(70880);
    Object localObject1;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, a.g.wallet_change_bankcard_item, null);
      paramViewGroup = new a();
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(a.f.title));
      paramViewGroup.MXN = ((TextView)paramView.findViewById(a.f.summary));
      paramViewGroup.VOE = ((CdnImageView)paramView.findViewById(a.f.bank_logo));
      paramViewGroup.VOD = ((FavourLayout)paramView.findViewById(a.f.favour_tip));
      paramViewGroup.pKl = paramView.findViewById(a.f.wcpay_listview_divider);
      paramViewGroup.HNO = ((ImageView)paramView.findViewById(a.f.bankcard_selected));
      paramViewGroup.VOF = ((ImageView)paramView.findViewById(a.f.new_card_logo));
      paramViewGroup.MXN.setText("");
      paramView.setTag(paramViewGroup);
      if (paramInt != getCount() - 1) {
        break label386;
      }
      localObject1 = paramViewGroup.pKl.getLayoutParams();
      if ((localObject1 instanceof LinearLayout.LayoutParams))
      {
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 16);
        paramViewGroup.pKl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    Object localObject2;
    for (;;)
    {
      paramViewGroup.MXN.setTextColor(MMApplicationContext.getResources().getColor(a.c.hint_text_color));
      paramViewGroup.VOD.setVisibility(8);
      localObject1 = arR(paramInt);
      if (localObject1 != null) {
        break label492;
      }
      paramViewGroup.MXN.setVisibility(8);
      paramViewGroup.titleTv.setText(a.i.wallet_pay_bankcard_add);
      paramViewGroup.VOE.setVisibility(8);
      paramViewGroup.VOF.setVisibility(0);
      localObject1 = new LinkedList();
      if ((this.OsJ == null) || (this.OsJ.VGY == null) || (this.OsJ.VGY.VlI == null)) {
        break label489;
      }
      localObject2 = this.OsJ.VGY.VlI.Vle;
      if (localObject2 == null) {
        break label489;
      }
      localObject2 = ((l)localObject2).VlU.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(((com.tencent.mm.plugin.wallet.model.m)((Iterator)localObject2).next()).OhO);
      }
      paramViewGroup = (a)paramView.getTag();
      break;
      label386:
      localObject1 = paramViewGroup.pKl.getLayoutParams();
      if ((localObject1 instanceof LinearLayout.LayoutParams))
      {
        ((LinearLayout.LayoutParams)localObject1).leftMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 40);
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        paramViewGroup.pKl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    if ((this.VOA) && (((LinkedList)localObject1).size() > 0))
    {
      paramViewGroup.VOD.setVisibility(0);
      paramViewGroup.MXN.setVisibility(8);
      paramViewGroup.VOD.setWording((LinkedList)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(70880);
      return paramView;
      label489:
      break;
      label492:
      paramViewGroup.VOE.setVisibility(0);
      paramViewGroup.VOF.setVisibility(8);
      paramViewGroup.MXN.setVisibility(0);
      paramViewGroup.MXN.setText("");
      if (((Bankcard)localObject1).ihZ())
      {
        paramViewGroup.titleTv.setText(p.b(this.mContext, ((Bankcard)localObject1).field_desc, paramViewGroup.titleTv.getTextSize()));
        label560:
        if (!((Bankcard)localObject1).ihV()) {
          break label1081;
        }
        localObject2 = u.iiC().VcF;
        if (Util.isNullOrNil(((Bankcard)localObject2).VDp)) {
          break label1016;
        }
        paramViewGroup.titleTv.setText(((Bankcard)localObject2).VDp);
        label599:
        paramViewGroup.MXN.setVisibility(0);
        switch (((Bankcard)localObject1).a(this.Vng, this.OsJ))
        {
        default: 
          if (!Util.isNullOrNil(((Bankcard)localObject1).field_tips))
          {
            paramViewGroup.MXN.setText(((Bankcard)localObject1).field_tips);
            label691:
            localObject2 = paramViewGroup.MXN.getText().toString();
            paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(a.c.normal_text_color));
            if (!isEnabled(paramInt)) {
              paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(a.c.hint_text_color));
            }
            if ((this.VOz == null) || (!this.VOz.equalsIgnoreCase(((Bankcard)localObject1).field_bindSerial))) {
              break label1298;
            }
            paramViewGroup.HNO.setVisibility(0);
            label783:
            paramViewGroup.VOE.setTag(a.f.wallet_core_bankcard_logo_helper_tag, null);
            paramViewGroup.VOE.setTag(null);
            paramViewGroup.VOE.setImageDrawable(null);
            paramViewGroup.MXN.setOnClickListener(null);
            if (!((Bankcard)localObject1).ihV()) {
              break label1310;
            }
            com.tencent.mm.plugin.wallet_core.utils.b.w(paramViewGroup.VOE);
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
        paramViewGroup.MXN.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70875);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletChangeBankcardAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            if ((paramAnonymousView.getTag() instanceof String))
            {
              localObject = new Intent();
              paramAnonymousView = (String)paramAnonymousView.getTag();
              Log.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", new Object[] { paramAnonymousView });
              ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject).putExtra("geta8key_username", z.bAM());
              ((Intent)localObject).putExtra("pay_channel", 1);
              i.d(m.a(m.this), (Intent)localObject, WalletChangeBankcardUI.Vnd);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletChangeBankcardAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70875);
          }
        });
        paramInt = ((String)localObject2).length();
        int i = ((String)localObject2).length();
        int j = ((Bankcard)localObject1).field_forbid_title.length();
        localSpannableString.setSpan(new ForegroundColorSpan(MMApplicationContext.getResources().getColor(a.c.wallet_forbid_card_link_color)), paramInt, i + j, 34);
        paramViewGroup.MXN.setText(localSpannableString);
        paramViewGroup.MXN.setTag(((Bankcard)localObject1).field_forbid_url);
        break;
        paramViewGroup.titleTv.setText(((Bankcard)localObject1).field_desc);
        break label560;
        label1016:
        if (((Bankcard)localObject2).VDo >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(ai.jPb(), new Object[] { i.X(((Bankcard)localObject2).VDo) }));
          break label599;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(a.i.wallet_index_ui_default_balance));
        break label599;
        label1081:
        if (!((Bankcard)localObject1).ihW()) {
          break label599;
        }
        if (!Util.isNullOrNil(((Bankcard)localObject1).VDp))
        {
          paramViewGroup.titleTv.setText(((Bankcard)localObject1).VDp);
          break label599;
        }
        if (((Bankcard)localObject1).VDo >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(a.i.wallet_lqt_change_bankcard_balance_left, new Object[] { i.X(((Bankcard)localObject1).VDo) }));
          break label599;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(a.i.wallet_index_ui_default_balance));
        break label599;
        paramViewGroup.MXN.setText(((Bankcard)localObject1).field_forbidWord);
        break label691;
        paramViewGroup.MXN.setText(a.i.wallet_pay_bankcard_expired);
        break label691;
        paramViewGroup.MXN.setText(a.i.wallet_pay_bankcard_quota);
        break label691;
        paramViewGroup.MXN.setText(a.i.wallet_pay_bankcard_maintenance);
        break label691;
        paramViewGroup.MXN.setText(a.i.wallet_pay_bankcard_insufficient_balance);
        break label691;
        paramViewGroup.MXN.setText(a.i.wallet_pay_bankcard_domestic);
        break label691;
        paramViewGroup.MXN.setText(a.i.wallet_pay_bankcard_international);
        break label691;
        paramViewGroup.MXN.setText(a.i.wallet_pay_bankcard_not_support_bankcard);
        break label691;
        paramViewGroup.MXN.setVisibility(8);
        break label691;
        label1298:
        paramViewGroup.HNO.setVisibility(8);
        break label783;
        label1310:
        if (((Bankcard)localObject1).ihW())
        {
          this.VjO.a((Bankcard)localObject1, paramViewGroup.VOE);
        }
        else if (((Bankcard)localObject1).ihZ())
        {
          paramViewGroup.VOE.setImageDrawable(com.tencent.mm.svg.a.a.i(MMApplicationContext.getResources(), a.h.honey_pay_bank_logo));
          if (!Util.isNullOrNil(((Bankcard)localObject1).VDG))
          {
            paramViewGroup.VOE.setUseSdcardCache(true);
            paramViewGroup.VOE.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.ikk());
            paramViewGroup.VOE.iz(((Bankcard)localObject1).VDG, a.h.honey_pay_bank_logo);
          }
        }
        else
        {
          this.VjO.a(this.mContext, (Bankcard)localObject1, paramViewGroup.VOE);
        }
      }
      label1425:
      if ((this.VOA) && (Util.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) && (Util.isNullOrNil((String)localObject2)))
      {
        localObject1 = j((Bankcard)localObject1);
        if ((localObject1 != null) && (((LinkedList)localObject1).size() > 0))
        {
          paramViewGroup.VOD.setVisibility(0);
          paramViewGroup.MXN.setVisibility(8);
          paramViewGroup.VOD.setWording((LinkedList)localObject1);
        }
      }
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(70879);
    Bankcard localBankcard = arR(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(70879);
      return true;
    }
    if (localBankcard.a(this.Vng, this.OsJ) != 0)
    {
      AppMethodBeat.o(70879);
      return false;
    }
    AppMethodBeat.o(70879);
    return true;
  }
  
  public final void m(ArrayList<Bankcard> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(70882);
    if (paramArrayList == null) {}
    for (this.Vbt = new ArrayList();; this.Vbt = paramArrayList)
    {
      this.VOA = paramBoolean;
      if (this.Vbt.size() > 0) {
        this.VjO.d(this.mContext, this.Vbt);
      }
      notifyDataSetChanged();
      AppMethodBeat.o(70882);
      return;
    }
  }
  
  final class a
  {
    public ImageView HNO;
    public TextView MXN;
    public FavourLayout VOD;
    public CdnImageView VOE;
    public ImageView VOF;
    public View pKl;
    public TextView titleTv;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.m
 * JD-Core Version:    0.7.0.1
 */