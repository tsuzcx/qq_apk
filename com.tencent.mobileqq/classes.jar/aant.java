import com.tencent.ad.tangram.Ad;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public class aant
{
  public static void a(aanu paramaanu)
  {
    if ((paramaanu == null) || (!paramaanu.a()))
    {
      aanp.d("GdtActionReporter", "report error");
      return;
    }
    Object localObject1 = paramaanu.jdField_a_of_type_ComTencentAdTangramAd.getUrlForAction();
    try
    {
      Object localObject2 = ((String)localObject1).replace("__TRACE_ID__", URLEncoder.encode(paramaanu.jdField_a_of_type_ComTencentAdTangramAd.getTraceId(), "utf-8")).replace("__PAGE_ACTION_ID__", String.valueOf(paramaanu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.get()));
      localObject1 = localObject2;
      if (paramaanu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.has()) {
        localObject1 = ((String)localObject2).replace("__PAGE_TIME__", String.valueOf(paramaanu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.get()));
      }
      localObject2 = localObject1;
      if (paramaanu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.has()) {
        localObject2 = ((String)localObject1).replace("__LANDING_ERROR_CODE__", String.valueOf(paramaanu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.get()));
      }
      paramaanu = ((String)localObject2).replace("__OS_TYPE__", String.valueOf(2)).replace("__VERSION__", URLEncoder.encode(aans.a(), "utf-8"));
      aanp.b("GdtActionReporter", "GdtActionReporter report url = " + paramaanu);
      aaob.a(paramaanu);
      return;
    }
    catch (UnsupportedEncodingException paramaanu)
    {
      aanp.d("GdtActionReporter", "report error", paramaanu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aant
 * JD-Core Version:    0.7.0.1
 */