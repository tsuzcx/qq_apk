import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aeet
  implements begw
{
  aeet(aeeh paramaeeh, begr parambegr) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Begr.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      if (badq.d(this.jdField_a_of_type_Aeeh.a())) {
        try
        {
          ((bbfc)this.jdField_a_of_type_Aeeh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107)).a(this.jdField_a_of_type_Aeeh.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new aeeu(this));
          this.jdField_a_of_type_Aeeh.d = new bbms(this.jdField_a_of_type_Aeeh.a(), this.jdField_a_of_type_Aeeh.a());
          this.jdField_a_of_type_Aeeh.d.setContentView(2131496755);
          this.jdField_a_of_type_Aeeh.d.a(this.jdField_a_of_type_Aeeh.a().getString(2131626627));
          this.jdField_a_of_type_Aeeh.d.setCancelable(false);
          this.jdField_a_of_type_Aeeh.d.show();
          paramView = this.jdField_a_of_type_Aeeh.jdField_a_of_type_Bbfs.a();
          if ((paramView == null) || (!paramView.b())) {
            continue;
          }
          awqx.b(this.jdField_a_of_type_Aeeh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "run_away", 0, 0, "", "", "", "");
        }
        catch (Exception paramView)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(this.jdField_a_of_type_Aeeh.jdField_a_of_type_JavaLangString, 2, "the sessionInfo.curFriendUin is wrong: " + this.jdField_a_of_type_Aeeh.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          continue;
        }
      } else {
        bbmy.a(this.jdField_a_of_type_Aeeh.a(), 2130839278, this.jdField_a_of_type_Aeeh.a().getResources().getString(2131629008), 0).b(this.jdField_a_of_type_Aeeh.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeet
 * JD-Core Version:    0.7.0.1
 */