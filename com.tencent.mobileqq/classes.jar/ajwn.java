import java.util.Comparator;
import java.util.Map.Entry;

class ajwn
  implements Comparator<Map.Entry<String, atmo>>
{
  ajwn(ajwm paramajwm) {}
  
  public int a(Map.Entry<String, atmo> paramEntry1, Map.Entry<String, atmo> paramEntry2)
  {
    paramEntry1 = ((String)paramEntry1.getKey()).split("&")[1];
    int i = Integer.parseInt(paramEntry1.split("-")[0]);
    int j = Integer.parseInt(paramEntry1.split("-")[1]);
    paramEntry1 = ((String)paramEntry2.getKey()).split("&")[1];
    int k = Integer.parseInt(paramEntry1.split("-")[0]);
    int m = Integer.parseInt(paramEntry1.split("-")[1]);
    if (i > k) {
      return 1;
    }
    if (i == k) {
      return j - m;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajwn
 * JD-Core Version:    0.7.0.1
 */