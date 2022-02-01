import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class acia
{
  private static int a(int paramInt)
  {
    if (paramInt == 7) {
      return 7;
    }
    return 0;
  }
  
  private static String a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt, acib paramacib)
  {
    int j = 0;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("bt", paramLong1 + "");
      localJSONObject.put("et", paramLong2 + "");
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramLong1 > 0L) {}
      for (int i = 0;; i = 1)
      {
        localJSONObject.put("bf", i + "");
        localStringBuilder = new StringBuilder();
        i = j;
        if (paramBoolean) {
          i = 1;
        }
        localJSONObject.put("ef", i + "");
        localJSONObject.put("pp", String.valueOf(a(paramInt)));
        localJSONObject.put("pa", paramacib.a() + "");
        localJSONObject.put("ft", paramacib.b() + "");
        if (paramacib.a()) {
          localJSONObject.put("ps", String.valueOf(paramacib.c()));
        }
        paramacib = localJSONObject.toString();
        return paramacib;
      }
      return null;
    }
    catch (JSONException paramacib)
    {
      QLog.e("GdtVideoStatisticsReport", 1, "json exception: " + paramacib.getMessage());
    }
  }
  
  public static void a(GdtAd paramGdtAd, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt, acib paramacib)
  {
    paramacib = a(paramLong1, paramLong2, paramBoolean, paramInt, paramacib);
    QLog.i("GdtVideoStatisticsReport", 1, "report: " + paramacib);
    a(paramGdtAd, paramacib);
  }
  
  private static void a(GdtAd paramGdtAd, String paramString)
  {
    if ((paramGdtAd == null) || (TextUtils.isEmpty(paramGdtAd.getUrlForImpression()))) {
      return;
    }
    a(paramGdtAd.getUrlForImpression(), paramString);
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      GdtReporter.doCgiReport(paramString1);
      return;
      paramString1 = paramString1 + "&" + "video" + "=" + URLEncoder.encode(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acia
 * JD-Core Version:    0.7.0.1
 */