package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
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
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof bo)))
    {
      bo localbo = (bo)paramView.getTag();
      a.a(a.a.HIZ, localbo);
      s locals = u.Ej(localbo.field_imgPath);
      dev localdev = locals.iaR;
      Object localObject;
      if ((localdev != null) && (!ae.isNullOrNil(localdev.hjV)))
      {
        o.aJy();
        paramView = t.DW(localbo.field_imgPath);
        Intent localIntent = new Intent();
        localIntent.putExtra("KFromTimeLine", false);
        localIntent.putExtra("KStremVideoUrl", localdev.hjV);
        localIntent.putExtra("KThumUrl", localdev.hka);
        localIntent.putExtra("KThumbPath", paramView);
        localIntent.putExtra("KMediaId", "fakeid_" + localbo.field_msgId);
        localIntent.putExtra("KMediaVideoTime", localdev.EBs);
        localIntent.putExtra("KMediaTitle", localdev.hjX);
        localIntent.putExtra("StreamWording", localdev.hjY);
        localIntent.putExtra("StremWebUrl", localdev.hjZ);
        localObject = localbo.field_talker;
        boolean bool = w.sQ((String)localObject);
        if (bool)
        {
          paramView = bi.yl(localbo.field_content);
          localIntent.putExtra("KSta_StremVideoAduxInfo", localdev.hkb);
          localIntent.putExtra("KSta_StremVideoPublishId", localdev.hkc);
          localIntent.putExtra("KSta_SourceType", 1);
          if (!bool) {
            break label426;
          }
        }
        label426:
        for (int i = a.b.HJi.value;; i = a.b.HJh.value)
        {
          localIntent.putExtra("KSta_Scene", i);
          localIntent.putExtra("KSta_FromUserName", paramView);
          localIntent.putExtra("KSta_ChatName", (String)localObject);
          localIntent.putExtra("KSta_MsgId", localbo.field_msgSvrId);
          localIntent.putExtra("KSta_SnsStatExtStr", locals.dvs);
          if (bool) {
            localIntent.putExtra("KSta_ChatroomMembercount", q.wb((String)localObject));
          }
          if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMG, 0) <= 0) {
            break label436;
          }
          d.b(this.Ied.Iav.HZV.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
          ac.i("MicroMsg.ImageGalleryViewHolder", "use new stream video play UI");
          AppMethodBeat.o(36322);
          return;
          paramView = (View)localObject;
          break;
        }
        label436:
        d.b(this.Ied.Iav.HZV.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
        AppMethodBeat.o(36322);
        return;
      }
      if ((localdev != null) && (!bs.isNullOrNil(localdev.hjY)) && (!bs.isNullOrNil(localdev.hjZ)))
      {
        ac.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + localdev.hjZ);
        paramView = new Intent();
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_snsad_statextstr", locals.dvs);
        paramView.putExtra("jsapiargs", (Bundle)localObject);
        paramView.putExtra("rawUrl", localdev.hjZ);
        paramView.putExtra("useJs", true);
        new ao(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36321);
            d.b(k.2.this.Ied.Iav.HZV.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
            AppMethodBeat.o(36321);
          }
        });
      }
    }
    AppMethodBeat.o(36322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.2
 * JD-Core Version:    0.7.0.1
 */