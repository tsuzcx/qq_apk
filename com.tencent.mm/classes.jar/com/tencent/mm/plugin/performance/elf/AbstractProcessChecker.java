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
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
  private MMHandler GNB;
  a GNC = new a((byte)0);
  private long GND = -1L;
  private boolean dgo = true;
  
  public AbstractProcessChecker()
  {
    ((Application)MMApplicationContext.getContext()).registerActivityLifecycleCallbacks(this.GNC);
    if (ElfCallUpReceiver.GNH > 0)
    {
      iO(Process.myPid(), ElfCallUpReceiver.GNH);
      return;
    }
    Log.w(getTag(), "not processElf call up!");
  }
  
  protected static long WF()
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
  
  public static long Yr()
  {
    Matcher localMatcher = Pattern.compile("\\d+").matcher(foc());
    if (localMatcher.find()) {
      return Util.safeParseInt(localMatcher.group()) * 1000L;
    }
    return -1L;
  }
  
  protected static int ax(Map<String, Integer> paramMap)
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
  
  private static String foc()
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
    Object localObject1 = new q(paramString);
    paramString = null;
    try
    {
      localObject1 = u.al((q)localObject1);
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
  
  private void vT(boolean paramBoolean)
  {
    ElfCheckResponse localElfCheckResponse = new ElfCheckResponse(isEnable(), fob(), paramBoolean, fnY(), MMApplicationContext.getProcessName(), ElfCallUpReceiver.class.getName());
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("processId", Process.myPid());
    localElfCheckResponse.zDr = ((Bundle)localObject);
    localObject = new Intent("ACTION_ELF_CHECK_RESPONSE");
    ((Intent)localObject).putExtra("MicroMsg.ElfCheckResponse", localElfCheckResponse);
    MMApplicationContext.getContext().sendBroadcast((Intent)localObject);
  }
  
  protected final boolean aax()
  {
    return this.dgo;
  }
  
  protected abstract boolean an(long paramLong1, long paramLong2);
  
  public void cN(boolean paramBoolean)
  {
    this.dgo = paramBoolean;
  }
  
  protected boolean fnY()
  {
    return true;
  }
  
  /* Error */
  protected final void fnZ()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	com/tencent/mm/plugin/performance/elf/AbstractProcessChecker:dgo	Z
    //   4: ifne +158 -> 162
    //   7: aload_0
    //   8: getfield 26	com/tencent/mm/plugin/performance/elf/AbstractProcessChecker:GNC	Lcom/tencent/mm/plugin/performance/elf/AbstractProcessChecker$a;
    //   11: getfield 331	com/tencent/mm/plugin/performance/elf/AbstractProcessChecker$a:isResume	Z
    //   14: ifne +148 -> 162
    //   17: aload_0
    //   18: iconst_1
    //   19: invokespecial 155	com/tencent/mm/plugin/performance/elf/AbstractProcessChecker:vT	(Z)V
    //   22: ldc_w 333
    //   25: ldc_w 335
    //   28: invokestatic 338	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: new 219	java/io/BufferedReader
    //   34: dup
    //   35: new 340	java/io/FileReader
    //   38: dup
    //   39: new 216	java/lang/StringBuilder
    //   42: dup
    //   43: ldc_w 342
    //   46: invokespecial 343	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: invokestatic 56	android/os/Process:myPid	()I
    //   52: invokevirtual 346	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: ldc_w 348
    //   58: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 349	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   67: sipush 1024
    //   70: invokespecial 352	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   73: astore_3
    //   74: aconst_null
    //   75: astore_2
    //   76: aload_3
    //   77: invokevirtual 230	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +57 -> 139
    //   85: ldc_w 333
    //   88: aload_1
    //   89: invokestatic 338	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: goto -16 -> 76
    //   95: astore_2
    //   96: aload_2
    //   97: athrow
    //   98: astore_1
    //   99: aload_2
    //   100: ifnull +55 -> 155
    //   103: aload_3
    //   104: invokevirtual 240	java/io/BufferedReader:close	()V
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: ldc_w 333
    //   113: aload_1
    //   114: ldc_w 354
    //   117: iconst_0
    //   118: anewarray 81	java/lang/Object
    //   121: invokestatic 358	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: invokestatic 361	com/tencent/mm/sdk/platformtools/Log:appenderFlush	()V
    //   127: new 363	java/lang/RuntimeException
    //   130: dup
    //   131: aload_0
    //   132: invokevirtual 366	com/tencent/mm/plugin/performance/elf/AbstractProcessChecker:foa	()Ljava/lang/String;
    //   135: invokespecial 367	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   138: athrow
    //   139: aload_3
    //   140: invokevirtual 240	java/io/BufferedReader:close	()V
    //   143: goto -19 -> 124
    //   146: astore_3
    //   147: aload_2
    //   148: aload_3
    //   149: invokevirtual 371	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   152: goto -45 -> 107
    //   155: aload_3
    //   156: invokevirtual 240	java/io/BufferedReader:close	()V
    //   159: goto -52 -> 107
    //   162: ldc_w 333
    //   165: ldc_w 373
    //   168: invokestatic 72	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: getstatic 379	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   174: ldc2_w 380
    //   177: ldc2_w 382
    //   180: lconst_1
    //   181: iconst_1
    //   182: invokevirtual 387	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   185: aload_0
    //   186: iconst_0
    //   187: invokespecial 155	com/tencent/mm/plugin/performance/elf/AbstractProcessChecker:vT	(Z)V
    //   190: return
    //   191: astore_1
    //   192: goto -93 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	AbstractProcessChecker
    //   80	9	1	str	String
    //   98	10	1	localObject1	Object
    //   109	5	1	localIOException	java.io.IOException
    //   191	1	1	localObject2	Object
    //   75	1	2	localObject3	Object
    //   95	53	2	localThrowable1	java.lang.Throwable
    //   73	67	3	localBufferedReader	BufferedReader
    //   146	10	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   76	81	95	java/lang/Throwable
    //   85	92	95	java/lang/Throwable
    //   96	98	98	finally
    //   31	74	109	java/io/IOException
    //   103	107	109	java/io/IOException
    //   107	109	109	java/io/IOException
    //   139	143	109	java/io/IOException
    //   147	152	109	java/io/IOException
    //   155	159	109	java/io/IOException
    //   103	107	146	java/lang/Throwable
    //   76	81	191	finally
    //   85	92	191	finally
  }
  
  protected String foa()
  {
    return String.format("ProcessEfl found exception!kill process[%s] %s %s %s", new Object[] { Integer.valueOf(Process.myPid()), Long.valueOf(Yr()), Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Runtime.getRuntime().totalMemory()) });
  }
  
  protected abstract long fob();
  
  protected final boolean fod()
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
    if ((this.GNB == null) || (this.GNB.isQuit())) {
      this.GNB = new MMHandler("ProcessChecker");
    }
    return this.GNB;
  }
  
  protected void iO(int paramInt1, int paramInt2) {}
  
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
            boolean bool = AbstractProcessChecker.this.an(Process.myPid(), localElfCheckRequest.FNJ);
            Log.i("MicroMsg.AbstractProcessChecker", "[onReceive] begin to check process[%s] isCanKill:%s isNeedReCall:%s", new Object[] { AbstractProcessChecker.getProcessName(), Boolean.valueOf(bool), Boolean.valueOf(AbstractProcessChecker.this.fnY()) });
            if (bool)
            {
              AbstractProcessChecker.this.fnZ();
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
    String GNF = "";
    boolean GNG = false;
    boolean isResume = true;
    
    private a() {}
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(124969);
      if (paramActivity.getClass().getSimpleName().endsWith("WeChatSplashActivity"))
      {
        this.GNG = true;
        Log.i(AbstractProcessChecker.this.getTag(), "WeChatSplashActivity was created!");
      }
      AppMethodBeat.o(124969);
    }
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity)
    {
      AppMethodBeat.i(124971);
      if (Util.isNullOrNil(this.GNF)) {
        this.GNF = paramActivity.getClass().getName();
      }
      AppMethodBeat.o(124971);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(124970);
      this.GNF = paramActivity.getClass().getName();
      this.isResume = true;
      AppMethodBeat.o(124970);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity) {}
    
    public final void onActivityStopped(Activity paramActivity)
    {
      AppMethodBeat.i(124972);
      if (Util.isNullOrNil(this.GNF)) {
        this.GNF = paramActivity.getClass().getName();
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