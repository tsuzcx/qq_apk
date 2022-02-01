import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aibk
  implements bkhw
{
  aibk(aiay paramaiay, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bkho.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      if (bgnt.d(this.jdField_a_of_type_Aiay.a())) {
        try
        {
          ((bhte)this.jdField_a_of_type_Aiay.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107)).a(this.jdField_a_of_type_Aiay.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new aibl(this));
          this.jdField_a_of_type_Aiay.d = new biau(this.jdField_a_of_type_Aiay.a(), this.jdField_a_of_type_Aiay.a());
          this.jdField_a_of_type_Aiay.d.setContentView(2131562815);
          this.jdField_a_of_type_Aiay.d.a(this.jdField_a_of_type_Aiay.a().getString(2131691896));
          this.jdField_a_of_type_Aiay.d.setCancelable(false);
          this.jdField_a_of_type_Aiay.d.show();
          paramView = this.jdField_a_of_type_Aiay.jdField_a_of_type_Bhtu.a();
          if ((paramView == null) || (!paramView.b())) {
            continue;
          }
          bcst.b(this.jdField_a_of_type_Aiay.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "run_away", 0, 0, "", "", "", "");
        }
        catch (Exception paramView)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(this.jdField_a_of_type_Aiay.jdField_a_of_type_JavaLangString, 2, "the sessionInfo.curFriendUin is wrong: " + this.jdField_a_of_type_Aiay.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          continue;
        }
      } else {
        QQToast.a(this.jdField_a_of_type_Aiay.a(), 2130839571, this.jdField_a_of_type_Aiay.a().getResources().getString(2131693991), 0).b(this.jdField_a_of_type_Aiay.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibk
 * JD-Core Version:    0.7.0.1
 */