import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.qphone.base.util.QLog;

class ahrn
  implements DialogInterface.OnClickListener
{
  ahrn(ahri paramahri, int paramInt, Object paramObject, ahtm paramahtm) {}
  
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
      ahri.a(this.jdField_a_of_type_Ahri, (AIOImageData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Ahtm);
      this.jdField_a_of_type_Ahri.u();
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOShortVideoData));
    ahri.a(this.jdField_a_of_type_Ahri, (AIOShortVideoData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Ahtm);
    this.jdField_a_of_type_Ahtm.a.a = true;
    this.jdField_a_of_type_Ahri.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrn
 * JD-Core Version:    0.7.0.1
 */