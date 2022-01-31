import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.VideoFlowDecodeWrapper;
import java.util.Comparator;

public class ahti
  implements Comparator
{
  public ahti(VideoFlowDecodeWrapper paramVideoFlowDecodeWrapper) {}
  
  public int a(ahsv paramahsv1, ahsv paramahsv2)
  {
    if (paramahsv2.b() > paramahsv1.b()) {}
    do
    {
      return -1;
      if (paramahsv2.b() < paramahsv1.b()) {
        return 1;
      }
    } while (paramahsv2.a() > paramahsv1.a());
    if (paramahsv2.a() == paramahsv1.a()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahti
 * JD-Core Version:    0.7.0.1
 */