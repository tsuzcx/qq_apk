package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static String Lq(int paramInt)
  {
    AppMethodBeat.i(63626);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("subCode", paramInt);
      localObject = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
      AppMethodBeat.o(63626);
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      AppMethodBeat.o(63626);
      return null;
    }
    catch (JSONException localJSONException)
    {
      label39:
      break label39;
    }
  }
  
  public static String akL(String paramString)
  {
    AppMethodBeat.i(63625);
    if (paramString == null)
    {
      AppMethodBeat.o(63625);
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", paramString);
      paramString = URLEncoder.encode(localJSONObject.toString(), "UTF-8");
      AppMethodBeat.o(63625);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ab.e("MicroMsg.WePkgReport", paramString.getMessage());
      AppMethodBeat.o(63625);
      return "";
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.WePkgReport", paramString.getMessage());
      }
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5)
  {
    AppMethodBeat.i(63622);
    ab.d("MicroMsg.WePkgReport", "reportWepkgLogicKv, scene = %s, url = %s, pkgId = %s, version = %s, resultCode = %d, costTime = %d, extInfo = %s", new Object[] { paramString1, paramString2, paramString3, paramString4, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString5 });
    for (;;)
    {
      try
      {
        if (bo.isNullOrNil(paramString5))
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("netType", at.gU(ah.getContext()));
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
        if (!bo.isNullOrNil(paramString2))
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
      h.qsU.e(13980, new Object[] { paramString1, str3, paramString3, paramString4, Long.valueOf(paramLong1), localObject, Long.valueOf(paramLong2) });
      AppMethodBeat.o(63622);
      return;
      localObject = new JSONObject(URLDecoder.decode(paramString5, "UTF-8"));
      ((JSONObject)localObject).put("netType", at.gU(ah.getContext()));
      localObject = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
      paramString5 = (String)localObject;
    }
  }
  
  public static void c(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(63623);
    com.tencent.mm.plugin.wepkg.b.a locala = com.tencent.mm.plugin.wepkg.b.b.dko().akl(paramString1);
    if (locala != null)
    {
      paramString1 = q(new Object[] { paramString1, locala.field_version, Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(0), paramString2, "", locala.field_oldVersion, Integer.valueOf(4), Long.valueOf(paramLong), Integer.valueOf(locala.field_pkgSize) });
      com.tencent.mm.game.report.api.a.ezM.a(new com.tencent.mm.game.report.api.b(14229, paramString1));
    }
    AppMethodBeat.o(63623);
  }
  
  public static String q(Object... paramVarArgs)
  {
    AppMethodBeat.i(63624);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 11)
    {
      localStringBuilder.append(String.valueOf(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(String.valueOf(paramVarArgs[11]));
    paramVarArgs = localStringBuilder.toString();
    AppMethodBeat.o(63624);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.a
 * JD-Core Version:    0.7.0.1
 */