import com.tencent.mobileqq.activity.PhoneUnityChangeActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class abht
  extends atog
{
  abht(abhs paramabhs) {}
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    PhoneUnityChangeActivity.a(this.a.a.a);
    this.a.a.a.app.unRegistObserver(this);
    if (paramBoolean)
    {
      ((ajof)this.a.a.a.app.getManager(102)).a(null);
      this.a.a.a.setResult(4001);
      this.a.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abht
 * JD-Core Version:    0.7.0.1
 */