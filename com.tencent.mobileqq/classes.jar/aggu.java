import com.tencent.mobileqq.qcall.QCallDetailActivity;

public class aggu
  implements Runnable
{
  public aggu(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void run()
  {
    QCallDetailActivity.a(this.a);
    this.a.runOnUiThread(new aggv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aggu
 * JD-Core Version:    0.7.0.1
 */