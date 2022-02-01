import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;

public class alpl
  extends OrientationEventListener
{
  public alpl(FlowCameraActivity2 paramFlowCameraActivity2, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.k = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alpl
 * JD-Core Version:    0.7.0.1
 */