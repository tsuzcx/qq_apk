import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.Iterator;

public class aefz
  implements npn
{
  public aefz(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a() {}
  
  public void a(ArrayList<TroopAppInfo> paramArrayList)
  {
    if ((this.a.isFinishing()) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      axfw localaxfw = (axfw)this.a.app.getManager(37);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        TroopAppInfo localTroopAppInfo = (TroopAppInfo)paramArrayList.next();
        localaxfw.a(Long.valueOf(localTroopAppInfo.appId), localTroopAppInfo);
        localArrayList.add(Long.valueOf(localTroopAppInfo.appId));
      }
      localaxfw.a(this.a.a.troopUin, localArrayList);
    } while (this.a.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aefz
 * JD-Core Version:    0.7.0.1
 */