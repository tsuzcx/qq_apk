package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;

public class MMTextInputUI
  extends MMActivity
{
  private int dng;
  private int iaT;
  private EditText kEp;
  private int wdA;
  private boolean wdB;
  private TextView wdz;
  
  private void goBack()
  {
    if (getIntent().getBooleanExtra("key_show_confirm", false))
    {
      h.a(this.mController.uMN, getString(a.k.quit_confirm_tips), "", new MMTextInputUI.1(this), null);
      return;
    }
    XM();
    setResult(0);
    finish();
  }
  
  public int getLayoutId()
  {
    return a.h.input_text_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.kEp = ((EditText)findViewById(a.g.text_edit));
    this.wdz = ((TextView)findViewById(a.g.state_tv));
    this.kEp.setHint(bk.aM(getIntent().getStringExtra("key_hint"), ""));
    this.kEp.append(bk.aM(getIntent().getStringExtra("key_value"), ""));
    this.dng = (getIntent().getIntExtra("key_max_count", -1) << 1);
    this.iaT = 0;
    this.wdA = Math.max(this.dng - 120, this.dng * 9 / 10);
    this.wdB = getIntent().getBooleanExtra("key_nullable", false);
    setBackBtn(new MMTextInputUI.2(this));
    a(0, getString(a.k.app_finish), new MMTextInputUI.3(this), s.b.uNx);
    enableOptionMenu(this.wdB);
    if ((!this.wdB) || (this.dng > 0)) {
      this.kEp.addTextChangedListener(new MMTextInputUI.4(this));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramInt)
    {
      y.i("MicroMsg.MMTextInputUI", "on back key down");
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void x(CharSequence paramCharSequence) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMTextInputUI
 * JD-Core Version:    0.7.0.1
 */