import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

class aixp
  implements View.OnClickListener
{
  aixp(aixn paramaixn) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("path", this.a.jdField_a_of_type_JavaLangString);
    PublicFragmentActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity, paramView, TribeVideoPreviewFragment.class);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.overridePendingTransition(2131034403, 2131034404);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.b != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.b.getVisibility() == 0)) {}
    for (int i = 2;; i = 1)
    {
      ReportController.b(null, "dc00899", "Grp_tribe", "", "post", "Clk_full_screen", i, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixp
 * JD-Core Version:    0.7.0.1
 */