import java.util.HashMap;
import java.util.Observable;

public class abvu
  extends Observable
{
  private static abvu a;
  public HashMap<String, String> a;
  
  public static abvu a()
  {
    if (jdField_a_of_type_Abvu == null) {}
    try
    {
      if (jdField_a_of_type_Abvu == null) {
        jdField_a_of_type_Abvu = new abvu();
      }
      return jdField_a_of_type_Abvu;
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
 * Qualified Name:     abvu
 * JD-Core Version:    0.7.0.1
 */