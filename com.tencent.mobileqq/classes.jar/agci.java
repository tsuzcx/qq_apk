import android.widget.TextView;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

class agci
  implements Runnable
{
  agci(agch paramagch, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      ScanOcrActivity.a(this.jdField_a_of_type_Agch.a).setVisibility(0);
      ScanOcrActivity.a(this.jdField_a_of_type_Agch.a).setText(2131433732);
      if (this.jdField_a_of_type_Agch.a.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Agch.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
      }
      return;
    }
    if (this.jdField_a_of_type_Agch.a.jdField_a_of_type_Int != 1) {
      if (!ScanOcrActivity.a(this.jdField_a_of_type_Agch.a).a())
      {
        ScanOcrActivity.a(this.jdField_a_of_type_Agch.a).setVisibility(0);
        ScanOcrActivity.a(this.jdField_a_of_type_Agch.a).postDelayed(new agcj(this), 500L);
      }
    }
    for (;;)
    {
      ScanOcrActivity.a(this.jdField_a_of_type_Agch.a).setVisibility(0);
      ScanOcrActivity.a(this.jdField_a_of_type_Agch.a).setText(ScanOcrActivity.a(this.jdField_a_of_type_Agch.a));
      return;
      this.jdField_a_of_type_Agch.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agci
 * JD-Core Version:    0.7.0.1
 */