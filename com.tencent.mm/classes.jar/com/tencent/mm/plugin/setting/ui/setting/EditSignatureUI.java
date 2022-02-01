package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.y.b;

public class EditSignatureUI
  extends MMActivity
{
  private TextView PoP;
  private MMEditText PoZ;
  
  public EditSignatureUI()
  {
    AppMethodBeat.i(73877);
    AppMethodBeat.o(73877);
  }
  
  public int getLayoutId()
  {
    return b.g.edit_signature;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73880);
    setMMTitle(b.i.settings_signature);
    this.PoZ = ((MMEditText)findViewById(b.f.content));
    this.PoP = ((TextView)findViewById(b.f.wordcount));
    String str = Util.nullAsNil((String)h.baE().ban().d(12291, null));
    this.PoZ.setText(p.b(this, str, this.PoZ.getTextSize()));
    this.PoZ.setSelection(this.PoZ.getText().length());
    this.PoP.setText(g.ej(60, this.PoZ.getEditableText().toString()) / 2);
    com.tencent.mm.ui.tools.b.c.i(this.PoZ).oF(0, 60).a(null);
    this.PoZ.addTextChangedListener(new a((byte)0));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(182594);
        EditSignatureUI.this.hideVKB();
        EditSignatureUI.this.finish();
        AppMethodBeat.o(182594);
        return true;
      }
    });
    addTextOptionMenu(0, getString(b.i.app_save), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73873);
        paramAnonymousMenuItem = EditSignatureUI.b(EditSignatureUI.this).getText().toString().trim();
        String str = com.tencent.mm.k.c.aRm();
        if ((!Util.isNullOrNil(str)) && (paramAnonymousMenuItem.matches(".*[" + str + "].*")))
        {
          k.c(EditSignatureUI.this.getContext(), EditSignatureUI.this.getString(b.i.invalid_input_character_toast, new Object[] { str }), EditSignatureUI.this.getString(b.i.app_tip), true);
          AppMethodBeat.o(73873);
          return false;
        }
        h.baE().ban().B(12291, paramAnonymousMenuItem);
        l.kK(4, 6);
        EditSignatureUI.this.hideVKB();
        EditSignatureUI.this.finish();
        AppMethodBeat.o(73873);
        return true;
      }
    }, null, y.b.adEJ);
    enableOptionMenu(false);
    AppMethodBeat.o(73880);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73878);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(73878);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73879);
    super.onDestroy();
    AppMethodBeat.o(73879);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(73881);
    if (paramInt == 4) {
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(73881);
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
    private int Ppb = 60;
    
    private a() {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(73876);
      this.Ppb = g.ej(60, paramEditable.toString());
      if (this.Ppb < 0) {
        this.Ppb = 0;
      }
      if (EditSignatureUI.a(EditSignatureUI.this) != null) {
        EditSignatureUI.a(EditSignatureUI.this).setText(this.Ppb / 2);
      }
      AppMethodBeat.o(73876);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(73875);
      EditSignatureUI.this.enableOptionMenu(true);
      AppMethodBeat.o(73875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI
 * JD-Core Version:    0.7.0.1
 */