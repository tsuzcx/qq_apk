import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.BindGroupConfirmActivity;

public class albi
  implements Runnable
{
  public albi(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     albi
 * JD-Core Version:    0.7.0.1
 */