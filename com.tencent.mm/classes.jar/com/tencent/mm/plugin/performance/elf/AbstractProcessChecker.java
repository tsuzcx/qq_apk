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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
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
  boolean cCq = true;
  private aq wXi;
  a wXj = new a((byte)0);
  private long wXk = -1L;
  
  public AbstractProcessChecker()
  {
    ((Application)ak.getContext()).registerActivityLifecycleCallbacks(this.wXj);
    if (ElfCallUpReceiver.wXo > 0)
    {
      gY(Process.myPid(), ElfCallUpReceiver.wXo);
      return;
    }
    ae.w(getTag(), "not processElf call up!");
  }
  
  public static long Jz()
  {
    Matcher localMatcher = Pattern.compile("\\d+").matcher(dCd());
    if (localMatcher.find()) {
      return bu.aSB(localMatcher.group()) * 1000L;
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
      if (bu.isNullOrNil((String)localObject)) {
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
  
  private static String dCd()
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
  
  protected static long dCe()
  {
    String str = String.format("/proc/%s/schedstat", new Object[] { Integer.valueOf(Process.myPid()) });
    try
    {
      str = getStringFromFile(str);
      if (str == null) {
        return -1L;
      }
      long l = bu.aSC(str.replaceAll("\n", "").split(" ")[2]);
      return l;
    }
    catch (Exception localException) {}
    return -2L;
  }
  
  public static String getProcessName()
  {
    return ak.getProcessName();
  }
  
  private static String getStringFromFile(String paramString)
  {
    Object localObject1 = new k(paramString);
    paramString = null;
    try
    {
      localObject1 = o.ai((k)localObject1);
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
  
  private void pv(boolean paramBoolean)
  {
    ElfCheckResponse localElfCheckResponse = new ElfCheckResponse(isEnable(), dCc(), paramBoolean, dBZ(), ak.getProcessName(), ElfCallUpReceiver.class.getName());
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("processId", Process.myPid());
    localElfCheckResponse.En = ((Bundle)localObject);
    localObject = new Intent("ACTION_ELF_CHECK_RESPONSE");
    ((Intent)localObject).putExtra("MicroMsg.ElfCheckResponse", localElfCheckResponse);
    ak.getContext().sendBroadcast((Intent)localObject);
  }
  
  protected abstract boolean ab(long paramLong1, long paramLong2);
  
  public void bV(boolean paramBoolean)
  {
    this.cCq = paramBoolean;
  }
  
  protected final aq cZF()
  {
    if ((this.wXi == null) || (this.wXi.isQuit())) {
      this.wXi = new aq("ProcessChecker");
    }
    return this.wXi;
  }
  
  protected boolean dBZ()
  {
    return true;
  }
  
  protected final void dCa()
  {
    if ((!this.cCq) && (!this.wXj.isResume))
    {
      pv(true);
      throw new RuntimeException(dCb());
    }
    ae.w("MicroMsg.AbstractProcessChecker", "pass this kill! app is on foreground!");
    e.ywz.idkeyStat(959L, 6L, 1L, true);
    pv(false);
  }
  
  protected String dCb()
  {
    return String.format("ProcessEfl found exception!kill process[%s] %s %s %s", new Object[] { Integer.valueOf(Process.myPid()), Long.valueOf(Jz()), Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Runtime.getRuntime().totalMemory()) });
  }
  
  protected abstract long dCc();
  
  protected final boolean dCf()
  {
    Object localObject = (ActivityManager)ak.getContext().getSystemService("activity");
    if (localObject == null)
    {
      ae.e("MicroMsg.AbstractProcessChecker", "[isHighPriorityProcess] mActivityManager is null.");
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
          ae.i(getTag(), "foreground service:%s process:%s ", new Object[] { localRunningServiceInfo.service, localRunningServiceInfo.process });
          return true;
        }
      }
    }
    return false;
  }
  
  protected void gY(int paramInt1, int paramInt2) {}
  
  protected String getTag()
  {
    return "AbstractProcessChecker";
  }
  
  protected abstract boolean isEnable();
  
  public final void onReceive(Context paramContext, final Intent paramIntent)
  {
    if (paramIntent.getAction() == "ACTION_ELF_CHECK") {
      cZF().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124968);
          if ("ACTION_ELF_CHECK".equals(paramIntent.getAction()))
          {
            ElfCheckRequest localElfCheckRequest = (ElfCheckRequest)paramIntent.getParcelableExtra("MicroMsg.ElfCheckRequest");
            if (localElfCheckRequest == null)
            {
              ae.w("MicroMsg.AbstractProcessChecker", "pass this check,because request is null! ????");
              AppMethodBeat.o(124968);
              return;
            }
            boolean bool = AbstractProcessChecker.this.ab(Process.myPid(), localElfCheckRequest.cJR);
            ae.i("MicroMsg.AbstractProcessChecker", "[onReceive] begin to check process[%s] isCanKill:%s isNeedReCall:%s", new Object[] { AbstractProcessChecker.getProcessName(), Boolean.valueOf(bool), Boolean.valueOf(AbstractProcessChecker.this.dBZ()) });
            if (bool)
            {
              AbstractProcessChecker.this.dCa();
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
    ak.getContext().registerReceiver(this, localIntentFilter);
  }
  
  final class a
    implements Application.ActivityLifecycleCallbacks
  {
    boolean isResume = true;
    String wXm = "";
    boolean wXn = false;
    
    private a() {}
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(124969);
      if (paramActivity.getClass().getSimpleName().endsWith("WeChatSplashActivity"))
      {
        this.wXn = true;
        ae.i(AbstractProcessChecker.this.getTag(), "WeChatSplashActivity was created!");
      }
      AppMethodBeat.o(124969);
    }
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity)
    {
      AppMethodBeat.i(124971);
      if (bu.isNullOrNil(this.wXm)) {
        this.wXm = paramActivity.getClass().getName();
      }
      AppMethodBeat.o(124971);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(124970);
      this.wXm = paramActivity.getClass().getName();
      this.isResume = true;
      AppMethodBeat.o(124970);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity) {}
    
    public final void onActivityStopped(Activity paramActivity)
    {
      AppMethodBeat.i(124972);
      if (bu.isNullOrNil(this.wXm)) {
        this.wXm = paramActivity.getClass().getName();
      }
      this.isResume = false;
      AppMethodBeat.o(124972);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.AbstractProcessChecker
 * JD-Core Version:    0.7.0.1
 */