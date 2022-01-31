import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;

public class akvr
  implements URLDrawableDownListener
{
  public akvr(ProfileCardMoreInfoView paramProfileCardMoreInfoView, String paramString, URLImageView paramURLImageView) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("Q.profilecard.FrdProfileCard", 1, "showDiamondImage onLoadFailed iconUrl = " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akvr
 * JD-Core Version:    0.7.0.1
 */