import com.tencent.mobileqq.richmedia.capture.fragment.CaptureSoDownloadFragmentAllWaite;
import com.tencent.qphone.base.util.QLog;

public class aguo
  implements Runnable
{
  public aguo(CaptureSoDownloadFragmentAllWaite paramCaptureSoDownloadFragmentAllWaite, int paramInt) {}
  
  public void run()
  {
    CaptureSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "onDownloadProgress mGestureState=" + CaptureSoDownloadFragmentAllWaite.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite) + " mVideoState=" + CaptureSoDownloadFragmentAllWaite.c(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite) + ",mFilterSoState=" + CaptureSoDownloadFragmentAllWaite.d(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite) + ",mQmcfState=" + CaptureSoDownloadFragmentAllWaite.e(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite));
    }
    CaptureSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite, "GestureDownloadProgress");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aguo
 * JD-Core Version:    0.7.0.1
 */