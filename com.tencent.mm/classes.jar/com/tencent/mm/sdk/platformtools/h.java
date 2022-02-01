package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;

public final class h
{
  public static String BUILD_TAG;
  public static String COMMAND;
  public static boolean DEBUG;
  public static boolean ENABLE_FPS_ANALYSE;
  public static boolean ENABLE_MATRIX;
  public static boolean ENABLE_MATRIX_TRACE;
  public static boolean EX_DEVICE_LOGIN;
  public static int GqE;
  public static final t GqF;
  public static String HOSTNAME;
  public static boolean IS_FLAVOR_PURPLE;
  public static boolean IS_FLAVOR_RED;
  public static boolean IS_UAT;
  public static String KINDA_DEFAULT;
  public static String MATRIX_VERSION;
  public static String OWNER;
  public static boolean PRE_RELEASE;
  public static boolean REDESIGN_ENTRANCE;
  public static String REV;
  public static String SVNPATH;
  public static String TIME;
  public static String TINKER_VERSION;
  public static String gMJ;
  public static boolean gMM;
  
  static
  {
    AppMethodBeat.i(125205);
    GqF = new t();
    AppMethodBeat.o(125205);
  }
  
  public static String info()
  {
    AppMethodBeat.i(125204);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("[b.ver] %s\n", new Object[] { a.ll(gMJ, a.gMJ) }));
    localStringBuilder.append(String.format("[tag  ] %s\n", new Object[] { a.ll(BUILD_TAG, a.BUILD_TAG) }));
    localStringBuilder.append(String.format("[by   ] %s\n", new Object[] { a.ll(OWNER, a.OWNER) }));
    localStringBuilder.append(String.format("[host ] %s\n", new Object[] { a.ll(HOSTNAME, a.HOSTNAME) }));
    localStringBuilder.append(String.format("[time ] %s\n", new Object[] { a.ll(TIME, a.TIME) }));
    localStringBuilder.append(String.format("[cmd  ] %s\n", new Object[] { a.ll(COMMAND, a.COMMAND) }));
    localStringBuilder.append(String.format("[path ] %s\n", new Object[] { a.ll(a.lk(SVNPATH, "MicroMsg_proj"), a.lk(a.SVNPATH, "MicroMsg_proj")) }));
    localStringBuilder.append(String.format("[rev  ] %s\n", new Object[] { a.ll(REV, a.REV) }));
    if (a.aoW())
    {
      str = a.aoT();
      localStringBuilder.append(String.format("[p.rev] %s\n", new Object[] { str }));
      if (!gMM) {
        break label329;
      }
    }
    label329:
    for (String str = "arm64-v8a";; str = "armeabi-v7a")
    {
      localStringBuilder.append(String.format("[eabi ] %s\n", new Object[] { str }));
      localStringBuilder.append(String.format("[feature_id] %s\n", new Object[] { GqF.getString("FEATURE_ID") }));
      str = localStringBuilder.toString();
      AppMethodBeat.o(125204);
      return str;
      str = "disabled";
      break;
    }
  }
  
  static final class a
  {
    public static String lk(String paramString1, String paramString2)
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
    
    public static String ll(String paramString1, String paramString2)
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
 * Qualified Name:     com.tencent.mm.sdk.platformtools.h
 * JD-Core Version:    0.7.0.1
 */