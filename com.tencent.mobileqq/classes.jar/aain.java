import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import cooperation.qzone.util.QZLog;
import java.net.URLEncoder;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;

public class aain
{
  private static String a(aaip paramaaip, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramaaip.a);
    localStringBuilder.append("_").append(paramaaip.b);
    localStringBuilder.append("_").append(paramaaip.h);
    localStringBuilder.append("_").append(a(paramString));
    paramString = bkdr.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder().append(paramaaip.d);
    localStringBuilder.append("_").append(paramaaip.k);
    localStringBuilder.append("_").append(paramaaip.l);
    localStringBuilder.append("_").append(paramaaip.m);
    localStringBuilder.append("_").append(paramaaip.n);
    localStringBuilder.append("_").append(paramaaip.o);
    localStringBuilder.append("_").append(paramaaip.p);
    localStringBuilder.append("_").append(paramaaip.q);
    localStringBuilder.append("_").append(paramString);
    return bkdr.a(localStringBuilder.toString());
  }
  
  private static String a(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 0);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec("d41d8cd98f00b204e9800998ecf8427e".getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding");
      localCipher.init(2, localSecretKeySpec);
      paramString = new String(localCipher.doFinal(paramString), "utf-8");
      return paramString;
    }
    catch (Throwable paramString)
    {
      QZLog.e("EvilReportUtil", "decrypt key error! " + paramString);
    }
    return "";
  }
  
  public static void a(Context paramContext, aaip paramaaip)
  {
    if ((paramContext == null) || (paramaaip == null)) {
      return;
    }
    Request localRequest = new Request.Builder().url("https://jubao.qq.com/uniform_impeach/impeach_cryptokey").build();
    new OkHttpClient().newCall(localRequest).enqueue(new aaio(paramContext, paramaaip));
  }
  
  private static void b(Context paramContext, aaip paramaaip, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://jubao.qq.com/uniform_impeach/impeach_entry");
    localStringBuilder.append("?system=").append(paramaaip.a);
    localStringBuilder.append("&version=").append(paramaaip.b);
    localStringBuilder.append("&uintype=").append(paramaaip.c);
    localStringBuilder.append("&eviluin=").append(paramaaip.d);
    localStringBuilder.append("&appname=").append(paramaaip.e);
    localStringBuilder.append("&appid=").append(paramaaip.f);
    localStringBuilder.append("&subapp=").append(paramaaip.g);
    localStringBuilder.append("&scene=").append(paramaaip.h);
    localStringBuilder.append("&buddyflag=").append(paramaaip.i);
    localStringBuilder.append("&contentid=").append(paramaaip.j);
    localStringBuilder.append("&srv_para=").append(paramaaip.k);
    localStringBuilder.append("&text_evidence=").append(paramaaip.l);
    localStringBuilder.append("&img_evidence=").append(URLEncoder.encode(paramaaip.m));
    localStringBuilder.append("&url_evidence=").append(paramaaip.n);
    localStringBuilder.append("&video_evidence=").append(URLEncoder.encode(paramaaip.o));
    localStringBuilder.append("&file_evidence=").append(paramaaip.p);
    localStringBuilder.append("&audio_evidence=").append(paramaaip.q);
    localStringBuilder.append("&user_input_param=").append(paramaaip.r);
    localStringBuilder.append("&cryptograph=").append(a(paramaaip, paramString));
    paramaaip = new Intent(paramContext, QQBrowserDelegationActivity.class);
    paramaaip.putExtra("url", localStringBuilder.toString());
    paramContext.startActivity(paramaaip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aain
 * JD-Core Version:    0.7.0.1
 */