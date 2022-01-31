package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.g;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.i;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends i
{
  private LayoutInflater Lu;
  private View ipf;
  private MaxListView qDt;
  private TextView qDu;
  private j.a qDv;
  private j.b qDw;
  private a qnm;
  
  private j(Context paramContext)
  {
    super(paramContext, a.j.mmpwddialog);
    this.Lu = LayoutInflater.from(paramContext);
    this.ipf = LayoutInflater.from(paramContext).inflate(a.g.wallet_favor_dialog, null);
    this.qDt = ((MaxListView)this.ipf.findViewById(a.f.wallet_favor_list));
    this.qDu = ((TextView)this.ipf.findViewById(a.f.wallet_favor_discount));
    this.qDv = new j.a(this);
    this.qDt.setAdapter(this.qDv);
    this.ipf.findViewById(a.f.wallet_favor_footer).setOnClickListener(new j.1(this));
  }
  
  public static j a(Context paramContext, Orders paramOrders, String paramString, j.b paramb)
  {
    j localj = new j(paramContext);
    localj.setOnCancelListener(null);
    localj.setCancelable(true);
    localj.qnm = b.qAd.a(paramOrders);
    if (localj.qnm == null)
    {
      y.w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
      localj.dismiss();
    }
    Object localObject3;
    Object localObject1;
    int i;
    for (;;)
    {
      localj.qDw = paramb;
      localj.show();
      com.tencent.mm.ui.base.h.a(paramContext, localj);
      return localj;
      paramOrders = localj.qDv;
      localObject3 = paramOrders.qDx.qnm.qzX;
      localObject1 = paramOrders.qDx.qnm.QJ(paramString);
      paramOrders.qDz = paramOrders.qDx.qnm.bWr();
      paramOrders.qDA = paramOrders.qDx.qnm.QF((String)localObject1);
      paramOrders.qDy = -1;
      i = 0;
      for (;;)
      {
        if (i < paramOrders.qDz.size()) {
          if (((q)paramOrders.qDz.get(i)).qlR == 0) {
            break label256;
          }
        }
        label256:
        for (j = 1; j != 0; j = 0)
        {
          paramOrders.qDy = i;
          paramString = new LinkedList();
          if (paramOrders.qDz == null) {
            break label271;
          }
          i = 0;
          while (i < paramOrders.qDz.size())
          {
            paramString.add(((q)paramOrders.qDz.get(i)).qkQ);
            i += 1;
          }
        }
        i += 1;
      }
      label271:
      y.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] mFavorList null");
      i = 0;
      label281:
      if (i != 0) {
        break label652;
      }
      y.w("MicroMsg.WalletFavorDialog", "initFavorInfo failed & dismiss");
      localj.dismiss();
    }
    LinkedList localLinkedList = new LinkedList();
    if ((localObject3 != null) && (((f)localObject3).qkX != null))
    {
      i = 0;
      while (i < ((f)localObject3).qkX.size())
      {
        localObject2 = ((q)((f)localObject3).qkX.get(i)).qkQ;
        if (!paramString.contains(localObject2)) {
          localLinkedList.add(localObject2);
        }
        i += 1;
      }
    }
    Object localObject2 = new LinkedList();
    label433:
    String str;
    if ((localObject3 != null) && (((f)localObject3).qkY != null) && (((f)localObject3).qkY.qli != null))
    {
      localObject3 = ((f)localObject3).qkY.qli;
      i = 0;
      if (i >= ((List)localObject3).size()) {
        break label546;
      }
      str = ((com.tencent.mm.plugin.wallet.a.h)((List)localObject3).get(i)).qlk;
      j = 0;
      label465:
      if (j >= localLinkedList.size()) {
        break label683;
      }
      if (!str.contains((CharSequence)localLinkedList.get(j))) {}
    }
    label546:
    label683:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        ((List)localObject2).add(str);
      }
      i += 1;
      break label433;
      j += 1;
      break label465;
      y.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] favorInfo.favorComposeList or favorInfo.favorComposeList.favorComposeInfo null");
      i = 0;
      break label281;
      localLinkedList = new LinkedList();
      if ((!bk.bl((String)localObject1)) && (!((String)localObject1).equals("0")))
      {
        localObject1 = ((String)localObject1).split("-");
        if (localObject1 != null)
        {
          i = 0;
          while (i < localObject1.length)
          {
            localLinkedList.add(localObject1[i]);
            i += 1;
          }
        }
        y.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] preKeyArr null");
        i = 0;
        break label281;
      }
      paramOrders.qDB.c(paramString, localLinkedList, (List)localObject2);
      i = 1;
      break label281;
      localj.qDu.setText(a.i.wallet_favor_dialog_title);
      localj.qDt.setOnItemClickListener(new j.2(localj));
      break;
    }
  }
  
  private void bWF()
  {
    y.d("MicroMsg.WalletFavorDialog", "On selection done");
    if (this.qDv != null)
    {
      Object localObject = this.qDv.qDB;
      localObject = ((m)localObject).a(((m)localObject).qwa, -1);
      localObject = this.qnm.QI((String)localObject);
      this.qDw.a((FavorPayInfo)localObject);
    }
  }
  
  public final void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WalletFavorDialog", "dismiss exception, e = " + localException.getMessage());
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.ipf);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      bWF();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    setCanceledOnTouchOutside(paramBoolean);
  }
  
  static final class c
  {
    TextView haW;
    TextView iIV;
    TextView irN;
    View qDD;
    ImageView qDE;
    CheckBox qDF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.j
 * JD-Core Version:    0.7.0.1
 */