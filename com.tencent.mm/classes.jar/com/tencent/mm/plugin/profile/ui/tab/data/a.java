package com.tencent.mm.plugin.profile.ui.tab.data;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.x;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.e.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileJumpLogic;", "", "()V", "jumpTo", "", "context", "Landroid/content/Context;", "jumpExtra", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileJumpLogic$BizProfileJumpExtra;", "BizProfileJumpExtra", "app_release"})
public final class a
{
  public static final a BmH;
  
  static
  {
    AppMethodBeat.i(230715);
    BmH = new a();
    AppMethodBeat.o(230715);
  }
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(230714);
    p.h(paramContext, "context");
    p.h(parama, "jumpExtra");
    nh localnh = parama.BmK;
    if (localnh == null)
    {
      AppMethodBeat.o(230714);
      return;
    }
    Object localObject2 = parama.BmL;
    Object localObject1 = com.tencent.mm.plugin.profile.ui.tab.list.a.BmV;
    Log.i(com.tencent.mm.plugin.profile.ui.tab.list.a.access$getTAG$cp(), "onClick jump to url:%s", new Object[] { localnh.KSj });
    localObject1 = new Intent();
    String str = m.d(localnh.KSj, 126, -1, 0);
    ((Intent)localObject1).putExtra("rawUrl", str);
    ((Intent)localObject1).putExtra("useJs", true);
    ((Intent)localObject1).putExtra("vertical_scroll", true);
    ((Intent)localObject1).putExtra("geta8key_scene", 3);
    ((Intent)localObject1).putExtra("geta8key_username", parama.BmI);
    Object localObject3 = ((Intent)localObject1).getStringExtra("prePublishId");
    int i;
    v localv;
    if (!Util.isNullOrNil((String)localObject3))
    {
      ((Intent)localObject1).putExtra("KPublisherId", (String)localObject3);
      ((Intent)localObject1).putExtra("prePublishId", (String)localObject3);
      ((Intent)localObject1).putExtra("preUsername", ((Intent)localObject1).getStringExtra("preUsername"));
      ((Intent)localObject1).putExtra("preChatName", ((Intent)localObject1).getStringExtra("preChatName"));
      ((Intent)localObject1).putExtra("preChatTYPE", ((Intent)localObject1).getIntExtra("preChatTYPE", 0));
      i = ((Intent)localObject1).getIntExtra("KOpenArticleSceneFromScene", 10000);
      if (localnh.iAb == 5)
      {
        localObject3 = g.af(b.class);
        p.g(localObject3, "MMKernel.service(IBrandService::class.java)");
        if (((b)localObject3).cld())
        {
          ((Intent)localObject1).putExtra(e.b.OyQ, 126);
          ((Intent)localObject1).putExtra(e.b.OyR, i);
          ((Intent)localObject1).putExtra("biz_video_session_id", ab.getSessionId());
          localObject3 = new x();
          ((x)localObject3).iAh = ((Intent)localObject1).getStringExtra("KPublisherId");
          ((x)localObject3).dHc = parama.BmI;
          ((x)localObject3).iAg = parama.sPQ;
          ((x)localObject3).iAi.url = str;
          ((x)localObject3).iAi.title = localnh.Title;
          ((x)localObject3).iAi.iAq = "detail.videoDigest";
          ((x)localObject3).iAi.iAo = localnh.KSl;
          ((x)localObject3).iAi.type = localnh.iAb;
          localv = ((x)localObject3).iAi;
          if (localObject2 == null) {
            break label666;
          }
        }
      }
    }
    label666:
    for (long l = ((ng)localObject2).CreateTime;; l = 0L)
    {
      localv.time = l;
      ((x)localObject3).iAi.iAs = localnh.KSx;
      ((x)localObject3).iAi.videoWidth = localnh.KSv;
      ((x)localObject3).iAi.videoHeight = localnh.KSw;
      ((x)localObject3).iAi.vid = localnh.KSu;
      ((x)localObject3).t((Intent)localObject1);
      localObject2 = com.tencent.mm.plugin.profile.ui.tab.list.a.BmV;
      Log.i(com.tencent.mm.plugin.profile.ui.tab.list.a.access$getTAG$cp(), "jump to native video");
      localObject2 = new int[2];
      parama = parama.BmJ;
      if (parama != null)
      {
        int j = parama.getWidth();
        int k = parama.getHeight();
        parama.getLocationInWindow((int[])localObject2);
        ((Intent)localObject1).putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", localObject2[0]).putExtra("img_gallery_top", localObject2[1]);
      }
      ((Intent)localObject1).addFlags(268435456);
      if ((!((b)g.af(b.class)).CR(6)) || (!((b)g.af(b.class)).a(paramContext, str, localnh.iAb, 126, i, (Intent)localObject1))) {
        break label672;
      }
      paramContext = com.tencent.mm.plugin.profile.ui.tab.list.a.BmV;
      Log.i(com.tencent.mm.plugin.profile.ui.tab.list.a.access$getTAG$cp(), "jump to TmplWebview");
      AppMethodBeat.o(230714);
      return;
      ((Intent)localObject1).putExtra("prePublishId", "brand_profile");
      ((Intent)localObject1).putExtra("KPublisherId", "brand_profile");
      break;
    }
    label672:
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    AppMethodBeat.o(230714);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileJumpLogic$BizProfileJumpExtra;", "", "()V", "baseInfo", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "getBaseInfo", "()Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "setBaseInfo", "(Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;)V", "bizNickName", "", "getBizNickName", "()Ljava/lang/String;", "setBizNickName", "(Ljava/lang/String;)V", "bizUserName", "getBizUserName", "setBizUserName", "coverView", "Landroid/view/View;", "getCoverView", "()Landroid/view/View;", "setCoverView", "(Landroid/view/View;)V", "detailInfo", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "getDetailInfo", "()Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "setDetailInfo", "(Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;)V", "app_release"})
  public static final class a
  {
    public String BmI = "";
    public View BmJ;
    public nh BmK;
    public ng BmL;
    public String sPQ = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.data.a
 * JD-Core Version:    0.7.0.1
 */