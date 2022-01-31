package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

final class ShowQRCodeStep1UI$3
  implements View.OnClickListener
{
  ShowQRCodeStep1UI$3(ShowQRCodeStep1UI paramShowQRCodeStep1UI) {}
  
  public final void onClick(View paramView)
  {
    if (ShowQRCodeStep1UI.a(this.nRH) == 3)
    {
      paramView = com.tencent.mm.kernel.g.DO().Dj();
      Object localObject = q.Gj();
      int i = bk.g((Integer)com.tencent.mm.kernel.g.DP().Dz().get(66561, null));
      y.d("MicroMsg.ShowQRCodeStep1UI", "sessionKey[%s], userName[%s], style[%d]", new Object[] { bk.aac(bk.bG(paramView)), localObject, Integer.valueOf(i) });
      paramView = "http://weixin.qq.com/cgi-bin/rweibourl?sid=" + com.tencent.mm.a.g.o(paramView) + "&u=" + (String)localObject + "&qr=" + i + "&device=" + com.tencent.mm.protocal.d.dOM + "&version=" + com.tencent.mm.protocal.d.spa;
      y.d("MicroMsg.ShowQRCodeStep1UI", "[%s]", new Object[] { paramView });
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramView);
      ((Intent)localObject).putExtra("title", this.nRH.getString(a.i.self_qrcode_show_to_sina));
      com.tencent.mm.br.d.b(this.nRH, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      this.nRH.finish();
      return;
    }
    if (ShowQRCodeStep1UI.a(this.nRH) == 4)
    {
      if (q.GL())
      {
        paramView = new Intent(this.nRH, ShareToQQUI.class);
        paramView.putExtra("show_to", 4);
        this.nRH.startActivity(paramView);
      }
      for (;;)
      {
        this.nRH.finish();
        return;
        ShowQRCodeStep1UI.a(this.nRH, FacebookAuthUI.class);
      }
    }
    if (ShowQRCodeStep1UI.a(this.nRH) == 2)
    {
      paramView = new Intent(this.nRH, ShareToQQUI.class);
      paramView.putExtra("show_to", 2);
      this.nRH.startActivity(paramView);
      this.nRH.finish();
      return;
    }
    paramView = new Intent(this.nRH, ShareToQQUI.class);
    paramView.putExtra("show_to", 1);
    this.nRH.startActivity(paramView);
    this.nRH.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI.3
 * JD-Core Version:    0.7.0.1
 */