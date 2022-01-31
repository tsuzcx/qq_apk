import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.qphone.base.util.QLog;

public class akli
  implements Runnable
{
  public akli(BindGroupActivity paramBindGroupActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->onGetOpenId timeout.");
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.c = true;
    this.a.b.hide();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akli
 * JD-Core Version:    0.7.0.1
 */