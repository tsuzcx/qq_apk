import android.os.Bundle;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

class acbw
  implements Runnable
{
  acbw(acbg paramacbg, String paramString, Bundle paramBundle, MessengerService paramMessengerService, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.jdField_a_of_type_JavaLangString).getJSONArray("gameList");
      ArrayList localArrayList = new ArrayList();
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(Integer.valueOf(((JSONArray)localObject).getInt(i)));
          i += 1;
        }
        localObject = new acbx(this);
        ApolloGameManager localApolloGameManager = (ApolloGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(210);
        localApolloGameManager.a = new WeakReference(localObject);
        localApolloGameManager.a("android.web", "apollo_aio_game.add_games_to_user_gamepanel", localArrayList);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acbw
 * JD-Core Version:    0.7.0.1
 */