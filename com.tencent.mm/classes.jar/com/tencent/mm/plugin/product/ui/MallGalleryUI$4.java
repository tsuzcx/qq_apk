package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.util.LinkedList;

final class MallGalleryUI$4
  implements MenuItem.OnMenuItemClickListener
{
  MallGalleryUI$4(MallGalleryUI paramMallGalleryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(66946);
    if (d.aCT("favorite")) {}
    for (paramMenuItem = this.vGh.getResources().getStringArray(2130903065);; paramMenuItem = this.vGh.getResources().getStringArray(2130903066))
    {
      h.b(this.vGh.getContext(), null, paramMenuItem, null, new h.c()
      {
        public final void kG(int paramAnonymousInt)
        {
          AppMethodBeat.i(66945);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(66945);
            return;
            MallGalleryUI localMallGalleryUI = MallGalleryUI.4.this.vGh;
            Object localObject1 = new Intent();
            ((Intent)localObject1).putExtra("Retr_Msg_content", "");
            ((Intent)localObject1).putExtra("Retr_Msg_Type", 0);
            if (!bs.isNullOrNil(localMallGalleryUI.dpn()))
            {
              ((Intent)localObject1).putExtra("Retr_File_Name", localMallGalleryUI.dpn());
              ((Intent)localObject1).putExtra("Retr_go_to_chattingUI", false);
              ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
              d.e(localMallGalleryUI, ".ui.transmit.MsgRetransmitUI", (Intent)localObject1);
              AppMethodBeat.o(66945);
              return;
            }
            ac.e("MicroMsg.MallGalleryUI", "url is null or nil");
            AppMethodBeat.o(66945);
            return;
            localMallGalleryUI = MallGalleryUI.4.this.vGh;
            localObject1 = localMallGalleryUI.dpn();
            if (!bs.isNullOrNil((String)localObject1))
            {
              ac.d("MicroMsg.MallGalleryUI", "can save. img path: %s", new Object[] { localObject1 });
              q.j((String)localObject1, localMallGalleryUI);
              AppMethodBeat.o(66945);
              return;
            }
            ac.w("MicroMsg.MallGalleryUI", "save error.");
            AppMethodBeat.o(66945);
            return;
            localMallGalleryUI = MallGalleryUI.4.this.vGh;
            localObject1 = localMallGalleryUI.dpn();
            if (!bs.isNullOrNil((String)localObject1))
            {
              ac.d("MicroMsg.MallGalleryUI", "file path valid");
              cs localcs = new cs();
              if (bs.isNullOrNil((String)localObject1))
              {
                ac.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                localcs.dck.dcp = 2131758885;
              }
              for (;;)
              {
                localcs.dck.dcq = 4;
                localcs.dck.activity = localMallGalleryUI;
                a.GpY.l(localcs);
                AppMethodBeat.o(66945);
                return;
                ac.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { localObject1, Integer.valueOf(9) });
                ahn localahn = new ahn();
                aht localaht = new aht();
                agx localagx = new agx();
                localagx.XM(2);
                localagx.aIQ((String)localObject1);
                localagx.aIP(g.getMessageDigest((localagx.toString() + 2 + System.currentTimeMillis()).getBytes()));
                Object localObject2 = new gt();
                ((gt)localObject2).dhx.type = 27;
                ((gt)localObject2).dhx.dhz = localagx;
                a.GpY.l((b)localObject2);
                localObject2 = ((gt)localObject2).dhy.thumbPath;
                f.c((String)localObject1, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject2);
                localagx.aIR((String)localObject2);
                localaht.aJC(u.axw());
                localaht.aJD(u.axw());
                localaht.XV(9);
                localaht.zY(bs.eWj());
                localahn.a(localaht);
                localahn.nxC.add(localagx);
                localcs.dck.title = localagx.title;
                localcs.dck.dcm = localahn;
                localcs.dck.type = 2;
              }
            }
            ac.w("MicroMsg.MallGalleryUI", "file path invalid");
          }
        }
      });
      AppMethodBeat.o(66946);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallGalleryUI.4
 * JD-Core Version:    0.7.0.1
 */