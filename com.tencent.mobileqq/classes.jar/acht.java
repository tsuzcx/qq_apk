import com.tencent.ad.tangram.Ad;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public class acht
{
  public static void a(achu paramachu)
  {
    if ((paramachu == null) || (!paramachu.a()))
    {
      acho.d("GdtActionReporter", "report error");
      return;
    }
    Object localObject1 = paramachu.jdField_a_of_type_ComTencentAdTangramAd.getUrlForAction();
    try
    {
      Object localObject2 = ((String)localObject1).replace("__TRACE_ID__", URLEncoder.encode(paramachu.jdField_a_of_type_ComTencentAdTangramAd.getTraceId(), "utf-8")).replace("__PAGE_ACTION_ID__", String.valueOf(paramachu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.get()));
      localObject1 = localObject2;
      if (paramachu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.has()) {
        localObject1 = ((String)localObject2).replace("__PAGE_TIME__", String.valueOf(paramachu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.get()));
      }
      localObject2 = localObject1;
      if (paramachu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.has()) {
        localObject2 = ((String)localObject1).replace("__LANDING_ERROR_CODE__", String.valueOf(paramachu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.get()));
      }
      paramachu = ((String)localObject2).replace("__OS_TYPE__", String.valueOf(2)).replace("__VERSION__", URLEncoder.encode(achs.a(), "utf-8"));
      acho.b("GdtActionReporter", "GdtActionReporter report url = " + paramachu);
      GdtReporter.doCgiReport(paramachu);
      return;
    }
    catch (UnsupportedEncodingException paramachu)
    {
      acho.d("GdtActionReporter", "report error", paramachu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acht
 * JD-Core Version:    0.7.0.1
 */