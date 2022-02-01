import java.util.HashMap;
import java.util.Observable;

public class addr
  extends Observable
{
  private static addr a;
  public HashMap<String, String> a;
  
  public static addr a()
  {
    if (jdField_a_of_type_Addr == null) {}
    try
    {
      if (jdField_a_of_type_Addr == null) {
        jdField_a_of_type_Addr = new addr();
      }
      return jdField_a_of_type_Addr;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     addr
 * JD-Core Version:    0.7.0.1
 */