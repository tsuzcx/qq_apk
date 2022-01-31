package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.m;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.a.a;
import com.tencent.mm.ui.chatting.a.b;

final class k$2
  implements View.OnClickListener
{
  k$2(k paramk) {}
  
  public final void onClick(final View paramView)
  {
    com.tencent.mm.modelvideo.s locals;
    bwa localbwa;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof bi)))
    {
      bi localbi = (bi)paramView.getTag();
      a.a(a.a.vgc, localbi);
      locals = u.oe(localbi.field_imgPath);
      localbwa = locals.eHQ;
      if ((localbwa == null) || (com.tencent.mm.platformtools.ah.bl(localbwa.dSP))) {
        break label398;
      }
      o.Sr();
      paramView = t.nT(localbi.field_imgPath);
      localIntent = new Intent();
      localIntent.putExtra("IsAd", false);
      localIntent.putExtra("KStremVideoUrl", localbwa.dSP);
      localIntent.putExtra("KThumUrl", localbwa.dSU);
      localIntent.putExtra("KThumbPath", paramView);
      localIntent.putExtra("KMediaId", "fakeid_" + localbi.field_msgId);
      localIntent.putExtra("KMediaVideoTime", localbwa.sWK);
      localIntent.putExtra("KMediaTitle", localbwa.dSR);
      localIntent.putExtra("StreamWording", localbwa.dSS);
      localIntent.putExtra("StremWebUrl", localbwa.dST);
      localObject = localbi.field_talker;
      bool = com.tencent.mm.model.s.fn((String)localObject);
      if (!bool) {
        break label382;
      }
      paramView = bd.iI(localbi.field_content);
      localIntent.putExtra("KSta_StremVideoAduxInfo", localbwa.dSV);
      localIntent.putExtra("KSta_StremVideoPublishId", localbwa.dSW);
      localIntent.putExtra("KSta_SourceType", 1);
      if (!bool) {
        break label388;
      }
      i = a.b.vgl.value;
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", paramView);
      localIntent.putExtra("KSta_ChatName", (String)localObject);
      localIntent.putExtra("KSta_MsgId", localbi.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", locals.bYN);
      if (bool) {
        localIntent.putExtra("KSta_ChatroomMembercount", m.gM((String)localObject));
      }
      d.b(this.vxz.vuf.vtJ.mController.uMN, "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
    label382:
    while ((localbwa == null) || (bk.bl(localbwa.dSS)) || (bk.bl(localbwa.dST))) {
      for (;;)
      {
        Intent localIntent;
        boolean bool;
        return;
        paramView = (View)localObject;
        continue;
        int i = a.b.vgk.value;
      }
    }
    label388:
    label398:
    y.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + localbwa.dST);
    paramView = new Intent();
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key_snsad_statextstr", locals.bYN);
    paramView.putExtra("jsapiargs", (Bundle)localObject);
    paramView.putExtra("rawUrl", localbwa.dST);
    paramView.putExtra("useJs", true);
    new com.tencent.mm.sdk.platformtools.ah(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        d.b(k.2.this.vxz.vuf.vtJ.mController.uMN, "webview", ".ui.tools.WebViewUI", paramView);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.2
 * JD-Core Version:    0.7.0.1
 */