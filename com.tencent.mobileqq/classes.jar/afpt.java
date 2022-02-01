import com.tencent.mobileqq.activity.TroopTransferActivity;
import java.util.Comparator;

public class afpt
  implements Comparator<afpv>
{
  private afpt(TroopTransferActivity paramTroopTransferActivity) {}
  
  public int a(afpv paramafpv1, afpv paramafpv2)
  {
    return paramafpv1.f.compareToIgnoreCase(paramafpv2.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpt
 * JD-Core Version:    0.7.0.1
 */