import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class ahva
  implements Runnable
{
  public ahva(ScribbleResMgr paramScribbleResMgr, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ScribbleResMgr.b(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr, this.jdField_a_of_type_Int, 0, true);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new ahvb(this);
    localHttpNetReq.jdField_a_of_type_JavaLangString = "";
    localHttpNetReq.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Int == 3)
    {
      localHttpNetReq.jdField_a_of_type_JavaLangString = ScribbleResMgr.e(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr);
      localHttpNetReq.jdField_c_of_type_JavaLangString = ScribbleResMgr.a(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr);
    }
    if (this.jdField_a_of_type_Int == 4)
    {
      localHttpNetReq.jdField_a_of_type_JavaLangString = ScribbleResMgr.f(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr);
      localHttpNetReq.jdField_c_of_type_JavaLangString = ScribbleResMgr.c(this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr);
    }
    localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).a(localHttpNetReq);
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleResMgrdownloading", 2, "startDownloadhttpscribbleRes, url: " + localHttpNetReq.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahva
 * JD-Core Version:    0.7.0.1
 */