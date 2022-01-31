package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bn;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;

public class EditSignatureUI
  extends MMActivity
{
  private p dnV = null;
  private com.tencent.mm.sdk.b.c dpQ = new EditSignatureUI.1(this);
  private MMEditText nRJ;
  private i.b nRK;
  final bn nRL = bn.Id();
  private boolean nRM = false;
  private TextView nRz;
  
  protected final int getLayoutId()
  {
    return a.g.edit_signature;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_signature);
    this.nRJ = ((MMEditText)findViewById(a.f.content));
    this.nRz = ((TextView)findViewById(a.f.wordcount));
    String str = bk.pm((String)g.DP().Dz().get(12291, null));
    this.nRJ.setText(j.a(this, str, this.nRJ.getTextSize()));
    this.nRJ.setSelection(this.nRJ.getText().length());
    this.nRz.setText(f.bi(60, this.nRJ.getEditableText().toString()));
    com.tencent.mm.ui.tools.a.c.d(this.nRJ).fJ(0, 60).a(null);
    this.nRJ.addTextChangedListener(new EditSignatureUI.a(this, (byte)0));
    setBackBtn(new EditSignatureUI.2(this));
    a(0, getString(a.i.app_save), new EditSignatureUI.3(this), s.b.uNx);
    enableOptionMenu(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a.udP.c(this.dpQ);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a.udP.d(this.dpQ);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      finish();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI
 * JD-Core Version:    0.7.0.1
 */