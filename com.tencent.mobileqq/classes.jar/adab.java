import com.tencent.mobileqq.activity.HotChatAnnounceActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class adab
  extends alqf
{
  public adab(HotChatAnnounceActivity paramHotChatAnnounceActivity) {}
  
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
      QQToast.a(this.a, 2, alpo.a(2131705908), 0).b(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    paramString1 = alpo.a(2131705911);
    if (paramInt == 1282) {
      paramString1 = alpo.a(2131705916);
    }
    QQToast.a(this.a, 1, paramString1, 0).b(this.a.getTitleBarHeight());
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
      QQToast.a(this.a, 2, alpo.a(2131705915), 0).b(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    paramArrayOfByte = alpo.a(2131705909);
    if (paramInt == 1288) {
      paramArrayOfByte = alpo.a(2131705913);
    }
    QQToast.a(this.a, 1, paramArrayOfByte, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adab
 * JD-Core Version:    0.7.0.1
 */