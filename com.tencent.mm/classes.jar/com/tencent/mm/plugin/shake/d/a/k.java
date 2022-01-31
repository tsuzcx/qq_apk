package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.so.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.ui.TVInfoUI;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class k
{
  public static boolean Do(int paramInt)
  {
    return (7 == paramInt) || (6 == paramInt) || (8 == paramInt) || (9 == paramInt) || (10 == paramInt) || (12 == paramInt) || (13 == paramInt);
  }
  
  public static void a(com.tencent.mm.plugin.shake.b.d paramd, Context paramContext)
  {
    AppMethodBeat.i(24652);
    new ak().postDelayed(new k.1(paramd, paramContext), 100L);
    AppMethodBeat.o(24652);
  }
  
  public static void a(com.tencent.mm.plugin.shake.b.d paramd, Context paramContext, boolean paramBoolean)
  {
    int i = 4;
    AppMethodBeat.i(24653);
    if (paramd == null)
    {
      AppMethodBeat.o(24653);
      return;
    }
    switch (paramd.field_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24653);
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
      com.tencent.mm.plugin.shake.a.gmO.i((Intent)localObject1, paramContext);
      AppMethodBeat.o(24653);
      return;
      localObject1 = paramd.field_username;
      aw.aaz();
      localObject2 = c.YA().arw((String)localObject1);
      if (localObject2 != null)
      {
        Intent localIntent = new Intent();
        if ((com.tencent.mm.n.a.je(((aq)localObject2).field_type)) && (((ad)localObject2).dwz()))
        {
          z.afi().rK((String)localObject1);
          if (paramd.field_distance.equals("1"))
          {
            localIntent.putExtra("Chat_User", (String)localObject1);
            localIntent.putExtra("finish_direct", true);
            com.tencent.mm.plugin.shake.a.gmO.d(localIntent, paramContext);
            AppMethodBeat.o(24653);
            return;
          }
        }
        localIntent.putExtra("Contact_User", (String)localObject1);
        localIntent.putExtra("force_get_contact", true);
        com.tencent.mm.bq.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
        AppMethodBeat.o(24653);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(paramContext, TVInfoUI.class);
        ((Intent)localObject1).putExtra("key_TV_xml_bytes", paramd.field_lvbuffer);
        ((Intent)localObject1).putExtra("key_TV_come_from_shake", true);
        paramContext.startActivity((Intent)localObject1);
        AppMethodBeat.o(24653);
        return;
        localObject1 = new hf();
        ((hf)localObject1).cwn.actionCode = 11;
        ((hf)localObject1).cwn.result = paramd.field_username;
        ((hf)localObject1).cwn.context = paramContext;
        ((hf)localObject1).callback = null;
        com.tencent.mm.sdk.b.a.ymk.a((b)localObject1, Looper.myLooper());
        AppMethodBeat.o(24653);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_product_id", paramd.field_username);
        ((Intent)localObject1).putExtra("key_product_scene", 9);
        com.tencent.mm.bq.d.b(paramContext, "product", ".ui.MallProductUI", (Intent)localObject1);
        AppMethodBeat.o(24653);
        return;
        if (paramBoolean) {}
        for (;;)
        {
          a(paramd.field_distance, paramd.field_username, i, paramContext);
          AppMethodBeat.o(24653);
          return;
          i = 3;
        }
        paramContext = paramd.field_username;
        localObject1 = paramd.field_reserved3;
        i = paramd.field_reserved2;
        if (bo.isNullOrNil(paramContext))
        {
          ab.i("Micromsg.ShakeTVLogic", "gotoAppBrand commField.app_brand_user_name is null");
          AppMethodBeat.o(24653);
          return;
        }
        paramd = new so();
        paramd.cIQ.userName = paramContext;
        paramd.cIQ.cIS = bo.bf((String)localObject1, "");
        paramd.cIQ.cIT = 0;
        paramd.cIQ.scene = 1039;
        paramd.cIQ.bDc = i;
        com.tencent.mm.sdk.b.a.ymk.l(paramd);
        ab.i("Micromsg.ShakeTVLogic", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d version:%d", new Object[] { paramd.cIQ.userName, paramd.cIQ.cIS, Integer.valueOf(paramd.cIQ.scene), Integer.valueOf(paramd.cIQ.cIT), Integer.valueOf(paramd.cIQ.bDc) });
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(24655);
    if (!bo.isNullOrNil(paramString2))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addCategory("android.intent.category.BROWSABLE");
      localIntent.setData(Uri.parse(paramString2));
      int i = 16;
      if ((paramInt == 3) || (paramInt == 4)) {
        i = 17;
      }
      localIntent.putExtra("translate_link_scene", i);
      paramContext.startActivity(localIntent);
      ab.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
      h.qsU.e(12108, new Object[] { bo.nullAsNil(paramString1), Integer.valueOf(paramInt), Integer.valueOf(1) });
      AppMethodBeat.o(24655);
      return;
    }
    AppMethodBeat.o(24655);
  }
  
  public static boolean cll()
  {
    AppMethodBeat.i(24654);
    if (ae.gkB)
    {
      AppMethodBeat.o(24654);
      return true;
    }
    String str = g.Nq().getValue("ShowShakeTV");
    ab.d("Micromsg.ShakeTVLogic", "DynamicConfig Get ShowShakeTV: %s", new Object[] { str });
    if ((!bo.isNullOrNil(str)) && (str.equals("1")))
    {
      AppMethodBeat.o(24654);
      return true;
    }
    AppMethodBeat.o(24654);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.k
 * JD-Core Version:    0.7.0.1
 */