import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

class aaac
  implements Callback
{
  aaac(zzz paramzzz, String paramString1, zzv paramzzv, boolean paramBoolean, String paramString2) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.d("RFWDownloader", 1, "checkResource:" + this.jdField_a_of_type_JavaLangString + " onFailure");
    this.jdField_a_of_type_Zzv.a(false, this.jdField_a_of_type_Boolean, false, this.b);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    try
    {
      paramCall = paramResponse.headers().get("X-COS-META-MD5");
      if ((TextUtils.isEmpty(paramCall)) || (this.b.equals(paramCall)))
      {
        QLog.d("RFWDownloader", 1, "checkResource:" + this.jdField_a_of_type_JavaLangString + " is up to date");
        this.jdField_a_of_type_Zzv.a(true, this.jdField_a_of_type_Boolean, false, paramCall);
        return;
      }
      QLog.d("RFWDownloader", 1, "checkResource:" + this.jdField_a_of_type_JavaLangString + " need update");
      this.jdField_a_of_type_Zzv.a(true, this.jdField_a_of_type_Boolean, true, paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      paramCall.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaac
 * JD-Core Version:    0.7.0.1
 */