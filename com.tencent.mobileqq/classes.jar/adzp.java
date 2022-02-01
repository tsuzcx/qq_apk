import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.mobileqq.activity.ForwardTroopListFragment.MyTroopObserver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class adzp
  extends aofu
{
  public adzp(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  protected void onGenNewTroopName(String paramString1, String paramString2)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
  
  protected void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  protected void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0) {
        this.a.a();
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
      this.a.a();
      return;
    } while ((paramInt1 != 9) || (paramInt2 != 0));
    this.a.a();
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "onUpdateTroopList " + paramBoolean);
    }
    if (paramBoolean) {
      ThreadManager.getUIHandler().postDelayed(new ForwardTroopListFragment.MyTroopObserver.1(this), 500L);
    }
  }
  
  protected void onUpdateTroopNickname(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzp
 * JD-Core Version:    0.7.0.1
 */