import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class adob
  extends nkq
{
  adob(adnz paramadnz, adol paramadol, JSONObject paramJSONObject, admy paramadmy) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(adnz.a, 2, "onResult appid=" + adnz.b(this.jdField_a_of_type_Adnz).a + ", openid=" + this.jdField_a_of_type_Adol.a + ", openkey=" + this.jdField_a_of_type_Adol.b + ", code=" + paramInt + ", req param=" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      adqf.a(this.jdField_a_of_type_Admy, paramInt, "reportScore result error, try again");
      return;
    }
    adqf.a(this.jdField_a_of_type_Admy, adna.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adob
 * JD-Core Version:    0.7.0.1
 */