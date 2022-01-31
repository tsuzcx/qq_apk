import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class absr
  implements View.OnClickListener
{
  absr(absp paramabsp, abso paramabso, absg paramabsg, JSONObject paramJSONObject, absf paramabsf) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Absp.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "accept " + this.jdField_a_of_type_Abso.a);
    absp.a(this.jdField_a_of_type_Absp, this.jdField_a_of_type_Abso, 2);
    absp.a(this.jdField_a_of_type_Absp, 0, this.jdField_a_of_type_Absg, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Absf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     absr
 * JD-Core Version:    0.7.0.1
 */