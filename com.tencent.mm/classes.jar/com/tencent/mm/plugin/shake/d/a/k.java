package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.f;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.vm.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.n.e;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.shake.ui.TVInfoUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;

public final class k
{
  public static boolean Pq(int paramInt)
  {
    return (7 == paramInt) || (6 == paramInt) || (8 == paramInt) || (9 == paramInt) || (10 == paramInt) || (12 == paramInt) || (13 == paramInt);
  }
  
  public static void a(com.tencent.mm.plugin.shake.b.d paramd, final Context paramContext)
  {
    AppMethodBeat.i(28322);
    new ap().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28321);
        k.a(this.yNY, paramContext, false);
        AppMethodBeat.o(28321);
      }
    }, 100L);
    AppMethodBeat.o(28322);
  }
  
  public static void a(com.tencent.mm.plugin.shake.b.d paramd, Context paramContext, boolean paramBoolean)
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
      com.tencent.mm.plugin.shake.a.iRG.i((Intent)localObject1, paramContext);
      AppMethodBeat.o(28323);
      return;
      localObject1 = paramd.field_username;
      ba.aBQ();
      localObject2 = c.azp().Bf((String)localObject1);
      if (localObject2 != null)
      {
        Intent localIntent = new Intent();
        if ((com.tencent.mm.o.b.lM(((aw)localObject2).field_type)) && (((am)localObject2).fqg()))
        {
          ag.aFZ().DD((String)localObject1);
          if (paramd.field_distance.equals("1"))
          {
            localIntent.putExtra("Chat_User", (String)localObject1);
            localIntent.putExtra("finish_direct", true);
            com.tencent.mm.plugin.shake.a.iRG.d(localIntent, paramContext);
            AppMethodBeat.o(28323);
            return;
          }
        }
        localIntent.putExtra("Contact_User", (String)localObject1);
        localIntent.putExtra("force_get_contact", true);
        com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(28323);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(paramContext, TVInfoUI.class);
        ((Intent)localObject1).putExtra("key_TV_xml_bytes", paramd.field_lvbuffer);
        ((Intent)localObject1).putExtra("key_TV_come_from_shake", true);
        paramd = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramd.ahp(), "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "handleRedirect", "(Lcom/tencent/mm/plugin/shake/model/ShakeItem;Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramd.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "handleRedirect", "(Lcom/tencent/mm/plugin/shake/model/ShakeItem;Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28323);
        return;
        localObject1 = new io();
        ((io)localObject1).dvh.actionCode = 11;
        ((io)localObject1).dvh.result = paramd.field_username;
        ((io)localObject1).dvh.context = paramContext;
        ((io)localObject1).callback = null;
        com.tencent.mm.sdk.b.a.IbL.a((com.tencent.mm.sdk.b.b)localObject1, Looper.myLooper());
        AppMethodBeat.o(28323);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_product_id", paramd.field_username);
        ((Intent)localObject1).putExtra("key_product_scene", 9);
        com.tencent.mm.bs.d.b(paramContext, "product", ".ui.MallProductUI", (Intent)localObject1);
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
        if (bt.isNullOrNil(paramContext))
        {
          ad.i("Micromsg.ShakeTVLogic", "gotoAppBrand commField.app_brand_user_name is null");
          AppMethodBeat.o(28323);
          return;
        }
        paramd = new vm();
        paramd.dJF.userName = paramContext;
        paramd.dJF.dJH = bt.bI((String)localObject1, "");
        paramd.dJF.dJI = 0;
        paramd.dJF.scene = 1039;
        paramd.dJF.aDD = i;
        com.tencent.mm.sdk.b.a.IbL.l(paramd);
        ad.i("Micromsg.ShakeTVLogic", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d version:%d", new Object[] { paramd.dJF.userName, paramd.dJF.dJH, Integer.valueOf(paramd.dJF.scene), Integer.valueOf(paramd.dJF.dJI), Integer.valueOf(paramd.dJF.aDD) });
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(28325);
    if (!bt.isNullOrNil(paramString2))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addCategory("android.intent.category.BROWSABLE");
      localIntent.setData(Uri.parse(paramString2));
      int i = 16;
      if ((paramInt == 3) || (paramInt == 4)) {
        i = 17;
      }
      localIntent.putExtra("translate_link_scene", i);
      paramString2 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString2.ahp(), "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "doShakeTvOpenTempSession", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString2.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "doShakeTvOpenTempSession", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ad.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
      com.tencent.mm.plugin.report.service.g.yhR.f(12108, new Object[] { bt.nullAsNil(paramString1), Integer.valueOf(paramInt), Integer.valueOf(1) });
      AppMethodBeat.o(28325);
      return;
    }
    AppMethodBeat.o(28325);
  }
  
  public static boolean dOM()
  {
    AppMethodBeat.i(28324);
    if (ac.iOE)
    {
      AppMethodBeat.o(28324);
      return true;
    }
    String str = com.tencent.mm.n.g.acA().getValue("ShowShakeTV");
    ad.d("Micromsg.ShakeTVLogic", "DynamicConfig Get ShowShakeTV: %s", new Object[] { str });
    if ((!bt.isNullOrNil(str)) && (str.equals("1")))
    {
      AppMethodBeat.o(28324);
      return true;
    }
    AppMethodBeat.o(28324);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.k
 * JD-Core Version:    0.7.0.1
 */