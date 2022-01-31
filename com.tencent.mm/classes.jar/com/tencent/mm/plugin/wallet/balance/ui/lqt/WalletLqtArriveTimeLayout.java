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
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtArriveTimeLayout
  extends LinearLayout
{
  private View.OnClickListener nyO;
  List<bsw> tPb;
  List<WeakReference<WalletLqtArriveTimeLayout.b>> tPc;
  bsw tPd;
  private WalletLqtArriveTimeLayout.a tPe;
  boolean tPf;
  
  public WalletLqtArriveTimeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(45505);
    this.tPb = new ArrayList();
    this.tPc = new ArrayList();
    this.tPf = false;
    this.nyO = new WalletLqtArriveTimeLayout.1(this);
    AppMethodBeat.o(45505);
  }
  
  public WalletLqtArriveTimeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(45506);
    this.tPb = new ArrayList();
    this.tPc = new ArrayList();
    this.tPf = false;
    this.nyO = new WalletLqtArriveTimeLayout.1(this);
    AppMethodBeat.o(45506);
  }
  
  private static void a(WalletLqtArriveTimeLayout.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(45509);
    paramb.VQ.setEnabled(paramBoolean);
    paramb.iJG.setEnabled(paramBoolean);
    paramb.kPB.setEnabled(paramBoolean);
    paramb.iCk.setEnabled(paramBoolean);
    AppMethodBeat.o(45509);
  }
  
  private void cRj()
  {
    AppMethodBeat.i(45507);
    if (this.tPe != null) {
      this.tPe.cRk();
    }
    AppMethodBeat.o(45507);
  }
  
  public final void aeR(String paramString)
  {
    AppMethodBeat.i(45510);
    ab.i("MicroMsg.WalletLqtArriveTimeLayout", "input money: %s", new Object[] { paramString });
    if ((this.tPb == null) || (this.tPb.isEmpty()))
    {
      AppMethodBeat.o(45510);
      return;
    }
    this.tPd = null;
    Object localObject1 = this.tPc.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      if (((WeakReference)localObject2).get() != null)
      {
        ((WalletLqtArriveTimeLayout.b)((WeakReference)localObject2).get()).VQ.setEnabled(true);
        ((WalletLqtArriveTimeLayout.b)((WeakReference)localObject2).get()).VQ.setChecked(false);
      }
    }
    int j = e.iL(paramString, "100");
    paramString = this.tPb.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      localObject1 = (bsw)paramString.next();
      if ((((bsw)localObject1).xGy >= 0) && (j > ((bsw)localObject1).xGy))
      {
        ab.i("MicroMsg.WalletLqtArriveTimeLayout", "disable item: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((bsw)localObject1).xGy) });
        localObject1 = (WalletLqtArriveTimeLayout.b)((WeakReference)this.tPc.get(i)).get();
        if (localObject1 != null)
        {
          ((WalletLqtArriveTimeLayout.b)localObject1).VQ.setChecked(false);
          a((WalletLqtArriveTimeLayout.b)localObject1, false);
          this.tPd = null;
          cRj();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = (WalletLqtArriveTimeLayout.b)((WeakReference)this.tPc.get(i)).get();
        if (localObject2 != null)
        {
          a((WalletLqtArriveTimeLayout.b)localObject2, true);
          if (this.tPd == null)
          {
            ab.i("MicroMsg.WalletLqtArriveTimeLayout", "auto select type: %s", new Object[] { Integer.valueOf(((bsw)localObject1).xBD) });
            ((WalletLqtArriveTimeLayout.b)localObject2).VQ.setChecked(true);
            this.tPd = ((bsw)localObject1);
            cRj();
            if (i > 0) {
              ((WalletLqtArriveTimeLayout.b)localObject2).iJG.setTextColor(ah.getContext().getResources().getColor(2131690139));
            } else {
              ((WalletLqtArriveTimeLayout.b)localObject2).cRl();
            }
          }
          else
          {
            ((WalletLqtArriveTimeLayout.b)localObject2).cRl();
          }
        }
      }
    }
    AppMethodBeat.o(45510);
  }
  
  public List<bsw> getRedeemTypeList()
  {
    return this.tPb;
  }
  
  public bsw getSelectRedeemType()
  {
    return this.tPd;
  }
  
  public void setCallback(WalletLqtArriveTimeLayout.a parama)
  {
    this.tPe = parama;
  }
  
  public void setRedeemTypeList(List<bsw> paramList)
  {
    AppMethodBeat.i(45508);
    this.tPf = true;
    this.tPb.addAll(paramList);
    this.tPc.clear();
    removeAllViews();
    setVisibility(0);
    if ((this.tPb != null) && (!this.tPb.isEmpty()))
    {
      paramList = this.tPb.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        bsw localbsw = (bsw)paramList.next();
        LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2130971199, this, false);
        WalletLqtArriveTimeLayout.b localb = new WalletLqtArriveTimeLayout.b((byte)0);
        localb.iCk = localLinearLayout;
        localb.iJG = ((TextView)localLinearLayout.findViewById(2131829189));
        localb.kPB = ((TextView)localLinearLayout.findViewById(2131829190));
        localb.VQ = ((RadioButton)localLinearLayout.findViewById(2131829191));
        ab.d("MicroMsg.WalletLqtArriveTimeLayout", "arrive wording: %s", new Object[] { localbsw.xGw });
        localb.iJG.setText(localbsw.xGw);
        if (!bo.isNullOrNil(localbsw.xGx)) {
          localb.kPB.setText(localbsw.xGx);
        }
        for (;;)
        {
          if (i == 0)
          {
            localb.VQ.setChecked(true);
            this.tPd = localbsw;
          }
          localb.index = i;
          localLinearLayout.setTag(localb);
          localLinearLayout.setOnClickListener(this.nyO);
          this.tPc.add(new WeakReference(localb));
          addView(localLinearLayout);
          i += 1;
          break;
          localb.kPB.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(45508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout
 * JD-Core Version:    0.7.0.1
 */