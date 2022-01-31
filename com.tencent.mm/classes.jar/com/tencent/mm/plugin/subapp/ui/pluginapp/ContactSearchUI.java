package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.io.IOException;

public class ContactSearchUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private ProgressDialog dnm = null;
  private EditText pxN;
  
  private static int PE(String paramString)
  {
    int i = 3;
    if (bk.ZB(paramString)) {
      i = 1;
    }
    do
    {
      return i;
      if (bk.ZC(paramString)) {
        return 2;
      }
    } while (!bk.ZD(paramString));
    return 3;
  }
  
  private void bMd()
  {
    Object localObject = this.pxN.getText().toString().trim();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      com.tencent.mm.ui.base.h.h(this.mController.uMN, R.l.verify_input_null_tip, R.l.app_tip);
      return;
    }
    y.d("MicroMsg.ContactSearchUI", "always search contact from internet!!!");
    localObject = new com.tencent.mm.plugin.messenger.a.f((String)localObject, 1);
    au.Dk().a((m)localObject, 0);
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    getString(R.l.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(R.l.address_searching), true, new ContactSearchUI.5(this, (com.tencent.mm.plugin.messenger.a.f)localObject));
  }
  
  protected final int getLayoutId()
  {
    return R.i.contact_search;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.contact_search_title);
    this.pxN = ((EditText)findViewById(R.h.contact_search_account_et));
    this.pxN.addTextChangedListener(new ContactSearchUI.1(this));
    this.pxN.setImeOptions(3);
    this.pxN.setOnEditorActionListener(new ContactSearchUI.2(this));
    addTextOptionMenu(0, getString(R.l.app_find), new ContactSearchUI.3(this));
    setBackBtn(new ContactSearchUI.4(this));
    if (getIntent().getBooleanExtra("from_webview", false))
    {
      String str = getIntent().getStringExtra("userName");
      this.pxN.setText(str);
      bMd();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  protected void onPause()
  {
    au.Dk().b(106, this);
    super.onPause();
  }
  
  protected void onResume()
  {
    au.Dk().a(106, this);
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ContactSearchUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if (b.eUS.b(this.mController.uMN, paramInt1, paramInt2, paramString)) {}
    Intent localIntent;
    do
    {
      return;
      if ((paramInt1 == 4) && (paramInt2 == -4))
      {
        com.tencent.mm.ui.base.h.h(this.mController.uMN, R.l.address_not_found, R.l.app_tip);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Toast.makeText(this, getString(R.l.fmt_search_err_no_code), 0).show();
        y.w("MicroMsg.ContactSearchUI", getString(R.l.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        return;
      }
      paramString = ((com.tencent.mm.plugin.messenger.a.f)paramm).bhH();
      if (paramString.tcA > 0)
      {
        paramm = new Intent();
        paramm.setClass(this, ContactSearchResultUI.class);
        try
        {
          paramm.putExtra("result", paramString.toByteArray());
          startActivity(paramm);
          return;
        }
        catch (IOException paramString)
        {
          y.printErrStackTrace("MicroMsg.ContactSearchUI", paramString, "", new Object[0]);
          return;
        }
      }
      paramm = aa.a(paramString.sQs);
      localIntent = new Intent();
      ((i)g.r(i.class)).a(localIntent, paramString, PE(this.pxN.getText().toString().trim()));
    } while (bk.pm(paramm).length() <= 0);
    if ((paramString.tpg & 0x8) > 0) {
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10298, paramm + "," + PE(this.pxN.getText().toString().trim()));
    }
    d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI
 * JD-Core Version:    0.7.0.1
 */