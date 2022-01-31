import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONObject;

public final class aevn
  implements Runnable
{
  public aevn(String paramString, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("targetuin", Long.parseLong(this.jdField_a_of_type_JavaLangString));
      ((JSONObject)localObject).put("type", this.jdField_a_of_type_Int);
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ProtoServlet.class);
      localNewIntent.putExtra("cmd", "NearbySvr.get_chat_signature");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localObject = ((JSONObject)localObject).toString();
      localWebSsoRequestBody.data.set((String)localObject);
      localNewIntent.putExtra("data", localWebSsoRequestBody.toByteArray());
      localNewIntent.setObserver(new aevo(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevn
 * JD-Core Version:    0.7.0.1
 */