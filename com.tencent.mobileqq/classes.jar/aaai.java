import java.util.HashMap;
import java.util.Observable;

public class aaai
  extends Observable
{
  private static aaai a;
  public HashMap<String, String> a;
  
  public static aaai a()
  {
    if (jdField_a_of_type_Aaai == null) {}
    try
    {
      if (jdField_a_of_type_Aaai == null) {
        jdField_a_of_type_Aaai = new aaai();
      }
      return jdField_a_of_type_Aaai;
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
 * Qualified Name:     aaai
 * JD-Core Version:    0.7.0.1
 */