import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class agup
  implements Runnable
{
  public agup(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, List paramList, String paramString, int paramInt) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    Bitmap localBitmap1 = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a(ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_AndroidContentContext, (String)this.jdField_a_of_type_JavaUtilList.get(1)), true);
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a(ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_AndroidContentContext, (String)this.jdField_a_of_type_JavaUtilList.get(0)), true);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "ANIMATION_SCROLL time " + (SystemClock.elapsedRealtime() - l));
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localBitmap1 != null)
    {
      localObject1 = localObject2;
      if (localBitmap2 != null)
      {
        localObject1 = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.getResources(), localBitmap1);
        localObject1 = new TransitionDrawable(new Drawable[] { new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.getResources(), localBitmap2), localObject1 });
      }
    }
    if (localObject1 != null)
    {
      localObject1 = new Pair(localObject1, Integer.valueOf(Utils.a(localBitmap1) + Utils.a(localBitmap2)));
      BaseApplicationImpl.sImageCache.put(this.jdField_a_of_type_JavaLangString, localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject1).what = 29;
      ((Message)localObject1).arg1 = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agup
 * JD-Core Version:    0.7.0.1
 */