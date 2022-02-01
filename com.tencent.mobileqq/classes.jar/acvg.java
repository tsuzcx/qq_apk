import com.tencent.ad.tangram.Ad;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public class acvg
{
  public static void a(acvh paramacvh)
  {
    if ((paramacvh == null) || (!paramacvh.a()))
    {
      acvc.d("GdtActionReporter", "report error");
      return;
    }
    Object localObject1 = paramacvh.jdField_a_of_type_ComTencentAdTangramAd.getUrlForAction();
    try
    {
      Object localObject2 = ((String)localObject1).replace("__TRACE_ID__", URLEncoder.encode(paramacvh.jdField_a_of_type_ComTencentAdTangramAd.getTraceId(), "utf-8")).replace("__PAGE_ACTION_ID__", String.valueOf(paramacvh.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.get()));
      localObject1 = localObject2;
      if (paramacvh.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.has()) {
        localObject1 = ((String)localObject2).replace("__PAGE_TIME__", String.valueOf(paramacvh.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.get()));
      }
      localObject2 = localObject1;
      if (paramacvh.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.has()) {
        localObject2 = ((String)localObject1).replace("__LANDING_ERROR_CODE__", String.valueOf(paramacvh.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.get()));
      }
      paramacvh = ((String)localObject2).replace("__OS_TYPE__", String.valueOf(2)).replace("__VERSION__", URLEncoder.encode(acvf.a(), "utf-8"));
      acvc.b("GdtActionReporter", "GdtActionReporter report url = " + paramacvh);
      GdtReporter.doCgiReport(paramacvh);
      return;
    }
    catch (UnsupportedEncodingException paramacvh)
    {
      acvc.d("GdtActionReporter", "report error", paramacvh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvg
 * JD-Core Version:    0.7.0.1
 */