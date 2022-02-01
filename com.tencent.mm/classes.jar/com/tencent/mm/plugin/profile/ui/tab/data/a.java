package com.tencent.mm.plugin.profile.ui.tab.data;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.m;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileJumpLogic;", "", "()V", "jumpTo", "", "context", "Landroid/content/Context;", "jumpExtra", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileJumpLogic$BizProfileJumpExtra;", "BizProfileJumpExtra", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Nen;
  
  static
  {
    AppMethodBeat.i(305958);
    Nen = new a();
    AppMethodBeat.o(305958);
  }
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(305947);
    s.u(paramContext, "context");
    s.u(parama, "jumpExtra");
    od localod = parama.Nep;
    if (localod == null)
    {
      AppMethodBeat.o(305947);
      return;
    }
    Object localObject = com.tencent.mm.plugin.profile.ui.tab.list.a.NeA;
    Log.i(com.tencent.mm.plugin.profile.ui.tab.list.a.access$getTAG$cp(), "onClick jump to url:%s", new Object[] { localod.YQK });
    localObject = new Intent();
    String str = m.e(localod.YQK, 126, -1, (int)System.currentTimeMillis() / 1000);
    ((Intent)localObject).putExtra("rawUrl", str);
    ((Intent)localObject).putExtra("useJs", true);
    ((Intent)localObject).putExtra("vertical_scroll", true);
    ((Intent)localObject).putExtra("geta8key_scene", 3);
    ((Intent)localObject).putExtra("geta8key_username", parama.hAw);
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
      if ((!((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(6)) || (!((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(paramContext, str, localod.nUA, 126, i, (Intent)localObject))) {
        break;
      }
      paramContext = com.tencent.mm.plugin.profile.ui.tab.list.a.NeA;
      Log.i(com.tencent.mm.plugin.profile.ui.tab.list.a.access$getTAG$cp(), "jump to TmplWebview");
      AppMethodBeat.o(305947);
      return;
      ((Intent)localObject).putExtra("prePublishId", "brand_profile");
      ((Intent)localObject).putExtra("KPublisherId", "brand_profile");
    }
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(305947);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileJumpLogic$BizProfileJumpExtra;", "", "()V", "baseInfo", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "getBaseInfo", "()Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "setBaseInfo", "(Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;)V", "bizNickName", "", "getBizNickName", "()Ljava/lang/String;", "setBizNickName", "(Ljava/lang/String;)V", "bizUserName", "getBizUserName", "setBizUserName", "coverView", "Landroid/view/View;", "getCoverView", "()Landroid/view/View;", "setCoverView", "(Landroid/view/View;)V", "detailInfo", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "getDetailInfo", "()Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "setDetailInfo", "(Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;)V", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public View Neo;
    public od Nep;
    public oc Neq;
    public String hAw = "";
    public String zRP = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.data.a
 * JD-Core Version:    0.7.0.1
 */