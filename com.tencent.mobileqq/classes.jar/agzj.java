import com.tencent.mobileqq.qcall.QCallDetailActivity;

public class agzj
  implements Runnable
{
  public agzj(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void run()
  {
    QCallDetailActivity.a(this.a);
    this.a.runOnUiThread(new agzk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agzj
 * JD-Core Version:    0.7.0.1
 */