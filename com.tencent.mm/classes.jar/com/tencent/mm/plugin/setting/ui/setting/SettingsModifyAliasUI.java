package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.hv;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.c.a;
import com.tencent.mm.view.CheckBoxLicenseView;
import java.util.ArrayList;

public class SettingsModifyAliasUI
  extends MMWizardActivity
  implements i, c.a
{
  private Button Ata;
  private MMClearEditText Jid;
  private com.tencent.mm.plugin.account.model.f Jie;
  private e Jif;
  private ArrayList<Integer> Jig;
  private ArrayList<String> Jih;
  private ScrollView jbL;
  private InputPanelLinearLayout jbM;
  private TextView nkh;
  private s tipDialog;
  
  private void Kz(String paramString)
  {
    AppMethodBeat.i(263733);
    if (Util.isNullOrNil(paramString))
    {
      this.nkh.setVisibility(8);
      AppMethodBeat.o(263733);
      return;
    }
    this.nkh.setVisibility(0);
    this.nkh.setText(paramString);
    AppMethodBeat.o(263733);
  }
  
  public int getLayoutId()
  {
    return b.g.settings_modify_alias;
  }
  
  public final void h(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(263729);
    Log.i("MicroMsg.SettingsModifyAliasUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.Ata.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(b.d.Edge_2A);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(b.d.Edge_2A);
      this.Ata.setLayoutParams(localLayoutParams);
      this.jbM.setPadding(this.jbM.getPaddingLeft(), this.jbM.getPaddingTop(), this.jbM.getPaddingRight(), paramInt);
      paramInt = this.jbL.getHeight();
      this.jbM.requestLayout();
      this.jbM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264570);
          Log.i("MicroMsg.SettingsModifyAliasUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight() > paramInt) {
            SettingsModifyAliasUI.e(SettingsModifyAliasUI.this).scrollBy(0, SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(264570);
        }
      });
      AppMethodBeat.o(263729);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Ata.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(b.d.Edge_12A);
    localLayoutParams.topMargin = 0;
    this.Ata.setLayoutParams(localLayoutParams);
    this.jbM.setPadding(this.jbM.getPaddingLeft(), this.jbM.getPaddingTop(), this.jbM.getPaddingRight(), 0);
    this.jbL.scrollBy(0, 0);
    AppMethodBeat.o(263729);
  }
  
  public void initView()
  {
    AppMethodBeat.i(263728);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(b.c.white));
    this.jbM = ((InputPanelLinearLayout)findViewById(b.f.input_container));
    this.jbM.setExternalListener(this);
    this.Ata = ((Button)findViewById(b.f.next_btn));
    this.Jid = ((MMClearEditText)findViewById(b.f.alias_edit));
    this.nkh = ((TextView)findViewById(b.f.error_tip));
    this.jbL = ((ScrollView)findViewById(b.f.scroll_view));
    this.Ata.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(263551);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, SettingsModifyAliasUI.a(SettingsModifyAliasUI.this).getText()))
        {
          SettingsModifyAliasUI.this.hideVKB();
          SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
          SettingsModifyAliasUI.b(SettingsModifyAliasUI.this, SettingsModifyAliasUI.a(SettingsModifyAliasUI.this).getText().toString());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(263551);
          return;
          paramAnonymousView = new hv();
          paramAnonymousView.xd(SettingsAliasUI.JgW);
          paramAnonymousView.geB = 4L;
          paramAnonymousView.gGS = 5L;
          paramAnonymousView.bpa();
        }
      }
    });
    this.Jid.requestFocus();
    this.Jid.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(264099);
        if ((paramAnonymousEditable != null) && (!Util.isNullOrNil(paramAnonymousEditable.toString()))) {}
        for (boolean bool = true;; bool = false)
        {
          SettingsModifyAliasUI.b(SettingsModifyAliasUI.this).setEnabled(bool);
          if (!bool) {
            SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
          }
          AppMethodBeat.o(264099);
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
        AppMethodBeat.i(264846);
        paramAnonymousMenuItem = new hv();
        paramAnonymousMenuItem.xd(SettingsAliasUI.JgW);
        paramAnonymousMenuItem.geB = 7L;
        paramAnonymousMenuItem.gGT = 2L;
        paramAnonymousMenuItem.bpa();
        SettingsModifyAliasUI.this.onBackPressed();
        AppMethodBeat.o(264846);
        return true;
      }
    });
    AppMethodBeat.o(263728);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(263725);
    super.onCreate(paramBundle);
    this.Jig = getIntent().getIntegerArrayListExtra("key_ticket_type");
    this.Jih = getIntent().getStringArrayListExtra("key_ticket");
    Log.i("MicroMsg.SettingsModifyAliasUI", "ticketTypes %s, tickets %s", new Object[] { this.Jig, this.Jih });
    initView();
    com.tencent.mm.kernel.h.aGY().a(3516, this);
    com.tencent.mm.kernel.h.aGY().a(177, this);
    if (com.tencent.mm.n.h.axc().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(263725);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(263727);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(3516, this);
    com.tencent.mm.kernel.h.aGY().b(177, this);
    AppMethodBeat.o(263727);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final q paramq)
  {
    AppMethodBeat.i(263732);
    Log.i("MicroMsg.SettingsModifyAliasUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    Object localObject1;
    if (paramq.getType() == 3516)
    {
      localObject1 = new hv();
      ((hv)localObject1).geB = 4L;
      ((hv)localObject1).xd(SettingsAliasUI.JgW);
      if (paramq != this.Jie)
      {
        Log.w("MicroMsg.SettingsModifyAliasUI", "check alias, not my scene, ignore!");
        AppMethodBeat.o(263732);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject2 = ((com.tencent.mm.plugin.account.model.f)paramq).idS;
        paramString = new g(this);
        paramString.ayv(b.g.settings_confirm_alias);
        ((TextView)paramString.oFW.findViewById(b.f.settings_alias_new)).setText((CharSequence)localObject2);
        paramq = (Button)paramString.oFW.findViewById(b.f.next_btn);
        paramq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(264822);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            SettingsModifyAliasUI.c(SettingsModifyAliasUI.this, this.Jij);
            paramAnonymousView = new hv();
            paramAnonymousView.xd(SettingsAliasUI.JgW);
            paramAnonymousView.geB = 6L;
            paramAnonymousView.bpa();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(264822);
          }
        });
        localObject2 = (CheckBoxLicenseView)paramString.oFW.findViewById(b.f.modify_alias_check_license);
        ((CheckBoxLicenseView)localObject2).setTermText(getString(b.i.modify_alias_tip_detail));
        ((CheckBoxLicenseView)localObject2).setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(264268);
            paramAnonymousCompoundButton = new hv();
            paramAnonymousCompoundButton.xd(SettingsAliasUI.JgW);
            paramAnonymousCompoundButton.geB = 5L;
            paramAnonymousCompoundButton.bpa();
            paramq.setEnabled(paramAnonymousBoolean);
            AppMethodBeat.o(264268);
          }
        });
        ((CheckBoxLicenseView)localObject2).setLicenseClickListener(new SettingsModifyAliasUI.8(this));
        paramq = (ImageView)paramString.oFW.findViewById(b.f.modify_alias_close_btn);
        if (ar.isDarkMode()) {
          paramq.setImageResource(b.e.actionbar_light_close_selector);
        }
        paramq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(264345);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView = new hv();
            paramAnonymousView.xd(SettingsAliasUI.JgW);
            paramAnonymousView.geB = 7L;
            paramAnonymousView.gGT = 3L;
            paramAnonymousView.bpa();
            paramString.bYF();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(264345);
          }
        });
        paramString.eik();
      }
      for (;;)
      {
        ((hv)localObject1).bpa();
        AppMethodBeat.o(263732);
        return;
        ((hv)localObject1).gGS = 6L;
        if (!Util.isNullOrNil(paramString))
        {
          paramq = com.tencent.mm.h.a.Kb(paramString);
          if (paramq != null) {
            Kz(paramq.desc);
          } else {
            Kz(paramString);
          }
        }
        else
        {
          Kz(getString(b.i.app_err_system_busy_tip));
        }
      }
    }
    if (paramq.getType() == 177)
    {
      if (paramq != this.Jif)
      {
        Log.w("MicroMsg.SettingsModifyAliasUI", "general set, not my scene, ignore!");
        AppMethodBeat.o(263732);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.cO(this, getString(b.i.app_modify_success));
        paramString = this.Jif.Jdo;
        paramq = (String)com.tencent.mm.kernel.h.aHG().aHp().b(42, null);
        localObject1 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VuG, null);
        Log.i("MicroMsg.SettingsModifyAliasUI", "newAlias %s, oldAlias %s, lastLogin %s", new Object[] { paramString, paramq, localObject1 });
        com.tencent.mm.kernel.h.aHG().aHp().i(42, paramString);
        if ((Util.isNullOrNil(paramq)) || (paramq.equals(localObject1)))
        {
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VuG, paramString);
          ci.lvQ.o(z.bcZ(), "login_user_name", paramString);
          bg.ltv.aS("login_user_name", paramString);
        }
        atX(-1);
        AppMethodBeat.o(263732);
        return;
      }
      if ((paramInt2 == -7) || (paramInt2 == -10))
      {
        com.tencent.mm.ui.base.h.p(getContext(), b.i.reg_username_exist_tip, b.i.modify_username_failed);
        AppMethodBeat.o(263732);
        return;
      }
      if (!Util.isNullOrNil(paramString))
      {
        paramq = com.tencent.mm.h.a.Kb(paramString);
        if (paramq != null)
        {
          paramq.a(this, null);
          AppMethodBeat.o(263732);
          return;
        }
        com.tencent.mm.ui.base.h.c(this, paramString, getString(b.i.modify_username_failed), true);
        AppMethodBeat.o(263732);
        return;
      }
      com.tencent.mm.ui.base.h.p(getContext(), b.i.app_err_system_busy_tip, b.i.modify_username_failed);
    }
    AppMethodBeat.o(263732);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI
 * JD-Core Version:    0.7.0.1
 */