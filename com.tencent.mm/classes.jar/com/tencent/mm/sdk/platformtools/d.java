package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.loader.a.a;

public final class d
{
  public static String BUILD_TAG;
  public static String CLIENT_VERSION;
  public static String COMMAND;
  public static boolean DEBUG;
  public static boolean ENABLE_FPS_ANALYSE;
  public static boolean ENABLE_MATRIX;
  public static boolean EX_DEVICE_LOGIN;
  public static String HOSTNAME;
  public static boolean IS_FLAVOR_RED;
  public static String OWNER;
  public static boolean PRE_RELEASE;
  public static boolean REDESIGN_ENTRANCE;
  public static String REV;
  public static String SVNPATH;
  public static String TIME;
  public static final p ueg = new p();
  
  public static String ayN()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("[b.ver] %s\n", new Object[] { a.gd(CLIENT_VERSION, a.CLIENT_VERSION) }));
    localStringBuilder.append(String.format("[tag  ] %s\n", new Object[] { a.gd(BUILD_TAG, a.BUILD_TAG) }));
    localStringBuilder.append(String.format("[by   ] %s\n", new Object[] { a.gd(OWNER, a.OWNER) }));
    localStringBuilder.append(String.format("[host ] %s\n", new Object[] { a.gd(HOSTNAME, a.HOSTNAME) }));
    localStringBuilder.append(String.format("[time ] %s\n", new Object[] { a.gd(TIME, a.TIME) }));
    localStringBuilder.append(String.format("[cmd  ] %s\n", new Object[] { a.gd(COMMAND, a.COMMAND) }));
    localStringBuilder.append(String.format("[path ] %s\n", new Object[] { a.gd(a.gc(SVNPATH, "MicroMsg_proj"), a.gc(a.SVNPATH, "MicroMsg_proj")) }));
    localStringBuilder.append(String.format("[rev  ] %s\n", new Object[] { a.gd(REV, a.REV) }));
    if (a.EQ()) {}
    for (String str = a.EO();; str = "disabled")
    {
      localStringBuilder.append(String.format("[p.rev] %s\n", new Object[] { str }));
      localStringBuilder.append(String.format("[feature_id] %s\n", new Object[] { ueg.getString("FEATURE_ID") }));
      return localStringBuilder.toString();
    }
  }
  
  private static final class a
  {
    public static String gc(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        paramString2 = null;
      }
      int i;
      do
      {
        return paramString2;
        i = paramString1.indexOf(paramString2);
        paramString2 = paramString1;
      } while (i < 0);
      return paramString1.substring(i);
    }
    
    public static String gd(String paramString1, String paramString2)
    {
      String str;
      if (paramString1 == null) {
        str = null;
      }
      do
      {
        return str;
        str = paramString1;
      } while (paramString1.equals(paramString2));
      return String.format("%s(%s)", new Object[] { paramString1, paramString2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.d
 * JD-Core Version:    0.7.0.1
 */