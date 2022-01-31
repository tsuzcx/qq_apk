import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qqprotect.qsec.ICloudAVEngine.ResultBundle;
import com.tencent.util.Pair;
import java.io.File;
import org.xmlpull.v1.XmlPullParser;

final class alhi
{
  private alhj jdField_a_of_type_Alhj;
  private File jdField_a_of_type_JavaIoFile;
  
  public alhi(File paramFile, alhj paramalhj)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Alhj = paramalhj;
  }
  
  private Pair a(XmlPullParser paramXmlPullParser)
  {
    try
    {
      String str = paramXmlPullParser.getAttributeValue(null, "Key");
      if (TextUtils.isEmpty(str)) {
        return null;
      }
      ICloudAVEngine.ResultBundle localResultBundle = new ICloudAVEngine.ResultBundle();
      localResultBundle.jdField_a_of_type_Int = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "AttrType"));
      localResultBundle.b = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "Category"));
      localResultBundle.c = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "SubCategory"));
      localResultBundle.d = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "Action"));
      localResultBundle.jdField_a_of_type_Long = Long.parseLong(paramXmlPullParser.getAttributeValue(null, "ExpireTime"));
      paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "ExtraInfo");
      if (!TextUtils.isEmpty(paramXmlPullParser)) {
        localResultBundle.jdField_a_of_type_ArrayOfByte = Base64.decode(paramXmlPullParser, 0);
      }
      paramXmlPullParser = new Pair(str, localResultBundle);
      return paramXmlPullParser;
    }
    catch (Exception paramXmlPullParser)
    {
      paramXmlPullParser.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: new 97	javax/crypto/spec/SecretKeySpec
    //   3: dup
    //   4: ldc 99
    //   6: invokevirtual 105	java/lang/String:getBytes	()[B
    //   9: ldc 107
    //   11: invokespecial 110	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   14: astore 5
    //   16: ldc 107
    //   18: invokestatic 116	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   21: astore 6
    //   23: aload 6
    //   25: iconst_2
    //   26: aload 5
    //   28: invokevirtual 120	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   31: new 122	javax/crypto/CipherInputStream
    //   34: dup
    //   35: new 124	java/io/BufferedInputStream
    //   38: dup
    //   39: new 126	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: getfield 14	alhi:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   47: invokespecial 129	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: invokespecial 132	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: aload 6
    //   55: invokespecial 135	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   58: astore 7
    //   60: invokestatic 141	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   63: astore 8
    //   65: aload 8
    //   67: aload 7
    //   69: ldc 143
    //   71: invokeinterface 147 3 0
    //   76: aload 8
    //   78: invokeinterface 151 1 0
    //   83: istore_3
    //   84: iconst_0
    //   85: istore_1
    //   86: aconst_null
    //   87: astore 5
    //   89: iload_3
    //   90: iconst_1
    //   91: if_icmpeq +46 -> 137
    //   94: iload_3
    //   95: iconst_2
    //   96: if_icmpne +116 -> 212
    //   99: aload 8
    //   101: invokeinterface 155 1 0
    //   106: astore 6
    //   108: aload 6
    //   110: ldc 157
    //   112: invokevirtual 161	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   115: ifeq +72 -> 187
    //   118: aload 8
    //   120: aconst_null
    //   121: ldc 163
    //   123: invokeinterface 28 3 0
    //   128: invokestatic 45	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   131: istore_1
    //   132: iload_1
    //   133: iconst_1
    //   134: if_icmpeq +28 -> 162
    //   137: aload 7
    //   139: ifnull +8 -> 147
    //   142: aload 7
    //   144: invokevirtual 168	java/io/InputStream:close	()V
    //   147: aload_0
    //   148: getfield 16	alhi:jdField_a_of_type_Alhj	Lalhj;
    //   151: ifnull +10 -> 161
    //   154: aload_0
    //   155: getfield 16	alhi:jdField_a_of_type_Alhj	Lalhj;
    //   158: invokevirtual 172	alhj:a	()V
    //   161: return
    //   162: iconst_1
    //   163: istore_1
    //   164: iload_1
    //   165: istore_2
    //   166: aload 5
    //   168: astore 6
    //   170: aload 8
    //   172: invokeinterface 175 1 0
    //   177: istore_3
    //   178: aload 6
    //   180: astore 5
    //   182: iload_2
    //   183: istore_1
    //   184: goto -95 -> 89
    //   187: iload_1
    //   188: ifeq +240 -> 428
    //   191: aload 6
    //   193: ldc 177
    //   195: invokevirtual 161	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   198: ifeq +230 -> 428
    //   201: aload_0
    //   202: aload 8
    //   204: invokespecial 179	alhi:a	(Lorg/xmlpull/v1/XmlPullParser;)Lcom/tencent/util/Pair;
    //   207: astore 5
    //   209: goto -45 -> 164
    //   212: aload 5
    //   214: astore 6
    //   216: iload_1
    //   217: istore_2
    //   218: iload_3
    //   219: iconst_3
    //   220: if_icmpne -50 -> 170
    //   223: aload 5
    //   225: astore 6
    //   227: iload_1
    //   228: istore_2
    //   229: ldc 177
    //   231: aload 8
    //   233: invokeinterface 155 1 0
    //   238: invokevirtual 161	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   241: ifeq -71 -> 170
    //   244: aload 5
    //   246: astore 6
    //   248: iload_1
    //   249: istore_2
    //   250: aload 5
    //   252: ifnull -82 -> 170
    //   255: aload_0
    //   256: getfield 16	alhi:jdField_a_of_type_Alhj	Lalhj;
    //   259: ifnull +33 -> 292
    //   262: aload_0
    //   263: getfield 16	alhi:jdField_a_of_type_Alhj	Lalhj;
    //   266: aload 5
    //   268: getfield 183	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   271: checkcast 101	java/lang/String
    //   274: aload 5
    //   276: getfield 186	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   279: checkcast 36	com/tencent/qqprotect/qsec/ICloudAVEngine$ResultBundle
    //   282: invokevirtual 189	alhj:a	(Ljava/lang/String;Lcom/tencent/qqprotect/qsec/ICloudAVEngine$ResultBundle;)Z
    //   285: istore 4
    //   287: iload 4
    //   289: ifeq -152 -> 137
    //   292: aconst_null
    //   293: astore 6
    //   295: iload_1
    //   296: istore_2
    //   297: goto -127 -> 170
    //   300: astore 5
    //   302: aload 5
    //   304: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   307: goto -160 -> 147
    //   310: astore 6
    //   312: aconst_null
    //   313: astore 5
    //   315: aload 6
    //   317: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   320: aload 5
    //   322: ifnull +8 -> 330
    //   325: aload 5
    //   327: invokevirtual 168	java/io/InputStream:close	()V
    //   330: aload_0
    //   331: getfield 16	alhi:jdField_a_of_type_Alhj	Lalhj;
    //   334: ifnull -173 -> 161
    //   337: aload_0
    //   338: getfield 16	alhi:jdField_a_of_type_Alhj	Lalhj;
    //   341: invokevirtual 172	alhj:a	()V
    //   344: return
    //   345: astore 5
    //   347: aload 5
    //   349: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   352: goto -22 -> 330
    //   355: astore 5
    //   357: aconst_null
    //   358: astore 6
    //   360: aload 6
    //   362: ifnull +8 -> 370
    //   365: aload 6
    //   367: invokevirtual 168	java/io/InputStream:close	()V
    //   370: aload_0
    //   371: getfield 16	alhi:jdField_a_of_type_Alhj	Lalhj;
    //   374: ifnull +10 -> 384
    //   377: aload_0
    //   378: getfield 16	alhi:jdField_a_of_type_Alhj	Lalhj;
    //   381: invokevirtual 172	alhj:a	()V
    //   384: aload 5
    //   386: athrow
    //   387: astore 6
    //   389: aload 6
    //   391: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   394: goto -24 -> 370
    //   397: astore 5
    //   399: aload 7
    //   401: astore 6
    //   403: goto -43 -> 360
    //   406: astore 7
    //   408: aload 5
    //   410: astore 6
    //   412: aload 7
    //   414: astore 5
    //   416: goto -56 -> 360
    //   419: astore 6
    //   421: aload 7
    //   423: astore 5
    //   425: goto -110 -> 315
    //   428: goto -264 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	alhi
    //   85	211	1	i	int
    //   165	132	2	j	int
    //   83	138	3	k	int
    //   285	3	4	bool	boolean
    //   14	261	5	localObject1	Object
    //   300	3	5	localIOException1	java.io.IOException
    //   313	13	5	localObject2	Object
    //   345	3	5	localIOException2	java.io.IOException
    //   355	30	5	localObject3	Object
    //   397	12	5	localObject4	Object
    //   414	10	5	localObject5	Object
    //   21	273	6	localObject6	Object
    //   310	6	6	localException1	Exception
    //   358	8	6	localObject7	Object
    //   387	3	6	localIOException3	java.io.IOException
    //   401	10	6	localObject8	Object
    //   419	1	6	localException2	Exception
    //   58	342	7	localCipherInputStream	javax.crypto.CipherInputStream
    //   406	16	7	localObject9	Object
    //   63	169	8	localXmlPullParser	XmlPullParser
    // Exception table:
    //   from	to	target	type
    //   142	147	300	java/io/IOException
    //   0	60	310	java/lang/Exception
    //   325	330	345	java/io/IOException
    //   0	60	355	finally
    //   365	370	387	java/io/IOException
    //   60	84	397	finally
    //   99	132	397	finally
    //   170	178	397	finally
    //   191	209	397	finally
    //   229	244	397	finally
    //   255	287	397	finally
    //   315	320	406	finally
    //   60	84	419	java/lang/Exception
    //   99	132	419	java/lang/Exception
    //   170	178	419	java/lang/Exception
    //   191	209	419	java/lang/Exception
    //   229	244	419	java/lang/Exception
    //   255	287	419	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alhi
 * JD-Core Version:    0.7.0.1
 */