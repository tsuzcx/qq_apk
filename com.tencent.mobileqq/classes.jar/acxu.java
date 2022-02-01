import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.qphone.base.util.QLog;

public class acxu
  extends BroadcastReceiver
{
  private acxu(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    if (("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction())) && (paramIntent.hasExtra("state")))
    {
      i = paramIntent.getIntExtra("state", 0);
      if (i != 1) {
        break label43;
      }
      QLog.i("GdtVideoCommonView", 1, "ACTION_HEADSET_PLUG HEADSET on");
    }
    label43:
    do
    {
      do
      {
        return;
      } while (i != 0);
      QLog.i("GdtVideoCommonView", 1, "ACTION_HEADSET_PLUG HEADSET off " + this.a.a);
    } while (!this.a.a);
    GdtVideoCommonView.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxu
 * JD-Core Version:    0.7.0.1
 */