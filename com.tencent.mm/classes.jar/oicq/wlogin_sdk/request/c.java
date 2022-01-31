package oicq.wlogin_sdk.request;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.Key;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public final class c
{
  Context _context;
  TreeMap<Long, WloginAllSigInfo> xqd = new TreeMap();
  
  public c(Context paramContext)
  {
    this._context = paramContext;
  }
  
  /* Error */
  private static int a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 30	oicq/wlogin_sdk/request/a
    //   5: dup
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 33	oicq/wlogin_sdk/request/a:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 37	oicq/wlogin_sdk/request/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 4
    //   18: aload 4
    //   20: new 39	java/lang/StringBuilder
    //   23: dup
    //   24: ldc 41
    //   26: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: aload_1
    //   30: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 50
    //   35: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 52
    //   44: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokevirtual 61	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   53: aload 4
    //   55: aload_1
    //   56: iconst_1
    //   57: anewarray 63	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: ldc 65
    //   64: aastore
    //   65: ldc 67
    //   67: aconst_null
    //   68: aconst_null
    //   69: aconst_null
    //   70: aconst_null
    //   71: invokevirtual 71	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore_3
    //   75: aload_3
    //   76: invokeinterface 77 1 0
    //   81: ifne +55 -> 136
    //   84: aload 4
    //   86: new 39	java/lang/StringBuilder
    //   89: dup
    //   90: ldc 79
    //   92: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_1
    //   96: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 81
    //   101: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 83
    //   110: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: iconst_2
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: iconst_0
    //   123: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: iconst_1
    //   130: newarray byte
    //   132: aastore
    //   133: invokevirtual 92	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: aload 4
    //   138: new 39	java/lang/StringBuilder
    //   141: dup
    //   142: ldc 94
    //   144: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload_1
    //   148: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc 96
    //   153: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_1
    //   157: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc 98
    //   162: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: iconst_1
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_2
    //   175: aastore
    //   176: invokevirtual 92	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: aload_3
    //   180: invokeinterface 101 1 0
    //   185: aload_0
    //   186: invokevirtual 102	oicq/wlogin_sdk/request/a:close	()V
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_0
    //   192: aload_3
    //   193: astore_1
    //   194: aload_0
    //   195: invokestatic 108	oicq/wlogin_sdk/tools/util:k	(Ljava/lang/Exception;)V
    //   198: aload_1
    //   199: ifnull +7 -> 206
    //   202: aload_1
    //   203: invokevirtual 102	oicq/wlogin_sdk/request/a:close	()V
    //   206: sipush -1022
    //   209: ireturn
    //   210: astore_1
    //   211: aload_1
    //   212: invokestatic 108	oicq/wlogin_sdk/tools/util:k	(Ljava/lang/Exception;)V
    //   215: aload_0
    //   216: invokevirtual 102	oicq/wlogin_sdk/request/a:close	()V
    //   219: sipush -1022
    //   222: ireturn
    //   223: astore_1
    //   224: aload_1
    //   225: invokestatic 108	oicq/wlogin_sdk/tools/util:k	(Ljava/lang/Exception;)V
    //   228: aload_0
    //   229: invokevirtual 102	oicq/wlogin_sdk/request/a:close	()V
    //   232: sipush -1022
    //   235: ireturn
    //   236: astore_1
    //   237: aload_1
    //   238: invokestatic 108	oicq/wlogin_sdk/tools/util:k	(Ljava/lang/Exception;)V
    //   241: aload_3
    //   242: invokeinterface 101 1 0
    //   247: aload_0
    //   248: invokevirtual 102	oicq/wlogin_sdk/request/a:close	()V
    //   251: sipush -1022
    //   254: ireturn
    //   255: astore_1
    //   256: aload_1
    //   257: invokestatic 108	oicq/wlogin_sdk/tools/util:k	(Ljava/lang/Exception;)V
    //   260: aload_3
    //   261: invokeinterface 101 1 0
    //   266: aload_0
    //   267: invokevirtual 102	oicq/wlogin_sdk/request/a:close	()V
    //   270: sipush -1022
    //   273: ireturn
    //   274: astore_2
    //   275: aload_0
    //   276: astore_1
    //   277: aload_2
    //   278: astore_0
    //   279: goto -85 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramContext	Context
    //   0	282	1	paramString	String
    //   0	282	2	paramArrayOfByte	byte[]
    //   1	260	3	localCursor	android.database.Cursor
    //   16	121	4	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   2	12	191	java/lang/Exception
    //   18	53	210	android/database/SQLException
    //   53	75	223	android/database/SQLException
    //   84	136	236	android/database/SQLException
    //   136	179	255	android/database/SQLException
    //   12	18	274	java/lang/Exception
  }
  
  private int a(TreeMap paramTreeMap, String paramString)
  {
    int i = 0;
    if (paramString == "tk_file") {}
    try
    {
      i = b(paramTreeMap, paramString);
      return i;
    }
    finally
    {
      paramTreeMap = finally;
      throw paramTreeMap;
    }
  }
  
  private int b(TreeMap paramTreeMap, String paramString)
  {
    try
    {
      Object localObject2 = new SecretKeySpec(i.xqF, "DESede");
      localObject1 = Cipher.getInstance("DESede");
      ((Cipher)localObject1).init(1, (Key)localObject2);
      localObject2 = new ByteArrayOutputStream();
      localObject1 = new ObjectOutputStream(new CipherOutputStream((OutputStream)localObject2, (Cipher)localObject1));
      ((ObjectOutputStream)localObject1).writeObject(paramTreeMap);
      ((ObjectOutputStream)localObject1).close();
      i = a(this._context, paramString, ((ByteArrayOutputStream)localObject2).toByteArray());
      return i;
    }
    catch (Exception paramTreeMap)
    {
      for (;;)
      {
        paramString = new StringWriter();
        Object localObject1 = new PrintWriter(paramString, true);
        paramTreeMap.printStackTrace((PrintWriter)localObject1);
        ((PrintWriter)localObject1).flush();
        paramString.flush();
        util.gX("exception", paramString.toString());
        int i = -1022;
      }
    }
    finally {}
  }
  
  /* Error */
  private static TreeMap bU(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 190	oicq/wlogin_sdk/request/c:bV	(Landroid/content/Context;Ljava/lang/String;)[B
    //   5: astore 4
    //   7: aload 4
    //   9: ifnull +507 -> 516
    //   12: new 116	javax/crypto/spec/SecretKeySpec
    //   15: dup
    //   16: getstatic 122	oicq/wlogin_sdk/request/i:xqF	[B
    //   19: ldc 124
    //   21: invokespecial 127	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   24: astore_1
    //   25: ldc 124
    //   27: invokestatic 133	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   30: astore_2
    //   31: aload_2
    //   32: iconst_2
    //   33: aload_1
    //   34: invokevirtual 137	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   37: new 192	java/io/ObjectInputStream
    //   40: dup
    //   41: new 194	javax/crypto/CipherInputStream
    //   44: dup
    //   45: new 196	java/io/ByteArrayInputStream
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 199	java/io/ByteArrayInputStream:<init>	([B)V
    //   54: aload_2
    //   55: invokespecial 202	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   58: invokespecial 205	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 209	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   66: checkcast 16	java/util/TreeMap
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull +440 -> 511
    //   74: aload_2
    //   75: invokevirtual 210	java/io/ObjectInputStream:close	()V
    //   78: aload_1
    //   79: areturn
    //   80: astore_2
    //   81: aconst_null
    //   82: astore_1
    //   83: new 163	java/io/StringWriter
    //   86: dup
    //   87: invokespecial 164	java/io/StringWriter:<init>	()V
    //   90: astore_3
    //   91: new 166	java/io/PrintWriter
    //   94: dup
    //   95: aload_3
    //   96: iconst_1
    //   97: invokespecial 169	java/io/PrintWriter:<init>	(Ljava/io/Writer;Z)V
    //   100: astore 5
    //   102: aload_2
    //   103: aload 5
    //   105: invokevirtual 173	java/lang/Exception:printStackTrace	(Ljava/io/PrintWriter;)V
    //   108: aload 5
    //   110: invokevirtual 176	java/io/PrintWriter:flush	()V
    //   113: aload_3
    //   114: invokevirtual 177	java/io/StringWriter:flush	()V
    //   117: ldc 179
    //   119: aload_3
    //   120: invokevirtual 180	java/io/StringWriter:toString	()Ljava/lang/String;
    //   123: invokestatic 184	oicq/wlogin_sdk/tools/util:gX	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_1
    //   127: astore_2
    //   128: aload_0
    //   129: invokestatic 214	oicq/wlogin_sdk/tools/util:iu	(Landroid/content/Context;)[B
    //   132: astore_3
    //   133: aload_2
    //   134: astore_1
    //   135: aload_3
    //   136: ifnull +84 -> 220
    //   139: aload_2
    //   140: astore_1
    //   141: aload_3
    //   142: arraylength
    //   143: ifle +77 -> 220
    //   146: new 116	javax/crypto/spec/SecretKeySpec
    //   149: dup
    //   150: aload_3
    //   151: ldc 124
    //   153: invokespecial 127	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   156: astore_1
    //   157: ldc 124
    //   159: invokestatic 133	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   162: astore_3
    //   163: aload_3
    //   164: iconst_2
    //   165: aload_1
    //   166: invokevirtual 137	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   169: new 192	java/io/ObjectInputStream
    //   172: dup
    //   173: new 194	javax/crypto/CipherInputStream
    //   176: dup
    //   177: new 196	java/io/ByteArrayInputStream
    //   180: dup
    //   181: aload 4
    //   183: invokespecial 199	java/io/ByteArrayInputStream:<init>	([B)V
    //   186: aload_3
    //   187: invokespecial 202	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   190: invokespecial 205	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   193: astore 5
    //   195: aload 5
    //   197: invokevirtual 209	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   200: checkcast 16	java/util/TreeMap
    //   203: astore_3
    //   204: aload_3
    //   205: astore_1
    //   206: aload_3
    //   207: ifnull +13 -> 220
    //   210: aload 5
    //   212: invokevirtual 210	java/io/ObjectInputStream:close	()V
    //   215: aload_3
    //   216: areturn
    //   217: astore_1
    //   218: aload_3
    //   219: astore_1
    //   220: aload_0
    //   221: invokestatic 217	oicq/wlogin_sdk/tools/util:it	(Landroid/content/Context;)[B
    //   224: astore_3
    //   225: aload_1
    //   226: astore_2
    //   227: aload_3
    //   228: ifnull +86 -> 314
    //   231: aload_1
    //   232: astore_2
    //   233: aload_3
    //   234: arraylength
    //   235: ifle +79 -> 314
    //   238: new 116	javax/crypto/spec/SecretKeySpec
    //   241: dup
    //   242: aload_3
    //   243: invokestatic 223	oicq/wlogin_sdk/tools/c:cf	([B)[B
    //   246: ldc 124
    //   248: invokespecial 127	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   251: astore_2
    //   252: ldc 124
    //   254: invokestatic 133	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   257: astore_3
    //   258: aload_3
    //   259: iconst_2
    //   260: aload_2
    //   261: invokevirtual 137	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   264: new 192	java/io/ObjectInputStream
    //   267: dup
    //   268: new 194	javax/crypto/CipherInputStream
    //   271: dup
    //   272: new 196	java/io/ByteArrayInputStream
    //   275: dup
    //   276: aload 4
    //   278: invokespecial 199	java/io/ByteArrayInputStream:<init>	([B)V
    //   281: aload_3
    //   282: invokespecial 202	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   285: invokespecial 205	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   288: astore_3
    //   289: aload_3
    //   290: invokevirtual 209	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   293: checkcast 16	java/util/TreeMap
    //   296: astore_2
    //   297: aload_2
    //   298: astore_1
    //   299: aload_2
    //   300: ifnull +12 -> 312
    //   303: aload_3
    //   304: invokevirtual 210	java/io/ObjectInputStream:close	()V
    //   307: aload_2
    //   308: areturn
    //   309: astore_1
    //   310: aload_2
    //   311: astore_1
    //   312: aload_1
    //   313: astore_2
    //   314: aload_0
    //   315: invokestatic 226	oicq/wlogin_sdk/tools/util:is	(Landroid/content/Context;)[B
    //   318: astore_1
    //   319: aload_2
    //   320: astore_0
    //   321: aload_1
    //   322: ifnull +84 -> 406
    //   325: aload_2
    //   326: astore_0
    //   327: aload_1
    //   328: arraylength
    //   329: ifle +77 -> 406
    //   332: new 116	javax/crypto/spec/SecretKeySpec
    //   335: dup
    //   336: aload_1
    //   337: invokestatic 223	oicq/wlogin_sdk/tools/c:cf	([B)[B
    //   340: ldc 124
    //   342: invokespecial 127	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   345: astore_0
    //   346: ldc 124
    //   348: invokestatic 133	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   351: astore_1
    //   352: aload_1
    //   353: iconst_2
    //   354: aload_0
    //   355: invokevirtual 137	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   358: new 192	java/io/ObjectInputStream
    //   361: dup
    //   362: new 194	javax/crypto/CipherInputStream
    //   365: dup
    //   366: new 196	java/io/ByteArrayInputStream
    //   369: dup
    //   370: aload 4
    //   372: invokespecial 199	java/io/ByteArrayInputStream:<init>	([B)V
    //   375: aload_1
    //   376: invokespecial 202	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   379: invokespecial 205	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   382: astore_3
    //   383: aload_3
    //   384: invokevirtual 209	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   387: checkcast 16	java/util/TreeMap
    //   390: astore_1
    //   391: aload_1
    //   392: astore_0
    //   393: aload_1
    //   394: ifnull +12 -> 406
    //   397: aload_3
    //   398: invokevirtual 210	java/io/ObjectInputStream:close	()V
    //   401: aload_1
    //   402: areturn
    //   403: astore_0
    //   404: aload_1
    //   405: astore_0
    //   406: new 116	javax/crypto/spec/SecretKeySpec
    //   409: dup
    //   410: new 63	java/lang/String
    //   413: dup
    //   414: ldc 228
    //   416: invokespecial 229	java/lang/String:<init>	(Ljava/lang/String;)V
    //   419: invokevirtual 232	java/lang/String:getBytes	()[B
    //   422: ldc 124
    //   424: invokespecial 127	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   427: astore_1
    //   428: ldc 124
    //   430: invokestatic 133	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   433: astore_2
    //   434: aload_2
    //   435: iconst_2
    //   436: aload_1
    //   437: invokevirtual 137	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   440: new 192	java/io/ObjectInputStream
    //   443: dup
    //   444: new 194	javax/crypto/CipherInputStream
    //   447: dup
    //   448: new 196	java/io/ByteArrayInputStream
    //   451: dup
    //   452: aload 4
    //   454: invokespecial 199	java/io/ByteArrayInputStream:<init>	([B)V
    //   457: aload_2
    //   458: invokespecial 202	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   461: invokespecial 205	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   464: astore_3
    //   465: aload_3
    //   466: invokevirtual 209	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   469: checkcast 16	java/util/TreeMap
    //   472: astore_2
    //   473: aload_2
    //   474: astore_1
    //   475: aload_2
    //   476: ifnull -398 -> 78
    //   479: aload_3
    //   480: invokevirtual 210	java/io/ObjectInputStream:close	()V
    //   483: aload_2
    //   484: areturn
    //   485: astore_0
    //   486: aload_2
    //   487: areturn
    //   488: astore_1
    //   489: aload_0
    //   490: areturn
    //   491: astore_0
    //   492: aload_2
    //   493: astore_0
    //   494: goto -88 -> 406
    //   497: astore_2
    //   498: goto -186 -> 312
    //   501: astore_1
    //   502: aload_2
    //   503: astore_1
    //   504: goto -284 -> 220
    //   507: astore_2
    //   508: goto -425 -> 83
    //   511: aload_1
    //   512: astore_2
    //   513: goto -385 -> 128
    //   516: aconst_null
    //   517: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	paramContext	Context
    //   0	518	1	paramString	String
    //   30	45	2	localObject1	Object
    //   80	23	2	localException1	Exception
    //   127	366	2	localObject2	Object
    //   497	6	2	localException2	Exception
    //   507	1	2	localException3	Exception
    //   512	1	2	str	String
    //   90	390	3	localObject3	Object
    //   5	448	4	arrayOfByte	byte[]
    //   100	111	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   12	70	80	java/lang/Exception
    //   210	215	217	java/lang/Exception
    //   303	307	309	java/lang/Exception
    //   397	401	403	java/lang/Exception
    //   479	483	485	java/lang/Exception
    //   406	473	488	java/lang/Exception
    //   314	319	491	java/lang/Exception
    //   327	391	491	java/lang/Exception
    //   220	225	497	java/lang/Exception
    //   233	297	497	java/lang/Exception
    //   128	133	501	java/lang/Exception
    //   141	204	501	java/lang/Exception
    //   74	78	507	java/lang/Exception
  }
  
  /* Error */
  private static byte[] bV(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: invokestatic 237	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4: astore 4
    //   6: new 30	oicq/wlogin_sdk/request/a
    //   9: dup
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 33	oicq/wlogin_sdk/request/a:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   15: astore_2
    //   16: aload_2
    //   17: invokevirtual 240	oicq/wlogin_sdk/request/a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: astore 5
    //   22: aload 5
    //   24: new 39	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 242
    //   30: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_1
    //   34: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 244
    //   39: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: aconst_null
    //   46: invokevirtual 248	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore_3
    //   50: aload 4
    //   52: astore_0
    //   53: aload_3
    //   54: invokeinterface 252 1 0
    //   59: ifeq +21 -> 80
    //   62: aload 4
    //   64: astore_0
    //   65: aload_3
    //   66: iconst_0
    //   67: invokeinterface 256 2 0
    //   72: ifle +8 -> 80
    //   75: iconst_1
    //   76: invokestatic 237	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   79: astore_0
    //   80: aload_3
    //   81: ifnull +18 -> 99
    //   84: aload_3
    //   85: invokeinterface 259 1 0
    //   90: ifne +9 -> 99
    //   93: aload_3
    //   94: invokeinterface 101 1 0
    //   99: aload_0
    //   100: invokevirtual 262	java/lang/Boolean:booleanValue	()Z
    //   103: ifne +26 -> 129
    //   106: aload_2
    //   107: invokevirtual 102	oicq/wlogin_sdk/request/a:close	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_1
    //   115: aload_0
    //   116: invokestatic 108	oicq/wlogin_sdk/tools/util:k	(Ljava/lang/Exception;)V
    //   119: aload_1
    //   120: ifnull +7 -> 127
    //   123: aload_1
    //   124: invokevirtual 102	oicq/wlogin_sdk/request/a:close	()V
    //   127: aconst_null
    //   128: areturn
    //   129: aload 5
    //   131: aload_1
    //   132: iconst_1
    //   133: anewarray 63	java/lang/String
    //   136: dup
    //   137: iconst_0
    //   138: aload_1
    //   139: aastore
    //   140: ldc 67
    //   142: aconst_null
    //   143: aconst_null
    //   144: aconst_null
    //   145: aconst_null
    //   146: invokevirtual 71	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   149: astore_0
    //   150: aload_0
    //   151: invokeinterface 77 1 0
    //   156: ifne +47 -> 203
    //   159: aload_0
    //   160: invokeinterface 101 1 0
    //   165: aload_2
    //   166: invokevirtual 102	oicq/wlogin_sdk/request/a:close	()V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_0
    //   172: aconst_null
    //   173: astore_1
    //   174: aload_0
    //   175: invokestatic 108	oicq/wlogin_sdk/tools/util:k	(Ljava/lang/Exception;)V
    //   178: aload_1
    //   179: ifnull +18 -> 197
    //   182: aload_1
    //   183: invokeinterface 259 1 0
    //   188: ifne +9 -> 197
    //   191: aload_1
    //   192: invokeinterface 101 1 0
    //   197: aload_2
    //   198: invokevirtual 102	oicq/wlogin_sdk/request/a:close	()V
    //   201: aconst_null
    //   202: areturn
    //   203: aload_0
    //   204: invokeinterface 265 1 0
    //   209: pop
    //   210: aload_0
    //   211: iconst_0
    //   212: invokeinterface 269 2 0
    //   217: astore_1
    //   218: aload_0
    //   219: invokeinterface 101 1 0
    //   224: aload_2
    //   225: invokevirtual 102	oicq/wlogin_sdk/request/a:close	()V
    //   228: aload_1
    //   229: areturn
    //   230: astore_0
    //   231: aload_3
    //   232: astore_1
    //   233: goto -59 -> 174
    //   236: astore_0
    //   237: aload_2
    //   238: astore_1
    //   239: goto -124 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramContext	Context
    //   0	242	1	paramString	String
    //   15	223	2	locala	a
    //   49	183	3	localCursor	android.database.Cursor
    //   4	59	4	localBoolean	java.lang.Boolean
    //   20	110	5	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   6	16	112	java/lang/Exception
    //   22	50	171	android/database/SQLException
    //   53	62	230	android/database/SQLException
    //   65	80	230	android/database/SQLException
    //   84	99	230	android/database/SQLException
    //   99	110	230	android/database/SQLException
    //   129	150	230	android/database/SQLException
    //   16	22	236	java/lang/Exception
  }
  
  /* Error */
  private WloginAllSigInfo iE(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 273
    //   5: new 39	java/lang/StringBuilder
    //   8: dup
    //   9: ldc_w 275
    //   12: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: lload_1
    //   16: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 281	oicq/wlogin_sdk/tools/util:gW	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 19	oicq/wlogin_sdk/request/c:xqd	Ljava/util/TreeMap;
    //   29: new 283	java/lang/Long
    //   32: dup
    //   33: lload_1
    //   34: invokespecial 286	java/lang/Long:<init>	(J)V
    //   37: invokevirtual 290	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 292	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +7 -> 52
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_3
    //   51: areturn
    //   52: aload_0
    //   53: getfield 21	oicq/wlogin_sdk/request/c:_context	Landroid/content/Context;
    //   56: ifnonnull +8 -> 64
    //   59: aconst_null
    //   60: astore_3
    //   61: goto -13 -> 48
    //   64: aload_0
    //   65: getfield 21	oicq/wlogin_sdk/request/c:_context	Landroid/content/Context;
    //   68: ldc 111
    //   70: invokestatic 294	oicq/wlogin_sdk/request/c:bU	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   73: astore_3
    //   74: aload_3
    //   75: ifnonnull +8 -> 83
    //   78: aconst_null
    //   79: astore_3
    //   80: goto -32 -> 48
    //   83: aload_3
    //   84: new 283	java/lang/Long
    //   87: dup
    //   88: lload_1
    //   89: invokespecial 286	java/lang/Long:<init>	(J)V
    //   92: invokevirtual 290	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast 292	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   98: astore_3
    //   99: aload_3
    //   100: ifnonnull +17 -> 117
    //   103: ldc_w 273
    //   106: ldc_w 296
    //   109: invokestatic 281	oicq/wlogin_sdk/tools/util:gW	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aconst_null
    //   113: astore_3
    //   114: goto -66 -> 48
    //   117: aload_0
    //   118: getfield 19	oicq/wlogin_sdk/request/c:xqd	Ljava/util/TreeMap;
    //   121: new 283	java/lang/Long
    //   124: dup
    //   125: lload_1
    //   126: invokespecial 286	java/lang/Long:<init>	(J)V
    //   129: aload_3
    //   130: invokevirtual 300	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: pop
    //   134: aload_3
    //   135: invokevirtual 304	oicq/wlogin_sdk/request/WloginAllSigInfo:get_clone	()Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   138: astore_3
    //   139: goto -91 -> 48
    //   142: astore_3
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_3
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	c
    //   0	147	1	paramLong	long
    //   43	96	3	localObject1	Object
    //   142	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	44	142	finally
    //   52	59	142	finally
    //   64	74	142	finally
    //   83	99	142	finally
    //   103	112	142	finally
    //   117	139	142	finally
  }
  
  public final int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[] paramArrayOfByte14, byte[] paramArrayOfByte15, byte[] paramArrayOfByte16, byte[][] paramArrayOfByte)
  {
    label341:
    for (;;)
    {
      try
      {
        WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)this.xqd.get(new Long(paramLong1));
        if (localWloginAllSigInfo != null) {
          break label341;
        }
        localWloginAllSigInfo = new WloginAllSigInfo();
        localObject = (WloginSigInfo)localWloginAllSigInfo._tk_map.get(new Long(paramLong2));
        if ((localObject != null) && (((WloginSigInfo)localObject)._en_A1 != null))
        {
          localObject = (byte[])((WloginSigInfo)localObject)._en_A1.clone();
          localWloginAllSigInfo._useInfo = new WloginSimpleInfo(paramLong1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4);
          int i = localWloginAllSigInfo.put_siginfo(paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte13, paramArrayOfByte14, paramArrayOfByte15, paramArrayOfByte16, paramArrayOfByte);
          util.ahk("before put_siginfo, ret=" + i);
          if (this._context != null)
          {
            paramArrayOfByte2 = bU(this._context, "tk_file");
            paramArrayOfByte1 = paramArrayOfByte2;
            if (paramArrayOfByte2 == null) {
              paramArrayOfByte1 = new TreeMap();
            }
            util.ahk("after loadTKTreeMap");
            paramArrayOfByte1.put(new Long(paramLong1), localWloginAllSigInfo.get_clone());
            i = a(paramArrayOfByte1, "tk_file");
            util.ahk("after refreshTKTreeMap, ret=" + i);
          }
          if (i != 0)
          {
            paramArrayOfByte1 = (WloginSigInfo)localWloginAllSigInfo._tk_map.get(new Long(paramLong2));
            if (paramArrayOfByte1 != null) {
              paramArrayOfByte1._en_A1 = ((byte[])((byte[])localObject).clone());
            }
          }
          this.xqd.put(new Long(paramLong1), localWloginAllSigInfo);
          return i;
        }
      }
      finally {}
      Object localObject = new byte[0];
    }
  }
  
  /* Error */
  public final WloginSigInfo iF(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 349
    //   5: new 39	java/lang/StringBuilder
    //   8: dup
    //   9: ldc_w 275
    //   12: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: lload_1
    //   16: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: ldc_w 351
    //   22: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 281	oicq/wlogin_sdk/tools/util:gW	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: lload_1
    //   33: invokespecial 353	oicq/wlogin_sdk/request/c:iE	(J)Loicq/wlogin_sdk/request/WloginAllSigInfo;
    //   36: astore_3
    //   37: aload_3
    //   38: ifnonnull +9 -> 47
    //   41: aconst_null
    //   42: astore_3
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_3
    //   46: areturn
    //   47: aload_3
    //   48: getfield 309	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   51: new 283	java/lang/Long
    //   54: dup
    //   55: ldc2_w 354
    //   58: invokespecial 286	java/lang/Long:<init>	(J)V
    //   61: invokevirtual 290	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: checkcast 311	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   67: astore 4
    //   69: aload 4
    //   71: astore_3
    //   72: aload 4
    //   74: ifnonnull -31 -> 43
    //   77: aconst_null
    //   78: astore_3
    //   79: goto -36 -> 43
    //   82: astore_3
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_3
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	c
    //   0	87	1	paramLong	long
    //   36	43	3	localObject1	Object
    //   82	4	3	localObject2	Object
    //   67	6	4	localWloginSigInfo	WloginSigInfo
    // Exception table:
    //   from	to	target	type
    //   2	37	82	finally
    //   47	69	82	finally
  }
  
  /* Error */
  public final void j(Long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	oicq/wlogin_sdk/request/c:xqd	Ljava/util/TreeMap;
    //   6: aload_1
    //   7: invokevirtual 360	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: aload_0
    //   12: getfield 21	oicq/wlogin_sdk/request/c:_context	Landroid/content/Context;
    //   15: ifnull +17 -> 32
    //   18: aload_0
    //   19: getfield 21	oicq/wlogin_sdk/request/c:_context	Landroid/content/Context;
    //   22: ldc 111
    //   24: invokestatic 294	oicq/wlogin_sdk/request/c:bU	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/TreeMap;
    //   27: astore_2
    //   28: aload_2
    //   29: ifnonnull +6 -> 35
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_2
    //   36: aload_1
    //   37: invokevirtual 360	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: aload_0
    //   42: aload_2
    //   43: ldc 111
    //   45: invokespecial 343	oicq/wlogin_sdk/request/c:a	(Ljava/util/TreeMap;Ljava/lang/String;)I
    //   48: pop
    //   49: goto -17 -> 32
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	c
    //   0	57	1	paramLong	Long
    //   27	16	2	localTreeMap	TreeMap
    // Exception table:
    //   from	to	target	type
    //   2	28	52	finally
    //   35	49	52	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.c
 * JD-Core Version:    0.7.0.1
 */