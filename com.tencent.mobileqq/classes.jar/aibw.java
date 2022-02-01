import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.qphone.base.util.QLog;

class aibw
  implements DialogInterface.OnClickListener
{
  aibw(aibr paramaibr, int paramInt, Object paramObject, aidw paramaidw) {}
  
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
      aibr.a(this.jdField_a_of_type_Aibr, (AIOImageData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Aidw);
      this.jdField_a_of_type_Aibr.u();
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOShortVideoData));
    aibr.a(this.jdField_a_of_type_Aibr, (AIOShortVideoData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Aidw);
    this.jdField_a_of_type_Aidw.a.a = true;
    this.jdField_a_of_type_Aibr.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibw
 * JD-Core Version:    0.7.0.1
 */