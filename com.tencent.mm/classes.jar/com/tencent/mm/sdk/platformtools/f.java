package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;

public final class f
{
  public static String BUILD_TAG;
  public static String CLIENT_VERSION;
  public static String COMMAND;
  public static boolean DEBUG;
  public static boolean ENABLE_FPS_ANALYSE;
  public static boolean ENABLE_MATRIX;
  public static boolean ENABLE_MATRIX_TRACE;
  public static boolean EX_DEVICE_LOGIN;
  public static String HOSTNAME;
  public static boolean IS_FLAVOR_PURPLE;
  public static boolean IS_FLAVOR_RED;
  public static String OWNER;
  public static boolean PRE_RELEASE;
  public static boolean REDESIGN_ENTRANCE;
  public static String REV;
  public static String SVNPATH;
  public static String TIME;
  public static int ymG;
  public static final s ymH;
  
  static
  {
    AppMethodBeat.i(115170);
    ymH = new s();
    AppMethodBeat.o(115170);
  }
  
  public static String bau()
  {
    AppMethodBeat.i(115169);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("[b.ver] %s\n", new Object[] { a.ie(CLIENT_VERSION, a.CLIENT_VERSION) }));
    localStringBuilder.append(String.format("[tag  ] %s\n", new Object[] { a.ie(BUILD_TAG, a.BUILD_TAG) }));
    localStringBuilder.append(String.format("[by   ] %s\n", new Object[] { a.ie(OWNER, a.OWNER) }));
    localStringBuilder.append(String.format("[host ] %s\n", new Object[] { a.ie(HOSTNAME, a.HOSTNAME) }));
    localStringBuilder.append(String.format("[time ] %s\n", new Object[] { a.ie(TIME, a.TIME) }));
    localStringBuilder.append(String.format("[cmd  ] %s\n", new Object[] { a.ie(COMMAND, a.COMMAND) }));
    localStringBuilder.append(String.format("[path ] %s\n", new Object[] { a.ie(a.id(SVNPATH, "MicroMsg_proj"), a.id(a.SVNPATH, "MicroMsg_proj")) }));
    localStringBuilder.append(String.format("[rev  ] %s\n", new Object[] { a.ie(REV, a.REV) }));
    if (a.Uk()) {}
    for (String str = a.Ui();; str = "disabled")
    {
      localStringBuilder.append(String.format("[p.rev] %s\n", new Object[] { str }));
      localStringBuilder.append(String.format("[feature_id] %s\n", new Object[] { ymH.getString("FEATURE_ID") }));
      str = localStringBuilder.toString();
      AppMethodBeat.o(115169);
      return str;
    }
  }
  
  static final class a
  {
    public static String id(String paramString1, String paramString2)
    {
      AppMethodBeat.i(115167);
      if (paramString1 == null)
      {
        AppMethodBeat.o(115167);
        return null;
      }
      int i = paramString1.indexOf(paramString2);
      if (i < 0)
      {
        AppMethodBeat.o(115167);
        return paramString1;
      }
      paramString1 = paramString1.substring(i);
      AppMethodBeat.o(115167);
      return paramString1;
    }
    
    public static String ie(String paramString1, String paramString2)
    {
      AppMethodBeat.i(115168);
      if (paramString1 == null)
      {
        AppMethodBeat.o(115168);
        return null;
      }
      if (paramString1.equals(paramString2))
      {
        AppMethodBeat.o(115168);
        return paramString1;
      }
      paramString1 = String.format("%s(%s)", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(115168);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.f
 * JD-Core Version:    0.7.0.1
 */