import java.util.HashMap;
import java.util.Observable;

public class aaas
  extends Observable
{
  private static aaas a;
  public int a;
  public HashMap<String, String> a;
  
  public static aaas a()
  {
    if (jdField_a_of_type_Aaas == null) {}
    try
    {
      if (jdField_a_of_type_Aaas == null) {
        jdField_a_of_type_Aaas = new aaas();
      }
      return jdField_a_of_type_Aaas;
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
 * Qualified Name:     aaas
 * JD-Core Version:    0.7.0.1
 */