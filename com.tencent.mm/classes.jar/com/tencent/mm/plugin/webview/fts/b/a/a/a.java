package com.tencent.mm.plugin.webview.fts.b.a.a;

public final class a
{
  public String cwc;
  public String uPS;
  public String uPT;
  public String uPU;
  private String uPV;
  private String uPW;
  private String uPX;
  private boolean uPY;
  
  /* Error */
  public a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: invokespecial 23	java/lang/Object:<init>	()V
    //   6: sipush 5776
    //   9: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: new 31	java/lang/String
    //   15: dup
    //   16: aload_1
    //   17: invokestatic 37	com/tencent/mm/sdk/platformtools/bo:readFromFile	(Ljava/lang/String;)[B
    //   20: invokespecial 40	java/lang/String:<init>	([B)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +165 -> 193
    //   31: new 48	org/json/JSONObject
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 50	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_0
    //   41: aload_1
    //   42: ldc 52
    //   44: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   47: putfield 58	com/tencent/mm/plugin/webview/fts/b/a/a/a:cwc	Ljava/lang/String;
    //   50: aload_0
    //   51: aload_1
    //   52: ldc 60
    //   54: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: putfield 62	com/tencent/mm/plugin/webview/fts/b/a/a/a:uPS	Ljava/lang/String;
    //   60: aload_0
    //   61: aload_1
    //   62: ldc 64
    //   64: invokevirtual 68	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   67: invokevirtual 72	org/json/JSONObject:toString	()Ljava/lang/String;
    //   70: putfield 74	com/tencent/mm/plugin/webview/fts/b/a/a/a:uPT	Ljava/lang/String;
    //   73: aload_0
    //   74: aload_1
    //   75: ldc 76
    //   77: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: putfield 78	com/tencent/mm/plugin/webview/fts/b/a/a/a:uPU	Ljava/lang/String;
    //   83: aload_0
    //   84: aload_1
    //   85: ldc 80
    //   87: invokevirtual 68	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   90: invokevirtual 72	org/json/JSONObject:toString	()Ljava/lang/String;
    //   93: putfield 82	com/tencent/mm/plugin/webview/fts/b/a/a/a:uPV	Ljava/lang/String;
    //   96: aload_0
    //   97: aload_1
    //   98: ldc 84
    //   100: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   103: putfield 86	com/tencent/mm/plugin/webview/fts/b/a/a/a:uPW	Ljava/lang/String;
    //   106: aload_0
    //   107: aload_1
    //   108: ldc 88
    //   110: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   113: putfield 90	com/tencent/mm/plugin/webview/fts/b/a/a/a:uPX	Ljava/lang/String;
    //   116: aload_1
    //   117: ldc 92
    //   119: invokevirtual 96	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   122: iconst_1
    //   123: if_icmpne +65 -> 188
    //   126: aload_0
    //   127: iload_2
    //   128: putfield 98	com/tencent/mm/plugin/webview/fts/b/a/a/a:uPY	Z
    //   131: sipush 5776
    //   134: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: return
    //   138: astore_1
    //   139: new 103	java/lang/IllegalArgumentException
    //   142: dup
    //   143: aload_1
    //   144: invokespecial 106	java/lang/IllegalArgumentException:<init>	(Ljava/lang/Throwable;)V
    //   147: astore_1
    //   148: sipush 5776
    //   151: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload_1
    //   155: athrow
    //   156: astore_3
    //   157: ldc 108
    //   159: aload_3
    //   160: ldc 110
    //   162: iconst_0
    //   163: anewarray 4	java/lang/Object
    //   166: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: goto -96 -> 73
    //   172: astore_3
    //   173: ldc 108
    //   175: aload_3
    //   176: ldc 110
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: goto -89 -> 96
    //   188: iconst_0
    //   189: istore_2
    //   190: goto -64 -> 126
    //   193: new 103	java/lang/IllegalArgumentException
    //   196: dup
    //   197: ldc 118
    //   199: invokespecial 119	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   202: astore_1
    //   203: sipush 5776
    //   206: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aload_1
    //   210: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	a
    //   0	211	1	paramString	String
    //   1	189	2	bool	boolean
    //   156	4	3	localException1	java.lang.Exception
    //   172	4	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   31	40	138	org/json/JSONException
    //   60	73	156	java/lang/Exception
    //   83	96	172	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */