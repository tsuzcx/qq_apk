import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class abxh
  implements View.OnClickListener
{
  abxh(abxe paramabxe, abxd paramabxd, abwv paramabwv, JSONObject paramJSONObject, abwu paramabwu) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Abxe.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "reject " + this.jdField_a_of_type_Abxd.a);
    abxe.a(this.jdField_a_of_type_Abxe, this.jdField_a_of_type_Abxd, 1);
    abxe.b(this.jdField_a_of_type_Abxe, 4, this.jdField_a_of_type_Abwv, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Abwu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxh
 * JD-Core Version:    0.7.0.1
 */