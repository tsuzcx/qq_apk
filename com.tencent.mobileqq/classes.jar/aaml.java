import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.report.AdRefreshCallback;
import com.tencent.ad.tangram.canvas.report.AdReportAdapter;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;
import com.tencent.gdtad.aditem.GdtAd;

public class aaml
  implements AdReportAdapter
{
  public void downloadReport(Ad paramAd, String paramString, int paramInt, boolean paramBoolean, AdAppBtnData paramAdAppBtnData)
  {
    if ((!(paramAd instanceof GdtAd)) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    aatr.a().a(paramString, (GdtAd)paramAd, paramAdAppBtnData);
    aatr.a().a((GdtAd)paramAd, paramInt, paramBoolean);
  }
  
  public AdRefreshCallback getAdReportAdapter()
  {
    return aatr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaml
 * JD-Core Version:    0.7.0.1
 */