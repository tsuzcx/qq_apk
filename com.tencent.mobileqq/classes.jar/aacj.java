import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import tencent.im.oidb.oidb_0xb60.ClientInfo;
import tencent.im.oidb.oidb_0xb60.GetPrivilegeReq;
import tencent.im.oidb.oidb_0xb60.ReqBody;

class aacj
  extends JobSegment<asiu, asiu>
{
  protected void a(JobContext paramJobContext, asiu paramasiu)
  {
    if (paramasiu.a())
    {
      notifyResult(paramasiu);
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "cache is valid");
      }
    }
    do
    {
      do
      {
        return;
        paramJobContext = BaseApplicationImpl.getApplication().getRuntime();
        if (paramJobContext != null) {
          break;
        }
        notifyError(new AppInfoError(6, "jobApiPermission app is null"));
      } while (!QLog.isColorLevel());
      QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "app is null");
      return;
      try
      {
        int i = Integer.parseInt(paramasiu.jdField_a_of_type_JavaLangString);
        oidb_0xb60.ReqBody localReqBody = new oidb_0xb60.ReqBody();
        localReqBody.get_privilege_req.setHasFlag(true);
        localReqBody.get_privilege_req.appid.set(i);
        localReqBody.get_privilege_req.app_type.set(paramasiu.jdField_a_of_type_Int);
        if (paramasiu.jdField_a_of_type_Int == 1)
        {
          oidb_0xb60.ClientInfo localClientInfo = new oidb_0xb60.ClientInfo();
          localClientInfo.platform.set(1);
          if (!TextUtils.isEmpty(paramasiu.k)) {
            localClientInfo.sdk_version.set(paramasiu.k);
          }
          if (!TextUtils.isEmpty(paramasiu.i)) {
            localClientInfo.android_package_name.set(paramasiu.i);
          }
          if (!TextUtils.isEmpty(paramasiu.j)) {
            localClientInfo.android_signature.set(paramasiu.j);
          }
          localReqBody.client_info.set(localClientInfo);
        }
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "send type=" + paramasiu.jdField_a_of_type_Int + ", appid=" + paramasiu.jdField_a_of_type_JavaLangString);
        }
        mxi.a(paramJobContext, new aack(this, paramasiu), localReqBody.toByteArray(), "OidbSvc.0xb60_1", 2912, 1, null, 0L);
        return;
      }
      catch (NumberFormatException paramJobContext)
      {
        notifyError(new AppInfoError(6, "jobApiPermission parse appid error"));
      }
    } while (!QLog.isColorLevel());
    QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "parse appid error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacj
 * JD-Core Version:    0.7.0.1
 */