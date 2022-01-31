import android.text.TextUtils;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;

public class aeli
  extends VasQuickUpdateManager.CallBacker
{
  public aeli(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 15L) && (paramString1.startsWith("card.")))
    {
      if ((paramInt1 == 0) && (!TextUtils.isEmpty(this.a.g))) {
        this.a.c(this.a.g);
      }
    }
    else {
      return;
    }
    QLog.e("VipProfileCardDiyActivity", 1, "download card background failed. errorCode=" + paramInt1 + ", url=" + this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeli
 * JD-Core Version:    0.7.0.1
 */