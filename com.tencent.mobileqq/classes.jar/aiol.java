import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class aiol
  implements BusinessObserver
{
  aiol(ainh paramainh) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "success:" + String.valueOf(paramBoolean));
    }
    boolean bool = true;
    if (!paramBoolean)
    {
      this.a.A(2131694659);
      paramBoolean = bool;
      if (paramBoolean) {
        this.a.bp();
      }
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label139;
        }
        mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
        localFollowResponse.mergeFrom(paramBundle);
        paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        paramBoolean = ainh.a(this.a, true, paramInt);
      }
      catch (Exception paramBundle)
      {
        paramBoolean = bool;
      }
      break;
      label139:
      paramBoolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiol
 * JD-Core Version:    0.7.0.1
 */