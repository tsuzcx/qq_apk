import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class alvm
  implements DialogInterface.OnClickListener
{
  public alvm(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    yup.a("video_shoot", "down_now", 0, 0, new String[0]);
    awcc.b(null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvm
 * JD-Core Version:    0.7.0.1
 */