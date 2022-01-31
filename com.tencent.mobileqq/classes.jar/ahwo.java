import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;

public class ahwo
  implements DialogInterface.OnClickListener
{
  public ahwo(QzoneSlideShowPreparingFragment paramQzoneSlideShowPreparingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QzoneSlideShowPreparingFragment.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahwo
 * JD-Core Version:    0.7.0.1
 */