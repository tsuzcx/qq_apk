import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class acke
  implements View.OnClickListener
{
  acke(ackb paramackb, acka paramacka, acjs paramacjs, JSONObject paramJSONObject, acjr paramacjr) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Ackb.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "reject " + this.jdField_a_of_type_Acka.a);
    ackb.a(this.jdField_a_of_type_Ackb, this.jdField_a_of_type_Acka, 1);
    ackb.b(this.jdField_a_of_type_Ackb, 4, this.jdField_a_of_type_Acjs, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Acjr);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acke
 * JD-Core Version:    0.7.0.1
 */