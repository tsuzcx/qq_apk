import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.Iterator;

public class adrx
  implements nxx
{
  public adrx(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a() {}
  
  public void a(ArrayList<TroopAppInfo> paramArrayList)
  {
    if ((this.a.isFinishing()) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      awzf localawzf = (awzf)this.a.app.getManager(QQManagerFactory.TROOPINFO_MANAGER);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        TroopAppInfo localTroopAppInfo = (TroopAppInfo)paramArrayList.next();
        localawzf.a(Long.valueOf(localTroopAppInfo.appId), localTroopAppInfo);
        localArrayList.add(Long.valueOf(localTroopAppInfo.appId));
      }
      localawzf.a(this.a.a.troopUin, localArrayList);
    } while (this.a.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrx
 * JD-Core Version:    0.7.0.1
 */