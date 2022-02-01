import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;

class ahal
  extends ahbl
{
  ahal(agwz paramagwz)
  {
    super(paramagwz, null);
  }
  
  protected afxi a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new FlashPicItemBuilder(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahal
 * JD-Core Version:    0.7.0.1
 */