import android.app.Activity;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;

public class adcm
  extends FlingGestureHandler
{
  public adcm(ContactBindedActivity paramContactBindedActivity, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void flingLToR()
  {
    if (!this.a.a) {
      super.flingLToR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcm
 * JD-Core Version:    0.7.0.1
 */