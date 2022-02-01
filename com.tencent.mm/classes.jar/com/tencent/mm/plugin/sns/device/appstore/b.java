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
  private final String QoB;
  private final String QoC;
  private final String QoD;
  private final String QoE;
  
  private b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.QoB = paramString1;
    this.QoC = paramString2;
    this.QoD = paramString3;
    this.QoE = paramString4;
  }
  
  static b J(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(306346);
    paramString1 = new b(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(306346);
    return paramString1;
  }
  
  private static Uri ma(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306365);
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
      AppMethodBeat.o(306365);
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
  
  final Intent heV()
  {
    AppMethodBeat.i(306373);
    try
    {
      Object localObject3 = this.QoB;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        Intent localIntent = new Intent();
        Object localObject1 = this.QoD;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject3 = ma((String)localObject3, (String)localObject1);
        }
        String str;
        do
        {
          localIntent.putExtra("target_app_id", (String)localObject1);
          localIntent.setAction("android.intent.action.VIEW");
          localIntent.setData((Uri)localObject3);
          if (!TextUtils.isEmpty(this.QoC)) {
            localIntent.setPackage(this.QoC);
          }
          if (!TextUtils.isEmpty(this.QoE)) {
            localIntent.putExtra("market_app_name", this.QoE);
          }
          AppMethodBeat.o(306373);
          return localIntent;
          localObject3 = Uri.parse((String)localObject3);
          str = ((Uri)localObject3).getQueryParameter("id");
          localObject1 = str;
        } while (!TextUtils.isEmpty(str));
        AppMethodBeat.o(306373);
        return null;
      }
    }
    finally
    {
      Log.e("MicroMsg.AdAppMarketIntentNode", "there is something wrong in toIntent");
      AppMethodBeat.o(306373);
      return null;
    }
    AppMethodBeat.o(306373);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.b
 * JD-Core Version:    0.7.0.1
 */