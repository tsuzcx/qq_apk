import com.tencent.mobileqq.activity.Conversation;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aawx
  extends ajyr
{
  public aawx(Conversation paramConversation) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onGetUserCreateHotChatAnnounce  isSuccess= " + paramBoolean + ", result=" + paramInt + ", memo=" + paramString2 + ", troopOwner=" + paramLong);
    }
    if ((paramBoolean) && (paramInt == 0)) {
      this.a.a(0L);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onGetHotChatAnnounce  isSuccess= " + paramBoolean + ", result=" + paramInt + ", memo=" + paramString2 + ", jumpurl=" + paramString3);
    }
    if ((paramBoolean) && (paramInt == 0)) {
      this.a.a(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aawx
 * JD-Core Version:    0.7.0.1
 */