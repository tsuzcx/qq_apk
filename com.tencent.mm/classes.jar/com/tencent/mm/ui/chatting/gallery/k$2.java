package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.a.a;
import com.tencent.mm.ui.chatting.a.b;

final class k$2
  implements View.OnClickListener
{
  k$2(k paramk) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(36322);
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof bl)))
    {
      bl localbl = (bl)paramView.getTag();
      a.a(a.a.Gjk, localbl);
      s locals = u.Ae(localbl.field_imgPath);
      czj localczj = locals.hAq;
      Object localObject;
      if ((localczj != null) && (!ae.isNullOrNil(localczj.gJv)))
      {
        o.aCI();
        paramView = t.zR(localbl.field_imgPath);
        Intent localIntent = new Intent();
        localIntent.putExtra("KFromTimeLine", false);
        localIntent.putExtra("KStremVideoUrl", localczj.gJv);
        localIntent.putExtra("KThumUrl", localczj.gJA);
        localIntent.putExtra("KThumbPath", paramView);
        localIntent.putExtra("KMediaId", "fakeid_" + localbl.field_msgId);
        localIntent.putExtra("KMediaVideoTime", localczj.Dim);
        localIntent.putExtra("KMediaTitle", localczj.gJx);
        localIntent.putExtra("StreamWording", localczj.gJy);
        localIntent.putExtra("StremWebUrl", localczj.gJz);
        localObject = localbl.field_talker;
        boolean bool = w.pF((String)localObject);
        if (bool)
        {
          paramView = bi.uf(localbl.field_content);
          localIntent.putExtra("KSta_StremVideoAduxInfo", localczj.gJB);
          localIntent.putExtra("KSta_StremVideoPublishId", localczj.gJC);
          localIntent.putExtra("KSta_SourceType", 1);
          if (!bool) {
            break label426;
          }
        }
        label426:
        for (int i = a.b.Gjt.value;; i = a.b.Gjs.value)
        {
          localIntent.putExtra("KSta_Scene", i);
          localIntent.putExtra("KSta_FromUserName", paramView);
          localIntent.putExtra("KSta_ChatName", (String)localObject);
          localIntent.putExtra("KSta_MsgId", localbl.field_msgSvrId);
          localIntent.putExtra("KSta_SnsStatExtStr", locals.dxG);
          if (bool) {
            localIntent.putExtra("KSta_ChatroomMembercount", q.rY((String)localObject));
          }
          if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjp, 0) <= 0) {
            break label436;
          }
          d.b(this.GEg.GAA.GAa.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
          ad.i("MicroMsg.ImageGalleryViewHolder", "use new stream video play UI");
          AppMethodBeat.o(36322);
          return;
          paramView = (View)localObject;
          break;
        }
        label436:
        d.b(this.GEg.GAA.GAa.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
        AppMethodBeat.o(36322);
        return;
      }
      if ((localczj != null) && (!bt.isNullOrNil(localczj.gJy)) && (!bt.isNullOrNil(localczj.gJz)))
      {
        ad.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + localczj.gJz);
        paramView = new Intent();
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_snsad_statextstr", locals.dxG);
        paramView.putExtra("jsapiargs", (Bundle)localObject);
        paramView.putExtra("rawUrl", localczj.gJz);
        paramView.putExtra("useJs", true);
        new ap(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36321);
            d.b(k.2.this.GEg.GAA.GAa.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
            AppMethodBeat.o(36321);
          }
        });
      }
    }
    AppMethodBeat.o(36322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.2
 * JD-Core Version:    0.7.0.1
 */