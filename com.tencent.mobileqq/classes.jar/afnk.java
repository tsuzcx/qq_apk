import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import java.util.HashMap;

public class afnk
  implements afni
{
  public afnk(TroopActivity paramTroopActivity) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((this.a.a.containsKey(paramString)) && (((Boolean)this.a.a.get(paramString)).booleanValue() != paramBoolean))
    {
      this.a.a.remove(paramString);
      return;
    }
    this.a.a.put(paramString, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afnk
 * JD-Core Version:    0.7.0.1
 */