package com.tencent.mm.plugin.teenmode.ui;

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
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.c.a;

public class TeenModeVerifyPwdUI
  extends MMWizardActivity
  implements com.tencent.mm.am.h, c.a
{
  private Button lDJ;
  private ScrollView lDL;
  private InputPanelLinearLayout lDM;
  private View qho;
  private TextView qhp;
  private EditText qhq;
  private int scene;
  private w tipDialog;
  
  private void Df(String paramString)
  {
    AppMethodBeat.i(279277);
    if (Util.isNullOrNil(paramString))
    {
      this.qhp.setVisibility(8);
      AppMethodBeat.o(279277);
      return;
    }
    this.qhp.setVisibility(0);
    this.qhp.setText(paramString);
    AppMethodBeat.o(279277);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.e.SWz;
  }
  
  public void initView()
  {
    AppMethodBeat.i(279329);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    this.lDL = ((ScrollView)findViewById(a.d.scroll_view));
    this.lDM = ((InputPanelLinearLayout)findViewById(a.d.input_container));
    this.lDM.setExternalListener(this);
    this.qhp = ((TextView)findViewById(a.d.error_tip));
    this.qho = findViewById(a.d.forget_pwd_btn);
    this.qhq = ((EditText)findViewById(a.d.pwd_edit));
    this.qhq.requestFocus();
    this.qhq.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(279049);
        if (!Util.isNullOrNil(paramAnonymousEditable.toString()))
        {
          TeenModeVerifyPwdUI.a(TeenModeVerifyPwdUI.this).setEnabled(true);
          AppMethodBeat.o(279049);
          return;
        }
        TeenModeVerifyPwdUI.a(TeenModeVerifyPwdUI.this).setEnabled(false);
        TeenModeVerifyPwdUI.a(TeenModeVerifyPwdUI.this, "");
        AppMethodBeat.o(279049);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.lDJ = ((Button)findViewById(a.d.next_btn));
    this.lDJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(279043);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        TeenModeVerifyPwdUI.a(TeenModeVerifyPwdUI.this, "");
        TeenModeVerifyPwdUI.this.hideVKB();
        TeenModeVerifyPwdUI.b(TeenModeVerifyPwdUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279043);
      }
    });
    this.qho.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(279095);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        TeenModeVerifyPwdUI.this.hideVKB();
        com.tencent.mm.br.c.ai(TeenModeVerifyPwdUI.this, "setting", ".ui.setting.SettingsForgetPwdUI");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279095);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(279089);
        TeenModeVerifyPwdUI.this.onBackPressed();
        AppMethodBeat.o(279089);
        return true;
      }
    });
    AppMethodBeat.o(279329);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(279342);
    super.onBackPressed();
    setResult(0);
    AppMethodBeat.o(279342);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279319);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(384, this);
    ((d)com.tencent.mm.kernel.h.ax(d.class)).rG(7);
    this.scene = getIntent().getIntExtra("key_scenen", 3);
    initView();
    AppMethodBeat.o(279319);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(279334);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(384, this);
    hideVKB();
    AppMethodBeat.o(279334);
  }
  
  public void onInputPanelChange(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(279360);
    Log.i("MicroMsg.VerifyPwdUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.lDJ.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(a.b.Edge_8A);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(a.b.Edge_5A);
      this.lDJ.setLayoutParams(localLayoutParams);
      this.lDM.setPadding(this.lDM.getPaddingLeft(), this.lDM.getPaddingTop(), this.lDM.getPaddingRight(), paramInt);
      paramInt = this.lDL.getHeight();
      this.lDM.requestLayout();
      this.lDM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(279085);
          Log.i("MicroMsg.VerifyPwdUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(TeenModeVerifyPwdUI.c(TeenModeVerifyPwdUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (TeenModeVerifyPwdUI.c(TeenModeVerifyPwdUI.this).getHeight() > paramInt) {
            TeenModeVerifyPwdUI.d(TeenModeVerifyPwdUI.this).scrollBy(0, TeenModeVerifyPwdUI.c(TeenModeVerifyPwdUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(279085);
        }
      });
      AppMethodBeat.o(279360);
      return;
    }
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(a.b.Edge_12A);
    localLayoutParams.topMargin = 0;
    this.lDJ.setLayoutParams(localLayoutParams);
    this.lDM.setPadding(this.lDM.getPaddingLeft(), this.lDM.getPaddingTop(), this.lDM.getPaddingRight(), 0);
    this.lDL.scrollBy(0, 0);
    AppMethodBeat.o(279360);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(279368);
    Log.i("MicroMsg.VerifyPwdUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      j.hEy().rG(2);
      aa.db(this, getString(a.g.verify_password_success));
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(279079);
          TeenModeVerifyPwdUI.this.hideVKB();
          TeenModeVerifyPwdUI.this.setResult(-1);
          TeenModeVerifyPwdUI.e(TeenModeVerifyPwdUI.this);
          if (TeenModeVerifyPwdUI.this.getIntent().getIntExtra("intent_extra_biz_type", 0) != 0)
          {
            com.tencent.mm.plugin.teenmode.a.e locale = new com.tencent.mm.plugin.teenmode.a.e();
            locale.field_businessType = TeenModeVerifyPwdUI.this.getIntent().getIntExtra("intent_extra_biz_type", 2147483647);
            locale.field_businessKey = TeenModeVerifyPwdUI.this.getIntent().getStringExtra("intent_extra_biz_key");
            Object localObject = ((d)com.tencent.mm.kernel.h.ax(d.class)).hEu();
            if (localObject != null) {
              locale.field_guardianUserName = ((az)localObject).field_username;
            }
            locale.field_wardUserName = z.bAM();
            locale.field_time = cn.bDv();
            localObject = com.tencent.mm.plugin.teenmode.b.a.e.SZq;
            com.tencent.mm.plugin.teenmode.b.a.e.hEB().replace(locale);
            ((d)com.tencent.mm.kernel.h.ax(d.class)).hEs();
          }
          AppMethodBeat.o(279079);
        }
      }, 2000L);
      AppMethodBeat.o(279368);
      return;
    }
    j.hEy().rG(6);
    if (paramInt1 == 4)
    {
      if (!Util.isNullOrNil(paramString))
      {
        paramp = com.tencent.mm.broadcast.a.CH(paramString);
        if (paramp != null)
        {
          Df(paramp.desc);
          AppMethodBeat.o(279368);
          return;
        }
        Df(paramString);
        AppMethodBeat.o(279368);
        return;
      }
      Df(getString(a.g.app_err_system_busy_tip));
      AppMethodBeat.o(279368);
      return;
    }
    Df(getString(a.g.app_err_system_busy_tip));
    AppMethodBeat.o(279368);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.TeenModeVerifyPwdUI
 * JD-Core Version:    0.7.0.1
 */