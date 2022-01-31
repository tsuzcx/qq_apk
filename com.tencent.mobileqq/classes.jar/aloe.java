import android.animation.TypeEvaluator;
import android.annotation.TargetApi;

@TargetApi(11)
public class aloe
  implements TypeEvaluator<alod>
{
  public alod a(float paramFloat, alod paramalod1, alod paramalod2)
  {
    float f1;
    float f2;
    if (paramalod2.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramalod1.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramalod2.e + 3.0F * f1 * paramFloat * paramFloat * paramalod2.g + paramFloat * paramFloat * paramFloat * paramalod2.jdField_a_of_type_Float;
      float f3 = paramalod1.b;
      float f4 = paramalod2.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramalod2.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramalod2.b;
    }
    for (;;)
    {
      alod localalod = alod.b(f2, f1);
      paramalod1.d += (paramalod2.d - paramalod1.d) * paramFloat;
      paramalod1.c += (paramalod2.c - paramalod1.c) * paramFloat;
      return localalod;
      if (paramalod2.jdField_a_of_type_Int == 1)
      {
        f1 = paramalod1.jdField_a_of_type_Float;
        f2 = (paramalod2.jdField_a_of_type_Float - paramalod1.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramalod1.b + (paramalod2.b - paramalod1.b) * paramFloat;
      }
      else
      {
        f2 = paramalod2.jdField_a_of_type_Float;
        f1 = paramalod2.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aloe
 * JD-Core Version:    0.7.0.1
 */