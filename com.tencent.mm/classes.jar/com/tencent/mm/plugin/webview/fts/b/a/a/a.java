package com.tencent.mm.plugin.webview.fts.b.a.a;

public final class a
{
  public String bOL;
  public String ral;
  public String ram;
  public String ran;
  private String rao;
  private String rap;
  private String raq;
  private boolean rar;
  
  /* Error */
  public a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: invokespecial 23	java/lang/Object:<init>	()V
    //   6: new 25	java/lang/String
    //   9: dup
    //   10: aload_1
    //   11: invokestatic 31	com/tencent/mm/sdk/platformtools/bk:readFromFile	(Ljava/lang/String;)[B
    //   14: invokespecial 34	java/lang/String:<init>	([B)V
    //   17: astore_1
    //   18: aload_1
    //   19: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifne +151 -> 173
    //   25: new 42	org/json/JSONObject
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 44	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload_0
    //   35: aload_1
    //   36: ldc 46
    //   38: invokevirtual 50	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: putfield 52	com/tencent/mm/plugin/webview/fts/b/a/a/a:bOL	Ljava/lang/String;
    //   44: aload_0
    //   45: aload_1
    //   46: ldc 54
    //   48: invokevirtual 50	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: putfield 56	com/tencent/mm/plugin/webview/fts/b/a/a/a:ral	Ljava/lang/String;
    //   54: aload_0
    //   55: aload_1
    //   56: ldc 58
    //   58: invokevirtual 62	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   61: invokevirtual 66	org/json/JSONObject:toString	()Ljava/lang/String;
    //   64: putfield 68	com/tencent/mm/plugin/webview/fts/b/a/a/a:ram	Ljava/lang/String;
    //   67: aload_0
    //   68: aload_1
    //   69: ldc 70
    //   71: invokevirtual 50	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   74: putfield 72	com/tencent/mm/plugin/webview/fts/b/a/a/a:ran	Ljava/lang/String;
    //   77: aload_0
    //   78: aload_1
    //   79: ldc 74
    //   81: invokevirtual 62	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   84: invokevirtual 66	org/json/JSONObject:toString	()Ljava/lang/String;
    //   87: putfield 76	com/tencent/mm/plugin/webview/fts/b/a/a/a:rao	Ljava/lang/String;
    //   90: aload_0
    //   91: aload_1
    //   92: ldc 78
    //   94: invokevirtual 50	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: putfield 80	com/tencent/mm/plugin/webview/fts/b/a/a/a:rap	Ljava/lang/String;
    //   100: aload_0
    //   101: aload_1
    //   102: ldc 82
    //   104: invokevirtual 50	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: putfield 84	com/tencent/mm/plugin/webview/fts/b/a/a/a:raq	Ljava/lang/String;
    //   110: aload_1
    //   111: ldc 86
    //   113: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   116: iconst_1
    //   117: if_icmpne +51 -> 168
    //   120: aload_0
    //   121: iload_2
    //   122: putfield 92	com/tencent/mm/plugin/webview/fts/b/a/a/a:rar	Z
    //   125: return
    //   126: astore_1
    //   127: new 94	java/lang/IllegalArgumentException
    //   130: dup
    //   131: aload_1
    //   132: invokespecial 97	java/lang/IllegalArgumentException:<init>	(Ljava/lang/Throwable;)V
    //   135: athrow
    //   136: astore_3
    //   137: ldc 99
    //   139: aload_3
    //   140: ldc 101
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokestatic 107	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: goto -82 -> 67
    //   152: astore_3
    //   153: ldc 99
    //   155: aload_3
    //   156: ldc 101
    //   158: iconst_0
    //   159: anewarray 4	java/lang/Object
    //   162: invokestatic 107	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: goto -75 -> 90
    //   168: iconst_0
    //   169: istore_2
    //   170: goto -50 -> 120
    //   173: new 94	java/lang/IllegalArgumentException
    //   176: dup
    //   177: ldc 109
    //   179: invokespecial 110	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	a
    //   0	183	1	paramString	String
    //   1	169	2	bool	boolean
    //   136	4	3	localException1	java.lang.Exception
    //   152	4	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   25	34	126	org/json/JSONException
    //   54	67	136	java/lang/Exception
    //   77	90	152	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */