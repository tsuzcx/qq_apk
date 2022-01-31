import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class afqc
  extends BroadcastReceiver
{
  afqc(afqb paramafqb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (afqb.a(this.a) != null) {
      ((bftc)afqb.a(this.a)).updatePublishBox(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqc
 * JD-Core Version:    0.7.0.1
 */