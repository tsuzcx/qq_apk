import android.app.Activity;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.forward.ForwardShortVideoOption;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class admj
  implements Runnable
{
  public admj(ForwardShortVideoOption paramForwardShortVideoOption, URLDrawable paramURLDrawable, QQCustomDialog paramQQCustomDialog, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    URLDrawableHelper.a(this.jdField_a_of_type_ComTencentImageURLDrawable, null, false);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardShortVideoOption.a.runOnUiThread(new admk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     admj
 * JD-Core Version:    0.7.0.1
 */