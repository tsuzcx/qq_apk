package com.tencent.mm.sdk.platformtools;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class bz
{
  private static HashSet<String> OeE;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(221321);
    TAG = "AccessibilityUtil";
    HashSet localHashSet = new HashSet();
    OeE = localHashSet;
    localHashSet.add("com.eg.android.AlipayGphone/com.alipay.mobile.rome.voicebroadcast.a11y.A11yService");
    OeE.add("com.apowersoft.mirror/.service.ListenAppService");
    AppMethodBeat.o(221321);
  }
  
  public static void ftx()
  {
    AppMethodBeat.i(221319);
    for (;;)
    {
      boolean bool2;
      try
      {
        ad.i(TAG, "smartDisableAccessibility");
        AccessibilityManager localAccessibilityManager = (AccessibilityManager)aj.getContext().getSystemService("accessibility");
        boolean bool1 = localAccessibilityManager.isEnabled();
        Object localObject1 = AccessibilityManager.class.getDeclaredField("mIsHighTextContrastEnabled");
        ((Field)localObject1).setAccessible(true);
        bool2 = ((Boolean)((Field)localObject1).get(localAccessibilityManager)).booleanValue();
        if (!bool1) {}
        try
        {
          ad.i(TAG, "recoverAccessibilityEnable");
          localObject1 = AccessibilityManager.class.getDeclaredMethod("setStateLocked", new Class[] { Integer.TYPE });
          ((Method)localObject1).setAccessible(true);
          if (!localAccessibilityManager.isTouchExplorationEnabled()) {
            break label425;
          }
          i = 3;
        }
        catch (Throwable localThrowable2)
        {
          ad.e(TAG, "recoverAccessibilityEnable error : %s", new Object[] { localThrowable2.getMessage() });
          continue;
        }
        ((Method)localObject1).invoke(localAccessibilityManager, new Object[] { Integer.valueOf(j) });
        ad.i(TAG, "recoverAccessibilityEnable setStateLocked is invoked, flag = %d", new Object[] { Integer.valueOf(j) });
        if ((bu.flW()) || (i.IS_FLAVOR_RED))
        {
          ad.i(TAG, "isCoolassistEnv or flavor red, return");
          AppMethodBeat.o(221319);
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        ad.w(TAG, "disableAccessibility exception -> " + localThrowable1.getMessage());
        AppMethodBeat.o(221319);
        return;
      }
      Object localObject2 = localThrowable1.getEnabledAccessibilityServiceList(1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AccessibilityServiceInfo localAccessibilityServiceInfo = (AccessibilityServiceInfo)((Iterator)localObject2).next();
        if (!OeE.contains(localAccessibilityServiceInfo.getId()))
        {
          ad.i(TAG, "has spoken service, return");
          AppMethodBeat.o(221319);
          return;
        }
      }
      if (localThrowable1.isTouchExplorationEnabled())
      {
        ad.i(TAG, "isTouchExplorationEnabled is true, return");
        AppMethodBeat.o(221319);
        return;
      }
      ad.i(TAG, "disableAccessibility");
      localObject2 = AccessibilityManager.class.getDeclaredMethod("setStateLocked", new Class[] { Integer.TYPE });
      ((Method)localObject2).setAccessible(true);
      if (bool2) {}
      for (int i = 4;; i = 0)
      {
        ((Method)localObject2).invoke(localThrowable1, new Object[] { Integer.valueOf(i) });
        ad.i(TAG, "smartDisableAccessibility setStateLocked is invoked, flag = %d", new Object[] { Integer.valueOf(i) });
        h.LTJ.aR(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(221318);
            bz.a(this.MHy);
            AppMethodBeat.o(221318);
          }
        });
        AppMethodBeat.o(221319);
        return;
      }
      label425:
      i = 1;
      int j = i;
      if (bool2) {
        j = i | 0x4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bz
 * JD-Core Version:    0.7.0.1
 */