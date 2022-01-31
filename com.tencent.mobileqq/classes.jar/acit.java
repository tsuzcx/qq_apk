import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class acit
  extends FriendListObserver
{
  public acit(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onUpdateAddFriend isSuccess=%s addSuccess=%s reqestUin=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString }));
    }
    paramString = ExtendFriendSquareFragment.a(this.a).a(ExtendFriendSquareFragment.a(this.a));
    if ((paramString != null) && (!paramString.c))
    {
      paramString.c = true;
      ExtendFriendSquareFragment.a(this.a).post(new aciu(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acit
 * JD-Core Version:    0.7.0.1
 */