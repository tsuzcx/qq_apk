import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

public class adyv
  extends alox
{
  public adyv(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (!bdal.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))) {}
    String str;
    do
    {
      return;
      this.a.b = false;
      str = bdbt.j(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      if (!TextUtils.isEmpty(str))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = str;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.troopinfo", 2, "onUpdateFriendInfo|uin = " + paramString + ", tmpNickName = " + str);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (bdal.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyv
 * JD-Core Version:    0.7.0.1
 */