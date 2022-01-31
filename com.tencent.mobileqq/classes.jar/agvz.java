import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView.UpdateProfileSetCardTask;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class agvz
  implements Runnable
{
  public agvz(ProfileHeaderView.UpdateProfileSetCardTask paramUpdateProfileSetCardTask, ProfileHeaderView paramProfileHeaderView) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap != null)
      {
        ReportController.b(null, "CliOper", "", "", "card_mall", "0X80066D3", 0, 0, "", "", "", "");
        View localView = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
        TextView localTextView = (TextView)localView.findViewById(2131362880);
        ImageView localImageView = (ImageView)localView.findViewById(2131370998);
        Resources localResources = localView.getResources();
        localTextView.setText(localResources.getString(2131436960));
        localImageView.setContentDescription(localResources.getString(2131436960));
        localView.setTag(new DataTag(29, "CLICK_BANNER"));
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.b.set(true);
        ProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agvz
 * JD-Core Version:    0.7.0.1
 */