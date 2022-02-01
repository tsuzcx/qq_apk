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

class adex
  extends JobSegment<awlp, awlp>
{
  protected void a(JobContext paramJobContext, awlp paramawlp)
  {
    if (paramawlp.a())
    {
      notifyResult(paramawlp);
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
        int i = Integer.parseInt(paramawlp.jdField_a_of_type_JavaLangString);
        oidb_0xb60.ReqBody localReqBody = new oidb_0xb60.ReqBody();
        localReqBody.get_privilege_req.setHasFlag(true);
        localReqBody.get_privilege_req.appid.set(i);
        localReqBody.get_privilege_req.app_type.set(paramawlp.jdField_a_of_type_Int);
        if (paramawlp.jdField_a_of_type_Int == 1)
        {
          oidb_0xb60.ClientInfo localClientInfo = new oidb_0xb60.ClientInfo();
          localClientInfo.platform.set(1);
          if (!TextUtils.isEmpty(paramawlp.k)) {
            localClientInfo.sdk_version.set(paramawlp.k);
          }
          if (!TextUtils.isEmpty(paramawlp.i)) {
            localClientInfo.android_package_name.set(paramawlp.i);
          }
          if (!TextUtils.isEmpty(paramawlp.j)) {
            localClientInfo.android_signature.set(paramawlp.j);
          }
          localReqBody.client_info.set(localClientInfo);
        }
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "send type=" + paramawlp.jdField_a_of_type_Int + ", appid=" + paramawlp.jdField_a_of_type_JavaLangString);
        }
        nir.a(paramJobContext, new adey(this, paramawlp), localReqBody.toByteArray(), "OidbSvc.0xb60_1", 2912, 1, null, 0L);
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
 * Qualified Name:     adex
 * JD-Core Version:    0.7.0.1
 */