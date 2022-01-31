import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.fragment.CaptureSoDownloadFragmentAllWaite;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class agun
  implements Runnable
{
  public agun(CaptureSoDownloadFragmentAllWaite paramCaptureSoDownloadFragmentAllWaite, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "onStatusChanged: " + this.jdField_a_of_type_Boolean + " error:" + this.jdField_a_of_type_Int);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131432961, 0).a();
      CaptureSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite, -1);
      return;
    }
    CaptureSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite, 101);
    CaptureSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite, "onStatusChanged");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agun
 * JD-Core Version:    0.7.0.1
 */