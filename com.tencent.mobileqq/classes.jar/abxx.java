import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class abxx
  extends nac
{
  abxx(abxv paramabxv, abyh paramabyh, JSONObject paramJSONObject, abwu paramabwu) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(abxv.a, 2, "onResult appid=" + abxv.b(this.jdField_a_of_type_Abxv).a + ", openid=" + this.jdField_a_of_type_Abyh.a + ", openkey=" + this.jdField_a_of_type_Abyh.b + ", code=" + paramInt + ", req param=" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      acab.a(this.jdField_a_of_type_Abwu, paramInt, "reportScore result error, try again");
      return;
    }
    acab.a(this.jdField_a_of_type_Abwu, abww.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxx
 * JD-Core Version:    0.7.0.1
 */