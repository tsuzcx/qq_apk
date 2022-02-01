import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiek
  implements View.OnClickListener
{
  aiek(aido paramaido) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
    this.a.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
    if (this.a.mInputBar != null) {
      this.a.mInputBar.setVisibility(0);
    }
    if (this.a.mFakeInput != null) {
      this.a.mFakeInput.setVisibility(0);
    }
    if (this.a.mFakeUpInput != null) {
      this.a.mFakeUpInput.setVisibility(0);
    }
    this.a.handleNightMask();
    if (this.a.jdField_a_of_type_Okn.b(this.a.getCurFriendUin()) != 0) {
      bdla.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC5", "0X8005EC5", 0, 0, this.a.sessionInfo.curFriendUin, "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiek
 * JD-Core Version:    0.7.0.1
 */