import com.tencent.mobileqq.lyric.data.Sentence;
import java.util.Comparator;

public class aelc
  implements Comparator
{
  public int a(Sentence paramSentence1, Sentence paramSentence2)
  {
    if (paramSentence1.a >= paramSentence2.a) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aelc
 * JD-Core Version:    0.7.0.1
 */