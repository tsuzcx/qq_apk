import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class aacp
  extends mxm
{
  aacp(aacn paramaacn, aacz paramaacz, JSONObject paramJSONObject, aabm paramaabm) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(aacn.a, 2, "onResult appid=" + aacn.b(this.jdField_a_of_type_Aacn).a + ", openid=" + this.jdField_a_of_type_Aacz.a + ", openkey=" + this.jdField_a_of_type_Aacz.b + ", code=" + paramInt + ", req param=" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      aaet.a(this.jdField_a_of_type_Aabm, paramInt, "reportScore result error, try again");
      return;
    }
    aaet.a(this.jdField_a_of_type_Aabm, aabo.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacp
 * JD-Core Version:    0.7.0.1
 */