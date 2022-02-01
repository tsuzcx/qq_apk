import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.qphone.base.util.QLog;

public class aipm
  extends anqd
{
  public aipm(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void a(boolean paramBoolean, int paramInt)
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
          BlessSelectMemberActivity.a(this.a, 2131690523, true);
          i = 0;
        }
        else
        {
          if (paramInt == 8) {
            BlessSelectMemberActivity.a(this.a, 2131690547, true);
          }
          i = 0;
        }
      }
    }
    this.a.e();
  }
  
  public void a(boolean paramBoolean1, int paramInt, long paramLong, boolean paramBoolean2)
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
      this.a.e();
      BlessSelectMemberActivity.a(this.a, 2131690534, true);
      return;
    }
    if (BlessSelectMemberActivity.b(this.a) == 15)
    {
      this.a.a(paramBoolean1);
      return;
    }
    this.a.a(paramBoolean1, paramBoolean2);
  }
  
  protected void c(boolean paramBoolean, String paramString)
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
        this.a.e();
        BlessSelectMemberActivity.a(this.a, 2131690533, false);
        return;
      } while (BlessSelectMemberActivity.c(this.a) != 2);
      if ((BlessSelectMemberActivity.a(this.a).a() == null) || (!paramBoolean))
      {
        this.a.e();
        BlessSelectMemberActivity.a(this.a, 2131690548, false);
        return;
      }
    } while (BlessSelectMemberActivity.b());
    BlessSelectMemberActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipm
 * JD-Core Version:    0.7.0.1
 */