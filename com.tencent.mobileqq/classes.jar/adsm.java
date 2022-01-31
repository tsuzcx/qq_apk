import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class adsm
  implements Runnable
{
  public adsm(ForwardBaseOption paramForwardBaseOption, Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a.setPreviewImage(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.b);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adsm
 * JD-Core Version:    0.7.0.1
 */