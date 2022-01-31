import java.util.HashMap;
import java.util.Observable;

public class aaao
  extends Observable
{
  private static aaao a;
  public int a;
  public HashMap<String, String> a;
  
  public static aaao a()
  {
    if (jdField_a_of_type_Aaao == null) {}
    try
    {
      if (jdField_a_of_type_Aaao == null) {
        jdField_a_of_type_Aaao = new aaao();
      }
      return jdField_a_of_type_Aaao;
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
 * Qualified Name:     aaao
 * JD-Core Version:    0.7.0.1
 */