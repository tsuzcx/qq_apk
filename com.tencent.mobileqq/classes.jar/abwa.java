import java.util.HashMap;
import java.util.Observable;

public class abwa
  extends Observable
{
  private static abwa a;
  public int a;
  public HashMap<String, String> a;
  
  public static abwa a()
  {
    if (jdField_a_of_type_Abwa == null) {}
    try
    {
      if (jdField_a_of_type_Abwa == null) {
        jdField_a_of_type_Abwa = new abwa();
      }
      return jdField_a_of_type_Abwa;
    }
    finally {}
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("key_type", "t_held_thread");
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    setChanged();
    notifyObservers();
  }
  
  public void a(HashMap<String, String> paramHashMap, int paramInt)
  {
    paramHashMap.put("key_type", "t_drop_frame");
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Int = paramInt;
    setChanged();
    notifyObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abwa
 * JD-Core Version:    0.7.0.1
 */