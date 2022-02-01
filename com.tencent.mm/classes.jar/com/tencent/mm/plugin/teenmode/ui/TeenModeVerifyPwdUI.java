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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;

public class TeenModeVerifyPwdUI
  extends MMActivity
  implements i, b.a
{
  private Button gxv;
  private ScrollView gxx;
  private InputPanelLinearLayout gxy;
  private View ksx;
  private TextView ksy;
  private EditText ksz;
  private int scene;
  private com.tencent.mm.ui.base.q tipDialog;
  
  private void DI(String paramString)
  {
    AppMethodBeat.i(187461);
    if (Util.isNullOrNil(paramString))
    {
      this.ksy.setVisibility(8);
      AppMethodBeat.o(187461);
      return;
    }
    this.ksy.setVisibility(0);
    this.ksy.setText(paramString);
    AppMethodBeat.o(187461);
  }
  
  public final void f(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(187464);
    Log.i("MicroMsg.VerifyPwdUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.gxv.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165312);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165306);
      this.gxv.setLayoutParams(localLayoutParams);
      this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), paramInt);
      paramInt = this.gxx.getHeight();
      this.gxy.requestLayout();
      this.gxy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187457);
          Log.i("MicroMsg.VerifyPwdUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(TeenModeVerifyPwdUI.c(TeenModeVerifyPwdUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (TeenModeVerifyPwdUI.c(TeenModeVerifyPwdUI.this).getHeight() > paramInt) {
            TeenModeVerifyPwdUI.d(TeenModeVerifyPwdUI.this).scrollBy(0, TeenModeVerifyPwdUI.c(TeenModeVerifyPwdUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(187457);
        }
      });
      AppMethodBeat.o(187464);
      return;
    }
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165281);
    localLayoutParams.topMargin = 0;
    this.gxv.setLayoutParams(localLayoutParams);
    this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), 0);
    this.gxx.scrollBy(0, 0);
    AppMethodBeat.o(187464);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496788;
  }
  
  public void initView()
  {
    AppMethodBeat.i(187460);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    this.gxx = ((ScrollView)findViewById(2131307339));
    this.gxy = ((InputPanelLinearLayout)findViewById(2131302671));
    this.gxy.setExternalListener(this);
    this.ksy = ((TextView)findViewById(2131300161));
    this.ksx = findViewById(2131301694);
    this.ksz = ((EditText)findViewById(2131306323));
    this.ksz.requestFocus();
    this.ksz.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(187453);
        if (!Util.isNullOrNil(paramAnonymousEditable.toString()))
        {
          TeenModeVerifyPwdUI.a(TeenModeVerifyPwdUI.this).setEnabled(true);
          AppMethodBeat.o(187453);
          return;
        }
        TeenModeVerifyPwdUI.a(TeenModeVerifyPwdUI.this).setEnabled(false);
        TeenModeVerifyPwdUI.a(TeenModeVerifyPwdUI.this, "");
        AppMethodBeat.o(187453);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.gxv = ((Button)findViewById(2131305423));
    this.gxv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187454);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        TeenModeVerifyPwdUI.a(TeenModeVerifyPwdUI.this, "");
        TeenModeVerifyPwdUI.this.hideVKB();
        TeenModeVerifyPwdUI.b(TeenModeVerifyPwdUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187454);
      }
    });
    this.ksx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187455);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        TeenModeVerifyPwdUI.this.hideVKB();
        c.V(TeenModeVerifyPwdUI.this, "setting", ".ui.setting.SettingsForgetPwdUI");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/TeenModeVerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187455);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(187456);
        TeenModeVerifyPwdUI.this.onBackPressed();
        AppMethodBeat.o(187456);
        return true;
      }
    });
    AppMethodBeat.o(187460);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(187463);
    super.onBackPressed();
    setResult(0);
    AppMethodBeat.o(187463);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(187459);
    super.onCreate(paramBundle);
    g.azz().a(384, this);
    this.scene = getIntent().getIntExtra("key_scenen", 3);
    initView();
    AppMethodBeat.o(187459);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(187462);
    super.onDestroy();
    g.azz().b(384, this);
    hideVKB();
    AppMethodBeat.o(187462);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(187465);
    Log.i("MicroMsg.VerifyPwdUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.teenmode.b.b.fvs().pl(2);
      u.cG(this, getString(2131767030));
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187458);
          TeenModeVerifyPwdUI.this.hideVKB();
          TeenModeVerifyPwdUI.this.finish();
          c.V(TeenModeVerifyPwdUI.this, "teenmode", ".ui.SettingsTeenModeMain");
          AppMethodBeat.o(187458);
        }
      }, 2000L);
      AppMethodBeat.o(187465);
      return;
    }
    com.tencent.mm.plugin.teenmode.b.b.fvs().pl(6);
    if (paramInt1 == 4)
    {
      if (!Util.isNullOrNil(paramString))
      {
        paramq = com.tencent.mm.h.a.Dk(paramString);
        if (paramq != null)
        {
          DI(paramq.desc);
          AppMethodBeat.o(187465);
          return;
        }
        DI(paramString);
        AppMethodBeat.o(187465);
        return;
      }
      DI(getString(2131755804));
      AppMethodBeat.o(187465);
      return;
    }
    DI(getString(2131755804));
    AppMethodBeat.o(187465);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.TeenModeVerifyPwdUI
 * JD-Core Version:    0.7.0.1
 */