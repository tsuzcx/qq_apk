package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.IOException;

public class ContactSearchUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private EditText BCr;
  private ProgressDialog fOC = null;
  
  private static int aDV(String paramString)
  {
    AppMethodBeat.i(29226);
    if (bu.aSo(paramString))
    {
      AppMethodBeat.o(29226);
      return 1;
    }
    if (bu.aSp(paramString))
    {
      AppMethodBeat.o(29226);
      return 2;
    }
    if (bu.aSq(paramString))
    {
      AppMethodBeat.o(29226);
      return 3;
    }
    AppMethodBeat.o(29226);
    return 3;
  }
  
  private void eqU()
  {
    AppMethodBeat.i(29224);
    Object localObject = this.BCr.getText().toString().trim();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      h.l(getContext(), 2131764655, 2131755906);
      AppMethodBeat.o(29224);
      return;
    }
    ae.d("MicroMsg.ContactSearchUI", "always search contact from internet!!!");
    localObject = new com.tencent.mm.plugin.messenger.a.f((String)localObject, 1);
    bc.ajj().a((n)localObject, 0);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.fOC = h.b(localAppCompatActivity, getString(2131755224), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(29219);
        bc.ajj().a(this.tJC);
        AppMethodBeat.o(29219);
      }
    });
    AppMethodBeat.o(29224);
  }
  
  public int getLayoutId()
  {
    return 2131493658;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29223);
    setMMTitle(2131757924);
    this.BCr = ((EditText)findViewById(2131298712));
    this.BCr.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(29215);
        ContactSearchUI localContactSearchUI = ContactSearchUI.this;
        if (paramAnonymousEditable.length() > 0) {}
        for (boolean bool = true;; bool = false)
        {
          localContactSearchUI.enableOptionMenu(bool);
          AppMethodBeat.o(29215);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.BCr.setImeOptions(3);
    this.BCr.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(29216);
        if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (!bu.isNullOrNil(ContactSearchUI.a(ContactSearchUI.this).getText().toString().trim()))) {
          ContactSearchUI.b(ContactSearchUI.this);
        }
        AppMethodBeat.o(29216);
        return false;
      }
    });
    addTextOptionMenu(0, getString(2131755774), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29217);
        ContactSearchUI.b(ContactSearchUI.this);
        AppMethodBeat.o(29217);
        return false;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29218);
        ContactSearchUI.this.hideVKB();
        ContactSearchUI.this.finish();
        AppMethodBeat.o(29218);
        return true;
      }
    });
    if (getIntent().getBooleanExtra("from_webview", false))
    {
      String str = getIntent().getStringExtra("userName");
      this.BCr.setText(str);
      eqU();
    }
    AppMethodBeat.o(29223);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29220);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(29220);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29222);
    bc.ajj().b(106, this);
    super.onPause();
    AppMethodBeat.o(29222);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29221);
    bc.ajj().a(106, this);
    super.onResume();
    AppMethodBeat.o(29221);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29225);
    ae.i("MicroMsg.ContactSearchUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if (b.iUA.b(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(29225);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      h.l(getContext(), 2131755218, 2131755906);
      AppMethodBeat.o(29225);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this, getString(2131759561), 0).show();
      ae.w("MicroMsg.ContactSearchUI", getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(29225);
      return;
    }
    paramString = ((com.tencent.mm.plugin.messenger.a.f)paramn).doB();
    if (paramString.GQu > 0)
    {
      paramn = new Intent();
      paramn.setClass(this, ContactSearchResultUI.class);
      try
      {
        paramn.putExtra("result", paramString.toByteArray());
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(29225);
        return;
      }
      catch (IOException paramString)
      {
        ae.printErrStackTrace("MicroMsg.ContactSearchUI", paramString, "", new Object[0]);
        AppMethodBeat.o(29225);
        return;
      }
    }
    paramn = z.a(paramString.GuF);
    Intent localIntent = new Intent();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).a(localIntent, paramString, aDV(this.BCr.getText().toString().trim()));
    if (bu.nullAsNil(paramn).length() > 0)
    {
      if ((paramString.Hhu & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, paramn + "," + aDV(this.BCr.getText().toString().trim()));
      }
      d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
    }
    AppMethodBeat.o(29225);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI
 * JD-Core Version:    0.7.0.1
 */