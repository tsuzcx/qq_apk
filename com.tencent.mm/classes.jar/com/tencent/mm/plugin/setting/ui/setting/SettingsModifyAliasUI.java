package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.bd;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.view.CheckBoxLicenseView;
import java.util.ArrayList;

public class SettingsModifyAliasUI
  extends MMWizardActivity
  implements com.tencent.mm.al.g, b.a
{
  private ScrollView ftp;
  private InputPanelLinearLayout ftq;
  private TextView iye;
  private Button qNK;
  private p tipDialog;
  private MMClearEditText whB;
  private com.tencent.mm.plugin.account.model.e whC;
  private d whD;
  private ArrayList<Integer> whE;
  private ArrayList<String> whF;
  
  private void oU(String paramString)
  {
    AppMethodBeat.i(186583);
    if (bt.isNullOrNil(paramString))
    {
      this.iye.setVisibility(8);
      AppMethodBeat.o(186583);
      return;
    }
    this.iye.setVisibility(0);
    this.iye.setText(paramString);
    AppMethodBeat.o(186583);
  }
  
  public final void g(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(186581);
    ad.i("MicroMsg.SettingsModifyAliasUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.qNK.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165289);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165289);
      this.qNK.setLayoutParams(localLayoutParams);
      this.ftq.setPadding(this.ftq.getPaddingLeft(), this.ftq.getPaddingTop(), this.ftq.getPaddingRight(), paramInt);
      paramInt = this.ftp.getHeight();
      this.ftq.requestLayout();
      this.ftq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186573);
          ad.i("MicroMsg.SettingsModifyAliasUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight() > paramInt) {
            SettingsModifyAliasUI.e(SettingsModifyAliasUI.this).scrollBy(0, SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(186573);
        }
      });
      AppMethodBeat.o(186581);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.qNK.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165277);
    localLayoutParams.topMargin = 0;
    this.qNK.setLayoutParams(localLayoutParams);
    this.ftq.setPadding(this.ftq.getPaddingLeft(), this.ftq.getPaddingTop(), this.ftq.getPaddingRight(), 0);
    this.ftp.scrollBy(0, 0);
    AppMethodBeat.o(186581);
  }
  
  public int getLayoutId()
  {
    return 2131495396;
  }
  
  public void initView()
  {
    AppMethodBeat.i(186580);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    this.ftq = ((InputPanelLinearLayout)findViewById(2131301024));
    this.ftq.setExternalListener(this);
    this.qNK = ((Button)findViewById(2131302852));
    this.whB = ((MMClearEditText)findViewById(2131296637));
    this.iye = ((TextView)findViewById(2131299523));
    this.ftp = ((ScrollView)findViewById(2131304376));
    this.qNK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186569);
        if (SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, SettingsModifyAliasUI.a(SettingsModifyAliasUI.this).getText()))
        {
          SettingsModifyAliasUI.this.hideVKB();
          SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
          SettingsModifyAliasUI.b(SettingsModifyAliasUI.this, SettingsModifyAliasUI.a(SettingsModifyAliasUI.this).getText().toString());
          AppMethodBeat.o(186569);
          return;
        }
        paramAnonymousView = new bd();
        paramAnonymousView.hY(SettingsAliasUI.wgy);
        paramAnonymousView.dFf = 4L;
        paramAnonymousView.dOw = 5L;
        paramAnonymousView.aBj();
        AppMethodBeat.o(186569);
      }
    });
    this.whB.requestFocus();
    this.whB.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(186570);
        if ((paramAnonymousEditable != null) && (!bt.isNullOrNil(paramAnonymousEditable.toString()))) {}
        for (boolean bool = true;; bool = false)
        {
          SettingsModifyAliasUI.b(SettingsModifyAliasUI.this).setEnabled(bool);
          if (!bool) {
            SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
          }
          AppMethodBeat.o(186570);
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
        AppMethodBeat.i(186571);
        paramAnonymousMenuItem = new bd();
        paramAnonymousMenuItem.hY(SettingsAliasUI.wgy);
        paramAnonymousMenuItem.dFf = 7L;
        paramAnonymousMenuItem.dOx = 2L;
        paramAnonymousMenuItem.aBj();
        SettingsModifyAliasUI.this.onBackPressed();
        AppMethodBeat.o(186571);
        return true;
      }
    });
    AppMethodBeat.o(186580);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186578);
    super.onCreate(paramBundle);
    this.whE = getIntent().getIntegerArrayListExtra("key_ticket_type");
    this.whF = getIntent().getStringArrayListExtra("key_ticket");
    ad.i("MicroMsg.SettingsModifyAliasUI", "ticketTypes %s, tickets %s", new Object[] { this.whE, this.whF });
    initView();
    com.tencent.mm.kernel.g.aeS().a(3516, this);
    com.tencent.mm.kernel.g.aeS().a(177, this);
    if (com.tencent.mm.m.g.Zd().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(186578);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(186579);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(3516, this);
    com.tencent.mm.kernel.g.aeS().b(177, this);
    AppMethodBeat.o(186579);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
  {
    AppMethodBeat.i(186582);
    ad.i("MicroMsg.SettingsModifyAliasUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    Object localObject1;
    if (paramn.getType() == 3516)
    {
      localObject1 = new bd();
      ((bd)localObject1).dFf = 4L;
      ((bd)localObject1).hY(SettingsAliasUI.wgy);
      if (paramn != this.whC)
      {
        ad.w("MicroMsg.SettingsModifyAliasUI", "check alias, not my scene, ignore!");
        AppMethodBeat.o(186582);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject2 = ((com.tencent.mm.plugin.account.model.e)paramn).eKn;
        paramString = new com.tencent.mm.ui.widget.a.g(this);
        if (paramString.HFN != null)
        {
          paramString.HFN.setVisibility(0);
          LayoutInflater.from(paramString.jGG.getContext()).inflate(2131495390, paramString.HFN, true);
        }
        ((TextView)paramString.jGG.findViewById(2131307244)).setText((CharSequence)localObject2);
        paramn = (Button)paramString.jGG.findViewById(2131302852);
        paramn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186574);
            SettingsModifyAliasUI.c(SettingsModifyAliasUI.this, this.whH);
            paramAnonymousView = new bd();
            paramAnonymousView.hY(SettingsAliasUI.wgy);
            paramAnonymousView.dFf = 6L;
            paramAnonymousView.aBj();
            AppMethodBeat.o(186574);
          }
        });
        localObject2 = (CheckBoxLicenseView)paramString.jGG.findViewById(2131302427);
        ((CheckBoxLicenseView)localObject2).setTermText(getString(2131766072));
        ((CheckBoxLicenseView)localObject2).setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(186575);
            paramAnonymousCompoundButton = new bd();
            paramAnonymousCompoundButton.hY(SettingsAliasUI.wgy);
            paramAnonymousCompoundButton.dFf = 5L;
            paramAnonymousCompoundButton.aBj();
            paramn.setEnabled(paramAnonymousBoolean);
            AppMethodBeat.o(186575);
          }
        });
        ((CheckBoxLicenseView)localObject2).setLicenseClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186576);
            com.tencent.mm.plugin.account.a.b.a.b(SettingsModifyAliasUI.this, SettingsModifyAliasUI.this.getString(2131766393, new Object[] { ac.eFu() }), 0, true);
            AppMethodBeat.o(186576);
          }
        });
        paramn = (ImageView)paramString.jGG.findViewById(2131307215);
        if (ai.Eq()) {
          paramn.setImageResource(2131234823);
        }
        paramn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186577);
            paramAnonymousView = new bd();
            paramAnonymousView.hY(SettingsAliasUI.wgy);
            paramAnonymousView.dFf = 7L;
            paramAnonymousView.dOx = 3L;
            paramAnonymousView.aBj();
            paramString.bfo();
            AppMethodBeat.o(186577);
          }
        });
        paramString.csG();
      }
      for (;;)
      {
        ((bd)localObject1).aBj();
        AppMethodBeat.o(186582);
        return;
        ((bd)localObject1).dOw = 6L;
        if (!bt.isNullOrNil(paramString))
        {
          paramn = com.tencent.mm.h.a.oG(paramString);
          if (paramn != null) {
            oU(paramn.desc);
          } else {
            oU(paramString);
          }
        }
        else
        {
          oU(getString(2131755733));
        }
      }
    }
    if (paramn.getType() == 177)
    {
      if (paramn != this.whD)
      {
        ad.w("MicroMsg.SettingsModifyAliasUI", "general set, not my scene, ignore!");
        AppMethodBeat.o(186582);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.cf(this, getString(2131756261));
        paramString = this.whD.wcU;
        paramn = (String)com.tencent.mm.kernel.g.afB().afk().get(42, null);
        localObject1 = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Ftd, null);
        ad.i("MicroMsg.SettingsModifyAliasUI", "newAlias %s, oldAlias %s, lastLogin %s", new Object[] { paramString, paramn, localObject1 });
        com.tencent.mm.kernel.g.afB().afk().set(42, paramString);
        if ((bt.isNullOrNil(paramn)) || (paramn.equals(localObject1)))
        {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Ftd, paramString);
          ca.gPq.m(u.aqG(), "login_user_name", paramString);
          ay.gNa.aD("login_user_name", paramString);
        }
        Xo(-1);
        AppMethodBeat.o(186582);
        return;
      }
      if ((paramInt2 == -7) || (paramInt2 == -10))
      {
        h.j(getContext(), 2131762274, 2131761323);
        AppMethodBeat.o(186582);
        return;
      }
      if (!bt.isNullOrNil(paramString))
      {
        paramn = com.tencent.mm.h.a.oG(paramString);
        if (paramn != null)
        {
          paramn.a(this, null);
          AppMethodBeat.o(186582);
          return;
        }
        h.c(this, paramString, getString(2131761323), true);
        AppMethodBeat.o(186582);
        return;
      }
      h.j(getContext(), 2131755733, 2131761323);
    }
    AppMethodBeat.o(186582);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI
 * JD-Core Version:    0.7.0.1
 */