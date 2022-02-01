import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class ahbr
  implements bils
{
  ahbr(ahbp paramahbp) {}
  
  public void a(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
    if (this.a.a()) {
      return;
    }
    Object localObject = (FragmentActivity)paramView.getContext();
    if (localObject != null) {}
    for (localObject = ((FragmentActivity)localObject).getChatFragment();; localObject = null)
    {
      if (localObject == null)
      {
        ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext);
        return;
      }
      ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbr
 * JD-Core Version:    0.7.0.1
 */