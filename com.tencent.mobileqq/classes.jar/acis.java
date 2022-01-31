import com.tencent.mobileqq.extendfriend.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.RspBody;
import com.tencent.qphone.base.util.QLog;

public class acis
  extends ExtendFriendObserver
{
  public acis(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  protected void a(boolean paramBoolean, ExtendFriendSquareInfo.RspBody paramRspBody)
  {
    try
    {
      ExtendFriendSquareFragment.a(this.a, paramBoolean, paramRspBody);
      return;
    }
    catch (Exception paramRspBody)
    {
      QLog.e("ExtendFriendSquareFragment", 1, "onGetSquareStrangerList exception", paramRspBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acis
 * JD-Core Version:    0.7.0.1
 */