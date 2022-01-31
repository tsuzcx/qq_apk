import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;

public class able
  extends VasQuickUpdateManager.CallBacker
{
  public able(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 15L) && (paramString1.startsWith("card.")) && (paramInt1 == 0) && (this.a.a != null)) {
      this.a.b(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     able
 * JD-Core Version:    0.7.0.1
 */