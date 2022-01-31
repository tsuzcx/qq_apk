package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.q.b;

public class MMTextInputUI
  extends MMActivity
{
  private TextView Awg;
  private int Awh;
  private int Awi;
  private boolean Awj;
  private int eeH;
  private EditText naN;
  
  private void goBack()
  {
    AppMethodBeat.i(107728);
    if (getIntent().getBooleanExtra("key_show_confirm", false))
    {
      h.a(getContext(), getString(2131302257), "", new MMTextInputUI.1(this), null);
      AppMethodBeat.o(107728);
      return;
    }
    hideVKB();
    setResult(0);
    finish();
    AppMethodBeat.o(107728);
  }
  
  protected void G(CharSequence paramCharSequence) {}
  
  public int getLayoutId()
  {
    return 2130969905;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107730);
    super.onCreate(paramBundle);
    this.naN = ((EditText)findViewById(2131823497));
    this.Awg = ((TextView)findViewById(2131824008));
    this.naN.setHint(bo.bf(getIntent().getStringExtra("key_hint"), ""));
    this.naN.append(bo.bf(getIntent().getStringExtra("key_value"), ""));
    this.eeH = (getIntent().getIntExtra("key_max_count", -1) << 1);
    this.Awi = 0;
    this.Awh = Math.max(this.eeH - 120, this.eeH * 9 / 10);
    this.Awj = getIntent().getBooleanExtra("key_nullable", false);
    setBackBtn(new MMTextInputUI.2(this));
    addTextOptionMenu(0, getString(2131296964), new MMTextInputUI.3(this), null, q.b.zby);
    enableOptionMenu(this.Awj);
    if ((!this.Awj) || (this.eeH > 0)) {
      this.naN.addTextChangedListener(new MMTextInputUI.4(this));
    }
    AppMethodBeat.o(107730);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107731);
    super.onDestroy();
    AppMethodBeat.o(107731);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107729);
    if (4 == paramInt)
    {
      ab.i("MicroMsg.MMTextInputUI", "on back key down");
      goBack();
      AppMethodBeat.o(107729);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(107729);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107733);
    super.onPause();
    AppMethodBeat.o(107733);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107732);
    super.onResume();
    AppMethodBeat.o(107732);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMTextInputUI
 * JD-Core Version:    0.7.0.1
 */