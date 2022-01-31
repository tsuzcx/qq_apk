import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.device.AdDeviceInfo;
import com.tencent.ad.tangram.device.AdDeviceInfo.Result;
import com.tencent.ad.tangram.net.AdIPV4;
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

public class aatd
{
  private static volatile int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString = "GdtDeviceInfoHelper";
  private static volatile Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static volatile boolean jdField_a_of_type_Boolean;
  
  public static aatf a(Context paramContext, aate paramaate)
  {
    if ((paramContext == null) || (paramaate == null) || (Looper.myLooper() == Looper.getMainLooper()))
    {
      aase.d(jdField_a_of_type_JavaLangString, String.format("create businessId:%s error", new Object[] { paramaate.jdField_a_of_type_JavaLangString }));
      return null;
    }
    aase.b(jdField_a_of_type_JavaLangString, String.format("create businessId:%s", new Object[] { paramaate.jdField_a_of_type_JavaLangString }));
    long l = System.currentTimeMillis();
    aath.a().a(paramContext, new aati());
    aatf localaatf = new aatf();
    localaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo = new tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo();
    a(paramContext, paramaate, localaatf);
    b(paramContext, paramaate, localaatf);
    c(paramContext, paramaate, localaatf);
    d(paramContext, paramaate, localaatf);
    localaatf.jdField_a_of_type_JavaUtilList.add(AdReporterForAnalysis.createEventForDeviceInfoEnd(paramContext, String.valueOf(paramaate.jdField_a_of_type_JavaLangString), System.currentTimeMillis() - l));
    e(paramContext, paramaate, localaatf);
    return localaatf;
  }
  
