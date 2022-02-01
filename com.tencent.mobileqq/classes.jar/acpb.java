import android.view.View;
import android.widget.ImageView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtReporter;

class acpb
  implements acvm
{
  acpb(acox paramacox, ImageView paramImageView) {}
  
  public void reportImpression(View paramView)
  {
    paramView = paramView.getTag(2131381107);
    if ((paramView != null) && ((paramView instanceof GdtAd)))
    {
      paramView = (GdtAd)paramView;
      GdtReporter.doCgiReport(acox.a(this.jdField_a_of_type_Acox).b(paramView.getUrlForImpression(), this.jdField_a_of_type_Acox.a(this.jdField_a_of_type_AndroidWidgetImageView)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpb
 * JD-Core Version:    0.7.0.1
 */