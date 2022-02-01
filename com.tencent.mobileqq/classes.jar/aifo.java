import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class aifo
  extends anvi
{
  aifo(aifl paramaifl) {}
  
  protected void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onAddFriend : " + paramString);
    }
    if ((this.a.isActivityResume()) && (paramString != null) && (paramString.equals(this.a.sessionInfo.curFriendUin))) {
      aifl.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifo
 * JD-Core Version:    0.7.0.1
 */