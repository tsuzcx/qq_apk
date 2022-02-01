import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class ackd
  implements View.OnClickListener
{
  ackd(ackb paramackb, acka paramacka, acjs paramacjs, JSONObject paramJSONObject, acjr paramacjr) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Ackb.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "accept " + this.jdField_a_of_type_Acka.a);
    ackb.a(this.jdField_a_of_type_Ackb, this.jdField_a_of_type_Acka, 2);
    ackb.a(this.jdField_a_of_type_Ackb, 0, this.jdField_a_of_type_Acjs, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Acjr);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackd
 * JD-Core Version:    0.7.0.1
 */