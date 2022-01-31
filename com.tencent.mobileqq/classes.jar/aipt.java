import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;
import java.util.List;

public class aipt
  extends FriendListObserver
{
  public aipt(TroopEntranceBar paramTroopEntranceBar) {}
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (this.a.a != null) && (this.a.a.size() > 0) && (paramString.equals(((TroopInfo)this.a.a.get(0)).troopuin))) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aipt
 * JD-Core Version:    0.7.0.1
 */