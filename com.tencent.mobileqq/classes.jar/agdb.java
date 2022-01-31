import android.view.View;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver.5.1;
import com.tencent.mobileqq.activity.main.MainAssistObserver.5.2;

public class agdb
  extends akud
{
  agdb(agcf paramagcf) {}
  
  public void a()
  {
    if (bhvy.j()) {
      this.a.a(39, null);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    if (!bhvy.i()) {}
    while (this.a.a == null) {
      return;
    }
    this.a.a.runOnUiThread(new MainAssistObserver.5.2(this, paramInt, paramObject));
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    a(1, paramView);
  }
  
  public void c()
  {
    if (!bhvy.i()) {}
    while (this.a.a == null) {
      return;
    }
    this.a.a.runOnUiThread(new MainAssistObserver.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agdb
 * JD-Core Version:    0.7.0.1
 */