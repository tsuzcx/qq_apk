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
import com.tencent.mm.protocal.protobuf.dvo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtArriveTimeLayout
  extends LinearLayout
{
  List<dvo> OoB;
  List<WeakReference<b>> OoC;
  dvo OoD;
  private a OoE;
  boolean OoF;
  private View.OnClickListener uqL;
  
  public WalletLqtArriveTimeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(68743);
    this.OoB = new ArrayList();
    this.OoC = new ArrayList();
    this.OoF = false;
    this.uqL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68741);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtArriveTimeLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
        paramAnonymousView = (WalletLqtArriveTimeLayout.b)paramAnonymousView.getTag();
        if ((WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this) != null) && (WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).size() > paramAnonymousView.index))
        {
          paramAnonymousView.md.setChecked(true);
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, (dvo)WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).get(paramAnonymousView.index));
        }
        for (;;)
        {
          WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
          Log.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousView.index), paramAnonymousView.pPT.getText() });
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
    this.OoB = new ArrayList();
    this.OoC = new ArrayList();
    this.OoF = false;
    this.uqL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68741);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtArriveTimeLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
        paramAnonymousView = (WalletLqtArriveTimeLayout.b)paramAnonymousView.getTag();
        if ((WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this) != null) && (WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).size() > paramAnonymousView.index))
        {
          paramAnonymousView.md.setChecked(true);
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, (dvo)WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).get(paramAnonymousView.index));
        }
        for (;;)
        {
          WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
          Log.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousView.index), paramAnonymousView.pPT.getText() });
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
    paramb.md.setEnabled(paramBoolean);
    paramb.pPT.setEnabled(paramBoolean);
    paramb.mMA.setEnabled(paramBoolean);
    paramb.mrI.setEnabled(paramBoolean);
    AppMethodBeat.o(68747);
  }
  
  private void gFZ()
  {
    AppMethodBeat.i(68745);
    if (this.OoE != null) {
      this.OoE.gGa();
    }
    AppMethodBeat.o(68745);
  }
  
  public final void bgs(String paramString)
  {
    AppMethodBeat.i(68748);
    Log.i("MicroMsg.WalletLqtArriveTimeLayout", "input money: %s", new Object[] { paramString });
    if ((this.OoB == null) || (this.OoB.isEmpty()))
    {
      AppMethodBeat.o(68748);
      return;
    }
    this.OoD = null;
    Object localObject1 = this.OoC.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      if (((WeakReference)localObject2).get() != null)
      {
        ((b)((WeakReference)localObject2).get()).md.setEnabled(true);
        ((b)((WeakReference)localObject2).get()).md.setChecked(false);
      }
    }
    int j = g.oz(paramString, "100");
    paramString = this.OoB.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      localObject1 = (dvo)paramString.next();
      if ((((dvo)localObject1).UbF >= 0) && (j > ((dvo)localObject1).UbF))
      {
        Log.i("MicroMsg.WalletLqtArriveTimeLayout", "disable item: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((dvo)localObject1).UbF) });
        localObject1 = (b)((WeakReference)this.OoC.get(i)).get();
        if (localObject1 != null)
        {
          ((b)localObject1).md.setChecked(false);
          a((b)localObject1, false);
          this.OoD = null;
          gFZ();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = (b)((WeakReference)this.OoC.get(i)).get();
        if (localObject2 != null)
        {
          a((b)localObject2, true);
          if (this.OoD == null)
          {
            Log.i("MicroMsg.WalletLqtArriveTimeLayout", "auto select type: %s", new Object[] { Integer.valueOf(((dvo)localObject1).TUV) });
            ((b)localObject2).md.setChecked(true);
            this.OoD = ((dvo)localObject1);
            gFZ();
            if (i > 0) {
              ((b)localObject2).pPT.setTextColor(MMApplicationContext.getContext().getResources().getColor(a.c.green_text_color));
            } else {
              ((b)localObject2).gGb();
            }
          }
          else
          {
            ((b)localObject2).gGb();
          }
        }
      }
    }
    AppMethodBeat.o(68748);
  }
  
  public List<dvo> getRedeemTypeList()
  {
    return this.OoB;
  }
  
  public dvo getSelectRedeemType()
  {
    return this.OoD;
  }
  
  public void setCallback(a parama)
  {
    this.OoE = parama;
  }
  
  public final void y(List<dvo> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(182505);
    this.OoF = true;
    this.OoB.clear();
    this.OoB.addAll(paramList);
    this.OoC.clear();
    removeAllViews();
    setVisibility(0);
    if ((this.OoB != null) && (!this.OoB.isEmpty()))
    {
      paramList = this.OoB.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        dvo localdvo = (dvo)paramList.next();
        LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(a.g.wallet_lqt_save_arrive_time_item, this, false);
        b localb = new b((byte)0);
        localb.mrI = localLinearLayout;
        localb.pPT = ((TextView)localLinearLayout.findViewById(a.f.lqt_save_arrive_time_item_title));
        localb.mMA = ((TextView)localLinearLayout.findViewById(a.f.lqt_save_arrive_time_item_desc));
        localb.md = ((RadioButton)localLinearLayout.findViewById(a.f.lqt_save_arrive_time_rb));
        localb.pPT.setText(localdvo.UbD);
        if (!Util.isNullOrNil(localdvo.UbE))
        {
          localb.mMA.setText(localdvo.UbE);
          label221:
          if (this.OoD != null) {
            Log.d("MicroMsg.WalletLqtArriveTimeLayout", "arrive wording: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.OoD.TUV), Integer.valueOf(localdvo.TUV) });
          }
          if (!paramBoolean) {
            break label373;
          }
          if ((this.OoD != null) && (this.OoD.TUV == localdvo.TUV)) {
            localb.md.setChecked(true);
          }
        }
        for (;;)
        {
          localb.index = i;
          localLinearLayout.setTag(localb);
          localLinearLayout.setOnClickListener(this.uqL);
          this.OoC.add(new WeakReference(localb));
          addView(localLinearLayout);
          i += 1;
          break;
          localb.mMA.setVisibility(8);
          break label221;
          label373:
          if (i == 0)
          {
            localb.md.setChecked(true);
            this.OoD = localdvo;
          }
        }
      }
    }
    AppMethodBeat.o(182505);
  }
  
  public static abstract interface a
  {
    public abstract void gGa();
  }
  
  static final class b
  {
    public int index;
    public TextView mMA;
    public RadioButton md;
    public View mrI;
    public TextView pPT;
    
    public final void gGb()
    {
      AppMethodBeat.i(68742);
      this.pPT.setTextColor(MMApplicationContext.getContext().getResources().getColorStateList(a.c.wallet_lqt_arrive_time_item_title_bg));
      AppMethodBeat.o(68742);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout
 * JD-Core Version:    0.7.0.1
 */