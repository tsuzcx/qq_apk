package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.hc;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.a.rc.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.ui.TVInfoUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class k
{
  public static void a(com.tencent.mm.plugin.shake.b.d paramd, Context paramContext, boolean paramBoolean)
  {
    int i = 4;
    if (paramd == null) {}
    Object localObject2;
    do
    {
      return;
      switch (paramd.field_type)
      {
      case 11: 
      default: 
        return;
      case 6: 
        localObject1 = paramd.field_username;
        au.Hx();
        localObject2 = c.Fw().abl((String)localObject1);
      }
    } while (localObject2 == null);
    Intent localIntent = new Intent();
    if ((com.tencent.mm.n.a.gR(((ao)localObject2).field_type)) && (((ad)localObject2).cua()))
    {
      z.My().kQ((String)localObject1);
      if (paramd.field_distance.equals("1"))
      {
        localIntent.putExtra("Chat_User", (String)localObject1);
        localIntent.putExtra("finish_direct", true);
        com.tencent.mm.plugin.shake.a.eUR.e(localIntent, paramContext);
        return;
        localObject1 = new Intent();
        i = 18;
        if (paramBoolean) {
          i = 26;
        }
        ((Intent)localObject1).putExtra("geta8key_scene", i);
        ((Intent)localObject1).putExtra("stastic_scene", 6);
        ((Intent)localObject1).putExtra("KAppId", "wxaf060266bfa9a35c");
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("jsapi_args_appid", "wxaf060266bfa9a35c");
        ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
        ((Intent)localObject1).putExtra("rawUrl", paramd.field_username);
        ((Intent)localObject1).putExtra("srcUsername", paramd.field_distance);
        com.tencent.mm.plugin.shake.a.eUR.j((Intent)localObject1, paramContext);
        return;
      }
    }
    localIntent.putExtra("Contact_User", (String)localObject1);
    localIntent.putExtra("force_get_contact", true);
    com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    return;
    Object localObject1 = new Intent();
    ((Intent)localObject1).setClass(paramContext, TVInfoUI.class);
    ((Intent)localObject1).putExtra("key_TV_xml_bytes", paramd.field_lvbuffer);
    ((Intent)localObject1).putExtra("key_TV_come_from_shake", true);
    paramContext.startActivity((Intent)localObject1);
    return;
    localObject1 = new hc();
    ((hc)localObject1).bOW.actionCode = 11;
    ((hc)localObject1).bOW.result = paramd.field_username;
    ((hc)localObject1).bOW.context = paramContext;
    ((hc)localObject1).bFJ = null;
    com.tencent.mm.sdk.b.a.udP.a((b)localObject1, Looper.myLooper());
    return;
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("key_product_id", paramd.field_username);
    ((Intent)localObject1).putExtra("key_product_scene", 9);
    com.tencent.mm.br.d.b(paramContext, "product", ".ui.MallProductUI", (Intent)localObject1);
    return;
    if (paramBoolean) {}
    for (;;)
    {
      a(paramd.field_distance, paramd.field_username, i, paramContext);
      return;
      i = 3;
    }
    paramContext = paramd.field_username;
    localObject1 = paramd.field_reserved3;
    i = paramd.field_reserved2;
    if (bk.bl(paramContext))
    {
      y.i("Micromsg.ShakeTVLogic", "gotoAppBrand commField.app_brand_user_name is null");
      return;
    }
    paramd = new rc();
    paramd.caq.userName = paramContext;
    paramd.caq.cas = bk.aM((String)localObject1, "");
    paramd.caq.cat = 0;
    paramd.caq.scene = 1039;
    paramd.caq.cau = i;
    com.tencent.mm.sdk.b.a.udP.m(paramd);
    y.i("Micromsg.ShakeTVLogic", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d version:%d", new Object[] { paramd.caq.userName, paramd.caq.cas, Integer.valueOf(paramd.caq.scene), Integer.valueOf(paramd.caq.cat), Integer.valueOf(paramd.caq.cau) });
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    if (!bk.bl(paramString2))
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
      y.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
      h.nFQ.f(12108, new Object[] { bk.pm(paramString1), Integer.valueOf(paramInt), Integer.valueOf(1) });
    }
  }
  
  public static boolean bzS()
  {
    if (ae.eSG) {}
    String str;
    do
    {
      return true;
      str = g.AA().getValue("ShowShakeTV");
      y.d("Micromsg.ShakeTVLogic", "DynamicConfig Get ShowShakeTV: %s", new Object[] { str });
    } while ((!bk.bl(str)) && (str.equals("1")));
    return false;
  }
  
  public static boolean xo(int paramInt)
  {
    return (7 == paramInt) || (6 == paramInt) || (8 == paramInt) || (9 == paramInt) || (10 == paramInt) || (12 == paramInt) || (13 == paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.k
 * JD-Core Version:    0.7.0.1
 */