import android.view.View;
import android.widget.ImageView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtReporter;

class ackx
  implements acri
{
  ackx(ackt paramackt, ImageView paramImageView) {}
  
  public void reportImpression(View paramView)
  {
    paramView = paramView.getTag(2131380927);
    if ((paramView != null) && ((paramView instanceof GdtAd)))
    {
      paramView = (GdtAd)paramView;
      GdtReporter.doCgiReport(ackt.a(this.jdField_a_of_type_Ackt).b(paramView.getUrlForImpression(), this.jdField_a_of_type_Ackt.a(this.jdField_a_of_type_AndroidWidgetImageView)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackx
 * JD-Core Version:    0.7.0.1
 */