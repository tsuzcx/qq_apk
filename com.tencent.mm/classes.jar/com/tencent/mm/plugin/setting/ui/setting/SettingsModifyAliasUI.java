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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.dh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private ScrollView fSp;
  private InputPanelLinearLayout fSq;
  private TextView juj;
  private Button sPf;
  private p tipDialog;
  private MMClearEditText yXK;
  private com.tencent.mm.plugin.account.model.e yXL;
  private com.tencent.mm.plugin.setting.model.e yXM;
  private ArrayList<Integer> yXN;
  private ArrayList<String> yXO;
  
  private void vr(String paramString)
  {
    AppMethodBeat.i(190391);
    if (bu.isNullOrNil(paramString))
    {
      this.juj.setVisibility(8);
      AppMethodBeat.o(190391);
      return;
    }
    this.juj.setVisibility(0);
    this.juj.setText(paramString);
    AppMethodBeat.o(190391);
  }
  
  public final void g(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(190389);
    ae.i("MicroMsg.SettingsModifyAliasUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.sPf.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165289);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165289);
      this.sPf.setLayoutParams(localLayoutParams);
      this.fSq.setPadding(this.fSq.getPaddingLeft(), this.fSq.getPaddingTop(), this.fSq.getPaddingRight(), paramInt);
      paramInt = this.fSp.getHeight();
      this.fSq.requestLayout();
      this.fSq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(190381);
          ae.i("MicroMsg.SettingsModifyAliasUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight() > paramInt) {
            SettingsModifyAliasUI.e(SettingsModifyAliasUI.this).scrollBy(0, SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(190381);
        }
      });
      AppMethodBeat.o(190389);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.sPf.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165277);
    localLayoutParams.topMargin = 0;
    this.sPf.setLayoutParams(localLayoutParams);
    this.fSq.setPadding(this.fSq.getPaddingLeft(), this.fSq.getPaddingTop(), this.fSq.getPaddingRight(), 0);
    this.fSp.scrollBy(0, 0);
    AppMethodBeat.o(190389);
  }
  
  public int getLayoutId()
  {
    return 2131495396;
  }
  
  public void initView()
  {
    AppMethodBeat.i(190388);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    this.fSq = ((InputPanelLinearLayout)findViewById(2131301024));
    this.fSq.setExternalListener(this);
    this.sPf = ((Button)findViewById(2131302852));
    this.yXK = ((MMClearEditText)findViewById(2131296637));
    this.juj = ((TextView)findViewById(2131299523));
    this.fSp = ((ScrollView)findViewById(2131304376));
    this.sPf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190377);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, SettingsModifyAliasUI.a(SettingsModifyAliasUI.this).getText()))
        {
          SettingsModifyAliasUI.this.hideVKB();
          SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
          SettingsModifyAliasUI.b(SettingsModifyAliasUI.this, SettingsModifyAliasUI.a(SettingsModifyAliasUI.this).getText().toString());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(190377);
          return;
          paramAnonymousView = new dh();
          paramAnonymousView.mO(SettingsAliasUI.yWG);
          paramAnonymousView.dQX = 4L;
          paramAnonymousView.egM = 5L;
          paramAnonymousView.aLH();
        }
      }
    });
    this.yXK.requestFocus();
    this.yXK.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(190378);
        if ((paramAnonymousEditable != null) && (!bu.isNullOrNil(paramAnonymousEditable.toString()))) {}
        for (boolean bool = true;; bool = false)
        {
          SettingsModifyAliasUI.b(SettingsModifyAliasUI.this).setEnabled(bool);
          if (!bool) {
            SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
          }
          AppMethodBeat.o(190378);
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
        AppMethodBeat.i(190379);
        paramAnonymousMenuItem = new dh();
        paramAnonymousMenuItem.mO(SettingsAliasUI.yWG);
        paramAnonymousMenuItem.dQX = 7L;
        paramAnonymousMenuItem.egN = 2L;
        paramAnonymousMenuItem.aLH();
        SettingsModifyAliasUI.this.onBackPressed();
        AppMethodBeat.o(190379);
        return true;
      }
    });
    AppMethodBeat.o(190388);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190386);
    super.onCreate(paramBundle);
    this.yXN = getIntent().getIntegerArrayListExtra("key_ticket_type");
    this.yXO = getIntent().getStringArrayListExtra("key_ticket");
    ae.i("MicroMsg.SettingsModifyAliasUI", "ticketTypes %s, tickets %s", new Object[] { this.yXN, this.yXO });
    initView();
    com.tencent.mm.kernel.g.ajj().a(3516, this);
    com.tencent.mm.kernel.g.ajj().a(177, this);
    if (com.tencent.mm.n.g.acL().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(190386);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(190387);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajj().b(3516, this);
    com.tencent.mm.kernel.g.ajj().b(177, this);
    AppMethodBeat.o(190387);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
  {
    AppMethodBeat.i(190390);
    ae.i("MicroMsg.SettingsModifyAliasUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    Object localObject1;
    if (paramn.getType() == 3516)
    {
      localObject1 = new dh();
      ((dh)localObject1).dQX = 4L;
      ((dh)localObject1).mO(SettingsAliasUI.yWG);
      if (paramn != this.yXL)
      {
        ae.w("MicroMsg.SettingsModifyAliasUI", "check alias, not my scene, ignore!");
        AppMethodBeat.o(190390);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject2 = ((com.tencent.mm.plugin.account.model.e)paramn).fhy;
        paramString = new com.tencent.mm.ui.widget.a.g(this);
        paramString.agc(2131495390);
        ((TextView)paramString.kFh.findViewById(2131307244)).setText((CharSequence)localObject2);
        paramn = (Button)paramString.kFh.findViewById(2131302852);
        paramn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(190382);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            SettingsModifyAliasUI.c(SettingsModifyAliasUI.this, this.yXQ);
            paramAnonymousView = new dh();
            paramAnonymousView.mO(SettingsAliasUI.yWG);
            paramAnonymousView.dQX = 6L;
            paramAnonymousView.aLH();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(190382);
          }
        });
        localObject2 = (CheckBoxLicenseView)paramString.kFh.findViewById(2131302427);
        ((CheckBoxLicenseView)localObject2).setTermText(getString(2131766072));
        ((CheckBoxLicenseView)localObject2).setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(190383);
            paramAnonymousCompoundButton = new dh();
            paramAnonymousCompoundButton.mO(SettingsAliasUI.yWG);
            paramAnonymousCompoundButton.dQX = 5L;
            paramAnonymousCompoundButton.aLH();
            paramn.setEnabled(paramAnonymousBoolean);
            AppMethodBeat.o(190383);
          }
        });
        ((CheckBoxLicenseView)localObject2).setLicenseClickListener(new SettingsModifyAliasUI.8(this));
        paramn = (ImageView)paramString.kFh.findViewById(2131307215);
        if (al.isDarkMode()) {
          paramn.setImageResource(2131234823);
        }
        paramn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(190385);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramAnonymousView = new dh();
            paramAnonymousView.mO(SettingsAliasUI.yWG);
            paramAnonymousView.dQX = 7L;
            paramAnonymousView.egN = 3L;
            paramAnonymousView.aLH();
            paramString.bqD();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(190385);
          }
        });
        paramString.cPF();
      }
      for (;;)
      {
        ((dh)localObject1).aLH();
        AppMethodBeat.o(190390);
        return;
        ((dh)localObject1).egM = 6L;
        if (!bu.isNullOrNil(paramString))
        {
          paramn = com.tencent.mm.h.a.uU(paramString);
          if (paramn != null) {
            vr(paramn.desc);
          } else {
            vr(paramString);
          }
        }
        else
        {
          vr(getString(2131755733));
        }
      }
    }
    if (paramn.getType() == 177)
    {
      if (paramn != this.yXM)
      {
        ae.w("MicroMsg.SettingsModifyAliasUI", "general set, not my scene, ignore!");
        AppMethodBeat.o(190390);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.cm(this, getString(2131756261));
        paramString = this.yXM.ySS;
        paramn = (String)com.tencent.mm.kernel.g.ajR().ajA().get(42, null);
        localObject1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXT, null);
        ae.i("MicroMsg.SettingsModifyAliasUI", "newAlias %s, oldAlias %s, lastLogin %s", new Object[] { paramString, paramn, localObject1 });
        com.tencent.mm.kernel.g.ajR().ajA().set(42, paramString);
        if ((bu.isNullOrNil(paramn)) || (paramn.equals(localObject1)))
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXT, paramString);
          cd.hLa.l(v.aAC(), "login_user_name", paramString);
          bb.hIK.aM("login_user_name", paramString);
        }
        acs(-1);
        AppMethodBeat.o(190390);
        return;
      }
      if ((paramInt2 == -7) || (paramInt2 == -10))
      {
        h.l(getContext(), 2131762274, 2131761323);
        AppMethodBeat.o(190390);
        return;
      }
      if (!bu.isNullOrNil(paramString))
      {
        paramn = com.tencent.mm.h.a.uU(paramString);
        if (paramn != null)
        {
          paramn.a(this, null);
          AppMethodBeat.o(190390);
          return;
        }
        h.c(this, paramString, getString(2131761323), true);
        AppMethodBeat.o(190390);
        return;
      }
      h.l(getContext(), 2131755733, 2131761323);
    }
    AppMethodBeat.o(190390);
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