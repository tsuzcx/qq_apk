import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;

public class ahsq
  implements View.OnClickListener
{
  public ahsq(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onClick(View paramView)
  {
    if (EditLocalVideoActivity.a(this.a).isPlaying())
    {
      EditLocalVideoActivity.b(this.a, false);
      EditLocalVideoActivity.a(this.a).pause();
      EditLocalVideoActivity.a(this.a).setVisibility(0);
      return;
    }
    EditLocalVideoActivity.b(this.a, true);
    EditLocalVideoActivity.b(this.a).setVisibility(8);
    EditLocalVideoActivity.a(this.a).start();
    EditLocalVideoActivity.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahsq
 * JD-Core Version:    0.7.0.1
 */