import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agap
  implements View.OnClickListener
{
  agap(agab paramagab) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.tag, 2, "mQimStatusOnClickListener.onClick: invoked. info: v = " + paramView);
    }
    this.a.app.reportClickEvent("CliOper", "0X80087E6");
    ahwv.a().a(this.a.app, this.a.mContext);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agap
 * JD-Core Version:    0.7.0.1
 */