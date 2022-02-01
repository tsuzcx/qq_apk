import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class akcz
  implements blnt
{
  public akcz(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.c(l);
      return;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 2, "onViewCompleteVisableAndReleased");
    }
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.a(l);
      if (!bhnv.g(this.a.getActivity())) {
        break;
      }
      ChatHistoryTroopFileFragment.a(this.a).a(0, 0);
      return true;
    }
    ChatHistoryTroopFileFragment.a(this.a, 1);
    bgsk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ChatHistoryTroopFileFragment.a(this.a));
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 2, "onViewCompleteVisable");
    }
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.b(l);
      return;
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 2, "onViewNotCompleteVisableAndReleased");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcz
 * JD-Core Version:    0.7.0.1
 */