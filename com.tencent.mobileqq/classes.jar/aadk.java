import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aadk
  implements View.OnClickListener
{
  aadk(aadj paramaadj) {}
  
  public void onClick(View paramView)
  {
    if ((!aauy.a("SUB_ENTER_FLOAT_MODE")) && (aadj.a(this.a) != null)) {
      aadj.a(this.a).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadk
 * JD-Core Version:    0.7.0.1
 */