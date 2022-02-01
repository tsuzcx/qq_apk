import android.content.Context;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

final class aaio
  implements Callback
{
  aaio(Context paramContext, aaip paramaaip) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    aain.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aaip, "Jbq0Dm55FudiaTa26UjP071XduhCyIKRYaK6MCcYzZA");
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    try
    {
      paramCall = new JSONObject(paramResponse.body().string()).optString("key");
      aain.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aaip, paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      paramCall.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaio
 * JD-Core Version:    0.7.0.1
 */