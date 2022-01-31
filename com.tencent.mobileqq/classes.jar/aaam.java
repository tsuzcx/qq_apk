import java.util.HashMap;
import java.util.Observable;

public class aaam
  extends Observable
{
  private static aaam a;
  public HashMap<String, String> a;
  
  public static aaam a()
  {
    if (jdField_a_of_type_Aaam == null) {}
    try
    {
      if (jdField_a_of_type_Aaam == null) {
        jdField_a_of_type_Aaam = new aaam();
      }
      return jdField_a_of_type_Aaam;
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
 * Qualified Name:     aaam
 * JD-Core Version:    0.7.0.1
 */