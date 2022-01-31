package com.tencent.mm.wear.a;

public final class a
{
  public static String nH()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("[tag ] %s\n", new Object[] { "MicroMessenger_Android_GIT_RELEASE_GRADLE #7898" }));
    localStringBuilder.append(String.format("[by  ] %s\n", new Object[] { "amm_code_helper" }));
    localStringBuilder.append(String.format("[host] %s\n", new Object[] { "c39127bbe61f" }));
    localStringBuilder.append(String.format("[time] %s\n", new Object[] { "2018-09-29 00:16:37" }));
    localStringBuilder.append(String.format("[cmd ] %s\n", new Object[] { "null" }));
    localStringBuilder.append(String.format("[rev ] %s\n", new Object[] { "9583be09a035314bcc371f0780e1d8bd46a0b1d1" }));
    String str = "origin/RB-2018-AUG@git";
    int i = "origin/RB-2018-AUG@git".indexOf("MicroMsg_proj");
    if (i < 0) {}
    for (;;)
    {
      localStringBuilder.append(String.format("[path] %s\n", new Object[] { str }));
      return localStringBuilder.toString();
      str = "origin/RB-2018-AUG@git".substring(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.a
 * JD-Core Version:    0.7.0.1
 */