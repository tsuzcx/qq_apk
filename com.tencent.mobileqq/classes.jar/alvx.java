import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.selectable.ChatSelCurPageForLSSHelper.1;
import com.tencent.mobileqq.bubble.ChatXListView;

public class alvx
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ChatSelCurPageForLSSHelper.1(this);
  private boolean jdField_a_of_type_Boolean;
  
  public alvx(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvx
 * JD-Core Version:    0.7.0.1
 */