import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;

public class abdk
  extends VasQuickUpdateManager.CallBacker
{
  public abdk(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((VipProfileCardDiyActivity.a(paramLong, paramString1, this.a.a.a.diyTextFontId)) && (paramInt1 == 0))
    {
      paramString1 = this.a.b.obtainMessage();
      paramString1.what = 5;
      paramString1.obj = this.a.a.a;
      paramString1.arg1 = 0;
      paramString1.arg2 = 17;
      this.a.b.sendMessage(paramString1);
      paramVasQuickUpdateManager.removeCallBacker(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abdk
 * JD-Core Version:    0.7.0.1
 */