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

class adnv
  extends JobSegment<axeh, axeh>
{
  protected void a(JobContext paramJobContext, axeh paramaxeh)
  {
    if (paramaxeh.a())
    {
      notifyResult(paramaxeh);
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
        int i = Integer.parseInt(paramaxeh.jdField_a_of_type_JavaLangString);
        oidb_0xb60.ReqBody localReqBody = new oidb_0xb60.ReqBody();
        localReqBody.get_privilege_req.setHasFlag(true);
        localReqBody.get_privilege_req.appid.set(i);
        localReqBody.get_privilege_req.app_type.set(paramaxeh.jdField_a_of_type_Int);
        if (paramaxeh.jdField_a_of_type_Int == 1)
        {
          oidb_0xb60.ClientInfo localClientInfo = new oidb_0xb60.ClientInfo();
          localClientInfo.platform.set(1);
          if (!TextUtils.isEmpty(paramaxeh.k)) {
            localClientInfo.sdk_version.set(paramaxeh.k);
          }
          if (!TextUtils.isEmpty(paramaxeh.i)) {
            localClientInfo.android_package_name.set(paramaxeh.i);
          }
          if (!TextUtils.isEmpty(paramaxeh.j)) {
            localClientInfo.android_signature.set(paramaxeh.j);
          }
          localReqBody.client_info.set(localClientInfo);
        }
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "send type=" + paramaxeh.jdField_a_of_type_Int + ", appid=" + paramaxeh.jdField_a_of_type_JavaLangString);
        }
        nkm.a(paramJobContext, new adnw(this, paramaxeh), localReqBody.toByteArray(), "OidbSvc.0xb60_1", 2912, 1, null, 0L);
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
 * Qualified Name:     adnv
 * JD-Core Version:    0.7.0.1
 */