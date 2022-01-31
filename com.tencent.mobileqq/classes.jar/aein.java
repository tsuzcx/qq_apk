import com.squareup.okhttp.Call;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.protocol.NowRequest.Builder;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageUploader.OnResultListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.TimeUnit;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class aein
  implements Runnable
{
  public aein(ImageUploader paramImageUploader, int paramInt, String paramString, byte[] paramArrayOfByte, TicketManager paramTicketManager, ImageUploader.OnResultListener paramOnResultListener) {}
  
  public void run()
  {
    int i = 0;
    int j = 0;
    if (j < 3) {}
    for (;;)
    {
      try
      {
        ImageUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader.a.getLongAccountUin(), this.jdField_a_of_type_ArrayOfByte);
        new File(this.jdField_a_of_type_JavaLangString);
        Object localObject1 = new OkHttpClient();
        ((OkHttpClient)localObject1).setConnectTimeout(10000L, TimeUnit.MILLISECONDS);
        ((OkHttpClient)localObject1).setWriteTimeout(10000L, TimeUnit.MILLISECONDS);
        ((OkHttpClient)localObject1).setReadTimeout(10000L, TimeUnit.MILLISECONDS);
        Object localObject3 = this.jdField_a_of_type_MqqManagerTicketManager.getSkey(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader.a.getCurrentAccountUin());
        Object localObject2 = new FormEncodingBuilder().add("pic", ImageUploader.a(this.jdField_a_of_type_JavaLangString)).add("bkn", "" + ImageUploader.a((String)localObject3)).build();
        String str = this.jdField_a_of_type_MqqManagerTicketManager.getA2(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader.a.getCurrentAccountUin());
        localObject3 = "ilive_uin=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader.a.getCurrentAccountUin() + ";ilive_a2=" + str + ";skey=" + (String)localObject3 + ";uin=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader.a.getCurrentAccountUin();
        localObject1 = ((OkHttpClient)localObject1).newCall(new NowRequest.Builder().a("http://now.qq.com/cgi-bin/now/web/user/upload_feeds_base64").a((RequestBody)localObject2).a("Referer", "http://now.qq.com").a("Cookie", "" + (String)localObject3).a()).execute();
        if (((Response)localObject1).isSuccessful())
        {
          localObject1 = ((Response)localObject1).body().string();
          QLog.i("ImageUploader", 1, "response result" + (String)localObject1);
          localObject3 = new JSONObject((String)localObject1);
          localObject2 = "";
          if (!((JSONObject)localObject3).has("retcode")) {
            break label483;
          }
          i = ((JSONObject)localObject3).optInt("retcode");
          localObject1 = localObject2;
          if (((JSONObject)localObject3).has("result"))
          {
            localObject3 = ((JSONObject)localObject3).optJSONObject("result");
            localObject1 = localObject2;
            if (localObject3 != null) {
              localObject1 = ((JSONObject)localObject3).optString("url");
            }
          }
          ImageUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader$OnResultListener, i, (String)localObject1);
          return;
        }
        i = ((Response)localObject1).code();
        ((Response)localObject1).body().close();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i = -1;
        continue;
      }
      j += 1;
      break;
      if (i == 0) {
        return;
      }
      ImageUploader.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageUploader$OnResultListener, i, "");
      return;
      label483:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aein
 * JD-Core Version:    0.7.0.1
 */