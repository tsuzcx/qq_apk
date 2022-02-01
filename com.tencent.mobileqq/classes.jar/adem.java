import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class adem
  implements View.OnClickListener
{
  adem(adek paramadek, adej paramadej, adeb paramadeb, JSONObject paramJSONObject, adea paramadea) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Adek.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "accept " + this.jdField_a_of_type_Adej.a);
    adek.a(this.jdField_a_of_type_Adek, this.jdField_a_of_type_Adej, 2);
    adek.a(this.jdField_a_of_type_Adek, 0, this.jdField_a_of_type_Adeb, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Adea);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adem
 * JD-Core Version:    0.7.0.1
 */