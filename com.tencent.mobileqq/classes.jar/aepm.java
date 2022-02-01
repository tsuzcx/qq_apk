import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;

public class aepm
  extends VasQuickUpdateManager.CallBacker
{
  public aepm(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 15L) && (paramString1.startsWith("card.")) && (this.a.a != null))
    {
      paramString1 = this.a.a.obtainMessage();
      paramString1.what = 7;
      if (paramInt1 != 0) {
        break label82;
      }
      paramString1.arg1 = 1;
    }
    for (paramString1.arg2 = 1;; paramString1.arg2 = 0)
    {
      if (this.a.a != null) {
        this.a.a.sendMessage(paramString1);
      }
      return;
      label82:
      paramString1.arg1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepm
 * JD-Core Version:    0.7.0.1
 */