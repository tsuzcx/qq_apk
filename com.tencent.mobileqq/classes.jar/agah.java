import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class agah
  extends auzh
{
  agah(agab paramagab) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.sessionInfo.curFriendUin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, "onBandIntimateRelationship");
      }
      this.a.a();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.sessionInfo.curFriendUin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, "onUpdateIntimateRelationship");
      }
      this.a.a();
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (TextUtils.equals(paramString, this.a.sessionInfo.curFriendUin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, "onDisbandIntimateRelationship");
      }
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agah
 * JD-Core Version:    0.7.0.1
 */