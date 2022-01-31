import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class aeur
{
  private static volatile aeur jdField_a_of_type_Aeur;
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + "eggs.xml";
  private ArrayList<aeuu> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    jdField_a_of_type_JavaLangString = localBaseApplication.getFilesDir().getAbsoluteFile() + File.separator + "animConfig/";
  }
  
  public static aeur a()
  {
    if (jdField_a_of_type_Aeur == null) {}
    try
    {
      if (jdField_a_of_type_Aeur == null) {
        jdField_a_of_type_Aeur = new aeur();
      }
      return jdField_a_of_type_Aeur;
    }
    finally {}
  }
  
  private ArrayList<aeuu> a(XmlPullParser paramXmlPullParser)
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
          localObject2 = new aeuu();
          ((aeuu)localObject2).jdField_a_of_type_Int = Integer.valueOf((String)localObject3).intValue();
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
              localObject4.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
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
              localObject4.c = Integer.valueOf(str1).intValue();
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
      localObject2 = new aeuw();
      if (str1 != null) {
        ((aeuw)localObject2).jdField_b_of_type_Int = aeuw.a(str1);
      }
      ((aeuw)localObject2).jdField_a_of_type_JavaLangString = str2;
      if (localObject4 != null)
      {
        if (localObject4.jdField_b_of_type_JavaUtilArrayList == null) {
          localObject4.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        }
        localObject4.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
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
      localObject4.jdField_a_of_type_Aeuv = new aeuv();
      localObject2 = paramXmlPullParser.getAttributeValue(null, "bid");
      localObject3 = paramXmlPullParser.getAttributeValue(null, "startTs");
      str1 = paramXmlPullParser.getAttributeValue(null, "endTs");
      str2 = paramXmlPullParser.getAttributeValue(null, "actId");
      String str3 = paramXmlPullParser.getAttributeValue(null, "timeDelay");
      localObject4.jdField_a_of_type_Aeuv.jdField_a_of_type_Int = Integer.parseInt((String)localObject2);
      localObject4.jdField_a_of_type_Aeuv.jdField_b_of_type_Int = Integer.parseInt((String)localObject3);
      localObject4.jdField_a_of_type_Aeuv.c = Integer.parseInt(str1);
      localObject4.jdField_a_of_type_Aeuv.e = Integer.parseInt(str3);
      localObject4.jdField_a_of_type_Aeuv.d = Integer.parseInt(str2);
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
        if ((localObject4.jdField_b_of_type_Int != 0) || (localObject4.c != 0)) {
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
        if (localObject4.c > localObject4.jdField_b_of_type_Int)
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
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 5
    //   10: astore_2
    //   11: new 31	java/io/File
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 236	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload 5
    //   22: astore_2
    //   23: aload_1
    //   24: invokevirtual 239	java/io/File:exists	()Z
    //   27: ifeq +13 -> 40
    //   30: aload 5
    //   32: astore_2
    //   33: aload_1
    //   34: invokevirtual 242	java/io/File:isFile	()Z
    //   37: ifne +57 -> 94
    //   40: aload 5
    //   42: astore_2
    //   43: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +34 -> 80
    //   49: aload 5
    //   51: astore_2
    //   52: ldc 202
    //   54: iconst_2
    //   55: new 20	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   62: ldc 244
    //   64: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 247	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   71: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 249	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: iconst_0
    //   81: ifeq +11 -> 92
    //   84: new 251	java/lang/NullPointerException
    //   87: dup
    //   88: invokespecial 252	java/lang/NullPointerException:<init>	()V
    //   91: athrow
    //   92: iconst_0
    //   93: ireturn
    //   94: aload 5
    //   96: astore_2
    //   97: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +34 -> 134
    //   103: aload 5
    //   105: astore_2
    //   106: ldc 202
    //   108: iconst_2
    //   109: new 20	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   116: ldc 254
    //   118: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_1
    //   122: invokevirtual 247	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   125: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload 5
    //   136: astore_2
    //   137: new 256	java/io/FileInputStream
    //   140: dup
    //   141: aload_1
    //   142: invokespecial 259	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   145: astore_1
    //   146: invokestatic 265	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   149: invokevirtual 269	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   152: astore_2
    //   153: aload_2
    //   154: aload_1
    //   155: ldc_w 271
    //   158: invokeinterface 275 3 0
    //   163: aload_0
    //   164: aload_2
    //   165: invokespecial 277	aeur:a	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/ArrayList;
    //   168: astore_2
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 280	java/io/FileInputStream:close	()V
    //   177: aload_2
    //   178: ifnull -86 -> 92
    //   181: aload_0
    //   182: aload_2
    //   183: putfield 281	aeur:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   186: iconst_1
    //   187: ireturn
    //   188: astore_2
    //   189: aload_3
    //   190: astore_1
    //   191: aload_2
    //   192: astore_3
    //   193: aload_1
    //   194: astore_2
    //   195: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +15 -> 213
    //   201: aload_1
    //   202: astore_2
    //   203: ldc 202
    //   205: iconst_2
    //   206: ldc_w 283
    //   209: aload_3
    //   210: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_1
    //   214: ifnull -122 -> 92
    //   217: aload_1
    //   218: invokevirtual 280	java/io/FileInputStream:close	()V
    //   221: iconst_0
    //   222: ireturn
    //   223: astore_1
    //   224: iconst_0
    //   225: ireturn
    //   226: astore_3
    //   227: aload 4
    //   229: astore_1
    //   230: aload_1
    //   231: astore_2
    //   232: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +15 -> 250
    //   238: aload_1
    //   239: astore_2
    //   240: ldc 202
    //   242: iconst_2
    //   243: ldc_w 283
    //   246: aload_3
    //   247: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   250: aload_1
    //   251: ifnull -159 -> 92
    //   254: aload_1
    //   255: invokevirtual 280	java/io/FileInputStream:close	()V
    //   258: iconst_0
    //   259: ireturn
    //   260: astore_1
    //   261: iconst_0
    //   262: ireturn
    //   263: astore_1
    //   264: aload_2
    //   265: ifnull +7 -> 272
    //   268: aload_2
    //   269: invokevirtual 280	java/io/FileInputStream:close	()V
    //   272: aload_1
    //   273: athrow
    //   274: astore_1
    //   275: iconst_0
    //   276: ireturn
    //   277: astore_1
    //   278: goto -101 -> 177
    //   281: astore_2
    //   282: goto -10 -> 272
    //   285: astore_3
    //   286: aload_1
    //   287: astore_2
    //   288: aload_3
    //   289: astore_1
    //   290: goto -26 -> 264
    //   293: astore_3
    //   294: goto -64 -> 230
    //   297: astore_3
    //   298: goto -105 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	aeur
    //   0	301	1	paramString	String
    //   10	173	2	localObject1	Object
    //   188	4	2	localException1	Exception
    //   194	75	2	str1	String
    //   281	1	2	localIOException	java.io.IOException
    //   287	1	2	str2	String
    //   7	203	3	localObject2	Object
    //   226	21	3	localOutOfMemoryError1	OutOfMemoryError
    //   285	4	3	localObject3	Object
    //   293	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   297	1	3	localException2	Exception
    //   1	227	4	localObject4	Object
    //   4	131	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   11	20	188	java/lang/Exception
    //   23	30	188	java/lang/Exception
    //   33	40	188	java/lang/Exception
    //   43	49	188	java/lang/Exception
    //   52	80	188	java/lang/Exception
    //   97	103	188	java/lang/Exception
    //   106	134	188	java/lang/Exception
    //   137	146	188	java/lang/Exception
    //   217	221	223	java/io/IOException
    //   11	20	226	java/lang/OutOfMemoryError
    //   23	30	226	java/lang/OutOfMemoryError
    //   33	40	226	java/lang/OutOfMemoryError
    //   43	49	226	java/lang/OutOfMemoryError
    //   52	80	226	java/lang/OutOfMemoryError
    //   97	103	226	java/lang/OutOfMemoryError
    //   106	134	226	java/lang/OutOfMemoryError
    //   137	146	226	java/lang/OutOfMemoryError
    //   254	258	260	java/io/IOException
    //   11	20	263	finally
    //   23	30	263	finally
    //   33	40	263	finally
    //   43	49	263	finally
    //   52	80	263	finally
    //   97	103	263	finally
    //   106	134	263	finally
    //   137	146	263	finally
    //   195	201	263	finally
    //   203	213	263	finally
    //   232	238	263	finally
    //   240	250	263	finally
    //   84	92	274	java/io/IOException
    //   173	177	277	java/io/IOException
    //   268	272	281	java/io/IOException
    //   146	169	285	finally
    //   146	169	293	java/lang/OutOfMemoryError
    //   146	169	297	java/lang/Exception
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
  
  public ArrayList<aeuu> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(Context paramContext)
  {
    if (bdhb.b(b))
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
      bdhb.a(jdField_a_of_type_JavaLangString, false);
      bdhb.a(paramString, jdField_a_of_type_JavaLangString, false);
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
 * Qualified Name:     aeur
 * JD-Core Version:    0.7.0.1
 */