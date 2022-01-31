import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;

class afss
  extends afuf
{
  afss(afpy paramafpy)
  {
    super(paramafpy, null);
  }
  
  protected aeqy a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new LightVideoItemBuilder(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afss
 * JD-Core Version:    0.7.0.1
 */