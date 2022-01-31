import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.qphone.base.util.QLog;

class acre
  implements Runnable
{
  acre(acrd paramacrd) {}
  
  public void run()
  {
    try
    {
      ExtendFriendSquareFragment.a(this.a.a).a(0, true);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendSquareFragment", 1, "onScrolled fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acre
 * JD-Core Version:    0.7.0.1
 */