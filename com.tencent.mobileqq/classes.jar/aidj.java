import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class aidj
  implements INetEngine.INetEngineListener
{
  aidj(aidi paramaidi) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "onResp url: " + this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl + " resultcode: " + paramNetResp.c);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable = this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo, false);
    if (this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable) {}
    try
    {
      ZipUtils.a(new File(PtvTemplateManager.b, this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleName), PtvTemplateManager.c);
      if (paramNetResp.jdField_a_of_type_Int == 0)
      {
        PreDownloadController localPreDownloadController = (PreDownloadController)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(192);
        if (localPreDownloadController.a()) {
          localPreDownloadController.a(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl, paramNetResp.jdField_a_of_type_Long);
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localIOException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aidj
 * JD-Core Version:    0.7.0.1
 */