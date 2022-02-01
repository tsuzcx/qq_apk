import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtReporter;

class actf
  implements acvm
{
  actf(acsz paramacsz) {}
  
  public void reportImpression(View paramView)
  {
    paramView = paramView.getTag(2131381107);
    if ((paramView != null) && ((paramView instanceof GdtAd)))
    {
      paramView = (GdtAd)paramView;
      GdtReporter.doCgiReport(new acrv().a(paramView.getUrlForImpression()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actf
 * JD-Core Version:    0.7.0.1
 */