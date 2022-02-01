package com.tencent.mm.ui.tools;

import android.app.Activity;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t.b;

public class MMTextInputUI
  extends MMActivity
{
  private TextView Qvd;
  private int Qve;
  private int Qvf;
  private boolean Qvg;
  private int maxCount;
  private EditText vy;
  
  private void goBack()
  {
    AppMethodBeat.i(143185);
    if (getIntent().getBooleanExtra("key_show_confirm", false))
    {
      h.a(getContext(), getString(2131764158), "", new DialogInterface.OnClickListener()
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
  
  protected void O(CharSequence paramCharSequence) {}
  
  public int getLayoutId()
  {
    return 2131495075;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(143187);
    super.onCreate(paramBundle);
    this.vy = ((EditText)findViewById(2131308994));
    this.Qvd = ((TextView)findViewById(2131308383));
    this.vy.setHint(Util.nullAs(getIntent().getStringExtra("key_hint"), ""));
    this.vy.append(Util.nullAs(getIntent().getStringExtra("key_value"), ""));
    this.maxCount = (getIntent().getIntExtra("key_max_count", -1) << 1);
    this.Qvf = 0;
    this.Qve = Math.max(this.maxCount - 120, this.maxCount * 9 / 10);
    this.Qvg = getIntent().getBooleanExtra("key_nullable", false);
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
    addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(143183);
        MMTextInputUI.this.O(MMTextInputUI.b(MMTextInputUI.this).getText());
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("key_result", MMTextInputUI.b(MMTextInputUI.this).getText());
        MMTextInputUI.this.setResult(-1, paramAnonymousMenuItem);
        MMTextInputUI.this.finish();
        AppMethodBeat.o(143183);
        return true;
      }
    }, null, t.b.OGU);
    enableOptionMenu(this.Qvg);
    if ((!this.Qvg) || (this.maxCount > 0)) {
      this.vy.addTextChangedListener(new TextWatcher()
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
              break label408;
            }
            MMTextInputUI.a(MMTextInputUI.this, 0);
            i = 0;
            label61:
            if (i >= paramAnonymousEditable.length()) {
              break label135;
            }
            if (!Util.isChinese(paramAnonymousEditable.charAt(i))) {
              break label115;
            }
            MMTextInputUI.a(MMTextInputUI.this, MMTextInputUI.e(MMTextInputUI.this) + 2);
          }
          for (;;)
          {
            i += 1;
            break label61;
            MMTextInputUI.this.enableOptionMenu(false);
            break;
            label115:
            MMTextInputUI.a(MMTextInputUI.this, MMTextInputUI.e(MMTextInputUI.this) + 1);
          }
          label135:
          if ((MMTextInputUI.e(MMTextInputUI.this) >= MMTextInputUI.f(MMTextInputUI.this)) && (MMTextInputUI.e(MMTextInputUI.this) <= MMTextInputUI.d(MMTextInputUI.this)))
          {
            MMTextInputUI.this.enableOptionMenu(true);
            MMTextInputUI.g(MMTextInputUI.this).setVisibility(0);
            MMTextInputUI.g(MMTextInputUI.this).setTextColor(MMTextInputUI.this.getResources().getColor(2131101250));
            MMTextInputUI.g(MMTextInputUI.this).setText(MMTextInputUI.this.getString(2131766708, new Object[] { Integer.valueOf(MMTextInputUI.d(MMTextInputUI.this) - MMTextInputUI.e(MMTextInputUI.this) >> 1) }));
            AppMethodBeat.o(143184);
            return;
          }
          if (MMTextInputUI.e(MMTextInputUI.this) > MMTextInputUI.d(MMTextInputUI.this))
          {
            MMTextInputUI.this.enableOptionMenu(false);
            MMTextInputUI.g(MMTextInputUI.this).setVisibility(0);
            MMTextInputUI.g(MMTextInputUI.this).setTextColor(MMTextInputUI.this.getResources().getColor(2131101251));
            MMTextInputUI.g(MMTextInputUI.this).setText(MMTextInputUI.this.getString(2131766709, new Object[] { Integer.valueOf((MMTextInputUI.e(MMTextInputUI.this) - MMTextInputUI.d(MMTextInputUI.this) >> 1) + 1) }));
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
            MMTextInputUI.g(MMTextInputUI.this).setVisibility(8);
            label408:
            AppMethodBeat.o(143184);
            return;
            if (MMTextInputUI.e(MMTextInputUI.this) > 0) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMTextInputUI
 * JD-Core Version:    0.7.0.1
 */