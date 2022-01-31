import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class ambs
  implements TypeEvaluator<ambp>
{
  public ambp a(float paramFloat, ambp paramambp1, ambp paramambp2)
  {
    long l = System.currentTimeMillis();
    float f1;
    float f2;
    amcs localamcs;
    ambp localambp;
    if (paramambp2.jdField_a_of_type_Amcs.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramambp1.jdField_a_of_type_Amcs.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramambp2.jdField_a_of_type_Amcs.e + 3.0F * f1 * paramFloat * paramFloat * paramambp2.jdField_a_of_type_Amcs.g + paramFloat * paramFloat * paramFloat * paramambp2.jdField_a_of_type_Amcs.jdField_a_of_type_Float;
      float f3 = paramambp1.jdField_a_of_type_Amcs.b;
      float f4 = paramambp2.jdField_a_of_type_Amcs.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramambp2.jdField_a_of_type_Amcs.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramambp2.jdField_a_of_type_Amcs.b;
      localamcs = amcs.b(f2, f1);
      localambp = new ambp();
      localamcs.d = (paramambp1.jdField_a_of_type_Amcs.d + (paramambp2.jdField_a_of_type_Amcs.d - paramambp1.jdField_a_of_type_Amcs.d) * paramFloat);
      localambp.jdField_a_of_type_Amcs = localamcs;
      localambp.jdField_a_of_type_Ambq = paramambp2.jdField_a_of_type_Ambq;
      localambp.jdField_a_of_type_AndroidGraphicsBitmap = paramambp2.jdField_a_of_type_AndroidGraphicsBitmap;
      localambp.jdField_a_of_type_JavaLangString = paramambp2.jdField_a_of_type_JavaLangString;
      localambp.jdField_b_of_type_JavaLangString = paramambp2.jdField_b_of_type_JavaLangString;
      localambp.jdField_a_of_type_JavaLangBoolean = paramambp2.jdField_a_of_type_JavaLangBoolean;
      localambp.jdField_a_of_type_Boolean = paramambp2.jdField_a_of_type_Boolean;
      localambp.jdField_a_of_type_AndroidGraphicsRect = paramambp2.jdField_a_of_type_AndroidGraphicsRect;
      if (paramambp1.jdField_b_of_type_Boolean) {
        if (paramFloat < 1.0D) {
          break label758;
        }
      }
    }
    label758:
    for (int i = 100;; i = (int)((paramFloat + 0.005D) * 100.0D))
    {
      localambp.jdField_a_of_type_Int = i;
      if ((localambp.jdField_a_of_type_Int - paramambp2.jdField_a_of_type_Int >= 5) || (paramambp2.jdField_a_of_type_Int == 0))
      {
        if ((paramambp2.jdField_b_of_type_Int == 0) || (paramambp2.c == 0))
        {
          paramambp2.jdField_b_of_type_Int = ((int)paramambp1.jdField_a_of_type_Amcs.jdField_a_of_type_Float);
          paramambp2.c = ((int)paramambp1.jdField_a_of_type_Amcs.b);
        }
        double d1 = Math.abs(f1 - paramambp2.c);
        double d2 = Math.abs(f2 - paramambp2.jdField_b_of_type_Int);
        double d3 = Math.pow(d1, 2.0D);
        d2 = Math.sqrt(Math.pow(d2, 2.0D) + d3);
        if ((d2 != 0.0D) && (d1 != 0.0D))
        {
          localamcs.c = ((float)Math.toDegrees(Math.asin(d1 / d2)));
          if (!paramambp2.jdField_a_of_type_Boolean) {
            localamcs.c = (-localamcs.c);
          }
        }
        if (Math.abs(localamcs.c) > 90.0F)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "too large rotate " + localamcs.c + ", reset to 0!");
          }
          localamcs.c = 0.0F;
        }
        if (QLog.isColorLevel())
        {
          QLog.i("BubbleInterActiveAnim", 2, "rotate: " + localamcs.c + " yDistance: " + d1 + ", distance: " + d2 + ", t: " + paramFloat);
          QLog.i("BubbleInterActiveAnim", 2, "evaluate_path_and_rotate, cost=" + (System.currentTimeMillis() - l));
        }
        paramambp2.jdField_a_of_type_Int = localambp.jdField_a_of_type_Int;
      }
      if (paramFloat == 1.0F) {
        localamcs.c = 360.0F;
      }
      paramambp2.jdField_b_of_type_Int = ((int)f2);
      paramambp2.c = ((int)f1);
      return localambp;
      if (paramambp2.jdField_a_of_type_Amcs.jdField_a_of_type_Int == 1)
      {
        f1 = paramambp1.jdField_a_of_type_Amcs.jdField_a_of_type_Float;
        f2 = (paramambp2.jdField_a_of_type_Amcs.jdField_a_of_type_Float - paramambp1.jdField_a_of_type_Amcs.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramambp1.jdField_a_of_type_Amcs.b + (paramambp2.jdField_a_of_type_Amcs.b - paramambp1.jdField_a_of_type_Amcs.b) * paramFloat;
        break;
      }
      f2 = paramambp2.jdField_a_of_type_Amcs.jdField_a_of_type_Float;
      f1 = paramambp2.jdField_a_of_type_Amcs.b;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambs
 * JD-Core Version:    0.7.0.1
 */