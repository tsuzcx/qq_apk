import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class agjv
  implements agin
{
  private agab a;
  
  public agjv(agab paramagab)
  {
    this.a = paramagab;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    SessionInfo localSessionInfo;
    do
    {
      return;
      localObject = this.a.a;
      localSessionInfo = this.a.sessionInfo;
      if ((localObject != null) && ((localSessionInfo.curType == 1024) || (((bjxa)localObject).a(localSessionInfo.curFriendUin)))) {
        ((bjxa)localObject).a(localSessionInfo.curFriendUin, localSessionInfo.curType);
      }
      if ((localObject != null) && (((bjxa)localObject).a(localSessionInfo.curFriendUin))) {
        ((bjyi)this.a.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(null, localSessionInfo.curFriendUin, false);
      }
    } while ((!(this.a instanceof ahyl)) && (!nut.b(localSessionInfo.curFriendUin)));
    if (localObject == null) {}
    for (Object localObject = "";; localObject = ((bjxa)localObject).a(localSessionInfo.curFriendUin))
    {
      bdla.b(this.a.app, "dc00899", "Qidian", localSessionInfo.curFriendUin, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.4.10", "");
      return;
    }
  }
  
  public int[] a()
  {
    return new int[] { 14 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjv
 * JD-Core Version:    0.7.0.1
 */