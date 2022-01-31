import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class alne
  implements TypeEvaluator<alnb>
{
  public alnb a(float paramFloat, alnb paramalnb1, alnb paramalnb2)
  {
    long l = System.currentTimeMillis();
    float f1;
    float f2;
    alod localalod;
    alnb localalnb;
    if (paramalnb2.jdField_a_of_type_Alod.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramalnb1.jdField_a_of_type_Alod.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramalnb2.jdField_a_of_type_Alod.e + 3.0F * f1 * paramFloat * paramFloat * paramalnb2.jdField_a_of_type_Alod.g + paramFloat * paramFloat * paramFloat * paramalnb2.jdField_a_of_type_Alod.jdField_a_of_type_Float;
      float f3 = paramalnb1.jdField_a_of_type_Alod.b;
      float f4 = paramalnb2.jdField_a_of_type_Alod.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramalnb2.jdField_a_of_type_Alod.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramalnb2.jdField_a_of_type_Alod.b;
      localalod = alod.b(f2, f1);
      localalnb = new alnb();
      localalod.d = (paramalnb1.jdField_a_of_type_Alod.d + (paramalnb2.jdField_a_of_type_Alod.d - paramalnb1.jdField_a_of_type_Alod.d) * paramFloat);
      localalnb.jdField_a_of_type_Alod = localalod;
      localalnb.jdField_a_of_type_Alnc = paramalnb2.jdField_a_of_type_Alnc;
      localalnb.jdField_a_of_type_AndroidGraphicsBitmap = paramalnb2.jdField_a_of_type_AndroidGraphicsBitmap;
      localalnb.jdField_a_of_type_JavaLangString = paramalnb2.jdField_a_of_type_JavaLangString;
      localalnb.jdField_b_of_type_JavaLangString = paramalnb2.jdField_b_of_type_JavaLangString;
      localalnb.jdField_a_of_type_JavaLangBoolean = paramalnb2.jdField_a_of_type_JavaLangBoolean;
      localalnb.jdField_a_of_type_Boolean = paramalnb2.jdField_a_of_type_Boolean;
      localalnb.jdField_a_of_type_AndroidGraphicsRect = paramalnb2.jdField_a_of_type_AndroidGraphicsRect;
      if (paramalnb1.jdField_b_of_type_Boolean) {
        if (paramFloat < 1.0D) {
          break label758;
        }
      }
    }
    label758:
    for (int i = 100;; i = (int)((paramFloat + 0.005D) * 100.0D))
    {
      localalnb.jdField_a_of_type_Int = i;
      if ((localalnb.jdField_a_of_type_Int - paramalnb2.jdField_a_of_type_Int >= 5) || (paramalnb2.jdField_a_of_type_Int == 0))
      {
        if ((paramalnb2.jdField_b_of_type_Int == 0) || (paramalnb2.c == 0))
        {
          paramalnb2.jdField_b_of_type_Int = ((int)paramalnb1.jdField_a_of_type_Alod.jdField_a_of_type_Float);
          paramalnb2.c = ((int)paramalnb1.jdField_a_of_type_Alod.b);
        }
        double d1 = Math.abs(f1 - paramalnb2.c);
        double d2 = Math.abs(f2 - paramalnb2.jdField_b_of_type_Int);
        double d3 = Math.pow(d1, 2.0D);
        d2 = Math.sqrt(Math.pow(d2, 2.0D) + d3);
        if ((d2 != 0.0D) && (d1 != 0.0D))
        {
          localalod.c = ((float)Math.toDegrees(Math.asin(d1 / d2)));
          if (!paramalnb2.jdField_a_of_type_Boolean) {
            localalod.c = (-localalod.c);
          }
        }
        if (Math.abs(localalod.c) > 90.0F)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "too large rotate " + localalod.c + ", reset to 0!");
          }
          localalod.c = 0.0F;
        }
        if (QLog.isColorLevel())
        {
          QLog.i("BubbleInterActiveAnim", 2, "rotate: " + localalod.c + " yDistance: " + d1 + ", distance: " + d2 + ", t: " + paramFloat);
          QLog.i("BubbleInterActiveAnim", 2, "evaluate_path_and_rotate, cost=" + (System.currentTimeMillis() - l));
        }
        paramalnb2.jdField_a_of_type_Int = localalnb.jdField_a_of_type_Int;
      }
      if (paramFloat == 1.0F) {
        localalod.c = 360.0F;
      }
      paramalnb2.jdField_b_of_type_Int = ((int)f2);
      paramalnb2.c = ((int)f1);
      return localalnb;
      if (paramalnb2.jdField_a_of_type_Alod.jdField_a_of_type_Int == 1)
      {
        f1 = paramalnb1.jdField_a_of_type_Alod.jdField_a_of_type_Float;
        f2 = (paramalnb2.jdField_a_of_type_Alod.jdField_a_of_type_Float - paramalnb1.jdField_a_of_type_Alod.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramalnb1.jdField_a_of_type_Alod.b + (paramalnb2.jdField_a_of_type_Alod.b - paramalnb1.jdField_a_of_type_Alod.b) * paramFloat;
        break;
      }
      f2 = paramalnb2.jdField_a_of_type_Alod.jdField_a_of_type_Float;
      f1 = paramalnb2.jdField_a_of_type_Alod.b;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alne
 * JD-Core Version:    0.7.0.1
 */