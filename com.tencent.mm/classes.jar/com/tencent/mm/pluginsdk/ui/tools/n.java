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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
{
  public static String Kwp = null;
  
  public static void a(Bundle paramBundle, BaseResp paramBaseResp, String paramString)
  {
    AppMethodBeat.i(152418);
    paramBaseResp.toBundle(paramBundle);
    paramBaseResp = new MMessageActV2.Args();
    paramBaseResp.targetPkgName = paramString;
    paramBaseResp.bundle = paramBundle;
    q.bo(paramBundle);
    q.bp(paramBundle);
    MMessageActV2.send(MMApplicationContext.getContext(), paramBaseResp);
    AppMethodBeat.o(152418);
  }
  
  public static boolean d(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(152417);
    paramString3 = h.o(paramString3, true, false);
    if (paramString3 == null)
    {
      Log.e("MicroMsg.OpenBusinessViewUtil", "launchBackApp info is null");
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
    localResp.transaction = Kwp;
    a(localBundle, localResp, paramString3.field_packageName);
    AppMethodBeat.o(152417);
    return true;
  }
  
  public static void i(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(223872);
    if (!paramBoolean)
    {
      Log.w("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom businessType:%s appid:%s extInfo:%s isSameAccount:%s", new Object[] { paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean) });
      paramString1 = MMApplicationContext.getContext();
      paramString2 = new f.a(paramString1).bow(paramString1.getString(2131763786));
      paramString2.JnN = true;
      paramString2.apa(2131755921).b(new n.1(paramString1)).show();
      AppMethodBeat.o(223872);
      return;
    }
    try
    {
      paramString1 = new JSONObject(paramString3).getString("ticket");
      paramString3 = new Intent();
      paramString3.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI");
      paramString3.addFlags(268435456);
      paramString3.putExtra("upgrade_openim_room_from_scene", 3);
      paramString3.putExtra("ticket", Util.nullAs(paramString1, ""));
      paramString2 = MMApplicationContext.getContext();
      paramString3 = new com.tencent.mm.hellhoundlib.b.a().bl(paramString3);
      com.tencent.mm.hellhoundlib.a.a.a(paramString2, paramString3.axQ(), "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString2.startActivity((Intent)paramString3.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString2, "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      Log.i("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom ticket:%s", new Object[] { Util.nullAs(paramString1, "") });
      AppMethodBeat.o(223872);
      return;
    }
    catch (JSONException paramString1)
    {
      Log.e("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
      AppMethodBeat.o(223872);
    }
  }
  
  public static boolean mF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223871);
    if (Util.isNullOrNil(paramString1))
    {
      Log.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount appid is null");
      AppMethodBeat.o(223871);
      return true;
    }
    paramString1 = h.o(paramString1, true, false);
    if (paramString1 == null)
    {
      Log.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount appInfo is null");
      AppMethodBeat.o(223871);
      return true;
    }
    if (Util.isNullOrNil(paramString2))
    {
      Log.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount openId is null");
      AppMethodBeat.o(223871);
      return true;
    }
    Log.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount %s/%s", new Object[] { paramString2, paramString1.field_openId });
    boolean bool = paramString2.equalsIgnoreCase(paramString1.field_openId);
    AppMethodBeat.o(223871);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.n
 * JD-Core Version:    0.7.0.1
 */