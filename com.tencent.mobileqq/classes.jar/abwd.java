import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.system.Os;
import android.system.OsConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Vector;
import org.jetbrains.annotations.NotNull;

public class abwd
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long = a(0L);
  @Nullable
  private static volatile abwd jdField_a_of_type_Abwd;
  @Nullable
  private static volatile abwg jdField_a_of_type_Abwg;
  @NonNull
  private static abwj jdField_a_of_type_Abwj = new abwj();
  public static Vector<abwg> a;
  private static final String b;
  public static Vector<abwl> b;
  public String a;
  
  static
  {
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_b_of_type_JavaUtilVector = new Vector();
    jdField_a_of_type_Int = Process.myPid();
    jdField_b_of_type_JavaLangString = "^" + jdField_a_of_type_Int + "\\s+";
  }
  
  private abwd()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  @SuppressLint({"ObsoleteSdkInt"})
  public static long a(long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      try
      {
        long l2 = Os.sysconf(OsConstants._SC_PAGESIZE);
        l1 = l2;
        if (l2 <= 0L) {
          l1 = Os.sysconf(OsConstants._SC_PAGE_SIZE);
        }
      }
      catch (Exception localException)
      {
        l1 = 0L;
        continue;
      }
      if (l1 > 0L) {
        paramLong = l1;
      }
      return paramLong;
      long l1 = paramLong;
    }
  }
  
  @Nullable
  public static abwd a()
  {
    if (jdField_a_of_type_Abwd == null) {}
    try
    {
      if (jdField_a_of_type_Abwd == null) {
        jdField_a_of_type_Abwd = new abwd();
      }
      return jdField_a_of_type_Abwd;
    }
    finally {}
  }
  
  @NonNull
  private abwf a()
  {
    abwf localabwf = new abwf(this, null);
    try
    {
      long[] arrayOfLong = jdField_a_of_type_Abwj.a();
      if (arrayOfLong != null)
      {
        abwf.a(localabwf, arrayOfLong[0]);
        abwf.b(localabwf, arrayOfLong[1]);
        abwf.c(localabwf, arrayOfLong[2]);
        abwf.d(localabwf, arrayOfLong[4]);
      }
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MagnifierSDK_QAPM", 2, "collectStatInfo: Failed. info: exception: ", localException);
    }
    return localabwf;
    return localabwf;
  }
  
  /* Error */
  private ArrayList<Double> a(int paramInt)
  {
    // Byte code:
    //   0: dconst_0
    //   1: dstore_2
    //   2: invokestatic 148	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: ldc 150
    //   7: iconst_1
    //   8: anewarray 4	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: iload_1
    //   14: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: aastore
    //   18: invokestatic 162	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   21: invokevirtual 166	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   24: astore 17
    //   26: iconst_1
    //   27: istore 16
    //   29: getstatic 82	android/os/Build$VERSION:SDK_INT	I
    //   32: bipush 26
    //   34: if_icmplt +491 -> 525
    //   37: aload 17
    //   39: ldc2_w 167
    //   42: getstatic 174	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   45: invokevirtual 180	java/lang/Process:waitFor	(JLjava/util/concurrent/TimeUnit;)Z
    //   48: istore 16
    //   50: iload 16
    //   52: ifne +32 -> 84
    //   55: new 182	java/util/ArrayList
    //   58: dup
    //   59: iconst_2
    //   60: anewarray 184	java/lang/Double
    //   63: dup
    //   64: iconst_0
    //   65: dconst_0
    //   66: invokestatic 187	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: dconst_0
    //   73: invokestatic 187	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   76: aastore
    //   77: invokestatic 193	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   80: invokespecial 196	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   83: pop
    //   84: new 198	java/io/BufferedReader
    //   87: dup
    //   88: new 200	java/io/InputStreamReader
    //   91: dup
    //   92: aload 17
    //   94: invokevirtual 204	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   97: invokespecial 207	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   100: invokespecial 210	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   103: astore 17
    //   105: aload 17
    //   107: astore 18
    //   109: dload_2
    //   110: dstore 4
    //   112: dload_2
    //   113: dstore 6
    //   115: dload_2
    //   116: dstore 8
    //   118: ldc 212
    //   120: invokestatic 218	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   123: astore 28
    //   125: aload 17
    //   127: astore 18
    //   129: dload_2
    //   130: dstore 4
    //   132: dload_2
    //   133: dstore 6
    //   135: dload_2
    //   136: dstore 8
    //   138: getstatic 56	abwd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   141: invokestatic 218	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   144: astore 29
    //   146: ldc 220
    //   148: astore 19
    //   150: ldc 220
    //   152: astore 21
    //   154: ldc 220
    //   156: astore 22
    //   158: ldc 220
    //   160: astore 27
    //   162: ldc 220
    //   164: astore 20
    //   166: aload 17
    //   168: astore 18
    //   170: dload_2
    //   171: dstore 4
    //   173: dload_2
    //   174: dstore 6
    //   176: dload_2
    //   177: dstore 8
    //   179: aload 17
    //   181: invokevirtual 223	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   184: astore 23
    //   186: aload 23
    //   188: ifnull +415 -> 603
    //   191: aload 17
    //   193: astore 18
    //   195: dload_2
    //   196: dstore 4
    //   198: dload_2
    //   199: dstore 6
    //   201: dload_2
    //   202: dstore 8
    //   204: aload 23
    //   206: invokevirtual 226	java/lang/String:trim	()Ljava/lang/String;
    //   209: astore 30
    //   211: aload 17
    //   213: astore 18
    //   215: dload_2
    //   216: dstore 4
    //   218: dload_2
    //   219: dstore 6
    //   221: dload_2
    //   222: dstore 8
    //   224: aload 30
    //   226: ldc 228
    //   228: invokevirtual 232	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   231: istore_1
    //   232: aload 27
    //   234: astore 25
    //   236: aload 22
    //   238: astore 26
    //   240: aload 21
    //   242: astore 24
    //   244: aload 19
    //   246: astore 23
    //   248: iload_1
    //   249: iconst_m1
    //   250: if_icmpeq +189 -> 439
    //   253: aload 17
    //   255: astore 18
    //   257: dload_2
    //   258: dstore 4
    //   260: dload_2
    //   261: dstore 6
    //   263: dload_2
    //   264: dstore 8
    //   266: aload 30
    //   268: iconst_0
    //   269: iload_1
    //   270: invokevirtual 236	java/lang/String:substring	(II)Ljava/lang/String;
    //   273: astore 27
    //   275: aload 17
    //   277: astore 18
    //   279: dload_2
    //   280: dstore 4
    //   282: dload_2
    //   283: dstore 6
    //   285: dload_2
    //   286: dstore 8
    //   288: aload 28
    //   290: aload 30
    //   292: invokevirtual 240	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   295: astore 31
    //   297: aload 27
    //   299: astore 25
    //   301: aload 22
    //   303: astore 26
    //   305: aload 21
    //   307: astore 24
    //   309: aload 19
    //   311: astore 23
    //   313: aload 17
    //   315: astore 18
    //   317: dload_2
    //   318: dstore 4
    //   320: dload_2
    //   321: dstore 6
    //   323: dload_2
    //   324: dstore 8
    //   326: aload 31
    //   328: invokevirtual 245	java/util/regex/Matcher:find	()Z
    //   331: ifeq +108 -> 439
    //   334: aload 27
    //   336: astore 25
    //   338: aload 22
    //   340: astore 26
    //   342: aload 21
    //   344: astore 24
    //   346: aload 19
    //   348: astore 23
    //   350: aload 17
    //   352: astore 18
    //   354: dload_2
    //   355: dstore 4
    //   357: dload_2
    //   358: dstore 6
    //   360: dload_2
    //   361: dstore 8
    //   363: aload 31
    //   365: invokevirtual 248	java/util/regex/Matcher:groupCount	()I
    //   368: iconst_3
    //   369: if_icmpne +70 -> 439
    //   372: aload 17
    //   374: astore 18
    //   376: dload_2
    //   377: dstore 4
    //   379: dload_2
    //   380: dstore 6
    //   382: dload_2
    //   383: dstore 8
    //   385: aload 31
    //   387: iconst_1
    //   388: invokevirtual 252	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   391: astore 23
    //   393: aload 17
    //   395: astore 18
    //   397: dload_2
    //   398: dstore 4
    //   400: dload_2
    //   401: dstore 6
    //   403: dload_2
    //   404: dstore 8
    //   406: aload 31
    //   408: iconst_2
    //   409: invokevirtual 252	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   412: astore 24
    //   414: aload 17
    //   416: astore 18
    //   418: dload_2
    //   419: dstore 4
    //   421: dload_2
    //   422: dstore 6
    //   424: dload_2
    //   425: dstore 8
    //   427: aload 31
    //   429: iconst_3
    //   430: invokevirtual 252	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   433: astore 26
    //   435: aload 27
    //   437: astore 25
    //   439: aload 25
    //   441: astore 27
    //   443: aload 26
    //   445: astore 22
    //   447: aload 24
    //   449: astore 21
    //   451: aload 23
    //   453: astore 19
    //   455: aload 17
    //   457: astore 18
    //   459: dload_2
    //   460: dstore 4
    //   462: dload_2
    //   463: dstore 6
    //   465: dload_2
    //   466: dstore 8
    //   468: aload 29
    //   470: aload 30
    //   472: invokevirtual 240	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   475: invokevirtual 245	java/util/regex/Matcher:find	()Z
    //   478: ifeq -312 -> 166
    //   481: aload 17
    //   483: astore 18
    //   485: dload_2
    //   486: dstore 4
    //   488: dload_2
    //   489: dstore 6
    //   491: dload_2
    //   492: dstore 8
    //   494: aload 30
    //   496: ldc 50
    //   498: invokevirtual 256	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   501: bipush 8
    //   503: aaload
    //   504: astore 20
    //   506: aload 25
    //   508: astore 27
    //   510: aload 26
    //   512: astore 22
    //   514: aload 24
    //   516: astore 21
    //   518: aload 23
    //   520: astore 19
    //   522: goto -356 -> 166
    //   525: aload 17
    //   527: invokevirtual 258	java/lang/Process:waitFor	()I
    //   530: pop
    //   531: goto -481 -> 50
    //   534: astore 18
    //   536: dconst_0
    //   537: dstore_2
    //   538: aconst_null
    //   539: astore 17
    //   541: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq +13 -> 557
    //   547: ldc 129
    //   549: iconst_2
    //   550: ldc 131
    //   552: aload 18
    //   554: invokestatic 135	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   557: dload_2
    //   558: dstore 4
    //   560: aload 17
    //   562: ifnull +496 -> 1058
    //   565: aload 17
    //   567: invokevirtual 261	java/io/BufferedReader:close	()V
    //   570: dconst_0
    //   571: dstore 4
    //   573: new 182	java/util/ArrayList
    //   576: dup
    //   577: iconst_2
    //   578: anewarray 184	java/lang/Double
    //   581: dup
    //   582: iconst_0
    //   583: dload_2
    //   584: invokestatic 187	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   587: aastore
    //   588: dup
    //   589: iconst_1
    //   590: dload 4
    //   592: invokestatic 187	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   595: aastore
    //   596: invokestatic 193	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   599: invokespecial 196	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   602: areturn
    //   603: aload 17
    //   605: astore 18
    //   607: dload_2
    //   608: dstore 4
    //   610: dload_2
    //   611: dstore 6
    //   613: dload_2
    //   614: dstore 8
    //   616: aload 19
    //   618: invokestatic 264	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   621: invokevirtual 268	java/lang/Double:doubleValue	()D
    //   624: dstore 10
    //   626: aload 17
    //   628: astore 18
    //   630: dload_2
    //   631: dstore 4
    //   633: dload_2
    //   634: dstore 6
    //   636: dload_2
    //   637: dstore 8
    //   639: aload 21
    //   641: invokestatic 264	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   644: invokevirtual 268	java/lang/Double:doubleValue	()D
    //   647: dstore 12
    //   649: aload 17
    //   651: astore 18
    //   653: dload_2
    //   654: dstore 4
    //   656: dload_2
    //   657: dstore 6
    //   659: dload_2
    //   660: dstore 8
    //   662: aload 22
    //   664: invokestatic 264	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   667: invokevirtual 268	java/lang/Double:doubleValue	()D
    //   670: dstore 14
    //   672: aload 17
    //   674: astore 18
    //   676: dload_2
    //   677: dstore 4
    //   679: dload_2
    //   680: dstore 6
    //   682: dload_2
    //   683: dstore 8
    //   685: aload 27
    //   687: invokestatic 264	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   690: invokevirtual 268	java/lang/Double:doubleValue	()D
    //   693: dstore_2
    //   694: aload 17
    //   696: astore 18
    //   698: dload_2
    //   699: dstore 4
    //   701: dload_2
    //   702: dstore 6
    //   704: dload_2
    //   705: dstore 8
    //   707: dload 12
    //   709: dload 10
    //   711: dadd
    //   712: dload 14
    //   714: dadd
    //   715: dload_2
    //   716: ddiv
    //   717: dstore_2
    //   718: aload 17
    //   720: astore 18
    //   722: dload_2
    //   723: dstore 4
    //   725: dload_2
    //   726: dstore 6
    //   728: dload_2
    //   729: dstore 8
    //   731: aload 20
    //   733: invokestatic 264	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   736: invokevirtual 268	java/lang/Double:doubleValue	()D
    //   739: dstore 10
    //   741: aload 17
    //   743: astore 18
    //   745: dload_2
    //   746: dstore 4
    //   748: dload_2
    //   749: dstore 6
    //   751: dload_2
    //   752: dstore 8
    //   754: aload 27
    //   756: invokestatic 264	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   759: invokevirtual 268	java/lang/Double:doubleValue	()D
    //   762: dstore 12
    //   764: dload 10
    //   766: dload 12
    //   768: ddiv
    //   769: dstore 4
    //   771: aload 17
    //   773: ifnull +294 -> 1067
    //   776: aload 17
    //   778: invokevirtual 261	java/io/BufferedReader:close	()V
    //   781: goto -208 -> 573
    //   784: astore 17
    //   786: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   789: ifeq +13 -> 802
    //   792: ldc 129
    //   794: iconst_2
    //   795: ldc 131
    //   797: aload 17
    //   799: invokestatic 135	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   802: goto -229 -> 573
    //   805: astore 17
    //   807: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   810: ifeq +13 -> 823
    //   813: ldc 129
    //   815: iconst_2
    //   816: ldc 131
    //   818: aload 17
    //   820: invokestatic 135	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   823: dconst_0
    //   824: dstore 4
    //   826: goto -253 -> 573
    //   829: astore 19
    //   831: aconst_null
    //   832: astore 17
    //   834: dconst_0
    //   835: dstore_2
    //   836: aload 17
    //   838: astore 18
    //   840: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: ifeq +17 -> 860
    //   846: aload 17
    //   848: astore 18
    //   850: ldc 129
    //   852: iconst_2
    //   853: ldc 131
    //   855: aload 19
    //   857: invokestatic 135	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   860: dload_2
    //   861: dstore 4
    //   863: aload 17
    //   865: ifnull +193 -> 1058
    //   868: aload 17
    //   870: invokevirtual 261	java/io/BufferedReader:close	()V
    //   873: dconst_0
    //   874: dstore 4
    //   876: goto -303 -> 573
    //   879: astore 17
    //   881: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   884: ifeq +13 -> 897
    //   887: ldc 129
    //   889: iconst_2
    //   890: ldc 131
    //   892: aload 17
    //   894: invokestatic 135	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   897: dconst_0
    //   898: dstore 4
    //   900: goto -327 -> 573
    //   903: astore 19
    //   905: aconst_null
    //   906: astore 17
    //   908: dconst_0
    //   909: dstore_2
    //   910: aload 17
    //   912: astore 18
    //   914: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   917: ifeq +17 -> 934
    //   920: aload 17
    //   922: astore 18
    //   924: ldc 129
    //   926: iconst_2
    //   927: ldc 131
    //   929: aload 19
    //   931: invokestatic 135	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   934: dload_2
    //   935: dstore 4
    //   937: aload 17
    //   939: ifnull +119 -> 1058
    //   942: aload 17
    //   944: invokevirtual 261	java/io/BufferedReader:close	()V
    //   947: dconst_0
    //   948: dstore 4
    //   950: goto -377 -> 573
    //   953: astore 17
    //   955: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   958: ifeq +13 -> 971
    //   961: ldc 129
    //   963: iconst_2
    //   964: ldc 131
    //   966: aload 17
    //   968: invokestatic 135	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   971: dconst_0
    //   972: dstore 4
    //   974: goto -401 -> 573
    //   977: astore 17
    //   979: aconst_null
    //   980: astore 18
    //   982: aload 18
    //   984: ifnull +8 -> 992
    //   987: aload 18
    //   989: invokevirtual 261	java/io/BufferedReader:close	()V
    //   992: aload 17
    //   994: athrow
    //   995: astore 18
    //   997: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1000: ifeq -8 -> 992
    //   1003: ldc 129
    //   1005: iconst_2
    //   1006: ldc 131
    //   1008: aload 18
    //   1010: invokestatic 135	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1013: goto -21 -> 992
    //   1016: astore 17
    //   1018: goto -36 -> 982
    //   1021: astore 19
    //   1023: aload 17
    //   1025: astore 18
    //   1027: aload 19
    //   1029: astore 17
    //   1031: goto -49 -> 982
    //   1034: astore 19
    //   1036: dload 4
    //   1038: dstore_2
    //   1039: goto -129 -> 910
    //   1042: astore 19
    //   1044: dload 6
    //   1046: dstore_2
    //   1047: goto -211 -> 836
    //   1050: astore 18
    //   1052: dload 8
    //   1054: dstore_2
    //   1055: goto -514 -> 541
    //   1058: dload 4
    //   1060: dstore_2
    //   1061: dconst_0
    //   1062: dstore 4
    //   1064: goto -491 -> 573
    //   1067: goto -494 -> 573
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1070	0	this	abwd
    //   0	1070	1	paramInt	int
    //   1	1060	2	d1	double
    //   110	953	4	d2	double
    //   113	932	6	d3	double
    //   116	937	8	d4	double
    //   624	141	10	d5	double
    //   647	120	12	d6	double
    //   670	43	14	d7	double
    //   27	24	16	bool	boolean
    //   24	753	17	localObject1	Object
    //   784	14	17	localException1	Exception
    //   805	14	17	localException2	Exception
    //   832	37	17	localObject2	Object
    //   879	14	17	localException3	Exception
    //   906	37	17	localObject3	Object
    //   953	14	17	localException4	Exception
    //   977	16	17	localObject4	Object
    //   1016	8	17	localObject5	Object
    //   1029	1	17	localObject6	Object
    //   107	377	18	localObject7	Object
    //   534	19	18	localInterruptedException1	java.lang.InterruptedException
    //   605	383	18	localObject8	Object
    //   995	14	18	localException5	Exception
    //   1025	1	18	localObject9	Object
    //   1050	1	18	localInterruptedException2	java.lang.InterruptedException
    //   148	469	19	localObject10	Object
    //   829	27	19	localIOException1	java.io.IOException
    //   903	27	19	localNumberFormatException1	java.lang.NumberFormatException
    //   1021	7	19	localObject11	Object
    //   1034	1	19	localNumberFormatException2	java.lang.NumberFormatException
    //   1042	1	19	localIOException2	java.io.IOException
    //   164	568	20	str1	String
    //   152	488	21	localObject12	Object
    //   156	507	22	localObject13	Object
    //   184	335	23	localObject14	Object
    //   242	273	24	localObject15	Object
    //   234	273	25	localObject16	Object
    //   238	273	26	localObject17	Object
    //   160	595	27	localObject18	Object
    //   123	166	28	localPattern1	java.util.regex.Pattern
    //   144	325	29	localPattern2	java.util.regex.Pattern
    //   209	286	30	str2	String
    //   295	133	31	localMatcher	java.util.regex.Matcher
    // Exception table:
    //   from	to	target	type
    //   2	26	534	java/lang/InterruptedException
    //   29	50	534	java/lang/InterruptedException
    //   55	84	534	java/lang/InterruptedException
    //   84	105	534	java/lang/InterruptedException
    //   525	531	534	java/lang/InterruptedException
    //   776	781	784	java/lang/Exception
    //   565	570	805	java/lang/Exception
    //   2	26	829	java/io/IOException
    //   29	50	829	java/io/IOException
    //   55	84	829	java/io/IOException
    //   84	105	829	java/io/IOException
    //   525	531	829	java/io/IOException
    //   868	873	879	java/lang/Exception
    //   2	26	903	java/lang/NumberFormatException
    //   29	50	903	java/lang/NumberFormatException
    //   55	84	903	java/lang/NumberFormatException
    //   84	105	903	java/lang/NumberFormatException
    //   525	531	903	java/lang/NumberFormatException
    //   942	947	953	java/lang/Exception
    //   2	26	977	finally
    //   29	50	977	finally
    //   55	84	977	finally
    //   84	105	977	finally
    //   525	531	977	finally
    //   987	992	995	java/lang/Exception
    //   118	125	1016	finally
    //   138	146	1016	finally
    //   179	186	1016	finally
    //   204	211	1016	finally
    //   224	232	1016	finally
    //   266	275	1016	finally
    //   288	297	1016	finally
    //   326	334	1016	finally
    //   363	372	1016	finally
    //   385	393	1016	finally
    //   406	414	1016	finally
    //   427	435	1016	finally
    //   468	481	1016	finally
    //   494	506	1016	finally
    //   616	626	1016	finally
    //   639	649	1016	finally
    //   662	672	1016	finally
    //   685	694	1016	finally
    //   707	718	1016	finally
    //   731	741	1016	finally
    //   754	764	1016	finally
    //   840	846	1016	finally
    //   850	860	1016	finally
    //   914	920	1016	finally
    //   924	934	1016	finally
    //   541	557	1021	finally
    //   118	125	1034	java/lang/NumberFormatException
    //   138	146	1034	java/lang/NumberFormatException
    //   179	186	1034	java/lang/NumberFormatException
    //   204	211	1034	java/lang/NumberFormatException
    //   224	232	1034	java/lang/NumberFormatException
    //   266	275	1034	java/lang/NumberFormatException
    //   288	297	1034	java/lang/NumberFormatException
    //   326	334	1034	java/lang/NumberFormatException
    //   363	372	1034	java/lang/NumberFormatException
    //   385	393	1034	java/lang/NumberFormatException
    //   406	414	1034	java/lang/NumberFormatException
    //   427	435	1034	java/lang/NumberFormatException
    //   468	481	1034	java/lang/NumberFormatException
    //   494	506	1034	java/lang/NumberFormatException
    //   616	626	1034	java/lang/NumberFormatException
    //   639	649	1034	java/lang/NumberFormatException
    //   662	672	1034	java/lang/NumberFormatException
    //   685	694	1034	java/lang/NumberFormatException
    //   707	718	1034	java/lang/NumberFormatException
    //   731	741	1034	java/lang/NumberFormatException
    //   754	764	1034	java/lang/NumberFormatException
    //   118	125	1042	java/io/IOException
    //   138	146	1042	java/io/IOException
    //   179	186	1042	java/io/IOException
    //   204	211	1042	java/io/IOException
    //   224	232	1042	java/io/IOException
    //   266	275	1042	java/io/IOException
    //   288	297	1042	java/io/IOException
    //   326	334	1042	java/io/IOException
    //   363	372	1042	java/io/IOException
    //   385	393	1042	java/io/IOException
    //   406	414	1042	java/io/IOException
    //   427	435	1042	java/io/IOException
    //   468	481	1042	java/io/IOException
    //   494	506	1042	java/io/IOException
    //   616	626	1042	java/io/IOException
    //   639	649	1042	java/io/IOException
    //   662	672	1042	java/io/IOException
    //   685	694	1042	java/io/IOException
    //   707	718	1042	java/io/IOException
    //   731	741	1042	java/io/IOException
    //   754	764	1042	java/io/IOException
    //   118	125	1050	java/lang/InterruptedException
    //   138	146	1050	java/lang/InterruptedException
    //   179	186	1050	java/lang/InterruptedException
    //   204	211	1050	java/lang/InterruptedException
    //   224	232	1050	java/lang/InterruptedException
    //   266	275	1050	java/lang/InterruptedException
    //   288	297	1050	java/lang/InterruptedException
    //   326	334	1050	java/lang/InterruptedException
    //   363	372	1050	java/lang/InterruptedException
    //   385	393	1050	java/lang/InterruptedException
    //   406	414	1050	java/lang/InterruptedException
    //   427	435	1050	java/lang/InterruptedException
    //   468	481	1050	java/lang/InterruptedException
    //   494	506	1050	java/lang/InterruptedException
    //   616	626	1050	java/lang/InterruptedException
    //   639	649	1050	java/lang/InterruptedException
    //   662	672	1050	java/lang/InterruptedException
    //   685	694	1050	java/lang/InterruptedException
    //   707	718	1050	java/lang/InterruptedException
    //   731	741	1050	java/lang/InterruptedException
    //   754	764	1050	java/lang/InterruptedException
  }
  
  @NotNull
  private abwg b()
  {
    abwg localabwg = new abwg();
    localabwg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localabwg.f = System.currentTimeMillis();
    localabwg.jdField_a_of_type_Long = (localabwg.f / 1000L);
    Object localObject = a();
    long l1;
    label84:
    label106:
    double d;
    if (abwf.a((abwf)localObject) > 0L)
    {
      l1 = abwf.a((abwf)localObject);
      localabwg.c = l1;
      if (abwf.b((abwf)localObject) <= 0L) {
        break label385;
      }
      l1 = abwf.b((abwf)localObject);
      localabwg.d = l1;
      if (abwf.c((abwf)localObject) <= 0L) {
        break label392;
      }
      l1 = abwf.c((abwf)localObject);
      localabwg.e = l1;
      if ((jdField_a_of_type_Long == 0L) || (abwf.d((abwf)localObject) == 9223372036854775807L)) {
        break label399;
      }
      l1 = abwf.d((abwf)localObject) * jdField_a_of_type_Long;
      label142:
      localabwg.jdField_b_of_type_Long = l1;
      if (jdField_a_of_type_Abwg == null) {
        break label462;
      }
      jdField_a_of_type_Abwg.f = localabwg.f;
      jdField_a_of_type_Abwg.jdField_a_of_type_Long = localabwg.jdField_a_of_type_Long;
      if ((jdField_a_of_type_Abwg.c == 9223372036854775807L) || (jdField_a_of_type_Abwg.d == 9223372036854775807L) || (jdField_a_of_type_Abwg.e == 9223372036854775807L)) {
        break label416;
      }
      l1 = localabwg.c;
      long l2 = jdField_a_of_type_Abwg.c;
      long l3 = localabwg.d - jdField_a_of_type_Abwg.d;
      long l4 = localabwg.e;
      long l5 = jdField_a_of_type_Abwg.e;
      if (l3 > 0L)
      {
        localabwg.jdField_a_of_type_Double = ((l1 - l2) * 1.0D / l3);
        localabwg.jdField_b_of_type_Double = (1.0D * (l4 - l5) / l3);
      }
      if (localabwg.jdField_a_of_type_Double <= 0.0D) {
        break label406;
      }
      d = localabwg.jdField_a_of_type_Double;
      label314:
      localabwg.jdField_a_of_type_Double = d;
      if (localabwg.jdField_b_of_type_Double <= 0.0D) {
        break label411;
      }
      d = localabwg.jdField_b_of_type_Double;
      label336:
      localabwg.jdField_b_of_type_Double = d;
    }
    for (;;)
    {
      jdField_a_of_type_Abwg.c = localabwg.c;
      jdField_a_of_type_Abwg.d = localabwg.d;
      jdField_a_of_type_Abwg.e = localabwg.e;
      return localabwg;
      l1 = 9223372036854775807L;
      break;
      label385:
      l1 = 9223372036854775807L;
      break label84;
      label392:
      l1 = 9223372036854775807L;
      break label106;
      label399:
      l1 = 9223372036854775807L;
      break label142;
      label406:
      d = 0.0D;
      break label314;
      label411:
      d = 0.0D;
      break label336;
      label416:
      localObject = a(jdField_a_of_type_Int);
      localabwg.jdField_b_of_type_Double = ((Double)((ArrayList)localObject).get(0)).doubleValue();
      localabwg.jdField_a_of_type_Double = ((Double)((ArrayList)localObject).get(1)).doubleValue();
    }
    label462:
    jdField_a_of_type_Abwg = new abwg();
    jdField_a_of_type_Abwg.f = localabwg.f;
    jdField_a_of_type_Abwg.jdField_a_of_type_Long = localabwg.jdField_a_of_type_Long;
    jdField_a_of_type_Abwg.c = localabwg.c;
    jdField_a_of_type_Abwg.d = localabwg.d;
    jdField_a_of_type_Abwg.e = localabwg.e;
    localabwg.jdField_a_of_type_Double = 0.0D;
    localabwg.jdField_b_of_type_Double = 0.0D;
    return localabwg;
  }
  
  public abwg a()
  {
    abwg localabwg = b();
    if (localabwg != null) {
      jdField_a_of_type_JavaUtilVector.add(localabwg);
    }
    return localabwg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwd
 * JD-Core Version:    0.7.0.1
 */