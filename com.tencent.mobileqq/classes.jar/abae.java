import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.armap.POIInfo;
import com.tencent.mobileqq.armap.map.ARMapPOIStarDialog;
import com.tencent.qphone.base.util.QLog;

public class abae
  implements URLDrawableDownListener
{
  public abae(ARMapPOIStarDialog paramARMapPOIStarDialog, POIInfo paramPOIInfo) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARMapPOIStarDialog", 2, "URLDrawable load fail, url=" + this.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo.d);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARMapPOIStarDialog", 2, "URLDrawable load success, url=" + this.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abae
 * JD-Core Version:    0.7.0.1
 */