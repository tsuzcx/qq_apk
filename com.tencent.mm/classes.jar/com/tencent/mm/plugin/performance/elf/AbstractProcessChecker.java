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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
  private MMHandler MKQ;
  a MKR = new a((byte)0);
  private long MKS = -1L;
  boolean ffv = true;
  
  public AbstractProcessChecker()
  {
    ((Application)MMApplicationContext.getContext()).registerActivityLifecycleCallbacks(this.MKR);
    if (ElfCallUpReceiver.MKW > 0)
    {
      ku(Process.myPid(), ElfCallUpReceiver.MKW);
      return;
    }
    Log.w(getTag(), "not processElf call up!");
  }
  
  private void Ap(boolean paramBoolean)
  {
    ElfCheckResponse localElfCheckResponse = new ElfCheckResponse(isEnable(), gyW(), paramBoolean, gyT(), MMApplicationContext.getProcessName(), ElfCallUpReceiver.class.getName());
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("processId", Process.myPid());
    localElfCheckResponse.EHy = ((Bundle)localObject);
    localObject = new Intent("ACTION_ELF_CHECK_RESPONSE");
    ((Intent)localObject).putExtra("MicroMsg.ElfCheckResponse", localElfCheckResponse);
    MMApplicationContext.getContext().sendBroadcast((Intent)localObject);
  }
  
  public static long aAm()
  {
    Matcher localMatcher = Pattern.compile("\\d+").matcher(gyX());
    if (localMatcher.find()) {
      return Util.safeParseInt(localMatcher.group()) * 1000L;
    }
    return -1L;
  }
  
  protected static int aN(Map<String, Integer> paramMap)
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
  
  protected static long axC()
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
    return MMApplicationContext.getProcessName();
  }
  
  private static String getStringFromFile(String paramString)
  {
    Object localObject1 = new u(paramString);
    paramString = null;
    try
    {
      localObject1 = y.ao((u)localObject1);
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
  
  private static String gyX()
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
  
  protected abstract boolean aX(long paramLong1, long paramLong2);
  
  public void du(boolean paramBoolean)
  {
    this.ffv = paramBoolean;
  }
  
  protected String getTag()
  {
    return "AbstractProcessChecker";
  }
  
  protected final MMHandler getWorkerHandler()
  {
    if ((this.MKQ == null) || (this.MKQ.isQuit())) {
      this.MKQ = new MMHandler("ProcessChecker");
    }
    return this.MKQ;
  }
  
  protected boolean gyT()
  {
    return true;
  }
  
  /* Error */
  protected final void gyU()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	com/tencent/mm/plugin/performance/elf/AbstractProcessChecker:ffv	Z
    //   4: ifne +142 -> 146
    //   7: aload_0
    //   8: getfield 26	com/tencent/mm/plugin/performance/elf/AbstractProcessChecker:MKR	Lcom/tencent/mm/plugin/performance/elf/AbstractProcessChecker$a;
    //   11: getfield 342	com/tencent/mm/plugin/performance/elf/AbstractProcessChecker$a:isResume	Z
    //   14: ifne +132 -> 146
    //   17: aload_0
    //   18: iconst_1
    //   19: invokespecial 134	com/tencent/mm/plugin/performance/elf/AbstractProcessChecker:Ap	(Z)V
    //   22: ldc_w 344
    //   25: ldc_w 346
    //   28: invokestatic 349	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: new 271	java/io/BufferedReader
    //   34: dup
    //   35: new 351	java/io/FileReader
    //   38: dup
    //   39: new 268	java/lang/StringBuilder
    //   42: dup
    //   43: ldc_w 353
    //   46: invokespecial 354	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: invokestatic 56	android/os/Process:myPid	()I
    //   52: invokevirtual 357	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: ldc_w 359
    //   58: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 360	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   67: sipush 1024
    //   70: invokespecial 363	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   73: astore_1
    //   74: aload_1
    //   75: invokevirtual 282	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   78: astore_2
    //   79: aload_2
    //   80: ifnull +50 -> 130
    //   83: ldc_w 344
    //   86: aload_2
    //   87: invokestatic 349	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: goto -16 -> 74
    //   93: astore_2
    //   94: aload_1
    //   95: invokevirtual 292	java/io/BufferedReader:close	()V
    //   98: aload_2
    //   99: athrow
    //   100: astore_1
    //   101: ldc_w 344
    //   104: aload_1
    //   105: ldc_w 365
    //   108: iconst_0
    //   109: anewarray 240	java/lang/Object
    //   112: invokestatic 369	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: invokestatic 372	com/tencent/mm/sdk/platformtools/Log:appenderFlush	()V
    //   118: new 374	java/lang/RuntimeException
    //   121: dup
    //   122: aload_0
    //   123: invokevirtual 377	com/tencent/mm/plugin/performance/elf/AbstractProcessChecker:gyV	()Ljava/lang/String;
    //   126: invokespecial 378	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   129: athrow
    //   130: aload_1
    //   131: invokevirtual 292	java/io/BufferedReader:close	()V
    //   134: goto -19 -> 115
    //   137: astore_1
    //   138: aload_2
    //   139: aload_1
    //   140: invokevirtual 384	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   143: goto -45 -> 98
    //   146: ldc_w 344
    //   149: ldc_w 386
    //   152: invokestatic 72	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: getstatic 392	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   158: ldc2_w 393
    //   161: ldc2_w 395
    //   164: lconst_1
    //   165: iconst_1
    //   166: invokevirtual 400	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   169: aload_0
    //   170: iconst_0
    //   171: invokespecial 134	com/tencent/mm/plugin/performance/elf/AbstractProcessChecker:Ap	(Z)V
    //   174: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	AbstractProcessChecker
    //   73	22	1	localBufferedReader	BufferedReader
    //   100	31	1	localIOException	java.io.IOException
    //   137	3	1	localThrowable	java.lang.Throwable
    //   78	9	2	str	String
    //   93	46	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   74	79	93	finally
    //   83	90	93	finally
    //   31	74	100	java/io/IOException
    //   98	100	100	java/io/IOException
    //   130	134	100	java/io/IOException
    //   138	143	100	java/io/IOException
    //   94	98	137	finally
  }
  
  protected String gyV()
  {
    return String.format("ProcessEfl found exception!kill process[%s] %s %s %s", new Object[] { Integer.valueOf(Process.myPid()), Long.valueOf(aAm()), Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Runtime.getRuntime().totalMemory()) });
  }
  
  protected abstract long gyW();
  
  protected final boolean gyY()
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
  
  protected abstract boolean isEnable();
  
  protected void ku(int paramInt1, int paramInt2) {}
  
  public final void onReceive(Context paramContext, final Intent paramIntent)
  {
    if ("ACTION_ELF_CHECK".equals(paramIntent.getAction())) {
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
            boolean bool = AbstractProcessChecker.this.aX(Process.myPid(), localElfCheckRequest.LIF);
            Log.i("MicroMsg.AbstractProcessChecker", "[onReceive] begin to check process[%s] isCanKill:%s isNeedReCall:%s", new Object[] { AbstractProcessChecker.getProcessName(), Boolean.valueOf(bool), Boolean.valueOf(AbstractProcessChecker.this.gyT()) });
            if (bool)
            {
              AbstractProcessChecker.this.gyU();
              AppMethodBeat.o(124968);
              return;
            }
            AbstractProcessChecker.a(AbstractProcessChecker.this);
          }
          AppMethodBeat.o(124968);
        }
      });
    }
    do
    {
      return;
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
      {
        onScreenOff();
        return;
      }
    } while (!"android.intent.action.SCREEN_ON".equals(paramIntent.getAction()));
    onScreenOn();
  }
  
  protected abstract void onScreenOff();
  
  protected abstract void onScreenOn();
  
  protected void start()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("ACTION_ELF_CHECK");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    MMApplicationContext.getContext().registerReceiver(this, localIntentFilter);
  }
  
  final class a
    implements Application.ActivityLifecycleCallbacks
  {
    String MKU = "";
    boolean MKV = false;
    boolean isResume = true;
    
    private a() {}
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(124969);
      if (paramActivity.getClass().getSimpleName().endsWith("WeChatSplashActivity"))
      {
        this.MKV = true;
        Log.i(AbstractProcessChecker.this.getTag(), "WeChatSplashActivity was created!");
      }
      AppMethodBeat.o(124969);
    }
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity)
    {
      AppMethodBeat.i(124971);
      if (Util.isNullOrNil(this.MKU)) {
        this.MKU = paramActivity.getClass().getName();
      }
      AppMethodBeat.o(124971);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(124970);
      this.MKU = paramActivity.getClass().getName();
      this.isResume = true;
      AppMethodBeat.o(124970);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity) {}
    
    public final void onActivityStopped(Activity paramActivity)
    {
      AppMethodBeat.i(124972);
      if (Util.isNullOrNil(this.MKU)) {
        this.MKU = paramActivity.getClass().getName();
      }
      this.isResume = false;
      AppMethodBeat.o(124972);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.AbstractProcessChecker
 * JD-Core Version:    0.7.0.1
 */