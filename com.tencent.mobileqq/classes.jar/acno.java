import com.tencent.mobileqq.activity.TroopTransferActivity;
import java.util.Comparator;

public class acno
  implements Comparator<acnq>
{
  private acno(TroopTransferActivity paramTroopTransferActivity) {}
  
  public int a(acnq paramacnq1, acnq paramacnq2)
  {
    return paramacnq1.f.compareToIgnoreCase(paramacnq2.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acno
 * JD-Core Version:    0.7.0.1
 */