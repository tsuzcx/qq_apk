import com.tencent.mobileqq.text.QzoneTextBuilder;
import java.util.Comparator;

public class ahzr
  implements Comparator
{
  public ahzr(QzoneTextBuilder paramQzoneTextBuilder) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    int i = this.a.getSpanStart(paramObject1);
    int j = this.a.getSpanStart(paramObject2);
    if (i == j) {
      return 0;
    }
    if (i > j) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahzr
 * JD-Core Version:    0.7.0.1
 */