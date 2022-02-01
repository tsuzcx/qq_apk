import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class ahku
  extends amsu
{
  ahku(ahkr paramahkr) {}
  
  protected void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onAddFriend : " + paramString);
    }
    if ((this.a.isActivityResume()) && (paramString != null) && (paramString.equals(this.a.sessionInfo.curFriendUin))) {
      ahkr.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahku
 * JD-Core Version:    0.7.0.1
 */