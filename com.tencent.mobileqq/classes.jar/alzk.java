import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicUtils.1;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import java.util.TimeZone;

public class alzk
{
  /* Error */
  private static int a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: invokestatic 18	java/lang/System:currentTimeMillis	()J
    //   6: lstore 5
    //   8: new 20	axlq
    //   11: dup
    //   12: invokespecial 24	axlq:<init>	()V
    //   15: astore 9
    //   17: aload 9
    //   19: iload_3
    //   20: putfield 28	axlq:c	I
    //   23: aload 9
    //   25: iload_3
    //   26: putfield 31	axlq:d	I
    //   29: aload 9
    //   31: ldc 33
    //   33: putfield 36	axlq:a	Ljava/lang/String;
    //   36: aload 9
    //   38: iload 4
    //   40: putfield 39	axlq:e	I
    //   43: aload_1
    //   44: aload_2
    //   45: aload 9
    //   47: invokestatic 42	alzk:a	(Ljava/lang/String;Ljava/lang/String;Laxlq;)[Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnonnull +8 -> 60
    //   55: ldc 44
    //   57: invokestatic 47	alzk:a	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: invokestatic 53	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   64: astore_0
    //   65: invokestatic 58	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Ljava/lang/String;
    //   68: astore 9
    //   70: new 60	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   77: ldc 63
    //   79: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 69
    //   88: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 9
    //   93: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 47	alzk:a	(Ljava/lang/String;)V
    //   102: new 74	java/lang/ProcessBuilder
    //   105: dup
    //   106: iconst_0
    //   107: anewarray 76	java/lang/String
    //   110: invokespecial 79	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   113: astore 10
    //   115: aload 10
    //   117: iconst_1
    //   118: invokevirtual 83	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   121: pop
    //   122: new 85	java/util/ArrayList
    //   125: dup
    //   126: invokespecial 86	java/util/ArrayList:<init>	()V
    //   129: astore 12
    //   131: aload 12
    //   133: new 60	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   140: aload_0
    //   141: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 88
    //   146: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokeinterface 94 2 0
    //   157: pop
    //   158: new 60	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   165: ldc 96
    //   167: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 12
    //   172: iconst_0
    //   173: invokeinterface 100 2 0
    //   178: checkcast 76	java/lang/String
    //   181: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 47	alzk:a	(Ljava/lang/String;)V
    //   190: aload_1
    //   191: arraylength
    //   192: istore 4
    //   194: iconst_0
    //   195: istore_3
    //   196: iload_3
    //   197: iload 4
    //   199: if_icmpge +21 -> 220
    //   202: aload 12
    //   204: aload_1
    //   205: iload_3
    //   206: aaload
    //   207: invokeinterface 94 2 0
    //   212: pop
    //   213: iload_3
    //   214: iconst_1
    //   215: iadd
    //   216: istore_3
    //   217: goto -21 -> 196
    //   220: aload 12
    //   222: new 60	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   229: aload_0
    //   230: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload 9
    //   235: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokeinterface 94 2 0
    //   246: pop
    //   247: aload 10
    //   249: aload 12
    //   251: invokevirtual 104	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   254: pop
    //   255: new 60	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   262: ldc 106
    //   264: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 12
    //   269: aload 12
    //   271: invokeinterface 110 1 0
    //   276: iconst_1
    //   277: isub
    //   278: invokeinterface 100 2 0
    //   283: checkcast 76	java/lang/String
    //   286: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 47	alzk:a	(Ljava/lang/String;)V
    //   295: aload 10
    //   297: invokevirtual 114	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   300: astore 13
    //   302: aload 13
    //   304: invokevirtual 120	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   307: astore_0
    //   308: new 122	java/io/InputStreamReader
    //   311: dup
    //   312: aload_0
    //   313: invokespecial 125	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   316: astore_1
    //   317: new 127	java/io/BufferedReader
    //   320: dup
    //   321: aload_1
    //   322: invokespecial 130	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   325: astore 12
    //   327: aload 12
    //   329: astore 11
    //   331: aload_1
    //   332: astore 10
    //   334: aload_0
    //   335: astore 9
    //   337: aload 13
    //   339: invokevirtual 133	java/lang/Process:waitFor	()I
    //   342: pop
    //   343: aload 12
    //   345: astore 11
    //   347: aload_1
    //   348: astore 10
    //   350: aload_0
    //   351: astore 9
    //   353: aload 13
    //   355: invokevirtual 136	java/lang/Process:exitValue	()I
    //   358: istore 4
    //   360: aload 12
    //   362: astore 11
    //   364: aload_1
    //   365: astore 10
    //   367: aload_0
    //   368: astore 9
    //   370: new 60	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   377: ldc 138
    //   379: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: iload 4
    //   384: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   387: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 47	alzk:a	(Ljava/lang/String;)V
    //   393: aload 12
    //   395: astore 11
    //   397: aload_1
    //   398: astore 10
    //   400: aload_0
    //   401: astore 9
    //   403: aload 12
    //   405: invokevirtual 144	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   408: astore 14
    //   410: aload 14
    //   412: ifnull +218 -> 630
    //   415: aload 12
    //   417: astore 11
    //   419: aload_1
    //   420: astore 10
    //   422: aload_0
    //   423: astore 9
    //   425: new 60	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   432: ldc 146
    //   434: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload 14
    //   439: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 47	alzk:a	(Ljava/lang/String;)V
    //   448: goto -55 -> 393
    //   451: astore 13
    //   453: sipush -1001
    //   456: istore 4
    //   458: aload 12
    //   460: astore 11
    //   462: aload_1
    //   463: astore 10
    //   465: aload_0
    //   466: astore 9
    //   468: aload 13
    //   470: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   473: aload 12
    //   475: astore 11
    //   477: aload_1
    //   478: astore 10
    //   480: aload_0
    //   481: astore 9
    //   483: new 60	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   490: ldc 151
    //   492: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload 13
    //   497: invokevirtual 152	java/io/IOException:toString	()Ljava/lang/String;
    //   500: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 47	alzk:a	(Ljava/lang/String;)V
    //   509: aload_0
    //   510: ifnull +7 -> 517
    //   513: aload_0
    //   514: invokevirtual 157	java/io/InputStream:close	()V
    //   517: aload_1
    //   518: ifnull +7 -> 525
    //   521: aload_1
    //   522: invokevirtual 158	java/io/InputStreamReader:close	()V
    //   525: iload 4
    //   527: istore_3
    //   528: aload 12
    //   530: ifnull +11 -> 541
    //   533: aload 12
    //   535: invokevirtual 159	java/io/BufferedReader:close	()V
    //   538: iload 4
    //   540: istore_3
    //   541: invokestatic 18	java/lang/System:currentTimeMillis	()J
    //   544: lstore 7
    //   546: new 60	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   553: ldc 161
    //   555: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: lload 7
    //   560: lload 5
    //   562: lsub
    //   563: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   566: ldc 166
    //   568: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: iload_3
    //   572: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   575: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokestatic 47	alzk:a	(Ljava/lang/String;)V
    //   581: iload_3
    //   582: ifeq +46 -> 628
    //   585: new 168	java/io/File
    //   588: dup
    //   589: aload_2
    //   590: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   593: astore_0
    //   594: aload_0
    //   595: invokevirtual 174	java/io/File:exists	()Z
    //   598: ifeq +30 -> 628
    //   601: aload_0
    //   602: invokevirtual 177	java/io/File:delete	()Z
    //   605: pop
    //   606: new 60	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   613: ldc 179
    //   615: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: iload_3
    //   619: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   622: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 47	alzk:a	(Ljava/lang/String;)V
    //   628: iload_3
    //   629: ireturn
    //   630: aload 12
    //   632: astore 11
    //   634: aload_1
    //   635: astore 10
    //   637: aload_0
    //   638: astore 9
    //   640: aload 13
    //   642: invokevirtual 182	java/lang/Process:destroy	()V
    //   645: aload 12
    //   647: astore 11
    //   649: aload_1
    //   650: astore 10
    //   652: aload_0
    //   653: astore 9
    //   655: ldc 184
    //   657: invokestatic 47	alzk:a	(Ljava/lang/String;)V
    //   660: aload_0
    //   661: ifnull +7 -> 668
    //   664: aload_0
    //   665: invokevirtual 157	java/io/InputStream:close	()V
    //   668: aload_1
    //   669: ifnull +7 -> 676
    //   672: aload_1
    //   673: invokevirtual 158	java/io/InputStreamReader:close	()V
    //   676: iload 4
    //   678: istore_3
    //   679: aload 12
    //   681: ifnull -140 -> 541
    //   684: aload 12
    //   686: invokevirtual 159	java/io/BufferedReader:close	()V
    //   689: iload 4
    //   691: istore_3
    //   692: goto -151 -> 541
    //   695: astore_0
    //   696: iload 4
    //   698: istore_3
    //   699: goto -158 -> 541
    //   702: astore 13
    //   704: aconst_null
    //   705: astore 12
    //   707: aconst_null
    //   708: astore_1
    //   709: aconst_null
    //   710: astore_0
    //   711: sipush -1002
    //   714: istore 4
    //   716: aload 12
    //   718: astore 11
    //   720: aload_1
    //   721: astore 10
    //   723: aload_0
    //   724: astore 9
    //   726: aload 13
    //   728: invokevirtual 185	java/lang/InterruptedException:printStackTrace	()V
    //   731: aload 12
    //   733: astore 11
    //   735: aload_1
    //   736: astore 10
    //   738: aload_0
    //   739: astore 9
    //   741: new 60	java/lang/StringBuilder
    //   744: dup
    //   745: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   748: ldc 187
    //   750: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: aload 13
    //   755: invokevirtual 188	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   758: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: invokestatic 47	alzk:a	(Ljava/lang/String;)V
    //   767: aload_0
    //   768: ifnull +7 -> 775
    //   771: aload_0
    //   772: invokevirtual 157	java/io/InputStream:close	()V
    //   775: aload_1
    //   776: ifnull +7 -> 783
    //   779: aload_1
    //   780: invokevirtual 158	java/io/InputStreamReader:close	()V
    //   783: iload 4
    //   785: istore_3
    //   786: aload 12
    //   788: ifnull -247 -> 541
    //   791: aload 12
    //   793: invokevirtual 159	java/io/BufferedReader:close	()V
    //   796: iload 4
    //   798: istore_3
    //   799: goto -258 -> 541
    //   802: astore_0
    //   803: iload 4
    //   805: istore_3
    //   806: goto -265 -> 541
    //   809: astore 13
    //   811: aconst_null
    //   812: astore 12
    //   814: aconst_null
    //   815: astore_1
    //   816: aconst_null
    //   817: astore_0
    //   818: sipush -1003
    //   821: istore 4
    //   823: aload 12
    //   825: astore 11
    //   827: aload_1
    //   828: astore 10
    //   830: aload_0
    //   831: astore 9
    //   833: aload 13
    //   835: invokevirtual 189	java/lang/Exception:printStackTrace	()V
    //   838: aload 12
    //   840: astore 11
    //   842: aload_1
    //   843: astore 10
    //   845: aload_0
    //   846: astore 9
    //   848: new 60	java/lang/StringBuilder
    //   851: dup
    //   852: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   855: ldc 191
    //   857: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: aload 13
    //   862: invokevirtual 192	java/lang/Exception:toString	()Ljava/lang/String;
    //   865: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: invokestatic 47	alzk:a	(Ljava/lang/String;)V
    //   874: aload_0
    //   875: ifnull +7 -> 882
    //   878: aload_0
    //   879: invokevirtual 157	java/io/InputStream:close	()V
    //   882: aload_1
    //   883: ifnull +7 -> 890
    //   886: aload_1
    //   887: invokevirtual 158	java/io/InputStreamReader:close	()V
    //   890: iload 4
    //   892: istore_3
    //   893: aload 12
    //   895: ifnull -354 -> 541
    //   898: aload 12
    //   900: invokevirtual 159	java/io/BufferedReader:close	()V
    //   903: iload 4
    //   905: istore_3
    //   906: goto -365 -> 541
    //   909: astore_0
    //   910: iload 4
    //   912: istore_3
    //   913: goto -372 -> 541
    //   916: astore_2
    //   917: aconst_null
    //   918: astore_1
    //   919: aconst_null
    //   920: astore_0
    //   921: aload_0
    //   922: ifnull +7 -> 929
    //   925: aload_0
    //   926: invokevirtual 157	java/io/InputStream:close	()V
    //   929: aload_1
    //   930: ifnull +7 -> 937
    //   933: aload_1
    //   934: invokevirtual 158	java/io/InputStreamReader:close	()V
    //   937: aload 11
    //   939: ifnull +8 -> 947
    //   942: aload 11
    //   944: invokevirtual 159	java/io/BufferedReader:close	()V
    //   947: aload_2
    //   948: athrow
    //   949: astore_0
    //   950: iload_3
    //   951: ireturn
    //   952: astore_0
    //   953: goto -6 -> 947
    //   956: astore_2
    //   957: aconst_null
    //   958: astore_1
    //   959: goto -38 -> 921
    //   962: astore_2
    //   963: goto -42 -> 921
    //   966: astore_2
    //   967: aload 10
    //   969: astore_1
    //   970: aload 9
    //   972: astore_0
    //   973: goto -52 -> 921
    //   976: astore 13
    //   978: aconst_null
    //   979: astore 12
    //   981: aconst_null
    //   982: astore_1
    //   983: goto -165 -> 818
    //   986: astore 13
    //   988: aconst_null
    //   989: astore 12
    //   991: goto -173 -> 818
    //   994: astore 13
    //   996: goto -178 -> 818
    //   999: astore 13
    //   1001: aconst_null
    //   1002: astore 12
    //   1004: aconst_null
    //   1005: astore_1
    //   1006: goto -295 -> 711
    //   1009: astore 13
    //   1011: aconst_null
    //   1012: astore 12
    //   1014: goto -303 -> 711
    //   1017: astore 13
    //   1019: goto -308 -> 711
    //   1022: astore_0
    //   1023: iload 4
    //   1025: istore_3
    //   1026: goto -485 -> 541
    //   1029: astore 13
    //   1031: aconst_null
    //   1032: astore 12
    //   1034: aconst_null
    //   1035: astore_1
    //   1036: aconst_null
    //   1037: astore_0
    //   1038: goto -585 -> 453
    //   1041: astore 13
    //   1043: aconst_null
    //   1044: astore 12
    //   1046: aconst_null
    //   1047: astore_1
    //   1048: goto -595 -> 453
    //   1051: astore 13
    //   1053: aconst_null
    //   1054: astore 12
    //   1056: goto -603 -> 453
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1059	0	paramContext	Context
    //   0	1059	1	paramString1	String
    //   0	1059	2	paramString2	String
    //   0	1059	3	paramInt1	int
    //   0	1059	4	paramInt2	int
    //   6	555	5	l1	long
    //   544	15	7	l2	long
    //   15	956	9	localObject1	Object
    //   113	855	10	localObject2	Object
    //   1	942	11	localObject3	Object
    //   129	926	12	localObject4	Object
    //   300	54	13	localProcess	java.lang.Process
    //   451	190	13	localIOException1	java.io.IOException
    //   702	52	13	localInterruptedException1	java.lang.InterruptedException
    //   809	52	13	localException1	java.lang.Exception
    //   976	1	13	localException2	java.lang.Exception
    //   986	1	13	localException3	java.lang.Exception
    //   994	1	13	localException4	java.lang.Exception
    //   999	1	13	localInterruptedException2	java.lang.InterruptedException
    //   1009	1	13	localInterruptedException3	java.lang.InterruptedException
    //   1017	1	13	localInterruptedException4	java.lang.InterruptedException
    //   1029	1	13	localIOException2	java.io.IOException
    //   1041	1	13	localIOException3	java.io.IOException
    //   1051	1	13	localIOException4	java.io.IOException
    //   408	30	14	str	String
    // Exception table:
    //   from	to	target	type
    //   337	343	451	java/io/IOException
    //   353	360	451	java/io/IOException
    //   370	393	451	java/io/IOException
    //   403	410	451	java/io/IOException
    //   425	448	451	java/io/IOException
    //   640	645	451	java/io/IOException
    //   655	660	451	java/io/IOException
    //   664	668	695	java/io/IOException
    //   672	676	695	java/io/IOException
    //   684	689	695	java/io/IOException
    //   102	194	702	java/lang/InterruptedException
    //   202	213	702	java/lang/InterruptedException
    //   220	308	702	java/lang/InterruptedException
    //   771	775	802	java/io/IOException
    //   779	783	802	java/io/IOException
    //   791	796	802	java/io/IOException
    //   102	194	809	java/lang/Exception
    //   202	213	809	java/lang/Exception
    //   220	308	809	java/lang/Exception
    //   878	882	909	java/io/IOException
    //   886	890	909	java/io/IOException
    //   898	903	909	java/io/IOException
    //   102	194	916	finally
    //   202	213	916	finally
    //   220	308	916	finally
    //   585	628	949	java/lang/Exception
    //   925	929	952	java/io/IOException
    //   933	937	952	java/io/IOException
    //   942	947	952	java/io/IOException
    //   308	317	956	finally
    //   317	327	962	finally
    //   337	343	966	finally
    //   353	360	966	finally
    //   370	393	966	finally
    //   403	410	966	finally
    //   425	448	966	finally
    //   468	473	966	finally
    //   483	509	966	finally
    //   640	645	966	finally
    //   655	660	966	finally
    //   726	731	966	finally
    //   741	767	966	finally
    //   833	838	966	finally
    //   848	874	966	finally
    //   308	317	976	java/lang/Exception
    //   317	327	986	java/lang/Exception
    //   337	343	994	java/lang/Exception
    //   353	360	994	java/lang/Exception
    //   370	393	994	java/lang/Exception
    //   403	410	994	java/lang/Exception
    //   425	448	994	java/lang/Exception
    //   640	645	994	java/lang/Exception
    //   655	660	994	java/lang/Exception
    //   308	317	999	java/lang/InterruptedException
    //   317	327	1009	java/lang/InterruptedException
    //   337	343	1017	java/lang/InterruptedException
    //   353	360	1017	java/lang/InterruptedException
    //   370	393	1017	java/lang/InterruptedException
    //   403	410	1017	java/lang/InterruptedException
    //   425	448	1017	java/lang/InterruptedException
    //   640	645	1017	java/lang/InterruptedException
    //   655	660	1017	java/lang/InterruptedException
    //   513	517	1022	java/io/IOException
    //   521	525	1022	java/io/IOException
    //   533	538	1022	java/io/IOException
    //   102	194	1029	java/io/IOException
    //   202	213	1029	java/io/IOException
    //   220	308	1029	java/io/IOException
    //   308	317	1041	java/io/IOException
    //   317	327	1051	java/io/IOException
  }
  
  public static int a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    return a(paramString1, paramString2, paramInt, paramContext, 25);
  }
  
  public static int a(String paramString1, String paramString2, int paramInt1, Context paramContext, int paramInt2)
  {
    long l1 = System.currentTimeMillis();
    int i = -1;
    if (ShortVideoTrimmer.a(paramContext, 0, 0))
    {
      axlq localaxlq = ShortVideoTrimmer.a(paramString1);
      localaxlq.c = paramInt1;
      localaxlq.d = paramInt1;
      if (QLog.isColorLevel()) {
        QLog.i("DynamicUtils", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
      }
      paramInt1 = a(paramContext, paramString1, paramString2, paramInt1, paramInt2);
      long l2 = System.currentTimeMillis();
      i = paramInt1;
      if (paramInt1 == 0)
      {
        long l3 = new File(paramString1).length();
        long l4 = new File(paramString2).length();
        i = paramInt1;
        if (QLog.isColorLevel())
        {
          QLog.i("DynamicUtils", 2, "CompressTask，step: ShortVideoTrimmer compress ret = " + paramInt1 + ", cost:" + (l2 - l1) + "ms, fileSourceSize=" + l3 + ", fileTargetSize=" + l4);
          i = paramInt1;
        }
      }
    }
    return i;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
      if (localBitmap != null)
      {
        Paint localPaint = new Paint(7);
        localBitmap.eraseColor(0);
        Canvas localCanvas = new Canvas(localBitmap);
        Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
        localPaint.setColor(Color.parseColor("#38000000"));
        localCanvas.drawRect(localRect, localPaint);
        localPaint.setColor(0);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        localCanvas.drawCircle(paramInt1 * 0.5F, paramInt2 * 0.5F, paramInt3, localPaint);
      }
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqBaseActivity", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
        }
        Object localObject = null;
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = null;
    if (paramBitmap == null) {
      paramBitmap = localBitmap1;
    }
    do
    {
      return paramBitmap;
      localBitmap1 = localBitmap2;
      try
      {
        localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
        localBitmap1 = localBitmap2;
        Canvas localCanvas = new Canvas(localBitmap2);
        localBitmap1 = localBitmap2;
        Paint localPaint = new Paint(6);
        localBitmap1 = localBitmap2;
        localCanvas.drawBitmap(paramBitmap, null, new Rect(0, 0, paramInt1, paramInt2), localPaint);
        return localBitmap2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        paramBitmap = localBitmap1;
      }
    } while (!QLog.isColorLevel());
    QLog.i("qqBaseActivity", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
    return localBitmap1;
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str2 = null;
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(paramString);
      str1 = str2;
      if (localFile != null)
      {
        str1 = str2;
        if (localFile.exists())
        {
          str2 = localFile.getParent() + "/dynamicAvatar_" + paramInt + "_" + System.currentTimeMillis() + ".mp4";
          str1 = str2;
          if (QLog.isColorLevel())
          {
            QLog.i("DynamicUtils", 2, "getDynamicAvatarCompressPath: sourcePath=" + paramString + "/n compressPath=" + str2);
            str1 = str2;
          }
        }
      }
    }
    return str1;
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    ThreadManager.post(new DynamicUtils.1(paramAppInterface, paramString, paramInt), 2, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    aywc localaywc = new aywc();
    localaywc.jdField_a_of_type_Boolean = true;
    localaywc.i = paramString;
    localaywc.jdField_a_of_type_Long = System.currentTimeMillis();
    localaywc.b = 48;
    paramQQAppInterface.a().a(localaywc);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    aywc localaywc = new aywc();
    localaywc.jdField_a_of_type_Boolean = true;
    localaywc.i = paramString;
    localaywc.jdField_a_of_type_Long = System.currentTimeMillis();
    localaywc.b = paramInt1;
    paramString = new lky();
    paramString.a(paramInt2);
    paramString.a(paramInt3);
    localaywc.jdField_a_of_type_ArrayOfByte = paramString.a();
    paramQQAppInterface.a().a(localaywc);
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DynamicUtils", 2, paramString);
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    boolean bool = true;
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {
      bool = false;
    }
    Calendar localCalendar1;
    Calendar localCalendar2;
    do
    {
      return bool;
      localCalendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08"));
      localCalendar1.setTimeInMillis(paramLong1);
      localCalendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08"));
      localCalendar2.setTimeInMillis(paramLong2);
    } while ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6)));
    return false;
  }
  
  private static String[] a(String paramString1, String paramString2, axlq paramaxlq)
  {
    String str1 = "1";
    if (ShortVideoTrimmer.a() >= 2) {
      str1 = "2";
    }
    String str2 = paramaxlq.c + "x" + String.valueOf(paramaxlq.d);
    a("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + paramaxlq.a, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-minrate", "300k", "-maxrate", "600k", "-bufsize", "800k", "-qmin", "1", "-qmax", String.valueOf(paramaxlq.e), "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
  }
  
  public static void b(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    paramAppInterface.reportClickEvent("dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alzk
 * JD-Core Version:    0.7.0.1
 */