import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class adan
  implements View.OnClickListener
{
  adan(adak paramadak, adaj paramadaj, adab paramadab, JSONObject paramJSONObject, adaa paramadaa) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Adak.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "reject " + this.jdField_a_of_type_Adaj.a);
    adak.a(this.jdField_a_of_type_Adak, this.jdField_a_of_type_Adaj, 1);
    adak.b(this.jdField_a_of_type_Adak, 4, this.jdField_a_of_type_Adab, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Adaa);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adan
 * JD-Core Version:    0.7.0.1
 */