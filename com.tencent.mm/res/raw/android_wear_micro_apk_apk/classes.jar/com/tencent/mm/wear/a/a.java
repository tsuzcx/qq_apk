package com.tencent.mm.wear.a;

public final class a
{
  public static String ov()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("[tag ] %s\n", new Object[] { "MicroMessenger_Android_Wear #16" }));
    localStringBuilder.append(String.format("[by  ] %s\n", new Object[] { "jiaminchen" }));
    localStringBuilder.append(String.format("[host] %s\n", new Object[] { "VM_10_240_centos" }));
    localStringBuilder.append(String.format("[time] %s\n", new Object[] { "2019-09-11 20:25:40" }));
    localStringBuilder.append(String.format("[cmd ] %s\n", new Object[] { "null" }));
    localStringBuilder.append(String.format("[rev ] %s\n", new Object[] { "c90af65aa3928d1a6d107bf09a666643f02347d3" }));
    String str = "origin/unstable/RB-2019-MAY/wear_apk@git";
    int i = "origin/unstable/RB-2019-MAY/wear_apk@git".indexOf("MicroMsg_proj");
    if (i < 0) {}
    for (;;)
    {
      localStringBuilder.append(String.format("[path] %s\n", new Object[] { str }));
      return localStringBuilder.toString();
      str = "origin/unstable/RB-2019-MAY/wear_apk@git".substring(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.a
 * JD-Core Version:    0.7.0.1
 */