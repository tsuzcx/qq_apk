import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import java.util.ArrayList;
import java.util.List;

public class ahwr
  implements bhqd
{
  public ahwr(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = ChatHistoryTroopFileFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopFileFragment).a();
    if ((paramView == null) || (paramView.isEmpty())) {}
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramView);
      ChatHistoryTroopFileFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopFileFragment).a(localArrayList, 3, new ahws(this));
      ChatHistoryTroopFileFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopFileFragment).a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopFileFragment.h();
    } while (!this.jdField_a_of_type_Bhpy.isShowing());
    this.jdField_a_of_type_Bhpy.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwr
 * JD-Core Version:    0.7.0.1
 */