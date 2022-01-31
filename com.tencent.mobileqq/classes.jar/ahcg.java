import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class ahcg
  implements INetEngine.INetEngineListener
{
  ahcg(ahcf paramahcf) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    int j = 2;
    QLog.i("ScribbleResMgr", 2, "DownloadResIcon onResp resp.mResult:  " + paramNetResp.jdField_a_of_type_Int);
    int i = j;
    Object localObject;
    String str1;
    String str2;
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      localObject = "";
      str1 = "";
      if (this.a.jdField_a_of_type_Int == 3)
      {
        localObject = ScribbleResMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr);
        str1 = ScribbleResMgr.b(this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr);
      }
      if (this.a.jdField_a_of_type_Int == 4)
      {
        localObject = ScribbleResMgr.c(this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr);
        str1 = ScribbleResMgr.d(this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr);
      }
      str2 = FileUtils.b((String)localObject);
      if ((TextUtils.isEmpty(str2)) || (!str2.equalsIgnoreCase(str1))) {
        break label259;
      }
      str1 = ScribbleResMgr.a;
      i = ZipUtils.a((String)localObject, str1);
      if (i == 0) {
        break label334;
      }
      QLog.e("ScribbleResMgr", 2, "unZipFolder  failed, filepath=" + (String)localObject + " destDir= " + str1 + " result: " + i);
    }
    label259:
    label334:
    for (i = 0;; i = 1)
    {
      if (i != 0) {
        i = 1;
      }
      for (;;)
      {
        if (paramNetResp.jdField_a_of_type_Int == 3) {
          i = 4;
        }
        paramNetResp = new ScribbleResMgr.ResInfo();
        paramNetResp.resType = this.a.jdField_a_of_type_Int;
        paramNetResp.sourceId = 0;
        ScribbleResMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqScribbleScribbleResMgr, paramNetResp, i);
        return;
        if (str2 == null) {}
        for (localObject = "";; localObject = str2)
        {
          str2 = str1;
          if (str1 == null) {
            str2 = "";
          }
          QLog.e("ScribbleResMgr", 2, "check wrong md5 =" + (String)localObject + " desMd5 = " + str2);
          i = j;
          break;
        }
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahcg
 * JD-Core Version:    0.7.0.1
 */