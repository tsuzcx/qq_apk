package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
{
  public static String DFK = null;
  
  public static void a(Bundle paramBundle, BaseResp paramBaseResp, String paramString)
  {
    AppMethodBeat.i(152418);
    paramBaseResp.toBundle(paramBundle);
    paramBaseResp = new MMessageActV2.Args();
    paramBaseResp.targetPkgName = paramString;
    paramBaseResp.bundle = paramBundle;
    q.aW(paramBundle);
    q.aX(paramBundle);
    MMessageActV2.send(ai.getContext(), paramBaseResp);
    AppMethodBeat.o(152418);
  }
  
  public static boolean d(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(152417);
    paramString3 = h.k(paramString3, true, false);
    if (paramString3 == null)
    {
      ac.e("MicroMsg.OpenBusinessViewUtil", "launchBackApp info is null");
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
    localResp.transaction = DFK;
    a(localBundle, localResp, paramString3.field_packageName);
    AppMethodBeat.o(152417);
    return true;
  }
  
  public static void g(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(192701);
    if (!paramBoolean)
    {
      ac.w("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom businessType:%s appid:%s extInfo:%s isSameAccount:%s", new Object[] { paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean) });
      paramString1 = ai.getContext();
      paramString2 = new f.a(paramString1).aRQ(paramString1.getString(2131766239));
      paramString2.JfY = true;
      paramString2.acQ(2131755835).b(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(192699);
          Object localObject = new Intent();
          ((Intent)localObject).setAction("android.intent.action.VIEW");
          ((Intent)localObject).setData(Uri.parse("wxwork://jump"));
          ((Intent)localObject).setPackage("com.tencent.wework");
          ((Intent)localObject).setFlags(268435456);
          paramAnonymousString = this.val$context;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(192699);
        }
      }).show();
      AppMethodBeat.o(192701);
      return;
    }
    try
    {
      paramString1 = new JSONObject(paramString3).getString("ticket");
      paramString3 = new Intent();
      paramString3.setClassName(ai.getContext(), "com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI");
      paramString3.addFlags(268435456);
      paramString3.putExtra("upgrade_openim_room_from_scene", 3);
      paramString3.putExtra("ticket", bs.bG(paramString1, ""));
      paramString2 = ai.getContext();
      paramString3 = new com.tencent.mm.hellhoundlib.b.a().ba(paramString3);
      com.tencent.mm.hellhoundlib.a.a.a(paramString2, paramString3.aeD(), "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString2.startActivity((Intent)paramString3.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString2, "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ac.i("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom ticket:%s", new Object[] { bs.bG(paramString1, "") });
      AppMethodBeat.o(192701);
      return;
    }
    catch (JSONException paramString1)
    {
      ac.e("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
      AppMethodBeat.o(192701);
    }
  }
  
  public static boolean lb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192700);
    if (bs.isNullOrNil(paramString1))
    {
      ac.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount appid is null");
      AppMethodBeat.o(192700);
      return true;
    }
    paramString1 = h.k(paramString1, true, false);
    if (paramString1 == null)
    {
      ac.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount appInfo is null");
      AppMethodBeat.o(192700);
      return true;
    }
    if (bs.isNullOrNil(paramString2))
    {
      ac.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount openId is null");
      AppMethodBeat.o(192700);
      return true;
    }
    ac.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount %s/%s", new Object[] { paramString2, paramString1.field_openId });
    boolean bool = paramString2.equalsIgnoreCase(paramString1.field_openId);
    AppMethodBeat.o(192700);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */