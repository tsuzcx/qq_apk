import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtReporter;

class acfa
  implements achz
{
  acfa(acey paramacey) {}
  
  public void reportImpression(View paramView)
  {
    paramView = paramView.getTag(2131381181);
    if ((paramView instanceof GdtAd))
    {
      paramView = (GdtAd)paramView;
      GdtReporter.doCgiReport(new acds().a(paramView.getUrlForImpression()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfa
 * JD-Core Version:    0.7.0.1
 */