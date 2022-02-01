package com.tencent.mm.plugin.repairer.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/model/RepairerInnerLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "sendFile", "", "context", "Landroid/content/Context;", "filePath", "ui-repairer_release"})
public final class c
{
  public static final c Iyf;
  private static final String TAG = "MicroMsg.Repairer.RepairerInnerLogic";
  
  static
  {
    AppMethodBeat.i(226609);
    Iyf = new c();
    TAG = "MicroMsg.Repairer.RepairerInnerLogic";
    AppMethodBeat.o(226609);
  }
  
  public static void bG(Context paramContext, String paramString)
  {
    AppMethodBeat.i(226608);
    p.k(paramContext, "context");
    p.k(paramString, "filePath");
    if (!u.agG(paramString))
    {
      w.makeText(paramContext, (CharSequence)"文件不存在", 0).show();
      AppMethodBeat.o(226608);
      return;
    }
    Log.i(TAG, "sendFile ".concat(String.valueOf(paramString)));
    Object localObject1 = new WXMediaMessage((WXMediaMessage.IMediaObject)new WXFileObject(paramString));
    ((WXMediaMessage)localObject1).title = new q(paramString).getName();
    ((WXMediaMessage)localObject1).description = Util.getSizeKB(u.bBQ(paramString));
    Object localObject2 = new SendMessageToWX.Req();
    ((SendMessageToWX.Req)localObject2).transaction = null;
    ((SendMessageToWX.Req)localObject2).message = ((WXMediaMessage)localObject1);
    paramString = new Bundle();
    ((SendMessageToWX.Req)localObject2).toBundle(paramString);
    paramString.putInt("_mmessage_sdkVersion", 637992960);
    paramString.putString("_mmessage_appPackage", "com.tencent.mm.openapi");
    paramString.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
    localObject1 = new Intent();
    ((Intent)localObject1).setClassName(paramContext, "com.tencent.mm.ui.transmit.SendAppMessageWrapperUI");
    localObject2 = new Intent();
    if (!(paramContext instanceof Activity)) {
      ((Intent)localObject2).addFlags(268435456);
    }
    ((Intent)localObject2).setClassName(paramContext, "com.tencent.mm.ui.transmit.SelectConversationUI");
    ((Intent)localObject2).putExtra("Select_Conv_NextStep", (Parcelable)((Intent)localObject1).putExtras(paramString).putExtra("animation_pop_in", true));
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aFh(), "com/tencent/mm/plugin/repairer/ui/model/RepairerInnerLogic", "sendFile", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/repairer/ui/model/RepairerInnerLogic", "sendFile", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(226608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.b.c
 * JD-Core Version:    0.7.0.1
 */