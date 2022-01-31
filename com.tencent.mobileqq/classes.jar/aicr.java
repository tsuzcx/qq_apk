import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureListener;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.mobileqq.shortvideo.ptvfilter.NonFit2DFilter;
import com.tencent.ttpic.util.VideoGlobalContext;

public class aicr
  implements GLGestureListener
{
  public aicr(NonFit2DFilter paramNonFit2DFilter) {}
  
  public int a()
  {
    return 1030;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction();
    if (i > 2)
    {
      NonFit2DFilter.a("onClick two_more pointer!");
      return false;
    }
    float f2;
    float f1;
    if ((i == 2) && (paramBoolean))
    {
      f2 = GLGestureProxy.a().a(paramMotionEvent.getX(1));
      f1 = GLGestureProxy.a().b(paramMotionEvent.getY(1));
      switch (j & 0xFF)
      {
      }
    }
    for (;;)
    {
      return true;
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      break;
      NonFit2DFilter.a(this.a).x = f2;
      NonFit2DFilter.a(this.a).y = f1;
      NonFit2DFilter.a(this.a, true);
      continue;
      if (NonFit2DFilter.a(NonFit2DFilter.a(this.a).x, NonFit2DFilter.a(this.a).y, f2, f1) > NonFit2DFilter.a(VideoGlobalContext.getContext()) * 0.05F)
      {
        NonFit2DFilter.a(this.a, false);
        NonFit2DFilter.a("onClick move, x:" + f2 + ", y:" + f1);
        continue;
        NonFit2DFilter.a("onClick up mNeedRecordTouchPoint:" + NonFit2DFilter.a(this.a) + ", isRecording:" + paramBoolean);
        if ((NonFit2DFilter.a(this.a)) && (!paramBoolean)) {
          NonFit2DFilter.a(this.a, paramMotionEvent.getX(), paramMotionEvent.getY());
        }
        NonFit2DFilter.a(this.a, true);
        continue;
        NonFit2DFilter.a("onClick point_down pointCnt:" + i + ", isRecording:" + paramBoolean + ", x:" + f2 + ", y:" + f1);
        if ((i == 2) && (paramBoolean))
        {
          NonFit2DFilter.a(this.a).x = f2;
          NonFit2DFilter.a(this.a).y = f1;
          NonFit2DFilter.a(this.a, true);
          continue;
          NonFit2DFilter.a("onClick point_up mNeedRecordTouchPoint:" + NonFit2DFilter.a(this.a));
          if (NonFit2DFilter.a(this.a))
          {
            if ((i == 2) && (paramBoolean)) {
              NonFit2DFilter.a(this.a, f2, f1);
            }
            NonFit2DFilter.a(this.a, false);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aicr
 * JD-Core Version:    0.7.0.1
 */