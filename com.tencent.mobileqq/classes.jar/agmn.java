import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class agmn
  implements bhqd
{
  agmn(agmb paramagmb, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bhpy.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      if (bdee.d(this.jdField_a_of_type_Agmb.a())) {
        try
        {
          ((behr)this.jdField_a_of_type_Agmb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107)).a(this.jdField_a_of_type_Agmb.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new agmo(this));
          this.jdField_a_of_type_Agmb.d = new bepp(this.jdField_a_of_type_Agmb.a(), this.jdField_a_of_type_Agmb.a());
          this.jdField_a_of_type_Agmb.d.setContentView(2131562559);
          this.jdField_a_of_type_Agmb.d.a(this.jdField_a_of_type_Agmb.a().getString(2131692289));
          this.jdField_a_of_type_Agmb.d.setCancelable(false);
          this.jdField_a_of_type_Agmb.d.show();
          paramView = this.jdField_a_of_type_Agmb.jdField_a_of_type_Beih.a();
          if ((paramView == null) || (!paramView.b())) {
            continue;
          }
          azmj.b(this.jdField_a_of_type_Agmb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "run_away", 0, 0, "", "", "", "");
        }
        catch (Exception paramView)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(this.jdField_a_of_type_Agmb.jdField_a_of_type_JavaLangString, 2, "the sessionInfo.curFriendUin is wrong: " + this.jdField_a_of_type_Agmb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          continue;
        }
      } else {
        QQToast.a(this.jdField_a_of_type_Agmb.a(), 2130839391, this.jdField_a_of_type_Agmb.a().getResources().getString(2131694829), 0).b(this.jdField_a_of_type_Agmb.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmn
 * JD-Core Version:    0.7.0.1
 */