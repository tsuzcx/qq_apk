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
import com.tencent.mm.protocal.protobuf.dlw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtArriveTimeLayout
  extends LinearLayout
{
  List<dlw> HwO;
  List<WeakReference<b>> HwP;
  dlw HwQ;
  private a HwR;
  boolean HwS;
  private View.OnClickListener qOH;
  
  public WalletLqtArriveTimeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(68743);
    this.HwO = new ArrayList();
    this.HwP = new ArrayList();
    this.HwS = false;
    this.qOH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68741);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtArriveTimeLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
        paramAnonymousView = (WalletLqtArriveTimeLayout.b)paramAnonymousView.getTag();
        if ((WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this) != null) && (WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).size() > paramAnonymousView.index))
        {
          paramAnonymousView.afT.setChecked(true);
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, (dlw)WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).get(paramAnonymousView.index));
        }
        for (;;)
        {
          WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
          Log.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousView.index), paramAnonymousView.mPa.getText() });
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
    this.HwO = new ArrayList();
    this.HwP = new ArrayList();
    this.HwS = false;
    this.qOH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68741);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtArriveTimeLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
        paramAnonymousView = (WalletLqtArriveTimeLayout.b)paramAnonymousView.getTag();
        if ((WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this) != null) && (WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).size() > paramAnonymousView.index))
        {
          paramAnonymousView.afT.setChecked(true);
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, (dlw)WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).get(paramAnonymousView.index));
        }
        for (;;)
        {
          WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
          Log.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousView.index), paramAnonymousView.mPa.getText() });
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
    paramb.afT.setEnabled(paramBoolean);
    paramb.mPa.setEnabled(paramBoolean);
    paramb.jVn.setEnabled(paramBoolean);
    paramb.jBN.setEnabled(paramBoolean);
    AppMethodBeat.o(68747);
  }
  
  private void fNv()
  {
    AppMethodBeat.i(68745);
    if (this.HwR != null) {
      this.HwR.fNw();
    }
    AppMethodBeat.o(68745);
  }
  
  public final void aUJ(String paramString)
  {
    AppMethodBeat.i(68748);
    Log.i("MicroMsg.WalletLqtArriveTimeLayout", "input money: %s", new Object[] { paramString });
    if ((this.HwO == null) || (this.HwO.isEmpty()))
    {
      AppMethodBeat.o(68748);
      return;
    }
    this.HwQ = null;
    Object localObject1 = this.HwP.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      if (((WeakReference)localObject2).get() != null)
      {
        ((b)((WeakReference)localObject2).get()).afT.setEnabled(true);
        ((b)((WeakReference)localObject2).get()).afT.setChecked(false);
      }
    }
    int j = f.nE(paramString, "100");
    paramString = this.HwO.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      localObject1 = (dlw)paramString.next();
      if ((((dlw)localObject1).MPB >= 0) && (j > ((dlw)localObject1).MPB))
      {
        Log.i("MicroMsg.WalletLqtArriveTimeLayout", "disable item: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((dlw)localObject1).MPB) });
        localObject1 = (b)((WeakReference)this.HwP.get(i)).get();
        if (localObject1 != null)
        {
          ((b)localObject1).afT.setChecked(false);
          a((b)localObject1, false);
          this.HwQ = null;
          fNv();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = (b)((WeakReference)this.HwP.get(i)).get();
        if (localObject2 != null)
        {
          a((b)localObject2, true);
          if (this.HwQ == null)
          {
            Log.i("MicroMsg.WalletLqtArriveTimeLayout", "auto select type: %s", new Object[] { Integer.valueOf(((dlw)localObject1).MJg) });
            ((b)localObject2).afT.setChecked(true);
            this.HwQ = ((dlw)localObject1);
            fNv();
            if (i > 0) {
              ((b)localObject2).mPa.setTextColor(MMApplicationContext.getContext().getResources().getColor(2131100566));
            } else {
              ((b)localObject2).fNx();
            }
          }
          else
          {
            ((b)localObject2).fNx();
          }
        }
      }
    }
    AppMethodBeat.o(68748);
  }
  
  public List<dlw> getRedeemTypeList()
  {
    return this.HwO;
  }
  
  public dlw getSelectRedeemType()
  {
    return this.HwQ;
  }
  
  public void setCallback(a parama)
  {
    this.HwR = parama;
  }
  
  public final void w(List<dlw> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(182505);
    this.HwS = true;
    this.HwO.clear();
    this.HwO.addAll(paramList);
    this.HwP.clear();
    removeAllViews();
    setVisibility(0);
    if ((this.HwO != null) && (!this.HwO.isEmpty()))
    {
      paramList = this.HwO.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        dlw localdlw = (dlw)paramList.next();
        LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131496955, this, false);
        b localb = new b((byte)0);
        localb.jBN = localLinearLayout;
        localb.mPa = ((TextView)localLinearLayout.findViewById(2131303994));
        localb.jVn = ((TextView)localLinearLayout.findViewById(2131303993));
        localb.afT = ((RadioButton)localLinearLayout.findViewById(2131303996));
        localb.mPa.setText(localdlw.MPz);
        if (!Util.isNullOrNil(localdlw.MPA))
        {
          localb.jVn.setText(localdlw.MPA);
          label217:
          if (this.HwQ != null) {
            Log.d("MicroMsg.WalletLqtArriveTimeLayout", "arrive wording: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.HwQ.MJg), Integer.valueOf(localdlw.MJg) });
          }
          if (!paramBoolean) {
            break label369;
          }
          if ((this.HwQ != null) && (this.HwQ.MJg == localdlw.MJg)) {
            localb.afT.setChecked(true);
          }
        }
        for (;;)
        {
          localb.index = i;
          localLinearLayout.setTag(localb);
          localLinearLayout.setOnClickListener(this.qOH);
          this.HwP.add(new WeakReference(localb));
          addView(localLinearLayout);
          i += 1;
          break;
          localb.jVn.setVisibility(8);
          break label217;
          label369:
          if (i == 0)
          {
            localb.afT.setChecked(true);
            this.HwQ = localdlw;
          }
        }
      }
    }
    AppMethodBeat.o(182505);
  }
  
  public static abstract interface a
  {
    public abstract void fNw();
  }
  
  static final class b
  {
    public RadioButton afT;
    public int index;
    public View jBN;
    public TextView jVn;
    public TextView mPa;
    
    public final void fNx()
    {
      AppMethodBeat.i(68742);
      this.mPa.setTextColor(MMApplicationContext.getContext().getResources().getColorStateList(2131101360));
      AppMethodBeat.o(68742);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout
 * JD-Core Version:    0.7.0.1
 */