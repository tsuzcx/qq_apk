import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class agcd
  extends CardObserver
{
  public agcd(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "user binding shoppingNo = " + paramString1 + "Threadid=" + Thread.currentThread().getId());
    }
    if ((this.a.app == null) || (this.a.isFinishing())) {}
    do
    {
      return;
      this.a.app.removeObserver(this);
      this.a.b = null;
    } while (!paramBoolean);
    if ("0".equals(paramString1))
    {
      paramString1 = this.a.a;
      paramString2 = this.a.a;
      paramString1 = paramString1.getSharedPreferences("is_binding_shop", 1).edit();
      paramString1.putBoolean(this.a.e, false);
      paramString1.commit();
      return;
    }
    paramString1 = this.a.a;
    paramString2 = this.a.a;
    paramString1 = paramString1.getSharedPreferences("is_binding_shop", 1).edit();
    paramString1.putBoolean(this.a.e, true);
    paramString1.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agcd
 * JD-Core Version:    0.7.0.1
 */