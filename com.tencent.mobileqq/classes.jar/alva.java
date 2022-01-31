import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.data.ScheduleReminderMgr;
import cooperation.dingdong.data.ScheduleTipsDialog;

public class alva
  extends AsyncTask
{
  public alva(ScheduleReminderMgr paramScheduleReminderMgr, DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    return Boolean.valueOf(DingdongPluginHelper.b(ScheduleReminderMgr.a(this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr).getApp().getApplicationContext()));
  }
  
  protected void a(Boolean paramBoolean)
  {
    Intent localIntent = new Intent(ScheduleReminderMgr.a(this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr).getApp().getApplicationContext(), ScheduleTipsDialog.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("isforeground", paramBoolean);
    localIntent.putExtra("summaryinfo", this.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData);
    ScheduleReminderMgr.a(this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr).getApp().getApplicationContext().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alva
 * JD-Core Version:    0.7.0.1
 */