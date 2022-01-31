import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.ChatHistoryViewBase.1;

public abstract class aasw
{
  public ChatHistoryFileActivity a;
  public boolean i = true;
  
  public abstract View a();
  
  public void a() {}
  
  public void a(long paramLong) {}
  
  public abstract boolean a();
  
  public void b() {}
  
  protected boolean b()
  {
    return this.i;
  }
  
  public void c() {}
  
  public abstract void d();
  
  public abstract void e();
  
  public void h_(int paramInt) {}
  
  protected void k()
  {
    this.i = false;
    new Handler().postDelayed(new ChatHistoryViewBase.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aasw
 * JD-Core Version:    0.7.0.1
 */