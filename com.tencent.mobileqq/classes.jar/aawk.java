import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Conversation.33.1;
import com.tencent.mobileqq.activity.Conversation.33.2;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class aawk
  extends ajto
{
  public aawk(Conversation paramConversation) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null) && (!bbbr.a(paramObject.uin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        this.a.a(8, paramObject.uin, -2147483648);
      }
      return;
    }
  }
  
  protected void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " conversation onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      this.a.a(0L);
    }
  }
  
  public void onGetNotDisturb(boolean paramBoolean, String paramString1, String paramString2)
  {
    super.onGetNotDisturb(paramBoolean, paramString1, paramString2);
    Conversation.a(this.a.jdField_a_of_type_MqqOsMqqHandler, this.a.a());
  }
  
  protected void onGreetingRecv(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onGreetingRecv");
      }
      this.a.a(8, ajsd.H, 1001);
    }
  }
  
  protected void onSetNotDisturb(boolean paramBoolean, String paramString1, String paramString2)
  {
    super.onSetNotDisturb(paramBoolean, paramString1, paramString2);
    if (!"not_disturb_from_conversation".equals(paramString2)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 4, "onSetNotDisturb NOT FROM THIS" + paramString2);
      }
    }
    do
    {
      return;
      if (!paramBoolean)
      {
        ThreadManagerV2.getUIHandlerV2().post(new Conversation.33.1(this));
        return;
      }
      Conversation.a(this.a.jdField_a_of_type_MqqOsMqqHandler, this.a.a());
    } while (FriendsStatusUtil.a(this.a.a()));
    ThreadManagerV2.getUIHandlerV2().post(new Conversation.33.2(this));
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "Conversation.onUpdateAvatar: uin:" + paramString + ", success :" + paramBoolean);
    }
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (bbbr.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aawk
 * JD-Core Version:    0.7.0.1
 */