package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.c.ak;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.g.a;

public class WalletDelayTransferSettingUI
  extends MMPreference
  implements i
{
  private TextView EUI;
  private String IoN;
  private WalletDelayTransferUISelectPreference OAV;
  private WalletDelayTransferUISelectPreference OAW;
  private WalletDelayTransferUISelectPreference OAX;
  private TextView OAY;
  private String OAZ;
  private String OBa;
  private int OBb = 0;
  private int OBc = 0;
  private int jaR = 1;
  private String mTitle;
  private com.tencent.mm.ui.base.preference.f screen;
  private long tZb;
  
  private void BU(boolean paramBoolean)
  {
    AppMethodBeat.i(267545);
    if (abt(16))
    {
      gHG();
      if (!paramBoolean)
      {
        this.OBc = 2;
        com.tencent.mm.plugin.report.service.h.IzE.a(23319, new Object[] { Integer.valueOf(this.jaR), Integer.valueOf(this.OBc), Integer.valueOf(0) });
        AppMethodBeat.o(267545);
      }
    }
    else if (abt(32))
    {
      gHH();
      if (!paramBoolean)
      {
        this.OBc = 3;
        com.tencent.mm.plugin.report.service.h.IzE.a(23319, new Object[] { Integer.valueOf(this.jaR), Integer.valueOf(this.OBc), Integer.valueOf(0) });
        AppMethodBeat.o(267545);
      }
    }
    else
    {
      gHF();
      if (!paramBoolean)
      {
        this.OBc = 1;
        com.tencent.mm.plugin.report.service.h.IzE.a(23319, new Object[] { Integer.valueOf(this.jaR), Integer.valueOf(this.OBc), Integer.valueOf(0) });
      }
    }
    AppMethodBeat.o(267545);
  }
  
  private boolean abt(int paramInt)
  {
    return (this.tZb & paramInt) != 0L;
  }
  
  private void gHE()
  {
    AppMethodBeat.i(69621);
    if ((this.OBb == 1) && (!Util.isNullOrNil(this.IoN)))
    {
      addIconOptionMenu(0, a.e.wallet_qanda_icon, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69618);
          com.tencent.mm.wallet_core.ui.g.p(WalletDelayTransferSettingUI.this.getContext(), WalletDelayTransferSettingUI.a(WalletDelayTransferSettingUI.this), false);
          AppMethodBeat.o(69618);
          return false;
        }
      });
      AppMethodBeat.o(69621);
      return;
    }
    removeAllOptionMenu();
    AppMethodBeat.o(69621);
  }
  
  private void gHF()
  {
    AppMethodBeat.i(69627);
    this.OAV.isSelected = true;
    this.OAW.isSelected = false;
    this.OAX.isSelected = false;
    AppMethodBeat.o(69627);
  }
  
  private void gHG()
  {
    AppMethodBeat.i(69628);
    this.OAV.isSelected = false;
    this.OAW.isSelected = true;
    this.OAX.isSelected = false;
    AppMethodBeat.o(69628);
  }
  
  private void gHH()
  {
    AppMethodBeat.i(69629);
    this.OAV.isSelected = false;
    this.OAW.isSelected = false;
    this.OAX.isSelected = true;
    AppMethodBeat.o(69629);
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(267550);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setPadding(0, 0, 0, com.tencent.mm.ci.a.aZ(getContext(), a.d.Edge_12A));
    localLinearLayout.setOrientation(1);
    Button localButton = new Button(getContext());
    localLinearLayout.addView(localButton);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(localButton.getLayoutParams());
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 17;
    localButton.setTextColor(getResources().getColor(a.c.color_btn_text_selector));
    localButton.setBackground(getDrawable(a.e.btn_solid_green));
    localButton.setTextSize(1, 17.0F);
    localButton.setPadding(com.tencent.mm.ci.a.aZ(getContext(), a.d.LargeBtnPadding), 0, com.tencent.mm.ci.a.aZ(getContext(), a.d.LargeBtnPadding), 0);
    localButton.setMinHeight(com.tencent.mm.ci.a.aZ(getContext(), a.d.MiddleBtnHeight));
    localButton.setMinWidth(com.tencent.mm.ci.a.aZ(getContext(), a.d.MiddleBtnWidth));
    localButton.setText(getString(a.i.wallet_balance_result_next));
    localButton.setGravity(17);
    localButton.setLayoutParams(localLayoutParams);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(247773);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pwd/ui/WalletDelayTransferSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletDelayTransferSettingUI.b(WalletDelayTransferSettingUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletDelayTransferSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247773);
      }
    });
    AppMethodBeat.o(267550);
    return localLinearLayout;
  }
  
  public int getHeaderResourceId()
  {
    return a.g.wallet_delay_transfer_header_ui;
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69622);
    this.OAV = ((WalletDelayTransferUISelectPreference)this.screen.byG("wallet_transfer_realtime"));
    this.OAW = ((WalletDelayTransferUISelectPreference)this.screen.byG("wallet_transfer_2h"));
    this.OAX = ((WalletDelayTransferUISelectPreference)this.screen.byG("wallet_transfer_24h"));
    this.OAY = ((TextView)findViewById(a.f.delay_transfer_header_title_tv));
    ar.a(this.OAY.getPaint(), 0.8F);
    this.EUI = ((TextView)findViewById(a.f.delay_transfer_header_desc_tv));
    this.OAV.auO(8);
    this.OAW.auO(8);
    this.OAX.auO(8);
    BU(false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(69619);
        WalletDelayTransferSettingUI.this.finish();
        AppMethodBeat.o(69619);
        return false;
      }
    });
    AppMethodBeat.o(69622);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69620);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(a.c.BG_2));
    setBackGroundColorResource(a.c.BG_2);
    hideActionbarLine();
    this.screen = getPreferenceScreen();
    this.jaR = getIntent().getIntExtra("key_scene", 1);
    if (getListView() != null)
    {
      int i = getContext().getResources().getDimensionPixelSize(a.d.Edge_4A);
      getListView().setPadding(i, 0, i, 0);
      getListView().setBackgroundColor(getContext().getResources().getColor(a.c.BG_2));
    }
    paramBundle = (RelativeLayout)findViewById(a.f.mm_preference_list_content_root);
    if (paramBundle != null) {
      paramBundle.setBackgroundColor(getContext().getResources().getColor(a.c.BG_2));
    }
    this.screen.auC(a.m.wallet_delay_transfer_setting_pref);
    com.tencent.mm.kernel.h.aHH();
    this.tZb = ((Long)com.tencent.mm.kernel.h.aHG().aHp().b(147457, Long.valueOf(0L))).longValue();
    initView();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(385, this);
    com.tencent.mm.kernel.h.aHH();
    this.OAZ = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VnO, ""));
    com.tencent.mm.kernel.h.aHH();
    this.OBa = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VnP, ""));
    com.tencent.mm.kernel.h.aHH();
    this.mTitle = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VnN, ""));
    com.tencent.mm.kernel.h.aHH();
    this.IoN = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VnR, ""));
    com.tencent.mm.kernel.h.aHH();
    this.OBb = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VnS, Integer.valueOf(0))).intValue();
    if ((Util.isNullOrNil(this.OAZ)) || (Util.isNullOrNil(this.mTitle)) || (Util.isNullOrNil(this.IoN)) || (Util.isNullOrNil(this.OBa))) {}
    for (boolean bool = ak.a(true, null);; bool = ak.a(false, null))
    {
      com.tencent.mm.wallet_core.ui.g.iju();
      if (!bool)
      {
        Log.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.b(385, this);
      }
      AppMethodBeat.o(69620);
      return;
      this.EUI.setText(this.OAZ);
      this.OAY.setText(this.mTitle);
      gHE();
    }
  }
  
  public void onDestroy()
  {
    int i = 1;
    AppMethodBeat.i(69623);
    super.onDestroy();
    Log.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", new Object[] { Long.valueOf(this.tZb) });
    if (abt(16)) {}
    for (;;)
    {
      cyu localcyu = new cyu();
      localcyu.Iza = i;
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(205, localcyu));
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(385, this);
      AppMethodBeat.o(69623);
      return;
      if (abt(32)) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69624);
    paramPreference = paramPreference.mKey;
    if ("wallet_transfer_realtime".equals(paramPreference))
    {
      this.tZb &= 0xFFFFFFEF;
      this.tZb &= 0xFFFFFFDF;
    }
    for (;;)
    {
      BU(true);
      paramf.notifyDataSetChanged();
      AppMethodBeat.o(69624);
      return true;
      if ("wallet_transfer_2h".equals(paramPreference))
      {
        this.tZb &= 0xFFFFFFDF;
        this.tZb |= 0x10;
      }
      else if ("wallet_transfer_24h".equals(paramPreference))
      {
        this.tZb &= 0xFFFFFFEF;
        this.tZb |= 0x20;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69625);
    if ((paramq instanceof ak))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.OAZ = ((ak)paramq).OID;
        this.mTitle = ((ak)paramq).OIC;
        this.IoN = ((ak)paramq).OIG;
        this.OBb = ((ak)paramq).OIH;
        this.OBa = ((ak)paramq).OIE;
        if (!Util.isNullOrNil(this.OAZ))
        {
          this.EUI.setText(this.OAZ);
          if (Util.isNullOrNil(this.mTitle)) {
            break label166;
          }
          this.OAY.setText(this.mTitle);
          label124:
          gHE();
        }
      }
      for (;;)
      {
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(69625);
        return;
        Log.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
        this.EUI.setText(a.i.wallet_delay_transfer_setting_title_hardcode_tip);
        break;
        label166:
        Log.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
        this.OAY.setText(a.i.wallet_password_setting_delay_transfer_date);
        break label124;
        Log.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
        this.EUI.setText(a.i.wallet_delay_transfer_setting_title_hardcode_tip);
        this.OAY.setText(a.i.wallet_password_setting_delay_transfer_date);
      }
    }
    Log.i("MicroMsg.WalletDelayTransferSettingUI", "other scene");
    AppMethodBeat.o(69625);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDelayTransferSettingUI
 * JD-Core Version:    0.7.0.1
 */