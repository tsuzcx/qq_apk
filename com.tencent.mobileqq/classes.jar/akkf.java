import android.os.Message;
import com.tencent.mobileqq.app.addfriendverifi.ui.NewFriendVerifyBlockedListFragment;
import mqq.os.MqqHandler;

public class akkf
  extends MqqHandler
{
  public akkf(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    NewFriendVerifyBlockedListFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akkf
 * JD-Core Version:    0.7.0.1
 */