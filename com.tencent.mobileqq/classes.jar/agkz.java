import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.qphone.base.util.QLog;

public class agkz
  extends BroadcastReceiver
{
  public agkz(AlbumListActivity paramAlbumListActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!this.a.isFinishing())
    {
      this.a.finish();
      QLog.i("AlbumListActivity", 1, "AlbumListActivity has finished by broadcastReceiver.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agkz
 * JD-Core Version:    0.7.0.1
 */