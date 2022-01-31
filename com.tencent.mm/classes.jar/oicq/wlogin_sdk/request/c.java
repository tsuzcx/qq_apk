package oicq.wlogin_sdk.request;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TreeMap;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public final class c
{
  TreeMap<Long, WloginAllSigInfo> CMq;
  Context _context;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(96415);
    this.CMq = new TreeMap();
    this._context = paramContext;
    AppMethodBeat.o(96415);
  }
  
  /* Error */
  private static int a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 39
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 41	oicq/wlogin_sdk/request/a
    //   10: dup
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial 44	oicq/wlogin_sdk/request/a:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   16: astore_0
    //   17: aload_0
    //   18: invokevirtual 48	oicq/wlogin_sdk/request/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore 4
    //   23: aload 4
    //   25: new 50	java/lang/StringBuilder
    //   28: dup
    //   29: ldc 52
    //   31: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 61
    //   40: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 63
    //   49: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokevirtual 72	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   58: aload 4
    //   60: aload_1
    //   61: iconst_1
    //   62: anewarray 74	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: ldc 76
    //   69: aastore
    //   70: ldc 78
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: invokevirtual 82	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore_3
    //   80: aload_3
    //   81: invokeinterface 88 1 0
    //   86: ifne +55 -> 141
    //   89: aload 4
    //   91: new 50	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 90
    //   97: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_1
    //   101: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 92
    //   106: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc 94
    //   115: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: iconst_2
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: iconst_0
    //   128: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: iconst_1
    //   135: newarray byte
    //   137: aastore
    //   138: invokevirtual 103	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload 4
    //   143: new 50	java/lang/StringBuilder
    //   146: dup
    //   147: ldc 105
    //   149: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload_1
    //   153: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 107
    //   158: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_1
    //   162: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 109
    //   167: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: iconst_1
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload_2
    //   180: aastore
    //   181: invokevirtual 103	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload_3
    //   185: invokeinterface 112 1 0
    //   190: aload_0
    //   191: invokevirtual 113	oicq/wlogin_sdk/request/a:close	()V
    //   194: ldc 39
    //   196: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: iconst_0
    //   200: ireturn
    //   201: astore_0
    //   202: aload_3
    //   203: astore_1
    //   204: aload_0
    //   205: invokestatic 119	oicq/wlogin_sdk/tools/util:j	(Ljava/lang/Exception;)V
    //   208: aload_1
    //   209: ifnull +7 -> 216
    //   212: aload_1
    //   213: invokevirtual 113	oicq/wlogin_sdk/request/a:close	()V
    //   216: ldc 39
    //   218: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: sipush -1022
    //   224: ireturn
    //   225: astore_1
    //   226: aload_1
    //   227: invokestatic 119	oicq/wlogin_sdk/tools/util:j	(Ljava/lang/Exception;)V
    //   230: aload_0
    //   231: invokevirtual 113	oicq/wlogin_sdk/request/a:close	()V
    //   234: ldc 39
    //   236: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: sipush -1022
    //   242: ireturn
    //   243: astore_1
    //   244: aload_1
    //   245: invokestatic 119	oicq/wlogin_sdk/tools/util:j	(Ljava/lang/Exception;)V
    //   248: aload_0
    //   249: invokevirtual 113	oicq/wlogin_sdk/request/a:close	()V
    //   252: ldc 39
    //   254: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: sipush -1022
    //   260: ireturn
    //   261: astore_1
    //   262: aload_1
    //   263: invokestatic 119	oicq/wlogin_sdk/tools/util:j	(Ljava/lang/Exception;)V
    //   266: aload_3
    //   267: invokeinterface 112 1 0
    //   272: aload_0
    //   273: invokevirtual 113	oicq/wlogin_sdk/request/a:close	()V
    //   276: ldc 39
    //   278: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: sipush -1022
    //   284: ireturn
    //   285: astore_1
    //   286: aload_1
    //   287: invokestatic 119	oicq/wlogin_sdk/tools/util:j	(Ljava/lang/Exception;)V
    //   290: aload_3
    //   291: invokeinterface 112 1 0
    //   296: aload_0
    //   297: invokevirtual 113	oicq/wlogin_sdk/request/a:close	()V
    //   300: ldc 39
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
      AppMethodBeat.i(96420);
      int i = 0;
      if (paramString == "tk_file") {
        i = b(paramTreeMap, paramString);
      }
      AppMethodBeat.o(96420);
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
    //   2: ldc 127
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 129	javax/crypto/spec/SecretKeySpec
    //   10: dup
    //   11: getstatic 135	oicq/wlogin_sdk/request/i:CMS	[B
    //   14: ldc 137
    //   16: invokespecial 140	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   19: astore 5
    //   21: ldc 137
    //   23: invokestatic 146	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   26: astore 4
    //   28: aload 4
    //   30: iconst_1
    //   31: aload 5
    //   33: invokevirtual 150	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   36: new 152	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: invokespecial 153	java/io/ByteArrayOutputStream:<init>	()V
    //   43: astore 5
    //   45: new 155	java/io/ObjectOutputStream
    //   48: dup
    //   49: new 157	javax/crypto/CipherOutputStream
    //   52: dup
    //   53: aload 5
    //   55: aload 4
    //   57: invokespecial 160	javax/crypto/CipherOutputStream:<init>	(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
    //   60: invokespecial 163	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   63: astore 4
    //   65: aload 4
    //   67: aload_1
    //   68: invokevirtual 167	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   71: aload 4
    //   73: invokevirtual 168	java/io/ObjectOutputStream:close	()V
    //   76: aload_0
    //   77: getfield 28	oicq/wlogin_sdk/request/c:_context	Landroid/content/Context;
    //   80: aload_2
    //   81: aload 5
    //   83: invokevirtual 172	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   86: invokestatic 174	oicq/wlogin_sdk/request/c:a	(Landroid/content/Context;Ljava/lang/String;[B)I
    //   89: istore_3
    //   90: ldc 127
    //   92: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: monitorexit
    //   97: iload_3
    //   98: ireturn
    //   99: astore_1
    //   100: new 176	java/io/StringWriter
    //   103: dup
    //   104: invokespecial 177	java/io/StringWriter:<init>	()V
    //   107: astore_2
    //   108: new 179	java/io/PrintWriter
    //   111: dup
    //   112: aload_2
    //   113: iconst_1
    //   114: invokespecial 182	java/io/PrintWriter:<init>	(Ljava/io/Writer;Z)V
    //   117: astore 4
    //   119: aload_1
    //   120: aload 4
    //   122: invokevirtual 186	java/lang/Exception:printStackTrace	(Ljava/io/PrintWriter;)V
    //   125: aload 4
    //   127: invokevirtual 189	java/io/PrintWriter:flush	()V
    //   130: aload_2
    //   131: invokevirtual 190	java/io/StringWriter:flush	()V
    //   134: ldc 192
    //   136: aload_2
    //   137: invokevirtual 193	java/io/StringWriter:toString	()Ljava/lang/String;
    //   140: invokestatic 197	oicq/wlogin_sdk/tools/util:jD	(Ljava/lang/String;Ljava/lang/String;)V
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
  private static TreeMap ci(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 200
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokestatic 204	oicq/wlogin_sdk/request/c:cj	(Landroid/content/Context;Ljava/lang/String;)[B
    //   10: astore 4
    //   12: aload 4
    //   14: ifnull +540 -> 554
    //   17: new 129	javax/crypto/spec/SecretKeySpec
    //   20: dup
    //   21: getstatic 135	oicq/wlogin_sdk/request/i:CMS	[B
    //   24: ldc 137
    //   26: invokespecial 140	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   29: astore_1
    //   30: ldc 137
    //   32: invokestatic 146	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   35: astore_2
    //   36: aload_2
    //   37: iconst_2
    //   38: aload_1
    //   39: invokevirtual 150	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   42: new 206	java/io/ObjectInputStream
    //   45: dup
    //   46: new 208	javax/crypto/CipherInputStream
    //   49: dup
    //   50: new 210	java/io/ByteArrayInputStream
    //   53: dup
    //   54: aload 4
    //   56: invokespecial 213	java/io/ByteArrayInputStream:<init>	([B)V
    //   59: aload_2
    //   60: invokespecial 216	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   63: invokespecial 219	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 223	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   71: checkcast 23	java/util/TreeMap
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +473 -> 549
    //   79: aload_2
    //   80: invokevirtual 224	java/io/ObjectInputStream:close	()V
    //   83: ldc 200
    //   85: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_1
    //   89: areturn
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: new 176	java/io/StringWriter
    //   96: dup
    //   97: invokespecial 177	java/io/StringWriter:<init>	()V
    //   100: astore_3
    //   101: new 179	java/io/PrintWriter
    //   104: dup
    //   105: aload_3
    //   106: iconst_1
    //   107: invokespecial 182	java/io/PrintWriter:<init>	(Ljava/io/Writer;Z)V
    //   110: astore 5
    //   112: aload_2
    //   113: aload 5
    //   115: invokevirtual 186	java/lang/Exception:printStackTrace	(Ljava/io/PrintWriter;)V
    //   118: aload 5
    //   120: invokevirtual 189	java/io/PrintWriter:flush	()V
    //   123: aload_3
    //   124: invokevirtual 190	java/io/StringWriter:flush	()V
    //   127: ldc 192
    //   129: aload_3
    //   130: invokevirtual 193	java/io/StringWriter:toString	()Ljava/lang/String;
    //   133: invokestatic 197	oicq/wlogin_sdk/tools/util:jD	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_1
    //   137: astore_2
    //   138: aload_0
    //   139: invokestatic 228	oicq/wlogin_sdk/tools/util:kc	(Landroid/content/Context;)[B
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
    //   156: new 129	javax/crypto/spec/SecretKeySpec
    //   159: dup
    //   160: aload_3
    //   161: ldc 137
    //   163: invokespecial 140	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   166: astore_1
    //   167: ldc 137
    //   169: invokestatic 146	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   172: astore_3
    //   173: aload_3
    //   174: iconst_2
    //   175: aload_1
    //   176: invokevirtual 150	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   179: new 206	java/io/ObjectInputStream
    //   182: dup
    //   183: new 208	javax/crypto/CipherInputStream
    //   186: dup
    //   187: new 210	java/io/ByteArrayInputStream
    //   190: dup
    //   191: aload 4
    //   193: invokespecial 213	java/io/ByteArrayInputStream:<init>	([B)V
    //   196: aload_3
    //   197: invokespecial 216	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   200: invokespecial 219	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   203: astore 5
    //   205: aload 5
    //   207: invokevirtual 223	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   210: checkcast 23	java/util/TreeMap
    //   213: astore_3
    //   214: aload_3
    //   215: astore_1
    //   216: aload_3
    //   217: ifnull +18 -> 235
    //   220: aload 5
    //   222: invokevirtual 224	java/io/ObjectInputStream:close	()V
    //   225: ldc 200
    //   227: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: aload_3
    //   231: areturn
    //   232: astore_1
    //   233: aload_2
    //   234: astore_1
    //   235: aload_0
    //   236: invokestatic 231	oicq/wlogin_sdk/tools/util:kb	(Landroid/content/Context;)[B
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
    //   253: new 129	javax/crypto/spec/SecretKeySpec
    //   256: dup
    //   257: aload_3
    //   258: invokestatic 237	oicq/wlogin_sdk/tools/c:cQ	([B)[B
    //   261: ldc 137
    //   263: invokespecial 140	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   266: astore_2
    //   267: ldc 137
    //   269: invokestatic 146	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   272: astore_3
    //   273: aload_3
    //   274: iconst_2
    //   275: aload_2
    //   276: invokevirtual 150	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   279: new 206	java/io/ObjectInputStream
    //   282: dup
    //   283: new 208	javax/crypto/CipherInputStream
    //   286: dup
    //   287: new 210	java/io/ByteArrayInputStream
    //   290: dup
    //   291: aload 4
    //   293: invokespecial 213	java/io/ByteArrayInputStream:<init>	([B)V
    //   296: aload_3
    //   297: invokespecial 216	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   300: invokespecial 219	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   303: astore_3
    //   304: aload_3
    //   305: invokevirtual 223	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   308: checkcast 23	java/util/TreeMap
    //   311: astore_2
    //   312: aload_2
    //   313: astore_1
    //   314: aload_2
    //   315: ifnull +15 -> 330
    //   318: aload_3
    //   319: invokevirtual 224	java/io/ObjectInputStream:close	()V
    //   322: ldc 200
    //   324: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: aload_2
    //   328: areturn
    //   329: astore_2
    //   330: aload_1
    //   331: astore_2
    //   332: aload_0
    //   333: invokestatic 240	oicq/wlogin_sdk/tools/util:ka	(Landroid/content/Context;)[B
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
    //   350: new 129	javax/crypto/spec/SecretKeySpec
    //   353: dup
    //   354: aload_1
    //   355: invokestatic 237	oicq/wlogin_sdk/tools/c:cQ	([B)[B
    //   358: ldc 137
    //   360: invokespecial 140	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   363: astore_0
    //   364: ldc 137
    //   366: invokestatic 146	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   369: astore_1
    //   370: aload_1
    //   371: iconst_2
    //   372: aload_0
    //   373: invokevirtual 150	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   376: new 206	java/io/ObjectInputStream
    //   379: dup
    //   380: new 208	javax/crypto/CipherInputStream
    //   383: dup
    //   384: new 210	java/io/ByteArrayInputStream
    //   387: dup
    //   388: aload 4
    //   390: invokespecial 213	java/io/ByteArrayInputStream:<init>	([B)V
    //   393: aload_1
    //   394: invokespecial 216	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   397: invokespecial 219	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   400: astore_3
    //   401: aload_3
    //   402: invokevirtual 223	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   405: checkcast 23	java/util/TreeMap
    //   408: astore_1
    //   409: aload_1
    //   410: astore_0
    //   411: aload_1
    //   412: ifnull +17 -> 429
    //   415: aload_3
    //   416: invokevirtual 224	java/io/ObjectInputStream:close	()V
    //   419: ldc 200
    //   421: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: aload_1
    //   425: areturn
    //   426: astore_0
    //   427: aload_2
    //   428: astore_0
    //   429: new 129	javax/crypto/spec/SecretKeySpec
    //   432: dup
    //   433: new 74	java/lang/String
    //   436: dup
    //   437: ldc 242
    //   439: invokespecial 243	java/lang/String:<init>	(Ljava/lang/String;)V
    //   442: invokevirtual 246	java/lang/String:getBytes	()[B
    //   445: ldc 137
    //   447: invokespecial 140	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   450: astore_1
    //   451: ldc 137
    //   453: invokestatic 146	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   456: astore_2
    //   457: aload_2
    //   458: iconst_2
    //   459: aload_1
    //   460: invokevirtual 150	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   463: new 206	java/io/ObjectInputStream
    //   466: dup
    //   467: new 208	javax/crypto/CipherInputStream
    //   470: dup
    //   471: new 210	java/io/ByteArrayInputStream
    //   474: dup
    //   475: aload 4
    //   477: invokespecial 213	java/io/ByteArrayInputStream:<init>	([B)V
    //   480: aload_2
    //   481: invokespecial 216	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   484: invokespecial 219	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   487: astore_2
    //   488: aload_2
    //   489: invokevirtual 223	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   492: checkcast 23	java/util/TreeMap
    //   495: astore_1
    //   496: aload_1
    //   497: astore_0
    //   498: aload_1
    //   499: ifnull +15 -> 514
    //   502: aload_2
    //   503: invokevirtual 224	java/io/ObjectInputStream:close	()V
    //   506: ldc 200
    //   508: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: aload_1
    //   512: areturn
    //   513: astore_1
    //   514: ldc 200
    //   516: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   519: aload_0
    //   520: areturn
    //   521: astore_0
    //   522: aload_1
    //   523: astore_0
    //   524: goto -10 -> 514
    //   527: astore_0
    //   528: aload_1
    //   529: astore_0
    //   530: goto -101 -> 429
    //   533: astore_1
    //   534: aload_2
    //   535: astore_1
    //   536: goto -206 -> 330
    //   539: astore_1
    //   540: aload_3
    //   541: astore_1
    //   542: goto -307 -> 235
    //   545: astore_2
    //   546: goto -453 -> 93
    //   549: aload_1
    //   550: astore_2
    //   551: goto -413 -> 138
    //   554: aconst_null
    //   555: astore_0
    //   556: goto -42 -> 514
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	559	0	paramContext	Context
    //   0	559	1	paramString	String
    //   35	45	2	localObject1	Object
    //   90	23	2	localException1	java.lang.Exception
    //   137	191	2	localObject2	Object
    //   329	1	2	localException2	java.lang.Exception
    //   331	204	2	localObject3	Object
    //   545	1	2	localException3	java.lang.Exception
    //   550	1	2	str	String
    //   100	441	3	localObject4	Object
    //   10	466	4	arrayOfByte	byte[]
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
    //   429	496	513	java/lang/Exception
    //   502	506	521	java/lang/Exception
    //   415	419	527	java/lang/Exception
    //   318	322	533	java/lang/Exception
    //   220	225	539	java/lang/Exception
    //   79	83	545	java/lang/Exception
  }
  
  /* Error */
  private static byte[] cj(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 247
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 253	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   8: astore 4
    //   10: new 41	oicq/wlogin_sdk/request/a
    //   13: dup
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 44	oicq/wlogin_sdk/request/a:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   19: astore_2
    //   20: aload_2
    //   21: invokevirtual 256	oicq/wlogin_sdk/request/a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore 5
    //   26: aload 5
    //   28: new 50	java/lang/StringBuilder
    //   31: dup
    //   32: ldc_w 258
    //   35: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: aload_1
    //   39: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 260
    //   45: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: aconst_null
    //   52: invokevirtual 264	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore_3
    //   56: aload 4
    //   58: astore_0
    //   59: aload_3
    //   60: invokeinterface 268 1 0
    //   65: ifeq +20 -> 85
    //   68: aload 4
    //   70: astore_0
    //   71: aload_3
    //   72: iconst_0
    //   73: invokeinterface 272 2 0
    //   78: ifle +7 -> 85
    //   81: getstatic 275	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   84: astore_0
    //   85: aload_3
    //   86: ifnull +18 -> 104
    //   89: aload_3
    //   90: invokeinterface 278 1 0
    //   95: ifne +9 -> 104
    //   98: aload_3
    //   99: invokeinterface 112 1 0
    //   104: aload_0
    //   105: invokevirtual 281	java/lang/Boolean:booleanValue	()Z
    //   108: ifne +36 -> 144
    //   111: aload_2
    //   112: invokevirtual 113	oicq/wlogin_sdk/request/a:close	()V
    //   115: ldc 247
    //   117: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aconst_null
    //   121: areturn
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_1
    //   125: aload_0
    //   126: invokestatic 119	oicq/wlogin_sdk/tools/util:j	(Ljava/lang/Exception;)V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 113	oicq/wlogin_sdk/request/a:close	()V
    //   137: ldc 247
    //   139: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aconst_null
    //   143: areturn
    //   144: aload 5
    //   146: aload_1
    //   147: iconst_1
    //   148: anewarray 74	java/lang/String
    //   151: dup
    //   152: iconst_0
    //   153: aload_1
    //   154: aastore
    //   155: ldc 78
    //   157: aconst_null
    //   158: aconst_null
    //   159: aconst_null
    //   160: aconst_null
    //   161: invokevirtual 82	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   164: astore_0
    //   165: aload_0
    //   166: invokeinterface 88 1 0
    //   171: ifne +57 -> 228
    //   174: aload_0
    //   175: invokeinterface 112 1 0
    //   180: aload_2
    //   181: invokevirtual 113	oicq/wlogin_sdk/request/a:close	()V
    //   184: ldc 247
    //   186: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aconst_null
    //   190: areturn
    //   191: astore_0
    //   192: aconst_null
    //   193: astore_1
    //   194: aload_0
    //   195: invokestatic 119	oicq/wlogin_sdk/tools/util:j	(Ljava/lang/Exception;)V
    //   198: aload_1
    //   199: ifnull +18 -> 217
    //   202: aload_1
    //   203: invokeinterface 278 1 0
    //   208: ifne +9 -> 217
    //   211: aload_1
    //   212: invokeinterface 112 1 0
    //   217: aload_2
    //   218: invokevirtual 113	oicq/wlogin_sdk/request/a:close	()V
    //   221: ldc 247
    //   223: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aconst_null
    //   227: areturn
    //   228: aload_0
    //   229: invokeinterface 284 1 0
    //   234: pop
    //   235: aload_0
    //   236: iconst_0
    //   237: invokeinterface 288 2 0
    //   242: astore_1
    //   243: aload_0
    //   244: invokeinterface 112 1 0
    //   249: aload_2
    //   250: invokevirtual 113	oicq/wlogin_sdk/request/a:close	()V
    //   253: ldc 247
    //   255: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload_1
    //   259: areturn
    //   260: astore_0
    //   261: aload_3
    //   262: astore_1
    //   263: goto -69 -> 194
    //   266: astore_0
    //   267: aload_2
    //   268: astore_1
    //   269: goto -144 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramContext	Context
    //   0	272	1	paramString	String
    //   19	249	2	locala	a
    //   55	207	3	localCursor	android.database.Cursor
    //   8	61	4	localBoolean	java.lang.Boolean
    //   24	121	5	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   10	20	122	java/lang/Exception
    //   26	56	191	android/database/SQLException
    //   59	68	260	android/database/SQLException
    //   71	85	260	android/database/SQLException
    //   89	104	260	android/database/SQLException
    //   104	115	260	android/database/SQLException
    //   144	165	260	android/database/SQLException
    //   20	26	266	java/lang/Exception
  }
  
  /* Error */
  private WloginAllSigInfo pC(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 291
    //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 293
    //   11: ldc_w 295
    //   14: lload_1
    //   15: invokestatic 298	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   18: invokevirtual 302	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   21: invokestatic 305	oicq/wlogin_sdk/tools/util:jC	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: getfield 26	oicq/wlogin_sdk/request/c:CMq	Ljava/util/TreeMap;
    //   28: new 307	java/lang/Long
    //   31: dup
    //   32: lload_1
    //   33: invokespecial 310	java/lang/Long:<init>	(J)V
    //   36: invokevirtual 314	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 316	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +13 -> 57
    //   47: ldc_w 291
    //   50: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_3
    //   56: areturn
    //   57: aload_0
    //   58: getfield 28	oicq/wlogin_sdk/request/c:_context	Landroid/content/Context;
    //   61: ifnonnull +14 -> 75
    //   64: ldc_w 291
    //   67: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aconst_null
    //   71: astore_3
    //   72: goto -19 -> 53
    //   75: aload_0
    //   76: getfield 28	oicq/wlogin_sdk/request/c:_context	Landroid/content/Context;
    //   79: ldc 123
    //   81: invokestatic 318	oicq/wlogin_sdk/request/c:ci	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   84: astore_3
    //   85: aload_3
    //   86: ifnonnull +14 -> 100
    //   89: ldc_w 291
    //   92: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aconst_null
    //   96: astore_3
    //   97: goto -44 -> 53
    //   100: aload_3
    //   101: new 307	java/lang/Long
    //   104: dup
    //   105: lload_1
    //   106: invokespecial 310	java/lang/Long:<init>	(J)V
    //   109: invokevirtual 314	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   112: checkcast 316	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   115: astore_3
    //   116: aload_3
    //   117: ifnonnull +23 -> 140
    //   120: ldc_w 293
    //   123: ldc_w 320
    //   126: invokestatic 305	oicq/wlogin_sdk/tools/util:jC	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: ldc_w 291
    //   132: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aconst_null
    //   136: astore_3
    //   137: goto -84 -> 53
    //   140: aload_0
    //   141: getfield 26	oicq/wlogin_sdk/request/c:CMq	Ljava/util/TreeMap;
    //   144: new 307	java/lang/Long
    //   147: dup
    //   148: lload_1
    //   149: invokespecial 310	java/lang/Long:<init>	(J)V
    //   152: aload_3
    //   153: invokevirtual 324	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: pop
    //   157: aload_3
    //   158: invokevirtual 328	oicq/wlogin_sdk/request/WloginAllSigInfo:get_clone	()Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   161: astore_3
    //   162: ldc_w 291
    //   165: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: goto -115 -> 53
    //   171: astore_3
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_3
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	c
    //   0	176	1	paramLong	long
    //   42	120	3	localObject1	Object
    //   171	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	171	finally
    //   47	53	171	finally
    //   57	70	171	finally
    //   75	85	171	finally
    //   89	95	171	finally
    //   100	116	171	finally
    //   120	135	171	finally
    //   140	168	171	finally
  }
  
  public final int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[] paramArrayOfByte14, byte[] paramArrayOfByte15, byte[] paramArrayOfByte16, byte[][] paramArrayOfByte)
  {
    label339:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(96416);
        WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)this.CMq.get(new Long(paramLong1));
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
          util.azC("before put_siginfo, ret=".concat(String.valueOf(i)));
          if (this._context != null)
          {
            paramArrayOfByte2 = ci(this._context, "tk_file");
            paramArrayOfByte1 = paramArrayOfByte2;
            if (paramArrayOfByte2 == null) {
              paramArrayOfByte1 = new TreeMap();
            }
            util.azC("after loadTKTreeMap");
            paramArrayOfByte1.put(new Long(paramLong1), localWloginAllSigInfo.get_clone());
            i = a(paramArrayOfByte1, "tk_file");
            util.azC("after refreshTKTreeMap, ret=".concat(String.valueOf(i)));
          }
          if (i != 0)
          {
            paramArrayOfByte1 = (WloginSigInfo)localWloginAllSigInfo._tk_map.get(new Long(paramLong2));
            if (paramArrayOfByte1 != null) {
              paramArrayOfByte1._en_A1 = ((byte[])((byte[])localObject).clone());
            }
          }
          this.CMq.put(new Long(paramLong1), localWloginAllSigInfo);
          AppMethodBeat.o(96416);
          return i;
        }
      }
      finally {}
      Object localObject = new byte[0];
    }
  }
  
  /* Error */
  public final void i(Long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 372
    //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 26	oicq/wlogin_sdk/request/c:CMq	Ljava/util/TreeMap;
    //   12: aload_1
    //   13: invokevirtual 375	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_0
    //   18: getfield 28	oicq/wlogin_sdk/request/c:_context	Landroid/content/Context;
    //   21: ifnull +40 -> 61
    //   24: aload_0
    //   25: getfield 28	oicq/wlogin_sdk/request/c:_context	Landroid/content/Context;
    //   28: ldc 123
    //   30: invokestatic 318	oicq/wlogin_sdk/request/c:ci	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnonnull +12 -> 47
    //   38: ldc_w 372
    //   41: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_2
    //   48: aload_1
    //   49: invokevirtual 375	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: aload_0
    //   54: aload_2
    //   55: ldc 123
    //   57: invokespecial 368	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   60: pop
    //   61: ldc_w 372
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
  
  /* Error */
  public final WloginSigInfo pD(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 378
    //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 380
    //   11: new 50	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 295
    //   18: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: lload_1
    //   22: invokevirtual 383	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: ldc_w 385
    //   28: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 305	oicq/wlogin_sdk/tools/util:jC	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_0
    //   38: lload_1
    //   39: invokespecial 387	oicq/wlogin_sdk/request/c:pC	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnonnull +15 -> 59
    //   47: ldc_w 378
    //   50: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aconst_null
    //   54: astore_3
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_3
    //   58: areturn
    //   59: aload_3
    //   60: getfield 334	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   63: ldc2_w 388
    //   66: invokestatic 392	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   69: invokevirtual 314	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 336	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   75: astore_3
    //   76: aload_3
    //   77: ifnonnull +14 -> 91
    //   80: ldc_w 378
    //   83: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aconst_null
    //   87: astore_3
    //   88: goto -33 -> 55
    //   91: ldc_w 378
    //   94: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: goto -42 -> 55
    //   100: astore_3
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_3
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	c
    //   0	105	1	paramLong	long
    //   42	46	3	localObject1	Object
    //   100	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	100	finally
    //   47	53	100	finally
    //   59	76	100	finally
    //   80	86	100	finally
    //   91	97	100	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.c
 * JD-Core Version:    0.7.0.1
 */