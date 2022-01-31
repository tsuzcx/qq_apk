import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.qphone.base.util.QLog;

class agia
  implements DialogInterface.OnClickListener
{
  agia(aghx paramaghx, int paramInt, Object paramObject, agkf paramagkf) {}
  
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
      aghx.a(this.jdField_a_of_type_Aghx, (AIOImageData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Agkf);
      this.jdField_a_of_type_Aghx.u();
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOShortVideoData));
    aghx.a(this.jdField_a_of_type_Aghx, (AIOShortVideoData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Agkf);
    this.jdField_a_of_type_Agkf.a.a = true;
    this.jdField_a_of_type_Aghx.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agia
 * JD-Core Version:    0.7.0.1
 */