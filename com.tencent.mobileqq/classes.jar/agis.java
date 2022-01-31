import android.os.Handler;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class agis
  extends aumg
{
  public agis(BindNumberActivity paramBindNumberActivity) {}
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      BindNumberActivity.a(this.a).sendEmptyMessage(3);
    }
    for (;;)
    {
      this.a.app.unRegistObserver(this.a.b);
      this.a.b = null;
      return;
      this.a.b();
      this.a.b(2131718748);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agis
 * JD-Core Version:    0.7.0.1
 */