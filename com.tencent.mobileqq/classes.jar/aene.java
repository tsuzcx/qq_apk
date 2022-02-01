import com.tencent.mobileqq.activity.PhoneUnityChangeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class aene
  extends azip
{
  aene(aend paramaend) {}
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    PhoneUnityChangeActivity.a(this.a.a.a);
    this.a.a.a.app.unRegistObserver(this);
    if (paramBoolean)
    {
      ((ajco)this.a.a.a.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).a(null);
      this.a.a.a.setResult(4001);
      this.a.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aene
 * JD-Core Version:    0.7.0.1
 */