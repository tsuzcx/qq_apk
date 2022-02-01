import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.qphone.base.util.QLog;

public class aiqe
  extends anyz
{
  public aiqe(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onBlessDirtyTextCheck(boolean paramBoolean, int paramInt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "onBlessDirtyTextCheck " + paramBoolean + " ,code=" + paramInt);
    }
    if (paramBoolean) {}
    while ((i != 0) && (!BlessSelectMemberActivity.b()))
    {
      BlessSelectMemberActivity.a(this.a, BlessSelectMemberActivity.a(this.a));
      return;
      if (paramInt != 0) {
        if (paramInt == 1)
        {
          BlessSelectMemberActivity.a(this.a, 2131690633, true);
          i = 0;
        }
        else
        {
          if (paramInt == 8) {
            BlessSelectMemberActivity.a(this.a, 2131690657, true);
          }
          i = 0;
        }
      }
    }
    this.a.c();
  }
  
  public void onSendBlessMsgResp(boolean paramBoolean1, int paramInt, long paramLong, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "onSendBlessMsgResp " + paramBoolean1 + " ,replyCode=" + paramInt + " waitTime=" + paramLong + " ,entrance=" + BlessSelectMemberActivity.a(this.a));
    }
    if (!this.a.a) {
      return;
    }
    this.a.a = false;
    if (paramInt == 67L)
    {
      BlessSelectMemberActivity.a(System.currentTimeMillis());
      this.a.a(paramLong);
      this.a.c();
      BlessSelectMemberActivity.a(this.a, 2131690644, true);
      return;
    }
    if (BlessSelectMemberActivity.b(this.a) == 15)
    {
      this.a.a(paramBoolean1);
      return;
    }
    this.a.a(paramBoolean1, paramBoolean2);
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessSelectMemberActivity", 2, "onUpdateMsgContent, isSuc:" + paramBoolean + " ,type:" + BlessSelectMemberActivity.c(this.a));
    }
    if (BlessSelectMemberActivity.c(this.a) == 3) {
      if (paramBoolean) {
        BlessSelectMemberActivity.a(this.a);
      }
    }
    do
    {
      do
      {
        return;
        this.a.c();
        BlessSelectMemberActivity.a(this.a, 2131690643, false);
        return;
      } while (BlessSelectMemberActivity.c(this.a) != 2);
      if ((BlessSelectMemberActivity.a(this.a).a() == null) || (!paramBoolean))
      {
        this.a.c();
        BlessSelectMemberActivity.a(this.a, 2131690658, false);
        return;
      }
    } while (BlessSelectMemberActivity.b());
    BlessSelectMemberActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqe
 * JD-Core Version:    0.7.0.1
 */