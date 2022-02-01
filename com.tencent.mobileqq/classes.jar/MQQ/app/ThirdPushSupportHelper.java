package mqq.app;

import android.content.Context;
import android.os.Bundle;

public class ThirdPushSupportHelper
{
  public static IThirdPushSupport sThirdPushSupport;
  
  public static int getThirdPushType(Context paramContext, Bundle paramBundle)
  {
    IThirdPushSupport localIThirdPushSupport = sThirdPushSupport;
    if (localIThirdPushSupport != null) {
      return localIThirdPushSupport.getThirdPushType(paramContext, paramBundle);
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.ThirdPushSupportHelper
 * JD-Core Version:    0.7.0.1
 */