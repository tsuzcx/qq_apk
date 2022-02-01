package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.ut.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.ui.TVInfoUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;

public final class k
{
  public static boolean NN(int paramInt)
  {
    return (7 == paramInt) || (6 == paramInt) || (8 == paramInt) || (9 == paramInt) || (10 == paramInt) || (12 == paramInt) || (13 == paramInt);
  }
  
  public static void a(com.tencent.mm.plugin.shake.b.d paramd, final Context paramContext)
  {
    AppMethodBeat.i(28322);
    new ao().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28321);
        k.a(this.xzo, paramContext, false);
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
      com.tencent.mm.plugin.shake.a.iyx.i((Intent)localObject1, paramContext);
      AppMethodBeat.o(28323);
      return;
      localObject1 = paramd.field_username;
      az.ayM();
      localObject2 = c.awB().aNt((String)localObject1);
      if (localObject2 != null)
      {
        Intent localIntent = new Intent();
        if ((com.tencent.mm.n.b.ln(((av)localObject2).field_type)) && (((ai)localObject2).fad()))
        {
          af.aCW().AE((String)localObject1);
          if (paramd.field_distance.equals("1"))
          {
            localIntent.putExtra("Chat_User", (String)localObject1);
            localIntent.putExtra("finish_direct", true);
            com.tencent.mm.plugin.shake.a.iyx.d(localIntent, paramContext);
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
        paramd = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramd.aeD(), "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "handleRedirect", "(Lcom/tencent/mm/plugin/shake/model/ShakeItem;Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramd.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "handleRedirect", "(Lcom/tencent/mm/plugin/shake/model/ShakeItem;Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28323);
        return;
        localObject1 = new ig();
        ((ig)localObject1).dju.actionCode = 11;
        ((ig)localObject1).dju.result = paramd.field_username;
        ((ig)localObject1).dju.context = paramContext;
        ((ig)localObject1).callback = null;
        com.tencent.mm.sdk.b.a.GpY.a((com.tencent.mm.sdk.b.b)localObject1, Looper.myLooper());
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
        if (bs.isNullOrNil(paramContext))
        {
          ac.i("Micromsg.ShakeTVLogic", "gotoAppBrand commField.app_brand_user_name is null");
          AppMethodBeat.o(28323);
          return;
        }
        paramd = new ut();
        paramd.dxt.userName = paramContext;
        paramd.dxt.dxv = bs.bG((String)localObject1, "");
        paramd.dxt.dxw = 0;
        paramd.dxt.scene = 1039;
        paramd.dxt.aBM = i;
        com.tencent.mm.sdk.b.a.GpY.l(paramd);
        ac.i("Micromsg.ShakeTVLogic", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d version:%d", new Object[] { paramd.dxt.userName, paramd.dxt.dxv, Integer.valueOf(paramd.dxt.scene), Integer.valueOf(paramd.dxt.dxw), Integer.valueOf(paramd.dxt.aBM) });
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(28325);
    if (!bs.isNullOrNil(paramString2))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addCategory("android.intent.category.BROWSABLE");
      localIntent.setData(Uri.parse(paramString2));
      int i = 16;
      if ((paramInt == 3) || (paramInt == 4)) {
        i = 17;
      }
      localIntent.putExtra("translate_link_scene", i);
      paramString2 = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString2.aeD(), "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "doShakeTvOpenTempSession", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString2.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "doShakeTvOpenTempSession", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ac.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
      h.wUl.f(12108, new Object[] { bs.nullAsNil(paramString1), Integer.valueOf(paramInt), Integer.valueOf(1) });
      AppMethodBeat.o(28325);
      return;
    }
    AppMethodBeat.o(28325);
  }
  
  public static boolean dDj()
  {
    AppMethodBeat.i(28324);
    if (ab.ivx)
    {
      AppMethodBeat.o(28324);
      return true;
    }
    String str = g.ZY().getValue("ShowShakeTV");
    ac.d("Micromsg.ShakeTVLogic", "DynamicConfig Get ShowShakeTV: %s", new Object[] { str });
    if ((!bs.isNullOrNil(str)) && (str.equals("1")))
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