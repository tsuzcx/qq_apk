import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.Set;

class aflq
  extends afpq
{
  aflq(aflj paramaflj)
  {
    super(paramaflj, null);
  }
  
  protected aemj a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    paramChatMessage = new afpx(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    aflj.a(this.a).add(paramChatMessage);
    return paramChatMessage;
  }
  
  protected boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aflq
 * JD-Core Version:    0.7.0.1
 */