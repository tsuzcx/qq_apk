import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahlb
  implements View.OnClickListener
{
  ahlb(ahkz paramahkz) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
    int i;
    switch (this.a.sessionInfo.curType)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      bcef.b(this.a.app, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(i), "", "", "");
      afcm.a(this.a.app, this.a.mActivity, this.a.sessionInfo, true, null, this.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlb
 * JD-Core Version:    0.7.0.1
 */