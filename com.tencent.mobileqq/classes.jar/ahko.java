import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;

class ahko
  extends BroadcastReceiver
{
  ahko(ahiu paramahiu) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = HwNetworkUtil.isNetworkAvailable(this.a.mContext);
    if ((bool) && (ahiu.d(this.a)))
    {
      nsf.a.a();
      ahiu.c(this.a, false);
    }
    while (bool) {
      return;
    }
    nsf.a.a(this.a.getCurTroopUin());
    ahiu.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahko
 * JD-Core Version:    0.7.0.1
 */