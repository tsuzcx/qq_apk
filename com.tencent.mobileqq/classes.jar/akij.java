import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.qphone.base.util.QLog;

public class akij
  implements URLDrawableDownListener
{
  public akij(VipGrayConfigHelper paramVipGrayConfigHelper, String paramString, URLImageView paramURLImageView) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("friends_king", 1, "namePlateOfKing drawable fail url = " + this.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     akij
 * JD-Core Version:    0.7.0.1
 */