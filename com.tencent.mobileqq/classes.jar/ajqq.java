import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;

public class ajqq
  implements View.OnClickListener
{
  public ajqq(ApolloPanel paramApolloPanel, ajqd paramajqd, ApolloActionData paramApolloActionData) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null) && (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel) != null)) {
      ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel).b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_Ajqd);
    }
    ApolloPanel.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "cmshow", "Apollo", "action_flame_clicksend", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajqq
 * JD-Core Version:    0.7.0.1
 */