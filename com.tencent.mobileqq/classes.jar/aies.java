import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class aies
  implements BusinessObserver
{
  aies(aido paramaido) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "success:" + String.valueOf(paramBoolean));
    }
    boolean bool = true;
    if (!paramBoolean)
    {
      this.a.b(2131694983);
      paramBoolean = bool;
      if (paramBoolean) {
        this.a.b();
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
        paramBoolean = aido.a(this.a, true, paramInt);
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
 * Qualified Name:     aies
 * JD-Core Version:    0.7.0.1
 */