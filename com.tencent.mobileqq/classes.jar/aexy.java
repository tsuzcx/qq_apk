import android.widget.RelativeLayout;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class aexy
  implements Runnable
{
  private int jdField_a_of_type_Int = 2;
  
  public aexy(ShortVideoCommentsView paramShortVideoCommentsView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      ShortVideoCommentsView.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).setVisibility(8);
      ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).setVisibility(8);
      return;
    case 0: 
      ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).setVisibility(8);
      ShortVideoCommentsView.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).setVisibility(0);
      return;
    }
    ShortVideoCommentsView.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).setVisibility(8);
    if ((ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView) != null) && (ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).jdField_a_of_type_Int != 4)) {
      ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).setVisibility(0);
    }
    ShortVideoCommentsView.d(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aexy
 * JD-Core Version:    0.7.0.1
 */