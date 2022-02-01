package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.List;

public class WalletBankcardDetailUI
  extends WalletBaseUI
{
  protected Bankcard Ooj;
  protected TextView OuT;
  private TextView OuU;
  private View OuV;
  protected LinearLayout OuW;
  protected LinearLayout OuX;
  protected LinearLayout OuY;
  
  private void BM(boolean paramBoolean)
  {
    AppMethodBeat.i(69093);
    if ((!z.bdq()) && (!paramBoolean) && (!((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).gNl()))
    {
      g.azK(0);
      com.tencent.mm.ui.base.h.a(this, a.i.wallet_bankcard_detail_unbind_dialog_tip, -1, a.i.wallet_bankcard_detail_unbind_dialog_open_gesture, a.i.wallet_bankcard_detail_unbind_dialog_unbind_btn, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69083);
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).m(WalletBankcardDetailUI.this, 1);
          g.azK(1);
          AppMethodBeat.o(69083);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69084);
          WalletBankcardDetailUI.b(WalletBankcardDetailUI.this);
          g.azK(2);
          AppMethodBeat.o(69084);
        }
      });
      AppMethodBeat.o(69093);
      return;
    }
    getInput().putBoolean("offline_pay", false);
    com.tencent.mm.wallet_core.a.l(this, getInput());
    AppMethodBeat.o(69093);
  }
  
  protected final void BL(boolean paramBoolean)
  {
    AppMethodBeat.i(69091);
    if (paramBoolean)
    {
      this.OuW.setVisibility(8);
      this.OuX.setVisibility(0);
      ((TextView)findViewById(a.f.wallet_bankcard_detail_bankphone)).setOnClickListener(new WalletBankcardDetailUI.2(this));
      TextView localTextView1 = (TextView)findViewById(a.f.wallet_bankcard_detail_per_order_kind);
      TextView localTextView2 = (TextView)findViewById(a.f.wallet_bankcard_detail_per_order_virtual);
      TextView localTextView3 = (TextView)findViewById(a.f.wallet_bankcard_detail_per_day_kind);
      TextView localTextView4 = (TextView)findViewById(a.f.wallet_bankcard_detail_per_day_virtual);
      localTextView1.setText(g.d(this.Ooj.field_onceQuotaKind, null));
      localTextView2.setText(g.d(this.Ooj.field_onceQuotaVirtual, null));
      localTextView3.setText(g.d(this.Ooj.field_dayQuotaKind, null));
      localTextView4.setText(g.d(this.Ooj.field_dayQuotaVirtual, null));
      if (!Util.isNullOrNil(this.Ooj.field_repay_url))
      {
        this.OuU.setVisibility(0);
        this.OuV.setVisibility(0);
      }
      AppMethodBeat.o(69091);
      return;
    }
    this.OuW.setVisibility(8);
    this.OuX.setVisibility(8);
    this.OuY.setVisibility(0);
    AppMethodBeat.o(69091);
  }
  
  protected final void gGC()
  {
    AppMethodBeat.i(69092);
    this.OuW.setVisibility(0);
    this.OuX.setVisibility(8);
    ((TextView)findViewById(a.f.wallet_bankcard_detail_expired_bankphone)).setOnClickListener(new WalletBankcardDetailUI.3(this));
    ((TextView)findViewById(a.f.wallet_bankcard_detail_unbind)).setOnClickListener(new WalletBankcardDetailUI.4(this));
    AppMethodBeat.o(69092);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_bankcard_detail;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69090);
    this.Ooj = ((Bankcard)getInput().getParcelable("key_bankcard"));
    if (this.Ooj == null)
    {
      AppMethodBeat.o(69090);
      return;
    }
    this.OuW = ((LinearLayout)findViewById(a.f.wallet_bankcard_detail_expired));
    this.OuX = ((LinearLayout)findViewById(a.f.wallet_bankcard_detail_ll));
    this.OuY = ((LinearLayout)findViewById(a.f.wallet_bankcard_detail_international_ll));
    this.OuU = ((TextView)findViewById(a.f.wallet_bankcard_detail_finance));
    this.OuV = findViewById(a.f.wallet_bankcard_detail_repay_layout);
    this.OuV.setOnClickListener(new WalletBankcardDetailUI.1(this));
    if (1 == this.Ooj.field_bankcardState)
    {
      gGC();
      AppMethodBeat.o(69090);
      return;
    }
    if (this.Ooj.gIK())
    {
      BL(true);
      this.OuT = ((TextView)findViewById(a.f.wallet_bankcard_detail_default));
      s.gGL();
      s.gGM();
      this.OuT.setVisibility(8);
    }
    for (;;)
    {
      addIconOptionMenu(0, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69082);
          s.gGL();
          paramAnonymousMenuItem = s.gGM().gKk();
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.size() > 1))
          {
            s.gGL();
            s.gGM();
          }
          paramAnonymousMenuItem = new ArrayList();
          com.tencent.mm.ui.base.h.b(WalletBankcardDetailUI.this, null, (String[])paramAnonymousMenuItem.toArray(new String[paramAnonymousMenuItem.size()]), WalletBankcardDetailUI.this.getString(a.i.wallet_index_ui_unbind_bankcard), new h.d()
          {
            public final void qy(int paramAnonymous2Int)
            {
              AppMethodBeat.i(69081);
              switch (paramAnonymous2Int)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(69081);
                return;
                WalletBankcardDetailUI.a(WalletBankcardDetailUI.this);
              }
            }
          });
          AppMethodBeat.o(69082);
          return true;
        }
      });
      AppMethodBeat.o(69090);
      return;
      BL(false);
      this.OuT = ((TextView)findViewById(a.f.wallet_bankcard_detail_international_default));
      s.gGL();
      s.gGM();
      this.OuT.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69087);
    super.onCreate(paramBundle);
    addSceneEndListener(621);
    setMMTitle(a.i.wallet_bankcard_detail_title);
    initView();
    AppMethodBeat.o(69087);
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(69094);
    Dialog localDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(a.i.wallet_bankcard_detail_bankphone_tips), getResources().getStringArray(a.b.wallet_phone_call), "", new WalletBankcardDetailUI.8(this));
    AppMethodBeat.o(69094);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69089);
    removeSceneEndListener(621);
    super.onDestroy();
    AppMethodBeat.o(69089);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69088);
    super.onResume();
    AppMethodBeat.o(69088);
  }
  
  public boolean onSceneEnd(final int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69095);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof com.tencent.mm.plugin.wallet.bind.a.b)) {
        if (this.OuT != null) {
          this.OuT.setVisibility(0);
        }
      }
    }
    while (!(paramq instanceof com.tencent.mm.plugin.wallet.bind.a.a)) {
      for (;;)
      {
        AppMethodBeat.o(69095);
        return false;
        if ((paramq instanceof com.tencent.mm.plugin.wallet.bind.a.a))
        {
          paramString = (com.tencent.mm.plugin.wallet.bind.a.a)paramq;
          Log.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo succ and level = " + paramString.Oum);
          switch (paramString.Oum)
          {
          default: 
            BM(false);
            break;
          case 2: 
          case 3: 
            paramInt1 = paramString.Oum;
            com.tencent.mm.ui.base.h.a(this, paramString.Oun, null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(69086);
                if (paramInt1 == 2) {
                  WalletBankcardDetailUI.b(WalletBankcardDetailUI.this);
                }
                paramAnonymousDialogInterface.dismiss();
                AppMethodBeat.o(69086);
              }
            });
          }
        }
      }
    }
    Log.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo error");
    BM(false);
    AppMethodBeat.o(69095);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI
 * JD-Core Version:    0.7.0.1
 */