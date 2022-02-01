import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.c2s.GdtC2SReportInterface.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public final class acif
  implements achw
{
  public int a;
  public long a;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  public qq_ad_get.QQAdGetRsp.AdInfo a;
  public int b;
  private List<String> b;
  private List<String> c;
  
  public acif()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Long = -2147483648L;
  }
  
  private int a(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis();
    acid.a(BaseApplicationImpl.getApplication(), this, paramString);
    j = -1;
    i = j;
    for (;;)
    {
      try
      {
        acho.a("GdtC2SReporter", "index: " + paramInt + " mOpeType " + this.jdField_a_of_type_Int);
        i = j;
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        i = j;
        localHttpURLConnection.setRequestMethod("GET");
        i = j;
        localHttpURLConnection.setConnectTimeout(10000);
        i = j;
        localHttpURLConnection.setReadTimeout(10000);
        i = j;
        localHttpURLConnection.setUseCaches(false);
        i = j;
        localHttpURLConnection.setInstanceFollowRedirects(true);
        i = j;
        localHttpURLConnection.connect();
        i = j;
        j = localHttpURLConnection.getResponseCode();
        i = j;
        acho.a("GdtC2SReporter", "rspCode:  " + j + " index: " + paramInt + " mOpeType " + this.jdField_a_of_type_Int + " reportUrl =" + paramString);
        i = j;
        int k = this.jdField_a_of_type_Int;
        if (j != 200) {
          continue;
        }
        paramInt = 0;
        i = j;
        bdla.a(null, "dc00898", "", "", "0X8009B97", "0X8009B97", k, paramInt, "", "", this.jdField_a_of_type_JavaLangString, paramString);
      }
      catch (Throwable localThrowable)
      {
        acho.d("GdtC2SReporter", "c2sReport excetpion: " + localThrowable.getMessage());
        j = i;
        continue;
      }
      acid.a(BaseApplicationImpl.getApplication(), this, paramString, j, System.currentTimeMillis() - l);
      return j;
      paramInt = 1;
    }
  }
  
  private void a(List<String> paramList)
  {
    int i = -1;
    paramList = paramList.iterator();
    int j = 0;
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      j += 1;
      int k = a(str, j);
      i = k;
      if (k < 0) {
        i = a(str, j);
      }
      acid.a(BaseApplicationImpl.getApplication(), this, str, i);
    }
    bdla.a(null, "dc00898", "", "", "0X8009EBF", "0X8009EBF", this.jdField_a_of_type_Int, i, "", "", this.jdField_a_of_type_JavaLangString, "");
  }
  
  public void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = paramAdInfo;
    if (paramAdInfo == null) {}
    do
    {
      do
      {
        acid.a(BaseApplicationImpl.getApplication(), new GdtAd(paramAdInfo), paramInt1, paramInt2, false);
        return;
        this.jdField_a_of_type_JavaUtilList = paramAdInfo.report_info.thirdparty_monitor_urls.api_exposure_monitor_url.get();
        this.jdField_b_of_type_JavaUtilList = paramAdInfo.report_info.thirdparty_monitor_urls.api_click_monitor_url.get();
        this.c = paramAdInfo.report_info.thirdparty_monitor_urls.video_play_monitor_url.get();
        this.jdField_a_of_type_JavaLangString = Long.toString(paramAdInfo.report_info.trace_info.aid.get());
      } while (this.jdField_a_of_type_JavaLangString == null);
      if ((paramInt1 == 0) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_Int = paramInt1;
      }
      if ((paramInt1 == 1) && (this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_Int = paramInt1;
      }
      if ((paramInt1 == 2) && (this.c != null) && (this.c.size() > 0)) {
        this.jdField_a_of_type_Int = paramInt1;
      }
    } while (this.jdField_a_of_type_Int == -1);
    acho.a("GdtC2SReporter", "reportAsync for ADID: " + this.jdField_a_of_type_JavaLangString + ", operationType: " + paramInt1);
    acid.a(BaseApplicationImpl.getApplication(), new GdtAd(paramAdInfo), paramInt1, paramInt2, true);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ThreadManager.executeOnNetWorkThread(new GdtC2SReportInterface.1(this));
    bdla.a(null, "dc00898", "", "", "0X8009EBC", "0X8009EBC", this.jdField_a_of_type_Int, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acif
 * JD-Core Version:    0.7.0.1
 */