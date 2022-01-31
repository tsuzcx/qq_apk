import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

public class ahfp
{
  private volatile SpringFestivalRedpacketConfBean jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public ahfp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private SpringFestivalRedpacketConfBean a(int paramInt1, int paramInt2, String paramString, List<Integer> paramList)
  {
    SpringFestivalRedpacketConfBean localSpringFestivalRedpacketConfBean = null;
    int i;
    if (paramString != null)
    {
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label130;
      }
      i = 0;
      if (i >= paramList.size()) {
        break label130;
      }
      if (((Integer)paramList.get(i)).intValue() <= 0) {
        break label121;
      }
    }
    label130:
    for (long l = ((Integer)paramList.get(i)).intValue() * 1000;; l = 0L)
    {
      localSpringFestivalRedpacketConfBean = SpringFestivalRedpacketConfBean.parse(paramString);
      if (localSpringFestivalRedpacketConfBean != null)
      {
        localSpringFestivalRedpacketConfBean.version = paramInt1;
        localSpringFestivalRedpacketConfBean.taskId = paramInt2;
        if (localSpringFestivalRedpacketConfBean.springFestivalHbEntryInfo != null) {
          localSpringFestivalRedpacketConfBean.springFestivalHbEntryInfo.pendantDelay = l;
        }
      }
      return localSpringFestivalRedpacketConfBean;
      label121:
      i += 1;
      break;
    }
  }
  
  private String a()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      String str = "config_md5_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject = ((Context)localObject).getSharedPreferences("spring_festival_redpacket_entry_config_sp", 0).getString(str, "");
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("springHb_SpringFestivalRedpacketConfProcessor", 1, "getLocalConfigMD5FromSP fail.", localException);
    }
    return null;
  }
  
  private void a()
  {
    try
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        Object localObject1 = "spring_festival_redpacket_entry_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        QLog.i("springHb_SpringFestivalRedpacketConfProcessor", 1, String.format("deleteLocalEntryConfig fileName=%s", new Object[] { localObject1 }));
        localObject1 = BaseApplicationImpl.getContext().getFileStreamPath((String)localObject1);
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        a(0, "");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("springHb_SpringFestivalRedpacketConfProcessor", 1, "deleteLocalEntryConfig fail.", localException);
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    QLog.i("springHb_SpringFestivalRedpacketConfProcessor", 1, String.format("saveLocalConfigVersionToSP version=%s md5=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    try
    {
      BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      String str1 = "config_version_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      String str2 = "config_md5_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localBaseApplication.getSharedPreferences("spring_festival_redpacket_entry_config_sp", 0).edit().putInt(str1, paramInt).putString(str2, paramString).apply();
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("springHb_SpringFestivalRedpacketConfProcessor", 1, "saveLocalConfigInfoToSP fail.", paramString);
    }
  }
  
  private void a(SpringFestivalRedpacketConfBean paramSpringFestivalRedpacketConfBean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean = paramSpringFestivalRedpacketConfBean;
    ahfz localahfz = (ahfz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(342);
    if ((localahfz != null) && (paramSpringFestivalRedpacketConfBean != null)) {
      localahfz.a(paramSpringFestivalRedpacketConfBean.springFestivalHbEntryInfo);
    }
  }
  
  /* Error */
  private SpringFestivalRedpacketConfBean b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 15	ahfp:jdField_a_of_type_ArrayOfByte	[B
    //   12: astore 7
    //   14: aload 7
    //   16: monitorenter
    //   17: new 70	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   24: ldc 111
    //   26: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: getfield 17	ahfp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 80	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   36: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 6
    //   44: invokestatic 128	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   47: aload 6
    //   49: invokevirtual 134	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 140	java/io/File:exists	()Z
    //   57: ifeq +138 -> 195
    //   60: aload_0
    //   61: invokespecial 191	ahfp:a	()Ljava/lang/String;
    //   64: aload_1
    //   65: invokevirtual 194	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: invokestatic 199	bdhv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   71: invokestatic 205	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   74: ifeq +109 -> 183
    //   77: ldc 206
    //   79: newarray byte
    //   81: astore_2
    //   82: new 208	java/io/FileInputStream
    //   85: dup
    //   86: aload_1
    //   87: invokespecial 211	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   90: astore_1
    //   91: aload_1
    //   92: aload_2
    //   93: invokevirtual 215	java/io/FileInputStream:read	([B)I
    //   96: pop
    //   97: new 217	java/io/ByteArrayInputStream
    //   100: dup
    //   101: aload_2
    //   102: invokespecial 220	java/io/ByteArrayInputStream:<init>	([B)V
    //   105: astore_3
    //   106: new 222	java/io/ObjectInputStream
    //   109: dup
    //   110: aload_3
    //   111: invokespecial 225	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   114: astore_2
    //   115: aload_2
    //   116: invokevirtual 229	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   119: checkcast 36	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean
    //   122: astore 5
    //   124: aload_2
    //   125: astore 4
    //   127: aload_1
    //   128: astore_2
    //   129: aload 5
    //   131: astore_1
    //   132: aload 4
    //   134: ifnull +8 -> 142
    //   137: aload 4
    //   139: invokevirtual 232	java/io/ObjectInputStream:close	()V
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 233	java/io/ByteArrayInputStream:close	()V
    //   150: aload_2
    //   151: ifnull +7 -> 158
    //   154: aload_2
    //   155: invokevirtual 234	java/io/FileInputStream:close	()V
    //   158: ldc 101
    //   160: iconst_1
    //   161: ldc 236
    //   163: iconst_1
    //   164: anewarray 4	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload 6
    //   171: aastore
    //   172: invokestatic 119	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   175: invokestatic 123	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: aload 7
    //   180: monitorexit
    //   181: aload_1
    //   182: areturn
    //   183: ldc 101
    //   185: iconst_1
    //   186: ldc 238
    //   188: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_0
    //   192: invokespecial 242	ahfp:a	()V
    //   195: aconst_null
    //   196: astore_3
    //   197: aconst_null
    //   198: astore 5
    //   200: aconst_null
    //   201: astore_1
    //   202: aload_2
    //   203: astore 4
    //   205: aload 5
    //   207: astore_2
    //   208: goto -76 -> 132
    //   211: astore_3
    //   212: aconst_null
    //   213: astore_1
    //   214: aconst_null
    //   215: astore_2
    //   216: ldc 101
    //   218: iconst_1
    //   219: ldc 244
    //   221: aload_3
    //   222: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload_0
    //   226: invokespecial 242	ahfp:a	()V
    //   229: new 246	java/lang/RuntimeException
    //   232: dup
    //   233: ldc 248
    //   235: invokespecial 251	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   238: athrow
    //   239: astore 5
    //   241: aload 4
    //   243: astore_3
    //   244: aload_1
    //   245: astore 4
    //   247: aload_2
    //   248: astore_1
    //   249: aload 5
    //   251: astore_2
    //   252: aload 4
    //   254: ifnull +8 -> 262
    //   257: aload 4
    //   259: invokevirtual 232	java/io/ObjectInputStream:close	()V
    //   262: aload_3
    //   263: ifnull +7 -> 270
    //   266: aload_3
    //   267: invokevirtual 233	java/io/ByteArrayInputStream:close	()V
    //   270: aload_1
    //   271: ifnull +7 -> 278
    //   274: aload_1
    //   275: invokevirtual 234	java/io/FileInputStream:close	()V
    //   278: aload_2
    //   279: athrow
    //   280: astore_1
    //   281: aload 7
    //   283: monitorexit
    //   284: aload_1
    //   285: athrow
    //   286: astore 4
    //   288: goto -146 -> 142
    //   291: astore_3
    //   292: goto -142 -> 150
    //   295: astore_2
    //   296: goto -138 -> 158
    //   299: astore 4
    //   301: goto -39 -> 262
    //   304: astore_3
    //   305: goto -35 -> 270
    //   308: astore_1
    //   309: goto -31 -> 278
    //   312: astore_2
    //   313: aconst_null
    //   314: astore_3
    //   315: aconst_null
    //   316: astore_1
    //   317: aload 5
    //   319: astore 4
    //   321: goto -69 -> 252
    //   324: astore_2
    //   325: aconst_null
    //   326: astore_3
    //   327: aload 5
    //   329: astore 4
    //   331: goto -79 -> 252
    //   334: astore_2
    //   335: aload 5
    //   337: astore 4
    //   339: goto -87 -> 252
    //   342: astore 5
    //   344: aload_2
    //   345: astore 4
    //   347: aload 5
    //   349: astore_2
    //   350: goto -98 -> 252
    //   353: astore_3
    //   354: aconst_null
    //   355: astore 5
    //   357: aload_1
    //   358: astore_2
    //   359: aload 5
    //   361: astore_1
    //   362: goto -146 -> 216
    //   365: astore 6
    //   367: aconst_null
    //   368: astore 5
    //   370: aload_3
    //   371: astore 4
    //   373: aload_1
    //   374: astore_2
    //   375: aload 6
    //   377: astore_3
    //   378: aload 5
    //   380: astore_1
    //   381: goto -165 -> 216
    //   384: astore 6
    //   386: aload_3
    //   387: astore 4
    //   389: aload_1
    //   390: astore 5
    //   392: aload 6
    //   394: astore_3
    //   395: aload_2
    //   396: astore_1
    //   397: aload 5
    //   399: astore_2
    //   400: goto -184 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	ahfp
    //   52	223	1	localObject1	Object
    //   280	5	1	localObject2	Object
    //   308	1	1	localException1	Exception
    //   316	81	1	localObject3	Object
    //   7	272	2	localObject4	Object
    //   295	1	2	localException2	Exception
    //   312	1	2	localObject5	Object
    //   324	1	2	localObject6	Object
    //   334	11	2	localObject7	Object
    //   349	51	2	localObject8	Object
    //   105	92	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   211	11	3	localException3	Exception
    //   243	24	3	localObject9	Object
    //   291	1	3	localException4	Exception
    //   304	1	3	localException5	Exception
    //   314	13	3	localObject10	Object
    //   353	18	3	localException6	Exception
    //   377	18	3	localException7	Exception
    //   1	257	4	localObject11	Object
    //   286	1	4	localException8	Exception
    //   299	1	4	localException9	Exception
    //   319	69	4	localObject12	Object
    //   4	202	5	localSpringFestivalRedpacketConfBean	SpringFestivalRedpacketConfBean
    //   239	97	5	localObject13	Object
    //   342	6	5	localObject14	Object
    //   355	43	5	localObject15	Object
    //   42	128	6	str	String
    //   365	11	6	localException10	Exception
    //   384	9	6	localException11	Exception
    //   12	270	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	91	211	java/lang/Exception
    //   183	195	211	java/lang/Exception
    //   216	239	239	finally
    //   137	142	280	finally
    //   146	150	280	finally
    //   154	158	280	finally
    //   158	181	280	finally
    //   257	262	280	finally
    //   266	270	280	finally
    //   274	278	280	finally
    //   278	280	280	finally
    //   281	284	280	finally
    //   137	142	286	java/lang/Exception
    //   146	150	291	java/lang/Exception
    //   154	158	295	java/lang/Exception
    //   257	262	299	java/lang/Exception
    //   266	270	304	java/lang/Exception
    //   274	278	308	java/lang/Exception
    //   17	91	312	finally
    //   183	195	312	finally
    //   91	106	324	finally
    //   106	115	334	finally
    //   115	124	342	finally
    //   91	106	353	java/lang/Exception
    //   106	115	365	java/lang/Exception
    //   115	124	384	java/lang/Exception
  }
  
  /* Error */
  private void b(SpringFestivalRedpacketConfBean paramSpringFestivalRedpacketConfBean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 15	ahfp:jdField_a_of_type_ArrayOfByte	[B
    //   10: astore 6
    //   12: aload 6
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 17	ahfp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 254	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   22: astore_2
    //   23: new 70	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   30: ldc 111
    //   32: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore_2
    //   43: invokestatic 128	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   46: aload_2
    //   47: invokevirtual 134	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   50: astore 7
    //   52: invokestatic 128	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: new 70	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   62: aload_2
    //   63: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 256
    //   69: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 134	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   78: astore 8
    //   80: ldc 101
    //   82: iconst_1
    //   83: ldc_w 258
    //   86: iconst_1
    //   87: anewarray 4	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: aload_2
    //   93: aastore
    //   94: invokestatic 119	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   97: invokestatic 123	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload 8
    //   102: invokevirtual 140	java/io/File:exists	()Z
    //   105: ifeq +9 -> 114
    //   108: aload 8
    //   110: invokevirtual 143	java/io/File:delete	()Z
    //   113: pop
    //   114: aload 8
    //   116: invokevirtual 261	java/io/File:createNewFile	()Z
    //   119: pop
    //   120: new 263	java/io/FileOutputStream
    //   123: dup
    //   124: aload 8
    //   126: invokespecial 264	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   129: astore_2
    //   130: new 266	java/io/ByteArrayOutputStream
    //   133: dup
    //   134: sipush 8192
    //   137: invokespecial 269	java/io/ByteArrayOutputStream:<init>	(I)V
    //   140: astore 4
    //   142: new 271	java/io/ObjectOutputStream
    //   145: dup
    //   146: aload 4
    //   148: invokespecial 274	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   151: astore_3
    //   152: aload_3
    //   153: aload_1
    //   154: invokevirtual 278	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   157: aload_3
    //   158: invokevirtual 281	java/io/ObjectOutputStream:flush	()V
    //   161: aload 4
    //   163: aload_2
    //   164: invokevirtual 284	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   167: aload 4
    //   169: invokevirtual 285	java/io/ByteArrayOutputStream:flush	()V
    //   172: aload_2
    //   173: invokevirtual 286	java/io/FileOutputStream:flush	()V
    //   176: aload 7
    //   178: invokevirtual 140	java/io/File:exists	()Z
    //   181: ifeq +9 -> 190
    //   184: aload 7
    //   186: invokevirtual 143	java/io/File:delete	()Z
    //   189: pop
    //   190: aload 8
    //   192: aload 7
    //   194: invokevirtual 290	java/io/File:renameTo	(Ljava/io/File;)Z
    //   197: pop
    //   198: aload 7
    //   200: invokevirtual 194	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   203: invokestatic 199	bdhv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 5
    //   208: aload_0
    //   209: aload_1
    //   210: getfield 44	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/config/SpringFestivalRedpacketConfBean:version	I
    //   213: aload 5
    //   215: invokespecial 146	ahfp:a	(ILjava/lang/String;)V
    //   218: aload_2
    //   219: ifnull +7 -> 226
    //   222: aload_2
    //   223: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   226: aload 4
    //   228: ifnull +8 -> 236
    //   231: aload 4
    //   233: invokevirtual 292	java/io/ByteArrayOutputStream:close	()V
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 293	java/io/ObjectOutputStream:close	()V
    //   244: aload 6
    //   246: monitorexit
    //   247: return
    //   248: astore 5
    //   250: aconst_null
    //   251: astore_1
    //   252: aconst_null
    //   253: astore_3
    //   254: aload 4
    //   256: astore_2
    //   257: aload 5
    //   259: astore 4
    //   261: ldc 101
    //   263: iconst_1
    //   264: ldc_w 295
    //   267: aload 4
    //   269: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   272: aload_0
    //   273: invokespecial 242	ahfp:a	()V
    //   276: aload_2
    //   277: ifnull +7 -> 284
    //   280: aload_2
    //   281: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   284: aload_1
    //   285: ifnull +7 -> 292
    //   288: aload_1
    //   289: invokevirtual 292	java/io/ByteArrayOutputStream:close	()V
    //   292: aload_3
    //   293: ifnull -49 -> 244
    //   296: aload_3
    //   297: invokevirtual 293	java/io/ObjectOutputStream:close	()V
    //   300: goto -56 -> 244
    //   303: astore_1
    //   304: goto -60 -> 244
    //   307: astore_1
    //   308: aconst_null
    //   309: astore 4
    //   311: aconst_null
    //   312: astore_3
    //   313: aload 5
    //   315: astore_2
    //   316: aload_2
    //   317: ifnull +7 -> 324
    //   320: aload_2
    //   321: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   324: aload 4
    //   326: ifnull +8 -> 334
    //   329: aload 4
    //   331: invokevirtual 292	java/io/ByteArrayOutputStream:close	()V
    //   334: aload_3
    //   335: ifnull +7 -> 342
    //   338: aload_3
    //   339: invokevirtual 293	java/io/ObjectOutputStream:close	()V
    //   342: aload_1
    //   343: athrow
    //   344: astore_1
    //   345: aload 6
    //   347: monitorexit
    //   348: aload_1
    //   349: athrow
    //   350: astore_1
    //   351: goto -125 -> 226
    //   354: astore_1
    //   355: goto -119 -> 236
    //   358: astore_1
    //   359: goto -115 -> 244
    //   362: astore_2
    //   363: goto -79 -> 284
    //   366: astore_1
    //   367: goto -75 -> 292
    //   370: astore_2
    //   371: goto -47 -> 324
    //   374: astore_2
    //   375: goto -41 -> 334
    //   378: astore_2
    //   379: goto -37 -> 342
    //   382: astore_1
    //   383: aconst_null
    //   384: astore 4
    //   386: aconst_null
    //   387: astore_3
    //   388: goto -72 -> 316
    //   391: astore_1
    //   392: aconst_null
    //   393: astore_3
    //   394: goto -78 -> 316
    //   397: astore_1
    //   398: goto -82 -> 316
    //   401: astore 5
    //   403: aload_1
    //   404: astore 4
    //   406: aload 5
    //   408: astore_1
    //   409: goto -93 -> 316
    //   412: astore 4
    //   414: aconst_null
    //   415: astore_3
    //   416: aconst_null
    //   417: astore_1
    //   418: goto -157 -> 261
    //   421: astore 5
    //   423: aload 4
    //   425: astore_1
    //   426: aconst_null
    //   427: astore_3
    //   428: aload 5
    //   430: astore 4
    //   432: goto -171 -> 261
    //   435: astore 5
    //   437: aload 4
    //   439: astore_1
    //   440: aload 5
    //   442: astore 4
    //   444: goto -183 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	this	ahfp
    //   0	447	1	paramSpringFestivalRedpacketConfBean	SpringFestivalRedpacketConfBean
    //   22	299	2	localObject1	Object
    //   362	1	2	localException1	Exception
    //   370	1	2	localException2	Exception
    //   374	1	2	localException3	Exception
    //   378	1	2	localException4	Exception
    //   151	277	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   4	401	4	localObject2	Object
    //   412	12	4	localException5	Exception
    //   430	13	4	localException6	Exception
    //   1	213	5	str	String
    //   248	66	5	localException7	Exception
    //   401	6	5	localObject3	Object
    //   421	8	5	localException8	Exception
    //   435	6	5	localException9	Exception
    //   10	336	6	arrayOfByte	byte[]
    //   50	149	7	localFile1	File
    //   78	113	8	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   15	114	248	java/lang/Exception
    //   114	130	248	java/lang/Exception
    //   296	300	303	java/lang/Exception
    //   15	114	307	finally
    //   114	130	307	finally
    //   222	226	344	finally
    //   231	236	344	finally
    //   240	244	344	finally
    //   244	247	344	finally
    //   280	284	344	finally
    //   288	292	344	finally
    //   296	300	344	finally
    //   320	324	344	finally
    //   329	334	344	finally
    //   338	342	344	finally
    //   342	344	344	finally
    //   345	348	344	finally
    //   222	226	350	java/lang/Exception
    //   231	236	354	java/lang/Exception
    //   240	244	358	java/lang/Exception
    //   280	284	362	java/lang/Exception
    //   288	292	366	java/lang/Exception
    //   320	324	370	java/lang/Exception
    //   329	334	374	java/lang/Exception
    //   338	342	378	java/lang/Exception
    //   130	142	382	finally
    //   142	152	391	finally
    //   152	190	397	finally
    //   190	218	397	finally
    //   261	276	401	finally
    //   130	142	412	java/lang/Exception
    //   142	152	421	java/lang/Exception
    //   152	190	435	java/lang/Exception
    //   190	218	435	java/lang/Exception
  }
  
  /* Error */
  private int c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	ahfp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: astore_2
    //   8: new 70	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   15: ldc 156
    //   17: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: getfield 17	ahfp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   24: invokevirtual 80	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   27: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore_3
    //   34: aload_2
    //   35: ldc 85
    //   37: iconst_0
    //   38: invokevirtual 91	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   41: aload_3
    //   42: iconst_0
    //   43: invokeinterface 299 3 0
    //   48: istore_1
    //   49: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +29 -> 81
    //   55: ldc 101
    //   57: iconst_2
    //   58: new 70	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 304
    //   68: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_1
    //   72: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 123	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: iload_1
    //   82: ireturn
    //   83: astore_2
    //   84: iconst_0
    //   85: istore_1
    //   86: ldc 101
    //   88: iconst_1
    //   89: ldc_w 309
    //   92: aload_2
    //   93: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   96: iload_1
    //   97: ireturn
    //   98: astore_2
    //   99: goto -13 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	ahfp
    //   48	49	1	i	int
    //   7	28	2	localBaseApplication	BaseApplication
    //   83	10	2	localException1	Exception
    //   98	1	2	localException2	Exception
    //   33	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   0	49	83	java/lang/Exception
    //   49	81	98	java/lang/Exception
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean.version;
    }
    return c();
  }
  
  public SpringFestivalRedpacketConfBean a()
  {
    return a(true);
  }
  
  public SpringFestivalRedpacketConfBean a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean == null) && (paramBoolean)) {}
    try
    {
      SpringFestivalRedpacketConfBean localSpringFestivalRedpacketConfBean = b();
      if (localSpringFestivalRedpacketConfBean != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean = localSpringFestivalRedpacketConfBean;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("springHb_SpringFestivalRedpacketConfProcessor", 1, "getLocalEntryConfig fail.", localException);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean;
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString, List<Integer> paramList, int paramInt3)
  {
    bool = true;
    localObject3 = null;
    Object localObject2 = null;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject1 = localObject3;
          QLog.i("springHb_SpringFestivalRedpacketConfProcessor", 1, String.format("onGetEntryConfig update=%s remoteVersion=%s taskId=%s delayList=%s reqOccasion=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramList, Integer.valueOf(paramInt3) }));
        }
        if (!paramBoolean) {
          continue;
        }
        localObject1 = localObject3;
        if (!TextUtils.isEmpty(paramString)) {
          continue;
        }
        localObject1 = localObject3;
        a();
        paramBoolean = bool;
        paramString = localObject2;
      }
      catch (Exception paramString)
      {
        QLog.e("springHb_SpringFestivalRedpacketConfProcessor", 1, "onGetEntryConfig fail.", paramString);
        paramBoolean = false;
        paramString = (String)localObject1;
        continue;
        localObject1 = paramString;
        QLog.e("springHb_SpringFestivalRedpacketConfProcessor", 1, "onGetEntryConfig parse config fail.");
        paramBoolean = false;
        continue;
        localObject1 = localObject3;
        paramString = b();
        paramBoolean = bool;
        continue;
      }
      a(paramString);
      if ((paramString != null) && (paramString.htmlOfflineCheckConfig != null)) {
        ahic.b(paramString.htmlOfflineCheckConfig.bids, paramInt2, paramInt1);
      }
      return paramBoolean;
      localObject1 = localObject3;
      paramString = a(paramInt1, paramInt2, paramString, paramList);
      if (paramString == null) {
        continue;
      }
      localObject1 = paramString;
      b(paramString);
      paramBoolean = bool;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean.taskId;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahfp
 * JD-Core Version:    0.7.0.1
 */