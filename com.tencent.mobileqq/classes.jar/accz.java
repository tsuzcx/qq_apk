import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;

public class accz
  implements Runnable
{
  public accz(EmojiManager paramEmojiManager, boolean paramBoolean, String paramString, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject1;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = EmoticonUtils.c.replace("[epId]", this.jdField_a_of_type_JavaLangString);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a().a((String)localObject1);
      if ((localObject2 == null) || (((DownloadTask)localObject2).b())) {
        break label102;
      }
    }
    label102:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label107;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson|epId is in downloading:" + this.jdField_a_of_type_JavaLangString);
      }
      return;
      localObject1 = EmosmUtils.a(this.jdField_a_of_type_JavaLangString);
      break;
    }
    label107:
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson|emoPackage is not exist:" + this.jdField_a_of_type_JavaLangString);
      }
      localObject2 = new EmoticonPackage();
      ((EmoticonPackage)localObject2).epId = this.jdField_a_of_type_JavaLangString;
      ((EmoticonPackage)localObject2).status = 0;
      if (this.jdField_a_of_type_Int != 0) {
        break label382;
      }
      ((EmoticonPackage)localObject2).aio = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a().a((EmoticonPackage)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson epId:" + ((EmoticonPackage)localObject2).epId);
      }
      localObject1 = new DownloadTask((String)localObject1, new File(EmoticonUtils.r.replace("[epId]", this.jdField_a_of_type_JavaLangString)));
      localObject3 = new Bundle();
      ((Bundle)localObject3).putInt("jsonType", this.b);
      ((Bundle)localObject3).putSerializable("emoticonPackage", (Serializable)localObject2);
      ((Bundle)localObject3).putBoolean("isSmallEmotion", this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        ((Bundle)localObject3).putBundle("jsonReqParams", this.jdField_a_of_type_AndroidOsBundle);
      }
      ((DownloadTask)localObject1).e = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.d;
      ((DownloadTask)localObject1).l = true;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a().a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject3);
      return;
      label382:
      if (this.jdField_a_of_type_Int == 1) {
        ((EmoticonPackage)localObject2).kandian = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     accz
 * JD-Core Version:    0.7.0.1
 */