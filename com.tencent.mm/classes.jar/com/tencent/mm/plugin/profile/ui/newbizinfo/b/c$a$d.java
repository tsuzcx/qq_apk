package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import a.f.b.j;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ke;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$a$d
  implements View.OnClickListener
{
  c$a$d(c.a parama, kf paramkf, ke paramke, View paramView, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = true;
    AppMethodBeat.i(154055);
    paramView = c.pEB;
    ab.i(c.access$getTAG$cp(), "onClick jump to url:%s", new Object[] { this.pEH.wxi });
    int i = this.pEE.intent.getIntExtra("KOpenArticleSceneFromScene", -1);
    paramView = new Intent();
    String str = com.tencent.mm.af.l.c(this.pEH.wxi, 126, i, 0);
    paramView.putExtra("rawUrl", str);
    paramView.putExtra("useJs", true);
    paramView.putExtra("vertical_scroll", true);
    paramView.putExtra("geta8key_scene", 3);
    Object localObject1 = this.pEE.pEy.ccM();
    j.p(localObject1, "widget.contact");
    paramView.putExtra("geta8key_username", ((ad)localObject1).getUsername());
    localObject1 = paramView.getStringExtra("prePublishId");
    int j;
    int k;
    if (!bo.isNullOrNil((String)localObject1))
    {
      paramView.putExtra("KPublisherId", (String)localObject1);
      paramView.putExtra("prePublishId", (String)localObject1);
      paramView.putExtra("preUsername", paramView.getStringExtra("preUsername"));
      paramView.putExtra("preChatName", paramView.getStringExtra("preChatName"));
      paramView.putExtra("preChatTYPE", paramView.getIntExtra("preChatTYPE", 0));
      i = paramView.getIntExtra("KOpenArticleSceneFromScene", 10000);
      if (this.pEH.wqp != 5) {
        break label855;
      }
      localObject1 = g.E(com.tencent.mm.plugin.brandservice.a.b.class);
      j.p(localObject1, "MMKernel.service(IBrandService::class.java)");
      if (!((com.tencent.mm.plugin.brandservice.a.b)localObject1).aWm()) {
        break label855;
      }
      paramView.putExtra("biz_video_scene", 126);
      paramView.putExtra("biz_video_subscene", i);
      paramView.putExtra("biz_video_session_id", com.tencent.mm.storage.s.getSessionId());
      localObject1 = new com.tencent.mm.af.s();
      ((com.tencent.mm.af.s)localObject1).fjC = paramView.getStringExtra("KPublisherId");
      Object localObject2 = this.pEE.pEy.ccM();
      j.p(localObject2, "widget.contact");
      ((com.tencent.mm.af.s)localObject1).cqX = ((ad)localObject2).getUsername();
      localObject2 = this.pEE.pEy.ccM();
      j.p(localObject2, "widget.contact");
      ((com.tencent.mm.af.s)localObject1).fjB = ((ad)localObject2).Oe();
      ((com.tencent.mm.af.s)localObject1).fjD.url = str;
      ((com.tencent.mm.af.s)localObject1).fjD.title = this.pEH.Title;
      ((com.tencent.mm.af.s)localObject1).fjD.fjL = "detail.videoDigest";
      ((com.tencent.mm.af.s)localObject1).fjD.fjJ = this.pEH.wxk;
      ((com.tencent.mm.af.s)localObject1).fjD.type = this.pEH.wqp;
      ((com.tencent.mm.af.s)localObject1).fjD.time = this.pEI.CreateTime;
      ((com.tencent.mm.af.s)localObject1).fjD.fjN = this.pEH.wxw;
      ((com.tencent.mm.af.s)localObject1).fjD.videoWidth = this.pEH.wxu;
      ((com.tencent.mm.af.s)localObject1).fjD.videoHeight = this.pEH.wxv;
      ((com.tencent.mm.af.s)localObject1).fjD.fgl = this.pEH.wxt;
      ((com.tencent.mm.af.s)localObject1).t(paramView);
      localObject1 = c.pEB;
      ab.i(c.access$getTAG$cp(), "jump to native video");
      localObject1 = new int[2];
      localObject2 = (ImageView)this.pEJ.findViewById(2131823046);
      if (localObject2 != null)
      {
        j = ((ImageView)localObject2).getWidth();
        k = ((ImageView)localObject2).getHeight();
        ((ImageView)localObject2).getLocationInWindow((int[])localObject1);
        paramView.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", localObject1[0]).putExtra("img_gallery_top", localObject1[1]);
      }
      paramView.addFlags(268435456);
    }
    for (;;)
    {
      if ((((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rU(6)) && (((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.pEE.context, str, this.pEH.wqp, bool, 126, i, paramView)))
      {
        paramView = c.pEB;
        ab.i(c.access$getTAG$cp(), "jump to TmplWebview");
      }
      for (;;)
      {
        paramView = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.pFJ;
        paramView = this.pEE.pEy.ccM();
        j.p(paramView, "widget.contact");
        paramView = paramView.getUsername();
        j.p(paramView, "widget.contact.username");
        long l = this.pEE.pEy.FH();
        i = this.pEI.wxe;
        j = this.pEH.wxh;
        k = this.pEH.wqp;
        int m = this.euX;
        int n = this.pEI.CreateTime;
        int i1 = this.pEE.pEy.ccP();
        j.q(paramView, "userName");
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a(com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.pFI, paramView, l, i, j, k, m, n, i1);
        AppMethodBeat.o(154055);
        return;
        paramView.putExtra("prePublishId", "brand_profile");
        paramView.putExtra("KPublisherId", "brand_profile");
        break;
        com.tencent.mm.bq.d.b(this.pEE.context, "webview", ".ui.tools.WebViewUI", paramView);
      }
      label855:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.c.a.d
 * JD-Core Version:    0.7.0.1
 */