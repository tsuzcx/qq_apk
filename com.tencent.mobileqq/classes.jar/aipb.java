import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;

class aipb
  extends BroadcastReceiver
{
  aipb(ainh paramainh) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = HwNetworkUtil.isNetworkAvailable(this.a.a);
    if ((bool) && (ainh.d(this.a)))
    {
      nqw.a.a();
      ainh.c(this.a, false);
    }
    while (bool) {
      return;
    }
    nqw.a.a(this.a.c());
    ainh.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipb
 * JD-Core Version:    0.7.0.1
 */