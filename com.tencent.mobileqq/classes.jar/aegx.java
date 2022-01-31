import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.qphone.base.util.QLog;

class aegx
  implements DialogInterface.OnClickListener
{
  aegx(aegu paramaegu, int paramInt, Object paramObject, aeja paramaeja) {}
  
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
      aegu.a(this.jdField_a_of_type_Aegu, (AIOImageData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Aeja);
      this.jdField_a_of_type_Aegu.u();
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOShortVideoData));
    aegu.a(this.jdField_a_of_type_Aegu, (AIOShortVideoData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Aeja);
    this.jdField_a_of_type_Aeja.a.a = true;
    this.jdField_a_of_type_Aegu.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aegx
 * JD-Core Version:    0.7.0.1
 */