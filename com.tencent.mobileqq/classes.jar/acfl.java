import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;

public class acfl
  implements View.OnClickListener
{
  public acfl(VisitorsActivity paramVisitorsActivity, CardProfile paramCardProfile, atyv paramatyv, int paramInt) {}
  
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
        break label136;
      }
      if (!((ased)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app.getManager(207)).c(this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.lEctID)) {
        break label131;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(this.jdField_a_of_type_Atyv, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.bVoteCnt, i);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, "CliOper", "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.lEctID), "like_mall", "like_list_view", j, 0, "", "", "", "");
      return;
      j = 0;
      break;
      label131:
      i = 0;
      continue;
      label136:
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acfl
 * JD-Core Version:    0.7.0.1
 */