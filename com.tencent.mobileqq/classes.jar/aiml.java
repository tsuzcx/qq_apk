import java.util.Calendar;
import java.util.Date;

public class aiml
{
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "星期日";
    case 2: 
      return "星期一";
    case 3: 
      return "星期二";
    case 4: 
      return "星期三";
    case 5: 
      return "星期四";
    case 6: 
      return "星期五";
    }
    return "星期六";
  }
  
  public static String a(long paramLong)
  {
    long l = System.currentTimeMillis();
    String str1 = b(paramLong);
    if (!a(paramLong, l)) {}
    for (boolean bool = true;; bool = false)
    {
      String str2 = a(paramLong, bool, true, true);
      return str2 + " " + str1;
    }
  }
  
  public static String a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean1)
    {
      str = localCalendar.get(1) + "-";
      localStringBuilder = localStringBuilder.append(str);
      if (!paramBoolean2) {
        break label143;
      }
      str = String.format("%02d-", new Object[] { Integer.valueOf(localCalendar.get(2) + 1) });
      label88:
      localStringBuilder = localStringBuilder.append(str);
      if (!paramBoolean3) {
        break label150;
      }
    }
    label143:
    label150:
    for (String str = String.format("%02d", new Object[] { Integer.valueOf(localCalendar.get(5)) });; str = "")
    {
      return str;
      str = "";
      break;
      str = "";
      break label88;
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return localCalendar1.get(1) == localCalendar2.get(1);
  }
  
  public static String b(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(localDate.getHours()), Integer.valueOf(localDate.getMinutes()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiml
 * JD-Core Version:    0.7.0.1
 */