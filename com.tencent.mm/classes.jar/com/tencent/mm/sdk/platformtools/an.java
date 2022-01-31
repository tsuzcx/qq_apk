package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Debug;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class an
{
  public static volatile an ufL = new an();
  public static volatile long ufM = 20L;
  private static d ufN = null;
  private final ai eAg = new ai("MemoryWatchDog");
  private final LinkedList<a> ufO = new LinkedList();
  private int ufP = -1;
  private int ufQ = -1;
  private long ufR = 0L;
  private long ufS = 0L;
  private long ufT = 0L;
  private long ufU = 0L;
  private long ufV;
  private long ufW;
  private boolean[] ufX = new boolean[6];
  private Runnable ufY = new b((byte)0);
  private long ufZ = 0L;
  
  public static void a(d paramd)
  {
    ufN = paramd;
  }
  
  private void bs(Context paramContext, String paramString)
  {
    try
    {
      y.i("MicroMsg.MD", "[checkMemory] %s", new Object[] { paramString });
      String str = paramString;
      if (paramContext != null)
      {
        if (this.ufP <= 0)
        {
          this.ufP = ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
          this.ufQ = ((ActivityManager)paramContext.getSystemService("activity")).getLargeMemoryClass();
          this.ufT = ((int)(this.ufQ * 1024 * 1024 * 0.8D));
        }
        str = paramContext.getClass().getCanonicalName() + "$" + paramContext.hashCode() + "#" + paramString;
      }
      this.eAg.O(new c(str));
      return;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.MD", "exception:%s", new Object[] { paramContext.toString() });
    }
  }
  
  public static void crm() {}
  
  public static void crn() {}
  
  public static void fC(Context paramContext)
  {
    ufL.bs(paramContext, "uiOnDestroy");
  }
  
  public static void fD(Context paramContext)
  {
    ufL.bs(paramContext, "uiOnPause");
  }
  
  public final f mt(boolean paramBoolean)
  {
    Object localObject1 = new HashMap();
    f localf = new f();
    LinkedList localLinkedList = new LinkedList();
    ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup();
    Object localObject2 = new Thread[localThreadGroup.activeCount() * 2];
    int k = localThreadGroup.enumerate((Thread[])localObject2);
    int i = 0;
    if (i < k)
    {
      localThreadGroup = localObject2[i];
      label94:
      int j;
      if (localThreadGroup.getState() == Thread.State.RUNNABLE)
      {
        localf.ugk += 1;
        if (!paramBoolean) {
          break label184;
        }
        if (!((HashMap)localObject1).containsKey(localThreadGroup.getName())) {
          break label179;
        }
        j = ((Integer)((HashMap)localObject1).get(localThreadGroup.getName())).intValue();
        label128:
        ((HashMap)localObject1).put(localThreadGroup.getName(), Integer.valueOf(j + 1));
      }
      for (;;)
      {
        localf.mDK += 1;
        i += 1;
        break;
        localf.ugl += 1;
        break label94;
        label179:
        j = 0;
        break label128;
        label184:
        localLinkedList.add(localThreadGroup.getName() + "$" + localThreadGroup.getId() + "#" + localThreadGroup.getState());
      }
    }
    if (paramBoolean)
    {
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        i = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
        if (i > 0) {
          localLinkedList.add((String)((Map.Entry)localObject2).getKey() + "#" + i);
        }
      }
    }
    localf.bZM = paramBoolean;
    localf.list = localLinkedList;
    return localf;
  }
  
  private final class a
  {
    WeakReference<Bitmap> fGd;
    long size;
  }
  
  private final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      Iterator localIterator = an.b(an.this).iterator();
      label72:
      while (localIterator.hasNext())
      {
        an.a locala = (an.a)localIterator.next();
        if (locala.fGd.get() == null) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label72;
          }
          an.a(an.this, an.a(an.this) - locala.size);
          break;
        }
      }
      if (an.a(an.this) > 0L) {
        y.i("MicroMsg.MD", "[CheckBitmapTask] AllocatedBitmapSize:%s LastAllocatedBitmapSize:%s", new Object[] { Long.valueOf(an.a(an.this)), Long.valueOf(an.c(an.this)) });
      }
      an.b(an.this, an.a(an.this));
      an.d(an.this).k(this, 20000L);
      an.ufM -= 1L;
    }
  }
  
  final class c
    implements Runnable
  {
    String tag;
    
    c(String paramString)
    {
      this.tag = paramString;
    }
    
    public final void run()
    {
      long l2 = System.currentTimeMillis();
      if (l2 - an.e(an.this) < 2000L) {}
      long l1;
      long l4;
      int i;
      label157:
      label203:
      do
      {
        return;
        long l3 = System.currentTimeMillis();
        an.e locale = new an.e(an.this, (byte)0);
        ae.getContext().getSystemService("activity");
        locale.ugb = Debug.getNativeHeapSize();
        locale.ugc = Debug.getNativeHeapAllocatedSize();
        locale.ugd = Debug.getNativeHeapFreeSize();
        locale.uge = Runtime.getRuntime().totalMemory();
        locale.ugf = Runtime.getRuntime().freeMemory();
        locale.ugg = Runtime.getRuntime().maxMemory();
        locale.ugj = an.this.mt(true);
        locale.tag = this.tag;
        l1 = locale.uge;
        l4 = locale.uge;
        if (an.i(an.this) > 0L) {
          break;
        }
        i = 0;
        if (i != 0)
        {
          if (l1 >= an.f(an.this)) {
            an.c(an.this, l1);
          }
          if (an.e(an.this) != 0L) {
            break label493;
          }
          an.d(an.this, 0L);
        }
        an.e(an.this, l2);
        y.i("MicroMsg.MD", "memory:%s cost:%sms", new Object[] { locale.toString(), Long.valueOf(System.currentTimeMillis() - l3) });
        i = locale.ugj.mDK;
        l2 = an.g(an.this);
      } while (an.cro() == null);
      if ((an.h(an.this)[5] == 0) && (i > 200)) {
        an.h(an.this)[5] = an.cro().pB(6);
      }
      if ((an.h(an.this)[4] == 0) && (l2 > 300000L)) {
        an.h(an.this)[4] = an.cro().pB(5);
      }
      for (;;)
      {
        y.i("MicroMsg.MD", "report memInfo %s(B) > %s(B) continueTime %sms", new Object[] { Long.valueOf(l1), Long.valueOf(an.i(an.this)), Long.valueOf(l2) });
        return;
        if (l4 < an.i(an.this))
        {
          an.c(an.this, 0L);
          an.d(an.this, 0L);
          an.j(an.this);
          i = 0;
          break label157;
        }
        if ((an.f(an.this) > 0L) && (l4 < an.f(an.this)) && ((an.f(an.this) - l4) * 1.0D / an.f(an.this) > 0.1D))
        {
          i = 0;
          break label157;
        }
        i = 1;
        break label157;
        label493:
        an.d(an.this, an.g(an.this) + (l2 - an.e(an.this)));
        break label203;
        if ((an.h(an.this)[3] == 0) && (l2 > 240000L))
        {
          an.h(an.this)[3] = an.cro().pB(4);
        }
        else if ((an.h(an.this)[2] == 0) && (l2 > 180000L))
        {
          an.h(an.this)[2] = an.cro().pB(3);
        }
        else if ((an.h(an.this)[1] == 0) && (l2 > 120000L))
        {
          an.h(an.this)[1] = an.cro().pB(2);
        }
        else
        {
          if ((an.h(an.this)[0] != 0) || (l2 <= 60000L)) {
            break;
          }
          an.h(an.this)[0] = an.cro().pB(1);
        }
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean pB(int paramInt);
  }
  
  private final class e
  {
    String tag;
    long ugb;
    long ugc;
    long ugd;
    long uge;
    long ugf;
    long ugg;
    final long ugh = an.k(an.this);
    final long ugi = an.l(an.this);
    an.f ugj;
    
    private e() {}
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MemoryInfo:").append(this.tag).append("[").append(this.ugh).append("(M):").append(this.ugi).append("(M)]{RUNTIME:").append(this.uge).append(",").append(this.ugf).append(",").append(this.ugg).append("}{NATIVE:").append(this.ugb).append(",").append(this.ugc).append(",").append(this.ugd).append("}{THREAD_INFO:").append(this.ugj.toString()).append("}");
      return localStringBuilder.toString();
    }
  }
  
  public final class f
  {
    boolean bZM;
    List<String> list;
    int mDK;
    int ugk;
    int ugl;
    
    public f() {}
    
    public final String toString()
    {
      String str2 = "activeCount=" + this.ugk + ", waitCount=" + this.ugl + ", allCount=" + this.mDK;
      String str1 = str2;
      if (this.list != null) {
        if (!this.bZM)
        {
          str1 = str2;
          if (this.list.size() <= 200) {}
        }
        else
        {
          str1 = str2 + " " + this.list.toString();
        }
      }
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.an
 * JD-Core Version:    0.7.0.1
 */