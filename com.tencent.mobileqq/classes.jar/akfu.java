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

public class akfu
{
  private static final HashMap<String, akfw> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<akfx, akgd> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(8, 0.75F);
  private static Map<akgd, akfx> b = new ConcurrentHashMap(8, 0.75F);
  
  static
  {
    b();
  }
  
  private static akfw a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (akfw)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private static akgd a(akfx paramakfx)
  {
    boolean bool1 = false;
    akfw localakfw = a(paramakfx.businessId);
    if (localakfw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "makeSososOnLocationListener business info is null, business id: " + paramakfx.businessId);
      }
      return null;
    }
    int i = localakfw.a();
    int j = localakfw.jdField_b_of_type_Int;
    boolean bool2 = localakfw.jdField_b_of_type_Boolean;
    boolean bool3 = localakfw.c;
    if (!localakfw.d) {
      bool1 = true;
    }
    return new akfv(j, bool1, bool3, i, paramakfx.observerOnUiThread, bool2, paramakfx.businessId, paramakfx);
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
  
  public static void a(akfx paramakfx)
  {
    if (paramakfx == null) {
      return;
    }
    label129:
    label134:
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (jdField_a_of_type_JavaUtilMap.containsKey(paramakfx)) {
          break label129;
        }
        localakgd = a(paramakfx);
        if (localakgd == null) {
          break label134;
        }
        jdField_a_of_type_JavaUtilMap.put(paramakfx, localakgd);
        b.put(localakgd, paramakfx);
        break label134;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("startLocation sosoLocationListener is null : ");
          if (localakgd == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool + " business id: " + paramakfx.businessId);
          }
        }
        else
        {
          if (localakgd == null) {
            break;
          }
          SosoInterface.a(localakgd);
          return;
        }
      }
      boolean bool = false;
      continue;
      akgd localakgd = null;
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
    if (((akfw)localObject).d)
    {
      paramString = new SosoInterface.SosoLbsInfo();
      paramString.jdField_a_of_type_ArrayOfByte = paramSosoLbsInfo.jdField_a_of_type_ArrayOfByte;
      if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) {
        paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(0, ((akfw)localObject).jdField_a_of_type_Boolean);
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
    paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(((akfw)localObject).jdField_b_of_type_Int, ((akfw)localObject).jdField_a_of_type_Boolean);
    return paramString;
  }
  
  public static String b()
  {
    return SosoInterface.b();
  }
  
  private static void b()
  {
    akfw localakfw = new akfw("official_location", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("QQMapActivity", true, 5, 1, true, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("readinjoy_anti_cheating", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("vas_red_point", false, 2, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("qzone_address_select", true, 5, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("qzone_for_report", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("qzone_weather", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("qzone_live", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("qzone_say", true, 5, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("qzone_upload_pic_video", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("qzone_photo_recommend", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("qzone_little_video_enter", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("qzone_request_server", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("qzone_h5", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("qzone_other", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("readinjoy_feed_ad_distance", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("gdt_tangram", true, 1, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("nearby_readinjoy", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("troop_handler", true, 2, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("troop_member_distance", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("webview", true, 3, 4, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("qq_weather", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("qq_story_water_mark", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("readinjoy_weather", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("LBSService.Point", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("Login.Guide", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("recommend_troop", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("vfuchong_bus_card", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("qq_spring_hb", true, 1, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
    localakfw = new akfw("readinjoy_position", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localakfw.jdField_a_of_type_JavaLangString, localakfw);
  }
  
  public static void b(akfx paramakfx)
  {
    if (paramakfx == null) {
      return;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (!jdField_a_of_type_JavaUtilMap.containsKey(paramakfx)) {
          break label120;
        }
        localakgd = (akgd)jdField_a_of_type_JavaUtilMap.remove(paramakfx);
        b.remove(localakgd);
        if (QLog.isColorLevel())
        {
          paramakfx = new StringBuilder().append("removeListener business id is: ").append(paramakfx.businessId).append(" sosoLocationListener is null: ");
          if (localakgd == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool);
          }
        }
        else
        {
          if (localakgd == null) {
            break;
          }
          SosoInterface.b(localakgd);
          return;
        }
      }
      boolean bool = false;
      continue;
      label120:
      akgd localakgd = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akfu
 * JD-Core Version:    0.7.0.1
 */