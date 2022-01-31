import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import java.util.ArrayList;
import java.util.List;

public class afyv
  implements bfoq
{
  public afyv(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = ChatHistoryTroopFileFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopFileFragment).a();
    if ((paramView == null) || (paramView.isEmpty())) {}
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramView);
      ChatHistoryTroopFileFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopFileFragment).a(localArrayList, 3, new afyw(this));
      ChatHistoryTroopFileFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopFileFragment).a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopFileFragment.h();
    } while (!this.jdField_a_of_type_Bfol.isShowing());
    this.jdField_a_of_type_Bfol.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afyv
 * JD-Core Version:    0.7.0.1
 */