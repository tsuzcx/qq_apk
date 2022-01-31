import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoAttribute;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class akuf
{
  private static final HashMap<String, akuh> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<akui, akuo> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(8, 0.75F);
  private static Map<akuo, akui> b = new ConcurrentHashMap(8, 0.75F);
  
  static
  {
    b();
  }
  
  private static akuh a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (akuh)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private static akuo a(akui paramakui)
  {
    boolean bool1 = false;
    akuh localakuh = a(paramakui.businessId);
    if (localakuh == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "makeSososOnLocationListener business info is null, business id: " + paramakui.businessId);
      }
      return null;
    }
    int i = localakuh.a();
    int j = localakuh.jdField_b_of_type_Int;
    boolean bool2 = localakuh.jdField_b_of_type_Boolean;
    boolean bool3 = localakuh.c;
    if (!localakuh.d) {
      bool1 = true;
    }
    return new akug(j, bool1, bool3, i, paramakui.observerOnUiThread, bool2, paramakui.businessId, paramakui);
  }
  
  public static SosoInterface.SosoLbsInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SOSO.LBS.LbsManagerService", 0, "getCachedLbsInfo business id: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = a(paramString);
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("SOSO.LBS.LbsManagerService", 0, "getCachedLbsInfo business info is null.");
    return null;
    if (paramString.d) {
      return SosoInterface.a(paramString.jdField_a_of_type_Boolean);
    }
    return SosoInterface.a(paramString.jdField_b_of_type_Int, paramString.jdField_a_of_type_Boolean);
  }
  
  public static String a()
  {
    return SosoInterface.a();
  }
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      jdField_a_of_type_JavaUtilMap.clear();
      b.clear();
      return;
    }
  }
  
  public static void a(akui paramakui)
  {
    if (paramakui == null) {
      return;
    }
    label129:
    label134:
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (jdField_a_of_type_JavaUtilMap.containsKey(paramakui)) {
          break label129;
        }
        localakuo = a(paramakui);
        if (localakuo == null) {
          break label134;
        }
        jdField_a_of_type_JavaUtilMap.put(paramakui, localakuo);
        b.put(localakuo, paramakui);
        break label134;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("startLocation sosoLocationListener is null : ");
          if (localakuo == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool + " business id: " + paramakui.businessId);
          }
        }
        else
        {
          if (localakuo == null) {
            break;
          }
          SosoInterface.a(localakuo);
          return;
        }
      }
      boolean bool = false;
      continue;
      akuo localakuo = null;
    }
  }
  
  public static boolean a()
  {
    return SosoInterface.a();
  }
  
  private static SosoInterface.SosoLbsInfo b(SosoInterface.SosoLbsInfo paramSosoLbsInfo, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      return null;
      localObject = a(paramString);
    } while ((localObject == null) || (paramSosoLbsInfo == null));
    if (((akuh)localObject).d)
    {
      paramString = new SosoInterface.SosoLbsInfo();
      paramString.jdField_a_of_type_ArrayOfByte = paramSosoLbsInfo.jdField_a_of_type_ArrayOfByte;
      if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) {
        paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(0, ((akuh)localObject).jdField_a_of_type_Boolean);
      }
      if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute != null) {
        paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.a();
      }
      localObject = new ArrayList();
      if (paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null) {
        ((ArrayList)localObject).addAll(paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList);
      }
      paramString.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      localObject = new ArrayList();
      if (paramSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList != null) {
        ((ArrayList)localObject).addAll(paramSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList);
      }
      paramString.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      paramString.jdField_a_of_type_Long = paramSosoLbsInfo.jdField_a_of_type_Long;
      paramString.jdField_a_of_type_JavaLangString = paramSosoLbsInfo.jdField_a_of_type_JavaLangString;
      paramString.jdField_b_of_type_JavaLangString = paramSosoLbsInfo.jdField_b_of_type_JavaLangString;
      return paramString;
    }
    paramString = new SosoInterface.SosoLbsInfo();
    paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(((akuh)localObject).jdField_b_of_type_Int, ((akuh)localObject).jdField_a_of_type_Boolean);
    return paramString;
  }
  
  public static String b()
  {
    return SosoInterface.b();
  }
  
  private static void b()
  {
    akuh localakuh = new akuh("official_location", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("QQMapActivity", true, 5, 1, true, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("readinjoy_anti_cheating", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("vas_red_point", false, 2, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("qzone_address_select", true, 5, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("qzone_for_report", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("qzone_weather", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("qzone_live", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("qzone_say", true, 5, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("qzone_upload_pic_video", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("qzone_photo_recommend", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("qzone_little_video_enter", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("qzone_request_server", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("qzone_h5", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("qzone_other", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("readinjoy_feed_ad_distance", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("gdt_tangram", true, 1, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("nearby_readinjoy", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("troop_handler", true, 2, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("troop_member_distance", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("webview", true, 3, 4, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("qq_weather", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("qq_story_water_mark", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("readinjoy_weather", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("LBSService.Point", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("Login.Guide", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("recommend_troop", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("vfuchong_bus_card", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("qq_spring_hb", true, 1, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
    localakuh = new akuh("readinjoy_position", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakuh.jdField_a_of_type_JavaLangString, localakuh);
  }
  
  public static void b(akui paramakui)
  {
    if (paramakui == null) {
      return;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (!jdField_a_of_type_JavaUtilMap.containsKey(paramakui)) {
          break label120;
        }
        localakuo = (akuo)jdField_a_of_type_JavaUtilMap.remove(paramakui);
        b.remove(localakuo);
        if (QLog.isColorLevel())
        {
          paramakui = new StringBuilder().append("removeListener business id is: ").append(paramakui.businessId).append(" sosoLocationListener is null: ");
          if (localakuo == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool);
          }
        }
        else
        {
          if (localakuo == null) {
            break;
          }
          SosoInterface.b(localakuo);
          return;
        }
      }
      boolean bool = false;
      continue;
      label120:
      akuo localakuo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akuf
 * JD-Core Version:    0.7.0.1
 */