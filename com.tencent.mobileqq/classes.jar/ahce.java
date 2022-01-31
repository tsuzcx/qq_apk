import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class ahce
  implements INetEngine.INetEngineListener
{
  ahce(ahcd paramahcd) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleResMgr", 2, "onResp  mResult: " + paramNetResp.jdField_a_of_type_Int + " url:" + this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceUrl);
    }
    int i = j;
    Object localObject;
    String str1;
    String str2;
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      localObject = "";
      if (this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.resType == 1) {
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr.b(this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.resType, this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceId);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.resType == 2) {
        localObject = ScribbleResMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr, this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceId);
      }
      str1 = this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceMd5;
      str2 = FileUtils.b((String)localObject);
      if ((TextUtils.isEmpty(str2)) || (!str2.equalsIgnoreCase(str1))) {
        break label369;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.resType != 2) {
        break label459;
      }
      str1 = ScribbleResMgr.b(this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr, this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceId);
      i = ZipUtils.a((String)localObject, str1);
      if (i == 0) {
        break label459;
      }
      QLog.e("ScribbleResMgr", 2, "unzip failed, filepath=" + (String)localObject + " destDir= " + str1 + " result: " + i);
    }
    label459:
    for (i = 0;; i = 1)
    {
      if (i != 0) {}
      for (i = 1;; i = 2)
      {
        j = i;
        localObject = (PreDownloadController)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(192);
        i = j;
        if (((PreDownloadController)localObject).a())
        {
          ((PreDownloadController)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceUrl, paramNetResp.jdField_a_of_type_Long);
          i = j;
        }
        if (paramNetResp.jdField_a_of_type_Int == 3) {
          i = 4;
        }
        ScribbleResMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr, this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo, i);
        return;
        label369:
        if (str2 == null) {}
        for (localObject = "";; localObject = str2)
        {
          if (str1 == null) {
            str1 = "";
          }
          for (;;)
          {
            QLog.e("ScribbleResMgr", 2, "onResp url: " + this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr$ResInfo.sourceUrl + "check wrong md5 =" + (String)localObject + " desMd5 = " + str1);
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahce
 * JD-Core Version:    0.7.0.1
 */