import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import org.json.JSONObject;

class ajdw
  implements HttpWebCgiAsyncTask.Callback
{
  ajdw(ajdv paramajdv, TroopBindPublicAccountMgr paramTroopBindPublicAccountMgr, int paramInt) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optInt("retcode", -1) == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBindPublicAccountMgr.a(this.jdField_a_of_type_Ajdv.a.a.a, 0, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdw
 * JD-Core Version:    0.7.0.1
 */