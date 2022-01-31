import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class ahuy
  implements Runnable
{
  public ahuy(ScribbleResMgr paramScribbleResMgr, ScribbleResMgr.ResInfo paramResInfo) {}
  
  public void run()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = ScribbleResMgr.b(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.resType, this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceId);
    if (FileUtils.a((String)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScribbleResMgr", 2, "res exist, return:" + this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceId + " " + this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.resType + " file:" + (String)localObject2 + " url:" + this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceUrl);
      }
      localObject1 = (PreDownloadController)((QQAppInterface)localObject1).getManager(192);
      if (((PreDownloadController)localObject1).a()) {
        ((PreDownloadController)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceUrl, FileUtils.b((String)localObject2));
      }
      ScribbleResMgr.a(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr, this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo, 1);
    }
    do
    {
      return;
      ScribbleResMgr.b(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr, this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.resType, this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceId, true);
      localObject2 = new HttpNetReq();
      ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new ahuz(this);
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceUrl;
      ((HttpNetReq)localObject2).jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.resType == 1) {
        ((HttpNetReq)localObject2).jdField_c_of_type_JavaLangString = ScribbleResMgr.b(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.resType, this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceId);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.resType == 2) {
        ((HttpNetReq)localObject2).jdField_c_of_type_JavaLangString = ScribbleResMgr.a(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceId);
      }
      ScribbleResMgr.a(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr, ((HttpNetReq)localObject2).jdField_c_of_type_JavaLangString);
      ((HttpNetReq)localObject2).jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
      ((QQAppInterface)localObject1).getNetEngine(0).a((NetReq)localObject2);
    } while (!QLog.isColorLevel());
    QLog.i("ScribbleResMgrdownloading", 2, "starthttpDownloadscribbleRes, url: " + this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuy
 * JD-Core Version:    0.7.0.1
 */