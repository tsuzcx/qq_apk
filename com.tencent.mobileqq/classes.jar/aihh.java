import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class aihh
  implements DialogInterface.OnClickListener
{
  aihh(aihg paramaihg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
      ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.a.a.jdField_b_of_type_JavaLangString, (MqqHandler)this.a.a.jdField_b_of_type_JavaLangRefWeakReference.get(), this.a.a.g + ".mp4", true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aihh
 * JD-Core Version:    0.7.0.1
 */