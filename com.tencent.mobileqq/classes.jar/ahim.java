import com.tencent.mobileqq.richmedia.capture.fragment.CaptureSoDownloadFragmentAllWaite;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

public class ahim
  implements Runnable
{
  public ahim(CaptureSoDownloadFragmentAllWaite paramCaptureSoDownloadFragmentAllWaite, String paramString) {}
  
  public void run()
  {
    if (CaptureSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite))
    {
      CaptureSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite).setProgress((CaptureSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite) + CaptureSoDownloadFragmentAllWaite.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite)) / 2);
      if (QLog.isColorLevel()) {
        QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "" + this.jdField_a_of_type_JavaLangString + " setProgress=" + (CaptureSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite) + CaptureSoDownloadFragmentAllWaite.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite)) / 2);
      }
      CaptureSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite);
    }
    do
    {
      return;
      CaptureSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite).setProgress(CaptureSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite));
    } while (!QLog.isColorLevel());
    QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "" + this.jdField_a_of_type_JavaLangString + " setProgress=" + CaptureSoDownloadFragmentAllWaite.c(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahim
 * JD-Core Version:    0.7.0.1
 */