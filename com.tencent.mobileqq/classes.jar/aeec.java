import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody;

public class aeec
  extends ameq
{
  public aeec(TroopLowCreditLevelNotifyActivity paramTroopLowCreditLevelNotifyActivity) {}
  
  protected void a(oidb_0xaf4.RspBody paramRspBody, int paramInt)
  {
    if (paramRspBody.group_id.has())
    {
      paramRspBody = String.valueOf(paramRspBody.group_id.get());
      if (TextUtils.equals(this.a.jdField_a_of_type_JavaLangString, paramRspBody)) {
        break label119;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "onGetNewTroopAppList troopUin not match. rsp uin=" + paramRspBody + ", current uin=" + this.a.jdField_a_of_type_JavaLangString);
      }
    }
    label119:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "onGetNewTroopAppList group_id lost. current uin=" + this.a.jdField_a_of_type_JavaLangString);
      }
      this.a.d();
      paramRspBody = this.a.a(1101236949L);
    } while (paramRspBody == null);
    this.a.a(paramRspBody);
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.act", 2, "onGetTroopCreditLevelInfo:" + this.a.jdField_a_of_type_JavaLangString + "," + paramBoolean);
    }
    if (!this.a.jdField_a_of_type_JavaLangString.equals(paramLong + "")) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.a.d();
          } while (!paramBoolean);
          localObject = (TroopManager)this.a.app.getManager(52);
        } while (localObject == null);
        localObject = ((TroopManager)localObject).b(this.a.jdField_a_of_type_JavaLangString);
      } while (localObject == null);
      paramLong = ((TroopInfo)localObject).troopCreditLevel;
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "onGetTroopCreditLevelInfo:" + this.a.jdField_a_of_type_JavaLangString + "," + paramLong);
      }
    } while (paramLong == 2L);
    if (paramLong == 1L)
    {
      localObject = bdgm.a(this.a.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.a.getString(2131720808)).setMessage(alud.a(2131715872));
      ((bdjz)localObject).setPositiveButton(2131697988, new aeed(this));
      ((bdjz)localObject).setNegativeButton("", null);
      ((bdjz)localObject).setCancelable(false);
      ((bdjz)localObject).show();
      return;
    }
    Object localObject = bdgm.a(this.a.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.a.getString(2131720808)).setMessage(alud.a(2131715873));
    ((bdjz)localObject).setPositiveButton(2131697988, new aeee(this));
    ((bdjz)localObject).setNegativeButton("", null);
    ((bdjz)localObject).setCancelable(false);
    ((bdjz)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeec
 * JD-Core Version:    0.7.0.1
 */