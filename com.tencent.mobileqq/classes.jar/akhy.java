import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class akhy
  extends akim
{
  public akhy(TroopManager paramTroopManager) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    switch (paramInt1)
    {
    }
    Object localObject2;
    do
    {
      return;
      this.a.f(paramString);
      synchronized (this.a)
      {
        if (TroopManager.a(this.a) != null)
        {
          localObject2 = TroopManager.a(this.a).iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (((TroopInfo)((Iterator)localObject2).next()).troopuin.equals(paramString)) {
              ((Iterator)localObject2).remove();
            }
          }
        }
        return;
      }
      ??? = new ArrayList();
      ((ArrayList)???).add(paramString);
      this.a.b((ArrayList)???);
      return;
      localObject2 = this.a.b(paramString);
    } while ((localObject2 == null) || (!TroopManager.a(this.a, (TroopInfo)localObject2, true)));
    akhq localakhq = (akhq)this.a.a.a(20);
    for (;;)
    {
      synchronized (this.a)
      {
        if (TroopManager.a(this.a) == null)
        {
          TroopManager.a(this.a, new ArrayList());
          TroopManager.a(this.a).add(localObject2);
          localakhq.a(true, paramString, ((TroopInfo)localObject2).troopcode, 9);
          return;
        }
      }
      TroopManager.a(this.a).add(localObject2);
    }
  }
  
  protected void a(String arg1, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    boolean bool;
    ArrayList localArrayList;
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder().append("onUpdateTroopGetMemberList(memberLimit), troopUin:").append(???).append(", mGetTroopMemberListTroops == null:");
      if (TroopManager.a(this.a) == null)
      {
        bool = true;
        QLog.i("Q.contacttab.troop", 2, bool);
      }
    }
    else
    {
      localArrayList = new ArrayList();
      localArrayList.add(???);
      if (TroopManager.a(this.a) != null) {
        break label98;
      }
      this.a.b(localArrayList);
    }
    label98:
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        do
        {
          return;
          bool = false;
          break;
        } while (TroopManager.a(this.a).size() <= 0);
        localTroopInfo = (TroopInfo)TroopManager.a(this.a).get(0);
      } while (!localTroopInfo.troopuin.equals(???));
      paramList = (akhq)this.a.a.a(20);
      if ((paramBoolean) || (TroopManager.a(this.a) >= 3)) {
        break label237;
      }
      paramList.a(true, localTroopInfo.troopuin, localTroopInfo.troopcode, 4);
    } while (!QLog.isColorLevel());
    QLog.w("Q.contacttab.troop", 2, "getTroopsMemberList(memberLimit), failed, retry mRetryGetTroopMemberListCount:" + TroopManager.b(this.a) + ", troopUin" + localTroopInfo.troopuin);
    return;
    label237:
    if (QLog.isColorLevel()) {
      QLog.i("Q.contacttab.troop", 2, "notifyTroopMembersUpdate, troopUin:" + ???);
    }
    if (paramBoolean) {
      this.a.b(localArrayList);
    }
    synchronized (this.a)
    {
      TroopManager.a(this.a).remove(0);
      if (TroopManager.a(this.a).size() > 0)
      {
        ??? = (TroopInfo)TroopManager.a(this.a).get(0);
        TroopManager.a(this.a, 0);
        paramList.a(true, ???.troopuin, ???.troopcode, 4);
        return;
        this.a.g(???);
      }
    }
    synchronized (this.a)
    {
      TroopManager.a(this.a, null);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    QLog.i("troop_ext", 1, "onGetTroopInfoResult success: troopUin: " + paramString);
  }
  
  protected void a(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        paramString = (TroopMemberCardInfo)paramArrayList.get(i);
        this.a.b(paramString.troopuin, paramString.memberuin);
        i += 1;
      }
    }
  }
  
  protected void f(boolean paramBoolean, String paramString)
  {
    QLog.i("troop_ext", 1, "onActiveExtTroop success: " + paramBoolean + " troopUin: " + paramString);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      ((akhq)this.a.a.a(20)).j(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akhy
 * JD-Core Version:    0.7.0.1
 */