import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aibx
  implements DialogInterface.OnClickListener
{
  aibx(aibr paramaibr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "showSaveFileTips cancel");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibx
 * JD-Core Version:    0.7.0.1
 */