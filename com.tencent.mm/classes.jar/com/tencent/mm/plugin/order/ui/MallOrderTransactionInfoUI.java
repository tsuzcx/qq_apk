package com.tencent.mm.plugin.order.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.plugin.order.ui.a.b;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.c;
import java.util.List;

public class MallOrderTransactionInfoUI
  extends WalletPreferenceUI
{
  protected f hcp;
  private int mRe;
  private MallTransactionObject mRf = null;
  private c mRg;
  
  private Bundle brL()
  {
    Bundle localBundle2 = com.tencent.mm.wallet_core.a.ai(this);
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    return localBundle1;
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public final boolean g(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        if ((paramm instanceof com.tencent.mm.plugin.order.model.h))
        {
          paramString = ((com.tencent.mm.plugin.order.model.h)paramm).mPG;
          if (paramString != null)
          {
            this.mRf = paramString.mOw;
            this.hcp.removeAll();
            AppCompatActivity localAppCompatActivity = this.mController.uMN;
            f localf = this.hcp;
            MallTransactionObject localMallTransactionObject = this.mRf;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = this.mRg;
            if (localMallTransactionObject == null)
            {
              paramString = null;
              if (paramString != null)
              {
                paramInt1 = 0;
                while (paramInt1 < paramString.size())
                {
                  paramm = (Preference)paramString.get(paramInt1);
                  this.hcp.a(paramm);
                  paramInt1 += 1;
                }
              }
            }
            else
            {
              switch (localMallTransactionObject.ccY)
              {
              default: 
                paramm = new com.tencent.mm.plugin.order.ui.a.a();
                paramString = paramm;
                if ((arrayOfObject[0] instanceof c)) {
                  ((com.tencent.mm.plugin.order.ui.a.a)paramm).mRg = ((c)arrayOfObject[0]);
                }
                break;
              }
              for (paramString = paramm;; paramString = new b())
              {
                paramString = paramString.a(localAppCompatActivity, localf, localMallTransactionObject);
                break;
              }
            }
            this.hcp.notifyDataSetChanged();
          }
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.mall_order_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.mall_order_detail_ui_title);
    setBackBtn(new MallOrderTransactionInfoUI.2(this));
    this.hcp = this.vdd;
    this.mRg = new c(this);
    this.mRg.init();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.wallet_core.a.aj(this);
    String str;
    if ((paramBundle != null) && ((paramBundle instanceof com.tencent.mm.plugin.order.a.a)))
    {
      str = brL().getString("key_trans_id");
      paramBundle = brL().getString("bill_id");
    }
    for (;;)
    {
      if (bk.bl(str))
      {
        y.w("MicroMsg.mmui.MMPreference", "mOrders info is Illegal!");
        com.tencent.mm.ui.base.h.a(this.mController.uMN, a.i.wallet_order_info_err, 0, new MallOrderTransactionInfoUI.1(this));
      }
      this.mRe = brL().getInt("key_pay_type");
      initView();
      cNr().a(new com.tencent.mm.plugin.order.model.h(str, paramBundle), true, 1);
      return;
      if ((getIntent().getIntExtra("scene", 0) == 1) || (getIntent().getIntExtra("scene", 0) == 2))
      {
        str = getIntent().getStringExtra("trans_id");
        paramBundle = getIntent().getStringExtra("bill_id");
      }
      else
      {
        paramBundle = null;
        str = null;
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mRg != null) {
      this.mRg.release();
    }
  }
  
  public final int xj()
  {
    return a.l.mall_order_preference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI
 * JD-Core Version:    0.7.0.1
 */