import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.widget.UpSideDownDrawable;

public final class alju
  implements Runnable
{
  public alju(RandomCoverView paramRandomCoverView, UpSideDownDrawable paramUpSideDownDrawable, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setImageDrawable(this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable.d();
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     alju
 * JD-Core Version:    0.7.0.1
 */