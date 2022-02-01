import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class alqz
  implements DialogInterface.OnClickListener
{
  public alqz(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ykv.a("video_shoot", "down_now", 0, 0, new String[0]);
    avux.c(null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqz
 * JD-Core Version:    0.7.0.1
 */