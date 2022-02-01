import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class agbb
{
  private static volatile agbb jdField_a_of_type_Agbb;
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + "eggs.xml";
  public static final String c = jdField_a_of_type_JavaLangString + "eggs_wrapper.xml";
  private ArrayList<agbe> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    jdField_a_of_type_JavaLangString = localBaseApplication.getFilesDir().getAbsoluteFile() + File.separator + "animConfig/";
  }
  
  public static agbb a()
  {
    if (jdField_a_of_type_Agbb == null) {}
    try
    {
      if (jdField_a_of_type_Agbb == null) {
        jdField_a_of_type_Agbb = new agbb();
      }
      return jdField_a_of_type_Agbb;
    }
    finally {}
  }
  
  @Nullable
  private agbe a(ArrayList<agbe> paramArrayList, int paramInt)
  {
    if ((paramInt < 0) || (bgnk.a(paramArrayList))) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      agbe localagbe = (agbe)paramArrayList.next();
      if (localagbe.jdField_a_of_type_Int == paramInt) {
        return localagbe;
      }
    }
    return null;
  }
  
  private ArrayList<agbe> a(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    int i = paramXmlPullParser.getEventType();
    Object localObject1 = null;
    Object localObject4 = null;
    String str1;
    Object localObject3;
    Object localObject2;
    label398:
    String str2;
    if (i != 1) {
      if (i == 2)
      {
        str1 = paramXmlPullParser.getName();
        if (str1.equalsIgnoreCase("Item"))
        {
          localObject3 = paramXmlPullParser.getAttributeValue(null, "id");
          localObject2 = new agbe();
          ((agbe)localObject2).jdField_a_of_type_Int = Integer.valueOf((String)localObject3).intValue();
          localObject3 = localObject1;
        }
        for (;;)
        {
          i = paramXmlPullParser.next();
          localObject4 = localObject2;
          localObject1 = localObject3;
          break;
          if (str1.equalsIgnoreCase("Keywords"))
          {
            str1 = paramXmlPullParser.nextText();
            localObject2 = localObject4;
            localObject3 = localObject1;
            if (localObject4 != null)
            {
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (!TextUtils.isEmpty(str1))
              {
                if (localObject4.jdField_a_of_type_JavaUtilArrayList == null) {
                  localObject4.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                }
                localObject4.jdField_a_of_type_JavaUtilArrayList.add(str1);
                localObject2 = localObject4;
                localObject3 = localObject1;
              }
            }
          }
          else if (str1.equalsIgnoreCase("FloorLimit"))
          {
            str1 = paramXmlPullParser.nextText();
            localObject2 = localObject4;
            localObject3 = localObject1;
            if (localObject4 != null)
            {
              localObject4.c = Integer.valueOf(str1).intValue();
              localObject2 = localObject4;
              localObject3 = localObject1;
            }
          }
          else if (str1.equalsIgnoreCase("JumpLimit"))
          {
            str1 = paramXmlPullParser.nextText();
            localObject2 = localObject4;
            localObject3 = localObject1;
            if (localObject4 != null)
            {
              localObject4.d = Integer.valueOf(str1).intValue();
              localObject2 = localObject4;
              localObject3 = localObject1;
            }
          }
          else
          {
            if (!str1.equalsIgnoreCase("IsCrazyMode")) {
              break label398;
            }
            str1 = paramXmlPullParser.nextText();
            localObject2 = localObject4;
            localObject3 = localObject1;
            if (localObject4 != null) {
              if (str1.equalsIgnoreCase("true"))
              {
                localObject4.jdField_a_of_type_Boolean = true;
                localObject2 = localObject4;
                localObject3 = localObject1;
              }
              else
              {
                localObject2 = localObject4;
                localObject3 = localObject1;
                if (str1.equalsIgnoreCase("false"))
                {
                  localObject4.jdField_a_of_type_Boolean = false;
                  localObject2 = localObject4;
                  localObject3 = localObject1;
                }
              }
            }
          }
        }
        if (str1.equalsIgnoreCase("JumpImage"))
        {
          str1 = paramXmlPullParser.getAttributeValue(null, "type");
          localObject2 = paramXmlPullParser.getAttributeValue(null, "count");
          str2 = paramXmlPullParser.nextText();
          if (localObject2 == null) {
            break label941;
          }
          i = Integer.valueOf((String)localObject2).intValue();
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (i <= 0) {
        break;
      }
      localObject2 = new agbg();
      if (str1 != null) {
        ((agbg)localObject2).c = agbg.a(str1);
      }
      ((agbg)localObject2).jdField_a_of_type_JavaLangString = str2;
      if (localObject4 != null)
      {
        if (localObject4.b == null) {
          localObject4.b = new ArrayList();
        }
        localObject4.b.add(localObject2);
      }
      i -= 1;
      continue;
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (!str1.equalsIgnoreCase("businessData")) {
        break;
      }
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (localObject4 == null) {
        break;
      }
      localObject4.jdField_a_of_type_Agbf = new agbf();
      localObject2 = paramXmlPullParser.getAttributeValue(null, "bid");
      localObject3 = paramXmlPullParser.getAttributeValue(null, "startTs");
      str1 = paramXmlPullParser.getAttributeValue(null, "endTs");
      str2 = paramXmlPullParser.getAttributeValue(null, "actId");
      String str3 = paramXmlPullParser.getAttributeValue(null, "timeDelay");
      localObject4.jdField_a_of_type_Agbf.jdField_a_of_type_Int = Integer.parseInt((String)localObject2);
      localObject4.jdField_a_of_type_Agbf.b = Integer.parseInt((String)localObject3);
      localObject4.jdField_a_of_type_Agbf.c = Integer.parseInt(str1);
      localObject4.jdField_a_of_type_Agbf.e = Integer.parseInt(str3);
      localObject4.jdField_a_of_type_Agbf.d = Integer.parseInt(str2);
      localObject2 = localObject4;
      localObject3 = localObject1;
      break;
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (i != 3) {
        break;
      }
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (!paramXmlPullParser.getName().equalsIgnoreCase("Item")) {
        break;
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new ArrayList();
      }
      boolean bool;
      if (localObject4 != null)
      {
        if ((localObject4.c != 0) || (localObject4.d != 0)) {
          break label869;
        }
        bool = true;
      }
      for (;;)
      {
        if (bool) {
          ((ArrayList)localObject3).add(localObject4);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationConfigHelper", 2, "<== Item, id = " + localObject4.jdField_a_of_type_Int + ",isValid = " + bool + "keywords:" + localObject4.jdField_a_of_type_JavaUtilArrayList.toString());
        }
        localObject2 = null;
        break;
        label869:
        if (localObject4.d > localObject4.c)
        {
          bool = true;
          continue;
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationConfigHelper", 2, "doParseRules :  cost time:" + (l2 - l1) + "ms");
          }
          return localObject1;
        }
        else
        {
          bool = false;
        }
      }
      label941:
      i = 1;
    }
  }
  
  private void a(XmlPullParser paramXmlPullParser, ArrayList<agbe> paramArrayList)
  {
    if (paramXmlPullParser == null) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = SystemClock.elapsedRealtime();
      int k = paramXmlPullParser.getEventType();
      int j = -1;
      Object localObject2 = "";
      int n = 0;
      if (k != 1)
      {
        Object localObject3;
        int m;
        Object localObject1;
        int i;
        if (k == 2)
        {
          localObject3 = paramXmlPullParser.getName();
          if (((String)localObject3).equalsIgnoreCase("Item"))
          {
            m = Integer.valueOf(paramXmlPullParser.getAttributeValue(null, "id")).intValue();
            localObject1 = "";
            i = 0;
          }
        }
        for (;;)
        {
          k = paramXmlPullParser.next();
          n = i;
          localObject2 = localObject1;
          j = m;
          break;
          if (((String)localObject3).equalsIgnoreCase("JumpUrl"))
          {
            localObject1 = paramXmlPullParser.nextText();
            i = n;
            m = j;
          }
          else
          {
            i = n;
            localObject1 = localObject2;
            m = j;
            if (((String)localObject3).equalsIgnoreCase("LargeCount"))
            {
              i = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
              localObject1 = localObject2;
              m = j;
              continue;
              i = n;
              localObject1 = localObject2;
              m = j;
              if (k == 3)
              {
                i = n;
                localObject1 = localObject2;
                m = j;
                if (paramXmlPullParser.getName().equalsIgnoreCase("Item"))
                {
                  localObject3 = a(paramArrayList, j);
                  i = n;
                  localObject1 = localObject2;
                  m = j;
                  if (localObject3 != null)
                  {
                    ((agbe)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
                    ((agbe)localObject3).a(n);
                    i = n;
                    localObject1 = localObject2;
                    m = j;
                  }
                }
              }
            }
          }
        }
      }
      l2 = SystemClock.elapsedRealtime();
    } while (!QLog.isColorLevel());
    QLog.d("AioAnimationConfigHelper", 2, "doParseRulesWrapper :  cost time:" + (l2 - l1) + "ms");
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aload 5
    //   10: astore_2
    //   11: new 32	java/io/File
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 282	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload 5
    //   22: astore_2
    //   23: aload_1
    //   24: invokevirtual 285	java/io/File:exists	()Z
    //   27: ifeq +13 -> 40
    //   30: aload 5
    //   32: astore_2
    //   33: aload_1
    //   34: invokevirtual 288	java/io/File:isFile	()Z
    //   37: ifne +58 -> 95
    //   40: aload 5
    //   42: astore_2
    //   43: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +35 -> 81
    //   49: aload 5
    //   51: astore_2
    //   52: ldc 228
    //   54: iconst_2
    //   55: new 21	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   62: ldc_w 290
    //   65: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 293	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   72: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: iconst_0
    //   82: ifeq +11 -> 93
    //   85: new 297	java/lang/NullPointerException
    //   88: dup
    //   89: invokespecial 298	java/lang/NullPointerException:<init>	()V
    //   92: athrow
    //   93: iconst_0
    //   94: ireturn
    //   95: aload 5
    //   97: astore_2
    //   98: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +35 -> 136
    //   104: aload 5
    //   106: astore_2
    //   107: ldc 228
    //   109: iconst_2
    //   110: new 21	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 300
    //   120: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_1
    //   124: invokevirtual 293	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   127: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: aload 5
    //   138: astore_2
    //   139: new 302	java/io/FileInputStream
    //   142: dup
    //   143: aload_1
    //   144: invokespecial 305	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   147: astore_1
    //   148: invokestatic 311	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   151: invokevirtual 315	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   154: astore_2
    //   155: aload_2
    //   156: aload_1
    //   157: ldc_w 317
    //   160: invokeinterface 321 3 0
    //   165: aload_0
    //   166: aload_2
    //   167: invokespecial 323	agbb:a	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/ArrayList;
    //   170: astore_2
    //   171: aload_1
    //   172: ifnull +7 -> 179
    //   175: aload_1
    //   176: invokevirtual 326	java/io/FileInputStream:close	()V
    //   179: aload_2
    //   180: ifnull -87 -> 93
    //   183: aload_0
    //   184: aload_2
    //   185: putfield 327	agbb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   188: aload_0
    //   189: getstatic 61	agbb:c	Ljava/lang/String;
    //   192: aload_0
    //   193: getfield 327	agbb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   196: invokespecial 330	agbb:a	(Ljava/lang/String;Ljava/util/ArrayList;)Z
    //   199: pop
    //   200: iconst_1
    //   201: ireturn
    //   202: astore_3
    //   203: aload 4
    //   205: astore_1
    //   206: aload_1
    //   207: astore_2
    //   208: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +15 -> 226
    //   214: aload_1
    //   215: astore_2
    //   216: ldc 228
    //   218: iconst_2
    //   219: ldc_w 332
    //   222: aload_3
    //   223: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_1
    //   227: ifnull -134 -> 93
    //   230: aload_1
    //   231: invokevirtual 326	java/io/FileInputStream:close	()V
    //   234: iconst_0
    //   235: ireturn
    //   236: astore_1
    //   237: iconst_0
    //   238: ireturn
    //   239: astore_2
    //   240: aload_3
    //   241: astore_1
    //   242: aload_2
    //   243: astore_3
    //   244: aload_1
    //   245: astore_2
    //   246: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +15 -> 264
    //   252: aload_1
    //   253: astore_2
    //   254: ldc 228
    //   256: iconst_2
    //   257: ldc_w 332
    //   260: aload_3
    //   261: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   264: aload_1
    //   265: ifnull -172 -> 93
    //   268: aload_1
    //   269: invokevirtual 326	java/io/FileInputStream:close	()V
    //   272: iconst_0
    //   273: ireturn
    //   274: astore_1
    //   275: iconst_0
    //   276: ireturn
    //   277: astore_1
    //   278: aload_2
    //   279: ifnull +7 -> 286
    //   282: aload_2
    //   283: invokevirtual 326	java/io/FileInputStream:close	()V
    //   286: aload_1
    //   287: athrow
    //   288: astore_1
    //   289: iconst_0
    //   290: ireturn
    //   291: astore_1
    //   292: goto -113 -> 179
    //   295: astore_2
    //   296: goto -10 -> 286
    //   299: astore_3
    //   300: aload_1
    //   301: astore_2
    //   302: aload_3
    //   303: astore_1
    //   304: goto -26 -> 278
    //   307: astore_3
    //   308: goto -64 -> 244
    //   311: astore_3
    //   312: goto -106 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	agbb
    //   0	315	1	paramString	String
    //   10	206	2	localObject1	Object
    //   239	4	2	localOutOfMemoryError1	OutOfMemoryError
    //   245	38	2	str1	String
    //   295	1	2	localIOException	java.io.IOException
    //   301	1	2	str2	String
    //   1	1	3	localObject2	Object
    //   202	39	3	localException1	Exception
    //   243	18	3	localObject3	Object
    //   299	4	3	localObject4	Object
    //   307	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   311	1	3	localException2	Exception
    //   6	198	4	localObject5	Object
    //   3	134	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   11	20	202	java/lang/Exception
    //   23	30	202	java/lang/Exception
    //   33	40	202	java/lang/Exception
    //   43	49	202	java/lang/Exception
    //   52	81	202	java/lang/Exception
    //   98	104	202	java/lang/Exception
    //   107	136	202	java/lang/Exception
    //   139	148	202	java/lang/Exception
    //   230	234	236	java/io/IOException
    //   11	20	239	java/lang/OutOfMemoryError
    //   23	30	239	java/lang/OutOfMemoryError
    //   33	40	239	java/lang/OutOfMemoryError
    //   43	49	239	java/lang/OutOfMemoryError
    //   52	81	239	java/lang/OutOfMemoryError
    //   98	104	239	java/lang/OutOfMemoryError
    //   107	136	239	java/lang/OutOfMemoryError
    //   139	148	239	java/lang/OutOfMemoryError
    //   268	272	274	java/io/IOException
    //   11	20	277	finally
    //   23	30	277	finally
    //   33	40	277	finally
    //   43	49	277	finally
    //   52	81	277	finally
    //   98	104	277	finally
    //   107	136	277	finally
    //   139	148	277	finally
    //   208	214	277	finally
    //   216	226	277	finally
    //   246	252	277	finally
    //   254	264	277	finally
    //   85	93	288	java/io/IOException
    //   175	179	291	java/io/IOException
    //   282	286	295	java/io/IOException
    //   148	171	299	finally
    //   148	171	307	java/lang/OutOfMemoryError
    //   148	171	311	java/lang/Exception
  }
  
  /* Error */
  private boolean a(String paramString, ArrayList<agbe> paramArrayList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 6
    //   11: astore_3
    //   12: new 32	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 282	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload 6
    //   23: astore_3
    //   24: aload_1
    //   25: invokevirtual 285	java/io/File:exists	()Z
    //   28: ifeq +13 -> 41
    //   31: aload 6
    //   33: astore_3
    //   34: aload_1
    //   35: invokevirtual 288	java/io/File:isFile	()Z
    //   38: ifne +50 -> 88
    //   41: aload 6
    //   43: astore_3
    //   44: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +35 -> 82
    //   50: aload 6
    //   52: astore_3
    //   53: ldc 228
    //   55: iconst_2
    //   56: new 21	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 337
    //   66: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_1
    //   70: invokevirtual 293	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   73: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aconst_null
    //   83: invokestatic 342	bgmg:a	(Ljava/io/Closeable;)V
    //   86: iconst_0
    //   87: ireturn
    //   88: aload 6
    //   90: astore_3
    //   91: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +35 -> 129
    //   97: aload 6
    //   99: astore_3
    //   100: ldc 228
    //   102: iconst_2
    //   103: new 21	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 344
    //   113: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: invokevirtual 293	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   120: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: aload 6
    //   131: astore_3
    //   132: new 302	java/io/FileInputStream
    //   135: dup
    //   136: aload_1
    //   137: invokespecial 305	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   140: astore_1
    //   141: invokestatic 311	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   144: invokevirtual 315	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   147: astore_3
    //   148: aload_3
    //   149: aload_1
    //   150: ldc_w 317
    //   153: invokeinterface 321 3 0
    //   158: aload_0
    //   159: aload_3
    //   160: aload_2
    //   161: invokespecial 346	agbb:a	(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/ArrayList;)V
    //   164: aload_1
    //   165: invokestatic 342	bgmg:a	(Ljava/io/Closeable;)V
    //   168: iconst_1
    //   169: ireturn
    //   170: astore_2
    //   171: aload 4
    //   173: astore_1
    //   174: aload_1
    //   175: astore_3
    //   176: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +15 -> 194
    //   182: aload_1
    //   183: astore_3
    //   184: ldc 228
    //   186: iconst_2
    //   187: ldc_w 348
    //   190: aload_2
    //   191: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   194: aload_1
    //   195: invokestatic 342	bgmg:a	(Ljava/io/Closeable;)V
    //   198: iconst_0
    //   199: ireturn
    //   200: astore_2
    //   201: aload 5
    //   203: astore_1
    //   204: aload_1
    //   205: astore_3
    //   206: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +15 -> 224
    //   212: aload_1
    //   213: astore_3
    //   214: ldc 228
    //   216: iconst_2
    //   217: ldc_w 348
    //   220: aload_2
    //   221: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: aload_1
    //   225: invokestatic 342	bgmg:a	(Ljava/io/Closeable;)V
    //   228: iconst_0
    //   229: ireturn
    //   230: astore_1
    //   231: aload_3
    //   232: invokestatic 342	bgmg:a	(Ljava/io/Closeable;)V
    //   235: aload_1
    //   236: athrow
    //   237: astore_2
    //   238: aload_1
    //   239: astore_3
    //   240: aload_2
    //   241: astore_1
    //   242: goto -11 -> 231
    //   245: astore_2
    //   246: goto -42 -> 204
    //   249: astore_2
    //   250: goto -76 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	agbb
    //   0	253	1	paramString	String
    //   0	253	2	paramArrayList	ArrayList<agbe>
    //   11	229	3	localObject1	Object
    //   7	165	4	localObject2	Object
    //   1	201	5	localObject3	Object
    //   4	126	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   12	21	170	java/lang/Exception
    //   24	31	170	java/lang/Exception
    //   34	41	170	java/lang/Exception
    //   44	50	170	java/lang/Exception
    //   53	82	170	java/lang/Exception
    //   91	97	170	java/lang/Exception
    //   100	129	170	java/lang/Exception
    //   132	141	170	java/lang/Exception
    //   12	21	200	java/lang/OutOfMemoryError
    //   24	31	200	java/lang/OutOfMemoryError
    //   34	41	200	java/lang/OutOfMemoryError
    //   44	50	200	java/lang/OutOfMemoryError
    //   53	82	200	java/lang/OutOfMemoryError
    //   91	97	200	java/lang/OutOfMemoryError
    //   100	129	200	java/lang/OutOfMemoryError
    //   132	141	200	java/lang/OutOfMemoryError
    //   12	21	230	finally
    //   24	31	230	finally
    //   34	41	230	finally
    //   44	50	230	finally
    //   53	82	230	finally
    //   91	97	230	finally
    //   100	129	230	finally
    //   132	141	230	finally
    //   176	182	230	finally
    //   184	194	230	finally
    //   206	212	230	finally
    //   214	224	230	finally
    //   141	164	237	finally
    //   141	164	245	java/lang/OutOfMemoryError
    //   141	164	249	java/lang/Exception
  }
  
  private void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AioAnimationConfigHelper", 2, "parseXmlFromRes");
    }
    paramContext = paramContext.getResources().getXml(2131886081);
    Object localObject = null;
    try
    {
      paramContext = a(paramContext);
      if (paramContext != null) {
        this.jdField_a_of_type_JavaUtilArrayList = paramContext;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramContext = localObject;
        if (QLog.isColorLevel())
        {
          QLog.e("AioAnimationConfigHelper", 2, "parseXmlFromRes doParseRules exception:", localException);
          paramContext = localObject;
        }
      }
    }
  }
  
  public ArrayList<agbe> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(Context paramContext)
  {
    if (bgmg.b(b))
    {
      boolean bool = a(b);
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationConfigHelper", 2, "parseXmlFromOutside: success = " + bool);
      }
      if (!bool) {
        b(paramContext);
      }
      return;
    }
    b(paramContext);
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    int i = 1;
    try
    {
      bgmg.a(jdField_a_of_type_JavaLangString, false);
      bgmg.a(paramString, jdField_a_of_type_JavaLangString, false);
      if (i != 0)
      {
        boolean bool = a(b);
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationConfigHelper", 2, "pareseRulesFromZip : delete and uncompressZip success, parse from outside result = " + bool);
        }
        if (bool)
        {
          paramQQAppInterface.getPreferences().edit().putLong("k_eggs_file_version", paramLong).commit();
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("AioAnimationConfigHelper", 2, "pareseRulesFromZip : delete and uncompress Exception=>", paramString);
        }
        i = 0;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AioAnimationConfigHelper", 2, "pareseRulesFromZip :  uncompress OOM Error =>", paramString);
        }
        i = 0;
      }
      b(paramQQAppInterface.getApplication());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AioAnimationConfigHelper", 2, "pareseRulesFromZip : delete and uncompressZip failure, parse from Res");
    }
    b(paramQQAppInterface.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbb
 * JD-Core Version:    0.7.0.1
 */