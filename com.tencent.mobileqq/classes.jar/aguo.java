import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;

public class aguo
  implements Runnable
{
  public aguo(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a(this.jdField_a_of_type_JavaLangString, false);
    if (localObject != null)
    {
      localObject = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.getResources(), (Bitmap)localObject);
      BaseApplicationImpl.sImageCache.put(this.jdField_a_of_type_JavaLangString, localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.obtainMessage();
      ((Message)localObject).what = 28;
      ((Message)localObject).arg1 = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.sendMessage((Message)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aguo
 * JD-Core Version:    0.7.0.1
 */