package oicq.wlogin_sdk.request;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TreeMap;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public final class c
{
  Context _context;
  TreeMap<Long, WloginAllSigInfo> ajGD;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(88054);
    this.ajGD = new TreeMap();
    this._context = paramContext;
    AppMethodBeat.o(88054);
  }
  
  /* Error */
  private WloginAllSigInfo BV(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 35
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 37
    //   9: ldc 39
    //   11: lload_1
    //   12: invokestatic 45	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   15: invokevirtual 49	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 55	oicq/wlogin_sdk/tools/util:ry	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: getfield 26	oicq/wlogin_sdk/request/c:ajGD	Ljava/util/TreeMap;
    //   25: new 57	java/lang/Long
    //   28: dup
    //   29: lload_1
    //   30: invokespecial 60	java/lang/Long:<init>	(J)V
    //   33: invokevirtual 64	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 66	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +12 -> 53
    //   44: ldc 35
    //   46: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_3
    //   52: areturn
    //   53: aload_0
    //   54: getfield 28	oicq/wlogin_sdk/request/c:_context	Landroid/content/Context;
    //   57: ifnonnull +13 -> 70
    //   60: ldc 35
    //   62: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aconst_null
    //   66: astore_3
    //   67: goto -18 -> 49
    //   70: aload_0
    //   71: getfield 28	oicq/wlogin_sdk/request/c:_context	Landroid/content/Context;
    //   74: ldc 68
    //   76: invokestatic 72	oicq/wlogin_sdk/request/c:dw	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   79: astore_3
    //   80: aload_3
    //   81: ifnonnull +13 -> 94
    //   84: ldc 35
    //   86: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aconst_null
    //   90: astore_3
    //   91: goto -42 -> 49
    //   94: aload_3
    //   95: new 57	java/lang/Long
    //   98: dup
    //   99: lload_1
    //   100: invokespecial 60	java/lang/Long:<init>	(J)V
    //   103: invokevirtual 64	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   106: checkcast 66	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   109: astore_3
    //   110: aload_3
    //   111: ifnonnull +20 -> 131
    //   114: ldc 37
    //   116: ldc 74
    //   118: invokestatic 55	oicq/wlogin_sdk/tools/util:ry	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: ldc 35
    //   123: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aconst_null
    //   127: astore_3
    //   128: goto -79 -> 49
    //   131: aload_0
    //   132: getfield 26	oicq/wlogin_sdk/request/c:ajGD	Ljava/util/TreeMap;
    //   135: new 57	java/lang/Long
    //   138: dup
    //   139: lload_1
    //   140: invokespecial 60	java/lang/Long:<init>	(J)V
    //   143: aload_3
    //   144: invokevirtual 78	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: aload_3
    //   149: invokevirtual 82	oicq/wlogin_sdk/request/WloginAllSigInfo:get_clone	()Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   152: astore_3
    //   153: ldc 35
    //   155: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: goto -109 -> 49
    //   161: astore_3
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_3
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	c
    //   0	166	1	paramLong	long
    //   39	114	3	localObject1	Object
    //   161	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	40	161	finally
    //   44	49	161	finally
    //   53	65	161	finally
    //   70	80	161	finally
    //   84	89	161	finally
    //   94	110	161	finally
    //   114	126	161	finally
    //   131	158	161	finally
  }
  
  /* Error */
  private static int a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 89
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 91	oicq/wlogin_sdk/request/a
    //   10: dup
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial 94	oicq/wlogin_sdk/request/a:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   16: astore_0
    //   17: aload_0
    //   18: invokevirtual 98	oicq/wlogin_sdk/request/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore 4
    //   23: aload 4
    //   25: new 100	java/lang/StringBuilder
    //   28: dup
    //   29: ldc 102
    //   31: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 111
    //   40: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 113
    //   49: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokevirtual 122	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   58: aload 4
    //   60: aload_1
    //   61: iconst_1
    //   62: anewarray 41	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: ldc 124
    //   69: aastore
    //   70: ldc 126
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: invokevirtual 130	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore_3
    //   80: aload_3
    //   81: invokeinterface 136 1 0
    //   86: ifne +55 -> 141
    //   89: aload 4
    //   91: new 100	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 138
    //   97: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_1
    //   101: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 140
    //   106: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc 142
    //   115: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: iconst_2
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: iconst_0
    //   128: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: iconst_1
    //   135: newarray byte
    //   137: aastore
    //   138: invokevirtual 150	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload 4
    //   143: new 100	java/lang/StringBuilder
    //   146: dup
    //   147: ldc 152
    //   149: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload_1
    //   153: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 154
    //   158: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_1
    //   162: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 156
    //   167: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: iconst_1
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload_2
    //   180: aastore
    //   181: invokevirtual 150	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload_3
    //   185: invokeinterface 159 1 0
    //   190: aload_0
    //   191: invokevirtual 160	oicq/wlogin_sdk/request/a:close	()V
    //   194: ldc 89
    //   196: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: iconst_0
    //   200: ireturn
    //   201: astore_0
    //   202: aload_3
    //   203: astore_1
    //   204: aload_0
    //   205: invokestatic 164	oicq/wlogin_sdk/tools/util:p	(Ljava/lang/Exception;)V
    //   208: aload_1
    //   209: ifnull +7 -> 216
    //   212: aload_1
    //   213: invokevirtual 160	oicq/wlogin_sdk/request/a:close	()V
    //   216: ldc 89
    //   218: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: sipush -1022
    //   224: ireturn
    //   225: astore_1
    //   226: aload_1
    //   227: invokestatic 164	oicq/wlogin_sdk/tools/util:p	(Ljava/lang/Exception;)V
    //   230: aload_0
    //   231: invokevirtual 160	oicq/wlogin_sdk/request/a:close	()V
    //   234: ldc 89
    //   236: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: sipush -1022
    //   242: ireturn
    //   243: astore_1
    //   244: aload_1
    //   245: invokestatic 164	oicq/wlogin_sdk/tools/util:p	(Ljava/lang/Exception;)V
    //   248: aload_0
    //   249: invokevirtual 160	oicq/wlogin_sdk/request/a:close	()V
    //   252: ldc 89
    //   254: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: sipush -1022
    //   260: ireturn
    //   261: astore_1
    //   262: aload_1
    //   263: invokestatic 164	oicq/wlogin_sdk/tools/util:p	(Ljava/lang/Exception;)V
    //   266: aload_3
    //   267: invokeinterface 159 1 0
    //   272: aload_0
    //   273: invokevirtual 160	oicq/wlogin_sdk/request/a:close	()V
    //   276: ldc 89
    //   278: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: sipush -1022
    //   284: ireturn
    //   285: astore_1
    //   286: aload_1
    //   287: invokestatic 164	oicq/wlogin_sdk/tools/util:p	(Ljava/lang/Exception;)V
    //   290: aload_3
    //   291: invokeinterface 159 1 0
    //   296: aload_0
    //   297: invokevirtual 160	oicq/wlogin_sdk/request/a:close	()V
    //   300: ldc 89
    //   302: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: sipush -1022
    //   308: ireturn
    //   309: astore_2
    //   310: aload_0
    //   311: astore_1
    //   312: aload_2
    //   313: astore_0
    //   314: goto -110 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	paramContext	Context
    //   0	317	1	paramString	String
    //   0	317	2	paramArrayOfByte	byte[]
    //   1	290	3	localCursor	android.database.Cursor
    //   21	121	4	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   7	17	201	java/lang/Exception
    //   23	58	225	android/database/SQLException
    //   58	80	243	android/database/SQLException
    //   89	141	261	android/database/SQLException
    //   141	184	285	android/database/SQLException
    //   17	23	309	java/lang/Exception
  }
  
  private int a(TreeMap paramTreeMap, String paramString)
  {
    try
    {
      AppMethodBeat.i(88059);
      int i = 0;
      if (paramString == "tk_file") {
        i = b(paramTreeMap, paramString);
      }
      AppMethodBeat.o(88059);
      return i;
    }
    finally {}
  }
  
  /* Error */
  private int b(TreeMap paramTreeMap, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 170
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 172	javax/crypto/spec/SecretKeySpec
    //   10: dup
    //   11: getstatic 178	oicq/wlogin_sdk/request/i:ajHf	[B
    //   14: ldc 180
    //   16: invokespecial 183	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   19: astore 5
    //   21: ldc 180
    //   23: invokestatic 189	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   26: astore 4
    //   28: aload 4
    //   30: iconst_1
    //   31: aload 5
    //   33: invokevirtual 193	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   36: new 195	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: invokespecial 196	java/io/ByteArrayOutputStream:<init>	()V
    //   43: astore 5
    //   45: new 198	java/io/ObjectOutputStream
    //   48: dup
    //   49: new 200	javax/crypto/CipherOutputStream
    //   52: dup
    //   53: aload 5
    //   55: aload 4
    //   57: invokespecial 203	javax/crypto/CipherOutputStream:<init>	(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
    //   60: invokespecial 206	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   63: astore 4
    //   65: aload 4
    //   67: aload_1
    //   68: invokevirtual 210	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   71: aload 4
    //   73: invokevirtual 211	java/io/ObjectOutputStream:close	()V
    //   76: aload_0
    //   77: getfield 28	oicq/wlogin_sdk/request/c:_context	Landroid/content/Context;
    //   80: aload_2
    //   81: aload 5
    //   83: invokevirtual 215	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   86: invokestatic 217	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;[B)I
    //   89: istore_3
    //   90: ldc 170
    //   92: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: monitorexit
    //   97: iload_3
    //   98: ireturn
    //   99: astore_1
    //   100: new 219	java/io/StringWriter
    //   103: dup
    //   104: invokespecial 220	java/io/StringWriter:<init>	()V
    //   107: astore_2
    //   108: new 222	java/io/PrintWriter
    //   111: dup
    //   112: aload_2
    //   113: iconst_1
    //   114: invokespecial 225	java/io/PrintWriter:<init>	(Ljava/io/Writer;Z)V
    //   117: astore 4
    //   119: aload_1
    //   120: aload 4
    //   122: invokevirtual 229	java/lang/Exception:printStackTrace	(Ljava/io/PrintWriter;)V
    //   125: aload 4
    //   127: invokevirtual 232	java/io/PrintWriter:flush	()V
    //   130: aload_2
    //   131: invokevirtual 233	java/io/StringWriter:flush	()V
    //   134: ldc 235
    //   136: aload_2
    //   137: invokevirtual 236	java/io/StringWriter:toString	()Ljava/lang/String;
    //   140: invokestatic 239	oicq/wlogin_sdk/tools/util:rz	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: sipush -1022
    //   146: istore_3
    //   147: goto -57 -> 90
    //   150: astore_1
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	c
    //   0	155	1	paramTreeMap	TreeMap
    //   0	155	2	paramString	String
    //   89	58	3	i	int
    //   26	100	4	localObject1	Object
    //   19	63	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	90	99	java/lang/Exception
    //   2	7	150	finally
    //   7	90	150	finally
    //   90	95	150	finally
    //   100	143	150	finally
  }
  
  /* Error */
  private static TreeMap dw(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 240
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokestatic 244	oicq/wlogin_sdk/request/c:dx	(Landroid/content/Context;Ljava/lang/String;)[B
    //   10: astore 4
    //   12: aload 4
    //   14: ifnull +541 -> 555
    //   17: new 172	javax/crypto/spec/SecretKeySpec
    //   20: dup
    //   21: getstatic 178	oicq/wlogin_sdk/request/i:ajHf	[B
    //   24: ldc 180
    //   26: invokespecial 183	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   29: astore_1
    //   30: ldc 180
    //   32: invokestatic 189	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   35: astore_2
    //   36: aload_2
    //   37: iconst_2
    //   38: aload_1
    //   39: invokevirtual 193	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   42: new 246	java/io/ObjectInputStream
    //   45: dup
    //   46: new 248	javax/crypto/CipherInputStream
    //   49: dup
    //   50: new 250	java/io/ByteArrayInputStream
    //   53: dup
    //   54: aload 4
    //   56: invokespecial 253	java/io/ByteArrayInputStream:<init>	([B)V
    //   59: aload_2
    //   60: invokespecial 256	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   63: invokespecial 259	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 263	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   71: checkcast 23	java/util/TreeMap
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +474 -> 550
    //   79: aload_2
    //   80: invokevirtual 264	java/io/ObjectInputStream:close	()V
    //   83: ldc 240
    //   85: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_1
    //   89: areturn
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: new 219	java/io/StringWriter
    //   96: dup
    //   97: invokespecial 220	java/io/StringWriter:<init>	()V
    //   100: astore_3
    //   101: new 222	java/io/PrintWriter
    //   104: dup
    //   105: aload_3
    //   106: iconst_1
    //   107: invokespecial 225	java/io/PrintWriter:<init>	(Ljava/io/Writer;Z)V
    //   110: astore 5
    //   112: aload_2
    //   113: aload 5
    //   115: invokevirtual 229	java/lang/Exception:printStackTrace	(Ljava/io/PrintWriter;)V
    //   118: aload 5
    //   120: invokevirtual 232	java/io/PrintWriter:flush	()V
    //   123: aload_3
    //   124: invokevirtual 233	java/io/StringWriter:flush	()V
    //   127: ldc 235
    //   129: aload_3
    //   130: invokevirtual 236	java/io/StringWriter:toString	()Ljava/lang/String;
    //   133: invokestatic 239	oicq/wlogin_sdk/tools/util:rz	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_1
    //   137: astore_2
    //   138: aload_0
    //   139: invokestatic 268	oicq/wlogin_sdk/tools/util:pp	(Landroid/content/Context;)[B
    //   142: astore_3
    //   143: aload_2
    //   144: astore_1
    //   145: aload_3
    //   146: ifnull +89 -> 235
    //   149: aload_2
    //   150: astore_1
    //   151: aload_3
    //   152: arraylength
    //   153: ifle +82 -> 235
    //   156: new 172	javax/crypto/spec/SecretKeySpec
    //   159: dup
    //   160: aload_3
    //   161: ldc 180
    //   163: invokespecial 183	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   166: astore_1
    //   167: ldc 180
    //   169: invokestatic 189	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   172: astore_3
    //   173: aload_3
    //   174: iconst_2
    //   175: aload_1
    //   176: invokevirtual 193	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   179: new 246	java/io/ObjectInputStream
    //   182: dup
    //   183: new 248	javax/crypto/CipherInputStream
    //   186: dup
    //   187: new 250	java/io/ByteArrayInputStream
    //   190: dup
    //   191: aload 4
    //   193: invokespecial 253	java/io/ByteArrayInputStream:<init>	([B)V
    //   196: aload_3
    //   197: invokespecial 256	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   200: invokespecial 259	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   203: astore 5
    //   205: aload 5
    //   207: invokevirtual 263	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   210: checkcast 23	java/util/TreeMap
    //   213: astore_3
    //   214: aload_3
    //   215: astore_1
    //   216: aload_3
    //   217: ifnull +18 -> 235
    //   220: aload 5
    //   222: invokevirtual 264	java/io/ObjectInputStream:close	()V
    //   225: ldc 240
    //   227: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: aload_3
    //   231: areturn
    //   232: astore_1
    //   233: aload_2
    //   234: astore_1
    //   235: aload_0
    //   236: invokestatic 271	oicq/wlogin_sdk/tools/util:po	(Landroid/content/Context;)[B
    //   239: astore_3
    //   240: aload_1
    //   241: astore_2
    //   242: aload_3
    //   243: ifnull +89 -> 332
    //   246: aload_1
    //   247: astore_2
    //   248: aload_3
    //   249: arraylength
    //   250: ifle +82 -> 332
    //   253: new 172	javax/crypto/spec/SecretKeySpec
    //   256: dup
    //   257: aload_3
    //   258: invokestatic 277	oicq/wlogin_sdk/tools/c:dW	([B)[B
    //   261: ldc 180
    //   263: invokespecial 183	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   266: astore_2
    //   267: ldc 180
    //   269: invokestatic 189	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   272: astore_3
    //   273: aload_3
    //   274: iconst_2
    //   275: aload_2
    //   276: invokevirtual 193	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   279: new 246	java/io/ObjectInputStream
    //   282: dup
    //   283: new 248	javax/crypto/CipherInputStream
    //   286: dup
    //   287: new 250	java/io/ByteArrayInputStream
    //   290: dup
    //   291: aload 4
    //   293: invokespecial 253	java/io/ByteArrayInputStream:<init>	([B)V
    //   296: aload_3
    //   297: invokespecial 256	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   300: invokespecial 259	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   303: astore_3
    //   304: aload_3
    //   305: invokevirtual 263	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   308: checkcast 23	java/util/TreeMap
    //   311: astore_2
    //   312: aload_2
    //   313: astore_1
    //   314: aload_2
    //   315: ifnull +15 -> 330
    //   318: aload_3
    //   319: invokevirtual 264	java/io/ObjectInputStream:close	()V
    //   322: ldc 240
    //   324: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: aload_2
    //   328: areturn
    //   329: astore_2
    //   330: aload_1
    //   331: astore_2
    //   332: aload_0
    //   333: invokestatic 280	oicq/wlogin_sdk/tools/util:pn	(Landroid/content/Context;)[B
    //   336: astore_1
    //   337: aload_2
    //   338: astore_0
    //   339: aload_1
    //   340: ifnull +89 -> 429
    //   343: aload_2
    //   344: astore_0
    //   345: aload_1
    //   346: arraylength
    //   347: ifle +82 -> 429
    //   350: new 172	javax/crypto/spec/SecretKeySpec
    //   353: dup
    //   354: aload_1
    //   355: invokestatic 277	oicq/wlogin_sdk/tools/c:dW	([B)[B
    //   358: ldc 180
    //   360: invokespecial 183	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   363: astore_0
    //   364: ldc 180
    //   366: invokestatic 189	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   369: astore_1
    //   370: aload_1
    //   371: iconst_2
    //   372: aload_0
    //   373: invokevirtual 193	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   376: new 246	java/io/ObjectInputStream
    //   379: dup
    //   380: new 248	javax/crypto/CipherInputStream
    //   383: dup
    //   384: new 250	java/io/ByteArrayInputStream
    //   387: dup
    //   388: aload 4
    //   390: invokespecial 253	java/io/ByteArrayInputStream:<init>	([B)V
    //   393: aload_1
    //   394: invokespecial 256	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   397: invokespecial 259	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   400: astore_3
    //   401: aload_3
    //   402: invokevirtual 263	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   405: checkcast 23	java/util/TreeMap
    //   408: astore_1
    //   409: aload_1
    //   410: astore_0
    //   411: aload_1
    //   412: ifnull +17 -> 429
    //   415: aload_3
    //   416: invokevirtual 264	java/io/ObjectInputStream:close	()V
    //   419: ldc 240
    //   421: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: aload_1
    //   425: areturn
    //   426: astore_0
    //   427: aload_2
    //   428: astore_0
    //   429: new 172	javax/crypto/spec/SecretKeySpec
    //   432: dup
    //   433: new 41	java/lang/String
    //   436: dup
    //   437: ldc_w 282
    //   440: invokespecial 283	java/lang/String:<init>	(Ljava/lang/String;)V
    //   443: invokevirtual 286	java/lang/String:getBytes	()[B
    //   446: ldc 180
    //   448: invokespecial 183	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   451: astore_1
    //   452: ldc 180
    //   454: invokestatic 189	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   457: astore_2
    //   458: aload_2
    //   459: iconst_2
    //   460: aload_1
    //   461: invokevirtual 193	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   464: new 246	java/io/ObjectInputStream
    //   467: dup
    //   468: new 248	javax/crypto/CipherInputStream
    //   471: dup
    //   472: new 250	java/io/ByteArrayInputStream
    //   475: dup
    //   476: aload 4
    //   478: invokespecial 253	java/io/ByteArrayInputStream:<init>	([B)V
    //   481: aload_2
    //   482: invokespecial 256	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   485: invokespecial 259	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   488: astore_2
    //   489: aload_2
    //   490: invokevirtual 263	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   493: checkcast 23	java/util/TreeMap
    //   496: astore_1
    //   497: aload_1
    //   498: astore_0
    //   499: aload_1
    //   500: ifnull +15 -> 515
    //   503: aload_2
    //   504: invokevirtual 264	java/io/ObjectInputStream:close	()V
    //   507: ldc 240
    //   509: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   512: aload_1
    //   513: areturn
    //   514: astore_1
    //   515: ldc 240
    //   517: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   520: aload_0
    //   521: areturn
    //   522: astore_0
    //   523: aload_1
    //   524: astore_0
    //   525: goto -10 -> 515
    //   528: astore_0
    //   529: aload_1
    //   530: astore_0
    //   531: goto -102 -> 429
    //   534: astore_1
    //   535: aload_2
    //   536: astore_1
    //   537: goto -207 -> 330
    //   540: astore_1
    //   541: aload_3
    //   542: astore_1
    //   543: goto -308 -> 235
    //   546: astore_2
    //   547: goto -454 -> 93
    //   550: aload_1
    //   551: astore_2
    //   552: goto -414 -> 138
    //   555: aconst_null
    //   556: astore_0
    //   557: goto -42 -> 515
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	560	0	paramContext	Context
    //   0	560	1	paramString	String
    //   35	45	2	localObject1	Object
    //   90	23	2	localException1	java.lang.Exception
    //   137	191	2	localObject2	Object
    //   329	1	2	localException2	java.lang.Exception
    //   331	205	2	localObject3	Object
    //   546	1	2	localException3	java.lang.Exception
    //   551	1	2	str	String
    //   100	442	3	localObject4	Object
    //   10	467	4	arrayOfByte	byte[]
    //   110	111	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   17	75	90	java/lang/Exception
    //   138	143	232	java/lang/Exception
    //   151	214	232	java/lang/Exception
    //   235	240	329	java/lang/Exception
    //   248	312	329	java/lang/Exception
    //   332	337	426	java/lang/Exception
    //   345	409	426	java/lang/Exception
    //   429	497	514	java/lang/Exception
    //   503	507	522	java/lang/Exception
    //   415	419	528	java/lang/Exception
    //   318	322	534	java/lang/Exception
    //   220	225	540	java/lang/Exception
    //   79	83	546	java/lang/Exception
  }
  
  /* Error */
  private static byte[] dx(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 287
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 293	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   9: astore 4
    //   11: new 91	oicq/wlogin_sdk/request/a
    //   14: dup
    //   15: aload_0
    //   16: aload_1
    //   17: invokespecial 94	oicq/wlogin_sdk/request/a:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 296	oicq/wlogin_sdk/request/a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: astore 5
    //   27: aload 5
    //   29: new 100	java/lang/StringBuilder
    //   32: dup
    //   33: ldc_w 298
    //   36: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_1
    //   40: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 300
    //   46: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: aconst_null
    //   53: invokevirtual 304	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore_3
    //   57: aload 4
    //   59: astore_0
    //   60: aload_3
    //   61: invokeinterface 308 1 0
    //   66: ifeq +20 -> 86
    //   69: aload 4
    //   71: astore_0
    //   72: aload_3
    //   73: iconst_0
    //   74: invokeinterface 312 2 0
    //   79: ifle +7 -> 86
    //   82: getstatic 315	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   85: astore_0
    //   86: aload_3
    //   87: ifnull +18 -> 105
    //   90: aload_3
    //   91: invokeinterface 318 1 0
    //   96: ifne +9 -> 105
    //   99: aload_3
    //   100: invokeinterface 159 1 0
    //   105: aload_0
    //   106: invokevirtual 321	java/lang/Boolean:booleanValue	()Z
    //   109: ifne +38 -> 147
    //   112: aload_2
    //   113: invokevirtual 160	oicq/wlogin_sdk/request/a:close	()V
    //   116: ldc_w 287
    //   119: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_1
    //   127: aload_0
    //   128: invokestatic 164	oicq/wlogin_sdk/tools/util:p	(Ljava/lang/Exception;)V
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 160	oicq/wlogin_sdk/request/a:close	()V
    //   139: ldc_w 287
    //   142: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aconst_null
    //   146: areturn
    //   147: aload 5
    //   149: aload_1
    //   150: iconst_1
    //   151: anewarray 41	java/lang/String
    //   154: dup
    //   155: iconst_0
    //   156: aload_1
    //   157: aastore
    //   158: ldc 126
    //   160: aconst_null
    //   161: aconst_null
    //   162: aconst_null
    //   163: aconst_null
    //   164: invokevirtual 130	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   167: astore_0
    //   168: aload_0
    //   169: invokeinterface 136 1 0
    //   174: ifne +59 -> 233
    //   177: aload_0
    //   178: invokeinterface 159 1 0
    //   183: aload_2
    //   184: invokevirtual 160	oicq/wlogin_sdk/request/a:close	()V
    //   187: ldc_w 287
    //   190: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aconst_null
    //   194: areturn
    //   195: astore_0
    //   196: aconst_null
    //   197: astore_1
    //   198: aload_0
    //   199: invokestatic 164	oicq/wlogin_sdk/tools/util:p	(Ljava/lang/Exception;)V
    //   202: aload_1
    //   203: ifnull +18 -> 221
    //   206: aload_1
    //   207: invokeinterface 318 1 0
    //   212: ifne +9 -> 221
    //   215: aload_1
    //   216: invokeinterface 159 1 0
    //   221: aload_2
    //   222: invokevirtual 160	oicq/wlogin_sdk/request/a:close	()V
    //   225: ldc_w 287
    //   228: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aconst_null
    //   232: areturn
    //   233: aload_0
    //   234: invokeinterface 324 1 0
    //   239: pop
    //   240: aload_0
    //   241: iconst_0
    //   242: invokeinterface 328 2 0
    //   247: astore_1
    //   248: aload_0
    //   249: invokeinterface 159 1 0
    //   254: aload_2
    //   255: invokevirtual 160	oicq/wlogin_sdk/request/a:close	()V
    //   258: ldc_w 287
    //   261: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aload_1
    //   265: areturn
    //   266: astore_0
    //   267: aload_3
    //   268: astore_1
    //   269: goto -71 -> 198
    //   272: astore_0
    //   273: aload_2
    //   274: astore_1
    //   275: goto -148 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramContext	Context
    //   0	278	1	paramString	String
    //   20	254	2	locala	a
    //   56	212	3	localCursor	android.database.Cursor
    //   9	61	4	localBoolean	java.lang.Boolean
    //   25	123	5	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   11	21	124	java/lang/Exception
    //   27	57	195	android/database/SQLException
    //   60	69	266	android/database/SQLException
    //   72	86	266	android/database/SQLException
    //   90	105	266	android/database/SQLException
    //   105	116	266	android/database/SQLException
    //   147	168	266	android/database/SQLException
    //   21	27	272	java/lang/Exception
  }
  
  public final int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[] paramArrayOfByte14, byte[] paramArrayOfByte15, byte[] paramArrayOfByte16, byte[][] paramArrayOfByte)
  {
    label339:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(88055);
        WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)this.ajGD.get(new Long(paramLong1));
        if (localWloginAllSigInfo != null) {
          break label339;
        }
        localWloginAllSigInfo = new WloginAllSigInfo();
        localObject = (WloginSigInfo)localWloginAllSigInfo._tk_map.get(new Long(paramLong2));
        if ((localObject != null) && (((WloginSigInfo)localObject)._en_A1 != null))
        {
          localObject = (byte[])((WloginSigInfo)localObject)._en_A1.clone();
          localWloginAllSigInfo._useInfo = new WloginSimpleInfo(paramLong1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4);
          int i = localWloginAllSigInfo.put_siginfo(paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfByte15, paramArrayOfByte16, paramArrayOfByte);
          util.bKf("before put_siginfo, ret=".concat(String.valueOf(i)));
          if (this._context != null)
          {
            paramArrayOfByte2 = dw(this._context, "tk_file");
            paramArrayOfByte1 = paramArrayOfByte2;
            if (paramArrayOfByte2 == null) {
              paramArrayOfByte1 = new TreeMap();
            }
            util.bKf("after loadTKTreeMap");
            paramArrayOfByte1.put(new Long(paramLong1), localWloginAllSigInfo.get_clone());
            i = a(paramArrayOfByte1, "tk_file");
            util.bKf("after refreshTKTreeMap, ret=".concat(String.valueOf(i)));
          }
          if (i != 0)
          {
            paramArrayOfByte1 = (WloginSigInfo)localWloginAllSigInfo._tk_map.get(new Long(paramLong2));
            if (paramArrayOfByte1 != null) {
              paramArrayOfByte1._en_A1 = ((byte[])((byte[])localObject).clone());
            }
          }
          this.ajGD.put(new Long(paramLong1), localWloginAllSigInfo);
          AppMethodBeat.o(88055);
          return i;
        }
      }
      finally {}
      Object localObject = new byte[0];
    }
  }
  
  /* Error */
  public final WloginSigInfo bT(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 373
    //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 375
    //   11: new 100	java/lang/StringBuilder
    //   14: dup
    //   15: ldc 39
    //   17: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: lload_1
    //   21: invokevirtual 378	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: ldc_w 380
    //   27: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 55	oicq/wlogin_sdk/tools/util:ry	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: lload_1
    //   38: invokespecial 382	oicq/wlogin_sdk/request/c:BV	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   41: astore 5
    //   43: aload 5
    //   45: ifnonnull +17 -> 62
    //   48: ldc_w 373
    //   51: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aconst_null
    //   55: astore 5
    //   57: aload_0
    //   58: monitorexit
    //   59: aload 5
    //   61: areturn
    //   62: aload 5
    //   64: getfield 334	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   67: ldc2_w 383
    //   70: invokestatic 387	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   73: invokevirtual 64	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   76: checkcast 336	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   79: astore 5
    //   81: aload 5
    //   83: ifnonnull +15 -> 98
    //   86: ldc_w 373
    //   89: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aconst_null
    //   93: astore 5
    //   95: goto -38 -> 57
    //   98: ldc_w 373
    //   101: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: goto -47 -> 57
    //   107: astore 5
    //   109: aload_0
    //   110: monitorexit
    //   111: aload 5
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	c
    //   0	114	1	paramLong1	long
    //   0	114	3	paramLong2	long
    //   41	53	5	localObject1	Object
    //   107	5	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	107	finally
    //   48	54	107	finally
    //   62	81	107	finally
    //   86	92	107	finally
    //   98	104	107	finally
  }
  
  /* Error */
  public final void x(Long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 390
    //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 26	oicq/wlogin_sdk/request/c:ajGD	Ljava/util/TreeMap;
    //   12: aload_1
    //   13: invokevirtual 393	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_0
    //   18: getfield 28	oicq/wlogin_sdk/request/c:_context	Landroid/content/Context;
    //   21: ifnull +40 -> 61
    //   24: aload_0
    //   25: getfield 28	oicq/wlogin_sdk/request/c:_context	Landroid/content/Context;
    //   28: ldc 68
    //   30: invokestatic 72	oicq/wlogin_sdk/request/c:dw	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnonnull +12 -> 47
    //   38: ldc_w 390
    //   41: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_2
    //   48: aload_1
    //   49: invokevirtual 393	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: aload_0
    //   54: aload_2
    //   55: ldc 68
    //   57: invokespecial 368	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   60: pop
    //   61: ldc_w 390
    //   64: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: goto -23 -> 44
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	c
    //   0	75	1	paramLong	Long
    //   33	22	2	localTreeMap	TreeMap
    // Exception table:
    //   from	to	target	type
    //   2	34	70	finally
    //   38	44	70	finally
    //   47	61	70	finally
    //   61	67	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.request.c
 * JD-Core Version:    0.7.0.1
 */