  @Deprecated
  public static tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo a(Context paramContext)
  {
    if (paramContext == null)
    {
      aase.d(jdField_a_of_type_JavaLangString, "create error");
      return null;
    }
    aath.a().a(paramContext, new aati());
    Object localObject = AdDeviceInfo.create(paramContext);
    if (localObject != null) {}
    for (localObject = ((AdDeviceInfo.Result)localObject).deviceInfo; localObject == null; localObject = null)
    {
      aase.d(jdField_a_of_type_JavaLangString, "create error");
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
    if (!TextUtils.isEmpty(aash.a())) {
      localDeviceInfo.qq_ver.set(aash.a());
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
    aase.b(jdField_a_of_type_JavaLangString, String.format("init %b", new Object[] { Boolean.valueOf(jdField_a_of_type_Boolean) }));
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
    AdIPV4.INSTANCE.init(paramContext);
    b(0L);
  }
  
  private static void a(Context paramContext, aate paramaate, aatf paramaatf)
  {
    AdDeviceInfo.Result localResult = AdDeviceInfo.create(paramContext);
    if (localResult != null) {}
    for (com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = localResult.deviceInfo; (paramContext == null) || (paramaate == null) || (paramaatf == null) || (paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null) || (localDeviceInfo == null); localDeviceInfo = null) {
      return;
    }
    paramaatf.jdField_a_of_type_JavaUtilList.addAll(localResult.eventsForAnalysis);
    if (!TextUtils.isEmpty(localDeviceInfo.muid)) {
      paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.muid.set(localDeviceInfo.muid);
    }
    paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.muid_type.set(localDeviceInfo.muid_type);
    paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.conn.set(localDeviceInfo.conn);
    paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.carrier_code.set(localDeviceInfo.carrier_code);
    if (!TextUtils.isEmpty(localDeviceInfo.os_ver)) {
      paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.os_ver.set(localDeviceInfo.os_ver);
    }
    paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.os_type.set(localDeviceInfo.os_type);
    if (!TextUtils.isEmpty(localDeviceInfo.manufacturer)) {
      paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.manufacturer.set(localDeviceInfo.manufacturer);
    }
    if (!TextUtils.isEmpty(localDeviceInfo.device_brand_and_model)) {
      paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.device_brand_and_model.set(localDeviceInfo.device_brand_and_model);
    }
    if (!TextUtils.isEmpty(localDeviceInfo.qadid)) {
      paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.qadid.set(localDeviceInfo.qadid);
    }
    if (!TextUtils.isEmpty(localDeviceInfo.md5_mac)) {
      paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.md5_mac.set(localDeviceInfo.md5_mac);
    }
    if (!TextUtils.isEmpty(localDeviceInfo.md5_android_id)) {
      paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.md5_android_id.set(localDeviceInfo.md5_android_id);
    }
    if (!TextUtils.isEmpty(localDeviceInfo.client_ipv4)) {
      paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.client_ipv4.set(localDeviceInfo.client_ipv4);
    }
    paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.origin_network_type.set(localDeviceInfo.origin_network_type);
  }
  
  private static int b(aatb paramaatb)
  {
    int j = d(paramaatb);
    int i = j;
    if (j == 0)
    {
      i = j;
      if (TextUtils.isEmpty(paramaatb.jdField_a_of_type_JavaLangString)) {
        i = 10;
      }
    }
    return i;
  }
  
  private static void b(long paramLong)
  {
    aase.b(jdField_a_of_type_JavaLangString, String.format("updateForAidTicketAndTaidTicket delayMillis:%d count:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(jdField_a_of_type_Int) }));
    AdThreadManager.INSTANCE.postDelayed(new GdtDeviceInfoHelper.1(paramLong), 4, paramLong);
  }
  
  private static void b(Context paramContext, aate paramaate, aatf paramaatf)
  {
    boolean bool2 = false;
    if ((paramContext == null) || (paramaate == null) || (paramaatf == null) || (paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null)) {
      return;
    }
    paramaate = ampk.a("gdt_tangram");
    if ((paramaate != null) && (paramaate.a != null))
    {
      qq_ad_get.QQAdGet.DeviceInfo.Location localLocation = new qq_ad_get.QQAdGet.DeviceInfo.Location();
      localLocation.coordinates_type.set(0);
      localLocation.latitude.set(Double.valueOf(paramaate.a.jdField_a_of_type_Double * 1000000.0D).intValue());
      localLocation.longitude.set(Double.valueOf(paramaate.a.b * 1000000.0D).intValue());
      paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.location.set(localLocation);
    }
    boolean bool1 = bool2;
    if (paramaate != null)
    {
      bool1 = bool2;
      if (paramaate.a != null) {
        bool1 = true;
      }
    }
    paramaatf = paramaatf.jdField_a_of_type_JavaUtilList;
    if (bool1) {}
    for (long l = System.currentTimeMillis() - paramaate.a.jdField_a_of_type_Long;; l = -2147483648L)
    {
      paramaatf.add(AdReporterForAnalysis.createEventForLocation(paramContext, bool1, l));
      return;
    }
  }
  
  private static int c(aatb paramaatb)
  {
    int j = d(paramaatb);
    int i = j;
    if (j == 0)
    {
      i = j;
      if (TextUtils.isEmpty(paramaatb.b)) {
        i = 1;
      }
    }
    return i;
  }
  
  private static void c(Context paramContext, aate paramaate, aatf paramaatf)
  {
    int j = -2147483648;
    if ((paramContext == null) || (paramaate == null) || (paramaatf == null) || (paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null)) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = paramaate.jdField_a_of_type_JavaLangString;
    paramaate = aasy.a().a((String)localObject);
    int k;
    if (paramaate != null)
    {
      aase.b(jdField_a_of_type_JavaLangString, String.format("fillDeviceInfoWithAidTicketAndTaidTicket businessId:%s errorCodeOfTicketEntity:%d expiredTimestampOfTicketEntity:%d aidTicket:%s taidTicket:%s", new Object[] { localObject, Integer.valueOf(paramaate.jdField_a_of_type_Int), Long.valueOf(paramaate.jdField_a_of_type_Long), paramaate.jdField_a_of_type_JavaLangString, paramaate.b }));
      if (!TextUtils.isEmpty(paramaate.jdField_a_of_type_JavaLangString)) {
        paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.aid_ticket.set(paramaate.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramaate.b)) {
        paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.taid_ticket.set(paramaate.b);
      }
      l = System.currentTimeMillis() - l;
      localObject = paramaatf.jdField_a_of_type_JavaUtilList;
      k = b(paramaate);
      if (paramaate == null) {
        break label262;
      }
    }
    label262:
    for (int i = paramaate.jdField_a_of_type_Int;; i = -2147483648)
    {
      ((List)localObject).add(AdReporterForAnalysis.createEventForAidTicket(paramContext, k, i, l));
      paramaatf = paramaatf.jdField_a_of_type_JavaUtilList;
      k = c(paramaate);
      i = j;
      if (paramaate != null) {
        i = paramaate.jdField_a_of_type_Int;
      }
      paramaatf.add(AdReporterForAnalysis.createEventForTaidTicket(paramContext, k, i, l));
      return;
      aase.d(jdField_a_of_type_JavaLangString, String.format("fillDeviceInfoWithAidTicketAndTaidTicket return null, businessId:%s", new Object[] { localObject }));
      break;
    }
  }
  
  private static int d(aatb paramaatb)
  {
    if (paramaatb == null) {}
    do
    {
      return 1;
      if (paramaatb.jdField_a_of_type_Int == 0) {
        return 0;
      }
      if (paramaatb.jdField_a_of_type_Int == -10001) {
        return 6;
      }
      if (paramaatb.jdField_a_of_type_Int == -10008) {
        return 8;
      }
      if (paramaatb.jdField_a_of_type_Int == -10009) {
        return 7;
      }
      if (paramaatb.jdField_a_of_type_Int == 10010) {
        return 5;
      }
      if (paramaatb.jdField_a_of_type_Int == -10011) {
        return 2;
      }
      if ((paramaatb.jdField_a_of_type_Int == -10004) || (paramaatb.jdField_a_of_type_Int == -10012) || (paramaatb.jdField_a_of_type_Int == -21052) || (paramaatb.jdField_a_of_type_Int == -22056)) {
        return 3;
      }
      if (paramaatb.jdField_a_of_type_Int == -30014) {
        return 10;
      }
      if (paramaatb.jdField_a_of_type_Int == -2147483648) {
        return 4;
      }
      if (paramaatb.jdField_a_of_type_Int == -2147483647) {
        return 9;
      }
      if (paramaatb.jdField_a_of_type_Int == -2147483646) {
        return 205;
      }
    } while (paramaatb.jdField_a_of_type_Int != -2147483645);
    return 206;
  }
  
  private static void d(Context paramContext, aate paramaate, aatf paramaatf)
  {
    if ((paramContext == null) || (paramaate == null) || (paramaatf == null) || (paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null)) {
      return;
    }
    if (!TextUtils.isEmpty(aash.a())) {
      paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.qq_ver.set(aash.a());
    }
    paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.app_version_id.set(AppSetting.a());
    paramaatf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.is_googleplay_version.set(false);
  }
  
  private static void e(Context paramContext, aate paramaate, aatf paramaatf)
  {
    if ((paramaate != null) && (!TextUtils.isEmpty(paramaate.jdField_a_of_type_JavaLangString))) {}
    for (String str = paramaate.jdField_a_of_type_JavaLangString; (paramaate == null) || (paramaatf == null) || (paramaatf.jdField_a_of_type_JavaUtilList == null) || (paramaatf.jdField_a_of_type_JavaUtilList.isEmpty()); str = "null") {
      return;
    }
    long l = System.currentTimeMillis();
    try
    {
      paramaate = (Long)jdField_a_of_type_JavaUtilMap.get(str);
      if ((paramaate != null) && (l - paramaate.longValue() < 60000L)) {
        return;
      }
    }
    finally {}
    jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(l));
    aase.b(jdField_a_of_type_JavaLangString, String.format("reportForAnalysis businessId:%s", new Object[] { str }));
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), paramaatf.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aatd
 * JD-Core Version:    0.7.0.1
 */