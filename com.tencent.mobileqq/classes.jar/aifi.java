import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;

class aifi
  extends BroadcastReceiver
{
  aifi(aido paramaido) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = HwNetworkUtil.isNetworkAvailable(this.a.mContext);
    if ((bool) && (aido.e(this.a)))
    {
      nzg.a.a();
      aido.c(this.a, false);
    }
    while (bool) {
      return;
    }
    nzg.a.a(this.a.getCurTroopUin());
    aido.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifi
 * JD-Core Version:    0.7.0.1
 */