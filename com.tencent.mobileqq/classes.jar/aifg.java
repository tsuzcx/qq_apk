import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.LyricItem;
import java.util.Comparator;

public class aifg
  implements Comparator
{
  public aifg(ResourceManager paramResourceManager) {}
  
  public int a(ResourceManager.LyricItem paramLyricItem1, ResourceManager.LyricItem paramLyricItem2)
  {
    if (paramLyricItem1.b < paramLyricItem2.b) {
      return -1;
    }
    if (paramLyricItem1.b > paramLyricItem2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aifg
 * JD-Core Version:    0.7.0.1
 */