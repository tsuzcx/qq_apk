import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipFunCallPreviewActivity;

public class aksz
  implements Runnable
{
  public aksz(VipFunCallPreviewActivity paramVipFunCallPreviewActivity, int paramInt) {}
  
  public void run()
  {
    BitmapDrawable localBitmapDrawable = null;
    Bitmap localBitmap = BitmapManager.a(VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallPreviewActivity.app, this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallPreviewActivity.jdField_a_of_type_Int, 9, null));
    if (localBitmap != null) {
      localBitmapDrawable = new BitmapDrawable(localBitmap);
    }
    if (localBitmapDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallPreviewActivity.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallPreviewActivity.jdField_a_of_type_AndroidOsHandler, 51, this.jdField_a_of_type_Int, 0, localBitmapDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aksz
 * JD-Core Version:    0.7.0.1
 */