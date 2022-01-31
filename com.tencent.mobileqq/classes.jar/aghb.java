import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.qcall.QCallFacade;

public class aghb
  extends FriendListObserver
{
  public aghb(QCallFacade paramQCallFacade) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    this.a.a(String.valueOf(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aghb
 * JD-Core Version:    0.7.0.1
 */