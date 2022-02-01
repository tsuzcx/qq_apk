package mqq.app;

import android.content.Context;
import android.os.Bundle;

public abstract interface IThirdPushSupport
{
  public static final int TYPE_DEFAULT = 1;
  public static final int TYPE_HUAWEI = 3;
  
  public abstract int getThirdPushType(Context paramContext, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.IThirdPushSupport
 * JD-Core Version:    0.7.0.1
 */