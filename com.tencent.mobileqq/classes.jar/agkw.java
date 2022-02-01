import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agkw
  implements View.OnClickListener
{
  agkw(agkt paramagkt) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    bhbu.a("Grp_AIO", "AIO_clk", "game_tips_clk_off", 0, 0, new String[] { this.a.b });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkw
 * JD-Core Version:    0.7.0.1
 */