package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ShareToQQWeiboUI
  extends MMActivity
  implements f
{
  private ProgressDialog eeN = null;
  private EditText pLt;
  private TextView qFx;
  
  public int getLayoutId()
  {
    return 2130969349;
  }
  
  public void initView()
  {
    AppMethodBeat.i(9845);
    setMMTitle(2131303669);
    this.pLt = ((EditText)findViewById(2131820946));
    this.qFx = ((TextView)findViewById(2131823234));
    String str1 = getIntent().getStringExtra("content");
    String str2 = getIntent().getStringExtra("shortUrl");
    this.pLt.addTextChangedListener(new MMEditText.c(this.pLt, this.qFx, 280));
    if (str1.contains(str2)) {
      this.pLt.setText(str1.trim());
    }
    for (;;)
    {
      setBackBtn(new ShareToQQWeiboUI.1(this));
      addTextOptionMenu(0, getString(2131297073), new ShareToQQWeiboUI.2(this));
      AppMethodBeat.o(9845);
      return;
      this.pLt.setText(str1 + " " + str2);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9843);
    super.onCreate(paramBundle);
    g.Rc().a(26, this);
    initView();
    AppMethodBeat.o(9843);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(9844);
    g.Rc().b(26, this);
    super.onDestroy();
    AppMethodBeat.o(9844);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(9846);
    ab.i("MicroMsg.ShareToQQWeiboUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramm.getType() != 26)
    {
      AppMethodBeat.o(9846);
      return;
    }
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      hideVKB();
      setResult(-1);
      finish();
      AppMethodBeat.o(9846);
      return;
    }
    setResult(1, new Intent().putExtra("err_code", paramInt2));
    Toast.makeText(this, getString(2131303663, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(9846);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.ShareToQQWeiboUI
 * JD-Core Version:    0.7.0.1
 */