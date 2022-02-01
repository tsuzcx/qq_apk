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

public class aamo
{
  private static String a(aamq paramaamq, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramaamq.a);
    localStringBuilder.append("_").append(paramaamq.b);
    localStringBuilder.append("_").append(paramaamq.h);
    localStringBuilder.append("_").append(a(paramString));
    paramString = blev.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder().append(paramaamq.d);
    localStringBuilder.append("_").append(paramaamq.k);
    localStringBuilder.append("_").append(paramaamq.l);
    localStringBuilder.append("_").append(paramaamq.m);
    localStringBuilder.append("_").append(paramaamq.n);
    localStringBuilder.append("_").append(paramaamq.o);
    localStringBuilder.append("_").append(paramaamq.p);
    localStringBuilder.append("_").append(paramaamq.q);
    localStringBuilder.append("_").append(paramString);
    return blev.a(localStringBuilder.toString());
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
  
  public static void a(Context paramContext, aamq paramaamq)
  {
    if ((paramContext == null) || (paramaamq == null)) {
      return;
    }
    Request localRequest = new Request.Builder().url("https://jubao.qq.com/uniform_impeach/impeach_cryptokey").build();
    new OkHttpClient().newCall(localRequest).enqueue(new aamp(paramContext, paramaamq));
  }
  
  private static void b(Context paramContext, aamq paramaamq, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://jubao.qq.com/uniform_impeach/impeach_entry");
    localStringBuilder.append("?system=").append(paramaamq.a);
    localStringBuilder.append("&version=").append(paramaamq.b);
    localStringBuilder.append("&uintype=").append(paramaamq.c);
    localStringBuilder.append("&eviluin=").append(paramaamq.d);
    localStringBuilder.append("&appname=").append(paramaamq.e);
    localStringBuilder.append("&appid=").append(paramaamq.f);
    localStringBuilder.append("&subapp=").append(paramaamq.g);
    localStringBuilder.append("&scene=").append(paramaamq.h);
    localStringBuilder.append("&buddyflag=").append(paramaamq.i);
    localStringBuilder.append("&contentid=").append(paramaamq.j);
    localStringBuilder.append("&srv_para=").append(paramaamq.k);
    localStringBuilder.append("&text_evidence=").append(paramaamq.l);
    localStringBuilder.append("&img_evidence=").append(URLEncoder.encode(paramaamq.m));
    localStringBuilder.append("&url_evidence=").append(paramaamq.n);
    localStringBuilder.append("&video_evidence=").append(URLEncoder.encode(paramaamq.o));
    localStringBuilder.append("&file_evidence=").append(paramaamq.p);
    localStringBuilder.append("&audio_evidence=").append(paramaamq.q);
    localStringBuilder.append("&user_input_param=").append(paramaamq.r);
    localStringBuilder.append("&groupid=").append(paramaamq.s);
    localStringBuilder.append("&cryptograph=").append(a(paramaamq, paramString));
    paramaamq = new Intent(paramContext, QQBrowserDelegationActivity.class);
    paramaamq.putExtra("url", localStringBuilder.toString());
    paramContext.startActivity(paramaamq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamo
 * JD-Core Version:    0.7.0.1
 */