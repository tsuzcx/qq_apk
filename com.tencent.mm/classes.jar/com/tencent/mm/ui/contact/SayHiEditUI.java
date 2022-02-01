package com.tencent.mm.ui.contact;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.y.b;

public class SayHiEditUI
  extends MMActivity
  implements h
{
  private MMEditText afhn;
  private ProgressDialog lzP = null;
  
  public int getLayoutId()
  {
    return R.i.gnE;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37967);
    this.afhn = ((MMEditText)findViewById(R.h.fVk));
    this.afhn.requestFocus();
    this.afhn.addTextChangedListener(new a((byte)0));
    this.afhn.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    c.i(this.afhn).aEg(100).a(null);
    addTextOptionMenu(0, getString(R.l.app_send), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(37963);
        SayHiEditUI.this.hideVKB();
        SayHiEditUI.a(SayHiEditUI.this);
        AppMethodBeat.o(37963);
        return false;
      }
    }, null, y.b.adEJ);
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
    bh.aZW().a(30, this);
    setMMTitle(R.l.gOp);
    initView();
    AppMethodBeat.o(37965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37966);
    bh.aZW().b(30, this);
    super.onDestroy();
    AppMethodBeat.o(37966);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 1;
    AppMethodBeat.i(37968);
    Log.i("MicroMsg.SayHiEditUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    for (;;)
    {
      try
      {
        if (this.lzP != null)
        {
          this.lzP.dismiss();
          this.lzP = null;
        }
        switch (paramInt2)
        {
        default: 
          i = 0;
          if (i == 0) {
            break label185;
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
      Toast.makeText(this, R.l.gOq, 0).show();
      continue;
      Toast.makeText(this, R.l.gOs, 0).show();
    }
    label185:
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      k.cZ(this, getString(R.l.confirm_dialog_sent));
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
      k.a(this, paramString, getString(R.l.app_tip), getString(R.l.app_ok), null);
      AppMethodBeat.o(37968);
      return;
    }
    Toast.makeText(this, R.l.gOr, 0).show();
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
    private boolean mEZ = false;
    
    public final void afterTextChanged(Editable paramEditable) {}
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(37964);
      if (this.mEZ)
      {
        AppMethodBeat.o(37964);
        return;
      }
      this.mEZ = true;
      d.MtP.aW(3, 2, 10);
      AppMethodBeat.o(37964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SayHiEditUI
 * JD-Core Version:    0.7.0.1
 */