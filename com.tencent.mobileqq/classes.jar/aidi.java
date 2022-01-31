import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aidi
  implements Runnable
{
  public aidi(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.DoodleInfo paramDoodleInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo, true)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable = true;
    }
    do
    {
      return;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new aidj(this);
      localHttpNetReq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl;
      localHttpNetReq.jdField_a_of_type_Int = 0;
      localHttpNetReq.jdField_c_of_type_JavaLangString = new File(PtvTemplateManager.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleName).getPath();
      localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).a(localHttpNetReq);
    } while (!QLog.isColorLevel());
    QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "startDownloadTemplate, url: " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aidi
 * JD-Core Version:    0.7.0.1
 */