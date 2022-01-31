package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtArriveTimeLayout
  extends LinearLayout
{
  private View.OnClickListener laS = new WalletLqtArriveTimeLayout.1(this);
  List<bjx> qhG = new ArrayList();
  List<WeakReference<WalletLqtArriveTimeLayout.b>> qhH = new ArrayList();
  bjx qhI;
  private a qhJ;
  boolean qhK = false;
  
  public WalletLqtArriveTimeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WalletLqtArriveTimeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static void a(WalletLqtArriveTimeLayout.b paramb, boolean paramBoolean)
  {
    paramb.Vd.setEnabled(paramBoolean);
    paramb.haW.setEnabled(paramBoolean);
    paramb.iIV.setEnabled(paramBoolean);
    paramb.ipf.setEnabled(paramBoolean);
  }
  
  private void bTu()
  {
    if (this.qhJ != null) {
      this.qhJ.bTv();
    }
  }
  
  public final void Qi(String paramString)
  {
    y.i("MicroMsg.WalletLqtArriveTimeLayout", "input money: %s", new Object[] { paramString });
    if ((this.qhG == null) || (this.qhG.isEmpty())) {
      return;
    }
    int j = e.gI(paramString, "100");
    paramString = this.qhG.iterator();
    int i = 0;
    label54:
    Object localObject;
    if (paramString.hasNext())
    {
      localObject = (bjx)paramString.next();
      if ((((bjx)localObject).tDK < 0) || (j <= ((bjx)localObject).tDK)) {
        break label177;
      }
      y.i("MicroMsg.WalletLqtArriveTimeLayout", "disable item: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((bjx)localObject).tDK) });
      localObject = (WalletLqtArriveTimeLayout.b)((WeakReference)this.qhH.get(i)).get();
      if (localObject != null)
      {
        ((WalletLqtArriveTimeLayout.b)localObject).Vd.setChecked(false);
        a((WalletLqtArriveTimeLayout.b)localObject, false);
        this.qhI = null;
        bTu();
      }
    }
    for (;;)
    {
      i += 1;
      break label54;
      break;
      label177:
      WalletLqtArriveTimeLayout.b localb = (WalletLqtArriveTimeLayout.b)((WeakReference)this.qhH.get(i)).get();
      if (localb != null)
      {
        a(localb, true);
        if (this.qhI == null)
        {
          y.i("MicroMsg.WalletLqtArriveTimeLayout", "auto select type: %s", new Object[] { Integer.valueOf(((bjx)localObject).tAb) });
          localb.Vd.setChecked(true);
          this.qhI = ((bjx)localObject);
          bTu();
        }
      }
    }
  }
  
  public List<bjx> getRedeemTypeList()
  {
    return this.qhG;
  }
  
  public bjx getSelectRedeemType()
  {
    return this.qhI;
  }
  
  public void setCallback(a parama)
  {
    this.qhJ = parama;
  }
  
  public void setRedeemTypeList(List<bjx> paramList)
  {
    this.qhK = true;
    this.qhG.addAll(paramList);
    this.qhH.clear();
    removeAllViews();
    setVisibility(0);
    if ((this.qhG != null) && (!this.qhG.isEmpty()))
    {
      paramList = this.qhG.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        bjx localbjx = (bjx)paramList.next();
        LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(a.g.wallet_lqt_save_arrive_time_item, this, false);
        WalletLqtArriveTimeLayout.b localb = new WalletLqtArriveTimeLayout.b((byte)0);
        localb.ipf = localLinearLayout;
        localb.haW = ((TextView)localLinearLayout.findViewById(a.f.lqt_save_arrive_time_item_title));
        localb.iIV = ((TextView)localLinearLayout.findViewById(a.f.lqt_save_arrive_time_item_desc));
        localb.Vd = ((RadioButton)localLinearLayout.findViewById(a.f.lqt_save_arrive_time_rb));
        localb.haW.setText(localbjx.tDI);
        if (!bk.bl(localbjx.tDJ)) {
          localb.iIV.setText(localbjx.tDJ);
        }
        for (;;)
        {
          if (i == 0)
          {
            localb.Vd.setChecked(true);
            this.qhI = localbjx;
          }
          localb.index = i;
          localLinearLayout.setTag(localb);
          localLinearLayout.setOnClickListener(this.laS);
          this.qhH.add(new WeakReference(localb));
          addView(localLinearLayout);
          i += 1;
          break;
          localb.iIV.setVisibility(8);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bTv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout
 * JD-Core Version:    0.7.0.1
 */