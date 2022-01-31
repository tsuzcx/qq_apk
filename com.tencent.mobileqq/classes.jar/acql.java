import android.animation.TypeEvaluator;
import com.tencent.qphone.base.util.QLog;

class acql
  implements TypeEvaluator
{
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdditionalAnimController", 2, "AlphaEvaluator value: " + paramFloat);
    }
    if ((paramFloat >= 0.0F) && (paramFloat <= 0.02985074626865672D)) {
      return Double.valueOf(paramFloat * 0.5D / 0.02985074626865672D);
    }
    if ((paramFloat > 0.02985074626865672D) && (paramFloat <= 0.9253731343283582D)) {
      return Double.valueOf(0.5D);
    }
    if ((paramFloat > 0.9253731343283582D) && (paramFloat <= 1.0F)) {
      return Double.valueOf((1.0F - paramFloat) * 0.5D / 0.07462686567164178D);
    }
    return Double.valueOf(0.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acql
 * JD-Core Version:    0.7.0.1
 */