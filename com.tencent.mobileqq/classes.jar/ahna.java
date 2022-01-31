import com.tencent.mobileqq.richmedia.capture.fragment.CaptureSoDownloadFragment;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

public class ahna
  implements Runnable
{
  public ahna(CaptureSoDownloadFragment paramCaptureSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    CaptureSoDownloadFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragment).setProgress(CaptureSoDownloadFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragment));
    if (QLog.isColorLevel()) {
      QLog.d("CaptureSoDownloadFragment", 2, "" + this.jdField_a_of_type_JavaLangString + " setProgress=" + CaptureSoDownloadFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragment));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahna
 * JD-Core Version:    0.7.0.1
 */