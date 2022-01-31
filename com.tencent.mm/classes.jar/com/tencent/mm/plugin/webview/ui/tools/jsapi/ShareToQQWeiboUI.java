package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ShareToQQWeiboUI
  extends MMActivity
  implements f
{
  private ProgressDialog dnm = null;
  private TextView nRz;
  private EditText nge;
  
  protected final int getLayoutId()
  {
    return R.i.edit_share_qqweibo;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.share_to_tencent_microblog);
    this.nge = ((EditText)findViewById(R.h.content));
    this.nRz = ((TextView)findViewById(R.h.wordcount));
    String str1 = getIntent().getStringExtra("content");
    String str2 = getIntent().getStringExtra("shortUrl");
    this.nge.addTextChangedListener(new MMEditText.c(this.nge, this.nRz, 280));
    if (str1.contains(str2)) {
      this.nge.setText(str1.trim());
    }
    for (;;)
    {
      setBackBtn(new ShareToQQWeiboUI.1(this));
      addTextOptionMenu(0, getString(R.l.app_share), new ShareToQQWeiboUI.2(this));
      return;
      this.nge.setText(str1 + " " + str2);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    au.Dk().a(26, this);
    initView();
  }
  
  public void onDestroy()
  {
    au.Dk().b(26, this);
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ShareToQQWeiboUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramm.getType() != 26) {
      return;
    }
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      XM();
      setResult(-1);
      finish();
      return;
    }
    setResult(1, new Intent().putExtra("err_code", paramInt2));
    Toast.makeText(this, getString(R.l.share_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.ShareToQQWeiboUI
 * JD-Core Version:    0.7.0.1
 */