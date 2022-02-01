import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afqk
  implements View.OnClickListener
{
  public afqk(BaseBubbleBuilder paramBaseBubbleBuilder, long paramLong, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bflj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqk
 * JD-Core Version:    0.7.0.1
 */