import java.util.Comparator;
import java.util.Map.Entry;

class aljp
  implements Comparator<Map.Entry<String, Long>>
{
  aljp(aljo paramaljo) {}
  
  public int a(Map.Entry<String, Long> paramEntry1, Map.Entry<String, Long> paramEntry2)
  {
    return ((Long)paramEntry2.getValue()).compareTo((Long)paramEntry1.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aljp
 * JD-Core Version:    0.7.0.1
 */