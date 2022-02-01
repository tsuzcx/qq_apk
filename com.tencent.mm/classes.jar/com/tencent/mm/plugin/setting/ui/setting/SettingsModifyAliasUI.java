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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.gc;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.view.CheckBoxLicenseView;
import java.util.ArrayList;

public class SettingsModifyAliasUI
  extends MMWizardActivity
  implements i, b.a
{
  private MMClearEditText DcC;
  private com.tencent.mm.plugin.account.model.f DcD;
  private com.tencent.mm.plugin.setting.model.e DcE;
  private ArrayList<Integer> DcF;
  private ArrayList<String> DcG;
  private ScrollView gxx;
  private InputPanelLinearLayout gxy;
  private TextView ksy;
  private com.tencent.mm.ui.base.q tipDialog;
  private Button vMn;
  
  private void DI(String paramString)
  {
    AppMethodBeat.i(256567);
    if (Util.isNullOrNil(paramString))
    {
      this.ksy.setVisibility(8);
      AppMethodBeat.o(256567);
      return;
    }
    this.ksy.setVisibility(0);
    this.ksy.setText(paramString);
    AppMethodBeat.o(256567);
  }
  
  public final void f(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(256565);
    Log.i("MicroMsg.SettingsModifyAliasUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.vMn.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165296);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165296);
      this.vMn.setLayoutParams(localLayoutParams);
      this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), paramInt);
      paramInt = this.gxx.getHeight();
      this.gxy.requestLayout();
      this.gxy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256557);
          Log.i("MicroMsg.SettingsModifyAliasUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight() > paramInt) {
            SettingsModifyAliasUI.e(SettingsModifyAliasUI.this).scrollBy(0, SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(256557);
        }
      });
      AppMethodBeat.o(256565);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.vMn.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165281);
    localLayoutParams.topMargin = 0;
    this.vMn.setLayoutParams(localLayoutParams);
    this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), 0);
    this.gxx.scrollBy(0, 0);
    AppMethodBeat.o(256565);
  }
  
  public int getLayoutId()
  {
    return 2131496257;
  }
  
  public void initView()
  {
    AppMethodBeat.i(256564);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    this.gxy = ((InputPanelLinearLayout)findViewById(2131302671));
    this.gxy.setExternalListener(this);
    this.vMn = ((Button)findViewById(2131305423));
    this.DcC = ((MMClearEditText)findViewById(2131296714));
    this.ksy = ((TextView)findViewById(2131300161));
    this.gxx = ((ScrollView)findViewById(2131307339));
    this.vMn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(256553);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, SettingsModifyAliasUI.a(SettingsModifyAliasUI.this).getText()))
        {
          SettingsModifyAliasUI.this.hideVKB();
          SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
          SettingsModifyAliasUI.b(SettingsModifyAliasUI.this, SettingsModifyAliasUI.a(SettingsModifyAliasUI.this).getText().toString());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(256553);
          return;
          paramAnonymousView = new gc();
          paramAnonymousView.tm(SettingsAliasUI.Dbv);
          paramAnonymousView.ejW = 4L;
          paramAnonymousView.eIu = 5L;
          paramAnonymousView.bfK();
        }
      }
    });
    this.DcC.requestFocus();
    this.DcC.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(256554);
        if ((paramAnonymousEditable != null) && (!Util.isNullOrNil(paramAnonymousEditable.toString()))) {}
        for (boolean bool = true;; bool = false)
        {
          SettingsModifyAliasUI.b(SettingsModifyAliasUI.this).setEnabled(bool);
          if (!bool) {
            SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
          }
          AppMethodBeat.o(256554);
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
        AppMethodBeat.i(256555);
        paramAnonymousMenuItem = new gc();
        paramAnonymousMenuItem.tm(SettingsAliasUI.Dbv);
        paramAnonymousMenuItem.ejW = 7L;
        paramAnonymousMenuItem.eIv = 2L;
        paramAnonymousMenuItem.bfK();
        SettingsModifyAliasUI.this.onBackPressed();
        AppMethodBeat.o(256555);
        return true;
      }
    });
    AppMethodBeat.o(256564);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256562);
    super.onCreate(paramBundle);
    this.DcF = getIntent().getIntegerArrayListExtra("key_ticket_type");
    this.DcG = getIntent().getStringArrayListExtra("key_ticket");
    Log.i("MicroMsg.SettingsModifyAliasUI", "ticketTypes %s, tickets %s", new Object[] { this.DcF, this.DcG });
    initView();
    com.tencent.mm.kernel.g.azz().a(3516, this);
    com.tencent.mm.kernel.g.azz().a(177, this);
    if (com.tencent.mm.n.h.aqJ().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(256562);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(256563);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(3516, this);
    com.tencent.mm.kernel.g.azz().b(177, this);
    AppMethodBeat.o(256563);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(256566);
    Log.i("MicroMsg.SettingsModifyAliasUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    Object localObject1;
    if (paramq.getType() == 3516)
    {
      localObject1 = new gc();
      ((gc)localObject1).ejW = 4L;
      ((gc)localObject1).tm(SettingsAliasUI.Dbv);
      if (paramq != this.DcD)
      {
        Log.w("MicroMsg.SettingsModifyAliasUI", "check alias, not my scene, ignore!");
        AppMethodBeat.o(256566);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject2 = ((com.tencent.mm.plugin.account.model.f)paramq).fMb;
        paramString = new com.tencent.mm.ui.widget.a.g(this);
        paramString.apf(2131496251);
        ((TextView)paramString.lJI.findViewById(2131307686)).setText((CharSequence)localObject2);
        paramq = (Button)paramString.lJI.findViewById(2131305423);
        paramq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(256558);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            SettingsModifyAliasUI.c(SettingsModifyAliasUI.this, this.DcI);
            paramAnonymousView = new gc();
            paramAnonymousView.tm(SettingsAliasUI.Dbv);
            paramAnonymousView.ejW = 6L;
            paramAnonymousView.bfK();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256558);
          }
        });
        localObject2 = (CheckBoxLicenseView)paramString.lJI.findViewById(2131304826);
        ((CheckBoxLicenseView)localObject2).setTermText(getString(2131763140));
        ((CheckBoxLicenseView)localObject2).setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(256559);
            paramAnonymousCompoundButton = new gc();
            paramAnonymousCompoundButton.tm(SettingsAliasUI.Dbv);
            paramAnonymousCompoundButton.ejW = 5L;
            paramAnonymousCompoundButton.bfK();
            paramq.setEnabled(paramAnonymousBoolean);
            AppMethodBeat.o(256559);
          }
        });
        ((CheckBoxLicenseView)localObject2).setLicenseClickListener(new SettingsModifyAliasUI.8(this));
        paramq = (ImageView)paramString.lJI.findViewById(2131304827);
        if (com.tencent.mm.ui.ao.isDarkMode()) {
          paramq.setImageResource(2131230871);
        }
        paramq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(256561);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            paramAnonymousView = new gc();
            paramAnonymousView.tm(SettingsAliasUI.Dbv);
            paramAnonymousView.ejW = 7L;
            paramAnonymousView.eIv = 3L;
            paramAnonymousView.bfK();
            paramString.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256561);
          }
        });
        paramString.dGm();
      }
      for (;;)
      {
        ((gc)localObject1).bfK();
        AppMethodBeat.o(256566);
        return;
        ((gc)localObject1).eIu = 6L;
        if (!Util.isNullOrNil(paramString))
        {
          paramq = com.tencent.mm.h.a.Dk(paramString);
          if (paramq != null) {
            DI(paramq.desc);
          } else {
            DI(paramString);
          }
        }
        else
        {
          DI(getString(2131755804));
        }
      }
    }
    if (paramq.getType() == 177)
    {
      if (paramq != this.DcE)
      {
        Log.w("MicroMsg.SettingsModifyAliasUI", "general set, not my scene, ignore!");
        AppMethodBeat.o(256566);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.cD(this, getString(2131755898));
        paramString = this.DcE.CXI;
        paramq = (String)com.tencent.mm.kernel.g.aAh().azQ().get(42, null);
        localObject1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ogq, null);
        Log.i("MicroMsg.SettingsModifyAliasUI", "newAlias %s, oldAlias %s, lastLogin %s", new Object[] { paramString, paramq, localObject1 });
        com.tencent.mm.kernel.g.aAh().azQ().set(42, paramString);
        if ((Util.isNullOrNil(paramq)) || (paramq.equals(localObject1)))
        {
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogq, paramString);
          ch.iFO.l(z.aTY(), "login_user_name", paramString);
          bf.iDu.aO("login_user_name", paramString);
        }
        ala(-1);
        AppMethodBeat.o(256566);
        return;
      }
      if ((paramInt2 == -7) || (paramInt2 == -10))
      {
        com.tencent.mm.ui.base.h.n(getContext(), 2131764340, 2131763150);
        AppMethodBeat.o(256566);
        return;
      }
      if (!Util.isNullOrNil(paramString))
      {
        paramq = com.tencent.mm.h.a.Dk(paramString);
        if (paramq != null)
        {
          paramq.a(this, null);
          AppMethodBeat.o(256566);
          return;
        }
        com.tencent.mm.ui.base.h.c(this, paramString, getString(2131763150), true);
        AppMethodBeat.o(256566);
        return;
      }
      com.tencent.mm.ui.base.h.n(getContext(), 2131755804, 2131763150);
    }
    AppMethodBeat.o(256566);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI
 * JD-Core Version:    0.7.0.1
 */