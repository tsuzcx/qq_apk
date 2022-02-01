package io.flutter.embedding.engine.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;

public final class a
{
  public static final String aare;
  public static final String aarf;
  public static final String aarg;
  public static final String aarh;
  
  static
  {
    AppMethodBeat.i(255507);
    aare = c.class.getName() + '.' + "aot-shared-library-name";
    aarf = c.class.getName() + '.' + "vm-snapshot-data";
    aarg = c.class.getName() + '.' + "isolate-snapshot-data";
    aarh = c.class.getName() + '.' + "flutter-assets-dir";
    AppMethodBeat.o(255507);
  }
  
  private static ApplicationInfo X(Context paramContext)
  {
    AppMethodBeat.i(255495);
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      AppMethodBeat.o(255495);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(255495);
      throw paramContext;
    }
  }
  
  /* Error */
  private static String a(ApplicationInfo paramApplicationInfo, Context paramContext)
  {
    // Byte code:
    //   0: ldc 93
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 99	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +10 -> 21
    //   14: ldc 93
    //   16: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_0
    //   22: ldc 101
    //   24: iconst_0
    //   25: invokevirtual 107	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   28: istore_2
    //   29: iload_2
    //   30: ifgt +10 -> 40
    //   33: ldc 93
    //   35: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aconst_null
    //   39: areturn
    //   40: new 109	org/json/JSONArray
    //   43: dup
    //   44: invokespecial 110	org/json/JSONArray:<init>	()V
    //   47: astore_0
    //   48: aload_1
    //   49: invokevirtual 114	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   52: iload_2
    //   53: invokevirtual 120	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   56: astore_1
    //   57: aload_1
    //   58: invokeinterface 126 1 0
    //   63: pop
    //   64: aload_1
    //   65: invokeinterface 129 1 0
    //   70: istore_2
    //   71: iload_2
    //   72: iconst_1
    //   73: if_icmpeq +46 -> 119
    //   76: iload_2
    //   77: iconst_2
    //   78: if_icmpne +23 -> 101
    //   81: aload_1
    //   82: invokeinterface 130 1 0
    //   87: ldc 132
    //   89: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifeq +9 -> 101
    //   95: aload_1
    //   96: aload_0
    //   97: iconst_0
    //   98: invokestatic 141	io/flutter/embedding/engine/a/a:a	(Landroid/content/res/XmlResourceParser;Lorg/json/JSONArray;Z)V
    //   101: aload_1
    //   102: invokeinterface 126 1 0
    //   107: istore_2
    //   108: goto -37 -> 71
    //   111: astore_0
    //   112: ldc 93
    //   114: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aconst_null
    //   118: areturn
    //   119: aload_0
    //   120: invokevirtual 142	org/json/JSONArray:toString	()Ljava/lang/String;
    //   123: astore_0
    //   124: ldc 93
    //   126: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_0
    //   130: areturn
    //   131: astore_0
    //   132: goto -20 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramApplicationInfo	ApplicationInfo
    //   0	135	1	paramContext	Context
    //   28	80	2	i	int
    // Exception table:
    //   from	to	target	type
    //   48	71	111	org/xmlpull/v1/XmlPullParserException
    //   81	101	111	org/xmlpull/v1/XmlPullParserException
    //   101	108	111	org/xmlpull/v1/XmlPullParserException
    //   48	71	131	java/io/IOException
    //   81	101	131	java/io/IOException
    //   101	108	131	java/io/IOException
  }
  
  private static void a(XmlResourceParser paramXmlResourceParser)
  {
    AppMethodBeat.i(255503);
    String str = paramXmlResourceParser.getName();
    for (int i = paramXmlResourceParser.getEventType(); (i != 3) || (paramXmlResourceParser.getName() != str); i = paramXmlResourceParser.next()) {}
    AppMethodBeat.o(255503);
  }
  
  private static void a(XmlResourceParser paramXmlResourceParser, JSONArray paramJSONArray, boolean paramBoolean)
  {
    AppMethodBeat.i(255501);
    paramBoolean = paramXmlResourceParser.getAttributeBooleanValue(null, "cleartextTrafficPermitted", paramBoolean);
    int i;
    do
    {
      for (;;)
      {
        i = paramXmlResourceParser.next();
        if (i != 2) {
          break;
        }
        if (paramXmlResourceParser.getName().equals("domain"))
        {
          boolean bool = paramXmlResourceParser.getAttributeBooleanValue(null, "includeSubdomains", false);
          paramXmlResourceParser.next();
          if (paramXmlResourceParser.getEventType() != 4)
          {
            paramXmlResourceParser = new IllegalStateException("Expected text");
            AppMethodBeat.o(255501);
            throw paramXmlResourceParser;
          }
          String str = paramXmlResourceParser.getText().trim();
          JSONArray localJSONArray = new JSONArray();
          localJSONArray.put(str);
          localJSONArray.put(bool);
          localJSONArray.put(paramBoolean);
          paramJSONArray.put(localJSONArray);
          paramXmlResourceParser.next();
          if (paramXmlResourceParser.getEventType() != 3)
          {
            paramXmlResourceParser = new IllegalStateException("Expected end of domain tag");
            AppMethodBeat.o(255501);
            throw paramXmlResourceParser;
          }
        }
        else if (paramXmlResourceParser.getName().equals("domain-config"))
        {
          a(paramXmlResourceParser, paramJSONArray, paramBoolean);
        }
        else
        {
          a(paramXmlResourceParser);
        }
      }
    } while (i != 3);
    AppMethodBeat.o(255501);
  }
  
  private static String getString(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(255497);
    if (paramBundle == null)
    {
      AppMethodBeat.o(255497);
      return null;
    }
    paramBundle = paramBundle.getString(paramString, null);
    AppMethodBeat.o(255497);
    return paramBundle;
  }
  
  public static b mK(Context paramContext)
  {
    AppMethodBeat.i(255504);
    ApplicationInfo localApplicationInfo = X(paramContext);
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }
    paramContext = new b(getString(localApplicationInfo.metaData, aare), getString(localApplicationInfo.metaData, aarf), getString(localApplicationInfo.metaData, aarg), getString(localApplicationInfo.metaData, aarh), a(localApplicationInfo, paramContext), localApplicationInfo.nativeLibraryDir, bool);
    AppMethodBeat.o(255504);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.a.a
 * JD-Core Version:    0.7.0.1
 */