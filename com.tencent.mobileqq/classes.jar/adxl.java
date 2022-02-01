import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class adxl
  extends anif
{
  public adxl(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if ((paramInt2 != 0) && (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString1)))
    {
      if ((!this.a.isFinishing()) && (this.a.isResume()))
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = this.a.getResources().getString(2131694156);
        }
        QQToast.a(this.a, 1, paramString1, 0).b(this.a.getTitleBarHeight());
      }
      ChatSettingForTroop.m(this.a);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = true;
    super.a(paramBoolean, paramString1, paramString2, paramString3, paramInt);
    if (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString1))
    {
      this.a.p();
      if (!paramBoolean) {
        break label171;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName = true;
      this.a.a(paramString2);
      if ((this.a.isResume()) && (this.a.e))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop = false;
        bfup.a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.a, new adxm(this));
        this.a.e = false;
      }
      paramString1 = this.a;
      if ((this.a.d) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
        break label166;
      }
      paramBoolean = bool;
      ChatSettingForTroop.b(paramString1, paramBoolean);
    }
    label166:
    label171:
    do
    {
      return;
      paramBoolean = false;
      break;
      if (paramInt == 1328) {
        ChatSettingForTroop.n(this.a);
      }
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = anni.a(2131700551);
      }
      QQToast.a(this.a, 1, paramString1, 0).b(this.a.getTitleBarHeight());
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
        this.a.e();
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.chatopttroop", 2, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxl
 * JD-Core Version:    0.7.0.1
 */