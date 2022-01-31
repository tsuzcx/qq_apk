package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.app.Dialog;
import android.view.View;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.a;
import com.tencent.mm.plugin.wallet_payu.order.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.protocal.c.bdz;
import com.tencent.mm.protocal.c.bej;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class PayUMallOrderRecordListUI
  extends MallOrderRecordListUI
{
  protected final void brI()
  {
    kh(1519);
    kh(1544);
  }
  
  protected final void brJ()
  {
    ki(1519);
    ki(1544);
  }
  
  protected final void brK()
  {
    a(new a(this.El), true, true);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    Object localObject;
    boolean bool;
    if ((paramm instanceof a))
    {
      if (this.klS != null)
      {
        this.klS.dismiss();
        this.klS = null;
      }
      paramString = (a)paramm;
      localObject = ((bdz)paramString.dmK.ecF.ecN).tzl;
      paramm = new LinkedList();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bej localbej = (bej)((Iterator)localObject).next();
        i locali = new i();
        locali.kVn = localbej.kVn;
        locali.mPS = localbej.mPS;
        locali.mPT = localbej.mPT;
        locali.mPL = localbej.mPL;
        locali.mPO = localbej.mPO;
        locali.mPK = localbej.mPK;
        locali.mPR = "0";
        locali.mPN = localbej.mPN;
        locali.mPQ = localbej.mPQ;
        locali.mPW = 1;
        locali.mPV = localbej.mPV;
        locali.mPU = localbej.mPU;
        locali.mPP = localbej.mPP;
        locali.mPJ = localbej.tze;
        locali.mPM = localbej.mPM;
        locali.mPI = localbej.mPI;
        paramm.add(locali);
      }
      bU(paramm);
      bV(null);
      this.mCount = this.mQQ.size();
      if (paramString.bXI() > this.mCount)
      {
        bool = true;
        this.lUw = bool;
        this.mQP.notifyDataSetChanged();
        y.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
        y.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + paramString.bXI());
        y.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.lUw);
        this.mHandler.post(new PayUMallOrderRecordListUI.1(this));
        this.isLoading = false;
      }
    }
    for (;;)
    {
      if ((this.mCount <= 0) && (this.mQQ.size() == 0))
      {
        showOptionMenu(false);
        findViewById(a.f.empty_tip_layout).setVisibility(0);
        return true;
        bool = false;
        break;
        if ((paramm instanceof g))
        {
          if (this.klS != null)
          {
            this.klS.dismiss();
            this.klS = null;
          }
          paramString = (g)paramm;
          label523:
          if (paramString.brE() == 2)
          {
            if (this.mQQ != null) {
              this.mQQ.clear();
            }
            this.mCount = 0;
            this.lUw = false;
            this.dso.cAP();
          }
          for (;;)
          {
            this.mHandler.post(new PayUMallOrderRecordListUI.2(this));
            break;
            paramString = paramString.brF();
            y.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:" + paramString);
            if (!bk.bl(paramString))
            {
              paramm = this.mQQ.iterator();
              if (paramm.hasNext())
              {
                localObject = (i)paramm.next();
                if (!paramString.equals(((i)localObject).mPI)) {
                  break label523;
                }
                this.mQQ.remove(localObject);
                this.mCount = this.mQQ.size();
              }
            }
          }
        }
      }
    }
    showOptionMenu(true);
    findViewById(a.f.empty_tip_layout).setVisibility(8);
    return true;
  }
  
  protected final void en(String paramString1, String paramString2)
  {
    a(new com.tencent.mm.plugin.wallet_payu.order.a.b(paramString1), true, true);
  }
  
  protected final String vK(int paramInt)
  {
    return e.a(paramInt, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI
 * JD-Core Version:    0.7.0.1
 */