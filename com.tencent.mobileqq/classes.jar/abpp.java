import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtReporter;

class abpp
  implements abrw
{
  abpp(abpi paramabpi) {}
  
  public void reportImpression(View paramView)
  {
    paramView = paramView.getTag(2131380829);
    if ((paramView instanceof GdtAd))
    {
      paramView = (GdtAd)paramView;
      GdtReporter.doCgiReport(new aboe().a(paramView.getUrlForImpression()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpp
 * JD-Core Version:    0.7.0.1
 */