import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aepq
  implements bfph
{
  aepq(aepe paramaepe, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bfpc.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      if (bbfj.d(this.jdField_a_of_type_Aepe.a())) {
        try
        {
          ((bciq)this.jdField_a_of_type_Aepe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107)).a(this.jdField_a_of_type_Aepe.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new aepr(this));
          this.jdField_a_of_type_Aepe.d = new bcqf(this.jdField_a_of_type_Aepe.a(), this.jdField_a_of_type_Aepe.a());
          this.jdField_a_of_type_Aepe.d.setContentView(2131562355);
          this.jdField_a_of_type_Aepe.d.a(this.jdField_a_of_type_Aepe.a().getString(2131692213));
          this.jdField_a_of_type_Aepe.d.setCancelable(false);
          this.jdField_a_of_type_Aepe.d.show();
          paramView = this.jdField_a_of_type_Aepe.jdField_a_of_type_Bcjg.a();
          if ((paramView == null) || (!paramView.b())) {
            continue;
          }
          axqy.b(this.jdField_a_of_type_Aepe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "run_away", 0, 0, "", "", "", "");
        }
        catch (Exception paramView)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(this.jdField_a_of_type_Aepe.jdField_a_of_type_JavaLangString, 2, "the sessionInfo.curFriendUin is wrong: " + this.jdField_a_of_type_Aepe.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          continue;
        }
      } else {
        bcql.a(this.jdField_a_of_type_Aepe.a(), 2130839302, this.jdField_a_of_type_Aepe.a().getResources().getString(2131694673), 0).b(this.jdField_a_of_type_Aepe.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aepq
 * JD-Core Version:    0.7.0.1
 */