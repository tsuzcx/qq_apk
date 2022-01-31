import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.js.SpringFestivalRedpacketJsPlugin.3;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

public class ahhx
  implements EIPCResultCallback
{
  public ahhx(SpringFestivalRedpacketJsPlugin.3 param3, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.i("springHb_SpringFestivalRedpacketJsPlugin", 1, "uploadHeadToH5: invoked.  QWalletIPCModule.ACTION_GET_User_Nick: " + paramEIPCResult);
    Object localObject;
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      paramEIPCResult = paramEIPCResult.data;
      if (paramEIPCResult == null)
      {
        localObject = "";
        paramEIPCResult = (EIPCResult)localObject;
        if (!bbjw.a((String)localObject)) {}
      }
    }
    for (paramEIPCResult = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalJsSpringFestivalRedpacketJsPlugin$3.jdField_a_of_type_JavaLangString;; paramEIPCResult = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalJsSpringFestivalRedpacketJsPlugin$3.jdField_a_of_type_JavaLangString)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("avatar", this.jdField_a_of_type_JavaLangString);
        ((JSONObject)localObject).put("nickname", paramEIPCResult);
        ahhu.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalJsSpringFestivalRedpacketJsPlugin$3.this$0, "getAvatarAndNickname", ((JSONObject)localObject).toString());
        QLog.i("springHb_SpringFestivalRedpacketJsPlugin", 1, "uploadHeadToH5 doCallback: " + ((JSONObject)localObject).toString());
        return;
      }
      catch (Exception paramEIPCResult)
      {
        QLog.e("springHb_SpringFestivalRedpacketJsPlugin", 1, "uploadHeadToH5 parse result throw an exception: " + paramEIPCResult);
      }
      localObject = paramEIPCResult.getString("user_nick");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhx
 * JD-Core Version:    0.7.0.1
 */