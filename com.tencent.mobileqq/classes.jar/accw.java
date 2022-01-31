import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class accw
  implements bhqd
{
  accw(accv paramaccv, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      do
      {
        for (;;)
        {
          return;
          azmj.b(this.jdField_a_of_type_Accv.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_Accv.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Manage_stranger", "Manage_str_delete", 0, 0, "", "", "", "");
          azmj.b(null, "dc00898", "", "", "0X800ACA3", "0X800ACA3", 0, 0, "", "0", "0", "");
          paramView = (alyn)this.jdField_a_of_type_Accv.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(26);
          ArrayList localArrayList = new ArrayList();
          try
          {
            localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_Accv.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
            paramView.a(localArrayList);
            if (this.jdField_a_of_type_Accv.a.c == null) {
              this.jdField_a_of_type_Accv.a.c = new bepp(this.jdField_a_of_type_Accv.a.jdField_a_of_type_AndroidContentContext, 0);
            }
            this.jdField_a_of_type_Accv.a.c.show();
          }
          catch (NumberFormatException paramView) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_Accv.a.jdField_a_of_type_JavaLangString, 2, "delete Stranger parseLong() error", paramView);
      return;
      paramView = new Intent(this.jdField_a_of_type_Accv.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      paramView.putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=" + this.jdField_a_of_type_Accv.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Accv.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramView);
      azmj.b(null, "dc00898", "", "", "0X800ACA4", "0X800ACA4", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     accw
 * JD-Core Version:    0.7.0.1
 */