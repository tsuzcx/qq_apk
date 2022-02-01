import android.os.Handler;
import android.view.View;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;

class ahxv
  implements aauj
{
  ahxv(ahxt paramahxt) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    afur.n = true;
    this.a.o.setVisibility(0);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 10000L);
    StructMsg.ButtonInfo localButtonInfo = this.a.a(paramInt1);
    asfi.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramString, this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a(), localButtonInfo);
    bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Bqq_Crm", "", "Aio_menu", "Clk_menu", 0, 0, this.a.a(), paramInt1 + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxv
 * JD-Core Version:    0.7.0.1
 */