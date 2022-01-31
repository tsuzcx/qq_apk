package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.os.Debug;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.sdk.f.e;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class ListenerInstanceMonitor
{
  private static final Map<Object, Set<a>> ueG = new WeakHashMap();
  private static final byte[] ueH = new byte[0];
  private static Field ueI = null;
  private static HandlerThread ueJ = null;
  private static ah ueK = null;
  private static volatile boolean ueL = false;
  private static final String ueM = Activity.class.getName();
  private static final Runnable ueN = new Runnable()
  {
    public final void run()
    {
      synchronized ()
      {
        if (!ListenerInstanceMonitor.ueL) {
          return;
        }
      }
      for (;;)
      {
        synchronized (ListenerInstanceMonitor.cqC())
        {
          if (ListenerInstanceMonitor.aQV().isEmpty())
          {
            y.d("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: no listener or cb was added, skip rest logic.");
            synchronized (ListenerInstanceMonitor.cqA())
            {
              if (ListenerInstanceMonitor.ueL) {
                ListenerInstanceMonitor.cqB().postDelayed(this, 10000L);
              }
              return;
            }
            localObject5 = finally;
            throw localObject5;
          }
          if (Debug.isDebuggerConnected()) {
            y.w("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: found debugger connected, disable monitor works in case of misreport.");
          }
        }
        y.d("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: triggering gc...");
        try
        {
          Runtime.getRuntime().gc();
          Thread.sleep(100L);
          Runtime.getRuntime().runFinalization();
          for (;;)
          {
            Iterator localIterator2;
            ListenerInstanceMonitor.a locala;
            Object localObject7;
            synchronized (ListenerInstanceMonitor.cqC())
            {
              Iterator localIterator1 = ListenerInstanceMonitor.aQV().entrySet().iterator();
              if (!localIterator1.hasNext()) {
                break;
              }
              localIterator2 = ((Set)((Map.Entry)localIterator1.next()).getValue()).iterator();
              if (!localIterator2.hasNext()) {
                continue;
              }
              locala = (ListenerInstanceMonitor.a)localIterator2.next();
              ??? = locala.ueO.get();
              localObject7 = (Activity)locala.ueP.get();
              if (localObject7 == null)
              {
                y.i("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: Ok, ui [%s] was recycled.", new Object[] { locala.ueQ.getName() });
                localIterator2.remove();
              }
            }
            boolean bool = ((Activity)localObject7).isDestroyed();
            int k;
            label309:
            Object localObject3;
            if (!bool)
            {
              k = 0;
              if ((k == 0) || (localObject2 != null)) {
                break label495;
              }
              if (locala.ueT <= 3) {
                break label633;
              }
              localIterator2.remove();
              if (bl.csf()) {
                break label692;
              }
              if (!bl.cqi()) {
                break label704;
              }
              break label692;
              if (locala.ueP.get() != null) {
                break label530;
              }
              if (locala.ueR == null) {
                break label497;
              }
              localObject3 = "ui of class [" + locala.ueQ.getName() + "] held by\n [" + locala.cqE() + "] is recycled";
            }
            for (;;)
            {
              localObject3 = new ListenerInstanceMonitor.ListenerLeakedException((String)localObject3, locala.ueS);
              if (i == 0) {
                break label617;
              }
              throw ((Throwable)localObject3);
              localObject7 = Looper.getMainLooper().getThread().getStackTrace();
              int j = localObject7.length;
              i = 0;
              k = bool;
              if (i >= j) {
                break label309;
              }
              Object localObject8 = localObject7[i];
              if ((!ListenerInstanceMonitor.ahk().equals(localObject8.getClassName())) || (!"performDestroy".equals(localObject8.getMethodName()))) {
                break label697;
              }
              k = 0;
              break label309;
              label495:
              break;
              label497:
              localObject3 = "ui of class [" + locala.ueQ.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is recycled";
              continue;
              label530:
              if (locala.ueR != null) {
                localObject3 = "ui of class [" + locala.ueQ.getName() + "] held by\n [" + locala.cqE() + "] is leaked.\n Perhaps you should remove the holder from any 'Manager' class when the leaked ui was destroyed.";
              } else {
                localObject3 = "ui of class [" + locala.ueQ.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is leaked.\n Perhaps you should remove any instance of this class from any 'Manager'";
              }
            }
            label617:
            y.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", (Throwable)localObject3, "", new Object[0]);
            continue;
            label633:
            locala.ueT += 1;
            y.w("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: ui [%s] was recycled, but its instance is still exists in %s time(s) check.", new Object[] { locala.ueQ.getName(), Integer.valueOf(locala.ueT) });
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            continue;
            label692:
            int i = 1;
            continue;
            label697:
            i += 1;
            continue;
            label704:
            i = 0;
          }
        }
      }
    }
  };
  
  static
  {
    if ((bl.csf()) || (bl.cqi()))
    {
      if (ae.cqV()) {
        try
        {
          ??? = View.class.getDeclaredField("mContext");
          ueI = (Field)???;
          ((Field)???).setAccessible(true);
          synchronized (ueN)
          {
            if (!ueL)
            {
              Object localObject2 = e.aap("ListenerInstanceMonitor");
              ueJ = (HandlerThread)localObject2;
              ((HandlerThread)localObject2).start();
              localObject2 = new ah(ueJ.getLooper());
              ueK = (ah)localObject2;
              ((ah)localObject2).postDelayed(ueN, 10000L);
              ueL = true;
            }
            return;
          }
          y.w("MicroMsg.ListenerInstanceMonitor", "Not mm process, keep disabled.");
        }
        catch (Throwable localThrowable)
        {
          y.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", localThrowable, "init failed, keep disabled.", new Object[0]);
          return;
        }
      }
      return;
    }
    y.w("MicroMsg.ListenerInstanceMonitor", "Not debug, assist or monkey env, keep disabled.");
  }
  
  private static void a(Object paramObject, Activity paramActivity, Field paramField, Throwable paramThrowable)
  {
    Object localObject2 = null;
    Object localObject1;
    int j;
    if (paramObject.getClass().isAnnotationPresent(f.class))
    {
      localObject1 = (f)paramObject.getClass().getAnnotation(f.class);
      if (localObject1 == null) {
        break label200;
      }
      localObject2 = paramActivity.getClass();
      localObject1 = ((f)localObject1).cqs();
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
        if (((Method)localObject1).isAnnotationPresent(f.class))
        {
          localObject1 = (f)((Method)localObject1).getAnnotation(f.class);
          break;
        }
        i += 1;
      }
    }
    label194:
    for (int i = 0; i != 0; i = 1)
    {
      y.w("MicroMsg.ListenerInstanceMonitor", "Activity %s held by %s is ignored !!", new Object[] { paramActivity, paramObject });
      return;
    }
    synchronized (ueH)
    {
      label200:
      localObject2 = (Set)ueG.get(paramObject);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        ueG.put(paramObject, localObject1);
      }
      ((Set)localObject1).add(new a(paramActivity, paramField, paramThrowable));
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
    //   5: instanceof 79
    //   8: ifeq +33 -> 41
    //   11: aload_0
    //   12: checkcast 79	android/view/View
    //   15: astore_3
    //   16: getstatic 44	com/tencent/mm/sdk/platformtools/ListenerInstanceMonitor:ueI	Ljava/lang/reflect/Field;
    //   19: aload_3
    //   20: invokevirtual 202	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: astore_3
    //   24: aload_3
    //   25: instanceof 52
    //   28: ifeq +13 -> 41
    //   31: aload_0
    //   32: aload_3
    //   33: checkcast 52	android/app/Activity
    //   36: aload_1
    //   37: aload_2
    //   38: invokestatic 198	com/tencent/mm/sdk/platformtools/ListenerInstanceMonitor:a	(Ljava/lang/Object;Landroid/app/Activity;Ljava/lang/reflect/Field;Ljava/lang/Throwable;)V
    //   41: return
    //   42: getstatic 44	com/tencent/mm/sdk/platformtools/ListenerInstanceMonitor:ueI	Ljava/lang/reflect/Field;
    //   45: ifnull -4 -> 41
    //   48: aload_1
    //   49: invokevirtual 201	java/lang/reflect/Field:isAccessible	()Z
    //   52: ifne +8 -> 60
    //   55: aload_1
    //   56: iconst_1
    //   57: invokevirtual 91	java/lang/reflect/Field:setAccessible	(Z)V
    //   60: aload_1
    //   61: aload_0
    //   62: invokevirtual 202	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 79	android/view/View
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
  
  public static void bP(Object paramObject)
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
  
  public static void bQ(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    synchronized (ueH)
    {
      ueG.remove(paramObject);
      return;
    }
  }
  
  private static final class ListenerLeakedException
    extends RuntimeException
  {
    ListenerLeakedException(String paramString, Throwable paramThrowable)
    {
      super();
      setStackTrace(paramThrowable.getStackTrace());
    }
    
    public final Throwable fillInStackTrace()
    {
      return this;
    }
  }
  
  private static final class a
  {
    final WeakReference<Object> ueO = new WeakReference(new Object());
    WeakReference<Activity> ueP;
    Class<?> ueQ;
    Field ueR;
    Throwable ueS;
    int ueT;
    
    a(Activity paramActivity, Field paramField, Throwable paramThrowable)
    {
      this.ueP = new WeakReference(paramActivity);
      this.ueQ = paramActivity.getClass();
      this.ueR = paramField;
      this.ueS = paramThrowable;
      this.ueT = 0;
    }
    
    private String cqD()
    {
      StringWriter localStringWriter = new StringWriter();
      try
      {
        PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
        bk.b(localPrintWriter);
      }
      finally
      {
        try
        {
          this.ueS.printStackTrace(localPrintWriter);
          bk.b(localPrintWriter);
          return localStringWriter.toString();
        }
        finally {}
        localObject1 = finally;
        localPrintWriter = null;
      }
      throw localObject1;
    }
    
    final String cqE()
    {
      if (this.ueR == null) {
        return "#null#";
      }
      Object localObject = this.ueR.getDeclaringClass();
      if (!((Class)localObject).isAnonymousClass()) {
        return "field " + this.ueR.getName() + " defined in " + ((Class)localObject).getName();
      }
      Type localType = ((Class)localObject).getGenericSuperclass();
      if (Object.class.equals(localType)) {
        localObject = localObject.getGenericInterfaces()[0];
      }
      for (;;)
      {
        return "field " + this.ueR.getName() + " define in anonymous class of " + localObject.toString().replace('<', '#').replace('>', '#');
        if (localType != null) {
          localObject = localType;
        }
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = true;
      if ((paramObject == null) || (!(paramObject instanceof a))) {
        return false;
      }
      paramObject = (a)paramObject;
      Object localObject1 = this.ueP.get();
      Object localObject2 = paramObject.ueP.get();
      boolean bool1;
      if ((localObject1 == null) && (localObject2 == null))
      {
        bool1 = true;
        label50:
        if (!bool1) {
          break label130;
        }
        localObject1 = this.ueR;
        localObject2 = paramObject.ueR;
        if ((localObject1 != null) || (localObject2 != null)) {
          break label132;
        }
        bool1 = true;
        label78:
        if (!bool1) {
          break label156;
        }
        localObject1 = this.ueS;
        paramObject = paramObject.ueS;
        if ((localObject1 != null) || (paramObject != null)) {
          break label158;
        }
        bool1 = bool2;
      }
      for (;;)
      {
        return bool1;
        if ((localObject1 != null) && (localObject2 != null))
        {
          bool1 = localObject1.equals(localObject2);
          break label50;
        }
        bool1 = false;
        break label50;
        label130:
        break;
        label132:
        if ((localObject1 != null) && (localObject2 != null))
        {
          bool1 = ((Field)localObject1).equals(localObject2);
          break label78;
        }
        bool1 = false;
        break label78;
        label156:
        break;
        label158:
        if ((localObject1 != null) && (paramObject != null)) {
          bool1 = localObject1.equals(paramObject);
        } else {
          bool1 = false;
        }
      }
    }
    
    public final int hashCode()
    {
      int k = 0;
      Object localObject = this.ueP.get();
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        if (this.ueR == null) {
          break label63;
        }
      }
      label63:
      for (int j = this.ueR.hashCode();; j = 0)
      {
        if (this.ueS != null) {
          k = this.ueS.hashCode();
        }
        return i + j + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      return cqE() + "@" + cqD().replace('\n', '|');
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor
 * JD-Core Version:    0.7.0.1
 */