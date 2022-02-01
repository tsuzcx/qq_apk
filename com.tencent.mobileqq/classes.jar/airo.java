import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class airo
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public airo(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_Airt.getCount();
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.c) || (this.b <= 0)) {}
    while ((paramInt != 0) || (this.b > this.jdField_a_of_type_Int)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.a(21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airo
 * JD-Core Version:    0.7.0.1
 */