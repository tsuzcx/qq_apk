import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class aemz
  extends azip
{
  public aemz(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    PhoneUnityBindInfoActivity.b(this.a);
    this.a.app.unRegistObserver(this);
    PhoneUnityBindInfoActivity.a(this.a);
    if (paramBoolean) {
      this.a.a(false);
    }
    for (;;)
    {
      PhoneUnityBindInfoActivity.c(this.a);
      return;
      this.a.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemz
 * JD-Core Version:    0.7.0.1
 */