package com.tencent.mm.plugin.recordvideo.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aq.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/util/SecondCutUtil;", "", "()V", "APPID_SECONDCUT", "", "DOWNLOAD_FROM_SIMPLE_STYLE", "DOWNLOAD_FROM_SNS_HOME", "DOWNLOAD_FROM_VIDEO_CORP", "DOWNLOAD_SECONDCUT_URL", "PACKAGE_NAME_SECONDCUT", "PRE_SCHEMA_SECONDCUT", "PUBLIC_KEY_SECONDCUT", "SCENE_MOMENTS", "TAG", "getSecondCutEditIntent", "Landroid/content/Intent;", "scene", "videoPath", "duration", "", "videoBitrate", "width", "height", "getSecondCutHomeIntent", "getSecondCutSimpleStyleIntent", "extInfo", "takeSecondCutSigh", "", "activity", "Landroid/content/Context;", "intent", "plugin-recordvideo_release"})
public final class i
{
  public static final i Ifo;
  
  static
  {
    AppMethodBeat.i(216208);
    Ifo = new i();
    AppMethodBeat.o(216208);
  }
  
  public static Intent am(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(216207);
    p.k(paramString1, "scene");
    p.k(paramString2, "extInfo");
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("miaojian://createvideo?scene=" + paramString1 + "&miaojianExtInfo=" + paramString2 + "&maxDuration=" + paramInt + "&from=3"));
    localIntent.setPackage("com.tencent.phoenix");
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    AppMethodBeat.o(216207);
    return localIntent;
  }
  
  public static void ax(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(216202);
    p.k(paramContext, "activity");
    p.k(paramIntent, "intent");
    try
    {
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/recordvideo/util/SecondCutUtil", "takeSecondCutSigh", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/recordvideo/util/SecondCutUtil", "takeSecondCutSigh", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if ((paramContext instanceof Activity))
      {
        ((Activity)paramContext).overridePendingTransition(a.a.sight_slide_bottom_in, -1);
        AppMethodBeat.o(216202);
        return;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.SecondCutUtil", "takeSecondCutSigh: error " + paramContext.getMessage());
      AppMethodBeat.o(216202);
    }
  }
  
  public static Intent b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(216205);
    p.k(paramString1, "scene");
    p.k(paramString2, "videoPath");
    Log.i("MicroMsg.SecondCutUtil", "getSecondCutEditIntent >>>videoPath: " + paramString2 + " >>>width: " + paramInt3 + " >>>height: " + paramInt4 + " >>>duration: " + paramInt1 + " >>> videoBitrate: " + paramInt2);
    paramString2 = paramString2.getBytes(d.UTF_8);
    p.j(paramString2, "(this as java.lang.String).getBytes(charset)");
    paramString2 = Base64.encodeToString(paramString2, 10);
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("miaojian://createvideo?scene=" + paramString1 + "&assetPaths=" + paramString2 + "&maxDuration=" + paramInt1 + "&bitrate=" + paramInt2 + "&resolution=" + paramInt3 + ',' + paramInt4 + "&from=2"));
    localIntent.setPackage("com.tencent.phoenix");
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    AppMethodBeat.o(216205);
    return localIntent;
  }
  
  public static Intent fO(String paramString, int paramInt)
  {
    AppMethodBeat.i(216206);
    p.k(paramString, "scene");
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("miaojian://createvideo?scene=" + paramString + "&maxDuration=" + paramInt + "&from=1"));
    localIntent.setPackage("com.tencent.phoenix");
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    AppMethodBeat.o(216206);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.i
 * JD-Core Version:    0.7.0.1
 */