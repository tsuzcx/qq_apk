import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class aden
  implements View.OnClickListener
{
  aden(adek paramadek, adej paramadej, adeb paramadeb, JSONObject paramJSONObject, adea paramadea) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Adek.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "reject " + this.jdField_a_of_type_Adej.a);
    adek.a(this.jdField_a_of_type_Adek, this.jdField_a_of_type_Adej, 1);
    adek.b(this.jdField_a_of_type_Adek, 4, this.jdField_a_of_type_Adeb, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Adea);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aden
 * JD-Core Version:    0.7.0.1
 */