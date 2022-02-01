import android.view.View;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ajym
  implements bkzq
{
  public ajym(Conversation paramConversation) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Bkzi.e();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, " showActionSheetForCancelMayknowRecommand recommend_item_menu hide clicked");
      }
      ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).reqHideConversationMayknowRecommend();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajym
 * JD-Core Version:    0.7.0.1
 */