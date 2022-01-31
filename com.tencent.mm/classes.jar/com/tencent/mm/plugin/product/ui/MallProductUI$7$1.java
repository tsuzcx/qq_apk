package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.wallet_core.ui.e;

final class MallProductUI$7$1
  implements h.c
{
  MallProductUI$7$1(MallProductUI.7 param7) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return;
          localf = MallProductUI.e(this.mVi.mVg);
          localObject1 = localf.mTL.bsg();
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Retr_Msg_content", (String)localObject1);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
          if (!bk.bl(localf.mTL.mRP.bsj())) {
            ((Intent)localObject2).putExtra("Retr_Msg_thumb_path", localf.mTL.brX());
          }
          ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
          ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
          d.e(localf.fyk, ".ui.transmit.MsgRetransmitUI", (Intent)localObject2);
        } while (f.fzn != 4);
        h.nFQ.f(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0) });
        return;
        localf = MallProductUI.e(this.mVi.mVg);
        Object localObject2 = localf.mTL.mRP;
        Object localObject1 = new Intent();
        ((Intent)localObject1).putExtra("KContentObjDesc", localf.mTL.bsh());
        ((Intent)localObject1).putExtra("Ksnsupload_title", ((m)localObject2).mSu.name);
        ((Intent)localObject1).putExtra("Ksnsupload_link", localf.mTL.brY());
        ((Intent)localObject1).putExtra("Ksnsupload_imgurl", localf.mTL.mRP.bsj());
        if (!bk.bl(localf.mTL.mRP.bsj())) {
          ((Intent)localObject1).putExtra("KsnsUpload_imgPath", localf.mTL.brX());
        }
        ((Intent)localObject1).putExtra("Ksnsupload_type", 6);
        ((Intent)localObject1).putExtra("KUploadProduct_UserData", localf.mTL.a((m)localObject2));
        ((Intent)localObject1).putExtra("KUploadProduct_subType", ((m)localObject2).mSr);
        localObject2 = u.ij("scan_product");
        u.Hc().v((String)localObject2, true).h("prePublishId", "scan_product");
        ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
        d.b(localf.fyk, "sns", ".ui.SnsUploadUI", (Intent)localObject1);
      } while (f.fzn != 4);
      h.nFQ.f(10651, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0) });
      return;
    case 2: 
      MallProductUI.e(this.mVi.mVg).bsn();
      return;
    }
    f localf = MallProductUI.e(this.mVi.mVg);
    e.aa(localf.fyk, localf.mTL.brW());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.7.1
 * JD-Core Version:    0.7.0.1
 */