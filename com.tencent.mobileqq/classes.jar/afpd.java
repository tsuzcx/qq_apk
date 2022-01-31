import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

class afpd
  extends afpq
{
  afpd(aflj paramaflj)
  {
    super(paramaflj, null);
  }
  
  protected aemj a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new afie(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpd
 * JD-Core Version:    0.7.0.1
 */