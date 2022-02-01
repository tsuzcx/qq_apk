import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ailc
  implements bliz
{
  ailc(aikq paramaikq, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Blir.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      if (bhnv.d(this.jdField_a_of_type_Aikq.a())) {
        try
        {
          ((bitz)this.jdField_a_of_type_Aikq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107)).a(this.jdField_a_of_type_Aikq.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new aild(this));
          this.jdField_a_of_type_Aikq.d = new bjbs(this.jdField_a_of_type_Aikq.a(), this.jdField_a_of_type_Aikq.a());
          this.jdField_a_of_type_Aikq.d.setContentView(2131562849);
          this.jdField_a_of_type_Aikq.d.a(this.jdField_a_of_type_Aikq.a().getString(2131691900));
          this.jdField_a_of_type_Aikq.d.setCancelable(false);
          this.jdField_a_of_type_Aikq.d.show();
          paramView = this.jdField_a_of_type_Aikq.jdField_a_of_type_Biup.a();
          if ((paramView == null) || (!paramView.b())) {
            continue;
          }
          bdll.b(this.jdField_a_of_type_Aikq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "run_away", 0, 0, "", "", "", "");
        }
        catch (Exception paramView)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(this.jdField_a_of_type_Aikq.jdField_a_of_type_JavaLangString, 2, "the sessionInfo.curFriendUin is wrong: " + this.jdField_a_of_type_Aikq.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          continue;
        }
      } else {
        QQToast.a(this.jdField_a_of_type_Aikq.a(), 2130839580, this.jdField_a_of_type_Aikq.a().getResources().getString(2131694008), 0).b(this.jdField_a_of_type_Aikq.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailc
 * JD-Core Version:    0.7.0.1
 */