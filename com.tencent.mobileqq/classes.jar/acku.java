import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class acku
  extends nmf
{
  acku(acks paramacks, acle paramacle, JSONObject paramJSONObject, acjr paramacjr) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(acks.a, 2, "onResult appid=" + acks.b(this.jdField_a_of_type_Acks).a + ", openid=" + this.jdField_a_of_type_Acle.a + ", openkey=" + this.jdField_a_of_type_Acle.b + ", code=" + paramInt + ", req param=" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      acmy.a(this.jdField_a_of_type_Acjr, paramInt, "reportScore result error, try again");
      return;
    }
    acmy.a(this.jdField_a_of_type_Acjr, acjt.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acku
 * JD-Core Version:    0.7.0.1
 */