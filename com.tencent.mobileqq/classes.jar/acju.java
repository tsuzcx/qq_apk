import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.ChatHistoryViewBase.1;

public abstract class acju
{
  public ChatHistoryFileActivity a;
  public boolean i = true;
  
  public abstract View a();
  
  public void a(int paramInt) {}
  
  public void a(long paramLong) {}
  
  public void b() {}
  
  public abstract boolean b();
  
  public void c() {}
  
  protected boolean c()
  {
    return this.i;
  }
  
  public void d() {}
  
  public abstract void e();
  
  public abstract void f();
  
  protected void k()
  {
    this.i = false;
    new Handler().postDelayed(new ChatHistoryViewBase.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acju
 * JD-Core Version:    0.7.0.1
 */