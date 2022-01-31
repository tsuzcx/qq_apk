import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class ahve
  implements DialogInterface.OnClickListener
{
  public ahve(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    vei.a("video_shoot", "cancel_now", 0, 0, new String[0]);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahve
 * JD-Core Version:    0.7.0.1
 */