import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class adnl
  implements View.OnClickListener
{
  adnl(adni paramadni, adnh paramadnh, admz paramadmz, JSONObject paramJSONObject, admy paramadmy) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Adni.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "reject " + this.jdField_a_of_type_Adnh.a);
    adni.a(this.jdField_a_of_type_Adni, this.jdField_a_of_type_Adnh, 1);
    adni.b(this.jdField_a_of_type_Adni, 4, this.jdField_a_of_type_Admz, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Admy);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adnl
 * JD-Core Version:    0.7.0.1
 */