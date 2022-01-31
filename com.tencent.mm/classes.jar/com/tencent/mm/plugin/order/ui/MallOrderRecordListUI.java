package com.tencent.mm.plugin.order.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.ti;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MallOrderRecordListUI
  extends WalletBaseUI
{
  public int El = 0;
  public MMLoadMoreListView dso;
  public boolean isLoading = false;
  public Dialog klS = null;
  public boolean lUw = true;
  public int mCount = 0;
  public ah mHandler = null;
  public MallOrderRecordListUI.a mQP = null;
  public List<i> mQQ = new ArrayList();
  protected String mQR = null;
  public boolean mQS = false;
  protected Map<String, String> mQT = new HashMap();
  
  private boolean KK(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.mQQ.size())
      {
        i locali = (i)this.mQQ.get(i);
        if ((locali != null) && (paramString.equals(locali.mPI))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private static String dA(int paramInt1, int paramInt2)
  {
    return paramInt1 + "-" + paramInt2;
  }
  
  public final void bU(List<i> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if (this.mQQ == null) {
        this.mQQ = new ArrayList();
      }
      int i = 0;
      while (i < paramList.size())
      {
        i locali = (i)paramList.get(i);
        if (!KK(locali.mPI)) {
          this.mQQ.add(locali);
        }
        i += 1;
      }
    }
  }
  
  public final void bV(List<d> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        d locald = (d)paramList.get(i);
        if (locald != null)
        {
          String str = dA(locald.year, locald.month);
          this.mQT.put(str, locald.mPC);
        }
        i += 1;
      }
    }
  }
  
  public void brI()
  {
    kh(388);
    kh(389);
  }
  
  public void brJ()
  {
    ki(388);
    ki(389);
  }
  
  public void brK()
  {
    a(new com.tencent.mm.plugin.order.model.e(this.El, this.mQR), true, true);
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool;
    if ((paramm instanceof com.tencent.mm.plugin.order.model.e))
    {
      if (this.klS != null)
      {
        this.klS.dismiss();
        this.klS = null;
      }
      paramString = (com.tencent.mm.plugin.order.model.e)paramm;
      this.mQR = paramString.mPF;
      bU(paramString.mPD);
      bV(paramString.mPE);
      this.mCount = this.mQQ.size();
      if (paramString.iHi > this.mCount)
      {
        bool = true;
        this.lUw = bool;
        this.mQP.notifyDataSetChanged();
        y.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
        y.d("MicroMsg.WalletOrderListUI", "orders list total record: " + paramString.iHi);
        y.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.lUw);
        this.mHandler.post(new MallOrderRecordListUI.5(this));
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
          label306:
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
            this.mHandler.post(new MallOrderRecordListUI.6(this));
            break;
            paramString = paramString.brF();
            y.d("MicroMsg.WalletOrderListUI", "delete transId:" + paramString);
            if (!bk.bl(paramString))
            {
              paramm = this.mQQ.iterator();
              if (paramm.hasNext())
              {
                i locali = (i)paramm.next();
                if (!paramString.equals(locali.mPI)) {
                  break label306;
                }
                this.mQQ.remove(locali);
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
  
  public void en(String paramString1, String paramString2)
  {
    a(new g(paramString1, paramString2), true, true);
  }
  
  protected final int getLayoutId()
  {
    return a.g.mall_order_list;
  }
  
  protected final void initView()
  {
    if ((com.tencent.mm.wallet_core.a.aj(this) instanceof com.tencent.mm.plugin.order.a.a))
    {
      this.isLoading = true;
      brK();
    }
    setMMTitle(a.i.mall_index_ui_my_msg);
    this.dso = ((MMLoadMoreListView)findViewById(a.f.mall_order_list_lv));
    this.mQP = new MallOrderRecordListUI.a(this);
    this.dso.setAdapter(this.mQP);
    this.dso.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = MallOrderRecordListUI.this;
        if (paramAnonymousInt < paramAnonymousAdapterView.mQQ.size())
        {
          paramAnonymousView = (i)paramAnonymousAdapterView.mQQ.get(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            Bundle localBundle = paramAnonymousAdapterView.BX;
            localBundle.putString("key_trans_id", paramAnonymousView.mPI);
            localBundle.putInt("key_pay_type", paramAnonymousView.mPQ);
            localBundle.putString("bill_id", paramAnonymousView.mQb);
            com.tencent.mm.wallet_core.a.j(paramAnonymousAdapterView, localBundle);
          }
        }
        com.tencent.mm.wallet_core.ui.e.Jc(26);
      }
    });
    this.dso.setOnItemLongClickListener(new MallOrderRecordListUI.2(this));
    this.dso.setOnLoadMoreListener(new MallOrderRecordListUI.3(this));
    Object localObject = new ti();
    ((ti)localObject).ccU.bso = "6";
    ((ti)localObject).bFJ = new MallOrderRecordListUI.4(this, (ti)localObject);
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.plugin.order.a.b.brv().axs();
    this.mQP.notifyDataSetChanged();
    localObject = h.nFQ;
    com.tencent.mm.plugin.order.a.b.brv();
    ((h)localObject).f(11036, new Object[] { Integer.valueOf(com.tencent.mm.plugin.order.a.b.bry().brD()) });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mHandler = new ah();
    brI();
    initView();
    this.El = 0;
    this.mQR = null;
  }
  
  public void onDestroy()
  {
    brJ();
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mQP != null) {
      this.mQP.notifyDataSetChanged();
    }
  }
  
  public String vK(int paramInt)
  {
    return com.tencent.mm.wallet_core.ui.e.Jb(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI
 * JD-Core Version:    0.7.0.1
 */