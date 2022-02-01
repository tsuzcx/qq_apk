import java.util.HashMap;
import java.util.Observable;

public class acji
  extends Observable
{
  private static acji a;
  public HashMap<String, String> a;
  
  public static acji a()
  {
    if (jdField_a_of_type_Acji == null) {}
    try
    {
      if (jdField_a_of_type_Acji == null) {
        jdField_a_of_type_Acji = new acji();
      }
      return jdField_a_of_type_Acji;
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
 * Qualified Name:     acji
 * JD-Core Version:    0.7.0.1
 */