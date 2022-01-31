import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity.14.1;
import com.tencent.mobileqq.app.ThreadManager;

public class aclm
  extends ajxl
{
  public aclm(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    ThreadManager.post(new TroopRequestActivity.14.1(this, paramString), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aclm
 * JD-Core Version:    0.7.0.1
 */