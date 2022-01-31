import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.ClientInfoA.EnvParamPacket;
import com.tencent.ims.ClientInfoA.ReportDetectResultPacket;
import com.tencent.mdm.m;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mqp.app.sec.SecClientInfoTask;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.security.MessageDigest;
import mqq.app.MobileQQ;

public class akzf
  implements Runnable
{
  public akzf(SecClientInfoTask paramSecClientInfoTask) {}
  
  public void run()
  {
    Object localObject1 = null;
    for (;;)
    {
      QQAppInterface localQQAppInterface;
      String str;
      ClientInfoA.ReportDetectResultPacket localReportDetectResultPacket;
      Object localObject3;
      try
      {
        localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localQQAppInterface == null) {
          return;
        }
        str = "" + SecClientInfoTask.a(this.a);
        localReportDetectResultPacket = new ClientInfoA.ReportDetectResultPacket();
        localObject3 = new ClientInfoA.EnvParamPacket();
        ((ClientInfoA.EnvParamPacket)localObject3).u32_platform.set(1);
        ((ClientInfoA.EnvParamPacket)localObject3).str_sysversion.set(Build.VERSION.RELEASE);
        ((ClientInfoA.EnvParamPacket)localObject3).str_qqversion.set("7.6.3.3560");
        ((ClientInfoA.EnvParamPacket)localObject3).u32_appid.set(AppSetting.a);
        ((ClientInfoA.EnvParamPacket)localObject3).bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
        ((ClientInfoA.EnvParamPacket)localObject3).str_uin.set(str);
        localReportDetectResultPacket.uint32_cmd.set(1);
        localReportDetectResultPacket.envParam.set((MessageMicro)localObject3);
        if (SecClientInfoTask.a(this.a) == 1)
        {
          localObject1 = SecClientInfoTask.a(SecClientInfoTask.b(this.a));
          if (localObject1 != null) {
            localReportDetectResultPacket.bytes_buffer.set(ByteStringMicro.copyFrom((byte[])localObject1));
          }
          localObject1 = new ToServiceMsg("mobileqq.service", str, "ClientInfoA.SecReport");
          if (localObject1 == null) {
            break;
          }
          ((ToServiceMsg)localObject1).putWupBuffer(localReportDetectResultPacket.toByteArray());
          ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
          ((ToServiceMsg)localObject1).setNeedCallback(false);
          localQQAppInterface.sendToService((ToServiceMsg)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      if (SecClientInfoTask.a(this.a) == 2)
      {
        if (!SecClientInfoTask.a())
        {
          SecClientInfoTask.a(m.a(localQQAppInterface.getApplication().getApplicationInfo().sourceDir));
          SecClientInfoTask.a(true);
        }
        if ((SecClientInfoTask.a() != null) && (SecClientInfoTask.a().length() > 0)) {
          localReportDetectResultPacket.str_qqmd5.set(SecClientInfoTask.a());
        }
        Object localObject2 = SecUtil.toHexString(NetConnInfoCenter.GUID).toLowerCase() + SecClientInfoTask.b(this.a);
        localObject3 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject3).update(((String)localObject2).getBytes());
        localReportDetectResultPacket.bytes_buffer.set(ByteStringMicro.copyFrom(((MessageDigest)localObject3).digest()));
        localObject2 = SecClientInfoTask.a(SecClientInfoTask.b(this.a) >> 1 & 0x7FFFFFFF);
        if (localObject2 != null) {
          localReportDetectResultPacket.bytes_buffer2.set(ByteStringMicro.copyFrom((byte[])localObject2));
        }
        localObject2 = new ToServiceMsg("mobileqq.service", str, "ClientInfoC.SecReport");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akzf
 * JD-Core Version:    0.7.0.1
 */