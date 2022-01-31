import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.qcall.QCallFacade;

public class agvd
  extends FriendListObserver
{
  public agvd(QCallFacade paramQCallFacade) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    this.a.a(String.valueOf(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agvd
 * JD-Core Version:    0.7.0.1
 */