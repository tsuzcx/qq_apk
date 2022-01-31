import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class abti
  extends nac
{
  abti(abtg paramabtg, abts paramabts, JSONObject paramJSONObject, absf paramabsf) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(abtg.a, 2, "onResult appid=" + abtg.b(this.jdField_a_of_type_Abtg).a + ", openid=" + this.jdField_a_of_type_Abts.a + ", openkey=" + this.jdField_a_of_type_Abts.b + ", code=" + paramInt + ", req param=" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      abvm.a(this.jdField_a_of_type_Absf, paramInt, "reportScore result error, try again");
      return;
    }
    abvm.a(this.jdField_a_of_type_Absf, absh.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abti
 * JD-Core Version:    0.7.0.1
 */