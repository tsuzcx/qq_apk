package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static String Wj(int paramInt)
  {
    AppMethodBeat.i(110785);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("subCode", paramInt);
      localObject = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
      AppMethodBeat.o(110785);
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      AppMethodBeat.o(110785);
      return null;
    }
    catch (JSONException localJSONException)
    {
      label39:
      break label39;
    }
  }
  
  public static String aFx(String paramString)
  {
    AppMethodBeat.i(110784);
    if (paramString == null)
    {
      AppMethodBeat.o(110784);
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", paramString);
      paramString = URLEncoder.encode(localJSONObject.toString(), "UTF-8");
      AppMethodBeat.o(110784);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ac.e("MicroMsg.WePkgReport", paramString.getMessage());
      AppMethodBeat.o(110784);
      return "";
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.WePkgReport", paramString.getMessage());
      }
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5)
  {
    AppMethodBeat.i(110781);
    ac.d("MicroMsg.WePkgReport", "reportWepkgLogicKv, scene = %s, url = %s, pkgId = %s, version = %s, resultCode = %d, costTime = %d, extInfo = %s", new Object[] { paramString1, paramString2, paramString3, paramString4, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString5 });
    for (;;)
    {
      try
      {
        if (bs.isNullOrNil(paramString5))
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("netType", ax.iH(ai.getContext()));
          localObject = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
          paramString5 = (String)localObject;
          localObject = paramString5;
          str3 = paramString2;
        }
      }
      catch (Exception localException1)
      {
        Object localObject;
        String str1 = paramString5;
        str3 = paramString2;
        continue;
      }
      try
      {
        if (!bs.isNullOrNil(paramString2))
        {
          str3 = URLEncoder.encode(paramString2, "UTF-8");
          localObject = paramString5;
        }
      }
      catch (Exception localException2)
      {
        String str2 = paramString5;
        str3 = paramString2;
        continue;
      }
      h.wUl.f(13980, new Object[] { paramString1, str3, paramString3, paramString4, Long.valueOf(paramLong1), localObject, Long.valueOf(paramLong2) });
      AppMethodBeat.o(110781);
      return;
      localObject = new JSONObject(URLDecoder.decode(paramString5, "UTF-8"));
      ((JSONObject)localObject).put("netType", ax.iH(ai.getContext()));
      localObject = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
      paramString5 = (String)localObject;
    }
  }
  
  public static void c(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(110782);
    com.tencent.mm.plugin.wepkg.b.a locala = com.tencent.mm.plugin.wepkg.b.b.eIR().aEV(paramString1);
    if (locala != null)
    {
      paramString1 = t(new Object[] { paramString1, locala.field_version, Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(0), paramString2, "", locala.field_oldVersion, Integer.valueOf(4), Long.valueOf(paramLong), Integer.valueOf(locala.field_pkgSize) });
      com.tencent.mm.game.report.api.a.fYF.a(new com.tencent.mm.game.report.api.b(14229, paramString1));
    }
    AppMethodBeat.o(110782);
  }
  
  public static String t(Object... paramVarArgs)
  {
    AppMethodBeat.i(110783);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 11)
    {
      localStringBuilder.append(String.valueOf(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(String.valueOf(paramVarArgs[11]));
    paramVarArgs = localStringBuilder.toString();
    AppMethodBeat.o(110783);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.a
 * JD-Core Version:    0.7.0.1
 */