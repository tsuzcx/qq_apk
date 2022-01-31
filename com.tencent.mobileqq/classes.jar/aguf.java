import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.34.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

public class aguf
  implements BusinessObserver
{
  aguf(agti paramagti) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("data");
        paramInt = paramBundle.getInt("type", 0);
        if (arrayOfByte == null) {
          continue;
        }
        paramBundle = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse();
        if (paramInt == 0) {
          paramBundle.mergeFrom(arrayOfByte);
        }
        for (paramBoolean = true; (paramBoolean) && (paramBundle.ret_info.has()) && (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.has()) && (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() == 0); paramBoolean = syb.a(arrayOfByte, localGetPublicAccountDetailInfoResponse, paramBundle))
        {
          ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountChatPie.34.1(this, paramBundle), 10L);
          return;
        }
        return;
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aguf
 * JD-Core Version:    0.7.0.1
 */