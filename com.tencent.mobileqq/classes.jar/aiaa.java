import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.FileUtils;

class aiaa
  implements DialogInterface.OnClickListener
{
  aiaa(ahzx paramahzx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    FileUtils.deleteFile(this.a.b);
    this.a.b = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiaa
 * JD-Core Version:    0.7.0.1
 */