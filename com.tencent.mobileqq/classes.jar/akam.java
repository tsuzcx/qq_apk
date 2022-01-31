import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;

public class akam
  extends ajxj
{
  public akam(MessageHandler paramMessageHandler) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3) && (!TextUtils.isEmpty(paramString))) {
      this.a.app.a().k();
    }
  }
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "onUpdateAnswerAddedFriend isSuccess = " + paramBoolean + ", uin = " + paramString + ", flag = " + paramInt);
    }
    if (paramBoolean) {
      this.a.app.a().k();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "onUpdateFriendList isSuccess = " + paramBoolean1 + ", isComplete = " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.app.a().k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akam
 * JD-Core Version:    0.7.0.1
 */