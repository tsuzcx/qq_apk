import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopAdminList.AdminListAdapter;

public class aivc
  implements Runnable
{
  public aivc(TroopAdminList paramTroopAdminList) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivc
 * JD-Core Version:    0.7.0.1
 */