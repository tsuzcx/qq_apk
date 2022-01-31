import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;

public class aiie
  extends BroadcastReceiver
{
  public aiie(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getAction().equals("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete"))) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiie
 * JD-Core Version:    0.7.0.1
 */