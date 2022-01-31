import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class agrj
  implements bemh<oidb_0x8ed.RspBody>
{
  agrj(agqq paramagqq) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (this.a.ac))
    {
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2, alud.a(2131705511), 0).a();
      bdne.f(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      this.a.jdField_a_of_type_Auxp.a(this.a.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrj
 * JD-Core Version:    0.7.0.1
 */