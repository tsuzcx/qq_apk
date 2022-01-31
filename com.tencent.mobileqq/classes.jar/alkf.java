import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class alkf
{
  public static alkd a(alkg paramalkg, int paramInt)
  {
    if (paramalkg == null) {
      throw new RuntimeException("params can not be null!");
    }
    Object localObject;
    switch (paramalkg.jdField_a_of_type_Int)
    {
    default: 
      localObject = new alki(paramInt);
    }
    for (;;)
    {
      QLog.i("KeyingManager", 1, "getKeying keying: " + localObject + "  params: " + paramalkg.toString());
      return localObject;
      localObject = new aljx(paramInt);
      continue;
      localObject = new alkk(paramInt);
      continue;
      localObject = new alkb(paramInt);
      continue;
      localObject = new alkc(paramInt);
      continue;
      if (TextUtils.isEmpty(paramalkg.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = new aljy(paramInt, paramalkg.jdField_a_of_type_JavaLangString);
    }
    throw new RuntimeException("fragmentShader can not be empty!");
  }
  
  public static alkg a(int paramInt)
  {
    return new alkg(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alkf
 * JD-Core Version:    0.7.0.1
 */