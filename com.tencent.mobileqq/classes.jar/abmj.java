import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.contactsync.ContactSyncManager;

public class abmj
  extends Handler
{
  public abmj(ContactSyncManager paramContactSyncManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      ContactSyncManager.a(this.a);
      return;
    }
    ContactSyncManager.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abmj
 * JD-Core Version:    0.7.0.1
 */