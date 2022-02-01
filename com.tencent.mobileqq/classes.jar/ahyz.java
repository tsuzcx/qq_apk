import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahyz
  implements View.OnClickListener
{
  ahyz(ahyl paramahyl) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
    bdla.b(this.a.app, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
    aftr.a(this.a.app, this.a.mActivity, this.a.sessionInfo, true, null, this.a);
    bdla.b(this.a.app, "dc00899", "Qidian", "", "0X8008FEB", "qidianMasterVideo", 1, 1, 0, "2", "0", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyz
 * JD-Core Version:    0.7.0.1
 */