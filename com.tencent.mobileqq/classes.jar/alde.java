import android.support.annotation.IdRes;
import java.util.HashMap;
import java.util.Map;

public class alde
{
  private static final Map<String, Integer> a;
  public static int[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2130838402, 2130838392, 2130838394, 2130838403, 2130838568, 2130841342, 2130838404, 2130838391, 2130838396, 2130838393, 2130838390, 2130838397, 2130838398, 2130838400, 2130838401 };
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
      if (!uuc.d(paramString)) {
        break label37;
      }
    }
    label37:
    for (localInteger1 = Integer.valueOf(8);; localInteger1 = Integer.valueOf(6)) {
      return localInteger1.intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alde
 * JD-Core Version:    0.7.0.1
 */