package com.tencent.mm.plugin.multitask.f;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.protocal.protobuf.ghm;
import com.tencent.mm.ui.f.s;

public final class b
{
  public static void a(Intent paramIntent, asy paramasy)
  {
    AppMethodBeat.i(303720);
    Bundle localBundle = new Bundle();
    localBundle.putString("app_type", paramasy.ZDe);
    localBundle.putString("app_media_id", paramasy.ZDf);
    localBundle.putLong("app_msg_id", paramasy.ZDg);
    localBundle.putBoolean("app_show_share", paramasy.ZDh);
    localBundle.putInt("scene", paramasy.scene);
    paramIntent.putExtras(localBundle);
    AppMethodBeat.o(303720);
  }
  
  public static void a(Intent paramIntent, ghm paramghm)
  {
    AppMethodBeat.i(303709);
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramghm.title);
    localBundle.putString("webpageTitle", paramghm.acdC);
    localBundle.putBoolean("hide_option_menu", paramghm.acdD);
    localBundle.putBoolean("translate_webview", paramghm.acdE);
    localBundle.putString("srcUsername", paramghm.iaa);
    localBundle.putString("srcDisplayname", paramghm.iab);
    localBundle.putInt("mode", paramghm.mode);
    localBundle.putString("KTemplateId", paramghm.acdF);
    localBundle.putString("KPublisherId", paramghm.acdG);
    localBundle.putInt("KOpenArticleSceneFromScene", paramghm.acdH);
    localBundle.putInt(f.s.adwT, paramghm.acdI);
    localBundle.putInt("pay_channel", paramghm.abot);
    localBundle.putInt("key_download_restrict", paramghm.acdJ);
    localBundle.putInt("key_wallet_region", paramghm.acdK);
    localBundle.putString("key_function_id", paramghm.acdL);
    localBundle.putInt(f.s.adwW, paramghm.acdM);
    localBundle.putInt("geta8key_scene", paramghm.acdN);
    localBundle.putString(f.s.adxe, paramghm.acdS);
    localBundle.putBoolean("key_menu_hide_expose", paramghm.acdT);
    localBundle.putString("webviewCurrentProcess", paramghm.acdU);
    localBundle.putString("rawUrl", paramghm.idu);
    paramIntent.putExtras(localBundle);
    AppMethodBeat.o(303709);
  }
  
  public static void a(Bundle paramBundle, ghm paramghm)
  {
    AppMethodBeat.i(303715);
    if ((paramghm == null) || (paramBundle == null))
    {
      AppMethodBeat.o(303715);
      return;
    }
    paramghm.title = paramBundle.getString("title");
    paramghm.acdC = paramBundle.getString("webpageTitle");
    paramghm.acdD = paramBundle.getBoolean("hide_option_menu");
    paramghm.acdE = paramBundle.getBoolean("translate_webview");
    paramghm.iaa = paramBundle.getString("srcUsername");
    paramghm.iab = paramBundle.getString("srcDisplayname");
    paramghm.mode = paramBundle.getInt("mode");
    paramghm.acdF = paramBundle.getString("KTemplateId");
    paramghm.acdG = paramBundle.getString("KPublisherId");
    paramghm.acdH = paramBundle.getInt("KOpenArticleSceneFromScene");
    paramghm.acdI = paramBundle.getInt(f.s.adwT);
    paramghm.abot = paramBundle.getInt("pay_channel");
    paramghm.acdJ = paramBundle.getInt("key_download_restrict");
    paramghm.acdK = paramBundle.getInt("key_wallet_region");
    paramghm.acdL = paramBundle.getString("key_function_id");
    paramghm.acdM = paramBundle.getInt(f.s.adwW, -1);
    paramghm.acdN = paramBundle.getInt("geta8key_scene");
    paramghm.acdS = paramBundle.getString(f.s.adxe);
    paramghm.acdT = paramBundle.getBoolean("key_menu_hide_expose");
    paramghm.acdU = paramBundle.getString("webviewCurrentProcess");
    paramghm.idu = paramBundle.getString("rawUrl");
    AppMethodBeat.o(303715);
  }
  
  public static void b(Intent paramIntent, ghm paramghm)
  {
    AppMethodBeat.i(303711);
    a(paramIntent.getExtras(), paramghm);
    AppMethodBeat.o(303711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.f.b
 * JD-Core Version:    0.7.0.1
 */