import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alec
  implements View.OnClickListener
{
  alec(aldh paramaldh) {}
  
  public void onClick(View paramView)
  {
    Object localObject = QQPlayerService.a();
    int i;
    if (localObject != null)
    {
      aldh.a(this.a).startActivity((Intent)localObject);
      localObject = ((Intent)localObject).getComponent().getClassName();
      if (!((String)localObject).equals(MusicPlayerActivity.class.getName())) {
        break label132;
      }
      i = 0;
    }
    for (;;)
    {
      bdla.a(aldh.a(this.a).app, "dc00898", "", "", "0X8009EE4", "0X8009EE4", 1, 0, "", "", "", "");
      bdla.b(aldh.a(this.a).app, "CliOper", "", "", "Msg_tab", "Mt_music_tips", 0, 0, "" + i, "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label132:
      if (((String)localObject).equals(MusicGeneQQBrowserActivity.class.getName())) {
        i = 1;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alec
 * JD-Core Version:    0.7.0.1
 */