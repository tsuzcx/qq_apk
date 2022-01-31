import android.widget.TextView;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

class agck
  implements Runnable
{
  agck(agch paramagch) {}
  
  public void run()
  {
    ScanOcrActivity.a(this.a.a).setVisibility(0);
    ScanOcrActivity.a(this.a.a).setText(ScanOcrActivity.a(this.a.a));
    if (this.a.a.jdField_a_of_type_Int != 1)
    {
      if (!ScanOcrActivity.a(this.a.a).a())
      {
        ScanOcrActivity.a(this.a.a).setVisibility(0);
        ScanOcrActivity.a(this.a.a).postDelayed(new agcl(this), 500L);
      }
      return;
    }
    this.a.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agck
 * JD-Core Version:    0.7.0.1
 */