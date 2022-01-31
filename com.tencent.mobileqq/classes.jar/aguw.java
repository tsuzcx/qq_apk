import com.tencent.mobileqq.qcall.QCallDetailActivity;

public class aguw
  implements Runnable
{
  public aguw(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void run()
  {
    QCallDetailActivity.a(this.a);
    this.a.runOnUiThread(new agux(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aguw
 * JD-Core Version:    0.7.0.1
 */