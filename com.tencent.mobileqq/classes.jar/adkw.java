import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.forward.ForwardMarketFaceOption;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class adkw
  implements Runnable
{
  public adkw(ForwardMarketFaceOption paramForwardMarketFaceOption, QQCustomDialog paramQQCustomDialog, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImage(this.jdField_a_of_type_ComTencentImageURLDrawable);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new adkx(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adkw
 * JD-Core Version:    0.7.0.1
 */