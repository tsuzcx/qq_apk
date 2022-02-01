package com.tencent.mm.plugin.sns.ad;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import org.xwalk.core.Log;

public final class d
{
  public static int PKV = 0;
  public static int PKW = 0;
  public static int PKX = 0;
  public static int PKY = 0;
  
  public static void bM(Context paramContext, String paramString)
  {
    AppMethodBeat.i(309652);
    Log.i("SnsAdTestConfig", "handleCmd, msg=".concat(String.valueOf(paramString)));
    String str2;
    String str1;
    int i;
    try
    {
      String[] arrayOfString = paramString.split(" ");
      paramString = "";
      String str3 = "";
      str2 = str3;
      str1 = paramString;
      if (arrayOfString != null)
      {
        if (arrayOfString.length >= 2) {
          paramString = arrayOfString[1].trim();
        }
        str2 = str3;
        str1 = paramString;
        if (arrayOfString.length >= 3)
        {
          str2 = arrayOfString[2];
          str1 = paramString;
        }
      }
      boolean bool = TextUtils.isEmpty(str1);
      if (bool)
      {
        AppMethodBeat.o(309652);
        return;
      }
      Log.i("SnsAdTestConfig", "handleSubCmd, subCmd=" + str1 + ", value=" + str2);
      if (!"fullcard_online".equals(str1)) {
        break label265;
      }
      i = Util.safeParseInt(str2);
      if ((i == 0) || (i == 1) || (i == 2)) {
        PKV = i;
      }
      if (PKV == 0)
      {
        Toast.makeText(paramContext, "default cfg", 1).show();
        AppMethodBeat.o(309652);
        return;
      }
    }
    finally
    {
      Log.e("SnsAdTestConfig", "handleCmd, exp=" + paramContext.toString());
      AppMethodBeat.o(309652);
      return;
    }
    if (PKV == 1)
    {
      Toast.makeText(paramContext, "force offline", 1).show();
      AppMethodBeat.o(309652);
      return;
    }
    if (PKV == 2) {
      Toast.makeText(paramContext, "force online", 1).show();
    }
    AppMethodBeat.o(309652);
    return;
    label265:
    if ("fullcard_new_item".equals(str1))
    {
      i = Util.safeParseInt(str2);
      if ((i == 0) || (i == 1) || (i == 2)) {
        PKW = i;
      }
      if (PKW == 0)
      {
        Toast.makeText(paramContext, "default cfg", 1).show();
        AppMethodBeat.o(309652);
        return;
      }
      if (PKW == 1)
      {
        Toast.makeText(paramContext, "force old item", 1).show();
        AppMethodBeat.o(309652);
        return;
      }
      if (PKW == 2) {
        Toast.makeText(paramContext, "force new item", 1).show();
      }
      AppMethodBeat.o(309652);
      return;
    }
    if ("useTp".equals(str1))
    {
      i = Util.safeParseInt(str2);
      if ((i == 0) || (i == 1) || (i == 2)) {
        PKX = i;
      }
      if (PKX == 0)
      {
        Toast.makeText(paramContext, "default cfg", 1).show();
        AppMethodBeat.o(309652);
        return;
      }
      if (PKX == 1)
      {
        Toast.makeText(paramContext, "force not thumbPlayer", 1).show();
        AppMethodBeat.o(309652);
        return;
      }
      if (PKX == 2) {
        Toast.makeText(paramContext, "force thumbPlayer", 1).show();
      }
      AppMethodBeat.o(309652);
      return;
    }
    if ("notCheckAtBtn".equals(str1))
    {
      i = Util.safeParseInt(str2);
      if ((i == 0) || (i == 1)) {
        PKY = i;
      }
      if (PKY == 0)
      {
        Toast.makeText(paramContext, "should check at btn", 1).show();
        AppMethodBeat.o(309652);
        return;
      }
      if (PKY == 1) {
        Toast.makeText(paramContext, "not check at btn", 1).show();
      }
    }
    AppMethodBeat.o(309652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d
 * JD-Core Version:    0.7.0.1
 */