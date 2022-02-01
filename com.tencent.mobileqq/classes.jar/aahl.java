import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aahl
  implements View.OnClickListener
{
  aahl(aahk paramaahk) {}
  
  public void onClick(View paramView)
  {
    if ((!aazb.a("SUB_ENTER_FLOAT_MODE")) && (aahk.a(this.a) != null)) {
      aahk.a(this.a).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahl
 * JD-Core Version:    0.7.0.1
 */