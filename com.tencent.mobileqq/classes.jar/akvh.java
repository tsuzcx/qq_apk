import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class akvh
  extends akuu
{
  private static final Object a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static byte a(String paramString)
  {
    return akuu.a(2, paramString);
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
        QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/" + "qq.android.minidetect.model_v8.0.7";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, "getLibDir ,path = " + str);
    return str;
  }
  
  public static String a(String paramString)
  {
    return paramString;
  }
  
  public static void a(String paramString)
  {
    Object localObject = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).edit();
    if (TextUtils.isEmpty(paramString)) {
      ((SharedPreferences.Editor)localObject).putString("mini_native_match_detect_so_md5", "").apply();
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = paramString;
        if (paramString == null) {
          localObject = "null";
        }
        QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, String.format("saveMatchDetectSoMd5=%s", new Object[] { localObject }));
      }
      return;
      ((SharedPreferences.Editor)localObject).putString("mini_native_match_detect_so_md5", paramString).apply();
    }
  }
  
  protected static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    if ((!a("qr_anchor.bin")) || (!a("qr_detection_model.txt")) || (!a("qr_detection_model.bin")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDetectModelLoader", 2, "modules is not exist!");
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return akuu.a(2, jdField_a_of_type_Boolean, paramString);
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
        QLog.e("MiniRecog.MiniScanDetectModelLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      int i = localXmlPullParser.next();
      break label218;
      String str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("qr_anchor.bin"))
      {
        paramHashMap.put("qr_anchor.bin", localXmlPullParser.nextText());
        continue;
      }
      else
      {
        if (str.equalsIgnoreCase("qr_detection_model.txt"))
        {
          paramHashMap.put("qr_detection_model.txt", localXmlPullParser.nextText());
          continue;
        }
        if (str.equalsIgnoreCase("qr_detection_model.bin"))
        {
          paramHashMap.put("qr_detection_model.bin", localXmlPullParser.nextText());
          continue;
        }
        if (!str.equalsIgnoreCase("match_detect_so_md5")) {
          continue;
        }
        a(localXmlPullParser.nextText());
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("MiniRecog.MiniScanDetectModelLoader", 2, "parseConfig success|config=" + paramHashMap);
        return true;
        label218:
        if (i != 1) {
          switch (i)
          {
          }
        }
      }
    }
  }
  
  public static String b()
  {
    String str2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("mini_native_match_detect_so_md5", null);
    if (QLog.isColorLevel()) {
      if (str2 != null) {
        break label52;
      }
    }
    label52:
    for (String str1 = "null";; str1 = str2)
    {
      QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, String.format("getMatchDetectSoMd5=%s", new Object[] { str1 }));
      return str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akvh
 * JD-Core Version:    0.7.0.1
 */