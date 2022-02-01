package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;

public final class k
  extends MAutoStorage<j>
  implements g.a
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(105114);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(j.info, "EmotionDesignerInfo") };
    AppMethodBeat.o(105114);
  }
  
  public k(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, j.info, "EmotionDesignerInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  /* Error */
  public final com.tencent.mm.protocal.protobuf.bmi blr(String paramString)
  {
    // Byte code:
    //   0: ldc 56
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 62	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +17 -> 26
    //   12: ldc 64
    //   14: ldc 66
    //   16: invokestatic 72	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 56
    //   21: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: new 74	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   33: aload_1
    //   34: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: getstatic 84	com/tencent/mm/storage/emotion/k$a:OsJ	Lcom/tencent/mm/storage/emotion/k$a;
    //   40: getfield 88	com/tencent/mm/storage/emotion/k$a:value	I
    //   43: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 50	com/tencent/mm/storage/emotion/k:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   54: ldc 33
    //   56: iconst_1
    //   57: anewarray 25	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: ldc 97
    //   64: aastore
    //   65: ldc 99
    //   67: iconst_1
    //   68: anewarray 25	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: iconst_2
    //   79: invokeinterface 105 9 0
    //   84: astore_1
    //   85: aload_1
    //   86: ifnull +132 -> 218
    //   89: aload_1
    //   90: astore_2
    //   91: aload_1
    //   92: invokeinterface 111 1 0
    //   97: ifeq +121 -> 218
    //   100: aload_1
    //   101: astore_2
    //   102: new 113	com/tencent/mm/protocal/protobuf/bmi
    //   105: dup
    //   106: invokespecial 114	com/tencent/mm/protocal/protobuf/bmi:<init>	()V
    //   109: astore_3
    //   110: aload_1
    //   111: astore_2
    //   112: aload_3
    //   113: aload_1
    //   114: iconst_0
    //   115: invokeinterface 118 2 0
    //   120: invokevirtual 122	com/tencent/mm/protocal/protobuf/bmi:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   123: pop
    //   124: aload_3
    //   125: astore_2
    //   126: aload_2
    //   127: astore_3
    //   128: aload_1
    //   129: ifnull +11 -> 140
    //   132: aload_1
    //   133: invokeinterface 125 1 0
    //   138: aload_2
    //   139: astore_3
    //   140: ldc 56
    //   142: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_3
    //   146: areturn
    //   147: astore_3
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: astore_2
    //   152: ldc 64
    //   154: ldc 127
    //   156: iconst_1
    //   157: anewarray 129	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload_3
    //   163: invokestatic 133	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   166: aastore
    //   167: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: aload_1
    //   171: ifnull +42 -> 213
    //   174: aload_1
    //   175: invokeinterface 125 1 0
    //   180: aconst_null
    //   181: astore_3
    //   182: goto -42 -> 140
    //   185: astore_1
    //   186: aconst_null
    //   187: astore_2
    //   188: aload_2
    //   189: ifnull +9 -> 198
    //   192: aload_2
    //   193: invokeinterface 125 1 0
    //   198: ldc 56
    //   200: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: goto -18 -> 188
    //   209: astore_3
    //   210: goto -60 -> 150
    //   213: aconst_null
    //   214: astore_3
    //   215: goto -75 -> 140
    //   218: aconst_null
    //   219: astore_2
    //   220: goto -94 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	k
    //   0	223	1	paramString	String
    //   90	130	2	localObject1	java.lang.Object
    //   109	37	3	localObject2	java.lang.Object
    //   147	16	3	localException1	java.lang.Exception
    //   181	1	3	localObject3	java.lang.Object
    //   209	1	3	localException2	java.lang.Exception
    //   214	1	3	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   50	85	147	java/lang/Exception
    //   50	85	185	finally
    //   91	100	205	finally
    //   102	110	205	finally
    //   112	124	205	finally
    //   152	170	205	finally
    //   91	100	209	java/lang/Exception
    //   102	110	209	java/lang/Exception
    //   112	124	209	java/lang/Exception
  }
  
  /* Error */
  public final com.tencent.mm.protocal.protobuf.bmg bls(String paramString)
  {
    // Byte code:
    //   0: ldc 142
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 62	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +17 -> 26
    //   12: ldc 64
    //   14: ldc 144
    //   16: invokestatic 72	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 142
    //   21: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: new 74	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   33: aload_1
    //   34: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: getstatic 147	com/tencent/mm/storage/emotion/k$a:OsL	Lcom/tencent/mm/storage/emotion/k$a;
    //   40: getfield 88	com/tencent/mm/storage/emotion/k$a:value	I
    //   43: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 50	com/tencent/mm/storage/emotion/k:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   54: ldc 33
    //   56: iconst_1
    //   57: anewarray 25	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: ldc 97
    //   64: aastore
    //   65: ldc 99
    //   67: iconst_1
    //   68: anewarray 25	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: iconst_2
    //   79: invokeinterface 105 9 0
    //   84: astore_1
    //   85: aload_1
    //   86: ifnull +132 -> 218
    //   89: aload_1
    //   90: astore_2
    //   91: aload_1
    //   92: invokeinterface 111 1 0
    //   97: ifeq +121 -> 218
    //   100: aload_1
    //   101: astore_2
    //   102: new 149	com/tencent/mm/protocal/protobuf/bmg
    //   105: dup
    //   106: invokespecial 150	com/tencent/mm/protocal/protobuf/bmg:<init>	()V
    //   109: astore_3
    //   110: aload_1
    //   111: astore_2
    //   112: aload_3
    //   113: aload_1
    //   114: iconst_0
    //   115: invokeinterface 118 2 0
    //   120: invokevirtual 151	com/tencent/mm/protocal/protobuf/bmg:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   123: pop
    //   124: aload_3
    //   125: astore_2
    //   126: aload_2
    //   127: astore_3
    //   128: aload_1
    //   129: ifnull +11 -> 140
    //   132: aload_1
    //   133: invokeinterface 125 1 0
    //   138: aload_2
    //   139: astore_3
    //   140: ldc 142
    //   142: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_3
    //   146: areturn
    //   147: astore_3
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: astore_2
    //   152: ldc 64
    //   154: ldc 127
    //   156: iconst_1
    //   157: anewarray 129	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload_3
    //   163: invokestatic 133	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   166: aastore
    //   167: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: aload_1
    //   171: ifnull +42 -> 213
    //   174: aload_1
    //   175: invokeinterface 125 1 0
    //   180: aconst_null
    //   181: astore_3
    //   182: goto -42 -> 140
    //   185: astore_1
    //   186: aconst_null
    //   187: astore_2
    //   188: aload_2
    //   189: ifnull +9 -> 198
    //   192: aload_2
    //   193: invokeinterface 125 1 0
    //   198: ldc 142
    //   200: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: goto -18 -> 188
    //   209: astore_3
    //   210: goto -60 -> 150
    //   213: aconst_null
    //   214: astore_3
    //   215: goto -75 -> 140
    //   218: aconst_null
    //   219: astore_2
    //   220: goto -94 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	k
    //   0	223	1	paramString	String
    //   90	130	2	localObject1	java.lang.Object
    //   109	37	3	localObject2	java.lang.Object
    //   147	16	3	localIOException1	java.io.IOException
    //   181	1	3	localObject3	java.lang.Object
    //   209	1	3	localIOException2	java.io.IOException
    //   214	1	3	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   50	85	147	java/io/IOException
    //   50	85	185	finally
    //   91	100	205	finally
    //   102	110	205	finally
    //   112	124	205	finally
    //   152	170	205	finally
    //   91	100	209	java/io/IOException
    //   102	110	209	java/io/IOException
    //   112	124	209	java/io/IOException
  }
  
  public static enum a
  {
    public int value;
    
    static
    {
      AppMethodBeat.i(105111);
      OsJ = new a("DesignerSimpleInfo", 0, 0);
      OsK = new a("PersonalDesigner", 1, 1);
      OsL = new a("DesignerEmojiList", 2, 2);
      OsM = new a[] { OsJ, OsK, OsL };
      AppMethodBeat.o(105111);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.k
 * JD-Core Version:    0.7.0.1
 */