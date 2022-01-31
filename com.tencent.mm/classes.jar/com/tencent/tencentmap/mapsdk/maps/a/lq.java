package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class lq
{
  private Context a;
  private WeakReference<lq.b> b;
  
  public lq(Context paramContext, lq.b paramb)
  {
    AppMethodBeat.i(149203);
    this.a = paramContext;
    this.b = new WeakReference(paramb);
    AppMethodBeat.o(149203);
  }
  
  private int a(String paramString, int paramInt)
  {
    AppMethodBeat.i(149205);
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
    AppMethodBeat.o(149205);
    return i;
  }
  
  private String a(Context paramContext)
  {
    AppMethodBeat.i(149206);
    if (paramContext == null)
    {
      AppMethodBeat.o(149206);
      return "";
    }
    String str = paramContext.getPackageName();
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
      if (paramContext == null)
      {
        AppMethodBeat.o(149206);
        return "";
      }
      if (paramContext.metaData == null)
      {
        AppMethodBeat.o(149206);
        return "";
      }
      paramContext = paramContext.metaData.getString(ka.b);
      AppMethodBeat.o(149206);
      return paramContext;
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
    AppMethodBeat.i(149204);
    new lq.a(this, null).execute(new Context[] { this.a });
    AppMethodBeat.o(149204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lq
 * JD-Core Version:    0.7.0.1
 */