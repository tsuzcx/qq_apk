import com.tencent.mobileqq.activity.TroopTransferActivity;
import java.util.Comparator;

public class acns
  implements Comparator<acnu>
{
  private acns(TroopTransferActivity paramTroopTransferActivity) {}
  
  public int a(acnu paramacnu1, acnu paramacnu2)
  {
    return paramacnu1.f.compareToIgnoreCase(paramacnu2.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acns
 * JD-Core Version:    0.7.0.1
 */