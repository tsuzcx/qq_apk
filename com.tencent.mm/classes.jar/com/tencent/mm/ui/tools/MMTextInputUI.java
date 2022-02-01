package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.y.b;

public class MMTextInputUI
  extends MMActivity
{
  private TextView afJu;
  private int afJv;
  private int afJw;
  private boolean afJx;
  private EditText dzv;
  private int lyL;
  
  private void goBack()
  {
    AppMethodBeat.i(143185);
    if (getIntent().getBooleanExtra("key_show_confirm", false))
    {
      k.a(getContext(), getString(a.k.quit_confirm_tips), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(143181);
          MMTextInputUI.this.hideVKB();
          MMTextInputUI.this.setResult(0);
          MMTextInputUI.this.finish();
          AppMethodBeat.o(143181);
        }
      }, null);
      AppMethodBeat.o(143185);
      return;
    }
    hideVKB();
    setResult(0);
    finish();
    AppMethodBeat.o(143185);
  }
  
  protected void ac(CharSequence paramCharSequence) {}
  
  public int getLayoutId()
  {
    return a.h.input_text_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(143187);
    super.onCreate(paramBundle);
    this.dzv = ((EditText)findViewById(a.g.text_edit));
    this.afJu = ((TextView)findViewById(a.g.state_tv));
    this.dzv.setHint(Util.nullAs(getIntent().getStringExtra("key_hint"), ""));
    this.dzv.append(Util.nullAs(getIntent().getStringExtra("key_value"), ""));
    this.lyL = (getIntent().getIntExtra("key_max_count", -1) << 1);
    this.afJw = 0;
    this.afJv = Math.max(this.lyL - 120, this.lyL * 9 / 10);
    this.afJx = getIntent().getBooleanExtra("key_nullable", false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(143182);
        MMTextInputUI.a(MMTextInputUI.this);
        AppMethodBeat.o(143182);
        return false;
      }
    });
    addTextOptionMenu(0, getString(a.k.app_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(143183);
        MMTextInputUI.this.ac(MMTextInputUI.b(MMTextInputUI.this).getText());
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("key_result", MMTextInputUI.b(MMTextInputUI.this).getText());
        MMTextInputUI.this.setResult(-1, paramAnonymousMenuItem);
        MMTextInputUI.this.finish();
        AppMethodBeat.o(143183);
        return true;
      }
    }, null, y.b.adEJ);
    enableOptionMenu(this.afJx);
    if ((!this.afJx) || (this.lyL > 0)) {
      this.dzv.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          boolean bool = false;
          AppMethodBeat.i(143184);
          paramAnonymousEditable = paramAnonymousEditable.toString();
          int i;
          if (!MMTextInputUI.c(MMTextInputUI.this))
          {
            if (paramAnonymousEditable.trim().length() > 0) {
              MMTextInputUI.this.enableOptionMenu(true);
            }
          }
          else
          {
            if (MMTextInputUI.d(MMTextInputUI.this) <= 0) {
              break label395;
            }
            MMTextInputUI.e(MMTextInputUI.this);
            i = 0;
            label60:
            if (i >= paramAnonymousEditable.length()) {
              break label118;
            }
            if (!Util.isChinese(paramAnonymousEditable.charAt(i))) {
              break label106;
            }
            MMTextInputUI.a(MMTextInputUI.this, 2);
          }
          for (;;)
          {
            i += 1;
            break label60;
            MMTextInputUI.this.enableOptionMenu(false);
            break;
            label106:
            MMTextInputUI.a(MMTextInputUI.this, 1);
          }
          label118:
          if ((MMTextInputUI.f(MMTextInputUI.this) >= MMTextInputUI.g(MMTextInputUI.this)) && (MMTextInputUI.f(MMTextInputUI.this) <= MMTextInputUI.d(MMTextInputUI.this)))
          {
            MMTextInputUI.this.enableOptionMenu(true);
            MMTextInputUI.h(MMTextInputUI.this).setVisibility(0);
            MMTextInputUI.h(MMTextInputUI.this).setTextColor(MMTextInputUI.this.getResources().getColor(a.d.text_input_limit_tips));
            MMTextInputUI.h(MMTextInputUI.this).setText(MMTextInputUI.this.getString(a.k.text_input_limit_tips, new Object[] { Integer.valueOf(MMTextInputUI.d(MMTextInputUI.this) - MMTextInputUI.f(MMTextInputUI.this) >> 1) }));
            AppMethodBeat.o(143184);
            return;
          }
          if (MMTextInputUI.f(MMTextInputUI.this) > MMTextInputUI.d(MMTextInputUI.this))
          {
            MMTextInputUI.this.enableOptionMenu(false);
            MMTextInputUI.h(MMTextInputUI.this).setVisibility(0);
            MMTextInputUI.h(MMTextInputUI.this).setTextColor(MMTextInputUI.this.getResources().getColor(a.d.text_input_limit_warn));
            MMTextInputUI.h(MMTextInputUI.this).setText(MMTextInputUI.this.getString(a.k.text_input_out_tips, new Object[] { Integer.valueOf((MMTextInputUI.f(MMTextInputUI.this) - MMTextInputUI.d(MMTextInputUI.this) >> 1) + 1) }));
            AppMethodBeat.o(143184);
            return;
          }
          paramAnonymousEditable = MMTextInputUI.this;
          if (MMTextInputUI.c(MMTextInputUI.this)) {
            bool = true;
          }
          for (;;)
          {
            paramAnonymousEditable.enableOptionMenu(bool);
            MMTextInputUI.h(MMTextInputUI.this).setVisibility(8);
            label395:
            AppMethodBeat.o(143184);
            return;
            if (MMTextInputUI.f(MMTextInputUI.this) > 0) {
              bool = true;
            }
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
    }
    AppMethodBeat.o(143187);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(143188);
    super.onDestroy();
    AppMethodBeat.o(143188);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(143186);
    if (4 == paramInt)
    {
      Log.i("MicroMsg.MMTextInputUI", "on back key down");
      goBack();
      AppMethodBeat.o(143186);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(143186);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(143190);
    super.onPause();
    AppMethodBeat.o(143190);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(143189);
    super.onResume();
    AppMethodBeat.o(143189);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMTextInputUI
 * JD-Core Version:    0.7.0.1
 */