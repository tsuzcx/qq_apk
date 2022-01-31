import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.transfile.dns.InnerDns;

public class aiec
  extends BroadcastReceiver
{
  public aiec(InnerDns paramInnerDns) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.innerdns.domainAddressDataUpdateAction".equals(paramIntent.getAction())) {
      InnerDns.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiec
 * JD-Core Version:    0.7.0.1
 */