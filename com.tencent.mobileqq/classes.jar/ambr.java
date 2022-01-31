import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class ambr
  implements TypeEvaluator<ambo>
{
  public ambo a(float paramFloat, ambo paramambo1, ambo paramambo2)
  {
    long l = System.currentTimeMillis();
    float f1;
    float f2;
    amcr localamcr;
    ambo localambo;
    if (paramambo2.jdField_a_of_type_Amcr.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramambo1.jdField_a_of_type_Amcr.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramambo2.jdField_a_of_type_Amcr.e + 3.0F * f1 * paramFloat * paramFloat * paramambo2.jdField_a_of_type_Amcr.g + paramFloat * paramFloat * paramFloat * paramambo2.jdField_a_of_type_Amcr.jdField_a_of_type_Float;
      float f3 = paramambo1.jdField_a_of_type_Amcr.b;
      float f4 = paramambo2.jdField_a_of_type_Amcr.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramambo2.jdField_a_of_type_Amcr.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramambo2.jdField_a_of_type_Amcr.b;
      localamcr = amcr.b(f2, f1);
      localambo = new ambo();
      localamcr.d = (paramambo1.jdField_a_of_type_Amcr.d + (paramambo2.jdField_a_of_type_Amcr.d - paramambo1.jdField_a_of_type_Amcr.d) * paramFloat);
      localambo.jdField_a_of_type_Amcr = localamcr;
      localambo.jdField_a_of_type_Ambp = paramambo2.jdField_a_of_type_Ambp;
      localambo.jdField_a_of_type_AndroidGraphicsBitmap = paramambo2.jdField_a_of_type_AndroidGraphicsBitmap;
      localambo.jdField_a_of_type_JavaLangString = paramambo2.jdField_a_of_type_JavaLangString;
      localambo.jdField_b_of_type_JavaLangString = paramambo2.jdField_b_of_type_JavaLangString;
      localambo.jdField_a_of_type_JavaLangBoolean = paramambo2.jdField_a_of_type_JavaLangBoolean;
      localambo.jdField_a_of_type_Boolean = paramambo2.jdField_a_of_type_Boolean;
      localambo.jdField_a_of_type_AndroidGraphicsRect = paramambo2.jdField_a_of_type_AndroidGraphicsRect;
      if (paramambo1.jdField_b_of_type_Boolean) {
        if (paramFloat < 1.0D) {
          break label758;
        }
      }
    }
    label758:
    for (int i = 100;; i = (int)((paramFloat + 0.005D) * 100.0D))
    {
      localambo.jdField_a_of_type_Int = i;
      if ((localambo.jdField_a_of_type_Int - paramambo2.jdField_a_of_type_Int >= 5) || (paramambo2.jdField_a_of_type_Int == 0))
      {
        if ((paramambo2.jdField_b_of_type_Int == 0) || (paramambo2.c == 0))
        {
          paramambo2.jdField_b_of_type_Int = ((int)paramambo1.jdField_a_of_type_Amcr.jdField_a_of_type_Float);
          paramambo2.c = ((int)paramambo1.jdField_a_of_type_Amcr.b);
        }
        double d1 = Math.abs(f1 - paramambo2.c);
        double d2 = Math.abs(f2 - paramambo2.jdField_b_of_type_Int);
        double d3 = Math.pow(d1, 2.0D);
        d2 = Math.sqrt(Math.pow(d2, 2.0D) + d3);
        if ((d2 != 0.0D) && (d1 != 0.0D))
        {
          localamcr.c = ((float)Math.toDegrees(Math.asin(d1 / d2)));
          if (!paramambo2.jdField_a_of_type_Boolean) {
            localamcr.c = (-localamcr.c);
          }
        }
        if (Math.abs(localamcr.c) > 90.0F)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "too large rotate " + localamcr.c + ", reset to 0!");
          }
          localamcr.c = 0.0F;
        }
        if (QLog.isColorLevel())
        {
          QLog.i("BubbleInterActiveAnim", 2, "rotate: " + localamcr.c + " yDistance: " + d1 + ", distance: " + d2 + ", t: " + paramFloat);
          QLog.i("BubbleInterActiveAnim", 2, "evaluate_path_and_rotate, cost=" + (System.currentTimeMillis() - l));
        }
        paramambo2.jdField_a_of_type_Int = localambo.jdField_a_of_type_Int;
      }
      if (paramFloat == 1.0F) {
        localamcr.c = 360.0F;
      }
      paramambo2.jdField_b_of_type_Int = ((int)f2);
      paramambo2.c = ((int)f1);
      return localambo;
      if (paramambo2.jdField_a_of_type_Amcr.jdField_a_of_type_Int == 1)
      {
        f1 = paramambo1.jdField_a_of_type_Amcr.jdField_a_of_type_Float;
        f2 = (paramambo2.jdField_a_of_type_Amcr.jdField_a_of_type_Float - paramambo1.jdField_a_of_type_Amcr.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramambo1.jdField_a_of_type_Amcr.b + (paramambo2.jdField_a_of_type_Amcr.b - paramambo1.jdField_a_of_type_Amcr.b) * paramFloat;
        break;
      }
      f2 = paramambo2.jdField_a_of_type_Amcr.jdField_a_of_type_Float;
      f1 = paramambo2.jdField_a_of_type_Amcr.b;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambr
 * JD-Core Version:    0.7.0.1
 */