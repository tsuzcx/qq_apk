import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.qphone.base.util.QLog;

class aegv
  implements DialogInterface.OnClickListener
{
  aegv(aegs paramaegs, int paramInt, Object paramObject, aeiy paramaeiy) {}
  
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
      aegs.a(this.jdField_a_of_type_Aegs, (AIOImageData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Aeiy);
      this.jdField_a_of_type_Aegs.u();
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOShortVideoData));
    aegs.a(this.jdField_a_of_type_Aegs, (AIOShortVideoData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Aeiy);
    this.jdField_a_of_type_Aeiy.a.a = true;
    this.jdField_a_of_type_Aegs.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aegv
 * JD-Core Version:    0.7.0.1
 */