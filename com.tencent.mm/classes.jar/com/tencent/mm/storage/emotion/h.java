package com.tencent.mm.storage.emotion;

import com.tencent.mm.cf.g.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class h
  extends i<g>
  implements g.a
{
  public static final String[] dXp = { i.a(g.buS, "EmotionDesignerInfo") };
  public e dXw;
  
  public h(e parame)
  {
    super(parame, g.buS, "EmotionDesignerInfo", null);
    this.dXw = parame;
  }
  
  public final int a(com.tencent.mm.cf.g paramg)
  {
    if (paramg != null) {
      this.dXw = paramg;
    }
    return 0;
  }
  
  /* Error */
  public final com.tencent.mm.protocal.c.aeu acG(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 50	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifeq +12 -> 16
    //   7: ldc 52
    //   9: ldc 54
    //   11: invokestatic 60	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aconst_null
    //   15: areturn
    //   16: new 62	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   23: aload_1
    //   24: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: getstatic 72	com/tencent/mm/storage/emotion/h$a:uDr	Lcom/tencent/mm/storage/emotion/h$a;
    //   30: getfield 76	com/tencent/mm/storage/emotion/h$a:value	I
    //   33: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore_1
    //   40: aload_0
    //   41: getfield 39	com/tencent/mm/storage/emotion/h:dXw	Lcom/tencent/mm/sdk/e/e;
    //   44: ldc 25
    //   46: iconst_1
    //   47: anewarray 17	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: ldc 85
    //   54: aastore
    //   55: ldc 87
    //   57: iconst_1
    //   58: anewarray 17	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: aload_1
    //   64: aastore
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: iconst_2
    //   69: invokeinterface 92 9 0
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +122 -> 198
    //   79: aload_1
    //   80: astore_2
    //   81: aload_1
    //   82: invokeinterface 98 1 0
    //   87: ifeq +111 -> 198
    //   90: aload_1
    //   91: astore_2
    //   92: new 100	com/tencent/mm/protocal/c/aeu
    //   95: dup
    //   96: invokespecial 101	com/tencent/mm/protocal/c/aeu:<init>	()V
    //   99: astore_3
    //   100: aload_1
    //   101: astore_2
    //   102: aload_3
    //   103: aload_1
    //   104: iconst_0
    //   105: invokeinterface 105 2 0
    //   110: invokevirtual 109	com/tencent/mm/protocal/c/aeu:aH	([B)Lcom/tencent/mm/bv/a;
    //   113: pop
    //   114: aload_3
    //   115: astore_2
    //   116: aload_2
    //   117: astore_3
    //   118: aload_1
    //   119: ifnull +11 -> 130
    //   122: aload_1
    //   123: invokeinterface 112 1 0
    //   128: aload_2
    //   129: astore_3
    //   130: aload_3
    //   131: areturn
    //   132: astore_3
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: astore_2
    //   137: ldc 52
    //   139: ldc 114
    //   141: iconst_1
    //   142: anewarray 116	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_3
    //   148: invokestatic 120	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 124	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_1
    //   156: ifnull +37 -> 193
    //   159: aload_1
    //   160: invokeinterface 112 1 0
    //   165: aconst_null
    //   166: astore_3
    //   167: goto -37 -> 130
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_2
    //   173: aload_2
    //   174: ifnull +9 -> 183
    //   177: aload_2
    //   178: invokeinterface 112 1 0
    //   183: aload_1
    //   184: athrow
    //   185: astore_1
    //   186: goto -13 -> 173
    //   189: astore_3
    //   190: goto -55 -> 135
    //   193: aconst_null
    //   194: astore_3
    //   195: goto -65 -> 130
    //   198: aconst_null
    //   199: astore_2
    //   200: goto -84 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	h
    //   0	203	1	paramString	String
    //   80	120	2	localObject1	java.lang.Object
    //   99	32	3	localObject2	java.lang.Object
    //   132	16	3	localException1	java.lang.Exception
    //   166	1	3	localObject3	java.lang.Object
    //   189	1	3	localException2	java.lang.Exception
    //   194	1	3	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   40	75	132	java/lang/Exception
    //   40	75	170	finally
    //   81	90	185	finally
    //   92	100	185	finally
    //   102	114	185	finally
    //   137	155	185	finally
    //   81	90	189	java/lang/Exception
    //   92	100	189	java/lang/Exception
    //   102	114	189	java/lang/Exception
  }
  
  /* Error */
  public final com.tencent.mm.protocal.c.aes acH(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 50	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifeq +12 -> 16
    //   7: ldc 52
    //   9: ldc 130
    //   11: invokestatic 60	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aconst_null
    //   15: areturn
    //   16: new 62	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   23: aload_1
    //   24: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: getstatic 133	com/tencent/mm/storage/emotion/h$a:uDt	Lcom/tencent/mm/storage/emotion/h$a;
    //   30: getfield 76	com/tencent/mm/storage/emotion/h$a:value	I
    //   33: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore_1
    //   40: aload_0
    //   41: getfield 39	com/tencent/mm/storage/emotion/h:dXw	Lcom/tencent/mm/sdk/e/e;
    //   44: ldc 25
    //   46: iconst_1
    //   47: anewarray 17	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: ldc 85
    //   54: aastore
    //   55: ldc 87
    //   57: iconst_1
    //   58: anewarray 17	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: aload_1
    //   64: aastore
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: iconst_2
    //   69: invokeinterface 92 9 0
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +122 -> 198
    //   79: aload_1
    //   80: astore_2
    //   81: aload_1
    //   82: invokeinterface 98 1 0
    //   87: ifeq +111 -> 198
    //   90: aload_1
    //   91: astore_2
    //   92: new 135	com/tencent/mm/protocal/c/aes
    //   95: dup
    //   96: invokespecial 136	com/tencent/mm/protocal/c/aes:<init>	()V
    //   99: astore_3
    //   100: aload_1
    //   101: astore_2
    //   102: aload_3
    //   103: aload_1
    //   104: iconst_0
    //   105: invokeinterface 105 2 0
    //   110: invokevirtual 137	com/tencent/mm/protocal/c/aes:aH	([B)Lcom/tencent/mm/bv/a;
    //   113: pop
    //   114: aload_3
    //   115: astore_2
    //   116: aload_2
    //   117: astore_3
    //   118: aload_1
    //   119: ifnull +11 -> 130
    //   122: aload_1
    //   123: invokeinterface 112 1 0
    //   128: aload_2
    //   129: astore_3
    //   130: aload_3
    //   131: areturn
    //   132: astore_3
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: astore_2
    //   137: ldc 52
    //   139: ldc 114
    //   141: iconst_1
    //   142: anewarray 116	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_3
    //   148: invokestatic 120	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 124	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_1
    //   156: ifnull +37 -> 193
    //   159: aload_1
    //   160: invokeinterface 112 1 0
    //   165: aconst_null
    //   166: astore_3
    //   167: goto -37 -> 130
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_2
    //   173: aload_2
    //   174: ifnull +9 -> 183
    //   177: aload_2
    //   178: invokeinterface 112 1 0
    //   183: aload_1
    //   184: athrow
    //   185: astore_1
    //   186: goto -13 -> 173
    //   189: astore_3
    //   190: goto -55 -> 135
    //   193: aconst_null
    //   194: astore_3
    //   195: goto -65 -> 130
    //   198: aconst_null
    //   199: astore_2
    //   200: goto -84 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	h
    //   0	203	1	paramString	String
    //   80	120	2	localObject1	java.lang.Object
    //   99	32	3	localObject2	java.lang.Object
    //   132	16	3	localIOException1	java.io.IOException
    //   166	1	3	localObject3	java.lang.Object
    //   189	1	3	localIOException2	java.io.IOException
    //   194	1	3	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   40	75	132	java/io/IOException
    //   40	75	170	finally
    //   81	90	185	finally
    //   92	100	185	finally
    //   102	114	185	finally
    //   137	155	185	finally
    //   81	90	189	java/io/IOException
    //   92	100	189	java/io/IOException
    //   102	114	189	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.h
 * JD-Core Version:    0.7.0.1
 */