import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;

public class aass
{
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    aasq.a("http://t.gdt.qq.com/conv/src/50/conv?" + "click_id={$clickid$}&product_id={$appid$}&conv_type={$convtype$}&conv_time={$convtime$}".replace("{$clickid$}", paramString1).replace("{$appid$}", paramString2).replace("{$convtype$}", new StringBuilder().append(paramInt).append("").toString()).replace("{$convtime$}", new StringBuilder().append(System.currentTimeMillis() / 1000L).append("").toString()));
  }
  
  public static void a(Ad paramAd, int paramInt)
  {
    if (TextUtils.isEmpty(paramAd.getUrlForEffect()))
    {
      aase.d("GdtTraceReporter", String.format("report %d error", new Object[] { Integer.valueOf(paramInt) }));
      return;
    }
    aase.b("GdtTraceReporter", String.format("report %d", new Object[] { Integer.valueOf(paramInt) }));
    aasq.a(paramAd.getUrlForEffect().replaceAll("__CLICK_ID__", paramAd.getTraceId()).replaceAll("__ACTION_ID__", String.valueOf(paramInt)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aass
 * JD-Core Version:    0.7.0.1
 */