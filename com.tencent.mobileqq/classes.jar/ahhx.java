import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ahhx
  extends amsu
{
  ahhx(ahhp paramahhp) {}
  
  protected void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onAddFriend : " + paramString);
    }
    if ((this.a.isActivityResume()) && (paramString != null) && (paramString.equals(this.a.sessionInfo.curFriendUin))) {
      ahhp.a(this.a);
    }
  }
  
  protected void onUpdateApolloHead(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.a.app != null) && (TextUtils.equals(paramString, this.a.app.getCurrentAccountUin()))) {
      this.a.refresh(65536);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhx
 * JD-Core Version:    0.7.0.1
 */