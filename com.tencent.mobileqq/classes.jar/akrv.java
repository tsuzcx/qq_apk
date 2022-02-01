import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akrv
  implements View.OnClickListener
{
  public akrv(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrv
 * JD-Core Version:    0.7.0.1
 */