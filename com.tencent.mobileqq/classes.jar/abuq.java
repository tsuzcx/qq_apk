import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class abuq
  implements Runnable
{
  abuq(abue paramabue, QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, float paramFloat, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject1 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
      localObject2 = new ApolloFavActionData();
      ((ApolloFavActionData)localObject2).acitonId = this.jdField_a_of_type_Int;
      ((ApolloFavActionData)localObject2).text = this.jdField_a_of_type_JavaLangString;
      ((ApolloFavActionData)localObject2).textType = this.b;
      ((ApolloFavActionData)localObject2).audioId = this.c;
      ((ApolloFavActionData)localObject2).playOriginalAudio = this.d;
      ((ApolloFavActionData)localObject2).audioStartTime = this.jdField_a_of_type_Float;
      l = System.currentTimeMillis();
      ((ApolloFavActionData)localObject2).favId = l;
      ((ApolloDaoManager)localObject1).a((ApolloFavActionData)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.web.MessengerService", 2, "add fav action success +" + ((ApolloFavActionData)localObject2).toString());
      }
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        localObject2 = new ApolloMainInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        ((ApolloInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloDaoManager)localObject1).a(this.jdField_a_of_type_Int);
        ((ApolloInfo)localObject2).b = this.jdField_a_of_type_JavaLangString;
        ((ApolloInfo)localObject2).d = this.b;
        ((ApolloInfo)localObject2).e = this.c;
        ((ApolloInfo)localObject2).jdField_a_of_type_Float = this.jdField_a_of_type_Float;
        ((ApolloInfo)localObject2).f = this.d;
        localObject1 = localMqqHandler.obtainMessage(66);
        ((Message)localObject1).obj = localObject2;
        ((Message)localObject1).sendToTarget();
      }
      localObject1 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject1).put("seq", l);
      ((JSONObject)localObject1).put("success", true);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("addFavAction", ((JSONObject)localObject1).toString());
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.emoji.web.MessengerService", 2, "addFavAction ipc json error + " + localJSONException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abuq
 * JD-Core Version:    0.7.0.1
 */