import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class aept
  implements bcij<oidb_0x8ed.RspBody>
{
  aept(aeps paramaeps) {}
  
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
      bbjn.e(this.a.a.a(), this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      atcf.a().d();
      this.a.a.ab = true;
      this.a.a.b(1);
      return;
    }
    if ((this.a.a.d != null) && (this.a.a.d.isShowing())) {
      this.a.a.d.dismiss();
    }
    bcpw.a(this.a.a.a(), 1, ajyc.a(2131705069), 0).b(this.a.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aept
 * JD-Core Version:    0.7.0.1
 */