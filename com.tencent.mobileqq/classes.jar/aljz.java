import android.os.Bundle;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

class aljz
  extends allb
{
  aljz(aljy paramaljy) {}
  
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
      if (aljq.aC.equals(paramObject.uin))
      {
        aljy.a(this.a, paramObject);
        aljy.a(this.a).jdField_a_of_type_ComTencentMobileqqDataCard = aljy.a(this.a);
        aljy.a(this.a).jdField_a_of_type_ArrayOfJavaLangString[0] = aljy.a(this.a).strNick;
        aljy.a(this.a).jdField_a_of_type_ArrayOfJavaLangString[4] = aljy.a(this.a).strReMark;
      }
    }
    if (aljy.a(this.a).get("getZanVoteCount") != null)
    {
      paramObject = (Bundle)aljy.a(this.a).get("getZanVoteCount");
      int i = paramObject.getInt("key_process_callback_id");
      paramObject = paramObject.getString("key_js_callback_id");
      Bundle localBundle = new Bundle();
      localBundle.putString("key_method_action", "getZanVoteCount");
      localBundle.putLong("key_get_zan_vote_count", aljy.a(this.a).lVoteCount);
      localBundle.putString("web_js_call_back_id", paramObject);
      this.a.callbackResult(i, EIPCResult.createSuccessResult(localBundle));
      aljy.a(this.a).remove("getZanVoteCount");
    }
  }
  
  public void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    aljy.a(this.a).babyQSwitch = paramBoolean2;
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb onGetBabyQSwitch babyQSwitch = " + paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aljz
 * JD-Core Version:    0.7.0.1
 */