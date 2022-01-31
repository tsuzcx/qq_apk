import com.tencent.mobileqq.intervideo.now.NowLoadingActivity;

public class adlb
  implements Runnable
{
  public adlb(NowLoadingActivity paramNowLoadingActivity) {}
  
  public void run()
  {
    if (!this.a.isFinishing()) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adlb
 * JD-Core Version:    0.7.0.1
 */