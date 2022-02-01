import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahjc
  implements View.OnClickListener
{
  ahjc(ahiu paramahiu) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      bcef.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8004EFC", "0X8004EFC", 0, 0, "", "", "" + this.a.a.msgId, "");
    }
    this.a.openOptionActivity();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjc
 * JD-Core Version:    0.7.0.1
 */