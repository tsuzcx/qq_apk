import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class akvu
{
  public static akvs a(akvv paramakvv, int paramInt)
  {
    if (paramakvv == null) {
      throw new RuntimeException("params can not be null!");
    }
    Object localObject;
    switch (paramakvv.jdField_a_of_type_Int)
    {
    default: 
      localObject = new akvx(paramInt);
    }
    for (;;)
    {
      QLog.i("KeyingManager", 1, "getKeying keying: " + localObject + "  params: " + paramakvv.toString());
      return localObject;
      localObject = new akvm(paramInt);
      continue;
      localObject = new akvz(paramInt);
      continue;
      localObject = new akvq(paramInt);
      continue;
      localObject = new akvr(paramInt);
      continue;
      if (TextUtils.isEmpty(paramakvv.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = new akvn(paramInt, paramakvv.jdField_a_of_type_JavaLangString);
    }
    throw new RuntimeException("fragmentShader can not be empty!");
  }
  
  public static akvv a(int paramInt)
  {
    return new akvv(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akvu
 * JD-Core Version:    0.7.0.1
 */