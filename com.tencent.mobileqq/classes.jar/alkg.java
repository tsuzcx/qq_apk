import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class alkg
{
  public static alke a(alkh paramalkh, int paramInt)
  {
    if (paramalkh == null) {
      throw new RuntimeException("params can not be null!");
    }
    Object localObject;
    switch (paramalkh.jdField_a_of_type_Int)
    {
    default: 
      localObject = new alkj(paramInt);
    }
    for (;;)
    {
      QLog.i("KeyingManager", 1, "getKeying keying: " + localObject + "  params: " + paramalkh.toString());
      return localObject;
      localObject = new aljy(paramInt);
      continue;
      localObject = new alkl(paramInt);
      continue;
      localObject = new alkc(paramInt);
      continue;
      localObject = new alkd(paramInt);
      continue;
      if (TextUtils.isEmpty(paramalkh.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = new aljz(paramInt, paramalkh.jdField_a_of_type_JavaLangString);
    }
    throw new RuntimeException("fragmentShader can not be empty!");
  }
  
  public static alkh a(int paramInt)
  {
    return new alkh(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alkg
 * JD-Core Version:    0.7.0.1
 */