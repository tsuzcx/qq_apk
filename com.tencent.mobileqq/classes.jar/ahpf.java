import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import java.util.HashMap;

public class ahpf
  implements ahpd
{
  public ahpf(TroopActivity paramTroopActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpf
 * JD-Core Version:    0.7.0.1
 */