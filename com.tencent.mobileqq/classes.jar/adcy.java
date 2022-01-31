import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.doodle.DoodleView;

public abstract class adcy
{
  protected Context a;
  protected Rect a;
  protected DoodleView a;
  
  public adcy(DoodleView paramDoodleView)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    if (paramDoodleView == null) {
      throw new IllegalStateException("DoodleView can not be null.");
    }
    this.jdField_a_of_type_AndroidContentContext = paramDoodleView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView = paramDoodleView;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramInt1, paramInt2);
  }
  
  public final void a(Canvas paramCanvas)
  {
    b(paramCanvas);
  }
  
  public boolean a()
  {
    return b();
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    b();
    return b(paramMotionEvent);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView.invalidate();
    }
  }
  
  protected abstract void b(Canvas paramCanvas);
  
  public boolean b()
  {
    return true;
  }
  
  protected abstract boolean b(MotionEvent paramMotionEvent);
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adcy
 * JD-Core Version:    0.7.0.1
 */