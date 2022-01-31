import com.tencent.mobileqq.activity.HotChatAnnounceActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class abjf
  extends ajyt
{
  public abjf(HotChatAnnounceActivity paramHotChatAnnounceActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatAnnounceActivity", 2, "onSetUserCreateHotChatAnnounce.isSuccess=" + paramBoolean + ",result=" + paramInt + ", strErr=" + paramString2);
    }
    HotChatAnnounceActivity.a(this.a);
    if ((paramBoolean) && (paramInt == 0))
    {
      paramString1 = ((HotChatManager)this.a.app.getManager(60)).a(this.a.a);
      if (paramString1 != null)
      {
        paramString1.memo = this.a.d;
        paramString1.memoUrl = this.a.e;
        paramString1.memoShowed = false;
      }
      bcpw.a(this.a, 2, ajyc.a(2131705525), 0).b(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    paramString1 = ajyc.a(2131705528);
    if (paramInt == 1282) {
      paramString1 = ajyc.a(2131705533);
    }
    bcpw.a(this.a, 1, paramString1, 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatAnnounceActivity", 2, "onSetHotChatAnnounce.isSuccess=" + paramBoolean + ",result=" + paramInt + ", strErr=" + paramString);
    }
    HotChatAnnounceActivity.a(this.a);
    if ((paramBoolean) && (paramInt == 0))
    {
      paramArrayOfByte = ((HotChatManager)this.a.app.getManager(60)).a(this.a.a);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.memo = this.a.d;
        paramArrayOfByte.memoUrl = this.a.e;
        paramArrayOfByte.memoShowed = false;
      }
      bcpw.a(this.a, 2, ajyc.a(2131705532), 0).b(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    paramArrayOfByte = ajyc.a(2131705526);
    if (paramInt == 1288) {
      paramArrayOfByte = ajyc.a(2131705530);
    }
    bcpw.a(this.a, 1, paramArrayOfByte, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abjf
 * JD-Core Version:    0.7.0.1
 */