import android.support.annotation.IdRes;
import java.util.HashMap;
import java.util.Map;

public class agxp
{
  private static final Map<String, Integer> a;
  public static int[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2130838172, 2130838163, 2130838165, 2130838173, 2130838340, 2130840857, 2130838174, 2130838162, 2130838167, 2130838164, 2130838161, 2130838168, 2130838169, 2130838170, 2130838171 };
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put("m.ke.qq.com", Integer.valueOf(7));
    jdField_a_of_type_JavaUtilMap.put("ke.qq.com", Integer.valueOf(7));
    jdField_a_of_type_JavaUtilMap.put("fudao.qq.com", Integer.valueOf(9));
    jdField_a_of_type_JavaUtilMap.put("buluo.qq.com", Integer.valueOf(10));
    jdField_a_of_type_JavaUtilMap.put("m.gamecenter.qq.com", Integer.valueOf(2));
    jdField_a_of_type_JavaUtilMap.put("imgcache.qq.com", Integer.valueOf(2));
  }
  
  @IdRes
  public static int a(int paramInt)
  {
    return jdField_a_of_type_ArrayOfInt[paramInt];
  }
  
  public static int a(String paramString)
  {
    Integer localInteger2 = (Integer)jdField_a_of_type_JavaUtilMap.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      if (!rtr.d(paramString)) {
        break label37;
      }
    }
    label37:
    for (localInteger1 = Integer.valueOf(8);; localInteger1 = Integer.valueOf(6)) {
      return localInteger1.intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agxp
 * JD-Core Version:    0.7.0.1
 */