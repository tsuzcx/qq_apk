import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.leba.QzoneFrame;

public class akgs
  extends BroadcastReceiver
{
  public akgs(QzoneFrame paramQzoneFrame) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QzoneFrame.a(this.a) != null) {
      ((bmxd)QzoneFrame.a(this.a)).updatePublishBox(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgs
 * JD-Core Version:    0.7.0.1
 */