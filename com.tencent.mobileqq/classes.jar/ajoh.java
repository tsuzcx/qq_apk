import com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter;
import com.tencent.mobileqq.activity.contacts.troop.TroopFragment;
import com.tencent.mobileqq.activity.contacts.troop.TroopFragment.MyTroopObserver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ajoh
  extends aofu
{
  public ajoh(TroopFragment paramTroopFragment) {}
  
  protected void onGenNewTroopName(String paramString1, String paramString2)
  {
    if (this.a.a != null) {
      this.a.a.d();
    }
  }
  
  protected void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
  
  protected void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
  
  protected void onTroopBlockStatusChanged(String paramString)
  {
    this.a.h();
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0) {
        this.a.h();
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt1 != 2) {
          break;
        }
      } while (paramInt2 != 0);
      this.a.h();
      return;
    } while ((paramInt1 != 9) || (paramInt2 != 0));
    this.a.h();
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "onUpdateTroopList " + paramBoolean);
    }
    if (this.a.c)
    {
      this.a.c = false;
      if (TroopFragment.a(this.a) != null) {
        TroopFragment.b(this.a).a(this.a.b(), paramBoolean, null);
      }
    }
    ThreadManager.getUIHandler().postDelayed(new TroopFragment.MyTroopObserver.1(this), 500L);
  }
  
  protected void onUpdateTroopNickname(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoh
 * JD-Core Version:    0.7.0.1
 */