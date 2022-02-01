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
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtArriveTimeLayout
  extends LinearLayout
{
  List<cnj> AZZ;
  List<WeakReference<b>> Baa;
  cnj Bab;
  private WalletLqtArriveTimeLayout.a Bac;
  boolean Bad;
  private View.OnClickListener oPc;
  
  public WalletLqtArriveTimeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(68743);
    this.AZZ = new ArrayList();
    this.Baa = new ArrayList();
    this.Bad = false;
    this.oPc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68741);
        WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
        paramAnonymousView = (WalletLqtArriveTimeLayout.b)paramAnonymousView.getTag();
        if ((WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this) != null) && (WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).size() > paramAnonymousView.index))
        {
          paramAnonymousView.adP.setChecked(true);
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, (cnj)WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).get(paramAnonymousView.index));
        }
        for (;;)
        {
          WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
          ac.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousView.index), paramAnonymousView.lfN.getText() });
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
    this.AZZ = new ArrayList();
    this.Baa = new ArrayList();
    this.Bad = false;
    this.oPc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68741);
        WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
        paramAnonymousView = (WalletLqtArriveTimeLayout.b)paramAnonymousView.getTag();
        if ((WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this) != null) && (WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).size() > paramAnonymousView.index))
        {
          paramAnonymousView.adP.setChecked(true);
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, (cnj)WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).get(paramAnonymousView.index));
        }
        for (;;)
        {
          WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
          ac.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousView.index), paramAnonymousView.lfN.getText() });
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
    paramb.adP.setEnabled(paramBoolean);
    paramb.lfN.setEnabled(paramBoolean);
    paramb.lgw.setEnabled(paramBoolean);
    paramb.ijA.setEnabled(paramBoolean);
    AppMethodBeat.o(68747);
  }
  
  private void eoG()
  {
    AppMethodBeat.i(68745);
    if (this.Bac != null) {
      this.Bac.eoH();
    }
    AppMethodBeat.o(68745);
  }
  
  public final void ayK(String paramString)
  {
    AppMethodBeat.i(68748);
    ac.i("MicroMsg.WalletLqtArriveTimeLayout", "input money: %s", new Object[] { paramString });
    if ((this.AZZ == null) || (this.AZZ.isEmpty()))
    {
      AppMethodBeat.o(68748);
      return;
    }
    this.Bab = null;
    Object localObject1 = this.Baa.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      if (((WeakReference)localObject2).get() != null)
      {
        ((b)((WeakReference)localObject2).get()).adP.setEnabled(true);
        ((b)((WeakReference)localObject2).get()).adP.setChecked(false);
      }
    }
    int j = e.mj(paramString, "100");
    paramString = this.AZZ.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      localObject1 = (cnj)paramString.next();
      if ((((cnj)localObject1).FAF >= 0) && (j > ((cnj)localObject1).FAF))
      {
        ac.i("MicroMsg.WalletLqtArriveTimeLayout", "disable item: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((cnj)localObject1).FAF) });
        localObject1 = (b)((WeakReference)this.Baa.get(i)).get();
        if (localObject1 != null)
        {
          ((b)localObject1).adP.setChecked(false);
          a((b)localObject1, false);
          this.Bab = null;
          eoG();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = (b)((WeakReference)this.Baa.get(i)).get();
        if (localObject2 != null)
        {
          a((b)localObject2, true);
          if (this.Bab == null)
          {
            ac.i("MicroMsg.WalletLqtArriveTimeLayout", "auto select type: %s", new Object[] { Integer.valueOf(((cnj)localObject1).FuV) });
            ((b)localObject2).adP.setChecked(true);
            this.Bab = ((cnj)localObject1);
            eoG();
            if (i > 0) {
              ((b)localObject2).lfN.setTextColor(ai.getContext().getResources().getColor(2131100464));
            } else {
              ((b)localObject2).eoI();
            }
          }
          else
          {
            ((b)localObject2).eoI();
          }
        }
      }
    }
    AppMethodBeat.o(68748);
  }
  
  public List<cnj> getRedeemTypeList()
  {
    return this.AZZ;
  }
  
  public cnj getSelectRedeemType()
  {
    return this.Bab;
  }
  
  public final void o(List<cnj> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(182505);
    this.Bad = true;
    this.AZZ.clear();
    this.AZZ.addAll(paramList);
    this.Baa.clear();
    removeAllViews();
    setVisibility(0);
    if ((this.AZZ != null) && (!this.AZZ.isEmpty()))
    {
      paramList = this.AZZ.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        cnj localcnj = (cnj)paramList.next();
        LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131495975, this, false);
        b localb = new b((byte)0);
        localb.ijA = localLinearLayout;
        localb.lfN = ((TextView)localLinearLayout.findViewById(2131301695));
        localb.lgw = ((TextView)localLinearLayout.findViewById(2131301694));
        localb.adP = ((RadioButton)localLinearLayout.findViewById(2131301697));
        localb.lfN.setText(localcnj.FAD);
        if (!bs.isNullOrNil(localcnj.FAE))
        {
          localb.lgw.setText(localcnj.FAE);
          label217:
          if (this.Bab != null) {
            ac.d("MicroMsg.WalletLqtArriveTimeLayout", "arrive wording: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.Bab.FuV), Integer.valueOf(localcnj.FuV) });
          }
          if (!paramBoolean) {
            break label369;
          }
          if ((this.Bab != null) && (this.Bab.FuV == localcnj.FuV)) {
            localb.adP.setChecked(true);
          }
        }
        for (;;)
        {
          localb.index = i;
          localLinearLayout.setTag(localb);
          localLinearLayout.setOnClickListener(this.oPc);
          this.Baa.add(new WeakReference(localb));
          addView(localLinearLayout);
          i += 1;
          break;
          localb.lgw.setVisibility(8);
          break label217;
          label369:
          if (i == 0)
          {
            localb.adP.setChecked(true);
            this.Bab = localcnj;
          }
        }
      }
    }
    AppMethodBeat.o(182505);
  }
  
  public void setCallback(WalletLqtArriveTimeLayout.a parama)
  {
    this.Bac = parama;
  }
  
  static final class b
  {
    public RadioButton adP;
    public View ijA;
    public int index;
    public TextView lfN;
    public TextView lgw;
    
    public final void eoI()
    {
      AppMethodBeat.i(68742);
      this.lfN.setTextColor(ai.getContext().getResources().getColorStateList(2131101117));
      AppMethodBeat.o(68742);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout
 * JD-Core Version:    0.7.0.1
 */