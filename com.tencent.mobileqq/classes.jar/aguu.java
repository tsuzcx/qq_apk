import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jumplightalk.CLJumpLightalkConfig;
import com.tencent.mobileqq.qcall.QCallDetailActivity;

public class aguu
  implements Runnable
{
  public aguu(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void run()
  {
    QCallDetailActivity.a(this.a, CLJumpLightalkConfig.a(this.a.app.getCurrentAccountUin()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aguu
 * JD-Core Version:    0.7.0.1
 */