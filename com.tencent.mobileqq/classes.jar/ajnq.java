import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.activity.phone.SettingActivity2.3;
import com.tencent.mobileqq.app.QQAppInterface;

public class ajnq
  extends aycd
{
  public ajnq(SettingActivity2.3 param3) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (this.a.this$0.c != null)
    {
      this.a.this$0.app.unRegistObserver(this.a.this$0.c);
      this.a.this$0.c = null;
    }
    this.a.this$0.b();
    if (paramBoolean)
    {
      if (this.a.this$0.c != null)
      {
        this.a.this$0.app.unRegistObserver(this.a.this$0.c);
        this.a.this$0.c = null;
      }
      this.a.this$0.a();
      this.a.this$0.setResult(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnq
 * JD-Core Version:    0.7.0.1
 */