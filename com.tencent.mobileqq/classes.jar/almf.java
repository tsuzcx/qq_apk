import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class almf
  implements Runnable
{
  public almf(GestureSelectGridView paramGestureSelectGridView) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if ((!this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.a.jdField_b_of_type_Int != -1))
    {
      if (this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener != null) {
        this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener.b(this.a.jdField_b_of_type_Int);
      }
      this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     almf
 * JD-Core Version:    0.7.0.1
 */