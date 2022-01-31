import java.util.HashMap;
import java.util.Observable;

public class abrf
  extends Observable
{
  private static abrf a;
  public HashMap<String, String> a;
  
  public static abrf a()
  {
    if (jdField_a_of_type_Abrf == null) {}
    try
    {
      if (jdField_a_of_type_Abrf == null) {
        jdField_a_of_type_Abrf = new abrf();
      }
      return jdField_a_of_type_Abrf;
    }
    finally {}
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    setChanged();
    notifyObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abrf
 * JD-Core Version:    0.7.0.1
 */