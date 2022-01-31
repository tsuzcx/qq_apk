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

class aacf
  extends JobSegment<asiw, asiw>
{
  protected void a(JobContext paramJobContext, asiw paramasiw)
  {
    if (paramasiw.a())
    {
      notifyResult(paramasiw);
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
        int i = Integer.parseInt(paramasiw.jdField_a_of_type_JavaLangString);
        oidb_0xb60.ReqBody localReqBody = new oidb_0xb60.ReqBody();
        localReqBody.get_privilege_req.setHasFlag(true);
        localReqBody.get_privilege_req.appid.set(i);
        localReqBody.get_privilege_req.app_type.set(paramasiw.jdField_a_of_type_Int);
        if (paramasiw.jdField_a_of_type_Int == 1)
        {
          oidb_0xb60.ClientInfo localClientInfo = new oidb_0xb60.ClientInfo();
          localClientInfo.platform.set(1);
          if (!TextUtils.isEmpty(paramasiw.k)) {
            localClientInfo.sdk_version.set(paramasiw.k);
          }
          if (!TextUtils.isEmpty(paramasiw.i)) {
            localClientInfo.android_package_name.set(paramasiw.i);
          }
          if (!TextUtils.isEmpty(paramasiw.j)) {
            localClientInfo.android_signature.set(paramasiw.j);
          }
          localReqBody.client_info.set(localClientInfo);
        }
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "send type=" + paramasiw.jdField_a_of_type_Int + ", appid=" + paramasiw.jdField_a_of_type_JavaLangString);
        }
        mxf.a(paramJobContext, new aacg(this, paramasiw), localReqBody.toByteArray(), "OidbSvc.0xb60_1", 2912, 1, null, 0L);
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
 * Qualified Name:     aacf
 * JD-Core Version:    0.7.0.1
 */