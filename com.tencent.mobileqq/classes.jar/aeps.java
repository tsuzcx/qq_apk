import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aeps
  implements bfoq
{
  aeps(aepg paramaepg, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bfol.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      if (bbev.d(this.jdField_a_of_type_Aepg.a())) {
        try
        {
          ((bcic)this.jdField_a_of_type_Aepg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107)).a(this.jdField_a_of_type_Aepg.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new aept(this));
          this.jdField_a_of_type_Aepg.d = new bcpq(this.jdField_a_of_type_Aepg.a(), this.jdField_a_of_type_Aepg.a());
          this.jdField_a_of_type_Aepg.d.setContentView(2131562356);
          this.jdField_a_of_type_Aepg.d.a(this.jdField_a_of_type_Aepg.a().getString(2131692213));
          this.jdField_a_of_type_Aepg.d.setCancelable(false);
          this.jdField_a_of_type_Aepg.d.show();
          paramView = this.jdField_a_of_type_Aepg.jdField_a_of_type_Bcis.a();
          if ((paramView == null) || (!paramView.b())) {
            continue;
          }
          axqw.b(this.jdField_a_of_type_Aepg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "run_away", 0, 0, "", "", "", "");
        }
        catch (Exception paramView)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(this.jdField_a_of_type_Aepg.jdField_a_of_type_JavaLangString, 2, "the sessionInfo.curFriendUin is wrong: " + this.jdField_a_of_type_Aepg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          continue;
        }
      } else {
        bcpw.a(this.jdField_a_of_type_Aepg.a(), 2130839302, this.jdField_a_of_type_Aepg.a().getResources().getString(2131694672), 0).b(this.jdField_a_of_type_Aepg.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeps
 * JD-Core Version:    0.7.0.1
 */