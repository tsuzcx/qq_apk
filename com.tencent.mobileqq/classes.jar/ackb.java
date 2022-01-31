import android.os.Bundle;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameRoamData;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

class ackb
  implements Runnable
{
  ackb(acjg paramacjg, String paramString, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      Object localObject2 = new JSONObject(this.jdField_a_of_type_JavaLangString);
      long l = ((JSONObject)localObject2).optLong("timestamp");
      Object localObject1 = new ArrayList();
      localObject2 = ((JSONObject)localObject2).optJSONArray("gameList");
      while (i < ((JSONArray)localObject2).length())
      {
        ApolloGameRoamData localApolloGameRoamData = new ApolloGameRoamData();
        JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
        localApolloGameRoamData.gameId = localJSONObject.optInt("gameId");
        localApolloGameRoamData.type = localJSONObject.optInt("tab");
        ((ArrayList)localObject1).add(localApolloGameRoamData);
        i += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessengerService$IncomingHandler", 2, "IPC_APOLLO_UPDATE_GAME_LIST, update game list");
        }
        localObject2 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
        ((ApolloDaoManager)localObject2).e();
        ((ApolloDaoManager)localObject2).c((ArrayList)localObject1);
        ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l);
        ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).d();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("result", 0);
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MessengerService$IncomingHandler", 1, "IPC_APOLLO_UPDATE_GAME_LIST, exception=", localException);
      Bundle localBundle = new Bundle();
      localBundle.putInt("result", 1);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ackb
 * JD-Core Version:    0.7.0.1
 */