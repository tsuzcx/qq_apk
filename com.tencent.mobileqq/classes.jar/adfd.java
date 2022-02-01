import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class adfd
  extends niv
{
  adfd(adfb paramadfb, adfn paramadfn, JSONObject paramJSONObject, adea paramadea) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(adfb.a, 2, "onResult appid=" + adfb.b(this.jdField_a_of_type_Adfb).a + ", openid=" + this.jdField_a_of_type_Adfn.a + ", openkey=" + this.jdField_a_of_type_Adfn.b + ", code=" + paramInt + ", req param=" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      adhh.a(this.jdField_a_of_type_Adea, paramInt, "reportScore result error, try again");
      return;
    }
    adhh.a(this.jdField_a_of_type_Adea, adec.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfd
 * JD-Core Version:    0.7.0.1
 */