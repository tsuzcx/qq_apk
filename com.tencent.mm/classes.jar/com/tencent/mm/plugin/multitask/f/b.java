package com.tencent.mm.plugin.multitask.f;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.ui.e.p;

public final class b
{
  public static void a(Intent paramIntent, aoe paramaoe)
  {
    AppMethodBeat.i(200274);
    Bundle localBundle = new Bundle();
    localBundle.putString("app_type", paramaoe.LzN);
    localBundle.putString("app_media_id", paramaoe.LzO);
    localBundle.putLong("app_msg_id", paramaoe.LzP);
    localBundle.putBoolean("app_show_share", paramaoe.LzQ);
    localBundle.putInt("scene", paramaoe.scene);
    paramIntent.putExtras(localBundle);
    AppMethodBeat.o(200274);
  }
  
  public static void a(Intent paramIntent, fah paramfah)
  {
    AppMethodBeat.i(200271);
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramfah.title);
    localBundle.putString("webpageTitle", paramfah.Nwj);
    localBundle.putBoolean("hide_option_menu", paramfah.Nwk);
    localBundle.putBoolean("translate_webview", paramfah.Nwl);
    localBundle.putString("srcUsername", paramfah.eag);
    localBundle.putString("srcDisplayname", paramfah.eah);
    localBundle.putInt("mode", paramfah.mode);
    localBundle.putString("KTemplateId", paramfah.Nwm);
    localBundle.putString("KPublisherId", paramfah.Nwn);
    localBundle.putInt(e.p.Ozw, paramfah.Nwo);
    localBundle.putInt(e.p.Ozx, paramfah.Nwp);
    localBundle.putInt("pay_channel", paramfah.MLG);
    localBundle.putInt("key_download_restrict", paramfah.Nwq);
    localBundle.putInt("key_wallet_region", paramfah.Nwr);
    localBundle.putString("key_function_id", paramfah.Nws);
    localBundle.putInt(e.p.OzA, paramfah.Nwt);
    localBundle.putInt("geta8key_scene", paramfah.Nwu);
    localBundle.putLong("biz_video_msg_id", paramfah.Nwv);
    localBundle.putInt("biz_video_msg_index", paramfah.Nww);
    localBundle.putLong("biz_video_msg_svr_id", paramfah.Nwx);
    localBundle.putString("biz_mp_msg_info", paramfah.Nwy);
    localBundle.putString(e.p.OzI, paramfah.Nwz);
    localBundle.putBoolean("key_menu_hide_expose", paramfah.NwA);
    localBundle.putString("webviewCurrentProcess", paramfah.NwB);
    localBundle.putString("rawUrl", paramfah.edo);
    paramIntent.putExtras(localBundle);
    AppMethodBeat.o(200271);
  }
  
  public static void a(Bundle paramBundle, aoe paramaoe)
  {
    AppMethodBeat.i(200275);
    if (paramBundle != null)
    {
      paramaoe.LzN = paramBundle.getString("app_type");
      paramaoe.LzO = paramBundle.getString("app_media_id");
      paramaoe.LzP = paramBundle.getLong("app_msg_id");
      paramaoe.LzQ = paramBundle.getBoolean("app_show_share");
      paramaoe.scene = paramBundle.getInt("scene");
      paramaoe.LzL = paramBundle.getBoolean("ifAppAttachDownloadUI");
      paramaoe.filePath = paramBundle.getString("filePath");
      paramaoe.gCr = paramBundle.getString("fileExt");
      paramaoe.appId = paramBundle.getString("appId");
      paramaoe.processName = paramBundle.getString("processName");
      paramaoe.lwF = paramBundle.getBoolean("showMenu");
    }
    AppMethodBeat.o(200275);
  }
  
  public static void a(Bundle paramBundle, fah paramfah)
  {
    AppMethodBeat.i(200273);
    if ((paramfah == null) || (paramBundle == null))
    {
      AppMethodBeat.o(200273);
      return;
    }
    paramfah.title = paramBundle.getString("title");
    paramfah.Nwj = paramBundle.getString("webpageTitle");
    paramfah.Nwk = paramBundle.getBoolean("hide_option_menu");
    paramfah.Nwl = paramBundle.getBoolean("translate_webview");
    paramfah.eag = paramBundle.getString("srcUsername");
    paramfah.eah = paramBundle.getString("srcDisplayname");
    paramfah.mode = paramBundle.getInt("mode");
    paramfah.Nwm = paramBundle.getString("KTemplateId");
    paramfah.Nwn = paramBundle.getString("KPublisherId");
    paramfah.Nwo = paramBundle.getInt(e.p.Ozw);
    paramfah.Nwp = paramBundle.getInt(e.p.Ozx);
    paramfah.MLG = paramBundle.getInt("pay_channel");
    paramfah.Nwq = paramBundle.getInt("key_download_restrict");
    paramfah.Nwr = paramBundle.getInt("key_wallet_region");
    paramfah.Nws = paramBundle.getString("key_function_id");
    paramfah.Nwt = paramBundle.getInt(e.p.OzA, -1);
    paramfah.Nwu = paramBundle.getInt("geta8key_scene");
    paramfah.Nwv = paramBundle.getLong("biz_video_msg_id");
    paramfah.Nww = paramBundle.getInt("biz_video_msg_index");
    paramfah.Nwx = paramBundle.getLong("biz_video_msg_svr_id");
    paramfah.Nwy = paramBundle.getString("biz_mp_msg_info");
    paramfah.Nwz = paramBundle.getString(e.p.OzI);
    paramfah.NwA = paramBundle.getBoolean("key_menu_hide_expose");
    paramfah.NwB = paramBundle.getString("webviewCurrentProcess");
    paramfah.edo = paramBundle.getString("rawUrl");
    AppMethodBeat.o(200273);
  }
  
  public static void b(Intent paramIntent, fah paramfah)
  {
    AppMethodBeat.i(200272);
    a(paramIntent.getExtras(), paramfah);
    AppMethodBeat.o(200272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.f.b
 * JD-Core Version:    0.7.0.1
 */