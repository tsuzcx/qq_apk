import cooperation.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import cooperation.dingdong.data.ScheduleReminderMgr.onScheduleTipsListener;
import cooperation.dingdong.data.ScheduleTipsDialog;

public class alvb
  implements ScheduleReminderMgr.onScheduleTipsListener
{
  public alvb(ScheduleTipsDialog paramScheduleTipsDialog) {}
  
  public void a(DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData)
  {
    ScheduleTipsDialog.a(this.a, paramScheduleSummaryData);
  }
  
  public boolean a()
  {
    if (this.a.isFinishing()) {
      return false;
    }
    return ScheduleTipsDialog.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvb
 * JD-Core Version:    0.7.0.1
 */