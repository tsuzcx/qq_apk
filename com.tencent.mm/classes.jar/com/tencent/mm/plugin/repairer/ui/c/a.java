package com.tencent.mm.plugin.repairer.ui.c;

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
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/model/RepairerInnerLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "sendFile", "", "context", "Landroid/content/Context;", "filePath", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Oyl;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(277847);
    Oyl = new a();
    TAG = "MicroMsg.Repairer.RepairerInnerLogic";
    AppMethodBeat.o(277847);
  }
  
  public static void bI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(277839);
    s.u(paramContext, "context");
    s.u(paramString, "filePath");
    if (!y.ZC(paramString))
    {
      aa.makeText(paramContext, (CharSequence)"文件不存在", 0).show();
      AppMethodBeat.o(277839);
      return;
    }
    Log.i(TAG, s.X("sendFile ", paramString));
    Object localObject1 = new WXMediaMessage((WXMediaMessage.IMediaObject)new WXFileObject(paramString));
    ((WXMediaMessage)localObject1).title = new u(paramString).getName();
    ((WXMediaMessage)localObject1).description = Util.getSizeKB(y.bEl(paramString));
    Object localObject2 = new SendMessageToWX.Req();
    ((SendMessageToWX.Req)localObject2).transaction = null;
    ((SendMessageToWX.Req)localObject2).message = ((WXMediaMessage)localObject1);
    paramString = new Bundle();
    ((SendMessageToWX.Req)localObject2).toBundle(paramString);
    paramString.putInt("_mmessage_sdkVersion", 638058496);
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
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/repairer/ui/model/RepairerInnerLogic", "sendFile", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/repairer/ui/model/RepairerInnerLogic", "sendFile", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(277839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.c.a
 * JD-Core Version:    0.7.0.1
 */