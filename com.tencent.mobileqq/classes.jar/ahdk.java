import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;

public class ahdk
  extends Handler
{
  public ahdk(SearchBaseFragment paramSearchBaseFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (SearchBaseFragment.a(this.a) != null) {
      SearchBaseFragment.a(this.a).sendMessage(Message.obtain(paramMessage));
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.a();
      return;
    case 1: 
      this.a.a((String)paramMessage.obj);
      return;
    case 2: 
      this.a.g();
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdk
 * JD-Core Version:    0.7.0.1
 */