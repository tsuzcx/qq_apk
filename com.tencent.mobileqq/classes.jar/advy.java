import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.qphone.base.util.QLog;

class advy
  implements DialogInterface.OnClickListener
{
  advy(advv paramadvv, int paramInt, Object paramObject, adyb paramadyb) {}
  
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
      advv.a(this.jdField_a_of_type_Advv, (AIOImageData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Adyb);
      this.jdField_a_of_type_Advv.u();
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOShortVideoData));
    advv.a(this.jdField_a_of_type_Advv, (AIOShortVideoData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Adyb);
    this.jdField_a_of_type_Adyb.a.a = true;
    this.jdField_a_of_type_Advv.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     advy
 * JD-Core Version:    0.7.0.1
 */