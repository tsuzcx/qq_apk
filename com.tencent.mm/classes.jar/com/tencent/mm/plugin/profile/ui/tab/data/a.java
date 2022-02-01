package com.tencent.mm.plugin.profile.ui.tab.data;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.mx;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileJumpLogic;", "", "()V", "jumpTo", "", "context", "Landroid/content/Context;", "jumpExtra", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileJumpLogic$BizProfileJumpExtra;", "BizProfileJumpExtra", "app_release"})
public final class a
{
  public static final a Hhb;
  
  static
  {
    AppMethodBeat.i(238359);
    Hhb = new a();
    AppMethodBeat.o(238359);
  }
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(238358);
    p.k(paramContext, "context");
    p.k(parama, "jumpExtra");
    my localmy = parama.Hhd;
    if (localmy == null)
    {
      AppMethodBeat.o(238358);
      return;
    }
    Object localObject = com.tencent.mm.plugin.profile.ui.tab.list.a.Hhq;
    Log.i(com.tencent.mm.plugin.profile.ui.tab.list.a.access$getTAG$cp(), "onClick jump to url:%s", new Object[] { localmy.RTk });
    localObject = new Intent();
    String str = m.e(localmy.RTk, 126, -1, 0);
    ((Intent)localObject).putExtra("rawUrl", str);
    ((Intent)localObject).putExtra("useJs", true);
    ((Intent)localObject).putExtra("vertical_scroll", true);
    ((Intent)localObject).putExtra("geta8key_scene", 3);
    ((Intent)localObject).putExtra("geta8key_username", parama.fvZ);
    parama = ((Intent)localObject).getStringExtra("prePublishId");
    if (!Util.isNullOrNil(parama))
    {
      ((Intent)localObject).putExtra("KPublisherId", parama);
      ((Intent)localObject).putExtra("prePublishId", parama);
      ((Intent)localObject).putExtra("preUsername", ((Intent)localObject).getStringExtra("preUsername"));
      ((Intent)localObject).putExtra("preChatName", ((Intent)localObject).getStringExtra("preChatName"));
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("preChatTYPE", ((Intent)localObject).getIntExtra("preChatTYPE", 0));
      int i = ((Intent)localObject).getIntExtra("KOpenArticleSceneFromScene", 10000);
      if ((!((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(6)) || (!((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramContext, str, localmy.lpx, 126, i, (Intent)localObject))) {
        break;
      }
      paramContext = com.tencent.mm.plugin.profile.ui.tab.list.a.Hhq;
      Log.i(com.tencent.mm.plugin.profile.ui.tab.list.a.access$getTAG$cp(), "jump to TmplWebview");
      AppMethodBeat.o(238358);
      return;
      ((Intent)localObject).putExtra("prePublishId", "brand_profile");
      ((Intent)localObject).putExtra("KPublisherId", "brand_profile");
    }
    com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(238358);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileJumpLogic$BizProfileJumpExtra;", "", "()V", "baseInfo", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "getBaseInfo", "()Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "setBaseInfo", "(Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;)V", "bizNickName", "", "getBizNickName", "()Ljava/lang/String;", "setBizNickName", "(Ljava/lang/String;)V", "bizUserName", "getBizUserName", "setBizUserName", "coverView", "Landroid/view/View;", "getCoverView", "()Landroid/view/View;", "setCoverView", "(Landroid/view/View;)V", "detailInfo", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "getDetailInfo", "()Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "setDetailInfo", "(Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;)V", "app_release"})
  public static final class a
  {
    public View Hhc;
    public my Hhd;
    public mx Hhe;
    public String fvZ = "";
    public String wvK = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.data.a
 * JD-Core Version:    0.7.0.1
 */