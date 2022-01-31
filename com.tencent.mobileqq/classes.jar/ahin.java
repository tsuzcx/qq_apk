import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.fragment.CaptureSoDownloadFragmentAllWaite;
import com.tencent.qphone.base.util.QLog;

public class ahin
  implements Runnable
{
  public ahin(CaptureSoDownloadFragmentAllWaite paramCaptureSoDownloadFragmentAllWaite, String paramString) {}
  
  public void run()
  {
    CaptureSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCaptureSoDownloadFragmentAllWaite).setText(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "setTipsTextData: textData=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahin
 * JD-Core Version:    0.7.0.1
 */