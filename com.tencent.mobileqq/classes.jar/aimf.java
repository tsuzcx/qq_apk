import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aimf
  extends amwl
{
  public aimf(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
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
      paramString = this.a.a.getResources().getString(2131718765);
      QQToast.a(this.a.a, 1, paramString, 0).b(this.a.a());
    }
  }
  
  protected void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopSuspiciousFragment", 2, "onSendSystemMsgActionFin");
    }
    long l2 = bcsz.a().b();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if (!paramBoolean)
      {
        TroopSuspiciousFragment.a(this.a, paramString2, paramInt3, paramString3, paramString4, l1);
        return;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        l1 = l2;
      }
      TroopSuspiciousFragment.a(this.a, paramInt1, paramString2, paramInt2, l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimf
 * JD-Core Version:    0.7.0.1
 */