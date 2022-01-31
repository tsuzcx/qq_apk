import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class agrd
  implements bemh<oidb_0x8ed.RspBody>
{
  agrd(agrc paramagrc) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a.jdField_a_of_type_JavaLangString, 2, "exitRoom: errorCode = " + paramInt);
    }
    if ((paramInt == 0) || (paramInt == 1285))
    {
      if ((this.a.a.d != null) && (this.a.a.d.isShowing())) {
        this.a.a.d.dismiss();
      }
      new Intent().putExtra("isNeedFinish", true);
      bdne.f(this.a.a.a(), this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      auxp.a().d();
      this.a.a.ab = true;
      this.a.a.b(1);
      return;
    }
    if ((this.a.a.d != null) && (this.a.a.d.isShowing())) {
      this.a.a.d.dismiss();
    }
    QQToast.a(this.a.a.a(), 1, alud.a(2131705464), 0).b(this.a.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrd
 * JD-Core Version:    0.7.0.1
 */