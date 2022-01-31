import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARCircleResult;

public class aams
  implements Runnable
{
  public aams(AREngine paramAREngine) {}
  
  public void run()
  {
    if ((AREngine.e(this.a)) && (AREngine.e(this.a) == 2))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.a.a != 0) {
        break label64;
      }
      if (AREngine.a(this.a) != null) {
        AREngine.b(this.a, 3);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Long = 0L;
      return;
      label64:
      if (this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.a.c == 0) {
        AREngine.g(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aams
 * JD-Core Version:    0.7.0.1
 */