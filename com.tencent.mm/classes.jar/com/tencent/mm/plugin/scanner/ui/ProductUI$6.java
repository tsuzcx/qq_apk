package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.ch.a;
import com.tencent.mm.g.a.ch.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h.d;

final class ProductUI$6
  implements h.d
{
  ProductUI$6(ProductUI paramProductUI) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(81086);
    if (ProductUI.a(this.qyh) == null)
    {
      AppMethodBeat.o(81086);
      return;
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(81086);
      return;
      com.tencent.mm.ui.base.h.a(this.qyh.getContext(), this.qyh.getContext().getString(2131296902), null, null, this.qyh.getContext().getString(2131296901), new h.d()
      {
        public final void ca(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(81085);
          switch (paramAnonymousInt2)
          {
          default: 
            ab.d("MicroMsg.scanner.ProductUI", "do del cancel");
          }
          ch localch;
          do
          {
            AppMethodBeat.o(81085);
            return;
            localch = new ch();
            localch.cpK.cpM = ProductUI.6.this.qyh.getIntent().getLongExtra("key_favorite_local_id", -1L);
            a.ymk.l(localch);
            ab.d("MicroMsg.scanner.ProductUI", "do del fav product, local id %d, result %B", new Object[] { Long.valueOf(localch.cpK.cpM), Boolean.valueOf(localch.cpL.cpz) });
          } while (!localch.cpL.cpz);
          ProductUI.6.this.qyh.finish();
          AppMethodBeat.o(81085);
        }
      });
      AppMethodBeat.o(81086);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(11446, new Object[] { ProductUI.a(this.qyh).field_productid, Integer.valueOf(2) });
      if (ProductUI.c(this.qyh) == 3)
      {
        com.tencent.mm.plugin.fav.a.h.i(this.qyh.getIntent().getLongExtra("key_favorite_local_id", -1L), 1, 0);
        com.tencent.mm.plugin.report.service.h.qsU.e(10651, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0) });
      }
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("KContentObjDesc", ProductUI.a(this.qyh).field_subtitle);
      ((Intent)localObject1).putExtra("Ksnsupload_title", ProductUI.a(this.qyh).field_title);
      ((Intent)localObject1).putExtra("Ksnsupload_link", ProductUI.a(this.qyh).field_shareurl);
      ((Intent)localObject1).putExtra("Ksnsupload_appname", q.V(this.qyh, ProductUI.a(this.qyh).field_type));
      ((Intent)localObject1).putExtra("Ksnsupload_appid", k.CD(ProductUI.a(this.qyh).field_functionType));
      ((Intent)localObject1).putExtra("Ksnsupload_imgurl", ProductUI.a(this.qyh).field_thumburl);
      ab.i("MicroMsg.scanner.ProductUI", "product.field_thumburl : " + ProductUI.a(this.qyh).field_thumburl);
      if (ProductUI.o(this.qyh) != null) {
        ((Intent)localObject1).putExtra("KsnsUpload_imgPath", ProductUI.o(this.qyh).aon());
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("Ksnsupload_type", 3);
        ((Intent)localObject1).putExtra("KUploadProduct_UserData", q.c(ProductUI.a(this.qyh)));
        ((Intent)localObject1).putExtra("KUploadProduct_subType", ProductUI.a(this.qyh).field_type);
        localObject2 = v.oQ("scan_product");
        v.aae().z((String)localObject2, true).i("prePublishId", "scan_product");
        ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
        d.b(this.qyh, "sns", ".ui.SnsUploadUI", (Intent)localObject1);
        AppMethodBeat.o(81086);
        return;
        ab.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(11446, new Object[] { ProductUI.a(this.qyh).field_productid, Integer.valueOf(1) });
      localObject1 = k.a(this.qyh.getContext(), ProductUI.a(this.qyh));
      Object localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Retr_Msg_content", (String)localObject1);
      ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
      if (ProductUI.o(this.qyh) != null) {
        ((Intent)localObject2).putExtra("Retr_Msg_thumb_path", ProductUI.o(this.qyh).aon());
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
        ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
        c.gmO.k((Intent)localObject2, this.qyh);
        if (ProductUI.c(this.qyh) != 3) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.qsU.e(10651, new Object[] { Integer.valueOf(10), Integer.valueOf(1), Integer.valueOf(0) });
        AppMethodBeat.o(81086);
        return;
        ab.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(11446, new Object[] { ProductUI.a(this.qyh).field_productid, Integer.valueOf(3) });
      ProductUI.r(this.qyh);
      AppMethodBeat.o(81086);
      return;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_fav_scene", 2);
      ((Intent)localObject1).putExtra("key_fav_item_id", this.qyh.getIntent().getLongExtra("key_favorite_local_id", -1L));
      b.b(this.qyh.getContext(), ".ui.FavTagEditUI", (Intent)localObject1);
      AppMethodBeat.o(81086);
      return;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", ProductUI.a(this.qyh).field_exposeurl);
      d.b(this.qyh.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.6
 * JD-Core Version:    0.7.0.1
 */