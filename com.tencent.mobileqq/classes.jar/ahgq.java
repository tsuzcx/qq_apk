import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.Set;

class ahgq
  extends ahkx
{
  ahgq(ahgk paramahgk)
  {
    super(paramahgk, null);
  }
  
  protected aghc a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    paramChatMessage = new ahle(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ahgk.a(this.a).add(paramChatMessage);
    return paramChatMessage;
  }
  
  protected boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgq
 * JD-Core Version:    0.7.0.1
 */