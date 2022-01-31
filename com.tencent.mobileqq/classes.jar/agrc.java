import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class agrc
  implements bhuk
{
  agrc(agqq paramagqq, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bhuf.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      if (bdin.d(this.jdField_a_of_type_Agqq.a())) {
        try
        {
          ((bema)this.jdField_a_of_type_Agqq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107)).a(this.jdField_a_of_type_Agqq.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new agrd(this));
          this.jdField_a_of_type_Agqq.d = new bety(this.jdField_a_of_type_Agqq.a(), this.jdField_a_of_type_Agqq.a());
          this.jdField_a_of_type_Agqq.d.setContentView(2131562577);
          this.jdField_a_of_type_Agqq.d.a(this.jdField_a_of_type_Agqq.a().getString(2131692290));
          this.jdField_a_of_type_Agqq.d.setCancelable(false);
          this.jdField_a_of_type_Agqq.d.show();
          paramView = this.jdField_a_of_type_Agqq.jdField_a_of_type_Bemq.a();
          if ((paramView == null) || (!paramView.b())) {
            continue;
          }
          azqs.b(this.jdField_a_of_type_Agqq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "run_away", 0, 0, "", "", "", "");
        }
        catch (Exception paramView)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(this.jdField_a_of_type_Agqq.jdField_a_of_type_JavaLangString, 2, "the sessionInfo.curFriendUin is wrong: " + this.jdField_a_of_type_Agqq.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          continue;
        }
      } else {
        QQToast.a(this.jdField_a_of_type_Agqq.a(), 2130839392, this.jdField_a_of_type_Agqq.a().getResources().getString(2131694831), 0).b(this.jdField_a_of_type_Agqq.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrc
 * JD-Core Version:    0.7.0.1
 */