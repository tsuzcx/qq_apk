import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.data.AppShareID;
import mqq.os.MqqHandler;

public class aamv
  extends ajgf
{
  public aamv(Conversation paramConversation) {}
  
  protected void a(Boolean paramBoolean1, Boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if ((!paramBoolean1.booleanValue()) && (paramBoolean2.booleanValue()) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008272", "0X8008272", 0, 0, "", "", "", "");
      if (!this.a.h) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1134068, new String[] { paramString1, paramString2, paramString3 }).sendToTarget();
      }
    }
  }
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID)
  {
    if (paramBoolean) {
      this.a.a(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aamv
 * JD-Core Version:    0.7.0.1
 */