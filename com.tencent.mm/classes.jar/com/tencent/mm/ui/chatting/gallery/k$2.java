package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.r;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    s locals;
    dld localdld;
    Intent localIntent;
    int i;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof bv)))
    {
      bv localbv = (bv)paramView.getTag();
      com.tencent.mm.ui.chatting.a.a(a.a.JRG, localbv);
      locals = u.Ia(localbv.field_imgPath);
      localdld = locals.ixh;
      if ((localdld == null) || (af.isNullOrNil(localdld.hET))) {
        break label507;
      }
      o.aNh();
      paramView = t.HK(localbv.field_imgPath);
      localIntent = new Intent();
      localIntent.putExtra("KFromTimeLine", false);
      localIntent.putExtra("KStremVideoUrl", localdld.hET);
      localIntent.putExtra("KThumUrl", localdld.hEY);
      localIntent.putExtra("KThumbPath", paramView);
      localIntent.putExtra("KMediaId", "fakeid_" + localbv.field_msgId);
      localIntent.putExtra("KMediaVideoTime", localdld.GBN);
      localIntent.putExtra("KMediaTitle", localdld.hEV);
      localIntent.putExtra("StreamWording", localdld.hEW);
      localIntent.putExtra("StremWebUrl", localdld.hEX);
      localObject = localbv.field_talker;
      boolean bool = x.wb((String)localObject);
      if (!bool) {
        break label464;
      }
      paramView = bl.BM(localbv.field_content);
      localIntent.putExtra("KSta_StremVideoAduxInfo", localdld.hEZ);
      localIntent.putExtra("KSta_StremVideoPublishId", localdld.hFa);
      localIntent.putExtra("KSta_SourceType", 1);
      if (!bool) {
        break label470;
      }
      i = a.b.JRP.value;
      label322:
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", paramView);
      localIntent.putExtra("KSta_ChatName", (String)localObject);
      localIntent.putExtra("KSta_MsgId", localbv.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", locals.dIA);
      if (bool) {
        localIntent.putExtra("KSta_ChatroomMembercount", r.zC((String)localObject));
      }
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxf, 0) <= 0) {
        break label480;
      }
      d.b(this.Kpe.KkX.Kkw.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      ae.i("MicroMsg.ImageGalleryViewHolder", "use new stream video play UI");
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
      i = a.b.JRO.value;
      break label322;
      label480:
      d.b(this.Kpe.KkX.Kkw.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
      continue;
      label507:
      if ((localdld != null) && (!bu.isNullOrNil(localdld.hEW)) && (!bu.isNullOrNil(localdld.hEX)))
      {
        ae.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + localdld.hEX);
        paramView = new Intent();
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_snsad_statextstr", locals.dIA);
        paramView.putExtra("jsapiargs", (Bundle)localObject);
        paramView.putExtra("rawUrl", localdld.hEX);
        paramView.putExtra("useJs", true);
        new aq(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36321);
            d.b(k.2.this.Kpe.KkX.Kkw.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
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