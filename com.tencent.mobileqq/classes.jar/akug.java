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

public class akug
{
  private static final HashMap<String, akui> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<akuj, akup> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(8, 0.75F);
  private static Map<akup, akuj> b = new ConcurrentHashMap(8, 0.75F);
  
  static
  {
    b();
  }
  
  private static akui a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (akui)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private static akup a(akuj paramakuj)
  {
    boolean bool1 = false;
    akui localakui = a(paramakuj.businessId);
    if (localakui == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "makeSososOnLocationListener business info is null, business id: " + paramakuj.businessId);
      }
      return null;
    }
    int i = localakui.a();
    int j = localakui.jdField_b_of_type_Int;
    boolean bool2 = localakui.jdField_b_of_type_Boolean;
    boolean bool3 = localakui.c;
    if (!localakui.d) {
      bool1 = true;
    }
    return new akuh(j, bool1, bool3, i, paramakuj.observerOnUiThread, bool2, paramakuj.businessId, paramakuj);
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
  
  public static void a(akuj paramakuj)
  {
    if (paramakuj == null) {
      return;
    }
    label129:
    label134:
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (jdField_a_of_type_JavaUtilMap.containsKey(paramakuj)) {
          break label129;
        }
        localakup = a(paramakuj);
        if (localakup == null) {
          break label134;
        }
        jdField_a_of_type_JavaUtilMap.put(paramakuj, localakup);
        b.put(localakup, paramakuj);
        break label134;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("startLocation sosoLocationListener is null : ");
          if (localakup == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool + " business id: " + paramakuj.businessId);
          }
        }
        else
        {
          if (localakup == null) {
            break;
          }
          SosoInterface.a(localakup);
          return;
        }
      }
      boolean bool = false;
      continue;
      akup localakup = null;
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
    if (((akui)localObject).d)
    {
      paramString = new SosoInterface.SosoLbsInfo();
      paramString.jdField_a_of_type_ArrayOfByte = paramSosoLbsInfo.jdField_a_of_type_ArrayOfByte;
      if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) {
        paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(0, ((akui)localObject).jdField_a_of_type_Boolean);
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
    paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(((akui)localObject).jdField_b_of_type_Int, ((akui)localObject).jdField_a_of_type_Boolean);
    return paramString;
  }
  
  public static String b()
  {
    return SosoInterface.b();
  }
  
  private static void b()
  {
    akui localakui = new akui("official_location", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("QQMapActivity", true, 5, 1, true, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("readinjoy_anti_cheating", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("vas_red_point", false, 2, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("qzone_address_select", true, 5, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("qzone_for_report", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("qzone_weather", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("qzone_live", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("qzone_say", true, 5, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("qzone_upload_pic_video", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("qzone_photo_recommend", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("qzone_little_video_enter", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("qzone_request_server", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("qzone_h5", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("qzone_other", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("readinjoy_feed_ad_distance", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("gdt_tangram", true, 1, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("nearby_readinjoy", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("troop_handler", true, 2, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("troop_member_distance", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("webview", true, 3, 4, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("qq_weather", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("qq_story_water_mark", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("readinjoy_weather", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("LBSService.Point", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("Login.Guide", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("recommend_troop", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("vfuchong_bus_card", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("qq_spring_hb", true, 1, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
    localakui = new akui("readinjoy_position", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakui.jdField_a_of_type_JavaLangString, localakui);
  }
  
  public static void b(akuj paramakuj)
  {
    if (paramakuj == null) {
      return;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (!jdField_a_of_type_JavaUtilMap.containsKey(paramakuj)) {
          break label120;
        }
        localakup = (akup)jdField_a_of_type_JavaUtilMap.remove(paramakuj);
        b.remove(localakup);
        if (QLog.isColorLevel())
        {
          paramakuj = new StringBuilder().append("removeListener business id is: ").append(paramakuj.businessId).append(" sosoLocationListener is null: ");
          if (localakup == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool);
          }
        }
        else
        {
          if (localakup == null) {
            break;
          }
          SosoInterface.b(localakup);
          return;
        }
      }
      boolean bool = false;
      continue;
      label120:
      akup localakup = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akug
 * JD-Core Version:    0.7.0.1
 */