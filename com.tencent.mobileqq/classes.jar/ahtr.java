import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;

public class ahtr
  extends OrientationEventListener
{
  public ahtr(FlowCameraActivity2 paramFlowCameraActivity2, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.k = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahtr
 * JD-Core Version:    0.7.0.1
 */