import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class aacl
  extends mxj
{
  aacl(aacj paramaacj, aacv paramaacv, JSONObject paramJSONObject, aabi paramaabi) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(aacj.a, 2, "onResult appid=" + aacj.b(this.jdField_a_of_type_Aacj).a + ", openid=" + this.jdField_a_of_type_Aacv.a + ", openkey=" + this.jdField_a_of_type_Aacv.b + ", code=" + paramInt + ", req param=" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      aaep.a(this.jdField_a_of_type_Aabi, paramInt, "reportScore result error, try again");
      return;
    }
    aaep.a(this.jdField_a_of_type_Aabi, aabk.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacl
 * JD-Core Version:    0.7.0.1
 */