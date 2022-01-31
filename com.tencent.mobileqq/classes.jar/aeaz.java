import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class aeaz
  implements Runnable
{
  public aeaz(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void run()
  {
    Object localObject2 = (TicketManager)this.a.app.getManager(2);
    Object localObject1 = this.a.app.getCurrentAccountUin();
    String str = ((TicketManager)localObject2).getSkey(this.a.app.getCurrentAccountUin());
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("bkn", "" + TroopUtils.b(str));
    ((Bundle)localObject2).putString("ver", "7.6.0");
    ((Bundle)localObject2).putString("src", "1");
    ((Bundle)localObject2).putString("platform", "android");
    ((Bundle)localObject2).putString("uin", this.a.app.getCurrentAccountUin());
    ((Bundle)localObject2).putString("count", "8");
    ((Bundle)localObject2).putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + str);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", localObject2);
    this.a.app.getApplication();
    ((HashMap)localObject1).put("CONTEXT", MobileQQ.getContext());
    new HttpWebCgiAsyncTask("http://nearby.qq.com/cgi-bin/werewolf/get_friend_board_list", "GET", this.a.a, 0, null, true).execute(new HashMap[] { localObject1 });
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomInviteActivity", 2, "get feed from server start: " + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeaz
 * JD-Core Version:    0.7.0.1
 */