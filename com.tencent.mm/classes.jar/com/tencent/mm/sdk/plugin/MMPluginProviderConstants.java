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
  
  public static final class Resolver
  {
    private static final String TAG = "MicroMsg.SDK.PluginProvider.Resolver";
    
    public static int getType(Object paramObject)
    {
      AppMethodBeat.i(230439);
      if (paramObject == null)
      {
        Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
        AppMethodBeat.o(230439);
        return 0;
      }
      if ((paramObject instanceof Integer))
      {
        AppMethodBeat.o(230439);
        return 1;
      }
      if ((paramObject instanceof Long))
      {
        AppMethodBeat.o(230439);
        return 2;
      }
      if ((paramObject instanceof String))
      {
        AppMethodBeat.o(230439);
        return 3;
      }
      if ((paramObject instanceof Boolean))
      {
        AppMethodBeat.o(230439);
        return 4;
      }
      if ((paramObject instanceof Float))
      {
        AppMethodBeat.o(230439);
        return 5;
      }
      if ((paramObject instanceof Double))
      {
        AppMethodBeat.o(230439);
        return 6;
      }
      Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + paramObject.getClass().toString());
      AppMethodBeat.o(230439);
      return 0;
    }
    
    public static Object resolveObj(int paramInt, String paramString)
    {
      AppMethodBeat.i(230441);
      switch (paramInt)
      {
      }
      try
      {
        Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
        AppMethodBeat.o(230441);
        return null;
        paramString = Integer.valueOf(paramString);
        AppMethodBeat.o(230441);
        return paramString;
        paramString = Long.valueOf(paramString);
        AppMethodBeat.o(230441);
        return paramString;
        AppMethodBeat.o(230441);
        return paramString;
        paramString = Boolean.valueOf(paramString);
        AppMethodBeat.o(230441);
        return paramString;
        paramString = Float.valueOf(paramString);
        AppMethodBeat.o(230441);
        return paramString;
        paramString = Double.valueOf(paramString);
        AppMethodBeat.o(230441);
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
      AppMethodBeat.i(230440);
      int i = getType(paramObject);
      if (i == 0)
      {
        AppMethodBeat.o(230440);
        return false;
      }
      paramContentValues.put("type", Integer.valueOf(i));
      paramContentValues.put("value", paramObject.toString());
      AppMethodBeat.o(230440);
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
      AppMethodBeat.i(230442);
      CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
      AppMethodBeat.o(230442);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginProviderConstants
 * JD-Core Version:    0.7.0.1
 */