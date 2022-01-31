import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.List;
import java.util.Map;

public class ajad
  implements Runnable
{
  public ajad(TroopAdminList paramTroopAdminList) {}
  
  public void run()
  {
    int j = this.a.a.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)((Map)this.a.a.get(i)).get("uin");
      ((Map)this.a.a.get(i)).put("nick", ContactUtils.l(this.a.app, str));
      i += 1;
    }
    this.a.runOnUiThread(new ajae(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajad
 * JD-Core Version:    0.7.0.1
 */