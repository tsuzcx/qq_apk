package com.tencent.mm.plugin.order.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.plugin.order.model.h;
import com.tencent.mm.plugin.order.ui.a.b;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.c;
import java.util.List;

public class MallOrderTransactionInfoUI
  extends WalletPreferenceUI
{
  private int MGo;
  private MallTransactionObject MGp = null;
  private c MGq;
  protected f pkD;
  
  private Bundle getInput()
  {
    AppMethodBeat.i(66790);
    Bundle localBundle2 = com.tencent.mm.wallet_core.a.cl(this);
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    AppMethodBeat.o(66790);
    return localBundle1;
  }
  
  public final boolean d(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(66789);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof h))
      {
        paramString = ((h)paramp).MEV;
        if (paramString != null)
        {
          this.MGp = paramString.MDN;
          this.pkD.removeAll();
          AppCompatActivity localAppCompatActivity = getContext();
          f localf = this.pkD;
          MallTransactionObject localMallTransactionObject = this.MGp;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = this.MGq;
          if (localMallTransactionObject == null)
          {
            paramString = null;
            if (paramString != null)
            {
              paramInt1 = 0;
              while (paramInt1 < paramString.size())
              {
                paramp = (Preference)paramString.get(paramInt1);
                this.pkD.c(paramp);
                paramInt1 += 1;
              }
            }
          }
          else
          {
            switch (localMallTransactionObject.igp)
            {
            default: 
              paramp = new com.tencent.mm.plugin.order.ui.a.a();
              paramString = paramp;
              if ((arrayOfObject[0] instanceof c)) {
                ((com.tencent.mm.plugin.order.ui.a.a)paramp).MGq = ((c)arrayOfObject[0]);
              }
              break;
            }
            for (paramString = paramp;; paramString = new b())
            {
              paramString = paramString.a(localAppCompatActivity, localf, localMallTransactionObject);
              break;
            }
          }
          this.pkD.notifyDataSetChanged();
        }
      }
      AppMethodBeat.o(66789);
      return true;
    }
    AppMethodBeat.o(66789);
    return false;
  }
  
  public int getLayoutId()
  {
    return a.g.mall_order_ui;
  }
  
  public int getResourceId()
  {
    return a.m.mall_order_preference;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66787);
    setMMTitle(a.i.mall_order_detail_ui_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66785);
        MallOrderTransactionInfoUI.this.finish();
        AppMethodBeat.o(66785);
        return false;
      }
    });
    this.pkD = getPreferenceScreen();
    this.MGq = new c(this);
    this.MGq.jPl();
    AppMethodBeat.o(66787);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66786);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.wallet_core.a.cm(this);
    String str;
    if ((paramBundle != null) && ((paramBundle instanceof com.tencent.mm.plugin.order.a.a)))
    {
      str = getInput().getString("key_trans_id");
      paramBundle = getInput().getString("bill_id");
    }
    for (;;)
    {
      if (Util.isNullOrNil(str))
      {
        Log.w("MicroMsg.mmui.MMPreference", "mOrders info is Illegal!");
        k.a(getContext(), a.i.wallet_order_info_err, 0, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(66784);
            MallOrderTransactionInfoUI.this.finish();
            AppMethodBeat.o(66784);
          }
        });
      }
      this.MGo = getInput().getInt("key_pay_type");
      initView();
      jPx().a(new h(str, paramBundle), true, 1);
      AppMethodBeat.o(66786);
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
  
  public void onDestroy()
  {
    AppMethodBeat.i(66788);
    super.onDestroy();
    if (this.MGq != null) {
      this.MGq.release();
    }
    AppMethodBeat.o(66788);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI
 * JD-Core Version:    0.7.0.1
 */