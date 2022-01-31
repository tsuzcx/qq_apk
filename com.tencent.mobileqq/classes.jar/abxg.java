import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper;
import java.util.List;

class abxg
  implements Runnable
{
  abxg(abxe paramabxe, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Abxe.a.jdField_a_of_type_ComTencentMobileqqNearpeopleNearbyRecommenderChatPushCarrierHelper != null)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_Abxe.a.jdField_a_of_type_ComTencentMobileqqNearpeopleNearbyRecommenderChatPushCarrierHelper.a(this.jdField_a_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_Abxe.a.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_Abxe.a.jdField_a_of_type_ComTencentMobileqqNearpeopleNearbyRecommenderChatPushCarrierHelper.a();
      this.jdField_a_of_type_Abxe.a.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_Abxe.a.jdField_d_of_type_AndroidViewView);
      this.jdField_a_of_type_Abxe.a.jdField_d_of_type_Boolean = true;
      if ((this.jdField_a_of_type_Abxe.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && ((this.jdField_a_of_type_Abxe.a.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Abxe.a.jdField_a_of_type_JavaUtilList.size() == 0))) {
        this.jdField_a_of_type_Abxe.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abxg
 * JD-Core Version:    0.7.0.1
 */