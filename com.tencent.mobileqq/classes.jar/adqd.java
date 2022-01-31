import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.RandomDrawableParam;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import java.io.File;

public class adqd
  implements Runnable
{
  public adqd(PngFrameManager paramPngFrameManager, PngFrameManager.RandomDrawableParam paramRandomDrawableParam) {}
  
  public void run()
  {
    File localFile = new File(EmoticonUtils.r.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString));
    EmoticonManager localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    ??? = localEmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString);
    Object localObject1 = ???;
    if (??? == null)
    {
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString;
      ((EmoticonPackage)localObject1).aio = true;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.jdField_a_of_type_AndroidOsHandler != null)
      {
        if (!localFile.exists()) {
          break label165;
        }
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameUtil.a(localFile);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
        ((EmoticonPackage)localObject1).rscType = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_Int;
        localEmoticonManager.a((EmoticonPackage)localObject1);
      }
      label165:
      DownloadTask localDownloadTask;
      do
      {
        return;
        localDownloadTask = new DownloadTask(EmosmUtils.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString), localFile);
        localDownloadTask.h = true;
      } while ((DownloaderFactory.a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameUtil == null) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.jdField_a_of_type_AndroidOsHandler == null));
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameUtil.a(localFile);
      ((EmoticonPackage)localObject1).rscType = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_Int;
      localEmoticonManager.a((EmoticonPackage)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adqd
 * JD-Core Version:    0.7.0.1
 */