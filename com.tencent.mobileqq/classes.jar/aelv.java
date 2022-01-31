import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngGifEngine;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class aelv
  extends DownloadListener
{
  aelv(aelu paramaelu) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onDone.【aio preview】");
    }
    synchronized (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.a != null)
      {
        if (paramDownloadTask.a() != 3) {
          this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.a.obtainMessage(226, this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
        }
      }
      else {
        return;
      }
      paramDownloadTask = PngGifEngine.a(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.a = paramDownloadTask;
      this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.a.obtainMessage(227, this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
      BaseApplicationImpl.sImageCache.put(this.a.jdField_a_of_type_JavaLangString, paramDownloadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aelv
 * JD-Core Version:    0.7.0.1
 */