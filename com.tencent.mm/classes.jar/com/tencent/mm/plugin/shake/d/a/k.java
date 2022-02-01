package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.n.e;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.shake.ui.TVInfoUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;

public final class k
{
  public static boolean PX(int paramInt)
  {
    return (7 == paramInt) || (6 == paramInt) || (8 == paramInt) || (9 == paramInt) || (10 == paramInt) || (12 == paramInt) || (13 == paramInt);
  }
  
  public static void a(com.tencent.mm.plugin.shake.b.d paramd, final Context paramContext)
  {
    AppMethodBeat.i(28322);
    new aq().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28321);
        k.a(this.zei, paramContext, false);
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
      com.tencent.mm.plugin.shake.a.iUz.i((Intent)localObject1, paramContext);
      AppMethodBeat.o(28323);
      return;
      localObject1 = paramd.field_username;
      bc.aCg();
      localObject2 = com.tencent.mm.model.c.azF().BH((String)localObject1);
      if (localObject2 != null)
      {
        Intent localIntent = new Intent();
        if ((com.tencent.mm.contact.c.lO(((aw)localObject2).field_type)) && (((an)localObject2).fug()))
        {
          ag.aGp().Ef((String)localObject1);
          if (paramd.field_distance.equals("1"))
          {
            localIntent.putExtra("Chat_User", (String)localObject1);
            localIntent.putExtra("finish_direct", true);
            com.tencent.mm.plugin.shake.a.iUz.d(localIntent, paramContext);
            AppMethodBeat.o(28323);
            return;
          }
        }
        localIntent.putExtra("Contact_User", (String)localObject1);
        localIntent.putExtra("force_get_contact", true);
        com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(28323);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(paramContext, TVInfoUI.class);
        ((Intent)localObject1).putExtra("key_TV_xml_bytes", paramd.field_lvbuffer);
        ((Intent)localObject1).putExtra("key_TV_come_from_shake", true);
        paramd = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramd.ahE(), "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "handleRedirect", "(Lcom/tencent/mm/plugin/shake/model/ShakeItem;Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramd.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "handleRedirect", "(Lcom/tencent/mm/plugin/shake/model/ShakeItem;Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28323);
        return;
        localObject1 = new ip();
        ((ip)localObject1).dwm.actionCode = 11;
        ((ip)localObject1).dwm.result = paramd.field_username;
        ((ip)localObject1).dwm.context = paramContext;
        ((ip)localObject1).callback = null;
        com.tencent.mm.sdk.b.a.IvT.a((b)localObject1, Looper.myLooper());
        AppMethodBeat.o(28323);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_product_id", paramd.field_username);
        ((Intent)localObject1).putExtra("key_product_scene", 9);
        com.tencent.mm.br.d.b(paramContext, "product", ".ui.MallProductUI", (Intent)localObject1);
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
        if (bu.isNullOrNil(paramContext))
        {
          ae.i("Micromsg.ShakeTVLogic", "gotoAppBrand commField.app_brand_user_name is null");
          AppMethodBeat.o(28323);
          return;
        }
        paramd = new vq();
        paramd.dKT.userName = paramContext;
        paramd.dKT.dKV = bu.bI((String)localObject1, "");
        paramd.dKT.dKW = 0;
        paramd.dKT.scene = 1039;
        paramd.dKT.aDD = i;
        com.tencent.mm.sdk.b.a.IvT.l(paramd);
        ae.i("Micromsg.ShakeTVLogic", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d version:%d", new Object[] { paramd.dKT.userName, paramd.dKT.dKV, Integer.valueOf(paramd.dKT.scene), Integer.valueOf(paramd.dKT.dKW), Integer.valueOf(paramd.dKT.aDD) });
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(28325);
    if (!bu.isNullOrNil(paramString2))
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
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString2.ahE(), "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "doShakeTvOpenTempSession", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString2.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "doShakeTvOpenTempSession", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ae.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
      com.tencent.mm.plugin.report.service.g.yxI.f(12108, new Object[] { bu.nullAsNil(paramString1), Integer.valueOf(paramInt), Integer.valueOf(1) });
      AppMethodBeat.o(28325);
      return;
    }
    AppMethodBeat.o(28325);
  }
  
  public static boolean dSj()
  {
    AppMethodBeat.i(28324);
    if (ac.iRy)
    {
      AppMethodBeat.o(28324);
      return true;
    }
    String str = com.tencent.mm.n.g.acL().getValue("ShowShakeTV");
    ae.d("Micromsg.ShakeTVLogic", "DynamicConfig Get ShowShakeTV: %s", new Object[] { str });
    if ((!bu.isNullOrNil(str)) && (str.equals("1")))
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