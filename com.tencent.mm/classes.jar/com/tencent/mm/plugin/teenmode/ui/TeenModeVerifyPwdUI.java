package com.tencent.mm.plugin.teenmode.ui;

import android.app.Activity;
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
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.c.a;

public class TeenModeVerifyPwdUI
  extends MMActivity
  implements com.tencent.mm.an.i, c.a
{
  private Button jbJ;
  private ScrollView jbL;
  private InputPanelLinearLayout jbM;
  private View nkg;
  private TextView nkh;
  private EditText nki;
  private int scene;
  private s tipDialog;
  
  private void Kz(String paramString)
  {
    AppMethodBeat.i(259479);
    if (Util.isNullOrNil(paramString))
    {
      this.nkh.setVisibility(8);
      AppMethodBeat.o(259479);
      return;
    }
    this.nkh.setVisibility(0);
    this.nkh.setText(paramString);
    AppMethodBeat.o(259479);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.e.MsJ;
  }
  
  public final void h(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(259482);
    Log.i("MicroMsg.VerifyPwdUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jbJ.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(a.b.Edge_8A);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(a.b.Edge_5A);
      this.jbJ.setLayoutParams(localLayoutParams);
      this.jbM.setPadding(this.jbM.getPaddingLeft(), this.jbM.getPaddingTop(), this.jbM.getPaddingRight(), paramInt);
      paramInt = this.jbL.getHeight();
      this.jbM.requestLayout();
      this.jbM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(259532);
          Log.i("MicroMsg.VerifyPwdUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(TeenModeVerifyPwdUI.c(TeenModeVerifyPwdUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (TeenModeVerifyPwdUI.c(TeenModeVerifyPwdUI.this).getHeight() > paramInt) {
            TeenModeVerifyPwdUI.d(TeenModeVerifyPwdUI.this).scrollBy(0, TeenModeVerifyPwdUI.c(TeenModeVerifyPwdUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(259532);
        }
      });
      AppMethodBeat.o(259482);
      return;
    }
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(a.b.Edge_12A);
    localLayoutParams.topMargin = 0;
    this.jbJ.setLayoutParams(localLayoutParams);
    this.jbM.setPadding(this.jbM.getPaddingLeft(), this.jbM.getPaddingTop(), this.jbM.getPaddingRight(), 0);
    this.jbL.scrollBy(0, 0);
    AppMethodBeat.o(259482);
  }
  
  public void initView()
  {
    AppMethodBeat.i(259478);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.a.white));
    this.jbL = ((ScrollView)findViewById(a.d.scroll_view));
    this.jbM = ((InputPanelLinearLayout)findViewById(a.d.input_container));
    this.jbM.setExternalListener(this);
    this.nkh = ((TextView)findViewById(a.d.error_tip));
    this.nkg = findViewById(a.d.forget_pwd_btn);
    this.nki = ((EditText)findViewById(a.d.pwd_edit));
    this.nki.requestFocus();
    this.nki.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(259462);
        if (!Util.isNullOrNil(paramAnonymousEditable.toString()))
        {
          TeenModeVerifyPwdUI.a(TeenModeVerifyPwdUI.this).setEnabled(true);
          AppMethodBeat.o(259462);
          return;
        }
        TeenModeVerifyPwdUI.a(TeenModeVerifyPwdUI.this).setEnabled(false);
        TeenModeVerifyPwdUI.a(TeenModeVerifyPwdUI.this, "");
        AppMethodBeat.o(259462);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.jbJ = ((Button)findViewById(a.d.next_btn));
    this.jbJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(259340);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        TeenModeVerifyPwdUI.a(TeenModeVerifyPwdUI.this, "");
        TeenModeVerifyPwdUI.this.hideVKB();
        TeenModeVerifyPwdUI.b(TeenModeVerifyPwdUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(259340);
      }
    });
    this.nkg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(259658);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        TeenModeVerifyPwdUI.this.hideVKB();
        c.ad(TeenModeVerifyPwdUI.this, "setting", ".ui.setting.SettingsForgetPwdUI");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(259658);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(259602);
        TeenModeVerifyPwdUI.this.onBackPressed();
        AppMethodBeat.o(259602);
        return true;
      }
    });
    AppMethodBeat.o(259478);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(259481);
    super.onBackPressed();
    setResult(0);
    AppMethodBeat.o(259481);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(259477);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aGY().a(384, this);
    ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).rE(7);
    this.scene = getIntent().getIntExtra("key_scenen", 3);
    initView();
    AppMethodBeat.o(259477);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(259480);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(384, this);
    hideVKB();
    AppMethodBeat.o(259480);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(259484);
    Log.i("MicroMsg.VerifyPwdUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.teenmode.b.b.gkv().rE(2);
      w.cR(this, getString(a.g.verify_password_success));
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(259655);
          TeenModeVerifyPwdUI.this.hideVKB();
          c.ad(TeenModeVerifyPwdUI.this, "teenmode", ".ui.SettingsTeenModeMain");
          com.tencent.e.h.ZvG.p(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(259537);
              TeenModeVerifyPwdUI.this.finish();
              AppMethodBeat.o(259537);
            }
          }, 200L);
          AppMethodBeat.o(259655);
        }
      }, 2000L);
      AppMethodBeat.o(259484);
      return;
    }
    com.tencent.mm.plugin.teenmode.b.b.gkv().rE(6);
    if (paramInt1 == 4)
    {
      if (!Util.isNullOrNil(paramString))
      {
        paramq = com.tencent.mm.h.a.Kb(paramString);
        if (paramq != null)
        {
          Kz(paramq.desc);
          AppMethodBeat.o(259484);
          return;
        }
        Kz(paramString);
        AppMethodBeat.o(259484);
        return;
      }
      Kz(getString(a.g.app_err_system_busy_tip));
      AppMethodBeat.o(259484);
      return;
    }
    Kz(getString(a.g.app_err_system_busy_tip));
    AppMethodBeat.o(259484);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.TeenModeVerifyPwdUI
 * JD-Core Version:    0.7.0.1
 */