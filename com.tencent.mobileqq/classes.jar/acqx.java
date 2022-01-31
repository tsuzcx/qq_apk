import android.app.Activity;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;

public class acqx
  extends FlingGestureHandler
{
  public acqx(ContactBindedActivity paramContactBindedActivity, Activity paramActivity)
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
 * Qualified Name:     acqx
 * JD-Core Version:    0.7.0.1
 */