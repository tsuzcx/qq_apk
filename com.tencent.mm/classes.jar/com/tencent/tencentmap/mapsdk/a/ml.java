package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class ml
{
  private Context a;
  private WeakReference<ml.b> b;
  
  public ml(Context paramContext, ml.b paramb)
  {
    this.a = paramContext;
    this.b = new WeakReference(paramb);
  }
  
  private int a(String paramString, int paramInt)
  {
    paramString = new JSONObject(paramString);
    int i = paramInt;
    if (paramString.optInt("error", -1) == 0)
    {
      paramString = paramString.optJSONObject("info");
      i = paramInt;
      if (paramString != null) {
        i = paramString.optInt("scenic", paramInt);
      }
    }
    return i;
  }
  
  private String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    String str = paramContext.getPackageName();
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
      if (paramContext == null) {
        return "";
      }
      if (paramContext.metaData == null) {
        return "";
      }
      return paramContext.metaData.getString(lq.b);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  public void a()
  {
    new ml.a(this, null).execute(new Context[] { this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ml
 * JD-Core Version:    0.7.0.1
 */