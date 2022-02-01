package mqq.util;

import android.text.TextUtils;

public class LogUtil
{
  public static String getSafePrintUin(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() >= 3)) {
      return paramString.substring(0, 3);
    }
    return "invalid uin";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.util.LogUtil
 * JD-Core Version:    0.7.0.1
 */