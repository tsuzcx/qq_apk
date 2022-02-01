package com.tencent.mm.plugin.order.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
{
  public static void a(Boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(66845);
    if (paramBoolean.booleanValue())
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11030, new Object[] { paramString1, "", paramString3, paramString4 });
      AppMethodBeat.o(66845);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(11030, new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(66845);
  }
  
  private static HashMap<String, String> aRk(String paramString)
  {
    AppMethodBeat.i(66841);
    if (paramString == null)
    {
      AppMethodBeat.o(66841);
      return null;
    }
    int i = paramString.indexOf("action");
    if (i <= 0)
    {
      AppMethodBeat.o(66841);
      return null;
    }
    paramString = paramString.substring(i, paramString.length());
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66841);
      return null;
    }
    paramString = paramString.split("&");
    if (paramString == null)
    {
      AppMethodBeat.o(66841);
      return null;
    }
    HashMap localHashMap = new HashMap();
    i = 0;
    while (i < paramString.length)
    {
      String[] arrayOfString = paramString[i].split("=");
      if ((arrayOfString != null) && (arrayOfString.length == 2)) {
        localHashMap.put(arrayOfString[0], arrayOfString[1]);
      }
      i += 1;
    }
    AppMethodBeat.o(66841);
    return localHashMap;
  }
  
  public static boolean bA(Context paramContext, String paramString)
  {
    AppMethodBeat.i(66842);
    Log.v("MicroMsg.MallUtil", "jumpToUrl:".concat(String.valueOf(paramString)));
    Intent localIntent = new Intent();
    HashMap localHashMap = aRk(paramString);
    if ((localHashMap != null) && (!localHashMap.isEmpty()))
    {
      paramString = (String)localHashMap.get("action");
      if ((TextUtils.isEmpty(paramString)) || (!isNumeric(paramString)))
      {
        Log.e("MicroMsg.MallUtil", "jumpToUrl illegal action:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(66842);
        return false;
      }
      switch (Util.getInt(paramString, 0))
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66842);
      return true;
      localIntent.putExtra("rawUrl", (String)localHashMap.get("3rdurl"));
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("pay_channel", 1);
      i.aS(paramContext, localIntent);
      continue;
      i.an(paramContext, (String)localHashMap.get("username"));
      continue;
      localIntent.putExtra("key_func_id", (String)localHashMap.get("functionid"));
      localIntent.putExtra("key_scene", 1);
      boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXg, true);
      Log.i("MicroMsg.MallUtil", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.br.c.b(paramContext, "mall", ".ui.MallIndexUIv2", localIntent);
      }
      else
      {
        com.tencent.mm.br.c.b(paramContext, "mall", ".ui.MallIndexUI", localIntent);
        continue;
        localIntent.putExtra("key_product_id", (String)localHashMap.get("productid"));
        localIntent.putExtra("key_product_scene", 5);
        com.tencent.mm.br.c.b(paramContext, "product", ".ui.MallProductUI", localIntent);
        continue;
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        bC(paramContext, paramString);
      }
    }
    Log.e("MicroMsg.MallUtil", "jumpToUrl illegal url:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(66842);
    return false;
  }
  
  public static void bB(Context paramContext, String paramString)
  {
    AppMethodBeat.i(66843);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66843);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_product_id", paramString);
    localIntent.putExtra("key_product_scene", 5);
    com.tencent.mm.br.c.b(paramContext, "product", ".ui.MallProductUI", localIntent);
    AppMethodBeat.o(66843);
  }
  
  public static void bC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(66844);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("pay_channel", 1);
    i.aS(paramContext, localIntent);
    AppMethodBeat.o(66844);
  }
  
  public static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(66840);
    boolean bool = Pattern.compile("[0-9]*").matcher(paramString).matches();
    AppMethodBeat.o(66840);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.c.c
 * JD-Core Version:    0.7.0.1
 */