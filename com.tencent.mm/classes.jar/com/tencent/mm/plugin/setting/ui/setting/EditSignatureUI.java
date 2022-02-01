package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;

public class EditSignatureUI
  extends MMActivity
{
  private TextView CYJ;
  private MMEditText CYT;
  
  public EditSignatureUI()
  {
    AppMethodBeat.i(73877);
    AppMethodBeat.o(73877);
  }
  
  public int getLayoutId()
  {
    return 2131493875;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73880);
    setMMTitle(2131765590);
    this.CYT = ((MMEditText)findViewById(2131299180));
    this.CYJ = ((TextView)findViewById(2131310528));
    String str = Util.nullAsNil((String)g.aAh().azQ().get(12291, null));
    this.CYT.setText(l.b(this, str, this.CYT.getTextSize()));
    this.CYT.setSelection(this.CYT.getText().length());
    this.CYJ.setText(f.dp(60, this.CYT.getEditableText().toString()));
    com.tencent.mm.ui.tools.b.c.f(this.CYT).lv(0, 60).a(null);
    this.CYT.addTextChangedListener(new a((byte)0));
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
    addTextOptionMenu(0, getString(2131755970), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73873);
        paramAnonymousMenuItem = EditSignatureUI.b(EditSignatureUI.this).getText().toString().trim();
        String str = com.tencent.mm.n.c.aqt();
        if ((!Util.isNullOrNil(str)) && (paramAnonymousMenuItem.matches(".*[" + str + "].*")))
        {
          h.c(EditSignatureUI.this.getContext(), EditSignatureUI.this.getString(2131761795, new Object[] { str }), EditSignatureUI.this.getString(2131755998), true);
          AppMethodBeat.o(73873);
          return false;
        }
        g.aAh().azQ().set(12291, paramAnonymousMenuItem);
        EditSignatureUI.this.hideVKB();
        EditSignatureUI.this.finish();
        AppMethodBeat.o(73873);
        return true;
      }
    }, null, t.b.OGU);
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
    private int CYV = 60;
    
    private a() {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(73876);
      this.CYV = f.dp(60, paramEditable.toString());
      if (this.CYV < 0) {
        this.CYV = 0;
      }
      if (EditSignatureUI.a(EditSignatureUI.this) != null) {
        EditSignatureUI.a(EditSignatureUI.this).setText(this.CYV);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI
 * JD-Core Version:    0.7.0.1
 */