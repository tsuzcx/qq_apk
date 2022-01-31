import android.os.Bundle;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

class ajem
  extends ajfo
{
  ajem(ajel paramajel) {}
  
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
      if (ajed.aB.equals(paramObject.uin))
      {
        ajel.a(this.a, paramObject);
        ajel.a(this.a).jdField_a_of_type_ComTencentMobileqqDataCard = ajel.a(this.a);
        ajel.a(this.a).jdField_a_of_type_ArrayOfJavaLangString[0] = ajel.a(this.a).strNick;
        ajel.a(this.a).jdField_a_of_type_ArrayOfJavaLangString[4] = ajel.a(this.a).strReMark;
      }
    }
    if (ajel.a(this.a).get("getZanVoteCount") != null)
    {
      paramObject = (Bundle)ajel.a(this.a).get("getZanVoteCount");
      int i = paramObject.getInt("key_process_callback_id");
      paramObject = paramObject.getString("key_js_callback_id");
      Bundle localBundle = new Bundle();
      localBundle.putString("key_method_action", "getZanVoteCount");
      localBundle.putLong("key_get_zan_vote_count", ajel.a(this.a).lVoteCount);
      localBundle.putString("web_js_call_back_id", paramObject);
      this.a.callbackResult(i, EIPCResult.createSuccessResult(localBundle));
      ajel.a(this.a).remove("getZanVoteCount");
    }
  }
  
  public void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    ajel.a(this.a).babyQSwitch = paramBoolean2;
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb onGetBabyQSwitch babyQSwitch = " + paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajem
 * JD-Core Version:    0.7.0.1
 */