package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.ba.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class ShowQRCodeStep1UI
  extends MMActivity
  implements f
{
  private ProgressDialog dnm = null;
  private int nRA = 1;
  private ImageView nRF = null;
  byte[] nRG = null;
  
  final void byI()
  {
    a locala = new a();
    g.Dk().a(locala, 0);
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    getString(a.i.app_tip);
    this.dnm = h.b(localAppCompatActivity, getString(a.i.self_qrcode_getting), true, new ShowQRCodeStep1UI.5(this, locala));
  }
  
  protected final int getLayoutId()
  {
    return a.g.show_qrcode_step1;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.send_qrcode_to_microblog);
    this.nRF = ((ImageView)findViewById(a.f.self_qrcode_iv));
    this.nRA = getIntent().getIntExtra("show_to", 1);
    TextView localTextView = (TextView)findViewById(a.f.show_qrcode_info_tv);
    if (this.nRA == 3) {
      localTextView.setText(getString(a.i.self_qrcode_show_all, new Object[] { getString(a.i.self_qrcode_show_all_sina) }));
    }
    for (;;)
    {
      byI();
      setBackBtn(new ShowQRCodeStep1UI.1(this));
      addIconOptionMenu(0, a.e.mm_title_btn_menu, new ShowQRCodeStep1UI.2(this));
      ((Button)findViewById(a.f.self_qrcode_share_btn)).setOnClickListener(new ShowQRCodeStep1UI.3(this));
      return;
      if (this.nRA == 4) {
        localTextView.setText(getString(a.i.self_qrcode_show_all, new Object[] { getString(a.i.self_qrcode_show_all_facebook) }));
      } else if (this.nRA == 2) {
        localTextView.setText(getString(a.i.self_qrcode_show_all, new Object[] { getString(a.i.self_qrcode_show_all_qzone) }));
      } else {
        localTextView.setText(getString(a.i.self_qrcode_show_all, new Object[] { getString(a.i.self_qrcode_show_all_qqwb) }));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    g.Dk().a(168, this);
  }
  
  public void onDestroy()
  {
    g.Dk().b(168, this);
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ShowQRCodeStep1UI", "onSceneEnd: errType = %d errCode = %d errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if (b.eUS.b(this.mController.uMN, paramInt1, paramInt2, paramString)) {
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this, getString(a.i.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      return;
    }
    this.nRG = ((a)paramm).exe;
    this.nRF.setImageBitmap(c.bu(this.nRG));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI
 * JD-Core Version:    0.7.0.1
 */