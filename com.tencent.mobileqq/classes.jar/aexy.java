import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;

class aexy
  implements View.OnClickListener
{
  aexy(aexv paramaexv, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!aexr.a(this.jdField_a_of_type_Aexv.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.jdField_a_of_type_Aexv.a(this.jdField_a_of_type_Int);
      if (localObject != null)
      {
        localObject = bdfk.a(((aexu)localObject).jdField_a_of_type_Int);
        if (!behh.a(aexr.a(this.jdField_a_of_type_Aexv.a), (String)localObject, new aexz(this))) {
          aexv.a(this.jdField_a_of_type_Aexv, this.jdField_a_of_type_Int);
        }
        MobileReportManager.getInstance().reportAction((String)localObject, "4", "platform898", "4", "1", 102, 1, System.currentTimeMillis());
        bdla.b(aexr.a(this.jdField_a_of_type_Aexv.a).app, "dc00898", "", "", "qq_vip", "0X800B15C", Integer.decode((String)localObject).intValue(), 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexy
 * JD-Core Version:    0.7.0.1
 */