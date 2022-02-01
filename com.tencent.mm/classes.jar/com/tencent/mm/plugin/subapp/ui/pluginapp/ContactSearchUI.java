package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;

public class ContactSearchUI
  extends MMActivity
  implements i
{
  private ProgressDialog iXX = null;
  private EditText xZi;
  
  private static int bdU(String paramString)
  {
    AppMethodBeat.i(29226);
    if (Util.isValidQQNum(paramString))
    {
      AppMethodBeat.o(29226);
      return 1;
    }
    if (Util.isValidEmail(paramString))
    {
      AppMethodBeat.o(29226);
      return 2;
    }
    if (Util.isValidAccount(paramString))
    {
      AppMethodBeat.o(29226);
      return 3;
    }
    AppMethodBeat.o(29226);
    return 3;
  }
  
  private void ghT()
  {
    AppMethodBeat.i(29224);
    Object localObject = this.xZi.getText().toString().trim();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      com.tencent.mm.ui.base.h.p(getContext(), R.l.verify_input_null_tip, R.l.app_tip);
      AppMethodBeat.o(29224);
      return;
    }
    Log.d("MicroMsg.ContactSearchUI", "always search contact from internet!!!");
    localObject = new f((String)localObject, 1);
    bh.aGY().a((q)localObject, 0);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(R.l.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(R.l.address_searching), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(29219);
        bh.aGY().a(this.BMA);
        AppMethodBeat.o(29219);
      }
    });
    AppMethodBeat.o(29224);
  }
  
  public int getLayoutId()
  {
    return R.i.efD;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29223);
    setMMTitle(R.l.eAo);
    this.xZi = ((EditText)findViewById(R.h.dCs));
    this.xZi.addTextChangedListener(new TextWatcher()
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
    this.xZi.setImeOptions(3);
    this.xZi.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(29216);
        if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (!Util.isNullOrNil(ContactSearchUI.a(ContactSearchUI.this).getText().toString().trim()))) {
          ContactSearchUI.b(ContactSearchUI.this);
        }
        AppMethodBeat.o(29216);
        return false;
      }
    });
    addTextOptionMenu(0, getString(R.l.app_find), new MenuItem.OnMenuItemClickListener()
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
      this.xZi.setText(str);
      ghT();
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
    bh.aGY().b(106, this);
    super.onPause();
    AppMethodBeat.o(29222);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29221);
    bh.aGY().a(106, this);
    super.onResume();
    AppMethodBeat.o(29221);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(29225);
    Log.i("MicroMsg.ContactSearchUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if (b.mIH.b(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(29225);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      com.tencent.mm.ui.base.h.p(getContext(), R.l.enL, R.l.app_tip);
      AppMethodBeat.o(29225);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this, getString(R.l.eFO), 0).show();
      Log.w("MicroMsg.ContactSearchUI", getString(R.l.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(29225);
      return;
    }
    paramString = ((f)paramq).eRV();
    if (paramString.Tdj > 0)
    {
      paramq = new Intent();
      paramq.setClass(this, ContactSearchResultUI.class);
      try
      {
        paramq.putExtra("result", paramString.toByteArray());
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/ContactSearchUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(29225);
        return;
      }
      catch (IOException paramString)
      {
        Log.printErrStackTrace("MicroMsg.ContactSearchUI", paramString, "", new Object[0]);
        AppMethodBeat.o(29225);
        return;
      }
    }
    paramq = z.a(paramString.SrH);
    Intent localIntent = new Intent();
    ((k)com.tencent.mm.kernel.h.ae(k.class)).a(localIntent, paramString, bdU(this.xZi.getText().toString().trim()));
    if (Util.nullAsNil(paramq).length() > 0)
    {
      if ((paramString.TxF & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramq + "," + bdU(this.xZi.getText().toString().trim()));
      }
      c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
    }
    AppMethodBeat.o(29225);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI
 * JD-Core Version:    0.7.0.1
 */