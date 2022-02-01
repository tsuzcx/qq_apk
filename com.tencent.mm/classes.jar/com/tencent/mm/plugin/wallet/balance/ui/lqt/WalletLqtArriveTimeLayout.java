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
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtArriveTimeLayout
  extends LinearLayout
{
  List<ctg> CRR;
  List<WeakReference<b>> CRS;
  ctg CRT;
  private a CRU;
  boolean CRV;
  private View.OnClickListener pzq;
  
  public WalletLqtArriveTimeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(68743);
    this.CRR = new ArrayList();
    this.CRS = new ArrayList();
    this.CRV = false;
    this.pzq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68741);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtArriveTimeLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
        paramAnonymousView = (WalletLqtArriveTimeLayout.b)paramAnonymousView.getTag();
        if ((WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this) != null) && (WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).size() > paramAnonymousView.index))
        {
          paramAnonymousView.afG.setChecked(true);
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, (ctg)WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).get(paramAnonymousView.index));
        }
        for (;;)
        {
          WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
          ae.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousView.index), paramAnonymousView.lHk.getText() });
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
    this.CRR = new ArrayList();
    this.CRS = new ArrayList();
    this.CRV = false;
    this.pzq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68741);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtArriveTimeLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
        paramAnonymousView = (WalletLqtArriveTimeLayout.b)paramAnonymousView.getTag();
        if ((WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this) != null) && (WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).size() > paramAnonymousView.index))
        {
          paramAnonymousView.afG.setChecked(true);
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, (ctg)WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).get(paramAnonymousView.index));
        }
        for (;;)
        {
          WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
          ae.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousView.index), paramAnonymousView.lHk.getText() });
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
    paramb.afG.setEnabled(paramBoolean);
    paramb.lHk.setEnabled(paramBoolean);
    paramb.lHT.setEnabled(paramBoolean);
    paramb.iFK.setEnabled(paramBoolean);
    AppMethodBeat.o(68747);
  }
  
  private void eGn()
  {
    AppMethodBeat.i(68745);
    if (this.CRU != null) {
      this.CRU.eGo();
    }
    AppMethodBeat.o(68745);
  }
  
  public final void aFl(String paramString)
  {
    AppMethodBeat.i(68748);
    ae.i("MicroMsg.WalletLqtArriveTimeLayout", "input money: %s", new Object[] { paramString });
    if ((this.CRR == null) || (this.CRR.isEmpty()))
    {
      AppMethodBeat.o(68748);
      return;
    }
    this.CRT = null;
    Object localObject1 = this.CRS.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      if (((WeakReference)localObject2).get() != null)
      {
        ((b)((WeakReference)localObject2).get()).afG.setEnabled(true);
        ((b)((WeakReference)localObject2).get()).afG.setChecked(false);
      }
    }
    int j = f.mN(paramString, "100");
    paramString = this.CRR.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      localObject1 = (ctg)paramString.next();
      if ((((ctg)localObject1).HEt >= 0) && (j > ((ctg)localObject1).HEt))
      {
        ae.i("MicroMsg.WalletLqtArriveTimeLayout", "disable item: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((ctg)localObject1).HEt) });
        localObject1 = (b)((WeakReference)this.CRS.get(i)).get();
        if (localObject1 != null)
        {
          ((b)localObject1).afG.setChecked(false);
          a((b)localObject1, false);
          this.CRT = null;
          eGn();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = (b)((WeakReference)this.CRS.get(i)).get();
        if (localObject2 != null)
        {
          a((b)localObject2, true);
          if (this.CRT == null)
          {
            ae.i("MicroMsg.WalletLqtArriveTimeLayout", "auto select type: %s", new Object[] { Integer.valueOf(((ctg)localObject1).HyA) });
            ((b)localObject2).afG.setChecked(true);
            this.CRT = ((ctg)localObject1);
            eGn();
            if (i > 0) {
              ((b)localObject2).lHk.setTextColor(ak.getContext().getResources().getColor(2131100464));
            } else {
              ((b)localObject2).eGp();
            }
          }
          else
          {
            ((b)localObject2).eGp();
          }
        }
      }
    }
    AppMethodBeat.o(68748);
  }
  
  public List<ctg> getRedeemTypeList()
  {
    return this.CRR;
  }
  
  public ctg getSelectRedeemType()
  {
    return this.CRT;
  }
  
  public final void q(List<ctg> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(182505);
    this.CRV = true;
    this.CRR.clear();
    this.CRR.addAll(paramList);
    this.CRS.clear();
    removeAllViews();
    setVisibility(0);
    if ((this.CRR != null) && (!this.CRR.isEmpty()))
    {
      paramList = this.CRR.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        ctg localctg = (ctg)paramList.next();
        LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131495975, this, false);
        b localb = new b((byte)0);
        localb.iFK = localLinearLayout;
        localb.lHk = ((TextView)localLinearLayout.findViewById(2131301695));
        localb.lHT = ((TextView)localLinearLayout.findViewById(2131301694));
        localb.afG = ((RadioButton)localLinearLayout.findViewById(2131301697));
        localb.lHk.setText(localctg.HEr);
        if (!bu.isNullOrNil(localctg.HEs))
        {
          localb.lHT.setText(localctg.HEs);
          label217:
          if (this.CRT != null) {
            ae.d("MicroMsg.WalletLqtArriveTimeLayout", "arrive wording: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.CRT.HyA), Integer.valueOf(localctg.HyA) });
          }
          if (!paramBoolean) {
            break label369;
          }
          if ((this.CRT != null) && (this.CRT.HyA == localctg.HyA)) {
            localb.afG.setChecked(true);
          }
        }
        for (;;)
        {
          localb.index = i;
          localLinearLayout.setTag(localb);
          localLinearLayout.setOnClickListener(this.pzq);
          this.CRS.add(new WeakReference(localb));
          addView(localLinearLayout);
          i += 1;
          break;
          localb.lHT.setVisibility(8);
          break label217;
          label369:
          if (i == 0)
          {
            localb.afG.setChecked(true);
            this.CRT = localctg;
          }
        }
      }
    }
    AppMethodBeat.o(182505);
  }
  
  public void setCallback(a parama)
  {
    this.CRU = parama;
  }
  
  public static abstract interface a
  {
    public abstract void eGo();
  }
  
  static final class b
  {
    public RadioButton afG;
    public View iFK;
    public int index;
    public TextView lHT;
    public TextView lHk;
    
    public final void eGp()
    {
      AppMethodBeat.i(68742);
      this.lHk.setTextColor(ak.getContext().getResources().getColorStateList(2131101117));
      AppMethodBeat.o(68742);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout
 * JD-Core Version:    0.7.0.1
 */