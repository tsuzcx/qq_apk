import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class alvl
  implements DialogInterface.OnClickListener
{
  public alvl(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    yup.a("video_shoot", "cancel_now", 0, 0, new String[0]);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvl
 * JD-Core Version:    0.7.0.1
 */