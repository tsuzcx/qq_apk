package com.tencent.mm.sdk.plugin;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class MMPluginProviderConstants
{
  public static final String AUTHORITY = "com.tencent.mm.sdk.plugin.provider";
  public static final String PLUGIN_PACKAGE_PATTERN = "com.tencent.mm.plugin";
  public static final int TYPE_BOOLEAN = 4;
  public static final int TYPE_DOUBLE = 6;
  public static final int TYPE_FLOAT = 5;
  public static final int TYPE_INT = 1;
  public static final int TYPE_LONG = 2;
  public static final int TYPE_STRING = 3;
  public static final int TYPE_UNKNOWN = 0;
  
  public static class PluginIntent
  {
    public static final String ACCESS_TOKEN = "com.tencent.mm.sdk.plugin.Intent.ACCESS_TOKEN";
    public static final String ACTION_QRCODE_SCANNED = "com.tencent.mm.sdk.plugin.Intent.ACTION_QRCODE_SCANNED";
    public static final String ACTION_REQUEST_TOKEN = "com.tencent.mm.sdk.plugin.Intent.ACTION_REQUEST_TOKEN";
    public static final String ACTION_RESPONSE = "com.tencent.mm.sdk.plugin.Intent.ACTION_RESPONSE";
    public static final String APP_PACKAGE_PATTERN = "com.tencent.mm";
    public static final String AUTH_KEY = "com.tencent.mm.sdk.plugin.Intent.AUTHKEY";
    public static final String NAME = "com.tencent.mm.sdk.plugin.Intent.NAME";
    public static final String PACKAGE = "com.tencent.mm.sdk.plugin.Intent.PACKAGE";
    public static final String PERMISSIONS = "com.tencent.mm.sdk.plugin.Intent.PERMISSIONS";
    public static final String PLUGIN_PACKAGE_PATTERN = "com.tencent.mm.plugin";
    public static final String REQUEST_TOKEN = "com.tencent.mm.sdk.plugin.Intent.REQUEST_TOKEN";
  }
  
  public static final class Resolver
  {
    private static final String TAG = "MicroMsg.SDK.PluginProvider.Resolver";
    
    public static int getType(Object paramObject)
    {
      AppMethodBeat.i(186539);
      if (paramObject == null)
      {
        Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
        AppMethodBeat.o(186539);
        return 0;
      }
      if ((paramObject instanceof Integer))
      {
        AppMethodBeat.o(186539);
        return 1;
      }
      if ((paramObject instanceof Long))
      {
        AppMethodBeat.o(186539);
        return 2;
      }
      if ((paramObject instanceof String))
      {
        AppMethodBeat.o(186539);
        return 3;
      }
      if ((paramObject instanceof Boolean))
      {
        AppMethodBeat.o(186539);
        return 4;
      }
      if ((paramObject instanceof Float))
      {
        AppMethodBeat.o(186539);
        return 5;
      }
      if ((paramObject instanceof Double))
      {
        AppMethodBeat.o(186539);
        return 6;
      }
      Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + paramObject.getClass().toString());
      AppMethodBeat.o(186539);
      return 0;
    }
    
    public static Object resolveObj(int paramInt, String paramString)
    {
      AppMethodBeat.i(186548);
      switch (paramInt)
      {
      }
      try
      {
        Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
        AppMethodBeat.o(186548);
        return null;
        paramString = Integer.valueOf(paramString);
        AppMethodBeat.o(186548);
        return paramString;
        paramString = Long.valueOf(paramString);
        AppMethodBeat.o(186548);
        return paramString;
        AppMethodBeat.o(186548);
        return paramString;
        paramString = Boolean.valueOf(paramString);
        AppMethodBeat.o(186548);
        return paramString;
        paramString = Float.valueOf(paramString);
        AppMethodBeat.o(186548);
        return paramString;
        paramString = Double.valueOf(paramString);
        AppMethodBeat.o(186548);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SDK.PluginProvider.Resolver", paramString, "", new Object[0]);
        }
      }
    }
    
    public static boolean unresolveObj(ContentValues paramContentValues, Object paramObject)
    {
      AppMethodBeat.i(186541);
      int i = getType(paramObject);
      if (i == 0)
      {
        AppMethodBeat.o(186541);
        return false;
      }
      paramContentValues.put("type", Integer.valueOf(i));
      paramContentValues.put("value", paramObject.toString());
      AppMethodBeat.o(186541);
      return true;
    }
  }
  
  public static final class SharedPref
    implements BaseColumns
  {
    public static final Uri CONTENT_URI;
    public static final String KEY = "key";
    public static final String TYPE = "type";
    public static final String VALUE = "value";
    
    static
    {
      AppMethodBeat.i(190318);
      CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
      AppMethodBeat.o(190318);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginProviderConstants
 * JD-Core Version:    0.7.0.1
 */