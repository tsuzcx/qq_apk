package com.tencent.shadow.dynamic.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.tencent.shadow.core.b.a.e.a;
import com.tencent.shadow.core.b.a.e.b;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.FailedException;
import com.tencent.shadow.dynamic.host.NotFoundException;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class a
  extends com.tencent.shadow.core.b.a
  implements g
{
  private static final Logger c = LoggerFactory.getLogger(a.class);
  private AtomicBoolean d = new AtomicBoolean(false);
  private AtomicReference<CountDownLatch> e = new AtomicReference();
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  /* Error */
  private InstalledApk c(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: invokevirtual 55	com/tencent/shadow/dynamic/a/a:a	(Ljava/lang/String;I)Lcom/tencent/shadow/core/b/a/e$a;
    //   6: astore 5
    //   8: aload 5
    //   10: getfield 60	com/tencent/shadow/core/b/a/e$a:b	Ljava/io/File;
    //   13: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16: astore 4
    //   18: aload 5
    //   20: getfield 68	com/tencent/shadow/core/b/a/e$a:c	Ljava/io/File;
    //   23: astore_1
    //   24: aconst_null
    //   25: astore_3
    //   26: aload_1
    //   27: ifnonnull +8 -> 35
    //   30: aconst_null
    //   31: astore_1
    //   32: goto +12 -> 44
    //   35: aload 5
    //   37: getfield 68	com/tencent/shadow/core/b/a/e$a:c	Ljava/io/File;
    //   40: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   43: astore_1
    //   44: aload 5
    //   46: getfield 70	com/tencent/shadow/core/b/a/e$a:d	Ljava/io/File;
    //   49: ifnonnull +6 -> 55
    //   52: goto +12 -> 64
    //   55: aload 5
    //   57: getfield 70	com/tencent/shadow/core/b/a/e$a:d	Ljava/io/File;
    //   60: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   63: astore_3
    //   64: new 72	com/tencent/shadow/core/common/InstalledApk
    //   67: dup
    //   68: aload 4
    //   70: aload_1
    //   71: aload_3
    //   72: invokespecial 75	com/tencent/shadow/core/common/InstalledApk:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   75: areturn
    //   76: astore_3
    //   77: getstatic 27	com/tencent/shadow/dynamic/a/a:c	Lcom/tencent/shadow/core/common/Logger;
    //   80: invokeinterface 81 1 0
    //   85: ifeq +14 -> 99
    //   88: getstatic 27	com/tencent/shadow/dynamic/a/a:c	Lcom/tencent/shadow/core/common/Logger;
    //   91: ldc 83
    //   93: aload_3
    //   94: invokeinterface 87 3 0
    //   99: new 89	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   106: astore 4
    //   108: aload 4
    //   110: ldc 92
    //   112: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 4
    //   118: aload_1
    //   119: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 4
    //   125: ldc 98
    //   127: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 4
    //   133: iload_2
    //   134: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 4
    //   140: ldc 103
    //   142: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 4
    //   148: aload_3
    //   149: invokevirtual 106	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   152: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: new 108	com/tencent/shadow/dynamic/host/NotFoundException
    //   159: dup
    //   160: aload 4
    //   162: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokespecial 114	com/tencent/shadow/dynamic/host/NotFoundException:<init>	(Ljava/lang/String;)V
    //   168: athrow
    //   169: astore_1
    //   170: new 116	com/tencent/shadow/dynamic/host/FailedException
    //   173: dup
    //   174: aload_1
    //   175: invokespecial 119	com/tencent/shadow/dynamic/host/FailedException:<init>	(Ljava/lang/RuntimeException;)V
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	a
    //   0	179	1	paramString	String
    //   0	179	2	paramInt	int
    //   25	47	3	str	String
    //   76	73	3	localRuntimeException	RuntimeException
    //   16	145	4	localObject	Object
    //   6	50	5	locala	e.a
    // Exception table:
    //   from	to	target	type
    //   0	8	76	java/lang/RuntimeException
    //   8	24	169	java/lang/RuntimeException
    //   35	44	169	java/lang/RuntimeException
    //   44	52	169	java/lang/RuntimeException
    //   55	64	169	java/lang/RuntimeException
    //   64	76	169	java/lang/RuntimeException
    //   77	99	169	java/lang/RuntimeException
    //   99	169	169	java/lang/RuntimeException
  }
  
  public final void a(int paramInt, TimeUnit paramTimeUnit)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      try
      {
        Object localObject;
        if (c.isInfoEnabled())
        {
          localObject = c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("waiting service connect connectCountDownLatch:");
          localStringBuilder.append(this.e);
          ((Logger)localObject).info(localStringBuilder.toString());
        }
        long l = System.currentTimeMillis();
        if (!(((CountDownLatch)this.e.get()).await(paramInt, paramTimeUnit) ^ true))
        {
          if (!c.isInfoEnabled()) {
            return;
          }
          paramTimeUnit = c;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("service connected ");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
          paramTimeUnit.info(((StringBuilder)localObject).toString());
          return;
        }
        paramTimeUnit = new StringBuilder();
        paramTimeUnit.append("连接Service超时 ,等待了：");
        paramTimeUnit.append(System.currentTimeMillis() - l);
        throw new TimeoutException(paramTimeUnit.toString());
      }
      catch (InterruptedException paramTimeUnit)
      {
        throw new RuntimeException(paramTimeUnit);
      }
    } else {
      throw new RuntimeException("waitServiceConnected 不能在主线程中调用");
    }
  }
  
  protected abstract void a(ComponentName paramComponentName);
  
  protected abstract void a(ComponentName paramComponentName, IBinder paramIBinder);
  
  public final void a(final String paramString)
  {
    if (this.d.get())
    {
      if (c.isInfoEnabled()) {
        c.info("pps service connecting");
      }
      return;
    }
    if (c.isInfoEnabled())
    {
      localObject1 = c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("bindPluginProcessService ");
      ((StringBuilder)localObject2).append(paramString);
      ((Logger)localObject1).info(((StringBuilder)localObject2).toString());
    }
    this.e.set(new CountDownLatch(1));
    this.d.set(true);
    Object localObject1 = new CountDownLatch(1);
    Object localObject2 = new boolean[1];
    this.b.post(new Runnable()
    {
      public void run()
      {
        Intent localIntent = new Intent();
        localIntent.setComponent(new ComponentName(a.this.a, paramString));
        boolean bool = a.this.a.bindService(localIntent, new ServiceConnection()
        {
          public void onServiceConnected(ComponentName paramAnonymous2ComponentName, IBinder paramAnonymous2IBinder)
          {
            if (a.c().isInfoEnabled())
            {
              Logger localLogger = a.c();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("onServiceConnected connectCountDownLatch:");
              localStringBuilder.append(a.a(a.this));
              localLogger.info(localStringBuilder.toString());
            }
            a.b(a.this).set(false);
            a.this.a(paramAnonymous2ComponentName, paramAnonymous2IBinder);
            ((CountDownLatch)a.a(a.this).get()).countDown();
            if (a.c().isInfoEnabled())
            {
              paramAnonymous2ComponentName = a.c();
              paramAnonymous2IBinder = new StringBuilder();
              paramAnonymous2IBinder.append("onServiceConnected countDown:");
              paramAnonymous2IBinder.append(a.a(a.this));
              paramAnonymous2ComponentName.info(paramAnonymous2IBinder.toString());
            }
          }
          
          public void onServiceDisconnected(ComponentName paramAnonymous2ComponentName)
          {
            if (a.c().isInfoEnabled()) {
              a.c().info("onServiceDisconnected");
            }
            a.b(a.this).set(false);
            a.this.a(paramAnonymous2ComponentName);
          }
        }, 1);
        this.b[0] = bool;
        this.c.countDown();
      }
    });
    try
    {
      ((CountDownLatch)localObject1).await(10L, TimeUnit.SECONDS);
      if (localObject2[0] != 0) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("无法绑定PPS:");
      ((StringBuilder)localObject1).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    catch (InterruptedException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public InstalledApk b(String paramString)
  {
    return c(paramString, 3);
  }
  
  public InstalledApk c(String paramString)
  {
    return c(paramString, 4);
  }
  
  public InstalledApk d(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        locala = a(paramString1, paramString2);
      }
      catch (RuntimeException localRuntimeException)
      {
        e.a locala;
        boolean bool;
        Object localObject4;
        Object localObject1;
        continue;
        paramString1 = null;
        continue;
        Object localObject2 = null;
        continue;
        Object localObject3 = null;
        continue;
      }
      try
      {
        bool = locala instanceof e.b;
        localObject4 = null;
        if (!bool) {
          continue;
        }
        paramString1 = ((e.b)locala).e;
        if (!(locala instanceof e.b)) {
          continue;
        }
        localObject1 = ((e.b)locala).f;
        if (!(locala instanceof e.b)) {
          continue;
        }
        localObject3 = ((e.b)locala).g;
        paramString2 = new com.tencent.shadow.core.a.a(paramString1, paramString2, (String[])localObject1, (String[])localObject3);
        paramString1 = Parcel.obtain();
        paramString2.writeToParcel(paramString1, 0);
        localObject1 = paramString1.marshall();
        paramString1.recycle();
        localObject3 = locala.b.getAbsolutePath();
        if (locala.c == null) {
          paramString1 = null;
        } else {
          paramString1 = locala.c.getAbsolutePath();
        }
        if (locala.d == null) {
          paramString2 = localObject4;
        } else {
          paramString2 = locala.d.getAbsolutePath();
        }
        return new InstalledApk((String)localObject3, paramString1, paramString2, (byte[])localObject1);
      }
      catch (RuntimeException paramString1)
      {
        if (!c.isErrorEnabled()) {
          continue;
        }
        c.error("getPlugin exception:", paramString1);
        throw new FailedException(paramString1);
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("uuid==");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("partKey==");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append("的Plugin找不到");
    throw new NotFoundException(((StringBuilder)localObject1).toString());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (c.isInfoEnabled())
    {
      Logger localLogger = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate bundle:");
      localStringBuilder.append(paramBundle);
      localLogger.info(localStringBuilder.toString());
    }
  }
  
  public void onDestroy()
  {
    if (c.isInfoEnabled()) {
      c.info("onDestroy:");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (c.isInfoEnabled())
    {
      Logger localLogger = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSaveInstanceState:");
      localStringBuilder.append(paramBundle);
      localLogger.info(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.dynamic.a.a
 * JD-Core Version:    0.7.0.1
 */