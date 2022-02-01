import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

class aief
  implements bfpo
{
  aief(aidp paramaidp) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject == null) {}
    while (paramJSONObject.optInt("retcode", -1) != 0) {
      return;
    }
    paramJSONObject = (bfrd)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
    paramInt = paramJSONObject.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    paramJSONObject.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0, paramInt & 0xF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aief
 * JD-Core Version:    0.7.0.1
 */