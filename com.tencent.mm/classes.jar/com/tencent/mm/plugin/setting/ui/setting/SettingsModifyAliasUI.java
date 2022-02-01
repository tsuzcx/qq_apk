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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.dh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.view.CheckBoxLicenseView;
import java.util.ArrayList;

public class SettingsModifyAliasUI
  extends MMWizardActivity
  implements f, b.a
{
  private ScrollView fQj;
  private InputPanelLinearLayout fQk;
  private TextView jrq;
  private Button sEg;
  private p tipDialog;
  private MMClearEditText yHA;
  private com.tencent.mm.plugin.account.model.e yHB;
  private d yHC;
  private ArrayList<Integer> yHD;
  private ArrayList<String> yHE;
  
  private void uV(String paramString)
  {
    AppMethodBeat.i(221016);
    if (bt.isNullOrNil(paramString))
    {
      this.jrq.setVisibility(8);
      AppMethodBeat.o(221016);
      return;
    }
    this.jrq.setVisibility(0);
    this.jrq.setText(paramString);
    AppMethodBeat.o(221016);
  }
  
  public final void g(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(221014);
    ad.i("MicroMsg.SettingsModifyAliasUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.sEg.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165289);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165289);
      this.sEg.setLayoutParams(localLayoutParams);
      this.fQk.setPadding(this.fQk.getPaddingLeft(), this.fQk.getPaddingTop(), this.fQk.getPaddingRight(), paramInt);
      paramInt = this.fQj.getHeight();
      this.fQk.requestLayout();
      this.fQk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(221006);
          ad.i("MicroMsg.SettingsModifyAliasUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight() > paramInt) {
            SettingsModifyAliasUI.e(SettingsModifyAliasUI.this).scrollBy(0, SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(221006);
        }
      });
      AppMethodBeat.o(221014);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.sEg.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165277);
    localLayoutParams.topMargin = 0;
    this.sEg.setLayoutParams(localLayoutParams);
    this.fQk.setPadding(this.fQk.getPaddingLeft(), this.fQk.getPaddingTop(), this.fQk.getPaddingRight(), 0);
    this.fQj.scrollBy(0, 0);
    AppMethodBeat.o(221014);
  }
  
  public int getLayoutId()
  {
    return 2131495396;
  }
  
  public void initView()
  {
    AppMethodBeat.i(221013);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    this.fQk = ((InputPanelLinearLayout)findViewById(2131301024));
    this.fQk.setExternalListener(this);
    this.sEg = ((Button)findViewById(2131302852));
    this.yHA = ((MMClearEditText)findViewById(2131296637));
    this.jrq = ((TextView)findViewById(2131299523));
    this.fQj = ((ScrollView)findViewById(2131304376));
    this.sEg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(221002);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, SettingsModifyAliasUI.a(SettingsModifyAliasUI.this).getText()))
        {
          SettingsModifyAliasUI.this.hideVKB();
          SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
          SettingsModifyAliasUI.b(SettingsModifyAliasUI.this, SettingsModifyAliasUI.a(SettingsModifyAliasUI.this).getText().toString());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(221002);
          return;
          paramAnonymousView = new dh();
          paramAnonymousView.mw(SettingsAliasUI.yGx);
          paramAnonymousView.dPH = 4L;
          paramAnonymousView.efl = 5L;
          paramAnonymousView.aLk();
        }
      }
    });
    this.yHA.requestFocus();
    this.yHA.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(221003);
        if ((paramAnonymousEditable != null) && (!bt.isNullOrNil(paramAnonymousEditable.toString()))) {}
        for (boolean bool = true;; bool = false)
        {
          SettingsModifyAliasUI.b(SettingsModifyAliasUI.this).setEnabled(bool);
          if (!bool) {
            SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
          }
          AppMethodBeat.o(221003);
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
        AppMethodBeat.i(221004);
        paramAnonymousMenuItem = new dh();
        paramAnonymousMenuItem.mw(SettingsAliasUI.yGx);
        paramAnonymousMenuItem.dPH = 7L;
        paramAnonymousMenuItem.efm = 2L;
        paramAnonymousMenuItem.aLk();
        SettingsModifyAliasUI.this.onBackPressed();
        AppMethodBeat.o(221004);
        return true;
      }
    });
    AppMethodBeat.o(221013);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(221011);
    super.onCreate(paramBundle);
    this.yHD = getIntent().getIntegerArrayListExtra("key_ticket_type");
    this.yHE = getIntent().getStringArrayListExtra("key_ticket");
    ad.i("MicroMsg.SettingsModifyAliasUI", "ticketTypes %s, tickets %s", new Object[] { this.yHD, this.yHE });
    initView();
    com.tencent.mm.kernel.g.aiU().a(3516, this);
    com.tencent.mm.kernel.g.aiU().a(177, this);
    if (com.tencent.mm.n.g.acA().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(221011);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(221012);
    super.onDestroy();
    com.tencent.mm.kernel.g.aiU().b(3516, this);
    com.tencent.mm.kernel.g.aiU().b(177, this);
    AppMethodBeat.o(221012);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
  {
    AppMethodBeat.i(221015);
    ad.i("MicroMsg.SettingsModifyAliasUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    Object localObject1;
    if (paramn.getType() == 3516)
    {
      localObject1 = new dh();
      ((dh)localObject1).dPH = 4L;
      ((dh)localObject1).mw(SettingsAliasUI.yGx);
      if (paramn != this.yHB)
      {
        ad.w("MicroMsg.SettingsModifyAliasUI", "check alias, not my scene, ignore!");
        AppMethodBeat.o(221015);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject2 = ((com.tencent.mm.plugin.account.model.e)paramn).ffB;
        paramString = new com.tencent.mm.ui.widget.a.g(this);
        paramString.aft(2131495390);
        ((TextView)paramString.kBS.findViewById(2131307244)).setText((CharSequence)localObject2);
        paramn = (Button)paramString.kBS.findViewById(2131302852);
        paramn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(221007);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            SettingsModifyAliasUI.c(SettingsModifyAliasUI.this, this.yHG);
            paramAnonymousView = new dh();
            paramAnonymousView.mw(SettingsAliasUI.yGx);
            paramAnonymousView.dPH = 6L;
            paramAnonymousView.aLk();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(221007);
          }
        });
        localObject2 = (CheckBoxLicenseView)paramString.kBS.findViewById(2131302427);
        ((CheckBoxLicenseView)localObject2).setTermText(getString(2131766072));
        ((CheckBoxLicenseView)localObject2).setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(221008);
            paramAnonymousCompoundButton = new dh();
            paramAnonymousCompoundButton.mw(SettingsAliasUI.yGx);
            paramAnonymousCompoundButton.dPH = 5L;
            paramAnonymousCompoundButton.aLk();
            paramn.setEnabled(paramAnonymousBoolean);
            AppMethodBeat.o(221008);
          }
        });
        ((CheckBoxLicenseView)localObject2).setLicenseClickListener(new SettingsModifyAliasUI.8(this));
        paramn = (ImageView)paramString.kBS.findViewById(2131307215);
        if (al.isDarkMode()) {
          paramn.setImageResource(2131234823);
        }
        paramn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(221010);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView = new dh();
            paramAnonymousView.mw(SettingsAliasUI.yGx);
            paramAnonymousView.dPH = 7L;
            paramAnonymousView.efm = 3L;
            paramAnonymousView.aLk();
            paramString.bpT();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(221010);
          }
        });
        paramString.cMW();
      }
      for (;;)
      {
        ((dh)localObject1).aLk();
        AppMethodBeat.o(221015);
        return;
        ((dh)localObject1).efl = 6L;
        if (!bt.isNullOrNil(paramString))
        {
          paramn = com.tencent.mm.h.a.uz(paramString);
          if (paramn != null) {
            uV(paramn.desc);
          } else {
            uV(paramString);
          }
        }
        else
        {
          uV(getString(2131755733));
        }
      }
    }
    if (paramn.getType() == 177)
    {
      if (paramn != this.yHC)
      {
        ad.w("MicroMsg.SettingsModifyAliasUI", "general set, not my scene, ignore!");
        AppMethodBeat.o(221015);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.cl(this, getString(2131756261));
        paramString = this.yHC.yCN;
        paramn = (String)com.tencent.mm.kernel.g.ajC().ajl().get(42, null);
        localObject1 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IDt, null);
        ad.i("MicroMsg.SettingsModifyAliasUI", "newAlias %s, oldAlias %s, lastLogin %s", new Object[] { paramString, paramn, localObject1 });
        com.tencent.mm.kernel.g.ajC().ajl().set(42, paramString);
        if ((bt.isNullOrNil(paramn)) || (paramn.equals(localObject1)))
        {
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDt, paramString);
          cb.hIi.l(u.aAm(), "login_user_name", paramString);
          az.hFS.aM("login_user_name", paramString);
        }
        abK(-1);
        AppMethodBeat.o(221015);
        return;
      }
      if ((paramInt2 == -7) || (paramInt2 == -10))
      {
        h.l(getContext(), 2131762274, 2131761323);
        AppMethodBeat.o(221015);
        return;
      }
      if (!bt.isNullOrNil(paramString))
      {
        paramn = com.tencent.mm.h.a.uz(paramString);
        if (paramn != null)
        {
          paramn.a(this, null);
          AppMethodBeat.o(221015);
          return;
        }
        h.c(this, paramString, getString(2131761323), true);
        AppMethodBeat.o(221015);
        return;
      }
      h.l(getContext(), 2131755733, 2131761323);
    }
    AppMethodBeat.o(221015);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI
 * JD-Core Version:    0.7.0.1
 */