import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.transfile.dns.InnerDns;

public class aisf
  extends BroadcastReceiver
{
  public aisf(InnerDns paramInnerDns) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.innerdns.domainAddressDataUpdateAction".equals(paramIntent.getAction())) {
      InnerDns.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisf
 * JD-Core Version:    0.7.0.1
 */