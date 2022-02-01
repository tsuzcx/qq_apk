import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;

class ahbj
  extends ahbl
{
  ahbj(agwz paramagwz)
  {
    super(paramagwz, null);
  }
  
  protected afxi a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new ScribbleItemBuilder(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbj
 * JD-Core Version:    0.7.0.1
 */