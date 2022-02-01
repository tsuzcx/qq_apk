import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ahgo
  implements bjoe
{
  ahgo(ahgc paramahgc, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bjnw.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      if (NetworkUtil.isNetSupport(this.jdField_a_of_type_Ahgc.getActivity())) {
        try
        {
          ((bhab)this.jdField_a_of_type_Ahgc.app.getBusinessHandler(107)).a(this.jdField_a_of_type_Ahgc.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new ahgp(this));
          this.jdField_a_of_type_Ahgc.jdField_a_of_type_Bhht = new bhht(this.jdField_a_of_type_Ahgc.getActivity(), this.jdField_a_of_type_Ahgc.getTitleBarHeight());
          this.jdField_a_of_type_Ahgc.jdField_a_of_type_Bhht.setContentView(2131562728);
          this.jdField_a_of_type_Ahgc.jdField_a_of_type_Bhht.a(this.jdField_a_of_type_Ahgc.getActivity().getString(2131691946));
          this.jdField_a_of_type_Ahgc.jdField_a_of_type_Bhht.setCancelable(false);
          this.jdField_a_of_type_Ahgc.jdField_a_of_type_Bhht.show();
          paramView = this.jdField_a_of_type_Ahgc.jdField_a_of_type_Bhar.a();
          if ((paramView == null) || (!paramView.b())) {
            continue;
          }
          bcef.b(this.jdField_a_of_type_Ahgc.app, "dc00899", "Grp_wolf", "", "in_game", "run_away", 0, 0, "", "", "", "");
        }
        catch (Exception paramView)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(this.jdField_a_of_type_Ahgc.tag, 2, "the sessionInfo.curFriendUin is wrong: " + this.jdField_a_of_type_Ahgc.sessionInfo.curFriendUin);
          continue;
        }
      } else {
        QQToast.a(this.jdField_a_of_type_Ahgc.getActivity(), 2130839615, this.jdField_a_of_type_Ahgc.getActivity().getResources().getString(2131694108), 0).b(this.jdField_a_of_type_Ahgc.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgo
 * JD-Core Version:    0.7.0.1
 */