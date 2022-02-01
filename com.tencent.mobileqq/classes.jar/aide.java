import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class aide
  extends anvi
{
  aide(aidd paramaidd) {}
  
  protected void onAddFriend(String paramString)
  {
    if (this.a.sessionInfo.curFriendUin.equals(paramString))
    {
      Intent localIntent = this.a.mActivity.getIntent();
      localIntent.putExtra("uintype", 0);
      aidd.b(this.a, localIntent);
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag + "Q.nearby.follow", 2, "onAddFriend, addUin:" + paramString + "|updateSession");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aide
 * JD-Core Version:    0.7.0.1
 */