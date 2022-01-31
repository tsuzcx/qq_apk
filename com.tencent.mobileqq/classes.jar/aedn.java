import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.RandomDrawableParam;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class aedn
  extends DownloadListener
{
  aedn(aedm paramaedm, String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onDone.【pngZip】");
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Aedm.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager)
      {
        if (this.jdField_a_of_type_Aedm.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.a != null)
        {
          if (paramDownloadTask.a() != 3) {
            this.jdField_a_of_type_Aedm.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.a.obtainMessage(226, this.jdField_a_of_type_Aedm.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
          }
        }
        else {
          return;
        }
      }
      try
      {
        FileUtils.a(this.jdField_a_of_type_JavaLangString, EmoticonUtils.z.replace("[epId]", this.jdField_a_of_type_Aedm.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString), false);
        new File(this.jdField_a_of_type_JavaLangString).delete();
        this.jdField_a_of_type_Aedm.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.b(this.jdField_a_of_type_Aedm.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.a.epId);
        this.jdField_a_of_type_Aedm.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.a.obtainMessage(225, this.jdField_a_of_type_Aedm.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
        continue;
        paramDownloadTask = finally;
        throw paramDownloadTask;
      }
      catch (IOException paramDownloadTask)
      {
        for (;;)
        {
          paramDownloadTask.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedn
 * JD-Core Version:    0.7.0.1
 */