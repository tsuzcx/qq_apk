import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;

public class aiks
  extends VasQuickUpdateManager.CallBacker
{
  public aiks(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 1000L) && (paramString1.equals("pendant_market_json.android.v2"))) {
      if (paramInt1 == 0) {
        this.a.e();
      }
    }
    while ((paramLong != 23L) || (!paramString1.equals("avatarInPendant_json")) || (paramInt1 != 0)) {
      return;
    }
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiks
 * JD-Core Version:    0.7.0.1
 */