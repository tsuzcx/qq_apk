import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.qphone.base.util.QLog;

class agdl
  implements DialogInterface.OnClickListener
{
  agdl(agdi paramagdi, int paramInt, Object paramObject, agfq paramagfq) {}
  
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
      agdi.a(this.jdField_a_of_type_Agdi, (AIOImageData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Agfq);
      this.jdField_a_of_type_Agdi.u();
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOShortVideoData));
    agdi.a(this.jdField_a_of_type_Agdi, (AIOShortVideoData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Agfq);
    this.jdField_a_of_type_Agfq.a.a = true;
    this.jdField_a_of_type_Agdi.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdl
 * JD-Core Version:    0.7.0.1
 */