import java.util.HashMap;
import java.util.Observable;

public class admp
  extends Observable
{
  private static admp a;
  public HashMap<String, String> a;
  
  public static admp a()
  {
    if (jdField_a_of_type_Admp == null) {}
    try
    {
      if (jdField_a_of_type_Admp == null) {
        jdField_a_of_type_Admp = new admp();
      }
      return jdField_a_of_type_Admp;
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
 * Qualified Name:     admp
 * JD-Core Version:    0.7.0.1
 */