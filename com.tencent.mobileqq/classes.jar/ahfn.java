import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.TimeInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public class ahfn
{
  private static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      if (paramString.equalsIgnoreCase("WiFi")) {
        return 1;
      }
      if (paramString.equalsIgnoreCase("5G")) {
        return 6;
      }
      if (paramString.equalsIgnoreCase("4G")) {
        return 4;
      }
      if (paramString.equalsIgnoreCase("3G")) {
        return 3;
      }
    } while (!paramString.equalsIgnoreCase("2G"));
    return 2;
  }
  
  public static long a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static long a(String paramString)
  {
    long l1 = 0L;
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
      localSimpleDateFormat.setCalendar(new GregorianCalendar());
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      long l2 = localSimpleDateFormat.parse(paramString).getTime();
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("springHb_Utils", 1, "parseTime exception: " + localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("springHb_Utils", 2, String.format("parseTime timeStr=%s timeMillis=%s", new Object[] { paramString, Long.valueOf(l1) }));
    }
    return l1;
  }
  
  public static String a(long paramLong)
  {
    try
    {
      Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
      ((DateFormat)localObject).setCalendar(new GregorianCalendar());
      ((DateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT+8"));
      localObject = ((DateFormat)localObject).format(new Date(paramLong));
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("springHb_Utils", 1, "parseTime exception: " + localException);
    }
    return "";
  }
  
  @Nullable
  public static String a(Bitmap paramBitmap)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      paramBitmap = Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 2);
      paramBitmap = "data:image/png;base64," + paramBitmap;
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      QLog.i("springHb_Utils", 1, "bitmapToBase64: invoked.  e: " + paramBitmap);
    }
    return null;
  }
  
  public static ArrayList<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      String str = paramJSONArray.optString(i);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    try
    {
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTime(new Date(paramLong1));
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTime(new Date(paramLong2));
      if (localCalendar1.get(1) == localCalendar2.get(1))
      {
        int i = localCalendar1.get(6);
        int j = localCalendar2.get(6);
        if (i == j) {
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramString = paramString.split("\\|");
    int j = bbev.a(paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("SpringFestivalRedpakcet", 2, "current net type: " + j);
    }
    int k = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label81;
      }
      if (a(paramString[i]) == j) {
        break;
      }
      i += 1;
    }
    label81:
    return false;
  }
  
  public static boolean a(SpringFestivalRedpacketConfBean.TimeInfo paramTimeInfo)
  {
    return (paramTimeInfo != null) && (paramTimeInfo.beginTime != 0L) && (paramTimeInfo.endTime != 0L) && (paramTimeInfo.beginTime < paramTimeInfo.endTime);
  }
  
  public static boolean a(SpringFestivalRedpacketConfBean.TimeInfo paramTimeInfo, long paramLong)
  {
    boolean bool = true;
    if (paramTimeInfo == null) {
      QLog.w("springHb_Utils", 1, "isInTime --> timeInfo is null");
    }
    do
    {
      return false;
      QLog.w("springHb_Utils", 1, "isInTime -->beginTime: " + paramTimeInfo.beginTime + "endTime: " + paramTimeInfo.endTime);
    } while (!a(paramTimeInfo));
    if ((paramTimeInfo.beginTime <= paramLong) && (paramLong <= paramTimeInfo.endTime)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(String paramString)
  {
    JSONObject localJSONObject = mze.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramString);
    paramString = mze.a(paramString);
    if (localJSONObject != null) {}
    for (int i = localJSONObject.optInt("version", 0);; i = 0)
    {
      if (paramString != null) {}
      for (int j = paramString.optInt("version", 0);; j = 0) {
        return (i != 0) || (j != 0);
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (!bbjw.a(paramString2))
    {
      paramString2 = paramString2.split("\\|");
      j = paramString2.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (paramString2[i].equals(paramString1)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static long b(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.set(11, 23);
    localCalendar.set(12, 59);
    localCalendar.set(13, 59);
    localCalendar.set(14, 999);
    return localCalendar.getTimeInMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahfn
 * JD-Core Version:    0.7.0.1
 */