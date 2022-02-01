import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aloi
  implements View.OnClickListener
{
  public aloi(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onClick(View paramView)
  {
    if (EditLocalVideoActivity.a(this.a).isPlaying())
    {
      EditLocalVideoActivity.b(this.a, false);
      EditLocalVideoActivity.a(this.a).pause();
      EditLocalVideoActivity.a(this.a).setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      EditLocalVideoActivity.b(this.a, true);
      EditLocalVideoActivity.b(this.a).setVisibility(8);
      EditLocalVideoActivity.a(this.a).start();
      EditLocalVideoActivity.a(this.a).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aloi
 * JD-Core Version:    0.7.0.1
 */