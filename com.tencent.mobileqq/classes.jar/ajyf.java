import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class ajyf
  implements HttpWebCgiAsyncTask.Callback
{
  public ajyf(TroopTopicMgr paramTroopTopicMgr, TroopChatPie paramTroopChatPie, String paramString1, ChatMessage paramChatMessage, String paramString2, int paramInt) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) || (TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr) == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.bn();
    TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr);
    paramJSONObject = TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr, paramJSONObject, this.jdField_a_of_type_JavaLangString);
    if (paramJSONObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "publishableJson = " + paramJSONObject);
      }
      TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr).put(this.jdField_a_of_type_JavaLangString, paramJSONObject);
      paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr.a(paramJSONObject, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.b, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie, paramJSONObject.toString());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_topic", 2, "publishableJson = null");
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(), TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr).getApp().getString(2131430738), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyf
 * JD-Core Version:    0.7.0.1
 */