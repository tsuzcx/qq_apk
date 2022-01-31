import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.VideoFlowDecodeWrapper;
import java.util.Comparator;

public class ahao
  implements Comparator
{
  public ahao(VideoFlowDecodeWrapper paramVideoFlowDecodeWrapper) {}
  
  public int a(ahab paramahab1, ahab paramahab2)
  {
    if (paramahab2.b() > paramahab1.b()) {}
    do
    {
      return -1;
      if (paramahab2.b() < paramahab1.b()) {
        return 1;
      }
    } while (paramahab2.a() > paramahab1.a());
    if (paramahab2.a() == paramahab1.a()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahao
 * JD-Core Version:    0.7.0.1
 */