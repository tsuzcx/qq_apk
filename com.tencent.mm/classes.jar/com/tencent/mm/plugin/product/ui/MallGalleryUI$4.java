package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import java.util.LinkedList;

final class MallGalleryUI$4
  implements MenuItem.OnMenuItemClickListener
{
  MallGalleryUI$4(MallGalleryUI paramMallGalleryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(66946);
    if (c.aZU("favorite")) {}
    for (paramMenuItem = this.BaD.getResources().getStringArray(2130903066);; paramMenuItem = this.BaD.getResources().getStringArray(2130903067))
    {
      h.b(this.BaD.getContext(), null, paramMenuItem, null, new h.d()
      {
        public final void oj(int paramAnonymousInt)
        {
          AppMethodBeat.i(66945);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(66945);
            return;
            MallGalleryUI localMallGalleryUI = MallGalleryUI.4.this.BaD;
            Object localObject1 = new Intent();
            ((Intent)localObject1).putExtra("Retr_Msg_content", "");
            ((Intent)localObject1).putExtra("Retr_Msg_Type", 0);
            if (!Util.isNullOrNil(localMallGalleryUI.eDy()))
            {
              ((Intent)localObject1).putExtra("Retr_File_Name", localMallGalleryUI.eDy());
              ((Intent)localObject1).putExtra("Retr_go_to_chattingUI", false);
              ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
              c.f(localMallGalleryUI, ".ui.transmit.MsgRetransmitUI", (Intent)localObject1);
              AppMethodBeat.o(66945);
              return;
            }
            Log.e("MicroMsg.MallGalleryUI", "url is null or nil");
            AppMethodBeat.o(66945);
            return;
            localMallGalleryUI = MallGalleryUI.4.this.BaD;
            localObject1 = localMallGalleryUI.eDy();
            if (!Util.isNullOrNil((String)localObject1))
            {
              Log.d("MicroMsg.MallGalleryUI", "can save. img path: %s", new Object[] { localObject1 });
              s.l((String)localObject1, localMallGalleryUI);
              AppMethodBeat.o(66945);
              return;
            }
            Log.w("MicroMsg.MallGalleryUI", "save error.");
            AppMethodBeat.o(66945);
            return;
            localMallGalleryUI = MallGalleryUI.4.this.BaD;
            localObject1 = localMallGalleryUI.eDy();
            if (!Util.isNullOrNil((String)localObject1))
            {
              Log.d("MicroMsg.MallGalleryUI", "file path valid");
              cz localcz = new cz();
              if (Util.isNullOrNil((String)localObject1))
              {
                Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                localcz.dFZ.dGe = 2131759209;
              }
              for (;;)
              {
                localcz.dFZ.dGf = 4;
                localcz.dFZ.activity = localMallGalleryUI;
                EventCenter.instance.publish(localcz);
                AppMethodBeat.o(66945);
                return;
                Log.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { localObject1, Integer.valueOf(9) });
                anb localanb = new anb();
                anh localanh = new anh();
                aml localaml = new aml();
                localaml.ajd(2);
                localaml.bgt((String)localObject1);
                localaml.bgs(g.getMessageDigest((localaml.toString() + 2 + System.currentTimeMillis()).getBytes()));
                Object localObject2 = new hb();
                ((hb)localObject2).dLm.type = 27;
                ((hb)localObject2).dLm.dLo = localaml;
                EventCenter.instance.publish((IEvent)localObject2);
                localObject2 = ((hb)localObject2).dLn.thumbPath;
                BitmapUtil.createThumbNail((String)localObject1, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject2, true);
                localaml.bgu((String)localObject2);
                localanh.bhf(z.aTY());
                localanh.bhg(z.aTY());
                localanh.ajm(9);
                localanh.MA(Util.nowMilliSecond());
                localanb.a(localanh);
                localanb.ppH.add(localaml);
                localcz.dFZ.title = localaml.title;
                localcz.dFZ.dGb = localanb;
                localcz.dFZ.type = 2;
              }
            }
            Log.w("MicroMsg.MallGalleryUI", "file path invalid");
          }
        }
      });
      AppMethodBeat.o(66946);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallGalleryUI.4
 * JD-Core Version:    0.7.0.1
 */