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
import com.tencent.mm.model.z;
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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class k
  extends BaseAdapter
{
  private Orders CwO;
  private com.tencent.mm.plugin.wallet_core.utils.a HCH;
  private int HGc;
  protected ArrayList<Bankcard> Hva;
  private int IfV;
  public String IfW;
  public boolean IfX;
  private boolean IfY;
  private Context mContext;
  
  public k(Context paramContext, ArrayList<Bankcard> paramArrayList, int paramInt, Orders paramOrders)
  {
    AppMethodBeat.i(70876);
    this.CwO = null;
    this.IfV = -1;
    this.IfW = "";
    this.IfX = true;
    this.IfY = false;
    this.mContext = paramContext;
    this.Hva = paramArrayList;
    this.HGc = paramInt;
    this.CwO = paramOrders;
    this.HCH = new com.tencent.mm.plugin.wallet_core.utils.a();
    this.HCH.b(this.mContext, this.Hva);
    if ((paramOrders != null) && (paramOrders.HZl == 1)) {
      this.IfY = true;
    }
    AppMethodBeat.o(70876);
  }
  
  private LinkedList<String> h(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70881);
    LinkedList localLinkedList = new LinkedList();
    if ((this.CwO != null) && (this.CwO.HZe != null) && (this.CwO.HZe.HEE != null))
    {
      Iterator localIterator = this.CwO.HZe.HEE.HDZ.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.ANo.equals(paramBankcard.field_bindSerial))
        {
          paramBankcard = localc.HEk.iterator();
          while (paramBankcard.hasNext()) {
            localLinkedList.add(((d)paramBankcard.next()).Coh);
          }
          AppMethodBeat.o(70881);
          return localLinkedList;
        }
      }
    }
    AppMethodBeat.o(70881);
    return localLinkedList;
  }
  
  public Bankcard aeu(int paramInt)
  {
    AppMethodBeat.i(70878);
    Bankcard localBankcard;
    if (this.IfY)
    {
      localBankcard = (Bankcard)this.Hva.get(paramInt);
      AppMethodBeat.o(70878);
      return localBankcard;
    }
    int j = getCount();
    int i;
    if (this.CwO != null)
    {
      i = j;
      if (this.CwO.HYY.equals("CFT")) {}
    }
    else
    {
      i = j - 1;
    }
    if (paramInt < i)
    {
      localBankcard = (Bankcard)this.Hva.get(paramInt);
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
    if (this.IfY)
    {
      if (this.Hva == null)
      {
        AppMethodBeat.o(70877);
        return 0;
      }
      i = this.Hva.size();
      AppMethodBeat.o(70877);
      return i;
    }
    if ((this.CwO != null) && (this.CwO.HYY.equals("CFT"))) {}
    for (;;)
    {
      if (this.Hva != null)
      {
        int j = this.Hva.size();
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
      paramView = View.inflate(this.mContext, 2131496914, null);
      paramViewGroup = new a();
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131309195));
      paramViewGroup.BfZ = ((TextView)paramView.findViewById(2131308767));
      paramViewGroup.Igb = ((CheckedTextView)paramView.findViewById(2131298596));
      paramViewGroup.Igc = ((CdnImageView)paramView.findViewById(2131297265));
      paramViewGroup.Iga = ((FavourLayout)paramView.findViewById(2131300549));
      paramViewGroup.BfZ.setText("");
      paramView.setTag(paramViewGroup);
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      paramViewGroup.BfZ.setTextColor(MMApplicationContext.getResources().getColor(2131100594));
      paramViewGroup.Iga.setVisibility(8);
      localObject1 = aeu(paramInt);
      if (localObject1 != null) {
        break label342;
      }
      paramViewGroup.Igb.setVisibility(4);
      paramViewGroup.BfZ.setVisibility(8);
      paramViewGroup.titleTv.setText(2131768113);
      paramViewGroup.Igc.setVisibility(8);
      localObject1 = new LinkedList();
      if ((this.CwO == null) || (this.CwO.HZe == null) || (this.CwO.HZe.HEE == null)) {
        break label339;
      }
      localObject2 = this.CwO.HZe.HEE.HEa;
      if (localObject2 == null) {
        break label339;
      }
      localObject2 = ((n)localObject2).HEQ.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((LinkedList)localObject1).add(((o)((Iterator)localObject2).next()).Coh);
      }
      paramViewGroup = (a)paramView.getTag();
    }
    if ((this.IfX) && (((LinkedList)localObject1).size() > 0))
    {
      paramViewGroup.Iga.setVisibility(0);
      paramViewGroup.BfZ.setVisibility(8);
      paramViewGroup.Iga.setWording((LinkedList)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(70880);
      return paramView;
      label339:
      break;
      label342:
      paramViewGroup.Igc.setVisibility(0);
      paramViewGroup.Igb.setVisibility(0);
      paramViewGroup.BfZ.setVisibility(0);
      paramViewGroup.BfZ.setText("");
      if (((Bankcard)localObject1).fQf())
      {
        paramViewGroup.titleTv.setText(l.b(this.mContext, ((Bankcard)localObject1).field_desc, paramViewGroup.titleTv.getTextSize()));
        label409:
        if (!((Bankcard)localObject1).fQb()) {
          break label902;
        }
        localObject2 = t.fQI().Hwc;
        if (Util.isNullOrNil(((Bankcard)localObject2).HVD)) {
          break label837;
        }
        paramViewGroup.titleTv.setText(((Bankcard)localObject2).HVD);
        label448:
        paramViewGroup.BfZ.setVisibility(0);
        switch (((Bankcard)localObject1).a(this.HGc, this.CwO))
        {
        default: 
          if (!Util.isNullOrNil(((Bankcard)localObject1).field_tips))
          {
            paramViewGroup.BfZ.setText(((Bankcard)localObject1).field_tips);
            label539:
            localObject2 = paramViewGroup.BfZ.getText().toString();
            paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100904));
            if (!this.IfW.equalsIgnoreCase(((Bankcard)localObject1).field_bindSerial)) {
              break label1119;
            }
            paramViewGroup.Igb.setChecked(true);
            paramViewGroup.Igb.setEnabled(true);
            label604:
            paramViewGroup.Igc.setTag(2131310182, null);
            paramViewGroup.Igc.setTag(null);
            paramViewGroup.Igc.setImageDrawable(null);
            paramViewGroup.BfZ.setOnClickListener(null);
            if (!((Bankcard)localObject1).fQb()) {
              break label1184;
            }
            com.tencent.mm.plugin.wallet_core.utils.a.m(paramViewGroup.Igc);
          }
          break;
        }
      }
      for (;;)
      {
        if ((Util.isNullOrNil(((Bankcard)localObject1).field_forbid_title)) || (Util.isNullOrNil(((Bankcard)localObject1).field_forbid_url))) {
          break label1299;
        }
        localObject2 = (String)localObject2 + "  ";
        SpannableString localSpannableString = new SpannableString((String)localObject2 + ((Bankcard)localObject1).field_forbid_title);
        paramViewGroup.BfZ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70875);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletChangeBankcardAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            if ((paramAnonymousView.getTag() instanceof String))
            {
              localObject = new Intent();
              paramAnonymousView = (String)paramAnonymousView.getTag();
              Log.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", new Object[] { paramAnonymousView });
              ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject).putExtra("geta8key_username", z.aTY());
              ((Intent)localObject).putExtra("pay_channel", 1);
              f.b(k.a(k.this), (Intent)localObject, WalletChangeBankcardUI.HFZ);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletChangeBankcardAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70875);
          }
        });
        paramInt = ((String)localObject2).length();
        int i = ((String)localObject2).length();
        int j = ((Bankcard)localObject1).field_forbid_title.length();
        localSpannableString.setSpan(new ForegroundColorSpan(MMApplicationContext.getResources().getColor(2131101350)), paramInt, i + j, 34);
        paramViewGroup.BfZ.setText(localSpannableString);
        paramViewGroup.BfZ.setTag(((Bankcard)localObject1).field_forbid_url);
        break;
        paramViewGroup.titleTv.setText(((Bankcard)localObject1).field_desc);
        break label409;
        label837:
        if (((Bankcard)localObject2).HVC >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(ah.hhF(), new Object[] { f.D(((Bankcard)localObject2).HVC) }));
          break label448;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(2131767746));
        break label448;
        label902:
        if (!((Bankcard)localObject1).fQc()) {
          break label448;
        }
        if (!Util.isNullOrNil(((Bankcard)localObject1).HVD))
        {
          paramViewGroup.titleTv.setText(((Bankcard)localObject1).HVD);
          break label448;
        }
        if (((Bankcard)localObject1).HVC >= 0.0D)
        {
          paramViewGroup.titleTv.setText(this.mContext.getString(2131767830, new Object[] { f.D(((Bankcard)localObject1).HVC) }));
          break label448;
        }
        paramViewGroup.titleTv.setText(this.mContext.getText(2131767746));
        break label448;
        paramViewGroup.BfZ.setText(((Bankcard)localObject1).field_forbidWord);
        break label539;
        paramViewGroup.BfZ.setText(2131768119);
        break label539;
        paramViewGroup.BfZ.setText(2131768130);
        break label539;
        paramViewGroup.BfZ.setText(2131768125);
        break label539;
        paramViewGroup.BfZ.setText(2131768121);
        break label539;
        paramViewGroup.BfZ.setText(2131768117);
        break label539;
        paramViewGroup.BfZ.setText(2131768123);
        break label539;
        paramViewGroup.BfZ.setText(2131768128);
        break label539;
        paramViewGroup.BfZ.setVisibility(8);
        break label539;
        label1119:
        if (isEnabled(paramInt))
        {
          paramViewGroup.Igb.setChecked(false);
          paramViewGroup.Igb.setEnabled(true);
          break label604;
        }
        paramViewGroup.Igb.setEnabled(false);
        paramViewGroup.Igb.setChecked(false);
        paramViewGroup.titleTv.setTextColor(this.mContext.getResources().getColor(2131100594));
        break label604;
        label1184:
        if (((Bankcard)localObject1).fQc())
        {
          this.HCH.a((Bankcard)localObject1, paramViewGroup.Igc);
        }
        else if (((Bankcard)localObject1).fQf())
        {
          paramViewGroup.Igc.setImageDrawable(com.tencent.mm.svg.a.a.h(MMApplicationContext.getResources(), 2131690395));
          if (!Util.isNullOrNil(((Bankcard)localObject1).HVU))
          {
            paramViewGroup.Igc.setUseSdcardCache(true);
            paramViewGroup.Igc.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.fSn());
            paramViewGroup.Igc.gI(((Bankcard)localObject1).HVU, 2131690395);
          }
        }
        else
        {
          this.HCH.a(this.mContext, (Bankcard)localObject1, paramViewGroup.Igc);
        }
      }
      label1299:
      if ((this.IfX) && (Util.isNullOrNil(((Bankcard)localObject1).field_forbidWord)) && (Util.isNullOrNil((String)localObject2)))
      {
        localObject1 = h((Bankcard)localObject1);
        if (((LinkedList)localObject1).size() > 0)
        {
          paramViewGroup.Iga.setVisibility(0);
          paramViewGroup.BfZ.setVisibility(8);
          paramViewGroup.Iga.setWording((LinkedList)localObject1);
        }
      }
    }
  }
  
  public final void h(ArrayList<Bankcard> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(70882);
    if (paramArrayList == null) {}
    for (this.Hva = new ArrayList();; this.Hva = paramArrayList)
    {
      this.IfX = paramBoolean;
      if (this.Hva.size() > 0) {
        this.HCH.b(this.mContext, this.Hva);
      }
      notifyDataSetChanged();
      AppMethodBeat.o(70882);
      return;
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(70879);
    Bankcard localBankcard = aeu(paramInt);
    if (localBankcard == null)
    {
      AppMethodBeat.o(70879);
      return true;
    }
    if (localBankcard.a(this.HGc, this.CwO) != 0)
    {
      AppMethodBeat.o(70879);
      return false;
    }
    AppMethodBeat.o(70879);
    return true;
  }
  
  final class a
  {
    public TextView BfZ;
    public FavourLayout Iga;
    public CheckedTextView Igb;
    public CdnImageView Igc;
    public TextView titleTv;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.k
 * JD-Core Version:    0.7.0.1
 */