import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.util.Utils;
import java.lang.reflect.Field;

public class advs
  implements HookMethodCallback
{
  @TargetApi(14)
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if ((paramMethodHookParam.throwable == null) || (!(paramMethodHookParam.throwable instanceof IllegalArgumentException))) {}
    AccessibilityNodeInfo localAccessibilityNodeInfo;
    do
    {
      return;
      localAccessibilityNodeInfo = (AccessibilityNodeInfo)paramMethodHookParam.args[0];
    } while (localAccessibilityNodeInfo == null);
    StringBuilder localStringBuilder = new StringBuilder(" -- className=");
    localStringBuilder.append(paramMethodHookParam.thisObject.getClass().getName());
    View localView = (View)paramMethodHookParam.thisObject;
    localObject1 = localView.getContext();
    Object localObject2 = localObject1;
    if ("android.view.ContextThemeWrapper".equals(localObject1.getClass().getName())) {}
    try
    {
      localObject2 = Class.forName("android.view.ContextThemeWrapper").getDeclaredField("mBase");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(localView.getContext());
      if ((localObject2 == null) || (!(localObject2 instanceof Context))) {
        break label365;
      }
      localObject2 = (Context)localObject2;
      localObject1 = localObject2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Utils.a(localClassNotFoundException);
        Object localObject3 = localObject1;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Utils.a(localNoSuchFieldException);
        Object localObject4 = localObject1;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Utils.a(localIllegalArgumentException);
        Object localObject5 = localObject1;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Utils.a(localIllegalAccessException);
        Object localObject6 = localObject1;
      }
    }
    localObject2 = localObject1;
    localStringBuilder.append(", context=").append(localObject2.getClass().getName());
    localObject1 = localView.getRootView();
    if (localObject1 != null) {
      localStringBuilder.append(", rootView=").append(localObject1.getClass().getName());
    }
    localStringBuilder.append(", view ID=").append(localView.getId());
    if (Build.VERSION.SDK_INT >= 14)
    {
      localStringBuilder.append(" -- AccessibilityNodeInfo: className=").append(localAccessibilityNodeInfo.getClassName());
      localStringBuilder.append(", contentDescription=").append(localAccessibilityNodeInfo.getContentDescription());
      localStringBuilder.append(", text=").append(localAccessibilityNodeInfo.getText());
      if (Build.VERSION.SDK_INT >= 18) {
        localStringBuilder.append(", viewIdResourceName=").append(localAccessibilityNodeInfo.getViewIdResourceName());
      }
    }
    paramMethodHookParam.throwable = new RuntimeException(paramMethodHookParam.throwable.getMessage() + localStringBuilder.toString(), paramMethodHookParam.throwable);
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advs
 * JD-Core Version:    0.7.0.1
 */