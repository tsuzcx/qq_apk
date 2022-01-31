import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class admi
  extends DiscussionObserver
{
  public admi(ForwardShareCardOption paramForwardShareCardOption) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "onGetFlyTicket: " + paramBoolean + " sigUrl=" + paramString1);
    }
    if (!paramBoolean)
    {
      this.a.t();
      switch (paramInt)
      {
      default: 
        paramString1 = "获取多人聊天链接失败";
        ForwardShareCardOption.c(this.a, null);
        ForwardShareCardOption.a(this.a, false);
        QQToast.a(this.a.a, 1, paramString1, 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
      }
    }
    while ((ForwardShareCardOption.c(this.a) == null) || (Long.parseLong(ForwardShareCardOption.c(this.a)) != paramLong2)) {
      for (;;)
      {
        return;
        paramString1 = "多人聊天不存在";
        continue;
        paramString1 = "你已不在此多人聊天";
      }
    }
    if (ForwardShareCardOption.a(this.a))
    {
      ForwardShareCardOption.c(this.a, paramString1);
      ForwardShareCardOption.a(this.a, ForwardShareCardOption.c(this.a), true);
    }
    ForwardShareCardOption.a(this.a, false);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardShareCardOption", 2, "onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramString + "]");
    }
    if ((ForwardShareCardOption.c(this.a) != null) && (ForwardShareCardOption.c(this.a).equals(paramString))) {
      ForwardShareCardOption.a(this.a, ForwardShareCardOption.c(this.a), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     admi
 * JD-Core Version:    0.7.0.1
 */