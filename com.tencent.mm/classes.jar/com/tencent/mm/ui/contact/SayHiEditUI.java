package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;

public class SayHiEditUI
  extends MMActivity
  implements i
{
  private MMEditText PYw;
  private ProgressDialog gtM = null;
  
  public int getLayoutId()
  {
    return 2131496129;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37967);
    this.PYw = ((MMEditText)findViewById(2131307219));
    this.PYw.requestFocus();
    this.PYw.addTextChangedListener(new a((byte)0));
    this.PYw.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(169894);
        if ((4 == paramAnonymousInt) || (66 == paramAnonymousKeyEvent.getAction()))
        {
          SayHiEditUI.a(SayHiEditUI.this);
          AppMethodBeat.o(169894);
          return true;
        }
        AppMethodBeat.o(169894);
        return false;
      }
    });
    c.f(this.PYw).aoq(100).a(null);
    addTextOptionMenu(0, getString(2131755976), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(37963);
        SayHiEditUI.this.hideVKB();
        SayHiEditUI.a(SayHiEditUI.this);
        AppMethodBeat.o(37963);
        return false;
      }
    }, null, t.b.OGU);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(169895);
        SayHiEditUI.this.finish();
        AppMethodBeat.o(169895);
        return true;
      }
    });
    AppMethodBeat.o(37967);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37965);
    super.onCreate(paramBundle);
    bg.azz().a(30, this);
    setMMTitle(2131763455);
    initView();
    AppMethodBeat.o(37965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37966);
    bg.azz().b(30, this);
    super.onDestroy();
    AppMethodBeat.o(37966);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 1;
    AppMethodBeat.i(37968);
    Log.i("MicroMsg.SayHiEditUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    for (;;)
    {
      try
      {
        if (this.gtM != null)
        {
          this.gtM.dismiss();
          this.gtM = null;
        }
        switch (paramInt2)
        {
        default: 
          i = 0;
          if (i == 0) {
            break label178;
          }
          AppMethodBeat.o(37968);
          return;
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.SayHiEditUI", "exception in onSceneEnd : " + paramString.getMessage());
        AppMethodBeat.o(37968);
        return;
      }
      Toast.makeText(this, 2131763456, 0).show();
      continue;
      Toast.makeText(this, 2131763459, 0).show();
    }
    label178:
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.cD(this, getString(2131757788));
      finish();
      AppMethodBeat.o(37968);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString)))
    {
      Toast.makeText(this, paramString, 1).show();
      AppMethodBeat.o(37968);
      return;
    }
    if ((paramInt2 == -101) && (!Util.isNullOrNil(paramString)))
    {
      h.a(this, paramString, getString(2131755998), getString(2131755921), null);
      AppMethodBeat.o(37968);
      return;
    }
    Toast.makeText(this, 2131763457, 0).show();
    AppMethodBeat.o(37968);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    implements TextWatcher
  {
    private boolean hsV = false;
    
    public final void afterTextChanged(Editable paramEditable) {}
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(37964);
      if (this.hsV)
      {
        AppMethodBeat.o(37964);
        return;
      }
      this.hsV = true;
      d.AEF.au(3, 2, 10);
      AppMethodBeat.o(37964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SayHiEditUI
 * JD-Core Version:    0.7.0.1
 */