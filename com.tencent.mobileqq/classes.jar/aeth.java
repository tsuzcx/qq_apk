import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SendMenuEventResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class aeth
  implements BusinessObserver
{
  aeth(aert paramaert) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "requestQidiKefu ... onReceive = " + paramBoolean);
    }
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        mobileqq_mp.SendMenuEventResponse localSendMenuEventResponse = new mobileqq_mp.SendMenuEventResponse();
        localSendMenuEventResponse.mergeFrom(paramBundle);
        paramInt = localSendMenuEventResponse.ret_info.ret_code.get();
        if (QLog.isColorLevel()) {
          QLog.d(this.a.a, 2, "requestQidiKefu ... onReceive: retCode = " + paramInt);
        }
        if (paramInt == 0)
        {
          this.a.ap = true;
          this.a.bE();
          this.a.bp();
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
    this.a.B(2131695569);
    this.a.bp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeth
 * JD-Core Version:    0.7.0.1
 */