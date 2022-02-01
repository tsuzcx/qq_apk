package io.flutter.embedding.engine.loader;

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

public final class ApplicationInfoLoader
{
  public static final String NETWORK_POLICY_METADATA_KEY = "io.flutter.network-policy";
  public static final String PUBLIC_AOT_SHARED_LIBRARY_NAME;
  public static final String PUBLIC_FLUTTER_ASSETS_DIR_KEY;
  public static final String PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY;
  public static final String PUBLIC_VM_SNAPSHOT_DATA_KEY;
  
  static
  {
    AppMethodBeat.i(190149);
    PUBLIC_AOT_SHARED_LIBRARY_NAME = FlutterLoader.class.getName() + '.' + "aot-shared-library-name";
    PUBLIC_VM_SNAPSHOT_DATA_KEY = FlutterLoader.class.getName() + '.' + "vm-snapshot-data";
    PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY = FlutterLoader.class.getName() + '.' + "isolate-snapshot-data";
    PUBLIC_FLUTTER_ASSETS_DIR_KEY = FlutterLoader.class.getName() + '.' + "flutter-assets-dir";
    AppMethodBeat.o(190149);
  }
  
  private static ApplicationInfo getApplicationInfo(Context paramContext)
  {
    AppMethodBeat.i(190083);
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      AppMethodBeat.o(190083);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(190083);
      throw paramContext;
    }
  }
  
  /* Error */
  private static String getNetworkPolicy(ApplicationInfo paramApplicationInfo, Context paramContext)
  {
    // Byte code:
    //   0: ldc 96
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 102	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +10 -> 21
    //   14: ldc 96
    //   16: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_0
    //   22: ldc 8
    //   24: iconst_0
    //   25: invokevirtual 108	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   28: istore_2
    //   29: iload_2
    //   30: ifgt +10 -> 40
    //   33: ldc 96
    //   35: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aconst_null
    //   39: areturn
    //   40: new 110	org/json/JSONArray
    //   43: dup
    //   44: invokespecial 111	org/json/JSONArray:<init>	()V
    //   47: astore_0
    //   48: aload_1
    //   49: invokevirtual 115	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   52: iload_2
    //   53: invokevirtual 121	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   56: astore_1
    //   57: aload_1
    //   58: invokeinterface 127 1 0
    //   63: pop
    //   64: aload_1
    //   65: invokeinterface 130 1 0
    //   70: istore_2
    //   71: iload_2
    //   72: iconst_1
    //   73: if_icmpeq +46 -> 119
    //   76: iload_2
    //   77: iconst_2
    //   78: if_icmpne +23 -> 101
    //   81: aload_1
    //   82: invokeinterface 131 1 0
    //   87: ldc 133
    //   89: invokevirtual 139	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifeq +9 -> 101
    //   95: aload_1
    //   96: aload_0
    //   97: iconst_0
    //   98: invokestatic 143	io/flutter/embedding/engine/loader/ApplicationInfoLoader:parseDomainConfig	(Landroid/content/res/XmlResourceParser;Lorg/json/JSONArray;Z)V
    //   101: aload_1
    //   102: invokeinterface 127 1 0
    //   107: istore_2
    //   108: goto -37 -> 71
    //   111: astore_0
    //   112: ldc 96
    //   114: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aconst_null
    //   118: areturn
    //   119: aload_0
    //   120: invokevirtual 144	org/json/JSONArray:toString	()Ljava/lang/String;
    //   123: astore_0
    //   124: ldc 96
    //   126: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static String getString(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(190091);
    if (paramBundle == null)
    {
      AppMethodBeat.o(190091);
      return null;
    }
    paramBundle = paramBundle.getString(paramString, null);
    AppMethodBeat.o(190091);
    return paramBundle;
  }
  
  public static FlutterApplicationInfo load(Context paramContext)
  {
    AppMethodBeat.i(190136);
    ApplicationInfo localApplicationInfo = getApplicationInfo(paramContext);
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }
    paramContext = new FlutterApplicationInfo(getString(localApplicationInfo.metaData, PUBLIC_AOT_SHARED_LIBRARY_NAME), getString(localApplicationInfo.metaData, PUBLIC_VM_SNAPSHOT_DATA_KEY), getString(localApplicationInfo.metaData, PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY), getString(localApplicationInfo.metaData, PUBLIC_FLUTTER_ASSETS_DIR_KEY), getNetworkPolicy(localApplicationInfo, paramContext), localApplicationInfo.nativeLibraryDir, bool);
    AppMethodBeat.o(190136);
    return paramContext;
  }
  
  private static void parseDomain(XmlResourceParser paramXmlResourceParser, JSONArray paramJSONArray, boolean paramBoolean)
  {
    AppMethodBeat.i(190125);
    boolean bool = paramXmlResourceParser.getAttributeBooleanValue(null, "includeSubdomains", false);
    paramXmlResourceParser.next();
    if (paramXmlResourceParser.getEventType() != 4)
    {
      paramXmlResourceParser = new IllegalStateException("Expected text");
      AppMethodBeat.o(190125);
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
      AppMethodBeat.o(190125);
      throw paramXmlResourceParser;
    }
    AppMethodBeat.o(190125);
  }
  
  private static void parseDomainConfig(XmlResourceParser paramXmlResourceParser, JSONArray paramJSONArray, boolean paramBoolean)
  {
    AppMethodBeat.i(190106);
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
        if (paramXmlResourceParser.getName().equals("domain")) {
          parseDomain(paramXmlResourceParser, paramJSONArray, paramBoolean);
        } else if (paramXmlResourceParser.getName().equals("domain-config")) {
          parseDomainConfig(paramXmlResourceParser, paramJSONArray, paramBoolean);
        } else {
          skipTag(paramXmlResourceParser);
        }
      }
    } while (i != 3);
    AppMethodBeat.o(190106);
  }
  
  private static void skipTag(XmlResourceParser paramXmlResourceParser)
  {
    AppMethodBeat.i(190116);
    String str = paramXmlResourceParser.getName();
    for (int i = paramXmlResourceParser.getEventType(); (i != 3) || (paramXmlResourceParser.getName() != str); i = paramXmlResourceParser.next()) {}
    AppMethodBeat.o(190116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.ApplicationInfoLoader
 * JD-Core Version:    0.7.0.1
 */