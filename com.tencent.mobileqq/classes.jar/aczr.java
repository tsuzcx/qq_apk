import java.util.HashMap;
import java.util.Observable;

public class aczr
  extends Observable
{
  private static aczr a;
  public HashMap<String, String> a;
  
  public static aczr a()
  {
    if (jdField_a_of_type_Aczr == null) {}
    try
    {
      if (jdField_a_of_type_Aczr == null) {
        jdField_a_of_type_Aczr = new aczr();
      }
      return jdField_a_of_type_Aczr;
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
 * Qualified Name:     aczr
 * JD-Core Version:    0.7.0.1
 */