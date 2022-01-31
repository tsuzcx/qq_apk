import android.content.SharedPreferences;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.NearbyRecommenderUtils;
import java.util.List;

public class abxe
  implements Runnable
{
  public abxe(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  public void run()
  {
    if (MsgBoxListActivity.a(this.a) != null)
    {
      MsgBoxListActivity.a(this.a).a("msglist_carrier_5.8");
      this.a.a = MsgBoxListActivity.a(this.a).a();
      this.a.runOnUiThread(new abxf(this));
      long l = this.a.app.getPreferences().getLong("sp_key_dating_config_time", 0L);
      Object localObject;
      if (Math.abs(System.currentTimeMillis() - l) > 180000L)
      {
        localObject = (LBSHandler)this.a.app.a(3);
        if (localObject != null) {
          ((LBSHandler)localObject).a(null);
        }
      }
      if (NearbyRecommenderUtils.b(this.a.app))
      {
        localObject = NearbyRecommenderUtils.a(this.a.app, this.a.app.getCurrentAccountUin());
        this.a.runOnUiThread(new abxg(this, (List)localObject));
        if (NearbyRecommenderUtils.a(this.a.app, 1))
        {
          localObject = (LBSHandler)this.a.app.a(3);
          if (localObject != null) {
            ((LBSHandler)localObject).a(1);
          }
        }
        NearbyRecommenderUtils.b(this.a.app);
      }
    }
    else
    {
      return;
    }
    this.a.runOnUiThread(new abxh(this));
    this.a.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abxe
 * JD-Core Version:    0.7.0.1
 */