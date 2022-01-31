import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;

public class ahub
  implements View.OnClickListener
{
  public ahub(StructMsgForHypertext paramStructMsgForHypertext) {}
  
  public void onClick(View paramView)
  {
    new StructMsgClickHandler(null, paramView, this.a.message).a("web", this.a.mSourceUrl, null, null);
    ReportController.b(null, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, this.a.mMsgServiceID + "", "", "", "");
    ReportController.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahub
 * JD-Core Version:    0.7.0.1
 */