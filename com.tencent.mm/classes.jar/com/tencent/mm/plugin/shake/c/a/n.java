package com.tencent.mm.plugin.shake.c.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.a.kw;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.a.zp.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.k.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b;
import com.tencent.mm.plugin.shake.ui.TVInfoUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

public final class n
{
  public static void a(com.tencent.mm.plugin.shake.model.d paramd, Context paramContext, boolean paramBoolean)
  {
    int i = 4;
    AppMethodBeat.i(28323);
    if (paramd == null)
    {
      AppMethodBeat.o(28323);
      return;
    }
    switch (paramd.field_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28323);
      return;
      Object localObject1 = new Intent();
      i = 18;
      if (paramBoolean) {
        i = 26;
      }
      ((Intent)localObject1).putExtra("geta8key_scene", i);
      ((Intent)localObject1).putExtra("stastic_scene", 6);
      ((Intent)localObject1).putExtra("KAppId", "wxaf060266bfa9a35c");
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("jsapi_args_appid", "wxaf060266bfa9a35c");
      ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("rawUrl", paramd.field_username);
      ((Intent)localObject1).putExtra("srcUsername", paramd.field_distance);
      b.pFn.h((Intent)localObject1, paramContext);
      AppMethodBeat.o(28323);
      return;
      localObject1 = paramd.field_username;
      bh.bCz();
      localObject2 = com.tencent.mm.model.c.bzA().JE((String)localObject1);
      if (localObject2 != null)
      {
        Intent localIntent = new Intent();
        if ((com.tencent.mm.contact.d.rs(((az)localObject2).field_type)) && (((au)localObject2).iZC()) && (af.bHf().Mn((String)localObject1) != null) && (paramd.field_distance.equals("1")))
        {
          localIntent.putExtra("Chat_User", (String)localObject1);
          localIntent.putExtra("finish_direct", true);
          b.pFn.d(localIntent, paramContext);
          AppMethodBeat.o(28323);
          return;
        }
        localIntent.putExtra("Contact_User", (String)localObject1);
        localIntent.putExtra("force_get_contact", true);
        com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(28323);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(paramContext, TVInfoUI.class);
        ((Intent)localObject1).putExtra("key_TV_xml_bytes", paramd.field_lvbuffer);
        ((Intent)localObject1).putExtra("key_TV_come_from_shake", true);
        paramd = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramd.aYi(), "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "handleRedirect", "(Lcom/tencent/mm/plugin/shake/model/ShakeItem;Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramd.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "handleRedirect", "(Lcom/tencent/mm/plugin/shake/model/ShakeItem;Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28323);
        return;
        localObject1 = new kw();
        ((kw)localObject1).hMB.actionCode = 11;
        ((kw)localObject1).hMB.result = paramd.field_username;
        ((kw)localObject1).hMB.context = paramContext;
        ((kw)localObject1).callback = null;
        ((kw)localObject1).asyncPublish(Looper.myLooper());
        AppMethodBeat.o(28323);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_product_id", paramd.field_username);
        ((Intent)localObject1).putExtra("key_product_scene", 9);
        com.tencent.mm.br.c.b(paramContext, "product", ".ui.MallProductUI", (Intent)localObject1);
        AppMethodBeat.o(28323);
        return;
        if (paramBoolean) {}
        for (;;)
        {
          a(paramd.field_distance, paramd.field_username, i, paramContext);
          AppMethodBeat.o(28323);
          return;
          i = 3;
        }
        paramContext = paramd.field_username;
        localObject1 = paramd.field_reserved3;
        i = paramd.field_reserved2;
        if (Util.isNullOrNil(paramContext))
        {
          Log.i("Micromsg.ShakeTVLogic", "gotoAppBrand commField.app_brand_user_name is null");
          AppMethodBeat.o(28323);
          return;
        }
        paramd = new zp();
        paramd.icM.userName = paramContext;
        paramd.icM.icO = Util.nullAs((String)localObject1, "");
        paramd.icM.icP = 0;
        paramd.icM.scene = 1039;
        paramd.icM.appVersion = i;
        paramd.publish();
        Log.i("Micromsg.ShakeTVLogic", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d version:%d", new Object[] { paramd.icM.userName, paramd.icM.icO, Integer.valueOf(paramd.icM.scene), Integer.valueOf(paramd.icM.icP), Integer.valueOf(paramd.icM.appVersion) });
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(28325);
    if (!Util.isNullOrNil(paramString2))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addCategory("android.intent.category.BROWSABLE");
      localIntent.setData(Uri.parse(paramString2));
      int i = 16;
      if ((paramInt == 3) || (paramInt == 4)) {
        i = 17;
      }
      localIntent.putExtra("translate_link_scene", i);
      paramString2 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString2.aYi(), "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "doShakeTvOpenTempSession", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString2.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "doShakeTvOpenTempSession", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      Log.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
      h.OAn.b(12108, new Object[] { Util.nullAsNil(paramString1), Integer.valueOf(paramInt), Integer.valueOf(1) });
      AppMethodBeat.o(28325);
      return;
    }
    AppMethodBeat.o(28325);
  }
  
  public static boolean ajg(int paramInt)
  {
    return (7 == paramInt) || (6 == paramInt) || (8 == paramInt) || (9 == paramInt) || (10 == paramInt) || (12 == paramInt) || (13 == paramInt);
  }
  
  public static boolean gXa()
  {
    AppMethodBeat.i(28324);
    if (z.pCd)
    {
      AppMethodBeat.o(28324);
      return true;
    }
    String str = i.aRC().getValue("ShowShakeTV");
    Log.d("Micromsg.ShakeTVLogic", "DynamicConfig Get ShowShakeTV: %s", new Object[] { str });
    if ((!Util.isNullOrNil(str)) && (str.equals("1")))
    {
      AppMethodBeat.o(28324);
      return true;
    }
    AppMethodBeat.o(28324);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.n
 * JD-Core Version:    0.7.0.1
 */