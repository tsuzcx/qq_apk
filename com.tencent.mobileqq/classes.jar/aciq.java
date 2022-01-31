import android.os.SystemClock;
import com.tencent.mobileqq.emosm.view.DragSortListView;

public class aciq
  implements Runnable
{
  private float jdField_a_of_type_Float;
  protected long a;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private float c;
  private float d;
  private float e;
  private float f;
  
  public aciq(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    this.jdField_b_of_type_Float = paramFloat;
    this.jdField_a_of_type_Float = paramInt;
    paramFloat = 1.0F / (this.jdField_b_of_type_Float * 2.0F * (1.0F - this.jdField_b_of_type_Float));
    this.f = paramFloat;
    this.c = paramFloat;
    this.d = (this.jdField_b_of_type_Float / ((this.jdField_b_of_type_Float - 1.0F) * 2.0F));
    this.e = (1.0F / (1.0F - this.jdField_b_of_type_Float));
  }
  
  public float a(float paramFloat)
  {
    if (paramFloat < this.jdField_b_of_type_Float) {
      return this.c * paramFloat * paramFloat;
    }
    if (paramFloat < 1.0F - this.jdField_b_of_type_Float) {
      return this.d + this.e * paramFloat;
    }
    return 1.0F - this.f * (paramFloat - 1.0F) * (paramFloat - 1.0F);
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void b() {}
  
  public void c()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Boolean = false;
    a();
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.post(this);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    float f1 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.jdField_a_of_type_Float;
    if (f1 >= 1.0F)
    {
      a(1.0F, 1.0F);
      b();
      return;
    }
    a(f1, a(f1));
    this.jdField_b_of_type_ComTencentMobileqqEmosmViewDragSortListView.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aciq
 * JD-Core Version:    0.7.0.1
 */