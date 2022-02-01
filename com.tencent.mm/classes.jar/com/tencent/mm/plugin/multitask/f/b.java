package com.tencent.mm.plugin.multitask.f;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.fky;
import com.tencent.mm.ui.f.r;

public final class b
{
  public static void a(Intent paramIntent, apf paramapf)
  {
    AppMethodBeat.i(248616);
    Bundle localBundle = new Bundle();
    localBundle.putString("app_type", paramapf.SCm);
    localBundle.putString("app_media_id", paramapf.SCn);
    localBundle.putLong("app_msg_id", paramapf.SCo);
    localBundle.putBoolean("app_show_share", paramapf.SCp);
    localBundle.putInt("scene", paramapf.scene);
    paramIntent.putExtras(localBundle);
    AppMethodBeat.o(248616);
  }
  
  public static void a(Intent paramIntent, fky paramfky)
  {
    AppMethodBeat.i(248613);
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramfky.title);
    localBundle.putString("webpageTitle", paramfky.UJu);
    localBundle.putBoolean("hide_option_menu", paramfky.UJv);
    localBundle.putBoolean("translate_webview", paramfky.UJw);
    localBundle.putString("srcUsername", paramfky.fUd);
    localBundle.putString("srcDisplayname", paramfky.fUe);
    localBundle.putInt("mode", paramfky.mode);
    localBundle.putString("KTemplateId", paramfky.UJx);
    localBundle.putString("KPublisherId", paramfky.UJy);
    localBundle.putInt(f.r.VSK, paramfky.UJz);
    localBundle.putInt(f.r.VSL, paramfky.UJA);
    localBundle.putInt("pay_channel", paramfky.TXB);
    localBundle.putInt("key_download_restrict", paramfky.UJB);
    localBundle.putInt("key_wallet_region", paramfky.UJC);
    localBundle.putString("key_function_id", paramfky.UJD);
    localBundle.putInt(f.r.VSO, paramfky.UJE);
    localBundle.putInt("geta8key_scene", paramfky.UJF);
    localBundle.putString(f.r.VSW, paramfky.UJK);
    localBundle.putBoolean("key_menu_hide_expose", paramfky.UJL);
    localBundle.putString("webviewCurrentProcess", paramfky.UJM);
    localBundle.putString("rawUrl", paramfky.fXu);
    paramIntent.putExtras(localBundle);
    AppMethodBeat.o(248613);
  }
  
  public static void a(Bundle paramBundle, apf paramapf)
  {
    AppMethodBeat.i(248617);
    if (paramBundle != null)
    {
      paramapf.SCm = paramBundle.getString("app_type");
      paramapf.SCn = paramBundle.getString("app_media_id");
      paramapf.SCo = paramBundle.getLong("app_msg_id");
      paramapf.SCp = paramBundle.getBoolean("app_show_share");
      paramapf.scene = paramBundle.getInt("scene");
      paramapf.SCl = paramBundle.getBoolean("ifAppAttachDownloadUI");
      paramapf.filePath = paramBundle.getString("filePath");
      paramapf.jmx = paramBundle.getString("fileExt");
      paramapf.appId = paramBundle.getString("appId");
      paramapf.processName = paramBundle.getString("processName");
      paramapf.orn = paramBundle.getBoolean("showMenu");
    }
    AppMethodBeat.o(248617);
  }
  
  public static void a(Bundle paramBundle, fky paramfky)
  {
    AppMethodBeat.i(248615);
    if ((paramfky == null) || (paramBundle == null))
    {
      AppMethodBeat.o(248615);
      return;
    }
    paramfky.title = paramBundle.getString("title");
    paramfky.UJu = paramBundle.getString("webpageTitle");
    paramfky.UJv = paramBundle.getBoolean("hide_option_menu");
    paramfky.UJw = paramBundle.getBoolean("translate_webview");
    paramfky.fUd = paramBundle.getString("srcUsername");
    paramfky.fUe = paramBundle.getString("srcDisplayname");
    paramfky.mode = paramBundle.getInt("mode");
    paramfky.UJx = paramBundle.getString("KTemplateId");
    paramfky.UJy = paramBundle.getString("KPublisherId");
    paramfky.UJz = paramBundle.getInt(f.r.VSK);
    paramfky.UJA = paramBundle.getInt(f.r.VSL);
    paramfky.TXB = paramBundle.getInt("pay_channel");
    paramfky.UJB = paramBundle.getInt("key_download_restrict");
    paramfky.UJC = paramBundle.getInt("key_wallet_region");
    paramfky.UJD = paramBundle.getString("key_function_id");
    paramfky.UJE = paramBundle.getInt(f.r.VSO, -1);
    paramfky.UJF = paramBundle.getInt("geta8key_scene");
    paramfky.UJK = paramBundle.getString(f.r.VSW);
    paramfky.UJL = paramBundle.getBoolean("key_menu_hide_expose");
    paramfky.UJM = paramBundle.getString("webviewCurrentProcess");
    paramfky.fXu = paramBundle.getString("rawUrl");
    AppMethodBeat.o(248615);
  }
  
  public static void b(Intent paramIntent, fky paramfky)
  {
    AppMethodBeat.i(248614);
    a(paramIntent.getExtras(), paramfky);
    AppMethodBeat.o(248614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.f.b
 * JD-Core Version:    0.7.0.1
 */