import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.qphone.base.util.QLog;

class ahsi
  implements DialogInterface.OnClickListener
{
  ahsi(ahsd paramahsd, int paramInt, Object paramObject, ahui paramahui) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    case 2: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "showSaveFileTips type = " + this.jdField_a_of_type_Int);
      }
      break;
    }
    do
    {
      do
      {
        return;
      } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOImageData));
      ahsd.a(this.jdField_a_of_type_Ahsd, (AIOImageData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Ahui);
      this.jdField_a_of_type_Ahsd.u();
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOShortVideoData));
    ahsd.a(this.jdField_a_of_type_Ahsd, (AIOShortVideoData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Ahui);
    this.jdField_a_of_type_Ahui.a.a = true;
    this.jdField_a_of_type_Ahsd.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsi
 * JD-Core Version:    0.7.0.1
 */