package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ShareToQQWeiboUI
  extends MMActivity
  implements i
{
  private TextView Jep;
  private ProgressDialog iXX = null;
  private EditText qDO;
  
  public int getLayoutId()
  {
    return c.g.edit_share_qqweibo;
  }
  
  public void initView()
  {
    AppMethodBeat.i(82053);
    setMMTitle(c.i.share_to_tencent_microblog);
    this.qDO = ((EditText)findViewById(c.f.content));
    this.Jep = ((TextView)findViewById(c.f.wordcount));
    String str1 = getIntent().getStringExtra("content");
    String str2 = getIntent().getStringExtra("shortUrl");
    this.qDO.addTextChangedListener(new MMEditText.c(this.qDO, this.Jep, 280));
    if (str1.contains(str2)) {
      this.qDO.setText(str1.trim());
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
      addTextOptionMenu(0, getString(c.i.app_share), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(82050);
          paramAnonymousMenuItem = new y(ShareToQQWeiboUI.this.getIntent().getIntExtra("type", 0), ShareToQQWeiboUI.this.getIntent().getStringExtra("shortUrl"), ShareToQQWeiboUI.a(ShareToQQWeiboUI.this).getText().toString());
          com.tencent.mm.kernel.h.aGY().a(paramAnonymousMenuItem, 0);
          ShareToQQWeiboUI localShareToQQWeiboUI = ShareToQQWeiboUI.this;
          AppCompatActivity localAppCompatActivity = ShareToQQWeiboUI.this.getContext();
          ShareToQQWeiboUI.this.getString(c.i.app_tip);
          ShareToQQWeiboUI.a(localShareToQQWeiboUI, com.tencent.mm.ui.base.h.a(localAppCompatActivity, ShareToQQWeiboUI.this.getString(c.i.wv_sending), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(82049);
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousMenuItem);
              AppMethodBeat.o(82049);
            }
          }));
          AppMethodBeat.o(82050);
          return true;
        }
      });
      AppMethodBeat.o(82053);
      return;
      this.qDO.setText(str1 + " " + str2);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(82051);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aGY().a(26, this);
    initView();
    AppMethodBeat.o(82051);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(82052);
    com.tencent.mm.kernel.h.aGY().b(26, this);
    super.onDestroy();
    AppMethodBeat.o(82052);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(82054);
    Log.i("MicroMsg.ShareToQQWeiboUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramq.getType() != 26)
    {
      AppMethodBeat.o(82054);
      return;
    }
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
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
    Toast.makeText(this, getString(c.i.share_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(82054);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.ShareToQQWeiboUI
 * JD-Core Version:    0.7.0.1
 */