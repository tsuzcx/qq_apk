import android.widget.TextView;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

class afpc
  implements Runnable
{
  afpc(afpb paramafpb, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      ScanOcrActivity.a(this.jdField_a_of_type_Afpb.a).setVisibility(0);
      ScanOcrActivity.a(this.jdField_a_of_type_Afpb.a).setText(2131433715);
      if (this.jdField_a_of_type_Afpb.a.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Afpb.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
      }
      return;
    }
    if (this.jdField_a_of_type_Afpb.a.jdField_a_of_type_Int != 1) {
      if (!ScanOcrActivity.a(this.jdField_a_of_type_Afpb.a).a())
      {
        ScanOcrActivity.a(this.jdField_a_of_type_Afpb.a).setVisibility(0);
        ScanOcrActivity.a(this.jdField_a_of_type_Afpb.a).postDelayed(new afpd(this), 500L);
      }
    }
    for (;;)
    {
      ScanOcrActivity.a(this.jdField_a_of_type_Afpb.a).setVisibility(0);
      ScanOcrActivity.a(this.jdField_a_of_type_Afpb.a).setText(ScanOcrActivity.a(this.jdField_a_of_type_Afpb.a));
      return;
      this.jdField_a_of_type_Afpb.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afpc
 * JD-Core Version:    0.7.0.1
 */