import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.Set;

class agdc
  extends aghj
{
  agdc(agcw paramagcw)
  {
    super(paramagcw, null);
  }
  
  protected aezx a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    paramChatMessage = new aghq(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    agcw.a(this.a).add(paramChatMessage);
    return paramChatMessage;
  }
  
  protected boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdc
 * JD-Core Version:    0.7.0.1
 */