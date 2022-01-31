import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.fragment.CaptureSoDownloadFragment;
import com.tencent.qphone.base.util.QLog;

public class agui
  implements Runnable
{
  public agui(CaptureSoDownloadFragment paramCaptureSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    CaptureSoDownloadFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragment).setText(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureSoDownloadFragment", 2, "setTipsTextData: textData=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agui
 * JD-Core Version:    0.7.0.1
 */