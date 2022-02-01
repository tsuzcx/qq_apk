import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.qphone.base.util.QLog;

class agym
  implements DialogInterface.OnClickListener
{
  agym(agyh paramagyh, int paramInt, Object paramObject, aham paramaham) {}
  
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
      agyh.a(this.jdField_a_of_type_Agyh, (AIOImageData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Aham);
      this.jdField_a_of_type_Agyh.u();
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOShortVideoData));
    agyh.a(this.jdField_a_of_type_Agyh, (AIOShortVideoData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Aham);
    this.jdField_a_of_type_Aham.a.a = true;
    this.jdField_a_of_type_Agyh.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agym
 * JD-Core Version:    0.7.0.1
 */