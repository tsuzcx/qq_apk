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
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
  private static HandlerThread psj;
  boolean bSe = true;
  private ak psk;
  a psl = new a((byte)0);
  private long psm = -1L;
  
  public AbstractProcessChecker()
  {
    ((Application)ah.getContext()).registerActivityLifecycleCallbacks(this.psl);
    if (ElfCallUpReceiver.psq > 0)
    {
      fd(Process.myPid(), ElfCallUpReceiver.psq);
      return;
    }
    ab.w(getTag(), "not processElf call up!");
  }
  
  protected static int U(Map<String, Integer> paramMap)
  {
    Object localObject = Looper.getMainLooper().getThread().getThreadGroup();
    Thread[] arrayOfThread = new Thread[((ThreadGroup)localObject).activeCount() * 2];
    int k = ((ThreadGroup)localObject).enumerate(arrayOfThread);
    int j = 0;
    int i = 0;
    if (j < k)
    {
      localObject = arrayOfThread[j].getName();
      if (bo.isNullOrNil((String)localObject)) {
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
  
  private static String caF()
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
  
  protected static long caG()
  {
    String str = String.format("/proc/%s/schedstat", new Object[] { Integer.valueOf(Process.myPid()) });
    try
    {
      str = getStringFromFile(str);
      if (str == null) {
        return -1L;
      }
      long l = bo.apW(str.replaceAll("\n", "").split(" ")[2]);
      return l;
    }
    catch (Exception localException) {}
    return -2L;
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
  
  public static String getProcessName()
  {
    return ah.getProcessName();
  }
  
  private static String getStringFromFile(String paramString)
  {
    paramString = new File(paramString);
    FileInputStream localFileInputStream;
    try
    {
      localFileInputStream = new FileInputStream(paramString);
      if (localFileInputStream == null) {
        break label40;
      }
    }
    finally
    {
      try
      {
        paramString = convertStreamToString(localFileInputStream);
        localFileInputStream.close();
        return paramString;
      }
      finally {}
      paramString = finally;
      localFileInputStream = null;
    }
    localFileInputStream.close();
    label40:
    throw paramString;
  }
  
  private void jZ(boolean paramBoolean)
  {
    ElfCheckResponse localElfCheckResponse = new ElfCheckResponse(isEnable(), caE(), paramBoolean, caA(), ah.getProcessName(), ElfCallUpReceiver.class.getName());
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("processId", Process.myPid());
    localElfCheckResponse.wP = ((Bundle)localObject);
    localObject = new Intent("ACTION_ELF_CHECK_RESPONSE");
    ((Intent)localObject).putExtra("MicroMsg.ElfCheckResponse", localElfCheckResponse);
    ah.getContext().sendBroadcast((Intent)localObject);
  }
  
  public static long zG()
  {
    Matcher localMatcher = Pattern.compile("\\d+").matcher(caF());
    if (localMatcher.find()) {
      return bo.apV(localMatcher.group());
    }
    return -1L;
  }
  
  protected abstract boolean S(long paramLong1, long paramLong2);
  
  protected abstract void awv();
  
  protected boolean caA()
  {
    return true;
  }
  
  protected final ak caB()
  {
    if ((this.psk == null) || (!this.psk.getLooper().getThread().isAlive()))
    {
      HandlerThread localHandlerThread = d.aqu("ProcessChecker");
      psj = localHandlerThread;
      localHandlerThread.start();
      this.psk = new ak(psj.getLooper());
    }
    return this.psk;
  }
  
  protected final void caC()
  {
    if ((!this.bSe) && (!this.psl.isResume))
    {
      jZ(true);
      throw new RuntimeException(caD());
    }
    ab.w("MicroMsg.AbstractProcessChecker", "pass this kill! app is on foreground!");
    e.qrI.idkeyStat(959L, 6L, 1L, true);
    jZ(false);
  }
  
  protected String caD()
  {
    return String.format("ProcessEfl found exception!kill process[%s] %s %s %s", new Object[] { Integer.valueOf(Process.myPid()), Long.valueOf(zG()), Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Runtime.getRuntime().totalMemory()) });
  }
  
  protected abstract long caE();
  
  protected final boolean caH()
  {
    Iterator localIterator = ((ActivityManager)ah.getContext().getSystemService("activity")).getRunningServices(50).iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)localIterator.next();
      if (localRunningServiceInfo.foreground)
      {
        ab.i(getTag(), "foreground service:%s process:%s ", new Object[] { localRunningServiceInfo.service, localRunningServiceInfo.process });
        return true;
      }
    }
    return false;
  }
  
  protected void fd(int paramInt1, int paramInt2) {}
  
  protected String getTag()
  {
    return "AbstractProcessChecker";
  }
  
  protected abstract boolean isEnable();
  
  public void jY(boolean paramBoolean)
  {
    this.bSe = paramBoolean;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == "ACTION_ELF_CHECK") {
      caB().post(new AbstractProcessChecker.1(this, paramIntent));
    }
    while (paramIntent.getAction() != "android.intent.action.SCREEN_OFF") {
      return;
    }
    awv();
  }
  
  protected void start()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("ACTION_ELF_CHECK");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    ah.getContext().registerReceiver(this, localIntentFilter);
  }
  
  final class a
    implements Application.ActivityLifecycleCallbacks
  {
    boolean isResume = true;
    String pso = "";
    boolean psp = false;
    
    private a() {}
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(111042);
      if (paramActivity.getClass().getSimpleName().endsWith("WeChatSplashActivity"))
      {
        this.psp = true;
        ab.i(AbstractProcessChecker.this.getTag(), "WeChatSplashActivity was created!");
      }
      AppMethodBeat.o(111042);
    }
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity)
    {
      AppMethodBeat.i(111044);
      if (bo.isNullOrNil(this.pso)) {
        this.pso = paramActivity.getClass().getName();
      }
      AppMethodBeat.o(111044);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(111043);
      this.pso = paramActivity.getClass().getName();
      this.isResume = true;
      AppMethodBeat.o(111043);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity) {}
    
    public final void onActivityStopped(Activity paramActivity)
    {
      AppMethodBeat.i(111045);
      if (bo.isNullOrNil(this.pso)) {
        this.pso = paramActivity.getClass().getName();
      }
      this.isResume = false;
      AppMethodBeat.o(111045);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.AbstractProcessChecker
 * JD-Core Version:    0.7.0.1
 */