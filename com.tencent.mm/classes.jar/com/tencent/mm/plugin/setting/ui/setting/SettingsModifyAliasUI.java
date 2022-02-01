package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.jy;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.k.i;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.c.a;
import com.tencent.mm.view.CheckBoxLicenseView;
import java.util.ArrayList;

public class SettingsModifyAliasUI
  extends MMWizardActivity
  implements com.tencent.mm.am.h, c.a
{
  private Button FSq;
  private MMClearEditText Puj;
  private com.tencent.mm.plugin.account.model.f Puk;
  private g Pul;
  private ArrayList<Integer> Pum;
  private ArrayList<String> Pun;
  private ScrollView lDL;
  private InputPanelLinearLayout lDM;
  private TextView qhp;
  private w tipDialog;
  
  private void Df(String paramString)
  {
    AppMethodBeat.i(299054);
    if (Util.isNullOrNil(paramString))
    {
      this.qhp.setVisibility(8);
      AppMethodBeat.o(299054);
      return;
    }
    this.qhp.setVisibility(0);
    this.qhp.setText(paramString);
    AppMethodBeat.o(299054);
  }
  
  public int getLayoutId()
  {
    return b.g.settings_modify_alias;
  }
  
  public void initView()
  {
    AppMethodBeat.i(299123);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(b.c.white));
    this.lDM = ((InputPanelLinearLayout)findViewById(b.f.input_container));
    this.lDM.setExternalListener(this);
    this.FSq = ((Button)findViewById(b.f.next_btn));
    this.Puj = ((MMClearEditText)findViewById(b.f.alias_edit));
    this.qhp = ((TextView)findViewById(b.f.error_tip));
    this.lDL = ((ScrollView)findViewById(b.f.scroll_view));
    this.FSq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(298767);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, SettingsModifyAliasUI.a(SettingsModifyAliasUI.this).getText()))
        {
          SettingsModifyAliasUI.this.hideVKB();
          SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
          SettingsModifyAliasUI.b(SettingsModifyAliasUI.this, SettingsModifyAliasUI.a(SettingsModifyAliasUI.this).getText().toString());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(298767);
          return;
          paramAnonymousView = new jy();
          paramAnonymousView.sq(SettingsAliasUI.PrO);
          paramAnonymousView.ila = 4L;
          paramAnonymousView.iUO = 5L;
          paramAnonymousView.bMH();
        }
      }
    });
    this.Puj.requestFocus();
    this.Puj.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(298711);
        if ((paramAnonymousEditable != null) && (!Util.isNullOrNil(paramAnonymousEditable.toString()))) {}
        for (boolean bool = true;; bool = false)
        {
          SettingsModifyAliasUI.b(SettingsModifyAliasUI.this).setEnabled(bool);
          if (!bool) {
            SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
          }
          AppMethodBeat.o(298711);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(298691);
        paramAnonymousMenuItem = new jy();
        paramAnonymousMenuItem.sq(SettingsAliasUI.PrO);
        paramAnonymousMenuItem.ila = 7L;
        paramAnonymousMenuItem.iUP = 2L;
        paramAnonymousMenuItem.bMH();
        SettingsModifyAliasUI.this.onBackPressed();
        AppMethodBeat.o(298691);
        return true;
      }
    });
    AppMethodBeat.o(299123);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(299109);
    super.onCreate(paramBundle);
    this.Pum = getIntent().getIntegerArrayListExtra("key_ticket_type");
    this.Pun = getIntent().getStringArrayListExtra("key_ticket");
    Log.i("MicroMsg.SettingsModifyAliasUI", "ticketTypes %s, tickets %s", new Object[] { this.Pum, this.Pun });
    initView();
    com.tencent.mm.kernel.h.aZW().a(3516, this);
    com.tencent.mm.kernel.h.aZW().a(177, this);
    if (i.aRC().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(299109);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(299117);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3516, this);
    com.tencent.mm.kernel.h.aZW().b(177, this);
    AppMethodBeat.o(299117);
  }
  
  public void onInputPanelChange(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(299131);
    Log.i("MicroMsg.SettingsModifyAliasUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.FSq.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(b.d.Edge_2A);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(b.d.Edge_2A);
      this.FSq.setLayoutParams(localLayoutParams);
      this.lDM.setPadding(this.lDM.getPaddingLeft(), this.lDM.getPaddingTop(), this.lDM.getPaddingRight(), paramInt);
      paramInt = this.lDL.getHeight();
      this.lDM.requestLayout();
      this.lDM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(298702);
          Log.i("MicroMsg.SettingsModifyAliasUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight() > paramInt) {
            SettingsModifyAliasUI.e(SettingsModifyAliasUI.this).scrollBy(0, SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(298702);
        }
      });
      AppMethodBeat.o(299131);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.FSq.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(b.d.Edge_12A);
    localLayoutParams.topMargin = 0;
    this.FSq.setLayoutParams(localLayoutParams);
    this.lDM.setPadding(this.lDM.getPaddingLeft(), this.lDM.getPaddingTop(), this.lDM.getPaddingRight(), 0);
    this.lDL.scrollBy(0, 0);
    AppMethodBeat.o(299131);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final p paramp)
  {
    AppMethodBeat.i(299141);
    Log.i("MicroMsg.SettingsModifyAliasUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    Object localObject1;
    if (paramp.getType() == 3516)
    {
      localObject1 = new jy();
      ((jy)localObject1).ila = 4L;
      ((jy)localObject1).sq(SettingsAliasUI.PrO);
      if (paramp != this.Puk)
      {
        Log.w("MicroMsg.SettingsModifyAliasUI", "check alias, not my scene, ignore!");
        AppMethodBeat.o(299141);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject2 = ((com.tencent.mm.plugin.account.model.f)paramp).kDc;
        paramString = new j(this);
        paramString.aFf(b.g.settings_confirm_alias);
        ((TextView)paramString.rootView.findViewById(b.f.settings_alias_new)).setText((CharSequence)localObject2);
        paramp = (Button)paramString.rootView.findViewById(b.f.next_btn);
        paramp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(298709);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            SettingsModifyAliasUI.c(SettingsModifyAliasUI.this, this.Pup);
            paramAnonymousView = new jy();
            paramAnonymousView.sq(SettingsAliasUI.PrO);
            paramAnonymousView.ila = 6L;
            paramAnonymousView.bMH();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(298709);
          }
        });
        localObject2 = (CheckBoxLicenseView)paramString.rootView.findViewById(b.f.modify_alias_check_license);
        ((CheckBoxLicenseView)localObject2).setTermText(getString(b.i.modify_alias_tip_detail));
        ((CheckBoxLicenseView)localObject2).setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(298718);
            paramAnonymousCompoundButton = new jy();
            paramAnonymousCompoundButton.sq(SettingsAliasUI.PrO);
            paramAnonymousCompoundButton.ila = 5L;
            paramAnonymousCompoundButton.bMH();
            paramp.setEnabled(paramAnonymousBoolean);
            AppMethodBeat.o(298718);
          }
        });
        ((CheckBoxLicenseView)localObject2).setLicenseClickListener(new SettingsModifyAliasUI.8(this));
        paramp = (ImageView)paramString.rootView.findViewById(b.f.modify_alias_close_btn);
        if (aw.isDarkMode()) {
          paramp.setImageResource(b.e.actionbar_light_close_selector);
        }
        paramp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(298716);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView = new jy();
            paramAnonymousView.sq(SettingsAliasUI.PrO);
            paramAnonymousView.ila = 7L;
            paramAnonymousView.iUP = 3L;
            paramAnonymousView.bMH();
            paramString.cyW();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(298716);
          }
        });
        paramString.dDn();
      }
      for (;;)
      {
        ((jy)localObject1).bMH();
        AppMethodBeat.o(299141);
        return;
        ((jy)localObject1).iUO = 6L;
        if (!Util.isNullOrNil(paramString))
        {
          paramp = com.tencent.mm.broadcast.a.CH(paramString);
          if (paramp != null) {
            Df(paramp.desc);
          } else {
            Df(paramString);
          }
        }
        else
        {
          Df(getString(b.i.app_err_system_busy_tip));
        }
      }
    }
    if (paramp.getType() == 177)
    {
      if (paramp != this.Pul)
      {
        Log.w("MicroMsg.SettingsModifyAliasUI", "general set, not my scene, ignore!");
        AppMethodBeat.o(299141);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        k.cZ(this, getString(b.i.app_modify_success));
        paramString = this.Pul.PnD;
        paramp = (String)com.tencent.mm.kernel.h.baE().ban().d(42, null);
        localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWp, null);
        Log.i("MicroMsg.SettingsModifyAliasUI", "newAlias %s, oldAlias %s, lastLogin %s", new Object[] { paramString, paramp, localObject1 });
        com.tencent.mm.kernel.h.baE().ban().B(42, paramString);
        if ((Util.isNullOrNil(paramp)) || (paramp.equals(localObject1)))
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acWp, paramString);
          cj.ono.s(z.bAM(), "login_user_name", paramString);
          bg.okT.bc("login_user_name", paramString);
        }
        aAp(-1);
        AppMethodBeat.o(299141);
        return;
      }
      if ((paramInt2 == -7) || (paramInt2 == -10))
      {
        k.s(getContext(), b.i.reg_username_exist_tip, b.i.modify_username_failed);
        AppMethodBeat.o(299141);
        return;
      }
      if (!Util.isNullOrNil(paramString))
      {
        paramp = com.tencent.mm.broadcast.a.CH(paramString);
        if (paramp != null)
        {
          paramp.a(this, null);
          AppMethodBeat.o(299141);
          return;
        }
        k.c(this, paramString, getString(b.i.modify_username_failed), true);
        AppMethodBeat.o(299141);
        return;
      }
      k.s(getContext(), b.i.app_err_system_busy_tip, b.i.modify_username_failed);
    }
    AppMethodBeat.o(299141);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI
 * JD-Core Version:    0.7.0.1
 */