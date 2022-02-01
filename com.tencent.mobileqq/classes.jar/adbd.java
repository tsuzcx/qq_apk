import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class adbd
  extends ntf
{
  adbd(adbb paramadbb, adbn paramadbn, JSONObject paramJSONObject, adaa paramadaa) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(adbb.a, 2, "onResult appid=" + adbb.b(this.jdField_a_of_type_Adbb).a + ", openid=" + this.jdField_a_of_type_Adbn.a + ", openkey=" + this.jdField_a_of_type_Adbn.b + ", code=" + paramInt + ", req param=" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      addh.a(this.jdField_a_of_type_Adaa, paramInt, "reportScore result error, try again");
      return;
    }
    addh.a(this.jdField_a_of_type_Adaa, adac.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbd
 * JD-Core Version:    0.7.0.1
 */