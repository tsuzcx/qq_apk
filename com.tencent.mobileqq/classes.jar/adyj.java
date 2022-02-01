import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.ArrayList;

public class adyj
  extends aofu
{
  public adyj(ForwardRecentActivity paramForwardRecentActivity) {}
  
  protected void onGetTroopMemberCardInfoResult(boolean paramBoolean1, ArrayList<TroopMemberCardInfo> paramArrayList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramArrayList != null) && (paramArrayList.size() > 0) && (paramBoolean2)) {
      ForwardRecentActivity.f(this.a);
    }
  }
  
  protected void onTroopSearch(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      ForwardRecentActivity.f(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adyj
 * JD-Core Version:    0.7.0.1
 */