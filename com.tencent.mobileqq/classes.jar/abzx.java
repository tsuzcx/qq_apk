import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.report.AdRefreshCallback;
import com.tencent.ad.tangram.canvas.report.AdReportAdapter;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;
import com.tencent.gdtad.aditem.GdtAd;

public class abzx
  implements AdReportAdapter
{
  public void downloadReport(Ad paramAd, String paramString, int paramInt, boolean paramBoolean, AdAppBtnData paramAdAppBtnData)
  {
    if ((!(paramAd instanceof GdtAd)) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    acix.a().a(paramString, (GdtAd)paramAd, paramAdAppBtnData);
    acix.a().a((GdtAd)paramAd, paramInt, paramBoolean);
  }
  
  public AdRefreshCallback getAdReportAdapter()
  {
    return acix.a();
  }
  
  public void reportForCanvasDataBuildEnd(Context paramContext, Ad paramAd, long paramLong) {}
  
  public void reportForCanvasDataBuildError(Context paramContext, int paramInt, Ad paramAd, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzx
 * JD-Core Version:    0.7.0.1
 */