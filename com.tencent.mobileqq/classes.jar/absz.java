import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class absz
  implements Runnable
{
  public absz(FavroamingManager paramFavroamingManager, String[] paramArrayOfString, TransferRequest paramTransferRequest) {}
  
  public void run()
  {
    if (!FileUtils.a(this.jdField_a_of_type_ArrayOfJavaLangString[1]))
    {
      Object localObject = new File(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      localObject = new DownloadTask(this.jdField_a_of_type_ArrayOfJavaLangString[0], (File)localObject);
      ((DownloadTask)localObject).l = true;
      if (DownloaderFactory.a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) {
        QLog.e("FavroamingManager", 1, "collectEmoji fail to download thumbFile: " + this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     absz
 * JD-Core Version:    0.7.0.1
 */