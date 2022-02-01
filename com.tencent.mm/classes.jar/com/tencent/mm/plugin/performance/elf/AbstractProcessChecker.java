package com.tencent.mm.plugin.performance.elf;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractProcessChecker
  extends BroadcastReceiver
{
  private MMHandler AUg;
  a AUh = new a((byte)0);
  private long AUi = -1L;
  boolean cQp = true;
  
  public AbstractProcessChecker()
  {
    ((Application)MMApplicationContext.getContext()).registerActivityLifecycleCallbacks(this.AUh);
    if (ElfCallUpReceiver.AUm > 0)
    {
      hJ(Process.myPid(), ElfCallUpReceiver.AUm);
      return;
    }
    Log.w(getTag(), "not processElf call up!");
  }
  
  protected static long Sr()
  {
    String str = String.format("/proc/%s/schedstat", new Object[] { Integer.valueOf(Process.myPid()) });
    try
    {
      str = getStringFromFile(str);
      if (str == null) {
        return -1L;
      }
      long l = Util.safeParseLong(str.replaceAll("\n", "").split(" ")[2]);
      return l;
    }
    catch (Exception localException) {}
    return -2L;
  }
  
  public static long TN()
  {
    Matcher localMatcher = Pattern.compile("\\d+").matcher(eCs());
    if (localMatcher.find()) {
      return Util.safeParseInt(localMatcher.group()) * 1000L;
    }
    return -1L;
  }
  
  protected static int aD(Map<String, Integer> paramMap)
  {
    Object localObject = Looper.getMainLooper().getThread().getThreadGroup();
    Thread[] arrayOfThread = new Thread[((ThreadGroup)localObject).activeCount() * 2];
    int k = ((ThreadGroup)localObject).enumerate(arrayOfThread);
    int j = 0;
    int i = 0;
    if (j < k)
    {
      localObject = arrayOfThread[j].getName();
      if (Util.isNullOrNil((String)localObject)) {
        break label136;
      }
      localObject = ((String)localObject).replaceAll("-?[0-9]\\d*", "?");
      if (paramMap.containsKey(localObject))
      {
        paramMap.put(localObject, Integer.valueOf(((Integer)paramMap.get(localObject)).intValue() + 1));
        label107:
        i += 1;
      }
    }
    label136:
    for (;;)
    {
      j += 1;
      break;
      paramMap.put(localObject, Integer.valueOf(1));
      break label107;
      return i;
    }
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      try
      {
        for (;;)
        {
          paramInputStream = localBufferedReader.readLine();
          if (paramInputStream == null) {
            break;
          }
          localStringBuilder.append(paramInputStream).append('\n');
        }
        if (localBufferedReader == null) {
          break label56;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        BufferedReader localBufferedReader = null;
      }
    }
    localBufferedReader.close();
    label56:
    throw paramInputStream;
    localBufferedReader.close();
    return localStringBuilder.toString();
  }
  
  private static String eCs()
  {
    Object localObject = String.format("/proc/%s/status", new Object[] { Integer.valueOf(Process.myPid()) });
    for (;;)
    {
      int i;
      try
      {
        localObject = getStringFromFile((String)localObject).trim().split("\n");
        int j = localObject.length;
        i = 0;
        if (i < j)
        {
          String str = localObject[i];
          if (str.startsWith("VmSize")) {
            return str;
          }
        }
        else
        {
          localObject = localObject[12];
          return localObject;
        }
      }
      catch (Exception localException)
      {
        return "";
      }
      i += 1;
    }
  }
  
  public static String getProcessName()
  {
    return MMApplicationContext.getProcessName();
  }
  
  private static String getStringFromFile(String paramString)
  {
    Object localObject1 = new o(paramString);
    paramString = null;
    try
    {
      localObject1 = s.ao((o)localObject1);
      paramString = (String)localObject1;
      String str = convertStreamToString((InputStream)localObject1);
      if (localObject1 != null) {
        ((InputStream)localObject1).close();
      }
      return str;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
    }
  }
  
  private void sD(boolean paramBoolean)
  {
    ElfCheckResponse localElfCheckResponse = new ElfCheckResponse(isEnable(), eCr(), paramBoolean, eCo(), MMApplicationContext.getProcessName(), ElfCallUpReceiver.class.getName());
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("processId", Process.myPid());
    localElfCheckResponse.Ew = ((Bundle)localObject);
    localObject = new Intent("ACTION_ELF_CHECK_RESPONSE");
    ((Intent)localObject).putExtra("MicroMsg.ElfCheckResponse", localElfCheckResponse);
    MMApplicationContext.getContext().sendBroadcast((Intent)localObject);
  }
  
  protected abstract boolean af(long paramLong1, long paramLong2);
  
  public void cy(boolean paramBoolean)
  {
    this.cQp = paramBoolean;
  }
  
  protected boolean eCo()
  {
    return true;
  }
  
  protected final void eCp()
  {
    if ((!this.cQp) && (!this.AUh.isResume))
    {
      sD(true);
      throw new RuntimeException(eCq());
    }
    Log.w("MicroMsg.AbstractProcessChecker", "pass this kill! app is on foreground!");
    e.Cxv.idkeyStat(959L, 6L, 1L, true);
    sD(false);
  }
  
  protected String eCq()
  {
    return String.format("ProcessEfl found exception!kill process[%s] %s %s %s", new Object[] { Integer.valueOf(Process.myPid()), Long.valueOf(TN()), Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Runtime.getRuntime().totalMemory()) });
  }
  
  protected abstract long eCr();
  
  protected final boolean eCt()
  {
    Object localObject = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
    if (localObject == null)
    {
      Log.e("MicroMsg.AbstractProcessChecker", "[isHighPriorityProcess] mActivityManager is null.");
      return false;
    }
    localObject = ((ActivityManager)localObject).getRunningServices(50);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)((Iterator)localObject).next();
        if (localRunningServiceInfo.foreground)
        {
          Log.i(getTag(), "foreground service:%s process:%s ", new Object[] { localRunningServiceInfo.service, localRunningServiceInfo.process });
          return true;
        }
      }
    }
    return false;
  }
  
  protected String getTag()
  {
    return "AbstractProcessChecker";
  }
  
  protected final MMHandler getWorkerHandler()
  {
    if ((this.AUg == null) || (this.AUg.isQuit())) {
      this.AUg = new MMHandler("ProcessChecker");
    }
    return this.AUg;
  }
  
  protected void hJ(int paramInt1, int paramInt2) {}
  
  protected abstract boolean isEnable();
  
  public final void onReceive(Context paramContext, final Intent paramIntent)
  {
    if (paramIntent.getAction() == "ACTION_ELF_CHECK") {
      getWorkerHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124968);
          if ("ACTION_ELF_CHECK".equals(paramIntent.getAction()))
          {
            ElfCheckRequest localElfCheckRequest = (ElfCheckRequest)paramIntent.getParcelableExtra("MicroMsg.ElfCheckRequest");
            if (localElfCheckRequest == null)
            {
              Log.w("MicroMsg.AbstractProcessChecker", "pass this check,because request is null! ????");
              AppMethodBeat.o(124968);
              return;
            }
            boolean bool = AbstractProcessChecker.this.af(Process.myPid(), localElfCheckRequest.dap);
            Log.i("MicroMsg.AbstractProcessChecker", "[onReceive] begin to check process[%s] isCanKill:%s isNeedReCall:%s", new Object[] { AbstractProcessChecker.getProcessName(), Boolean.valueOf(bool), Boolean.valueOf(AbstractProcessChecker.this.eCo()) });
            if (bool)
            {
              AbstractProcessChecker.this.eCp();
              AppMethodBeat.o(124968);
              return;
            }
            AbstractProcessChecker.a(AbstractProcessChecker.this);
          }
          AppMethodBeat.o(124968);
        }
      });
    }
    while (paramIntent.getAction() != "android.intent.action.SCREEN_OFF") {
      return;
    }
    onScreenOff();
  }
  
  protected abstract void onScreenOff();
  
  protected void start()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("ACTION_ELF_CHECK");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    MMApplicationContext.getContext().registerReceiver(this, localIntentFilter);
  }
  
  final class a
    implements Application.ActivityLifecycleCallbacks
  {
    String AUk = "";
    boolean AUl = false;
    boolean isResume = true;
    
    private a() {}
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(124969);
      if (paramActivity.getClass().getSimpleName().endsWith("WeChatSplashActivity"))
      {
        this.AUl = true;
        Log.i(AbstractProcessChecker.this.getTag(), "WeChatSplashActivity was created!");
      }
      AppMethodBeat.o(124969);
    }
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity)
    {
      AppMethodBeat.i(124971);
      if (Util.isNullOrNil(this.AUk)) {
        this.AUk = paramActivity.getClass().getName();
      }
      AppMethodBeat.o(124971);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(124970);
      this.AUk = paramActivity.getClass().getName();
      this.isResume = true;
      AppMethodBeat.o(124970);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity) {}
    
    public final void onActivityStopped(Activity paramActivity)
    {
      AppMethodBeat.i(124972);
      if (Util.isNullOrNil(this.AUk)) {
        this.AUk = paramActivity.getClass().getName();
      }
      this.isResume = false;
      AppMethodBeat.o(124972);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.AbstractProcessChecker
 * JD-Core Version:    0.7.0.1
 */