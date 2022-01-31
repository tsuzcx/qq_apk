import android.os.IBinder.DeathRecipient;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class acbh
  implements IBinder.DeathRecipient
{
  acbh(acbg paramacbg) {}
  
  public void binderDied()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("MessengerService$IncomingHandler", 2, "-->binder died");
      MessengerService.a((MessengerService)this.a.a.get());
      MessengerService.b((MessengerService)this.a.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acbh
 * JD-Core Version:    0.7.0.1
 */