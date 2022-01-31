import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.Set;

class afqf
  extends afuf
{
  afqf(afpy paramafpy)
  {
    super(paramafpy, null);
  }
  
  protected aeqy a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    paramChatMessage = new afum(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    afpy.a(this.a).add(paramChatMessage);
    return paramChatMessage;
  }
  
  protected boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqf
 * JD-Core Version:    0.7.0.1
 */