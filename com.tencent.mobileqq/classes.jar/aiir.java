import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class aiir
  extends afpy
{
  boolean a;
  
  public aiir(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 62) || (paramInt == 96) || (paramInt == 75);
  }
  
  public aeqy a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (a(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage))) {
      if (this.jdField_a_of_type_Aiiv == null) {
        this.jdField_a_of_type_Aiiv = new aiiv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
    }
    for (paramChatMessage = a(this.jdField_a_of_type_Aiiv, paramBaseAdapter);; paramChatMessage = super.a(paramChatMessage, paramBaseAdapter))
    {
      if ((paramChatMessage instanceof BaseBubbleBuilder)) {
        ((BaseBubbleBuilder)paramChatMessage).b = true;
      }
      return paramChatMessage;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiir
 * JD-Core Version:    0.7.0.1
 */