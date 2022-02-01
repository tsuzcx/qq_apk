import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahyo
  implements View.OnClickListener
{
  ahyo(ahyl paramahyl) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
    this.a.a.setVisibility(8);
    this.a.mInputBar.setVisibility(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyo
 * JD-Core Version:    0.7.0.1
 */