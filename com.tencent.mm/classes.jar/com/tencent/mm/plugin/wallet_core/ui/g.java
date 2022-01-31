package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.a.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class g
  extends BaseAdapter
{
  private Context mContext;
  private Orders nEh = null;
  private int qCO = -1;
  public String qCP = "";
  public boolean qCQ = true;
  private boolean qCR = false;
  public ArrayList<Bankcard> qgr;
  private com.tencent.mm.plugin.wallet_core.e.a qjy;
  private int qmx;
  
  public g(Context paramContext, ArrayList<Bankcard> paramArrayList, int paramInt, Orders paramOrders)
  {
    this.mContext = paramContext;
    this.qgr = paramArrayList;
    this.qmx = paramInt;
    this.nEh = paramOrders;
    this.qjy = new com.tencent.mm.plugin.wallet_core.e.a();
    this.qjy.b(this.mContext, this.qgr);
    if ((paramOrders != null) && (paramOrders.qwV == 1)) {
      this.qCR = true;
    }
  }
  
  private LinkedList<String> f(Bankcard paramBankcard)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((this.nEh != null) && (this.nEh.qwO != null) && (this.nEh.qwO.qlh != null))
    {
      Iterator localIterator = this.nEh.qwO.qlh.qkL.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.wallet.a.b localb = (com.tencent.mm.plugin.wallet.a.b)localIterator.next();
        if (localb.mOc.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localb.qkN.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((c)paramBankcard.next()).nxN);
          }
          return localLinkedList;
        }
      }
    }
    return localLinkedList;
  }
  
  public Bankcard AH(int paramInt)
  {
    if (this.qCR) {
      return (Bankcard)this.qgr.get(paramInt);
    }
    int j = getCount();
    int i;
    if (this.nEh != null)
    {
      i = j;
      if (this.nEh.qwJ.equals("CFT")) {}
    }
    else
    {
      i = j - 1;
    }
    if (paramInt < i) {
      return (Bankcard)this.qgr.get(paramInt);
    }
    return null;
  }
  
  public final void e(ArrayList<Bankcard> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null) {}
    for (this.qgr = new ArrayList();; this.qgr = paramArrayList)
    {
      this.qCQ = paramBoolean;
      if (this.qgr.size() > 0) {
        this.qjy.b(this.mContext, this.qgr);
      }
      notifyDataSetChanged();
      return;
    }
  }
  
  public int getCount()
  {
    int i = 0;
    int j = 0;
    if (this.qCR)
    {
      if (this.qgr == null) {
        return j;
      }
      return this.qgr.size();
    }
    if ((this.nEh != null) && (this.nEh.qwJ.equals("CFT"))) {}
    for (;;)
    {
      j = i;
      if (this.qgr == null) {
        break;
      }
      return i + this.qgr.size();
      i = 1;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, a.g.wallet_change_bankcard_item, null);
      paramViewGroup = new g.a(this);
      paramViewGroup.eXr = ((TextView)paramView.findViewById(a.f.title));
      paramViewGroup.mXQ = ((TextView)paramView.findViewById(a.f.summary));
      paramViewGroup.qCU = ((CheckedTextView)paramView.findViewById(a.f.check));
      paramViewGroup.qCV = ((CdnImageView)paramView.findViewById(a.f.bank_logo));
      paramViewGroup.qCT = ((FavourLayout)paramView.findViewById(a.f.favour_tip));
      paramViewGroup.mXQ.setText("");
      paramView.setTag(paramViewGroup);
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      paramViewGroup.mXQ.setTextColor(ae.getResources().getColor(a.c.hint_text_color));
      paramViewGroup.qCT.setVisibility(8);
      localObject1 = AH(paramInt);
      if (localObject1 != null) {
        break label340;
      }
      paramViewGroup.qCU.setVisibility(4);
      paramViewGroup.mXQ.setVisibility(8);
      paramViewGroup.eXr.setText(a.i.wallet_pay_bankcard_add);
      paramViewGroup.qCV.setVisibility(8);
      localObject1 = new LinkedList();
      if ((this.nEh == null) || (this.nEh.qwO == null) || (this.nEh.qwO.qlh == null)) {
        break label337;
      }
      localObject2 = this.nEh.qwO.qlh.qkM;
      if (localObject2 == null) {
        break label337;
      }
      localObject2 = ((k)localObject2).qlr.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(((l)((Iterator)localObject2).next()).nxN);
      }
      paramViewGroup = (g.a)paramView.getTag();
    }
    if ((this.qCQ) && (((LinkedList)localObject1).size() > 0))
    {
      paramViewGroup.qCT.setVisibility(0);
      paramViewGroup.mXQ.setVisibility(8);
      paramViewGroup.qCT.setWording((LinkedList)localObject1);
    }
    label337:
    label340:
    label600:
    do
    {
      do
      {
        return paramView;
        break;
        paramViewGroup.qCV.setVisibility(0);
        paramViewGroup.qCU.setVisibility(0);
        paramViewGroup.mXQ.setVisibility(0);
        paramViewGroup.mXQ.setText("");
        Object localObject3;
        if (((Bankcard)localObject1).bUU())
        {
          paramViewGroup.eXr.setText(j.a(this.mContext, ((Bankcard)localObject1).field_desc, paramViewGroup.eXr.getTextSize()));
          if (!((Bankcard)localObject1).bUQ()) {
            break label944;
          }
          localObject2 = o.bVs().qhj;
          if (bk.bl(((Bankcard)localObject2).qtz)) {
            break label853;
          }
          paramViewGroup.eXr.setText(((Bankcard)localObject2).qtz);
          paramViewGroup.mXQ.setVisibility(0);
          switch (((Bankcard)localObject1).a(this.qmx, this.nEh))
          {
          default: 
            if (!bk.bl(((Bankcard)localObject1).field_tips))
            {
              paramViewGroup.mXQ.setText(((Bankcard)localObject1).field_tips);
              localObject2 = paramViewGroup.mXQ.getText().toString();
              paramViewGroup.eXr.setTextColor(this.mContext.getResources().getColor(a.c.normal_text_color));
              if (!this.qCP.equalsIgnoreCase(((Bankcard)localObject1).field_bindSerial)) {
                break label1169;
              }
              paramViewGroup.qCU.setChecked(true);
              paramViewGroup.qCU.setEnabled(true);
              paramViewGroup.qCV.setTag(a.f.wallet_core_bankcard_logo_helper_tag, null);
              paramViewGroup.qCV.setTag(null);
              paramViewGroup.qCV.setImageDrawable(null);
              paramViewGroup.mXQ.setOnClickListener(null);
              if (!((Bankcard)localObject1).bUQ()) {
                break label1235;
              }
              localObject3 = paramViewGroup.qCV;
              if (localObject3 != null)
              {
                ((ImageView)localObject3).setTag(a.f.wallet_core_bankcard_logo_helper_tag, null);
                ((ImageView)localObject3).setImageResource(a.e.wallet_balance_manager_logo_small);
              }
            }
            break;
          }
        }
        for (;;)
        {
          if ((bk.bl(((Bankcard)localObject1).field_forbid_title)) || (bk.bl(((Bankcard)localObject1).field_forbid_url))) {
            break label1350;
          }
          localObject2 = (String)localObject2 + "  ";
          localObject3 = new SpannableString((String)localObject2 + ((Bankcard)localObject1).field_forbid_title);
          paramViewGroup.mXQ.setOnClickListener(new g.1(this));
          paramInt = ((String)localObject2).length();
          int i = ((String)localObject2).length();
          int j = ((Bankcard)localObject1).field_forbid_title.length();
          ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(ae.getResources().getColor(a.c.wallet_forbid_card_link_color)), paramInt, i + j, 34);
          paramViewGroup.mXQ.setText((CharSequence)localObject3);
          paramViewGroup.mXQ.setTag(((Bankcard)localObject1).field_forbid_url);
          return paramView;
          paramViewGroup.eXr.setText(((Bankcard)localObject1).field_desc);
          break;
          if (((Bankcard)localObject2).qty >= 0.0D)
          {
            localObject3 = paramViewGroup.eXr;
            Context localContext = this.mContext;
            if (q.Gw()) {}
            for (i = a.i.wallet_change_bankcard_balance_left_payu;; i = a.i.wallet_change_bankcard_balance_left)
            {
              ((TextView)localObject3).setText(localContext.getString(i, new Object[] { e.B(((Bankcard)localObject2).qty) }));
              break;
            }
          }
          paramViewGroup.eXr.setText(this.mContext.getText(a.i.wallet_index_ui_default_balance));
          break label446;
          if (!((Bankcard)localObject1).bUR()) {
            break label446;
          }
          localObject2 = o.bVs().qzj;
          if (!bk.bl(((Bankcard)localObject2).qtz))
          {
            paramViewGroup.eXr.setText(((Bankcard)localObject2).qtz);
            break label446;
          }
          if (((Bankcard)localObject2).qty >= 0.0D)
          {
            paramViewGroup.eXr.setText(this.mContext.getString(a.i.wallet_lqt_change_bankcard_balance_left, new Object[] { e.B(((Bankcard)localObject2).qty) }));
            break label446;
          }
          paramViewGroup.eXr.setText(this.mContext.getText(a.i.wallet_index_ui_default_balance));
          break label446;
          paramViewGroup.mXQ.setText(((Bankcard)localObject1).field_forbidWord);
          break label535;
          paramViewGroup.mXQ.setText(a.i.wallet_pay_bankcard_expired);
          break label535;
          paramViewGroup.mXQ.setText(a.i.wallet_pay_bankcard_quota);
          break label535;
          paramViewGroup.mXQ.setText(a.i.wallet_pay_bankcard_maintenance);
          break label535;
          paramViewGroup.mXQ.setText(a.i.wallet_pay_bankcard_insufficient_balance);
          break label535;
          paramViewGroup.mXQ.setText(a.i.wallet_pay_bankcard_domestic);
          break label535;
          paramViewGroup.mXQ.setText(a.i.wallet_pay_bankcard_international);
          break label535;
          paramViewGroup.mXQ.setText(a.i.wallet_pay_bankcard_not_support_bankcard);
          break label535;
          paramViewGroup.mXQ.setVisibility(8);
          break label535;
          if (isEnabled(paramInt))
          {
            paramViewGroup.qCU.setChecked(false);
            paramViewGroup.qCU.setEnabled(true);
            break label600;
          }
          paramViewGroup.qCU.setEnabled(false);
          paramViewGroup.qCU.setChecked(false);
          paramViewGroup.eXr.setTextColor(this.mContext.getResources().getColor(a.c.hint_text_color));
          break label600;
          if (((Bankcard)localObject1).bUR())
          {
            this.qjy.a((Bankcard)localObject1, paramViewGroup.qCV);
          }
          else if (((Bankcard)localObject1).bUU())
          {
            paramViewGroup.qCV.setImageDrawable(com.tencent.mm.svg.a.a.e(ae.getResources(), a.h.honey_pay_bank_logo));
            if (!bk.bl(((Bankcard)localObject1).qtP))
            {
              paramViewGroup.qCV.setUseSdcardCache(true);
              paramViewGroup.qCV.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.bWn());
              paramViewGroup.qCV.dl(((Bankcard)localObject1).qtP, a.h.honey_pay_bank_logo);
            }
          }
          else
          {
            this.qjy.a(this.mContext, (Bankcard)localObject1, paramViewGroup.qCV);
          }
        }
      } while ((!this.qCQ) || (!bk.bl(((Bankcard)localObject1).field_forbidWord)) || (!bk.bl((String)localObject2)));
      localObject1 = f((Bankcard)localObject1);
    } while (((LinkedList)localObject1).size() <= 0);
    label446:
    label853:
    paramViewGroup.qCT.setVisibility(0);
    label535:
    label944:
    label1235:
    paramViewGroup.mXQ.setVisibility(8);
    label1169:
    label1350:
    paramViewGroup.qCT.setWording((LinkedList)localObject1);
    return paramView;
  }
  
  public boolean isEnabled(int paramInt)
  {
    Bankcard localBankcard = AH(paramInt);
    if (localBankcard == null) {}
    while (localBankcard.a(this.qmx, this.nEh) == 0) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.g
 * JD-Core Version:    0.7.0.1
 */