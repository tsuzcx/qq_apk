import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.forward.ForwardShortVideoOption;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

class admk
  implements Runnable
{
  admk(admj paramadmj) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentImageURLDrawable.setBounds(0, 0, this.a.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicWidth(), this.a.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicHeight());
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImage(this.a.jdField_a_of_type_ComTencentImageURLDrawable, true, 0, true);
    if (this.a.jdField_a_of_type_Boolean)
    {
      if ((this.a.jdField_a_of_type_Int != 0) && (this.a.b != 0))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setVideoFormat(true, false, ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardShortVideoOption.a, this.a.jdField_a_of_type_Int), ShortVideoUtils.a(this.a.b * 1000));
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setVideoFormat(true, false, null, null);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setVideoFormat(true, false, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     admk
 * JD-Core Version:    0.7.0.1
 */