package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class p
  extends j<o>
  implements g.a
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(62878);
    SQL_CREATE = new String[] { j.getCreateSQLs(o.info, "GetEmotionListCache") };
    AppMethodBeat.o(62878);
  }
  
  public p(e parame)
  {
    this(parame, o.info, "GetEmotionListCache");
  }
  
  private p(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.db = parame;
  }
  
  private boolean asY(String paramString)
  {
    AppMethodBeat.i(62869);
    if (this.db.delete("GetEmotionListCache", "reqType=?", new String[] { paramString }) > 0)
    {
      AppMethodBeat.o(62869);
      return true;
    }
    AppMethodBeat.o(62869);
    return false;
  }
  
  public final GetEmotionListResponse NK(int paramInt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(62871);
    Cursor localCursor = this.db.a("GetEmotionListCache", null, "reqType=?", new String[] { String.valueOf(paramInt) }, null, null, null, 2);
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
      localObject1 = new GetEmotionListResponse();
      ((GetEmotionListResponse)localObject1).parseFrom(localo.field_cache);
      ab.d("MicroMsg.emoji.Storage", "succed get cache: %d", new Object[] { Integer.valueOf(paramInt) });
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(62871);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { bo.l(localIOException) });
        Object localObject2 = localObject3;
      }
    }
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean a(int paramInt, GetEmotionListResponse paramGetEmotionListResponse)
  {
    AppMethodBeat.i(62870);
    if (paramGetEmotionListResponse == null)
    {
      AppMethodBeat.o(62870);
      return false;
    }
    try
    {
      this.db.delete("GetEmotionListCache", "reqType=?", new String[] { String.valueOf(paramInt) });
      paramGetEmotionListResponse = new o(String.valueOf(paramInt), paramGetEmotionListResponse.toByteArray());
      ab.d("MicroMsg.emoji.Storage", "insert cache: %d", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = insert(paramGetEmotionListResponse);
      AppMethodBeat.o(62870);
      return bool;
    }
    catch (Exception paramGetEmotionListResponse)
    {
      ab.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { bo.l(paramGetEmotionListResponse) });
      AppMethodBeat.o(62870);
    }
    return false;
  }
  
  public final boolean a(String paramString, ajx paramajx)
  {
    AppMethodBeat.i(62877);
    if (paramajx == null)
    {
      AppMethodBeat.o(62877);
      return false;
    }
    try
    {
      asY(paramString);
      boolean bool = insert(new o(paramString, paramajx.toByteArray()));
      AppMethodBeat.o(62877);
      return bool;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(62877);
    }
    return false;
  }
  
  public final boolean a(String paramString, aoc paramaoc)
  {
    AppMethodBeat.i(62872);
    if (paramaoc == null)
    {
      AppMethodBeat.o(62872);
      return false;
    }
    try
    {
      asY(paramString);
      boolean bool = insert(new o(paramString, paramaoc.toByteArray()));
      AppMethodBeat.o(62872);
      return bool;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(62872);
    }
    return false;
  }
  
  public final aoc asZ(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(62873);
    Cursor localCursor = this.db.a("GetEmotionListCache", null, "reqType=?", new String[] { paramString }, null, null, null, 2);
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
      localObject1 = new aoc();
      ((aoc)localObject1).parseFrom(localo.field_cache);
      ab.d("MicroMsg.emoji.Storage", "succed get designerID cache: %s", new Object[] { paramString });
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(62873);
      return localObject1;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { bo.l(paramString) });
        localObject1 = localObject2;
      }
    }
  }
  
  /* Error */
  public final ajx ata(String paramString)
  {
    // Byte code:
    //   0: ldc 166
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 169	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +17 -> 26
    //   12: ldc 97
    //   14: ldc 171
    //   16: invokestatic 175	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 166
    //   21: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: getfield 50	com/tencent/mm/storage/emotion/p:db	Lcom/tencent/mm/sdk/e/e;
    //   30: ldc 30
    //   32: aconst_null
    //   33: ldc 55
    //   35: iconst_1
    //   36: anewarray 22	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: aastore
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokeinterface 179 8 0
    //   51: astore_1
    //   52: aload_1
    //   53: ifnull +142 -> 195
    //   56: aload_1
    //   57: astore_2
    //   58: aload_1
    //   59: invokeinterface 80 1 0
    //   64: ifeq +131 -> 195
    //   67: aload_1
    //   68: astore_2
    //   69: new 24	com/tencent/mm/storage/emotion/o
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 83	com/tencent/mm/storage/emotion/o:<init>	(Landroid/database/Cursor;)V
    //   77: astore 4
    //   79: aload_1
    //   80: astore_2
    //   81: new 150	com/tencent/mm/protocal/protobuf/ajx
    //   84: dup
    //   85: invokespecial 180	com/tencent/mm/protocal/protobuf/ajx:<init>	()V
    //   88: astore_3
    //   89: aload_1
    //   90: astore_2
    //   91: aload_3
    //   92: aload 4
    //   94: getfield 91	com/tencent/mm/storage/emotion/o:field_cache	[B
    //   97: invokevirtual 181	com/tencent/mm/protocal/protobuf/ajx:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   100: pop
    //   101: aload_3
    //   102: astore_2
    //   103: aload_2
    //   104: astore_3
    //   105: aload_1
    //   106: ifnull +11 -> 117
    //   109: aload_1
    //   110: invokeinterface 115 1 0
    //   115: aload_2
    //   116: astore_3
    //   117: ldc 166
    //   119: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_3
    //   123: areturn
    //   124: astore_3
    //   125: aconst_null
    //   126: astore_1
    //   127: aload_1
    //   128: astore_2
    //   129: ldc 97
    //   131: ldc 117
    //   133: iconst_1
    //   134: anewarray 101	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload_3
    //   140: invokestatic 123	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   143: aastore
    //   144: invokestatic 126	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: aload_1
    //   148: ifnull +42 -> 190
    //   151: aload_1
    //   152: invokeinterface 115 1 0
    //   157: aconst_null
    //   158: astore_3
    //   159: goto -42 -> 117
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: ifnull +9 -> 175
    //   169: aload_2
    //   170: invokeinterface 115 1 0
    //   175: ldc 166
    //   177: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: goto -18 -> 165
    //   186: astore_3
    //   187: goto -60 -> 127
    //   190: aconst_null
    //   191: astore_3
    //   192: goto -75 -> 117
    //   195: aconst_null
    //   196: astore_2
    //   197: goto -94 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	p
    //   0	200	1	paramString	String
    //   57	140	2	localObject1	Object
    //   88	35	3	localObject2	Object
    //   124	16	3	localIOException1	IOException
    //   158	1	3	localObject3	Object
    //   186	1	3	localIOException2	IOException
    //   191	1	3	localObject4	Object
    //   77	16	4	localo	o
    // Exception table:
    //   from	to	target	type
    //   26	52	124	java/io/IOException
    //   26	52	162	finally
    //   58	67	182	finally
    //   69	79	182	finally
    //   81	89	182	finally
    //   91	101	182	finally
    //   129	147	182	finally
    //   58	67	186	java/io/IOException
    //   69	79	186	java/io/IOException
    //   81	89	186	java/io/IOException
    //   91	101	186	java/io/IOException
  }
  
  public final boolean b(cda paramcda)
  {
    AppMethodBeat.i(62875);
    if (paramcda == null)
    {
      AppMethodBeat.o(62875);
      return false;
    }
    try
    {
      asY("Smiley_panel_req_type");
      boolean bool = insert(new o("Smiley_panel_req_type", paramcda.toByteArray()));
      AppMethodBeat.o(62875);
      return bool;
    }
    catch (Exception paramcda)
    {
      ab.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { bo.l(paramcda) });
      AppMethodBeat.o(62875);
    }
    return false;
  }
  
  /* Error */
  public final cda blb()
  {
    // Byte code:
    //   0: ldc 192
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 50	com/tencent/mm/storage/emotion/p:db	Lcom/tencent/mm/sdk/e/e;
    //   9: ldc 30
    //   11: aconst_null
    //   12: ldc 55
    //   14: iconst_1
    //   15: anewarray 22	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc 186
    //   22: aastore
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokeinterface 179 8 0
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +142 -> 175
    //   36: aload_1
    //   37: astore_2
    //   38: aload_1
    //   39: invokeinterface 80 1 0
    //   44: ifeq +131 -> 175
    //   47: aload_1
    //   48: astore_2
    //   49: new 24	com/tencent/mm/storage/emotion/o
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 83	com/tencent/mm/storage/emotion/o:<init>	(Landroid/database/Cursor;)V
    //   57: astore 4
    //   59: aload_1
    //   60: astore_2
    //   61: new 188	com/tencent/mm/protocal/protobuf/cda
    //   64: dup
    //   65: invokespecial 193	com/tencent/mm/protocal/protobuf/cda:<init>	()V
    //   68: astore_3
    //   69: aload_1
    //   70: astore_2
    //   71: aload_3
    //   72: aload 4
    //   74: getfield 91	com/tencent/mm/storage/emotion/o:field_cache	[B
    //   77: invokevirtual 194	com/tencent/mm/protocal/protobuf/cda:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   80: pop
    //   81: aload_3
    //   82: astore_2
    //   83: aload_2
    //   84: astore_3
    //   85: aload_1
    //   86: ifnull +11 -> 97
    //   89: aload_1
    //   90: invokeinterface 115 1 0
    //   95: aload_2
    //   96: astore_3
    //   97: ldc 192
    //   99: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: areturn
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: astore_2
    //   109: ldc 97
    //   111: ldc 117
    //   113: iconst_1
    //   114: anewarray 101	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_3
    //   120: invokestatic 123	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   123: aastore
    //   124: invokestatic 126	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_1
    //   128: ifnull +42 -> 170
    //   131: aload_1
    //   132: invokeinterface 115 1 0
    //   137: aconst_null
    //   138: astore_3
    //   139: goto -42 -> 97
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 115 1 0
    //   155: ldc 192
    //   157: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: goto -18 -> 145
    //   166: astore_3
    //   167: goto -60 -> 107
    //   170: aconst_null
    //   171: astore_3
    //   172: goto -75 -> 97
    //   175: aconst_null
    //   176: astore_2
    //   177: goto -94 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	p
    //   31	101	1	localCursor	Cursor
    //   142	19	1	localObject1	Object
    //   162	1	1	localObject2	Object
    //   37	140	2	localObject3	Object
    //   68	35	3	localObject4	Object
    //   104	16	3	localException1	Exception
    //   138	1	3	localObject5	Object
    //   166	1	3	localException2	Exception
    //   171	1	3	localObject6	Object
    //   57	16	4	localo	o
    // Exception table:
    //   from	to	target	type
    //   5	32	104	java/lang/Exception
    //   5	32	142	finally
    //   38	47	162	finally
    //   49	59	162	finally
    //   61	69	162	finally
    //   71	81	162	finally
    //   109	127	162	finally
    //   38	47	166	java/lang/Exception
    //   49	59	166	java/lang/Exception
    //   61	69	166	java/lang/Exception
    //   71	81	166	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.p
 * JD-Core Version:    0.7.0.1
 */