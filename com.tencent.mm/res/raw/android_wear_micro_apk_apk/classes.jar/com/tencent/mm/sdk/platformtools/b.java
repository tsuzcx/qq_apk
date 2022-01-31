package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.os.Debug;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class b
{
  private static final Map<Object, Set<c>> WU = new WeakHashMap();
  private static final byte[] WV = new byte[0];
  private static Field WW = null;
  private static HandlerThread WX = null;
  private static j WY = null;
  private static volatile boolean WZ = false;
  private static final String Xa = Activity.class.getName();
  private static final Runnable Xb = new Runnable()
  {
    public final void run()
    {
      synchronized ()
      {
        if (!b.lf()) {
          return;
        }
      }
      for (;;)
      {
        synchronized (b.lh())
        {
          if (b.li().isEmpty())
          {
            f.f("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: no listener or cb was added, skip rest logic.");
            synchronized (b.le())
            {
              if (b.lf()) {
                b.lg().c(this);
              }
              return;
            }
            localObject3 = finally;
            throw localObject3;
          }
          if (Debug.isDebuggerConnected()) {
            f.d("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: found debugger connected, disable monitor works in case of misreport.");
          }
        }
        f.f("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: triggering gc...");
        try
        {
          Runtime.getRuntime().gc();
          Thread.sleep(100L);
          Runtime.getRuntime().runFinalization();
          for (;;)
          {
            Iterator localIterator2;
            Object localObject6;
            Object localObject7;
            Object localObject8;
            synchronized (b.lh())
            {
              Iterator localIterator1 = b.li().entrySet().iterator();
              if (!localIterator1.hasNext()) {
                break;
              }
              localIterator2 = ((Set)((Map.Entry)localIterator1.next()).getValue()).iterator();
              if (!localIterator2.hasNext()) {
                continue;
              }
              localObject6 = (c)localIterator2.next();
              localObject7 = ((c)localObject6).Xc.get();
              localObject8 = (Activity)((c)localObject6).Xd.get();
              if (localObject8 == null)
              {
                f.c("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: Ok, ui [%s] was recycled.", new Object[] { ((c)localObject6).Xe.getName() });
                localIterator2.remove();
              }
            }
            boolean bool = ((Activity)localObject8).isDestroyed();
            int k;
            if (!bool) {
              k = 0;
            }
            while ((k != 0) && (localObject7 == null))
            {
              if (((c)localObject6).Xh <= 3) {
                break label451;
              }
              localIterator2.remove();
              if (r.ls()) {
                break label510;
              }
              if (!r.lr()) {
                break label522;
              }
              break label510;
              localObject6 = new d(((c)localObject6).lk(), ((c)localObject6).Xg);
              if (i == 0) {
                break label435;
              }
              throw ((Throwable)localObject6);
              localObject8 = Looper.getMainLooper().getThread().getStackTrace();
              int j = localObject8.length;
              i = 0;
              k = bool;
              if (i < j)
              {
                Object localObject9 = localObject8[i];
                if ((!b.lj().equals(localObject9.getClassName())) || (!"performDestroy".equals(localObject9.getMethodName()))) {
                  break label515;
                }
                k = 0;
              }
            }
            continue;
            label435:
            f.a("MicroMsg.ListenerInstanceMonitor", (Throwable)localObject6, "", new Object[0]);
            continue;
            label451:
            ((c)localObject6).Xh += 1;
            f.b("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: ui [%s] was recycled, but its instance is still exists in %s time(s) check.", new Object[] { ((c)localObject6).Xe.getName(), Integer.valueOf(((c)localObject6).Xh) });
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            continue;
            label510:
            int i = 1;
            continue;
            label515:
            i += 1;
            continue;
            label522:
            i = 0;
          }
        }
      }
    }
  };
  
  static
  {
    if ((r.ls()) || (r.lr()))
    {
      if (i.lp()) {
        try
        {
          ??? = View.class.getDeclaredField("mContext");
          WW = (Field)???;
          ((Field)???).setAccessible(true);
          synchronized (Xb)
          {
            if (!WZ)
            {
              Object localObject2 = com.tencent.mm.sdk.b.c.E("ListenerInstanceMonitor");
              WX = (HandlerThread)localObject2;
              ((HandlerThread)localObject2).start();
              localObject2 = new j(WX.getLooper());
              WY = (j)localObject2;
              ((j)localObject2).c(Xb);
              WZ = true;
            }
            return;
          }
          f.d("MicroMsg.ListenerInstanceMonitor", "Not mm process, keep disabled.");
        }
        catch (Throwable localThrowable)
        {
          f.a("MicroMsg.ListenerInstanceMonitor", localThrowable, "init failed, keep disabled.", new Object[0]);
          return;
        }
      }
      return;
    }
    f.d("MicroMsg.ListenerInstanceMonitor", "Not debug, assist or monkey env, keep disabled.");
  }
  
  public static void D(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    Throwable localThrowable = new Throwable();
    Class localClass1 = paramObject.getClass();
    label19:
    if (!Object.class.equals(localClass1))
    {
      if (!Activity.class.isAssignableFrom(localClass1)) {
        break label52;
      }
      a(paramObject, null, localThrowable);
    }
    for (;;)
    {
      localClass1 = localClass1.getSuperclass();
      break label19;
      break;
      label52:
      if (!View.class.isAssignableFrom(localClass1)) {
        break label71;
      }
      b(paramObject, null, localThrowable);
    }
    label71:
    Field[] arrayOfField = localClass1.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    label83:
    Field localField;
    Class localClass2;
    if (i < j)
    {
      localField = arrayOfField[i];
      localClass2 = localField.getType();
      if (!Activity.class.isAssignableFrom(localClass2)) {
        break label126;
      }
      a(paramObject, localField, localThrowable);
    }
    for (;;)
    {
      i += 1;
      break label83;
      break;
      label126:
      if (View.class.isAssignableFrom(localClass2)) {
        b(paramObject, localField, localThrowable);
      }
    }
  }
  
  public static void E(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    synchronized (WV)
    {
      WU.remove(paramObject);
      return;
    }
  }
  
  private static void a(Object paramObject, Activity paramActivity, Field paramField, Throwable paramThrowable)
  {
    Object localObject2 = null;
    Object localObject1;
    int j;
    if (paramObject.getClass().isAnnotationPresent(a.class))
    {
      localObject1 = (a)paramObject.getClass().getAnnotation(a.class);
      if (localObject1 == null) {
        break label200;
      }
      localObject2 = paramActivity.getClass();
      localObject1 = ((a)localObject1).ld();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          if (localObject2.equals(localObject1[i])) {
            break label194;
          }
          i += 1;
        }
      }
    }
    else
    {
      ??? = paramObject.getClass().getDeclaredMethods();
      j = ???.length;
      i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= j) {
          break;
        }
        localObject1 = ???[i];
        if (((Method)localObject1).isAnnotationPresent(a.class))
        {
          localObject1 = (a)((Method)localObject1).getAnnotation(a.class);
          break;
        }
        i += 1;
      }
    }
    label194:
    for (int i = 0; i != 0; i = 1)
    {
      f.b("MicroMsg.ListenerInstanceMonitor", "Activity %s held by %s is ignored !!", new Object[] { paramActivity, paramObject });
      return;
    }
    synchronized (WV)
    {
      label200:
      localObject2 = (Set)WU.get(paramObject);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        WU.put(paramObject, localObject1);
      }
      ((Set)localObject1).add(new c(paramActivity, paramField, paramThrowable));
      return;
    }
  }
  
  private static void a(Object paramObject, Field paramField, Throwable paramThrowable)
  {
    Object localObject;
    if (paramField == null) {
      if ((paramObject instanceof Activity)) {
        localObject = (Activity)paramObject;
      }
    }
    for (;;)
    {
      a(paramObject, (Activity)localObject, paramField, paramThrowable);
      return;
      if (!paramField.isAccessible()) {
        paramField.setAccessible(true);
      }
      try
      {
        Activity localActivity = (Activity)paramField.get(paramObject);
        localObject = localActivity;
        if (localActivity == null) {}
      }
      catch (Throwable paramObject) {}
    }
  }
  
  /* Error */
  private static void b(Object paramObject, Field paramField, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +41 -> 42
    //   4: aload_0
    //   5: instanceof 73
    //   8: ifeq +33 -> 41
    //   11: aload_0
    //   12: checkcast 73	android/view/View
    //   15: astore_3
    //   16: getstatic 38	com/tencent/mm/sdk/platformtools/b:WW	Ljava/lang/reflect/Field;
    //   19: aload_3
    //   20: invokevirtual 220	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: astore_3
    //   24: aload_3
    //   25: instanceof 46
    //   28: ifeq +13 -> 41
    //   31: aload_0
    //   32: aload_3
    //   33: checkcast 46	android/app/Activity
    //   36: aload_1
    //   37: aload_2
    //   38: invokestatic 216	com/tencent/mm/sdk/platformtools/b:a	(Ljava/lang/Object;Landroid/app/Activity;Ljava/lang/reflect/Field;Ljava/lang/Throwable;)V
    //   41: return
    //   42: getstatic 38	com/tencent/mm/sdk/platformtools/b:WW	Ljava/lang/reflect/Field;
    //   45: ifnull -4 -> 41
    //   48: aload_1
    //   49: invokevirtual 219	java/lang/reflect/Field:isAccessible	()Z
    //   52: ifne +8 -> 60
    //   55: aload_1
    //   56: iconst_1
    //   57: invokevirtual 85	java/lang/reflect/Field:setAccessible	(Z)V
    //   60: aload_1
    //   61: aload_0
    //   62: invokevirtual 220	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 73	android/view/View
    //   68: astore 4
    //   70: aload 4
    //   72: astore_3
    //   73: aload 4
    //   75: ifnonnull -59 -> 16
    //   78: return
    //   79: astore_0
    //   80: return
    //   81: astore_0
    //   82: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramObject	Object
    //   0	83	1	paramField	Field
    //   0	83	2	paramThrowable	Throwable
    //   15	58	3	localObject	Object
    //   68	6	4	localView	View
    // Exception table:
    //   from	to	target	type
    //   16	41	79	java/lang/Throwable
    //   60	70	81	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.b
 * JD-Core Version:    0.7.0.1
 */