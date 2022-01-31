package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h.c;
import java.util.LinkedList;

final class MallGalleryUI$4$1
  implements h.c
{
  MallGalleryUI$4$1(MallGalleryUI.4 param4) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(44038);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(44038);
      return;
      MallGalleryUI localMallGalleryUI = this.pvF.pvE;
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Retr_Msg_content", "");
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 0);
      if (!bo.isNullOrNil(localMallGalleryUI.cbq()))
      {
        ((Intent)localObject1).putExtra("Retr_File_Name", localMallGalleryUI.cbq());
        ((Intent)localObject1).putExtra("Retr_go_to_chattingUI", false);
        ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
        com.tencent.mm.bq.d.f(localMallGalleryUI, ".ui.transmit.MsgRetransmitUI", (Intent)localObject1);
        AppMethodBeat.o(44038);
        return;
      }
      ab.e("MicroMsg.MallGalleryUI", "url is null or nil");
      AppMethodBeat.o(44038);
      return;
      localMallGalleryUI = this.pvF.pvE;
      localObject1 = localMallGalleryUI.cbq();
      if (!bo.isNullOrNil((String)localObject1))
      {
        ab.d("MicroMsg.MallGalleryUI", "can save. img path: %s", new Object[] { localObject1 });
        n.k((String)localObject1, localMallGalleryUI);
        AppMethodBeat.o(44038);
        return;
      }
      ab.w("MicroMsg.MallGalleryUI", "save error.");
      AppMethodBeat.o(44038);
      return;
      localMallGalleryUI = this.pvF.pvE;
      localObject1 = localMallGalleryUI.cbq();
      if (!bo.isNullOrNil((String)localObject1))
      {
        ab.d("MicroMsg.MallGalleryUI", "file path valid");
        cm localcm = new cm();
        if (bo.isNullOrNil((String)localObject1))
        {
          ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
          localcm.cpR.cpX = 2131299713;
        }
        for (;;)
        {
          localcm.cpR.cpY = 4;
          localcm.cpR.activity = localMallGalleryUI;
          a.ymk.l(localcm);
          AppMethodBeat.o(44038);
          return;
          ab.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { localObject1, Integer.valueOf(9) });
          acq localacq = new acq();
          acw localacw = new acw();
          aca localaca = new aca();
          localaca.MI(2);
          localaca.anE((String)localObject1);
          localaca.anD(g.w((localaca.toString() + 2 + System.currentTimeMillis()).getBytes()));
          Object localObject2 = new gi();
          ((gi)localObject2).cuX.type = 27;
          ((gi)localObject2).cuX.cuZ = localaca;
          a.ymk.l((b)localObject2);
          localObject2 = ((gi)localObject2).cuY.thumbPath;
          com.tencent.mm.sdk.platformtools.d.c((String)localObject1, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject2);
          localaca.anF((String)localObject2);
          localacw.aon(r.Zn());
          localacw.aoo(r.Zn());
          localacw.MR(9);
          localacw.nI(bo.aoy());
          localacq.a(localacw);
          localacq.wVc.add(localaca);
          localcm.cpR.title = localaca.title;
          localcm.cpR.cpT = localacq;
          localcm.cpR.type = 2;
        }
      }
      ab.w("MicroMsg.MallGalleryUI", "file path invalid");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallGalleryUI.4.1
 * JD-Core Version:    0.7.0.1
 */