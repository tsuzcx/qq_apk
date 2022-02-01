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
  
  public static String wrapLogUin(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() < 4) {
        return paramString;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, 4));
      ((StringBuilder)localObject).append("*");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.util.LogUtil
 * JD-Core Version:    0.7.0.1
 */