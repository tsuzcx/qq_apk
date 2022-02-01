package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.br;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.a.a;
import com.tencent.mm.ui.chatting.a.b;

final class r$2
  implements View.OnClickListener
{
  r$2(r paramr) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(36322);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    z localz;
    fjp localfjp;
    Intent localIntent;
    int i;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof cc)))
    {
      cc localcc = (cc)paramView.getTag();
      com.tencent.mm.ui.chatting.a.a(a.a.aedm, localcc);
      localz = com.tencent.mm.modelvideo.ab.Qo(localcc.field_imgPath);
      localfjp = localz.pbk;
      if ((localfjp == null) || (com.tencent.mm.platformtools.ab.isNullOrNil(localfjp.nTu))) {
        break label507;
      }
      com.tencent.mm.modelvideo.v.bOh();
      paramView = aa.PY(localcc.field_imgPath);
      localIntent = new Intent();
      localIntent.putExtra("KFromTimeLine", false);
      localIntent.putExtra("KStremVideoUrl", localfjp.nTu);
      localIntent.putExtra("KThumUrl", localfjp.nTz);
      localIntent.putExtra("KThumbPath", paramView);
      localIntent.putExtra("KMediaId", "fakeid_" + localcc.field_msgId);
      localIntent.putExtra("KMediaVideoTime", localfjp.ZBc);
      localIntent.putExtra("KMediaTitle", localfjp.nTw);
      localIntent.putExtra("StreamWording", localfjp.nTx);
      localIntent.putExtra("StremWebUrl", localfjp.nTy);
      localObject = localcc.field_talker;
      boolean bool = au.bwE((String)localObject);
      if (!bool) {
        break label464;
      }
      paramView = br.JJ(localcc.field_content);
      localIntent.putExtra("KSta_StremVideoAduxInfo", localfjp.nTA);
      localIntent.putExtra("KSta_StremVideoPublishId", localfjp.nTB);
      localIntent.putExtra("KSta_SourceType", 1);
      if (!bool) {
        break label470;
      }
      i = a.b.aedv.value;
      label322:
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", paramView);
      localIntent.putExtra("KSta_ChatName", (String)localObject);
      localIntent.putExtra("KSta_MsgId", localcc.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", localz.iah);
      if (bool) {
        localIntent.putExtra("KSta_ChatroomMembercount", com.tencent.mm.model.v.getMembersCountByChatRoomName((String)localObject));
      }
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHP, 0) <= 0) {
        break label480;
      }
      com.tencent.mm.br.c.b(this.aeFK.aeAZ.aeAB.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      Log.i("MicroMsg.ImageGalleryViewHolder", "use new stream video play UI");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36322);
      return;
      label464:
      paramView = (View)localObject;
      break;
      label470:
      i = a.b.aedu.value;
      break label322;
      label480:
      com.tencent.mm.br.c.b(this.aeFK.aeAZ.aeAB.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
      continue;
      label507:
      if ((localfjp != null) && (!Util.isNullOrNil(localfjp.nTx)) && (!Util.isNullOrNil(localfjp.nTy)))
      {
        Log.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + localfjp.nTy);
        paramView = new Intent();
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_snsad_statextstr", localz.iah);
        paramView.putExtra("jsapiargs", (Bundle)localObject);
        paramView.putExtra("rawUrl", localfjp.nTy);
        paramView.putExtra("useJs", true);
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36321);
            com.tencent.mm.br.c.b(r.2.this.aeFK.aeAZ.aeAB.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
            AppMethodBeat.o(36321);
          }
        });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.r.2
 * JD-Core Version:    0.7.0.1
 */