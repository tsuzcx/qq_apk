package com.tencent.mm.sdk.platformtools;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
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
    AppMethodBeat.i(244042);
    TAG = "AccessibilityUtil";
    HashSet localHashSet = new HashSet();
    spokenServiceBlackSet = localHashSet;
    localHashSet.add("com.eg.android.AlipayGphone/com.alipay.mobile.rome.voicebroadcast.a11y.A11yService");
    spokenServiceBlackSet.add("com.apowersoft.mirror/.service.ListenAppService");
    spokenServiceBlackSet.add("com.tencent.android.qqdownloader/com.tencent.nucleus.manager.accessibility.YYBAccessibilityService");
    spokenServiceBlackSet.add("com.huawei.recsys/.service.PortraitDaService");
    spokenServiceBlackSet.add("com.samsung.android.app.sreminder/.phone.shoppingassistant.ShoppingAssistantService");
    spokenServiceBlackSet.add("com.liuzh.quickly/.accservice.QuicklyAccService");
    spokenServiceBlackSet.add("com.kugou.android.ringtone/.ringcommon.util.permission.accessibilitysuper.service.AccessibilitySuperService");
    spokenServiceBlackSet.add("com.tencent.qqpinyin/.accessibility.EmotionHelperService");
    spokenServiceBlackSet.add("com.samsung.android.bixbytouch/com.samsung.android.bixbytouch.library.shopping.ShoppingAccessibilityService");
    spokenServiceBlackSet.add("org.autojs.autojs/com.stardust.autojs.core.accessibility.AccessibilityService");
    spokenServiceBlackSet.add("com.whatsbug.litiaotiao/.MyAccessibilityService");
    spokenServiceBlackSet.add("com.auto.greenskipad/com.auto.skip.service.NewTiaoGuoService");
    spokenServiceBlackSet.add("com.hihonor.awareness/.server.pageanalysis.AccessibleInfoStuck");
    spokenServiceBlackSet.add("com.coloros.colordirectservice/.ColorTextAccessibilityService");
    spokenServiceBlackSet.add("com.huawei.contentsensor/.accessibility.ContentAccessibilityService");
    AppMethodBeat.o(244042);
  }
  
  private static void printEnabledAccessibilityServiceInfo(AccessibilityManager paramAccessibilityManager)
  {
    AppMethodBeat.i(244027);
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
      AppMethodBeat.o(244027);
    }
    finally
    {
      Log.e(TAG, "printEnabledAccessibilityServiceInfo error : %s", new Object[] { paramAccessibilityManager.getMessage() });
      AppMethodBeat.o(244027);
      return;
    }
  }
  
  private static void recoverAccessibilityEnable(AccessibilityManager paramAccessibilityManager, boolean paramBoolean)
  {
    AppMethodBeat.i(244019);
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
      finally
      {
        Method localMethod;
        Log.e(TAG, "recoverAccessibilityEnable error : %s", new Object[] { paramAccessibilityManager.getMessage() });
        AppMethodBeat.o(244019);
        return;
      }
      localMethod.invoke(paramAccessibilityManager, new Object[] { Integer.valueOf(j) });
      Log.i(TAG, "recoverAccessibilityEnable setStateLocked is invoked, flag = %d", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(244019);
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
    AppMethodBeat.i(244010);
    for (;;)
    {
      try
      {
        Log.i(TAG, "smartDisableAccessibility");
        AccessibilityManager localAccessibilityManager = (AccessibilityManager)MMApplicationContext.getContext().getSystemService("accessibility");
        boolean bool1 = localAccessibilityManager.isEnabled();
        Object localObject2 = AccessibilityManager.class.getDeclaredField("mIsHighTextContrastEnabled");
        ((Field)localObject2).setAccessible(true);
        boolean bool2 = ((Boolean)((Field)localObject2).get(localAccessibilityManager)).booleanValue();
        if (!bool1) {
          recoverAccessibilityEnable(localAccessibilityManager, bool2);
        }
        if ((WeChatEnvironment.isCoolassistEnv()) || (BuildInfo.IS_FLAVOR_RED))
        {
          Log.i(TAG, "isCoolassistEnv or flavor red, return");
          AppMethodBeat.o(244010);
          return;
        }
        localObject2 = localAccessibilityManager.getEnabledAccessibilityServiceList(1).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          AccessibilityServiceInfo localAccessibilityServiceInfo = (AccessibilityServiceInfo)((Iterator)localObject2).next();
          if (spokenServiceBlackSet.contains(localAccessibilityServiceInfo.getId())) {
            continue;
          }
          Log.i(TAG, "has spoken service, return");
          printEnabledAccessibilityServiceInfo(localAccessibilityManager);
          AppMethodBeat.o(244010);
          return;
        }
        if (localAccessibilityManager.isTouchExplorationEnabled())
        {
          Log.i(TAG, "isTouchExplorationEnabled is true, return");
          AppMethodBeat.o(244010);
          return;
        }
        Log.i(TAG, "disableAccessibility");
        localObject2 = AccessibilityManager.class.getDeclaredMethod("setStateLocked", new Class[] { Integer.TYPE });
        ((Method)localObject2).setAccessible(true);
        if (bool2)
        {
          i = 4;
          ((Method)localObject2).invoke(localAccessibilityManager, new Object[] { Integer.valueOf(i) });
          Log.i(TAG, "smartDisableAccessibility setStateLocked is invoked, flag = %d", new Object[] { Integer.valueOf(i) });
          h.ahAA.bm(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(243822);
              AccessibilityUtil.access$000(AccessibilityUtil.this);
              AppMethodBeat.o(243822);
            }
          });
          AppMethodBeat.o(244010);
          return;
        }
      }
      finally
      {
        Log.w(TAG, "disableAccessibility exception -> " + localObject1.getMessage());
        AppMethodBeat.o(244010);
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