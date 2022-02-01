package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.a.a;
import com.tencent.mm.ui.chatting.a.b;

final class k$2
  implements View.OnClickListener
{
  k$2(k paramk) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(36322);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    s locals;
    eeq localeeq;
    Intent localIntent;
    int i;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof ca)))
    {
      ca localca = (ca)paramView.getTag();
      com.tencent.mm.ui.chatting.a.a(a.a.PcK, localca);
      locals = u.QN(localca.field_imgPath);
      localeeq = locals.jsw;
      if ((localeeq == null) || (af.isNullOrNil(localeeq.iyZ))) {
        break label507;
      }
      o.bhj();
      paramView = t.Qx(localca.field_imgPath);
      localIntent = new Intent();
      localIntent.putExtra("KFromTimeLine", false);
      localIntent.putExtra("KStremVideoUrl", localeeq.iyZ);
      localIntent.putExtra("KThumUrl", localeeq.ize);
      localIntent.putExtra("KThumbPath", paramView);
      localIntent.putExtra("KMediaId", "fakeid_" + localca.field_msgId);
      localIntent.putExtra("KMediaVideoTime", localeeq.LxJ);
      localIntent.putExtra("KMediaTitle", localeeq.izb);
      localIntent.putExtra("StreamWording", localeeq.izc);
      localIntent.putExtra("StremWebUrl", localeeq.izd);
      localObject = localca.field_talker;
      boolean bool = ab.Eq((String)localObject);
      if (!bool) {
        break label464;
      }
      paramView = bp.Ks(localca.field_content);
      localIntent.putExtra("KSta_StremVideoAduxInfo", localeeq.izf);
      localIntent.putExtra("KSta_StremVideoPublishId", localeeq.izg);
      localIntent.putExtra("KSta_SourceType", 1);
      if (!bool) {
        break label470;
      }
      i = a.b.PcT.value;
      label322:
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", paramView);
      localIntent.putExtra("KSta_ChatName", (String)localObject);
      localIntent.putExtra("KSta_MsgId", localca.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", locals.ean);
      if (bool) {
        localIntent.putExtra("KSta_ChatroomMembercount", v.Ie((String)localObject));
      }
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOS, 0) <= 0) {
        break label480;
      }
      c.b(this.PBh.PwU.Pwv.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
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
      i = a.b.PcS.value;
      break label322;
      label480:
      c.b(this.PBh.PwU.Pwv.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
      continue;
      label507:
      if ((localeeq != null) && (!Util.isNullOrNil(localeeq.izc)) && (!Util.isNullOrNil(localeeq.izd)))
      {
        Log.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + localeeq.izd);
        paramView = new Intent();
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_snsad_statextstr", locals.ean);
        paramView.putExtra("jsapiargs", (Bundle)localObject);
        paramView.putExtra("rawUrl", localeeq.izd);
        paramView.putExtra("useJs", true);
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36321);
            c.b(k.2.this.PBh.PwU.Pwv.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
            AppMethodBeat.o(36321);
          }
        });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.2
 * JD-Core Version:    0.7.0.1
 */