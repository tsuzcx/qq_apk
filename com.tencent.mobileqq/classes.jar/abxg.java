import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class abxg
  implements View.OnClickListener
{
  abxg(abxe paramabxe, abxd paramabxd, abwv paramabwv, JSONObject paramJSONObject, abwu paramabwu) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Abxe.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "accept " + this.jdField_a_of_type_Abxd.a);
    abxe.a(this.jdField_a_of_type_Abxe, this.jdField_a_of_type_Abxd, 2);
    abxe.a(this.jdField_a_of_type_Abxe, 0, this.jdField_a_of_type_Abwv, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Abwu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxg
 * JD-Core Version:    0.7.0.1
 */