import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.device.AdDeviceInfo;
import com.tencent.ad.tangram.device.AdDeviceInfo.Result;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.1;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location;

public class acrx
{
  private static volatile int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString = "GdtDeviceInfoHelper";
  private static volatile Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static volatile boolean jdField_a_of_type_Boolean;
  
  public static acrz a(Context paramContext, acry paramacry)
  {
    if ((paramContext == null) || (paramacry == null) || (Looper.myLooper() == Looper.getMainLooper()))
    {
      acqy.d(jdField_a_of_type_JavaLangString, String.format("create businessId:%s error", new Object[] { paramacry.jdField_a_of_type_JavaLangString }));
      return null;
    }
    acqy.b(jdField_a_of_type_JavaLangString, String.format("create businessId:%s", new Object[] { paramacry.jdField_a_of_type_JavaLangString }));
    long l = System.currentTimeMillis();
    acsb.a().a(paramContext, new acsc());
    acrz localacrz = new acrz();
    localacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo = new tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo();
    a(paramContext, paramacry, localacrz);
    b(paramContext, paramacry, localacrz);
    c(paramContext, paramacry, localacrz);
    d(paramContext, paramacry, localacrz);
    localacrz.jdField_a_of_type_JavaUtilList.add(AdReporterForAnalysis.createEventForDeviceInfoEnd(paramContext, String.valueOf(paramacry.jdField_a_of_type_JavaLangString), System.currentTimeMillis() - l));
    e(paramContext, paramacry, localacrz);
    return localacrz;
  }
  
