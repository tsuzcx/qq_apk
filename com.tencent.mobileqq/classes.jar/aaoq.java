import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;

class aaoq
  extends LinearSmoothScroller
{
  aaoq(aaop paramaaop, Context paramContext)
  {
    super(paramContext);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaoq
 * JD-Core Version:    0.7.0.1
 */