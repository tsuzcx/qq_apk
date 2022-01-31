import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DoodleView;

public abstract class agqz
{
  protected Context a;
  protected Rect a;
  protected DoodleView a;
  
  public agqz(DoodleView paramDoodleView)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    if (paramDoodleView == null) {
      throw new IllegalStateException("DoodleView can not be null.");
    }
    this.jdField_a_of_type_AndroidContentContext = paramDoodleView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView = paramDoodleView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView.invalidate();
    }
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
    a();
    return b(paramMotionEvent);
  }
  
  protected abstract void b(Canvas paramCanvas);
  
  public boolean b()
  {
    return true;
  }
  
  protected abstract boolean b(MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agqz
 * JD-Core Version:    0.7.0.1
 */