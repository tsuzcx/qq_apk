import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agai
  implements View.OnClickListener
{
  public agai(VisitorsActivity paramVisitorsActivity, CardProfile paramCardProfile, azzy paramazzy, int paramInt) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    int j;
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.type == 3)
    {
      j = 1;
      k = this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.bIsLastVoteCharged;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.type != 3) {
        break label143;
      }
      if (!((axvr)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app.getManager(207)).c(this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.lEctID)) {
        break label138;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(this.jdField_a_of_type_Azzy, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.bVoteCnt, i);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, "CliOper", "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.lEctID), "like_mall", "like_list_view", j, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      j = 0;
      break;
      label138:
      i = 0;
      continue;
      label143:
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agai
 * JD-Core Version:    0.7.0.1
 */