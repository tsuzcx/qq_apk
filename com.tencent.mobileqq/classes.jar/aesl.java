import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class aesl
  extends Thread
{
  public int a;
  public String a;
  public volatile boolean a;
  public int b;
  public String b;
  public volatile boolean b;
  private int c;
  public volatile boolean c;
  public volatile boolean d = true;
  
  public aesl(QQPlayerService paramQQPlayerService, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    setName("QQPlayerService-DownloadThread");
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  private File a(String paramString)
  {
    File localFile = new File(QQPlayerService.b());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString = new File(QQPlayerService.b() + "/" + paramString);
    if (!paramString.exists()) {}
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQPlayerService", 2, "createNewFile:" + localIOException.getMessage(), localIOException);
    }
    return paramString;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: invokestatic 103	com/tencent/mobileqq/utils/DeviceInfoUtil:b	()[J
    //   6: astore 4
    //   8: aload 4
    //   10: ifnull +39 -> 49
    //   13: aload 4
    //   15: iconst_1
    //   16: laload
    //   17: ldc2_w 104
    //   20: lcmp
    //   21: ifgt +28 -> 49
    //   24: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +11 -> 38
    //   30: ldc 79
    //   32: iconst_2
    //   33: ldc 107
    //   35: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_0
    //   39: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   42: invokevirtual 114	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   45: invokestatic 117	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   48: return
    //   49: aload_0
    //   50: aload_0
    //   51: getfield 31	aesl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokespecial 119	aesl:a	(Ljava/lang/String;)Ljava/io/File;
    //   57: astore 8
    //   59: aload_0
    //   60: iconst_1
    //   61: putfield 121	aesl:jdField_c_of_type_Boolean	Z
    //   64: new 123	java/io/RandomAccessFile
    //   67: dup
    //   68: aload 8
    //   70: ldc 125
    //   72: invokespecial 128	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   75: astore 5
    //   77: aload 5
    //   79: astore 4
    //   81: new 130	java/net/URL
    //   84: dup
    //   85: ldc 132
    //   87: aload_0
    //   88: getfield 29	aesl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   91: invokestatic 138	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   94: invokespecial 139	java/net/URL:<init>	(Ljava/lang/String;)V
    //   97: astore 9
    //   99: aload 5
    //   101: astore 4
    //   103: invokestatic 142	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   106: astore 7
    //   108: aload 7
    //   110: ifnonnull +74 -> 184
    //   113: aload 5
    //   115: astore 4
    //   117: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +15 -> 135
    //   123: aload 5
    //   125: astore 4
    //   127: ldc 79
    //   129: iconst_2
    //   130: ldc 144
    //   132: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_0
    //   136: iconst_0
    //   137: putfield 121	aesl:jdField_c_of_type_Boolean	Z
    //   140: aload 5
    //   142: ifnull +8 -> 150
    //   145: aload 5
    //   147: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   150: aload_0
    //   151: getfield 37	aesl:jdField_a_of_type_Int	I
    //   154: aload_0
    //   155: getfield 35	aesl:jdField_b_of_type_Int	I
    //   158: if_icmpge -110 -> 48
    //   161: aload_0
    //   162: getfield 35	aesl:jdField_b_of_type_Int	I
    //   165: ifle -117 -> 48
    //   168: aload_0
    //   169: getfield 31	aesl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   172: aload_0
    //   173: getfield 37	aesl:jdField_a_of_type_Int	I
    //   176: aload_0
    //   177: getfield 35	aesl:jdField_b_of_type_Int	I
    //   180: invokestatic 155	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   183: return
    //   184: aload 5
    //   186: astore 4
    //   188: aload 7
    //   190: getfield 158	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   193: aload_0
    //   194: getfield 29	aesl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   197: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   200: ifeq +2467 -> 2667
    //   203: aload 5
    //   205: astore 4
    //   207: aload_0
    //   208: getfield 21	aesl:d	Z
    //   211: ifeq +2456 -> 2667
    //   214: aload 5
    //   216: astore 4
    //   218: aload_0
    //   219: getfield 37	aesl:jdField_a_of_type_Int	I
    //   222: i2f
    //   223: aload_0
    //   224: getfield 35	aesl:jdField_b_of_type_Int	I
    //   227: i2f
    //   228: aload_0
    //   229: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   232: getfield 167	com/tencent/mobileqq/music/QQPlayerService:a	F
    //   235: fmul
    //   236: fcmpl
    //   237: ifle +336 -> 573
    //   240: aload 5
    //   242: astore 4
    //   244: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq +15 -> 262
    //   250: aload 5
    //   252: astore 4
    //   254: ldc 79
    //   256: iconst_2
    //   257: ldc 169
    //   259: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload 5
    //   264: astore 4
    //   266: invokestatic 172	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   269: invokevirtual 177	android/media/MediaPlayer:reset	()V
    //   272: aload 5
    //   274: astore 4
    //   276: invokestatic 172	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   279: aload 8
    //   281: invokevirtual 180	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   284: invokevirtual 183	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   287: aload 5
    //   289: astore 4
    //   291: invokestatic 172	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   294: invokevirtual 186	android/media/MediaPlayer:prepare	()V
    //   297: aload 5
    //   299: astore 4
    //   301: invokestatic 172	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   304: invokevirtual 189	android/media/MediaPlayer:start	()V
    //   307: aload 5
    //   309: astore 4
    //   311: aload_0
    //   312: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   315: iconst_2
    //   316: invokestatic 192	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   319: aload 5
    //   321: astore 4
    //   323: aload_0
    //   324: iconst_0
    //   325: putfield 21	aesl:d	Z
    //   328: goto +2339 -> 2667
    //   331: iload_1
    //   332: istore_2
    //   333: aload 4
    //   335: astore 6
    //   337: iload_1
    //   338: ifgt +147 -> 485
    //   341: iload_1
    //   342: istore_2
    //   343: aload 4
    //   345: astore 6
    //   347: iload_3
    //   348: iconst_5
    //   349: if_icmpgt +136 -> 485
    //   352: aload 5
    //   354: astore 4
    //   356: aload 9
    //   358: invokevirtual 196	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   361: checkcast 198	java/net/HttpURLConnection
    //   364: astore 6
    //   366: aload 5
    //   368: astore 4
    //   370: aload 6
    //   372: iconst_1
    //   373: invokevirtual 202	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   376: aload 5
    //   378: astore 4
    //   380: aload 6
    //   382: ldc 204
    //   384: ldc 206
    //   386: invokevirtual 210	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload 5
    //   391: astore 4
    //   393: aload_0
    //   394: getfield 33	aesl:jdField_c_of_type_Int	I
    //   397: ifeq +63 -> 460
    //   400: aload 5
    //   402: astore 4
    //   404: aload_0
    //   405: getfield 33	aesl:jdField_c_of_type_Int	I
    //   408: aload_0
    //   409: getfield 37	aesl:jdField_a_of_type_Int	I
    //   412: if_icmple +48 -> 460
    //   415: aload 5
    //   417: astore 4
    //   419: aload 6
    //   421: ldc 212
    //   423: new 59	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   430: ldc 214
    //   432: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_0
    //   436: getfield 37	aesl:jdField_a_of_type_Int	I
    //   439: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   442: ldc 219
    //   444: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload_0
    //   448: getfield 33	aesl:jdField_c_of_type_Int	I
    //   451: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   454: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokevirtual 210	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   460: aload 5
    //   462: astore 4
    //   464: aload 6
    //   466: invokevirtual 222	java/net/HttpURLConnection:connect	()V
    //   469: aload 5
    //   471: astore 4
    //   473: aload 6
    //   475: invokevirtual 226	java/net/HttpURLConnection:getContentLength	()I
    //   478: istore_1
    //   479: iload_1
    //   480: ifle +269 -> 749
    //   483: iload_1
    //   484: istore_2
    //   485: iload_2
    //   486: ifgt +334 -> 820
    //   489: aload 5
    //   491: astore 4
    //   493: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +15 -> 511
    //   499: aload 5
    //   501: astore 4
    //   503: ldc 79
    //   505: iconst_2
    //   506: ldc 228
    //   508: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   511: aload 5
    //   513: astore 4
    //   515: aload_0
    //   516: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   519: bipush 7
    //   521: invokestatic 192	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   524: aload_0
    //   525: iconst_0
    //   526: putfield 121	aesl:jdField_c_of_type_Boolean	Z
    //   529: aload 5
    //   531: ifnull +8 -> 539
    //   534: aload 5
    //   536: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   539: aload_0
    //   540: getfield 37	aesl:jdField_a_of_type_Int	I
    //   543: aload_0
    //   544: getfield 35	aesl:jdField_b_of_type_Int	I
    //   547: if_icmpge -499 -> 48
    //   550: aload_0
    //   551: getfield 35	aesl:jdField_b_of_type_Int	I
    //   554: ifle -506 -> 48
    //   557: aload_0
    //   558: getfield 31	aesl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   561: aload_0
    //   562: getfield 37	aesl:jdField_a_of_type_Int	I
    //   565: aload_0
    //   566: getfield 35	aesl:jdField_b_of_type_Int	I
    //   569: invokestatic 155	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   572: return
    //   573: aload 5
    //   575: astore 4
    //   577: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   580: ifeq +15 -> 595
    //   583: aload 5
    //   585: astore 4
    //   587: ldc 79
    //   589: iconst_2
    //   590: ldc 233
    //   592: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: aload 5
    //   597: astore 4
    //   599: aload_0
    //   600: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   603: iconst_1
    //   604: invokestatic 192	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   607: goto +2060 -> 2667
    //   610: astore 6
    //   612: aload 5
    //   614: astore 4
    //   616: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   619: ifeq +38 -> 657
    //   622: aload 5
    //   624: astore 4
    //   626: ldc 79
    //   628: iconst_2
    //   629: new 59	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   636: ldc 235
    //   638: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload 6
    //   643: invokevirtual 236	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   646: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: aload 6
    //   654: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   657: aload 5
    //   659: astore 4
    //   661: aload_0
    //   662: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   665: invokevirtual 114	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   668: invokestatic 117	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   671: aload_0
    //   672: iconst_0
    //   673: putfield 121	aesl:jdField_c_of_type_Boolean	Z
    //   676: aload 5
    //   678: ifnull +8 -> 686
    //   681: aload 5
    //   683: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   686: aload_0
    //   687: getfield 37	aesl:jdField_a_of_type_Int	I
    //   690: aload_0
    //   691: getfield 35	aesl:jdField_b_of_type_Int	I
    //   694: if_icmpge +25 -> 719
    //   697: aload_0
    //   698: getfield 35	aesl:jdField_b_of_type_Int	I
    //   701: ifle +18 -> 719
    //   704: aload_0
    //   705: getfield 31	aesl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   708: aload_0
    //   709: getfield 37	aesl:jdField_a_of_type_Int	I
    //   712: aload_0
    //   713: getfield 35	aesl:jdField_b_of_type_Int	I
    //   716: invokestatic 155	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   719: aload_0
    //   720: getfield 238	aesl:jdField_b_of_type_Boolean	Z
    //   723: ifeq +6 -> 729
    //   726: invokestatic 240	com/tencent/mobileqq/utils/MusicCacheManager:a	()V
    //   729: aload_0
    //   730: iconst_0
    //   731: putfield 238	aesl:jdField_b_of_type_Boolean	Z
    //   734: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   737: ifeq -689 -> 48
    //   740: ldc 79
    //   742: iconst_2
    //   743: ldc 242
    //   745: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   748: return
    //   749: iload_3
    //   750: iconst_1
    //   751: iadd
    //   752: istore_3
    //   753: aload 5
    //   755: astore 4
    //   757: ldc2_w 243
    //   760: invokestatic 248	java/lang/Thread:sleep	(J)V
    //   763: aload 6
    //   765: astore 4
    //   767: goto -436 -> 331
    //   770: astore 7
    //   772: aload 5
    //   774: astore 4
    //   776: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   779: ifeq +1899 -> 2678
    //   782: aload 5
    //   784: astore 4
    //   786: ldc 79
    //   788: iconst_2
    //   789: new 59	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   796: ldc 250
    //   798: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aload 7
    //   803: invokevirtual 251	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   806: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: aload 7
    //   814: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   817: goto +1861 -> 2678
    //   820: iload_2
    //   821: istore_1
    //   822: aload 5
    //   824: astore 4
    //   826: aload_0
    //   827: getfield 37	aesl:jdField_a_of_type_Int	I
    //   830: ifle +14 -> 844
    //   833: aload 5
    //   835: astore 4
    //   837: iload_2
    //   838: aload_0
    //   839: getfield 37	aesl:jdField_a_of_type_Int	I
    //   842: iadd
    //   843: istore_1
    //   844: aload 5
    //   846: astore 4
    //   848: aload_0
    //   849: iload_1
    //   850: putfield 35	aesl:jdField_b_of_type_Int	I
    //   853: iload_1
    //   854: istore_2
    //   855: aload 6
    //   857: astore 7
    //   859: aload 5
    //   861: astore 4
    //   863: aload_0
    //   864: getfield 33	aesl:jdField_c_of_type_Int	I
    //   867: ifeq +244 -> 1111
    //   870: iload_1
    //   871: istore_2
    //   872: aload 6
    //   874: astore 7
    //   876: aload 5
    //   878: astore 4
    //   880: aload_0
    //   881: getfield 33	aesl:jdField_c_of_type_Int	I
    //   884: iload_1
    //   885: if_icmpeq +226 -> 1111
    //   888: aload 5
    //   890: astore 4
    //   892: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   895: ifeq +44 -> 939
    //   898: aload 5
    //   900: astore 4
    //   902: ldc 79
    //   904: iconst_2
    //   905: new 59	java/lang/StringBuilder
    //   908: dup
    //   909: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   912: ldc 253
    //   914: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: aload_0
    //   918: getfield 33	aesl:jdField_c_of_type_Int	I
    //   921: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   924: ldc 255
    //   926: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: iload_1
    //   930: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   933: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   936: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   939: aload 5
    //   941: astore 4
    //   943: aload_0
    //   944: iconst_0
    //   945: putfield 37	aesl:jdField_a_of_type_Int	I
    //   948: aload 5
    //   950: astore 4
    //   952: aload_0
    //   953: iconst_1
    //   954: putfield 21	aesl:d	Z
    //   957: aload 5
    //   959: astore 4
    //   961: aload 9
    //   963: invokevirtual 196	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   966: checkcast 198	java/net/HttpURLConnection
    //   969: astore 7
    //   971: aload 5
    //   973: astore 4
    //   975: aload 7
    //   977: iconst_1
    //   978: invokevirtual 202	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   981: aload 5
    //   983: astore 4
    //   985: aload 7
    //   987: ldc 204
    //   989: ldc 206
    //   991: invokevirtual 210	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   994: aload 5
    //   996: astore 4
    //   998: aload 7
    //   1000: invokevirtual 222	java/net/HttpURLConnection:connect	()V
    //   1003: aload 5
    //   1005: astore 4
    //   1007: aload 7
    //   1009: invokevirtual 226	java/net/HttpURLConnection:getContentLength	()I
    //   1012: istore_2
    //   1013: iload_2
    //   1014: ifge +88 -> 1102
    //   1017: aload 5
    //   1019: astore 4
    //   1021: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1024: ifeq +16 -> 1040
    //   1027: aload 5
    //   1029: astore 4
    //   1031: ldc 79
    //   1033: iconst_2
    //   1034: ldc_w 257
    //   1037: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1040: aload 5
    //   1042: astore 4
    //   1044: aload_0
    //   1045: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1048: bipush 7
    //   1050: invokestatic 192	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1053: aload_0
    //   1054: iconst_0
    //   1055: putfield 121	aesl:jdField_c_of_type_Boolean	Z
    //   1058: aload 5
    //   1060: ifnull +8 -> 1068
    //   1063: aload 5
    //   1065: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   1068: aload_0
    //   1069: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1072: aload_0
    //   1073: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1076: if_icmpge -1028 -> 48
    //   1079: aload_0
    //   1080: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1083: ifle -1035 -> 48
    //   1086: aload_0
    //   1087: getfield 31	aesl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1090: aload_0
    //   1091: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1094: aload_0
    //   1095: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1098: invokestatic 155	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1101: return
    //   1102: aload 5
    //   1104: astore 4
    //   1106: aload_0
    //   1107: iload_2
    //   1108: putfield 35	aesl:jdField_b_of_type_Int	I
    //   1111: aload 5
    //   1113: astore 4
    //   1115: aload 5
    //   1117: iload_2
    //   1118: i2l
    //   1119: invokevirtual 260	java/io/RandomAccessFile:setLength	(J)V
    //   1122: aload 5
    //   1124: astore 4
    //   1126: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1129: ifeq +62 -> 1191
    //   1132: aload 5
    //   1134: astore 4
    //   1136: ldc 79
    //   1138: iconst_2
    //   1139: new 59	java/lang/StringBuilder
    //   1142: dup
    //   1143: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1146: ldc_w 262
    //   1149: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: aload_0
    //   1153: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1156: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1159: ldc_w 264
    //   1162: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: aload_0
    //   1166: getfield 33	aesl:jdField_c_of_type_Int	I
    //   1169: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1172: ldc_w 266
    //   1175: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: aload_0
    //   1179: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1182: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1185: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1188: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1191: aload 5
    //   1193: astore 4
    //   1195: aload 7
    //   1197: invokevirtual 270	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1200: astore 6
    //   1202: aload 5
    //   1204: astore 4
    //   1206: sipush 8192
    //   1209: newarray byte
    //   1211: astore 7
    //   1213: aload 5
    //   1215: astore 4
    //   1217: aload 5
    //   1219: aload_0
    //   1220: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1223: i2l
    //   1224: invokevirtual 273	java/io/RandomAccessFile:seek	(J)V
    //   1227: aload 5
    //   1229: astore 4
    //   1231: aload_0
    //   1232: getfield 33	aesl:jdField_c_of_type_Int	I
    //   1235: ifne +22 -> 1257
    //   1238: aload 5
    //   1240: astore 4
    //   1242: aload_0
    //   1243: getfield 31	aesl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1246: aload_0
    //   1247: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1250: aload_0
    //   1251: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1254: invokestatic 155	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1257: aload 5
    //   1259: astore 4
    //   1261: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1264: ifeq +1421 -> 2685
    //   1267: aload 5
    //   1269: astore 4
    //   1271: ldc 79
    //   1273: iconst_2
    //   1274: new 59	java/lang/StringBuilder
    //   1277: dup
    //   1278: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1281: ldc_w 275
    //   1284: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: aload_0
    //   1288: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1291: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1294: ldc_w 266
    //   1297: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: aload_0
    //   1301: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1304: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1307: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1310: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1313: goto +1372 -> 2685
    //   1316: aload 5
    //   1318: astore 4
    //   1320: aload_0
    //   1321: getfield 277	aesl:jdField_a_of_type_Boolean	Z
    //   1324: ifne +556 -> 1880
    //   1327: aload 5
    //   1329: astore 4
    //   1331: aload_0
    //   1332: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1335: aload_0
    //   1336: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1339: if_icmpge +541 -> 1880
    //   1342: iload_1
    //   1343: bipush 10
    //   1345: if_icmpge +535 -> 1880
    //   1348: aload 5
    //   1350: astore 4
    //   1352: invokestatic 142	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1355: astore 9
    //   1357: aload 9
    //   1359: ifnonnull +74 -> 1433
    //   1362: aload 5
    //   1364: astore 4
    //   1366: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1369: ifeq +15 -> 1384
    //   1372: aload 5
    //   1374: astore 4
    //   1376: ldc 79
    //   1378: iconst_2
    //   1379: ldc 144
    //   1381: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1384: aload_0
    //   1385: iconst_0
    //   1386: putfield 121	aesl:jdField_c_of_type_Boolean	Z
    //   1389: aload 5
    //   1391: ifnull +8 -> 1399
    //   1394: aload 5
    //   1396: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   1399: aload_0
    //   1400: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1403: aload_0
    //   1404: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1407: if_icmpge -1359 -> 48
    //   1410: aload_0
    //   1411: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1414: ifle -1366 -> 48
    //   1417: aload_0
    //   1418: getfield 31	aesl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1421: aload_0
    //   1422: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1425: aload_0
    //   1426: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1429: invokestatic 155	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1432: return
    //   1433: aload 5
    //   1435: astore 4
    //   1437: aload_0
    //   1438: getfield 21	aesl:d	Z
    //   1441: ifeq +187 -> 1628
    //   1444: aload 5
    //   1446: astore 4
    //   1448: aload 9
    //   1450: getfield 158	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1453: aload_0
    //   1454: getfield 29	aesl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1457: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1460: ifeq +168 -> 1628
    //   1463: aload 5
    //   1465: astore 4
    //   1467: aload_0
    //   1468: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1471: i2f
    //   1472: aload_0
    //   1473: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1476: i2f
    //   1477: aload_0
    //   1478: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1481: getfield 167	com/tencent/mobileqq/music/QQPlayerService:a	F
    //   1484: fmul
    //   1485: fcmpl
    //   1486: ifle +142 -> 1628
    //   1489: aload 5
    //   1491: astore 4
    //   1493: invokestatic 172	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1496: invokevirtual 177	android/media/MediaPlayer:reset	()V
    //   1499: aload 5
    //   1501: astore 4
    //   1503: invokestatic 172	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1506: aload 8
    //   1508: invokevirtual 180	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1511: invokevirtual 183	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   1514: aload 5
    //   1516: astore 4
    //   1518: invokestatic 172	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1521: invokevirtual 186	android/media/MediaPlayer:prepare	()V
    //   1524: aload 5
    //   1526: astore 4
    //   1528: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1531: ifeq +52 -> 1583
    //   1534: aload 5
    //   1536: astore 4
    //   1538: ldc 79
    //   1540: iconst_2
    //   1541: new 59	java/lang/StringBuilder
    //   1544: dup
    //   1545: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1548: ldc_w 279
    //   1551: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: aload_0
    //   1555: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1558: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1561: ldc_w 281
    //   1564: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: aload_0
    //   1568: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1571: invokestatic 284	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   1574: invokevirtual 287	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1577: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1580: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1583: aload 5
    //   1585: astore 4
    //   1587: aload_0
    //   1588: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1591: invokestatic 284	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   1594: ifne +25 -> 1619
    //   1597: aload 5
    //   1599: astore 4
    //   1601: invokestatic 172	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1604: invokevirtual 189	android/media/MediaPlayer:start	()V
    //   1607: aload 5
    //   1609: astore 4
    //   1611: aload_0
    //   1612: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1615: iconst_2
    //   1616: invokestatic 192	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1619: aload 5
    //   1621: astore 4
    //   1623: aload_0
    //   1624: iconst_0
    //   1625: putfield 21	aesl:d	Z
    //   1628: aload 5
    //   1630: astore 4
    //   1632: aload 6
    //   1634: aload 7
    //   1636: invokevirtual 293	java/io/InputStream:read	([B)I
    //   1639: istore_2
    //   1640: iload_2
    //   1641: ifgt +207 -> 1848
    //   1644: aload 5
    //   1646: astore 4
    //   1648: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1651: ifeq +16 -> 1667
    //   1654: aload 5
    //   1656: astore 4
    //   1658: ldc 79
    //   1660: iconst_2
    //   1661: ldc_w 295
    //   1664: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1667: aload 5
    //   1669: astore 4
    //   1671: ldc2_w 243
    //   1674: invokestatic 248	java/lang/Thread:sleep	(J)V
    //   1677: iload_1
    //   1678: iconst_1
    //   1679: iadd
    //   1680: istore_1
    //   1681: goto -365 -> 1316
    //   1684: astore 9
    //   1686: aload 5
    //   1688: astore 4
    //   1690: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1693: ifeq -16 -> 1677
    //   1696: aload 5
    //   1698: astore 4
    //   1700: ldc 79
    //   1702: iconst_2
    //   1703: new 59	java/lang/StringBuilder
    //   1706: dup
    //   1707: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1710: ldc_w 297
    //   1713: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1716: aload 9
    //   1718: invokevirtual 251	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   1721: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1724: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1727: aload 9
    //   1729: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1732: goto -55 -> 1677
    //   1735: astore 6
    //   1737: aload 5
    //   1739: astore 4
    //   1741: aload_0
    //   1742: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1745: invokevirtual 114	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   1748: invokestatic 117	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   1751: aload 5
    //   1753: astore 4
    //   1755: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1758: ifeq +39 -> 1797
    //   1761: aload 5
    //   1763: astore 4
    //   1765: ldc 79
    //   1767: iconst_2
    //   1768: new 59	java/lang/StringBuilder
    //   1771: dup
    //   1772: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1775: ldc_w 299
    //   1778: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: aload 6
    //   1783: invokevirtual 300	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   1786: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1789: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1792: aload 6
    //   1794: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1797: aload_0
    //   1798: iconst_0
    //   1799: putfield 121	aesl:jdField_c_of_type_Boolean	Z
    //   1802: aload 5
    //   1804: ifnull +8 -> 1812
    //   1807: aload 5
    //   1809: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   1812: aload_0
    //   1813: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1816: aload_0
    //   1817: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1820: if_icmpge -1101 -> 719
    //   1823: aload_0
    //   1824: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1827: ifle -1108 -> 719
    //   1830: aload_0
    //   1831: getfield 31	aesl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1834: aload_0
    //   1835: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1838: aload_0
    //   1839: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1842: invokestatic 155	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1845: goto -1126 -> 719
    //   1848: aload 5
    //   1850: astore 4
    //   1852: aload_0
    //   1853: aload_0
    //   1854: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1857: iload_2
    //   1858: iadd
    //   1859: putfield 37	aesl:jdField_a_of_type_Int	I
    //   1862: aload 5
    //   1864: astore 4
    //   1866: aload 5
    //   1868: aload 7
    //   1870: iconst_0
    //   1871: iload_2
    //   1872: invokevirtual 304	java/io/RandomAccessFile:write	([BII)V
    //   1875: iconst_0
    //   1876: istore_1
    //   1877: goto -561 -> 1316
    //   1880: aload 5
    //   1882: astore 4
    //   1884: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1887: ifeq +72 -> 1959
    //   1890: aload 5
    //   1892: astore 4
    //   1894: ldc 79
    //   1896: iconst_2
    //   1897: new 59	java/lang/StringBuilder
    //   1900: dup
    //   1901: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1904: ldc_w 306
    //   1907: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1910: aload_0
    //   1911: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1914: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1917: ldc_w 308
    //   1920: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: iload_1
    //   1924: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1927: ldc_w 266
    //   1930: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1933: aload_0
    //   1934: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1937: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1940: ldc_w 264
    //   1943: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1946: aload_0
    //   1947: getfield 33	aesl:jdField_c_of_type_Int	I
    //   1950: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1953: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1956: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1959: aload 6
    //   1961: ifnull +12 -> 1973
    //   1964: aload 5
    //   1966: astore 4
    //   1968: aload 6
    //   1970: invokevirtual 309	java/io/InputStream:close	()V
    //   1973: aload 5
    //   1975: astore 4
    //   1977: aload_0
    //   1978: getfield 37	aesl:jdField_a_of_type_Int	I
    //   1981: aload_0
    //   1982: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1985: if_icmpne +25 -> 2010
    //   1988: aload 5
    //   1990: astore 4
    //   1992: aload_0
    //   1993: getfield 35	aesl:jdField_b_of_type_Int	I
    //   1996: ifle +14 -> 2010
    //   1999: aload 5
    //   2001: astore 4
    //   2003: aload_0
    //   2004: getfield 31	aesl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2007: invokestatic 311	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;)V
    //   2010: aload_0
    //   2011: iconst_0
    //   2012: putfield 121	aesl:jdField_c_of_type_Boolean	Z
    //   2015: aload 5
    //   2017: ifnull +8 -> 2025
    //   2020: aload 5
    //   2022: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   2025: aload_0
    //   2026: getfield 37	aesl:jdField_a_of_type_Int	I
    //   2029: aload_0
    //   2030: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2033: if_icmpge -1314 -> 719
    //   2036: aload_0
    //   2037: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2040: ifle -1321 -> 719
    //   2043: aload_0
    //   2044: getfield 31	aesl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2047: aload_0
    //   2048: getfield 37	aesl:jdField_a_of_type_Int	I
    //   2051: aload_0
    //   2052: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2055: invokestatic 155	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2058: goto -1339 -> 719
    //   2061: astore 6
    //   2063: aconst_null
    //   2064: astore 5
    //   2066: aload 5
    //   2068: astore 4
    //   2070: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2073: ifeq +39 -> 2112
    //   2076: aload 5
    //   2078: astore 4
    //   2080: ldc 79
    //   2082: iconst_2
    //   2083: new 59	java/lang/StringBuilder
    //   2086: dup
    //   2087: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   2090: ldc_w 313
    //   2093: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2096: aload 6
    //   2098: invokevirtual 84	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2101: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2104: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2107: aload 6
    //   2109: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2112: aload 5
    //   2114: astore 4
    //   2116: invokestatic 142	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   2119: astore 6
    //   2121: aload 6
    //   2123: ifnull +55 -> 2178
    //   2126: aload 5
    //   2128: astore 4
    //   2130: invokestatic 172	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2133: ifnull +45 -> 2178
    //   2136: aload 5
    //   2138: astore 4
    //   2140: aload_0
    //   2141: getfield 29	aesl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2144: aload 6
    //   2146: getfield 158	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2149: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2152: ifeq +26 -> 2178
    //   2155: aload 5
    //   2157: astore 4
    //   2159: invokestatic 172	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   2162: invokevirtual 177	android/media/MediaPlayer:reset	()V
    //   2165: aload 5
    //   2167: astore 4
    //   2169: aload_0
    //   2170: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2173: bipush 6
    //   2175: invokestatic 192	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   2178: aload 5
    //   2180: astore 4
    //   2182: invokestatic 316	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   2185: ifnull +52 -> 2237
    //   2188: aload 5
    //   2190: astore 4
    //   2192: invokestatic 316	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   2195: arraylength
    //   2196: iconst_1
    //   2197: if_icmpne +40 -> 2237
    //   2200: aload 5
    //   2202: astore 4
    //   2204: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2207: ifeq +16 -> 2223
    //   2210: aload 5
    //   2212: astore 4
    //   2214: ldc 79
    //   2216: iconst_2
    //   2217: ldc_w 318
    //   2220: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2223: aload 5
    //   2225: astore 4
    //   2227: aload_0
    //   2228: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2231: invokevirtual 114	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2234: invokestatic 117	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2237: aload_0
    //   2238: iconst_0
    //   2239: putfield 121	aesl:jdField_c_of_type_Boolean	Z
    //   2242: aload 5
    //   2244: ifnull +8 -> 2252
    //   2247: aload 5
    //   2249: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   2252: aload_0
    //   2253: getfield 37	aesl:jdField_a_of_type_Int	I
    //   2256: aload_0
    //   2257: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2260: if_icmpge -1541 -> 719
    //   2263: aload_0
    //   2264: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2267: ifle -1548 -> 719
    //   2270: aload_0
    //   2271: getfield 31	aesl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2274: aload_0
    //   2275: getfield 37	aesl:jdField_a_of_type_Int	I
    //   2278: aload_0
    //   2279: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2282: invokestatic 155	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2285: goto -1566 -> 719
    //   2288: astore 6
    //   2290: aconst_null
    //   2291: astore 5
    //   2293: aload 5
    //   2295: astore 4
    //   2297: aload_0
    //   2298: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2301: invokevirtual 114	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2304: invokestatic 117	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2307: aload 5
    //   2309: astore 4
    //   2311: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2314: ifeq +39 -> 2353
    //   2317: aload 5
    //   2319: astore 4
    //   2321: ldc 79
    //   2323: iconst_2
    //   2324: new 59	java/lang/StringBuilder
    //   2327: dup
    //   2328: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   2331: ldc_w 320
    //   2334: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2337: aload 6
    //   2339: invokevirtual 321	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   2342: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2345: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2348: aload 6
    //   2350: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2353: aload_0
    //   2354: iconst_0
    //   2355: putfield 121	aesl:jdField_c_of_type_Boolean	Z
    //   2358: aload 5
    //   2360: ifnull +8 -> 2368
    //   2363: aload 5
    //   2365: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   2368: aload_0
    //   2369: getfield 37	aesl:jdField_a_of_type_Int	I
    //   2372: aload_0
    //   2373: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2376: if_icmpge -1657 -> 719
    //   2379: aload_0
    //   2380: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2383: ifle -1664 -> 719
    //   2386: aload_0
    //   2387: getfield 31	aesl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2390: aload_0
    //   2391: getfield 37	aesl:jdField_a_of_type_Int	I
    //   2394: aload_0
    //   2395: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2398: invokestatic 155	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2401: goto -1682 -> 719
    //   2404: astore 6
    //   2406: aconst_null
    //   2407: astore 5
    //   2409: aload 5
    //   2411: astore 4
    //   2413: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2416: ifeq +39 -> 2455
    //   2419: aload 5
    //   2421: astore 4
    //   2423: ldc 79
    //   2425: iconst_2
    //   2426: new 59	java/lang/StringBuilder
    //   2429: dup
    //   2430: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   2433: ldc_w 323
    //   2436: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2439: aload 6
    //   2441: invokevirtual 324	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2444: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2447: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2450: aload 6
    //   2452: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2455: aload 5
    //   2457: astore 4
    //   2459: aload_0
    //   2460: getfield 16	aesl:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2463: invokevirtual 114	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2466: invokestatic 117	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2469: aload_0
    //   2470: iconst_0
    //   2471: putfield 121	aesl:jdField_c_of_type_Boolean	Z
    //   2474: aload 5
    //   2476: ifnull +8 -> 2484
    //   2479: aload 5
    //   2481: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   2484: aload_0
    //   2485: getfield 37	aesl:jdField_a_of_type_Int	I
    //   2488: aload_0
    //   2489: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2492: if_icmpge -1773 -> 719
    //   2495: aload_0
    //   2496: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2499: ifle -1780 -> 719
    //   2502: aload_0
    //   2503: getfield 31	aesl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2506: aload_0
    //   2507: getfield 37	aesl:jdField_a_of_type_Int	I
    //   2510: aload_0
    //   2511: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2514: invokestatic 155	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2517: goto -1798 -> 719
    //   2520: astore 5
    //   2522: aconst_null
    //   2523: astore 4
    //   2525: aload_0
    //   2526: iconst_0
    //   2527: putfield 121	aesl:jdField_c_of_type_Boolean	Z
    //   2530: aload 4
    //   2532: ifnull +8 -> 2540
    //   2535: aload 4
    //   2537: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   2540: aload_0
    //   2541: getfield 37	aesl:jdField_a_of_type_Int	I
    //   2544: aload_0
    //   2545: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2548: if_icmpge +25 -> 2573
    //   2551: aload_0
    //   2552: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2555: ifle +18 -> 2573
    //   2558: aload_0
    //   2559: getfield 31	aesl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2562: aload_0
    //   2563: getfield 37	aesl:jdField_a_of_type_Int	I
    //   2566: aload_0
    //   2567: getfield 35	aesl:jdField_b_of_type_Int	I
    //   2570: invokestatic 155	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2573: aload 5
    //   2575: athrow
    //   2576: astore 4
    //   2578: goto -2428 -> 150
    //   2581: astore 4
    //   2583: goto -2044 -> 539
    //   2586: astore 4
    //   2588: goto -1520 -> 1068
    //   2591: astore 4
    //   2593: goto -1194 -> 1399
    //   2596: astore 4
    //   2598: goto -573 -> 2025
    //   2601: astore 4
    //   2603: goto -1917 -> 686
    //   2606: astore 4
    //   2608: goto -796 -> 1812
    //   2611: astore 4
    //   2613: goto -361 -> 2252
    //   2616: astore 4
    //   2618: goto -250 -> 2368
    //   2621: astore 4
    //   2623: goto -139 -> 2484
    //   2626: astore 4
    //   2628: goto -88 -> 2540
    //   2631: astore 5
    //   2633: goto -108 -> 2525
    //   2636: astore 6
    //   2638: goto -229 -> 2409
    //   2641: astore 6
    //   2643: goto -350 -> 2293
    //   2646: astore 6
    //   2648: goto -582 -> 2066
    //   2651: astore 6
    //   2653: aconst_null
    //   2654: astore 5
    //   2656: goto -919 -> 1737
    //   2659: astore 6
    //   2661: aconst_null
    //   2662: astore 5
    //   2664: goto -2052 -> 612
    //   2667: iconst_0
    //   2668: istore_3
    //   2669: iconst_0
    //   2670: istore_1
    //   2671: aload 6
    //   2673: astore 4
    //   2675: goto -2344 -> 331
    //   2678: aload 6
    //   2680: astore 4
    //   2682: goto -2351 -> 331
    //   2685: iconst_0
    //   2686: istore_1
    //   2687: goto -1371 -> 1316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2690	0	this	aesl
    //   331	2356	1	i	int
    //   332	1540	2	j	int
    //   347	2322	3	k	int
    //   6	2530	4	localObject1	java.lang.Object
    //   2576	1	4	localIOException1	IOException
    //   2581	1	4	localIOException2	IOException
    //   2586	1	4	localIOException3	IOException
    //   2591	1	4	localIOException4	IOException
    //   2596	1	4	localIOException5	IOException
    //   2601	1	4	localIOException6	IOException
    //   2606	1	4	localIOException7	IOException
    //   2611	1	4	localIOException8	IOException
    //   2616	1	4	localIOException9	IOException
    //   2621	1	4	localIOException10	IOException
    //   2626	1	4	localIOException11	IOException
    //   2673	8	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   75	2405	5	localRandomAccessFile	java.io.RandomAccessFile
    //   2520	54	5	localObject2	java.lang.Object
    //   2631	1	5	localObject3	java.lang.Object
    //   2654	9	5	localObject4	java.lang.Object
    //   1	473	6	localObject5	java.lang.Object
    //   610	263	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   1200	433	6	localInputStream	java.io.InputStream
    //   1735	234	6	localMalformedURLException1	java.net.MalformedURLException
    //   2061	47	6	localIOException12	IOException
    //   2119	26	6	localSongInfo1	com.tencent.mobileqq.music.SongInfo
    //   2288	61	6	localIllegalStateException1	java.lang.IllegalStateException
    //   2404	47	6	localException1	java.lang.Exception
    //   2636	1	6	localException2	java.lang.Exception
    //   2641	1	6	localIllegalStateException2	java.lang.IllegalStateException
    //   2646	1	6	localIOException13	IOException
    //   2651	1	6	localMalformedURLException2	java.net.MalformedURLException
    //   2659	20	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   106	83	7	localSongInfo2	com.tencent.mobileqq.music.SongInfo
    //   770	43	7	localInterruptedException1	java.lang.InterruptedException
    //   857	1012	7	localObject6	java.lang.Object
    //   57	1450	8	localFile	File
    //   97	1352	9	localObject7	java.lang.Object
    //   1684	44	9	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   81	99	610	java/io/FileNotFoundException
    //   103	108	610	java/io/FileNotFoundException
    //   117	123	610	java/io/FileNotFoundException
    //   127	135	610	java/io/FileNotFoundException
    //   188	203	610	java/io/FileNotFoundException
    //   207	214	610	java/io/FileNotFoundException
    //   218	240	610	java/io/FileNotFoundException
    //   244	250	610	java/io/FileNotFoundException
    //   254	262	610	java/io/FileNotFoundException
    //   266	272	610	java/io/FileNotFoundException
    //   276	287	610	java/io/FileNotFoundException
    //   291	297	610	java/io/FileNotFoundException
    //   301	307	610	java/io/FileNotFoundException
    //   311	319	610	java/io/FileNotFoundException
    //   323	328	610	java/io/FileNotFoundException
    //   356	366	610	java/io/FileNotFoundException
    //   370	376	610	java/io/FileNotFoundException
    //   380	389	610	java/io/FileNotFoundException
    //   393	400	610	java/io/FileNotFoundException
    //   404	415	610	java/io/FileNotFoundException
    //   419	460	610	java/io/FileNotFoundException
    //   464	469	610	java/io/FileNotFoundException
    //   473	479	610	java/io/FileNotFoundException
    //   493	499	610	java/io/FileNotFoundException
    //   503	511	610	java/io/FileNotFoundException
    //   515	524	610	java/io/FileNotFoundException
    //   577	583	610	java/io/FileNotFoundException
    //   587	595	610	java/io/FileNotFoundException
    //   599	607	610	java/io/FileNotFoundException
    //   757	763	610	java/io/FileNotFoundException
    //   776	782	610	java/io/FileNotFoundException
    //   786	817	610	java/io/FileNotFoundException
    //   826	833	610	java/io/FileNotFoundException
    //   837	844	610	java/io/FileNotFoundException
    //   848	853	610	java/io/FileNotFoundException
    //   863	870	610	java/io/FileNotFoundException
    //   880	888	610	java/io/FileNotFoundException
    //   892	898	610	java/io/FileNotFoundException
    //   902	939	610	java/io/FileNotFoundException
    //   943	948	610	java/io/FileNotFoundException
    //   952	957	610	java/io/FileNotFoundException
    //   961	971	610	java/io/FileNotFoundException
    //   975	981	610	java/io/FileNotFoundException
    //   985	994	610	java/io/FileNotFoundException
    //   998	1003	610	java/io/FileNotFoundException
    //   1007	1013	610	java/io/FileNotFoundException
    //   1021	1027	610	java/io/FileNotFoundException
    //   1031	1040	610	java/io/FileNotFoundException
    //   1044	1053	610	java/io/FileNotFoundException
    //   1106	1111	610	java/io/FileNotFoundException
    //   1115	1122	610	java/io/FileNotFoundException
    //   1126	1132	610	java/io/FileNotFoundException
    //   1136	1191	610	java/io/FileNotFoundException
    //   1195	1202	610	java/io/FileNotFoundException
    //   1206	1213	610	java/io/FileNotFoundException
    //   1217	1227	610	java/io/FileNotFoundException
    //   1231	1238	610	java/io/FileNotFoundException
    //   1242	1257	610	java/io/FileNotFoundException
    //   1261	1267	610	java/io/FileNotFoundException
    //   1271	1313	610	java/io/FileNotFoundException
    //   1320	1327	610	java/io/FileNotFoundException
    //   1331	1342	610	java/io/FileNotFoundException
    //   1352	1357	610	java/io/FileNotFoundException
    //   1366	1372	610	java/io/FileNotFoundException
    //   1376	1384	610	java/io/FileNotFoundException
    //   1437	1444	610	java/io/FileNotFoundException
    //   1448	1463	610	java/io/FileNotFoundException
    //   1467	1489	610	java/io/FileNotFoundException
    //   1493	1499	610	java/io/FileNotFoundException
    //   1503	1514	610	java/io/FileNotFoundException
    //   1518	1524	610	java/io/FileNotFoundException
    //   1528	1534	610	java/io/FileNotFoundException
    //   1538	1583	610	java/io/FileNotFoundException
    //   1587	1597	610	java/io/FileNotFoundException
    //   1601	1607	610	java/io/FileNotFoundException
    //   1611	1619	610	java/io/FileNotFoundException
    //   1623	1628	610	java/io/FileNotFoundException
    //   1632	1640	610	java/io/FileNotFoundException
    //   1648	1654	610	java/io/FileNotFoundException
    //   1658	1667	610	java/io/FileNotFoundException
    //   1671	1677	610	java/io/FileNotFoundException
    //   1690	1696	610	java/io/FileNotFoundException
    //   1700	1732	610	java/io/FileNotFoundException
    //   1852	1862	610	java/io/FileNotFoundException
    //   1866	1875	610	java/io/FileNotFoundException
    //   1884	1890	610	java/io/FileNotFoundException
    //   1894	1959	610	java/io/FileNotFoundException
    //   1968	1973	610	java/io/FileNotFoundException
    //   1977	1988	610	java/io/FileNotFoundException
    //   1992	1999	610	java/io/FileNotFoundException
    //   2003	2010	610	java/io/FileNotFoundException
    //   757	763	770	java/lang/InterruptedException
    //   1671	1677	1684	java/lang/InterruptedException
    //   81	99	1735	java/net/MalformedURLException
    //   103	108	1735	java/net/MalformedURLException
    //   117	123	1735	java/net/MalformedURLException
    //   127	135	1735	java/net/MalformedURLException
    //   188	203	1735	java/net/MalformedURLException
    //   207	214	1735	java/net/MalformedURLException
    //   218	240	1735	java/net/MalformedURLException
    //   244	250	1735	java/net/MalformedURLException
    //   254	262	1735	java/net/MalformedURLException
    //   266	272	1735	java/net/MalformedURLException
    //   276	287	1735	java/net/MalformedURLException
    //   291	297	1735	java/net/MalformedURLException
    //   301	307	1735	java/net/MalformedURLException
    //   311	319	1735	java/net/MalformedURLException
    //   323	328	1735	java/net/MalformedURLException
    //   356	366	1735	java/net/MalformedURLException
    //   370	376	1735	java/net/MalformedURLException
    //   380	389	1735	java/net/MalformedURLException
    //   393	400	1735	java/net/MalformedURLException
    //   404	415	1735	java/net/MalformedURLException
    //   419	460	1735	java/net/MalformedURLException
    //   464	469	1735	java/net/MalformedURLException
    //   473	479	1735	java/net/MalformedURLException
    //   493	499	1735	java/net/MalformedURLException
    //   503	511	1735	java/net/MalformedURLException
    //   515	524	1735	java/net/MalformedURLException
    //   577	583	1735	java/net/MalformedURLException
    //   587	595	1735	java/net/MalformedURLException
    //   599	607	1735	java/net/MalformedURLException
    //   757	763	1735	java/net/MalformedURLException
    //   776	782	1735	java/net/MalformedURLException
    //   786	817	1735	java/net/MalformedURLException
    //   826	833	1735	java/net/MalformedURLException
    //   837	844	1735	java/net/MalformedURLException
    //   848	853	1735	java/net/MalformedURLException
    //   863	870	1735	java/net/MalformedURLException
    //   880	888	1735	java/net/MalformedURLException
    //   892	898	1735	java/net/MalformedURLException
    //   902	939	1735	java/net/MalformedURLException
    //   943	948	1735	java/net/MalformedURLException
    //   952	957	1735	java/net/MalformedURLException
    //   961	971	1735	java/net/MalformedURLException
    //   975	981	1735	java/net/MalformedURLException
    //   985	994	1735	java/net/MalformedURLException
    //   998	1003	1735	java/net/MalformedURLException
    //   1007	1013	1735	java/net/MalformedURLException
    //   1021	1027	1735	java/net/MalformedURLException
    //   1031	1040	1735	java/net/MalformedURLException
    //   1044	1053	1735	java/net/MalformedURLException
    //   1106	1111	1735	java/net/MalformedURLException
    //   1115	1122	1735	java/net/MalformedURLException
    //   1126	1132	1735	java/net/MalformedURLException
    //   1136	1191	1735	java/net/MalformedURLException
    //   1195	1202	1735	java/net/MalformedURLException
    //   1206	1213	1735	java/net/MalformedURLException
    //   1217	1227	1735	java/net/MalformedURLException
    //   1231	1238	1735	java/net/MalformedURLException
    //   1242	1257	1735	java/net/MalformedURLException
    //   1261	1267	1735	java/net/MalformedURLException
    //   1271	1313	1735	java/net/MalformedURLException
    //   1320	1327	1735	java/net/MalformedURLException
    //   1331	1342	1735	java/net/MalformedURLException
    //   1352	1357	1735	java/net/MalformedURLException
    //   1366	1372	1735	java/net/MalformedURLException
    //   1376	1384	1735	java/net/MalformedURLException
    //   1437	1444	1735	java/net/MalformedURLException
    //   1448	1463	1735	java/net/MalformedURLException
    //   1467	1489	1735	java/net/MalformedURLException
    //   1493	1499	1735	java/net/MalformedURLException
    //   1503	1514	1735	java/net/MalformedURLException
    //   1518	1524	1735	java/net/MalformedURLException
    //   1528	1534	1735	java/net/MalformedURLException
    //   1538	1583	1735	java/net/MalformedURLException
    //   1587	1597	1735	java/net/MalformedURLException
    //   1601	1607	1735	java/net/MalformedURLException
    //   1611	1619	1735	java/net/MalformedURLException
    //   1623	1628	1735	java/net/MalformedURLException
    //   1632	1640	1735	java/net/MalformedURLException
    //   1648	1654	1735	java/net/MalformedURLException
    //   1658	1667	1735	java/net/MalformedURLException
    //   1671	1677	1735	java/net/MalformedURLException
    //   1690	1696	1735	java/net/MalformedURLException
    //   1700	1732	1735	java/net/MalformedURLException
    //   1852	1862	1735	java/net/MalformedURLException
    //   1866	1875	1735	java/net/MalformedURLException
    //   1884	1890	1735	java/net/MalformedURLException
    //   1894	1959	1735	java/net/MalformedURLException
    //   1968	1973	1735	java/net/MalformedURLException
    //   1977	1988	1735	java/net/MalformedURLException
    //   1992	1999	1735	java/net/MalformedURLException
    //   2003	2010	1735	java/net/MalformedURLException
    //   64	77	2061	java/io/IOException
    //   64	77	2288	java/lang/IllegalStateException
    //   64	77	2404	java/lang/Exception
    //   64	77	2520	finally
    //   145	150	2576	java/io/IOException
    //   534	539	2581	java/io/IOException
    //   1063	1068	2586	java/io/IOException
    //   1394	1399	2591	java/io/IOException
    //   2020	2025	2596	java/io/IOException
    //   681	686	2601	java/io/IOException
    //   1807	1812	2606	java/io/IOException
    //   2247	2252	2611	java/io/IOException
    //   2363	2368	2616	java/io/IOException
    //   2479	2484	2621	java/io/IOException
    //   2535	2540	2626	java/io/IOException
    //   81	99	2631	finally
    //   103	108	2631	finally
    //   117	123	2631	finally
    //   127	135	2631	finally
    //   188	203	2631	finally
    //   207	214	2631	finally
    //   218	240	2631	finally
    //   244	250	2631	finally
    //   254	262	2631	finally
    //   266	272	2631	finally
    //   276	287	2631	finally
    //   291	297	2631	finally
    //   301	307	2631	finally
    //   311	319	2631	finally
    //   323	328	2631	finally
    //   356	366	2631	finally
    //   370	376	2631	finally
    //   380	389	2631	finally
    //   393	400	2631	finally
    //   404	415	2631	finally
    //   419	460	2631	finally
    //   464	469	2631	finally
    //   473	479	2631	finally
    //   493	499	2631	finally
    //   503	511	2631	finally
    //   515	524	2631	finally
    //   577	583	2631	finally
    //   587	595	2631	finally
    //   599	607	2631	finally
    //   616	622	2631	finally
    //   626	657	2631	finally
    //   661	671	2631	finally
    //   757	763	2631	finally
    //   776	782	2631	finally
    //   786	817	2631	finally
    //   826	833	2631	finally
    //   837	844	2631	finally
    //   848	853	2631	finally
    //   863	870	2631	finally
    //   880	888	2631	finally
    //   892	898	2631	finally
    //   902	939	2631	finally
    //   943	948	2631	finally
    //   952	957	2631	finally
    //   961	971	2631	finally
    //   975	981	2631	finally
    //   985	994	2631	finally
    //   998	1003	2631	finally
    //   1007	1013	2631	finally
    //   1021	1027	2631	finally
    //   1031	1040	2631	finally
    //   1044	1053	2631	finally
    //   1106	1111	2631	finally
    //   1115	1122	2631	finally
    //   1126	1132	2631	finally
    //   1136	1191	2631	finally
    //   1195	1202	2631	finally
    //   1206	1213	2631	finally
    //   1217	1227	2631	finally
    //   1231	1238	2631	finally
    //   1242	1257	2631	finally
    //   1261	1267	2631	finally
    //   1271	1313	2631	finally
    //   1320	1327	2631	finally
    //   1331	1342	2631	finally
    //   1352	1357	2631	finally
    //   1366	1372	2631	finally
    //   1376	1384	2631	finally
    //   1437	1444	2631	finally
    //   1448	1463	2631	finally
    //   1467	1489	2631	finally
    //   1493	1499	2631	finally
    //   1503	1514	2631	finally
    //   1518	1524	2631	finally
    //   1528	1534	2631	finally
    //   1538	1583	2631	finally
    //   1587	1597	2631	finally
    //   1601	1607	2631	finally
    //   1611	1619	2631	finally
    //   1623	1628	2631	finally
    //   1632	1640	2631	finally
    //   1648	1654	2631	finally
    //   1658	1667	2631	finally
    //   1671	1677	2631	finally
    //   1690	1696	2631	finally
    //   1700	1732	2631	finally
    //   1741	1751	2631	finally
    //   1755	1761	2631	finally
    //   1765	1797	2631	finally
    //   1852	1862	2631	finally
    //   1866	1875	2631	finally
    //   1884	1890	2631	finally
    //   1894	1959	2631	finally
    //   1968	1973	2631	finally
    //   1977	1988	2631	finally
    //   1992	1999	2631	finally
    //   2003	2010	2631	finally
    //   2070	2076	2631	finally
    //   2080	2112	2631	finally
    //   2116	2121	2631	finally
    //   2130	2136	2631	finally
    //   2140	2155	2631	finally
    //   2159	2165	2631	finally
    //   2169	2178	2631	finally
    //   2182	2188	2631	finally
    //   2192	2200	2631	finally
    //   2204	2210	2631	finally
    //   2214	2223	2631	finally
    //   2227	2237	2631	finally
    //   2297	2307	2631	finally
    //   2311	2317	2631	finally
    //   2321	2353	2631	finally
    //   2413	2419	2631	finally
    //   2423	2455	2631	finally
    //   2459	2469	2631	finally
    //   81	99	2636	java/lang/Exception
    //   103	108	2636	java/lang/Exception
    //   117	123	2636	java/lang/Exception
    //   127	135	2636	java/lang/Exception
    //   188	203	2636	java/lang/Exception
    //   207	214	2636	java/lang/Exception
    //   218	240	2636	java/lang/Exception
    //   244	250	2636	java/lang/Exception
    //   254	262	2636	java/lang/Exception
    //   266	272	2636	java/lang/Exception
    //   276	287	2636	java/lang/Exception
    //   291	297	2636	java/lang/Exception
    //   301	307	2636	java/lang/Exception
    //   311	319	2636	java/lang/Exception
    //   323	328	2636	java/lang/Exception
    //   356	366	2636	java/lang/Exception
    //   370	376	2636	java/lang/Exception
    //   380	389	2636	java/lang/Exception
    //   393	400	2636	java/lang/Exception
    //   404	415	2636	java/lang/Exception
    //   419	460	2636	java/lang/Exception
    //   464	469	2636	java/lang/Exception
    //   473	479	2636	java/lang/Exception
    //   493	499	2636	java/lang/Exception
    //   503	511	2636	java/lang/Exception
    //   515	524	2636	java/lang/Exception
    //   577	583	2636	java/lang/Exception
    //   587	595	2636	java/lang/Exception
    //   599	607	2636	java/lang/Exception
    //   757	763	2636	java/lang/Exception
    //   776	782	2636	java/lang/Exception
    //   786	817	2636	java/lang/Exception
    //   826	833	2636	java/lang/Exception
    //   837	844	2636	java/lang/Exception
    //   848	853	2636	java/lang/Exception
    //   863	870	2636	java/lang/Exception
    //   880	888	2636	java/lang/Exception
    //   892	898	2636	java/lang/Exception
    //   902	939	2636	java/lang/Exception
    //   943	948	2636	java/lang/Exception
    //   952	957	2636	java/lang/Exception
    //   961	971	2636	java/lang/Exception
    //   975	981	2636	java/lang/Exception
    //   985	994	2636	java/lang/Exception
    //   998	1003	2636	java/lang/Exception
    //   1007	1013	2636	java/lang/Exception
    //   1021	1027	2636	java/lang/Exception
    //   1031	1040	2636	java/lang/Exception
    //   1044	1053	2636	java/lang/Exception
    //   1106	1111	2636	java/lang/Exception
    //   1115	1122	2636	java/lang/Exception
    //   1126	1132	2636	java/lang/Exception
    //   1136	1191	2636	java/lang/Exception
    //   1195	1202	2636	java/lang/Exception
    //   1206	1213	2636	java/lang/Exception
    //   1217	1227	2636	java/lang/Exception
    //   1231	1238	2636	java/lang/Exception
    //   1242	1257	2636	java/lang/Exception
    //   1261	1267	2636	java/lang/Exception
    //   1271	1313	2636	java/lang/Exception
    //   1320	1327	2636	java/lang/Exception
    //   1331	1342	2636	java/lang/Exception
    //   1352	1357	2636	java/lang/Exception
    //   1366	1372	2636	java/lang/Exception
    //   1376	1384	2636	java/lang/Exception
    //   1437	1444	2636	java/lang/Exception
    //   1448	1463	2636	java/lang/Exception
    //   1467	1489	2636	java/lang/Exception
    //   1493	1499	2636	java/lang/Exception
    //   1503	1514	2636	java/lang/Exception
    //   1518	1524	2636	java/lang/Exception
    //   1528	1534	2636	java/lang/Exception
    //   1538	1583	2636	java/lang/Exception
    //   1587	1597	2636	java/lang/Exception
    //   1601	1607	2636	java/lang/Exception
    //   1611	1619	2636	java/lang/Exception
    //   1623	1628	2636	java/lang/Exception
    //   1632	1640	2636	java/lang/Exception
    //   1648	1654	2636	java/lang/Exception
    //   1658	1667	2636	java/lang/Exception
    //   1671	1677	2636	java/lang/Exception
    //   1690	1696	2636	java/lang/Exception
    //   1700	1732	2636	java/lang/Exception
    //   1852	1862	2636	java/lang/Exception
    //   1866	1875	2636	java/lang/Exception
    //   1884	1890	2636	java/lang/Exception
    //   1894	1959	2636	java/lang/Exception
    //   1968	1973	2636	java/lang/Exception
    //   1977	1988	2636	java/lang/Exception
    //   1992	1999	2636	java/lang/Exception
    //   2003	2010	2636	java/lang/Exception
    //   81	99	2641	java/lang/IllegalStateException
    //   103	108	2641	java/lang/IllegalStateException
    //   117	123	2641	java/lang/IllegalStateException
    //   127	135	2641	java/lang/IllegalStateException
    //   188	203	2641	java/lang/IllegalStateException
    //   207	214	2641	java/lang/IllegalStateException
    //   218	240	2641	java/lang/IllegalStateException
    //   244	250	2641	java/lang/IllegalStateException
    //   254	262	2641	java/lang/IllegalStateException
    //   266	272	2641	java/lang/IllegalStateException
    //   276	287	2641	java/lang/IllegalStateException
    //   291	297	2641	java/lang/IllegalStateException
    //   301	307	2641	java/lang/IllegalStateException
    //   311	319	2641	java/lang/IllegalStateException
    //   323	328	2641	java/lang/IllegalStateException
    //   356	366	2641	java/lang/IllegalStateException
    //   370	376	2641	java/lang/IllegalStateException
    //   380	389	2641	java/lang/IllegalStateException
    //   393	400	2641	java/lang/IllegalStateException
    //   404	415	2641	java/lang/IllegalStateException
    //   419	460	2641	java/lang/IllegalStateException
    //   464	469	2641	java/lang/IllegalStateException
    //   473	479	2641	java/lang/IllegalStateException
    //   493	499	2641	java/lang/IllegalStateException
    //   503	511	2641	java/lang/IllegalStateException
    //   515	524	2641	java/lang/IllegalStateException
    //   577	583	2641	java/lang/IllegalStateException
    //   587	595	2641	java/lang/IllegalStateException
    //   599	607	2641	java/lang/IllegalStateException
    //   757	763	2641	java/lang/IllegalStateException
    //   776	782	2641	java/lang/IllegalStateException
    //   786	817	2641	java/lang/IllegalStateException
    //   826	833	2641	java/lang/IllegalStateException
    //   837	844	2641	java/lang/IllegalStateException
    //   848	853	2641	java/lang/IllegalStateException
    //   863	870	2641	java/lang/IllegalStateException
    //   880	888	2641	java/lang/IllegalStateException
    //   892	898	2641	java/lang/IllegalStateException
    //   902	939	2641	java/lang/IllegalStateException
    //   943	948	2641	java/lang/IllegalStateException
    //   952	957	2641	java/lang/IllegalStateException
    //   961	971	2641	java/lang/IllegalStateException
    //   975	981	2641	java/lang/IllegalStateException
    //   985	994	2641	java/lang/IllegalStateException
    //   998	1003	2641	java/lang/IllegalStateException
    //   1007	1013	2641	java/lang/IllegalStateException
    //   1021	1027	2641	java/lang/IllegalStateException
    //   1031	1040	2641	java/lang/IllegalStateException
    //   1044	1053	2641	java/lang/IllegalStateException
    //   1106	1111	2641	java/lang/IllegalStateException
    //   1115	1122	2641	java/lang/IllegalStateException
    //   1126	1132	2641	java/lang/IllegalStateException
    //   1136	1191	2641	java/lang/IllegalStateException
    //   1195	1202	2641	java/lang/IllegalStateException
    //   1206	1213	2641	java/lang/IllegalStateException
    //   1217	1227	2641	java/lang/IllegalStateException
    //   1231	1238	2641	java/lang/IllegalStateException
    //   1242	1257	2641	java/lang/IllegalStateException
    //   1261	1267	2641	java/lang/IllegalStateException
    //   1271	1313	2641	java/lang/IllegalStateException
    //   1320	1327	2641	java/lang/IllegalStateException
    //   1331	1342	2641	java/lang/IllegalStateException
    //   1352	1357	2641	java/lang/IllegalStateException
    //   1366	1372	2641	java/lang/IllegalStateException
    //   1376	1384	2641	java/lang/IllegalStateException
    //   1437	1444	2641	java/lang/IllegalStateException
    //   1448	1463	2641	java/lang/IllegalStateException
    //   1467	1489	2641	java/lang/IllegalStateException
    //   1493	1499	2641	java/lang/IllegalStateException
    //   1503	1514	2641	java/lang/IllegalStateException
    //   1518	1524	2641	java/lang/IllegalStateException
    //   1528	1534	2641	java/lang/IllegalStateException
    //   1538	1583	2641	java/lang/IllegalStateException
    //   1587	1597	2641	java/lang/IllegalStateException
    //   1601	1607	2641	java/lang/IllegalStateException
    //   1611	1619	2641	java/lang/IllegalStateException
    //   1623	1628	2641	java/lang/IllegalStateException
    //   1632	1640	2641	java/lang/IllegalStateException
    //   1648	1654	2641	java/lang/IllegalStateException
    //   1658	1667	2641	java/lang/IllegalStateException
    //   1671	1677	2641	java/lang/IllegalStateException
    //   1690	1696	2641	java/lang/IllegalStateException
    //   1700	1732	2641	java/lang/IllegalStateException
    //   1852	1862	2641	java/lang/IllegalStateException
    //   1866	1875	2641	java/lang/IllegalStateException
    //   1884	1890	2641	java/lang/IllegalStateException
    //   1894	1959	2641	java/lang/IllegalStateException
    //   1968	1973	2641	java/lang/IllegalStateException
    //   1977	1988	2641	java/lang/IllegalStateException
    //   1992	1999	2641	java/lang/IllegalStateException
    //   2003	2010	2641	java/lang/IllegalStateException
    //   81	99	2646	java/io/IOException
    //   103	108	2646	java/io/IOException
    //   117	123	2646	java/io/IOException
    //   127	135	2646	java/io/IOException
    //   188	203	2646	java/io/IOException
    //   207	214	2646	java/io/IOException
    //   218	240	2646	java/io/IOException
    //   244	250	2646	java/io/IOException
    //   254	262	2646	java/io/IOException
    //   266	272	2646	java/io/IOException
    //   276	287	2646	java/io/IOException
    //   291	297	2646	java/io/IOException
    //   301	307	2646	java/io/IOException
    //   311	319	2646	java/io/IOException
    //   323	328	2646	java/io/IOException
    //   356	366	2646	java/io/IOException
    //   370	376	2646	java/io/IOException
    //   380	389	2646	java/io/IOException
    //   393	400	2646	java/io/IOException
    //   404	415	2646	java/io/IOException
    //   419	460	2646	java/io/IOException
    //   464	469	2646	java/io/IOException
    //   473	479	2646	java/io/IOException
    //   493	499	2646	java/io/IOException
    //   503	511	2646	java/io/IOException
    //   515	524	2646	java/io/IOException
    //   577	583	2646	java/io/IOException
    //   587	595	2646	java/io/IOException
    //   599	607	2646	java/io/IOException
    //   757	763	2646	java/io/IOException
    //   776	782	2646	java/io/IOException
    //   786	817	2646	java/io/IOException
    //   826	833	2646	java/io/IOException
    //   837	844	2646	java/io/IOException
    //   848	853	2646	java/io/IOException
    //   863	870	2646	java/io/IOException
    //   880	888	2646	java/io/IOException
    //   892	898	2646	java/io/IOException
    //   902	939	2646	java/io/IOException
    //   943	948	2646	java/io/IOException
    //   952	957	2646	java/io/IOException
    //   961	971	2646	java/io/IOException
    //   975	981	2646	java/io/IOException
    //   985	994	2646	java/io/IOException
    //   998	1003	2646	java/io/IOException
    //   1007	1013	2646	java/io/IOException
    //   1021	1027	2646	java/io/IOException
    //   1031	1040	2646	java/io/IOException
    //   1044	1053	2646	java/io/IOException
    //   1106	1111	2646	java/io/IOException
    //   1115	1122	2646	java/io/IOException
    //   1126	1132	2646	java/io/IOException
    //   1136	1191	2646	java/io/IOException
    //   1195	1202	2646	java/io/IOException
    //   1206	1213	2646	java/io/IOException
    //   1217	1227	2646	java/io/IOException
    //   1231	1238	2646	java/io/IOException
    //   1242	1257	2646	java/io/IOException
    //   1261	1267	2646	java/io/IOException
    //   1271	1313	2646	java/io/IOException
    //   1320	1327	2646	java/io/IOException
    //   1331	1342	2646	java/io/IOException
    //   1352	1357	2646	java/io/IOException
    //   1366	1372	2646	java/io/IOException
    //   1376	1384	2646	java/io/IOException
    //   1437	1444	2646	java/io/IOException
    //   1448	1463	2646	java/io/IOException
    //   1467	1489	2646	java/io/IOException
    //   1493	1499	2646	java/io/IOException
    //   1503	1514	2646	java/io/IOException
    //   1518	1524	2646	java/io/IOException
    //   1528	1534	2646	java/io/IOException
    //   1538	1583	2646	java/io/IOException
    //   1587	1597	2646	java/io/IOException
    //   1601	1607	2646	java/io/IOException
    //   1611	1619	2646	java/io/IOException
    //   1623	1628	2646	java/io/IOException
    //   1632	1640	2646	java/io/IOException
    //   1648	1654	2646	java/io/IOException
    //   1658	1667	2646	java/io/IOException
    //   1671	1677	2646	java/io/IOException
    //   1690	1696	2646	java/io/IOException
    //   1700	1732	2646	java/io/IOException
    //   1852	1862	2646	java/io/IOException
    //   1866	1875	2646	java/io/IOException
    //   1884	1890	2646	java/io/IOException
    //   1894	1959	2646	java/io/IOException
    //   1968	1973	2646	java/io/IOException
    //   1977	1988	2646	java/io/IOException
    //   1992	1999	2646	java/io/IOException
    //   2003	2010	2646	java/io/IOException
    //   64	77	2651	java/net/MalformedURLException
    //   64	77	2659	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesl
 * JD-Core Version:    0.7.0.1
 */