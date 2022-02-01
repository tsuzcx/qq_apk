package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;

public final class j
{
  public static String BUILD_TAG;
  public static String COMMAND;
  public static boolean DEBUG;
  public static boolean ENABLE_FPS_ANALYSE;
  public static boolean ENABLE_MATRIX;
  public static boolean ENABLE_MATRIX_TRACE;
  public static boolean EX_DEVICE_LOGIN;
  public static String HOSTNAME;
  public static boolean IS_FLAVOR_BLUE;
  public static boolean IS_FLAVOR_PURPLE;
  public static boolean IS_FLAVOR_RED;
  public static boolean IS_UAT;
  public static int IwD;
  public static final v IwE;
  public static String KINDA_DEFAULT;
  public static String MATRIX_VERSION;
  public static String OWNER;
  public static boolean PRE_RELEASE;
  public static boolean REDESIGN_ENTRANCE;
  public static String REV;
  public static String SVNPATH;
  public static String TIME;
  public static String TINKER_VERSION;
  public static String hju;
  public static boolean hjx;
  
  static
  {
    AppMethodBeat.i(125205);
    IwE = new v();
    AppMethodBeat.o(125205);
  }
  
  public static String info()
  {
    AppMethodBeat.i(125204);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("[b.ver] %s\n", new Object[] { a.lR(hju, a.hju) }));
    localStringBuilder.append(String.format("[tag  ] %s\n", new Object[] { a.lR(BUILD_TAG, a.BUILD_TAG) }));
    localStringBuilder.append(String.format("[by   ] %s\n", new Object[] { a.lR(OWNER, a.OWNER) }));
    localStringBuilder.append(String.format("[host ] %s\n", new Object[] { a.lR(HOSTNAME, a.HOSTNAME) }));
    localStringBuilder.append(String.format("[time ] %s\n", new Object[] { a.lR(TIME, a.TIME) }));
    localStringBuilder.append(String.format("[cmd  ] %s\n", new Object[] { a.lR(COMMAND, a.COMMAND) }));
    localStringBuilder.append(String.format("[path ] %s\n", new Object[] { a.lR(a.lQ(SVNPATH, "MicroMsg_proj"), a.lQ(a.SVNPATH, "MicroMsg_proj")) }));
    localStringBuilder.append(String.format("[rev  ] %s\n", new Object[] { a.lR(REV, a.REV) }));
    if (a.arY())
    {
      str = a.arV();
      localStringBuilder.append(String.format("[p.rev] %s\n", new Object[] { str }));
      if (!hjx) {
        break label329;
      }
    }
    label329:
    for (String str = "arm64-v8a";; str = "armeabi-v7a")
    {
      localStringBuilder.append(String.format("[eabi ] %s\n", new Object[] { str }));
      localStringBuilder.append(String.format("[feature_id] %s\n", new Object[] { IwE.getString("FEATURE_ID") }));
      str = localStringBuilder.toString();
      AppMethodBeat.o(125204);
      return str;
      str = "disabled";
      break;
    }
  }
  
  static final class a
  {
    public static String lQ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(125202);
      if (paramString1 == null)
      {
        AppMethodBeat.o(125202);
        return null;
      }
      int i = paramString1.indexOf(paramString2);
      if (i < 0)
      {
        AppMethodBeat.o(125202);
        return paramString1;
      }
      paramString1 = paramString1.substring(i);
      AppMethodBeat.o(125202);
      return paramString1;
    }
    
    public static String lR(String paramString1, String paramString2)
    {
      AppMethodBeat.i(125203);
      if (paramString1 == null)
      {
        AppMethodBeat.o(125203);
        return null;
      }
      if (paramString1.equals(paramString2))
      {
        AppMethodBeat.o(125203);
        return paramString1;
      }
      paramString1 = String.format("%s(%s)", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(125203);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.j
 * JD-Core Version:    0.7.0.1
 */