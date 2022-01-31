package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ce;
import com.tencent.mm.h.a.ce.a;
import com.tencent.mm.h.a.ce.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.scanner.a.j;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.s;

final class ProductUI$6
  implements h.d
{
  ProductUI$6(ProductUI paramProductUI) {}
  
  public final void bF(int paramInt1, int paramInt2)
  {
    if (ProductUI.a(this.nKF) == null) {
      return;
    }
    Object localObject2;
    switch (paramInt2)
    {
    default: 
      return;
    case -1: 
      com.tencent.mm.ui.base.h.a(this.nKF.mController.uMN, this.nKF.mController.uMN.getString(R.l.app_delete_tips), null, null, this.nKF.mController.uMN.getString(R.l.app_delete), new h.d()
      {
        public final void bF(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          switch (paramAnonymousInt2)
          {
          default: 
            y.d("MicroMsg.scanner.ProductUI", "do del cancel");
          }
          ce localce;
          do
          {
            return;
            localce = new ce();
            localce.bIp.bIr = ProductUI.6.this.nKF.getIntent().getLongExtra("key_favorite_local_id", -1L);
            a.udP.m(localce);
            y.d("MicroMsg.scanner.ProductUI", "do del fav product, local id %d, result %B", new Object[] { Long.valueOf(localce.bIp.bIr), Boolean.valueOf(localce.bIq.bIe) });
          } while (!localce.bIq.bIe);
          ProductUI.6.this.nKF.finish();
        }
      });
      return;
    case 0: 
      com.tencent.mm.plugin.report.service.h.nFQ.f(11446, new Object[] { ProductUI.a(this.nKF).field_productid, Integer.valueOf(2) });
      if (ProductUI.c(this.nKF) == 3)
      {
        com.tencent.mm.plugin.fav.a.h.f(this.nKF.getIntent().getLongExtra("key_favorite_local_id", -1L), 1, 0);
        com.tencent.mm.plugin.report.service.h.nFQ.f(10651, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0) });
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("KContentObjDesc", ProductUI.a(this.nKF).field_subtitle);
      ((Intent)localObject1).putExtra("Ksnsupload_title", ProductUI.a(this.nKF).field_title);
      ((Intent)localObject1).putExtra("Ksnsupload_link", ProductUI.a(this.nKF).field_shareurl);
      ((Intent)localObject1).putExtra("Ksnsupload_appname", o.I(this.nKF, ProductUI.a(this.nKF).field_type));
      ((Intent)localObject1).putExtra("Ksnsupload_appid", j.wN(ProductUI.a(this.nKF).field_functionType));
      ((Intent)localObject1).putExtra("Ksnsupload_imgurl", ProductUI.a(this.nKF).field_thumburl);
      y.i("MicroMsg.scanner.ProductUI", "product.field_thumburl : " + ProductUI.a(this.nKF).field_thumburl);
      if (ProductUI.m(this.nKF) != null) {
        ((Intent)localObject1).putExtra("KsnsUpload_imgPath", ProductUI.m(this.nKF).UO());
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("Ksnsupload_type", 3);
        ((Intent)localObject1).putExtra("KUploadProduct_UserData", o.c(ProductUI.a(this.nKF)));
        ((Intent)localObject1).putExtra("KUploadProduct_subType", ProductUI.a(this.nKF).field_type);
        localObject2 = u.ij("scan_product");
        u.Hc().v((String)localObject2, true).h("prePublishId", "scan_product");
        ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
        d.b(this.nKF, "sns", ".ui.SnsUploadUI", (Intent)localObject1);
        return;
        y.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
      }
    case 1: 
      com.tencent.mm.plugin.report.service.h.nFQ.f(11446, new Object[] { ProductUI.a(this.nKF).field_productid, Integer.valueOf(1) });
      localObject1 = j.a(this.nKF.mController.uMN, ProductUI.a(this.nKF));
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Retr_Msg_content", (String)localObject1);
      ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
      if (ProductUI.m(this.nKF) != null) {
        ((Intent)localObject2).putExtra("Retr_Msg_thumb_path", ProductUI.m(this.nKF).UO());
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
        ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
        com.tencent.mm.plugin.scanner.b.eUR.l((Intent)localObject2, this.nKF);
        if (ProductUI.c(this.nKF) != 3) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(10651, new Object[] { Integer.valueOf(10), Integer.valueOf(1), Integer.valueOf(0) });
        return;
        y.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
      }
    case 2: 
      com.tencent.mm.plugin.report.service.h.nFQ.f(11446, new Object[] { ProductUI.a(this.nKF).field_productid, Integer.valueOf(3) });
      ProductUI.p(this.nKF);
      return;
    case 3: 
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_fav_scene", 2);
      ((Intent)localObject1).putExtra("key_fav_item_id", this.nKF.getIntent().getLongExtra("key_favorite_local_id", -1L));
      com.tencent.mm.plugin.fav.a.b.a(this.nKF.mController.uMN, ".ui.FavTagEditUI", (Intent)localObject1);
      return;
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("rawUrl", ProductUI.a(this.nKF).field_exposeurl);
    d.b(this.nKF.mController.uMN, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.6
 * JD-Core Version:    0.7.0.1
 */