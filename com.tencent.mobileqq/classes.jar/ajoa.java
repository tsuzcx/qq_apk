import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ajoa
  extends ThreadLocal
{
  public ajoa(TroopAppMgr paramTroopAppMgr) {}
  
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoa
 * JD-Core Version:    0.7.0.1
 */