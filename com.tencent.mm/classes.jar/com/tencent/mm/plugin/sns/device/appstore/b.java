package com.tencent.mm.plugin.sns.device.appstore;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.Set;

final class b
{
  private final String zuH;
  private final String zuI;
  private final String zuJ;
  private final String zuK;
  
  private b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.zuH = paramString1;
    this.zuI = paramString2;
    this.zuJ = paramString3;
    this.zuK = paramString4;
  }
  
  private static Uri jp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219281);
    paramString1 = Uri.parse(paramString1);
    Object localObject;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = paramString1.getQueryParameterNames();
      if ((localObject == null) || (((Set)localObject).isEmpty()) || (!((Set)localObject).contains("id"))) {
        paramString1 = paramString1.buildUpon().appendQueryParameter("id", paramString2).build();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(219281);
      return paramString1;
      if (!paramString2.equals(paramString1.getQueryParameter("id")))
      {
        Uri.Builder localBuilder = paramString1.buildUpon().clearQuery();
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          if ("id".equals(str1))
          {
            localBuilder.appendQueryParameter("id", paramString2);
          }
          else if (str1 != null)
          {
            String str2 = paramString1.getQueryParameter(str1);
            if (str2 != null) {
              localBuilder.appendQueryParameter(str1, str2);
            }
          }
        }
        paramString1 = localBuilder.build();
      }
    }
  }
  
  static b x(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(219279);
    paramString1 = new b(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(219279);
    return paramString1;
  }
  
  final Intent dWt()
  {
    AppMethodBeat.i(219280);
    try
    {
      Object localObject2 = this.zuH;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        Intent localIntent = new Intent();
        Object localObject1 = this.zuJ;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = jp((String)localObject2, (String)localObject1);
        }
        String str;
        do
        {
          localIntent.putExtra("target_app_id", (String)localObject1);
          localIntent.setAction("android.intent.action.VIEW");
          localIntent.setData((Uri)localObject2);
          if (!TextUtils.isEmpty(this.zuI)) {
            localIntent.setPackage(this.zuI);
          }
          if (!TextUtils.isEmpty(this.zuK)) {
            localIntent.putExtra("market_app_name", this.zuK);
          }
          AppMethodBeat.o(219280);
          return localIntent;
          localObject2 = Uri.parse((String)localObject2);
          str = ((Uri)localObject2).getQueryParameter("id");
          localObject1 = str;
        } while (!TextUtils.isEmpty(str));
        AppMethodBeat.o(219280);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.AdAppMarketIntentNode", "there is something wrong in toIntent");
      AppMethodBeat.o(219280);
      return null;
    }
    AppMethodBeat.o(219280);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.b
 * JD-Core Version:    0.7.0.1
 */