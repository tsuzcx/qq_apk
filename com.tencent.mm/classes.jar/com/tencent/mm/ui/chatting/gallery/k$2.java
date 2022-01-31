package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.a.b;

final class k$2
  implements View.OnClickListener
{
  k$2(k paramk) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(32383);
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof bi)))
    {
      bi localbi = (bi)paramView.getTag();
      com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.zuZ, localbi);
      s locals = u.vr(localbi.field_imgPath);
      cii localcii = locals.fXG;
      Object localObject;
      if ((localcii != null) && (!ah.isNullOrNil(localcii.fiO)))
      {
        o.alE();
        paramView = com.tencent.mm.modelvideo.t.vg(localbi.field_imgPath);
        Intent localIntent = new Intent();
        localIntent.putExtra("KFromTimeLine", false);
        localIntent.putExtra("KStremVideoUrl", localcii.fiO);
        localIntent.putExtra("KThumUrl", localcii.fiT);
        localIntent.putExtra("KThumbPath", paramView);
        localIntent.putExtra("KMediaId", "fakeid_" + localbi.field_msgId);
        localIntent.putExtra("KMediaVideoTime", localcii.wUJ);
        localIntent.putExtra("KMediaTitle", localcii.fiQ);
        localIntent.putExtra("StreamWording", localcii.fiR);
        localIntent.putExtra("StremWebUrl", localcii.fiS);
        localObject = localbi.field_talker;
        boolean bool = com.tencent.mm.model.t.lA((String)localObject);
        if (bool)
        {
          paramView = bf.pu(localbi.field_content);
          localIntent.putExtra("KSta_StremVideoAduxInfo", localcii.fiU);
          localIntent.putExtra("KSta_StremVideoPublishId", localcii.fiV);
          localIntent.putExtra("KSta_SourceType", 1);
          if (!bool) {
            break label428;
          }
        }
        label428:
        for (int i = a.b.zvi.value;; i = a.b.zvh.value)
        {
          localIntent.putExtra("KSta_Scene", i);
          localIntent.putExtra("KSta_FromUserName", paramView);
          localIntent.putExtra("KSta_ChatName", (String)localObject);
          localIntent.putExtra("KSta_MsgId", localbi.field_msgSvrId);
          localIntent.putExtra("KSta_SnsStatExtStr", locals.cGU);
          if (bool) {
            localIntent.putExtra("KSta_ChatroomMembercount", n.nv((String)localObject));
          }
          if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lRW, 0) <= 0) {
            break label438;
          }
          d.b(this.zNL.zKg.zJK.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
          ab.i("MicroMsg.ImageGalleryViewHolder", "use new stream video play UI");
          AppMethodBeat.o(32383);
          return;
          paramView = (View)localObject;
          break;
        }
        label438:
        d.b(this.zNL.zKg.zJK.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
        AppMethodBeat.o(32383);
        return;
      }
      if ((localcii != null) && (!bo.isNullOrNil(localcii.fiR)) && (!bo.isNullOrNil(localcii.fiS)))
      {
        ab.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + localcii.fiS);
        paramView = new Intent();
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_snsad_statextstr", locals.cGU);
        paramView.putExtra("jsapiargs", (Bundle)localObject);
        paramView.putExtra("rawUrl", localcii.fiS);
        paramView.putExtra("useJs", true);
        new ak(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(32382);
            d.b(k.2.this.zNL.zKg.zJK.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
            AppMethodBeat.o(32382);
          }
        });
      }
    }
    AppMethodBeat.o(32383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.2
 * JD-Core Version:    0.7.0.1
 */