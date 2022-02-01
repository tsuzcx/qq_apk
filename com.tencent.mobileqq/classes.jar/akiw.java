import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity.1;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;

public class akiw
  extends azip
{
  public akiw(PhoneLaunchActivity.1 param1) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    PhoneLaunchActivity.a(this.a.this$0).setEnabled(true);
    if (this.a.this$0.a != null)
    {
      this.a.this$0.app.unRegistObserver(this.a.this$0.a);
      this.a.this$0.a = null;
    }
    this.a.this$0.b();
    if (paramBoolean)
    {
      Object localObject = this.a.this$0;
      if ((PhoneLaunchActivity.a(this.a.this$0)) || (PhoneLaunchActivity.b(this.a.this$0)))
      {
        this.a.this$0.setResult(-1);
        this.a.this$0.finish();
        return;
      }
      localObject = new Intent((Context)localObject, SettingActivity2.class);
      if (PhoneLaunchActivity.c(this.a.this$0)) {
        ((Intent)localObject).putExtra("kSrouce", 7);
      }
      this.a.this$0.startActivityForResult((Intent)localObject, 2);
      this.a.this$0.setResult(-1);
      this.a.this$0.finish();
      return;
    }
    this.a.this$0.a(anvx.a(2131707469));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akiw
 * JD-Core Version:    0.7.0.1
 */