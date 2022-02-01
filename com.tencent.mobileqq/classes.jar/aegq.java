import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;

class aegq
  implements View.OnClickListener
{
  aegq(aegn paramaegn, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!aegj.a(this.jdField_a_of_type_Aegn.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.jdField_a_of_type_Aegn.a(this.jdField_a_of_type_Int);
      if (localObject != null)
      {
        localObject = bbyp.a(((aegm)localObject).jdField_a_of_type_Int);
        if (!bdai.a(aegj.a(this.jdField_a_of_type_Aegn.a), (String)localObject, new aegr(this))) {
          aegn.a(this.jdField_a_of_type_Aegn, this.jdField_a_of_type_Int);
        }
        MobileReportManager.getInstance().reportAction((String)localObject, "4", "platform898", "4", "1", 102, 1, System.currentTimeMillis());
        bcef.b(aegj.a(this.jdField_a_of_type_Aegn.a).app, "dc00898", "", "", "qq_vip", "0X800B15C", Integer.decode((String)localObject).intValue(), 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegq
 * JD-Core Version:    0.7.0.1
 */