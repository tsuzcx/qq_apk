import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ajhf
  extends anyz
{
  public ajhf(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  protected void onGetSuspiciousSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopSuspiciousFragment", 2, "onGetSuspiciousSystemMsgFin.bengin");
    }
    if (this.a.a.isFinishing()) {
      return;
    }
    TroopSuspiciousFragment.d(this.a);
    if (!paramBoolean1) {
      TroopSuspiciousFragment.a(this.a, paramBoolean2);
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopSuspiciousFragment", 2, "onGetSuspiciousSystemMsgFin.success");
    }
    try
    {
      TroopSuspiciousFragment.a(this.a, paramList);
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  protected void onSendSystemMsgActionError(String paramString)
  {
    if ((TroopSuspiciousFragment.a(this.a) != null) && (TroopSuspiciousFragment.a(this.a).isShowing()))
    {
      TroopSuspiciousFragment.a(this.a).dismiss();
      paramString = this.a.a.getResources().getString(2131719155);
      QQToast.a(this.a.a, 1, paramString, 0).b(this.a.a());
    }
  }
  
  protected void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopSuspiciousFragment", 2, "onSendSystemMsgActionFin");
    }
    if (!TextUtils.isEmpty(paramString1)) {}
    while (!paramBoolean)
    {
      TroopSuspiciousFragment.a(this.a, paramString2, paramInt3, paramString3, paramString4, paramString1);
      return;
      paramString1 = bdzy.a().b();
    }
    TroopSuspiciousFragment.a(this.a, paramInt1, paramString2, paramInt2, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhf
 * JD-Core Version:    0.7.0.1
 */