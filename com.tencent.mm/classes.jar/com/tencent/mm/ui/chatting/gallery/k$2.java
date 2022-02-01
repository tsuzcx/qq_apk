package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    s locals;
    dki localdki;
    Intent localIntent;
    int i;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof bu)))
    {
      bu localbu = (bu)paramView.getTag();
      com.tencent.mm.ui.chatting.a.a(a.a.JwQ, localbu);
      locals = u.Hy(localbu.field_imgPath);
      localdki = locals.iun;
      if ((localdki == null) || (af.isNullOrNil(localdki.hCe))) {
        break label507;
      }
      o.aMJ();
      paramView = t.Hi(localbu.field_imgPath);
      localIntent = new Intent();
      localIntent.putExtra("KFromTimeLine", false);
      localIntent.putExtra("KStremVideoUrl", localdki.hCe);
      localIntent.putExtra("KThumUrl", localdki.hCj);
      localIntent.putExtra("KThumbPath", paramView);
      localIntent.putExtra("KMediaId", "fakeid_" + localbu.field_msgId);
      localIntent.putExtra("KMediaVideoTime", localdki.Gje);
      localIntent.putExtra("KMediaTitle", localdki.hCg);
      localIntent.putExtra("StreamWording", localdki.hCh);
      localIntent.putExtra("StremWebUrl", localdki.hCi);
      localObject = localbu.field_talker;
      boolean bool = w.vF((String)localObject);
      if (!bool) {
        break label464;
      }
      paramView = bj.Bk(localbu.field_content);
      localIntent.putExtra("KSta_StremVideoAduxInfo", localdki.hCk);
      localIntent.putExtra("KSta_StremVideoPublishId", localdki.hCl);
      localIntent.putExtra("KSta_SourceType", 1);
      if (!bool) {
        break label470;
      }
      i = a.b.JwZ.value;
      label322:
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", paramView);
      localIntent.putExtra("KSta_ChatName", (String)localObject);
      localIntent.putExtra("KSta_MsgId", localbu.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", locals.dHv);
      if (bool) {
        localIntent.putExtra("KSta_ChatroomMembercount", q.yS((String)localObject));
      }
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqx, 0) <= 0) {
        break label480;
      }
      d.b(this.JTE.JPM.JPk.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      ad.i("MicroMsg.ImageGalleryViewHolder", "use new stream video play UI");
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
      i = a.b.JwY.value;
      break label322;
      label480:
      d.b(this.JTE.JPM.JPk.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
      continue;
      label507:
      if ((localdki != null) && (!bt.isNullOrNil(localdki.hCh)) && (!bt.isNullOrNil(localdki.hCi)))
      {
        ad.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + localdki.hCi);
        paramView = new Intent();
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_snsad_statextstr", locals.dHv);
        paramView.putExtra("jsapiargs", (Bundle)localObject);
        paramView.putExtra("rawUrl", localdki.hCi);
        paramView.putExtra("useJs", true);
        new ap(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36321);
            d.b(k.2.this.JTE.JPM.JPk.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
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