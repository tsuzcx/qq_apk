import android.os.Handler;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;

class acvi
  implements Runnable
{
  acvi(acvh paramacvh) {}
  
  public void run()
  {
    if (this.a.a.f)
    {
      this.a.a.d();
      return;
    }
    this.a.a.e();
    this.a.a.d();
    new Handler().postDelayed(new acvj(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acvi
 * JD-Core Version:    0.7.0.1
 */