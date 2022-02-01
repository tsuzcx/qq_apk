package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.a;

public class BuildInfo
{
  public static String BUILD_TAG;
  public static String CLIENT_VERSION;
  public static int CLIENT_VERSION_INT;
  public static String COMMAND;
  public static boolean DEBUG;
  public static boolean ENABLE_FPS_ANALYSE;
  public static boolean ENABLE_LIVE_SDK_DEBUG;
  public static boolean ENABLE_MATRIX;
  public static boolean ENABLE_MATRIX_MEMORY_HOOK;
  public static boolean ENABLE_MATRIX_PTHREAD_HOOK;
  public static boolean ENABLE_MATRIX_SILENCE_ANALYSE;
  public static boolean ENABLE_MATRIX_TRACE;
  public static boolean ENABLE_PAYTEST;
  public static boolean ENABLE_XPOSED_HOOK;
  public static boolean EX_DEVICE_LOGIN;
  public static String HOSTNAME;
  public static boolean IS_ARM64;
  public static boolean IS_FLAVOR_BLUE;
  public static boolean IS_FLAVOR_PURPLE;
  public static boolean IS_FLAVOR_RED;
  public static boolean IS_UAT;
  public static String KINDA_DEFAULT;
  public static int LIVE_JS_ADAPTER_VERSION;
  public static String MATRIX_VERSION;
  public static String OVERRIDE_VERSION_NAME;
  public static String OWNER;
  public static boolean PRE_RELEASE;
  public static boolean REDESIGN_ENTRANCE;
  public static String REV;
  public static String SVNPATH;
  public static String TIME;
  public static String TINKER_VERSION;
  public static String curClientVersion;
  public static final ImmutableBundle ext;
  
  static
  {
    AppMethodBeat.i(125205);
    ext = new ImmutableBundle();
    curClientVersion = CLIENT_VERSION;
    AppMethodBeat.o(125205);
  }
  
  public static String info()
  {
    AppMethodBeat.i(125204);
    String str = info(false);
    AppMethodBeat.o(125204);
    return str;
  }
  
  public static String info(boolean paramBoolean)
  {
    AppMethodBeat.i(243445);
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = BUILD_TAG;
    String str2 = HOSTNAME;
    String str3 = TIME;
    String str4 = REV;
    String str5 = SVNPATH;
    if ((paramBoolean) && (CLIENT_VERSION_INT >= 671093248) && (CLIENT_VERSION_INT <= 671093503)) {
      if (IS_ARM64)
      {
        str1 = "0x28001233";
        curClientVersion = str1;
        str1 = "9d2d42f91552dee6a16fc846bbead136de78b129";
        str2 = a.SVNPATH;
        str3 = curClientVersion;
        localStringBuilder.append(String.format("[b.ver] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(str3, str3) }));
        localStringBuilder.append(String.format("[tag  ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr("Android_Wechat_RELEASE #12217", "Android_Wechat_RELEASE #12217") }));
        localStringBuilder.append(String.format("[by   ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(OWNER, a.OWNER) }));
        localStringBuilder.append(String.format("[host ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr("VM_53_123_centos", "VM_53_123_centos") }));
        localStringBuilder.append(String.format("[time ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr("2022-01-04 23:14:34", "2022-01-04 23:14:34") }));
        localStringBuilder.append(String.format("[cmd  ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(COMMAND, a.COMMAND) }));
        localStringBuilder.append(String.format("[path ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(BuildInfo.StringUtil.stringFrom(str2, "MicroMsg_proj"), BuildInfo.StringUtil.stringFrom(a.SVNPATH, "MicroMsg_proj")) }));
        localStringBuilder.append(String.format("[rev  ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr("9d2d42f91552dee6a16fc846bbead136de78b129", "9d2d42f91552dee6a16fc846bbead136de78b129") }));
        if (!a.bmo()) {
          break label381;
        }
        label293:
        localStringBuilder.append(String.format("[p.rev] %s\n", new Object[] { str1 }));
        if (!IS_ARM64) {
          break label635;
        }
      }
    }
    label635:
    for (str1 = "arm64-v8a";; str1 = "armeabi-v7a")
    {
      localStringBuilder.append(String.format("[eabi ] %s\n", new Object[] { str1 }));
      localStringBuilder.append(String.format("[feature_id] %s\n", new Object[] { ext.getString("FEATURE_ID") }));
      str1 = localStringBuilder.toString();
      AppMethodBeat.o(243445);
      return str1;
      str1 = "0x28001232";
      break;
      label381:
      str1 = "disabled";
      break label293;
      localStringBuilder.append(String.format("[b.ver] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(curClientVersion, a.CLIENT_VERSION) }));
      localStringBuilder.append(String.format("[tag  ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(str1, a.BUILD_TAG) }));
      localStringBuilder.append(String.format("[by   ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(OWNER, a.OWNER) }));
      localStringBuilder.append(String.format("[host ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(str2, a.HOSTNAME) }));
      localStringBuilder.append(String.format("[time ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(str3, a.TIME) }));
      localStringBuilder.append(String.format("[cmd  ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(COMMAND, a.COMMAND) }));
      localStringBuilder.append(String.format("[path ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(BuildInfo.StringUtil.stringFrom(str5, "MicroMsg_proj"), BuildInfo.StringUtil.stringFrom(a.SVNPATH, "MicroMsg_proj")) }));
      localStringBuilder.append(String.format("[rev  ] %s\n", new Object[] { BuildInfo.StringUtil.diffStr(str4, a.REV) }));
      if (a.bmo()) {}
      for (str1 = a.bml();; str1 = "disabled")
      {
        localStringBuilder.append(String.format("[p.rev] %s\n", new Object[] { str1 }));
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BuildInfo
 * JD-Core Version:    0.7.0.1
 */