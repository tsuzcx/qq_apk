package com.tencent.mm.plugin.recordvideo.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/util/SecondCutUtil;", "", "()V", "APPID_SECONDCUT", "", "DOWNLOAD_FROM_SNS_HOME", "DOWNLOAD_FROM_VIDEO_CORP", "DOWNLOAD_SECONDCUT_URL", "PACKAGE_NAME_SECONDCUT", "PRE_SCHEMA_SECONDCUT", "PUBLIC_KEY_SECONDCUT", "SCENE_MOMENTS", "TAG", "getSecondCutEditIntent", "Landroid/content/Intent;", "scene", "videoPath", "duration", "", "videoBitrate", "width", "height", "getSecondCutHomeIntent", "takeSecondCutSigh", "", "activity", "Landroid/content/Context;", "intent", "plugin-recordvideo_release"})
public final class h
{
  public static final h Cix;
  
  static
  {
    AppMethodBeat.i(238005);
    Cix = new h();
    AppMethodBeat.o(238005);
  }
  
  public static void ao(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(238002);
    p.h(paramContext, "activity");
    p.h(paramIntent, "intent");
    try
    {
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/recordvideo/util/SecondCutUtil", "takeSecondCutSigh", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/recordvideo/util/SecondCutUtil", "takeSecondCutSigh", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if ((paramContext instanceof Activity))
      {
        ((Activity)paramContext).overridePendingTransition(2130772161, -1);
        AppMethodBeat.o(238002);
        return;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.SecondCutUtil", "takeSecondCutSigh: error " + paramContext.getMessage());
      AppMethodBeat.o(238002);
    }
  }
  
  public static Intent b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(238003);
    p.h(paramString1, "scene");
    p.h(paramString2, "videoPath");
    Log.i("MicroMsg.SecondCutUtil", "getSecondCutEditIntent >>>videoPath: " + paramString2 + " >>>width: " + paramInt3 + " >>>height: " + paramInt4 + " >>>duration: " + paramInt1 + " >>> videoBitrate: " + paramInt2);
    paramString2 = paramString2.getBytes(d.UTF_8);
    p.g(paramString2, "(this as java.lang.String).getBytes(charset)");
    paramString2 = Base64.encodeToString(paramString2, 10);
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("miaojian://createvideo?scene=" + paramString1 + "&assetPaths=" + paramString2 + "&maxDuration=" + paramInt1 + "&bitrate=" + paramInt2 + "&resolution=" + paramInt3 + ',' + paramInt4 + "&from=2"));
    localIntent.setPackage("com.tencent.phoenix");
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    AppMethodBeat.o(238003);
    return localIntent;
  }
  
  public static Intent fm(String paramString, int paramInt)
  {
    AppMethodBeat.i(238004);
    p.h(paramString, "scene");
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("miaojian://createvideo?scene=" + paramString + "&maxDuration=" + paramInt + "&from=1"));
    localIntent.setPackage("com.tencent.phoenix");
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    AppMethodBeat.o(238004);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.h
 * JD-Core Version:    0.7.0.1
 */