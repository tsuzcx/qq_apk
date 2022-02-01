import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import cooperation.qzone.api.QzoneFragmentImpl;

public class ajel
  extends BroadcastReceiver
{
  public ajel(QzoneFrame paramQzoneFrame) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QzoneFrame.a(this.a) != null) {
      ((QzoneFragmentImpl)QzoneFrame.a(this.a)).updatePublishBox(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajel
 * JD-Core Version:    0.7.0.1
 */