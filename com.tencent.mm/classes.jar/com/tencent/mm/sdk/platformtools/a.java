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

public final class a
{
  private static HashSet<String> Iwh;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(196733);
    TAG = "AccessibilityUtil";
    HashSet localHashSet = new HashSet();
    Iwh = localHashSet;
    localHashSet.add("com.eg.android.AlipayGphone/com.alipay.mobile.rome.voicebroadcast.a11y.A11yService");
    Iwh.add("com.apowersoft.mirror/.service.ListenAppService");
    Iwh.add("com.tencent.android.qqdownloader/com.tencent.nucleus.manager.accessibility.YYBAccessibilityService");
    Iwh.add("com.huawei.recsys/.service.PortraitDaService");
    AppMethodBeat.o(196733);
  }
  
  private static void a(AccessibilityManager paramAccessibilityManager)
  {
    AppMethodBeat.i(196731);
    ae.i(TAG, "printEnabledAccessibilityServiceInfo");
    try
    {
      ae.i(TAG, "printEnabledAccessibilityServiceInfo enabled = " + paramAccessibilityManager.isEnabled());
      paramAccessibilityManager = paramAccessibilityManager.getEnabledAccessibilityServiceList(-1).iterator();
      while (paramAccessibilityManager.hasNext())
      {
        AccessibilityServiceInfo localAccessibilityServiceInfo = (AccessibilityServiceInfo)paramAccessibilityManager.next();
        ae.i(TAG, "enabledAccessibilityServiceInfo : %s", new Object[] { localAccessibilityServiceInfo.toString() });
      }
      AppMethodBeat.o(196731);
    }
    catch (Throwable paramAccessibilityManager)
    {
      ae.e(TAG, "printEnabledAccessibilityServiceInfo error : %s", new Object[] { paramAccessibilityManager.getMessage() });
      AppMethodBeat.o(196731);
      return;
    }
  }
  
  public static void fnK()
  {
    AppMethodBeat.i(196730);
    for (;;)
    {
      boolean bool2;
      try
      {
        ae.i(TAG, "smartDisableAccessibility");
        AccessibilityManager localAccessibilityManager = (AccessibilityManager)ak.getContext().getSystemService("accessibility");
        boolean bool1 = localAccessibilityManager.isEnabled();
        Object localObject1 = AccessibilityManager.class.getDeclaredField("mIsHighTextContrastEnabled");
        ((Field)localObject1).setAccessible(true);
        bool2 = ((Boolean)((Field)localObject1).get(localAccessibilityManager)).booleanValue();
        if (!bool1) {}
        try
        {
          ae.i(TAG, "recoverAccessibilityEnable");
          localObject1 = AccessibilityManager.class.getDeclaredMethod("setStateLocked", new Class[] { Integer.TYPE });
          ((Method)localObject1).setAccessible(true);
          if (!localAccessibilityManager.isTouchExplorationEnabled()) {
            break label430;
          }
          i = 3;
        }
        catch (Throwable localThrowable2)
        {
          ae.e(TAG, "recoverAccessibilityEnable error : %s", new Object[] { localThrowable2.getMessage() });
          continue;
        }
        ((Method)localObject1).invoke(localAccessibilityManager, new Object[] { Integer.valueOf(j) });
        ae.i(TAG, "recoverAccessibilityEnable setStateLocked is invoked, flag = %d", new Object[] { Integer.valueOf(j) });
        if ((bv.fpR()) || (j.IS_FLAVOR_RED))
        {
          ae.i(TAG, "isCoolassistEnv or flavor red, return");
          AppMethodBeat.o(196730);
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        ae.w(TAG, "disableAccessibility exception -> " + localThrowable1.getMessage());
        AppMethodBeat.o(196730);
        return;
      }
      Object localObject2 = localThrowable1.getEnabledAccessibilityServiceList(1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AccessibilityServiceInfo localAccessibilityServiceInfo = (AccessibilityServiceInfo)((Iterator)localObject2).next();
        if (!Iwh.contains(localAccessibilityServiceInfo.getId()))
        {
          ae.i(TAG, "has spoken service, return");
          a(localThrowable1);
          AppMethodBeat.o(196730);
          return;
        }
      }
      if (localThrowable1.isTouchExplorationEnabled())
      {
        ae.i(TAG, "isTouchExplorationEnabled is true, return");
        AppMethodBeat.o(196730);
        return;
      }
      ae.i(TAG, "disableAccessibility");
      localObject2 = AccessibilityManager.class.getDeclaredMethod("setStateLocked", new Class[] { Integer.TYPE });
      ((Method)localObject2).setAccessible(true);
      if (bool2) {}
      for (int i = 4;; i = 0)
      {
        ((Method)localObject2).invoke(localThrowable1, new Object[] { Integer.valueOf(i) });
        ae.i(TAG, "smartDisableAccessibility setStateLocked is invoked, flag = %d", new Object[] { Integer.valueOf(i) });
        h.MqF.aO(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(196729);
            a.b(this.Iwi);
            AppMethodBeat.o(196729);
          }
        });
        AppMethodBeat.o(196730);
        return;
      }
      label430:
      i = 1;
      int j = i;
      if (bool2) {
        j = i | 0x4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.a
 * JD-Core Version:    0.7.0.1
 */