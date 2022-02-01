package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.ui.TVInfoUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class k
{
  public static boolean XA(int paramInt)
  {
    return (7 == paramInt) || (6 == paramInt) || (8 == paramInt) || (9 == paramInt) || (10 == paramInt) || (12 == paramInt) || (13 == paramInt);
  }
  
  public static void a(d paramd, Context paramContext, boolean paramBoolean)
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
      com.tencent.mm.plugin.shake.a.jRt.i((Intent)localObject1, paramContext);
      AppMethodBeat.o(28323);
      return;
      localObject1 = paramd.field_username;
      bg.aVF();
      localObject2 = com.tencent.mm.model.c.aSN().Kn((String)localObject1);
      if (localObject2 != null)
      {
        Intent localIntent = new Intent();
        if ((com.tencent.mm.contact.c.oR(((ax)localObject2).field_type)) && (((as)localObject2).gBM()))
        {
          ag.bah().MT((String)localObject1);
          if (paramd.field_distance.equals("1"))
          {
            localIntent.putExtra("Chat_User", (String)localObject1);
            localIntent.putExtra("finish_direct", true);
            com.tencent.mm.plugin.shake.a.jRt.d(localIntent, paramContext);
            AppMethodBeat.o(28323);
            return;
          }
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
        paramd = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramd.axQ(), "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "handleRedirect", "(Lcom/tencent/mm/plugin/shake/model/ShakeItem;Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramd.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "handleRedirect", "(Lcom/tencent/mm/plugin/shake/model/ShakeItem;Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28323);
        return;
        localObject1 = new je();
        ((je)localObject1).dNT.actionCode = 11;
        ((je)localObject1).dNT.result = paramd.field_username;
        ((je)localObject1).dNT.context = paramContext;
        ((je)localObject1).callback = null;
        EventCenter.instance.asyncPublish((IEvent)localObject1, Looper.myLooper());
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
        paramd = new wq();
        paramd.ecI.userName = paramContext;
        paramd.ecI.ecK = Util.nullAs((String)localObject1, "");
        paramd.ecI.ecL = 0;
        paramd.ecI.scene = 1039;
        paramd.ecI.appVersion = i;
        EventCenter.instance.publish(paramd);
        Log.i("Micromsg.ShakeTVLogic", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d version:%d", new Object[] { paramd.ecI.userName, paramd.ecI.ecK, Integer.valueOf(paramd.ecI.scene), Integer.valueOf(paramd.ecI.ecL), Integer.valueOf(paramd.ecI.appVersion) });
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
      paramString2 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString2.axQ(), "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "doShakeTvOpenTempSession", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString2.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "doShakeTvOpenTempSession", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      Log.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
      com.tencent.mm.plugin.report.service.h.CyF.a(12108, new Object[] { Util.nullAsNil(paramString1), Integer.valueOf(paramInt), Integer.valueOf(1) });
      AppMethodBeat.o(28325);
      return;
    }
    AppMethodBeat.o(28325);
  }
  
  public static boolean eUk()
  {
    AppMethodBeat.i(28324);
    if (ac.jOt)
    {
      AppMethodBeat.o(28324);
      return true;
    }
    String str = com.tencent.mm.n.h.aqJ().getValue("ShowShakeTV");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.k
 * JD-Core Version:    0.7.0.1
 */