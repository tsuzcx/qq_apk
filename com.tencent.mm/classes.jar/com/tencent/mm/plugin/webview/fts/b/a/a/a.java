package com.tencent.mm.plugin.webview.fts.b.a.a;

public final class a
{
  public String PLW;
  public String PLX;
  public String PLY;
  private String PLZ;
  private String PMa;
  private String PMb;
  private boolean PMc;
  public String appid;
  
  /* Error */
  public a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: invokespecial 23	java/lang/Object:<init>	()V
    //   6: ldc 24
    //   8: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: new 32	java/lang/String
    //   14: dup
    //   15: aload_1
    //   16: invokestatic 38	com/tencent/mm/sdk/platformtools/Util:readFromFile	(Ljava/lang/String;)[B
    //   19: invokespecial 41	java/lang/String:<init>	([B)V
    //   22: astore_1
    //   23: aload_1
    //   24: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifne +163 -> 190
    //   30: new 49	org/json/JSONObject
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_0
    //   40: aload_1
    //   41: ldc 52
    //   43: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   46: putfield 58	com/tencent/mm/plugin/webview/fts/b/a/a/a:appid	Ljava/lang/String;
    //   49: aload_0
    //   50: aload_1
    //   51: ldc 60
    //   53: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: putfield 62	com/tencent/mm/plugin/webview/fts/b/a/a/a:PLW	Ljava/lang/String;
    //   59: aload_0
    //   60: aload_1
    //   61: ldc 64
    //   63: invokevirtual 68	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   66: invokevirtual 72	org/json/JSONObject:toString	()Ljava/lang/String;
    //   69: putfield 74	com/tencent/mm/plugin/webview/fts/b/a/a/a:PLX	Ljava/lang/String;
    //   72: aload_0
    //   73: aload_1
    //   74: ldc 76
    //   76: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: putfield 78	com/tencent/mm/plugin/webview/fts/b/a/a/a:PLY	Ljava/lang/String;
    //   82: aload_0
    //   83: aload_1
    //   84: ldc 80
    //   86: invokevirtual 68	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   89: invokevirtual 72	org/json/JSONObject:toString	()Ljava/lang/String;
    //   92: putfield 82	com/tencent/mm/plugin/webview/fts/b/a/a/a:PLZ	Ljava/lang/String;
    //   95: aload_0
    //   96: aload_1
    //   97: ldc 84
    //   99: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   102: putfield 86	com/tencent/mm/plugin/webview/fts/b/a/a/a:PMa	Ljava/lang/String;
    //   105: aload_0
    //   106: aload_1
    //   107: ldc 88
    //   109: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   112: putfield 90	com/tencent/mm/plugin/webview/fts/b/a/a/a:PMb	Ljava/lang/String;
    //   115: aload_1
    //   116: ldc 92
    //   118: invokevirtual 96	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   121: iconst_1
    //   122: if_icmpne +63 -> 185
    //   125: aload_0
    //   126: iload_2
    //   127: putfield 98	com/tencent/mm/plugin/webview/fts/b/a/a/a:PMc	Z
    //   130: ldc 24
    //   132: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: astore_1
    //   137: new 103	java/lang/IllegalArgumentException
    //   140: dup
    //   141: aload_1
    //   142: invokespecial 106	java/lang/IllegalArgumentException:<init>	(Ljava/lang/Throwable;)V
    //   145: astore_1
    //   146: ldc 24
    //   148: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_1
    //   152: athrow
    //   153: astore_3
    //   154: ldc 108
    //   156: aload_3
    //   157: ldc 110
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: goto -94 -> 72
    //   169: astore_3
    //   170: ldc 108
    //   172: aload_3
    //   173: ldc 110
    //   175: iconst_0
    //   176: anewarray 4	java/lang/Object
    //   179: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: goto -87 -> 95
    //   185: iconst_0
    //   186: istore_2
    //   187: goto -62 -> 125
    //   190: new 103	java/lang/IllegalArgumentException
    //   193: dup
    //   194: ldc 118
    //   196: invokespecial 119	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   199: astore_1
    //   200: ldc 24
    //   202: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload_1
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	a
    //   0	207	1	paramString	String
    //   1	186	2	bool	boolean
    //   153	4	3	localException1	java.lang.Exception
    //   169	4	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   30	39	136	org/json/JSONException
    //   59	72	153	java/lang/Exception
    //   82	95	169	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */