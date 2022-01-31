import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.qphone.base.util.QLog;

public class ahuq
  extends OrientationEventListener
{
  public ahuq(NewFlowCameraActivity paramNewFlowCameraActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    NewFlowCameraActivity.a(this.a).a(paramInt);
    if (this.a.j) {}
    do
    {
      return;
      if (paramInt == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "OrientationEventListener unknown");
        }
        this.a.o = 90;
        return;
      }
      if ((paramInt > 315) || (paramInt < 45))
      {
        this.a.o = 90;
        return;
      }
      if ((paramInt > 45) && (paramInt < 135))
      {
        this.a.o = 180;
        return;
      }
      if ((paramInt > 135) && (paramInt < 225))
      {
        this.a.o = 270;
        return;
      }
    } while ((paramInt <= 225) || (paramInt >= 315));
    this.a.o = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahuq
 * JD-Core Version:    0.7.0.1
 */