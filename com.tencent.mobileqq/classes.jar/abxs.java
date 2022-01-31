import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.oidb_0xb60.GetPrivilegeRsp;
import tencent.im.oidb.oidb_0xb60.RspBody;

class abxs
  extends nac
{
  abxs(abxr paramabxr, auef paramauef) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "onResult type=" + this.jdField_a_of_type_Auef.jdField_a_of_type_Int + ", appid=" + this.jdField_a_of_type_Auef.jdField_a_of_type_JavaLangString + ", code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      abxr.a(this.jdField_a_of_type_Abxr, new AppInfoError(6, "jobApiPermission req error"));
      if ((QLog.isColorLevel()) && (paramArrayOfByte == null)) {
        break label513;
      }
    }
    for (;;)
    {
      Object localObject;
      try
      {
        paramBundle = ((oidb_0xb60.RspBody)new oidb_0xb60.RspBody().mergeFrom(paramArrayOfByte)).wording.get();
        localObject = new StringBuilder().append("req error code=").append(paramInt);
        if (paramArrayOfByte == null)
        {
          paramArrayOfByte = ", data=null";
          QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, paramArrayOfByte);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle = "";
        continue;
        paramArrayOfByte = ", msg=" + paramBundle;
        continue;
      }
      paramBundle = new oidb_0xb60.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if ((paramBundle.get_privilege_rsp.api_groups.has()) && (paramBundle.get_privilege_rsp.next_req_duration.has())) {
          break label297;
        }
        abxr.b(this.jdField_a_of_type_Abxr, new AppInfoError(6, "jobApiPermission rsp invalid"));
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "rsp invalid");
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        abxr.c(this.jdField_a_of_type_Abxr, new AppInfoError(6, "jobApiPermission parse rsp error"));
      }
      if (QLog.isColorLevel())
      {
        QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "parse rsp error", paramArrayOfByte);
        return;
        label297:
        if (QLog.isColorLevel()) {
          QLog.d("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "receive api_groups:" + paramBundle.get_privilege_rsp.api_groups.get() + ", api_names:" + paramBundle.get_privilege_rsp.api_names.get());
        }
        paramArrayOfByte = abxj.a();
        paramArrayOfByte.a(paramBundle.get_privilege_rsp.api_groups.get(), this.jdField_a_of_type_Auef.jdField_a_of_type_JavaUtilSet);
        if (paramBundle.get_privilege_rsp.api_names.size() > 0)
        {
          localObject = paramBundle.get_privilege_rsp.api_names.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            if (abxj.a(paramArrayOfByte, str)) {
              this.jdField_a_of_type_Auef.jdField_a_of_type_JavaUtilSet.add(str);
            }
          }
        }
        this.jdField_a_of_type_Auef.c = (NetConnInfoCenter.getServerTimeMillis() + Math.max(paramBundle.get_privilege_rsp.next_req_duration.get() * 1000L, 300000L));
        auek.a().a(this.jdField_a_of_type_Auef);
        abxr.a(this.jdField_a_of_type_Abxr, this.jdField_a_of_type_Auef);
        return;
        label513:
        paramBundle = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxs
 * JD-Core Version:    0.7.0.1
 */