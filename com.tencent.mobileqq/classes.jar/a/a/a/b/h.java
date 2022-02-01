package a.a.a.b;

import a.a.a.a.b;
import android.util.Base64;
import java.io.DataInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class h
{
  public static final byte[] a = { 8, 89, -108, 70, 3, 26, 39, -38, 6, 67, -94, 103, 29, 18, 117, -82, 1, 65, -106, 98, 15, 10, 66, -36, 4, 36, -108, 110, 15, 31, 84, -33, 44, 65, -104, 98, 41, 10, 83, -48, 63, 32, -108, 73, 5, 42, 66, -52, 43, 96, -67, 83, 13, 51, 34, -18, 52, 73, -65, 118, 10, 54, 92, -12, 116, 105, -71, 105, 13, 21, 124, -10, 3, 114, -87, 97, 43, 15, 118, -54, 35, 63, -93, 101, 0, 48, 66, -55, 17, 33, -22, 108, 11, 99, 81, -54, 43, 36, -21, 99, 120, 104, 66, -46, 6, 88, -126, 85, 27, 61, 33, -86, 52, 105, -76, 99, 8, 14, 86, -19, 18, 37, -8, 18, 126, 12, 83, -88, 22, 113, -80, 98, 40, 63, 109, -16, 48, 118, -68, 72, 45, 24, 86, -25, 35, 88, -28, 106, 123, 33, 114, -45, 117, 81, -94, 111, 3, 60, 120, -86, 110, 123, -28, 105, 101, 52, 94, -19, 31, 97, -67, 104, 3, 41, 117, -84, 51, 82, -65, 86, 6, 57, 60, -86, 124, 115, -89, 23, 30, 11, 60, -39, 52, 67, -125, 66, 36, 41, 60, -7, 20, 69, -80, 111, 120, 41, 89, -10, 47, 103, -102, 100, 15, 10, 86, -33 };
  public static final byte[] b = { 8, 84, -26, 87, 39, 47, 127, -49, 22, 81 };
  public static final byte[] c = { 23, 67, -110 };
  
  public static h.b a(DataInputStream paramDataInputStream)
  {
    h.b localb = new h.b(null);
    try
    {
      localb.a = paramDataInputStream.readInt();
      localb.b = paramDataInputStream.readInt();
      localb.c = paramDataInputStream.readInt();
      if (localb.c > 0)
      {
        if (localb.c > 256) {
          return null;
        }
        localb.d = new byte[localb.c];
        paramDataInputStream.read(localb.d);
        return localb;
      }
      return null;
    }
    catch (IOException paramDataInputStream)
    {
      paramDataInputStream.printStackTrace();
    }
    return null;
  }
  
  public static PublicKey a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = b.a(a);
    }
    paramString = new X509EncodedKeySpec(Base64.decode(str, 0));
    try
    {
      paramString = KeyFactory.getInstance(b.a(c)).generatePublic(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean a(DataInputStream paramDataInputStream, int paramInt, byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    int i;
    for (;;)
    {
      try
      {
        localSignature = Signature.getInstance(b.a(b));
        localSignature.initVerify(paramPublicKey);
        paramPublicKey = new byte[8192];
        if (paramInt < 8192) {
          i = paramDataInputStream.read(paramPublicKey, 0, paramInt);
        } else {
          i = paramDataInputStream.read(paramPublicKey);
        }
      }
      catch (Exception paramDataInputStream)
      {
        Signature localSignature;
        paramDataInputStream.printStackTrace();
        return false;
      }
      localSignature.update(paramPublicKey, 0, i);
      paramInt -= i;
    }
    for (;;)
    {
      boolean bool = localSignature.verify(paramArrayOfByte);
      return bool;
      if (i != 0) {
        if (i != -1) {
          break;
        }
      }
    }
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 241	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 7
    //   15: aconst_null
    //   16: astore 9
    //   18: new 162	java/io/DataInputStream
    //   21: dup
    //   22: new 243	java/io/FileInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 246	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: invokespecial 249	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore 5
    //   35: aload 9
    //   37: astore 7
    //   39: aload 5
    //   41: astore 6
    //   43: aload 5
    //   45: invokevirtual 252	java/io/DataInputStream:available	()I
    //   48: istore_2
    //   49: iload_2
    //   50: sipush 140
    //   53: if_icmpgt +17 -> 70
    //   56: aload 5
    //   58: invokevirtual 255	java/io/DataInputStream:close	()V
    //   61: iconst_0
    //   62: ireturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   68: iconst_0
    //   69: ireturn
    //   70: iload_2
    //   71: sipush 140
    //   74: isub
    //   75: istore_2
    //   76: aload 9
    //   78: astore 7
    //   80: aload 5
    //   82: astore 6
    //   84: aload 5
    //   86: iload_2
    //   87: invokevirtual 259	java/io/DataInputStream:skipBytes	(I)I
    //   90: pop
    //   91: aload 9
    //   93: astore 7
    //   95: aload 5
    //   97: astore 6
    //   99: aload 5
    //   101: invokestatic 261	a/a/a/b/h:a	(Ljava/io/DataInputStream;)La/a/a/b/h$b;
    //   104: astore 10
    //   106: aload 10
    //   108: ifnonnull +17 -> 125
    //   111: aload 5
    //   113: invokevirtual 255	java/io/DataInputStream:close	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   123: iconst_0
    //   124: ireturn
    //   125: aload 9
    //   127: astore 7
    //   129: aload 5
    //   131: astore 6
    //   133: aload 10
    //   135: getfield 169	a/a/a/b/h$b:a	I
    //   138: istore_3
    //   139: iload_3
    //   140: ldc_w 262
    //   143: if_icmpeq +17 -> 160
    //   146: aload 5
    //   148: invokevirtual 255	java/io/DataInputStream:close	()V
    //   151: iconst_0
    //   152: ireturn
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   158: iconst_0
    //   159: ireturn
    //   160: aload 9
    //   162: astore 7
    //   164: aload 5
    //   166: astore 6
    //   168: aload 10
    //   170: getfield 171	a/a/a/b/h$b:b	I
    //   173: istore_3
    //   174: iload_3
    //   175: ifle +145 -> 320
    //   178: iload_3
    //   179: ldc_w 263
    //   182: if_icmple +6 -> 188
    //   185: goto +135 -> 320
    //   188: iload_2
    //   189: iload_3
    //   190: if_icmpeq +17 -> 207
    //   193: aload 5
    //   195: invokevirtual 255	java/io/DataInputStream:close	()V
    //   198: iconst_0
    //   199: ireturn
    //   200: astore_0
    //   201: aload_0
    //   202: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   205: iconst_0
    //   206: ireturn
    //   207: aload 9
    //   209: astore 7
    //   211: aload 5
    //   213: astore 6
    //   215: aload_1
    //   216: invokestatic 265	a/a/a/b/h:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   219: astore_1
    //   220: aload_1
    //   221: ifnonnull +17 -> 238
    //   224: aload 5
    //   226: invokevirtual 255	java/io/DataInputStream:close	()V
    //   229: iconst_0
    //   230: ireturn
    //   231: astore_0
    //   232: aload_0
    //   233: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   236: iconst_0
    //   237: ireturn
    //   238: aload 9
    //   240: astore 7
    //   242: aload 5
    //   244: astore 6
    //   246: new 162	java/io/DataInputStream
    //   249: dup
    //   250: new 243	java/io/FileInputStream
    //   253: dup
    //   254: aload_0
    //   255: invokespecial 246	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   258: invokespecial 249	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   261: astore_0
    //   262: aload_0
    //   263: aload 10
    //   265: getfield 171	a/a/a/b/h$b:b	I
    //   268: aload 10
    //   270: getfield 176	a/a/a/b/h$b:d	[B
    //   273: aload_1
    //   274: invokestatic 267	a/a/a/b/h:a	(Ljava/io/DataInputStream;I[BLjava/security/PublicKey;)Z
    //   277: istore 4
    //   279: aload 5
    //   281: invokevirtual 255	java/io/DataInputStream:close	()V
    //   284: goto +8 -> 292
    //   287: astore_1
    //   288: aload_1
    //   289: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   292: aload_0
    //   293: invokevirtual 255	java/io/DataInputStream:close	()V
    //   296: iload 4
    //   298: ireturn
    //   299: astore_0
    //   300: aload_0
    //   301: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   304: iload 4
    //   306: ireturn
    //   307: astore_1
    //   308: aload_0
    //   309: astore 7
    //   311: aload_1
    //   312: astore_0
    //   313: goto +96 -> 409
    //   316: astore_1
    //   317: goto +46 -> 363
    //   320: aload 5
    //   322: invokevirtual 255	java/io/DataInputStream:close	()V
    //   325: iconst_0
    //   326: ireturn
    //   327: astore_0
    //   328: aload_0
    //   329: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   332: iconst_0
    //   333: ireturn
    //   334: astore_0
    //   335: aload 6
    //   337: astore 5
    //   339: goto +70 -> 409
    //   342: astore_1
    //   343: aload 8
    //   345: astore_0
    //   346: goto +17 -> 363
    //   349: astore_0
    //   350: aconst_null
    //   351: astore 5
    //   353: goto +56 -> 409
    //   356: astore_1
    //   357: aconst_null
    //   358: astore 5
    //   360: aload 8
    //   362: astore_0
    //   363: aload_0
    //   364: astore 7
    //   366: aload 5
    //   368: astore 6
    //   370: aload_1
    //   371: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   374: aload 5
    //   376: ifnull +16 -> 392
    //   379: aload 5
    //   381: invokevirtual 255	java/io/DataInputStream:close	()V
    //   384: goto +8 -> 392
    //   387: astore_1
    //   388: aload_1
    //   389: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   392: aload_0
    //   393: ifnull +14 -> 407
    //   396: aload_0
    //   397: invokevirtual 255	java/io/DataInputStream:close	()V
    //   400: iconst_0
    //   401: ireturn
    //   402: astore_0
    //   403: aload_0
    //   404: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   407: iconst_0
    //   408: ireturn
    //   409: aload 5
    //   411: ifnull +16 -> 427
    //   414: aload 5
    //   416: invokevirtual 255	java/io/DataInputStream:close	()V
    //   419: goto +8 -> 427
    //   422: astore_1
    //   423: aload_1
    //   424: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   427: aload 7
    //   429: ifnull +16 -> 445
    //   432: aload 7
    //   434: invokevirtual 255	java/io/DataInputStream:close	()V
    //   437: goto +8 -> 445
    //   440: astore_1
    //   441: aload_1
    //   442: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   445: aload_0
    //   446: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	paramFile	java.io.File
    //   0	447	1	paramString	String
    //   48	143	2	i	int
    //   138	53	3	j	int
    //   277	28	4	bool	boolean
    //   33	382	5	localObject1	Object
    //   41	328	6	localObject2	Object
    //   13	420	7	localObject3	Object
    //   10	351	8	localObject4	Object
    //   16	223	9	localObject5	Object
    //   104	165	10	localb	h.b
    // Exception table:
    //   from	to	target	type
    //   56	61	63	java/io/IOException
    //   111	116	118	java/io/IOException
    //   146	151	153	java/io/IOException
    //   193	198	200	java/io/IOException
    //   224	229	231	java/io/IOException
    //   279	284	287	java/io/IOException
    //   292	296	299	java/io/IOException
    //   262	279	307	finally
    //   262	279	316	java/io/IOException
    //   320	325	327	java/io/IOException
    //   43	49	334	finally
    //   84	91	334	finally
    //   99	106	334	finally
    //   133	139	334	finally
    //   168	174	334	finally
    //   215	220	334	finally
    //   246	262	334	finally
    //   370	374	334	finally
    //   43	49	342	java/io/IOException
    //   84	91	342	java/io/IOException
    //   99	106	342	java/io/IOException
    //   133	139	342	java/io/IOException
    //   168	174	342	java/io/IOException
    //   215	220	342	java/io/IOException
    //   246	262	342	java/io/IOException
    //   18	35	349	finally
    //   18	35	356	java/io/IOException
    //   379	384	387	java/io/IOException
    //   396	400	402	java/io/IOException
    //   414	419	422	java/io/IOException
    //   432	437	440	java/io/IOException
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 9
    //   15: new 162	java/io/DataInputStream
    //   18: dup
    //   19: new 270	java/io/ByteArrayInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 271	java/io/ByteArrayInputStream:<init>	([B)V
    //   27: invokespecial 249	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: astore 5
    //   32: aload 9
    //   34: astore 7
    //   36: aload 5
    //   38: astore 6
    //   40: aload 5
    //   42: invokevirtual 252	java/io/DataInputStream:available	()I
    //   45: istore_2
    //   46: iload_2
    //   47: sipush 140
    //   50: if_icmpgt +17 -> 67
    //   53: aload 5
    //   55: invokevirtual 255	java/io/DataInputStream:close	()V
    //   58: iconst_0
    //   59: ireturn
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   65: iconst_0
    //   66: ireturn
    //   67: iload_2
    //   68: sipush 140
    //   71: isub
    //   72: istore_2
    //   73: aload 9
    //   75: astore 7
    //   77: aload 5
    //   79: astore 6
    //   81: aload 5
    //   83: iload_2
    //   84: invokevirtual 259	java/io/DataInputStream:skipBytes	(I)I
    //   87: pop
    //   88: aload 9
    //   90: astore 7
    //   92: aload 5
    //   94: astore 6
    //   96: aload 5
    //   98: invokestatic 261	a/a/a/b/h:a	(Ljava/io/DataInputStream;)La/a/a/b/h$b;
    //   101: astore 10
    //   103: aload 10
    //   105: ifnonnull +17 -> 122
    //   108: aload 5
    //   110: invokevirtual 255	java/io/DataInputStream:close	()V
    //   113: iconst_0
    //   114: ireturn
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   120: iconst_0
    //   121: ireturn
    //   122: aload 9
    //   124: astore 7
    //   126: aload 5
    //   128: astore 6
    //   130: aload 10
    //   132: getfield 169	a/a/a/b/h$b:a	I
    //   135: istore_3
    //   136: iload_3
    //   137: ldc_w 262
    //   140: if_icmpeq +17 -> 157
    //   143: aload 5
    //   145: invokevirtual 255	java/io/DataInputStream:close	()V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   155: iconst_0
    //   156: ireturn
    //   157: aload 9
    //   159: astore 7
    //   161: aload 5
    //   163: astore 6
    //   165: aload 10
    //   167: getfield 171	a/a/a/b/h$b:b	I
    //   170: istore_3
    //   171: iload_3
    //   172: ifle +145 -> 317
    //   175: iload_3
    //   176: ldc_w 263
    //   179: if_icmple +6 -> 185
    //   182: goto +135 -> 317
    //   185: iload_2
    //   186: iload_3
    //   187: if_icmpeq +17 -> 204
    //   190: aload 5
    //   192: invokevirtual 255	java/io/DataInputStream:close	()V
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_0
    //   198: aload_0
    //   199: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   202: iconst_0
    //   203: ireturn
    //   204: aload 9
    //   206: astore 7
    //   208: aload 5
    //   210: astore 6
    //   212: aload_1
    //   213: invokestatic 265	a/a/a/b/h:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   216: astore_1
    //   217: aload_1
    //   218: ifnonnull +17 -> 235
    //   221: aload 5
    //   223: invokevirtual 255	java/io/DataInputStream:close	()V
    //   226: iconst_0
    //   227: ireturn
    //   228: astore_0
    //   229: aload_0
    //   230: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   233: iconst_0
    //   234: ireturn
    //   235: aload 9
    //   237: astore 7
    //   239: aload 5
    //   241: astore 6
    //   243: new 162	java/io/DataInputStream
    //   246: dup
    //   247: new 270	java/io/ByteArrayInputStream
    //   250: dup
    //   251: aload_0
    //   252: invokespecial 271	java/io/ByteArrayInputStream:<init>	([B)V
    //   255: invokespecial 249	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   258: astore_0
    //   259: aload_0
    //   260: aload 10
    //   262: getfield 171	a/a/a/b/h$b:b	I
    //   265: aload 10
    //   267: getfield 176	a/a/a/b/h$b:d	[B
    //   270: aload_1
    //   271: invokestatic 267	a/a/a/b/h:a	(Ljava/io/DataInputStream;I[BLjava/security/PublicKey;)Z
    //   274: istore 4
    //   276: aload 5
    //   278: invokevirtual 255	java/io/DataInputStream:close	()V
    //   281: goto +8 -> 289
    //   284: astore_1
    //   285: aload_1
    //   286: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   289: aload_0
    //   290: invokevirtual 255	java/io/DataInputStream:close	()V
    //   293: iload 4
    //   295: ireturn
    //   296: astore_0
    //   297: aload_0
    //   298: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   301: iload 4
    //   303: ireturn
    //   304: astore_1
    //   305: aload_0
    //   306: astore 7
    //   308: aload_1
    //   309: astore_0
    //   310: goto +96 -> 406
    //   313: astore_1
    //   314: goto +46 -> 360
    //   317: aload 5
    //   319: invokevirtual 255	java/io/DataInputStream:close	()V
    //   322: iconst_0
    //   323: ireturn
    //   324: astore_0
    //   325: aload_0
    //   326: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   329: iconst_0
    //   330: ireturn
    //   331: astore_0
    //   332: aload 6
    //   334: astore 5
    //   336: goto +70 -> 406
    //   339: astore_1
    //   340: aload 8
    //   342: astore_0
    //   343: goto +17 -> 360
    //   346: astore_0
    //   347: aconst_null
    //   348: astore 5
    //   350: goto +56 -> 406
    //   353: astore_1
    //   354: aconst_null
    //   355: astore 5
    //   357: aload 8
    //   359: astore_0
    //   360: aload_0
    //   361: astore 7
    //   363: aload 5
    //   365: astore 6
    //   367: aload_1
    //   368: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   371: aload 5
    //   373: ifnull +16 -> 389
    //   376: aload 5
    //   378: invokevirtual 255	java/io/DataInputStream:close	()V
    //   381: goto +8 -> 389
    //   384: astore_1
    //   385: aload_1
    //   386: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   389: aload_0
    //   390: ifnull +14 -> 404
    //   393: aload_0
    //   394: invokevirtual 255	java/io/DataInputStream:close	()V
    //   397: iconst_0
    //   398: ireturn
    //   399: astore_0
    //   400: aload_0
    //   401: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   404: iconst_0
    //   405: ireturn
    //   406: aload 5
    //   408: ifnull +16 -> 424
    //   411: aload 5
    //   413: invokevirtual 255	java/io/DataInputStream:close	()V
    //   416: goto +8 -> 424
    //   419: astore_1
    //   420: aload_1
    //   421: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   424: aload 7
    //   426: ifnull +16 -> 442
    //   429: aload 7
    //   431: invokevirtual 255	java/io/DataInputStream:close	()V
    //   434: goto +8 -> 442
    //   437: astore_1
    //   438: aload_1
    //   439: invokevirtual 183	java/io/IOException:printStackTrace	()V
    //   442: aload_0
    //   443: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	paramArrayOfByte	byte[]
    //   0	444	1	paramString	String
    //   45	143	2	i	int
    //   135	53	3	j	int
    //   274	28	4	bool	boolean
    //   30	382	5	localObject1	Object
    //   38	328	6	localObject2	Object
    //   10	420	7	localObject3	Object
    //   7	351	8	localObject4	Object
    //   13	223	9	localObject5	Object
    //   101	165	10	localb	h.b
    // Exception table:
    //   from	to	target	type
    //   53	58	60	java/io/IOException
    //   108	113	115	java/io/IOException
    //   143	148	150	java/io/IOException
    //   190	195	197	java/io/IOException
    //   221	226	228	java/io/IOException
    //   276	281	284	java/io/IOException
    //   289	293	296	java/io/IOException
    //   259	276	304	finally
    //   259	276	313	java/io/IOException
    //   317	322	324	java/io/IOException
    //   40	46	331	finally
    //   81	88	331	finally
    //   96	103	331	finally
    //   130	136	331	finally
    //   165	171	331	finally
    //   212	217	331	finally
    //   243	259	331	finally
    //   367	371	331	finally
    //   40	46	339	java/io/IOException
    //   81	88	339	java/io/IOException
    //   96	103	339	java/io/IOException
    //   130	136	339	java/io/IOException
    //   165	171	339	java/io/IOException
    //   212	217	339	java/io/IOException
    //   243	259	339	java/io/IOException
    //   15	32	346	finally
    //   15	32	353	java/io/IOException
    //   376	381	384	java/io/IOException
    //   393	397	399	java/io/IOException
    //   411	416	419	java/io/IOException
    //   429	434	437	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     a.a.a.b.h
 * JD-Core Version:    0.7.0.1
 */