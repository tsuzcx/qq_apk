package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.protocal.c.afa;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.protocal.c.bsl;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class p
  extends i<o>
  implements g.a
{
  public static final String[] dXp = { i.a(o.buS, "GetEmotionListCache") };
  private e dXw;
  
  public p(e parame)
  {
    this(parame, o.buS, "GetEmotionListCache");
  }
  
  private p(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.dXw = parame;
  }
  
  private boolean acK(String paramString)
  {
    return this.dXw.delete("GetEmotionListCache", "reqType=?", new String[] { paramString }) > 0;
  }
  
  public final afi FA(int paramInt)
  {
    Object localObject3 = null;
    Cursor localCursor = this.dXw.a("GetEmotionListCache", null, "reqType=?", new String[] { String.valueOf(paramInt) }, null, null, null, 2);
    Object localObject1 = localObject3;
    o localo;
    if (localCursor != null)
    {
      localObject1 = localObject3;
      if (localCursor.moveToFirst()) {
        localo = new o(localCursor);
      }
    }
    try
    {
      localObject1 = new afi();
      ((afi)localObject1).aH(localo.field_cache);
      y.d("MicroMsg.emoji.Storage", "succed get cache: %d", new Object[] { Integer.valueOf(paramInt) });
      if (localCursor != null) {
        localCursor.close();
      }
      return localObject1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { bk.j(localIOException) });
        Object localObject2 = localObject3;
      }
    }
  }
  
  public final int a(g paramg)
  {
    if (paramg != null) {
      this.dXw = paramg;
    }
    return 0;
  }
  
  public final boolean a(int paramInt, afi paramafi)
  {
    if (paramafi == null) {
      return false;
    }
    try
    {
      this.dXw.delete("GetEmotionListCache", "reqType=?", new String[] { String.valueOf(paramInt) });
      paramafi = new o(String.valueOf(paramInt), paramafi.toByteArray());
      y.d("MicroMsg.emoji.Storage", "insert cache: %d", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = b(paramafi);
      return bool;
    }
    catch (Exception paramafi)
    {
      y.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { bk.j(paramafi) });
    }
    return false;
  }
  
  public final boolean a(String paramString, afa paramafa)
  {
    if (paramafa == null) {
      return false;
    }
    try
    {
      acK(paramString);
      boolean bool = b(new o(paramString, paramafa.toByteArray()));
      return bool;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { bk.j(paramString) });
    }
    return false;
  }
  
  public final boolean a(String paramString, aix paramaix)
  {
    if (paramaix == null) {
      return false;
    }
    try
    {
      acK(paramString);
      boolean bool = b(new o(paramString, paramaix.toByteArray()));
      return bool;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { bk.j(paramString) });
    }
    return false;
  }
  
  /* Error */
  public final bsl aHm()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/tencent/mm/storage/emotion/p:dXw	Lcom/tencent/mm/sdk/e/e;
    //   4: ldc 23
    //   6: aconst_null
    //   7: ldc 44
    //   9: iconst_1
    //   10: anewarray 15	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc 144
    //   17: aastore
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokeinterface 148 8 0
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +122 -> 150
    //   31: aload_1
    //   32: astore_2
    //   33: aload_1
    //   34: invokeinterface 67 1 0
    //   39: ifeq +111 -> 150
    //   42: aload_1
    //   43: astore_2
    //   44: new 17	com/tencent/mm/storage/emotion/o
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 70	com/tencent/mm/storage/emotion/o:<init>	(Landroid/database/Cursor;)V
    //   52: astore 4
    //   54: aload_1
    //   55: astore_2
    //   56: new 150	com/tencent/mm/protocal/c/bsl
    //   59: dup
    //   60: invokespecial 151	com/tencent/mm/protocal/c/bsl:<init>	()V
    //   63: astore_3
    //   64: aload_1
    //   65: astore_2
    //   66: aload_3
    //   67: aload 4
    //   69: getfield 78	com/tencent/mm/storage/emotion/o:field_cache	[B
    //   72: invokevirtual 152	com/tencent/mm/protocal/c/bsl:aH	([B)Lcom/tencent/mm/bv/a;
    //   75: pop
    //   76: aload_3
    //   77: astore_2
    //   78: aload_1
    //   79: ifnull +9 -> 88
    //   82: aload_1
    //   83: invokeinterface 102 1 0
    //   88: aload_2
    //   89: areturn
    //   90: astore_3
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore_2
    //   95: ldc 84
    //   97: ldc 104
    //   99: iconst_1
    //   100: anewarray 88	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_3
    //   106: invokestatic 110	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   109: aastore
    //   110: invokestatic 113	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: aload_1
    //   114: ifnull +34 -> 148
    //   117: aload_1
    //   118: invokeinterface 102 1 0
    //   123: aconst_null
    //   124: areturn
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_2
    //   128: aload_2
    //   129: ifnull +9 -> 138
    //   132: aload_2
    //   133: invokeinterface 102 1 0
    //   138: aload_1
    //   139: athrow
    //   140: astore_1
    //   141: goto -13 -> 128
    //   144: astore_3
    //   145: goto -52 -> 93
    //   148: aconst_null
    //   149: areturn
    //   150: aconst_null
    //   151: astore_2
    //   152: goto -74 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	p
    //   26	92	1	localCursor	Cursor
    //   125	14	1	localObject1	Object
    //   140	1	1	localObject2	Object
    //   32	120	2	localObject3	Object
    //   63	14	3	localbsl	bsl
    //   90	16	3	localException1	Exception
    //   144	1	3	localException2	Exception
    //   52	16	4	localo	o
    // Exception table:
    //   from	to	target	type
    //   0	27	90	java/lang/Exception
    //   0	27	125	finally
    //   33	42	140	finally
    //   44	54	140	finally
    //   56	64	140	finally
    //   66	76	140	finally
    //   95	113	140	finally
    //   33	42	144	java/lang/Exception
    //   44	54	144	java/lang/Exception
    //   56	64	144	java/lang/Exception
    //   66	76	144	java/lang/Exception
  }
  
  public final aix acL(String paramString)
  {
    Object localObject2 = null;
    Cursor localCursor = this.dXw.a("GetEmotionListCache", null, "reqType=?", new String[] { paramString }, null, null, null, 2);
    Object localObject1 = localObject2;
    o localo;
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst()) {
        localo = new o(localCursor);
      }
    }
    try
    {
      localObject1 = new aix();
      ((aix)localObject1).aH(localo.field_cache);
      y.d("MicroMsg.emoji.Storage", "succed get designerID cache: %s", new Object[] { paramString });
      if (localCursor != null) {
        localCursor.close();
      }
      return localObject1;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { bk.j(paramString) });
        localObject1 = localObject2;
      }
    }
  }
  
  /* Error */
  public final afa acM(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 163	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifeq +12 -> 16
    //   7: ldc 84
    //   9: ldc 165
    //   11: invokestatic 169	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: getfield 40	com/tencent/mm/storage/emotion/p:dXw	Lcom/tencent/mm/sdk/e/e;
    //   20: ldc 23
    //   22: aconst_null
    //   23: ldc 44
    //   25: iconst_1
    //   26: anewarray 15	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: aload_1
    //   32: aastore
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: invokeinterface 148 8 0
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +132 -> 175
    //   46: aload_1
    //   47: astore_2
    //   48: aload_1
    //   49: invokeinterface 67 1 0
    //   54: ifeq +121 -> 175
    //   57: aload_1
    //   58: astore_2
    //   59: new 17	com/tencent/mm/storage/emotion/o
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 70	com/tencent/mm/storage/emotion/o:<init>	(Landroid/database/Cursor;)V
    //   67: astore 4
    //   69: aload_1
    //   70: astore_2
    //   71: new 135	com/tencent/mm/protocal/c/afa
    //   74: dup
    //   75: invokespecial 170	com/tencent/mm/protocal/c/afa:<init>	()V
    //   78: astore_3
    //   79: aload_1
    //   80: astore_2
    //   81: aload_3
    //   82: aload 4
    //   84: getfield 78	com/tencent/mm/storage/emotion/o:field_cache	[B
    //   87: invokevirtual 171	com/tencent/mm/protocal/c/afa:aH	([B)Lcom/tencent/mm/bv/a;
    //   90: pop
    //   91: aload_3
    //   92: astore_2
    //   93: aload_2
    //   94: astore_3
    //   95: aload_1
    //   96: ifnull +11 -> 107
    //   99: aload_1
    //   100: invokeinterface 102 1 0
    //   105: aload_2
    //   106: astore_3
    //   107: aload_3
    //   108: areturn
    //   109: astore_3
    //   110: aconst_null
    //   111: astore_1
    //   112: aload_1
    //   113: astore_2
    //   114: ldc 84
    //   116: ldc 104
    //   118: iconst_1
    //   119: anewarray 88	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_3
    //   125: invokestatic 110	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   128: aastore
    //   129: invokestatic 113	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload_1
    //   133: ifnull +37 -> 170
    //   136: aload_1
    //   137: invokeinterface 102 1 0
    //   142: aconst_null
    //   143: astore_3
    //   144: goto -37 -> 107
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_2
    //   150: aload_2
    //   151: ifnull +9 -> 160
    //   154: aload_2
    //   155: invokeinterface 102 1 0
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: goto -13 -> 150
    //   166: astore_3
    //   167: goto -55 -> 112
    //   170: aconst_null
    //   171: astore_3
    //   172: goto -65 -> 107
    //   175: aconst_null
    //   176: astore_2
    //   177: goto -84 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	p
    //   0	180	1	paramString	String
    //   47	130	2	localObject1	Object
    //   78	30	3	localObject2	Object
    //   109	16	3	localIOException1	IOException
    //   143	1	3	localObject3	Object
    //   166	1	3	localIOException2	IOException
    //   171	1	3	localObject4	Object
    //   67	16	4	localo	o
    // Exception table:
    //   from	to	target	type
    //   16	42	109	java/io/IOException
    //   16	42	147	finally
    //   48	57	162	finally
    //   59	69	162	finally
    //   71	79	162	finally
    //   81	91	162	finally
    //   114	132	162	finally
    //   48	57	166	java/io/IOException
    //   59	69	166	java/io/IOException
    //   71	79	166	java/io/IOException
    //   81	91	166	java/io/IOException
  }
  
  public final boolean b(bsl parambsl)
  {
    if (parambsl == null) {
      return false;
    }
    try
    {
      acK("Smiley_panel_req_type");
      boolean bool = b(new o("Smiley_panel_req_type", parambsl.toByteArray()));
      return bool;
    }
    catch (Exception parambsl)
    {
      y.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { bk.j(parambsl) });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.p
 * JD-Core Version:    0.7.0.1
 */