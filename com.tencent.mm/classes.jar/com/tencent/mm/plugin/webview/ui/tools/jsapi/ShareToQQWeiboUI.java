package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ShareToQQWeiboUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private ProgressDialog fpP = null;
  private EditText lmq;
  private TextView wdU;
  
  public int getLayoutId()
  {
    return 2131493738;
  }
  
  public void initView()
  {
    AppMethodBeat.i(82053);
    setMMTitle(2131763651);
    this.lmq = ((EditText)findViewById(2131298739));
    this.wdU = ((TextView)findViewById(2131307005));
    String str1 = getIntent().getStringExtra("content");
    String str2 = getIntent().getStringExtra("shortUrl");
    this.lmq.addTextChangedListener(new MMEditText.c(this.lmq, this.wdU, 280));
    if (str1.contains(str2)) {
      this.lmq.setText(str1.trim());
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(82048);
          ShareToQQWeiboUI.this.hideVKB();
          ShareToQQWeiboUI.this.finish();
          AppMethodBeat.o(82048);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755891), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(82050);
          paramAnonymousMenuItem = new x(ShareToQQWeiboUI.this.getIntent().getIntExtra("type", 0), ShareToQQWeiboUI.this.getIntent().getStringExtra("shortUrl"), ShareToQQWeiboUI.a(ShareToQQWeiboUI.this).getText().toString());
          com.tencent.mm.kernel.g.aeS().a(paramAnonymousMenuItem, 0);
          ShareToQQWeiboUI localShareToQQWeiboUI = ShareToQQWeiboUI.this;
          AppCompatActivity localAppCompatActivity = ShareToQQWeiboUI.this.getContext();
          ShareToQQWeiboUI.this.getString(2131755906);
          ShareToQQWeiboUI.a(localShareToQQWeiboUI, h.b(localAppCompatActivity, ShareToQQWeiboUI.this.getString(2131766286), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(82049);
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousMenuItem);
              AppMethodBeat.o(82049);
            }
          }));
          AppMethodBeat.o(82050);
          return true;
        }
      });
      AppMethodBeat.o(82053);
      return;
      this.lmq.setText(str1 + " " + str2);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(82051);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aeS().a(26, this);
    initView();
    AppMethodBeat.o(82051);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(82052);
    com.tencent.mm.kernel.g.aeS().b(26, this);
    super.onDestroy();
    AppMethodBeat.o(82052);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(82054);
    ad.i("MicroMsg.ShareToQQWeiboUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() != 26)
    {
      AppMethodBeat.o(82054);
      return;
    }
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      hideVKB();
      setResult(-1);
      finish();
      AppMethodBeat.o(82054);
      return;
    }
    setResult(1, new Intent().putExtra("err_code", paramInt2));
    Toast.makeText(this, getString(2131763645, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(82054);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.ShareToQQWeiboUI
 * JD-Core Version:    0.7.0.1
 */