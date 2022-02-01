package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.b.g;
import com.tencent.mm.br.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k.d;
import java.util.LinkedList;

final class MallGalleryUI$4$1
  implements k.d
{
  MallGalleryUI$4$1(MallGalleryUI.4 param4) {}
  
  public final void qz(int paramInt)
  {
    AppMethodBeat.i(66945);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(66945);
      return;
      MallGalleryUI localMallGalleryUI = this.MSe.MSd;
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Retr_Msg_content", "");
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 0);
      if (!Util.isNullOrNil(localMallGalleryUI.gAv()))
      {
        ((Intent)localObject1).putExtra("Retr_File_Name", localMallGalleryUI.gAv());
        ((Intent)localObject1).putExtra("Retr_go_to_chattingUI", false);
        ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
        c.g(localMallGalleryUI, ".ui.transmit.MsgRetransmitUI", (Intent)localObject1);
        AppMethodBeat.o(66945);
        return;
      }
      Log.e("MicroMsg.MallGalleryUI", "url is null or nil");
      AppMethodBeat.o(66945);
      return;
      localMallGalleryUI = this.MSe.MSd;
      localObject1 = localMallGalleryUI.gAv();
      if (!Util.isNullOrNil((String)localObject1))
      {
        Log.d("MicroMsg.MallGalleryUI", "can save. img path: %s", new Object[] { localObject1 });
        t.o((String)localObject1, localMallGalleryUI);
        AppMethodBeat.o(66945);
        return;
      }
      Log.w("MicroMsg.MallGalleryUI", "save error.");
      AppMethodBeat.o(66945);
      return;
      localMallGalleryUI = this.MSe.MSd;
      localObject1 = localMallGalleryUI.gAv();
      if (!Util.isNullOrNil((String)localObject1))
      {
        Log.d("MicroMsg.MallGalleryUI", "file path valid");
        dn localdn = new dn();
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
          localdn.hDr.hDx = a.i.favorite_fail_argument_error;
        }
        for (;;)
        {
          localdn.hDr.hDy = 4;
          localdn.hDr.activity = localMallGalleryUI;
          localdn.publish();
          AppMethodBeat.o(66945);
          return;
          Log.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { localObject1, Integer.valueOf(9) });
          arv localarv = new arv();
          asb localasb = new asb();
          arf localarf = new arf();
          localarf.axy(2);
          localarf.bsC((String)localObject1);
          localarf.bsB(g.getMessageDigest((localarf.toString() + 2 + System.currentTimeMillis()).getBytes()));
          Object localObject2 = new ht();
          ((ht)localObject2).hIR.type = 27;
          ((ht)localObject2).hIR.hIT = localarf;
          ((ht)localObject2).publish();
          localObject2 = ((ht)localObject2).hIS.thumbPath;
          BitmapUtil.createThumbNail((String)localObject1, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject2, true);
          localarf.bsD((String)localObject2);
          localasb.bto(z.bAM());
          localasb.btp(z.bAM());
          localasb.axH(9);
          localasb.yu(Util.nowMilliSecond());
          localarv.a(localasb);
          localarv.vEn.add(localarf);
          localdn.hDr.title = localarf.title;
          localdn.hDr.hDt = localarv;
          localdn.hDr.type = 2;
        }
      }
      Log.w("MicroMsg.MallGalleryUI", "file path invalid");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallGalleryUI.4.1
 * JD-Core Version:    0.7.0.1
 */