import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;

public class acwr
  extends BroadcastReceiver
{
  public acwr(FavEmosmManageActivity paramFavEmosmManageActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (FavEmosmManageActivity.a(this.a) != null) {
      FavEmosmManageActivity.a(this.a).a(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwr
 * JD-Core Version:    0.7.0.1
 */