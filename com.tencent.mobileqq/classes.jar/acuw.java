import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;

class acuw
  extends BroadcastReceiver
{
  acuw(acuv paramacuv) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equalsIgnoreCase("com.opensdk.downloadmanager.renameFilename")))
    {
      paramContext = paramIntent.getBundleExtra("extraBundle");
      FileManagerDataCenter.a(this.a.a, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acuw
 * JD-Core Version:    0.7.0.1
 */