package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class ug
{
  private static final String g = "Qmap" + File.separator;
  private AtomicBoolean a = new AtomicBoolean(false);
  private volatile Context b;
  private AtomicInteger c = new AtomicInteger(0);
  private b d;
  private ug.c e;
  private ReentrantReadWriteLock f = new ReentrantReadWriteLock();
  
  public static ug a()
  {
    return ug.a.a;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "md5";
    }
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      byte[] arrayOfByte = ((MessageDigest)localObject).digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < arrayOfByte.length)
      {
        localObject = Integer.toHexString(arrayOfByte[i] & 0xFF);
        paramArrayOfByte = (byte[])localObject;
        if (((String)localObject).length() == 1) {
          paramArrayOfByte = "0" + (String)localObject;
        }
        localStringBuilder.append(paramArrayOfByte);
        i += 1;
      }
      paramArrayOfByte = localStringBuilder.toString();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      new StringBuilder("CacheManager getMd5 failed:").append(paramArrayOfByte.toString());
    }
    return "md5";
  }
  
  private static byte[] c(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int j = paramString.length + paramArrayOfByte.length;
      byte[] arrayOfByte = new byte[j];
      int i = 0;
      while (i < paramString.length)
      {
        arrayOfByte[i] = paramString[i];
        i += 1;
      }
      i = paramString.length;
      while (i < j)
      {
        arrayOfByte[i] = paramArrayOfByte[(i - paramString.length)];
        i += 1;
      }
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      new StringBuilder("CacheManager encode:").append(paramString.toString());
    }
    return paramArrayOfByte;
  }
  
  private static byte[] d(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      int j = paramString.getBytes("UTF-8").length;
      paramString = new byte[paramArrayOfByte.length - j];
      int i = j;
      while (i < paramArrayOfByte.length)
      {
        paramString[(i - j)] = paramArrayOfByte[i];
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return paramArrayOfByte;
  }
  
  /* Error */
  public final uh a(uf paramuf)
  {
    // Byte code:
    //   0: new 132	com/tencent/tencentmap/mapsdk/a/uh
    //   3: dup
    //   4: aconst_null
    //   5: invokestatic 136	com/tencent/tencentmap/mapsdk/a/tp:b	()I
    //   8: ldc 138
    //   10: invokespecial 141	com/tencent/tencentmap/mapsdk/a/uh:<init>	([BILjava/lang/String;)V
    //   13: astore_2
    //   14: aload_0
    //   15: getfield 143	com/tencent/tencentmap/mapsdk/a/ug:e	Lcom/tencent/tencentmap/mapsdk/a/ug$c;
    //   18: ifnull +42 -> 60
    //   21: aload_1
    //   22: invokevirtual 149	com/tencent/tencentmap/mapsdk/a/uf:m	()Lcom/tencent/tencentmap/mapsdk/a/ue$a;
    //   25: getstatic 154	com/tencent/tencentmap/mapsdk/a/ue$a:e	Lcom/tencent/tencentmap/mapsdk/a/ue$a;
    //   28: if_acmpeq +32 -> 60
    //   31: aload_1
    //   32: invokevirtual 149	com/tencent/tencentmap/mapsdk/a/uf:m	()Lcom/tencent/tencentmap/mapsdk/a/ue$a;
    //   35: getstatic 156	com/tencent/tencentmap/mapsdk/a/ue$a:d	Lcom/tencent/tencentmap/mapsdk/a/ue$a;
    //   38: if_acmpeq +22 -> 60
    //   41: aload_1
    //   42: invokevirtual 149	com/tencent/tencentmap/mapsdk/a/uf:m	()Lcom/tencent/tencentmap/mapsdk/a/ue$a;
    //   45: getstatic 158	com/tencent/tencentmap/mapsdk/a/ue$a:a	Lcom/tencent/tencentmap/mapsdk/a/ue$a;
    //   48: if_acmpne +14 -> 62
    //   51: aload_1
    //   52: invokevirtual 161	com/tencent/tencentmap/mapsdk/a/uf:n	()I
    //   55: bipush 7
    //   57: if_icmpne +5 -> 62
    //   60: aload_2
    //   61: areturn
    //   62: aload_0
    //   63: getfield 71	com/tencent/tencentmap/mapsdk/a/ug:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   66: invokevirtual 165	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   69: invokevirtual 170	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   72: aload_0
    //   73: getfield 143	com/tencent/tencentmap/mapsdk/a/ug:e	Lcom/tencent/tencentmap/mapsdk/a/ug$c;
    //   76: aload_1
    //   77: invokevirtual 172	com/tencent/tencentmap/mapsdk/a/ug$c:a	(Lcom/tencent/tencentmap/mapsdk/a/uf;)Lcom/tencent/tencentmap/mapsdk/a/uh;
    //   80: astore_1
    //   81: aload_0
    //   82: getfield 71	com/tencent/tencentmap/mapsdk/a/ug:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   85: invokevirtual 165	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   88: invokevirtual 175	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   91: aload_1
    //   92: areturn
    //   93: astore_1
    //   94: aload_0
    //   95: getfield 71	com/tencent/tencentmap/mapsdk/a/ug:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   98: invokevirtual 165	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   101: invokevirtual 175	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   104: aload_2
    //   105: areturn
    //   106: astore_1
    //   107: aload_0
    //   108: getfield 71	com/tencent/tencentmap/mapsdk/a/ug:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   111: invokevirtual 165	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   114: invokevirtual 175	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   117: aload_1
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	ug
    //   0	119	1	paramuf	uf
    //   13	92	2	localuh	uh
    // Exception table:
    //   from	to	target	type
    //   72	81	93	java/lang/Throwable
    //   72	81	106	finally
  }
  
  public final void a(Context paramContext)
  {
    try
    {
      this.c.incrementAndGet();
      if (this.a.compareAndSet(false, true))
      {
        this.b = paramContext;
        this.d = new b(this.b);
        this.e = new ug.c(this, this.d);
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public final boolean a(ue.a parama)
  {
    if (this.e == null) {
      return false;
    }
    this.f.writeLock().lock();
    try
    {
      boolean bool = this.e.a(parama);
      return bool;
    }
    catch (Throwable parama)
    {
      new StringBuilder("clearCache error:").append(parama.toString());
      return false;
    }
    finally
    {
      this.f.writeLock().unlock();
    }
  }
  
  public final boolean a(uf paramuf, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((this.e == null) || (paramuf.m() == ue.a.e) || (paramuf.m() == ue.a.d) || ((paramuf.m() == ue.a.a) && (paramuf.n() == 7))) {
      return false;
    }
    this.f.writeLock().lock();
    try
    {
      paramBoolean = this.e.a(paramuf, null, true);
      return paramBoolean;
    }
    catch (Throwable paramuf)
    {
      new StringBuilder("updateTile error:").append(paramuf.toString());
      return false;
    }
    finally
    {
      this.f.writeLock().unlock();
    }
  }
  
  public final boolean a(uh paramuh, uf paramuf)
  {
    if ((this.e == null) || (paramuf.m() == ue.a.e) || (paramuf.m() == ue.a.d) || ((paramuf.m() == ue.a.a) && (paramuf.n() == 7))) {
      return false;
    }
    Object localObject = paramuf.m();
    int i;
    switch (ug.1.a[localObject.ordinal()])
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      this.f.writeLock().lock();
      try
      {
        if ((paramuf.g()) && (paramuf.l() == i))
        {
          localObject = this.e;
          if (localObject != null) {}
        }
        else
        {
          return false;
          i = tp.g();
          continue;
          i = tp.b();
          continue;
          i = tp.d();
          continue;
        }
        if (!ug.c.a(this.e, paramuf))
        {
          bool = this.e.a(paramuf, paramuh.c());
          return bool;
        }
        boolean bool = this.e.a(paramuf, paramuh.c(), false);
        return bool;
      }
      catch (Throwable paramuh)
      {
        new StringBuilder("put error:").append(paramuh.toString());
        return false;
      }
      finally
      {
        this.f.writeLock().unlock();
      }
    }
  }
  
  public final String b()
  {
    int j = 1;
    boolean bool = Environment.getExternalStorageState().equals("mounted");
    if (this.b == null) {
      return null;
    }
    int i = j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      i = this.b.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
      int k = this.b.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
      if ((i != 0) || (k != 0)) {
        break label168;
      }
    }
    label168:
    for (i = j;; i = 0)
    {
      if ((bool) && (i != 0)) {}
      for (;;)
      {
        try
        {
          String str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + g;
          sx.b(str1);
          return str1;
        }
        catch (Exception localException)
        {
          System.out.println(localException.toString());
          return null;
        }
        String str2 = this.b.getFileStreamPath("") + File.separator + g;
      }
    }
  }
  
  public final void c()
  {
    if (this.c.decrementAndGet() == 0)
    {
      if (this.e != null) {
        this.e.close();
      }
      this.a.compareAndSet(true, false);
    }
  }
  
  final class b
    extends ContextWrapper
  {
    public b(Context paramContext)
    {
      super();
    }
    
    public final SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
    {
      String str = ug.this.b();
      if ((str == null) || (str.length() == 0)) {
        return super.openOrCreateDatabase(paramString, paramInt, paramCursorFactory);
      }
      return SQLiteDatabase.openOrCreateDatabase(str + paramString, null);
    }
    
    public final SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
    {
      String str = ug.this.b();
      if ((str == null) || (str.length() == 0)) {
        return super.openOrCreateDatabase(paramString, paramInt, paramCursorFactory, paramDatabaseErrorHandler);
      }
      return SQLiteDatabase.openOrCreateDatabase(str + paramString, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ug
 * JD-Core Version:    0.7.0.1
 */