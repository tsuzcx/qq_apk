package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.MMEditText;

public class SayHiEditUI
  extends MMActivity
  implements i
{
  private MMEditText Xvu;
  private ProgressDialog iXX = null;
  
  public int getLayoutId()
  {
    return R.i.ekz;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37967);
    this.Xvu = ((MMEditText)findViewById(R.h.dTd));
    this.Xvu.requestFocus();
    this.Xvu.addTextChangedListener(new SayHiEditUI.a((byte)0));
    this.Xvu.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    c.i(this.Xvu).axx(100).a(null);
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
    }, null, w.b.Wao);
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
    bh.aGY().a(30, this);
    setMMTitle(R.l.nearby_friend_say_hi);
    initView();
    AppMethodBeat.o(37965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37966);
    bh.aGY().b(30, this);
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
        if (this.iXX != null)
        {
          this.iXX.dismiss();
          this.iXX = null;
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
      Toast.makeText(this, R.l.nearby_friend_say_hi_black_list, 0).show();
      continue;
      Toast.makeText(this, R.l.nearby_friend_say_hi_spam, 0).show();
    }
    label185:
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.cO(this, getString(R.l.confirm_dialog_sent));
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
      h.a(this, paramString, getString(R.l.app_tip), getString(R.l.app_ok), null);
      AppMethodBeat.o(37968);
      return;
    }
    Toast.makeText(this, R.l.nearby_friend_say_hi_failed, 0).show();
    AppMethodBeat.o(37968);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SayHiEditUI
 * JD-Core Version:    0.7.0.1
 */