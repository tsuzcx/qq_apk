package com.tencent.mm.plugin.sns.lucky.a;

public final class k
{
  /* Error */
  public static com.tencent.mm.plugin.sns.j.i i(com.tencent.mm.storage.ar.a parama)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 16	com/tencent/mm/plugin/sns/j/i
    //   8: dup
    //   9: invokespecial 20	com/tencent/mm/plugin/sns/j/i:<init>	()V
    //   12: astore_2
    //   13: invokestatic 26	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   16: pop
    //   17: invokestatic 30	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   20: invokevirtual 36	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   23: aload_0
    //   24: aconst_null
    //   25: invokevirtual 42	com/tencent/mm/storage/ao:get	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 44	java/lang/String
    //   31: astore_0
    //   32: aload_0
    //   33: ifnonnull +17 -> 50
    //   36: ldc 46
    //   38: ldc 48
    //   40: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: ldc 9
    //   45: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_2
    //   49: areturn
    //   50: new 16	com/tencent/mm/plugin/sns/j/i
    //   53: dup
    //   54: invokespecial 20	com/tencent/mm/plugin/sns/j/i:<init>	()V
    //   57: aload_0
    //   58: ldc 58
    //   60: invokestatic 64	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   63: invokevirtual 68	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   66: invokevirtual 72	com/tencent/mm/plugin/sns/j/i:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   69: checkcast 16	com/tencent/mm/plugin/sns/j/i
    //   72: astore_1
    //   73: aload_1
    //   74: astore_0
    //   75: aload_1
    //   76: ifnonnull +11 -> 87
    //   79: new 16	com/tencent/mm/plugin/sns/j/i
    //   82: dup
    //   83: invokespecial 20	com/tencent/mm/plugin/sns/j/i:<init>	()V
    //   86: astore_0
    //   87: aload_0
    //   88: astore_1
    //   89: aload_0
    //   90: ifnonnull +11 -> 101
    //   93: new 16	com/tencent/mm/plugin/sns/j/i
    //   96: dup
    //   97: invokespecial 20	com/tencent/mm/plugin/sns/j/i:<init>	()V
    //   100: astore_1
    //   101: ldc 9
    //   103: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_1
    //   107: areturn
    //   108: astore_1
    //   109: aload_2
    //   110: astore_0
    //   111: ldc 46
    //   113: new 74	java/lang/StringBuilder
    //   116: dup
    //   117: ldc 76
    //   119: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload_1
    //   123: invokevirtual 83	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   126: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: goto -48 -> 87
    //   138: astore_0
    //   139: aload_1
    //   140: astore_2
    //   141: aload_0
    //   142: astore_1
    //   143: aload_2
    //   144: astore_0
    //   145: goto -34 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	parama	com.tencent.mm.storage.ar.a
    //   72	35	1	localObject1	Object
    //   108	32	1	localException	java.lang.Exception
    //   142	1	1	locala	com.tencent.mm.storage.ar.a
    //   12	132	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   50	73	108	java/lang/Exception
    //   79	87	138	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.k
 * JD-Core Version:    0.7.0.1
 */