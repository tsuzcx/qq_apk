package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.wallet_core.ui.e;

final class MallProductUI$7$1
  implements h.c
{
  MallProductUI$7$1(MallProductUI.7 param7) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(44163);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(44163);
      return;
      f localf = MallProductUI.e(this.pxn.pxl);
      Object localObject1 = localf.pvR.cbm();
      Object localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Retr_Msg_content", (String)localObject1);
      ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
      if (!bo.isNullOrNil(localf.pvR.ptU.cbp())) {
        ((Intent)localObject2).putExtra("Retr_Msg_thumb_path", localf.pvR.cbd());
      }
      ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
      ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
      ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
      d.f(localf.gQx, ".ui.transmit.MsgRetransmitUI", (Intent)localObject2);
      if (f.mScene == 4) {
        h.qsU.e(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0) });
      }
      AppMethodBeat.o(44163);
      return;
      localf = MallProductUI.e(this.pxn.pxl);
      localObject2 = localf.pvR.ptU;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("KContentObjDesc", localf.pvR.cbn());
      ((Intent)localObject1).putExtra("Ksnsupload_title", ((m)localObject2).puA.name);
      ((Intent)localObject1).putExtra("Ksnsupload_link", localf.pvR.cbe());
      ((Intent)localObject1).putExtra("Ksnsupload_imgurl", localf.pvR.ptU.cbp());
      if (!bo.isNullOrNil(localf.pvR.ptU.cbp())) {
        ((Intent)localObject1).putExtra("KsnsUpload_imgPath", localf.pvR.cbd());
      }
      ((Intent)localObject1).putExtra("Ksnsupload_type", 6);
      ((Intent)localObject1).putExtra("KUploadProduct_UserData", localf.pvR.a((m)localObject2));
      ((Intent)localObject1).putExtra("KUploadProduct_subType", ((m)localObject2).pux);
      localObject2 = v.oQ("scan_product");
      v.aae().z((String)localObject2, true).i("prePublishId", "scan_product");
      ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
      d.b(localf.gQx, "sns", ".ui.SnsUploadUI", (Intent)localObject1);
      if (f.mScene == 4) {
        h.qsU.e(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0) });
      }
      AppMethodBeat.o(44163);
      return;
      MallProductUI.e(this.pxn.pxl).cbt();
      AppMethodBeat.o(44163);
      return;
      localf = MallProductUI.e(this.pxn.pxl);
      e.ad(localf.gQx, localf.pvR.cbc());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.7.1
 * JD-Core Version:    0.7.0.1
 */