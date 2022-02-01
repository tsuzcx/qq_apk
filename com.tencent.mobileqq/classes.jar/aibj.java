import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

class aibj
  extends BroadcastReceiver
{
  aibj(aiav paramaiav) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.a != null) {
      this.a.a.a(paramContext);
    }
    this.a.mActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibj
 * JD-Core Version:    0.7.0.1
 */