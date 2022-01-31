import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aegw
  implements DialogInterface.OnClickListener
{
  aegw(aegs paramaegs) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "showSaveFileTips cancel");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aegw
 * JD-Core Version:    0.7.0.1
 */