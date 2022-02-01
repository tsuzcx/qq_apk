package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.c;
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
import com.tencent.mm.protocal.protobuf.dqa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;

public class WalletDelayTransferSettingUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private TextView KPG;
  private String Omg;
  private WalletDelayTransferUISelectPreference Vqi;
  private WalletDelayTransferUISelectPreference Vqj;
  private WalletDelayTransferUISelectPreference Vqk;
  private TextView Vql;
  private String Vqm;
  private String Vqn;
  private int Vqo = 0;
  private int Vqp = 0;
  private int lCR = 1;
  private String mTitle;
  private com.tencent.mm.ui.base.preference.f screen;
  private long xct;
  
  private void Hz(boolean paramBoolean)
  {
    AppMethodBeat.i(315677);
    if (afN(16))
    {
      igL();
      if (!paramBoolean)
      {
        this.Vqp = 2;
        com.tencent.mm.plugin.report.service.h.OAn.b(23319, new Object[] { Integer.valueOf(this.lCR), Integer.valueOf(this.Vqp), Integer.valueOf(0) });
        AppMethodBeat.o(315677);
      }
    }
    else if (afN(32))
    {
      igM();
      if (!paramBoolean)
      {
        this.Vqp = 3;
        com.tencent.mm.plugin.report.service.h.OAn.b(23319, new Object[] { Integer.valueOf(this.lCR), Integer.valueOf(this.Vqp), Integer.valueOf(0) });
        AppMethodBeat.o(315677);
      }
    }
    else
    {
      igK();
      if (!paramBoolean)
      {
        this.Vqp = 1;
        com.tencent.mm.plugin.report.service.h.OAn.b(23319, new Object[] { Integer.valueOf(this.lCR), Integer.valueOf(this.Vqp), Integer.valueOf(0) });
      }
    }
    AppMethodBeat.o(315677);
  }
  
  private boolean afN(int paramInt)
  {
    return (this.xct & paramInt) != 0L;
  }
  
  private void igJ()
  {
    AppMethodBeat.i(69621);
    if ((this.Vqo == 1) && (!Util.isNullOrNil(this.Omg)))
    {
      addIconOptionMenu(0, a.e.wallet_qanda_icon, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69618);
          i.p(WalletDelayTransferSettingUI.this.getContext(), WalletDelayTransferSettingUI.a(WalletDelayTransferSettingUI.this), false);
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
  
  private void igK()
  {
    AppMethodBeat.i(69627);
    this.Vqi.isSelected = true;
    this.Vqj.isSelected = false;
    this.Vqk.isSelected = false;
    AppMethodBeat.o(69627);
  }
  
  private void igL()
  {
    AppMethodBeat.i(69628);
    this.Vqi.isSelected = false;
    this.Vqj.isSelected = true;
    this.Vqk.isSelected = false;
    AppMethodBeat.o(69628);
  }
  
  private void igM()
  {
    AppMethodBeat.i(69629);
    this.Vqi.isSelected = false;
    this.Vqj.isSelected = false;
    this.Vqk.isSelected = true;
    AppMethodBeat.o(69629);
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(315718);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setPadding(0, 0, 0, a.bs(getContext(), a.d.Edge_12A));
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
    localButton.setPadding(a.bs(getContext(), a.d.LargeBtnPadding), 0, a.bs(getContext(), a.d.LargeBtnPadding), 0);
    localButton.setMinHeight(a.bs(getContext(), a.d.MiddleBtnHeight));
    localButton.setMinWidth(a.bs(getContext(), a.d.MiddleBtnWidth));
    localButton.setText(getString(a.i.wallet_balance_result_next));
    localButton.setGravity(17);
    localButton.setLayoutParams(localLayoutParams);
    localButton.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(315625);
        WalletDelayTransferSettingUI.b(WalletDelayTransferSettingUI.this);
        AppMethodBeat.o(315625);
      }
    });
    AppMethodBeat.o(315718);
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
    this.Vqi = ((WalletDelayTransferUISelectPreference)this.screen.bAi("wallet_transfer_realtime"));
    this.Vqj = ((WalletDelayTransferUISelectPreference)this.screen.bAi("wallet_transfer_2h"));
    this.Vqk = ((WalletDelayTransferUISelectPreference)this.screen.bAi("wallet_transfer_24h"));
    this.Vql = ((TextView)findViewById(a.f.delay_transfer_header_title_tv));
    aw.a(this.Vql.getPaint(), 0.8F);
    this.KPG = ((TextView)findViewById(a.f.delay_transfer_header_desc_tv));
    this.Vqi.aBq(8);
    this.Vqj.aBq(8);
    this.Vqk.aBq(8);
    Hz(false);
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
    this.lCR = getIntent().getIntExtra("key_scene", 1);
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
    this.screen.aBe(a.m.wallet_delay_transfer_setting_pref);
    com.tencent.mm.kernel.h.baF();
    this.xct = ((Long)com.tencent.mm.kernel.h.baE().ban().d(147457, Long.valueOf(0L))).longValue();
    initView();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(385, this);
    com.tencent.mm.kernel.h.baF();
    this.Vqm = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPj, ""));
    com.tencent.mm.kernel.h.baF();
    this.Vqn = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPk, ""));
    com.tencent.mm.kernel.h.baF();
    this.mTitle = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPi, ""));
    com.tencent.mm.kernel.h.baF();
    this.Omg = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPm, ""));
    com.tencent.mm.kernel.h.baF();
    this.Vqo = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPn, Integer.valueOf(0))).intValue();
    if ((Util.isNullOrNil(this.Vqm)) || (Util.isNullOrNil(this.mTitle)) || (Util.isNullOrNil(this.Omg)) || (Util.isNullOrNil(this.Vqn))) {}
    for (boolean bool = ak.a(true, null);; bool = ak.a(false, null))
    {
      i.jPs();
      if (!bool)
      {
        Log.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.b(385, this);
      }
      AppMethodBeat.o(69620);
      return;
      this.KPG.setText(this.Vqm);
      this.Vql.setText(this.mTitle);
      igJ();
    }
  }
  
  public void onDestroy()
  {
    int i = 1;
    AppMethodBeat.i(69623);
    super.onDestroy();
    Log.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", new Object[] { Long.valueOf(this.xct) });
    if (afN(16)) {}
    for (;;)
    {
      dqa localdqa = new dqa();
      localdqa.OzH = i;
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(205, localdqa));
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(385, this);
      AppMethodBeat.o(69623);
      return;
      if (afN(32)) {
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
      this.xct &= 0xFFFFFFEF;
      this.xct &= 0xFFFFFFDF;
    }
    for (;;)
    {
      Hz(true);
      paramf.notifyDataSetChanged();
      AppMethodBeat.o(69624);
      return true;
      if ("wallet_transfer_2h".equals(paramPreference))
      {
        this.xct &= 0xFFFFFFDF;
        this.xct |= 0x10;
      }
      else if ("wallet_transfer_24h".equals(paramPreference))
      {
        this.xct &= 0xFFFFFFEF;
        this.xct |= 0x20;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(69625);
    if ((paramp instanceof ak))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Vqm = ((ak)paramp).Vyp;
        this.mTitle = ((ak)paramp).Vyo;
        this.Omg = ((ak)paramp).Vys;
        this.Vqo = ((ak)paramp).Vyt;
        this.Vqn = ((ak)paramp).Vyq;
        if (!Util.isNullOrNil(this.Vqm))
        {
          this.KPG.setText(this.Vqm);
          if (Util.isNullOrNil(this.mTitle)) {
            break label166;
          }
          this.Vql.setText(this.mTitle);
          label124:
          igJ();
        }
      }
      for (;;)
      {
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(69625);
        return;
        Log.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
        this.KPG.setText(a.i.wallet_delay_transfer_setting_title_hardcode_tip);
        break;
        label166:
        Log.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
        this.Vql.setText(a.i.wallet_password_setting_delay_transfer_date);
        break label124;
        Log.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
        this.KPG.setText(a.i.wallet_delay_transfer_setting_title_hardcode_tip);
        this.Vql.setText(a.i.wallet_password_setting_delay_transfer_date);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDelayTransferSettingUI
 * JD-Core Version:    0.7.0.1
 */