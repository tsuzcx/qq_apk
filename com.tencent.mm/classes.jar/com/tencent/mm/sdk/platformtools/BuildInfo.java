package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;

public class BuildInfo
{
  public static String BUILD_TAG;
  public static String CLIENT_VERSION;
  public static int CLIENT_VERSION_INT;
  public static String COMMAND;
  public static boolean DEBUG;
  public static boolean ENABLE_FPS_ANALYSE;
  public static boolean ENABLE_MATRIX;
  public static boolean ENABLE_MATRIX_TRACE;
  public static boolean ENABLE_PAYTEST;
  public static boolean EX_DEVICE_LOGIN;
  public static String HOSTNAME;
  public static boolean IS_ARM64;
  public static boolean IS_FLAVOR_BLUE;
  public static boolean IS_FLAVOR_PURPLE;
  public static boolean IS_FLAVOR_RED;
  public static boolean IS_UAT;
  public static String KINDA_DEFAULT;
  public static String MATRIX_VERSION;
  public static String OVERRIDE_VERSION_NAME;
  public static String OWNER;
  public static boolean PRE_RELEASE;
  public static boolean REDESIGN_ENTRANCE;
  public static String REV;
  public static String SVNPATH;
  public static String TIME;
  public static String TINKER_VERSION;
  public static final ImmutableBundle ext;
  
  static
  {
    AppMethodBeat.i(125205);
    ext = new ImmutableBundle();
    AppMethodBeat.o(125205);
  }
  
  public static String info()
  {
    AppMethodBeat.i(125204);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("[b.ver] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(CLIENT_VERSION, a.CLIENT_VERSION) }));
    localStringBuilder.append(String.format("[tag  ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(BUILD_TAG, a.BUILD_TAG) }));
    localStringBuilder.append(String.format("[by   ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(OWNER, a.OWNER) }));
    localStringBuilder.append(String.format("[host ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(HOSTNAME, a.HOSTNAME) }));
    localStringBuilder.append(String.format("[time ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(TIME, a.TIME) }));
    localStringBuilder.append(String.format("[cmd  ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(COMMAND, a.COMMAND) }));
    localStringBuilder.append(String.format("[path ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(BuildInfo.StringUtil.stringFrom(SVNPATH, "MicroMsg_proj"), BuildInfo.StringUtil.stringFrom(a.SVNPATH, "MicroMsg_proj")) }));
    localStringBuilder.append(String.format("[rev  ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(REV, a.REV) }));
    if (a.aSA())
    {
      str = a.aSx();
      localStringBuilder.append(String.format("[p.rev] %s\n", new Object[] { str }));
      if (!IS_ARM64) {
        break label329;
      }
    }
    label329:
    for (String str = "arm64-v8a";; str = "armeabi-v7a")
    {
      localStringBuilder.append(String.format("[eabi ] %s\n", new Object[] { str }));
      localStringBuilder.append(String.format("[feature_id] %s\n", new Object[] { ext.getString("FEATURE_ID") }));
      str = localStringBuilder.toString();
      AppMethodBeat.o(125204);
      return str;
      str = "disabled";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BuildInfo
 * JD-Core Version:    0.7.0.1
 */