  @Deprecated
  public static tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo a(Context paramContext)
  {
    if (paramContext == null)
    {
      acqy.d(jdField_a_of_type_JavaLangString, "create error");
      return null;
    }
    acsb.a().a(paramContext, new acsc());
    Object localObject = AdDeviceInfo.INSTANCE.create(paramContext);
    if (localObject != null) {}
    for (localObject = ((AdDeviceInfo.Result)localObject).deviceInfo; localObject == null; localObject = null)
    {
      acqy.d(jdField_a_of_type_JavaLangString, "create error");
      return null;
    }
    tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = new tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo();
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).muid)) {
      localDeviceInfo.muid.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).muid);
    }
    localDeviceInfo.muid_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).muid_type);
    localDeviceInfo.conn.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).conn);
    localDeviceInfo.carrier_code.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).carrier_code);
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).os_ver)) {
      localDeviceInfo.os_ver.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).os_ver);
    }
    localDeviceInfo.os_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).os_type);
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).manufacturer)) {
      localDeviceInfo.manufacturer.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).manufacturer);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).device_brand_and_model)) {
      localDeviceInfo.device_brand_and_model.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).device_brand_and_model);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).qadid)) {
      localDeviceInfo.qadid.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).qadid);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_mac)) {
      localDeviceInfo.md5_mac.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_mac);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_android_id)) {
      localDeviceInfo.md5_android_id.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_android_id);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).client_ipv4)) {
      localDeviceInfo.client_ipv4.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).client_ipv4);
    }
    if (!TextUtils.isEmpty(acrb.a())) {
      localDeviceInfo.qq_ver.set(acrb.a());
    }
    localDeviceInfo.app_version_id.set(AppSetting.a());
    paramContext = GdtLocationUtil.INSTANCE.getLocation(paramContext);
    if ((paramContext != null) && (paramContext.length == 2))
    {
      localObject = new qq_ad_get.QQAdGet.DeviceInfo.Location();
      ((qq_ad_get.QQAdGet.DeviceInfo.Location)localObject).coordinates_type.set(0);
      ((qq_ad_get.QQAdGet.DeviceInfo.Location)localObject).latitude.set(paramContext[0]);
      ((qq_ad_get.QQAdGet.DeviceInfo.Location)localObject).longitude.set(paramContext[1]);
      localDeviceInfo.location.set((MessageMicro)localObject);
    }
    localDeviceInfo.is_googleplay_version.set(false);
    return localDeviceInfo;
  }
  
  static void a(Context paramContext)
  {
    acqy.b(jdField_a_of_type_JavaLangString, String.format("init %b", new Object[] { Boolean.valueOf(jdField_a_of_type_Boolean) }));
    if (jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (jdField_a_of_type_Boolean) {
        return;
      }
    }
    finally {}
    jdField_a_of_type_Boolean = true;
    AdDeviceInfo.INSTANCE.init(paramContext);
    b(0L);
  }
  
  private static void a(Context paramContext, acry paramacry, acrz paramacrz)
  {
    AdDeviceInfo.Result localResult = AdDeviceInfo.INSTANCE.create(paramContext);
    if (localResult != null) {}
    for (com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = localResult.deviceInfo; (paramContext == null) || (paramacry == null) || (paramacrz == null) || (paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null) || (localDeviceInfo == null); localDeviceInfo = null) {
      return;
    }
    paramacrz.jdField_a_of_type_JavaUtilList.addAll(localResult.eventsForAnalysis);
    if (!TextUtils.isEmpty(localDeviceInfo.muid)) {
      paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.muid.set(localDeviceInfo.muid);
    }
    paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.muid_type.set(localDeviceInfo.muid_type);
    paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.conn.set(localDeviceInfo.conn);
    paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.carrier_code.set(localDeviceInfo.carrier_code);
    if (!TextUtils.isEmpty(localDeviceInfo.os_ver)) {
      paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.os_ver.set(localDeviceInfo.os_ver);
    }
    paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.os_type.set(localDeviceInfo.os_type);
    if (!TextUtils.isEmpty(localDeviceInfo.manufacturer)) {
      paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.manufacturer.set(localDeviceInfo.manufacturer);
    }
    if (!TextUtils.isEmpty(localDeviceInfo.device_brand_and_model)) {
      paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.device_brand_and_model.set(localDeviceInfo.device_brand_and_model);
    }
    if (!TextUtils.isEmpty(localDeviceInfo.qadid)) {
      paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.qadid.set(localDeviceInfo.qadid);
    }
    if (!TextUtils.isEmpty(localDeviceInfo.md5_mac)) {
      paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.md5_mac.set(localDeviceInfo.md5_mac);
    }
    if (!TextUtils.isEmpty(localDeviceInfo.md5_android_id)) {
      paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.md5_android_id.set(localDeviceInfo.md5_android_id);
    }
    if (!TextUtils.isEmpty(localDeviceInfo.client_ipv4)) {
      paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.client_ipv4.set(localDeviceInfo.client_ipv4);
    }
    if (!TextUtils.isEmpty(localDeviceInfo.brand)) {
      paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.brand.set(localDeviceInfo.brand);
    }
    if (!TextUtils.isEmpty(localDeviceInfo.device_ext)) {
      paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.device_ext.set(localDeviceInfo.device_ext);
    }
    paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.origin_network_type.set(localDeviceInfo.origin_network_type);
  }
  
  private static int b(acrv paramacrv)
  {
    int j = d(paramacrv);
    int i = j;
    if (j == 0)
    {
      i = j;
      if (TextUtils.isEmpty(paramacrv.jdField_a_of_type_JavaLangString)) {
        i = 10;
      }
    }
    return i;
  }
  
  private static void b(long paramLong)
  {
    acqy.b(jdField_a_of_type_JavaLangString, String.format("updateForAidTicketAndTaidTicket delayMillis:%d count:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(jdField_a_of_type_Int) }));
    AdThreadManager.INSTANCE.postDelayed(new GdtDeviceInfoHelper.1(paramLong), 4, paramLong);
  }
  
  private static void b(Context paramContext, acry paramacry, acrz paramacrz)
  {
    boolean bool2 = false;
    if ((paramContext == null) || (paramacry == null) || (paramacrz == null) || (paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null)) {
      return;
    }
    paramacry = aoor.a("gdt_tangram");
    if ((paramacry != null) && (paramacry.a != null))
    {
      qq_ad_get.QQAdGet.DeviceInfo.Location localLocation = new qq_ad_get.QQAdGet.DeviceInfo.Location();
      localLocation.coordinates_type.set(0);
      localLocation.latitude.set(Double.valueOf(paramacry.a.jdField_a_of_type_Double * 1000000.0D).intValue());
      localLocation.longitude.set(Double.valueOf(paramacry.a.b * 1000000.0D).intValue());
      paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.location.set(localLocation);
    }
    boolean bool1 = bool2;
    if (paramacry != null)
    {
      bool1 = bool2;
      if (paramacry.a != null) {
        bool1 = true;
      }
    }
    paramacrz = paramacrz.jdField_a_of_type_JavaUtilList;
    if (bool1) {}
    for (long l = System.currentTimeMillis() - paramacry.a.jdField_a_of_type_Long;; l = -2147483648L)
    {
      paramacrz.add(AdReporterForAnalysis.createEventForLocation(paramContext, bool1, l));
      return;
    }
  }
  
  private static int c(acrv paramacrv)
  {
    int j = d(paramacrv);
    int i = j;
    if (j == 0)
    {
      i = j;
      if (TextUtils.isEmpty(paramacrv.b)) {
        i = 1;
      }
    }
    return i;
  }
  
  private static void c(Context paramContext, acry paramacry, acrz paramacrz)
  {
    int j = -2147483648;
    if ((paramContext == null) || (paramacry == null) || (paramacrz == null) || (paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null)) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = paramacry.jdField_a_of_type_JavaLangString;
    paramacry = acrs.a().a((String)localObject);
    int k;
    if (paramacry != null)
    {
      acqy.b(jdField_a_of_type_JavaLangString, String.format("fillDeviceInfoWithAidTicketAndTaidTicket businessId:%s errorCodeOfTicketEntity:%d expiredTimestampOfTicketEntity:%d aidTicket:%s taidTicket:%s", new Object[] { localObject, Integer.valueOf(paramacry.jdField_a_of_type_Int), Long.valueOf(paramacry.jdField_a_of_type_Long), paramacry.jdField_a_of_type_JavaLangString, paramacry.b }));
      if (!TextUtils.isEmpty(paramacry.jdField_a_of_type_JavaLangString)) {
        paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.aid_ticket.set(paramacry.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramacry.b)) {
        paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.taid_ticket.set(paramacry.b);
      }
      l = System.currentTimeMillis() - l;
      localObject = paramacrz.jdField_a_of_type_JavaUtilList;
      k = b(paramacry);
      if (paramacry == null) {
        break label262;
      }
    }
    label262:
    for (int i = paramacry.jdField_a_of_type_Int;; i = -2147483648)
    {
      ((List)localObject).add(AdReporterForAnalysis.createEventForAidTicket(paramContext, k, i, l));
      paramacrz = paramacrz.jdField_a_of_type_JavaUtilList;
      k = c(paramacry);
      i = j;
      if (paramacry != null) {
        i = paramacry.jdField_a_of_type_Int;
      }
      paramacrz.add(AdReporterForAnalysis.createEventForTaidTicket(paramContext, k, i, l));
      return;
      acqy.d(jdField_a_of_type_JavaLangString, String.format("fillDeviceInfoWithAidTicketAndTaidTicket return null, businessId:%s", new Object[] { localObject }));
      break;
    }
  }
  
  private static int d(acrv paramacrv)
  {
    if (paramacrv == null) {}
    do
    {
      return 1;
      if (paramacrv.jdField_a_of_type_Int == 0) {
        return 0;
      }
      if (paramacrv.jdField_a_of_type_Int == -10001) {
        return 6;
      }
      if (paramacrv.jdField_a_of_type_Int == -10008) {
        return 8;
      }
      if (paramacrv.jdField_a_of_type_Int == -10009) {
        return 7;
      }
      if (paramacrv.jdField_a_of_type_Int == 10010) {
        return 5;
      }
      if (paramacrv.jdField_a_of_type_Int == -10011) {
        return 2;
      }
      if ((paramacrv.jdField_a_of_type_Int == -10004) || (paramacrv.jdField_a_of_type_Int == -10012) || (paramacrv.jdField_a_of_type_Int == -21052) || (paramacrv.jdField_a_of_type_Int == -22056)) {
        return 3;
      }
      if (paramacrv.jdField_a_of_type_Int == -30014) {
        return 10;
      }
      if (paramacrv.jdField_a_of_type_Int == -2147483648) {
        return 4;
      }
      if (paramacrv.jdField_a_of_type_Int == -2147483647) {
        return 9;
      }
      if (paramacrv.jdField_a_of_type_Int == -2147483646) {
        return 205;
      }
    } while (paramacrv.jdField_a_of_type_Int != -2147483645);
    return 206;
  }
  
  private static void d(Context paramContext, acry paramacry, acrz paramacrz)
  {
    if ((paramContext == null) || (paramacry == null) || (paramacrz == null) || (paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null)) {
      return;
    }
    if (!TextUtils.isEmpty(acrb.a())) {
      paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.qq_ver.set(acrb.a());
    }
    paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.app_version_id.set(AppSetting.a());
    paramacrz.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.is_googleplay_version.set(false);
  }
  
  private static void e(Context paramContext, acry paramacry, acrz paramacrz)
  {
    if ((paramacry != null) && (!TextUtils.isEmpty(paramacry.jdField_a_of_type_JavaLangString))) {}
    for (String str = paramacry.jdField_a_of_type_JavaLangString; (paramacry == null) || (paramacrz == null) || (paramacrz.jdField_a_of_type_JavaUtilList == null) || (paramacrz.jdField_a_of_type_JavaUtilList.isEmpty()); str = "null") {
      return;
    }
    long l = System.currentTimeMillis();
    try
    {
      paramacry = (Long)jdField_a_of_type_JavaUtilMap.get(str);
      if ((paramacry != null) && (l - paramacry.longValue() < 60000L)) {
        return;
      }
    }
    finally {}
    jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(l));
    acqy.b(jdField_a_of_type_JavaLangString, String.format("reportForAnalysis businessId:%s", new Object[] { str }));
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), paramacrz.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrx
 * JD-Core Version:    0.7.0.1
 */