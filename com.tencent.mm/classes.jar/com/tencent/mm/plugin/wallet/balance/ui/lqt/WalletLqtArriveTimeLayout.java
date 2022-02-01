package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.protocal.protobuf.eok;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtArriveTimeLayout
  extends LinearLayout
{
  List<eok> Vdt;
  List<WeakReference<b>> Vdu;
  eok Vdv;
  private a Vdw;
  boolean Vdx;
  private View.OnClickListener xxi;
  
  public WalletLqtArriveTimeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(68743);
    this.Vdt = new ArrayList();
    this.Vdu = new ArrayList();
    this.Vdx = false;
    this.xxi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68741);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtArriveTimeLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
        paramAnonymousView = (WalletLqtArriveTimeLayout.b)paramAnonymousView.getTag();
        if ((WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this) != null) && (WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).size() > paramAnonymousView.index))
        {
          paramAnonymousView.nc.setChecked(true);
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, (eok)WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).get(paramAnonymousView.index));
        }
        for (;;)
        {
          WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
          Log.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousView.index), paramAnonymousView.sUt.getText() });
          a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtArriveTimeLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68741);
          return;
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, null);
        }
      }
    };
    AppMethodBeat.o(68743);
  }
  
  public WalletLqtArriveTimeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(68744);
    this.Vdt = new ArrayList();
    this.Vdu = new ArrayList();
    this.Vdx = false;
    this.xxi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68741);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtArriveTimeLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
        paramAnonymousView = (WalletLqtArriveTimeLayout.b)paramAnonymousView.getTag();
        if ((WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this) != null) && (WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).size() > paramAnonymousView.index))
        {
          paramAnonymousView.nc.setChecked(true);
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, (eok)WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).get(paramAnonymousView.index));
        }
        for (;;)
        {
          WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
          Log.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousView.index), paramAnonymousView.sUt.getText() });
          a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtArriveTimeLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68741);
          return;
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, null);
        }
      }
    };
    AppMethodBeat.o(68744);
  }
  
  private static void a(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(68747);
    paramb.nc.setEnabled(paramBoolean);
    paramb.sUt.setEnabled(paramBoolean);
    paramb.pJi.setEnabled(paramBoolean);
    paramb.plc.setEnabled(paramBoolean);
    AppMethodBeat.o(68747);
  }
  
  private void ieY()
  {
    AppMethodBeat.i(68745);
    if (this.Vdw != null) {
      this.Vdw.ieZ();
    }
    AppMethodBeat.o(68745);
  }
  
  public final void M(List<eok> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(182505);
    this.Vdx = true;
    this.Vdt.clear();
    this.Vdt.addAll(paramList);
    this.Vdu.clear();
    removeAllViews();
    setVisibility(0);
    if ((this.Vdt != null) && (!this.Vdt.isEmpty()))
    {
      paramList = this.Vdt.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        eok localeok = (eok)paramList.next();
        LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(a.g.wallet_lqt_save_arrive_time_item, this, false);
        b localb = new b((byte)0);
        localb.plc = localLinearLayout;
        localb.sUt = ((TextView)localLinearLayout.findViewById(a.f.lqt_save_arrive_time_item_title));
        localb.pJi = ((TextView)localLinearLayout.findViewById(a.f.lqt_save_arrive_time_item_desc));
        localb.nc = ((RadioButton)localLinearLayout.findViewById(a.f.lqt_save_arrive_time_rb));
        localb.sUt.setText(localeok.absL);
        if (!Util.isNullOrNil(localeok.absM))
        {
          localb.pJi.setText(localeok.absM);
          label221:
          if (this.Vdv != null) {
            Log.d("MicroMsg.WalletLqtArriveTimeLayout", "arrive wording: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.Vdv.ablG), Integer.valueOf(localeok.ablG) });
          }
          if (!paramBoolean) {
            break label372;
          }
          if ((this.Vdv != null) && (this.Vdv.ablG == localeok.ablG)) {
            localb.nc.setChecked(true);
          }
        }
        for (;;)
        {
          localb.index = i;
          localLinearLayout.setTag(localb);
          localLinearLayout.setOnClickListener(this.xxi);
          this.Vdu.add(new WeakReference(localb));
          addView(localLinearLayout);
          i += 1;
          break;
          localb.pJi.setVisibility(8);
          break label221;
          label372:
          if (i == 0)
          {
            localb.nc.setChecked(true);
            this.Vdv = localeok;
          }
        }
      }
    }
    AppMethodBeat.o(182505);
  }
  
  public final void bfX(String paramString)
  {
    AppMethodBeat.i(68748);
    Log.i("MicroMsg.WalletLqtArriveTimeLayout", "input money: %s", new Object[] { paramString });
    if ((this.Vdt == null) || (this.Vdt.isEmpty()))
    {
      AppMethodBeat.o(68748);
      return;
    }
    this.Vdv = null;
    Object localObject1 = this.Vdu.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      if (((WeakReference)localObject2).get() != null)
      {
        ((b)((WeakReference)localObject2).get()).nc.setEnabled(true);
        ((b)((WeakReference)localObject2).get()).nc.setChecked(false);
      }
    }
    int j = i.qx(paramString, "100");
    paramString = this.Vdt.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      localObject1 = (eok)paramString.next();
      if ((((eok)localObject1).absN >= 0) && (j > ((eok)localObject1).absN))
      {
        Log.i("MicroMsg.WalletLqtArriveTimeLayout", "disable item: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((eok)localObject1).absN) });
        localObject1 = (b)((WeakReference)this.Vdu.get(i)).get();
        if (localObject1 != null)
        {
          ((b)localObject1).nc.setChecked(false);
          a((b)localObject1, false);
          this.Vdv = null;
          ieY();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = (b)((WeakReference)this.Vdu.get(i)).get();
        if (localObject2 != null)
        {
          a((b)localObject2, true);
          if (this.Vdv == null)
          {
            Log.i("MicroMsg.WalletLqtArriveTimeLayout", "auto select type: %s", new Object[] { Integer.valueOf(((eok)localObject1).ablG) });
            ((b)localObject2).nc.setChecked(true);
            this.Vdv = ((eok)localObject1);
            ieY();
            if (i > 0) {
              ((b)localObject2).sUt.setTextColor(MMApplicationContext.getContext().getResources().getColor(a.c.green_text_color));
            } else {
              ((b)localObject2).ifa();
            }
          }
          else
          {
            ((b)localObject2).ifa();
          }
        }
      }
    }
    AppMethodBeat.o(68748);
  }
  
  public List<eok> getRedeemTypeList()
  {
    return this.Vdt;
  }
  
  public eok getSelectRedeemType()
  {
    return this.Vdv;
  }
  
  public void setCallback(a parama)
  {
    this.Vdw = parama;
  }
  
  public static abstract interface a
  {
    public abstract void ieZ();
  }
  
  static final class b
  {
    public int index;
    public RadioButton nc;
    public TextView pJi;
    public View plc;
    public TextView sUt;
    
    public final void ifa()
    {
      AppMethodBeat.i(68742);
      this.sUt.setTextColor(MMApplicationContext.getContext().getResources().getColorStateList(a.c.wallet_lqt_arrive_time_item_title_bg));
      AppMethodBeat.o(68742);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout
 * JD-Core Version:    0.7.0.1
 */