package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.g;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h.c;
import java.util.LinkedList;

final class MallGalleryUI$4$1
  implements h.c
{
  MallGalleryUI$4$1(MallGalleryUI.4 param4) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localMallGalleryUI = this.mTz.mTy;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Retr_Msg_content", "");
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 0);
      if (!bk.bl(localMallGalleryUI.bsk()))
      {
        ((Intent)localObject1).putExtra("Retr_File_Name", localMallGalleryUI.bsk());
        ((Intent)localObject1).putExtra("Retr_go_to_chattingUI", false);
        ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
        d.e(localMallGalleryUI, ".ui.transmit.MsgRetransmitUI", (Intent)localObject1);
        return;
      }
      y.e("MicroMsg.MallGalleryUI", "url is null or nil");
      return;
    case 1: 
      localMallGalleryUI = this.mTz.mTy;
      localObject1 = localMallGalleryUI.bsk();
      if (!bk.bl((String)localObject1))
      {
        y.d("MicroMsg.MallGalleryUI", "can save. img path: %s", new Object[] { localObject1 });
        l.i((String)localObject1, localMallGalleryUI);
        return;
      }
      y.w("MicroMsg.MallGalleryUI", "save error.");
      return;
    }
    MallGalleryUI localMallGalleryUI = this.mTz.mTy;
    Object localObject1 = localMallGalleryUI.bsk();
    if (!bk.bl((String)localObject1))
    {
      y.d("MicroMsg.MallGalleryUI", "file path valid");
      cj localcj = new cj();
      if (bk.bl((String)localObject1))
      {
        y.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
        localcj.bIw.bIC = a.i.favorite_fail_argument_error;
      }
      for (;;)
      {
        localcj.bIw.bID = 4;
        localcj.bIw.activity = localMallGalleryUI;
        a.udP.m(localcj);
        return;
        y.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { localObject1, Integer.valueOf(9) });
        yj localyj = new yj();
        yp localyp = new yp();
        xv localxv = new xv();
        localxv.EH(2);
        localxv.XI((String)localObject1);
        localxv.XH(g.o((localxv.toString() + 2 + System.currentTimeMillis()).getBytes()));
        Object localObject2 = new gf();
        ((gf)localObject2).bNF.type = 27;
        ((gf)localObject2).bNF.bNH = localxv;
        a.udP.m((b)localObject2);
        localObject2 = ((gf)localObject2).bNG.thumbPath;
        c.c((String)localObject1, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject2);
        localxv.XJ((String)localObject2);
        localyp.Yq(q.Gj());
        localyp.Yr(q.Gj());
        localyp.EQ(9);
        localyp.hl(bk.UY());
        localyj.a(localyp);
        localyj.sXc.add(localxv);
        localcj.bIw.title = localxv.title;
        localcj.bIw.bIy = localyj;
        localcj.bIw.type = 2;
      }
    }
    y.w("MicroMsg.MallGalleryUI", "file path invalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallGalleryUI.4.1
 * JD-Core Version:    0.7.0.1
 */