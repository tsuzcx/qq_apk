import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afkn
  implements View.OnClickListener
{
  public afkn(VisitorsActivity paramVisitorsActivity, CardProfile paramCardProfile, azti paramazti, int paramInt) {}
  
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
      if (!((axpb)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.lEctID)) {
        break label138;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(this.jdField_a_of_type_Azti, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.bVoteCnt, i);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, "CliOper", "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.lEctID), "like_mall", "like_list_view", j, 0, "", "", "", "");
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
 * Qualified Name:     afkn
 * JD-Core Version:    0.7.0.1
 */