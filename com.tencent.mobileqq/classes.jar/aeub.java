import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

public class aeub
  implements View.OnClickListener
{
  public aeub(NearbyProfileEditPanel paramNearbyProfileEditPanel, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (this.jdField_a_of_type_Int != 0) {
      localActionSheet.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131437400));
    }
    localActionSheet.c("查看大图");
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
      localActionSheet.a("删除照片", 3);
    }
    localActionSheet.c(2131432998);
    localActionSheet.a(new aeuc(this, paramView, localPicInfo, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeub
 * JD-Core Version:    0.7.0.1
 */