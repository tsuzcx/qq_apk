package com.tencent.mm.plugin.recordvideo.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ar.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/SecondCutUtil;", "", "()V", "APPID_SECONDCUT", "", "DOWNLOAD_FROM_SIMPLE_STYLE", "DOWNLOAD_FROM_SNS_HOME", "DOWNLOAD_FROM_VIDEO_CORP", "DOWNLOAD_SECONDCUT_URL", "PACKAGE_NAME_SECONDCUT", "PRE_SCHEMA_SECONDCUT", "PUBLIC_KEY_SECONDCUT", "SCENE_MOMENTS", "TAG", "checkApplyThirdPartyVideoDataToUploadIntent", "", "intent", "Landroid/content/Intent;", "editResult", "getSecondCutEditIntent", "scene", "videoPath", "duration", "", "videoBitrate", "width", "height", "getSecondCutHomeIntent", "getSecondCutSimpleStyleIntent", "extInfo", "takeSecondCutSigh", "activity", "Landroid/content/Context;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l ObI;
  
  static
  {
    AppMethodBeat.i(279572);
    ObI = new l();
    AppMethodBeat.o(279572);
  }
  
  public static void aG(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(279526);
    s.u(paramContext, "activity");
    s.u(paramIntent, "intent");
    try
    {
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/recordvideo/util/SecondCutUtil", "takeSecondCutSigh", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/recordvideo/util/SecondCutUtil", "takeSecondCutSigh", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if ((paramContext instanceof Activity))
      {
        ((Activity)paramContext).overridePendingTransition(a.a.sight_slide_bottom_in, -1);
        AppMethodBeat.o(279526);
        return;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.SecondCutUtil", s.X("takeSecondCutSigh: error ", paramContext.getMessage()));
      AppMethodBeat.o(279526);
    }
  }
  
  public static Intent av(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(279551);
    s.u(paramString1, "scene");
    s.u(paramString2, "extInfo");
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("miaojian://createvideo?scene=" + paramString1 + "&miaojianExtInfo=" + paramString2 + "&maxDuration=" + paramInt + "&from=3"));
    localIntent.setPackage("com.tencent.phoenix");
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    AppMethodBeat.o(279551);
    return localIntent;
  }
  
  public static Intent b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(279535);
    s.u(paramString1, "scene");
    s.u(paramString2, "videoPath");
    Log.i("MicroMsg.SecondCutUtil", "getSecondCutEditIntent >>>videoPath: " + paramString2 + " >>>width: " + paramInt3 + " >>>height: " + paramInt4 + " >>>duration: " + paramInt1 + " >>> videoBitrate: " + paramInt2);
    paramString2 = paramString2.getBytes(d.UTF_8);
    s.s(paramString2, "(this as java.lang.String).getBytes(charset)");
    paramString2 = Base64.encodeToString(paramString2, 10);
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("miaojian://createvideo?scene=" + paramString1 + "&assetPaths=" + paramString2 + "&maxDuration=" + paramInt1 + "&bitrate=" + paramInt2 + "&resolution=" + paramInt3 + ',' + paramInt4 + "&from=2"));
    localIntent.setPackage("com.tencent.phoenix");
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    AppMethodBeat.o(279535);
    return localIntent;
  }
  
  public static void c(Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(279563);
    s.u(paramIntent1, "intent");
    s.u(paramIntent2, "editResult");
    paramIntent2 = paramIntent2.getBundleExtra("key_extra_data");
    if (paramIntent2 == null)
    {
      AppMethodBeat.o(279563);
      return;
    }
    paramIntent2 = paramIntent2.getString("kThirdPartyVideoExtData");
    Object localObject = (CharSequence)paramIntent2;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(279563);
      return;
    }
    try
    {
      localObject = new SendMessageToWX.Req();
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      i locali = new i();
      locali.m("miaojianExtInfo", paramIntent2);
      localWXMediaMessage.messageExt = locali.toString();
      ((SendMessageToWX.Req)localObject).message = localWXMediaMessage;
      paramIntent2 = new Bundle();
      ((SendMessageToWX.Req)localObject).toBundle(paramIntent2);
      paramIntent1.putExtra("KSnsUploadFromSkipCompress", true);
      paramIntent1.putExtra("Ksnsupload_appid", "wxa5e0de08d96cc09d");
      paramIntent1.putExtra("Ksnsupload_timeline", paramIntent2);
      paramIntent1.putExtra("KSnsAction", true);
      paramIntent1.putExtra("need_result", true);
      paramIntent1.putExtra("KSnsUploadShowAppName", false);
      AppMethodBeat.o(279563);
      return;
    }
    catch (Exception paramIntent1)
    {
      Log.printErrStackTrace("MicroMsg.SecondCutUtil", (Throwable)paramIntent1, "", new Object[0]);
      AppMethodBeat.o(279563);
    }
  }
  
  public static Intent gH(String paramString, int paramInt)
  {
    AppMethodBeat.i(279543);
    s.u(paramString, "scene");
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("miaojian://createvideo?scene=" + paramString + "&maxDuration=" + paramInt + "&from=1"));
    localIntent.setPackage("com.tencent.phoenix");
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    AppMethodBeat.o(279543);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.l
 * JD-Core Version:    0.7.0.1
 */