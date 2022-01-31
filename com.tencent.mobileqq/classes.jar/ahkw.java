import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;

class ahkw
  implements View.OnClickListener
{
  ahkw(ahkd paramahkd) {}
  
  public void onClick(View paramView)
  {
    paramView = QQPlayerService.a();
    int i;
    if (paramView != null)
    {
      ahkd.a(this.a).startActivity(paramView);
      paramView = paramView.getComponent().getClassName();
      if (!paramView.equals(MusicPlayerActivity.class.getName())) {
        break label125;
      }
      i = 0;
    }
    for (;;)
    {
      axqy.a(ahkd.a(this.a).app, "dc00898", "", "", "0X8009EE4", "0X8009EE4", 1, 0, "", "", "", "");
      axqy.b(ahkd.a(this.a).app, "CliOper", "", "", "Msg_tab", "Mt_music_tips", 0, 0, "" + i, "", "", "");
      return;
      label125:
      if (paramView.equals(MusicGeneQQBrowserActivity.class.getName())) {
        i = 1;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahkw
 * JD-Core Version:    0.7.0.1
 */