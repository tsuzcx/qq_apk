package com.tencent.mm.wear.app.a;

import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.q;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.e;
import com.google.android.gms.wearable.i;
import com.google.android.gms.wearable.n;
import com.google.android.gms.wearable.r;
import com.google.android.gms.wearable.u;
import com.google.android.gms.wearable.v;
import com.google.android.gms.wearable.w;
import com.google.android.gms.wearable.y;
import com.google.android.gms.wearable.z;
import com.tencent.mm.wear.app.MMApplication;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public final class a
  implements c
{
  private com.google.android.gms.common.api.p adR = new q(MMApplication.getContext()).a(z.Sl).gK();
  private ReentrantLock adS = new ReentrantLock();
  
  /* Error */
  private d a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 58	java/io/File
    //   3: dup
    //   4: aload_3
    //   5: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: invokevirtual 65	java/io/File:exists	()Z
    //   15: ifne +13 -> 28
    //   18: new 67	com/tencent/mm/wear/app/a/d
    //   21: dup
    //   22: ldc 68
    //   24: invokespecial 71	com/tencent/mm/wear/app/a/d:<init>	(I)V
    //   27: areturn
    //   28: aload_0
    //   29: invokespecial 51	com/tencent/mm/wear/app/a/a:my	()Lcom/google/android/gms/common/api/p;
    //   32: invokevirtual 76	com/google/android/gms/common/api/p:isConnected	()Z
    //   35: ifne +13 -> 48
    //   38: new 67	com/tencent/mm/wear/app/a/d
    //   41: dup
    //   42: ldc 77
    //   44: invokespecial 71	com/tencent/mm/wear/app/a/d:<init>	(I)V
    //   47: areturn
    //   48: new 67	com/tencent/mm/wear/app/a/d
    //   51: dup
    //   52: invokespecial 78	com/tencent/mm/wear/app/a/d:<init>	()V
    //   55: astore 4
    //   57: aload_0
    //   58: getfield 46	com/tencent/mm/wear/app/a/a:adS	Ljava/util/concurrent/locks/ReentrantLock;
    //   61: ldc2_w 79
    //   64: getstatic 86	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   67: invokevirtual 90	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   70: pop
    //   71: getstatic 94	com/google/android/gms/wearable/z:Ur	Lcom/google/android/gms/wearable/b;
    //   74: aload_0
    //   75: invokespecial 51	com/tencent/mm/wear/app/a/a:my	()Lcom/google/android/gms/common/api/p;
    //   78: aload_2
    //   79: aload_1
    //   80: invokeinterface 99 4 0
    //   85: ldc2_w 100
    //   88: getstatic 86	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   91: invokevirtual 106	com/google/android/gms/common/api/t:a	(JLjava/util/concurrent/TimeUnit;)Lcom/google/android/gms/common/api/w;
    //   94: checkcast 108	com/google/android/gms/wearable/d
    //   97: astore 6
    //   99: aload 6
    //   101: invokeinterface 112 1 0
    //   106: astore 7
    //   108: aload 7
    //   110: invokevirtual 117	com/google/android/gms/common/api/Status:gw	()Z
    //   113: ifne +71 -> 184
    //   116: aload 4
    //   118: ldc 77
    //   120: putfield 121	com/tencent/mm/wear/app/a/d:adX	I
    //   123: aload 4
    //   125: aload 7
    //   127: invokevirtual 125	com/google/android/gms/common/api/Status:gQ	()Ljava/lang/String;
    //   130: putfield 129	com/tencent/mm/wear/app/a/d:adY	Ljava/lang/String;
    //   133: ldc 131
    //   135: ldc 133
    //   137: iconst_2
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload 7
    //   145: invokevirtual 137	com/google/android/gms/common/api/Status:getStatusCode	()I
    //   148: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: aastore
    //   152: dup
    //   153: iconst_1
    //   154: aload 7
    //   156: invokevirtual 125	com/google/android/gms/common/api/Status:gQ	()Ljava/lang/String;
    //   159: aastore
    //   160: invokestatic 148	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aload_0
    //   164: getfield 46	com/tencent/mm/wear/app/a/a:adS	Ljava/util/concurrent/locks/ReentrantLock;
    //   167: invokevirtual 151	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   170: aload 4
    //   172: areturn
    //   173: astore_1
    //   174: aload 4
    //   176: ldc 68
    //   178: putfield 121	com/tencent/mm/wear/app/a/d:adX	I
    //   181: aload 4
    //   183: areturn
    //   184: new 153	com/tencent/mm/wear/app/a/b
    //   187: dup
    //   188: aload_0
    //   189: iconst_0
    //   190: invokespecial 156	com/tencent/mm/wear/app/a/b:<init>	(Lcom/tencent/mm/wear/app/a/a;B)V
    //   193: astore 7
    //   195: aload 7
    //   197: aload_2
    //   198: putfield 159	com/tencent/mm/wear/app/a/b:adV	Ljava/lang/String;
    //   201: aload 7
    //   203: aload_3
    //   204: putfield 162	com/tencent/mm/wear/app/a/b:adT	Ljava/lang/String;
    //   207: aload 7
    //   209: aload_1
    //   210: putfield 165	com/tencent/mm/wear/app/a/b:adU	Ljava/lang/String;
    //   213: getstatic 94	com/google/android/gms/wearable/z:Ur	Lcom/google/android/gms/wearable/b;
    //   216: aload_0
    //   217: invokespecial 51	com/tencent/mm/wear/app/a/a:my	()Lcom/google/android/gms/common/api/p;
    //   220: aload 7
    //   222: invokeinterface 168 3 0
    //   227: pop
    //   228: aload 6
    //   230: invokeinterface 172 1 0
    //   235: aload_0
    //   236: invokespecial 51	com/tencent/mm/wear/app/a/a:my	()Lcom/google/android/gms/common/api/p;
    //   239: aload 5
    //   241: invokestatic 178	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   244: invokeinterface 183 3 0
    //   249: pop
    //   250: ldc 131
    //   252: ldc 185
    //   254: iconst_2
    //   255: anewarray 4	java/lang/Object
    //   258: dup
    //   259: iconst_0
    //   260: aload_1
    //   261: aastore
    //   262: dup
    //   263: iconst_1
    //   264: aload 5
    //   266: invokevirtual 189	java/io/File:length	()J
    //   269: invokestatic 194	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   272: aastore
    //   273: invokestatic 197	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   276: goto -113 -> 163
    //   279: astore_1
    //   280: aload 4
    //   282: ldc 68
    //   284: putfield 121	com/tencent/mm/wear/app/a/d:adX	I
    //   287: goto -117 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	a
    //   0	290	1	paramString1	String
    //   0	290	2	paramString2	String
    //   0	290	3	paramString3	String
    //   55	226	4	locald	d
    //   8	257	5	localFile	java.io.File
    //   97	132	6	locald1	com.google.android.gms.wearable.d
    //   106	115	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   57	71	173	java/lang/InterruptedException
    //   163	170	279	java/lang/Throwable
  }
  
  private d a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (!my().isConnected()) {
      return new d(131072);
    }
    locald = new d();
    try
    {
      this.adS.tryLock(10L, TimeUnit.SECONDS);
      com.tencent.mm.wear.a.c.d.d("MicroMsg.GlobalConnection", "send message item", new Object[0]);
      paramString1 = ((r)z.Up.a(my(), paramString1, paramString2, paramArrayOfByte).a(2L, TimeUnit.SECONDS)).gM();
      return locald;
    }
    catch (InterruptedException paramString1)
    {
      try
      {
        this.adS.unlock();
        if (!paramString1.gw())
        {
          locald.adX = 131072;
          locald.adY = paramString1.gQ();
          com.tencent.mm.wear.a.c.d.a("MicroMsg.GlobalConnection", "send message not success errorCode=%d | errorMsg=%s", new Object[] { Integer.valueOf(paramString1.getStatusCode()), paramString1.gQ() });
        }
        return locald;
      }
      catch (Throwable paramString1)
      {
        locald.adX = 65536;
      }
      paramString1 = paramString1;
      locald.adX = 65536;
      return locald;
    }
  }
  
  private com.google.android.gms.common.api.p my()
  {
    if (!this.adR.isConnected())
    {
      com.tencent.mm.wear.a.c.d.c("MicroMsg.GlobalConnection", "connect to google api client", new Object[0]);
      ConnectionResult localConnectionResult = this.adR.a(TimeUnit.SECONDS);
      if (!localConnectionResult.gw()) {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.GlobalConnection", "google api client connect error, code=%d, ", new Object[] { Integer.valueOf(localConnectionResult.getErrorCode()) });
      }
    }
    return this.adR;
  }
  
  private HashSet<String> mz()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (v)z.Uq.c(my()).a(30L, TimeUnit.SECONDS);
    if (localObject != null)
    {
      localObject = ((v)localObject).kH().iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashSet.add(((com.google.android.gms.wearable.t)((Iterator)localObject).next()).getId());
      }
    }
    return localHashSet;
  }
  
  public final d a(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = mz();
    d locald1 = new d();
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald2 = a((String)((Iterator)localObject).next(), paramString, paramArrayOfByte);
      if (locald2.adX != 0) {
        return locald2;
      }
    }
    return locald1;
  }
  
  public final byte[] a(Asset paramAsset)
  {
    paramAsset = (i)z.Un.a(my(), paramAsset).a(30L, TimeUnit.SECONDS);
    Status localStatus = paramAsset.gM();
    if (!localStatus.gw()) {
      com.tencent.mm.wear.a.c.d.a("MicroMsg.GlobalConnection", "read asset data not success errorCode=%d | errorMsg=%s", new Object[] { Integer.valueOf(localStatus.getStatusCode()), localStatus.gQ() });
    }
    return com.tencent.mm.wear.a.f.c.b(paramAsset.getInputStream());
  }
  
  public final d b(String paramString, byte[] paramArrayOfByte)
  {
    if (!my().isConnected()) {
      return new d(131072);
    }
    paramString = y.v(paramString);
    paramString.kG().putLong("key_timestamp", System.currentTimeMillis());
    paramString.kG().a("key_data", Asset.e(paramArrayOfByte));
    paramArrayOfByte = paramString.kL();
    paramString = new d();
    try
    {
      this.adS.tryLock(10L, TimeUnit.SECONDS);
      com.tencent.mm.wear.a.c.d.d("MicroMsg.GlobalConnection", "put data item", new Object[0]);
      z.Un.a(my(), paramArrayOfByte);
      return paramString;
    }
    catch (InterruptedException paramArrayOfByte)
    {
      try
      {
        this.adS.unlock();
        com.tencent.mm.wear.a.c.d.c("MicroMsg.GlobalConnection", "send data request path=%s | length=%d", new Object[] { paramArrayOfByte.getUri().getPath(), Integer.valueOf(paramArrayOfByte.getData().length) });
        return paramString;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramString.adX = 65536;
      }
      paramArrayOfByte = paramArrayOfByte;
      paramString.adX = 65536;
      return paramString;
    }
  }
  
  public final boolean e(Uri paramUri)
  {
    z.Un.b(my(), paramUri);
    com.tencent.mm.wear.a.c.d.c("MicroMsg.GlobalConnection", "delete data item %s", new Object[] { paramUri });
    return true;
  }
  
  public final d m(String paramString1, String paramString2)
  {
    Object localObject = mz();
    d locald1 = new d();
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald2 = a(paramString1, (String)((Iterator)localObject).next(), paramString2);
      if (locald2.adX != 0) {
        return locald2;
      }
    }
    return locald1;
  }
  
  public final String mA()
  {
    return ((w)z.Uq.b(my()).a(30L, TimeUnit.SECONDS)).kI().getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.a.a
 * JD-Core Version:    0.7.0.1
 */