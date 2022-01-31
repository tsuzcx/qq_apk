import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

public class agcd
  implements Runnable
{
  public agcd(ScanOcrActivity paramScanOcrActivity) {}
  
  public void run()
  {
    ScanOcrActivity.a(this.a).e();
    ScanOcrActivity.b(this.a).setImageDrawable(new ColorDrawable(-16777216));
    ScanOcrActivity.b(this.a).setVisibility(0);
    ScanOcrActivity.b(this.a).postDelayed(new agce(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agcd
 * JD-Core Version:    0.7.0.1
 */