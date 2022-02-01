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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.cp;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.view.CheckBoxLicenseView;
import java.util.ArrayList;

public class SettingsModifyAliasUI
  extends MMWizardActivity
  implements com.tencent.mm.ak.g, b.a
{
  private ScrollView fwW;
  private InputPanelLinearLayout fwX;
  private TextView iYh;
  private Button rJi;
  private p tipDialog;
  private MMClearEditText xsR;
  private com.tencent.mm.plugin.account.model.e xsS;
  private d xsT;
  private ArrayList<Integer> xsU;
  private ArrayList<String> xsV;
  
  private void sg(String paramString)
  {
    AppMethodBeat.i(191049);
    if (bs.isNullOrNil(paramString))
    {
      this.iYh.setVisibility(8);
      AppMethodBeat.o(191049);
      return;
    }
    this.iYh.setVisibility(0);
    this.iYh.setText(paramString);
    AppMethodBeat.o(191049);
  }
  
  public final void g(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(191047);
    ac.i("MicroMsg.SettingsModifyAliasUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.rJi.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165289);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165289);
      this.rJi.setLayoutParams(localLayoutParams);
      this.fwX.setPadding(this.fwX.getPaddingLeft(), this.fwX.getPaddingTop(), this.fwX.getPaddingRight(), paramInt);
      paramInt = this.fwW.getHeight();
      this.fwX.requestLayout();
      this.fwX.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(191039);
          ac.i("MicroMsg.SettingsModifyAliasUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight() > paramInt) {
            SettingsModifyAliasUI.e(SettingsModifyAliasUI.this).scrollBy(0, SettingsModifyAliasUI.d(SettingsModifyAliasUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(191039);
        }
      });
      AppMethodBeat.o(191047);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.rJi.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165277);
    localLayoutParams.topMargin = 0;
    this.rJi.setLayoutParams(localLayoutParams);
    this.fwX.setPadding(this.fwX.getPaddingLeft(), this.fwX.getPaddingTop(), this.fwX.getPaddingRight(), 0);
    this.fwW.scrollBy(0, 0);
    AppMethodBeat.o(191047);
  }
  
  public int getLayoutId()
  {
    return 2131495396;
  }
  
  public void initView()
  {
    AppMethodBeat.i(191046);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    this.fwX = ((InputPanelLinearLayout)findViewById(2131301024));
    this.fwX.setExternalListener(this);
    this.rJi = ((Button)findViewById(2131302852));
    this.xsR = ((MMClearEditText)findViewById(2131296637));
    this.iYh = ((TextView)findViewById(2131299523));
    this.fwW = ((ScrollView)findViewById(2131304376));
    this.rJi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191035);
        if (SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, SettingsModifyAliasUI.a(SettingsModifyAliasUI.this).getText()))
        {
          SettingsModifyAliasUI.this.hideVKB();
          SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
          SettingsModifyAliasUI.b(SettingsModifyAliasUI.this, SettingsModifyAliasUI.a(SettingsModifyAliasUI.this).getText().toString());
          AppMethodBeat.o(191035);
          return;
        }
        paramAnonymousView = new cp();
        paramAnonymousView.kA(SettingsAliasUI.xrO);
        paramAnonymousView.dCS = 4L;
        paramAnonymousView.dPX = 5L;
        paramAnonymousView.aHZ();
        AppMethodBeat.o(191035);
      }
    });
    this.xsR.requestFocus();
    this.xsR.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(191036);
        if ((paramAnonymousEditable != null) && (!bs.isNullOrNil(paramAnonymousEditable.toString()))) {}
        for (boolean bool = true;; bool = false)
        {
          SettingsModifyAliasUI.b(SettingsModifyAliasUI.this).setEnabled(bool);
          if (!bool) {
            SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
          }
          AppMethodBeat.o(191036);
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
        AppMethodBeat.i(191037);
        paramAnonymousMenuItem = new cp();
        paramAnonymousMenuItem.kA(SettingsAliasUI.xrO);
        paramAnonymousMenuItem.dCS = 7L;
        paramAnonymousMenuItem.dPY = 2L;
        paramAnonymousMenuItem.aHZ();
        SettingsModifyAliasUI.this.onBackPressed();
        AppMethodBeat.o(191037);
        return true;
      }
    });
    AppMethodBeat.o(191046);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(191044);
    super.onCreate(paramBundle);
    this.xsU = getIntent().getIntegerArrayListExtra("key_ticket_type");
    this.xsV = getIntent().getStringArrayListExtra("key_ticket");
    ac.i("MicroMsg.SettingsModifyAliasUI", "ticketTypes %s, tickets %s", new Object[] { this.xsU, this.xsV });
    initView();
    com.tencent.mm.kernel.g.agi().a(3516, this);
    com.tencent.mm.kernel.g.agi().a(177, this);
    if (com.tencent.mm.m.g.ZY().getInt("EnableModAlias", 0) == 0) {
      finish();
    }
    AppMethodBeat.o(191044);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(191045);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(3516, this);
    com.tencent.mm.kernel.g.agi().b(177, this);
    AppMethodBeat.o(191045);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
  {
    AppMethodBeat.i(191048);
    ac.i("MicroMsg.SettingsModifyAliasUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    Object localObject1;
    if (paramn.getType() == 3516)
    {
      localObject1 = new cp();
      ((cp)localObject1).dCS = 4L;
      ((cp)localObject1).kA(SettingsAliasUI.xrO);
      if (paramn != this.xsS)
      {
        ac.w("MicroMsg.SettingsModifyAliasUI", "check alias, not my scene, ignore!");
        AppMethodBeat.o(191048);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject2 = ((com.tencent.mm.plugin.account.model.e)paramn).eNf;
        paramString = new com.tencent.mm.ui.widget.a.g(this);
        if (paramString.Jgk != null)
        {
          paramString.Jgk.setVisibility(0);
          LayoutInflater.from(paramString.khe.getContext()).inflate(2131495390, paramString.Jgk, true);
        }
        ((TextView)paramString.khe.findViewById(2131307244)).setText((CharSequence)localObject2);
        paramn = (Button)paramString.khe.findViewById(2131302852);
        paramn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(191040);
            SettingsModifyAliasUI.c(SettingsModifyAliasUI.this, this.xsX);
            paramAnonymousView = new cp();
            paramAnonymousView.kA(SettingsAliasUI.xrO);
            paramAnonymousView.dCS = 6L;
            paramAnonymousView.aHZ();
            AppMethodBeat.o(191040);
          }
        });
        localObject2 = (CheckBoxLicenseView)paramString.khe.findViewById(2131302427);
        ((CheckBoxLicenseView)localObject2).setTermText(getString(2131766072));
        ((CheckBoxLicenseView)localObject2).setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(191041);
            paramAnonymousCompoundButton = new cp();
            paramAnonymousCompoundButton.kA(SettingsAliasUI.xrO);
            paramAnonymousCompoundButton.dCS = 5L;
            paramAnonymousCompoundButton.aHZ();
            paramn.setEnabled(paramAnonymousBoolean);
            AppMethodBeat.o(191041);
          }
        });
        ((CheckBoxLicenseView)localObject2).setLicenseClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(191042);
            com.tencent.mm.plugin.account.a.b.a.b(SettingsModifyAliasUI.this, SettingsModifyAliasUI.this.getString(2131766393, new Object[] { ab.eUO() }), 0, true);
            AppMethodBeat.o(191042);
          }
        });
        paramn = (ImageView)paramString.khe.findViewById(2131307215);
        if (aj.DT()) {
          paramn.setImageResource(2131234823);
        }
        paramn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(191043);
            paramAnonymousView = new cp();
            paramAnonymousView.kA(SettingsAliasUI.xrO);
            paramAnonymousView.dCS = 7L;
            paramAnonymousView.dPY = 3L;
            paramAnonymousView.aHZ();
            paramString.bmi();
            AppMethodBeat.o(191043);
          }
        });
        paramString.cED();
      }
      for (;;)
      {
        ((cp)localObject1).aHZ();
        AppMethodBeat.o(191048);
        return;
        ((cp)localObject1).dPX = 6L;
        if (!bs.isNullOrNil(paramString))
        {
          paramn = com.tencent.mm.h.a.rM(paramString);
          if (paramn != null) {
            sg(paramn.desc);
          } else {
            sg(paramString);
          }
        }
        else
        {
          sg(getString(2131755733));
        }
      }
    }
    if (paramn.getType() == 177)
    {
      if (paramn != this.xsT)
      {
        ac.w("MicroMsg.SettingsModifyAliasUI", "general set, not my scene, ignore!");
        AppMethodBeat.o(191048);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.cg(this, getString(2131756261));
        paramString = this.xsT.xoi;
        paramn = (String)com.tencent.mm.kernel.g.agR().agA().get(42, null);
        localObject1 = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQW, null);
        ac.i("MicroMsg.SettingsModifyAliasUI", "newAlias %s, oldAlias %s, lastLogin %s", new Object[] { paramString, paramn, localObject1 });
        com.tencent.mm.kernel.g.agR().agA().set(42, paramString);
        if ((bs.isNullOrNil(paramn)) || (paramn.equals(localObject1)))
        {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQW, paramString);
          ca.hpQ.m(u.axw(), "login_user_name", paramString);
          ay.hnA.aL("login_user_name", paramString);
        }
        ZA(-1);
        AppMethodBeat.o(191048);
        return;
      }
      if ((paramInt2 == -7) || (paramInt2 == -10))
      {
        h.l(getContext(), 2131762274, 2131761323);
        AppMethodBeat.o(191048);
        return;
      }
      if (!bs.isNullOrNil(paramString))
      {
        paramn = com.tencent.mm.h.a.rM(paramString);
        if (paramn != null)
        {
          paramn.a(this, null);
          AppMethodBeat.o(191048);
          return;
        }
        h.c(this, paramString, getString(2131761323), true);
        AppMethodBeat.o(191048);
        return;
      }
      h.l(getContext(), 2131755733, 2131761323);
    }
    AppMethodBeat.o(191048);
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