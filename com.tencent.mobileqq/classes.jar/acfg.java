import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.dating.MsgBoxListActivity;

public class acfg
  implements Runnable
{
  public acfg(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  public void run()
  {
    if (MsgBoxListActivity.a(this.a) != null) {
      MsgBoxListActivity.a(this.a).b("msglist_carrier_5.8");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acfg
 * JD-Core Version:    0.7.0.1
 */