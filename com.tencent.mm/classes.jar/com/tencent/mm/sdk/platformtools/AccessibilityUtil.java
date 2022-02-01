package com.tencent.mm.sdk.platformtools;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class AccessibilityUtil
{
  private static String TAG;
  private static HashSet<String> spokenServiceBlackSet;
  
  static
  {
    AppMethodBeat.i(263311);
    TAG = "AccessibilityUtil";
    HashSet localHashSet = new HashSet();
    spokenServiceBlackSet = localHashSet;
    localHashSet.add("com.eg.android.AlipayGphone/com.alipay.mobile.rome.voicebroadcast.a11y.A11yService");
    spokenServiceBlackSet.add("com.apowersoft.mirror/.service.ListenAppService");
    spokenServiceBlackSet.add("com.tencent.android.qqdownloader/com.tencent.nucleus.manager.accessibility.YYBAccessibilityService");
    spokenServiceBlackSet.add("com.huawei.recsys/.service.PortraitDaService");
    spokenServiceBlackSet.add("com.samsung.android.app.sreminder/.phone.shoppingassistant.ShoppingAssistantService");
    spokenServiceBlackSet.add("com.liuzh.quickly/.accservice.QuicklyAccService");
    spokenServiceBlackSet.add("com.whatsbug.litiaotiao/.MyAccessibilityService");
    AppMethodBeat.o(263311);
  }
  
  private static void printEnabledAccessibilityServiceInfo(AccessibilityManager paramAccessibilityManager)
  {
    AppMethodBeat.i(263309);
    Log.i(TAG, "printEnabledAccessibilityServiceInfo");
    try
    {
      Log.i(TAG, "printEnabledAccessibilityServiceInfo enabled = " + paramAccessibilityManager.isEnabled());
      paramAccessibilityManager = paramAccessibilityManager.getEnabledAccessibilityServiceList(-1).iterator();
      while (paramAccessibilityManager.hasNext())
      {
        AccessibilityServiceInfo localAccessibilityServiceInfo = (AccessibilityServiceInfo)paramAccessibilityManager.next();
        Log.i(TAG, "enabledAccessibilityServiceInfo : %s", new Object[] { localAccessibilityServiceInfo.toString() });
      }
      AppMethodBeat.o(263309);
    }
    catch (Throwable paramAccessibilityManager)
    {
      Log.e(TAG, "printEnabledAccessibilityServiceInfo error : %s", new Object[] { paramAccessibilityManager.getMessage() });
      AppMethodBeat.o(263309);
      return;
    }
  }
  
  private static void recoverAccessibilityEnable(AccessibilityManager paramAccessibilityManager, boolean paramBoolean)
  {
    AppMethodBeat.i(263308);
    for (;;)
    {
      try
      {
        Log.i(TAG, "recoverAccessibilityEnable");
        localMethod = AccessibilityManager.class.getDeclaredMethod("setStateLocked", new Class[] { Integer.TYPE });
        localMethod.setAccessible(true);
        if (!paramAccessibilityManager.isTouchExplorationEnabled()) {
          break label119;
        }
        i = 3;
      }
      catch (Throwable paramAccessibilityManager)
      {
        Method localMethod;
        Log.e(TAG, "recoverAccessibilityEnable error : %s", new Object[] { paramAccessibilityManager.getMessage() });
        AppMethodBeat.o(263308);
        return;
      }
      localMethod.invoke(paramAccessibilityManager, new Object[] { Integer.valueOf(j) });
      Log.i(TAG, "recoverAccessibilityEnable setStateLocked is invoked, flag = %d", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(263308);
      return;
      label119:
      int i = 1;
      int j = i;
      if (paramBoolean) {
        j = i | 0x4;
      }
    }
  }
  
  public static void smartDisableAccessibility()
  {
    AppMethodBeat.i(263307);
    for (;;)
    {
      try
      {
        Log.i(TAG, "smartDisableAccessibility");
        AccessibilityManager localAccessibilityManager = (AccessibilityManager)MMApplicationContext.getContext().getSystemService("accessibility");
        boolean bool1 = localAccessibilityManager.isEnabled();
        Object localObject = AccessibilityManager.class.getDeclaredField("mIsHighTextContrastEnabled");
        ((Field)localObject).setAccessible(true);
        boolean bool2 = ((Boolean)((Field)localObject).get(localAccessibilityManager)).booleanValue();
        if (!bool1) {
          recoverAccessibilityEnable(localAccessibilityManager, bool2);
        }
        if ((WeChatEnvironment.isCoolassistEnv()) || (BuildInfo.IS_FLAVOR_RED))
        {
          Log.i(TAG, "isCoolassistEnv or flavor red, return");
          AppMethodBeat.o(263307);
          return;
        }
        localObject = localAccessibilityManager.getEnabledAccessibilityServiceList(1).iterator();
        if (((Iterator)localObject).hasNext())
        {
          AccessibilityServiceInfo localAccessibilityServiceInfo = (AccessibilityServiceInfo)((Iterator)localObject).next();
          if (spokenServiceBlackSet.contains(localAccessibilityServiceInfo.getId())) {
            continue;
          }
          Log.i(TAG, "has spoken service, return");
          printEnabledAccessibilityServiceInfo(localAccessibilityManager);
          AppMethodBeat.o(263307);
          return;
        }
        if (localAccessibilityManager.isTouchExplorationEnabled())
        {
          Log.i(TAG, "isTouchExplorationEnabled is true, return");
          AppMethodBeat.o(263307);
          return;
        }
        Log.i(TAG, "disableAccessibility");
        localObject = AccessibilityManager.class.getDeclaredMethod("setStateLocked", new Class[] { Integer.TYPE });
        ((Method)localObject).setAccessible(true);
        if (bool2)
        {
          i = 4;
          ((Method)localObject).invoke(localAccessibilityManager, new Object[] { Integer.valueOf(i) });
          Log.i(TAG, "smartDisableAccessibility setStateLocked is invoked, flag = %d", new Object[] { Integer.valueOf(i) });
          h.ZvG.be(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(263039);
              AccessibilityUtil.access$000(this.val$accessibilityManager);
              AppMethodBeat.o(263039);
            }
          });
          AppMethodBeat.o(263307);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.w(TAG, "disableAccessibility exception -> " + localThrowable.getMessage());
        AppMethodBeat.o(263307);
        return;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.AccessibilityUtil
 * JD-Core Version:    0.7.0.1
 */