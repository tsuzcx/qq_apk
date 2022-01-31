import android.content.Context;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class aljr
  extends aljf
{
  private static final Object a;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static byte a(String paramString)
  {
    return aljf.a(0, paramString);
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
        QLog.i("MiniRecog.MiniScanDecodeSoLoader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/" + "qq.android.minidecode.so_v8.2.0";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("MiniRecog.MiniScanDecodeSoLoader", 2, "getLibDir ,path = " + str);
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
    if (!aljf.a(0, b, "minicode"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDecodeSoLoader", 2, "native so is not exist!");
      }
      return false;
    }
    return true;
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
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MiniRecog.MiniScanDecodeSoLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      int i = localXmlPullParser.next();
      break label165;
      str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("minicode")) {
        paramHashMap.put("minicode", localXmlPullParser.nextText());
      }
      if (str.equalsIgnoreCase("minicode_64"))
      {
        paramHashMap.put("minicode_64", localXmlPullParser.nextText());
        break label132;
        ;;
        label132:
        if (QLog.isColorLevel())
        {
          QLog.d("MiniRecog.MiniScanDecodeSoLoader", 2, "parseConfig success|config=" + paramHashMap);
          return true;
          label165:
          if (i != 1) {
            switch (i)
            {
            }
          }
        }
      }
    }
  }
  
  public static byte b(String paramString)
  {
    return aljf.a(0, b, paramString);
  }
  
  public static String b(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static String c(String paramString)
  {
    return aljf.a(0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aljr
 * JD-Core Version:    0.7.0.1
 */