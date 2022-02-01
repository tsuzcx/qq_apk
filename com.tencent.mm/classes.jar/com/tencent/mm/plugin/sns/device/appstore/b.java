package com.tencent.mm.plugin.sns.device.appstore;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Set;

final class b
{
  private final String DET;
  private final String DEU;
  private final String DEW;
  private final String DEX;
  
  private b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.DET = paramString1;
    this.DEU = paramString2;
    this.DEW = paramString3;
    this.DEX = paramString4;
  }
  
  static b B(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(202640);
    paramString1 = new b(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(202640);
    return paramString1;
  }
  
  private static Uri kc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202642);
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
      AppMethodBeat.o(202642);
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
  
  final Intent eZB()
  {
    AppMethodBeat.i(202641);
    try
    {
      Object localObject2 = this.DET;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        Intent localIntent = new Intent();
        Object localObject1 = this.DEW;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = kc((String)localObject2, (String)localObject1);
        }
        String str;
        do
        {
          localIntent.putExtra("target_app_id", (String)localObject1);
          localIntent.setAction("android.intent.action.VIEW");
          localIntent.setData((Uri)localObject2);
          if (!TextUtils.isEmpty(this.DEU)) {
            localIntent.setPackage(this.DEU);
          }
          if (!TextUtils.isEmpty(this.DEX)) {
            localIntent.putExtra("market_app_name", this.DEX);
          }
          AppMethodBeat.o(202641);
          return localIntent;
          localObject2 = Uri.parse((String)localObject2);
          str = ((Uri)localObject2).getQueryParameter("id");
          localObject1 = str;
        } while (!TextUtils.isEmpty(str));
        AppMethodBeat.o(202641);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AdAppMarketIntentNode", "there is something wrong in toIntent");
      AppMethodBeat.o(202641);
      return null;
    }
    AppMethodBeat.o(202641);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.b
 * JD-Core Version:    0.7.0.1
 */