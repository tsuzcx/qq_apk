package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public class h
{
  private static volatile h rIb = null;
  private q rIc = null;
  
  /* Error */
  private static byte[] b(q paramq)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 24	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 25	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_1
    //   14: new 27	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 30	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore 5
    //   24: aload 5
    //   26: astore_3
    //   27: aload_1
    //   28: astore_2
    //   29: aload 5
    //   31: aload_0
    //   32: invokevirtual 34	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   35: aload 5
    //   37: astore_3
    //   38: aload_1
    //   39: astore_2
    //   40: aload 5
    //   42: invokevirtual 37	java/io/ObjectOutputStream:flush	()V
    //   45: aload 5
    //   47: astore_3
    //   48: aload_1
    //   49: astore_2
    //   50: aload_1
    //   51: invokevirtual 41	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   54: astore_0
    //   55: aload 5
    //   57: invokevirtual 44	java/io/ObjectOutputStream:close	()V
    //   60: aload_1
    //   61: invokevirtual 45	java/io/ByteArrayOutputStream:close	()V
    //   64: aload_0
    //   65: areturn
    //   66: astore_1
    //   67: ldc 47
    //   69: ldc 49
    //   71: iconst_1
    //   72: anewarray 4	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload_1
    //   78: aastore
    //   79: invokestatic 55	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: aload_0
    //   83: areturn
    //   84: astore 4
    //   86: aconst_null
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_0
    //   91: astore_3
    //   92: aload_1
    //   93: astore_2
    //   94: ldc 47
    //   96: ldc 57
    //   98: iconst_1
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload 4
    //   106: aastore
    //   107: invokestatic 55	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_0
    //   111: ifnull +7 -> 118
    //   114: aload_0
    //   115: invokevirtual 44	java/io/ObjectOutputStream:close	()V
    //   118: aload_1
    //   119: ifnull -115 -> 4
    //   122: aload_1
    //   123: invokevirtual 45	java/io/ByteArrayOutputStream:close	()V
    //   126: aconst_null
    //   127: areturn
    //   128: astore_0
    //   129: ldc 47
    //   131: ldc 49
    //   133: iconst_1
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload_0
    //   140: aastore
    //   141: invokestatic 55	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: aconst_null
    //   148: astore_3
    //   149: aconst_null
    //   150: astore_1
    //   151: aload_3
    //   152: ifnull +7 -> 159
    //   155: aload_3
    //   156: invokevirtual 44	java/io/ObjectOutputStream:close	()V
    //   159: aload_1
    //   160: ifnull +7 -> 167
    //   163: aload_1
    //   164: invokevirtual 45	java/io/ByteArrayOutputStream:close	()V
    //   167: aload_0
    //   168: athrow
    //   169: astore_1
    //   170: ldc 47
    //   172: ldc 49
    //   174: iconst_1
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload_1
    //   181: aastore
    //   182: invokestatic 55	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: goto -18 -> 167
    //   188: astore_0
    //   189: aconst_null
    //   190: astore_3
    //   191: goto -40 -> 151
    //   194: astore_0
    //   195: aload_2
    //   196: astore_1
    //   197: goto -46 -> 151
    //   200: astore 4
    //   202: aconst_null
    //   203: astore_0
    //   204: goto -114 -> 90
    //   207: astore 4
    //   209: aload 5
    //   211: astore_0
    //   212: goto -122 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramq	q
    //   13	48	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   66	12	1	localException1	java.lang.Exception
    //   89	75	1	localObject1	Object
    //   169	12	1	localException2	java.lang.Exception
    //   196	1	1	localObject2	Object
    //   28	168	2	localObject3	Object
    //   26	165	3	localObject4	Object
    //   84	21	4	localException3	java.lang.Exception
    //   200	1	4	localException4	java.lang.Exception
    //   207	1	4	localException5	java.lang.Exception
    //   22	188	5	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   55	64	66	java/lang/Exception
    //   6	14	84	java/lang/Exception
    //   114	118	128	java/lang/Exception
    //   122	126	128	java/lang/Exception
    //   6	14	146	finally
    //   155	159	169	java/lang/Exception
    //   163	167	169	java/lang/Exception
    //   14	24	188	finally
    //   29	35	194	finally
    //   40	45	194	finally
    //   50	55	194	finally
    //   94	110	194	finally
    //   14	24	200	java/lang/Exception
    //   29	35	207	java/lang/Exception
    //   40	45	207	java/lang/Exception
    //   50	55	207	java/lang/Exception
  }
  
  /* Error */
  private static q bh(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: arraylength
    //   6: ifgt +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 61	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 64	java/io/ByteArrayInputStream:<init>	([B)V
    //   19: astore_1
    //   20: new 66	java/io/ObjectInputStream
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 69	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_0
    //   29: aload_0
    //   30: astore_3
    //   31: aload_1
    //   32: astore_2
    //   33: aload_0
    //   34: invokevirtual 73	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   37: checkcast 75	com/tencent/mm/plugin/wenote/model/a/q
    //   40: astore 4
    //   42: aload_0
    //   43: invokevirtual 76	java/io/ObjectInputStream:close	()V
    //   46: aload_1
    //   47: invokevirtual 77	java/io/ByteArrayInputStream:close	()V
    //   50: aload 4
    //   52: areturn
    //   53: astore_0
    //   54: ldc 47
    //   56: ldc 79
    //   58: iconst_1
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_0
    //   65: aastore
    //   66: invokestatic 55	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload 4
    //   71: areturn
    //   72: astore 4
    //   74: aconst_null
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_0
    //   79: astore_3
    //   80: aload_1
    //   81: astore_2
    //   82: ldc 47
    //   84: ldc 81
    //   86: iconst_1
    //   87: anewarray 4	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: aload 4
    //   94: aastore
    //   95: invokestatic 55	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 76	java/io/ObjectInputStream:close	()V
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 77	java/io/ByteArrayInputStream:close	()V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_0
    //   117: ldc 47
    //   119: ldc 79
    //   121: iconst_1
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_0
    //   128: aastore
    //   129: invokestatic 55	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aconst_null
    //   133: areturn
    //   134: astore_0
    //   135: aconst_null
    //   136: astore_3
    //   137: aconst_null
    //   138: astore_1
    //   139: aload_3
    //   140: ifnull +7 -> 147
    //   143: aload_3
    //   144: invokevirtual 76	java/io/ObjectInputStream:close	()V
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 77	java/io/ByteArrayInputStream:close	()V
    //   155: aload_0
    //   156: athrow
    //   157: astore_1
    //   158: ldc 47
    //   160: ldc 79
    //   162: iconst_1
    //   163: anewarray 4	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload_1
    //   169: aastore
    //   170: invokestatic 55	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: goto -18 -> 155
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_3
    //   179: goto -40 -> 139
    //   182: astore_0
    //   183: aload_2
    //   184: astore_1
    //   185: goto -46 -> 139
    //   188: astore 4
    //   190: aconst_null
    //   191: astore_0
    //   192: goto -114 -> 78
    //   195: astore 4
    //   197: goto -119 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramArrayOfByte	byte[]
    //   19	133	1	localByteArrayInputStream1	java.io.ByteArrayInputStream
    //   157	12	1	localException1	java.lang.Exception
    //   184	1	1	localObject	Object
    //   32	152	2	localByteArrayInputStream2	java.io.ByteArrayInputStream
    //   30	149	3	arrayOfByte	byte[]
    //   40	30	4	localq	q
    //   72	21	4	localException2	java.lang.Exception
    //   188	1	4	localException3	java.lang.Exception
    //   195	1	4	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   42	50	53	java/lang/Exception
    //   11	20	72	java/lang/Exception
    //   102	106	116	java/lang/Exception
    //   110	114	116	java/lang/Exception
    //   11	20	134	finally
    //   143	147	157	java/lang/Exception
    //   151	155	157	java/lang/Exception
    //   20	29	176	finally
    //   33	42	182	finally
    //   82	98	182	finally
    //   20	29	188	java/lang/Exception
    //   33	42	195	java/lang/Exception
  }
  
  public static h cir()
  {
    if (rIb == null) {}
    try
    {
      if (rIb == null) {
        rIb = new h();
      }
      return rIb;
    }
    finally {}
  }
  
  public final void a(q paramq)
  {
    this.rIc = paramq;
    byte[] arrayOfByte = b(this.rIc);
    String str = "";
    paramq = str;
    if (arrayOfByte != null)
    {
      paramq = str;
      if (arrayOfByte.length > 0) {
        paramq = bk.bG(arrayOfByte);
      }
    }
    if (this.rIc != null) {}
    for (str = this.rIc.chC();; str = "null")
    {
      y.i("WNNoteKeepTopManager", "setCurrentTopItem item: %s", new Object[] { str });
      y.i("WNNoteKeepTopManager", "setCurrentTopItem itemStr: %s", new Object[] { paramq });
      au.Hx();
      c.Dz().c(ac.a.uwx, bk.pm(paramq));
      return;
    }
  }
  
  public final q cis()
  {
    if (this.rIc != null) {
      return this.rIc;
    }
    au.Hx();
    Object localObject = (String)c.Dz().get(ac.a.uwx, "");
    y.d("WNNoteKeepTopManager", "getCurrentTopItem itemStr: %s", new Object[] { localObject });
    if (bk.bl((String)localObject)) {
      return null;
    }
    localObject = bk.ZM((String)localObject);
    if (localObject.length <= 0) {
      return null;
    }
    this.rIc = bh((byte[])localObject);
    if (this.rIc != null) {}
    for (localObject = this.rIc.chC();; localObject = "null")
    {
      y.d("WNNoteKeepTopManager", "getCurrentTopItem item: %s", new Object[] { localObject });
      return this.rIc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.h
 * JD-Core Version:    0.7.0.1
 */