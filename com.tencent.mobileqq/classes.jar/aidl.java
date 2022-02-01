import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aidl
  implements View.OnClickListener
{
  aidl(aidd paramaidd) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
    if ((this.a.sessionInfo.curType == 1001) || (this.a.sessionInfo.curType == 10002)) {
      bdla.b(this.a.app, "CliOper", "", "", "0X800514F", "0X800514F", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      bdla.b(this.a.app, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
      aftr.a(this.a.app, this.a.mActivity, this.a.sessionInfo, true, null, this.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.sessionInfo.curType == 1010) {
        bdla.b(this.a.app, "CliOper", "", "", "0X80049C6", "0X80049C6", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidl
 * JD-Core Version:    0.7.0.1
 */