package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ShareToQQUI
  extends MMActivity
  implements f
{
  private ProgressDialog dnm = null;
  private int nRA;
  private boolean nRB = false;
  private TextView nRz;
  private EditText nge;
  
  protected final int getLayoutId()
  {
    return a.g.edit_sharetoqq;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.send_qrcode_to_microblog);
    this.nge = ((EditText)findViewById(a.f.content));
    this.nRz = ((TextView)findViewById(a.f.wordcount));
    this.nge.addTextChangedListener(new MMEditText.c(this.nge, this.nRz, 280));
    this.nRA = getIntent().getIntExtra("show_to", 2);
    if (this.nRA == 4) {
      this.nge.setText(a.i.self_qrcode_show_facebook_et_content);
    }
    for (;;)
    {
      setBackBtn(new ShareToQQUI.1(this));
      addTextOptionMenu(0, getString(a.i.app_share), new ShareToQQUI.2(this));
      return;
      this.nge.setText(a.i.self_qrcode_show_qq_et_content);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.Dk().a(26, this);
    initView();
    if (q.GL())
    {
      paramBundle = new c("290293790992170");
      paramBundle.aea(bk.pm((String)com.tencent.mm.kernel.g.DP().Dz().get(65830, null)));
      new com.tencent.mm.plugin.account.model.g(paramBundle, new ShareToQQUI.5(this)).Xx();
    }
  }
  
  public void onDestroy()
  {
    com.tencent.mm.kernel.g.Dk().b(26, this);
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ShareToQQUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramm.getType() != 26) {}
    do
    {
      return;
      if (this.dnm != null)
      {
        this.dnm.dismiss();
        this.dnm = null;
      }
      if ((paramInt1 == 4) && (paramInt2 == -68))
      {
        paramm = paramString;
        if (bk.bl(paramString)) {
          paramm = "error";
        }
        h.a(this, paramm, getString(a.i.app_tip), new ShareToQQUI.3(this), null);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        XM();
        paramString = getString(a.i.share_ok);
        new ShareToQQUI.4(this);
        h.bC(this, paramString);
        return;
      }
      this.nRB = false;
    } while (b.eUS.a(this.mController.uMN, paramInt1, paramInt2, paramString));
    Toast.makeText(this, getString(a.i.share_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI
 * JD-Core Version:    0.7.0.1
 */