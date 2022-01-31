import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import java.io.File;
import java.util.Locale;
import mqq.os.MqqHandler;

class agec
  implements DialogInterface.OnClickListener
{
  agec(ageb paramageb, File paramFile) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_JavaIoFile.getParentFile().getName().toLowerCase(Locale.US) + ".mp4";
    ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Ageb.a.a, paramDialogInterface, true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agec
 * JD-Core Version:    0.7.0.1
 */