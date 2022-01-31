import android.os.Bundle;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

class ajsm
  extends ajto
{
  ajsm(ajsl paramajsl) {}
  
  public void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb onCardDownload ");
    }
    if ((paramObject instanceof Card))
    {
      paramObject = (Card)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("BabyQIPCModule", 2, "babyqWeb onCardDownload set card info uin = " + paramObject.uin);
      }
      if (ajsd.aC.equals(paramObject.uin))
      {
        ajsl.a(this.a, paramObject);
        ajsl.a(this.a).jdField_a_of_type_ComTencentMobileqqDataCard = ajsl.a(this.a);
        ajsl.a(this.a).jdField_a_of_type_ArrayOfJavaLangString[0] = ajsl.a(this.a).strNick;
        ajsl.a(this.a).jdField_a_of_type_ArrayOfJavaLangString[4] = ajsl.a(this.a).strReMark;
      }
    }
    if (ajsl.a(this.a).get("getZanVoteCount") != null)
    {
      paramObject = (Bundle)ajsl.a(this.a).get("getZanVoteCount");
      int i = paramObject.getInt("key_process_callback_id");
      paramObject = paramObject.getString("key_js_callback_id");
      Bundle localBundle = new Bundle();
      localBundle.putString("key_method_action", "getZanVoteCount");
      localBundle.putLong("key_get_zan_vote_count", ajsl.a(this.a).lVoteCount);
      localBundle.putString("web_js_call_back_id", paramObject);
      this.a.callbackResult(i, EIPCResult.createSuccessResult(localBundle));
      ajsl.a(this.a).remove("getZanVoteCount");
    }
  }
  
  public void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    ajsl.a(this.a).babyQSwitch = paramBoolean2;
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb onGetBabyQSwitch babyQSwitch = " + paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajsm
 * JD-Core Version:    0.7.0.1
 */