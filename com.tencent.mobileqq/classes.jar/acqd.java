import com.tencent.mobileqq.extendfriend.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class acqd
  extends ExtendFriendObserver
{
  public acqd(ExtendFriendGroupFragment paramExtendFriendGroupFragment) {}
  
  protected void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, long paramLong, boolean paramBoolean3)
  {
    try
    {
      ExtendFriendGroupFragment.a(this.a, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramList);
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("ExtendFriendGroupFragment", 1, "mExtendFriendObserver exception", paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqd
 * JD-Core Version:    0.7.0.1
 */