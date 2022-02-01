import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ajve
  implements View.OnClickListener
{
  public ajve(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, List paramList, CheckBox paramCheckBox, boolean paramBoolean, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (aoep)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.b.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    String str;
    if (localObject != null)
    {
      ((aoep)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_c_of_type_JavaLangString), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked(), this.jdField_a_of_type_Boolean);
      str = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.o;
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label153;
      }
    }
    label153:
    for (localObject = "0";; localObject = "1")
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.b, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 1, 0, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_c_of_type_JavaLangString, str, (String)localObject, "");
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.x();
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_c_of_type_AndroidAppDialog.show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajve
 * JD-Core Version:    0.7.0.1
 */