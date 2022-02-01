import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class afsh
  implements afrc
{
  private afiw a;
  
  public afsh(afiw paramafiw)
  {
    this.a = paramafiw;
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
      if ((localObject != null) && ((localSessionInfo.curType == 1024) || (((bily)localObject).a(localSessionInfo.curFriendUin)))) {
        ((bily)localObject).a(localSessionInfo.curFriendUin, localSessionInfo.curType);
      }
      if ((localObject != null) && (((bily)localObject).a(localSessionInfo.curFriendUin))) {
        ((bing)this.a.app.getBusinessHandler(85)).a(null, localSessionInfo.curFriendUin, false);
      }
    } while ((!(this.a instanceof ahdt)) && (!nns.b(localSessionInfo.curFriendUin)));
    if (localObject == null) {}
    for (Object localObject = "";; localObject = ((bily)localObject).a(localSessionInfo.curFriendUin))
    {
      bcef.b(this.a.app, "dc00899", "Qidian", localSessionInfo.curFriendUin, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.4.8", "");
      return;
    }
  }
  
  public int[] a()
  {
    return new int[] { 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsh
 * JD-Core Version:    0.7.0.1
 */