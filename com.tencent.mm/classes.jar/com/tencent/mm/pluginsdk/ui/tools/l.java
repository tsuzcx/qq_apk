package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.f.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
{
  public static String FkP = null;
  
  public static void a(Bundle paramBundle, BaseResp paramBaseResp, String paramString)
  {
    AppMethodBeat.i(152418);
    paramBaseResp.toBundle(paramBundle);
    paramBaseResp = new MMessageActV2.Args();
    paramBaseResp.targetPkgName = paramString;
    paramBaseResp.bundle = paramBundle;
    q.bb(paramBundle);
    q.bc(paramBundle);
    MMessageActV2.send(aj.getContext(), paramBaseResp);
    AppMethodBeat.o(152418);
  }
  
  public static boolean d(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(152417);
    paramString3 = h.m(paramString3, true, false);
    if (paramString3 == null)
    {
      ad.e("MicroMsg.OpenBusinessViewUtil", "launchBackApp info is null");
      AppMethodBeat.o(152417);
      return false;
    }
    Bundle localBundle = new Bundle();
    WXOpenBusinessView.Resp localResp = new WXOpenBusinessView.Resp(localBundle);
    localResp.extMsg = paramString2;
    localResp.errStr = paramString4;
    localResp.openId = paramString3.field_openId;
    localResp.errCode = paramInt;
    localResp.businessType = paramString1;
    localResp.transaction = FkP;
    a(localBundle, localResp, paramString3.field_packageName);
    AppMethodBeat.o(152417);
    return true;
  }
  
  public static void g(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(195454);
    if (!paramBoolean)
    {
      ad.w("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom businessType:%s appid:%s extInfo:%s isSameAccount:%s", new Object[] { paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean) });
      paramString1 = aj.getContext();
      paramString2 = new f.a(paramString1).aXO(paramString1.getString(2131766239));
      paramString2.EgK = true;
      paramString2.afp(2131755835).b(new l.1(paramString1)).show();
      AppMethodBeat.o(195454);
      return;
    }
    try
    {
      paramString1 = new JSONObject(paramString3).getString("ticket");
      paramString3 = new Intent();
      paramString3.setClassName(aj.getContext(), "com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI");
      paramString3.addFlags(268435456);
      paramString3.putExtra("upgrade_openim_room_from_scene", 3);
      paramString3.putExtra("ticket", bt.bI(paramString1, ""));
      paramString2 = aj.getContext();
      paramString3 = new com.tencent.mm.hellhoundlib.b.a().bc(paramString3);
      com.tencent.mm.hellhoundlib.a.a.a(paramString2, paramString3.ahp(), "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString2.startActivity((Intent)paramString3.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString2, "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ad.i("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom ticket:%s", new Object[] { bt.bI(paramString1, "") });
      AppMethodBeat.o(195454);
      return;
    }
    catch (JSONException paramString1)
    {
      ad.e("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
      AppMethodBeat.o(195454);
    }
  }
  
  public static boolean lA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195453);
    if (bt.isNullOrNil(paramString1))
    {
      ad.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount appid is null");
      AppMethodBeat.o(195453);
      return true;
    }
    paramString1 = h.m(paramString1, true, false);
    if (paramString1 == null)
    {
      ad.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount appInfo is null");
      AppMethodBeat.o(195453);
      return true;
    }
    if (bt.isNullOrNil(paramString2))
    {
      ad.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount openId is null");
      AppMethodBeat.o(195453);
      return true;
    }
    ad.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount %s/%s", new Object[] { paramString2, paramString1.field_openId });
    boolean bool = paramString2.equalsIgnoreCase(paramString1.field_openId);
    AppMethodBeat.o(195453);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */