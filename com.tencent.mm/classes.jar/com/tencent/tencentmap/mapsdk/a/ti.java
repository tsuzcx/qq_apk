package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ti
{
  private static List<ss> a = new CopyOnWriteArrayList();
  private static ConcurrentHashMap<String, Bitmap> b = new ConcurrentHashMap();
  private static ReentrantReadWriteLock g = new ReentrantReadWriteLock();
  private String c = null;
  private Context d;
  private WeakReference<tn> e;
  private AtomicInteger f = new AtomicInteger(0);
  
  public ti(tn paramtn)
  {
    if (this.f.getAndIncrement() == 0) {
      a(tp.j());
    }
    this.d = tn.a();
    this.e = new WeakReference(paramtn);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      a.clear();
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject2 = paramString.getJSONObject(i);
          Object localObject1 = ((JSONObject)localObject2).getJSONArray("level");
          int k = ((JSONArray)localObject1).getInt(0);
          int m = ((JSONArray)localObject1).getInt(1);
          localObject1 = new ArrayList();
          localObject2 = ((JSONObject)localObject2).getJSONArray("districts");
          int j = 0;
          while (j < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
            int n = localJSONObject.getInt("rule");
            int i1 = localJSONObject.getInt("priority");
            String str = localJSONObject.getString("frontier");
            ((List)localObject1).add(new sr(n, i1, localJSONObject.getString("logo_name"), localJSONObject.getString("logo"), str));
            j += 1;
          }
          a.add(new ss(k, m, (List)localObject1));
          i += 1;
        }
        return;
      }
      catch (Throwable paramString) {}
    }
  }
  
  /* Error */
  private boolean a(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 40	com/tencent/tencentmap/mapsdk/a/ti:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   6: invokevirtual 154	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   9: invokevirtual 159	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   12: aload_2
    //   13: ifnonnull +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 161	com/tencent/tencentmap/mapsdk/a/ti:b	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_1
    //   24: new 163	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 168	java/io/File:exists	()Z
    //   37: istore_3
    //   38: iload_3
    //   39: ifeq +18 -> 57
    //   42: aconst_null
    //   43: invokestatic 173	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   46: getstatic 40	com/tencent/tencentmap/mapsdk/a/ti:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   49: invokevirtual 154	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   52: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   55: iconst_0
    //   56: ireturn
    //   57: new 178	java/io/FileOutputStream
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 181	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   65: astore_1
    //   66: aload_2
    //   67: getstatic 187	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   70: bipush 100
    //   72: aload_1
    //   73: invokevirtual 193	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   76: istore_3
    //   77: aload_1
    //   78: invokestatic 173	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   81: getstatic 40	com/tencent/tencentmap/mapsdk/a/ti:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   84: invokevirtual 154	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   87: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   90: iload_3
    //   91: ireturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: invokestatic 173	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   99: getstatic 40	com/tencent/tencentmap/mapsdk/a/ti:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   102: invokevirtual 154	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   105: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   108: iconst_0
    //   109: ireturn
    //   110: astore_1
    //   111: aload 4
    //   113: astore_2
    //   114: aload_2
    //   115: invokestatic 173	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   118: getstatic 40	com/tencent/tencentmap/mapsdk/a/ti:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   121: invokevirtual 154	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   124: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   127: aload_1
    //   128: athrow
    //   129: astore 4
    //   131: aload_1
    //   132: astore_2
    //   133: aload 4
    //   135: astore_1
    //   136: goto -22 -> 114
    //   139: astore_2
    //   140: goto -45 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	ti
    //   0	143	1	paramString	String
    //   0	143	2	paramBitmap	Bitmap
    //   37	54	3	bool	boolean
    //   1	111	4	localObject1	Object
    //   129	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	38	92	java/lang/Throwable
    //   57	66	92	java/lang/Throwable
    //   24	38	110	finally
    //   57	66	110	finally
    //   66	77	129	finally
    //   66	77	139	java/lang/Throwable
  }
  
  private String b(String paramString)
  {
    String str = d();
    sx.b(str);
    return str + "/" + paramString;
  }
  
  /* Error */
  private Bitmap c(String paramString)
  {
    // Byte code:
    //   0: getstatic 40	com/tencent/tencentmap/mapsdk/a/ti:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   3: invokevirtual 215	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   6: invokevirtual 218	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   9: new 163	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 161	com/tencent/tencentmap/mapsdk/a/ti:b	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 168	java/io/File:exists	()Z
    //   26: istore_2
    //   27: iload_2
    //   28: ifne +18 -> 46
    //   31: aconst_null
    //   32: invokestatic 173	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   35: getstatic 40	com/tencent/tencentmap/mapsdk/a/ti:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   38: invokevirtual 215	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   41: invokevirtual 219	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   44: aconst_null
    //   45: areturn
    //   46: new 221	java/io/FileInputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 222	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore_1
    //   55: aload_1
    //   56: invokestatic 228	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   59: astore_3
    //   60: aload_1
    //   61: invokestatic 173	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   64: getstatic 40	com/tencent/tencentmap/mapsdk/a/ti:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   67: invokevirtual 215	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   70: invokevirtual 219	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   73: aload_3
    //   74: areturn
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: invokestatic 173	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   82: getstatic 40	com/tencent/tencentmap/mapsdk/a/ti:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   85: invokevirtual 215	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   88: invokevirtual 219	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_3
    //   96: aload_3
    //   97: invokestatic 173	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   100: getstatic 40	com/tencent/tencentmap/mapsdk/a/ti:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   103: invokevirtual 215	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   106: invokevirtual 219	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   109: aload_1
    //   110: athrow
    //   111: astore_3
    //   112: aload_1
    //   113: astore 4
    //   115: aload_3
    //   116: astore_1
    //   117: aload 4
    //   119: astore_3
    //   120: goto -24 -> 96
    //   123: astore_3
    //   124: goto -46 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	ti
    //   0	127	1	paramString	String
    //   26	2	2	bool	boolean
    //   59	38	3	localBitmap	Bitmap
    //   111	5	3	localObject1	Object
    //   119	1	3	localObject2	Object
    //   123	1	3	localThrowable	Throwable
    //   113	5	4	str	String
    // Exception table:
    //   from	to	target	type
    //   9	27	75	java/lang/Throwable
    //   46	55	75	java/lang/Throwable
    //   9	27	93	finally
    //   46	55	93	finally
    //   55	60	111	finally
    //   55	60	123	java/lang/Throwable
  }
  
  private String d()
  {
    return this.d.getFilesDir() + "/logos";
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: getstatic 40	com/tencent/tencentmap/mapsdk/a/ti:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   3: invokevirtual 154	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   6: invokevirtual 159	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   9: getstatic 35	com/tencent/tencentmap/mapsdk/a/ti:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: invokevirtual 241	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   15: new 163	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 195	com/tencent/tencentmap/mapsdk/a/ti:d	()Ljava/lang/String;
    //   23: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 168	java/io/File:exists	()Z
    //   31: ifeq +56 -> 87
    //   34: new 163	java/io/File
    //   37: dup
    //   38: new 200	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   45: aload_0
    //   46: getfield 72	com/tencent/tencentmap/mapsdk/a/ti:d	Landroid/content/Context;
    //   49: invokevirtual 235	android/content/Context:getFilesDir	()Ljava/io/File;
    //   52: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   55: ldc 243
    //   57: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore_2
    //   67: aload_1
    //   68: aload_2
    //   69: invokevirtual 247	java/io/File:renameTo	(Ljava/io/File;)Z
    //   72: ifeq +25 -> 97
    //   75: new 249	com/tencent/tencentmap/mapsdk/a/ti$2
    //   78: dup
    //   79: aload_0
    //   80: aload_2
    //   81: invokespecial 252	com/tencent/tencentmap/mapsdk/a/ti$2:<init>	(Lcom/tencent/tencentmap/mapsdk/a/ti;Ljava/io/File;)V
    //   84: invokevirtual 255	com/tencent/tencentmap/mapsdk/a/ti$2:start	()V
    //   87: getstatic 40	com/tencent/tencentmap/mapsdk/a/ti:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   90: invokevirtual 154	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   93: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   96: return
    //   97: aload_1
    //   98: invokevirtual 258	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   101: invokestatic 260	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/lang/String;)Z
    //   104: pop
    //   105: goto -18 -> 87
    //   108: astore_1
    //   109: getstatic 40	com/tencent/tencentmap/mapsdk/a/ti:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   112: invokevirtual 154	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   115: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   118: return
    //   119: astore_1
    //   120: getstatic 40	com/tencent/tencentmap/mapsdk/a/ti:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   123: invokevirtual 154	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   126: invokevirtual 176	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   129: aload_1
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	ti
    //   26	72	1	localFile1	java.io.File
    //   108	1	1	localThrowable	Throwable
    //   119	11	1	localObject	Object
    //   66	15	2	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   15	87	108	java/lang/Throwable
    //   97	105	108	java/lang/Throwable
    //   15	87	119	finally
    //   97	105	119	finally
  }
  
  public final void a(st paramst)
  {
    float f1 = paramst.c();
    Object localObject2 = a.iterator();
    Object localObject1;
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (ss)((Iterator)localObject2).next();
    } while ((f1 < ((ss)localObject1).a()) || (f1 > ((ss)localObject1).b()));
    for (;;)
    {
      if (localObject1 == null) {}
      for (;;)
      {
        return;
        localObject1 = ((ss)localObject1).a(paramst);
        if (localObject1 != null)
        {
          paramst = localObject1[0];
          localObject1 = localObject1[1];
          if (paramst != this.c) {}
          for (int i = 1; i != 0; i = 0)
          {
            localObject2 = (Bitmap)b.get(paramst);
            if (localObject2 == null) {
              break label172;
            }
            if (((Bitmap)localObject2).isRecycled()) {
              break label164;
            }
            if (this.e.get() == null) {
              break label172;
            }
            ((tn)this.e.get()).a((Bitmap)localObject2);
            this.c = paramst;
            return;
          }
        }
      }
      label164:
      b.remove(paramst);
      label172:
      localObject2 = c(paramst);
      if ((localObject2 != null) && (this.e.get() != null))
      {
        this.c = paramst;
        b.put(this.c, localObject2);
        ((tn)this.e.get()).a((Bitmap)localObject2);
        return;
      }
      this.c = null;
      new ti.1(this, (String)localObject1, paramst).start();
      return;
      localObject1 = null;
    }
  }
  
  public final void b()
  {
    if (this.f.decrementAndGet() == 0)
    {
      if (Build.VERSION.SDK_INT < 11)
      {
        Iterator localIterator = b.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            localBitmap.recycle();
          }
        }
      }
      b.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ti
 * JD-Core Version:    0.7.0.1
 */