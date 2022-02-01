import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akyi
  implements View.OnClickListener
{
  public akyi(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.b.setVisibility(8);
    this.a.a.setVisibility(8);
    RedPacketKSongFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyi
 * JD-Core Version:    0.7.0.1
 */