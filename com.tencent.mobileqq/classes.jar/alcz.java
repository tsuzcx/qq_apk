import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class alcz
  extends bkqo
{
  public alcz(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public int a()
  {
    return ShortVideoPlayActivity.d(this.a);
  }
  
  public void a(Bundle paramBundle)
  {
    Intent localIntent = this.a.a();
    localIntent.putExtras(paramBundle);
    atky.a((Activity)this.a.a, localIntent, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_shoucang");
  }
  
  public void b()
  {
    ShortVideoPlayActivity.e(this.a);
  }
  
  public void e()
  {
    this.a.v();
  }
  
  public void f()
  {
    ShortVideoPlayActivity.g(this.a);
  }
  
  public void g()
  {
    this.a.u();
  }
  
  public void m()
  {
    ShortVideoPlayActivity.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alcz
 * JD-Core Version:    0.7.0.1
 */