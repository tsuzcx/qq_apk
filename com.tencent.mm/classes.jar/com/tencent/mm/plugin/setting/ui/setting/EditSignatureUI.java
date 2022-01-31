package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;

public class EditSignatureUI
  extends MMActivity
{
  private p efs;
  private com.tencent.mm.sdk.b.c ehn;
  private MMEditText qFH;
  private j.b qFI;
  final bp qFJ;
  private boolean qFK;
  private TextView qFx;
  
  public EditSignatureUI()
  {
    AppMethodBeat.i(126949);
    this.efs = null;
    this.qFJ = bp.aba();
    this.qFK = false;
    this.ehn = new EditSignatureUI.1(this);
    AppMethodBeat.o(126949);
  }
  
  public int getLayoutId()
  {
    return 2130969351;
  }
  
  public void initView()
  {
    AppMethodBeat.i(126952);
    setMMTitle(2131303426);
    this.qFH = ((MMEditText)findViewById(2131820946));
    this.qFx = ((TextView)findViewById(2131823234));
    String str = bo.nullAsNil((String)g.RL().Ru().get(12291, null));
    this.qFH.setText(j.b(this, str, this.qFH.getTextSize()));
    this.qFH.setSelection(this.qFH.getText().length());
    this.qFx.setText(f.bO(60, this.qFH.getEditableText().toString()));
    com.tencent.mm.ui.tools.b.c.d(this.qFH).hR(0, 60).a(null);
    this.qFH.addTextChangedListener(new a((byte)0));
    setBackBtn(new EditSignatureUI.2(this));
    addTextOptionMenu(0, getString(2131297063), new EditSignatureUI.3(this), null, q.b.zby);
    enableOptionMenu(false);
    AppMethodBeat.o(126952);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126950);
    super.onCreate(paramBundle);
    a.ymk.c(this.ehn);
    initView();
    AppMethodBeat.o(126950);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126951);
    super.onDestroy();
    a.ymk.d(this.ehn);
    AppMethodBeat.o(126951);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126953);
    if (paramInt == 4) {
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(126953);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements TextWatcher
  {
    private int qFM = 60;
    
    private a() {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(126948);
      this.qFM = f.bO(60, paramEditable.toString());
      if (this.qFM < 0) {
        this.qFM = 0;
      }
      if (EditSignatureUI.e(EditSignatureUI.this) != null) {
        EditSignatureUI.e(EditSignatureUI.this).setText(this.qFM);
      }
      AppMethodBeat.o(126948);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(126947);
      EditSignatureUI.this.enableOptionMenu(true);
      AppMethodBeat.o(126947);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI
 * JD-Core Version:    0.7.0.1
 */