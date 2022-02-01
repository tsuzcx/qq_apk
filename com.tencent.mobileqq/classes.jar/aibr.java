import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class aibr
  implements bhtl<oidb_0x8ed.RspBody>
{
  aibr(aiay paramaiay) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (this.a.ab))
    {
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2, anni.a(2131703907), 0).a();
      bgsg.f(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      this.a.jdField_a_of_type_Axey.a(this.a.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibr
 * JD-Core Version:    0.7.0.1
 */