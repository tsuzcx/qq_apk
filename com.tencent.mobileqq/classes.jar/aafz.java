import android.graphics.PointF;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARCircleResult;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;
import com.tencent.qphone.base.util.QLog;

public class aafz
  implements Runnable
{
  public aafz(AREngine paramAREngine) {}
  
  public void run()
  {
    int i = 0;
    if (i < 2)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.a.g <= this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.a.e - 1) {
        break label75;
      }
      this.a.c = true;
    }
    label75:
    while (this.a.c == true)
    {
      if (!this.a.c) {
        AREngine.a(this.a.jdField_a_of_type_JavaLangRunnable, this.a.b);
      }
      return;
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.a.b[this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.a.g];
    localObject = ARLocalGestureCircleRecog.a(AREngine.f(this.a), AREngine.g(this.a), AREngine.h(this.a), AREngine.i(this.a), (PointF)localObject);
    int j = (int)((PointF)localObject).x;
    int k = (int)((PointF)localObject).y;
    int m = this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.a.a[this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.a.g];
    localObject = ARWorldCupGameLogicManager.a();
    if (this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.a.g == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ARWorldCupGameLogicManager)localObject).a(new int[] { j }, new int[] { k }, new int[] { m }, bool);
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.a;
      ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject).g += 1;
      QLog.i("AREngine_AREngine", 1, "DrawCircle. mDrawCirclePuase = " + this.a.c + ", genIdx = " + this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.a.g);
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aafz
 * JD-Core Version:    0.7.0.1
 */