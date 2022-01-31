import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ahyy
  implements Runnable
{
  public ahyy(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, AppInterface paramAppInterface) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = true;
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = false;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new ahyz(this);
      localHttpNetReq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl;
      localHttpNetReq.jdField_a_of_type_Int = 0;
      localHttpNetReq.jdField_c_of_type_JavaLangString = new File(PtvTemplateManager.a, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name).getPath();
      localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).a(localHttpNetReq);
    } while (!QLog.isColorLevel());
    QLog.i("PtvTemplateManager", 2, "startDownloadTemplate, url: " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahyy
 * JD-Core Version:    0.7.0.1
 */