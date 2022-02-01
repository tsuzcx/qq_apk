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
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtArriveTimeLayout
  extends LinearLayout
{
  List<csm> CAm;
  List<WeakReference<b>> CAn;
  csm CAo;
  private WalletLqtArriveTimeLayout.a CAp;
  boolean CAq;
  private View.OnClickListener psK;
  
  public WalletLqtArriveTimeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(68743);
    this.CAm = new ArrayList();
    this.CAn = new ArrayList();
    this.CAq = false;
    this.psK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68741);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtArriveTimeLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
        paramAnonymousView = (WalletLqtArriveTimeLayout.b)paramAnonymousView.getTag();
        if ((WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this) != null) && (WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).size() > paramAnonymousView.index))
        {
          paramAnonymousView.afG.setChecked(true);
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, (csm)WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).get(paramAnonymousView.index));
        }
        for (;;)
        {
          WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
          ad.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousView.index), paramAnonymousView.lCL.getText() });
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
    this.CAm = new ArrayList();
    this.CAn = new ArrayList();
    this.CAq = false;
    this.psK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68741);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtArriveTimeLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
        paramAnonymousView = (WalletLqtArriveTimeLayout.b)paramAnonymousView.getTag();
        if ((WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this) != null) && (WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).size() > paramAnonymousView.index))
        {
          paramAnonymousView.afG.setChecked(true);
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, (csm)WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).get(paramAnonymousView.index));
        }
        for (;;)
        {
          WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
          ad.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousView.index), paramAnonymousView.lCL.getText() });
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
    paramb.lCL.setEnabled(paramBoolean);
    paramb.lDu.setEnabled(paramBoolean);
    paramb.iCR.setEnabled(paramBoolean);
    AppMethodBeat.o(68747);
  }
  
  private void eCG()
  {
    AppMethodBeat.i(68745);
    if (this.CAp != null) {
      this.CAp.eCH();
    }
    AppMethodBeat.o(68745);
  }
  
  public final void aDS(String paramString)
  {
    AppMethodBeat.i(68748);
    ad.i("MicroMsg.WalletLqtArriveTimeLayout", "input money: %s", new Object[] { paramString });
    if ((this.CAm == null) || (this.CAm.isEmpty()))
    {
      AppMethodBeat.o(68748);
      return;
    }
    this.CAo = null;
    Object localObject1 = this.CAn.iterator();
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
    int j = e.mH(paramString, "100");
    paramString = this.CAm.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      localObject1 = (csm)paramString.next();
      if ((((csm)localObject1).HkT >= 0) && (j > ((csm)localObject1).HkT))
      {
        ad.i("MicroMsg.WalletLqtArriveTimeLayout", "disable item: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((csm)localObject1).HkT) });
        localObject1 = (b)((WeakReference)this.CAn.get(i)).get();
        if (localObject1 != null)
        {
          ((b)localObject1).afG.setChecked(false);
          a((b)localObject1, false);
          this.CAo = null;
          eCG();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = (b)((WeakReference)this.CAn.get(i)).get();
        if (localObject2 != null)
        {
          a((b)localObject2, true);
          if (this.CAo == null)
          {
            ad.i("MicroMsg.WalletLqtArriveTimeLayout", "auto select type: %s", new Object[] { Integer.valueOf(((csm)localObject1).Hfa) });
            ((b)localObject2).afG.setChecked(true);
            this.CAo = ((csm)localObject1);
            eCG();
            if (i > 0) {
              ((b)localObject2).lCL.setTextColor(aj.getContext().getResources().getColor(2131100464));
            } else {
              ((b)localObject2).eCI();
            }
          }
          else
          {
            ((b)localObject2).eCI();
          }
        }
      }
    }
    AppMethodBeat.o(68748);
  }
  
  public List<csm> getRedeemTypeList()
  {
    return this.CAm;
  }
  
  public csm getSelectRedeemType()
  {
    return this.CAo;
  }
  
  public final void q(List<csm> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(182505);
    this.CAq = true;
    this.CAm.clear();
    this.CAm.addAll(paramList);
    this.CAn.clear();
    removeAllViews();
    setVisibility(0);
    if ((this.CAm != null) && (!this.CAm.isEmpty()))
    {
      paramList = this.CAm.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        csm localcsm = (csm)paramList.next();
        LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131495975, this, false);
        b localb = new b((byte)0);
        localb.iCR = localLinearLayout;
        localb.lCL = ((TextView)localLinearLayout.findViewById(2131301695));
        localb.lDu = ((TextView)localLinearLayout.findViewById(2131301694));
        localb.afG = ((RadioButton)localLinearLayout.findViewById(2131301697));
        localb.lCL.setText(localcsm.HkR);
        if (!bt.isNullOrNil(localcsm.HkS))
        {
          localb.lDu.setText(localcsm.HkS);
          label217:
          if (this.CAo != null) {
            ad.d("MicroMsg.WalletLqtArriveTimeLayout", "arrive wording: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.CAo.Hfa), Integer.valueOf(localcsm.Hfa) });
          }
          if (!paramBoolean) {
            break label369;
          }
          if ((this.CAo != null) && (this.CAo.Hfa == localcsm.Hfa)) {
            localb.afG.setChecked(true);
          }
        }
        for (;;)
        {
          localb.index = i;
          localLinearLayout.setTag(localb);
          localLinearLayout.setOnClickListener(this.psK);
          this.CAn.add(new WeakReference(localb));
          addView(localLinearLayout);
          i += 1;
          break;
          localb.lDu.setVisibility(8);
          break label217;
          label369:
          if (i == 0)
          {
            localb.afG.setChecked(true);
            this.CAo = localcsm;
          }
        }
      }
    }
    AppMethodBeat.o(182505);
  }
  
  public void setCallback(WalletLqtArriveTimeLayout.a parama)
  {
    this.CAp = parama;
  }
  
  static final class b
  {
    public RadioButton afG;
    public View iCR;
    public int index;
    public TextView lCL;
    public TextView lDu;
    
    public final void eCI()
    {
      AppMethodBeat.i(68742);
      this.lCL.setTextColor(aj.getContext().getResources().getColorStateList(2131101117));
      AppMethodBeat.o(68742);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout
 * JD-Core Version:    0.7.0.1
 */