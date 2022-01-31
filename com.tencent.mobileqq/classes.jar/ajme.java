import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.observer.AccountObserver;

public class ajme
  extends AccountObserver
{
  public ajme(MessageHandler paramMessageHandler, String paramString) {}
  
  public void onChangeToken(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null))
    {
      paramHashMap = (RespondCustomSig)paramHashMap.get("login.chgTok");
      if ((paramHashMap == null) || (paramHashMap.SigList == null)) {
        return;
      }
      int i = 0;
      while (i < paramHashMap.SigList.size())
      {
        Object localObject = (CustomSigContent)paramHashMap.SigList.get(i);
        if ((((CustomSigContent)localObject).sResult == 0) && (((CustomSigContent)localObject).ulSigType == 16L))
        {
          localObject = new String(((CustomSigContent)localObject).SigContent);
          OpenID localOpenID = new OpenID();
          localOpenID.appID = this.jdField_a_of_type_JavaLangString;
          localOpenID.openID = ((String)localObject);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().b(localOpenID);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.a(this.jdField_a_of_type_JavaLangString, localOpenID);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.notifyUI(1, true, localOpenID);
        }
        i += 1;
      }
    }
    if (paramBoolean) {}
    for (paramHashMap = "0";; paramHashMap = "1")
    {
      bcad.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getAccount(), "", this.jdField_a_of_type_JavaLangString, "41", "19", paramHashMap, "", "", "4", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajme
 * JD-Core Version:    0.7.0.1
 */