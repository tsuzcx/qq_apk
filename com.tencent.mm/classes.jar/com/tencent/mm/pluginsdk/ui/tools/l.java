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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
{
  public static String FDn = null;
  
  public static void a(Bundle paramBundle, BaseResp paramBaseResp, String paramString)
  {
    AppMethodBeat.i(152418);
    paramBaseResp.toBundle(paramBundle);
    paramBaseResp = new MMessageActV2.Args();
    paramBaseResp.targetPkgName = paramString;
    paramBaseResp.bundle = paramBundle;
    q.bc(paramBundle);
    q.bd(paramBundle);
    MMessageActV2.send(ak.getContext(), paramBaseResp);
    AppMethodBeat.o(152418);
  }
  
  public static boolean d(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(152417);
    paramString3 = h.m(paramString3, true, false);
    if (paramString3 == null)
    {
      ae.e("MicroMsg.OpenBusinessViewUtil", "launchBackApp info is null");
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
    localResp.transaction = FDn;
    a(localBundle, localResp, paramString3.field_packageName);
    AppMethodBeat.o(152417);
    return true;
  }
  
  public static void g(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(218907);
    if (!paramBoolean)
    {
      ae.w("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom businessType:%s appid:%s extInfo:%s isSameAccount:%s", new Object[] { paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean) });
      paramString1 = ak.getContext();
      paramString2 = new f.a(paramString1).aZq(paramString1.getString(2131766239));
      paramString2.EyN = true;
      paramString2.afY(2131755835).b(new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(218905);
          Object localObject = new Intent();
          ((Intent)localObject).setAction("android.intent.action.VIEW");
          ((Intent)localObject).setData(Uri.parse("wxwork://jump"));
          ((Intent)localObject).setPackage("com.tencent.wework");
          ((Intent)localObject).setFlags(268435456);
          paramAnonymousString = this.val$context;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(218905);
        }
      }).show();
      AppMethodBeat.o(218907);
      return;
    }
    try
    {
      paramString1 = new JSONObject(paramString3).getString("ticket");
      paramString3 = new Intent();
      paramString3.setClassName(ak.getContext(), "com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI");
      paramString3.addFlags(268435456);
      paramString3.putExtra("upgrade_openim_room_from_scene", 3);
      paramString3.putExtra("ticket", bu.bI(paramString1, ""));
      paramString2 = ak.getContext();
      paramString3 = new com.tencent.mm.hellhoundlib.b.a().bc(paramString3);
      com.tencent.mm.hellhoundlib.a.a.a(paramString2, paramString3.ahE(), "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString2.startActivity((Intent)paramString3.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString2, "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ae.i("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom ticket:%s", new Object[] { bu.bI(paramString1, "") });
      AppMethodBeat.o(218907);
      return;
    }
    catch (JSONException paramString1)
    {
      ae.e("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom Exception:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
      AppMethodBeat.o(218907);
    }
  }
  
  public static boolean lH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218906);
    if (bu.isNullOrNil(paramString1))
    {
      ae.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount appid is null");
      AppMethodBeat.o(218906);
      return true;
    }
    paramString1 = h.m(paramString1, true, false);
    if (paramString1 == null)
    {
      ae.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount appInfo is null");
      AppMethodBeat.o(218906);
      return true;
    }
    if (bu.isNullOrNil(paramString2))
    {
      ae.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount openId is null");
      AppMethodBeat.o(218906);
      return true;
    }
    ae.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount %s/%s", new Object[] { paramString2, paramString1.field_openId });
    boolean bool = paramString2.equalsIgnoreCase(paramString1.field_openId);
    AppMethodBeat.o(218906);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */