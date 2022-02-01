import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aibh
  implements bkzq
{
  aibh(aiav paramaiav, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bkzi.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      if (NetworkUtil.isNetSupport(this.jdField_a_of_type_Aiav.getActivity())) {
        try
        {
          ((bikt)this.jdField_a_of_type_Aiav.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(this.jdField_a_of_type_Aiav.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new aibi(this));
          this.jdField_a_of_type_Aiav.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_Aiav.getActivity(), this.jdField_a_of_type_Aiav.getTitleBarHeight());
          this.jdField_a_of_type_Aiav.jdField_a_of_type_Bisl.setContentView(2131562799);
          this.jdField_a_of_type_Aiav.jdField_a_of_type_Bisl.a(this.jdField_a_of_type_Aiav.getActivity().getString(2131692036));
          this.jdField_a_of_type_Aiav.jdField_a_of_type_Bisl.setCancelable(false);
          this.jdField_a_of_type_Aiav.jdField_a_of_type_Bisl.show();
          paramView = this.jdField_a_of_type_Aiav.jdField_a_of_type_Bilj.a();
          if ((paramView == null) || (!paramView.b())) {
            continue;
          }
          bdla.b(this.jdField_a_of_type_Aiav.app, "dc00899", "Grp_wolf", "", "in_game", "run_away", 0, 0, "", "", "", "");
        }
        catch (Exception paramView)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(this.jdField_a_of_type_Aiav.tag, 2, "the sessionInfo.curFriendUin is wrong: " + this.jdField_a_of_type_Aiav.sessionInfo.curFriendUin);
          continue;
        }
      } else {
        QQToast.a(this.jdField_a_of_type_Aiav.getActivity(), 2130839636, this.jdField_a_of_type_Aiav.getActivity().getResources().getString(2131694305), 0).b(this.jdField_a_of_type_Aiav.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibh
 * JD-Core Version:    0.7.0.1
 */