import android.content.Context;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class alju
  extends aljg
{
  private static final Object a;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static byte a(String paramString)
  {
    return aljg.a(1, paramString);
  }
  
  public static Object a()
  {
    return jdField_a_of_type_JavaLangObject;
  }
  
  public static String a()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanDetectSoLoader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/" + "qq.android.minidetect.so_v8.2.0";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("MiniRecog.MiniScanDetectSoLoader", 2, "getLibDir ,path = " + str);
    return str;
  }
  
  public static String a(String paramString)
  {
    if (jdField_a_of_type_Boolean) {
      return "lib" + paramString + "_64" + ".so";
    }
    return "lib" + paramString + ".so";
  }
  
  protected static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean a()
  {
    boolean bool2 = true;
    boolean bool1;
    if (aljg.a(1, b, "QMCF_qr"))
    {
      bool1 = bool2;
      if (!jdField_a_of_type_Boolean)
      {
        bool1 = bool2;
        if (aljg.a(1, b, "yuvutil")) {}
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDetectSoLoader", 2, "native so is not exist!");
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public static boolean a(String paramString, HashMap<String, String> paramHashMap)
  {
    boolean bool = true;
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    paramHashMap.clear();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramHashMap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MiniRecog.MiniScanDetectSoLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      int i = localXmlPullParser.next();
      break label222;
      String str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("QMCF_qr"))
      {
        paramHashMap.put("QMCF_qr", localXmlPullParser.nextText());
        continue;
      }
      else
      {
        if (str.equalsIgnoreCase("yuvutil"))
        {
          paramHashMap.put("yuvutil", localXmlPullParser.nextText());
          continue;
        }
        if (str.equalsIgnoreCase("QMCF_qr_64"))
        {
          paramHashMap.put("QMCF_qr_64", localXmlPullParser.nextText());
          continue;
        }
        if (!str.equalsIgnoreCase("yuvutil_64")) {
          continue;
        }
        paramHashMap.put("yuvutil_64", localXmlPullParser.nextText());
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("MiniRecog.MiniScanDetectSoLoader", 2, "parseConfig success|config=" + paramHashMap);
        return true;
        label222:
        if (i != 1) {
          switch (i)
          {
          }
        }
      }
    }
  }
  
  public static byte b(String paramString)
  {
    if ((jdField_a_of_type_Boolean) && (paramString == "yuvutil")) {
      return 0;
    }
    return aljg.a(1, b, paramString);
  }
  
  public static String b(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static String c(String paramString)
  {
    return aljg.a(1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alju
 * JD-Core Version:    0.7.0.1
 */