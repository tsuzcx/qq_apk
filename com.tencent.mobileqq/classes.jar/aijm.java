import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio;
import com.tencent.mobileqq.transfile.PAAudioPttDownloadProcessor;
import java.io.File;

public class aijm
  implements View.OnClickListener
{
  public aijm(StructMsgItemPAAudio paramStructMsgItemPAAudio) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(this.a.y)) {
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        str = PAAudioPttDownloadProcessor.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.x);
        if (TextUtils.isEmpty(str))
        {
          this.a.a();
          this.a.a(this.a.y, paramView);
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005C9B", "0X8005C9B", 0, 1, 0, this.a.y, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.w, this.a.x);
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (new File(str).exists())
      {
        if (this.a.jdField_a_of_type_Boolean) {
          this.a.d();
        } else {
          this.a.c();
        }
      }
      else
      {
        this.a.a();
        this.a.a(this.a.y, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijm
 * JD-Core Version:    0.7.0.1
 */