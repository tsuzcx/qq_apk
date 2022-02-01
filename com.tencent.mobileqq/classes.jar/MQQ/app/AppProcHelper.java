package mqq.app;

import android.content.Context;
import android.text.format.Time;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;

public class AppProcHelper
{
  public static final String ACTION_PROCESS_EXIT = "com.tencent.process.exit";
  
  public static String getLocalVerify(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(((Time)localObject).year);
    localStringBuilder.append(((Time)localObject).month + 1);
    localStringBuilder.append(((Time)localObject).monthDay);
    localStringBuilder.append(((Time)localObject).hour);
    if (paramBoolean) {
      localStringBuilder.append(((Time)localObject).minute - 1);
    } else {
      localStringBuilder.append(((Time)localObject).minute);
    }
    if (paramArrayList == null) {
      paramArrayList = "null";
    } else {
      paramArrayList = paramArrayList.toString();
    }
    localStringBuilder.append(paramArrayList);
    paramArrayList = MD5.toMD5(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramArrayList);
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    return MD5.toMD5(((StringBuilder)localObject).toString());
  }
  
  public static boolean isContainsProc(Context paramContext, ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return true;
      }
      int i = 0;
      while (i < paramArrayList.size())
      {
        if ((MobileQQ.processName != null) && (MobileQQ.processName.equals(paramArrayList.get(i)))) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    return true;
  }
  
  public static boolean isLegalBroadcast(String paramString, ArrayList<String> paramArrayList)
  {
    if (Foreground.getActivityCount() > 0) {
      return false;
    }
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      if (!paramString.equals(getLocalVerify(paramArrayList, false))) {
        return paramString.equals(getLocalVerify(paramArrayList, true));
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.AppProcHelper
 * JD-Core Version:    0.7.0.1
 */